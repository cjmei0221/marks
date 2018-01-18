package com.marks.module.wx.manage.controller.base;

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
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.entity.base.MyWxMenu;
import com.marks.module.wx.manage.service.base.WxMenuService;

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
	@RequestMapping("/inner/wxMenu/findWxMenuById")
	public void findWxMenuById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			MyWxMenu wxMenu = getModel(MyWxMenu.class);

			MyWxMenu requestWxMenu = wxMenuService.findById(wxMenu.getId());
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
	@RequestMapping("/inner/wxMenu/save")
	public void saveWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			MyWxMenu wxMenu = getModel(MyWxMenu.class);
			// wxMenu.setId(IDUtil.getTimeID());
			if(wxMenu.getLvl() !=0){
				MyWxMenu ori  = wxMenuService.findById(wxMenu.getParent_id());
				wxMenu.setAccountid(ori.getAccountid());
			}
			wxMenu.setCompanyId(admin.getCompanyId());
			wxMenuService.save(wxMenu);
			result.setMessage("保存成功");
			result.setCode(Code.CODE_SUCCESS);

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
	@RequestMapping("/inner/wxMenu/update")
	public void updateWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			MyWxMenu wxMenu = getModel(MyWxMenu.class);
			MyWxMenu ori = wxMenuService.findById(wxMenu.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				if (wxMenu.getLvl() != 0) {
					wxMenu.setMenutype(ori.getMenutype());
					wxMenu.setTagid(ori.getTagid());
					wxMenu.setMenuid(ori.getMenuid());
				}
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
	@RequestMapping("/inner/wxMenu/delete")
	public void deleteWxMenuById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			MyWxMenu wxMenu = getModel(MyWxMenu.class);
			List<MyWxMenu> childList = wxMenuService.getChildWxMenuList(wxMenu.getId());
			if (null != childList && childList.size() > 0) {
				result.setMessage("含有子节点不能删除!");
				result.setCode("4004");
			} else {
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
	@RequestMapping("/inner/wxMenu/findAllWxMenu")
	public void findAllWxMenu(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<MyWxMenu> wxMenuList = wxMenuService.findAll();
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
	@RequestMapping("/inner/wxMenu/deleteIds")
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
	@RequestMapping("/inner/wxMenu/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {

		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String parentId = request.getParameter("parentId");
		if (parentId == null || "".equals(parentId)) {
			parentId = "0";
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("companyId", admin.getCompanyId());
		param.put("parentId", parentId);
		List<MyWxMenu> list = wxMenuService.listTree(param);
		JsonUtil.output(response, JSONArray.fromObject(list).toString());
	}

	/**
	 * 同步微信
	 */
	@RequestMapping("/inner/wxMenu/syncWx")
	public void syncWx(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		try {
			String id = request.getParameter("id");
			result = wxMenuService.syncWx(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("syncWx wxMenu fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}