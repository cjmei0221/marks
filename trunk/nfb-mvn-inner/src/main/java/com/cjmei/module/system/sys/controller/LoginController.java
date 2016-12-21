package com.cjmei.module.system.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.common.enums.Enums;
import com.cjmei.common.util.Constants;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.encrypt.EncryptUtil;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.service.LoginService;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysuser.pojo.SysUser;
import com.cjmei.module.wx.wxaccount.service.WxAccountService;

/**
 * 用户登录 控制层 File Name: com.grgbanking.inner.controller.LoginController.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月27日下午1:59:34
 * @see (optional)
 * @Copyright (c) 2016, cjmei All Rights Reserved.
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private WxAccountService wxAccountService;

	/**
	 * 登录 queryDepartmentList:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @author cjmei
	 * @throws Exception
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sys/login")
	public void queryDepartmentList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		/**
		 * 如果登陆用为system，则拥有所有权限除了业务权限
		 */
		SysUser user = loginService.getSysUserByUserid(userid);
		if (user == null) {
			result.setCode(4001);
			result.setMessage("用户不存在");
		} else {
			if (Enums.SysUserUse.NOUSE.getValue() == user.getActiveFlag()) {
				result.setCode(4002);
				result.setMessage("用户被禁用");
			} else {
				String password = EncryptUtil.encrypt(pwd);
				if (password.equals(user.getPassword())) {
					List<SysRole> roleList = loginService.getUserRoleList(user.getUserid());
					if (roleList != null && roleList.size() > 0) {
						if ("0".equals(user.getCompanyId())) {
							user.setCompanyId(null);
						}
						result.setCode(0);
						result.setMessage("success");
						user.setLoginTime(new Date());
						user.setPassword("");
						user.setRoleIds(roleList);
						OrgInfo orgInfo = StaticData.getOrgInfo(roleList.get(0).getOrgid());
						user.setOrgInfo(orgInfo);
						// 组织架构
						boolean topflag = true;
						if (Constants.top_org_parentid_id.equals(orgInfo.getParentId())
								|| "0".equals(orgInfo.getParentId())) {
							topflag = false;
						}
						if (topflag) {
							List<String> orgids = loginService.getOrgidBySysUser(orgInfo.getOrgid());
							user.setOrgids(orgids);
						} else {
							user.setOrgids(null);
						}
						user.setAccountids(null);
						if (null != user.getOrgids() && null != user.getCompanyId()) {
							Map<String, Object> param = new HashMap<String, Object>();
							param.put("conpanyId", user.getCompanyId());
							param.put("orgids", user.getOrgids());
							List<String> accountids = wxAccountService.getAccountIdsByLoginUser(param);
							user.setAccountids(accountids);
						}
						SysUserHelper.setCurrentUserInfo(request, user);
					} else {
						result.setCode(4005);
						result.setMessage("您没有权限登录");
					}

				} else {
					result.setCode(4003);
					result.setMessage("密码错误");
				}
			}
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = SysUserHelper.getCurrentUserInfo(request);
		if (user != null) {
			SysUserHelper.setCurrentUserInfo(request, null);
		}
		result.setCode(0);
		result.setMessage("success");
		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/menu")
	public void sysMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = SysUserHelper.getCurrentUserInfo(request);
		List<SysMenu> list = loginService.getSysMenuOfSysUser(user);
		result.setCode(0);
		result.setMessage("success");
		result.getData().put("menuList", list);
		result.getData().put("loginUser", user);
		JsonUtil.output(response, result);
	}
}
