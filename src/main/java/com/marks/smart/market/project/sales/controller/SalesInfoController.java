package com.marks.smart.market.project.sales.controller;

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
import com.marks.common.enums.SalesEnums.AwardTypeCode;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.project.sales.pojo.SalesInfo;
import com.marks.smart.market.project.sales.pojo.SalesItem;
import com.marks.smart.market.project.sales.service.SalesInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

/**
 * 促销方案: 促销方案 促销信息 优惠券等
 */
@Controller
public class SalesInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SalesInfoController.class);

	@Autowired
	private SalesInfoService salesInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询促销方案
	 */
	@RequestMapping("/inner/salesInfo/getProjectCode")
	public void getProjectCode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String projectCode = "P-" + IDUtil.getProjectCode();
			result.getData().put("projectCode", projectCode);
			result.setMessage(" successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询促销方案
	 */
	@RequestMapping("/inner/salesInfo/findById")
	public void findById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SalesInfo info = getModel(SalesInfo.class);
			SalesInfo vo = salesInfoService.findById(info.getProjectCode());
			List<SalesItem> list=salesInfoService.findSalesItemListByProjectCode(info.getProjectCode());
			result.getData().put("info", vo);
			result.getData().put("list", list);
			result.setMessage(" successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存促销方案
	 */
	@RequestMapping("/inner/salesInfo/save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SalesInfo info = getModel(SalesInfo.class);
			SalesInfo ori = null;
			if (info.getProjectCode() != null) {
				ori = salesInfoService.findById(info.getProjectCode());
			}
			if (ori == null) {
				info.setCompanyId(admin.getCompanyId());
				info.setCreator(admin.getOperator());
				info.setStatus(Enums.Status.Unable.getValue());
				info.setUpdater(admin.getOperator());
				List<SalesItem> list = getSalesItemList(request, info);
				salesInfoService.save(info, list);
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
	 * 更改促销方案
	 */
	@RequestMapping("/inner/salesInfo/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SalesInfo info = getModel(SalesInfo.class);
			SalesInfo ori = salesInfoService.findById(info.getProjectCode());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				info.setCompanyId(admin.getCompanyId());
				info.setCreator(admin.getOperator());
				info.setStatus(Enums.Status.Unable.getValue());
				info.setUpdater(admin.getOperator());
				List<SalesItem> list = getSalesItemList(request, info);
				salesInfoService.update(info, list);
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

	private List<SalesItem> getSalesItemList(HttpServletRequest request, SalesInfo info) {
		String[] limitNums = request.getParameterValues("limitNums");
		String[] itemTypeCode = request.getParameterValues("itemTypeCode");
		String[] itemVal1 = request.getParameterValues("itemVal1");
		if (null == limitNums || (null != limitNums && limitNums.length == 0)) {
			return null;
		}

		List<SalesItem> list = new ArrayList<SalesItem>();
		if (limitNums != null && limitNums.length > 0) {
			SalesItem item = null;
			for (int i = 0; i < limitNums.length; i++) {
				if (limitNums[i] != null && limitNums[i] != "" && Integer.parseInt(limitNums[i]) > 0) {
					item = new SalesItem();
					item.setCompanyId(info.getCompanyId());
					item.setItemTypeCode(Integer.parseInt(itemTypeCode[i]));
					item.setItemVal1(itemVal1[i]);
					item.setLimitNums(limitNums[i]);
					item.setItemName("满" + item.getLimitNums() + " " + AwardTypeCode.getByKey(item.getItemTypeCode())
							+ " " + item.getItemVal1());
					item.setProjectCode(info.getProjectCode());
					item.setProjectName(info.getProjectName());
					list.add(item);
				}
			}
			if (list.size() > 0) {
				int idx = 0;
				for (SalesItem vo : list) {
					idx += 1;
					vo.setItemCode(idx+"");
					vo.setItemId(info.getProjectCode()+"-"+idx);
					vo.setSort(idx);
				}
			}
		}
		return list;
	}

	/**
	 * 删除促销方案
	 */
	@RequestMapping("/inner/salesInfo/delete")
	public void deleteById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SalesInfo info = getModel(SalesInfo.class);
			salesInfoService.delete(info.getProjectCode());
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
	 * 查询全部促销方案
	 */

	/*
	 * @RequestMapping("/inner/salesInfo/findAllSalesInfo") public void
	 * findAll(HttpServletRequest request, HttpServletResponse response){ Result
	 * result = new Result(); try { List<SalesInfo> allList =
	 * salesInfoService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll successs!"); result.setCode(Code.CODE_SUCCESS); }
	 * catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("findAll salesInfo fail!"); result.setCode(Code.CODE_FAIL);
	 * } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个促销方案
	 */
	/*
	 * @RequestMapping("/inner/salesInfo/deleteIds") public void
	 * delete(HttpServletRequest request, HttpServletResponse response){ Result
	 * result = new Result(); try { String id = request.getParameter("projectCode");
	 * String[] ids = id.split(","); List<String> idList = new ArrayList<String>();
	 * for(int i=0;i<ids.length;i++){ idList.add(ids[i]); } if(idList.size()>0){
	 * salesInfoService.deleteBatch(idList); result.setMessage("删除成功!");
	 * result.setCode(Code.CODE_SUCCESS); }else{ result.setMessage("删除失败，请联系管理员!");
	 * result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete salesInfo fail!"); result.setCode(Code.CODE_FAIL);
	 * } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/salesInfo/list")
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
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<SalesInfo> list = salesInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("list successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("list fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/salesInfo/approve")
	public void approve(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String idNo = request.getParameter("projectCode");
			String checkStatus = Enums.CheckStatus.checkOk.getValue() + "";

			SalesInfo info = salesInfoService.findById(idNo);
			if (info == null) {
				result.setMessage("参数错误！");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			// 审批
			// 审批
//			WorkFlow work = new WorkFlow();
//			work.setApplyMan(admin.getUsername());
//			work.setApplyManId(admin.getUserid());
//			work.setApplyOrgId(admin.getOrgId());
//			work.setApplyOrgName(admin.getOrgName());
//			work.setApplyRoleId(admin.getRoleId());
//			work.setApplyRoleName(admin.getRoleName());
//			work.setCompanyId(admin.getCompanyId());
//			work.setIdNo(idNo);
//			work.setRemarks(info.getProjectName());
//			work.setTypeCode(WorkEnums.WorkType.project_sales.getValue());
//			boolean isCheck = workInfoService.save(work);
//			if (isCheck) {
//				checkStatus = Enums.CheckStatus.checking.getValue() + "";
//			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("idNo", idNo);
			map.put("checkStatus", checkStatus);
			map.put("checkerId", admin.getUserCode());
			map.put("checker", admin.getUsername());
			map.put("companyId", admin.getCompanyId());
			salesInfoService.updateCheckStatus(map);
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
	 * 启禁用
	 */
	@RequestMapping("/inner/salesInfo/active")
	public void active(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String projectCode = request.getParameter("projectCode");
			SalesInfo info = salesInfoService.findById(projectCode);
			if (info == null) {
				result.setMessage("参数错误！");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			if (Enums.Status.Enable.getValue() == info.getStatus()) {
				info.setStatus(Enums.Status.Unable.getValue());
			} else {
				info.setStatus(Enums.Status.Enable.getValue());
			}
			salesInfoService.update(info,null);
			result.setMessage("success!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}