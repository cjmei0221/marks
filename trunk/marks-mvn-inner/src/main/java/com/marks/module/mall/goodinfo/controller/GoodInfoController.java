package com.marks.module.mall.goodinfo.controller;

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
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.autocode.core.produced.SupportContorller;
import com.marks.module.mall.goodinfo.pojo.GoodImg;
import com.marks.module.mall.goodinfo.pojo.GoodInfo;
import com.marks.module.mall.goodinfo.service.GoodInfoService;
import com.marks.module.system.core.helper.SysUserHelper;
import com.marks.module.system.sysuser.pojo.SysUser;

@Controller
public class GoodInfoController extends SupportContorller {
	private static Logger logger = Logger.getLogger(GoodInfoController.class);

	@Autowired
	private GoodInfoService goodInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询商品管理
	 */
	@RequestMapping("/goodInfo/findGoodInfoById")
	public void findGoodInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodInfo goodInfo = getModel(GoodInfo.class);
			GoodInfo requestGoodInfo = goodInfoService.findById(goodInfo.getGoodId());
			result.getData().put("goodInfo", requestGoodInfo);
			result.setMessage("findById goodInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	@RequestMapping("/goodInfo/findGoodImgByGoodId")
	public void findGoodImgByGoodId(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodInfo goodInfo = getModel(GoodInfo.class);
			List<GoodImg> requestGoodInfo = goodInfoService.findGoodImgByGoodId(goodInfo.getGoodId());
			result.getData().put("goodImgList", requestGoodInfo);
			result.setMessage("findGoodImgByGoodId GoodImg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存商品管理
	 */
	@RequestMapping("/goodInfo/save")
	public void saveGoodInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			GoodInfo goodInfo = getModel(GoodInfo.class);
			
			GoodInfo old=goodInfoService.getGoodInfoBySkuNum(goodInfo.getSku_num());
			if(old !=null){
				result.setMessage("此商品编码已存在");
				result.setCode("4001");
			}else{
				goodInfo.setGoodId("P"+IDUtil.getTimeID());
				goodInfo.setImageUrl(request.getParameter("imageUrlPut"));
				String addMainImagePut=request.getParameter("addMainImagePut");
				String addDetailImagePut=request.getParameter("addDetailImagePut");
				goodInfo.setCreator(admin.getUserid());
				goodInfoService.save(goodInfo,addMainImagePut,addDetailImagePut);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改商品管理
	 */
	@RequestMapping("/goodInfo/update")
	public void updateGoodInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodInfo goodInfo = getModel(GoodInfo.class);
			GoodInfo ori = goodInfoService.findById(goodInfo.getGoodId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				GoodInfo sku = goodInfoService.getGoodInfoBySkuNum(goodInfo.getSku_num());
				if(sku !=null && !sku.getGoodId().equals(goodInfo.getGoodId())){
					result.setMessage("此商品编码已存在!");
					result.setCode("2001");
				}else{
					goodInfo.setImageUrl(request.getParameter("imageUrlPut"));
					String addMainImagePut=request.getParameter("addMainImagePut");
					String addDetailImagePut=request.getParameter("addDetailImagePut");
					goodInfoService.update(goodInfo,addMainImagePut,addDetailImagePut);
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
	 * 删除商品管理
	 */
	@RequestMapping("/goodInfo/delete")
	public void deleteGoodInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodInfo goodInfo = getModel(GoodInfo.class);
			goodInfoService.delete(goodInfo.getGoodId());
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
	 * 查询全部商品管理
	 */
	@RequestMapping("/goodInfo/findAllGoodInfo")
	public void findAllGoodInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<GoodInfo> goodInfoList = goodInfoService.findAll();
			result.getData().put("goodInfoList", goodInfoList);
			result.setMessage("findAll goodInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll goodInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个商品管理
	 */
	@RequestMapping("/goodInfo/deleteIds")
	public void deleteGoodInfo(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("goodId");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				goodInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete goodInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/goodInfo/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			PojoDomain<GoodInfo> list = goodInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find goodInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find goodInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除商品管理
	 */
	@RequestMapping("/goodSale/onsale")
	public void onsale(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String goodId=request.getParameter("goodId");
			GoodInfo goodInfo =goodInfoService.findById(goodId);
			if(null != goodInfo){
				if(Enums.GoodOnsale.onsale.getValue()==goodInfo.getOnsale_status()){
					goodInfoService.onsale(goodId,Enums.GoodOnsale.shelves.getValue());
					result.setMessage("下架成功!");
				}else{
					goodInfoService.onsale(goodId,Enums.GoodOnsale.onsale.getValue());
					result.setMessage("上架成功!");
				}
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}