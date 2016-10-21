package com.grgbanking.module.wxfwhao.wxservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.grgbanking.common.util.JsonResult;
import com.grgbanking.common.util.SysCode;
import com.grgbanking.module.system.listener.DatabaseHelper;
import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.service.WeixinAccountService;
import com.grgbanking.module.wxfwhao.utils.AccessTokenUtil;
import com.grgbanking.module.wxfwhao.utils.WxHttpUtils;
import com.grgbanking.module.wxfwhao.utils.WxfwConfig;

/**
 * 获取jssdk 的 jsapi_ticket
 * @author cjmei
 *
 */
public class JssdkUtil {
	private static final long expires_in=7100*1000;
	private static Logger logger = Logger.getLogger(AccessTokenUtil.class);
	private static Map<String, AccessTokenVo> accesstoken_map=new HashMap<String, AccessTokenVo>();
	WeixinAccountService weixinAccountService=(WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
	private static final String jssdk_pre="jssdk_";
	private static JssdkUtil util=null;
	private boolean updateflag=false;
	private JssdkUtil(){};
	
	public static JssdkUtil getInstance(){
		if(util == null){
			util = new JssdkUtil();
		}
		return util;
	}
	public String getJsapi_ticket(String accountid){
		AccessTokenVo vo=null;
		if(updateflag){
			try {
				if(null ==weixinAccountService){
					weixinAccountService=(WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
				}
				vo=weixinAccountService.getAccessTokenVoByAccountid(jssdk_pre+accountid);
				//vo=MemcachedUtil.getInstance().getACCESS_TOKEN(jssdk_pre+accountid);
			} catch (Exception e) {
				vo=accesstoken_map.get(jssdk_pre+accountid);
			}
		}
		//updateflag=true;
		if(vo==null){
			vo=accesstoken_map.get(jssdk_pre+accountid);
		}
		if(vo==null){
			vo=sendJsapi_ticketRequest(accountid);
			if(null == vo){
				vo = sendJsapi_ticketRequest(accountid);
			}
		}
		if(null !=vo){
			long nowtime=System.currentTimeMillis();
			long time=Long.parseLong(vo.getPuttime());
			if((nowtime-time)>expires_in){
				vo = sendJsapi_ticketRequest(accountid);
			}
		}
		if(vo==null){
			return null;
		}
		return vo.getAccesstoken();
	}
	
	private void putJsapi_ticket(AccessTokenVo vo){
		updateflag=false;
		accesstoken_map.put(vo.getAccountid(), vo);
		if(null ==weixinAccountService){
			weixinAccountService=(WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
		}
		weixinAccountService.saveOrUpdateAccessTokenVo(vo);
		//MemcachedUtil.getInstance().putACCESS_TOKEN(jssdk_pre+vo.getAccountid(), vo, vo.getExpires_in());
	}
	
	  /***
     * 获取当前公众号Token
     * @param appId 微信号id
     * @param secret 密码
     * @return jsonResult
     */
    public synchronized AccessTokenVo sendJsapi_ticketRequest(String accountid){
    	AccessTokenVo vo=null;
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		try {
			logger.info("access_token:"+access_token);
			String url =WxfwConfig.weixin_server_prefix+"/ticket/getticket?access_token="+AccessTokenUtil.getInstance().getAccessToken(accountid)+"&type=jsapi";
			logger.info("url:"+url);
			JsonResult returnJson = WxHttpUtils.doGet(accountid,url,null,null);
			 if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
			     JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			     if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
			    	 vo=new AccessTokenVo();
			    	 vo.setAccesstoken(jsonObj.getString("ticket"));
			    	 vo.setAccountid(jssdk_pre+accountid);
			    	 vo.setExpires_in(jsonObj.getLong("expires_in")+"");
			    	 vo.setPuttime(System.currentTimeMillis()+"");
			    	 putJsapi_ticket(vo);
			     }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
			    	 sendJsapi_ticketRequest(accountid);
			     }
			 }
		} catch (Exception e) {
			logger.info("error",e);
		}
		return vo;
    }
}
