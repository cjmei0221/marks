package com.marks.module.asset.manage.controller;

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
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.asset.manage.pojo.AssetPlan;
import com.marks.module.asset.manage.service.AssetPlanService;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 理财: 理财计划
 */
@Controller
public class AssetPlanController extends SupportContorller {
	private static Logger logger = Logger.getLogger(AssetPlanController.class);

	@Autowired
	private AssetPlanService assetPlanService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询理财
	 */
	@RequestMapping("/inner/assetPlan/findById")
	public void findAssetPlanById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			AssetPlan reqVo = getModel(AssetPlan.class);

			logger.info("findAssetPlanById > param>" + reqVo.getPlanId());

			AssetPlan info = assetPlanService.findById(reqVo.getPlanId());
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
	 * 保存理财
	 */
	@RequestMapping("/inner/assetPlan/save")
	public void saveAssetPlan(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			AssetPlan reqVo = getModel(AssetPlan.class);
			reqVo.setPlanId(IDUtil.getDateID() + "-" + IDUtil.getRandom(100, 999) + IDUtil.getRandom(100, 999));

			logger.info("saveAssetPlan > param>" + reqVo.toLog());

			reqVo.setUsername(admin.getUserid());
			reqVo.setUserid(admin.getUserid());
			reqVo.setMobile(admin.getBind_mobile());
			assetPlanService.save(reqVo);
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
	 * 更改理财
	 */
	@RequestMapping("/inner/assetPlan/update")
	public void updateAssetPlan(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			AssetPlan reqVo = getModel(AssetPlan.class);

			logger.info(" updateAssetPlan> param>" + reqVo.toLog());

			AssetPlan ori = assetPlanService.findById(reqVo.getPlanId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				reqVo.setUsername(admin.getUserid());
				reqVo.setMobile(admin.getBind_mobile());
				assetPlanService.update(reqVo);
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
	 * 删除理财
	 */
	@RequestMapping("/inner/assetPlan/delete")
	public void deleteAssetPlanById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			AssetPlan reqVo = getModel(AssetPlan.class);

			logger.info("deleteAssetPlanById > param>" + reqVo.getPlanId());

			assetPlanService.delete(reqVo.getPlanId());
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
	 * 查询全部理财
	 */

	/*
	 * @RequestMapping("/inner/assetPlan/findAllAssetPlan") public void
	 * findAllAssetPlan(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { List<AssetPlan> allList =
	 * assetPlanService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll assetPlan successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll assetPlan fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个理财
	 */
	/*
	 * @RequestMapping("/inner/assetPlan/deleteIds") public void
	 * deleteAssetPlan(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { String id =
	 * request.getParameter("planId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ assetPlanService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete assetPlan fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/assetPlan/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
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
			PojoDomain<AssetPlan> list = assetPlanService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find assetPlan successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find assetPlan fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}