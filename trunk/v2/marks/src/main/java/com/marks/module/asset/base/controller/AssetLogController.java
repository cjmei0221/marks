package com.marks.module.asset.base.controller;

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
import com.marks.common.domain.TreeVo;
import com.marks.common.enums.AssetEnums;
import com.marks.common.enums.AssetEnums.ItemType;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.asset.base.pojo.AssetLog;
import com.marks.module.asset.base.service.AssetLogService;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 记账: 记录日常交易等
 */
@Controller
public class AssetLogController extends SupportContorller {
	private static Logger logger = Logger.getLogger(AssetLogController.class);

	@Autowired
	private AssetLogService assetLogService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询记账
	 */
	@RequestMapping("/inner/assetLog/findById")
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
	@RequestMapping("/inner/assetLog/save")
	public void saveAssetLog(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			AssetLog info = getModel(AssetLog.class);
			info.setId("I_" + IDUtil.getDateID() + "_" + IDUtil.getID(8));

			logger.info("saveAssetLog > param>" + info.toLog());
			info.setMobile(admin.getBind_mobile());
			info.setUserid(admin.getUserid());
			info.setUsername(admin.getUsername());
			if (null != info.getItemType() && !"".equals(info.getItemType())) {
				info.setItemName(AssetEnums.ItemType.getByKey(info.getItemType()));
			}
			assetLogService.save(info);
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
	@RequestMapping("/inner/assetLog/update")
	public void updateAssetLog(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
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
	@RequestMapping("/inner/assetLog/delete")
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
	 * 查询全部记账
	 */

	/*
	 * @RequestMapping("/inner/assetLog/findAllAssetLog") public void
	 * findAllAssetLog(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { List<AssetLog> allList =
	 * assetLogService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll assetLog successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll assetLog fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个记账
	 */
	/*
	 * @RequestMapping("/inner/assetLog/deleteIds") public void
	 * deleteAssetLog(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("id"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ assetLogService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete assetLog fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/assetLog/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
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

	@RequestMapping("/inner/assetLogItemType")
	public void combo(HttpServletRequest request, HttpServletResponse response) {
		List<TreeVo> list = new ArrayList<TreeVo>();
		TreeVo vo = null;
		for (ItemType c : AssetEnums.ItemType.values()) {
			vo = new TreeVo();
			vo.setId(c.getValue());
			vo.setText(c.getName());
			list.add(vo);
		}
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

}