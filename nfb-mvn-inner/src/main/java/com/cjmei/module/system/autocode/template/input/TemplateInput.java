package com.cjmei.module.system.autocode.template.input;

import java.io.File;

import com.cjmei.module.system.autocode.template.TemplateStream;

/**
 * 文件读入
 * @author ykai5
 *
 */
public interface TemplateInput extends TemplateStream{

	public StringBuffer readTemplate(File templateFile);
	
}
