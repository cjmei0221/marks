package com.marks.smart.system.autocode.core.produced.template.output;

import java.util.List;

import com.marks.smart.system.autocode.core.produced.pojo.OutFileContent;
import com.marks.smart.system.autocode.core.produced.pojo.OutPutFileResult;

/**
 * 输出文件
 * @author ykai5
 *
 */
public interface TemplateOutPut {

	String  BACK_SLANT = "/";
	
	 /**
	  * 根据文件与文件内容输出文件
	  * @param outFileContents
	  * @return
	  */
	OutPutFileResult outPutFiles( List<OutFileContent> outFileContents,boolean isCoverFile  );
}
