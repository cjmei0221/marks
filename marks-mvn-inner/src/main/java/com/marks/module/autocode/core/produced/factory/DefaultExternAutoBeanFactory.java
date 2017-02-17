package com.cjmei.module.autocode.core.produced.factory;

import com.cjmei.module.autocode.core.produced.extern.DefaultExternAutoCode;
import com.cjmei.module.autocode.core.produced.extern.ExternAutoCode;
import com.cjmei.module.autocode.core.produced.fileformat.DefaultTemplateFileFormat;
import com.cjmei.module.autocode.core.produced.fileformat.TemplateFileFormat;
import com.cjmei.module.autocode.core.produced.template.input.DefaultTemplateRead;
import com.cjmei.module.autocode.core.produced.template.input.TemplateInput;
import com.cjmei.module.autocode.core.produced.template.output.DefaultTemplateOutPut;
import com.cjmei.module.autocode.core.produced.template.output.TemplateOutPut;

/**
 * 默认的生成方案
 * @author ykai5
 *
 */
public class DefaultExternAutoBeanFactory implements ExternAutoCodeBeanFactory{
	
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
	
	/**
	 * 获取externAutoCode方案
	 * @return
	 */
	public ExternAutoCode externAutoCodeBean(){
		templateFileFormat = templateFileFormat==null?new DefaultTemplateFileFormat():templateFileFormat;
		templateInput = templateInput==null?new DefaultTemplateRead():templateInput; 
		templateOutPut = templateOutPut==null?new DefaultTemplateOutPut():templateOutPut;
		ExternAutoCode autoCode = new DefaultExternAutoCode(templateFileFormat, templateInput, templateOutPut);
		return autoCode;
	}
	
}
