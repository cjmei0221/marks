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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.order.pojo.OrderInfo;
import com.marks.module.mall.order.service.OrderInfoService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 订单管理: 订单信息
	 */
@Controller
public class OrderInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( OrderInfoController.class);
    
    @Autowired
    private OrderInfoService  orderInfoService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询订单管理
	 */
    @RequestMapping("/inner/orderInfo/findById")
    public void findOrderInfoById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    OrderInfo info = getModel(OrderInfo.class);
		    
		    logger.info("findOrderInfoById > param>"+info.getOrderId());
		    
			OrderInfo vo = orderInfoService.findById(info.getOrderId());
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
	 * 保存订单管理
	 */
	
	/**
	 * 更改订单管理
	 */
    @RequestMapping("/inner/orderInfo/update")
    public void updateOrderInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    OrderInfo info = getModel(OrderInfo.class);
		    
		    logger.info(" updateOrderInfo> param>"+info.toLog());
		    
		    OrderInfo ori=orderInfoService.findById(info.getOrderId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	orderInfoService.update(info);
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
	 * 删除订单管理
	 */
    @RequestMapping("/inner/orderInfo/delete")
    public void deleteOrderInfoById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	OrderInfo info = getModel(OrderInfo.class);
		   	
		   	logger.info("deleteOrderInfoById > param>"+info.getOrderId());
		   	
			orderInfoService.delete(info.getOrderId());
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
	 * 查询全部订单管理
	 */

    /*
    @RequestMapping("/inner/orderInfo/findAllOrderInfo")
    public void findAllOrderInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<OrderInfo> allList = orderInfoService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll orderInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll orderInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个订单管理
	 */
	/*
	@RequestMapping("/inner/orderInfo/deleteIds")
	public void deleteOrderInfo(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("orderId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				orderInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete orderInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/orderInfo/list")
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
			PojoDomain<OrderInfo> list = orderInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find orderInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find orderInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}