package com.cjmei.module.system.autocode;

import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.pojo.OutFileContent;
import com.cjmei.module.system.autocode.util.StringUtil;

public abstract class AbstractProduced implements ModuleProduced {

	protected OutFileContent outFileContent = new OutFileContent();
	
	
	public OutFileContent getOutFileContent() {
		return outFileContent;
	}

	//文件后缀
	private String fileNameAfter;
	
	public abstract String  getFileNameAfter();

	/**
	 * 获取实体bean的包路径
	 */
	public String producedBeanPackageUrl(AutoBean autoBean) {
		return StringUtil.StringJoin(autoBean.getDefaultPackageUrl(),autoBean.getFactBeanName(),DOT_VALUE,autoBean.getDefaultPojo());
	}
	
//	public abstract String producedPackageUrl(AutoBean autoBean);
	
}
