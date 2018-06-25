package com.marks.module.user.sysuser.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.PaginationResult;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.Enums;
import com.marks.common.enums.UserEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.service.SysUserService;

@Controller
public class SysUserController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SysUserController.class);
	@Autowired
	private SysUserService sysUserService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询用户管理
	 */
	@RequestMapping("/inner/sysUser/findSysUserById")
	public void findSysUserById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser sysUser = getModel(SysUser.class);
			SysUser requestSysUser = sysUserService.findByUserid(sysUser.getUserid());
			result.getData().put("sysUser", requestSysUser);
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
	 * 保存用户管理
	 */
	@RequestMapping("/inner/sysUser/save")
	public void saveSysUser(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysUser sysUser = getModel(SysUser.class);
			String companyId = admin.getCompanyId();
			// sysUser.setUserid(IDUtil.getTimeID());

			// 密码处理
			sysUser.setPassword(EncryptUtil.defaultPwd);
			sysUser.setCreator(admin.getOperator());
			sysUser.setCompanyId(companyId);
			sysUser.setChannelId(ChannelEnums.Channel.manage.getValue());
			sysUser.setActiveFlag(Enums.Status.Enable.getValue());
			if (UserEnums.UserType.VIP.getValue().equals(sysUser.getRoleType())) {
				sysUser.setRoleId(admin.getCompanyId() + "_" + sysUser.getRoleType());
			}
			result = sysUserService.save(sysUser);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改用户管理
	 */
	@RequestMapping("/inner/sysUser/update")
	public void updateSysUser(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysUser sysUser = getModel(SysUser.class);
			SysUser ori = sysUserService.findByUserid(sysUser.getUserid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}

			sysUser.setCompanyId(admin.getCompanyId());
			sysUser.setActiveFlag(ori.getActiveFlag());
			result = sysUserService.update(sysUser);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除用户管理
	 */
	@RequestMapping("/inner/sysUser/delete")
	public void deleteSysUserById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser sysUser = getModel(SysUser.class);
			sysUserService.delete(sysUser.getUserid());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询全部用户管理
	 */
	@RequestMapping("/inner/sysUser/findAllSysUser")
	public void findAllSysUser(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<SysUser> sysUserList = sysUserService.findAll();
			result.getData().put("sysUserList", sysUserList);
			result.setMessage("findAll sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个用户管理
	 */
	@RequestMapping("/inner/sysUser/deleteIds")
	public void deleteSysUser(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("userid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				sysUserService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/sysUser/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			String ssorgid = request.getParameter("ssorgid");
			String s_role = request.getParameter("s_role");
			String roleType = request.getParameter("roleType");
			String showflag = request.getParameter("showflag");
			String roleYwType = request.getParameter("roleYwType");
			String companyId = admin.getCompanyId();
			if (UserEnums.RoleYwType.sys.toString().equals(roleYwType)) {
				companyId = "";
			}

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("orgid", admin.getOrgId());
			param.put("companyId", companyId);
			param.put("sorgid", ssorgid);
			param.put("s_role", s_role);
			param.put("roleType", roleType);
			param.put("showflag", showflag);
			param.put("roleYwType", roleYwType);
			PojoDomain<SysUser> list = sysUserService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 重置密码
	 */
	@RequestMapping("/inner/sysUser/resetPwd")
	public void resetPwd(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String userid = request.getParameter("userid");
			SysUser su = sysUserService.findByUserid(userid);
			if (su != null) {
				sysUserService.updatePwd(userid, EncryptUtil.defaultPwd);
				result.setMessage("resetPwd sysUser successs!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更新密码
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/sysUser/updatePwd")
	public void updatePwd(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String newPwd = request.getParameter("newPwd");
			String oldPwd = request.getParameter("oldPwd");
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysUser su = sysUserService.findByUserid(admin.getUserid());
			if (su.getPassword().equals(EncryptUtil.encryptPwd(oldPwd))) {
				admin.setPassword(EncryptUtil.encryptPwd(newPwd));
				sysUserService.updatePwd(admin.getUserid(), admin.getPassword());
			} else {
				result.setMessage("原密码错误");
				result.setCode("2001");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更新手机号码
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/sysUser/updateMobile")
	public void updateMobile(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String newPhone = request.getParameter("newPhone");
			String newPwd = request.getParameter("newPwd");
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysUser su = sysUserService.findByUserid(admin.getUserid());
			if (su.getPassword().equals(EncryptUtil.encryptPwd(newPwd))) {
				SysUser sUser = sysUserService.findByMobile(admin.getCompanyId(), newPhone);
				if (sUser == null) {
					sysUserService.updateMobile(admin.getUserid(), newPhone);
				} else {
					result.setMessage("此手机号已注册");
					result.setCode("4001");
				}

			} else {
				result.setMessage("密码错误");
				result.setCode("2001");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更新手机号码
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/sysUser/updateActiveFlag")
	public void updateActiveFlag(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String userid = request.getParameter("userid");
			SysUser su = sysUserService.findByUserid(userid);
			if (su != null) {
				int flag = Enums.Status.Enable.getValue();
				if (Enums.Status.Enable.getValue() == su.getActiveFlag()) {
					flag = Enums.Status.Unable.getValue();
				}
				su.setActiveFlag(flag);
				sysUserService.updateActiveFlag(su);
				result.setMessage("resetPwd sysUser successs!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}