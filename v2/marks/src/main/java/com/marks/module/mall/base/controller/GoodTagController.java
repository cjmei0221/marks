package com.marks.module.mall.base.controller;

import java.util.HashMap;
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
import com.marks.module.mall.base.pojo.GoodTag;
import com.marks.module.mall.base.service.GoodTagService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 商品标签: 商品标签
	 */
@Controller
public class GoodTagController extends SupportContorller{
    private static Logger logger = Logger.getLogger( GoodTagController.class);
    
    @Autowired
    private GoodTagService  goodTagService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询商品标签
	 */
    @RequestMapping("/inner/goodTag/findById")
    public void findGoodTagById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    GoodTag reqVo = getModel(GoodTag.class);
		    
		    logger.info("findGoodTagById > param>"+reqVo.getTagId());
		    
			GoodTag info = goodTagService.findById(reqVo.getTagId());
			result.getData().put("info",info);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存商品标签
	 */
    @RequestMapping("/inner/goodTag/save")
    public void saveGoodTag(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
	    	GoodTag reqVo = getModel(GoodTag.class);
	        reqVo.setTagId(IDUtil.getUUID());
	 		
	 		logger.info("saveGoodTag > param>"+reqVo.toLog());
	 
			 GoodTag ori=null;
	 		if(reqVo.getTagId() != null){
	 			ori=goodTagService.findById(reqVo.getTagId());
	 		}
	 		
	 		if(ori==null){
				reqVo.setCompanyId(admin.getCompanyId());
				reqVo.setCreator(admin.getUserCode() + " - " + admin.getUsername());
	 			goodTagService.save(reqVo);
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
	 * 更改商品标签
	 */
    @RequestMapping("/inner/goodTag/update")
    public void updateGoodTag(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		    GoodTag reqVo = getModel(GoodTag.class);
		    
		    logger.info(" updateGoodTag> param>"+reqVo.toLog());
		    
		    GoodTag ori=goodTagService.findById(reqVo.getTagId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	goodTagService.update(reqVo);
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
	 * 删除商品标签
	 */
    @RequestMapping("/inner/goodTag/delete")
    public void deleteGoodTagById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	GoodTag reqVo = getModel(GoodTag.class);
		   	
		   	logger.info("deleteGoodTagById > param>"+reqVo.getTagId());
		   	
			goodTagService.delete(reqVo.getTagId());
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
	 * 查询全部商品标签
	 */

    /*@RequestMapping("/inner/goodTag/findAllGoodTag")
    public void findAllGoodTag(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<GoodTag> allList = goodTagService.findAll();
			result.getData().put("allList",allList);
			result.setMessage("findAll goodTag successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll goodTag fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	} */
	
	/**
	 * 删除多个商品标签
	 */
	/*@RequestMapping("/inner/goodTag/deleteIds")
	public void deleteGoodTag(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("tagId");
			logger.info("delete batch> param>"+id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				goodTagService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete goodTag fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}*/
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/goodTag/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<GoodTag> list = goodTagService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find goodTag successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find goodTag fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}