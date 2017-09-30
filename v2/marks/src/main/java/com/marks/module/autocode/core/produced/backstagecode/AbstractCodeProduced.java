package com.marks.module.autocode.core.produced.backstagecode;

import com.marks.module.autocode.core.produced.AbstractProduced;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.util.FileUtil;
import com.marks.module.autocode.core.produced.util.StringUtil;

/**
 * 基本方法实现类
 * @author ykai5
 *
 */
public abstract class AbstractCodeProduced 
				extends AbstractProduced implements CodeProduced{

	/**
	 * 获取泛型名字
	 */
	public String producedT(AutoBean autoBean) {
		
		return StringUtil.getUpperCaseChar( producedBeanName(autoBean) );
	}

	/**
	 * 获取beanName名字
	 */
	public String producedBeanName(AutoBean autoBean) {
		//TODO 注入方式
		setFileSrc( autoBean);
		String beanName = StringUtil.getUpperCaseChar(autoBean.getFactBeanName());
		outFileContent.setFileName(StringUtil.StringJoin(beanName,getFileNameAfter(),DOT_VALUE,DEFAULT_FILE_JAVA) );
		return beanName;
	}
	
	/**
	 * 把路径set到outFileContent
	 * @param outFileContent
	 * @param sBuffer：包名（需处理成路径方式）
	 */
	public void setFileSrc(String fileSrc){
		outFileContent.setFileSrc(fileSrc.replace(DOT_VALUE, BACK_SLANT));
	}
	
	public void setFileSrc(AutoBean autoBean){
		setFileSrc(FileUtil.getJavaRootSrc() + getFileSrc(autoBean));
	}
	
	public abstract String getFileSrc(AutoBean autoBean);
	
	public abstract String producedPackageUrl(AutoBean autoBean);
	
}
