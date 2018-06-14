package com.marks.module.mall.dispatch.controller;

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
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.pojo.DispatchInfo;
import com.marks.module.mall.dispatch.service.DispatchGoodService;
import com.marks.module.mall.dispatch.service.DispatchInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 采购单:
 */
@Controller
public class DispatchInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(DispatchInfoController.class);

	@Autowired
	private DispatchInfoService dispatchInfoService;

	@Autowired
	private DispatchGoodService dispatchGoodService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询采购单
	 */
	@RequestMapping("/inner/dispatchInfo/findById")
	public void findDispatchInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String orderId = request.getParameter("orderId");

			String page_size = request.getParameter("page_size");

			int len = Integer.parseInt(page_size);

			DispatchInfo vo = dispatchInfoService.findById(orderId);
			if (vo == null) {
				vo = new DispatchInfo();
				vo.setOrderId(IDUtil.getProjectCode());
			}
			List<DispatchGood> list = dispatchGoodService.findByOrderId(orderId);
			if (null == list) {
				list = new ArrayList<DispatchGood>();
			}
			int size = list.size();
			if (size < len) {
				DispatchGood info = null;
				for (int i = size; i < len; i++) {
					info = new DispatchGood();
					info.setOrderGoodId(IDUtil.getNumID());
					list.add(info);
				}
			}
			result.getData().put("info", vo);
			result.getData().put("list", list);
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
	 * 保存采购单
	 */
	@RequestMapping("/inner/dispatchInfo/save")
	public void saveDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class);

			logger.info("saveDispatchInfo > param>" + info.toLog());

			DispatchInfo ori = null;
			if (info.getOrderId() != null) {
				ori = dispatchInfoService.findById(info.getOrderId());
			}

			if (ori == null) {
				dispatchInfoService.save(info);
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
	 * 更改采购单
	 */
	@RequestMapping("/inner/dispatchInfo/update")
	public void updateDispatchInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			DispatchInfo info = getModel(DispatchInfo.class);

			logger.info(" updateDispatchInfo> param>" + info.toLog());

			DispatchInfo ori = dispatchInfoService.findById(info.getOrderId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				dispatchInfoService.update(info);
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
	 * 删除采购单
	 */
	@RequestMapping("/inner/dispatchInfo/delete")
	public void deleteDispatchInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			DispatchInfo info = getModel(DispatchInfo.class);

			logger.info("deleteDispatchInfoById > param>" + info.getOrderId());

			dispatchInfoService.delete(info.getOrderId());
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
	 * 查询全部采购单
	 */

	/*
	 * @RequestMapping("/inner/dispatchInfo/findAllDispatchInfo") public void
	 * findAllDispatchInfo(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { List<DispatchInfo> allList
	 * = dispatchInfoService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll dispatchInfo successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll dispatchInfo fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个采购单
	 */
	/*
	 * @RequestMapping("/inner/dispatchInfo/deleteIds") public void
	 * deleteDispatchInfo(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { String id =
	 * request.getParameter("orderId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ dispatchInfoService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete dispatchInfo fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/dispatchInfo/list")
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
			PojoDomain<DispatchInfo> list = dispatchInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find dispatchInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find dispatchInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}