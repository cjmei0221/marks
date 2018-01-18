package com.marks.module.asset.base.controller;

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
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

import com.marks.module.asset.base.pojo.Asset;
import com.marks.module.asset.base.service.AssetService;

 /**
	 * 资产: 用户资产项
	 */
@Controller
public class AssetController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AssetController.class);
    
    @Autowired
    private AssetService  assetService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询资产
	 */
    @RequestMapping("/inner/asset/findById")
    public void findAssetById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Asset info = getModel(Asset.class);
		    
		    logger.info("findAssetById > param>"+info.getIdNo());
		    
			Asset vo = assetService.findById(info.getIdNo());
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
	 * 保存资产
	 */
    @RequestMapping("/inner/asset/save")
    public void saveAsset(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Asset info = getModel(Asset.class);
	        info.setIdNo(IDUtil.getUUID());
	 		
	 		logger.info("saveAsset > param>"+info.toLog());
	 
			 Asset ori=null;
	 		if(info.getIdNo() != null){
	 			ori=assetService.findById(info.getIdNo());
	 		}
	 		
	 		if(ori==null){
	 			assetService.save(info);
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
	 * 更改资产
	 */
    @RequestMapping("/inner/asset/update")
    public void updateAsset(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    Asset info = getModel(Asset.class);
		    
		    logger.info(" updateAsset> param>"+info.toLog());
		    
		    Asset ori=assetService.findById(info.getIdNo());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	assetService.update(info);
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
	 * 删除资产
	 */
    @RequestMapping("/inner/asset/delete")
    public void deleteAssetById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Asset info = getModel(Asset.class);
		   	
		   	logger.info("deleteAssetById > param>"+info.getIdNo());
		   	
			assetService.delete(info.getIdNo());
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
	 * 查询全部资产
	 */

    /*@RequestMapping("/inner/asset/findAllAsset")
    public void findAllAsset(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Asset> allList = assetService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll asset successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll asset fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个资产
	 */
	/*@RequestMapping("/inner/asset/deleteIds")
	public void deleteAsset(HttpServletRequest request,
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
				assetService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete asset fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/asset/list")
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
			PojoDomain<Asset> list = assetService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find asset successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find asset fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}