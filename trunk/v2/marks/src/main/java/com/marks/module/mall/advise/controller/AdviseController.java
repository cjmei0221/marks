package com.marks.module.mall.advise.controller;

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
import com.marks.module.mall.advise.pojo.Advise;
import com.marks.module.mall.advise.service.AdviseService;
import com.marks.module.user.login.helper.LoginInnerUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class AdviseController extends SupportContorller {
	private static Logger logger = Logger.getLogger(AdviseController.class);

	@Autowired
	private AdviseService adviseService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询客户专制
	 */
	@RequestMapping("/inner/advise/findAdviseById")
	public void findAdviseById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Advise advise = getModel(Advise.class);
			Advise requestAdvise = adviseService.findById(advise.getID());
			result.getData().put("advise", requestAdvise);
			result.setMessage("findById advise successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存客户专制
	 */
	@RequestMapping("/inner/advise/save")
	public void saveAdvise(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			Advise advise = getModel(Advise.class);
			// advise.setID(IDUtil.getTimeID());

			advise.setUserid(admin.getUserid());
			adviseService.save(advise);
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
	 * 更改客户专制
	 */
	@RequestMapping("/inner/advise/update")
	public void updateAdvise(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Advise advise = getModel(Advise.class);
			Advise ori = adviseService.findById(advise.getID());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				adviseService.update(advise);
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
	 * 删除客户专制
	 */
	@RequestMapping("/inner/advise/delete")
	public void deleteAdviseById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Advise advise = getModel(Advise.class);
			adviseService.delete(advise.getID());
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
	 * 查询全部客户专制
	 */
	@RequestMapping("/inner/advise/findAllAdvise")
	public void findAllAdvise(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<Advise> adviseList = adviseService.findAll();
			result.getData().put("adviseList", adviseList);
			result.setMessage("findAll advise successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll advise fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个客户专制
	 */
	@RequestMapping("/inner/advise/deleteIds")
	public void deleteAdvise(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("ID");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				adviseService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete advise fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/advise/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			PojoDomain<Advise> list = adviseService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find advise successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find advise fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}