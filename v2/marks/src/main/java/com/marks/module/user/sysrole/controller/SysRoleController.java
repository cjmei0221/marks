package com.marks.module.user.sysrole.controller;


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
import com.marks.common.domain.TreeVo;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.system.sysmenu.pojo.SysMenu;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysrole.pojo.SysRole;
import com.marks.module.user.sysrole.service.SysRoleService;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

@Controller
public class SysRoleController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SysRoleController.class);

	@Autowired
	private SysRoleService sysRoleService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询角色管理
	 */
	@RequestMapping("/inner/sysRole/findSysRoleById")
	public void findSysRoleById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysRole sysRole = getModel(SysRole.class);
			SysRole requestSysRole = sysRoleService.findById(sysRole.getRoleid());
			result.getData().put("sysRole", requestSysRole);
			result.setMessage("findById sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存角色管理
	 */
	@RequestMapping("/inner/sysRole/save")
	public void saveSysRole(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			SysRole sysRole = getModel(SysRole.class);
			sysRole.setCreator(admin.getUserid());
			sysRole.setCompanyId(admin.getCompanyId());
			SysRole ori = sysRoleService.findByUserTypeAndCompanyId(sysRole.getUserType(), sysRole.getCompanyId());
			if (ori == null) {
				sysRole.setRoleid(sysRole.getCompanyId() + "_" + sysRole.getUserType());
				sysRoleService.save(sysRole);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此记录已存在");
				result.setCode(Code.CODE_FAIL);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改角色管理
	 */
	@RequestMapping("/inner/sysRole/update")
	public void updateSysRole(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			SysRole sysRole = getModel(SysRole.class);
			sysRole.setCompanyId(admin.getCompanyId());
			if ("system".equals(sysRole.getRoleid())) {
				result.setMessage("此记录不可编辑!");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			SysRole ori = sysRoleService.findById(sysRole.getRoleid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			SysRole ori2 = sysRoleService.findByUserTypeAndCompanyId(sysRole.getUserType(), sysRole.getCompanyId());
			if (ori2 != null && !ori2.getRoleid().equals(sysRole.getRoleid())) {
				result.setMessage("此记录已存在!");
				result.setCode(Code.CODE_FAIL);
			} else {
				sysRoleService.update(sysRole);
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

	/**
	 * 删除角色管理
	 */
	@RequestMapping("/inner/sysRole/delete")
	public void deleteSysRoleById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysRole sysRole = getModel(SysRole.class);
			SysRole ori = sysRoleService.findById(sysRole.getRoleid());
			if (ori != null && ori.getDelFlag() == 0) {
				result.setMessage("该角色不可删除!");
				result.setCode("3");
				JsonUtil.output(response, result);
				return;
			}
			if (sysRoleService.isDelete(sysRole.getRoleid())) {
				sysRoleService.delete(sysRole.getRoleid());
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("该角色下有用户不能删除!");
				result.setCode("2");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询全部角色管理
	 */
	@RequestMapping("/inner/sysRole/findAllSysRole")
	public void findAllSysRole(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<SysRole> sysRoleList = sysRoleService.findAll();
			result.getData().put("sysRoleList", sysRoleList);
			result.setMessage("findAll sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个角色管理
	 */
	@RequestMapping("/inner/sysRole/deleteIds")
	public void deleteSysRole(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("roleid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				sysRoleService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/sysRole/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			String s_lvl = request.getParameter("s_lvl");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("s_lvl", s_lvl);
			param.put("companyId", admin.getCompanyId());
			param.put("lvl", admin.getRoleLvl());
			PojoDomain<SysRole> list = sysRoleService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sysRole/funclist")
	public void funclist(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			String roleId = request.getParameter("roleId");
			List<SysMenu> list = sysRoleService.funcList(admin, roleId);
			result.getData().put("funcList", list);
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sysRole/funcSave")
	public void funcSave(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			String roleId = request.getParameter("roleId");
			String[] funcIds = request.getParameterValues("funcId");

			List<String> funcList = new ArrayList<String>();
			for (String funcId : funcIds) {
				if (funcId != null && !"".equals(funcId)) {
					funcList.add(funcId);
				}
			}
			sysRoleService.saveSysFuncByRoleId(admin, roleId, funcList);
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sysRole/lvl")
	public void combox(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = ManageUtil.getCurrentUserInfo(request);
		int lvl = admin.getRoleLvl();
		List<TreeVo> list = new ArrayList<TreeVo>();
		TreeVo vo = null;
		for (int i = lvl; i < 10; i++) {
			vo = new TreeVo();
			vo.setId(i + "");
			vo.setText("L" + i);
			list.add(vo);
		}
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	@RequestMapping("/inner/sysRole/combo")
	public void combo(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = ManageUtil.getCurrentUserInfo(request);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("companyId", admin.getCompanyId());
		param.put("lvl", admin.getRoleLvl());
		List<SysRole> list = sysRoleService.getUserlist(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}
}