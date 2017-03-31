package com.marks.module.autocode.web.controller;

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
import com.marks.module.autocode.core.produced.introduction.introduction.IntroductionPageProduced;
import com.marks.module.autocode.core.produced.pojo.AttrType;
import com.marks.module.autocode.core.produced.pojo.AutoAttr;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.util.AuthUtil;
import com.marks.module.autocode.core.util.AutoCodeFactory;
import com.marks.module.autocode.web.pojo.AutoCode;
import com.marks.module.autocode.web.pojo.AutoCodeAttr;
import com.marks.module.autocode.web.service.AutoCodeService;
import com.marks.module.system.sys.controller.SupportContorller;

@Controller
public class AutoCodeController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AutoCodeController.class);
    
    @Autowired
    private AutoCodeService  autoCodeService;
    
    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询自动生成代码记录
	 */
    @RequestMapping("/autoCode/findAutoCodeById")
    public void findAutoCodeById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    AutoCode autoCode = getModel(AutoCode.class);
			AutoCode requestAutoCode = autoCodeService.findById(autoCode.getTableName());
			result.getData().put("autoCode",requestAutoCode);
			result.setMessage("findById autoCode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存自动生成代码记录
	 */
    @RequestMapping("/autoCode/save")
    public void saveAutoCode(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
	    	AutoCode autoCode = getModel(AutoCode.class);
	 //     autoCode.setTableName(IDUtil.getTimeID());
	    	 String attrList = request.getParameter("attrListPut");
			autoCodeService.save(autoCode,attrList);
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
	 * 更改自动生成代码记录
	 */
    @RequestMapping("/autoCode/update")
    public void updateAutoCode(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    AutoCode autoCode = getModel(AutoCode.class);
		    String attrList = request.getParameter("attrListPut");
			autoCodeService.update(autoCode,attrList);
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
	 * 删除自动生成代码记录
	 */
    @RequestMapping("/autoCode/delete")
    public void deleteAutoCodeById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	AutoCode autoCode = getModel(AutoCode.class);
			autoCodeService.delete(autoCode.getTableName());
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
	 * 查询全部自动生成代码记录
	 */
    @RequestMapping("/autoCode/findAllAutoCode")
    public void findAllAutoCode(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<AutoCode> autoCodeList = autoCodeService.findAll();
			result.getData().put("autoCodeList",autoCodeList);
			result.setMessage("findAll autoCode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("findAll autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个自动生成代码记录
	 */
	@RequestMapping("/autoCode/deleteIds")
	public void deleteAutoCode(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("tableName");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				autoCodeService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("delete autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/autoCode/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			AutoCode autoCode = getModel(AutoCode.class);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("autoCode", autoCode);
			PojoDomain<AutoCode> list = autoCodeService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find autoCode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("find autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	@RequestMapping("/autoCode/attrList")
    public void attrList(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			int page_number =1;
			int page_size = 1000;
			AutoCode autoCode = getModel(AutoCode.class);
			Map<String,Object> param=new HashMap<String,Object>();
			String tableName=autoCode.getTableName();
			if(autoCode.getTableName()==null || "".equals(autoCode.getTableName())){
				tableName="";
			}
			param.put("tableName", tableName);
			PojoDomain<AutoCodeAttr> list = autoCodeService.attrList(page_number, page_size, param);
			result.getData().put("attrlist", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find autoCode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage("find autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	/**
	 * 自动生成代码
	 */
    @RequestMapping("/autoCode/autocode")
    public void autocode(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String tableName=request.getParameter("tableName");
			AutoCode info=autoCodeService.findDetailById(tableName);
			if(info==null){
				result.setMessage("该表记录不存在");
				result.setCode("3");
			}else{
				if(null !=info.getAttrList() && info.getAttrList().size()>0 ){
					AutoBean autoBean=getAutoBean(info);
					AutoCodeFactory.getInstance().autoCode(autoBean);
					if(info.getIs_createtable()==1){
						AutoCodeFactory.getInstance().createTable(autoBean);
					}
					result.setMessage("autoCode successs!");
					result.setCode(Code.CODE_SUCCESS);
					//授权
					if(info.getIs_auth()==1){
						AuthUtil.getInstance().addFuncForRole(autoBean);
					}
				}else{
					result.setMessage("该表没有字段，请添加字段");
					result.setCode("4");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    
    /**
	 * 自动生成代码
	 */
    @RequestMapping("/autoCode/autocodeIntroFile")
    public void autocodeIntroFile(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			String tableName=request.getParameter("tableName");
			AutoCode info=autoCodeService.findDetailById(tableName);
			if(info==null){
				result.setMessage("该表记录不存在");
				result.setCode("3");
			}else{
				if(null !=info.getAttrList() && info.getAttrList().size()>0 ){
					AutoBean autoBean=getAutoBean(info);
					AutoCodeFactory.getInstance().autoCodeOneFile(autoBean, new IntroductionPageProduced());
				}else{
					result.setMessage("该表没有字段，请添加字段");
					result.setCode("4");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    
    private AutoBean getAutoBean(AutoCode info) {
		AutoBean autoBean = new AutoBean();
		autoBean.setBeanName(info.getBeanName());
		autoBean.setModuleDesc(info.getModuleDesc());
		autoBean.setTableName(info.getTableName().toUpperCase());
		autoBean.setParentPackage(info.getParentPackage());
		autoBean.setDescription(info.getDescription());
		// 包路径
		// autoBean.setDefaultPackageUrl("cluster.scheme.module.rbac.");
		List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
		AutoAttr attr=null;
		if(null !=info.getAttrList() && info.getAttrList().size()>0){
			for(AutoCodeAttr vo:info.getAttrList()){
				attr=new AutoAttr();
				attr.setAttrDesc(vo.getAttrDesc());
				attr.setAttrName(vo.getAttrName());
				attr.setAttrSize(vo.getAttrSize());
				attr.setAttrType(AttrType.getAttrTypeByString(vo.getAttrType()));
				attr.setPK(vo.getIsPK()==1?true:false);
				attr.setSeq("");
				attr.setNote(vo.getNote());
				attr.setIsQuery(vo.getIsQuery());
				autoAttrs.add(attr);
			}
		}
		autoBean.setAutoAttrs(autoAttrs);
		return autoBean;
	}
}