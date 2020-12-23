package com.marks.smart.market.mall.stock.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.stock.pojo.StockInfo;
import com.marks.smart.market.mall.stock.service.StockInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

 /**
	 * 库存管理: 库存管理
	 */
@Controller
public class StockInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( StockInfoController.class);
    
    @Autowired
    private StockInfoService  stockInfoService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询库存管理
	 */
    @RequestMapping("/inner/stockInfo/findById")
    public void findStockInfoById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    StockInfo info = getModel(StockInfo.class,request.getParameterMap());
		    
		    logger.info("findStockInfoById > param>"+info.getStockId());
		    
			StockInfo vo = stockInfoService.findById(info.getStockId());
			result.getData().put("info",vo);
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
	 * 查询全部库存管理
	 */

    /*
    @RequestMapping("/inner/stockInfo/findAllStockInfo")
    public void findAllStockInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<StockInfo> allList = stockInfoService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll stockInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll stockInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个库存管理
	 */
	/*
	@RequestMapping("/inner/stockInfo/deleteIds")
	public void deleteStockInfo(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("stockId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				stockInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete stockInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/stockInfo/list")
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
			param.put("companyId", admin.getCompanyId());
			PojoDomain<StockInfo> list = stockInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find stockInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find stockInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}