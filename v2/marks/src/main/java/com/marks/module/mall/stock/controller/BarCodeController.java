package com.marks.module.mall.stock.controller;

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
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.good.service.GoodInfoService;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.service.BarCodeService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 条码管理: 条码管理
 */
@Controller
public class BarCodeController extends SupportContorller {
	private static Logger logger = Logger.getLogger(BarCodeController.class);
	@Autowired
	private GoodInfoService goodInfoService;
	@Autowired
	private BarCodeService barCodeService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询条码管理
	 */
	@RequestMapping("/inner/barCode/findById")
	public void findBarCodeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			BarCode reqVo = getModel(BarCode.class);

			logger.info("findBarCodeById > param>" + reqVo.getBarcode());

			BarCode info = barCodeService.findById(reqVo.getBarcode());
			result.getData().put("info", info);
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
	 * 删除条码管理
	 */
	@RequestMapping("/inner/barCode/delete")
	public void deleteBarCodeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			BarCode reqVo = getModel(BarCode.class);

			logger.info("deleteBarCodeById > param>" + reqVo.getBarcode());

			barCodeService.delete(reqVo.getBarcode());
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
	 * 查询全部条码管理
	 */

	/*
	 * @RequestMapping("/inner/barCode/findAllBarCode") public void
	 * findAllBarCode(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { List<BarCode> allList =
	 * barCodeService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll barCode successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll barCode fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个条码管理
	 */
	/*
	 * @RequestMapping("/inner/barCode/deleteIds") public void
	 * deleteBarCode(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("barcode"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ barCodeService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete barCode fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/barCode/list")
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
			if (keyword == null) {
				keyword = "";
			}
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<BarCode> list = barCodeService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find barCode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find barCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}