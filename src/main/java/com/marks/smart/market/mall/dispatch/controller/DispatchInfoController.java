package com.marks.smart.market.mall.dispatch.controller;

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
import com.marks.smart.market.mall.dispatch.pojo.DispatchGood;
import com.marks.smart.market.mall.dispatch.pojo.DispatchInfo;
import com.marks.smart.market.mall.dispatch.service.DispatchGoodService;
import com.marks.smart.market.mall.dispatch.service.DispatchInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 采购单:
 */
@Controller
public class DispatchInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(DispatchInfoController.class);

	@Autowired
	private DispatchInfoService dispatchInfoService;

	@Autowired
	private DispatchGoodService dispatchGoodService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询采购单
	 */
	@RequestMapping("/inner/dispatchInfo/findById")
	public void findDispatchInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String orderId = request.getParameter("orderId");

			String page_size = request.getParameter("page_size");

			String formStatus = request.getParameter("formStatus");

			int len = 1;

			DispatchInfo vo = dispatchInfoService.findById(orderId);
			String orgId = "";
			List<DispatchGood> list = null;
			if (vo != null) {
				if (DispatchEnums.YwCode.ywCode_cg.getValue().equals(vo.getYwCode())) {
					orgId = vo.getReceiveOrgId();
				} else {
					orgId = vo.getSendOrgId();
				}
				list = dispatchGoodService.findByOrderId(orderId, orgId);
			}

			if (vo == null) {
				vo = new DispatchInfo();
				vo.setOrderId(IDUtil.getProjectCode());
			}

			if (null == list) {
				list = new ArrayList<DispatchGood>();
			}
			if ("new".equals(formStatus) || "edit".equals(formStatus)) {
				int size = list.size();
				if (size < len) {
					DispatchGood info = null;
					for (int i = size; i < len; i++) {
						info = new DispatchGood();
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
	 * 保存采购单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/dispatchInfo/save")
	public void saveDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class,request.getParameterMap());

			logger.info("saveDispatchInfo > param>" + info.toLog());

			DispatchInfo ori = null;
			if (info.getOrderId() != null) {
				ori = dispatchInfoService.findById(info.getOrderId());
			}

			if (ori == null) {
				info.setCompanyId(admin.getCompanyId());
				info.setCreator(admin.getUsername());
				info.setCreatorCode(admin.getUserCode());
				info.setStatus(DispatchEnums.Status.init.getValue());
				String goodObj = request.getParameter("goodData");
				List<DispatchGood> goodList = (List<DispatchGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						DispatchGood.class);
				dispatchInfoService.save(info, goodList);
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
	 * 更改采购单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/dispatchInfo/update")
	public void updateDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class,request.getParameterMap());

			logger.info(" updateDispatchInfo> param>" + info.toLog());

			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				String goodObj = request.getParameter("goodData");
				List<DispatchGood> goodList = (List<DispatchGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						DispatchGood.class);
				dispatchInfoService.update(info, goodList);
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
	 * 保存收货记录
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/dispatchInfo/receive")
	public void receive(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class,request.getParameterMap());

			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				String goodObj = request.getParameter("goodData");
				List<DispatchGood> goodList = (List<DispatchGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						DispatchGood.class);
//				ori.setReceiveOrgId(admin.getOrgId());
//				ori.setReceiveOrgName(admin.getOrgName());
				ori.setCreator(admin.getOperator());
				dispatchInfoService.updateReceiveGoodForDh(ori, goodList);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存收货记录
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/dispatchInfo/send")
	public void send(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class,request.getParameterMap());

			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				String goodObj = request.getParameter("goodData");
				List<DispatchGood> goodList = (List<DispatchGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						DispatchGood.class);
//				ori.setReceiveOrgId(admin.getOrgId());
//				ori.setReceiveOrgName(admin.getOrgName());
				ori.setCreator(admin.getOperator());
				dispatchInfoService.updateSendGoodForPh(ori, goodList);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除采购单
	 */
	@RequestMapping("/inner/dispatchInfo/delete")
	public void deleteDispatchInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			DispatchInfo info = getModel(DispatchInfo.class,request.getParameterMap());

			logger.info("deleteDispatchInfoById > param>" + info.getOrderId());
			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (Enums.CheckStatus.noCheck.getValue() != ori.getCheckStatus()) {
				result.setMessage("已审核，不可删除！");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			dispatchInfoService.delete(info.getOrderId());
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
	 * 查询全部采购单
	 */

	/*
	 * @RequestMapping("/inner/dispatchInfo/findAllDispatchInfo") public void
	 * findAllDispatchInfo(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { List<DispatchInfo> allList =
	 * dispatchInfoService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll dispatchInfo successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll dispatchInfo fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个采购单
	 */
	/*
	 * @RequestMapping("/inner/dispatchInfo/deleteIds") public void
	 * deleteDispatchInfo(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("orderId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new ArrayList<String>();
	 * for(int i=0;i<ids.length;i++){ idList.add(ids[i]); } if(idList.size()>0){
	 * dispatchInfoService.deleteBatch(idList); result.setMessage("删除成功!");
	 * result.setCode(Code.CODE_SUCCESS); }else{ result.setMessage("删除失败，请联系管理员!");
	 * result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete dispatchInfo fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/dispatchInfo/list")
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
			param.put("ywCode", request.getParameter("ywCode"));
			param.put("typeCode", request.getParameter("typeCode"));
			param.put("companyId", admin.getCompanyId());
			PojoDomain<DispatchInfo> list = dispatchInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find dispatchInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find dispatchInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/dispatchInfo/approve")
	public void approve(HttpServletRequest request, HttpServletResponse response) {

		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String idNo = request.getParameter("idNo");
			String checkStatus = Enums.CheckStatus.checkOk.toString();
			DispatchInfo info = dispatchInfoService.findById(idNo);
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
			dispatchInfoService.updateCheckStatus(map);

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