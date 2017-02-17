package com.cjmei.module.system.sys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysFunc;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.service.SysMenuService;
import com.cjmei.module.system.sysuser.pojo.SysUser;

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
	private final static Logger log = Logger.getLogger(SysMenuController.class);
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
			sm.setUrl(request.getParameter("urlPut"));
			sm.setCreatetime(new Date());
			sm.setCreator(user.getUsername());
			sm.setUpdatetime(new Date());
			sysMenuService.save(sm);
			result.getData().put("menu", sm);
		}else{//修改
			String menuid=request.getParameter("menuid");
			SysMenu sm=sysMenuService.getSysMenuByMenuid(menuid);
			if(null !=sm){
				sm.setMenuitem(request.getParameter("menuitemPut"));
				sm.setParentid(request.getParameter("parentidPut"));
				sm.setSort(Integer.parseInt(request.getParameter("sortPut")));
				sm.setUrl(request.getParameter("urlPut"));
				sm.setCreator(user.getUsername());
				sm.setUpdatetime(new Date());
				sysMenuService.update(sm);
				result.getData().put("menu", sm);
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
		String menuid=request.getParameter("id");
		sysMenuService.delete(menuid,result);
		JsonUtil.output(response, result);
	}
	
	@RequestMapping("/sysMenu/initFunc")
	public void initFunc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		try {
			String menuid = request.getParameter("menuid");

			if (null == menuid || "".equals(menuid)) {
				result.setCode(1);
				result.setMessage("菜单ID為空");
			} else {
				List<SysOperate> list = sysMenuService.getSysOperateListByMenuid(menuid);

				List<SysOperate> alllist = sysMenuService.getSysOperateList();
				result.setCode(0);
				result.getData().put("list", list);
				result.getData().put("operatelist", alllist);
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(-1);
			result.setMessage("系统错误");
		}

		JsonUtil.output(response, result);
	}
	/**
	 * 删除菜单功能
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/sysMenu/deleteFunc")
	public void deleteFunc(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String funcid = request.getParameter("funcid");

			if (null == funcid || "".equals(funcid)) {
				result.setCode(1);
				result.setMessage("功能ID为空");
			} else {
				sysMenuService.deleteFunc(funcid);
				result.setCode(0);
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(-1);
			result.setMessage("系统错误");
		}

		JsonUtil.output(response, result);
	}

	@RequestMapping("/sysMenu/addFunc")
	public void addFunc(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String operid = request.getParameter("operid");
			String menuid = request.getParameter("menuid");
			String url=request.getParameter("funcurl");
			if (null == menuid || "".equals(menuid)) {
				result.setCode(1);
				result.setMessage("菜单ID為空");
			} else {
				int idx=url.indexOf(".");
				if(idx>0){
					url=url.substring(0, idx);
				}
				SysFunc sf = sysMenuService.getSysFuncByOperIdAndMenuid(menuid, operid);
				if (sf != null) {
					result.setCode(2);
					result.setMessage("此功能已存在");
				} else {
					SysUser user=SysUserHelper.getCurrentUserInfo(request);
					SysOperate oper = sysMenuService.saveFunc(operid, menuid,url);
					oper.setCreator(user.getUsername());
					result.setCode(0);
					result.getData().put("operObj", oper);
				}
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(-1);
			result.setMessage("系统错误");
		}
		JsonUtil.output(response, result);
	}
}