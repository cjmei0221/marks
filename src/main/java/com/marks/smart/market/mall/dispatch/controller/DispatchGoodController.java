package com.marks.smart.market.mall.dispatch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.StockEnums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.dispatch.pojo.DispatchGood;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.service.GoodInfoService;
import com.marks.smart.market.mall.stock.pojo.StockInfo;
import com.marks.smart.market.mall.stock.service.StockInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

 /**
	 * 采购商品: 
	 */
@Controller
public class DispatchGoodController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DispatchGoodController.class);
    
	@Autowired
	private GoodInfoService goodInfoService;
	@Autowired
    private StockInfoService  stockInfoService;

    @Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询采购商品
	 */
	@RequestMapping("/inner/dispatchGood/findGoodInfoById")
	public void findGoodInfoById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String goodNo = request.getParameter("goodNo");
			
			String orgId=request.getParameter("orgId");
			
			String edit=request.getParameter("edit");
			DispatchGood info = new DispatchGood();
			if("1".equals(edit)) {
				info.setOrderGoodId(IDUtil.getNumID());
				result.getData().put("info", info);
				result.setMessage("findById successs!");
				result.setCode(Code.CODE_SUCCESS);
				JsonUtil.output(response, result);
				return;
			}
			logger.info("findDispatchGoodById > param>" + goodNo);
			GoodInfo good = goodInfoService.getGoodInfoByLike(admin.getCompanyId(), goodNo);
			if (null != good) {
				StockInfo stock=stockInfoService.findByOrgIdAndGoodNo(admin.getCompanyId(), orgId, good.getGoodNo());
				if(null !=stock) {
					info.setStockNums(stock.getStockNums());
				}
				info.setBarNo(good.getBarNo());
				info.setBrandId(good.getBrandId());
				info.setBrandName(good.getBrandName());
				info.setGoodNo(good.getGoodNo());
				info.setGoodId(good.getGoodId());
				info.setGoodName(good.getGoodName());
				info.setModel(good.getModel());
				info.setOrderGoodId(IDUtil.getNumID());
				info.setCostPrice(good.getCostPrice());
				info.setRank(good.getRank());
				info.setStockType(good.getStockManageType());
				info.setStockTypeName(StockEnums.StockManageType.getByKey(good.getStockManageType()));
				info.setTypeId(good.getTypeId());
				info.setTypeName(good.getTypeName());
				info.setUnit(good.getUnit());
				info.setSalePrice(good.getSalePrice());
				info.setSaleAmt("0");
				info.setTaxRate(0);
				info.setTaxAmt("0.00");
				info.setDispatchPrice(good.getDispatchPrice());
				if (!MoneyUtil.compare(info.getDispatchPrice(), "0.01")) {
					info.setDispatchPrice(info.getCostPrice());
				}
			}
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
}