package com.cjmei.module.system.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.upload.util.FTPUtil;
import com.cjmei.module.system.upload.util.UploadUtil;

import sun.misc.BASE64Decoder;

/**
 * 上传图片。
 */
@Controller
public class FileUploadController {
	private static final Logger LOG = Logger.getLogger(ImageUploadController.class);
	private static final long serialVersionUID = 1L;

	@RequestMapping("/fileUpload/image")
	public void upload(HttpServletRequest req, HttpServletResponse resp) {
		Result result = new Result();
		result.setCode(0);
		try {
			String image = req.getParameter("image");

			// 只允许jpg

			String header = "data:image/jpeg;base64,";
			String header2 = "data:image/png;base64,";
			
			String fileType="";
			
			boolean isSupport=false;
			
			if(image.indexOf(header)>=0){
				isSupport=true;
				fileType=".jpg";
				// 去掉头部
				image = image.substring(header.length());
			}
			
			if(image.indexOf(header2)>=0){
				isSupport=true;
				fileType=".png";
				// 去掉头部
				image = image.substring(header.length()-1);
			}
			
			if (!isSupport) {

				result.setCode(1);
				result.setMessage("只支持jpg,png图片");
				JsonUtil.output(resp, result);
				return;

			}

			

			

			// 写入磁盘

			boolean success = false;

			BASE64Decoder decoder = new BASE64Decoder();

			try {

				byte[] decodedBytes = decoder.decodeBuffer(image);
				String commPath = UploadUtil.getUploadPath(req);
				String picName = IDUtil.getUUID() + fileType;
				//String imgFilePath = "D://uploadimage";
				File saveFile = new File(commPath + picName);
				FileOutputStream out = new FileOutputStream(saveFile);

				out.write(decodedBytes);

				out.close();

				success = true;
				result.getData().put("fileUrl", FTPUtil.ftp_url + picName);
				FTPUtil.uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
						FTPUtil.ftpFileDirectory, picName, saveFile, "");

			} catch (Exception e) {

				success = false;

				LOG.error(e.getMessage(),e);
				result.setCode(-1);
				result.setMessage("系统错误");

			}

		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			result.setCode(-1);
			result.setMessage("系统错误");
		}
		
		JsonUtil.output(resp, result);
	}

}