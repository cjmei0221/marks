package com.marks.module.note.gains.controller;

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
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.core.data.StaticData;
import com.marks.module.note.gains.pojo.Gains;
import com.marks.module.note.gains.service.GainsService;
import com.marks.module.user.login.helper.LoginInnerUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

@Controller
public class GainsController extends SupportContorller{
    private static Logger logger = Logger.getLogger( GainsController.class);
    
    @Autowired
    private GainsService  gainsService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询心得记录
	 */
    @RequestMapping("/inner/gains/findGainsById")
    public void findGainsById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Gains gains = getModel(Gains.class);
			Gains requestGains = gainsService.findById(gains.getId());
			result.getData().put("gains",requestGains);
			result.setMessage("findById gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存心得记录
	 */
    @RequestMapping("/inner/gains/save")
    public void saveGains(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
	    	Gains gains = getModel(Gains.class);
	    	gains.setId(IDUtil.getTimeID());
			 Gains ori=null;
	 		if(gains.getTitle() != null){
	 			ori=gainsService.findByTitle(gains.getTitle());
	 		}
	 		
	 		if(ori==null){
	 			gains.setMobile(admin.getBind_mobile());
	 			gains.setLvlName(StaticData.getDatadirValue("gains_level", gains.getLvl()));
	 			gains.setCreator(admin.getUserid());
	 			gains.setUpdater(admin.getUserid());
	 			gainsService.save(gains);
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
	 * 更改心得记录
	 */
    @RequestMapping("/inner/gains/update")
    public void updateGains(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
		    Gains gains = getModel(Gains.class);
		    Gains ori=gainsService.findById(gains.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	gains.setLvlName(StaticData.getDatadirValue("gains_level", gains.getLvl()));
	 			gains.setUpdater(admin.getUserid());
		    	gainsService.update(gains);
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
	 * 删除心得记录
	 */
    @RequestMapping("/inner/gains/delete")
    public void deleteGainsById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Gains gains = getModel(Gains.class);
			gainsService.delete(gains.getId());
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
	 * 查询全部心得记录
	 */
    @RequestMapping("/inner/gains/findAllGains")
    public void findAllGains(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Gains> gainsList = gainsService.findAll();
			result.getData().put("gainsList",gainsList);
			result.setMessage("findAll gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个心得记录
	 */
	@RequestMapping("/inner/gains/deleteIds")
	public void deleteGains(HttpServletRequest request,
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
				gainsService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/gains/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			String userid=admin.getUserid();
			if("admin".equals(admin.getUserid())){
				userid=null;
			}
			param.put("userid", userid);
			param.put("keyword", keyword);
			PojoDomain<Gains> list = gainsService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find gains successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find gains fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}