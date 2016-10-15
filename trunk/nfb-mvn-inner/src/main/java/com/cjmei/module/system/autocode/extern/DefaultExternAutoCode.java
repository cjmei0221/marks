package com.cjmei.module.system.autocode.extern;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.system.autocode.ModuleProduced;
import com.cjmei.module.system.autocode.backstagecode.CodeProduced;
import com.cjmei.module.system.autocode.config.AutoConfig;
import com.cjmei.module.system.autocode.fileformat.TemplateFileFormat;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.pojo.OutFileContent;
import com.cjmei.module.system.autocode.pojo.OutPutFileResult;
import com.cjmei.module.system.autocode.template.input.DefaultTemplateRead;
import com.cjmei.module.system.autocode.template.input.TemplateInput;
import com.cjmei.module.system.autocode.template.output.TemplateOutPut;
import com.cjmei.module.system.autocode.util.ReflectUtil;
import com.cjmei.module.system.autocode.util.StringUtil;

public class DefaultExternAutoCode implements ExternAutoCode {
	
	List<OutFileContent> outFileContents = new ArrayList<OutFileContent>();
	
	/**
	 * 格式化内容
	 */
	private TemplateFileFormat templateFileFormat;
	
	/**
	 * 输入内容
	 */
	private TemplateInput templateInput;
	
	/**
	 * 输出内容
	 */
	private TemplateOutPut templateOutPut;
	
	public DefaultExternAutoCode(){
		
	}
	
	public DefaultExternAutoCode(TemplateFileFormat templateFileFormat,
			TemplateInput templateInput,TemplateOutPut templateOutPut){
		this.templateFileFormat = templateFileFormat;
		this.templateInput = templateInput;
		this.templateOutPut = templateOutPut;
	}
	
	public TemplateOutPut getTemplateOutPut() {
		return templateOutPut;
	}

	public void setTemplateOutPut(TemplateOutPut templateOutPut) {
		this.templateOutPut = templateOutPut;
	}

	public TemplateInput getTemplateInput() {
		return templateInput;
	}

	public void setTemplateInput(TemplateInput templateInput) {
		this.templateInput = templateInput;
	}

	public TemplateFileFormat getTemplateFileFormat() {
		return templateFileFormat;
	}

	public void setTemplateFileFormat(TemplateFileFormat templateFileFormat) {
		this.templateFileFormat = templateFileFormat;
	}

//	String filePath =  this.getClass().getClassLoader().getResource("template/daoInterfaceProduced.template").getPath();
//	File file = new File(filePath);
//	StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
//	OutFileContent outFileContent = new DefaultTemplateFileFormat(codeProduced).fileContextFormat(sBuffer, autoBean);
//	new DefaultTemplateOutPut().outPutFiles(outFileContent);
//	System.out.println(outFileContent);
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectUtil reflectUtil = ReflectUtil.class.newInstance();
		System.out.println(reflectUtil);
	}
	
	public OutPutFileResult autoProducedCode(AutoBean autoBean,boolean isCoverFile) {
		
		List<Class<?>> classes = ReflectUtil.getClasssFromPackage(AutoConfig.AUTOCODE_CONFIG_PACKAGE);
		System.out.println();
		for(Class<?> c : classes){
			baseClassToOutFile(c,autoBean);
	    }
		OutPutFileResult outPutFileResult = templateOutPut.outPutFiles(outFileContents, isCoverFile);
		return outPutFileResult;
	}
	
	public OutPutFileResult autoProducedCode(AutoBean autoBean) {
		return autoProducedCode(autoBean, false);
	}
	
	/**
	 * 生成文件内容
	 * @param c
	 * @param autoBean
	 */
	public void baseClassToOutFile(Class<?> c,AutoBean autoBean){
		//类型为ModuleProduced
		
		ModuleProduced moduleProduced = null;
		try {
			//c.isAnonymousClass()，过滤内部类
			if(ReflectUtil.isFactClass(c)&&!c.isEnum()&&!c.isAnonymousClass()){
			
				if(c.newInstance() instanceof ModuleProduced){
					moduleProduced =  (ModuleProduced) c.newInstance();
					String className = c.getSimpleName();
					String templateName = StringUtil.getLowerCaseChar(className);
					String resourceUrl = StringUtil.StringJoin(AutoConfig.template_path,CodeProduced.BACK_SLANT,
							templateName,CodeProduced.DOT_VALUE,AutoConfig.template_end);
//					System.out.println("baseClassToOutFile resourceUrl>"+resourceUrl);
					String filePath =  this.getClass().getClassLoader().getResource(resourceUrl).getPath();
					File file = new File(filePath);
					StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
					templateFileFormat.setModuleProduced(moduleProduced);
//					System.out.println("filePath>"+filePath);
					OutFileContent outFileContent = templateFileFormat.fileContextFormat(sBuffer, autoBean);
					outFileContents.add(outFileContent);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
