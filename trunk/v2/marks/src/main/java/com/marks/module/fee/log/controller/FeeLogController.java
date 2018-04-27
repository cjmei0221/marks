package com.marks.module.fee.log.controller;

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
import com.marks.common.util.JsonUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.fee.log.pojo.FeeLog;
import com.marks.module.fee.log.service.FeeLogService;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

 /**
	 * 费用明细: 
	 */
@Controller
public class FeeLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( FeeLogController.class);
    
    @Autowired
    private FeeLogService  feeLogService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询费用明细
	 */
    @RequestMapping("/inner/feeLog/findById")
    public void findFeeLogById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    FeeLog info = getModel(FeeLog.class);
		    
		    logger.info("findFeeLogById > param>"+info.getId());
		    
			FeeLog vo = feeLogService.findById(info.getId());
			result.getData().put("info",vo);
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
	 * 列表查询
	 */
	@RequestMapping("/inner/feeLog/list")
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
			PojoDomain<FeeLog> list = feeLogService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find feeLog successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find feeLog fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}