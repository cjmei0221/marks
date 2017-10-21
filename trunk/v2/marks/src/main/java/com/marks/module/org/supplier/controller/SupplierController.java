package com.marks.module.org.supplier.controller;

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
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import com.marks.module.org.supplier.pojo.Supplier;
import com.marks.module.org.supplier.service.SupplierService;

 /**
	 * 供应商管理: 供应商管理
	 */
@Controller
public class SupplierController extends SupportContorller{
    private static Logger logger = Logger.getLogger( SupplierController.class);
    
    @Autowired
    private SupplierService  supplierService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询供应商管理
	 */
    @RequestMapping("/inner/supplier/findById")
    public void findSupplierById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Supplier reqVo = getModel(Supplier.class);
		    
		    logger.info("findSupplierById > param>"+reqVo.getOrgid());
		    
			Supplier info = supplierService.findById(reqVo.getOrgid());
			result.getData().put("info",info);
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
	 * 保存供应商管理
	 */
    @RequestMapping("/inner/supplier/save")
    public void saveSupplier(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	Supplier reqVo = getModel(Supplier.class);
	        reqVo.setOrgid(IDUtil.getUUID());
	 		
	 		logger.info("saveSupplier > param>"+reqVo.toLog());
	 
			 Supplier ori=null;
	 		if(reqVo.getOrgid() != null){
	 			ori=supplierService.findById(reqVo.getOrgid());
	 		}
	 		
	 		if(ori==null){
	 			supplierService.save(reqVo);
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
	 * 更改供应商管理
	 */
    @RequestMapping("/inner/supplier/update")
    public void updateSupplier(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    Supplier reqVo = getModel(Supplier.class);
		    
		    logger.info(" updateSupplier> param>"+reqVo.toLog());
		    
		    Supplier ori=supplierService.findById(reqVo.getOrgid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	supplierService.update(reqVo);
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
	 * 删除供应商管理
	 */
    @RequestMapping("/inner/supplier/delete")
    public void deleteSupplierById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Supplier reqVo = getModel(Supplier.class);
		   	
		   	logger.info("deleteSupplierById > param>"+reqVo.getOrgid());
		   	
			supplierService.delete(reqVo.getOrgid());
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
	 * 查询全部供应商管理
	 */

    /*@RequestMapping("/inner/supplier/findAllSupplier")
    public void findAllSupplier(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Supplier> allList = supplierService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll supplier successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll supplier fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个供应商管理
	 */
	/*@RequestMapping("/inner/supplier/deleteIds")
	public void deleteSupplier(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("orgid");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				supplierService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete supplier fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/supplier/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
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
			PojoDomain<Supplier> list = supplierService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find supplier successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find supplier fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}