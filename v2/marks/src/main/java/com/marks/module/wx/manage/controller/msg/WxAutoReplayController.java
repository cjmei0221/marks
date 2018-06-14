package com.marks.module.wx.manage.controller.msg;

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
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.entity.msg.WxAutoReplay;
import com.marks.module.wx.manage.service.msg.WxAutoReplayService;

@Controller
public class WxAutoReplayController extends SupportContorller {
	private static Logger logger = Logger.getLogger(WxAutoReplayController.class);

	@Autowired
	private WxAutoReplayService wxAutoReplayService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询微信回复管理
	 */
	@RequestMapping("/inner/wxAutoReplay/findWxAutoReplayById")
	public void findWxAutoReplayById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			WxAutoReplay requestWxAutoReplay = wxAutoReplayService.findById(wxAutoReplay.getCtype());
			result.getData().put("wxAutoReplay", requestWxAutoReplay);
			result.setMessage("findById wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存微信回复管理
	 */
	@RequestMapping("/inner/wxAutoReplay/save")
	public void saveWxAutoReplay(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			// wxAutoReplay.setCparentType(IDUtil.getTimeID());
			wxAutoReplay.setCkey(wxAutoReplay.getCkey().toLowerCase());
			List<WxAutoReplay> ori = null;
			if (wxAutoReplay.getCkey() != null) {
				ori = wxAutoReplayService.findByCkey(wxAutoReplay.getCkey().toLowerCase(), wxAutoReplay.getCkeyName(),
						wxAutoReplay.getAccountid());
			}

			if (ori != null && ori.size() > 0) {
				result.setMessage("此记录已经存在，不能重复！");
				result.setCode(Code.CODE_FAIL);
			} else {
				wxAutoReplay.setCompanyId(admin.getCompanyId());
				wxAutoReplay.setCreator(admin.getOperator());
				wxAutoReplayService.save(wxAutoReplay);
				result.setMessage("保存成功");
				result.setCode(Code.CODE_SUCCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 更改微信回复管理
	 */
	@RequestMapping("/inner/wxAutoReplay/update")
	public void updateWxAutoReplay(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			wxAutoReplay.setCkey(wxAutoReplay.getCkey().toLowerCase());
			WxAutoReplay ori = wxAutoReplayService.findById(wxAutoReplay.getCtype());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				if (ori.getCkey().equals(wxAutoReplay.getCkey())
						&& ori.getCkeyName().equals(wxAutoReplay.getCkeyName())) {
					wxAutoReplayService.update(wxAutoReplay);
					result.setMessage("更新成功!");
					result.setCode(Code.CODE_SUCCESS);
				} else {
					List<WxAutoReplay> oriList = wxAutoReplayService.findByCkey(wxAutoReplay.getCkey(),
							wxAutoReplay.getCkeyName(), wxAutoReplay.getAccountid());
					if (oriList != null && oriList.size() > 0) {
						result.setMessage("此记录已经存在，不能重复!");
						result.setCode("4002");
					} else {
						wxAutoReplayService.update(wxAutoReplay);
						result.setMessage("更新成功!");
						result.setCode(Code.CODE_SUCCESS);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("更新失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除微信回复管理
	 */
	@RequestMapping("/inner/wxAutoReplay/delete")
	public void deleteWxAutoReplayById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			WxAutoReplay wxAutoReplay = getModel(WxAutoReplay.class);
			wxAutoReplayService.delete(wxAutoReplay.getCtype());
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
	 * 查询全部微信回复管理
	 */
	@RequestMapping("/inner/wxAutoReplay/findAllWxAutoReplay")
	public void findAllWxAutoReplay(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<WxAutoReplay> wxAutoReplayList = wxAutoReplayService.findAll();
			result.getData().put("wxAutoReplayList", wxAutoReplayList);
			result.setMessage("findAll wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll wxAutoReplay fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/wxAutoReplay/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<WxAutoReplay> list = wxAutoReplayService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find wxAutoReplay successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find wxAutoReplay fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}