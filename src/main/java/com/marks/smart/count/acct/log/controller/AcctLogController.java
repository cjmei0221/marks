package com.marks.smart.count.acct.log.controller;

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
import com.marks.common.enums.AcctEnums;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.string.IStringUtil;
import com.marks.smart.count.acct.ext.pojo.PointLog;
import com.marks.smart.count.acct.ext.pojo.TranLog;
import com.marks.smart.count.acct.ext.service.AcctService;
import com.marks.smart.count.acct.log.pojo.AcctLog;
import com.marks.smart.count.acct.log.service.AcctLogService;
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

 /**
	 * 交易记录: 用户交易记录
	 */
@Controller
public class AcctLogController extends SupportContorller{
    private static Logger logger = Logger.getLogger( AcctLogController.class);
    
    @Autowired
    private AcctLogService  acctLogService;
    @Autowired
    private AcctService  acctService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}
    
    /**
	 * 保存用户积分
	 */
    @RequestMapping("/inner/acct/save")
    public void save(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			AcctLog info = getModel(AcctLog.class,request.getParameterMap());
			String orderId=IDUtil.getNumID();
	 		if(AcctEnums.YwCode.point.getValue().equals(info.getYwCode())) {
	 			PointLog log=new PointLog();
	 			log.setChannelId(ChannelEnums.Channel.manage.getValue());
	 			log.setOperatorCode(admin.getUserCode());
	 			log.setOperatorName(admin.getUsername());
	 			log.setOrderId(orderId);
	 			log.setOrgId(admin.getOrgId());
	 			log.setOrgName(admin.getOrgName());
	 			log.setRemarks("(手工)"+(info.getRemarks()==null?"":info.getRemarks()));
	 			log.setTranCode(info.getTranCode());
	 			if(AcctEnums.TranCode.add.getValue().equals(info.getTranCode())) {
	 				log.setTranDesc("人工新增");
	 			}else {
	 				log.setTranDesc("人工扣减");
	 			}
	 			log.setTranPoint(info.getTranPoint());
	 			log.setTranTime(DateUtil.getCurrDateStr());
	 			log.setUserid(info.getUserid());
	 			acctService.savePoint(log);
	 		}else if(AcctEnums.YwCode.acct.getValue().equals(info.getYwCode())) {
	 			TranLog log=new TranLog();
	 			log.setCashAmt("0.00");
	 			log.setChannelId(ChannelEnums.Channel.manage.getValue());
	 			log.setOperatorCode(admin.getUserCode());
	 			log.setOperatorName(admin.getUsername());
	 			log.setOrderId(orderId);
	 			log.setOrgId(admin.getOrgId());
	 			log.setOrgName(admin.getOrgName());
	 			log.setRemarks("(手工)"+(info.getRemarks()==null?"":info.getRemarks()));
	 			log.setTranCode(info.getTranCode());
	 			if(AcctEnums.TranCode.add.getValue().equals(info.getTranCode())) {
	 				log.setTranDesc("人工新增");
	 			}else {
	 				log.setTranDesc("人工扣减");
	 			}
	 			log.setTranTime(DateUtil.getCurrDateStr());
	 			log.setUserid(info.getUserid());
	 			log.setSendAmt(info.getSendAmt());
	 			log.setTranAmt(info.getSendAmt());
	 			acctService.saveAmt(log);
	 		}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
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
			param.put("ywCode", request.getParameter("ywCode"));
			param.put("companyId", admin.getCompanyId());
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