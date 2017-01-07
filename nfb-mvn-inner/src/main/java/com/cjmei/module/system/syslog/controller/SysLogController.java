package com.cjmei.module.system.syslog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sys.pojo.SysLog;
import com.cjmei.module.system.syslog.service.SysLogService;
import com.cjmei.module.system.sysuser.pojo.SysUser;

@Controller
public class SysLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( SysLogController.class);
    
    @Autowired
    private SysLogService  sysLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/sysLog/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			String source=request.getParameter("source");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			param.put("source", source);
			PojoDomain<SysLog> list = sysLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find sysLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find sysLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}