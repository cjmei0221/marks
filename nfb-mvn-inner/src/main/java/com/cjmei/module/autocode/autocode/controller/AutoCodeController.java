package com.cjmei.module.autocode.autocode.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.cjmei.common.util.syscode.Code;
import com.cjmei.module.autocode.autocode.pojo.AutoCode;
import com.cjmei.module.autocode.autocode.pojo.AutoCodeAttr;
import com.cjmei.module.autocode.autocode.service.AutoCodeService;
import com.cjmei.module.system.autocode.DBProduced;
import com.cjmei.module.system.autocode.config.AutoConfig;
import com.cjmei.module.system.autocode.extern.ExternAutoCode;
import com.cjmei.module.system.autocode.factory.DefaultExternAutoBeanFactory;
import com.cjmei.module.system.autocode.pojo.AttrType;
import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.table.MySqlTableProduced;
import com.cjmei.module.system.autocode.webpage.html.htmlpage.HtmlPageProduced;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.controller.SupportContorller;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sys.service.SysMenuService;
import com.cjmei.module.system.sys.service.SysRoleService;

@Controller
public class AutoCodeController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AutoCodeController.class);
    
    @Autowired
	private SysMenuService sysMenuService;
    
    @Autowired
    private AutoCodeService  autoCodeService;

    @Autowired
	private SysRoleService sysRoleService;
    
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
	    	 String attrList = request.getParameter("attrList");
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
		    String attrList = request.getParameter("attrList");
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
				result.setCode(3);
			}else{
				if(null !=info.getAttrList() && info.getAttrList().size()>0 ){
					ExternAutoCode autoCode = new DefaultExternAutoBeanFactory().externAutoCodeBean();
					AutoBean autoBean=getAutoBean(info);
					autoCode.autoProducedCode(autoBean, true);
					if(info.getIs_createtable()==1){
						DBProduced dbutil = new MySqlTableProduced();
						dbutil.createTable(autoBean);
					}
					result.setMessage("findAll autoCode successs!");
					result.setCode(Code.CODE_SUCCESS);
					//授权
					SysUser user=SysUserHelper.getCurrentUserInfo(request);
					HtmlPageProduced html = new HtmlPageProduced();
					String autoBeanName=html.getFileSrc(autoBean);
					String menuUrl=AutoConfig.FILE_Menu_SRC+autoBeanName+"/"+autoBeanName+"."+html.DEFAULT_FILE_HTML;
					String listurl="/"+autoBeanName+"/list";
					String saveurl="/"+autoBeanName+"/save";
					String updateurl="/"+autoBeanName+"/update";
					String deleteurl="/"+autoBeanName+"/delete";
					SysMenu sm=sysMenuService.getSysMenuByMenuid(autoBeanName);
					if(sm==null){
						sm=new SysMenu();
						sm.setMenuid(autoBeanName);
						sm.setMenuitem(info.getModuleDesc());
						sm.setParentid("4");
						sm.setSort(20);
						sm.setUrl(menuUrl);
						sm.setCreatetime(new Date());
						sm.setCreator(user.getUsername());
						sm.setUpdatetime(new Date());
						sysMenuService.save(sm);
						SysOperate query=sysMenuService.saveFunc("1", sm.getMenuid(), listurl);
						SysOperate add=sysMenuService.saveFunc("2", sm.getMenuid(), saveurl);
						SysOperate update=sysMenuService.saveFunc("3", sm.getMenuid(), updateurl);
						SysOperate delete=sysMenuService.saveFunc("4", sm.getMenuid(), deleteurl);
						List<String> funcIds=new ArrayList<String>();
						funcIds.add(query.getFuncid());
						funcIds.add(add.getFuncid());
						funcIds.add(update.getFuncid());
						funcIds.add(delete.getFuncid());
						sysRoleService.addSysFuncByRoleId("20160928", funcIds);
					}
					
				}else{
					result.setMessage("该表没有字段，请添加字段");
					result.setCode(4);
				}
			}
		} catch (Exception e) {
			result.setMessage("findAll autoCode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
    private AutoBean getAutoBean(AutoCode info) {
		AutoBean autoBean = new AutoBean();
		autoBean.setBeanName(info.getBeanName().toLowerCase());
		autoBean.setModuleDesc(info.getModuleDesc());
		autoBean.setTableName(info.getTableName().toLowerCase());
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
				autoAttrs.add(attr);
			}
		}
		autoBean.setAutoAttrs(autoAttrs);
		return autoBean;
	}
}