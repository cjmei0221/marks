package com.cjmei.module.system.datadir.controller;

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

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

import com.cjmei.module.system.datadir.pojo.DataDir;
import com.cjmei.module.system.datadir.service.DataDirService;

@Controller
public class DataDirController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DataDirController.class);
    
    @Autowired
    private DataDirService  dataDirService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询数据字典
	 */
    @RequestMapping("/dataDir/findDataDirById")
    public void findDataDirById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    DataDir dataDir = getModel(DataDir.class);
			DataDir requestDataDir = dataDirService.findById(dataDir.getCkey());
			result.getData().put("dataDir",requestDataDir);
			result.setMessage("findById dataDir successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存数据字典
	 */
    @RequestMapping("/dataDir/save")
    public void saveDataDir(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	DataDir dataDir = getModel(DataDir.class);
	 //     dataDir.setCkey(IDUtil.getTimeID());
			 DataDir ori=null;
	 		if(dataDir.getCkey() != null){
	 			ori=dataDirService.findById(dataDir.getCkey());
	 		}
	 		
	 		if(ori==null){
	 			dataDirService.save(dataDir);
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
	 * 更改数据字典
	 */
    @RequestMapping("/dataDir/update")
    public void updateDataDir(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    DataDir dataDir = getModel(DataDir.class);
		    DataDir ori=dataDirService.findById(dataDir.getCkey());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	dataDirService.update(dataDir);
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
	 * 删除数据字典
	 */
    @RequestMapping("/dataDir/delete")
    public void deleteDataDirById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	DataDir dataDir = getModel(DataDir.class);
			dataDirService.delete(dataDir.getCkey());
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
	 * 查询全部数据字典
	 */
    @RequestMapping("/dataDir/findAllDataDir")
    public void findAllDataDir(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<DataDir> dataDirList = dataDirService.findAll();
			result.getData().put("dataDirList",dataDirList);
			result.setMessage("findAll dataDir successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll dataDir fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个数据字典
	 */
	@RequestMapping("/dataDir/deleteIds")
	public void deleteDataDir(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("ckey");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				dataDirService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete dataDir fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/dataDir/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<DataDir> list = dataDirService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find dataDir successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find dataDir fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}