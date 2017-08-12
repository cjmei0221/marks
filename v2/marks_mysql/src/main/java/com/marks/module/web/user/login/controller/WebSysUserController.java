package com.marks.module.web.user.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.module.inner.user.login.service.LoginService;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.inner.user.sysuser.service.SysUserService;
import com.marks.module.web.user.login.util.LoginUtil;

@Controller
public class WebSysUserController {
	private static Logger logger = Logger.getLogger(WebSysUserController.class);
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private LoginService loginService;
	/**
	 * 更改密码
	 */
	@RequestMapping("/web/sysUser/changeMobile")
	public void changeMobile(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String mobile = request.getParameter("mobile");
			String pwd = request.getParameter("password");
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			SysUser user = loginService.getSysUserByUseridOrMobile(loginUser.getUserid());
			String password = EncryptUtil.encryptPwd(pwd);
			if (password.equals(user.getPassword())) {
				sysUserService.updateMobile(user.getUserid(), mobile);
			} else {
				result.setCode("4001");
				result.setMessage("原密码错误");
			}

		} catch (Exception e) {
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	/**
	 * 更改密码
	 */
	@RequestMapping("/web/sysUser/changePwd")
	public void changePwd(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String oldPwd = request.getParameter("oldPwd");
			String newPwd = request.getParameter("newPwd");
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			SysUser user = loginService.getSysUserByUseridOrMobile(loginUser.getUserid());
			String password = EncryptUtil.encryptPwd(oldPwd);
			if (password.equals(user.getPassword())) {
				sysUserService.updatePwd(user.getUserid(), EncryptUtil.encryptPwd(newPwd));
			} else {
				result.setCode("4001");
				result.setMessage("原密码错误");
			}

		} catch (Exception e) {
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改皮肤
	 */
	@RequestMapping("/web/sysUser/changeSkin")
	public void changeSkin(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String skin = request.getParameter("skin");
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			sysUserService.updateSkin(loginUser.getUserid(), Integer.parseInt(skin));
		} catch (Exception e) {
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	
}
