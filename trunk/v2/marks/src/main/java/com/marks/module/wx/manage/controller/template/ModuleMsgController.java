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
import com.marks.module.wx.manage.entity.template.ModuleMsg;
import com.marks.module.wx.manage.service.template.ModuleMsgService;

@Controller
public class ModuleMsgController extends SupportContorller{
    private static Logger logger = Logger.getLogger( ModuleMsgController.class);
    
    @Autowired
    private ModuleMsgService  moduleMsgService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询模板消息
	 */
    @RequestMapping("/inner/moduleMsg/findModuleMsgById")
    public void findModuleMsgById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    ModuleMsg moduleMsg = getModel(ModuleMsg.class);
			ModuleMsg requestModuleMsg = moduleMsgService.findById(moduleMsg.getId());
			result.getData().put("moduleMsg",requestModuleMsg);
			result.setMessage("findById moduleMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存模板消息
	 */
    @RequestMapping("/inner/moduleMsg/save")
    public void saveModuleMsg(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	ModuleMsg moduleMsg = getModel(ModuleMsg.class);
	 //     moduleMsg.setId(IDUtil.getTimeID());
			 ModuleMsg ori=null;
	 		if(moduleMsg.getId() != null){
	 			ori=moduleMsgService.findById(moduleMsg.getId());
	 		}
	 		
	 		if(ori==null){
	 			moduleMsgService.save(moduleMsg);
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
	 * 更改模板消息
	 */
    @RequestMapping("/inner/moduleMsg/update")
    public void updateModuleMsg(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    ModuleMsg moduleMsg = getModel(ModuleMsg.class);
		    ModuleMsg ori=moduleMsgService.findById(moduleMsg.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	moduleMsgService.update(moduleMsg);
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
	 * 删除模板消息
	 */
    @RequestMapping("/inner/moduleMsg/delete")
    public void deleteModuleMsgById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	ModuleMsg moduleMsg = getModel(ModuleMsg.class);
			moduleMsgService.delete(moduleMsg.getId());
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
	 * 查询全部模板消息
	 */
    @RequestMapping("/inner/moduleMsg/findAllModuleMsg")
    public void findAllModuleMsg(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<ModuleMsg> moduleMsgList = moduleMsgService.findAll();
			result.getData().put("moduleMsgList",moduleMsgList);
			result.setMessage("findAll moduleMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll moduleMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个模板消息
	 */
	@RequestMapping("/inner/moduleMsg/deleteIds")
	public void deleteModuleMsg(HttpServletRequest request,
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
				moduleMsgService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete moduleMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/moduleMsg/list")
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
			param.put("s_resultCode", request.getParameter("s_resultCode"));
			param.put("s_sendFlag", request.getParameter("s_sendFlag"));
			param.put("companyId", admin.getCompanyId());
			PojoDomain<ModuleMsg> list = moduleMsgService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find moduleMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find moduleMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}