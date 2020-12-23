package com.marks.smart.system.system.myimage.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.system.myimage.pojo.MyImage;
import com.marks.smart.system.system.myimage.service.MyImageService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

 /**
	 * 图片: 图片
	 */
@Controller
public class MyImageController extends SupportContorller{
    private static Logger logger = Logger.getLogger( MyImageController.class);
    
    @Autowired
    private MyImageService  myImageService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询图片
	 */
    @RequestMapping("/inner/myImage/findMyImageById")
    public void findMyImageById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    MyImage myImage = getModel(MyImage.class);
		    
		    logger.info("findMyImageById > param>"+myImage.getPicId());
		    
			MyImage requestMyImage = myImageService.findById(myImage.getPicId());
			result.getData().put("myImage",requestMyImage);
			result.setMessage("findById myImage successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存图片
	 */
    @RequestMapping("/inner/myImage/save")
    public void saveMyImage(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	MyImage myImage = getModel(MyImage.class);
	 //     myImage.setPicId(IDUtil.getTimeID());
	 		
	 		logger.info("saveMyImage > param>"+myImage.toLog());
	 
			 MyImage ori=null;
	 		if(myImage.getPicId() != null){
	 			ori=myImageService.findById(myImage.getPicId());
	 		}
	 		
	 		if(ori==null){
	 			myImageService.save(myImage);
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
	 * 更改图片
	 */
    @RequestMapping("/inner/myImage/update")
    public void updateMyImage(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    MyImage myImage = getModel(MyImage.class);
		    
		    logger.info(" updateMyImage> param>"+myImage.toLog());
		    
		    MyImage ori=myImageService.findById(myImage.getPicId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	myImageService.update(myImage);
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
	 * 删除图片
	 */
    @RequestMapping("/inner/myImage/delete")
    public void deleteMyImageById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	MyImage myImage = getModel(MyImage.class);
		   	
		   	logger.info("deleteMyImageById > param>"+myImage.getPicId());
		   	
			myImageService.delete(myImage.getPicId());
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
	 * 查询全部图片
	 */
    @RequestMapping("/inner/myImage/findAllMyImage")
    public void findAllMyImage(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<MyImage> myImageList = myImageService.findAll();
			result.getData().put("myImageList",myImageList);
			result.setMessage("findAll myImage successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll myImage fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个图片
	 */
	@RequestMapping("/inner/myImage/deleteIds")
	public void deleteMyImage(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("picId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				myImageService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete myImage fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/myImage/list")
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
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<MyImage> list = myImageService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find myImage successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find myImage fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}