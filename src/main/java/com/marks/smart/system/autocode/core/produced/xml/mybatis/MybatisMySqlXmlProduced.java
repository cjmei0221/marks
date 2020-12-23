/**
 * File Name: cluster.scheme.autocode.xml.mybatis.MybatisMySqlXmlProduced.java
 * 类简述
 * @author:lffei1@grgbanking.com
 * @Date:2016年7月12日下午3:46:11
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.marks.smart.system.autocode.core.produced.xml.mybatis;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.marks.smart.system.autocode.core.produced.config.AutoConfig;
import com.marks.smart.system.autocode.core.produced.pojo.AttrType;
import com.marks.smart.system.autocode.core.produced.pojo.AutoAttr;
import com.marks.smart.system.autocode.core.produced.pojo.AutoBean;
import com.marks.smart.system.autocode.core.produced.util.StringUtil;
import com.marks.smart.system.autocode.core.produced.xml.AbstractXmlProduced;

/**
 * File Name: cluster.scheme.autocode.xml.mybatis.MybatisMySqlXmlProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年7月12日下午3:46:11
 * @see (optional)
 * @Copyright (c) 2016, 广电运通信息科技有限公司 All Rights Reserved.
 */
public class MybatisMySqlXmlProduced extends AbstractXmlProduced {

	/**
	 * 
	 * @see cluster.scheme.autocode.xml.AbstractXmlProduced#getFileSrc(cluster.scheme.autocode.pojo.AutoBean)
	 */
	@Override
	public String getFileSrc(AutoBean autoBean) {
		String mysqlSrc = StringUtil.StringJoin(MYSQL_PACKAGE, DOT_VALUE, autoBean.getParentPackage());
		return mysqlSrc;
	}

	/**
	 * 
	 * @see cluster.scheme.autocode.AbstractProduced#getFileNameAfter()
	 */
	@Override
	public String getFileNameAfter() {
		String result = StringUtil.StringJoin(StringUtil.getUpperCaseChar(DEFAULT_DAO),
				StringUtil.getUpperCaseChar(DEFAULT_MAPPER));
		return result;
	}

