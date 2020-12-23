package com.marks.smart.market.mall.pay.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.IDUtil;
import com.marks.common.util.Code;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

import com.marks.smart.market.mall.pay.pojo.PayAcct;
import com.marks.smart.market.mall.pay.service.PayAcctService;

 /**
	 * 支付账户: 支付账户
	 */
@Controller
public class PayAcctController extends SupportContorller{
    private static Logger logger = Logger.getLogger( PayAcctController.class);
    
    @Autowired
    private PayAcctService  payAcctService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询支付账户
	 */
    @RequestMapping("/inner/payAcct/findById")
    public void findPayAcctById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    PayAcct info = getModel(PayAcct.class,request.getParameterMap());
		    
		    logger.info("findPayAcctById > param>"+info.getId());
		    
			PayAcct vo = payAcctService.findById(info.getId());
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
	 * 保存支付账户
	 */
    @RequestMapping("/inner/payAcct/save")
    public void savePayAcct(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	PayAcct info = getModel(PayAcct.class,request.getParameterMap());
	        info.setId(IDUtil.getUUID());
	 		
	 		logger.info("savePayAcct > param>"+info.toLog());
	 
			 PayAcct ori=null;
	 		if(info.getId() != null){
	 			ori=payAcctService.findById(info.getId());
	 		}
	 		
	 		if(ori==null){
	 			payAcctService.save(info);
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
	 * 更改支付账户
	 */
    @RequestMapping("/inner/payAcct/update")
    public void updatePayAcct(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    PayAcct info = getModel(PayAcct.class,request.getParameterMap());
		    
		    logger.info(" updatePayAcct> param>"+info.toLog());
		    
		    PayAcct ori=payAcctService.findById(info.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	payAcctService.update(info);
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
	 * 删除支付账户
	 */
    @RequestMapping("/inner/payAcct/delete")
    public void deletePayAcctById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	PayAcct info = getModel(PayAcct.class,request.getParameterMap());
		   	
		   	logger.info("deletePayAcctById > param>"+info.getId());
		   	
			payAcctService.delete(info.getId());
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
	 * 查询全部支付账户
	 */

    /*@RequestMapping("/inner/payAcct/findAllPayAcct")
    public void findAllPayAcct(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<PayAcct> allList = payAcctService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个支付账户
	 */
	/*@RequestMapping("/inner/payAcct/deleteIds")
	public void deletePayAcct(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				payAcctService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/payAcct/list")
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
			PojoDomain<PayAcct> list = payAcctService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find payAcct successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find payAcct fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}