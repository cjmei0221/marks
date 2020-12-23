package com.marks.smart.market.mall.order.controller;

import java.util.ArrayList;
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
import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.OrderEnums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.market.mall.order.pojo.OrderGood;
import com.marks.smart.market.mall.order.pojo.OrderInfo;
import com.marks.smart.market.mall.order.service.OrderGoodService;
import com.marks.smart.market.mall.order.service.OrderInfoService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import net.sf.json.JSONArray;

 /**
	 * 订单管理: 订单信息
	 */
@Controller
public class OrderInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( OrderInfoController.class);
    
    @Autowired
    private OrderInfoService  orderInfoService;
   
	@Autowired
	private OrderGoodService orderGoodService;
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
			String orderId = request.getParameter("orderId");

			String page_size = request.getParameter("page_size");

			String formStatus = request.getParameter("formStatus");

			int len = 1;

			OrderInfo vo = orderInfoService.findById(orderId);
			if (vo == null) {
				vo = new OrderInfo();
			}
			List<OrderGood> list = orderGoodService.findByOrderId(orderId);
			if (null == list) {
				list = new ArrayList<OrderGood>();
			}
			if(list.size()>0) {
				for(OrderGood good:list) {
					good.setNowPrice(good.getPayPrice());
					good.setPayPrice(MoneyUtil.divide(good.getRecevieAmt(), good.getNums()+""));
				}
			}
			if ("new".equals(formStatus) || "edit".equals(formStatus)) {
				int size = list.size();
				if (size < len) {
					OrderGood info = null;
					for (int i = size; i < len; i++) {
						info = new OrderGood();
						info.setOrderGoodId(IDUtil.getNumID());
						list.add(info);
					}
				}
			}
			result.getData().put("info", vo);
			result.getData().put("list", list);
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
	 * 退货
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/inner/orderInfo/refund")
	public void refund(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    OrderInfo info = getModel(OrderInfo.class,request.getParameterMap());
			info.setOldOrderId(info.getOrderId());

			String goodObj = request.getParameter("goodData");
			List<OrderGood> goodList = (List<OrderGood>) JSONArray.toCollection(JSONArray.fromObject(goodObj),
					OrderGood.class);
			for (OrderGood good : goodList) {
				good.setOldOrderGoodId(good.getOrderGoodId());
				good.setNums(-good.getRefundNums());
				good.setPayableAmt(MoneyUtil.multiply("" + good.getNums(), good.getPayPrice()));
				good.setNowPrice(good.getPayPrice());
			}

			info.setOrderId(orderInfoService.getOrderId());
			info.setCashDate(DateUtil.getCurrDateStr().substring(0, 10));
			info.setCashAmt("-" + info.getRefundAmt());
			info.setCashMan(admin.getUsername());
			info.setCashManId(admin.getUserid());
			info.setCashManCode(admin.getUserCode());
			info.setCashType(OrderEnums.CashType.refund.getValue());
			info.setYwType(OrderEnums.YwType.good.getValue());
			info.setCommitTime(DateUtil.getCurrDateStr());
			info.setCompanyId(admin.getCompanyId());
			info.setOrderStatus(OrderEnums.OrderStatus.complete.getValue());
			info.setOrderStatusName(OrderEnums.OrderStatus.getByKey(info.getOrderStatus()));
			info.setOrgId(admin.getOrgId());
			info.setOrgName(admin.getOrgName());
			info.setPayAmt("-" + info.getRefundAmt());
			info.setPayableAmt("-" + info.getRefundAmt());
			info.setPayStatus(1);
			info.setVipId(info.getVipMobile());
			info.setPayTypeCode(OrderEnums.PayType.cash.getValue());
			info.setPayTypeName(OrderEnums.PayType.getByKey(info.getPayTypeCode()));
			info.setChannelId(ChannelEnums.Channel.manage.getValue());
			info.setCompanyName(admin.getCompanyName());
			orderInfoService.saveRefund(info, goodList, null);
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
		   	OrderInfo info = getModel(OrderInfo.class,request.getParameterMap());
		   	
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
			param.put("companyId", admin.getCompanyId());
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