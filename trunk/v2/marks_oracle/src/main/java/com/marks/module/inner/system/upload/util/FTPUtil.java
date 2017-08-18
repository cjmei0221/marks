package com.marks.module.inner.system.upload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.marks.common.util.properties.Config;


/**
 * FTP工具类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class FTPUtil {
	private FTPClient ftp=new FTPClient();
	private final static Logger Log=Logger.getLogger(FTPUtil.class);
	
	public static String ip =Config.ftp_ip;
	public static String login_name = Config.ftp_login_name;
	public static String password = Config.ftp_password;
	public static String ftpFileDirectory = Config.ftp_FileDirectory;
	public static String ftp_url = Config.ftp_url;
	private static FTPUtil util=null;
	private FTPUtil(){}
	public static FTPUtil getInstance(){
		if(util==null){
			util=new FTPUtil();
		}
		return util;
	}
	 /**
     * 断开与远程服务器的连接
     * @throws IOException
     */
    public void disconnect() throws IOException{
        if(ftp.isConnected()){
        	ftp.disconnect();
        }
    }
    /**
     * 连接到FTP服务器
     * @param hostname 主机名
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return 是否连接成功
     * @throws IOException
     */
    public boolean connect(String hostname,int port,String username,String password) throws IOException{
    	ftp.connect(hostname, port);
    	ftp.setControlEncoding("utf-8");
        if(FTPReply.isPositiveCompletion(ftp.getReplyCode())){
            if(ftp.login(username, password)){
                return true;
            }
        }
        Log.info("连接ftp （"+ip+"） 服务器失败");
        disconnect();
        return false;
    }
     
	public boolean uploadFTPImageInput(String ip,String login_name,String password,String ftpFileDirectory,String ftpFileNames,File files, String jid){
		/*try {
			if(!connect(ip, 21, login_name, password)){
				return false;
			}
			ftp.enterLocalActiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
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
		}*/
		return true;
	}
	

	
	public static void main(String[] args) {
		String ftpFileNames ="a.jpg";
		File saveFile = new File("D:\\aa.jpg");
		FTPUtil.getInstance().uploadFTPImageInput(FTPUtil.ip, FTPUtil.login_name, FTPUtil.password, 
				FTPUtil.ftpFileDirectory,ftpFileNames,saveFile,"");
	}
}
