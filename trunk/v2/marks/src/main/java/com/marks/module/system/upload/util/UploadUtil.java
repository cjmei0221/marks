package com.marks.module.system.upload.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class UploadUtil {
	
	/**
	 * 获取临时上传文件路径
	 * lhyan3
	 * 2015年7月13日下午3:32:51
	 * TODO
	 * @param request
	 * @return
	 */
	public static String getUploadPath(HttpServletRequest request){
		String uploadFile = request.getSession().getServletContext().getRealPath("/") + "upload_file" + File.separator;
		if ("N".equals(FTPUtil.ftp_flag)) {
			uploadFile = request.getSession().getServletContext().getRealPath("/") + "upload_file" + File.separator;
		}
		File file = new File(uploadFile);
		if(!file.exists()){
			file.mkdir();
		}
		return uploadFile;
	}

	public static String getRootPath(HttpServletRequest request) {
		String uploadFile = request.getSession().getServletContext().getRealPath("/");
		File file = new File(uploadFile);
		if (!file.exists()) {
			file.mkdir();
		}
		return uploadFile;
	}

}
