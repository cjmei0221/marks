package com.marks.module.mall.dispatch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.DispatchEnums;
import com.marks.common.enums.Enums;
import com.marks.common.enums.WorkEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.pojo.DispatchInfo;
import com.marks.module.mall.dispatch.service.DispatchInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.work.info.pojo.WorkFlow;
import com.marks.module.work.info.service.WorkInfoService;

import net.sf.json.JSONArray;

/**
 * 采购单:
 */
@Controller
public class PurchaseInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(PurchaseInfoController.class);

	@Autowired
	private DispatchInfoService dispatchInfoService;

	@Autowired
	private WorkInfoService workInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 保存采购单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/purchase/save")
	public void saveDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class);

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
	@RequestMapping("/inner/purchase/update")
	public void updateDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class);

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
	@RequestMapping("/inner/purchase/receive")
	public void receive(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class);

			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				String goodObj = request.getParameter("goodData");
				List<DispatchGood> goodList = (List<DispatchGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
						DispatchGood.class);
				ori.setReceiveOrgId(admin.getOrgId());
				ori.setReceiveOrgName(admin.getOrgName());
				ori.setCreator(admin.getOperator());
				dispatchInfoService.updateReceiveGood(ori, goodList);
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





	@RequestMapping("/inner/purchase/approve")
	public void approve(HttpServletRequest request, HttpServletResponse response) {

		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String idNo = request.getParameter("idNo");
			String checkStatus = Enums.CheckStatus.checkOk.getValue() + "";
			DispatchInfo info = dispatchInfoService.findById(idNo);
			if (info == null) {
				result.setMessage("参数错误！");
				result.setCode("4001");
				JsonUtil.output(response, result);
				return;
			}
			// 审批
			// 审批
			WorkFlow work = new WorkFlow();
			work.setApplyMan(admin.getUsername());
			work.setApplyManId(admin.getUserid());
			work.setApplyOrgId(admin.getOrgId());
			work.setApplyOrgName(admin.getOrgName());
			work.setApplyRoleId(admin.getRoleId());
			work.setApplyRoleName(admin.getRoleName());
			work.setCompanyId(admin.getCompanyId());
			work.setIdNo(idNo);
			work.setRemarks(info.getSendOrgName());
			work.setTypeCode(WorkEnums.WorkType.dispatch_cg.getValue());
			boolean isCheck = workInfoService.save(work);
			if (isCheck) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("idNo", idNo);
				map.put("checkStatus", Enums.CheckStatus.checking.getValue() + "");
				map.put("checkerId", admin.getUserCode());
				map.put("checker", admin.getUsername());
				dispatchInfoService.updateCheckStatus(map);
			} else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("idNo", idNo);
				map.put("checkStatus", checkStatus);
				map.put("checkerId", admin.getUserCode());
				map.put("checker", admin.getUsername());
				dispatchInfoService.updateCheckStatus(map);
			}
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