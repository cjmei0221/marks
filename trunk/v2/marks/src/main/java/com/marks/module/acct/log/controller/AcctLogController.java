package com.marks.module.acct.log.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.acct.log.pojo.AcctLog;
import com.marks.module.acct.log.service.AcctLogService;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 交易记录: 用户交易记录
	 */
@Controller
public class AcctLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AcctLogController.class);
    
    @Autowired
    private AcctLogService  acctLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}


	
	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/acctLog/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword=IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>"+page_number+"-"+page_size+"-"+keyword);
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<AcctLog> list = acctLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find acctLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find acctLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}