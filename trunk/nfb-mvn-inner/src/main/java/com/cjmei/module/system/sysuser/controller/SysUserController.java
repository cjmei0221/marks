package com.cjmei.module.system.sysuser.controller;

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
import com.cjmei.common.util.encrypt.EncryptUtil;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;
import com.cjmei.module.system.orginfo.service.OrgInfoService;
import com.cjmei.module.system.sysuser.pojo.SysUser;
import com.cjmei.module.system.sysuser.service.SysUserService;

@Controller
public class SysUserController extends SupportContorller{
    private static Logger logger = Logger.getLogger( SysUserController.class);
    
    private String defaultPwd="B15A268148D9C5A9363E915581CE1819";
    @Autowired
    private SysUserService  sysUserService;
   
    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询用户管理
	 */
    @RequestMapping("/sysUser/findSysUserById")
    public void findSysUserById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    SysUser sysUser = getModel(SysUser.class);
			SysUser requestSysUser = sysUserService.findByUserid(sysUser.getUserid());
			result.getData().put("sysUser",requestSysUser);
			result.setMessage("findById sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
  
    /**
	 * 保存用户管理
	 */
    @RequestMapping("/sysUser/save")
    public void saveSysUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	SysUser sysUser = getModel(SysUser.class);
	 //     sysUser.setUserid(IDUtil.getTimeID());
	 		SysUser ori=sysUserService.findByMobile(sysUser.getBind_mobile());
	 		if(ori==null){
	 			//密码处理
	 			String orgIdsPut=request.getParameter("orgIdsPut");
	 			sysUser.setPassword(defaultPwd);
	 			sysUser.setCreator(admin.getUserid());
	 			sysUserService.save(sysUser,orgIdsPut);
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
	 * 更改用户管理
	 */
    @RequestMapping("/sysUser/update")
    public void updateSysUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    SysUser sysUser = getModel(SysUser.class);
		    SysUser ori=sysUserService.findByMobile(sysUser.getBind_mobile());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
	 			String orgIdsPut=request.getParameter("orgIdsPut");
		    	sysUserService.update(sysUser,orgIdsPut);
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
	 * 删除用户管理
	 */
    @RequestMapping("/sysUser/delete")
    public void deleteSysUserById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	SysUser sysUser = getModel(SysUser.class);
			sysUserService.delete(sysUser.getUserid());
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
	 * 查询全部用户管理
	 */
    @RequestMapping("/sysUser/findAllSysUser")
    public void findAllSysUser(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<SysUser> sysUserList = sysUserService.findAll();
			result.getData().put("sysUserList",sysUserList);
			result.setMessage("findAll sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个用户管理
	 */
	@RequestMapping("/sysUser/deleteIds")
	public void deleteSysUser(HttpServletRequest request,
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
				sysUserService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/sysUser/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			String ssorgid=request.getParameter("ssorgid");
			String s_role=request.getParameter("s_role");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("orgids", admin.getOrgids());
			param.put("companyId", admin.getCompanyId());
			param.put("sorgid", ssorgid);
			param.put("s_role", s_role);
			param.put("userType", Enums.UserType.SYS.getValue());
			PojoDomain<SysUser> list = sysUserService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysUser successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	/**
	 * 重置密码
	 */
    @RequestMapping("/sysUser/resetPwd")
    public void resetPwd(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String userid=request.getParameter("userid");
			SysUser su=sysUserService.findById(userid);
			if(su !=null){
				su.setPassword(defaultPwd);
				sysUserService.updatetPwd(su);
				result.setMessage("resetPwd sysUser successs!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    
    /**
     * 更新密码
     * @param request
     * @param response
     */
    @RequestMapping("/sysUser/updatePwd")
    public void updatePwd(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String newPwd=request.getParameter("newPwd");
			String oldPwd=request.getParameter("oldPwd");
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			SysUser su=sysUserService.findById(admin.getUserid());
			if(su.getPassword().equals(EncryptUtil.encrypt(oldPwd))){
				admin.setPassword(EncryptUtil.encrypt(newPwd));
				sysUserService.updatetPwd(admin);
			}else{
				result.setMessage("原密码错误");
				result.setCode(2001);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    /**
     * 更新手机号码
     * @param request
     * @param response
     */
    @RequestMapping("/sysUser/updateMobile")
    public void updateMobile(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String newPhone=request.getParameter("newPhone");
			String newPwd=request.getParameter("newPwd");
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			SysUser su=sysUserService.findById(admin.getUserid());
			if(su.getPassword().equals(EncryptUtil.encrypt(newPwd))){
				SysUser sUser=sysUserService.findByMobile(newPhone);
				if(sUser==null){
					sysUserService.updateMobile(admin.getUserid(),newPhone);
				}else{
					result.setMessage("此手机号已注册");
					result.setCode(4001);
				}
				
			}else{
				result.setMessage("密码错误");
				result.setCode(2001);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    /**
     * 更新手机号码
     * @param request
     * @param response
     */
    @RequestMapping("/sysUser/updateActiveFlag")
    public void updateActiveFlag(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String userid=request.getParameter("userid");
			SysUser su=sysUserService.findById(userid);
			if(su !=null){
				int flag=Enums.SysUserUse.USE.getValue();
				if(Enums.SysUserUse.USE.getValue()==su.getActiveFlag()){
					flag=Enums.SysUserUse.NOUSE.getValue();
				}
				sysUserService.updateActiveFlag(userid,flag);
				result.setMessage("resetPwd sysUser successs!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll sysUser fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}