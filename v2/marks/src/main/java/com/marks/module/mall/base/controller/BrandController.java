package com.marks.module.mall.base.controller;

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
import com.marks.module.mall.base.pojo.Brand;
import com.marks.module.mall.base.service.BrandService;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.good.service.GoodInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 品牌管理: 品牌管理
 */
@Controller
public class BrandController extends SupportContorller {
	private static Logger logger = Logger.getLogger(BrandController.class);

	@Autowired
	private BrandService brandService;

	@Autowired
	private GoodInfoService goodInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询品牌管理
	 */
	@RequestMapping("/inner/brand/findById")
	public void findBrandById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Brand reqVo = getModel(Brand.class);

			logger.info("findBrandById > param>" + reqVo.getBrandId());

			Brand info = brandService.findById(reqVo.getBrandId());
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
	 * 保存品牌管理
	 */
	@RequestMapping("/inner/brand/save")
	public void saveBrand(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			Brand reqVo = getModel(Brand.class);
			reqVo.setBrandId(brandService.getBrandId());

			logger.info("saveBrand > param>" + reqVo.toLog());

			Brand ori = null;
			if (reqVo.getBrandId() != null) {
				ori = brandService.findById(reqVo.getBrandId());
			}

			if (ori == null) {
				reqVo.setCompanyId(admin.getCompanyId());
				reqVo.setCreator(admin.getOperator());
				brandService.save(reqVo);
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
	 * 更改品牌管理
	 */
	@RequestMapping("/inner/brand/update")
	public void updateBrand(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			Brand reqVo = getModel(Brand.class);

			logger.info(" updateBrand> param>" + reqVo.toLog());

			Brand ori = brandService.findById(reqVo.getBrandId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				brandService.update(reqVo);
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
	 * 删除品牌管理
	 */
	@RequestMapping("/inner/brand/delete")
	public void deleteBrandById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Brand reqVo = getModel(Brand.class);

			logger.info("deleteBrandById > param>" + reqVo.getBrandId());
			List<GoodInfo> glist = goodInfoService.listGoodByBrandId(reqVo.getTypeId());
			if (null != glist && glist.size() > 0) {
				result.setMessage("有关联商品，不能删除！");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			brandService.delete(reqVo.getBrandId());
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
	 * 查询全部品牌管理
	 */

	@RequestMapping("/inner/brand/brandbox")
	public void findAllBrand(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String typeId = request.getParameter("typeId");
		List<Brand> allList = brandService.findListByTypeId(admin.getCompanyId(), typeId);

		JsonUtil.output(response, JSONArray.fromObject(allList).toString());
	}

	/**
	 * 删除多个品牌管理
	 */
	/*
	 * @RequestMapping("/inner/brand/deleteIds") public void
	 * deleteBrand(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("brandId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ brandService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete brand fail!"); result.setCode(Code.CODE_FAIL);
	 * } JsonUtil.output(response, result); }
	 */

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/brand/list")
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
			PojoDomain<Brand> list = brandService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find brand successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find brand fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}