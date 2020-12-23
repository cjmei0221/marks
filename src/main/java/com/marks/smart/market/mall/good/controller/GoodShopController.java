package com.marks.smart.market.mall.good.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.pojo.GoodShop;
import com.marks.smart.market.mall.good.service.GoodShopService;
import com.marks.smart.system.org.orginfo.pojo.OrgInfo;
import com.marks.smart.system.org.orginfo.service.OrgInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

/**
 * 门店商品: 门店商品
 */
@Controller
public class GoodShopController extends SupportContorller {
	private static Logger logger = Logger.getLogger(GoodShopController.class);

	@Autowired
	private GoodShopService goodShopService;
	@Autowired
	private OrgInfoService orgInfoService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询门店商品
	 */
	@RequestMapping("/inner/goodShop/findGoodInoById")
	public void findGoodInoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			if ("1".equals(request.getParameter("edit"))) {
				GoodShop vo = new GoodShop();
				vo.setGoodShopId(IDUtil.getNumID());
				result.getData().put("info", vo);
				result.setMessage(" successs!");
				result.setCode(Code.CODE_SUCCESS);
				JsonUtil.output(response, result);
				return;
			}
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			GoodShop info = getModel(GoodShop.class,request.getParameterMap());
			GoodShop vo = goodShopService.findGoodShopByGoodNo(admin.getCompanyId(), info.getGoodNo(), info.getShopId());
			result.getData().put("info", vo);
			result.setMessage(" successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改门店商品
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/goodShop/save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String shopId=request.getParameter("shopId");
			String goodObj = request.getParameter("goodData");
			List<GoodShop> goodList = (List<GoodShop>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
					GoodShop.class);
			if(null != goodList && goodList.size()>0) {

				OrgInfo org = orgInfoService.findById(shopId);
				for(GoodShop info:goodList) {
					info.setCompanyId(admin.getCompanyId());
					info.setGoodShopId(shopId + info.getGoodNo());
					if (org != null) {
						info.setShopName(org.getOrgname());
					}
					info.setUpdater(admin.getOperator());
					info.setUpdaterCode(admin.getUserCode());
					info.setOnsale_status(1);
					GoodShop ori = goodShopService.findById(info.getGoodShopId());
					if (ori == null) {
						goodShopService.save(info);
					} else {
						goodShopService.update(info);
					}
				}
			}
			result.setMessage("更新成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改门店商品
	 */
	@RequestMapping("/inner/goodShop/update")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			GoodShop info = getModel(GoodShop.class,request.getParameterMap());
			info.setGoodShopId(info.getShopId() + info.getGoodNo());
			OrgInfo org = orgInfoService.findById(info.getShopId());
			if (org != null) {
				info.setShopName(org.getOrgname());
			}
			info.setUpdater(admin.getOperator());
			info.setUpdaterCode(admin.getUserCode());
			info.setCompanyId(admin.getCompanyId());
			GoodShop ori = goodShopService.findById(info.getGoodShopId());
			if (ori == null) {
				goodShopService.save(info);
			} else {
				goodShopService.update(info);
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
	 * 删除门店商品
	 */
	@RequestMapping("/inner/goodShop/delete")
	public void deleteById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			GoodShop info = getModel(GoodShop.class,request.getParameterMap());
			goodShopService.delete(info.getGoodShopId());
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
	 * 查询全部门店商品
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/goodShop/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String shopId = request.getParameter("shopId");
			if (shopId == null) {
				shopId = "";
			}
			String keyword = request.getParameter("keyword");
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("shopId", shopId);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<GoodInfo> list = goodShopService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.getData().put("shopId", shopId);
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("list successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("list fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}