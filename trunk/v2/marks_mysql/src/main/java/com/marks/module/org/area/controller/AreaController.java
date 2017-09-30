package com.marks.module.org.area.controller;

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

import com.marks.module.org.area.pojo.Area;
import com.marks.module.org.area.service.AreaService;

 /**
	 * 区域管理: 机构区域管理
	 */
@Controller
public class AreaController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AreaController.class);
    
    @Autowired
    private AreaService  areaService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询区域管理
	 */
    @RequestMapping("/inner/area/findById")
    public void findAreaById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Area area = getModel(Area.class);
		    
		    logger.info("findAreaById > param>"+area.getAreaId());
		    
			Area requestArea = areaService.findById(area.getAreaId());
			result.getData().put("area",requestArea);
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
	 * 保存区域管理
	 */
    @RequestMapping("/inner/area/save")
    public void saveArea(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
	    	Area area = getModel(Area.class);
	 //     area.setAreaId(IDUtil.getUUID());
	 		
	 		logger.info("saveArea > param>"+area.toLog());
	 
			 Area ori=null;
	 		if(area.getAreaId() != null){
	 			ori=areaService.findById(area.getAreaId());
	 		}
	 		
	 		if(ori==null){
	 			areaService.save(area);
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
	 * 更改区域管理
	 */
    @RequestMapping("/inner/area/update")
    public void updateArea(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
		    Area area = getModel(Area.class);
		    
		    logger.info(" updateArea> param>"+area.toLog());
		    
		    Area ori=areaService.findById(area.getAreaId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	areaService.update(area);
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
	 * 删除区域管理
	 */
    @RequestMapping("/inner/area/delete")
    public void deleteAreaById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Area area = getModel(Area.class);
		   	
		   	logger.info("deleteAreaById > param>"+area.getAreaId());
		   	
			areaService.delete(area.getAreaId());
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
	 * 查询全部区域管理
	 */

    /*@RequestMapping("/inner/area/findAllArea")
    public void findAllArea(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Area> areaList = areaService.findAll();
			result.getData().put("areaList",areaList);
			result.setMessage("findAll area successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll area fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个区域管理
	 */
	/*@RequestMapping("/inner/area/deleteIds")
	public void deleteArea(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("areaId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				areaService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete area fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/area/list")
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
			PojoDomain<Area> list = areaService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find area successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find area fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}