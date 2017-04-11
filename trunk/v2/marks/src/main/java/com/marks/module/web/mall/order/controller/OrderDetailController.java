package com.marks.module.web.mall.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.system.sys.controller.SupportContorller;

@Controller
public class OrderDetailController extends SupportContorller {

	private static Logger logger = Logger.getLogger(OrderDetailController.class);

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询我的日记
	 */
	@RequestMapping("/web/orderDetail")
	public void orderDetail(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String url = request.getParameter("url");
			logger.info("url>>" + url);
			result.setMessage("orderDetail successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
