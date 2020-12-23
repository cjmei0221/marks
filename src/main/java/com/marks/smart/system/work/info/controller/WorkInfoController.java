package com.marks.smart.system.work.info.controller;

import java.util.HashMap;
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
import com.marks.common.util.Constants;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.work.info.pojo.WorkFlow;
import com.marks.smart.system.work.info.pojo.WorkInfo;
import com.marks.smart.system.work.info.pojo.WorkStep;
import com.marks.smart.system.work.info.service.WorkInfoService;

/**
 * 工作流查询: 工作流查询
 */
@Controller
public class WorkInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WorkInfoController.class);

	@Autowired
	private WorkInfoService workInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询工作流查询
	 */
	@RequestMapping("/inner/workInfo/findById")
	public void findWorkInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WorkInfo info = getModel(WorkInfo.class);

			logger.info("findWorkInfoById > param>" + info.getWorkId());

			WorkInfo vo = workInfoService.findById(info.getWorkId());
			result.getData().put("info", vo);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	@RequestMapping("/inner/workInfo/check")
	public void check(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String typeCode=request.getParameter("typeCode");
		boolean isCheck = workInfoService.check(admin.getCompanyId(),typeCode);
		if(!isCheck) {
			result.setCode("4001");
			result.setMessage("无需审核");
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 保存工作流查询
	 */
	@RequestMapping("/inner/workInfo/apply")
	public void apply(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			WorkFlow work = new WorkFlow();
			work.setApplyMan(admin.getUsername());
			work.setApplyManId(admin.getUserid());
			work.setApplyOrgId(admin.getOrgId());
			work.setApplyOrgName(admin.getOrgName());
			work.setApplyRoleId(admin.getRoleId());
			work.setApplyRoleName(admin.getRoleName());
			work.setCompanyId(admin.getCompanyId());
			work.setIdNo(request.getParameter("idNo"));
			work.setRemarks(request.getParameter("remarks"));
			work.setTypeCode(request.getParameter("typeCode"));
			work.setCheckerId(request.getParameter("userid"));
			boolean isCheck = workInfoService.save(work);
			String checkStatus=Enums.CheckStatus.checkOk.toString();
			if (isCheck) {
				checkStatus=Enums.CheckStatus.checking.getValue() + "";
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("idNo", request.getParameter("idNo"));
			map.put("checkStatus", checkStatus);
			map.put("checkerId", admin.getUserCode());
			map.put("checker", admin.getUsername());
			map.put("companyId", admin.getCompanyId());
			workInfoService.updateTargetCheckStatus(work,map);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存工作流查询
	 */
	@RequestMapping("/inner/workInfo/save")
	public void saveWorkInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			WorkStep info = getModel(WorkStep.class);
			info.setCompanyId(admin.getCompanyId());
			info.setEndTime(DateUtil.getCurrDateStr());
			info.setOperatorId(admin.getUserCode());
			info.setOperatorName(admin.getUsername());
			info.setOperatorOrgId(admin.getOrgId());
			info.setOperatorOrgName(admin.getOrgName());
			info.setRoleId(admin.getRoleId());
			info.setRoleName(admin.getRoleName());
			info.setParentOrgId(admin.getParentOrgId());
			logger.info("/inner/workInfo/save > " + info.toLog());
			workInfoService.saveWorkStep(info);
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
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/workInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			
			String keyword = IStringUtil.getUTF8(request.getParameter("keyword"));
			int flag=1;
			String roleId=admin.getRoleId();
			if(admin.getBind_mobile().equals(admin.getCompanyId()) || Constants.default_roleId.equals(admin.getUserid())) {
				roleId="";
				flag=0;
			}
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("roleId", roleId);
			param.put("flag", flag);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WorkInfo> list = workInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find workInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find workInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/workInfo/listByUserId")
	public void listByUserId(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("userid", admin.getUserid());
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WorkInfo> list = workInfoService.listByUserId(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find workInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find workInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}