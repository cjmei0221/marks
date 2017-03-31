package com.marks.module.wx.wxmenu.controller;

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

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.system.core.helper.SysUserHelper;
import com.marks.module.system.sys.controller.SupportContorller;
import com.marks.module.system.sysuser.pojo.SysUser;
import com.marks.module.wx.wxmenu.pojo.WxMenu;
import com.marks.module.wx.wxmenu.service.WxMenuService;

import net.sf.json.JSONArray;

@Controller
public class WxMenuController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WxMenuController.class);

	@Autowired
	private WxMenuService wxMenuService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询微信菜单管理
	 */
	@RequestMapping("/wxMenu/findWxMenuById")
	public void findWxMenuById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxMenu wxMenu = getModel(WxMenu.class);
			
			WxMenu requestWxMenu = wxMenuService.findById(wxMenu.getId());
			result.getData().put("wxMenu", requestWxMenu);
			result.setMessage("findById wxMenu successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存微信菜单管理
	 */
	@RequestMapping("/wxMenu/save")
	public void saveWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			WxMenu wxMenu = getModel(WxMenu.class);
			// wxMenu.setId(IDUtil.getTimeID());
			WxMenu ori = null;
			if (wxMenu.getId() != null) {
				ori = wxMenuService.findById(wxMenu.getId());
			}

			if (ori == null) {
				wxMenuService.save(wxMenu);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("此记录已存在");
				result.setCode(Code.CODE_FAIL);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改微信菜单管理
	 */
	@RequestMapping("/wxMenu/update")
	public void updateWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = SysUserHelper.getCurrentUserInfo(request);
			WxMenu wxMenu = getModel(WxMenu.class);
			WxMenu ori = wxMenuService.findById(wxMenu.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				wxMenuService.update(wxMenu);
				result.setMessage("更新成功!");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除微信菜单管理
	 */
	@RequestMapping("/wxMenu/delete")
	public void deleteWxMenuById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxMenu wxMenu = getModel(WxMenu.class);
			List<WxMenu> childList=wxMenuService.getChildWxMenuList(wxMenu.getId());
			if(null != childList && childList.size()>0){
				result.setMessage("含有子节点不能删除!");
				result.setCode("4004");
			}else{
				wxMenuService.delete(wxMenu.getId());
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询全部微信菜单管理
	 */
	@RequestMapping("/wxMenu/findAllWxMenu")
	public void findAllWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<WxMenu> wxMenuList = wxMenuService.findAll();
			result.getData().put("wxMenuList", wxMenuList);
			result.setMessage("findAll wxMenu successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll wxMenu fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个微信菜单管理
	 */
	@RequestMapping("/wxMenu/deleteIds")
	public void deleteWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				wxMenuService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete wxMenu fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/wxMenu/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = SysUserHelper.getCurrentUserInfo(request);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("accountIds", admin.getAccountids());
		List<WxMenu> list = wxMenuService.listTree(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	/**
	 * 同步微信
	 */
	@RequestMapping("/wxMenu/syncWx")
	public void syncWx(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		try {
			String accountid=request.getParameter("accountid");
			result = wxMenuService.syncWx(accountid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("syncWx wxMenu fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}