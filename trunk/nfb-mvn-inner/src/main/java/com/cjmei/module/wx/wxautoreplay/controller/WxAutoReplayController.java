package com.cjmei.module.wx.wxautoreplay.controller;

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

import com.cjmei.module.wx.wxautoreplay.pojo.WxAutoReplay;
import com.cjmei.module.wx.wxautoreplay.service.WxAutoReplayService;

@Controller
public class WxAutoReplayController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxAutoReplayController.class);
    
    @Autowired
    private WxAutoReplayService  wxAutoReplayService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询微信回复管理
	 */
    @RequestMapping("/wxAutoReplay/findWxAutoReplayById")
    public void findWxAutoReplayById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			WxAutoReplay requestWxAutoReplay = wxAutoReplayService.findById(wxAutoReplay.getCparentType());
			result.getData().put("wxAutoReplay",requestWxAutoReplay);
			result.setMessage("findById wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存微信回复管理
	 */
    @RequestMapping("/wxAutoReplay/save")
    public void saveWxAutoReplay(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
	 //     wxAutoReplay.setCparentType(IDUtil.getTimeID());
			 WxAutoReplay ori=null;
	 		if(wxAutoReplay.getCparentType() != null){
	 			ori=wxAutoReplayService.findById(wxAutoReplay.getCparentType());
	 		}
	 		
	 		if(ori==null){
	 			wxAutoReplayService.save(wxAutoReplay);
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
	 * 更改微信回复管理
	 */
    @RequestMapping("/wxAutoReplay/update")
    public void updateWxAutoReplay(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
		    WxAutoReplay ori=wxAutoReplayService.findById(wxAutoReplay.getCparentType());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxAutoReplayService.update(wxAutoReplay);
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
	 * 删除微信回复管理
	 */
    @RequestMapping("/wxAutoReplay/delete")
    public void deleteWxAutoReplayById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			wxAutoReplayService.delete(wxAutoReplay.getCparentType());
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
	 * 查询全部微信回复管理
	 */
    @RequestMapping("/wxAutoReplay/findAllWxAutoReplay")
    public void findAllWxAutoReplay(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxAutoReplay> wxAutoReplayList = wxAutoReplayService.findAll();
			result.getData().put("wxAutoReplayList",wxAutoReplayList);
			result.setMessage("findAll wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxAutoReplay fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个微信回复管理
	 */
	@RequestMapping("/wxAutoReplay/deleteIds")
	public void deleteWxAutoReplay(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("cparentType");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				wxAutoReplayService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxAutoReplay fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/wxAutoReplay/list")
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
			PojoDomain<WxAutoReplay> list = wxAutoReplayService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxAutoReplay fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}