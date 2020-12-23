package com.marks.smart.market.mall.order.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.OrderEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.order.pojo.OrderGood;
import com.marks.smart.market.mall.order.pojo.OrderInfo;
import com.marks.smart.market.mall.order.service.OrderInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 订单管理: 订单信息
 */
@Controller
public class WebOrderInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WebOrderInfoController.class);

	@Autowired
	private OrderInfoService orderInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/web/orderInfo/save")
	public void saveOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String goodJson = request.getParameter("goodList");// 商品列表
			String vipId = request.getParameter("vipId");// 会员编号
			String payAmt = request.getParameter("payAmt");// 实付金额
			String payableAmt = request.getParameter("payableAmt");// 应付金额
			String barCodeJson = request.getParameter("barCodeList");

			String usePoint = request.getParameter("usePoint");// 应付金额
			String pointAmt = request.getParameter("pointAmt");// 应付金额
			String storedAmt = request.getParameter("storedAmt");// 应付金额
			String cashAmt = request.getParameter("cashAmt");// 应付金额
			logger.info("saveOrderInfo params > " + vipId + " - " + payAmt + " - " + goodJson);
			List<OrderGood> goodList = (List<OrderGood>) JSONArray.toCollection(JSONArray.fromObject(goodJson),
					OrderGood.class);
			if(null != goodList && goodList.size()>0) {
				for(OrderGood good:goodList) {
					good.setPayNums(good.getNums());
					good.setNums(good.getPayNums()+good.getSendNums());
				}
			}
			List<String> barCodeList = null;
			if (null != barCodeJson && barCodeJson.length() > 4) {
				barCodeList = (List<String>) JSONArray.toCollection(JSONArray.fromObject(barCodeJson), String.class);
			}
			OrderInfo info = new OrderInfo();
			info.setOrderId(orderInfoService.getOrderId());
			info.setCashDate(DateUtil.getCurrDateStr().substring(0, 10));
			info.setStoredAmt(storedAmt);
			info.setPointAmt(pointAmt);
			info.setPayingAmt(payAmt);
			info.setUsePoint(Integer.parseInt(usePoint));
			info.setCashAmt(cashAmt);
			info.setCashMan(admin.getUsername());
			info.setCashManId(admin.getUserid());
			info.setCashManCode(admin.getUserCode());
			info.setCashType(OrderEnums.CashType.consume.getValue());
			info.setYwType(OrderEnums.YwType.good.getValue());
			info.setCommitTime(DateUtil.getCurrDateStr());
			info.setCompanyId(admin.getCompanyId());
			info.setOrderStatus(OrderEnums.OrderStatus.complete.getValue());
			info.setOrderStatusName(OrderEnums.OrderStatus.getByKey(info.getOrderStatus()));
			info.setOrgId(admin.getOrgId());
			info.setOrgName(admin.getOrgName());
			info.setPayAmt(payAmt);
			info.setPayableAmt(payableAmt);
			info.setPayStatus(1);
			info.setVipId(vipId);
			info.setPayTypeCode(OrderEnums.PayType.cash.getValue());
			info.setPayTypeName(OrderEnums.PayType.getByKey(info.getPayTypeCode()));
			info.setChannelId(ChannelEnums.Channel.web.getValue());
			info.setCompanyName(admin.getCompanyName());
			orderInfoService.saveOrder(info, goodList, barCodeList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/web/orderInfo/recharge")
	public void recharge(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String vipId = request.getParameter("vipId");// 会员编号
			String payAmt = request.getParameter("payAmt");// 实付金额
			String payableAmt = request.getParameter("payableAmt");// 应付金额
			String cashAmt = request.getParameter("cashAmt");// 应付金额
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrderInfo info = new OrderInfo();
			info.setOrderId(orderInfoService.getOrderId());
			info.setCashDate(DateUtil.getCurrDateStr().substring(0, 10));
			info.setCashAmt(cashAmt);
			info.setCashMan(admin.getUsername());
			info.setCashManId(admin.getUserid());
			info.setCashManCode(admin.getUserCode());
			info.setCashType(OrderEnums.CashType.recharge.getValue());
			info.setYwType(OrderEnums.YwType.service.getValue());
			info.setCommitTime(DateUtil.getCurrDateStr());
			info.setCompanyId(admin.getCompanyId());
			info.setOrderStatus(OrderEnums.OrderStatus.complete.getValue());
			info.setOrderStatusName(OrderEnums.OrderStatus.getByKey(info.getOrderStatus()));
			info.setOrgId(admin.getOrgId());
			info.setOrgName(admin.getOrgName());
			info.setPayingAmt(payAmt);
			info.setPayAmt(payAmt);
			info.setPayableAmt(payableAmt);
			info.setPayStatus(1);
			info.setVipId(vipId);
			info.setPayTypeCode(OrderEnums.PayType.cash.getValue());
			info.setPayTypeName(OrderEnums.PayType.getByKey(info.getPayTypeCode()));
			info.setChannelId(ChannelEnums.Channel.web.getValue());
			info.setCompanyName(admin.getCompanyName());
			orderInfoService.saveRecharge(info);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}