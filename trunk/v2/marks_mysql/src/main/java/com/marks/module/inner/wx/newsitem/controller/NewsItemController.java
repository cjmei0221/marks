package com.marks.module.inner.wx.newsitem.controller;

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
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.system.sys.controller.SupportContorller;
import com.marks.module.inner.user.login.helper.SysUserHelper;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.inner.wx.newsitem.pojo.NewsItem;
import com.marks.module.inner.wx.newsitem.service.NewsItemService;

import net.sf.json.JSONArray;

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
    @RequestMapping("/inner/newsItem/findNewsItemById")
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
    @RequestMapping("/inner/newsItem/save")
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
	 			newsItem.setId("N"+IDUtil.getDateSID());
	 			newsItem.setCreator(admin.getUserid());
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
    @RequestMapping("/inner/newsItem/update")
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
    @RequestMapping("/inner/newsItem/delete")
    public void deleteNewsItemById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	NewsItem newsItem = getModel(NewsItem.class);
		   	int count=newsItemService.countNews(newsItem.getId());
		   	if(count>0){
		   		result.setMessage("已被使用，不能删除!");
				result.setCode(Code.CODE_FAIL);
		   	}else{
		   		newsItemService.delete(newsItem.getId());
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
	 * 查询全部回复图文管理
	 */
    @RequestMapping("/inner/newsItem/findAllNewsItem")
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
	@RequestMapping("/inner/newsItem/deleteIds")
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
	@RequestMapping("/inner/newsItem/list")
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
			param.put("accountIds", admin.getAccountids());
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
	@RequestMapping("/inner/newsItem/combox")
	public void combox(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = SysUserHelper.getCurrentUserInfo(request);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("accountIds", admin.getAccountids());
		List<NewsItem> list = newsItemService.getnewItems(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}
}