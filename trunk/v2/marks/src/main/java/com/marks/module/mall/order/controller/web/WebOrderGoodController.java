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
import com.marks.module.acct.base.pojo.UserExt;
import com.marks.module.acct.base.service.UserExtService;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.core.runModel.RunModel;
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

	@Autowired
	private UserExtService userExtService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询订单商品
	 */
	@RequestMapping("/web/orderInfo/findGoodById")
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

			if (null == vo.getVipPrice() || "".equals(vo.getVipPrice())) {
				vo.setVipPrice(vo.getSalePrice());
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

	/**
	 * 查询用户管理
	 */
	@RequestMapping("/web/orderInfo/findVipInfoById")
	public void findById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String mobile = request.getParameter("mobile");
			String companyId = RunModel.getInstance().getCompanyId();
			UserExt user = userExtService.findByMobile(companyId, mobile);
			result.getData().put("info", user);
			result.setMessage("findById sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}