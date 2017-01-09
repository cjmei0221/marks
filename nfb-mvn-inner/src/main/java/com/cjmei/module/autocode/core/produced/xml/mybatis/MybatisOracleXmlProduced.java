package com.cjmei.module.autocode.core.produced.xml.mybatis;

/**
 * File Name: cluster.scheme.autocode.backstagecode.ampperxml.MapperXmlProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年5月24日下午2:03:36
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */

import java.text.MessageFormat;
import java.util.List;

import com.cjmei.module.autocode.core.produced.config.AutoConfig;
import com.cjmei.module.autocode.core.produced.pojo.AttrType;
import com.cjmei.module.autocode.core.produced.pojo.AutoAttr;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.util.StringUtil;
import com.cjmei.module.autocode.core.produced.xml.AbstractXmlProduced;

/**
 * File Name:
 * cluster.scheme.autocode.backstagecode.ampperxml.MapperXmlProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年5月24日下午2:03:36
 * @see (optional)
 * @Copyright (c) 2016, 广电运通信息科技有限公司 All Rights Reserved.
 */
public class MybatisOracleXmlProduced extends AbstractXmlProduced {

	/* String tableOtherName; */

	/**
	 * 文件后缀格式
	 * 
	 * @see cluster.scheme.autocode.backstagecode.AbstractCodeProduced#getFileNameAfter()
	 */
	@Override
	public String getFileNameAfter() {
		String result = StringUtil.StringJoin(StringUtil.getUpperCaseChar(DEFAULT_DAO),
				StringUtil.getUpperCaseChar(DEFAULT_MAPPER));
		return result;
	}

	// @Override
	// public String producedPackageUrl(AutoBean autoBean) {
	//
	// }

	@Override
	public String getFileSrc(AutoBean autoBean) {
		// TODO 改为代理注入方案
		// setFileSrc(outFileContent, sBuffer.toString());
		// TODO Auto-generated method stub
		String oracleSrc = StringUtil.StringJoin(ORACLE_PACKAGE);
		return oracleSrc;
	}

	/**
	 * namespace
	 */
	public String producedNameSpaceUrl(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName().toLowerCase())
				.append(DOT_VALUE).append(autoBean.getDefaultPojo());
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
			sBuffer.append(autoBean.getDefaultTableOtherName()).append(DOT_VALUE)
					.append(autoAttrs.get(i).getAttrName().toUpperCase());
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
	public String producedOraclePK(AutoBean autoBean) {
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			AutoAttr autoAttr = autoAttrs.get(i);
			if (autoAttr.isPK()) {
				if (!StringUtil.isNull(autoAttr.getSeq())) {
					String seqStr = AutoConfig.oracle_seq;
					;
					return MessageFormat.format(seqStr, autoAttr.getAttrName(), autoAttr.getAttrType(),
							autoAttr.getSeq());
				} else {
					String uuid = AutoConfig.oracle_seq;
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
			sBuffer.append(DEFAULT_POUND).append(LEFT_BRACKETS);
			sBuffer.append(autoAttrs.get(i).getAttrName());
			sBuffer.append(COlON_VALUE).append(autoAttrs.get(i).getAttrType().getMybatisType());
			if (i == autoAttrs.size() - 1) {
				sBuffer.append(RIGHT_BRACKETS).append(ENTER_VALUE);
			} else {
				sBuffer.append(RIGHT_BRACKETS).append(COMMA_VALUE).append(ENTER_VALUE);
			}
		}

		return sBuffer.toString();
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
		return sBuffer.toString();
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

		sBuffer.append(BANK_VALUE_4).append(autoBean.getDefaultTableOtherName()).append(DOT_VALUE)
				.append(attrName.toUpperCase()).append(BANK_VALUE_1).append(EQUAL_VALUE).append(BANK_VALUE_1)
				.append(DEFAULT_POUND).append(LEFT_BRACKETS).append(attrName).append(COlON_VALUE).append(type)
				.append(RIGHT_BRACKETS);

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
		sBuffer.append(" and (");
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		for (int i = 0; i < autoAttrs.size(); i++) {
			String attrName = autoAttrs.get(i).getAttrName();
			String type = autoAttrs.get(i).getAttrType().getMybatisType();
			if (i > 0) {
				sBuffer.append(producedSpace());
				sBuffer.append(producedSpace());
				sBuffer.append(BANK_VALUE_4).append(DEFAULT_OR);
			}
			sBuffer.append(producedMiddleStatement(attrName, type, autoBean));
		}
		sBuffer.append(" )");
		sBuffer.append(producedSpace());
		sBuffer.append(producedSpace());
		sBuffer.append(producedEndIfStatement());
		return sBuffer.toString();
	}

	// 多条件查询
	public String producedMiddleStatement(String attrName, String attrType, AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		String type = AttrType.String.getMybatisType();
		sBuffer.append(BANK_VALUE_1);
		if (attrType.equals(AttrType.Date.getMybatisType())) {
			sBuffer.append("to_char(");
			sBuffer.append(autoBean.getDefaultTableOtherName()).append(DOT_VALUE).append(attrName.toUpperCase());
			sBuffer.append(",'yyyy-MM-dd')");
		} else {
			sBuffer.append(autoBean.getDefaultTableOtherName()).append(DOT_VALUE).append(attrName.toUpperCase());
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
		sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName().toLowerCase())
				.append(DOT_VALUE).append(autoBean.getDefaultDao());
		return sBuffer.toString();
	}
}
