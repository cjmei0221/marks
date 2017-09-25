package com.marks.module.wx.manage.wxchat.controller;

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

import com.marks.common.domain.PaginationResult;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.LoginInnerUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.wxchat.pojo.WxChatMsg;
import com.marks.module.wx.manage.wxchat.pojo.WxChatSession;
import com.marks.module.wx.manage.wxchat.service.WxChatMsgService;
import com.marks.module.wx.manage.wxchat.service.WxChatSessionService;
import com.marks.module.wx.manage.wxutil.WxFwUtil;

/**
 * 询问管理: 记录粉丝询问和回复
 */
@Controller
public class WxChatMsgController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WxChatMsgController.class);

	@Autowired
	private WxChatMsgService wxChatMsgService;
	@Autowired
	private WxChatSessionService  wxChatSessionService;
	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/findWxChatMsgById")
	public void findWxChatMsgById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxChatMsg wxChatMsg = getModel(WxChatMsg.class);

			logger.info("findWxChatMsgById > param>" + wxChatMsg.getId());

			WxChatMsg requestWxChatMsg = wxChatMsgService.findById(wxChatMsg.getId());
			result.getData().put("wxChatMsg", requestWxChatMsg);
			result.setMessage("findById wxChatMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/save")
	public void saveWxChatMsg(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			WxChatMsg wxChatMsg = getModel(WxChatMsg.class);
			// wxChatMsg.setId(IDUtil.getTimeID());

			logger.info("saveWxChatMsg > param>" + wxChatMsg.toLog());
			//WxChatMsg old = wxChatMsgService.findById(wxChatMsg.getId());
			WxChatSession old = wxChatSessionService.findById(wxChatMsg.getSession_id());
			wxChatMsg.setAccountid(old.getAccountid());
			wxChatMsg.setC_type(1);
			wxChatMsg.setOpenid(old.getOpenid());
			wxChatMsg.setSession_id(old.getSession_id());
			wxChatMsg.setUserid(admin.getUserid());
			wxChatMsg.setCreatetime(new Date());
			wxChatMsg.setUsername(admin.getUsername());
			wxChatMsg.setIs_replay(1);
			result=WxFwUtil.getInstance().sendCustomTextMsg(wxChatMsg.
			getAccountid(), wxChatMsg.getOpenid(), wxChatMsg.getC_content());
			 
			if (Code.CODE_SUCCESS.equals(result.getCode())) {
				wxChatMsgService.save(wxChatMsg);
				result.getData().put("info", wxChatMsg);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/update")
	public void updateWxChatMsg(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			WxChatMsg wxChatMsg = getModel(WxChatMsg.class);

			logger.info(" updateWxChatMsg> param>" + wxChatMsg.toLog());

			WxChatMsg ori = wxChatMsgService.findById(wxChatMsg.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				wxChatMsgService.update(wxChatMsg);
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
	 * 删除询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/delete")
	public void deleteWxChatMsgById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxChatMsg wxChatMsg = getModel(WxChatMsg.class);

			logger.info("deleteWxChatMsgById > param>" + wxChatMsg.getId());

			wxChatMsgService.delete(wxChatMsg.getId());
			result.setMessage("删除成功!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("删除失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询全部询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/findAllWxChatMsg")
	public void findAllWxChatMsg(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<WxChatMsg> wxChatMsgList = wxChatMsgService.findAll();
			result.getData().put("wxChatMsgList", wxChatMsgList);
			result.setMessage("findAll wxChatMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll wxChatMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/deleteIds")
	public void deleteWxChatMsg(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			logger.info("delete batch> param>" + id);
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				wxChatMsgService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete wxChatMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxChatMsg/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginInnerUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			PojoDomain<WxChatMsg> list = wxChatMsgService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxChatMsg successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find wxChatMsg fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 查询询问管理
	 */
	@RequestMapping("/inner/wxChatMsg/replayList")
	public void replayList(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		String session_id = request.getParameter("session_id");

		logger.info("replayList > param>" + session_id);

		List<WxChatMsg> list = wxChatMsgService.getReplayList(session_id);
		result.getData().put("repayList", list);
		result.setMessage("findById wxChatMsg successs!");
		result.setCode(Code.CODE_SUCCESS);

		JsonUtil.output(response, result);
	}

}