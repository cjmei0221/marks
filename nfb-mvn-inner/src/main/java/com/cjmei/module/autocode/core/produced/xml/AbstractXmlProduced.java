package com.cjmei.module.autocode.core.produced.xml;

import com.cjmei.module.autocode.core.produced.AbstractProduced;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.util.FileUtil;
import com.cjmei.module.autocode.core.produced.util.StringUtil;

public abstract class AbstractXmlProduced extends AbstractProduced implements XmlProduced{

	/**
	 * 获取beanName名字
	 */
	public String producedBeanName(AutoBean autoBean) {
		setFileSrc(autoBean);
		String beanName = StringUtil.getUpperCaseChar(autoBean.getFactBeanName());
		outFileContent.setFileName(StringUtil.StringJoin(beanName,getFileNameAfter(),DOT_VALUE,DEFAULT_FILE_XML) );
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
		String packageUrl =  StringUtil.StringJoin( autoBean.getDefaultPackageUrl(),
				autoBean.getFactBeanName(),DOT_VALUE,autoBean.getDefaultDao(),DOT_VALUE,"mybatis."); 
		setFileSrc( FileUtil.getResourceSrc()+packageUrl+ getFileSrc(autoBean));
	}
	
	public abstract String getFileSrc(AutoBean autoBean);
}
