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
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询我的日记
	 */
	@RequestMapping("/login")
	public void findDiaryById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String userid=request.getParameter("mobile");
			String pwd=request.getParameter("password");
			SysUser loginUser=sysUserService.getSysUserByUseridOrMobile(userid);
			if(loginUser!=null){
				if (Enums.SysUserUse.NOUSE.getValue() == loginUser.getActiveFlag()) {
					result.setCode(4002);
					result.setMessage("用户被禁用");
				}else{
					String password = EncryptUtil.encrypt(pwd);
					if (password.equals(loginUser.getPassword())) {
						LoginUtil.getInstance().setCurrentUser(request, loginUser);
					}else{
						result.setCode(4003);
						result.setMessage("密码错误");
					}
				}
			}else{
				result.setMessage("用户不存在");
				result.setCode(4001);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 获取登录用户信息
	 */
	@RequestMapping("/getInfo")
	public void getInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			SysUser user = sysUserService.getSysUserByUseridOrMobile(loginUser.getUserid());
			result.getData().put("loginUser", user);
		} catch (Exception e) {
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
