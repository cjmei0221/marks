package com.marks.module.inner.autocode.core.produced.extern;

import com.marks.module.inner.autocode.core.produced.ModuleProduced;
import com.marks.module.inner.autocode.core.produced.pojo.AutoBean;
import com.marks.module.inner.autocode.core.produced.pojo.OutPutFileResult;

/**
 * 外部调用接口
 * @author ykai5
 */
public interface ExternAutoCode {

    //String AUTOCODE_PACKAGE = "cluster.scheme.autocode"; 
	
	/**
	 * 暴露给外部生成代码的接口,
	 * @param autoBean 生成代码的属性集合
	 * @param isCoverFile 是否覆盖原文件,true为直接覆盖原文件，风险较大，不建议使用
	 */
	public OutPutFileResult autoProducedCode(AutoBean autoBean,boolean isCoverFile);
	
	/**
	 *重载方法
	 */
	public OutPutFileResult autoProducedCode(AutoBean autoBean);

	public OutPutFileResult autoProducedCode(AutoBean autoBean, ModuleProduced moduleProduced, boolean b);
	
}
