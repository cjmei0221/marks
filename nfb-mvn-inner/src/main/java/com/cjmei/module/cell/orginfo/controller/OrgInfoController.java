package com.cjmei.module.cell.orginfo.controller;

import java.sql.Timestamp;
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
import com.cjmei.common.domain.TreeVo;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.cell.orginfo.pojo.OrgInfo;
import com.cjmei.module.cell.orginfo.service.OrgInfoService;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysUser;

import net.sf.json.JSONArray;

@Controller
public class OrgInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( OrgInfoController.class);
    
    @Autowired
    private OrgInfoService  orgInfoService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}
    
    /**
	 * 查询机构管理
	 */
    @RequestMapping("/orgInfo/getChildListByParentId")
    public void getChildListByParentId(HttpServletRequest request,
    HttpServletResponse response){
       
		    String parentId=request.getParameter("parentId");
		    if(parentId !=null && !"".equals(parentId)){
		    	List<TreeVo> list = orgInfoService.getChildListByParentId(parentId);
		    	JsonUtil.output(response, JSONArray.fromObject(list).toString());
		    }
    }

    /**
	 * 查询机构管理
	 */
    @RequestMapping("/orgInfo/findOrgInfoById")
    public void findOrgInfoById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    OrgInfo orgInfo = getModel(OrgInfo.class);
			OrgInfo requestOrgInfo = orgInfoService.findById(orgInfo.getOrgid());
			result.getData().put("orgInfo",requestOrgInfo);
			result.setMessage("findById orgInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存机构管理
	 */
    @RequestMapping("/orgInfo/save")
    public void saveOrgInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	OrgInfo orgInfo = getModel(OrgInfo.class);
	 //     orgInfo.setOrgid(IDUtil.getTimeID());
	 		OrgInfo ori=orgInfoService.findById(orgInfo.getOrgid());
	 		if(ori==null){
	 			orgInfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
	 			orgInfo.setUpdatetime(orgInfo.getCreatetime());
	 			orgInfo.setCreator(admin.getUserid());
	 			orgInfoService.save(orgInfo);
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
	 * 更改机构管理
	 */
    @RequestMapping("/orgInfo/update")
    public void updateOrgInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    OrgInfo orgInfo = getModel(OrgInfo.class);
		    OrgInfo ori=orgInfoService.findById(orgInfo.getOrgid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	orgInfo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		    	orgInfoService.update(orgInfo);
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
	 * 删除机构管理
	 */
    @RequestMapping("/orgInfo/delete")
    public void deleteOrgInfoById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	OrgInfo orgInfo = getModel(OrgInfo.class);
			orgInfoService.delete(orgInfo.getOrgid());
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
	 * 查询全部机构管理
	 */
    @RequestMapping("/orgInfo/findAllOrgInfo")
    public void findAllOrgInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<OrgInfo> orgInfoList = orgInfoService.findAll();
			result.getData().put("orgInfoList",orgInfoList);
			result.setMessage("findAll orgInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll orgInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个机构管理
	 */
	@RequestMapping("/orgInfo/deleteIds")
	public void deleteOrgInfo(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("orgid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				orgInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete orgInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/orgInfo/list")
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
			PojoDomain<OrgInfo> list = orgInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find orgInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find orgInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}