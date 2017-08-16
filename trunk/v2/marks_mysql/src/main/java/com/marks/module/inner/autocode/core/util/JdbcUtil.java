package com.marks.module.inner.autocode.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.marks.module.inner.autocode.core.produced.config.AutoConfig;

public class JdbcUtil {

	private static Logger logger = Logger.getLogger(JdbcUtil.class);

	private static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";

	// TODO oracle ，mysql 需统一处理
	public static String getDriver(String dialect) {
		if ("oracle".equals(dialect)) {
			return ORACLEDRIVER;
		}
		if ("mysql".equals(dialect)) {
			return MYSQLDRIVER;
		}
		return "";
	}

	private static class JdbcHelper {

		private static Connection connection = getConnection();

		private static Connection getConnection() {
			if (connection == null) {
				try {
					String dialect = AutoConfig.jdbc_password;
					if ("oracle".equals(dialect)) {
						Class.forName(JdbcUtil.getDriver("oracle"));
					}else{
						Class.forName(JdbcUtil.getDriver("mysql"));
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				// String dialect = PropsUtil.getProperty("jdbc.dialect");
				String jdbcUrl = AutoConfig.jdbc_url;
				String user = AutoConfig.jdbc_user;
				String password = AutoConfig.jdbc_password;
				try {
					return DriverManager.getConnection(jdbcUrl, user, password);
				} catch (SQLException e) {
					logger.info("获取数据库connection失败，请检查jdbc配置");
				}
				return null;
			} else
				return connection;

		}
	}

	public static Connection getConnection() {
		return JdbcHelper.connection;
	}

}
