package com.marks.module.mall.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.base.pojo.Category;
import com.marks.module.mall.base.service.CategoryService;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.good.service.GoodInfoService;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 品类管理: 商品品类管理
 */
@Controller
public class CategoryController extends SupportContorller {
	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private GoodInfoService goodInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询品类管理
	 */
	@RequestMapping("/inner/category/findById")
	public void findCategoryById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Category reqVo = getModel(Category.class);

			logger.info("findCategoryById > param>" + reqVo.getTypeId());

			Category info = categoryService.findById(reqVo.getTypeId());
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
	 * 保存品类管理
	 */
	@RequestMapping("/inner/category/save")
	public void saveCategory(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			Category reqVo = getModel(Category.class);
			reqVo.setTypeId("T" + IDUtil.getDateID() + IDUtil.getRandom(1000, 9999));
			reqVo.setCompanyId(admin.getCompanyId());
			logger.info("saveCategory > param>" + reqVo.toLog());

			Category ori = null;
			if (reqVo.getTypeId() != null) {
				ori = categoryService.findById(reqVo.getTypeId());
			}

			if (ori == null) {
				Category parentVo = null;
				if ("top".equals(reqVo.getParentId())) {
					parentVo = new Category();
					parentVo.setLvl(0);
					reqVo.setParentId(admin.getCompanyId());
					reqVo.setLvl(1);
				} else {
					parentVo = categoryService.findById(reqVo.getParentId());
					reqVo.setLvl(parentVo.getLvl() + 1);
					reqVo.setParentName(parentVo.getParentName());
				}

				reqVo.setLvl1Id(parentVo.getLvl1Id());
				reqVo.setLvl1Name(parentVo.getLvl1Name());

				reqVo.setLvl2Id(parentVo.getLvl2Id());
				reqVo.setLvl2Name(parentVo.getLvl2Name());

				reqVo.setLvl3Id(parentVo.getLvl3Id());
				reqVo.setLvl3Name(parentVo.getLvl3Name());

				reqVo.setLvl4Id(parentVo.getLvl4Id());
				reqVo.setLvl4Name(parentVo.getLvl4Name());

				reqVo.setLvl5Id(parentVo.getLvl5Id());
				reqVo.setLvl5Name(parentVo.getLvl5Name());

				if (reqVo.getLvl() == 1) {
					reqVo.setLvl1Id(reqVo.getTypeId());
					reqVo.setLvl1Name(reqVo.getTypeName());
				} else if (reqVo.getLvl() == 2) {
					reqVo.setLvl2Id(reqVo.getTypeId());
					reqVo.setLvl2Name(reqVo.getTypeName());
				} else if (reqVo.getLvl() == 3) {
					reqVo.setLvl3Id(reqVo.getTypeId());
					reqVo.setLvl3Name(reqVo.getTypeName());
				} else if (reqVo.getLvl() == 4) {
					reqVo.setLvl4Id(reqVo.getTypeId());
					reqVo.setLvl4Name(reqVo.getTypeName());
				} else if (reqVo.getLvl() == 5) {
					reqVo.setLvl5Id(reqVo.getTypeId());
					reqVo.setLvl5Name(reqVo.getTypeName());
				}
				categoryService.save(reqVo);
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
	 * 更改品类管理
	 */
	@RequestMapping("/inner/category/update")
	public void updateCategory(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			Category reqVo = getModel(Category.class);

			logger.info(" updateCategory> param>" + reqVo.toLog());

			Category ori = categoryService.findById(reqVo.getTypeId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				categoryService.update(reqVo);
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
	 * 删除品类管理
	 */
	@RequestMapping("/inner/category/delete")
	public void deleteCategoryById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			Category reqVo = getModel(Category.class);

			logger.info("deleteCategoryById > param>" + reqVo.getTypeId());
			List<Category> clist = categoryService.treeGrid(admin.getCompanyId(), reqVo.getTypeId());
			if (null != clist && clist.size() > 0) {
				result.setMessage("有子节点，不能删除！");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}

			List<GoodInfo> glist = goodInfoService.listGoodByTypeId(reqVo.getTypeId());
			if (null != glist && glist.size() > 0) {
				result.setMessage("有关联商品，不能删除！");
				result.setCode(Code.CODE_FAIL);
				JsonUtil.output(response, result);
				return;
			}
			categoryService.delete(reqVo.getTypeId());
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
	 * 查询全部品类管理
	 */

	/*
	 * @RequestMapping("/inner/category/findAllCategory") public void
	 * findAllCategory(HttpServletRequest request, HttpServletResponse
	 * response){ Result result = new Result(); try { List<Category> allList =
	 * categoryService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll category successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll category fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个品类管理
	 */
	/*
	 * @RequestMapping("/inner/category/deleteIds") public void
	 * deleteCategory(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("cId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ categoryService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete category fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/category/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		SysUser admin = ManageUtil.getCurrentUserInfo(request);

		String parentId = request.getParameter("parentId");
		String companyId = admin.getCompanyId();
		List<Category> list = null;
		// 根节点加载
		if (parentId == null || "".equals(parentId)) {
			parentId = companyId;
		}
		list = categoryService.treeGrid(companyId, parentId);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
		return;
	}

}