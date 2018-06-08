package com.marks.module.mall.dispatch.controller;

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
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.service.DispatchGoodService;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.good.service.GoodInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 采购商品: 
	 */
@Controller
public class DispatchGoodController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DispatchGoodController.class);
    
    @Autowired
    private DispatchGoodService  dispatchGoodService;
	@Autowired
	private GoodInfoService goodInfoService;

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
			logger.info("findDispatchGoodById > param>" + goodNo);
			GoodInfo good = goodInfoService.getGoodInfoByLike(admin.getCompanyId(), goodNo);
			DispatchGood info = new DispatchGood();
			if (null != good) {
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

    /**
	 * 查询采购商品
	 */
    @RequestMapping("/inner/dispatchGood/findById")
    public void findDispatchGoodById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    DispatchGood info = getModel(DispatchGood.class);
		    
		    logger.info("findDispatchGoodById > param>"+info.getOrderGoodId());
		    
			DispatchGood vo = dispatchGoodService.findById(info.getOrderGoodId());
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
	 * 保存采购商品
	 */
    @RequestMapping("/inner/dispatchGood/save")
    public void saveDispatchGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	DispatchGood info = getModel(DispatchGood.class);
	        info.setOrderGoodId(IDUtil.getUUID());
	 		
	 		logger.info("saveDispatchGood > param>"+info.toLog());
	 
			 DispatchGood ori=null;
	 		if(info.getOrderGoodId() != null){
	 			ori=dispatchGoodService.findById(info.getOrderGoodId());
	 		}
	 		
	 		if(ori==null){
	 			dispatchGoodService.save(info);
	 			result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
	 		}else{
	    		result.setMessage("此记录已存在");
				result.setCode(Code.CODE_FAIL);
	    	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改采购商品
	 */
    @RequestMapping("/inner/dispatchGood/update")
    public void updateDispatchGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    DispatchGood info = getModel(DispatchGood.class);
		    
		    logger.info(" updateDispatchGood> param>"+info.toLog());
		    
		    DispatchGood ori=dispatchGoodService.findById(info.getOrderGoodId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	dispatchGoodService.update(info);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
		    }
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除采购商品
	 */
    @RequestMapping("/inner/dispatchGood/delete")
    public void deleteDispatchGoodById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	DispatchGood info = getModel(DispatchGood.class);
		   	
		   	logger.info("deleteDispatchGoodById > param>"+info.getOrderGoodId());
		   	
			dispatchGoodService.delete(info.getOrderGoodId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部采购商品
	 */

    /*
    @RequestMapping("/inner/dispatchGood/findAllDispatchGood")
    public void findAllDispatchGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<DispatchGood> allList = dispatchGoodService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll dispatchGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll dispatchGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个采购商品
	 */
	/*
	@RequestMapping("/inner/dispatchGood/deleteIds")
	public void deleteDispatchGood(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("orderGoodId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				dispatchGoodService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete dispatchGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/dispatchGood/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<DispatchGood> list = dispatchGoodService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find dispatchGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find dispatchGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}