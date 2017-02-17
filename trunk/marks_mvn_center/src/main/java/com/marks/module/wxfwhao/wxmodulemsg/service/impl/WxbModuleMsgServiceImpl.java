package com.marks.module.wxfwhao.wxmodulemsg.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.wxfwhao.common.utils.WxfwUtil;
import com.marks.module.wxfwhao.common.wxservice.SendMsgUtils;
import com.marks.module.wxfwhao.wxmodulemsg.dao.WxbModuleMsgDao;
import com.marks.module.wxfwhao.wxmodulemsg.entity.WxbModuleMsg;
import com.marks.module.wxfwhao.wxmodulemsg.service.WxbModuleMsgService;
import com.marks.module.wxfwhao.wxmodulemsg.thread.pool.WxModuleMsgThreadPool;

public class WxbModuleMsgServiceImpl implements WxbModuleMsgService{
   

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
         msg.setSendtime(new Timestamp(System.currentTimeMillis()));
         msg.setPush_code(result.getErrorCode());
         msg.setPush_msg(result.getErrorMsg());
         msg.setSendtimes(((msg.getSendtimes()==null?0:msg.getSendtimes())+1));
         msg.setCreatetime(new Timestamp(System.currentTimeMillis()));
         
         msg.setAccountid(accountid);
         msg.setData(data);
         msg.setNeedflag(1);
         msg.setTemplate_id(templateCode);
         msg.setTouser(toUser);
         msg.setUrl(url);
         msg.setNote(note);
         wxbModuleMsgDao.save(msg);
         result.setErrorCode(SysCode.SUCCESS);
         result.setErrorMsg("已推送，若未推送成功，将启动定时器，进行推送，共推送3次");
		return result;
	}
	@Override
	public void pustWxbModuleMsg() {
		int limitnum=1000;
		String wxb_module_msg_push_times=WxfwUtil.getProperty("every_time_push_limitnum");
		if(null != wxb_module_msg_push_times && !"".equals(wxb_module_msg_push_times)){
			limitnum=Integer.parseInt(wxb_module_msg_push_times);
		}
		List<WxbModuleMsg> list=wxbModuleMsgDao.getNeedPustMsg(limitnum);
		if(null !=list && list.size()>0){
			for(WxbModuleMsg msg:list){
				WxModuleMsgThreadPool.pushModuleMsg(msg);
			}
		}
	}
}