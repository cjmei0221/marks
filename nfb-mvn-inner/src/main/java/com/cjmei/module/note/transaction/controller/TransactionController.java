package com.cjmei.module.note.transaction.controller;

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

import com.cjmei.common.domain.PaginationResult;
import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.autocode.core.util.Code;
import com.cjmei.module.autocode.core.produced.SupportContorller;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

import com.cjmei.module.note.transaction.pojo.Transaction;
import com.cjmei.module.note.transaction.service.TransactionService;

 /**
	 * 事务提醒: 1，事务提醒 ，特殊日子可设置每年提醒，普通事务提醒，默认明天；<br/>2，提醒时间是9点提醒<br/>3，可设置提前提醒
	 */
@Controller
public class TransactionController extends SupportContorller{
    private static Logger logger = Logger.getLogger( TransactionController.class);
    
    @Autowired
    private TransactionService  transactionService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询事务提醒
	 */
    @RequestMapping("/transaction/findTransactionById")
    public void findTransactionById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    Transaction transaction = getModel(Transaction.class);
			Transaction requestTransaction = transactionService.findById(transaction.getId());
			result.getData().put("transaction",requestTransaction);
			result.setMessage("findById transaction successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    /**
	 * 保存事务提醒
	 */
    @RequestMapping("/transaction/save")
    public void saveTransaction(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
	    	Transaction transaction = getModel(Transaction.class);
	 //     transaction.setId(IDUtil.getTimeID());
			 Transaction ori=null;
	 		if(transaction.getId() != null){
	 			ori=transactionService.findById(transaction.getId());
	 		}
	 		
	 		if(ori==null){
	 			transactionService.save(transaction);
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
	 * 更改事务提醒
	 */
    @RequestMapping("/transaction/update")
    public void updateTransaction(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
		    Transaction transaction = getModel(Transaction.class);
		    Transaction ori=transactionService.findById(transaction.getId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	transactionService.update(transaction);
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
	 * 删除事务提醒
	 */
    @RequestMapping("/transaction/delete")
    public void deleteTransactionById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	Transaction transaction = getModel(Transaction.class);
			transactionService.delete(transaction.getId());
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
	 * 查询全部事务提醒
	 */
    @RequestMapping("/transaction/findAllTransaction")
    public void findAllTransaction(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<Transaction> transactionList = transactionService.findAll();
			result.getData().put("transactionList",transactionList);
			result.setMessage("findAll transaction successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll transaction fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个事务提醒
	 */
	@RequestMapping("/transaction/deleteIds")
	public void deleteTransaction(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				transactionService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete transaction fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/transaction/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			PojoDomain<Transaction> list = transactionService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find transaction successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find transaction fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
}