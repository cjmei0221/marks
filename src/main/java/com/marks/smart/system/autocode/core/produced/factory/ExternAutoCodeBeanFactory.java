package com.marks.smart.system.autocode.core.produced.factory;

import com.marks.smart.system.autocode.core.produced.extern.ExternAutoCode;

/**
 * 生成自动代码生产工厂类
 * @author ykai5
 *
 */
public interface ExternAutoCodeBeanFactory {

	/**
	 * 获取externAutoCode方案
	 * @return
	 */
	public ExternAutoCode externAutoCodeBean();
	
	
}
