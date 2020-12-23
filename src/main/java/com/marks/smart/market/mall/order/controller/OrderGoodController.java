package com.marks.smart.market.mall.order.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.good.service.GoodInfoService;
import com.marks.smart.market.mall.order.pojo.OrderGood;
import com.marks.smart.market.mall.order.service.OrderGoodService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

/**
 * 订单商品: 订单商品
 */
@Controller
public class OrderGoodController extends SupportContorller {
	private static Logger logger = Logger.getLogger(OrderGoodController.class);
	@Autowired
	private OrderGoodService orderGoodService;
	@Autowired
	private GoodInfoService goodInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@RequestMapping("/inner/orderGood/findById")
	public void findGoodInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String goodNo = request.getParameter("goodNo");
			String edit = request.getParameter("edit");
			OrderGood info = null;
			if ("1".equals(edit)) {
				info = new OrderGood();
				info.setOrderGoodId(IDUtil.getNumID());
				result.getData().put("info", info);
				result.setMessage("findById successs!");
				result.setCode(Code.CODE_SUCCESS);
				JsonUtil.output(response, result);
				return;
			}
			logger.info("findDispatchGoodById > param>" + goodNo);
			info = orderGoodService.findById(admin.getCompanyId(), goodNo,admin.getOrgId());
			if (null != info) {
				info.setPayPrice(info.getSalePrice());
				info.setNowPrice(info.getSalePrice());
			}
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
	 * 列表查询
	 */
	@RequestMapping("/inner/orderGood/list")
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
			String orderId = request.getParameter("orderId");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("orderId", orderId);
			PojoDomain<OrderGood> list = orderGoodService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find orderGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find orderGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}