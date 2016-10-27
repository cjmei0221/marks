package com.cjmei.module.system.upload.controller;

import java.io.File;
import java.util.ArrayList;
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

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.properties.Config;
import com.cjmei.module.system.upload.util.FTPUtil;
import com.cjmei.module.system.upload.util.UploadUtil;

/**
 * 上传图片
 * 
 * @author lhyan3 2015年3月1日下午4:14:14
 */
@Controller
public class ImageUploadController {

	private static final int UPLOAD_SUCCSSS = 0; // "上传文件成功！",

	private static final Logger LOG = Logger.getLogger(ImageUploadController.class);

	/**
	 * TODO 上传图片 lhyan3 2015年3月1日下午3:27:07
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upload/image")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		String commPath = UploadUtil.getUploadPath(request);
		try {
			response.setContentType("text/html; charset=UTF-8");

			// 图片类型
			String uploadType = request.getParameter("uploadType");
			if (uploadType != null) {
				uploadType = "";
			}
			result.getData().put("uploadType", uploadType);

			// 上传操作
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List items = upload.parseRequest(request);
			if (null != items) {
				List<File> files = new ArrayList<File>();
				for (int i = 0; i < items.size(); i++) {
					FileItem item = (FileItem) items.get(i);
					if (item.isFormField()) {
						continue;
					} else {
						String hzname = item.getName().substring(item.getName().lastIndexOf("."),
								item.getName().length());
						String picName = IDUtil.getUUID() + hzname;
						File saveFile = new File(commPath + picName);
						files.add(saveFile);
						item.write(saveFile);
						result.getData().put("status", UPLOAD_SUCCSSS);

						result.getData().put("name", item.getName());
						result.getData().put("realname", picName);

						result.getData().put("message", FTPUtil.ftp_url + picName);
						FTPUtil.uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
								FTPUtil.ftpFileDirectory, picName, saveFile, "");
						JsonUtil.output(response, result);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			;
		}
	}

}