	/**
	 * namespace
	 */
	public String producedNameSpaceUrl(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(DOT_VALUE).append(autoBean.getDefaultPojo());
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

	/**
	 * 设置表别名
	 * 
	 * @param autoBean
	 * @return String
	 * @author lffei1
	 */
	public String producedTableOtherName(AutoBean autoBean) {
		return autoBean.getFactBeanName().toLowerCase();
	}

	/**
	 * 获取主键值
	 * 
	 * @param autoBean
	 * @return String
	 */
	public String producedPKAttrValue(AutoBean autoBean) {
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (AutoAttr attr : autoAttrs) {
			if (attr.isPK()) {
				return String.valueOf(attr.getAttrName());

			}
		}
		return "";
	}

	/**
	 * 获取主键名
	 * 
	 * @param autoBean
	 * @return String
	 */
	public String producedPKAttrName(AutoBean autoBean) {

		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (AutoAttr attr : autoAttrs) {
			if (attr.isPK()) {
				return String.valueOf((attr.getAttrName().toUpperCase()));
			}
		}
		return BANK_VALUE_0;
	}

	/**
	 * 获取属性名
	 * 
	 * @param autoBean
	 * @return string
	 */
	public String producedGetAttrName(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4);
			sBuffer.append(autoAttrs.get(i).getAttrName().toUpperCase());
			if (i != autoAttrs.size() - 1) {
				sBuffer.append(COMMA_VALUE).append(ENTER_VALUE);
			}
		}
		return sBuffer.toString();
	}

	/**
	 * 主键生成策略
	 * 
	 * @param autoBean
	 * @return
	 */
	public String producedMysqlPK(AutoBean autoBean) {
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			AutoAttr autoAttr = autoAttrs.get(i);
			if (autoAttr.isPK()) {
				if (!StringUtil.isNull(autoAttr.getSeq())) {
					// String seqStr =
					// (String)PropsUtil.getProperty("mysql.seq");
					String seqStr = AutoConfig.mysql_seq;
					return MessageFormat.format(seqStr, autoAttr.getAttrName(), autoAttr.getAttrType(),
							autoAttr.getSeq());
				} else {
					String uuid = AutoConfig.mysql_uuid;
					return MessageFormat.format(uuid, autoAttr.getAttrName(), autoAttr.getAttrType());
				}
			}
		}
		return BANK_VALUE_0;
	}

	/**
	 * 设置属性值
	 * 
	 * @param autoBean
	 * @return String
	 */
	public String producedSetAttrValue(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			AutoAttr autoAttr = autoAttrs.get(i);
			sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4);
			if (createTime.equals(autoAttr.getAttrName().toLowerCase())
					|| updateTime.equals(autoAttr.getAttrName().toLowerCase())) {
				sBuffer.append("now()");
			} else {
				sBuffer.append(DEFAULT_POUND).append(LEFT_BRACKETS);
				sBuffer.append("info").append(DOT_VALUE).append(autoAttr.getAttrName());
				sBuffer.append(COlON_VALUE).append(autoAttr.getAttrType().getMybatisType());
				sBuffer.append(RIGHT_BRACKETS);
			}
			if (i == autoAttrs.size() - 1) {
				sBuffer.append(ENTER_VALUE);
			} else {
				sBuffer.append(COMMA_VALUE).append(ENTER_VALUE);
			}

		}
		String str = sBuffer.toString().trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * update方法
	 * 
	 * @param autoBean
	 * @return
	 */
	public String producedUpdateMothod(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			String attrName = autoAttrs.get(i).getAttrName();
			if (createTime.equals(attrName.toLowerCase())) {
				continue;
			}
			String type = autoAttrs.get(i).getAttrType().getMybatisType();
			if (!autoAttrs.get(i).isPK()) {

				if (i != autoAttrs.size() - 1) {
					sBuffer.append(producedSpace());
					sBuffer.append(producedSaveValue(attrName, type, autoBean));
					sBuffer.append(COMMA_VALUE).append(ENTER_VALUE);
				} else {
					sBuffer.append(producedSpace());
					sBuffer.append(producedSaveValue(attrName, type, autoBean));
				}
			}
		}
		String str = sBuffer.toString().trim();
		if (str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	// 边距
	public String producedSpace() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4);
		return sBuffer.toString();
	}

	// <if test=......>
	public String producedStartIfStatement(String attrName) {
		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append(LEFT_ANGLE).append(START_IF_VALUE).append(BANK_VALUE_1).append(TEST_VALUE).append(EQUAL_VALUE)
				.append("\"").append(StringUtil.getLowerCaseChar(attrName)).append(UNEQUALS_VALUE).append(NULL_VALUE)
				.append(BANK_VALUE_1).append(DEFAULT_AND).append(BANK_VALUE_1)
				.append(StringUtil.getLowerCaseChar(attrName)).append(UNEQUALS_VALUE).append("\'").append("\'")
				.append("\"").append(RIGHT_ANGLE).append(ENTER_VALUE);

		return sBuffer.toString();
	}

	// <if></if>中间的语句
	public String producedSaveValue(String attrName, String type, AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(BANK_VALUE_4).append(attrName.toUpperCase()).append(BANK_VALUE_1).append(EQUAL_VALUE)
				.append(BANK_VALUE_1);
		if (updateTime.equals(attrName.toLowerCase())) {
			sBuffer.append("now()");
		} else {
			sBuffer.append(DEFAULT_POUND).append(LEFT_BRACKETS).append("info").append(DOT_VALUE).append(attrName)
					.append(COlON_VALUE).append(type).append(RIGHT_BRACKETS);
		}
		return sBuffer.toString();
	}

	public String producedOrderBy(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			String attrName = autoAttrs.get(i).getAttrName();
			if (updateTime.equals(attrName.toLowerCase())) {
				sBuffer.append(BANK_VALUE_4).append("order by ").append(BANK_VALUE_1);
				sBuffer.append("t").append(DOT_VALUE).append(attrName.toUpperCase()).append(BANK_VALUE_1);
				sBuffer.append("DESC");
			}
		}
		return sBuffer.toString();
	}

	// </if>
	public String producedEndIfStatement() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(END_IF_VALUE).append(ENTER_VALUE);
		return sBuffer.toString();
	}

	// 多条件查询--<if>
	public String producedTypeIfStatement() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(LEFT_ANGLE).append(START_IF_VALUE).append(BANK_VALUE_1).append(TEST_VALUE).append(EQUAL_VALUE)
				.append("\"");
		sBuffer.append(DEFAULT_KEYWORD);
		sBuffer.append(UNEQUALS_VALUE).append(NULL_VALUE).append(BANK_VALUE_1).append(DEFAULT_AND).append(BANK_VALUE_1);
		sBuffer.append(DEFAULT_KEYWORD);
		sBuffer.append(UNEQUALS_VALUE).append("\'").append("\'").append("\"").append(RIGHT_ANGLE).append(ENTER_VALUE);
		return sBuffer.toString();
	}

	// 多条件if循环
	public String producedFindToType(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(producedSpace());
		sBuffer.append(producedSpace());
		sBuffer.append(producedTypeIfStatement());
		sBuffer.append(" and ( 2=1 ");
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		boolean isFlag = false;
		for (int i = 0; i < autoAttrs.size(); i++) {
			String isQuery = autoAttrs.get(i).getIsQuery();
			String attrName = autoAttrs.get(i).getAttrName();
			String type = autoAttrs.get(i).getAttrType().getMybatisType();
			if ("YES".equals(isQuery)) {
				isFlag = true;
				sBuffer.append(producedSpace());
				sBuffer.append(producedSpace());
				sBuffer.append(BANK_VALUE_4).append(DEFAULT_OR);
				sBuffer.append(producedMiddleStatement(attrName, type, autoBean));
			}
		}
		sBuffer.append(" )");
		sBuffer.append(producedSpace());
		sBuffer.append(producedSpace());
		sBuffer.append(producedEndIfStatement());
		if (isFlag) {
			return sBuffer.toString();
		}
		return "";
	}

	// 多条件查询
	public String producedMiddleStatement(String attrName, String attrType, AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		String type = AttrType.String.getMybatisType();
		sBuffer.append(BANK_VALUE_1);
		if (attrType.equals(AttrType.Date.getMybatisType())) {
			sBuffer.append("date_format(");
			sBuffer.append("t").append(DOT_VALUE).append(attrName.toUpperCase());
			sBuffer.append(",'%Y%m%d')");
		} else {
			sBuffer.append("t").append(DOT_VALUE).append(attrName.toUpperCase());
		}
		sBuffer.append(BANK_VALUE_1);
		sBuffer.append(LIKE_VALUE).append(BANK_VALUE_1).append(CONCAT_VALUE).append(LEFT_PATEN).append(CONCAT_VALUE)
				.append(LEFT_PATEN);
		sBuffer.append("\'").append(PERCENT_VALUE).append("\'").append(COMMA_VALUE);
		sBuffer.append(DEFAULT_POUND).append(LEFT_BRACKETS).append(DEFAULT_KEYWORD).append(COlON_VALUE).append(type);
		sBuffer.append(RIGHT_BRACKETS).append(RIGHT_PATEN).append(COMMA_VALUE).append("\'").append(PERCENT_VALUE)
				.append("\'").append(RIGHT_PATEN);
		sBuffer.append(ENTER_VALUE);

		return sBuffer.toString();
	}

	public String producedGetBeanObject(AutoBean autoBean) {
		String beanObject = StringUtil.getLowerCaseChar(autoBean.getFactBeanName());
		return beanObject;
	}

	public String producedDaoInterfacePackageUrl(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(DOT_VALUE).append(autoBean.getDefaultDao());
		return sBuffer.toString();
	}

	public static void main(String[] args) {
		AutoBean autoBean = new AutoBean();
		autoBean.setBeanName("job");
		autoBean.setModuleDesc("job");
		// 包路径
		// autoBean.setDefaultPackageUrl("cluster.scheme.module.inner.rbac.");
		List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
		AutoAttr autoAttr = new AutoAttr();
		AutoAttr autoAttr1 = new AutoAttr();
		AutoAttr autoAttr2 = new AutoAttr();
		// 属性设置
		autoAttr.setAttrName("penId");
		autoAttr.setAttrDesc("ID");
		autoAttr.setAttrType(AttrType.String);
		autoAttr.setAttrSize(70);
		// //表主键
		autoAttr.setPK(true);
		autoAttr.setSeq("SYS_USERS_SEQ");// 不设置则默认为uuid策略

		autoAttr1.setAttrName("penName");
		autoAttr1.setAttrType(AttrType.Date);
		autoAttr1.setAttrDesc("笔名");
		autoAttr1.setAttrSize(50);

		autoAttr2.setAttrName("penPrice");
		autoAttr2.setAttrType(AttrType.Integer);
		autoAttr2.setAttrDesc("价格");
		autoAttr2.setAttrSize(3);

		autoAttrs.add(autoAttr);
		autoAttrs.add(autoAttr1);
		autoAttrs.add(autoAttr2);
		autoBean.setAutoAttrs(autoAttrs);

		MybatisMySqlXmlProduced mysql = new MybatisMySqlXmlProduced();
		System.out.println(mysql.producedFindToType(autoBean));

	}
}
