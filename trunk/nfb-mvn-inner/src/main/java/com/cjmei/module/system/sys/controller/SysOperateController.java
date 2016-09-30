package com.cjmei.module.system.sys.controller;

import java.util.Date;

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
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sys.service.SysOperateService;

/**
 * 系统菜单控制层 File Name: com.grgbanking.inner.controller.SysMenuController.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月29日下午3:58:06
 * @see (optional)
 * @Copyright (c) 2016, cjmei All Rights Reserved.
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
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysOperate/list")
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
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysOperate/save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(0);
		result.setMessage("sucess");
		String formStatus = request.getParameter("formStatus");
		SysUser user = SysUserHelper.getCurrentUserInfo(request);
		if ("new".equals(formStatus)) {
			SysOperate info = new SysOperate();
			info.setOperid(IDUtil.getUUID());
			info.setOperkey(request.getParameter("operkey"));
			info.setOpername(request.getParameter("opername"));
			info.setPicicon(request.getParameter("picicon"));
			info.setSort(Integer.parseInt(request.getParameter("sort")));
			info.setCreatetime(new Date());
			info.setCreator(user.getUsername());
			info.setUpdatetime(new Date());
			sysOperateService.save(info);
		} else {// 修改
			String operid = request.getParameter("operid");
			SysOperate info = sysOperateService.getObjectById(operid);
			if (null != info) {
				info.setOperkey(request.getParameter("operkey"));
				info.setOpername(request.getParameter("opername"));
				info.setPicicon(request.getParameter("picicon"));
				info.setSort(Integer.parseInt(request.getParameter("sort")));
				info.setCreator(user.getUsername());
				info.setUpdatetime(new Date());
				sysOperateService.update(info);
			} else {
				result.setCode(4001);
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
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/sysOperate/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		result.setCode(0);
		result.setMessage("success");
		String id = request.getParameter("id");
		sysOperateService.delete(result, id);
		JsonUtil.output(response, result);
	}

}
