package com.marks.module.org.orginfo.controller;

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
import com.marks.common.enums.OrgEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.org.orginfo.service.OrgInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

@Controller
public class OrgInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(OrgInfoController.class);

	@Autowired
	private OrgInfoService orgInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询机构管理
	 */
	@RequestMapping("/inner/orgInfo/findOrgInfoById")
	public void findOrgInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			OrgInfo orgInfo = getModel(OrgInfo.class);
			OrgInfo requestOrgInfo = orgInfoService.findById(orgInfo.getOrgid());
			result.getData().put("orgInfo", requestOrgInfo);
			result.setMessage("findById orgInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存机构管理
	 */
	@RequestMapping("/inner/orgInfo/save")
	public void saveOrgInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrgInfo orgInfo = getModel(OrgInfo.class);
			// orgInfo.setOrgid(IDUtil.getTimeID());
			OrgInfo ori = null;
			if (orgInfo.getLogoId() != null) {
				ori = orgInfoService.findById(orgInfo.getLogoId());
			}

			if (ori == null) {
				if (OrgEnums.OrgType.company.getValue() == orgInfo.getOrgType()) {
					String orgId = orgInfoService.getCompanyId();
					orgInfo.setOrgid(orgId);
					orgInfo.setOrgCategory(OrgEnums.OrgCategory.company.getValue());
				} else {
					if ("top".equals(orgInfo.getParentId())) {
						orgInfo.setParentId(admin.getCompanyId());
					}
					String orgId = orgInfoService.getOrgId();
					orgInfo.setOrgid(orgId);
					orgInfo.setOrgCategory(OrgEnums.OrgCategory.dept.getValue());
				}
				orgInfo.setCompanyId(admin.getCompanyId());
				orgInfo.setCreator(admin.getUsername());
				orgInfoService.save(orgInfo);
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
	 * 更改机构管理
	 */
	@RequestMapping("/inner/orgInfo/update")
	public void updateOrgInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrgInfo orgInfo = getModel(OrgInfo.class);
			OrgInfo ori = orgInfoService.findById(orgInfo.getOrgid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			if (OrgEnums.OrgType.company.getValue() != orgInfo.getOrgType() && ori.getChildnum() > 0
					&& !ori.getParentId().equals(orgInfo.getParentId())) {
				result.setMessage("此记录下有子节点不能更换父节点!");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			if ("top".equals(orgInfo.getParentId())) {
				orgInfo.setParentId(admin.getCompanyId());
			}
			orgInfoService.update(orgInfo);
			result.setMessage("更新成功!");
			result.setCode(Code.CODE_SUCCESS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除机构管理
	 */
	@RequestMapping("/inner/orgInfo/delete")
	public void deleteOrgInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			OrgInfo orgInfo = getModel(OrgInfo.class);
			List<OrgInfo> list = orgInfoService.getChildList(orgInfo.getOrgid());
			if (list != null && list.size() > 0) {
				result.setMessage("含子节点不能删除!");
				result.setCode("2001");
			} else {
				orgInfoService.delete(orgInfo.getOrgid());
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String parentId = request.getParameter("parentId");
		String orgType = request.getParameter("orgType");
		logger.info("list parentId:" + parentId);
		String companyId = admin.getCompanyId();
		logger.info("list companyId:" + companyId);
		List<OrgInfo> list = null;

		// 根节点加载
		if (parentId == null || "".equals(parentId)) {
			parentId = admin.getCompanyId();
		}
		String useFlag = "";
		logger.info("list parentId:" + parentId + " - " + admin.getCompanyId());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		params.put("companyId", companyId);
		params.put("orgType", orgType);
		params.put("useFlag", useFlag);
		list = orgInfoService.listGrid(params);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
		return;
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/treebox")
	public void treebox(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String parentId = request.getParameter("parentId");
		String orgType = request.getParameter("orgType");
		logger.info("list parentId:" + parentId);
		String companyId = admin.getCompanyId();
		logger.info("list companyId:" + companyId);
		List<OrgInfo> list = null;

		// 根节点加载
		if (parentId == null || "".equals(parentId)) {
			parentId = admin.getCompanyId();
		}
		String useFlag = "1";
		logger.info("list parentId:" + parentId + " - " + admin.getCompanyId() + " - " + orgType + " - ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", parentId);
		params.put("companyId", companyId);
		params.put("orgType", orgType);
		params.put("useFlag", useFlag);
		list = orgInfoService.listGrid(params);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
		return;
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/tree")
	public void tree(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String orgType = request.getParameter("orgType");
		List<OrgInfo> list = orgInfoService.list(admin, orgType);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/framelist")
	public void framelist(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", null);
			PojoDomain<OrgInfo> list = orgInfoService.framelist(page_number, page_size, param);
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

	@RequestMapping("/inner/orgInfo/combo")
	public void combo(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		Map<String, Object> param = new HashMap<String, Object>();
		String companyId = admin.getCompanyId();
		param.put("companyId", companyId);
		List<OrgInfo> list = orgInfoService.frameCombo(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	/**
	 * 根据不同的机构类型查询组织
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/orgInfo/listByOrgType")
	public void listByOrgType(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = IStringUtil.getUTF8(request.getParameter("keyword"));
			String orgType = request.getParameter("orgType");

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			param.put("orgType", orgType);
			PojoDomain<OrgInfo> list = orgInfoService.listByOrgType(page_number, page_size, param);
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
}