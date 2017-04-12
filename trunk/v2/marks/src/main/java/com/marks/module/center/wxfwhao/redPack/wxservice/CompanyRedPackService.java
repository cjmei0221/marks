package com.marks.module.center.wxfwhao.redPack.wxservice;

import java.util.Map;
import java.util.SortedMap;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxfwhao.redPack.pojo.CompanyQueryRedPackReq;
import com.marks.module.center.wxfwhao.redPack.pojo.CompanyQueryRedPackRes;
import com.marks.module.center.wxfwhao.redPack.pojo.CompanyRedPackReq;
import com.marks.module.center.wxfwhao.redPack.pojo.CompanyRedPackRes;
import com.marks.module.center.wxfwhao.redPack.util.HttpService;
import com.marks.module.center.wxfwhao.redPack.util.PropsPaywxUtil;
import com.marks.module.center.wxfwhao.redPack.util.WXPayUtil;

public class CompanyRedPackService {
	private static Logger logger = Logger.getLogger(CompanyRedPackService.class);
	private static CompanyRedPackService util=null;
	private CompanyRedPackService(){};
	
	public static CompanyRedPackService getInstance(){
		if(util == null){
			util = new CompanyRedPackService();
		}
		return util;
	}

	public JsonResult companyPay(String accountid,CompanyRedPackReq vo) {
		JsonResult result=new JsonResult();  
		//签名
		WXPayUtil wxPayUtil = new WXPayUtil();
		try {
			String sign = wxPayUtil.createSign(vo.getSortedMap(),PropsPaywxUtil.getProperty("key"));
			String reqUrl=PropsPaywxUtil.getProperty("transfers_url");
			SortedMap<String, String> reqMap=vo.getSortedMap();
			reqMap.put("sign", sign);
			String rsp = HttpService.doSendMoney(reqUrl, wxPayUtil.parseMapToXML(reqMap),accountid).replaceAll("\r|\n", "");
			Map<String, String> resMap=wxPayUtil.parseXMLToMap(rsp);
			CompanyRedPackRes res=(CompanyRedPackRes) wxPayUtil.converMap(CompanyRedPackRes.class, resMap);
			if(!"SUCCESS".equals(res.getReturn_code())){
				result.setErrorCode(res.getReturn_code());
				result.setErrorMsg(res.getReturn_msg());
				return result;	
			}
			if(!"SUCCESS".equals(res.getResult_code())){
				result.setErrorCode(res.getErr_code());
				result.setErrorMsg(res.getErr_code_des());
				return result;	
			}
			result.setResult(res);
		} catch (Exception e) {
			result.setErrorCode(SysCode.ERROR);
			result.setErrorMsg("系统错误");
		}  
		
		return result;
	}


	public JsonResult gettransferinfo(String accountid, CompanyQueryRedPackReq vo) {
		JsonResult result=new JsonResult();  
		//签名
		WXPayUtil wxPayUtil = new WXPayUtil();
		try {
			String sign = wxPayUtil.createSign(vo.getSortedMap(),PropsPaywxUtil.getProperty("key"));
			String reqUrl=PropsPaywxUtil.getProperty("gettransferinfo_url");
			SortedMap<String, String> reqMap=vo.getSortedMap();
			reqMap.put("sign", sign);
			String rsp = HttpService.doSendMoney(reqUrl, wxPayUtil.parseMapToXML(reqMap),accountid).replaceAll("\r|\n", "");
			Map<String, String> resMap=wxPayUtil.parseXMLToMap(rsp);
			CompanyQueryRedPackRes res=(CompanyQueryRedPackRes) wxPayUtil.converMap(CompanyQueryRedPackRes.class, resMap);
			if(!"SUCCESS".equals(res.getReturn_code())){
				result.setErrorCode(res.getReturn_code());
				result.setErrorMsg(res.getReturn_msg());
				return result;	
			}
			if(!"SUCCESS".equals(res.getResult_code())){
				result.setErrorCode(res.getErr_code());
				result.setErrorMsg(res.getErr_code_des());
				return result;	
			}
			result.setResult(res);
		} catch (Exception e) {
			result.setErrorCode(SysCode.ERROR);
			result.setErrorMsg("系统错误");
		}  
		
		return result;
	}
}