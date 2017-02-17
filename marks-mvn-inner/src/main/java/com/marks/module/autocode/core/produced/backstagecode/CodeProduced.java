package com.cjmei.module.autocode.core.produced.backstagecode;

import com.cjmei.module.autocode.core.produced.ModuleProduced;
import com.cjmei.module.autocode.core.produced.config.AutoConfig;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;

/**
 * java文件代码生成接口
 * @author ykai5
 *
 */
public interface CodeProduced extends ModuleProduced {

	//默认包路径,{0}表示实体包名
	String DEFAULT_PACKAGE_URL = AutoConfig.DEFAULT_JAVA_PACKAGE_URL;

	//实现类的默认包
	String DEFAULT_PRIVATE = "private";
	String DEFAULT_PUBLIC = "public";
	String DEFAULT_PROTECTED = "protected";
	String DEFAULT_GET = "get";
	String DEFAULT_SET = "set";
	
//	
	String DEFAULT_IMPL = "impl";
	String DEFAULT_CONTROLLER = "controller";
	String DEFAULT_DAO = "dao";
	String DEFAULT_POJO = "pojo";
	String DEFAULT_SERVICE = "service";
	
	String DEFAULT_FILE_JAVA = "java";
	
	String GET_VALUE="get";
	String ADD_VALUE="add";
	String DELETE_VALUE="delete";
	String UPDATE_VALUE="update";
	String FINDALL_VALUE="findAll";
	
	String SUFFIX_DAO = "Dao";
	String FINDBYID_VALUE = "findById";
	String SAVE_VALUE = "save";

	
	
    String RETURN_VALUE="return";
	String VOID_VALUE="void";

	String THIS_VALUE="this.";
	String EQUAL_VALUE="=";
		
    String DESC_1 = "/**";
    String DESC_2 = "*";
    String DESC_3 = "*/";
    /**    
	 * 泛型T获取
	 * @param autoBean
	 * @return
	 */
	public String producedT(AutoBean autoBean);

}
