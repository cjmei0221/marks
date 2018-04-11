package com.marks.module.mall.order.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.OrderEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.pojo.OrderInfo;
import com.marks.module.mall.order.service.OrderInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

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
			String barCodeJson = request.getParameter("barCodeList");
			logger.info("saveOrderInfo params > " + vipId + " - " + payAmt + " - " + goodJson);
			List<OrderGood> goodList = (List<OrderGood>) JSONArray.toCollection(JSONArray.fromObject(goodJson),
					OrderGood.class);
			List<String> barCodeList = null;
			if (null != barCodeJson && barCodeJson.length() > 4) {
				barCodeList = (List<String>) JSONArray.toCollection(JSONArray.fromObject(barCodeJson),
						String.class);
			}
			OrderInfo info = new OrderInfo();
			info.setOrderId(orderInfoService.getOrderId());
			info.setCashDate(DateUtil.getCurrDateStr().substring(0, 10));
			info.setCashAmt(payAmt);
			info.setCashMan(admin.getUsername());
			info.setCashManId(admin.getUserid());
			info.setCashType(OrderEnums.CashType.consume.getValue());
			info.setYwType(OrderEnums.YwType.good.getValue());
			info.setCommitTime(DateUtil.getCurrDateStr());
			info.setCompanyId(admin.getCompanyId());
			info.setOrderStatus(OrderEnums.OrderStatus.complete.getValue());
			info.setOrderStatusName(OrderEnums.OrderStatus.getByKey(info.getOrderStatus()));
			info.setOrgId(admin.getOrgId());
			info.setOrgName(admin.getOrgName());
			info.setPayAmt(payAmt);
			info.setPayStatus(1);
			info.setVipId(vipId);
			info.setPayTypeCode(OrderEnums.PayType.cash.getValue());
			info.setPayTypeName(OrderEnums.PayType.getByKey(info.getPayTypeCode()));
			orderInfoService.saveOrder(info, goodList, barCodeList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}