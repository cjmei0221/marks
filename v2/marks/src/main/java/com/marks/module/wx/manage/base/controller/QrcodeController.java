package com.marks.module.wx.manage.base.controller;

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
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.qrImage.QrcodeUtil;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.base.pojo.Qrcode;
import com.marks.module.wx.manage.base.service.QrcodeService;
import com.marks.module.wx.manage.wxutil.WxMpUtil;

@Controller
public class QrcodeController extends SupportContorller {
	private static Logger logger = Logger.getLogger(QrcodeController.class);

	@Autowired
	private QrcodeService qrcodeService;

	@Override
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 查询二维码管理
	 */
	@RequestMapping("/inner/qrcode/findQrcodeById")
	public void findQrcodeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Qrcode qrcode = getModel(Qrcode.class);
			Qrcode requestQrcode = qrcodeService.findById(qrcode.getId());
			result.getData().put("qrcode", requestQrcode);
			result.setMessage("findById qrcode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("查询失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 保存二维码管理
	 */
	@RequestMapping("/inner/qrcode/save")
	public void saveQrcode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			Qrcode qrcode = getModel(Qrcode.class);
			qrcode.setQrNo(IDUtil.getTimeID());
			Qrcode ori = null;
			if ("1".equals(qrcode.getQrType())) {// 公众号
				ori = qrcodeService.findByQrNo(qrcode.getQrNo(),qrcode.getAccountid());
				if (ori == null) {
					
					qrcode.setCompanyId(admin.getCompanyNo());
					qrcode.setCreator(admin.getUserid());
					String imagePath = createQrImage(qrcode, request);
					if (imagePath != null && imagePath.length() > 5) {
						qrcode.setQrPath(imagePath);
						qrcodeService.save(qrcode);
						result.setMessage("保存成功");
						result.setCode(Code.CODE_SUCCESS);
					} else {
						result.setMessage("生产图片失败");
						result.setCode("4002");
					}
				} else {
					result.setMessage("此标识已存在");
					result.setCode("4001");
				}
			} else {
				qrcode.setCompanyId(admin.getCompanyNo());
				qrcode.setCreator(admin.getUserid());
				qrcode.setSceneType(1);
				String imagePath = createQrImage(qrcode, request);
				if (imagePath != null && imagePath.length() > 5) {
					qrcode.setQrPath(imagePath);
					qrcodeService.save(qrcode);
					result.setMessage("保存成功");
					result.setCode(Code.CODE_SUCCESS);
				} else {
					result.setMessage("生产图片失败");
					result.setCode("4002");
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("保存失败，请联系管理员！");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 生产二维码图片
	 * 
	 * @param qrcode
	 * @return
	 * @throws Exception
	 */
	private String createQrImage(Qrcode qrcode, HttpServletRequest request) throws Exception {
		String imagePath = null;

		if ("1".equals(qrcode.getQrType())) {// 公众号
			String aid = qrcode.getAccountid();
			int action_type = qrcode.getSceneType();
			int expire_seconds = 2592000;
			int scene_id = Integer.parseInt(qrcode.getQrNo());
			String ticket = WxMpUtil.getInstance().createQrcode(aid, action_type, expire_seconds, scene_id);
			if (ticket != null) {
				imagePath = QrcodeUtil.createFwQrcode(request, ticket);
			}
		} else {// 链接
			imagePath = QrcodeUtil.createUrlQrcode(request, qrcode.getQrUrl());
		}
		return imagePath;
	}

	/**
	 * 更改二维码管理
	 */
	@RequestMapping("/inner/qrcode/update")
	public void updateQrcode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Qrcode qrcode = getModel(Qrcode.class);
			Qrcode ori = qrcodeService.findById(qrcode.getId());
			if (ori == null) {
				result.setMessage("此记录已删除!");
				result.setCode(Code.CODE_FAIL);
			} else {
				qrcodeService.update(qrcode);
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
	 * 删除二维码管理
	 */
	@RequestMapping("/inner/qrcode/delete")
	public void deleteQrcodeById(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			Qrcode qrcode = getModel(Qrcode.class);
			qrcodeService.delete(qrcode.getId());
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
	 * 查询全部二维码管理
	 */
	@RequestMapping("/inner/qrcode/findAllQrcode")
	public void findAllQrcode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			List<Qrcode> qrcodeList = qrcodeService.findAll();
			result.getData().put("qrcodeList", qrcodeList);
			result.setMessage("findAll qrcode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("findAll qrcode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * 删除多个二维码管理
	 */
	@RequestMapping("/inner/qrcode/deleteIds")
	public void deleteQrcode(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String[] ids = id.split(",");
			List<String> idList = new ArrayList<String>();
			for (int i = 0; i < ids.length; i++) {
				idList.add(ids[i]);
			}
			if (idList.size() > 0) {
				qrcodeService.deleteBatch(idList);
				result.setMessage("删除成功!");
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setMessage("删除失败，请联系管理员!");
				result.setCode(Code.CODE_FAIL);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("delete qrcode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

	/**
	 * jqGrid多种条件查询
	 */
	@RequestMapping("/inner/qrcode/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		PaginationResult result = new PaginationResult();
		try {
			SysUser admin = ManageUtil.getCurrentUserInfo(request);
			int page_number = Integer.parseInt(request.getParameter("page_number"));
			int page_size = Integer.parseInt(request.getParameter("page_size"));
			String keyword = request.getParameter("keyword");
			if (keyword == null) {
				keyword = "";
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("keyword", keyword);
			param.put("companyId", admin.getCompanyNo());
			PojoDomain<Qrcode> list = qrcodeService.list(page_number, page_size, param);
			result.getData().put("list", list.getPojolist());
			result.setPageNumber(list.getPage_number());
			result.setPageSize(list.getPage_size());
			result.setPageTotal(list.getPage_total());
			result.setTotalCount(list.getTotal_count());
			result.setMessage("find qrcode successs!");
			result.setCode(Code.CODE_SUCCESS);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("find qrcode fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}

}