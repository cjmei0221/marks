package com.marks.module.user.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.UserEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.common.util.validate.VcodeUtil;
import com.marks.module.core.runModel.RunModel;
import com.marks.module.user.login.helper.WebUtil;
import com.marks.module.user.login.helper.WxUtil;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.service.SysUserService;

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
			//盘点用户是否为空
			if (loginUser == null) {
				result.setMessage("用户不存在");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			//校验是否被禁用
			if (UserEnums.ActiveFlag.unuse.getValue() == loginUser.getActiveFlag()) {
				result.setCode("4002");
				result.setMessage("用户被禁用");
				JsonUtil.output(response, result);
				return;
			}
			//校验是否未绑定
			// if (UserEnums.BindFlag.unbind.getValue() ==
			// loginUser.getBindFlag()) {
			// result.setCode("4003");
			// result.setMessage("未绑定");
			// JsonUtil.output(response, result);
			// return;
			// }
			//校验密码
			String password = EncryptUtil.encryptPwd(pwd);
			if (!password.equals(loginUser.getPassword())) {
				result.setCode("4004");
				result.setMessage("密码错误");
				JsonUtil.output(response, result);
				return;
			} 
			WebUtil.getInstance().setCurrentUser(request, loginUser);
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
			SysUser loginUser = WebUtil.getInstance().getCurrentUser(request);
			if(loginUser==null){
				result.setMessage("用户未登录");
				result.setCode("-102");
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
			String code=request.getParameter("code");
			boolean checkVcode=VcodeUtil.getInstance().checkValidateCode(request,code);
			if(!checkVcode){
				result.setCode("4001");
				result.setMessage("验证码错误");
				JsonUtil.output(response, result);
				return;
			}
			String mobile=request.getParameter("mobile");
			String password=request.getParameter("password");
			String companyId = RunModel.getInstance().getCompanyId();
			SysUser sysUser = loginService.findById(companyId, mobile);
			
			
			if(sysUser !=null){
				if (UserEnums.ActiveFlag.unuse.getValue() == sysUser.getActiveFlag()) {
					result.setCode("4002");
					result.setMessage("此手机号已被禁用");
					JsonUtil.output(response, result);
					return;
				}
				if (UserEnums.BindFlag.unbind.getValue() == sysUser.getBindFlag()) {
					result.setCode("4003");
					result.setMessage("此手机号已被绑定");
					JsonUtil.output(response, result);
					return;
				}
			}
			SysUser user=new SysUser();
			user.setActiveFlag(UserEnums.ActiveFlag.use.getValue());
			user.setBind_mobile(mobile);
			user.setBindFlag(UserEnums.BindFlag.bind.getValue());
			user.setCompanyId(companyId);
			user.setCreator(mobile);
			user.setPassword(EncryptUtil.encryptPwd(password));
			user.setUsername(mobile);
			user.setRoleid(companyId + "_" + UserEnums.UserType.VIP.getValue());
			user.setOpenid(WxUtil.getInstance().getCurrentOpenid(request));
			user.setAccountid(WxUtil.getInstance().getCurrentAccountid(request));
			if(sysUser==null){
				sysUserService.save(user);
			}else{
				sysUserService.update(user);
			}
		} catch (Exception e) {
			logger.error("bind", e);
			result.setMessage("系统错误");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
