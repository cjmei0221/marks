package com.cjmei.module.autocode.core.produced.fileformat;

import java.util.Iterator;
import java.util.Set;

import com.cjmei.module.autocode.core.produced.ModuleProduced;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.pojo.OutFileContent;
import com.cjmei.module.autocode.core.produced.util.ReflectUtil;
import com.cjmei.module.autocode.core.produced.util.StringUtil;

/**
 * 文件内容格式化
 * @author ykai5
 *
 */
public class DefaultTemplateFileFormat implements TemplateFileFormat{

	//TODO 通过默认方式 及 spring配置方式扩展，
	private ModuleProduced moduleProduced ;
	
	public ModuleProduced getModuleProduced() {
		return moduleProduced;
	}
	public void setModuleProduced(ModuleProduced moduleProduced) {
		this.moduleProduced = moduleProduced;
	}
	public DefaultTemplateFileFormat(){
		
	}
	public DefaultTemplateFileFormat(ModuleProduced moduleProduced){
		this.moduleProduced = moduleProduced;
	}
	
	//约定方法前缀	
	private final static String METHOD_PRE = "produced";  
	
	//转换文件内容，生成文件信息
	public OutFileContent fileContextFormat(StringBuffer sBuffer
			 ,AutoBean autoBean) {
		Set<String> fileCodes = StringUtil.getFileFeatureCode(sBuffer);
		//TODO 通过manage管理类，降低耦合
		Iterator<String> iter = fileCodes.iterator();
		OutFileContent outFileContent = moduleProduced.getOutFileContent();
		while(iter.hasNext()){
			String iterValue = iter.next();
			String methodName = METHOD_PRE+ StringUtil.getUpperCaseChar( iterValue);
			//System.out.println("fileContextFormat target >"+methodName+" autoBean>"+autoBean.getBeanName());
			String target = ReflectUtil.reflectMethod(moduleProduced, methodName, autoBean);
			String resource = FILEBEGINCODE+iterValue+FILEENDCODE;
			String result = StringUtil.replaceAll(sBuffer, resource, target==null?"":target);
			sBuffer = new StringBuffer(result);
		}
		outFileContent.setFileContext(sBuffer);
		return outFileContent;
	}
	
	
}
