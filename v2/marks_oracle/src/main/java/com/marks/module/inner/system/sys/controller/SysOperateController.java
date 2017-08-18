package com.marks.module.inner.system.sys.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.PaginationResult;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.system.sys.pojo.SysOperate;
import com.marks.module.inner.system.sys.service.SysOperateService;
import com.marks.module.inner.user.login.helper.SysUserHelper;
import com.marks.module.inner.user.sysuser.pojo.SysUser;

/**
 * 系统菜单控制层 File Name: com.grgbanking.inner.controller.SysMenuController.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月29日下午3:58:06
 * @see (optional)
 * @Copyright (c) 2016, marks All Rights Reserved.
 */
@Controller
public class SysOperateController {
	@Autowired
	private SysOperateService sysOperateService;

	/**
	 * 系统菜单列表 list:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysOperate/list")
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PaginationResult result = new PaginationResult();
		String keyword = request.getParameter("keyword");
		int page_number = Integer.parseInt(request.getParameter("page_number"));
		int page_size = Integer.parseInt(request.getParameter("page_size"));
		PojoDomain<SysOperate> list = sysOperateService.list(page_number, page_size, keyword);
		result.getData().put("list", list.getPojolist());
		result.setPageNumber(list.getPage_number());
		result.setPageSize(list.getPage_size());
		result.setPageTotal(list.getPage_total());
		result.setTotalCount(list.getTotal_count());
		JsonUtil.output(response, result);
	}

	/**
	 * 父菜单下拉框 parentMenu:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysOperate/save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("sucess");
		String formStatus = request.getParameter("formStatus");
		SysUser user = SysUserHelper.getCurrentUserInfo(request);
		String operid = request.getParameter("operid");
		SysOperate info = sysOperateService.getObjectById(operid);
		if ("new".equals(formStatus)) {
			if(info==null){
				info = new SysOperate();
				info.setOperid(operid);
				info.setOpername(request.getParameter("opername"));
				info.setPicicon(request.getParameter("picicon"));
				info.setSort(Integer.parseInt(request.getParameter("sort")));
				info.setCreatetime(new Date());
				info.setCreator(user.getUsername());
				info.setUpdatetime(new Date());
				sysOperateService.save(info);
			}else{
				result.setCode("4002");
				result.setMessage("已存在");
			}	
		} else {// 修改
			if (null != info) {
				info.setOpername(request.getParameter("opername"));
				info.setPicicon(request.getParameter("picicon"));
				info.setSort(Integer.parseInt(request.getParameter("sort")));
				info.setCreator(user.getUsername());
				info.setUpdatetime(new Date());
				sysOperateService.update(info);
			} else {
				result.setCode("4001");
				result.setMessage("已删除");
			}
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除菜单 若有子菜单，则不能删除 delete:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/sysOperate/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		String id = request.getParameter("id");
		sysOperateService.delete(result, id);
		JsonUtil.output(response, result);
	}

}
