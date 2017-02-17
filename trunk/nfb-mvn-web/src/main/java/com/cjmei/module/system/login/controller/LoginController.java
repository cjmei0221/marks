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
import com.cjmei.common.util.validate.VcodeUtil;
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
			String userid = request.getParameter("mobile");
			String pwd = request.getParameter("password");
			SysUser loginUser = sysUserService.getSysUserByUseridOrMobile(userid);
			//盘点用户是否为空
			if (loginUser == null) {
				result.setMessage("用户不存在");
				result.setCode(4001);
				JsonUtil.output(response, result);
				return;
			}
			//校验是否被禁用
			if (Enums.SysUserUse.NOUSE.getValue() == loginUser.getActiveFlag()) {
				result.setCode(4002);
				result.setMessage("用户被禁用");
				JsonUtil.output(response, result);
				return;
			}
			//校验是否未绑定
			if (Enums.SysUserBindFlag.NOUSE.getValue()==loginUser.getBindFlag()) {
				result.setCode(4003);
				result.setMessage("未绑定");
				JsonUtil.output(response, result);
				return;
			}
			//校验密码
			String password = EncryptUtil.encrypt(pwd);
			if (!password.equals(loginUser.getPassword())) {
				result.setCode(4004);
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
	@RequestMapping("/getInfo")
	public void getInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			if(loginUser==null){
				result.setMessage("用户未登录");
				result.setCode(-102);
				JsonUtil.output(response, result);
				return;
			}
			SysUser user = sysUserService.getSysUserByUseridOrMobile(loginUser.getUserid());
			result.getData().put("loginUser", user);
		} catch (Exception e) {
			logger.error("getInfo", e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	@RequestMapping("/bind")
	public void bind(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
			String code=request.getParameter("code");
			boolean checkVcode=VcodeUtil.getInstance().checkValidateCode(request,code);
			if(!checkVcode){
				result.setCode(4001);
				result.setMessage("验证码错误");
				JsonUtil.output(response, result);
				return;
			}
			String mobile=request.getParameter("mobile");
			String password=request.getParameter("password");
			SysUser sysUser=sysUserService.getSysUserByUseridOrMobile(mobile);
			if(sysUser !=null){
				if(Enums.SysUserUse.NOUSE.getValue()==sysUser.getActiveFlag()){
					result.setCode(4002);
					result.setMessage("此手机号已被禁用");
					JsonUtil.output(response, result);
					return;
				}
				if(Enums.SysUserBindFlag.USE.getValue()==sysUser.getBindFlag()){
					result.setCode(4003);
					result.setMessage("此手机号已被绑定");
					JsonUtil.output(response, result);
					return;
				}
			}
			SysUser user=new SysUser();
			user.setActiveFlag(Enums.SysUserUse.USE.getValue());
			user.setBind_mobile(mobile);
			user.setBindFlag(Enums.SysUserBindFlag.USE.getValue());
			user.setCompanyId(LoginUtil.getInstance().getCompanyId());
			user.setCreator(mobile);
			user.setPassword(EncryptUtil.encrypt(password));
			user.setUsername(mobile);
			user.setRoleid(user.getCompanyId()+"_"+Enums.SysUserType.VIP.getValue());
			if(sysUser==null){
				sysUserService.save(user);
			}else{
				sysUserService.update(user);
			}
		} catch (Exception e) {
			logger.error("getInfo", e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
