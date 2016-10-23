package com.cjmei.module.system.sysrole.controller;

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

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysrole.service.SysRoleService;
import com.cjmei.module.system.sysuser.pojo.SysUser;

@Controller
public class SysRoleController extends SupportContorller{
    private static Logger logger = Logger.getLogger( SysRoleController.class);
    
    @Autowired
    private SysRoleService  sysRoleService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询角色管理
	 */
    @RequestMapping("/sysRole/findSysRoleById")
    public void findSysRoleById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    SysRole sysRole = getModel(SysRole.class);
			SysRole requestSysRole = sysRoleService.findById(sysRole.getRoleid());
			result.getData().put("sysRole",requestSysRole);
			result.setMessage("findById sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存角色管理
	 */
    @RequestMapping("/sysRole/save")
    public void saveSysRole(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	SysRole sysRole = getModel(SysRole.class);
	    	sysRole.setRoleid(IDUtil.getTimeID());
	    	sysRole.setCreator(admin.getUserid());
	    	sysRole.setCompanyId(admin.getCompanyId());
	 		SysRole ori=sysRoleService.findById(sysRole.getRoleid());
	 		if(ori==null){
	 			sysRoleService.save(sysRole);
	 			result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
	 		}else{
	    		result.setMessage("此记录已存在");
				result.setCode(Code.CODE_FAIL);
	    	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改角色管理
	 */
    @RequestMapping("/sysRole/update")
    public void updateSysRole(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    SysRole sysRole = getModel(SysRole.class);
		    SysRole ori=sysRoleService.findById(sysRole.getRoleid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	sysRoleService.update(sysRole);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
		    }
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除角色管理
	 */
    @RequestMapping("/sysRole/delete")
    public void deleteSysRoleById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	SysRole sysRole = getModel(SysRole.class);
			sysRoleService.delete(sysRole.getRoleid());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部角色管理
	 */
    @RequestMapping("/sysRole/findAllSysRole")
    public void findAllSysRole(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<SysRole> sysRoleList = sysRoleService.findAll();
			result.getData().put("sysRoleList",sysRoleList);
			result.setMessage("findAll sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个角色管理
	 */
	@RequestMapping("/sysRole/deleteIds")
	public void deleteSysRole(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("roleid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				sysRoleService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/sysRole/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<SysRole> list = sysRoleService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	@RequestMapping("/sysRole/funclist")
    public void funclist(HttpServletRequest request,HttpServletResponse response){
       Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			String roleId=request.getParameter("roleId");
			List<SysMenu> list=sysRoleService.funcList(admin,roleId);
			result.getData().put("funcList", list);
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	@RequestMapping("/sysRole/funcSave")
    public void funcSave(HttpServletRequest request,HttpServletResponse response){
       Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			String roleId=request.getParameter("roleId");
			String[] funcIds=request.getParameterValues("funcId");
			
			List<String> funcList=new ArrayList<String>();
			for(String funcId:funcIds){
				if(funcId !=null && funcId.length()>4){
					funcList.add(funcId);
				}
			}
			sysRoleService.saveSysFuncByRoleId(admin,roleId, funcList);
			result.setMessage("find sysRole successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find sysRole fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
}