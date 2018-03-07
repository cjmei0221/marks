package com.marks.module.mall.order.controller;

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
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.service.OrderGoodService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 订单商品: 订单商品
	 */
@Controller
public class OrderGoodController extends SupportContorller{
    private static Logger logger = Logger.getLogger( OrderGoodController.class);
    
    @Autowired
    private OrderGoodService  orderGoodService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 保存订单商品
	 */
    @RequestMapping("/inner/orderGood/save")
    public void saveOrderGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	OrderGood info = getModel(OrderGood.class);
	        info.setOrderGoodId(IDUtil.getUUID());
	 		
	 		logger.info("saveOrderGood > param>"+info.toLog());
	 
			 OrderGood ori=null;
	 		if(info.getOrderGoodId() != null){
	 			ori=orderGoodService.findById(info.getOrderGoodId());
	 		}
	 		
	 		if(ori==null){
	 			orderGoodService.save(info);
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
	 * 更改订单商品
	 */
    @RequestMapping("/inner/orderGood/update")
    public void updateOrderGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    OrderGood info = getModel(OrderGood.class);
		    
		    logger.info(" updateOrderGood> param>"+info.toLog());
		    
		    OrderGood ori=orderGoodService.findById(info.getOrderGoodId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	orderGoodService.update(info);
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
	 * 删除订单商品
	 */
    @RequestMapping("/inner/orderGood/delete")
    public void deleteOrderGoodById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	OrderGood info = getModel(OrderGood.class);
		   	
		   	logger.info("deleteOrderGoodById > param>"+info.getOrderGoodId());
		   	
			orderGoodService.delete(info.getOrderGoodId());
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
	 * 查询全部订单商品
	 */

    /*
    @RequestMapping("/inner/orderGood/findAllOrderGood")
    public void findAllOrderGood(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<OrderGood> allList = orderGoodService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll orderGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll orderGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个订单商品
	 */
	/*
	@RequestMapping("/inner/orderGood/deleteIds")
	public void deleteOrderGood(HttpServletRequest request,
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
				orderGoodService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete orderGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/orderGood/list")
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
			PojoDomain<OrderGood> list = orderGoodService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find orderGood successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find orderGood fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}