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
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.mall.stock.pojo.BarCodeForm;
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.service.StockBatchService;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 库存批次: 库存批次
	 */
@Controller
public class StockBatchController extends SupportContorller{
    private static Logger logger = Logger.getLogger( StockBatchController.class);
    
    @Autowired
    private StockBatchService  stockBatchService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询库存批次
	 */
    @RequestMapping("/inner/stockBatch/findById")
    public void findStockBatchById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    StockBatch info = getModel(StockBatch.class);
		    
		    logger.info("findStockBatchById > param>"+info.getBatchId());
		    
			StockBatch vo = stockBatchService.findById(info.getBatchId());
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
	 * 首次入库
	 */
    @RequestMapping("/inner/stockBatch/save")
    public void saveStockBatch(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			BarCodeForm reqVo = getModel(BarCodeForm.class);
			reqVo.setCompanyId(admin.getCompanyId());
			reqVo.setOrgid(admin.getDefaultOrgid());
			reqVo.setOrgname(admin.getDefaultOrgname());
			reqVo.setOperator(admin.getUsername());
			reqVo.setOperatorId(admin.getUserid());
			logger.info("saveBarCode > param>" + reqVo.getGoodId() + " - " + reqVo.getNums());

			result = stockBatchService.saveFirstStockIn(reqVo);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改库存批次
	 */
    @RequestMapping("/inner/stockBatch/update")
    public void updateStockBatch(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    StockBatch info = getModel(StockBatch.class);
		    
		    logger.info(" updateStockBatch> param>"+info.toLog());
		    
		    StockBatch ori=stockBatchService.findById(info.getBatchId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	stockBatchService.update(info);
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
	 * 删除库存批次
	 */
    @RequestMapping("/inner/stockBatch/delete")
    public void deleteStockBatchById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	StockBatch info = getModel(StockBatch.class);
		   	
		   	logger.info("deleteStockBatchById > param>"+info.getBatchId());
		   	
			stockBatchService.delete(info.getBatchId());
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
	 * 查询全部库存批次
	 */

    /*
    @RequestMapping("/inner/stockBatch/findAllStockBatch")
    public void findAllStockBatch(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<StockBatch> allList = stockBatchService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll stockBatch successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll stockBatch fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个库存批次
	 */
	/*
	@RequestMapping("/inner/stockBatch/deleteIds")
	public void deleteStockBatch(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("batchId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				stockBatchService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete stockBatch fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/stockBatch/list")
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
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<StockBatch> list = stockBatchService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find stockBatch successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find stockBatch fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}