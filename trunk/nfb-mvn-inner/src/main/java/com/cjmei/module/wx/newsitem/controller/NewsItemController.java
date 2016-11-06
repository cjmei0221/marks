package com.cjmei.module.wx.newsitem.controller;

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

import com.cjmei.module.wx.newsitem.pojo.NewsItem;
import com.cjmei.module.wx.newsitem.service.NewsItemService;

@Controller
public class NewsItemController extends SupportContorller{
    private static Logger logger = Logger.getLogger( NewsItemController.class);
    
    @Autowired
    private NewsItemService  newsItemService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询回复图文管理
	 */
    @RequestMapping("/newsItem/findNewsItemById")
    public void findNewsItemById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    NewsItem newsItem = getModel(NewsItem.class);
			NewsItem requestNewsItem = newsItemService.findById(newsItem.getId());
			result.getData().put("newsItem",requestNewsItem);
			result.setMessage("findById newsItem successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存回复图文管理
	 */
    @RequestMapping("/newsItem/save")
    public void saveNewsItem(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	NewsItem newsItem = getModel(NewsItem.class);
	 //     newsItem.setId(IDUtil.getTimeID());
			 NewsItem ori=null;
	 		if(newsItem.getId() != null){
	 			ori=newsItemService.findById(newsItem.getId());
	 		}
	 		
	 		if(ori==null){
	 			newsItemService.save(newsItem);
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
	 * 更改回复图文管理
	 */
    @RequestMapping("/newsItem/update")
    public void updateNewsItem(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    NewsItem newsItem = getModel(NewsItem.class);
		    NewsItem ori=newsItemService.findById(newsItem.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	newsItemService.update(newsItem);
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
	 * 删除回复图文管理
	 */
    @RequestMapping("/newsItem/delete")
    public void deleteNewsItemById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	NewsItem newsItem = getModel(NewsItem.class);
			newsItemService.delete(newsItem.getId());
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
	 * 查询全部回复图文管理
	 */
    @RequestMapping("/newsItem/findAllNewsItem")
    public void findAllNewsItem(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<NewsItem> newsItemList = newsItemService.findAll();
			result.getData().put("newsItemList",newsItemList);
			result.setMessage("findAll newsItem successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll newsItem fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个回复图文管理
	 */
	@RequestMapping("/newsItem/deleteIds")
	public void deleteNewsItem(HttpServletRequest request,
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
				newsItemService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete newsItem fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/newsItem/list")
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
			PojoDomain<NewsItem> list = newsItemService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find newsItem successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find newsItem fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}