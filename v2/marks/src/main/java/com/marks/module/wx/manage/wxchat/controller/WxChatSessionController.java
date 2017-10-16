package com.marks.module.wx.manage.wxchat.controller;

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
import com.marks.module.wx.manage.wxchat.pojo.WxChatCount;
import com.marks.module.wx.manage.wxchat.pojo.WxChatSession;
import com.marks.module.wx.manage.wxchat.service.WxChatSessionService;

 /**
	 * 回话管理: 微信自动回复管理
	 */
@Controller
public class WxChatSessionController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxChatSessionController.class);
    
    @Autowired
    private WxChatSessionService  wxChatSessionService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询回话管理
	 */
    @RequestMapping("/inner/wxChatSession/findWxChatSessionById")
    public void findWxChatSessionById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxChatSession wxChatSession = getModel(WxChatSession.class);
		    
		    logger.info("findWxChatSessionById > param>"+wxChatSession.getSession_id());
		    
			WxChatSession requestWxChatSession = wxChatSessionService.findById(wxChatSession.getSession_id());
			result.getData().put("wxChatSession",requestWxChatSession);
			result.setMessage("findById wxChatSession successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存回话管理
	 */
    @RequestMapping("/inner/wxChatSession/save")
    public void saveWxChatSession(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	WxChatSession wxChatSession = getModel(WxChatSession.class);
	 //     wxChatSession.setSession_id(IDUtil.getTimeID());
	 		
	 		logger.info("saveWxChatSession > param>"+wxChatSession.toLog());
	 
			 WxChatSession ori=null;
	 		if(wxChatSession.getSession_id() != null){
	 			ori=wxChatSessionService.findById(wxChatSession.getSession_id());
	 		}
	 		
	 		if(ori==null){
	 			wxChatSessionService.save(wxChatSession);
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
	 * 更改回话管理
	 */
    @RequestMapping("/inner/wxChatSession/update")
    public void updateWxChatSession(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
		    WxChatSession wxChatSession = getModel(WxChatSession.class);
		    
		    logger.info(" updateWxChatSession> param>"+wxChatSession.toLog());
		    
		    WxChatSession ori=wxChatSessionService.findById(wxChatSession.getSession_id());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxChatSessionService.update(wxChatSession);
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
	 * 删除回话管理
	 */
    @RequestMapping("/inner/wxChatSession/delete")
    public void deleteWxChatSessionById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxChatSession wxChatSession = getModel(WxChatSession.class);
		   	
		   	logger.info("deleteWxChatSessionById > param>"+wxChatSession.getSession_id());
		   	
			wxChatSessionService.delete(wxChatSession.getSession_id());
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
	 * 查询全部回话管理
	 */
    @RequestMapping("/inner/wxChatSession/findAllWxChatSession")
    public void findAllWxChatSession(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxChatSession> wxChatSessionList = wxChatSessionService.findAll();
			result.getData().put("wxChatSessionList",wxChatSessionList);
			result.setMessage("findAll wxChatSession successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxChatSession fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个回话管理
	 */
	@RequestMapping("/inner/wxChatSession/deleteIds")
	public void deleteWxChatSession(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("session_id");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				wxChatSessionService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxChatSession fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxChatSession/list")
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
			param.put("accountIds", admin.getAccountids());
			PojoDomain<WxChatSession> list = wxChatSessionService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxChatSession successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxChatSession fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	@RequestMapping("/inner/wxChatSession/countList")
    public void countList(HttpServletRequest request,HttpServletResponse response){
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
			param.put("accountIds", admin.getAccountids());
			PojoDomain<WxChatCount> list = wxChatSessionService.getCountList(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxChatSession successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxChatSession fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}