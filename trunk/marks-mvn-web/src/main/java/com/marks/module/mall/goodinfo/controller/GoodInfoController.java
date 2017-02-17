package com.cjmei.module.mall.goodinfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.code.Code;
import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;
import com.cjmei.module.mall.goodinfo.service.GoodInfoService;
import com.cjmei.module.system.sys.controller.SupportContorller;

@Controller
public class GoodInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(GoodInfoController.class);

	@Autowired
	private GoodInfoService goodInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询商品管理
	 */
	@RequestMapping("/goodInfo/findGoodInfoById")
	public void findGoodInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodInfo goodInfo = getModel(GoodInfo.class);
			GoodInfo requestGoodInfo = goodInfoService.findById(goodInfo.getGoodId());
			result.getData().put("goodInfo", requestGoodInfo);
			result.setMessage("findById goodInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/goodInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			PojoDomain<GoodInfo> list = goodInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find goodInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find goodInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}