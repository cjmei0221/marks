package com.marks.module.inner.org.orginfo.controller;

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
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.org.orginfo.pojo.OrgInfo;
import com.marks.module.inner.org.orginfo.service.OrgInfoService;
import com.marks.module.inner.system.sys.controller.SupportContorller;
import com.marks.module.inner.user.login.helper.SysUserHelper;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.sys.system.core.data.StaticData;

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
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			OrgInfo orgInfo = getModel(OrgInfo.class);
			// orgInfo.setOrgid(IDUtil.getTimeID());
			OrgInfo ori = null;
			if(orgInfo.getLogoId() !=null){
				ori = orgInfoService.findById(orgInfo.getLogoId());
			}
			
			if (ori == null) {
				String orgId=orgInfoService.getOrgId();
				orgInfo.setOrgid(orgId);
				if (Enums.OrgType.company.getValue() == orgInfo.getOrgType()) {
					orgInfo.setParentId("0");
					orgInfo.setCompanyId(orgInfo.getOrgid());
					orgInfo.setLvl(1);
				} else {
					OrgInfo parentVo = orgInfoService.findById(orgInfo.getParentId());
					orgInfo.setLvl(parentVo.getLvl() + 1);
					orgInfo.setCompanyId(parentVo.getCompanyId());
				}
				orgInfo.setCreator(admin.getUserid());
				StaticData.putOrgInfo(orgInfo);
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
			OrgInfo orgInfo = getModel(OrgInfo.class);
			OrgInfo ori = orgInfoService.findById(orgInfo.getOrgid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				if (Enums.OrgType.company.getValue() == orgInfo.getOrgType()) {
					orgInfo.setParentId("0");
					orgInfo.setLvl(1);
				} else {
					OrgInfo parentVo = orgInfoService.findById(orgInfo.getParentId());
					orgInfo.setLvl(parentVo.getLvl() + 1);
				}
				StaticData.putOrgInfo(orgInfo);
				orgInfoService.update(orgInfo);
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
	 * 查询全部机构管理
	 */
	@RequestMapping("/inner/orgInfo/findAllOrgInfo")
	public void findAllOrgInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<OrgInfo> orgInfoList = orgInfoService.findAll();
			result.getData().put("orgInfoList", orgInfoList);
			result.setMessage("findAll orgInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll orgInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个机构管理
	 */
	@RequestMapping("/inner/orgInfo/deleteIds")
	public void deleteOrgInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("orgid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				orgInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete orgInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = SysUserHelper.getCurrentUserInfo(request);

		List<String> plist = new ArrayList<String>();
		String parentId = request.getParameter("parentId");
		String companyId = request.getParameter("companyId");
		List<OrgInfo> list = null;
		
		//根节点加载
		if (parentId == null || "".equals(parentId)) {
			if (null == admin.getCompanyId()) {
				List<OrgInfo> s = admin.getOrgInfoList();
				plist.add(s.get(0).getParentId());
				
				if(null == companyId){
					list = orgInfoService.listGrid(plist, admin.getCompanyId());
				}else{
					list = orgInfoService.listGrid(plist, companyId);
				}
				
			} else {
				list = admin.getOrgInfoList();
				for (OrgInfo info : list) {
					if (info.getChildnum() > 0) {
						info.setState("closed");
					}
				}
			}
		} else {//非根节点
			plist.add(parentId);
			list = orgInfoService.listGrid(plist, admin.getCompanyId());
			
		}
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
		return;
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/tree")
	public void tree(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		List<OrgInfo> list = orgInfoService.list(admin);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/orgInfo/framelist")
	public void framelist(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
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
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		Map<String, Object> param = new HashMap<String, Object>();
		String companyId = admin.getCompanyId();
		param.put("companyId", companyId);
		List<OrgInfo> list = orgInfoService.frameCombo(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}
}