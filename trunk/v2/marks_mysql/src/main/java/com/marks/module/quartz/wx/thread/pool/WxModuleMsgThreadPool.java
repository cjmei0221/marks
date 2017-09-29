package com.marks.module.quartz.wx.thread.pool;

import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.wx.api.mp.msg.wxservice.SendMsgUtils;
import com.marks.module.wx.manage.template.pojo.ModuleMsg;
import com.marks.module.wx.manage.template.service.ModuleMsgService;

/**
 * 消息推送线程池类
 * 
 * @author cjmei
 * @createTime 2015-01-28
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WxModuleMsgThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(200);// 开10个线程
	}

	public static void destroy() {
		pool.shutdown();
	}

	/**
	 * 推送模板信息
	 * 
	 * @param accountid
	 * @param tousers
	 * @param content
	 */
	public static void pushModuleMsg(ModuleMsg msg) {
		pool.execute(new PushModuleMsgThread(msg));
	}

	public static void scanModuleMsgThread() {
		pool.execute(new ScanModuleMsgThread());
	}

}

class ScanModuleMsgThread implements Runnable {

	private Logger logger = Logger.getLogger(ScanModuleMsgThread.class);

	private ModuleMsgService moduleMsgService = null;

	public ScanModuleMsgThread() {
	}

	@Override
	public void run() {
		try {

			if (moduleMsgService == null) {
				moduleMsgService = (ModuleMsgService) SpringContextHolder
						.getBean(ModuleMsgService.class);
			}
			moduleMsgService.pustWxbModuleMsg();

		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}
}

/**
 * 模板信息推送线程
 * 
 * @author cjmei
 * @createTime 2014-11-28
 * @history 1.修改时间,修改;修改内容：
 * 
 */
class PushModuleMsgThread implements Runnable {

	private Logger logger = Logger.getLogger(PushModuleMsgThread.class);

	private ModuleMsg msg;
	private ModuleMsgService moduleMsgService = null;
	public PushModuleMsgThread(ModuleMsg msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			if(null != msg){
				 if (moduleMsgService == null) {
					 moduleMsgService = (ModuleMsgService) SpringContextHolder.getBean(ModuleMsgService.class);
				 }
				logger.info("开始推送消息  id"+msg.getId());
				JsonResult result=SendMsgUtils.getInstance().sendTemplateMsg(msg.getAccountid(),msg.getTouser(), msg.getTemplate_id(), msg.getUrl(), msg.getData());
				 logger.info("推送结果>>"+msg.getId()+"-"+result.getErrorCode()+"-"+result.getErrorMsg());
			        int isSend = 0;//未发送
			        String msgid="";
		             if(SysCode.SUCCESS.equals(result.getErrorCode())){
		             	msgid=String.valueOf(result.getResult());
		             	isSend=1;//发送成功
		             }else{
		            	isSend=2;//发送失败 
		             }
		             msg.setSendFlag(isSend);
		             msg.setMsgId(msgid);
		             msg.setSendtime(new Timestamp(System.currentTimeMillis()));
		             msg.setPush_code(result.getErrorCode());
		             msg.setPush_msg(result.getErrorMsg());
		             msg.setSendTimes((msg.getSendTimes()+1));
		             moduleMsgService.update(msg);
				
				logger.info("结束推送消息  id"+msg.getId());
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}
}
