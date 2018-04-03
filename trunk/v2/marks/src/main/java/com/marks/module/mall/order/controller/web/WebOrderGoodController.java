package com.marks.module.mall.order.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.StockEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.service.OrderGoodService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 订单商品: 订单商品
 */
@Controller
public class WebOrderGoodController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WebOrderGoodController.class);

	@Autowired
	private OrderGoodService orderGoodService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询订单商品
	 */
	@RequestMapping("/web/orderGood/findById")
	public void findOrderGoodById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			OrderGood info = getModel(OrderGood.class);

			logger.info("findOrderGoodById > param>" + info.getGoodId());
			OrderGood vo = orderGoodService.findById(admin.getCompanyId(), info.getGoodId());
			if (vo == null) {
				result.setMessage("无数据！");
				result.setCode("4003");
				JsonUtil.output(response, result);
				return;
			}
			if (null == vo.getPrice() || "".equals(vo.getPrice())) {
				vo.setPrice("0.00");
			}
			if (null == vo.getSalePrice() || "".equals(vo.getSalePrice())) {
				vo.setSalePrice(vo.getPrice());
			}

			if (info.getGoodId().length() >= 6 && info.getGoodId().length() < 8) {
				vo.setStockType(StockEnums.StockManageType.simple.getValue());
			} else {
				vo.setStockType(StockEnums.StockManageType.nums.getValue());
			}
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

}