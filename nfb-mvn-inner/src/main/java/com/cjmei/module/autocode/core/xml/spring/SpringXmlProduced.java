package com.cjmei.module.autocode.core.xml.spring;

import com.cjmei.module.autocode.core.pojo.AutoBean;
import com.cjmei.module.autocode.core.util.StringUtil;
import com.cjmei.module.autocode.core.xml.AbstractSpringXmlProduced;

public class SpringXmlProduced extends AbstractSpringXmlProduced {

	public String getFileSrc(AutoBean autoBean) {
		return "";
	}

	public String producedServiceImplPackageUrl(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName().toLowerCase()).append(DOT_VALUE)
				.append(autoBean.getDefaultService()).append(DOT_VALUE).append(autoBean.getDefaultImpl());
		// TODO 改为代理注入方案
		// setFileSrc(outFileContent, sBuffer.toString());
		return sBuffer.toString();
	}

	// Dao 路径
	public String producedDaoInterfacePackageUrl(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName().toLowerCase()).append(DOT_VALUE)
				.append(autoBean.getDefaultDao());
		return sBuffer.toString();
	}

	public String producedGetBeanObject(AutoBean autoBean) {
		String beanObject = StringUtil.getLowerCaseChar(autoBean.getFactBeanName());
		return beanObject;
	}

	@Override
	public String getFileNameAfter() {
		return "";
	}

}
