package com.cjmei.module.note.vipinfo.controller;

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

import com.cjmei.module.note.vipinfo.pojo.VipInfo;
import com.cjmei.module.note.vipinfo.service.VipInfoService;

@Controller
public class VipInfoController extends SupportContorller{
    private static Logger logger = Logger.getLogger( VipInfoController.class);
    
    @Autowired
    private VipInfoService  vipInfoService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询会员信息
	 */
    @RequestMapping("/vipInfo/findVipInfoById")
    public void findVipInfoById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    VipInfo vipInfo = getModel(VipInfo.class);
			VipInfo requestVipInfo = vipInfoService.findById(vipInfo.getUserid());
			result.getData().put("vipInfo",requestVipInfo);
			result.setMessage("findById vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存会员信息
	 */
    @RequestMapping("/vipInfo/save")
    public void saveVipInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	VipInfo vipInfo = getModel(VipInfo.class);
	 //     vipInfo.setUserid(IDUtil.getTimeID());
			 VipInfo ori=null;
	 		if(vipInfo.getUserid() != null){
	 			ori=vipInfoService.findById(vipInfo.getUserid());
	 		}
	 		
	 		if(ori==null){
	 			vipInfoService.save(vipInfo);
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
	 * 更改会员信息
	 */
    @RequestMapping("/vipInfo/update")
    public void updateVipInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    VipInfo vipInfo = getModel(VipInfo.class);
		    VipInfo ori=vipInfoService.findById(vipInfo.getUserid());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	vipInfoService.update(vipInfo);
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
	 * 删除会员信息
	 */
    @RequestMapping("/vipInfo/delete")
    public void deleteVipInfoById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	VipInfo vipInfo = getModel(VipInfo.class);
			vipInfoService.delete(vipInfo.getUserid());
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
	 * 查询全部会员信息
	 */
    @RequestMapping("/vipInfo/findAllVipInfo")
    public void findAllVipInfo(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<VipInfo> vipInfoList = vipInfoService.findAll();
			result.getData().put("vipInfoList",vipInfoList);
			result.setMessage("findAll vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个会员信息
	 */
	@RequestMapping("/vipInfo/deleteIds")
	public void deleteVipInfo(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("userid");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				vipInfoService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/vipInfo/list")
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
			param.put("companyId",admin.getCompanyId());
			PojoDomain<VipInfo> list = vipInfoService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find vipInfo successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find vipInfo fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}