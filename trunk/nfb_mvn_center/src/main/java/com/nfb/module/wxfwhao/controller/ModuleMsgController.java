package com.nfb.module.wxfwhao.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nfb.common.util.JsonResult;
import com.nfb.module.wxmodulemsg.service.WxbModuleMsgService;

import net.sf.json.JSONObject;

/**
 * 模板消息
 * @author cjmei
 *
 */
@Controller
public class ModuleMsgController {

    private static Logger logger = Logger.getLogger(ModuleMsgController.class);
    @Autowired
    private WxbModuleMsgService  wxbModuleMsgService;
   
    @RequestMapping(value = "/wechat/receive/sendTemplateMsg")
    public void sendTemplateMsg(HttpServletRequest request,HttpServletResponse response) {
        JsonResult result = new JsonResult();
        try {
        	String accountid=request.getParameter("accountid");
        	String toUser=request.getParameter("toUser");
        	String templateCode=request.getParameter("templateCode");
        	String url="";
            if(request.getParameter("toUrl") != null && !request.getParameter("toUrl").trim().equals("")){
            	url=URLDecoder.decode(request.getParameter("toUrl"), "utf-8");
                logger.info("toUrl>>"+url);
            }
            String data="";
            if(request.getParameter("data") != null && !request.getParameter("data").trim().equals("")){
            	data=URLDecoder.decode(request.getParameter("data"), "utf-8");
            }

           result= wxbModuleMsgService.sendTemplateMsg(accountid, toUser, templateCode, url,data);
        } catch (Exception e) {
            logger.error("系统异常，请稍后再试",e);
            result.setSuccess(Boolean.FALSE);
            result.setErrorMsg("系统异常，请稍后再试");
            result.setErrorCode("9999");
        }
        try {
        	JSONObject array = JSONObject.fromObject(result);     
        	response.setContentType("text/html;charset=UTF-8");
    		response.getWriter().write(array.toString());
    		response.getWriter().close();
		} catch (IOException e) {
			
		}
    }

}
