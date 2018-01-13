package com.marks.module.user.sysuser.controller.web;

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
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.WebUtil;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.service.SysUserService;

@Controller
public class WebSysUserController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WebSysUserController.class);
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private LoginService loginService;

	/**
	 * 查询用户管理
	 */
	@RequestMapping("/web/sysUser/findSysUserById")
	public void findSysUserById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			SysUser requestSysUser = sysUserService.findByUserid(loginUser.getUserid());
			result.getData().put("info", requestSysUser);
			result.setMessage("findById sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

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
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			SysUser user = loginService.findSysUserByUserid(loginUser.getUserid());
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
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			SysUser user = loginService.findSysUserByUserid(loginUser.getUserid());
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
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			sysUserService.updateSkin(loginUser.getUserid(), Integer.parseInt(skin));
		} catch (Exception e) {
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改用户管理
	 */
	@RequestMapping("/web/sysUser/update")
	public void updateSysUser(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			SysUser info = getModel(SysUser.class);
			SysUser ori = sysUserService.findById(loginUser.getUserid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				ori.setGender(info.getGender());
				ori.setBirthday(info.getBirthday());
				ori.setSignature(info.getSignature());
				ori.setUsername(info.getUsername());
				ori.setEmail(info.getEmail());
				sysUserService.update(ori);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

}
