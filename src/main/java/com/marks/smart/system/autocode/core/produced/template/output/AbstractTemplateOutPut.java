package com.marks.smart.system.autocode.core.produced.template.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.marks.smart.system.autocode.core.produced.pojo.OutFileContent;
import com.marks.smart.system.autocode.core.produced.pojo.OutPutFileResult;
import com.marks.smart.system.autocode.core.produced.util.FileUtil;
import com.marks.smart.system.autocode.core.produced.util.StringUtil;

/**
 * 输出文件抽象类
 * @author ykai5
 *
 */
public abstract class AbstractTemplateOutPut implements TemplateOutPut{
		
	 
	private static final Logger logger = Logger.getLogger(AbstractTemplateOutPut.class);

	private FileWriter fw;
	
	 /**
	  * 判断输出文件是否合法,包括权限与是否有重复文件
	  * @param outFileContents
	  * @param isCoverFile 是否覆盖文件
	  * @return
	  */
	 abstract OutPutFileResult isOutPutLegal( List<OutFileContent> outFileContents,
			 boolean isCoverFile);
	 
	 /**
	  * 根据文件与文件内容输出文件
	  * @param outFileContents
	  * @return
	  */
	 public OutPutFileResult outPutFiles( List<OutFileContent> outFileContents,boolean isCoverFile ){
		
		 OutPutFileResult outPutFileResult = isOutPutLegal(outFileContents,isCoverFile);
		 //校验是否创建文件
		 if(!outPutFileResult.isSusscess()){
			 return outPutFileResult;
		 }
		 outPutFileResult.setSusscess(true);
		 //判断是否存在该目录，不存在则创建目录
		 FileUtil.createFolder(outFileContents);
		 for(OutFileContent outFileContent:outFileContents){
			 	String filePath = StringUtil.StringJoin(outFileContent.getFileSrc(),
			 			BACK_SLANT,outFileContent.getFileName());
			 	System.out.println("filePath:>"+filePath);
		    	File f = new File(filePath);
		    	try {
					fw = new FileWriter(f);
					fw.write(outFileContent.getFileContext().toString());
					fw.flush();
					fw.close();
				} catch (IOException e) {
					outPutFileResult.setSusscess(false);
					outPutFileResult.setResultInfo("写入文件失败！");
				}
		 }
		 
		 return outPutFileResult;
	 }
	 
	 //outPutFiles 重载
	 public OutPutFileResult outPutFiles( OutFileContent outFileContent,boolean isCoverFile ){
		 List<OutFileContent> outFileContents = new ArrayList<OutFileContent>();
		 outFileContents.add(outFileContent);
		 return outPutFiles(outFileContents, isCoverFile);
	 }
	 //outPutFiles 重载
	 public OutPutFileResult outPutFiles( OutFileContent outFileContent ){
		 List<OutFileContent> outFileContents = new ArrayList<OutFileContent>();
		 outFileContents.add(outFileContent);
		 return outPutFiles(outFileContents, false);
	 }
	 
	 
	 
}
