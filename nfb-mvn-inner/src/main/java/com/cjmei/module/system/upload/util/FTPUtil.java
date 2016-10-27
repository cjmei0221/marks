package com.cjmei.module.system.upload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import com.cjmei.common.util.properties.Config;


/**
 * FTP工具类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class FTPUtil {
	private final static Logger Log=Logger.getLogger(FTPUtil.class);
	
	public static String ip =Config.ftp_ip;
	public static String login_name = Config.ftp_login_name;
	public static String password = Config.ftp_password;
	public static String ftpFileDirectory = Config.ftp_FileDirectory;
	public static String ftp_url = Config.ftp_url;

	public static boolean uploadFTPImageInput(String ip,String login_name,String password,String ftpFileDirectory,String ftpFileNames,File files, String jid){
		FTPClient ftp=new FTPClient();
		try {
			ftp.connect(ip);
			if(login_name !=null && login_name.length()>3){
				ftp.login(login_name, password);
			}
			ftp.enterLocalActiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlEncoding("utf-8");
			ftp.changeWorkingDirectory(ftpFileDirectory);
			if(!ftp.changeWorkingDirectory(jid)){
				ftp.makeDirectory(jid);
				ftp.changeWorkingDirectory(jid);
			}
			ftp.storeFile(ftpFileNames, new FileInputStream(files));
			return true;
		} catch (Exception e) {
			Log.error("Exception",e);
			return false;
		} finally{
			if(ftp.isConnected()){
				try {
					ftp.disconnect();
				} catch (IOException e) {
					Log.error("IOException",e);
				}
			}
		}
	}
	

	
	public static void main(String[] args) {
		String ftpFileNames ="a.jpg";
		File saveFile = new File("D:\\aa.jpg");
		uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password, 
				FTPUtil.ftpFileDirectory,ftpFileNames,saveFile,"");
	}
}
