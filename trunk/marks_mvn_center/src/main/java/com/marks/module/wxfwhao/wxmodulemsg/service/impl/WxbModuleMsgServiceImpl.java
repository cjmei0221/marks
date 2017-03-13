package com.marks.module.wxfwhao.wxmodulemsg.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.system.core.data.WeChatAccountHelper;
import com.marks.module.wxfwhao.common.wxservice.SendMsgUtils;
import com.marks.module.wxfwhao.wxmodulemsg.dao.WxbModuleMsgDao;
import com.marks.module.wxfwhao.wxmodulemsg.entity.WxbModuleMsg;
import com.marks.module.wxfwhao.wxmodulemsg.service.WxbModuleMsgService;
import com.marks.module.wxfwhao.wxmodulemsg.thread.pool.WxModuleMsgThreadPool;

public class WxbModuleMsgServiceImpl implements WxbModuleMsgService{
   
	private static final Logger logger = Logger.getLogger(WxbModuleMsgServiceImpl.class);
    private WxbModuleMsgDao wxbModuleMsgDao;

    public WxbModuleMsgDao getWxbModuleMsgDao(){
        return wxbModuleMsgDao;
    }
    public void setWxbModuleMsgDao(WxbModuleMsgDao wxbModuleMsgDao){
        this.wxbModuleMsgDao =wxbModuleMsgDao;
    }

    
    /**
    *根据ID查找模板消息推送管理
    */
    @Override
    public WxbModuleMsg findById(String id){
        return wxbModuleMsgDao.findById(id);
    }
    
    /**
    *保存模板消息推送管理
    */
    @Override
    public void save(WxbModuleMsg wxbModuleMsg){
        wxbModuleMsgDao.save(wxbModuleMsg);
    }
    
    /**
    *更新模板消息推送管理
    */
    @Override
    public void update(WxbModuleMsg wxbModuleMsg){
        wxbModuleMsgDao.update(wxbModuleMsg);
    }
    
    /**
    *删除模板消息推送管理
    */
    @Override
    public void delete(String id){
        wxbModuleMsgDao.delete(id);       
    }
    
    /**
    *查找所有模板消息推送管理
    */
    @Override
    public List<WxbModuleMsg> findAll(){
        return wxbModuleMsgDao.findAll();   
    }
    
    /**
    *删除多个模板消息推送管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxbModuleMsgDao.deleteBatch(ids);
	}
	@Override
	public JsonResult sendTemplateMsg(String accountid, String toUser, String templateCode, String url, String data,String note) {
		JsonResult result=SendMsgUtils.getInstance().sendTemplateMsg(accountid, toUser, templateCode, url, data);
		WxbModuleMsg msg=new WxbModuleMsg();
		int isSend = 0;//未发送
        String msgid="";
         if(SysCode.SUCCESS.equals(result.getErrorCode())){
         	msgid=String.valueOf(result.getResult());
         	isSend=1;//发送成功
         }else{
        	isSend=2;//发送失败 
         }
         msg.setSendflag(isSend);
         msg.setMsgid(msgid);
         msg.setPush_code(result.getErrorCode());
         msg.setPush_msg(result.getErrorMsg());
         msg.setSendtimes(1);
         
         msg.setAccountid(accountid);
         msg.setData(data);
         msg.setNeedflag(1);
         msg.setTemplate_id(templateCode);
         msg.setTouser(toUser);
         msg.setUrl(url);
         msg.setNote(note);
         msg.setCreate_stamp(System.currentTimeMillis()/1000);
         wxbModuleMsgDao.save(msg);
         result.setErrorCode(SysCode.SUCCESS);
         result.setErrorMsg("已推送，若未推送成功，将启动定时器，进行推送，共推送3次");
		return result;
	}
	@Override
	public void pustWxbModuleMsg() {
		int limitnum=1000;//一次扫描的记录条数
		String limitStr=WeChatAccountHelper.getWxConf("wx_modulemsg_scan_limitnum");
		if(null !=limitStr && !"".equals(limitStr)){
			limitnum=Integer.parseInt(limitStr);
		}
		int pushlimitnum=3;//一条记录推送次数
		String pushlimitnumStr=WeChatAccountHelper.getWxConf("wx_modulemsg_push_limitnum");
		if(null !=pushlimitnumStr && !"".equals(pushlimitnumStr)){
			pushlimitnum=Integer.parseInt(pushlimitnumStr);
		}
		int timelimit=60;//时间限制 默认60分钟
		String timelimitStr=WeChatAccountHelper.getWxConf("wx_modulemsg_time_limit");
		if(null !=timelimitStr && !"".equals(timelimitStr)){
			timelimit=Integer.parseInt(timelimitStr);
		}
		long nowtime=System.currentTimeMillis()/1000;
//		logger.info("pustWxbModuleMsg params> limitnum:"+limitnum +" - pushlimitnum:"+pushlimitnum+" - timelimit:"+timelimit+"- nowtime:"+nowtime);
		List<WxbModuleMsg> list=wxbModuleMsgDao.getNeedPustMsg(limitnum,pushlimitnum,timelimit*60,nowtime);
		if(null !=list && list.size()>0){
			for(WxbModuleMsg msg:list){
				WxModuleMsgThreadPool.pushModuleMsg(msg);
			}
		}
	}
}