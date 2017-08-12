package com.marks.module.inner.system.upload.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.system.myimage.pojo.MyImage;
import com.marks.module.inner.system.myimage.service.MyImageService;
import com.marks.module.inner.system.upload.util.FTPUtil;
import com.marks.module.inner.system.upload.util.UploadUtil;
import com.marks.module.inner.user.login.helper.SysUserHelper;
import com.marks.module.inner.user.sysuser.pojo.SysUser;

import sun.misc.BASE64Decoder;

/**
 * 上传图片。
 */
@Controller
public class ImageUploadController {
	private static final Logger LOG = Logger.getLogger(ImageUploadController.class);
	private static final long serialVersionUID = 1L;
	@Autowired
    private MyImageService  myImageService;
   
	@RequestMapping("/inner/fileUpload/image")
	public void upload(HttpServletRequest req, HttpServletResponse resp) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
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

				result.setCode("1");
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
				String id="U"+IDUtil.getTimeID();
				String picName = id+ fileType;
				//String imgFilePath = "D://uploadimage";
				File saveFile = new File(commPath + picName);
				FileOutputStream out = new FileOutputStream(saveFile);

				out.write(decodedBytes);

				out.close();

				success = true;
				result.getData().put("imgId", id);
				result.getData().put("fileUrl", picName);
				FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
						FTPUtil.ftpFileDirectory, picName, saveFile, "");
				SysUser admin = SysUserHelper.getCurrentUserInfo(req);
				MyImage img=new MyImage();
				img.setPicId(id);
				img.setCreator(admin.getUserid());
				img.setPicName(picName);
				img.setPicUrl(FTPUtil.ftp_url + picName);
				myImageService.save(img);
			} catch (Exception e) {

				success = false;

				LOG.error(e.getMessage(),e);
				result.setCode(Code.CODE_FAIL);
				result.setMessage("系统错误");

			}

		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统错误");
		}
		
		JsonUtil.output(resp, result);
	}

}