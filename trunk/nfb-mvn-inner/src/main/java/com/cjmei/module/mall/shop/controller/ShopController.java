package com.cjmei.module.mall.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.enums.Enums;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.mall.shop.pojo.ShopInfo;
import com.cjmei.module.mall.shop.service.ShopService;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysUser;
/**
 * 店铺公司控制层
 * @author cjmei
 *
 */
@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;

	/**
	 * 获取当前用户的商铺列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shop/getShopList")
	public void getShopList(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		int page_number = Integer.parseInt(request.getParameter("page_number")==null?"1":request.getParameter("page_number"));
		int page_size = Integer.parseInt(request.getParameter("page_size")==null?"10000":request.getParameter("page_size"));
		String keyword=request.getParameter("keyword");
		PojoDomain<ShopInfo> list = shopService.getShopList(admin,Enums.Shop.shop.getValue(),page_number,page_size,keyword);
		result.getData().put("list", list.getPojolist());
		result.setPageNumber(list.getPage_number());
		result.setPageSize(list.getPage_size());
		result.setPageTotal(list.getPage_total());
		result.setTotalCount(list.getTotal_count());
		JsonUtil.output(response, result);
	}
	
	/**
	 * 获取当前用户的商铺列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("/shop/getCompanyList")
	public void getCompanyList(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		int page_number = Integer.parseInt(request.getParameter("page_number")==null?"1":request.getParameter("page_number"));
		int page_size = Integer.parseInt(request.getParameter("page_size")==null?"10000":request.getParameter("page_size"));
		String keyword=request.getParameter("keyword");
		PojoDomain<ShopInfo> list = shopService.getShopList(admin,Enums.Shop.company.getValue(),page_number,page_size,keyword);
		result.getData().put("list", list.getPojolist());
		result.setPageNumber(list.getPage_number());
		result.setPageSize(list.getPage_size());
		result.setPageTotal(list.getPage_total());
		result.setTotalCount(list.getTotal_count());
		JsonUtil.output(response, result);
	}


	
}
