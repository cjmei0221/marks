package com.marks.module.system.upload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.system.myimage.pojo.MyImage;
import com.marks.module.system.myimage.service.MyImageService;
import com.marks.module.system.upload.util.FTPUtil;
import com.marks.module.system.upload.util.UploadUtil;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 上传图片。
 */
@Controller
public class ImageUploadController {
	private static final Logger LOG = Logger.getLogger(ImageUploadController.class);
	private static final long serialVersionUID = 1L;
	@Autowired
	private MyImageService myImageService;
	
	@RequestMapping("/inner/fileUpload/img")
	public void upload2(@RequestParam(value = "file_upload", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		InputStream ins = null;
		FileOutputStream fos = null;
		try {
			String id = "I_" + IDUtil.getDateID() + "_" + IDUtil.getRandom(100, 999) + IDUtil.getRandom(100, 999);
			String ImagePath = UploadUtil.getUploadPath(request);
			LOG.info("upload2 >" + file);
			LOG.info("upload2 >" + file.getOriginalFilename());
			String[] s = file.getOriginalFilename().split("\\.");
			String picName = id + "." + s[s.length - 1];
			File targetfile = new File(ImagePath, picName);
			ins = file.getInputStream();
			fos = new FileOutputStream(targetfile);

			byte b[] = new byte[1024];
			int temp = 0;

			while ((temp = ins.read(b)) != -1) {
				fos.write(b, 0, temp);
			}

			fos.flush();

			result.getData().put("imgId", id);
			result.getData().put("fileUrl", picName);
			FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
					FTPUtil.ftpFileDirectory, picName, targetfile, "");
			SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
			MyImage img = new MyImage();
			img.setPicId(id);
			img.setCreator(admin.getOperator());
			img.setPicName(picName);
			img.setPicUrl(FTPUtil.ftp_url + picName);
			img.setCompanyId(admin.getCompanyId());
			myImageService.save(img);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统错误");
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {

			}
		}

		JsonUtil.output(response, result);
	}

}