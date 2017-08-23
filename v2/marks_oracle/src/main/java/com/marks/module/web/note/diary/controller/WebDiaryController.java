package com.marks.module.web.note.diary.controller;

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
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.module.inner.note.diary.pojo.Diary;
import com.marks.module.inner.note.diary.service.DiaryService;
import com.marks.module.inner.system.sys.controller.SupportContorller;
import com.marks.module.inner.system.upload.util.UploadUtil;
import com.marks.module.inner.user.login.service.LoginService;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.inner.user.sysuser.service.SysUserService;
import com.marks.module.web.runModel.RunModel;
import com.marks.module.web.user.login.util.LoginUtil;

@Controller
public class WebDiaryController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WebDiaryController.class);
    
    @Autowired
    private DiaryService  diaryService;
    @Autowired
	private SysUserService sysUserService;
    @Autowired
	private LoginService loginService;

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询我的日记
	 */
    @RequestMapping("/web/diary/findDiaryById")
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
    @RequestMapping("/web/getUUID")
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
    @RequestMapping("/web/diary/save")
    public void saveDiary(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	Diary diary = getModel(Diary.class);
	 //     diary.setID(IDUtil.getTimeID());
	    	diary.setCreator(admin.getUserid());
	    	Diary old=diaryService.findById(diary.getId());
	    	diary.setMobile(admin.getBind_mobile());
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
    @RequestMapping("/web/diary/update")
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
    @RequestMapping("/web/diary/delete")
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
    @RequestMapping("/web/diary/findAllDiary")
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
	@RequestMapping("/web/diary/deleteIds")
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
	@RequestMapping("/web/diary/list")
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
	    @RequestMapping("/web/saveForDiary")
	    public void saveForDiary(HttpServletRequest request,
	    HttpServletResponse response){
			Result result = new Result();
			try {
		    	Diary diary = getModel(Diary.class);
		    	Diary old=diaryService.findById(diary.getId());
		    	String mobile=request.getParameter("mobile");
		    	SysUser sysUser=loginService.getSysUserByUseridOrMobile(mobile);
		    	if(sysUser==null){
		    		sysUser=new SysUser();
		    		sysUser.setActiveFlag(Enums.SysUserUse.USE.getValue());
		    		sysUser.setBind_mobile(mobile);
		    		sysUser.setCompanyId(RunModel.getInstance().getCompanyId());
		    		sysUser.setPassword(EncryptUtil.defaultPwd);
		    		sysUser.setUsername(mobile);
		    		sysUser.setRoleid(RunModel.getInstance().getCompanyId()+"_"+Enums.UserType.VIP.getValue());
		    		sysUser.setCreator(mobile);
		    		sysUserService.save(sysUser,RunModel.getInstance().getCompanyId());
		    		sysUser=loginService.getSysUserByUseridOrMobile(mobile);
		    	}else{
		    		if(sysUser.getActiveFlag()==Enums.SysUserUse.NOUSE.getValue()){
		    			result.setMessage("此手机号已禁用");
						result.setCode("4001");
						JsonUtil.output(response, result);
						return;
		    		}
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
	    /**
		 * 导出txt
		 */
		@RequestMapping("/web/diary/export")
		public void export(HttpServletRequest request, HttpServletResponse response) {
			Result result = new Result();
			try {
				SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
				Map<String, Object> param = new HashMap<String, Object>();
				String keyword = request.getParameter("keyword");
				param.put("userid", admin.getUserid());
				param.put("keyword", keyword);
				String basePath = UploadUtil.getUploadPath(request);
				String path = diaryService.exportTxt(param, basePath);
				result.getData().put("filepath", path);
				result.setMessage("findAll diary successs!");
				result.setCode(Code.CODE_SUCCESS);
			} catch (Exception e) {
				e.printStackTrace();
				result.setMessage("findAll diary fail!");
				result.setCode(Code.CODE_FAIL);
			}
			JsonUtil.output(response, result);
		}
}