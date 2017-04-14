package com.marks.module.inner.system.upload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.excel.ExcelUtil;
import com.marks.module.inner.system.upload.util.UploadUtil;

@Controller
public class ExcelFileUploadController {
	private static final Logger logger = Logger.getLogger(ImageUploadController.class);

	@RequestMapping("/inner/fileUpload/excel")
	public void excel(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		try {
			// 也可以用request获取上传文件
			// MultipartFile fileFile = request.getFile("file"); //这里是页面的name属性
			// 转换成输入流

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List items = upload.parseRequest(request);
			String commPath = UploadUtil.getUploadPath(request);

			File saveFile = null;
			if (null != items) {
				List<File> files = new ArrayList<File>();
				for (int i = 0; i < items.size(); i++) {
					FileItem item = (FileItem) items.get(i);
					if (item.isFormField()) {
						continue;
					} else {
						String fileName = "EXCEL" + IDUtil.getTimeID();
						String hzname = item.getName().substring(item.getName().lastIndexOf("."),
								item.getName().length());
						fileName = fileName + hzname;
						result.getData().put("realName", item.getName());
						saveFile = new File(commPath + fileName);
						files.add(saveFile);
						// 开始在 服务器中 写文件
						item.write(saveFile);
						result.getData().put("fileName", fileName);
						logger.info("文件上传ftp完成");
					}
				}
			}

		} catch (Exception e) {
			logger.error("excel", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("上传失败");
		}
		JsonUtil.output(response, result);
	}

	private static byte[] readUrlStream(BufferedInputStream bufferedInputStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		int byteNum = 1024;
		byte[] buff = new byte[byteNum]; // buff用于存放循环读取的临时数据
		int rc = 0;
		while ((rc = bufferedInputStream.read(buff, 0, byteNum)) > 0) {
			swapStream.write(buff, 0, rc);
		}

		return swapStream.toByteArray();
	}

	@RequestMapping("/inner/fileUpload/excelTemplate")
	public void excelTemplate(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		try {
			String fileName = request.getParameter("fileName");
			String path = UploadUtil.getTemplatePath(request) + fileName;
			downLoadFile(path, response, fileName, "xls");
			return;
		} catch (Exception e) {
			logger.error("excel", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("下载失败");
		}
		JsonUtil.output(response, result);
	}

	public boolean downLoadFile(String filePath, HttpServletResponse response, String fileName, String fileType)
			throws Exception {
		File file = new File(filePath); // 根据文件路径获得File文件
		// 设置文件类型(这样设置就不止是下Excel文件了，一举多得)
		if ("pdf".equals(fileType)) {
			response.setContentType("application/pdf;charset=GBK");
		} else if ("xls".equals(fileType)) {
			response.setContentType("application/msexcel;charset=GBK");
		} else if ("doc".equals(fileType)) {
			response.setContentType("application/msword;charset=GBK");
		}
		// 文件名
		response.setHeader("Content-Disposition",
				"attachment;filename=\"" + new String(fileName.getBytes(), "ISO8859-1") + "\"");
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n = -1;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			// 异常自己捕捉
		} finally {
			// 关闭流，不可少
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
		return false;
	}
}
