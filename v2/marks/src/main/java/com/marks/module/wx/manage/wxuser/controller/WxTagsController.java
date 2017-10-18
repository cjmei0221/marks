package com.marks.module.wx.manage.wxuser.controller;

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
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.wxuser.pojo.WxTags;
import com.marks.module.wx.manage.wxuser.service.WxTagsService;
import com.marks.module.wx.manage.wxutil.WxMpUtil;

import net.sf.json.JSONArray;

 /**
	 * 用户标签: 微信用户标签，用于用户个性化菜单
	 */
@Controller
public class WxTagsController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxTagsController.class);
    
    @Autowired
    private WxTagsService  wxTagsService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询用户标签
	 */
    @RequestMapping("/inner/wxTags/findWxTagsById")
    public void findWxTagsById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxTags wxTags = getModel(WxTags.class);
		    
		    logger.info("findWxTagsById > param>"+wxTags.getId());
		    
			WxTags requestWxTags = wxTagsService.findById(wxTags.getId());
			result.getData().put("wxTags",requestWxTags);
			result.setMessage("findById wxTags successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存用户标签
	 */
    @RequestMapping("/inner/wxTags/save")
    public void saveWxTags(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	WxTags wxTags = getModel(WxTags.class);
	 //     wxTags.setId(IDUtil.getUUID());
	 		
	 		logger.info("saveWxTags > param>"+wxTags.toLog());
	 
	 		//判断唯一性，公众号和名称
			 WxTags ori=wxTagsService.findByAccountIdAndName(wxTags.getAccountid(),wxTags.getName());
	 		
	 		
	 		if(ori==null){
	 			//调用微信接口，创建标签
	 			result=WxMpUtil.getInstance().createTag(wxTags.getAccountid(), wxTags.getName());
	 			//成功则保存数据库
	 			if(result.getCode().equals(Code.CODE_SUCCESS)){
	 				wxTags.setTagid(Integer.parseInt(result.getData().get("tagid").toString()) );
	 				wxTags.setUpdater(admin.getUserid()+"-"+admin.getUsername());
					wxTags.setCompanyId(admin.getCompanyId());
	 				wxTagsService.save(wxTags);
		 			result.setMessage("保存成功");
					result.setCode(Code.CODE_SUCCESS);
	 			}
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
	 * 更改用户标签
	 */
    @RequestMapping("/inner/wxTags/update")
    public void updateWxTags(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    WxTags wxTags = getModel(WxTags.class);
		    
		    logger.info(" updateWxTags> param>"+wxTags.toLog());
		    
		    WxTags ori=wxTagsService.findById(wxTags.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	result=WxMpUtil.getInstance().editTag(ori.getAccountid(), wxTags.getTagid(), wxTags.getName());
		    	if(result.getCode().equals(Code.CODE_SUCCESS)){
		    		wxTags.setUpdater(admin.getUserid()+"-"+admin.getUsername());
			    	wxTagsService.update(wxTags);
					result.setMessage("更新成功!");
					result.setCode(Code.CODE_SUCCESS);
		    	}
		    }
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除用户标签
	 */
    @RequestMapping("/inner/wxTags/delete")
    public void deleteWxTagsById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxTags wxTags = getModel(WxTags.class);
		   	
		   	logger.info("deleteWxTagsById > param>"+wxTags.getId());
		   	result=WxMpUtil.getInstance().delTag(wxTags.getAccountid(), wxTags.getTagid());
		   	if(result.getCode().equals(Code.CODE_SUCCESS)){
		   		wxTagsService.delete(wxTags.getId());
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
		   	}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部用户标签
	 */
    @RequestMapping("/inner/wxTags/findWxTagsByAccountid")
    public void findAllWxTags(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String id=request.getParameter("id");
			List<WxTags> wxTagsList = wxTagsService.findWxTagsByAccountid(id);
			
			JsonUtil.output(response, JSONArray.fromObject(wxTagsList).toString());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxTags fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个用户标签
	 */
	@RequestMapping("/inner/wxTags/deleteIds")
	public void deleteWxTags(HttpServletRequest request,
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
				wxTagsService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxTags fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxTags/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<WxTags> list = wxTagsService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxTags successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxTags fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}