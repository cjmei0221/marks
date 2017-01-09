package com.cjmei.module.autocode.core.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.autocode.core.produced.ModuleProduced;
import com.cjmei.module.autocode.core.produced.backstagecode.CodeProduced;
import com.cjmei.module.autocode.core.produced.config.AutoConfig;
import com.cjmei.module.autocode.core.produced.factory.DefaultExternAutoBeanFactory;
import com.cjmei.module.autocode.core.produced.fileformat.DefaultTemplateFileFormat;
import com.cjmei.module.autocode.core.produced.fileformat.TemplateFileFormat;
import com.cjmei.module.autocode.core.produced.introduction.introduction.IntroductionPageProduced;
import com.cjmei.module.autocode.core.produced.pojo.AttrType;
import com.cjmei.module.autocode.core.produced.pojo.AutoAttr;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.pojo.OutFileContent;
import com.cjmei.module.autocode.core.produced.pojo.OutPutFileResult;
import com.cjmei.module.autocode.core.produced.template.input.DefaultTemplateRead;
import com.cjmei.module.autocode.core.produced.template.output.DefaultTemplateOutPut;
import com.cjmei.module.autocode.core.produced.template.output.TemplateOutPut;
import com.cjmei.module.autocode.core.produced.util.StringUtil;

public class Test {

	private static AutoBean getAutoBean() {
		AutoBean autoBean = new AutoBean();
		autoBean.setBeanName("asdfaf");
		autoBean.setModuleDesc("asdfaf");
		autoBean.setTableName("asdfaf");
		autoBean.setParentPackage("aaa");
		autoBean.setDescription("asdfaf");
		// 包路径
		// autoBean.setDefaultPackageUrl("cluster.scheme.module.rbac.");
		List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
		AutoAttr attr = null;

		for (int i=0;i<3;i++) {
			attr = new AutoAttr();
			attr.setAttrDesc("sdfadsf"+i);
			attr.setAttrName("sdfadsf"+i);
			attr.setAttrSize(i);
			attr.setAttrType(AttrType.getAttrTypeByString("Date"));
			attr.setPK(false);
			attr.setSeq("");
			attr.setNote("");
			autoAttrs.add(attr);
		}

		autoBean.setAutoAttrs(autoAttrs);
		return autoBean;
	}

	public static void main(String[] args) {
		/*
		 * ExternAutoCode autoCode = new
		 * DefaultExternAutoBeanFactory().externAutoCodeBean(); OutPutFileResult
		 * outFileResult = autoCode.autoProducedCode(getAutoBean(), true);
		 * 
		 * System.out.println(outFileResult.getResultInfo()); DBProduced dbutil
		 * = new MySqlTableProduced(); dbutil.createTable(getAutoBean());
		 */
		/*
		 * ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext(
		 * "classpath:config/spring/applicationContext.xml");
		 * DatabaseHelper.init(context);
		 * AutoCodeFactory.getInstance().autoCodeByEntity(true, TestCode.class);
		 */

		Test test=new Test();
		test.createOneFile(getAutoBean(),new IntroductionPageProduced());
	}
	
	public void createOneFile(AutoBean autoBean,ModuleProduced moduleProduced){
		String className = IntroductionPageProduced.class.getSimpleName();
		String templateName = StringUtil.getLowerCaseChar(className);
		String resourceUrl = StringUtil.StringJoin(AutoConfig.template_path, CodeProduced.BACK_SLANT, templateName,
				CodeProduced.DOT_VALUE, AutoConfig.template_end);
		String path = Test.class.getResource("").getPath();
		path = path.substring(0, path.indexOf("/com"));
		resourceUrl = path + "/" + resourceUrl;
		System.out.println("test resourceUrl:" + resourceUrl);
		String filePath = resourceUrl;
		File file = new File(filePath);
		DefaultExternAutoBeanFactory autoCode = new DefaultExternAutoBeanFactory();
		TemplateFileFormat templateFileFormat = autoCode.getTemplateFileFormat();
		templateFileFormat = templateFileFormat == null ? new DefaultTemplateFileFormat() : templateFileFormat;
		StringBuffer sBuffer = new DefaultTemplateRead().readTemplate(file);
		templateFileFormat.setModuleProduced(moduleProduced);
		// System.out.println("filePath>"+filePath);
/*		System.out.println(sBuffer);*/
		OutFileContent outFileContent = templateFileFormat.fileContextFormat(sBuffer,autoBean );
		TemplateOutPut templateOutPut = new DefaultTemplateOutPut();
		List<OutFileContent> outFileContents = new ArrayList<OutFileContent>();
		outFileContents.add(outFileContent);
		OutPutFileResult outPutFileResult = templateOutPut.outPutFiles(outFileContents, true);
	}

}
