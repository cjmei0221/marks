package com.cjmei.module.system.autocode.util;

import java.io.File;
import java.util.List;

import com.cjmei.module.system.autocode.config.AutoConfig;
import com.cjmei.module.system.autocode.pojo.OutFileContent;

public class FileUtil {

	private static final String JAVA_SRC =  AutoConfig.FILE_JAVA_SRC;
	private static final String XML_SRC =  AutoConfig.FILE_XML_SRC;
	
	private static final String WEB_SRC = AutoConfig.FILE_WEB_SRC;
	/**
	 * 获取项目路径
	 * 
	 * @return
	 */
	public static String getFileRootSrc() {
	//	return System.getProperty("user.dir");
	   String root =  AutoConfig.rootPath;
	   return root;
	}
	
	//TODO路径获取方案待解决
	public static String getJavaRootSrc(){
		return (getFileRootSrc() + JAVA_SRC);
	}
	
	public static String getResourceSrc(){
		return (getFileRootSrc() + XML_SRC );
	}
	
	public static String getWebAppSrc(){
	    return (getFileRootSrc() + WEB_SRC );
	}
	

	/**
	 * 判断文件是否存在，文件存在则返回false
	 * 
	 * @param folderName
	 *            ：目录路径
	 * @param fileName
	 *            ：文件路径
	 * @return
	 */
	public static boolean isExistFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断目录是否存在，若不存在则创建该文件目录
	 * 
	 * @param outFileContent
	 * @return
	 */
	public static void createFolder(List<OutFileContent> outFileContents) {

		for (OutFileContent outFileContent : outFileContents) {
			String fileEndSrc = outFileContent.getFileSrc();
			if(null !=fileEndSrc && !"".equals(fileEndSrc)){
				createFolder(fileEndSrc);
			}
		}
	}
	
	public static void createFolder(String fileEndSrc){
		
//		String javaRootSrc = getJavaRootSrc();
		StringBuffer sBuffer = new StringBuffer();
//		sBuffer.append(javaRootSrc);
		String[] paths = fileEndSrc.split("\\\\|[/]");
		// 逐级判断文件夹目录是否存在
		for (int i = 0; i < paths.length; i++) {
			sBuffer.append("/").append(paths[i]).append("/");
			File file = new File(sBuffer.toString());
			if (!file.exists()) {
				file.mkdir();
			}
		}
	}
}
