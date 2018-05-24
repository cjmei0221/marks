package com.marks.module.mall.report.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.excel.ExcelUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.report.pojo.OrderLog;
import com.marks.module.mall.report.service.OrderLogService;
import com.marks.module.system.upload.util.UploadUtil;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class OrderLogController extends SupportContorller {
	private static Logger logger = Logger.getLogger(OrderLogController.class);

	@Autowired
	private OrderLogService orderLogService;
	@Override
	public Logger getLogger() {
		return logger;
	}

	@RequestMapping("/inner/orderLog/list")
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
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("startDate", startDate);
			param.put("endDate", endDate);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<OrderLog> list = orderLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 导出
	 */
	@RequestMapping("/inner/orderLog/listExcel")
	public void listExcel(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		OutputStream os = null;
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = 1;
			int page_size = 500000;
			String keyword = request.getParameter("keyword");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("startDate", startDate);
			param.put("endDate", endDate);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<OrderLog> list = orderLogService.list(page_number, page_size, param);

			response.setContentType("application/ms-excel");
			try {
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode("销售流水_" + IDUtil.getSecondID() + ".xls", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			os = response.getOutputStream();

			Map<String, Object> beanParams = new HashMap<String, Object>(); // 数据集
			beanParams.put("list", list.getPojolist()); // 绑定数据，在模板中可用el表达式获取数据
			String mobanPath = UploadUtil.getRootPath(request) + "inner/page/mall/report/template/orderLog.xls";
			ExcelUtil.exportExcelByTemplate(os, beanParams, mobanPath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find traceInfo fail!");
			result.setCode(Code.CODE_FAIL);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

}
