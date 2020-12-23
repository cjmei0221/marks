package com.marks.smart.system.autocode.core.produced.fileformat;

import com.marks.smart.system.autocode.core.produced.ModuleProduced;
import com.marks.smart.system.autocode.core.produced.pojo.AutoBean;
import com.marks.smart.system.autocode.core.produced.pojo.OutFileContent;

/**
 * 文件内容格式化
 * @author ykai5
 *
 */
public interface TemplateFileFormat {

	String FILEBEGINCODE = "@{";
	String FILEENDCODE = "}";
	String DEFAULT_PACKAGE_URL = "module.";
	
	//；
	String SEMI_VALUE = ";";
	//.
	String DOT_VALUE = ".";
	
	//约定方法前缀	
	String METHOD_PRE = "produced";  
	
	/**
	 * 文件内容格式化
	 * @param sBuffer
	 * @param fileCode
	 * @param autoBean
	 * @return
	 */
	public OutFileContent fileContextFormat(StringBuffer sBuffer,AutoBean autoBean);
	
//	/**
//	 * 文件特征值获取
//	 * @param sBuffer
//	 * @return 文件特征值${param}解析成param队列
//	 */
//	public Set<String> getFileFeatureCode(StringBuffer sBuffer);
	public void setModuleProduced(ModuleProduced moduleProduced);
	
}
