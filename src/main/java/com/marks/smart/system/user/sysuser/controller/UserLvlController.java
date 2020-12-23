package com.marks.smart.system.user.sysuser.controller;

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
import com.marks.smart.system.core.controller.SupportContorller;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.UserLvl;
import com.marks.smart.system.user.sysuser.service.UserLvlService;

/**
 * 用户等级: 用户等级
 */
@Controller
public class UserLvlController extends SupportContorller {
	private static Logger logger = Logger.getLogger(UserLvlController.class);

	@Autowired
	private UserLvlService userLvlService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询用户等级
	 */
	@RequestMapping("/inner/userLvl/findById")
	public void findUserLvlById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			UserLvl info = getModel(UserLvl.class);

			logger.info("findUserLvlById > param>" + info.getLvlId());

			UserLvl vo = userLvlService.findById(info.getLvlId());
			result.getData().put("info", vo);
			result.setMessage("findById successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存用户等级
	 */
	@RequestMapping("/inner/userLvl/save")
	public void saveUserLvl(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			UserLvl info = getModel(UserLvl.class);
			info.setLvlId(admin.getCompanyId() + "_" + info.getLvl());

			logger.info("saveUserLvl > param>" + info.toLog());

			UserLvl ori = null;
			if (info.getLvlId() != null) {
				ori = userLvlService.findById(info.getLvlId());
			}

			if (ori == null) {
				userLvlService.save(info);
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
	 * 更改用户等级
	 */
	@RequestMapping("/inner/userLvl/update")
	public void updateUserLvl(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			UserLvl info = getModel(UserLvl.class);

			logger.info(" updateUserLvl> param>" + info.toLog());

			UserLvl ori = userLvlService.findById(info.getLvlId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				userLvlService.update(info);
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
	 * 删除用户等级
	 */
	@RequestMapping("/inner/userLvl/delete")
	public void deleteUserLvlById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			UserLvl info = getModel(UserLvl.class);

			logger.info("deleteUserLvlById > param>" + info.getLvlId());

			userLvlService.delete(info.getLvlId());
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
	 * 查询全部用户等级
	 */

	/*
	 * @RequestMapping("/inner/userLvl/findAllUserLvl") public void
	 * findAllUserLvl(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { List<UserLvl> allList =
	 * userLvlService.findAll(); result.getData().put("allList",allList);
	 * result.setMessage("findAll userLvl successs!");
	 * result.setCode(Code.CODE_SUCCESS); } catch (Exception e) {
	 * logger.error(e.getMessage(),e);
	 * result.setMessage("findAll userLvl fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 删除多个用户等级
	 */
	/*
	 * @RequestMapping("/inner/userLvl/deleteIds") public void
	 * deleteUserLvl(HttpServletRequest request, HttpServletResponse response){
	 * Result result = new Result(); try { String id =
	 * request.getParameter("lvlId"); logger.info("delete batch> param>"+id);
	 * String[] ids = id.split(","); List<String> idList = new
	 * ArrayList<String>(); for(int i=0;i<ids.length;i++){ idList.add(ids[i]); }
	 * if(idList.size()>0){ userLvlService.deleteBatch(idList);
	 * result.setMessage("删除成功!"); result.setCode(Code.CODE_SUCCESS); }else{
	 * result.setMessage("删除失败，请联系管理员!"); result.setCode(Code.CODE_FAIL); }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(),e);
	 * result.setMessage("delete userLvl fail!");
	 * result.setCode(Code.CODE_FAIL); } JsonUtil.output(response, result); }
	 */

	/**
	 * 列表查询
	 */
	@RequestMapping("/inner/userLvl/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			if (page_size > 200) {
				page_size = 200;
			}
			String keyword = IStringUtil.getUTF8(request.getParameter("keyword"));
			logger.info("list> param>" + page_number + "-" + page_size + "-" + keyword);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyId());
			PojoDomain<UserLvl> list = userLvlService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find userLvl successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find userLvl fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}