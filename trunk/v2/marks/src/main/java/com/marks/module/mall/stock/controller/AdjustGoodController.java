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
import com.marks.common.enums.StockEnums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.good.service.GoodInfoService;
import com.marks.module.mall.stock.pojo.AdjustGood;
import com.marks.module.mall.stock.service.AdjustGoodService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 调整商品: 
	 */
@Controller
public class AdjustGoodController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AdjustGoodController.class);
    
    @Autowired
    private AdjustGoodService  adjustGoodService;
	@Autowired
	private GoodInfoService goodInfoService;

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询调整商品
	 */
    @RequestMapping("/inner/adjustGood/findById")
    public void findAdjustGoodById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String goodNo = request.getParameter("goodNo");
			logger.info("findDispatchGoodById > param>" + goodNo);
			GoodInfo good = goodInfoService.getGoodInfoByLike(admin.getCompanyId(), goodNo);
			AdjustGood info = new AdjustGood();
			if (null != good) {
				info.setBarNo(good.getBarNo());
				info.setBrandId(good.getBrandId());
				info.setBrandName(good.getBrandName());
				info.setGoodNo(good.getGoodNo());
				info.setHelpCode(good.getHelpCode());
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
				info.setDispatchPrice(good.getDispatchPrice());
				if (!MoneyUtil.compare(info.getDispatchPrice(), "0.01")) {
					info.setDispatchPrice(info.getCostPrice());
				}
			}
			result.getData().put("info", info);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
  
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/adjustGood/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=request.getParameter("keyword");
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<AdjustGood> list = adjustGoodService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find adjustGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find adjustGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}