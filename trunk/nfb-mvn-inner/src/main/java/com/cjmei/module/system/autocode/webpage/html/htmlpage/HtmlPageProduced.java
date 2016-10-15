/**
 * File Name: cluster.scheme.autocode.webpage.html.htmlpage.HtmlPageProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年6月6日下午4:30:56
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.system.autocode.webpage.html.htmlpage;

import java.util.List;

import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.util.StringUtil;
import com.cjmei.module.system.autocode.webpage.html.AbstractHtmlProduced;

/**
 * File Name:
 * cluster.scheme.autocode.webpage.html.htmlpage.HtmlPageProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月6日下午4:30:56
 * @see (optional)
 * @Copyright (c) 2016, 广电运通信息科技有限公司 All Rights Reserved.
 */
public class HtmlPageProduced extends AbstractHtmlProduced {

	/**
	 * 
	 * @see cluster.scheme.autocode.AbstractProduced#getFileNameAfter()
	 */
	public String getFileNameAfter() {
		return "";
	}

	public String getFileSrc(AutoBean autoBean) {
		String cssRoot = autoBean.getFactBeanName().toLowerCase();
		System.out.println("HtmlPageProduced getFileSrc >"+autoBean);
		return cssRoot;
	}

	/**
	 * 获取css路径
	 */
	public String producedGetCssRoot(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append(DEFAULT_CSS).append(BACK_SLANT).append(StringUtil.getLowerCaseChar(autoBean.getFactBeanName()));
		sBuffer.append(DOT_VALUE).append(DEFAULT_CSS);

		return sBuffer.toString();
	}

	/**
	 * 获取js路径
	 */
	public String producedGetJsRoot(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append(DEFAULT_JS).append(BACK_SLANT).append(StringUtil.getLowerCaseChar(autoBean.getFactBeanName()))
				.append(DOT_VALUE).append(DEFAULT_JS);

		return sBuffer.toString();
	}

	// caption
	public String producedGetCaption(AutoBean autoBean) {
		return autoBean.getModuleDesc();
	}

	/**
	 * 表格生成
	 * 
	 * @param args
	 * @author lffei1
	 */
	public String producedGetInputField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		/*
		 * List<AutoAttr> attrs = autoBean.getAutoAttrs(); for (int i = 0; i <
		 * attrs.size(); i++) { String attrName = attrs.get(i).getAttrName();
		 * String desc = attrs.get(i).getAttrDesc();
		 * 
		 * String str = "<tr><th>" + desc + "</th><td><input id=\""+attrName+
		 * "\" name=\""+attrName+"\" class=\"easyui-validatebox\"></td></tr>";
		 * sBuffer.append(str); }
		 */
		return sBuffer.toString();
	}

	// space
	public String producedSetSpace() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4);
		return sBuffer.toString();
	}
}
