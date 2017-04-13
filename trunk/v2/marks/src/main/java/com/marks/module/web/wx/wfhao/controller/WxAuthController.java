package com.marks.module.web.wx.wfhao.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.module.center.wxfwhao.common.entity.WxUser;
import com.marks.module.inner.system.sys.service.LoginService;
import com.marks.module.inner.system.sysuser.pojo.SysUser;
import com.marks.module.inner.wx.wxuser.service.WxUserService;
import com.marks.module.web.runModel.RunModel;
import com.marks.module.web.system.login.util.LoginUtil;
import com.marks.module.web.wx.wfhao.config.PageConfigUtil;
import com.marks.module.web.wx.wfhao.util.WxUtil;

@Controller
public class WxAuthController {

	private static Logger logger = Logger.getLogger(WxAuthController.class);

	public static final String wxauth_after_url = "wxauth_after_url";

	@Autowired
	private WxUserService wxUserService;
	@Autowired
	private LoginService loginService;

	/**
	 * 调用微信授权接口去授权
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/web/toWxAuth")
	public void toWxAuth(HttpServletRequest request, HttpServletResponse response) {
		logger.info("调用微信授权接口去授权1>>start");
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		try {
			String accountid = request.getParameter("accountid");
			String to_url = request.getParameter("to_url");
			logger.info("调用微信授权接口去授权2>>accountid=" + accountid + "&to_url=" + to_url);
			if (accountid != null && !"".equals(accountid) && null != to_url && to_url.length() > 5) {
				// 如果session中有openid,则不去获取openid
				boolean flag = checkSession(request, false, null, accountid);
				if (flag) {
					String return_url = URLDecoder.decode(to_url, "utf-8");
					return_url = WxUtil.getInstance().getCompleteUrl(accountid, return_url);
					response.sendRedirect(return_url);
					return;
				} else {
					request.getSession().setAttribute(wxauth_after_url, to_url);
					if (RunModel.getInstance().getWeixinMode().equals("N")) {
						String return_url = URLDecoder.decode(to_url, "utf-8");
						logger.info("调用微信授权接口去授权3>>url>>" + return_url);
						response.sendRedirect(return_url);
					} else {
						// 组装授权URL
						String url = WxUtil.getInstance().getWeixinUrl(accountid,
								request.getContextPath() + "/web/wxAuthCallback.do?accountid=" + accountid);
						response.sendRedirect(url);
					}
				}
			} else {
				logger.info("调用微信授权接口去授权>>6");
				response.sendRedirect(WxUtil.getInstance().getCompleteUrl(accountid,
						request.getContextPath() + PageConfigUtil.getProperty("errorUrl")));
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统繁忙");
		}
	}

	@RequestMapping("/web/wxAuthCallback")
	public void callback(HttpServletRequest request, HttpServletResponse response) {
		logger.info("微信授权回调>>start");
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		String accountid = request.getParameter("accountid");
		try {
			String code = request.getParameter("code");
			logger.info(" weixin code >> " + code);
			String to_url = URLDecoder.decode((String) request.getSession().getAttribute(wxauth_after_url), "utf-8");
			if (RunModel.getInstance().getWeixinMode().equals("Y")) {
				logger.info("通过code获取openid>>start");
				String openid = WxUtil.getInstance().getOpenIdByCode(code, accountid);
				logger.info("通过code获取openid>>end");
				if (null != openid && openid.length() > 5) {
					logger.info(" weixin openid >> " + openid);
					checkSession(request, true, openid, accountid);
				} else {
					logger.info(" weixin openid is null ,openid=" + openid);
					to_url = request.getContextPath() + PageConfigUtil.getProperty("errorUrl");
				}
			}
			logger.info("微信授权回调>>end");
			String return_url = WxUtil.getInstance().getCompleteUrl(accountid, to_url);
			logger.info("微信授权回调结束之后跳转url>>" + return_url);
			response.sendRedirect(return_url);
		} catch (Exception e) {
			logger.error("Exception:", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统繁忙");
			try {
				response.sendRedirect(WxUtil.getInstance().getCompleteUrl(accountid,
						request.getContextPath() + PageConfigUtil.getProperty("errorUrl")));
			} catch (IOException e1) {

			}
		}
	}

	/**
	 * 
	 * @param request
	 * @param flag
	 *            是否重新获取openid
	 * @param newOpenid
	 * @return
	 */
	private boolean checkSession(HttpServletRequest request, boolean flag, String newOpenid, String accountid) {
		if (flag) {
			WxUtil.getInstance().setCurrentOpenid(request, newOpenid);
			WxUtil.getInstance().setCurrentAccountid(request, accountid);
			WxUser user = wxUserService.findById(accountid, newOpenid);
			if (user == null) {
				return false;
			}
			WxUtil.getInstance().setCurrentWxbUser(request, user);
			SysUser loginUser = loginService.getSysUserByUseridOrMobile(user.getFanId());
			if (null == loginUser) {
				return false;
			}
			loginUser.setUsername(user.getNickname());
			LoginUtil.getInstance().setCurrentUser(request, loginUser);
			return false;
		} else {
			String openid = WxUtil.getInstance().getCurrentOpenid(request);
			logger.info("session>>openid>>" + openid);
			if (openid != null && openid.length() > 5) {
				WxUser user = WxUtil.getInstance().getCurrentWxbUser(request);
				if (user != null) {
					return true;
				}
				user = wxUserService.findById(accountid, openid);
				if(user==null){
					return true;
				}
				WxUtil.getInstance().setCurrentWxbUser(request, user);
				
				SysUser loginUser = loginService.getSysUserByUseridOrMobile(user.getFanId());
				if (null != loginUser) {
					loginUser.setUsername(user.getNickname());
					LoginUtil.getInstance().setCurrentUser(request, loginUser);
				}
				return true;
			}
		}

		return false;
	}
}
