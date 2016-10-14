package com.cjmei.module.system.sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysRole;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sys.service.SysRoleService;

@Controller
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/sys/role/list")
	public void getSysRoleList(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		int page_number = Integer.parseInt(request.getParameter("page_number"));
		int page_size = Integer.parseInt(request.getParameter("page_size"));
		String keyword=request.getParameter("keyword");
		PojoDomain<SysRole> list = sysRoleService.querySysRoleList(admin,page_number,page_size,keyword);
		result.getData().put("list", list.getPojolist());
		result.getData().put("loginUserLvl", admin.getRole().getLvl());
		result.setPageNumber(list.getPage_number());
		result.setPageSize(list.getPage_size());
		result.setPageTotal(list.getPage_total());
		result.setTotalCount(list.getTotal_count());
		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/role/save")
	public void saveSysRole(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		
		SysRole sysRole = new SysRole();
		sysRole.setRoleid(request.getParameter("roleid"));
		sysRole.setRolename(request.getParameter("rolename"));
		sysRole.setCreator(admin.getUserid());
		if(admin.getRole().getLvl()==0){
			sysRole.setLvl(Integer.parseInt(request.getParameter("lvlEdit")));
			if(sysRole.getLvl()==0){
				sysRole.setOrgid(null);
			}else if(sysRole.getLvl()==1){
				sysRole.setOrgid(request.getParameter("companyPut"));
			}else if(sysRole.getLvl()==2){
				sysRole.setOrgid(request.getParameter("shopPut"));
			}else{
				sysRole.setOrgid(request.getParameter("shopPut"));
			}
		}else if(admin.getRole().getLvl()==1){
			sysRole.setLvl(Integer.parseInt(request.getParameter("lvlEdit")));
			if(sysRole.getLvl()==1){
				sysRole.setOrgid(admin.getOrgid());
			}else{
				sysRole.setOrgid(request.getParameter("shopPut"));
			}
		}else{
			sysRole.setLvl(admin.getRole().getLvl()+1);
			sysRole.setOrgid(admin.getOrgid());
		}
		String formStatus=request.getParameter("formStatus");
		if("new".equals(formStatus)){
			sysRole.setRoleid(IDUtil.getTimeID());
			sysRoleService.saveSysRole(sysRole);
		}else{
			sysRoleService.updateSysRole(sysRole);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/role/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		String roleId = request.getParameter("roleid");
		if (null != roleId && !"".equals(roleId)) {
			SysRole role = sysRoleService.getNeedDeleteSysRoleByRoleid(roleId);
			if (null != role) {
				result.setCode(3);
				result.setMessage("该角色下有用户，不能删除");
			} else {
				result.setCode(0);
				sysRoleService.deleteSysRole(roleId);
			}
		} else {
			result.setCode(2);//
			result.setMessage("参数有误");
		}

		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/role/oper/list")
	public void getSysRoleOper(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		String roleid = request.getParameter("roleid");
		String userRoleid =admin.getRoleid();
		if(admin.getRole().getLvl()==0){
			userRoleid=null;
		}
		List<SysMenu> menu_list = sysRoleService.getSysFuncTree(userRoleid, roleid);
		result.getData().put("menu_list", menu_list);
		JsonUtil.output(response, result);
	}

	@RequestMapping("/sys/role/oper/save")
	public void saveSysFunc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String roleId = request.getParameter("roleid");
		String[] funcId_str_ary = request.getParameterValues("funcid");
		List<String> funcIds = new ArrayList<String>();
		if (funcId_str_ary != null) {
			for (String funcId : funcId_str_ary)
				funcIds.add(funcId);
		}
		sysRoleService.saveSysFuncByRoleId(roleId, funcIds);
		JsonUtil.output(response, result);
	}
	
	
}
