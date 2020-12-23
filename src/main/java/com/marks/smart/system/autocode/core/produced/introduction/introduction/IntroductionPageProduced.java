/**
 * File Name: cluster.scheme.autocode.webpage.html.htmlpage.HtmlPageProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年6月6日下午4:30:56
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.marks.smart.system.autocode.core.produced.introduction.introduction;

import java.util.List;

import com.marks.smart.system.autocode.core.produced.introduction.AbstractIntroHtmlProduced;
import com.marks.smart.system.autocode.core.produced.pojo.AutoAttr;
import com.marks.smart.system.autocode.core.produced.pojo.AutoBean;

/**
 * File Name:
 * cluster.scheme.autocode.webpage.html.htmlpage.HtmlPageProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月6日下午4:30:56
 * @see (optional)
 * @Copyright (c) 2016, 广电运通信息科技有限公司 All Rights Reserved.
 */
public class IntroductionPageProduced extends AbstractIntroHtmlProduced {

	/**
	 * 
	 * @see cluster.scheme.autocode.AbstractProduced#getFileNameAfter()
	 */
	@Override
	public String getFileNameAfter() {
		return "";
	}

	/**
	 * root
	 */
	@Override
	public String getFileSrc(AutoBean autoBean) {
		return autoBean.getFactBeanName().toLowerCase();
	}
	
	public String producedGetTableField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			AutoAttr autoAttr = autoAttrs.get(i);
			sBuffer.append("<tr>");
			sBuffer.append("<td>" + (i + 1) + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrName().toUpperCase() + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrDesc() + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrType().getOracleType() + "</td>");
			sBuffer.append("<td>" + (autoAttr.getNote()==null?"无":autoAttr.getNote()) + "</td>");
			sBuffer.append("</tr>");
		}
		return sBuffer.toString();
	}

	public String producedGetEntityField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			AutoAttr autoAttr = autoAttrs.get(i);
			sBuffer.append("<tr>");
			sBuffer.append("<td>" + (i + 1) + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrName() + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrDesc() + "</td>");
			sBuffer.append("<td>" + autoAttr.getAttrType().getJavaType() + "</td>");
			sBuffer.append("<td>" + (autoAttr.getNote()==null?"无":autoAttr.getNote()) + "</td>");
			sBuffer.append("</tr>");
		}
		return sBuffer.toString();
	}

	public String producedGetControllerField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		String beanName = autoBean.getBeanName();
		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 1 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/find" + beanName + "ById" + "</td>");
		sBuffer.append("<td>" + "find" + beanName + "ById" + "</td>");
		sBuffer.append("<td>查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 2 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/save" + "</td>");
		sBuffer.append("<td>" + "save" + beanName + "</td>");
		sBuffer.append("<td>保存" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 3 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/update" + "</td>");
		sBuffer.append("<td>" + "update" + beanName + "</td>");
		sBuffer.append("<td>更新" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 4 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/delete" + "</td>");
		sBuffer.append("<td>" + "delete" + beanName + "ById</td>");
		sBuffer.append("<td>删除" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 5 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/findAll" + autoBean.getBeanName() + "</td>");
		sBuffer.append("<td>" + "findAll" + beanName + "</td>");
		sBuffer.append("<td>查询全部" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 6 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/deleteIds" + "</td>");
		sBuffer.append("<td>" + "delete" + beanName + "</td>");
		sBuffer.append("<td>删除多个" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 7 + "</td>");
		sBuffer.append("<td>" + "/" + autoBean.getFactBeanName() + "/list" + "</td>");
		sBuffer.append("<td>" + "list" + "</td>");
		sBuffer.append("<td>列表查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		return sBuffer.toString();
	}
	
	public String producedGetServiceField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 1 + "</td>");
		sBuffer.append("<td>" + "findById" + "</td>");
		sBuffer.append("<td>查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 2 + "</td>");
		sBuffer.append("<td>" + "save" + "</td>");
		sBuffer.append("<td>保存" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 3 + "</td>");
		sBuffer.append("<td>" + "update" + "</td>");
		sBuffer.append("<td>更新" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 4 + "</td>");
		sBuffer.append("<td>" + "delete" + "ById</td>");
		sBuffer.append("<td>删除" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 5 + "</td>");
		sBuffer.append("<td>" + "findAll"  + "</td>");
		sBuffer.append("<td>查询全部" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 6 + "</td>");
		sBuffer.append("<td>" + "deleteBatch" + "</td>");
		sBuffer.append("<td>删除多个" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 7 + "</td>");
		sBuffer.append("<td>" + "list" + "</td>");
		sBuffer.append("<td>列表查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		return sBuffer.toString();
	}
	
	public String producedGetDaoField(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 1 + "</td>");
		sBuffer.append("<td>" + "findById" + "</td>");
		sBuffer.append("<td>查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 2 + "</td>");
		sBuffer.append("<td>" + "save" + "</td>");
		sBuffer.append("<td>保存" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 3 + "</td>");
		sBuffer.append("<td>" + "update" + "</td>");
		sBuffer.append("<td>更新" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 4 + "</td>");
		sBuffer.append("<td>" + "delete" + "ById</td>");
		sBuffer.append("<td>删除" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 5 + "</td>");
		sBuffer.append("<td>" + "findAll"  + "</td>");
		sBuffer.append("<td>查询全部" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 6 + "</td>");
		sBuffer.append("<td>" + "deleteBatch" + "</td>");
		sBuffer.append("<td>删除多个" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		sBuffer.append("<tr>");
		sBuffer.append("<td>" + 7 + "</td>");
		sBuffer.append("<td>" + "list" + "</td>");
		sBuffer.append("<td>列表查询" + autoBean.getModuleDesc() + "</td>");
		sBuffer.append("</tr>");

		return sBuffer.toString();
	}
	/**
	 * 设置数据库表名
	 * 
	 * @param autoBean
	 * @return String
	 * @author lffei1
	 */
	public String producedTableName(AutoBean autoBean) {
		String tableName = autoBean.getFactTableName();
		return tableName;
	}
	
	//表标题
    public String producedGetCaption(AutoBean autoBean){
        return autoBean.getModuleDesc();
    }
    
  //表标题
    public String producedGetDesc(AutoBean autoBean){
        return autoBean.getDescription();
    }
}
