package com.marks.smart.system.autocode.core.backup.xml_spring;

import com.marks.smart.system.autocode.core.produced.AbstractProduced;
import com.marks.smart.system.autocode.core.produced.config.AutoConfig;
import com.marks.smart.system.autocode.core.produced.pojo.AutoBean;
import com.marks.smart.system.autocode.core.produced.util.StringUtil;
import com.marks.smart.system.autocode.core.produced.xml.XmlProduced;

public abstract class AbstractSpringXmlProduced extends AbstractProduced implements XmlProduced{

	/**
	 * 获取beanName名字
	 */
	public String producedBeanName(AutoBean autoBean) {
		setFileSrc(autoBean);
		String beanName = StringUtil.getUpperCaseChar(autoBean.getFactBeanName());
		outFileContent.setFileName(StringUtil.StringJoin(AutoConfig.SPRING_NAME+"-"+autoBean.getParentPackage()+"_"+beanName.toLowerCase(),getFileNameAfter(),DOT_VALUE,DEFAULT_FILE_XML) );
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
		setFileSrc(AutoConfig.getInstance().getRootPath() + AutoConfig.FILE_SPRING_SRC);
	}
	
	public abstract String getFileSrc(AutoBean autoBean);
}
