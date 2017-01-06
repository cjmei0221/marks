package com.cjmei.module.note.diary.controller;

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
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.code.Code;
import com.cjmei.common.util.encrypt.EncryptUtil;
import com.cjmei.module.note.diary.pojo.Diary;
import com.cjmei.module.note.diary.service.DiaryService;
import com.cjmei.module.system.login.pojo.SysUser;
import com.cjmei.module.system.login.service.SysUserService;
import com.cjmei.module.system.login.util.LoginUtil;
import com.cjmei.module.system.sys.controller.SupportContorller;

@Controller
public class DiaryController extends SupportContorller{
    private static Logger logger = Logger.getLogger( DiaryController.class);
    
    @Autowired
    private DiaryService  diaryService;
    @Autowired
	private SysUserService sysUserService;

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询我的日记
	 */
    @RequestMapping("/diary/findDiaryById")
    public void findDiaryById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Diary diary = getModel(Diary.class);
			Diary requestDiary = diaryService.findById(diary.getId());
			result.getData().put("diary",requestDiary);
			result.setMessage("findById diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    /**
	 * 保存我的日记
	 */
    @RequestMapping("/getUUID")
    public void getID(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			result.getData().put("id", IDUtil.getUUID());
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
    
    /**
	 * 保存我的日记
	 */
    @RequestMapping("/diary/save")
    public void saveDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String content=request.getParameter("content");
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Diary diary = getModel(Diary.class);
	 //     diary.setID(IDUtil.getTimeID());
	    	diary.setCreator(admin.getUserid());
	    	Diary old=diaryService.findById(diary.getId());
	    	if(old !=null){
	    		diaryService.update(diary);
	    	}else{
	    		diaryService.save(diary);
	    	}
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 更改我的日记
	 */
    @RequestMapping("/diary/update")
    public void updateDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    Diary diary = getModel(Diary.class);
			diaryService.update(diary);
			result.setMessage("更新成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除我的日记
	 */
    @RequestMapping("/diary/delete")
    public void deleteDiaryById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Diary diary = getModel(Diary.class);
			diaryService.delete(diary.getId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 查询全部我的日记
	 */
    @RequestMapping("/diary/findAllDiary")
    public void findAllDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Diary> diaryList = diaryService.findAll();
			result.getData().put("diaryList",diaryList);
			result.setMessage("findAll diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("findAll diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个我的日记
	 */
	@RequestMapping("/diary/deleteIds")
	public void deleteDiary(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("ID");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				diaryService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("delete diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/diary/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			Map<String,Object> param=new HashMap<String,Object>();
			String keyword=request.getParameter("keyword");
			param.put("userid", admin.getUserid());
			param.put("keyword", keyword);
			PojoDomain<Diary> list = diaryService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find diary successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("find diary fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	 /**
		 * 保存我的日记
		 */
	    @RequestMapping("/saveForDiary")
	    public void saveForDiary(HttpServletRequest request,
	    HttpServletResponse response){
			Result result = new Result();
			try {
		    	Diary diary = getModel(Diary.class);
		    	Diary old=diaryService.findById(diary.getId());
		    	String mobile=request.getParameter("mobile");
		    	SysUser sysUser=sysUserService.getSysUserByUseridOrMobile(mobile);
		    	if(sysUser==null){
		    		sysUser=new SysUser();
		    		sysUser.setActiveFlag(Enums.SysUserUse.USE.getValue());
		    		sysUser.setBind_mobile(mobile);
		    		sysUser.setCompanyId(LoginUtil.getInstance().getCompanyId());
		    		sysUser.setPassword(EncryptUtil.defaultPwd);
		    		sysUser.setUsername(mobile);
		    		sysUser.setUserType(Enums.SysUserType.VIP.getValue());
		    		sysUser.setCreator(mobile);
		    		sysUserService.save(sysUser);
		    		sysUser=sysUserService.getSysUserByUseridOrMobile(mobile);
		    	}
		    	diary.setCreator(sysUser.getUserid());
		    	if(old !=null){
		    		diaryService.update(diary);
		    	}else{
		    		diaryService.save(diary);
		    	}
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			} catch (Exception e) {
				logger.info(e);
				result.setMessage("保存失败，请联系管理员！");
				result.setCode(Code.CODE_FAIL);
			}
			JsonUtil.output(response, result);
		}
	
}