package com.marks.module.wx.manage.base.controller;

import java.sql.Timestamp;
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
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.base.pojo.WxAccount;
import com.marks.module.wx.manage.base.service.WxAccountService;

import net.sf.json.JSONArray;

@Controller
public class WxAccountController extends SupportContorller{
    private static Logger logger = Logger.getLogger( WxAccountController.class);
    
    @Autowired
    private WxAccountService  wxAccountService;
   

    @Override
	public Logger getLogger() {
		return logger;
	}

    /**
	 * 查询公众号管理
	 */
    @RequestMapping("/inner/wxAccount/findWxAccountById")
    public void findWxAccountById(HttpServletRequest request,
    HttpServletResponse response){
        Result result = new Result();
		try {
		    WxAccount wxAccount = getModel(WxAccount.class);
			WxAccount requestWxAccount = wxAccountService.findById(wxAccount.getAccountId());
			result.getData().put("wxAccount",requestWxAccount);
			result.setMessage("findById wxAccount successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
    
    
    /**
	 * 保存公众号管理
	 */
    @RequestMapping("/inner/wxAccount/save")
    public void saveWxAccount(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
	    	WxAccount wxAccount = getModel(WxAccount.class);
	 //     wxAccount.setAccountId(IDUtil.getTimeID());
	 		WxAccount ori=wxAccountService.findById(wxAccount.getAccountId());
	 		if(ori==null){
	 			
	 			wxAccount.setCreatetime(new Timestamp(System.currentTimeMillis()));
	 			wxAccount.setUpdatetime(wxAccount.getCreatetime());
	 			wxAccount.setCreator(admin.getUserid());
	 			wxAccount.setUrl(getUrl(wxAccount));
//	 			OrgInfo info=StaticData.getOrgInfo(wxAccount.getOrgid());
//	 			wxAccount.setCompanyId(info.getCompanyId());
	 			wxAccount.setCompanyId(wxAccount.getOrgid());
	 			wxAccountService.save(wxAccount);
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
	private String getUrl(WxAccount wxAccount){
		return wxAccount.getAuthdomain()+wxAccount.getServer_context()+"WECHAT/HANDLER?accountid="+wxAccount.getAccountId();
	}
	/**
	 * 更改公众号管理
	 */
    @RequestMapping("/inner/wxAccount/update")
    public void updateWxAccount(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		    WxAccount wxAccount = getModel(WxAccount.class);
		    WxAccount ori=wxAccountService.findById(wxAccount.getAccountId());
		    if(ori == null){
		    	result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
		    }else{
		    	wxAccount.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		    	wxAccount.setUrl(getUrl(wxAccount));
		    	/*OrgInfo info=StaticData.getOrgInfo(wxAccount.getOrgid());
	 			wxAccount.setCompanyId(info.getCompanyId());*/
		    	wxAccount.setCompanyId(wxAccount.getOrgid());
		    	wxAccountService.update(wxAccount);
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
	 * 删除公众号管理
	 */
    @RequestMapping("/inner/wxAccount/delete")
    public void deleteWxAccountById(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
		   	WxAccount wxAccount = getModel(WxAccount.class);
			wxAccountService.delete(wxAccount.getAccountId());
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
	 * 查询全部公众号管理
	 */
    @RequestMapping("/inner/wxAccount/findAllWxAccount")
    public void findAllWxAccount(HttpServletRequest request,
    HttpServletResponse response){
		Result result = new Result();
		try {
			List<WxAccount> wxAccountList = wxAccountService.findAll();
			result.getData().put("wxAccountList",wxAccountList);
			result.setMessage("findAll wxAccount successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("findAll wxAccount fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * 删除多个公众号管理
	 */
	@RequestMapping("/inner/wxAccount/deleteIds")
	public void deleteWxAccount(HttpServletRequest request,
			HttpServletResponse response){
		Result result = new Result();
		try {
			String id = request.getParameter("accountId");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for(int i=0;i<ids.length;i++){
				idList.add(ids[i]);
			}
			if(idList.size()>0){
				wxAccountService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}else{
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("delete wxAccount fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
	
	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxAccount/list")
    public void list(HttpServletRequest request,HttpServletResponse response){
       PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword=request.getParameter("keyword");
			if(keyword==null){
				keyword="";
			}
			Map<String,Object> param=new HashMap<String,Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WxAccount> list = wxAccountService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxAccount successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.setMessage("find wxAccount fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
    }
	
	@RequestMapping("/inner/wxAccount/combox")
	public void combox(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = ManageUtil.getCurrentUserInfo(request);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("companyId", admin.getCompanyId());
		List<WxAccount> list = wxAccountService.combox(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}
	
}