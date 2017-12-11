package com.marks.module.asset.base.controller.web;

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
import com.marks.common.enums.AssetEnums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.asset.base.pojo.AssetLog;
import com.marks.module.asset.base.pojo.AssetLogCount;
import com.marks.module.asset.base.service.AssetLogService;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.WebUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 记账: 记录日常交易等
 */
@Controller
public class WebAssetLogController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WebAssetLogController.class);

	@Autowired
	private AssetLogService assetLogService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询记账
	 */
	@RequestMapping("/web/assetLog/findById")
	public void findAssetLogById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			AssetLog info = getModel(AssetLog.class);

			logger.info("findAssetLogById > param>" + info.getId());

			AssetLog vo = assetLogService.findById(info.getId());
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
	 * 保存记账
	 */
	@RequestMapping("/web/assetLog/save")
	public void saveAssetLog(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = WebUtil.getInstance().getCurrentUser(request);
			AssetLog info = getModel(AssetLog.class);
			logger.info("saveAssetLog > param>" + info.toLog());
			AssetLog ori = null;
			if (info.getId() != null) {
				ori = assetLogService.findById(info.getId());
			}
			if (null != info.getItemType() && !"".equals(info.getItemType())) {
				info.setItemName(AssetEnums.ItemType.getByKey(info.getItemType()));
			}
			if (ori == null) {
				info.setMobile(admin.getBind_mobile());
				info.setUserid(admin.getUserid());
				info.setUsername(admin.getUsername());
				assetLogService.save(info);
			} else {
				assetLogService.update(info);
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
	 * 更改记账
	 */
	@RequestMapping("/web/assetLog/update")
	public void updateAssetLog(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = WebUtil.getInstance().getCurrentUser(request);
			AssetLog info = getModel(AssetLog.class);

			logger.info(" updateAssetLog> param>" + info.toLog());

			AssetLog ori = assetLogService.findById(info.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				if (null != info.getItemType() && !"".equals(info.getItemType())) {
					info.setItemName(AssetEnums.ItemType.getByKey(info.getItemType()));
				}
				assetLogService.update(info);
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
	 * 删除记账
	 */
	@RequestMapping("/web/assetLog/delete")
	public void deleteAssetLogById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			AssetLog info = getModel(AssetLog.class);

			logger.info("deleteAssetLogById > param>" + info.getId());

			assetLogService.delete(info.getId());
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
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/web/assetLog/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = WebUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = request.getParameter("keyword");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("userid", admin.getUserid());
			PojoDomain<AssetLog> list = assetLogService.list(page_number, page_size, param);
			List<AssetLogCount> countList = assetLogService.countAmount(param);
			result.getData().put("countList", countList);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find assetLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find assetLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 年统计
	 */
	@RequestMapping("/web/assetLog/listCount")
	public void listCount(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = WebUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = request.getParameter("keyword");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("userid", admin.getUserid());
			PojoDomain<AssetLogCount> list = assetLogService.listCount(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find assetLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find assetLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 日统计
	 */
	@RequestMapping("/web/assetLog/listDayCount")
	public void listDayCount(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = WebUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = request.getParameter("keyword");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("userid", admin.getUserid());
			PojoDomain<AssetLogCount> list = assetLogService.listDayCount(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find assetLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find assetLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}