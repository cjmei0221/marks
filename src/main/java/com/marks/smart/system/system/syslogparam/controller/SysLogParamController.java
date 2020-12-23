package com.marks.smart.system.system.syslogparam.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.system.syslogparam.pojo.SysLogParam;
import com.marks.smart.system.system.syslogparam.service.SysLogParamService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

@Controller
public class SysLogParamController extends SupportContorller {
	private static Logger logger = Logger.getLogger(SysLogParamController.class);

	@Autowired
	private SysLogParamService sysLogParamService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询日志参数
	 */
	@RequestMapping("/inner/sysLogParam/findSysLogParamById")
	public void findSysLogParamById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysLogParam sysLogParam = getModel(SysLogParam.class);
			SysLogParam requestSysLogParam = sysLogParamService.findById(sysLogParam.getId());
			result.getData().put("sysLogParam", requestSysLogParam);
			result.setMessage("findById sysLogParam successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存日志参数
	 */
	@RequestMapping("/inner/sysLogParam/save")
	public void saveSysLogParam(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysLogParam sysLogParam = getModel(SysLogParam.class);
			// sysLogParam.setId(IDUtil.getTimeID());
			SysLogParam ori = null;

			ori = sysLogParamService.findByUrlAndSource(sysLogParam.getUrl(),sysLogParam.getSource());
			if (ori == null) {
				sysLogParam.setCreator(admin.getCreator());
				sysLogParamService.save(sysLogParam);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此记录已存在");
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
	 * 更改日志参数
	 */
	@RequestMapping("/inner/sysLogParam/update")
	public void updateSysLogParam(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			SysLogParam sysLogParam = getModel(SysLogParam.class);
			SysLogParam ori = sysLogParamService.findById(sysLogParam.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				ori = sysLogParamService.findByUrlAndSource(sysLogParam.getUrl(),sysLogParam.getSource());
				if(ori !=null && !ori.getId().equals(sysLogParam.getId())){
					result.setMessage("此记录已存在");
					result.setCode(Code.CODE_FAIL);
				}else{
					sysLogParamService.update(sysLogParam);
					result.setMessage("更新成功!");
					result.setCode(Code.CODE_SUCCESS);
				}
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除日志参数
	 */
	@RequestMapping("/inner/sysLogParam/delete")
	public void deleteSysLogParamById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysLogParam sysLogParam = getModel(SysLogParam.class);
			sysLogParamService.delete(sysLogParam.getId());
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
	 * 查询全部日志参数
	 */
	@RequestMapping("/inner/sysLogParam/findAllSysLogParam")
	public void findAllSysLogParam(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<SysLogParam> sysLogParamList = sysLogParamService.findAll();
			result.getData().put("sysLogParamList", sysLogParamList);
			result.setMessage("findAll sysLogParam successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll sysLogParam fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个日志参数
	 */
	@RequestMapping("/inner/sysLogParam/deleteIds")
	public void deleteSysLogParam(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				sysLogParamService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete sysLogParam fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/sysLogParam/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			String source=request.getParameter("source");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("source", source);
			PojoDomain<SysLogParam> list = sysLogParamService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysLogParam successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find sysLogParam fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}