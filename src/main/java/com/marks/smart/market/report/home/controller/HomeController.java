package com.marks.smart.market.report.home.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.report.home.pojo.CoreData;
import com.marks.smart.market.report.home.pojo.SalesData;
import com.marks.smart.market.report.home.service.HomeService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

@Controller
public class HomeController extends SupportContorller {
	private static Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private HomeService homeService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@RequestMapping("/inner/home/getCodeData")
	public void getCodeData(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			// 日期类型 0:本日 1:本周 2:本月 3:本季度 4:本年
			String dateType = request.getParameter("dateType");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = sdf.format(new Date());
			String i_year = startDate.substring(0, 4);
			if ("1".equals(dateType)) {
				startDate = DateUtil.getMonday(0, sdf);
			} else if ("2".equals(dateType)) {
				startDate = DateUtil.getMonthFirstDay(0, sdf);
			} else if ("3".equals(dateType)) {
				int month = Integer.parseInt(startDate.substring(5, 7));
				startDate = DateUtil.getSeasonFirstDay(i_year, month);
			} else if ("4".equals(dateType)) {
				startDate = i_year + "-01-01";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("startDate", startDate);
			CoreData data = homeService.getCoreData(param);
			result.getData().put("info", data);
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/home/getSalesForDate")
	public void getSalesForDate(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			// 日期类型 0:本日 1:本周 2:本月 3:本季度 4:本年
			String dateType = "2";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = sdf.format(new Date());
			String i_year = startDate.substring(0, 4);
			if ("1".equals(dateType)) {
				startDate = DateUtil.getMonday(0, sdf);
			} else if ("2".equals(dateType)) {
				startDate = DateUtil.getMonthFirstDay(0, sdf);
			} else if ("3".equals(dateType)) {
				int month = Integer.parseInt(startDate.substring(5, 7));
				startDate = DateUtil.getSeasonFirstDay(i_year, month);
			} else if ("4".equals(dateType)) {
				startDate = i_year + "-01-01";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("startDate", startDate);
			List<SalesData> list = homeService.getSalesForDate(param);
			result.getData().put("list", list);
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/home/getSalesForMonth")
	public void getSalesForMonth(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int i_year = Integer.parseInt(DateUtil.getCurrDateStr().substring(0, 4));
			i_year = i_year - 3;
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("i_year", i_year);
			List<SalesData> list = homeService.getSalesForMonth(param);
			result.getData().put("list", list);
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/home/getSalesForSeason")
	public void getSalesForSeason(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int i_year = Integer.parseInt(DateUtil.getCurrDateStr().substring(0, 4));
			i_year = i_year - 3;
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("i_year", i_year);
			List<SalesData> list = homeService.getSalesForSeason(param);
			result.getData().put("list", list);
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}
