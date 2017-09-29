package com.marks.module.note.web.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.core.data.StaticData;
import com.marks.module.note.gains.pojo.Gains;
import com.marks.module.note.gains.service.GainsService;
import com.marks.module.system.upload.util.UploadUtil;
import com.marks.module.user.login.helper.LoginWebUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class WebGainsController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WebGainsController.class);

	@Autowired
	private GainsService gainsService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询心得记录
	 */
	@RequestMapping("/web/gains/findGainsById")
	public void findGainsById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Gains gains = getModel(Gains.class);
			Gains requestGains = gainsService.findById(gains.getId());
			result.getData().put("gains", requestGains);
			result.setMessage("findById gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存心得记录
	 */
	@RequestMapping("/web/gains/save")
	public void saveGains(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginWebUtil.getInstance().getCurrentUser(request);
			String userid = admin == null ? "" : admin.getUserid();
			Gains gains = getModel(Gains.class);
			// gains.setId(IDUtil.getTimeID());

			gains.setLvlName(StaticData.getDatadirValue("gains_level", gains.getLvl()));
			gains.setCreator(userid);
			gains.setUpdater(userid);
			gains.setMobile(admin.getBind_mobile());
			Gains old = gainsService.findById(gains.getId());
			if (old == null) {
				gainsService.save(gains);
			} else {
				gainsService.update(gains);
			}
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
	 * 更改心得记录
	 */
	@RequestMapping("/web/gains/update")
	public void updateGains(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginWebUtil.getInstance().getCurrentUser(request);
			String userid = admin == null ? "" : admin.getUserid();
			Gains gains = getModel(Gains.class);

			gains.setLvlName(StaticData.getDatadirValue("gains_level", gains.getLvl()));
			gains.setUpdater(userid);
			gainsService.update(gains);
			result.setMessage("更新成功!");
			result.setCode(Code.CODE_SUCCESS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除心得记录
	 */
	@RequestMapping("/web/gains/delete")
	public void deleteGainsById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Gains gains = getModel(Gains.class);
			gainsService.delete(gains.getId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询全部心得记录
	 */
	@RequestMapping("/web/gains/findAllGains")
	public void findAllGains(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<Gains> gainsList = gainsService.findAll();
			result.getData().put("gainsList", gainsList);
			result.setMessage("findAll gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个心得记录
	 */
	@RequestMapping("/web/gains/deleteIds")
	public void deleteGains(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				gainsService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/web/gains/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginWebUtil.getInstance().getCurrentUser(request);
			String userid = admin == null ? "" : admin.getUserid();
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("userid", userid);
			PojoDomain<Gains> list = gainsService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 导出txt
	 */
	@RequestMapping("/web/gains/export")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginWebUtil.getInstance().getCurrentUser(request);
			Map<String, Object> param = new HashMap<String, Object>();
			String keyword = request.getParameter("keyword");
			param.put("userid", admin.getUserid());
			param.put("keyword", keyword);
			String basePath = UploadUtil.getUploadPath(request);
			String path = gainsService.exportTxt(param, basePath);
			result.getData().put("filepath", path);
			result.setMessage("findAll diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("findAll diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}