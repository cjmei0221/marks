package com.marks.module.fee.log.controller;

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
import com.marks.common.domain.Result;
import com.marks.common.enums.FeeEnums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.excel.ExcelUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.fee.log.pojo.FeeLog;
import com.marks.module.fee.log.service.FeeLogService;
import com.marks.module.system.upload.util.UploadUtil;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 费用明细:
 */
@Controller
public class FeeLogController extends SupportContorller {
	private static Logger logger = Logger.getLogger(FeeLogController.class);

	@Autowired
	private FeeLogService feeLogService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询费用明细
	 */
	@RequestMapping("/inner/feeLog/findById")
	public void findFeeLogById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			FeeLog info = getModel(FeeLog.class);

			logger.info("findFeeLogById > param>" + info.getId());

			FeeLog vo = feeLogService.findById(info.getId());
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
	 * 保存费用科目
	 */
	@RequestMapping("/inner/feeLog/save")
	public void saveFeeType(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			FeeLog info = getModel(FeeLog.class);
			info.setCompanyId(admin.getCompanyId());
			info.setItemCode(FeeEnums.ItemCode.self.getValue());
			info.setIsDel(1);
			info.setCreator(admin.getOperator());
			logger.info("saveFeeType > param>" + info.toLog());
			feeLogService.save(info);
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改费用科目
	 */
	@RequestMapping("/inner/feeLog/update")
	public void updateFeeType(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			FeeLog info = getModel(FeeLog.class);

			logger.info(" updateFeeType> param>" + info.toLog());

			FeeLog ori = feeLogService.findById(info.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				info.setItemCode(FeeEnums.ItemCode.self.getValue());
				info.setIsDel(1);
				info.setCreator(admin.getOperator());
				feeLogService.update(info);
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
	 * 列表查询
	 */
	@RequestMapping("/inner/feeLog/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("startDate", request.getParameter("startDate"));
			param.put("endDate", request.getParameter("endDate"));
			PojoDomain<FeeLog> list = feeLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find feeLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find feeLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 导出
	 */
	@RequestMapping("/inner/feeLog/listExcel")
	public void listExcel(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		OutputStream os = null;
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = 1;
			int page_size = 500000;
			String keyword = request.getParameter("keyword");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("startDate", request.getParameter("startDate"));
			param.put("endDate", request.getParameter("endDate"));
			PojoDomain<FeeLog> list = feeLogService.list(page_number, page_size, param);
			response.setContentType("application/ms-excel");
			try {
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode("费用明细_" + IDUtil.getSecondID() + ".xls", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			os = response.getOutputStream();

			Map<String, Object> beanParams = new HashMap<String, Object>(); // 数据集
			beanParams.put("list", list.getPojolist()); // 绑定数据，在模板中可用el表达式获取数据
			String mobanPath = UploadUtil.getRootPath(request) + "inner/page/fee/log/template/feeLog.xls";
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