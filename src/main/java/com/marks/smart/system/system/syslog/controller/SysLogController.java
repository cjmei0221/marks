package com.marks.smart.system.system.syslog.controller;

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
import com.marks.common.util.Code;
import com.marks.common.util.Constants;
import com.marks.common.util.JsonUtil;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.system.syslog.pojo.SysLog;
import com.marks.smart.system.system.syslog.service.SysLogService;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

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
	@RequestMapping("/inner/sysLog/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			String source=request.getParameter("source");
			if(keyword==null){
				keyword="";
			}
			String companyId=admin.getCompanyId();
			if(Constants.default_roleId.equals(admin.getRoleId())) {
				companyId="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", companyId);
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