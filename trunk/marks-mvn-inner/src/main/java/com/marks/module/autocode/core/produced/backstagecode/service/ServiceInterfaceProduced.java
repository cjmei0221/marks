/**
 * File Name: util.autocode.backstagecode.service.ServiceProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年5月19日下午3:41:56
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.marks.module.autocode.core.produced.backstagecode.service;

import java.util.List;

import com.marks.module.autocode.core.produced.backstagecode.AbstractCodeProduced;
import com.marks.module.autocode.core.produced.backstagecode.CodeProduced;
import com.marks.module.autocode.core.produced.pojo.AutoAttr;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.util.StringUtil;

/**
 * File Name: util.autocode.backstagecode.service.ServiceProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * Service interface 处理
 * @Date:2016年5月19日下午3:41:56
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public class ServiceInterfaceProduced extends AbstractCodeProduced{

    /**
     * 获取文件后缀
     * @see util.autocode.backstagecode.AbstractCodeProduced#getFileNameAfter()
     */
    @Override
    public String getFileNameAfter() {
        return  StringUtil.getUpperCaseChar(CodeProduced.DEFAULT_SERVICE);
    }

    /**
     * 获取 packageURL
     * @see util.autocode.backstagecode.AbstractCodeProduced#producedPackageUrl(util.autocode.pojo.AutoBean)
     */
    @Override
    public String producedPackageUrl(AutoBean autoBean) {
        String packageUrl =  StringUtil.StringJoin( autoBean.getDefaultPackageUrl(),
                autoBean.getFactBeanName().toLowerCase(),DOT_VALUE,autoBean.getDefaultService()); 
        //TODO 改为代理注入方案
//        setFileSrc(outFileContent, packageUrl);
        return packageUrl;
    }
    
	public String getFileSrc(AutoBean autoBean) {
		return producedPackageUrl(autoBean);
	}

    
    public String producedGetIdAttrValue(AutoBean autoBean){
        String pkName = "isID";
        List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
        for(AutoAttr attr : autoAttrs){
            if(attr.isPK()){
                 return attr.getAttrName();
            }
        }
        return pkName;
    }
    
    public String producedGetIdAttrType(AutoBean autoBean){
        String pkType="isId";
        List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
        for(AutoAttr attr : autoAttrs){
            if(attr.isPK()){
                 pkType = String.valueOf(attr.getAttrType());
                 return pkType;
            }
        }
        return pkType;
    }
    
    public String producedGetBeanObject(AutoBean autoBean){
        String beanObject =StringUtil.getLowerCaseChar(autoBean.getFactBeanName());
        return beanObject;
    }
  
}
