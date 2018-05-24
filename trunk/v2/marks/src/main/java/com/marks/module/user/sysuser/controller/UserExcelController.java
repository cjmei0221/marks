package com.marks.module.user.sysuser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.excel.ExcelUtil;
import com.marks.common.util.excel.ImportExcelUtil;
import com.marks.module.system.upload.util.UploadUtil;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserExcel;
import com.marks.module.user.sysuser.thread.UserThread;

@Controller
public class UserExcelController {
	private static Logger logger = Logger.getLogger(UserExcelController.class);

	/**
	 * 导出模版
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/sysuser/exportModelForVip")
	public void exportModel(HttpServletRequest request, HttpServletResponse response) {
		OutputStream os = null;
		try {

			response.setContentType("application/ms-excel");
			try {
				response.setHeader("Content-Disposition", "attachment;filename="
						+ URLEncoder.encode("vipInfo_" + IDUtil.getSecondID() + ".xls", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			os = response.getOutputStream();
			Map<String, Object> beanParams = new HashMap<String, Object>(); // 数据集
			String mobanPath = UploadUtil.getRootPath(request) + "inner/page/target/employeeset/model/employeeInfo.xls";
			ExcelUtil.exportExcelByTemplate(os, beanParams, mobanPath);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * 导入
	 * 
	 * @param file
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/sysuser/excelImportForVip")
	public void excelImportForVip(@RequestParam(value = "file_upload", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			String fileName = file.getOriginalFilename();
			InputStream in = file.getInputStream();
			Workbook wb = ImportExcelUtil.chooseWorkbook(fileName, in);
			// 定义excel行数标记
			int flag = 1;
			List<SysUserExcel> infoList = ImportExcelUtil.readDateListT(wb, new SysUserExcel(), 2, 0);
			StringBuffer msg = new StringBuffer();
			boolean saveFlag = true;
			for (SysUserExcel vo : infoList) {
				logger.info("excelImportForVip>" + vo.getMobile());
				vo.setCompanyId(admin.getCompanyId());
				flag++;
				if (null == vo.getMobile() || "".equals(vo.getMobile())) {
					msg.append(";  第【" + flag + "】行手机号为空");
					saveFlag = false;
					continue;
				}
				if (null == vo.getUsername() || "".equals(vo.getUsername())) {
					msg.append(";  第【" + flag + "】行姓名为空");
					saveFlag = false;
					continue;
				}
			}
			if (!saveFlag) {
				// 导入文件有误
				result.setCode("4011");
				result.setMessage(msg.toString().substring(1));
				JsonUtil.output(response, result);
				return;
			}
			if (infoList.size() > 0) {
				int size = 200;
				if (infoList.size() > size) {

					int endLen = infoList.size() / size;
					if (infoList.size() % size > 0) {
						endLen = endLen + 1;
					}
					for (int i = 0; i < endLen; i++) {
						List<SysUserExcel> saveList = null;
						if (i == endLen - 1) {
							saveList = infoList.subList(i * size, infoList.size());
						} else {
							saveList = infoList.subList(i * size, (i + 1) * size);
						}
						new Thread(new UserThread(saveList)).start();
					}
				} else {
					new Thread(new UserThread(infoList)).start();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setMessage("import fail!");
			result.setCode(Code.CODE_FAIL);
		}
		JsonUtil.output(response, result);
	}
}
