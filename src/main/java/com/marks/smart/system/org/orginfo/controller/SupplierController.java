package com.marks.smart.system.org.orginfo.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.org.orginfo.pojo.OrgInfo;
import com.marks.smart.system.org.orginfo.service.OrgInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 供应商管理: 供应商管理
 */
@Controller
public class SupplierController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SupplierController.class);
	@Autowired
	private OrgInfoService orgInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询供应商管理
	 */
	@RequestMapping("/inner/supplier/findById")
	public void findSupplierById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			OrgInfo reqVo = getModel(OrgInfo.class);

			logger.info("findSupplierById > param>" + reqVo.getOrgid());

			OrgInfo info = orgInfoService.findById(reqVo.getOrgid());
			result.getData().put("info", info);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存供应商管理
	 */
	@RequestMapping("/inner/supplier/save")
	public void saveSupplier(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrgInfo org = getModel(OrgInfo.class);
			org.setCompanyId(admin.getCompanyId());
			org.setCreator(admin.getUserCode());
			org.setLvl(2);
			org.setOrgType(OrgEnums.OrgType.supplier.getValue());
			org.setParentId(admin.getCompanyId());
			org.setOrgCategory(OrgEnums.OrgCategory.supplier.getValue());
			String orgid = orgInfoService.save(org);
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改供应商管理
	 */
	@RequestMapping("/inner/supplier/update")
	public void updateSupplier(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrgInfo org = getModel(OrgInfo.class);
			org.setCompanyId(admin.getCompanyId());

			OrgInfo ori = orgInfoService.findById(org.getOrgid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				org.setCompanyId(admin.getCompanyId());
				org.setCreator(admin.getOperator());
				org.setLvl(2);
				org.setOrgType(OrgEnums.OrgType.supplier.getValue());
				org.setParentId(admin.getCompanyId());
				orgInfoService.update(org);
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
	 * 删除供应商管理
	 */
	@RequestMapping("/inner/supplier/delete")
	public void deleteSupplierById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			OrgInfo reqVo = getModel(OrgInfo.class);
			orgInfoService.delete(reqVo.getOrgid());
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
	 * 查询全部供应商管理
	 */
	/**
	 * 查询全部品牌管理
	 */

	@RequestMapping("/inner/supplier/combobox")
	public void findAllBrand(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("companyId", admin.getCompanyId());
		param.put("orgType", OrgEnums.OrgType.supplier.getValue());
		param.put("orgCategory", OrgEnums.OrgCategory.supplier.getValue());
		List<OrgInfo> allList = orgInfoService.frameCombo(param);

		JsonUtil.output(response, JSONArray.fromObject(allList).toString());
	}
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/supplier/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			param.put("orgCategory", OrgEnums.OrgCategory.supplier.getValue());
			PojoDomain<OrgInfo> list = orgInfoService.framelist(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find supplier successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find supplier fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}