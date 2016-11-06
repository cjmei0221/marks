package com.cjmei.module.weixin.wfhao.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.module.login.util.LoginUtil;
import com.cjmei.module.login.util.RunModel;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.service.WeixinAccountService;
import com.cjmei.module.weixin.wfhao.threadPool.UpdateWxUserhreadPool;

@Controller
public class WxAuthController {

	private static Logger logger = Logger.getLogger(WxAuthController.class);

	public static final String wxauth_after_url = "wxauth_after_url";

	private static String errorUrl = "/extfunc/500.html";
	private static String openid_null_url = "/extfunc/openid_null.html";
	private String unsubscribeurl = "/main/notWeChatBrowser.html";
	@Autowired
	private WeixinAccountService weixinAccountService;

	/**
	 * 调用微信授权接口去授权
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/wxauth/toWxAuth")
	public void toWxAuth(HttpServletRequest request, HttpServletResponse response) {
		logger.info("调用微信授权接口去授权>>start");
		Result result = new Result();
		result.setCode(0);
		try {
			String accountid = request.getParameter("accountid");
			String to_url = request.getParameter("to_url");
			logger.info("调用微信授权接口去授权>>accountid=" + accountid + "&to_url=" + to_url);
			if (accountid != null && !"".equals(accountid) && null != to_url && to_url.length() > 5) {
				request.getSession().setAttribute(wxauth_after_url, to_url);
				if (RunModel.getInstance().getWeixinMode().equals("N")) {
					String return_url = URLDecoder.decode(to_url, "utf-8");
					logger.info("调用微信授权接口去授权>>url>>" + return_url);
					response.sendRedirect(return_url);
				} else {
					// 组装授权URL
					String url = LoginUtil.getInstance().getWeixinUrl(accountid,
							"/WECHAT/wxauth/callback.do?accountid=" + accountid);
					response.sendRedirect(url);
				}
			} else {
				logger.info("调用微信授权接口去授权>>6");
				response.sendRedirect(LoginUtil.getInstance().getCompleteUrl(accountid, errorUrl));
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
			result.setCode(-1);
			result.setMessage("系统繁忙");
		}
	}

	@RequestMapping("/wxauth/callback")
	public void callback(HttpServletRequest request, HttpServletResponse response) {
		logger.info("微信授权回调>>start");
		Result result = new Result();
		result.setCode(0);
		String accountid = request.getParameter("accountid");
		try {
			String code = request.getParameter("code");
			logger.info(" weixin code >> " + code);
			String to_url = URLDecoder.decode((String) request.getSession().getAttribute(wxauth_after_url), "utf-8");
			WxUser user = null;
			if (RunModel.getInstance().getWeixinMode().equals("Y")) {
				logger.info("通过code获取openid>>start");
				String openid = LoginUtil.getInstance().getOpenIdByCode(code, accountid);
				logger.info("通过code获取openid>>end");
				if (null != openid && openid.length() > 5) {
					logger.info(" weixin openid >> " + openid);
					LoginUtil.getInstance().setCurrentOpenid(request, openid);
					LoginUtil.getInstance().setCurrentAccountid(request, accountid);
					user = weixinAccountService.queryWxUserByOpenID(accountid, openid);
					if (null == user || (null != user && user.getIssubscribe() == 0)) {
						logger.info("未关注服务号>>openid>>" + openid);
						to_url = unsubscribeurl;
					} else {
						LoginUtil.getInstance().setCurrentWxbUser(request, user);
					}
					// 更新关注者信息
					UpdateWxUserhreadPool.updateWxUser(accountid, openid);
				} else {
					logger.info(" weixin openid is null ,openid=" + openid);
					to_url = openid_null_url;
				}
			}
			logger.info("微信授权回调>>end");
			String return_url = LoginUtil.getInstance().getCompleteUrl(accountid, to_url);
			logger.info("微信授权回调结束之后跳转url>>" + return_url);
			response.sendRedirect(return_url);
		} catch (Exception e) {
			logger.error("Exception:", e);
			result.setCode(-1);
			result.setMessage("系统繁忙");
			try {
				response.sendRedirect(LoginUtil.getInstance().getCompleteUrl(accountid, errorUrl));
			} catch (IOException e1) {

			}
		}
	}
}
