package com.marks.smart.system.user.login.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.Enums;
import com.marks.common.enums.UserEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.common.util.validate.VcodeUtil;
import com.marks.smart.system.core.runModel.RunModel;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.login.service.LoginService;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.service.SysUserService;

@Controller
public class WebLoginController {
	private static Logger logger = Logger.getLogger(WebLoginController.class);
	@Autowired
	private LoginService loginService;
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 前端登陆
	 */
	@RequestMapping("/web/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String userid = request.getParameter("mobile");
			String pwd = request.getParameter("password");
			String companyId = RunModel.getInstance().getCompanyId();
			SysUser loginUser = loginService.findById(companyId, userid);
			// 盘点用户是否为空
			if (loginUser == null) {
				result.setMessage("用户不存在");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			// 校验是否被禁用
			if (Enums.Status.Unable.getValue() == loginUser.getActiveFlag()) {
				result.setCode("4002");
				result.setMessage("用户被禁用");
				JsonUtil.output(response, result);
				return;
			}
			// 校验密码
			String password = EncryptUtil.encryptPwd(pwd);
			if (!password.equals(loginUser.getPassword())) {
				result.setCode("4004");
				result.setMessage("密码错误");
				JsonUtil.output(response, result);
				return;
			}
			LoginUtil.getInstance().setCurrentUser(request, loginUser);
		} catch (Exception e) {
			logger.error("findDiaryById", e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 获取登录用户信息
	 */
	@RequestMapping("/web/getInfo")
	public void getInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			if (loginUser == null) {
				result.setMessage("用户未登录");
				result.setCode("-102");
				JsonUtil.output(response, result);
				return;
			}
			if (Enums.Status.Unable.getValue() == loginUser.getActiveFlag()) {
				result.setMessage("您已经被禁用了哦");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			SysUser user = loginService.findSysUserByUserid(loginUser.getUserid());
			result.getData().put("loginUser", user);
		} catch (Exception e) {
			logger.error("getInfo", e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/web/bind")
	public void bind(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String code = request.getParameter("code");
			boolean checkVcode = VcodeUtil.getInstance().checkValidateCode(request, code);
			if (!checkVcode) {
				result.setCode("4001");
				result.setMessage("验证码错误");
				JsonUtil.output(response, result);
				return;
			}
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String companyId = RunModel.getInstance().getCompanyId();
			SysUser user = sysUserService.findById(companyId, mobile);
			if (null == user) {
				user = new SysUser();
				user.setCreator(mobile);
				user.setPassword(EncryptUtil.encryptPwd(password));
				user.setUsername(mobile);
				user.setRoleType(UserEnums.UserType.VIP.getValue());
				user.setRoleId(companyId + "_" + user.getRoleType());
				user.setChannelId(ChannelEnums.Channel.web.getValue());
			}
			user.setBind_mobile(mobile);
			user.setActiveFlag(Enums.Status.Enable.getValue());
			user.setBindFlag(Enums.Status.Enable.getValue());
			user.setCompanyId(companyId);
			user.setOpenid(LoginUtil.getInstance().getCurrentOpenid(request));
			user.setAccountid(LoginUtil.getInstance().getCurrentAccountid(request));
			sysUserService.saveOrUpdate(user);
		} catch (Exception e) {
			logger.error("bind", e);
			result.setMessage("系统错误");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
