package com.cjmei.module.wx.wxuser.controller;

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
import com.cjmei.common.enums.Enums;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

import com.cjmei.module.wx.wxuser.pojo.WxUser;
import com.cjmei.module.wx.wxuser.service.WxUserService;

@Controller
public class WxUserController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxUserController.class);
    
    @Autowired
    private WxUserService  wxUserService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询粉丝管理
	 */
    @RequestMapping("/wxUser/findWxUserById")
    public void findWxUserById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxUser wxUser = getModel(WxUser.class);
			WxUser requestWxUser = wxUserService.findById(wxUser.getOpenid());
			result.getData().put("wxUser",requestWxUser);
			result.setMessage("findById wxUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存粉丝管理
	 */
    @RequestMapping("/wxUser/save")
    public void saveWxUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	WxUser wxUser = getModel(WxUser.class);
	 //     wxUser.setOpenid(IDUtil.getTimeID());
			 WxUser ori=null;
	 		if(wxUser.getOpenid() != null){
	 			ori=wxUserService.findById(wxUser.getOpenid());
	 		}
	 		
	 		if(ori==null){
	 			wxUserService.save(wxUser);
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
	 * 更改粉丝管理
	 */
    @RequestMapping("/wxUser/update")
    public void updateWxUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    WxUser wxUser = getModel(WxUser.class);
		    WxUser ori=wxUserService.findById(wxUser.getOpenid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxUserService.update(wxUser);
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
	 * 删除粉丝管理
	 */
    @RequestMapping("/wxUser/delete")
    public void deleteWxUserById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxUser wxUser = getModel(WxUser.class);
			wxUserService.delete(wxUser.getOpenid());
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
	 * 查询全部粉丝管理
	 */
    @RequestMapping("/wxUser/findAllWxUser")
    public void findAllWxUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxUser> wxUserList = wxUserService.findAll();
			result.getData().put("wxUserList",wxUserList);
			result.setMessage("findAll wxUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个粉丝管理
	 */
	@RequestMapping("/wxUser/deleteIds")
	public void deleteWxUser(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("openid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				wxUserService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/wxUser/list")
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
			PojoDomain<WxUser> list = wxUserService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	/**
	 * 推送日记模板消息
	 * @param request
	 * @param response
	 */
    @RequestMapping("/wxUser/dairy")
    public void dairy(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String openid=request.getParameter("openid");
			WxUser wxUser=wxUserService.findById(openid);
			int dairyFlag=Enums.DairyUse.NOUSE.getValue();
			if(Enums.DairyUse.NOUSE.getValue()==wxUser.getDairyFlag()){
				dairyFlag=Enums.DairyUse.USE.getValue();
			}
			wxUserService.updateDairyFlag(openid,dairyFlag);
			result.setMessage("pushdairy wxUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
}