/**
 * File Name: cluster.scheme.autocode.table.MySqlTableProduced.java
 * 类简述
 * @author:lffei1@grgbanking.com
 * @Date:2016年7月14日上午10:53:33
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.autocode.core.produced.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.cjmei.module.autocode.core.produced.DBProduced;
import com.cjmei.module.autocode.core.produced.pojo.AttrType;
import com.cjmei.module.autocode.core.produced.pojo.AutoAttr;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.util.JdbcUtil;

/**
 * File Name: cluster.scheme.autocode.table.MySqlTableProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年7月14日上午10:53:33
 * @see (optional)
 * @Copyright (c) 2016, 广电运通信息科技有限公司 All Rights Reserved.
 */
public class MySqlTableProduced implements DBProduced {

	private static Logger logger = Logger.getLogger(MySqlTableProduced.class);

	public String createTableSql(AutoBean autoBean) {
		String beanName = autoBean.getFactTableName();
		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append(createTableName(beanName));
		sBuffer.append(createFieldSql(autoBean));
		sBuffer.append(ENTER_VALUE).append(RIGHT_PATEN);
		return sBuffer.toString();
	}

	public String createTableName(String beanName) {
		StringBuffer sBuffer = new StringBuffer();

		sBuffer.append(DEFAULT_CREATE).append(BANK_VALUE_1).append(DEFAULT_TABLE).append(BANK_VALUE_1).append(beanName)
				.append(BANK_VALUE_1).append(LEFT_PATEN).append(ENTER_VALUE);

		return sBuffer.toString();
	}

	public String createFieldSql(AutoBean autoBean) {
		StringBuffer sBuffer = new StringBuffer();

		List<AutoAttr> attrs = autoBean.getAutoAttrs();
		for (int i = 0; i < attrs.size(); i++) {
			sBuffer.append(BANK_VALUE_4).append(attrs.get(i).getAttrName()).append(BANK_VALUE_1)
					.append(attrs.get(i).getAttrType().getMySqlType());
			if (AttrType.String.getMybatisType().equals(attrs.get(i).getAttrType().getMybatisType())) {
				sBuffer.append(LEFT_PATEN).append(attrs.get(i).getAttrSize()).append(RIGHT_PATEN);
			}
			if (attrs.get(i).isPK()) {
				sBuffer.append(BANK_VALUE_1).append(DEFAULT_PRIMARY);
			}
			if (i < attrs.size() - 1) {
				sBuffer.append(COMMA_VALUE).append(ENTER_VALUE);
			}
		}

		return sBuffer.toString();
	}

	// 判断表是否存在
	public boolean existTable(AutoBean autoBean) {
		boolean flag = true;
		try {
			DatabaseMetaData dMetaData = JdbcUtil.getConnection().getMetaData();
			ResultSet table = null;
			String[] type = { "TABLE" };
			table = dMetaData.getTables(null, null, autoBean.getFactBeanName().toUpperCase(), type);
			if (table.next()) {
				flag = false;
			}
			table.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void createTable(AutoBean autoBean) {
		MySqlTableProduced mySqlTableProduced = new MySqlTableProduced();
		Connection connection = JdbcUtil.getConnection();

		if (!mySqlTableProduced.existTable(autoBean)) {
			logger.info(autoBean.getBeanName() + "表已存在");
			return;
		}
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(mySqlTableProduced.createTableSql(autoBean));
			logger.info(autoBean.getBeanName() + "表创建成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
