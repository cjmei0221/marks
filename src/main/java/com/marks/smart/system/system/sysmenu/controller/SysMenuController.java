package com.marks.smart.system.system.sysmenu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.Constants;
import com.marks.common.util.JsonUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.system.sysmenu.pojo.SysFunc;
import com.marks.smart.system.system.sysmenu.pojo.SysMenu;
import com.marks.smart.system.system.sysmenu.pojo.SysOperate;
import com.marks.smart.system.system.sysmenu.service.SysMenuService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 系统菜单控制层 File Name: com.grgbanking.inner.controller.SysMenuController.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月29日下午3:58:06
 * @see (optional)
 * @Copyright (c) 2016, marks All Rights Reserved.
 */
@Controller
public class SysMenuController extends SupportContorller {
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
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysMenu/list")
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String parentId = request.getParameter("parentId");
		if (null == parentId || "".equals(parentId)) {
			parentId = Constants.top_parent_id;
		}
		List<SysMenu> list = sysMenuService.listTree(parentId);
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		result.getData().put("menuList", list);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
		return;
	}
	/**
	 * 父菜单下拉框
	 * parentMenu:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysMenu/parentMenu")
	public void parentMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String parentId = request.getParameter("parentId");
		if (parentId == null || "".equals(parentId)) {
			return;
		}
		List<SysMenu> returnlist = sysMenuService.getChildListByParentid(parentId);
		JsonUtil.output(response, JSONArray.fromObject(returnlist).toString());
	}
	
	/**
	 * 父菜单下拉框
	 * parentMenu:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysMenu/save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("sucess");
		String formStatus=request.getParameter("formStatus");
		SysUser user = LoginUtil.getInstance().getCurrentUser(request);
		SysMenu sm = getModel(SysMenu.class);
		if (sm.getLvl() == 1) {
			sm.setParentid(Constants.top_parent_id);
		} else if (sm.getLvl() == 2) {
			sm.setParentid(sm.getLvl1Menuid());
		} else if (sm.getLvl() == 3) {
			sm.setParentid(sm.getLvl2Menuid());
		}
		sm.setMenuid(sm.getMenuid().toUpperCase());
		if("new".equals(formStatus)){	
			SysMenu old = sysMenuService.getSysMenuByMenuid(sm.getMenuid());
			if(old != null) {
				result.setCode("4002");
				result.setMessage("该菜单编号已存在");
				JsonUtil.output(response, result);
				return;
			}
//			sm.setMenuid("M_" + IDUtil.getDateID() + "_" + IDUtil.getID(8));
			sm.setCreatetime(new Date());
			sm.setCreator(user.getOperator());
			sm.setUpdatetime(new Date());
			sysMenuService.save(sm);
			result.getData().put("menu", sm);
		} else {// 修改
			SysMenu old = sysMenuService.getSysMenuByMenuid(sm.getMenuid());
			if (null != old) {
				sm.setCreator(user.getUsername());
				sm.setUpdatetime(new Date());
				sysMenuService.update(sm);
				result.getData().put("menu", sm);
			}else{
				result.setCode("4001");
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
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysMenu/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		String menuid=request.getParameter("id");
		sysMenuService.delete(menuid,result);
		JsonUtil.output(response, result);
	}
	
	@RequestMapping("/inner/sysMenu/initFunc")
	public void initFunc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		try {
			String menuid = request.getParameter("menuid");

			if (null == menuid || "".equals(menuid)) {
				result.setCode("1");
				result.setMessage("菜单ID為空");
			} else {
				List<SysOperate> list = sysMenuService.getSysOperateListByMenuid(menuid);

				List<SysOperate> alllist = sysMenuService.getSysOperateList();
				result.setCode(Code.CODE_SUCCESS);
				result.getData().put("list", list);
				result.getData().put("operatelist", alllist);
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(Code.CODE_FAIL);
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
	@RequestMapping("/inner/sysMenu/deleteFunc")
	public void deleteFunc(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String funcid = request.getParameter("funcid");

			if (null == funcid || "".equals(funcid)) {
				result.setCode("1");
				result.setMessage("功能ID为空");
			} else {
				sysMenuService.deleteFunc(funcid);
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统错误");
		}

		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sysMenu/addFunc")
	public void addFunc(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String operid = request.getParameter("operid");
			String menuid = request.getParameter("menuid");
			String url=request.getParameter("funcurl");
			if (null == menuid || "".equals(menuid)) {
				result.setCode("1");
				result.setMessage("菜单ID為空");
			} else {
				int idx=url.indexOf(".");
				if(idx>0){
					url=url.substring(0, idx);
				}
				SysFunc sf = sysMenuService.getSysFuncByOperIdAndMenuid(menuid, operid);
				if (sf != null) {
					result.setCode("2");
					result.setMessage("此功能已存在");
				} else {
					SysUser user = LoginUtil.getInstance().getCurrentUser(request);
					SysOperate oper = sysMenuService.saveFunc(operid, menuid,url);
					oper.setCreator(user.getOperator());
					result.setCode(Code.CODE_SUCCESS);
					result.getData().put("operObj", oper);
				}
			}
		} catch (Exception e) {
			log.error("Exception:", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统错误");
		}
		JsonUtil.output(response, result);
	}

	@Override
	public Logger getLogger() {
		return log;
	}
}
