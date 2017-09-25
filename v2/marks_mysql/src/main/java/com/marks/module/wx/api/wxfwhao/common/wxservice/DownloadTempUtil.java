package com.marks.module.wx.api.wxfwhao.common.wxservice;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.IDUtil;
import com.marks.common.util.center.SysCode;
import com.marks.common.util.http.HttpUtils;
import com.marks.module.wx.api.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wx.api.wxfwhao.common.utils.WxfwConfig;

public class DownloadTempUtil {
	private static Logger logger = Logger.getLogger(DownloadTempUtil.class);
	private static DownloadTempUtil util = null;

	private DownloadTempUtil() {
	};

	public static DownloadTempUtil getInstance() {
		if (util == null) {
			util = new DownloadTempUtil();
		}
		return util;
	}

	/**
	 * 
	 * @param accountid
	 * @param type   类型 video
	 * @param fileName 仅是名称
	 * @param media_id
	 * @return
	 */
	public JsonResult download(String accountid, String type, String fileName,String media_id) {
		JsonResult jsonResult = new JsonResult();
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		String url = WxfwConfig.weixin_server_prefix + "/media/get?access_token=" + access_token + "&media_id="
				+ media_id;
		if ("video".equals(type.toLowerCase())) {
			url = url.replace("https", "http");
		}
		String downloadPath=WxfwConfig.downloadMediaPath;
		String viewPath=WxfwConfig.view_media_url;
		if("image".equals(type.toLowerCase())){
			downloadPath=WxfwConfig.downloadImagePath;
			viewPath=WxfwConfig.view_image_url;
		}
		logger.info("fileName:" + downloadPath+fileName);
		jsonResult = HttpUtils.getInstance().download(url,downloadPath+fileName);
		 if(SysCode.SUCCESS.equals(jsonResult.getErrorCode())){
			 jsonResult.setResult(viewPath+fileName);
		 }
		return jsonResult;
	}
	public static void main(String[] args) throws Exception {
		String downloadPath=WxfwConfig.downloadMediaPath;
		String viewPath=WxfwConfig.view_image_url;
		String fileName="P"+IDUtil.getTimeID()+".html";
//		String url="http://ccrb.1news.cc/res/1/1/2017-03/18/04/res01_attpic_brief.jpg";
		String url="http://news.163.com/17/0317/20/CFOPOFJO00014AEE.html";
		JsonResult	jsonResult = HttpUtils.getInstance().download(url,downloadPath+fileName);
		
		System.out.println(jsonResult.getErrorCode());
		System.out.println(viewPath+fileName);
	}
}
