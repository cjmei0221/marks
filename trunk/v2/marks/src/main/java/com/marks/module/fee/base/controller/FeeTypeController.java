package com.marks.module.fee.base.controller;

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
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.fee.base.pojo.FeeType;
import com.marks.module.fee.base.service.FeeTypeService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 费用科目:
 */
@Controller
public class FeeTypeController extends SupportContorller {
	private static Logger logger = Logger.getLogger(FeeTypeController.class);

	@Autowired
	private FeeTypeService feeTypeService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询费用科目
	 */
	@RequestMapping("/inner/feeType/findById")
	public void findFeeTypeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			FeeType info = getModel(FeeType.class);

			logger.info("findFeeTypeById > param>" + info.getTypeId());

			FeeType vo = feeTypeService.findById(info.getTypeId());
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
	@RequestMapping("/inner/feeType/save")
	public void saveFeeType(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			FeeType info = getModel(FeeType.class);
			info.setCompanyId(admin.getCompanyId());
			info.setUpdater(admin.getOperator());
			info.setTypeId(info.getCompanyId() + info.getTypeCode());

			logger.info("saveFeeType > param>" + info.toLog());

			FeeType ori = null;
			if (info.getTypeId() != null) {
				ori = feeTypeService.findById(info.getTypeId());
			}

			if (ori == null) {
				feeTypeService.save(info);
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
	 * 更改费用科目
	 */
	@RequestMapping("/inner/feeType/update")
	public void updateFeeType(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			FeeType info = getModel(FeeType.class);

			logger.info(" updateFeeType> param>" + info.toLog());

			FeeType ori = feeTypeService.findById(info.getTypeId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				info.setUpdater(admin.getOperator());
				feeTypeService.update(info);
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
	 * 删除费用科目
	 */
	@RequestMapping("/inner/feeType/delete")
	public void deleteFeeTypeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			FeeType info = getModel(FeeType.class);

			logger.info("deleteFeeTypeById > param>" + info.getTypeId());

			feeTypeService.delete(info.getTypeId());
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
	 * 查询全部费用科目
	 */

	/*
	 * @RequestMapping("/inner/feeType/findAllFeeType") public void
	 * findAllFeeType(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { List<FeeType> allList =
	 * feeTypeService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll feeType successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll feeType fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个费用科目
	 */
	/*
	 * @RequestMapping("/inner/feeType/deleteIds") public void
	 * deleteFeeType(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("typeId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ feeTypeService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete feeType fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/feeType/list")
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
			PojoDomain<FeeType> list = feeTypeService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find feeType successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find feeType fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/feeType/combobox")
	public void combobox(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		List<FeeType> allList = feeTypeService.findAll();
		JsonUtil.output(response, JSONArray.fromObject(allList).toString());
	}
}