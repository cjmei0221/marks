package com.marks.module.vip.coupon.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.IDUtil;
import com.marks.common.util.Code;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginInnerUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import com.marks.module.vip.coupon.pojo.VipCoupon;
import com.marks.module.vip.coupon.service.VipCouponService;

 /**
	 * 会员优惠券: 会员优惠券
	 */
@Controller
public class VipCouponController extends SupportContorller{
    private static Logger logger = Logger.getLogger( VipCouponController.class);
    
    @Autowired
    private VipCouponService  vipCouponService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询会员优惠券
	 */
    @RequestMapping("/inner/vipCoupon/findById")
    public void findVipCouponById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    VipCoupon vipCoupon = getModel(VipCoupon.class);
		    
		    logger.info("findVipCouponById > param>"+vipCoupon.getIdNo());
		    
			VipCoupon requestVipCoupon = vipCouponService.findById(vipCoupon.getIdNo());
			result.getData().put("vipCoupon",requestVipCoupon);
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
	 * 保存会员优惠券
	 */
    @RequestMapping("/inner/vipCoupon/save")
    public void saveVipCoupon(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
	    	VipCoupon vipCoupon = getModel(VipCoupon.class);
	 //     vipCoupon.setIdNo(IDUtil.getUUID());
	 		
	 		logger.info("saveVipCoupon > param>"+vipCoupon.toLog());
	 
			 VipCoupon ori=null;
	 		if(vipCoupon.getIdNo() != null){
	 			ori=vipCouponService.findById(vipCoupon.getIdNo());
	 		}
	 		
	 		if(ori==null){
	 			vipCouponService.save(vipCoupon);
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
	 * 更改会员优惠券
	 */
    @RequestMapping("/inner/vipCoupon/update")
    public void updateVipCoupon(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
		    VipCoupon vipCoupon = getModel(VipCoupon.class);
		    
		    logger.info(" updateVipCoupon> param>"+vipCoupon.toLog());
		    
		    VipCoupon ori=vipCouponService.findById(vipCoupon.getIdNo());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	vipCouponService.update(vipCoupon);
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
	 * 删除会员优惠券
	 */
    @RequestMapping("/inner/vipCoupon/delete")
    public void deleteVipCouponById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	VipCoupon vipCoupon = getModel(VipCoupon.class);
		   	
		   	logger.info("deleteVipCouponById > param>"+vipCoupon.getIdNo());
		   	
			vipCouponService.delete(vipCoupon.getIdNo());
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
	 * 查询全部会员优惠券
	 */

    /*@RequestMapping("/inner/vipCoupon/findAllVipCoupon")
    public void findAllVipCoupon(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<VipCoupon> vipCouponList = vipCouponService.findAll();
			result.getData().put("vipCouponList",vipCouponList);
			result.setMessage("findAll vipCoupon successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll vipCoupon fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个会员优惠券
	 */
	/*@RequestMapping("/inner/vipCoupon/deleteIds")
	public void deleteVipCoupon(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("idNo");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				vipCouponService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete vipCoupon fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/vipCoupon/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<VipCoupon> list = vipCouponService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find vipCoupon successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find vipCoupon fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}