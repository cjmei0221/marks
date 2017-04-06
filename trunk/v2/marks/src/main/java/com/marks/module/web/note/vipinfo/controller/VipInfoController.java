package com.marks.module.web.note.vipinfo.controller;

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
import com.marks.module.inner.note.vipinfo.pojo.VipInfo;
import com.marks.module.inner.note.vipinfo.service.VipInfoService;
import com.marks.module.inner.system.sys.controller.SupportContorller;
import com.marks.module.inner.system.sysuser.pojo.SysUser;
import com.marks.module.web.system.login.util.LoginUtil;

@Controller
public class VipInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(VipInfoController.class);

	@Autowired
	private VipInfoService vipInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询会员信息
	 */
	@RequestMapping("/vipInfo/findVipInfoById")
	public void findVipInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
			VipInfo requestVipInfo = vipInfoService.findVipDetailInfoById(loginUser.getUserid());
			result.getData().put("vipInfo", requestVipInfo);
			result.setMessage("findById vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存会员信息
	 */
	@RequestMapping("/vipInfo/save")
	public void saveVipInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			VipInfo vipInfo = getModel(VipInfo.class);
			vipInfo.setUserid(admin.getUserid());
			VipInfo ori = null;
			ori = vipInfoService.findById(vipInfo.getUserid());
			if (ori == null ) {
				vipInfoService.save(vipInfo);
			} else {
				vipInfoService.update(vipInfo);
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
	 * 更改会员信息
	 */
	@RequestMapping("/vipInfo/update")
	public void updateVipInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			VipInfo vipInfo = getModel(VipInfo.class);
			VipInfo ori = vipInfoService.findById(vipInfo.getUserid());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				vipInfoService.update(vipInfo);
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
	 * 删除会员信息
	 */
	@RequestMapping("/vipInfo/delete")
	public void deleteVipInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			VipInfo vipInfo = getModel(VipInfo.class);
			vipInfoService.delete(vipInfo.getUserid());
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
	 * 查询全部会员信息
	 */
	@RequestMapping("/vipInfo/findAllVipInfo")
	public void findAllVipInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<VipInfo> vipInfoList = vipInfoService.findAll();
			result.getData().put("vipInfoList", vipInfoList);
			result.setMessage("findAll vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个会员信息
	 */
	@RequestMapping("/vipInfo/deleteIds")
	public void deleteVipInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("userid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				vipInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/vipInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			PojoDomain<VipInfo> list = vipInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}