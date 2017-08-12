package com.marks.module.inner.autocode.core.produced.extern;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.marks.module.inner.autocode.core.produced.ModuleProduced;
import com.marks.module.inner.autocode.core.produced.backstagecode.CodeProduced;
import com.marks.module.inner.autocode.core.produced.config.AutoConfig;
import com.marks.module.inner.autocode.core.produced.factory.DefaultExternAutoBeanFactory;
import com.marks.module.inner.autocode.core.produced.fileformat.DefaultTemplateFileFormat;
import com.marks.module.inner.autocode.core.produced.fileformat.TemplateFileFormat;
import com.marks.module.inner.autocode.core.produced.introduction.introduction.IntroductionPageProduced;
import com.marks.module.inner.autocode.core.produced.pojo.AutoBean;
import com.marks.module.inner.autocode.core.produced.pojo.OutFileContent;
import com.marks.module.inner.autocode.core.produced.pojo.OutPutFileResult;
import com.marks.module.inner.autocode.core.produced.template.input.DefaultTemplateRead;
import com.marks.module.inner.autocode.core.produced.template.input.TemplateInput;
import com.marks.module.inner.autocode.core.produced.template.output.DefaultTemplateOutPut;
import com.marks.module.inner.autocode.core.produced.template.output.TemplateOutPut;
import com.marks.module.inner.autocode.core.produced.util.ReflectUtil;
import com.marks.module.inner.autocode.core.produced.util.StringUtil;
import com.marks.module.inner.autocode.core.test.Test;

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

	public DefaultExternAutoCode() {

	}

	public DefaultExternAutoCode(TemplateFileFormat templateFileFormat, TemplateInput templateInput,
			TemplateOutPut templateOutPut) {
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

	// String filePath =
	// this.getClass().getClassLoader().getResource("template/daoInterfaceProduced.template").getPath();
	// File file = new File(filePath);
	// StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
	// OutFileContent outFileContent = new
	// DefaultTemplateFileFormat(codeProduced).fileContextFormat(sBuffer,
	// autoBean);
	// new DefaultTemplateOutPut().outPutFiles(outFileContent);
	// System.out.println(outFileContent);

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectUtil reflectUtil = ReflectUtil.class.newInstance();
		System.out.println(reflectUtil);
	}

	public OutPutFileResult autoProducedCode(AutoBean autoBean, boolean isCoverFile) {

		List<Class<?>> classes = ReflectUtil.getClasssFromPackage(AutoConfig.AUTOCODE_CONFIG_PACKAGE);
		System.out.println();
		for (Class<?> c : classes) {
			baseClassToOutFile(c, autoBean);
		}
		OutPutFileResult outPutFileResult = templateOutPut.outPutFiles(outFileContents, isCoverFile);
		return outPutFileResult;
	}

	public OutPutFileResult autoProducedCode(AutoBean autoBean) {
		return autoProducedCode(autoBean, false);
	}

	/**
	 * 生成文件内容
	 * 
	 * @param c
	 * @param autoBean
	 */
	public void baseClassToOutFile(Class<?> c, AutoBean autoBean) {
		// 类型为ModuleProduced

		ModuleProduced moduleProduced = null;
		try {
			// c.isAnonymousClass()，过滤内部类
			if (ReflectUtil.isFactClass(c) && !c.isEnum() && !c.isAnonymousClass()) {

				if (c.newInstance() instanceof ModuleProduced) {
					moduleProduced = (ModuleProduced) c.newInstance();
					String className = c.getSimpleName();
					String templateName = StringUtil.getLowerCaseChar(className);
					String resourceUrl = StringUtil.StringJoin(AutoConfig.template_path, CodeProduced.BACK_SLANT,
							templateName, CodeProduced.DOT_VALUE, AutoConfig.template_end);
	/*				 System.out.println("baseClassToOutFile resourceUrl>"+resourceUrl);*/
					String filePath = this.getClass().getClassLoader().getResource(resourceUrl).getPath();
					File file = new File(filePath);
					StringBuffer sBuffer = new DefaultTemplateRead().readTemplate(file);
					templateFileFormat.setModuleProduced(moduleProduced);
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

	@Override
	public OutPutFileResult autoProducedCode(AutoBean autoBean, ModuleProduced moduleProduced, boolean b) {
		String className = IntroductionPageProduced.class.getSimpleName();
		String templateName = StringUtil.getLowerCaseChar(className);
		String resourceUrl = StringUtil.StringJoin(AutoConfig.template_path, CodeProduced.BACK_SLANT, templateName,
				CodeProduced.DOT_VALUE, AutoConfig.template_end);
		String filePath = this.getClass().getClassLoader().getResource(resourceUrl).getPath();
		File file = new File(filePath);
		DefaultExternAutoBeanFactory autoCode = new DefaultExternAutoBeanFactory();
		TemplateFileFormat templateFileFormat = autoCode.getTemplateFileFormat();
		templateFileFormat = templateFileFormat == null ? new DefaultTemplateFileFormat() : templateFileFormat;
		StringBuffer sBuffer = new DefaultTemplateRead().readTemplate(file);
		templateFileFormat.setModuleProduced(moduleProduced);
		OutFileContent outFileContent = templateFileFormat.fileContextFormat(sBuffer, autoBean);
		TemplateOutPut templateOutPut = new DefaultTemplateOutPut();
		List<OutFileContent> outFileContents = new ArrayList<OutFileContent>();
		outFileContents.add(outFileContent);
		OutPutFileResult outPutFileResult = templateOutPut.outPutFiles(outFileContents, true);
		return outPutFileResult;
	}

}
