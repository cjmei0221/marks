package com.cjmei.module.system.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.common.enums.Enums;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.code.Code;
import com.cjmei.common.util.encrypt.EncryptUtil;
import com.cjmei.module.system.login.pojo.SysUser;
import com.cjmei.module.system.login.service.SysUserService;
import com.cjmei.module.system.login.util.LoginUtil;

@Controller
public class SysUserController {
	private static Logger logger = Logger.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询我的日记
	 */
	@RequestMapping("/sysUser/changePwd")
	public void findDiaryById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String oldPwd = request.getParameter("oldPwd");
			String newPwd = request.getParameter("newPwd");
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			SysUser user = sysUserService.getSysUserByUserid(loginUser.getUserid());

			String password = EncryptUtil.encrypt(oldPwd);
			if (password.equals(user.getPassword())) {
				sysUserService.updatePwd(user.getUserid(),EncryptUtil.encrypt(newPwd));
			} else {
				result.setCode(4001);
				result.setMessage("原密码错误");
			}

		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
