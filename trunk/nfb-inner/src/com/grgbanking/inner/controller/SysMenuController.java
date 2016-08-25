package com.grgbanking.inner.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grgbanking.inner.helper.SysUserHelper;
import com.grgbanking.inner.po.domain.Result;
import com.grgbanking.inner.po.sys.SysMenu;
import com.grgbanking.inner.po.sys.SysUser;
import com.grgbanking.inner.service.SysMenuService;
import com.grgbanking.inner.util.IDUtil;
import com.grgbanking.inner.util.JsonUtil;

/**
 * 系统菜单控制层 File Name: com.grgbanking.inner.controller.SysMenuController.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月29日下午3:58:06
 * @see (optional)
 * @Copyright (c) 2016, cjmei All Rights Reserved.
 */
@Controller
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 系统菜单列表
	 * list:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysMenu/list")
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		List<SysMenu> list=sysMenuService.getSysMenuList();
		result.setCode(0);
		result.setMessage("success");
		result.getData().put("menuList", list);
		JsonUtil.output(response, result);
	}
	/**
	 * 父菜单下拉框
	 * parentMenu:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysMenu/parentMenu")
	public void parentMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		List<SysMenu> returnlist=sysMenuService.getParentSysMenuList();
		SysMenu p=new SysMenu();
		p.setMenuid("0");
		p.setMenuitem("一级菜单选项");
		returnlist.add(p);
		result.setCode(0);
		result.setMessage("success");
		result.getData().put("list", returnlist);
		JsonUtil.output(response, result);
	}
	
	/**
	 * 父菜单下拉框
	 * parentMenu:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysMenu/save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(0);
		result.setMessage("sucess");
		String formStatus=request.getParameter("formStatus");
		SysUser user=SysUserHelper.getCurrentUserInfo(request);
		if("new".equals(formStatus)){
			SysMenu sm=new SysMenu();
			sm.setMenuid(IDUtil.getTimeID());
			sm.setMenuitem(request.getParameter("menuitemPut"));
			sm.setParentid(request.getParameter("parentidPut"));
			sm.setSort(Integer.parseInt(request.getParameter("sortPut")));
			sm.setCreatetime(new Date());
			sm.setCreator(user.getUsername());
			sm.setUpdatetime(new Date());
			sysMenuService.save(sm);
			result.getData().put("menuid", sm.getMenuid());
		}else{//修改
			String menuid=request.getParameter("menuid");
			SysMenu sm=sysMenuService.getSysMenuByMenuid(menuid);
			if(null !=sm){
				sm.setMenuitem(request.getParameter("menuitemPut"));
				sm.setParentid(request.getParameter("parentidPut"));
				sm.setSort(Integer.parseInt(request.getParameter("sortPut")));
				sm.setCreator(user.getUsername());
				sm.setUpdatetime(new Date());
				sysMenuService.update(sm);
			}else{
				result.setCode(4001);
				result.setMessage("该菜单已删除");
			}
		}
		JsonUtil.output(response, result);
	}
	/**
	 * 删除菜单 若有子菜单，则不能删除
	 * delete:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysMenu/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(0);
		result.setMessage("success");
		String menuid=request.getParameter("menuid");
		result=sysMenuService.delete(menuid,result);
		JsonUtil.output(response, result);
	}
}
