package com.cjmei.module.system.autocode.template.output;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.system.autocode.backstagecode.CodeProduced;
import com.cjmei.module.system.autocode.backstagecode.dao.DaoInterfaceProduced;
import com.cjmei.module.system.autocode.backstagecode.pojo.PojoProduced;
import com.cjmei.module.system.autocode.fileformat.DefaultTemplateFileFormat;
import com.cjmei.module.system.autocode.pojo.AttrType;
import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.pojo.OutFileContent;
import com.cjmei.module.system.autocode.pojo.OutPutFileResult;
import com.cjmei.module.system.autocode.template.input.DefaultTemplateRead;
import com.cjmei.module.system.autocode.util.FileUtil;
import com.cjmei.module.system.autocode.util.StringUtil;
/**
 * 
 * @author ykai5
 *
 */
public class DefaultTemplateOutPut extends AbstractTemplateOutPut {

	 //判断文件是否合法,不合法则不创建
	 OutPutFileResult isOutPutLegal(List<OutFileContent> outFileContents,
			boolean isCoverFile) {
		OutPutFileResult outPutFileResult = new OutPutFileResult();
		outPutFileResult.setSusscess(true);
		String javaRootSrc = FileUtil.getJavaRootSrc();
		for(OutFileContent outFileContent:outFileContents){
			//文件夹路径
			String folderName = outFileContent.getFileSrc();
			//文件路径
			String fileName =StringUtil.StringJoin(folderName,BACK_SLANT,outFileContent.getFileName());
			if(FileUtil.isExistFile(fileName)){
				if(!isCoverFile){
					outPutFileResult.setSusscess(false);
					outPutFileResult.setResultInfo(fileName+"已经存在！");
				}else{
					outPutFileResult.setResultInfo(outPutFileResult.getResultInfo()+fileName+"被覆盖。");
				}
				
			}
		}
		return outPutFileResult;
	}

	public static void main(String[] args) {
		AutoBean autoBean = new AutoBean();
		autoBean.setTableName("goodInfo");
		List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
		AutoAttr autoAttr = new AutoAttr();
		AutoAttr autoAttr1 = new AutoAttr();
		autoAttr.setAttrName("gooodId");
		autoAttr.setAttrType(AttrType.Integer);
		autoAttr1.setAttrName("gooodName");
		autoAttr1.setAttrType(AttrType.String);
		autoAttrs.add(autoAttr);
		autoAttrs.add(autoAttr1);
		autoBean.setAutoAttrs(autoAttrs);
		
		
		
	}
	
	public  void testDaoInterface(AutoBean autoBean,CodeProduced codeProduced){
		String filePath =  this.getClass().getClassLoader().getResource("template/daoInterfaceProduced.template").getPath();
//		File file = new File("D:\\workspace\\clusterScheme\\src\\main\\resources\\local\\template\\daoInterfaceProduced.template");
		File file = new File(filePath);
		StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
		OutFileContent outFileContent = new DefaultTemplateFileFormat(codeProduced).fileContextFormat(sBuffer, autoBean);
		new DefaultTemplateOutPut().outPutFiles(outFileContent);
		System.out.println(outFileContent);
	}
	
	public  void testDaoImpl(AutoBean autoBean,CodeProduced codeProduced){
		String filePath =  this.getClass().getClassLoader().getResource("template/daoImplProduced.template").getPath();
		File file = new File(filePath);
		StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
		OutFileContent outFileContent = new DefaultTemplateFileFormat(codeProduced).fileContextFormat(sBuffer, autoBean);
		new DefaultTemplateOutPut().outPutFiles(outFileContent);
		System.out.println(outFileContent);
	}
	
	public  void testPojo(AutoBean autoBean,CodeProduced codeProduced){
		String filePath =  this.getClass().getClassLoader().getResource("template/pojoProduced.template").getPath();
		File file = new File(filePath);
		StringBuffer sBuffer =new DefaultTemplateRead().readTemplate(file);
		OutFileContent outFileContent = new DefaultTemplateFileFormat(codeProduced).fileContextFormat(sBuffer, autoBean);
		new DefaultTemplateOutPut().outPutFiles(outFileContent);
		System.out.println(outFileContent);
	}
	
}
