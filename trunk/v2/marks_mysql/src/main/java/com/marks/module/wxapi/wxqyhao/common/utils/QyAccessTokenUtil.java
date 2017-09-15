package com.marks.module.wxapi.wxqyhao.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.http.HttpUtils;
import com.marks.module.inner.wx.wxaccount.pojo.WxAccount;
import com.marks.module.sys.common.SpringContextHolder;
import com.marks.module.sys.data.StaticData;
import com.marks.module.wxapi.wxfwhao.common.entity.AccessTokenVo;
import com.marks.module.wxapi.wxfwhao.common.service.AccessTokenService;
import com.marks.module.wxapi.wxfwhao.common.utils.WxfwConfig;

public class QyAccessTokenUtil {
	private static final long expires_in=7100*1000;
	private static Logger logger = Logger.getLogger(QyAccessTokenUtil.class);
	private static Map<String, AccessTokenVo> accesstoken_map=new HashMap<String, AccessTokenVo>();
	AccessTokenService accessTokenService=(AccessTokenService) SpringContextHolder.getBean(AccessTokenService.class);
	private long updateflag=0;
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
		AccessTokenVo vo=null;
		if (WxfwConfig.access_token_db_flag_Y.equals(WxfwConfig.access_token_db_flag) && System.currentTimeMillis()-updateflag>3000) {
			try {
				if(null ==accessTokenService){
					accessTokenService=(AccessTokenService) SpringContextHolder.getBean(AccessTokenService.class);
				}
				vo=accessTokenService.getAccessTokenVoByAccountid(prefix+accountid);
				//vo=MemcachedUtil.getInstance().getACCESS_TOKEN();
			} catch (Exception e) {
				vo=accesstoken_map.get(prefix+accountid);
			}	
		}else{
			vo=accesstoken_map.get(prefix+accountid);
		}
		//updateflag=true;
		if(vo==null){
			vo=accesstoken_map.get(prefix+accountid);
		}
		//首次
		if(vo==null){
			vo=sendQyAccessTokenRequest(accountid);
			if(vo ==null){
				vo=sendQyAccessTokenRequest(accountid);
			}
		}
		if(null != vo){
			long nowtime=System.currentTimeMillis();
			long time=Long.parseLong(vo.getPuttime());
			if((nowtime-time)>expires_in){
				vo=sendQyAccessTokenRequest(accountid);
			}
		}
		return vo.getAccesstoken();
	}
	
	public  void putQyAccessToken(AccessTokenVo vo){
		updateflag=System.currentTimeMillis();
		accesstoken_map.put(vo.getAccountid(), vo);
		try {
			if(null ==accessTokenService){
				accessTokenService=(AccessTokenService) SpringContextHolder.getBean(AccessTokenService.class);
			}
			accessTokenService.saveOrUpdateAccessTokenVo(vo);
			//MemcachedUtil.getInstance().putACCESS_TOKEN(vo.getAccountid(), vo,expires_in);
		} catch (Exception e) {
	
		}
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
        	WxAccount wx=StaticData.getWxAccount(accountid);
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
                	putQyAccessToken(vo);
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
