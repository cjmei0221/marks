package com.marks.smart.market.mall.stock.controller;

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
import com.marks.common.enums.DispatchEnums;
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.stock.pojo.AdjustGood;
import com.marks.smart.market.mall.stock.pojo.AdjustInfo;
import com.marks.smart.market.mall.stock.service.AdjustGoodService;
import com.marks.smart.market.mall.stock.service.AdjustInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 库存调整单:
 */
@Controller
public class AdjustInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(AdjustInfoController.class);

	@Autowired
	private AdjustInfoService adjustInfoService;

	@Autowired
	private AdjustGoodService adjustGoodService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询库存调整单
	 */
	@RequestMapping("/inner/adjustInfo/findById")
	public void findAdjustInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String orderId = request.getParameter("orderId");

			String page_size = request.getParameter("page_size");

			String formStatus = request.getParameter("formStatus");

			int len = 1;

			AdjustInfo vo = adjustInfoService.findById(orderId);
			if (vo == null) {
				vo = new AdjustInfo();
				vo.setOrderId(IDUtil.getProjectCode());
			}
			List<AdjustGood> list = adjustGoodService.findByOrderId(orderId);
			if (null == list) {
				list = new ArrayList<AdjustGood>();
			}
			if ("new".equals(formStatus) || "edit".equals(formStatus)) {
				int size = list.size();
				if (size < len) {
					AdjustGood info = null;
					for (int i = size; i < len; i++) {
						info = new AdjustGood();
						info.setOrderGoodId(IDUtil.getNumID());
						list.add(info);
					}
				}
			}
			result.getData().put("info", vo);
			result.getData().put("list", list);
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
	 * 保存库存调整单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/adjustInfo/save")
	public void saveAdjustInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			AdjustInfo info = getModel(AdjustInfo.class,request.getParameterMap());

			logger.info("saveAdjustInfo > param>" + info.toLog());

			AdjustInfo ori = null;
			if (info.getOrderId() != null) {
				ori = adjustInfoService.findById(info.getOrderId());
			}

			if (ori == null) {
				info.setCompanyId(admin.getCompanyId());
				info.setCreatorCode(admin.getUserCode());
				info.setCreatorName(admin.getUsername());
				info.setStatus(DispatchEnums.Status.init.getValue());
				String goodObj = request.getParameter("goodData");
				List<AdjustGood> goodList = (List<AdjustGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						AdjustGood.class);
				adjustInfoService.save(info, goodList);
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
	 * 更改库存调整单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/adjustInfo/update")
	public void updateAdjustInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			AdjustInfo info = getModel(AdjustInfo.class,request.getParameterMap());

			logger.info(" updateAdjustInfo> param>" + info.toLog());

			AdjustInfo ori = adjustInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				String goodObj = request.getParameter("goodData");
				List<AdjustGood> goodList = (List<AdjustGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						AdjustGood.class);
				adjustInfoService.update(info, goodList);
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
	 * 删除库存调整单
	 */
	@RequestMapping("/inner/adjustInfo/delete")
	public void deleteAdjustInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			AdjustInfo info = getModel(AdjustInfo.class,request.getParameterMap());

			logger.info("deleteAdjustInfoById > param>" + info.getOrderId());

			adjustInfoService.delete(info.getOrderId());
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
	 * 查询全部库存调整单
	 */

	/*
	 * @RequestMapping("/inner/adjustInfo/findAllAdjustInfo") public void
	 * findAllAdjustInfo(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { List<AdjustInfo> allList =
	 * adjustInfoService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll adjustInfo successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll adjustInfo fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个库存调整单
	 */
	/*
	 * @RequestMapping("/inner/adjustInfo/deleteIds") public void
	 * deleteAdjustInfo(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("orderId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new ArrayList<String>();
	 * for(int i=0;i<ids.length;i++){ idList.add(ids[i]); } if(idList.size()>0){
	 * adjustInfoService.deleteBatch(idList); result.setMessage("删除成功!");
	 * result.setCode(Code.CODE_SUCCESS); }else{ result.setMessage("删除失败，请联系管理员!");
	 * result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete adjustInfo fail!"); result.setCode(Code.CODE_FAIL);
	 * } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/adjustInfo/list")
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
			PojoDomain<AdjustInfo> list = adjustInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find adjustInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find adjustInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/adjustInfo/approve")
	public void approve(HttpServletRequest request, HttpServletResponse response) {

		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String idNo = request.getParameter("idNo");
			String checkStatus = Enums.CheckStatus.checkOk.getValue() + "";
			AdjustInfo info = adjustInfoService.findById(idNo);
			if (info == null) {
				result.setMessage("参数错误！");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}

			Map<String, String> map = new HashMap<String, String>();
			map.put("idNo", idNo);
			map.put("checkStatus", checkStatus);
			map.put("checkerId", admin.getUserCode());
			map.put("checker", admin.getUsername());
			adjustInfoService.updateCheckStatus(map);

			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}