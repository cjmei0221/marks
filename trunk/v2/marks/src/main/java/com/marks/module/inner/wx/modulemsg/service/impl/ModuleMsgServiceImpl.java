package com.marks.module.inner.wx.modulemsg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.JsonResult;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxfwhao.common.wxservice.SendMsgUtils;
import com.marks.module.inner.wx.modulemsg.dao.ModuleMsgDao;
import com.marks.module.inner.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.inner.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.inner.wx.modulemsg.thread.pool.WxModuleMsgThreadPool;
import com.marks.module.inner.wx.wxutil.WxFwUtil;
import com.marks.module.sys.system.core.data.StaticData;

public class ModuleMsgServiceImpl implements ModuleMsgService {

	private ModuleMsgDao moduleMsgDao;

	public ModuleMsgDao getModuleMsgDao() {
		return moduleMsgDao;
	}

	public void setModuleMsgDao(ModuleMsgDao moduleMsgDao) {
		this.moduleMsgDao = moduleMsgDao;
	}

	public void pustModuleMsg(ModuleMsg mmsg, boolean b) {
		mmsg.setNeedFlag(1);
		mmsg.setSendFlag(0);
		mmsg.setSendTimes(0);
		mmsg.setCreate_stamp(System.currentTimeMillis()/1000);
		if (b) {
			this.sendTemplateMsg(mmsg.getAccountid(), mmsg.getTouser(), mmsg.getTemplate_id(), mmsg.getUrl(), mmsg.getData(), mmsg.getNote());
		} else {
			this.moduleMsgDao.save(mmsg);
		}
	}

	/**
	 * 根据ID查找模板消息
	 */
	@Override
	public ModuleMsg findById(String id) {
		return moduleMsgDao.findById(id);
	}

	/**
	 * 保存模板消息
	 */
	@Override
	public void save(ModuleMsg moduleMsg) {
		moduleMsgDao.save(moduleMsg);
	}

	/**
	 * 更新模板消息
	 */
	@Override
	public void update(ModuleMsg moduleMsg) {
		moduleMsgDao.update(moduleMsg);
	}

	/**
	 * 删除模板消息
	 */
	@Override
	public void delete(String id) {
		moduleMsgDao.delete(id);
	}

	/**
	 * 查找所有模板消息
	 */
	@Override
	public List<ModuleMsg> findAll() {
		return moduleMsgDao.findAll();
	}

	/**
	 * 删除多个模板消息
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		moduleMsgDao.deleteBatch(ids);
	}

	public PojoDomain<ModuleMsg> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<ModuleMsg> pojoDomain = new PojoDomain<ModuleMsg>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<ModuleMsg> list = moduleMsgDao.list(pageBounds, param);
		PageList<ModuleMsg> pageList = (PageList<ModuleMsg>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void clearData() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String clear_modulemsg_data_str=StaticData.getSysConf("clear_modulemsg_data");
		int clearNum=30;
		if(null !=clear_modulemsg_data_str && !"".equals(clear_modulemsg_data_str)){
			clearNum=Integer.parseInt(clear_modulemsg_data_str);
		}
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_MONTH, -clearNum);
		moduleMsgDao.deleteData(sdf.format(today.getTime()));
	}

	@Override
	public void pustWxbModuleMsg() {
		int limitnum=1000;//一次扫描的记录条数
		String limitStr=StaticData.getSysConf("wx_modulemsg_scan_limitnum");
		if(null !=limitStr && !"".equals(limitStr)){
			limitnum=Integer.parseInt(limitStr);
		}
		int pushlimitnum=3;//一条记录推送次数
		String pushlimitnumStr=StaticData.getSysConf("wx_modulemsg_push_limitnum");
		if(null !=pushlimitnumStr && !"".equals(pushlimitnumStr)){
			pushlimitnum=Integer.parseInt(pushlimitnumStr);
		}
		int timelimit=60;//时间限制 默认60分钟
		String timelimitStr=StaticData.getSysConf("wx_modulemsg_time_limit");
		if(null !=timelimitStr && !"".equals(timelimitStr)){
			timelimit=Integer.parseInt(timelimitStr);
		}
		long nowtime=System.currentTimeMillis()/1000;
//		logger.info("pustWxbModuleMsg params> limitnum:"+limitnum +" - pushlimitnum:"+pushlimitnum+" - timelimit:"+timelimit+"- nowtime:"+nowtime);
		List<ModuleMsg> list=moduleMsgDao.getNeedPustMsg(limitnum,pushlimitnum,timelimit*60,nowtime);
		if(null !=list && list.size()>0){
			for(ModuleMsg msg:list){
				WxModuleMsgThreadPool.pushModuleMsg(msg);
			}
		}
	}

	@Override
	public JsonResult sendTemplateMsg(String accountid, String toUser, String templateCode, String url, String data,
			String note) {
		JsonResult result=SendMsgUtils.getInstance().sendTemplateMsg(accountid, toUser, templateCode, url, data);
		ModuleMsg msg=new ModuleMsg();
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
         msg.setPush_code(result.getErrorCode());
         msg.setPush_msg(result.getErrorMsg());
         msg.setSendTimes(1);
         
         msg.setAccountid(accountid);
         msg.setData(data);
         msg.setNeedFlag(1);
         msg.setTemplate_id(templateCode);
         msg.setTouser(toUser);
         msg.setUrl(url);
         msg.setNote(note);
         msg.setCreate_stamp(System.currentTimeMillis()/1000);
         moduleMsgDao.save(msg);
         result.setErrorCode(SysCode.SUCCESS);
         result.setErrorMsg("已推送，若未推送成功，将启动定时器，进行推送，共推送3次");
		return result;
	}
	
	
}