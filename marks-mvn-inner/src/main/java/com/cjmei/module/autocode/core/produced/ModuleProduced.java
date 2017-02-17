package com.cjmei.module.autocode.core.produced;

import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.pojo.OutFileContent;

public interface ModuleProduced {

		String LEFT_BRACKETS = "{";
		String RIGHT_BRACKETS = "}";
		String LEFT_PATEN="(";
		String RIGHT_PATEN=")";
	    String LEFT_ANGLE = "<";
	    String RIGHT_ANGLE = ">";
	    
	//换行符
		String ENTER_VALUE = "\r\n";
		//空格
		
		String BANK_VALUE_0 = "";
		String BANK_VALUE_1 = " ";
		String BANK_VALUE_2 = "  ";
		String BANK_VALUE_3 = "   ";
		String BANK_VALUE_4 = "    ";
		
		//；
		String SEMI_VALUE = ";";
		//.
		String DOT_VALUE = ".";
		String BACK_SLANT = "/"; 
	    String DEFAULT_POUND = "#";
	    String COMMA_VALUE = ",";
	    String COlON_VALUE = ":";
	    
	    String createTime="createtime";
	    String updateTime="updatetime";
	    
		/**
		 * bean package url
		 * @param autoBean
		 * @return
		 */
		public String producedBeanPackageUrl(AutoBean autoBean);
		
		/**
		 * 实体bean名字
		 * @param autoBean
		 * @return
		 */
		public String producedBeanName(AutoBean autoBean);
		
		public OutFileContent getOutFileContent();
		public void setFileSrc(AutoBean autoBean);
}
