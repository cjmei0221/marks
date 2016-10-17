package com.cjmei.module.autocode.core.backstagecode.dao;

import java.util.List;

import com.cjmei.module.autocode.core.backstagecode.AbstractCodeProduced;
import com.cjmei.module.autocode.core.backstagecode.CodeProduced;
import com.cjmei.module.autocode.core.pojo.AutoAttr;
import com.cjmei.module.autocode.core.pojo.AutoBean;
import com.cjmei.module.autocode.core.util.StringUtil;

/**
 * daoInterface处理
 * @author ykai5
 *
 */
public class DaoInterfaceProduced extends AbstractCodeProduced {

	//fileurl,package
	public String producedPackageUrl(AutoBean autoBean){
		String packageUrl =  StringUtil.StringJoin( autoBean.getDefaultPackageUrl(),
				autoBean.getFactBeanName().toLowerCase(),DOT_VALUE,autoBean.getDefaultDao()); 
		//TODO 改为代理注入方案
//		setFileSrc(outFileContent, packageUrl);
		return packageUrl;
	}

	public String getFileNameAfter() {
		return StringUtil.getUpperCaseChar( CodeProduced.DEFAULT_DAO );
	}

	@Override
	public String getFileSrc(AutoBean autoBean) {
		return producedPackageUrl(autoBean);
	}
    
	 /**
     * 获取对象
     * @param autoBean
     * @return
     */
    public String producedBeanObject(AutoBean autoBean){
        String beanObject = StringUtil.getLowerCaseChar(autoBean.getFactBeanName() );
        return beanObject;
    }
    
	//获取主键     
	public String producedGetPkAttrName(AutoBean autoBean){
	    
	    List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
	       for(AutoAttr attr : autoAttrs){
	           if(attr.isPK()){
	                return attr.getAttrName();
	           }
	       }
	       return "";
	}
}
