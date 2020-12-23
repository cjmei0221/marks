package com.marks.smart.system.autocode.core.produced.util;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import com.marks.smart.system.autocode.core.produced.fileformat.TemplateFileFormat;

public class StringUtil {

	public static boolean isNull(String arg){
		if(arg!=null&&!"".equals(arg))
			return false;
		return true;
	}
	
	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String getUpperCaseChar(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String getLowerCaseChar(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}

	
	public static void main(String[] args) {
		System.out.println( MessageFormat.format("{error} abc", "error","abcd") );
	}
	
	/**
	 * 获取文件特征值
	 */
	public static Set<String> getFileFeatureCode(StringBuffer sBuffer) {
		String flag = sBuffer.toString();
		Set<String> fileCodes = new HashSet<String>();
		while( flag.indexOf(TemplateFileFormat.FILEBEGINCODE)>-1 ){
			flag = flag.substring( flag.indexOf(TemplateFileFormat.FILEBEGINCODE)+TemplateFileFormat.FILEBEGINCODE.length() );
			int end = flag.indexOf(TemplateFileFormat.FILEENDCODE);
			String fileCode = flag.substring(0,end) ;
			fileCodes.add(fileCode);
		}
		return fileCodes;
	}
	
	/**
	 * 
	 * @param sBuffer 替换数据
	 * @param resource 被替换数据
	 * @param target    替换值
	 * @return
	 */
	public static String replaceAll(StringBuffer sBuffer,String resource,String target){
		String result = sBuffer.toString();
		result = result.replace(resource, target);
		return result;
	}
	
	
	public static String StringJoin(String...keys){
		StringBuffer sBuffer = new StringBuffer();
		for(String key:keys){
			sBuffer.append(key);
		}
		return sBuffer.toString();
	}

}
