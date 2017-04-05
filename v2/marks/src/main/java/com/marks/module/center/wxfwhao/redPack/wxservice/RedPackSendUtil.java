package com.marks.module.center.wxfwhao.redPack.wxservice;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.module.center.wxfwhao.redPack.util.HttpService;

public class RedPackSendUtil {
	private static Logger logger = Logger.getLogger(RedPackSendUtil.class);
	private static String access_token = null;
	private static RedPackSendUtil util=null;
	public static RedPackSendUtil getInstance(){
		if(util == null){
			util = new RedPackSendUtil();
		}
		return util;
	}
	//现金红包发送
	public JsonResult redPackSend(String requestUrl,String data,String accountid) throws Exception{
		String rsp = HttpService.doSendMoney(requestUrl, data,accountid).replaceAll("\r|\n", "");
		JsonResult jsonResult = new JsonResult();
		jsonResult.setResult(rsp);
		return jsonResult;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
