package com.marks.common.util.qrImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.marks.common.util.IDUtil;
import com.marks.module.system.upload.util.FTPUtil;
import com.marks.module.system.upload.util.UploadUtil;

/**
 * 
 * 创建二维码
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容
 *
 */
public class QrcodeUtil {
	private static Logger logger = Logger.getLogger(QrcodeUtil.class);

	/**
	 * 对url生成二维码，并写入流中。
	 * 
	 * @param url
	 * @param stream
	 */
	public static void encodeToStream(String url, OutputStream stream, int width, int height) {
		Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			MatrixToImageWriter.writeToStream(matrix, "png", stream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * lhyan3 2015年8月4日下午4:28:45 TODO 生成二维码并上传到ftp
	 * 
	 * @param url
	 *            链接
	 * @param width
	 *            宽度
	 * @param height
	 *            告诉
	 * @param name
	 *            图片名字
	 */
	public static String createUrlQrcode(HttpServletRequest request, String url) {
		int width = 4000;
		int height = 4000;
		String name = "QR" + IDUtil.getTimeID() + ".png";
		Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix matrix = null;
		String path = null;
		try {
			matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
			File qrcodeFile = new File(UploadUtil.getUploadPath(request) + name);
			MatrixToImageWriter.writeToFile(matrix, "png", qrcodeFile);
			if (FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
					FTPUtil.ftpFileDirectory, name, qrcodeFile, "")) {
				// 上传成功
				path = FTPUtil.ftp_url + qrcodeFile.getName();
			}
			qrcodeFile.deleteOnExit();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return path;
	}

	/**
	 * 生产微信服务号二维码
	 * 
	 * @param request
	 * @param ticket
	 * @return
	 */
	public static String createFwQrcode(HttpServletRequest request, String ticket) {
		String filename = "WQR" + IDUtil.getTimeID() + ".jpg";
		try {
			OutputStream out = null;
			InputStream is = null;
			HttpURLConnection connection = null;
			String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
			String tickets = URLEncoder.encode(ticket, "utf-8");
			requestUrl = requestUrl.replace("TICKET", tickets);
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setUseCaches(true);
			connection.connect();
			is = connection.getInputStream();
			String commPath = UploadUtil.getUploadPath(request);
			File saveFile = new File(commPath + filename);

			out = new FileOutputStream(saveFile, true);
			int size = 0;
			byte[] buf = new byte[1024 * 1024 * 10];
			while ((size = is.read(buf)) != -1) {
				out.write(buf, 0, size);
				out.flush();
				Thread.sleep(160);
			}
			is.close();
			out.close();
			connection.disconnect();
			FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
					FTPUtil.ftpFileDirectory, filename, saveFile, "");
			return FTPUtil.ftp_url + filename;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 生产条形码
	 * 
	 * @return
	 * @throws Exception 
	 */
	public static String createBarCode(HttpServletRequest request, String code) throws Exception {

		String commPath = UploadUtil.getUploadPath(request);
		String fileName = code + ".jpg";
		String path = commPath + fileName;
		File file=new File(path);
		FileOutputStream out = new FileOutputStream(file);
//		JBarCodeUtils.generateBarCode128(code, "0.8", "30", out);
		CreateBarCodeUtils.generateFile(code, path);
		FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password,
				FTPUtil.ftpFileDirectory, fileName, new File(path), "");
		return FTPUtil.ftp_url + fileName;
	}
	/*
	 * public static String createBarCode2(HttpServletRequest request,String
	 * code){
	 * 
	 * String commPath = UploadUtil.getUploadPath(request); String
	 * fileName=code+".png"; String path=commPath+fileName;
	 * CreateBarCodeUtils.generateFile(code, path);
	 * FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name,
	 * FTPUtil.password, FTPUtil.ftpFileDirectory, fileName, new File(path),
	 * ""); return FTPUtil.ftp_url+fileName; }
	 */
}
