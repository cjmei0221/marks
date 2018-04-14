package com.marks.module.wx.manage.controller.template;

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
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.entity.template.WxTemplate;
import com.marks.module.wx.manage.service.template.WxTemplateService;

@Controller
public class WxTemplateController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxTemplateController.class);
    
    @Autowired
    private WxTemplateService  wxTemplateService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询微信模板
	 */
    @RequestMapping("/inner/wxTemplate/findWxTemplateById")
    public void findWxTemplateById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxTemplate wxTemplate = getModel(WxTemplate.class);
			WxTemplate requestWxTemplate = wxTemplateService.findById(wxTemplate.getYwType(),wxTemplate.getAccountid());
			result.getData().put("wxTemplate",requestWxTemplate);
			result.setMessage("findById wxTemplate successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存微信模板
	 */
    @RequestMapping("/inner/wxTemplate/save")
    public void saveWxTemplate(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	WxTemplate wxTemplate = getModel(WxTemplate.class);
	 //     wxTemplate.setYwType(IDUtil.getTimeID());
			 WxTemplate ori=null;
	 		if(wxTemplate.getYwType() != null){
	 			ori=wxTemplateService.findById(wxTemplate.getYwType(),wxTemplate.getAccountid());
	 		}
	 		
	 		if(ori==null){
				wxTemplate.setCompanyId(admin.getCompanyId());
				wxTemplate.setCreator(admin.getUsername());
	 			wxTemplateService.save(wxTemplate);
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
	 * 更改微信模板
	 */
    @RequestMapping("/inner/wxTemplate/update")
    public void updateWxTemplate(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    WxTemplate wxTemplate = getModel(WxTemplate.class);
		    WxTemplate ori=wxTemplateService.findById(wxTemplate.getYwType(),wxTemplate.getAccountid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxTemplateService.update(wxTemplate);
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
	 * 删除微信模板
	 */
    @RequestMapping("/inner/wxTemplate/delete")
    public void deleteWxTemplateById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxTemplate wxTemplate = getModel(WxTemplate.class);
			wxTemplateService.delete(wxTemplate.getYwType(),wxTemplate.getAccountid());
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
	 * 查询全部微信模板
	 */
    @RequestMapping("/inner/wxTemplate/findAllWxTemplate")
    public void findAllWxTemplate(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxTemplate> wxTemplateList = wxTemplateService.findAll();
			result.getData().put("wxTemplateList",wxTemplateList);
			result.setMessage("findAll wxTemplate successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxTemplate fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个微信模板
	 */
	@RequestMapping("/inner/wxTemplate/deleteIds")
	public void deleteWxTemplate(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("ywType");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				wxTemplateService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxTemplate fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxTemplate/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WxTemplate> list = wxTemplateService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxTemplate successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxTemplate fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}