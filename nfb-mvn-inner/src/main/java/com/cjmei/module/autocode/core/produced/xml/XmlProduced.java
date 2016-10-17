package com.cjmei.module.autocode.core.produced.xml;

import com.cjmei.module.autocode.core.produced.ModuleProduced;

public interface XmlProduced extends ModuleProduced{

	String DEFAULT_MAPPER = "mapper";
    String START_IF_VALUE = "if";
    String END_IF_VALUE = "</if>";
    String UNEQUALS_VALUE = "!=";

    String TEST_VALUE = "test";
    String NULL_VALUE = "null";
    String DEFAULT_AND = "and";
    String TAB_NAME = "Tab";
    String DEFAULT_MAPPERXML ="MapperXml";
	
    String RETURN_VALUE="return";
	String VOID_VALUE="void";

	String THIS_VALUE="this.";
	String EQUAL_VALUE="=";
    String DEFAULT_FILE_XML = "xml";
    
    String DEFAULT_DAO = "dao";
    
    String LIKE_VALUE = "LIKE";
    String CONCAT_VALUE = "CONCAT";
    String PERCENT_VALUE = "%";
    
    String DEFAULT_PK_VALUE = "id";
    
    String MYSQL_PACKAGE = "mysql"; 
    String ORACLE_PACKAGE = "oracle";
}
