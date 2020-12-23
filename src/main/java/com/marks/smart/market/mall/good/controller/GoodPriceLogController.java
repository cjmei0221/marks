package com.marks.smart.market.mall.good.controller;

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

import com.marks.smart.market.mall.good.pojo.GoodPriceLog;
import com.marks.smart.market.mall.good.service.GoodPriceLogService;

 /**
	 * 调价单: 门店商品价格修改日志
	 */
@Controller
public class GoodPriceLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( GoodPriceLogController.class);
    
    @Autowired
    private GoodPriceLogService  goodPriceLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询调价单
	 */
    @RequestMapping("/inner/goodPriceLog/findById")
    public void findById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    GoodPriceLog info = getModel(GoodPriceLog.class,request.getParameterMap());
			GoodPriceLog vo = goodPriceLogService.findById(info.getId());
			result.getData().put("info",vo);
			result.setMessage(" successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存调价单
	 */
    @RequestMapping("/inner/goodPriceLog/save")
    public void save(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	GoodPriceLog info = getModel(GoodPriceLog.class,request.getParameterMap());
	        info.setId(IDUtil.getUUID());
			 GoodPriceLog ori=null;
	 		if(info.getId() != null){
	 			ori=goodPriceLogService.findById(info.getId());
	 		}
	 		
	 		if(ori==null){
	 			goodPriceLogService.save(info);
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
	 * 更改调价单
	 */
    @RequestMapping("/inner/goodPriceLog/update")
    public void update(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    GoodPriceLog info = getModel(GoodPriceLog.class,request.getParameterMap());
		    GoodPriceLog ori=goodPriceLogService.findById(info.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	goodPriceLogService.update(info);
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
	 * 删除调价单
	 */
    @RequestMapping("/inner/goodPriceLog/delete")
    public void deleteById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	GoodPriceLog info = getModel(GoodPriceLog.class,request.getParameterMap());
			goodPriceLogService.delete(info.getId());
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
	 * 查询全部调价单
	 */

    /*
    @RequestMapping("/inner/goodPriceLog/findAllGoodPriceLog")
    public void findAll(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<GoodPriceLog> allList = goodPriceLogService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll goodPriceLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} 
	*/
	
	/**
	 * 删除多个调价单
	 */
	/*
	@RequestMapping("/inner/goodPriceLog/deleteIds")
	public void delete(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				goodPriceLogService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete goodPriceLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	*/
	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/goodPriceLog/list")
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
			PojoDomain<GoodPriceLog> list = goodPriceLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("list successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("list fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}