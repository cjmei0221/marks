package com.marks.module.wx.api.wxInterface.mp.base.wxservice;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.wx.api.util.WxCacheData;
import com.marks.module.wx.api.wxInterface.mp.base.entity.AccessTokenVo;
import com.marks.module.wx.api.wxInterface.mp.base.utils.AccessTokenUtil;
import com.marks.module.wx.api.wxInterface.mp.base.utils.WxHttpUtils;
import com.marks.module.wx.api.wxInterface.mp.base.utils.WxfwConfig;

/**
 * 获取jssdk 的 jsapi_ticket
 * @author cjmei
 *
 */
public class JssdkUtil {
	private static Logger logger = Logger.getLogger(JssdkUtil.class);
	private static final String jssdk_pre="jssdk_";
	private static JssdkUtil util=null;
	private JssdkUtil(){};
	
	public static JssdkUtil getInstance(){
		if(util == null){
			util = new JssdkUtil();
		}
		return util;
	}
	public String getJsapi_ticket(String accountid){
		AccessTokenVo vo = WxCacheData.getInstance().getAccessToken(jssdk_pre + accountid);
		// 首次
		if (vo == null) {
			vo = sendJsapi_ticketRequest(accountid);
		}
		if (vo == null) {
			return null;
		}
		return vo.getAccesstoken();
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
					WxCacheData.getInstance().putAccessToken(vo);
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
