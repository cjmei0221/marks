package com.marks.module.wx.manage.base.controller;

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
import com.marks.module.wx.manage.base.pojo.WxMenuUrl;
import com.marks.module.wx.manage.base.service.WxMenuUrlService;

@Controller
public class WxMenuUrlController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxMenuUrlController.class);
    
    @Autowired
    private WxMenuUrlService  wxMenuUrlService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询微信菜单URL
	 */
    @RequestMapping("/inner/wxMenuUrl/findWxMenuUrlById")
    public void findWxMenuUrlById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxMenuUrl wxMenuUrl = getModel(WxMenuUrl.class);
			WxMenuUrl requestWxMenuUrl = wxMenuUrlService.findById(wxMenuUrl.getId());
			result.getData().put("wxMenuUrl",requestWxMenuUrl);
			result.setMessage("findById wxMenuUrl successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存微信菜单URL
	 */
    @RequestMapping("/inner/wxMenuUrl/save")
    public void saveWxMenuUrl(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	WxMenuUrl wxMenuUrl = getModel(WxMenuUrl.class);
	 //     wxMenuUrl.setId(IDUtil.getTimeID());
			 WxMenuUrl ori=null;
	 		if(wxMenuUrl.getId() != null){
	 			ori=wxMenuUrlService.findById(wxMenuUrl.getId());
	 		}
	 		
	 		if(ori==null){
				wxMenuUrl.setCompanyId(admin.getCompanyId());
	 			wxMenuUrlService.save(wxMenuUrl);
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
	 * 更改微信菜单URL
	 */
    @RequestMapping("/inner/wxMenuUrl/update")
    public void updateWxMenuUrl(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    WxMenuUrl wxMenuUrl = getModel(WxMenuUrl.class);
		    WxMenuUrl ori=wxMenuUrlService.findById(wxMenuUrl.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxMenuUrlService.update(wxMenuUrl);
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
	 * 删除微信菜单URL
	 */
    @RequestMapping("/inner/wxMenuUrl/delete")
    public void deleteWxMenuUrlById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxMenuUrl wxMenuUrl = getModel(WxMenuUrl.class);
			wxMenuUrlService.delete(wxMenuUrl.getId());
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
	 * 查询全部微信菜单URL
	 */
    @RequestMapping("/inner/wxMenuUrl/findAllWxMenuUrl")
    public void findAllWxMenuUrl(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxMenuUrl> wxMenuUrlList = wxMenuUrlService.findAll();
			result.getData().put("wxMenuUrlList",wxMenuUrlList);
			result.setMessage("findAll wxMenuUrl successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxMenuUrl fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个微信菜单URL
	 */
	@RequestMapping("/inner/wxMenuUrl/deleteIds")
	public void deleteWxMenuUrl(HttpServletRequest request,
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
				wxMenuUrlService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxMenuUrl fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxMenuUrl/list")
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
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WxMenuUrl> list = wxMenuUrlService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxMenuUrl successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxMenuUrl fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}