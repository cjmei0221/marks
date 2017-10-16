package com.marks.module.system.sysconf.controller;

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
import com.marks.module.system.sysconf.pojo.SysConf;
import com.marks.module.system.sysconf.service.SysConfService;
import com.marks.module.user.login.helper.LoginManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class SysConfController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SysConfController.class);

	@Autowired
	private SysConfService sysConfService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询系统参数
	 */
	@RequestMapping("/inner/sysConf/findSysConfById")
	public void findSysConfById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysConf sysConf = getModel(SysConf.class);
			SysConf requestSysConf = sysConfService.findById(sysConf.getCkey());
			result.getData().put("sysConf", requestSysConf);
			result.setMessage("findById sysConf successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存系统参数
	 */
	@RequestMapping("/inner/sysConf/save")
	public void saveSysConf(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginManageUtil.getCurrentUserInfo(request);
			SysConf sysConf = getModel(SysConf.class);
			// sysConf.setCkey(IDUtil.getTimeID());
			SysConf ori = null;
			if (sysConf.getCkey() != null) {
				ori = sysConfService.findById(sysConf.getCkey());
			}

			if (ori == null) {
				sysConf.setCompanyId(admin.getCompanyNo());
				sysConf.setCreator(admin.getUserid());
				sysConfService.save(sysConf);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此主键不能使用");
				result.setCode(Code.CODE_FAIL);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改系统参数
	 */
	@RequestMapping("/inner/sysConf/update")
	public void updateSysConf(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysConf sysConf = getModel(SysConf.class);
			SysConf ori = sysConfService.findById(sysConf.getCkey());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				sysConfService.update(sysConf);
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
	 * 删除系统参数
	 */
	@RequestMapping("/inner/sysConf/delete")
	public void deleteSysConfById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysConf sysConf = getModel(SysConf.class);
			sysConfService.delete(sysConf.getCkey());
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
	 * 查询全部系统参数
	 */
	@RequestMapping("/inner/sysConf/findAllSysConf")
	public void findAllSysConf(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<SysConf> sysConfList = sysConfService.findAll();
			result.getData().put("sysConfList", sysConfList);
			result.setMessage("findAll sysConf successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysConf fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个系统参数
	 */
	@RequestMapping("/inner/sysConf/deleteIds")
	public void deleteSysConf(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("ckey");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				sysConfService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete sysConf fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/sysConf/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<SysConf> list = sysConfService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysConf successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysConf fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}