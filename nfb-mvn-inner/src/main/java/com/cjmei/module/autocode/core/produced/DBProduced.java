package com.cjmei.module.autocode.core.produced;

import com.cjmei.module.autocode.core.produced.pojo.AutoBean;

/**
 * 生成数据库表
 * @author ykai5
 *
 */
public interface DBProduced {
	
	/**
	 * 根据bean信息，生成对应数据库表
	 * @param autoBean
	 * @return
	 */
    String ENTER_VALUE = "\r\n";
    
    String BANK_VALUE_1 = " ";
    String BANK_VALUE_4 = "    ";
    
    String COMMA_VALUE = ",";
    String SEMI_VALUE = ";";
    String LEFT_PATEN="(";
    String RIGHT_PATEN=")";
    
    String DEFAULT_CREATE = "CREATE";
    String DEFAULT_TABLE = "TABLE";
    String DEFAULT_PRIMARY = "primary key";
    
	public String createTableSql(AutoBean autoBean);
	
	public   void  createTable(AutoBean autoBean);
	
}
