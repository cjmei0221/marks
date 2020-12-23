package com.marks.smart.wx.api.work.wxInterface.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.http.HttpUtils;
import com.marks.smart.system.cache.CacheData;
import com.marks.smart.wx.api.util.WxCacheData;
import com.marks.smart.wx.api.mp.wxInteface.base.entity.AccessTokenVo;
import com.marks.smart.wx.api.work.wxInterface.base.utils.WxqyConfig;
import com.marks.smart.wx.manage.mp.entity.WxAccount;

public class QyAccessTokenUtil {

	private static Logger logger = Logger.getLogger(QyAccessTokenUtil.class);

	private static QyAccessTokenUtil util=null;
	private QyAccessTokenUtil(){};
	
	public static QyAccessTokenUtil getInstance(){
		if(util == null){
			util = new QyAccessTokenUtil();
		}
		return util;
	}
	private static final String prefix="qy_";
	public String getQyAccessToken(String accountid){
		AccessTokenVo vo = WxCacheData.getInstance().getAccessToken(prefix + accountid);
		// 首次
		if (vo == null) {
			vo = sendQyAccessTokenRequest(accountid);
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
    public synchronized AccessTokenVo sendQyAccessTokenRequest(String accountid){
    	AccessTokenVo vo=null;
        JsonResult jsonResult = new JsonResult();
        try{
        	String url=WxqyConfig.weixin_qy_server_prefix+"/gettoken";
			WxAccount wx = CacheData.getWxAccount(accountid);
            Map<String,String> params = new HashMap<String,String>();
            params.put("corpid",wx.getAppid());
            params.put("corpsecret",wx.getAppsecret());
            JsonResult returnJson = HttpUtils.getInstance().doGet(url,params,null,"utf-8");
            if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
                JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
                if(returnJson.getResult().toString().indexOf("access_token") != -1){
                	logger.info("access_token:"+jsonObj.getString("access_token"));
                	vo=new AccessTokenVo();
                	vo.setAccesstoken(jsonObj.get("access_token").toString());
                	vo.setAccountid(prefix+accountid);
                	vo.setExpires_in(jsonObj.getLong("expires_in")+"");
                	vo.setPuttime(System.currentTimeMillis()+"");
					WxCacheData.getInstance().putAccessToken(vo);
                }else {
                    jsonResult.setSuccess(Boolean.FALSE);
                    jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
                    jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
                }
            } else {
                jsonResult.setSuccess(Boolean.FALSE);
                jsonResult.setErrorCode("9999");
                jsonResult.setErrorMsg("return data null");
            }
        }catch (Exception ex){
            jsonResult.setSuccess(Boolean.FALSE);
            jsonResult.setErrorCode("9999");
            jsonResult.setErrorMsg(ex.getMessage());
        }
        logger.info("sendQyAccessTokenRequest>>"+jsonResult.getErrorCode()+"-"+jsonResult.getErrorCode());
        return vo;
    }
}
