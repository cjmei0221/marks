/**
 * File Name: util.autocode.backstagecode.service.ServiceImplProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年5月20日上午11:46:00
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.system.autocode.backstagecode.service;

import java.util.List;

import com.cjmei.module.system.autocode.backstagecode.AbstractCodeProduced;
import com.cjmei.module.system.autocode.backstagecode.CodeProduced;
import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.util.StringUtil;


/**
 * File Name: util.autocode.backstagecode.service.ServiceImplProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年5月20日上午11:46:00
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public class ServiceImplProduced extends AbstractCodeProduced{

    /**
     * 
     * @see util.autocode.backstagecode.AbstractCodeProduced#getFileNameAfter()
     */
    @Override
    public String getFileNameAfter() {
        String result = StringUtil.StringJoin(StringUtil.getUpperCaseChar( CodeProduced.DEFAULT_SERVICE ),
                StringUtil.getUpperCaseChar( CodeProduced.DEFAULT_IMPL ));
        return result;
    }

    /**
     * 
     * @see util.autocode.backstagecode.AbstractCodeProduced#producedPackageUrl(util.autocode.pojo.AutoBean)
     */
    @Override
    public String producedPackageUrl(AutoBean autoBean) {
        
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName())
        .append(DOT_VALUE).append(autoBean.getDefaultService()).append(DOT_VALUE).append(autoBean.getDefaultImpl());
        //TODO 改为代理注入方案
//        setFileSrc(outFileContent, sBuffer.toString());
        return sBuffer.toString();
    }
    
	public String getFileSrc(AutoBean autoBean) {
		return producedPackageUrl(autoBean);
	}

    
    //service 路径
    public String producedServiceInterfacePackageUrl(AutoBean autoBean){
       StringBuffer sBuffer = new StringBuffer();
       sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName())
       .append(DOT_VALUE).append(autoBean.getDefaultService());
       
       return sBuffer.toString();
    }
    
  //Dao 路径
    public String producedDaoInterfacePackageUrl(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName())
        .append(DOT_VALUE).append(autoBean.getDefaultDao());
        return sBuffer.toString();
    }
    
    //对象声明
    public String producedObject(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(BANK_VALUE_4).append(DEFAULT_PRIVATE).append(BANK_VALUE_1)
            .append(StringUtil.getUpperCaseChar(autoBean.getFactBeanName()) ).append(BANK_VALUE_1)
            .append(autoBean.getFactBeanName());
        
        return sBuffer.toString();
    }
   
  //object
    public String producedDaoObject(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        
        sBuffer.append(BANK_VALUE_4).append(DEFAULT_PRIVATE).append(BANK_VALUE_1)
        .append(StringUtil.getUpperCaseChar(autoBean.getFactBeanName()) )
        .append(SUFFIX_DAO).append(BANK_VALUE_1)
        .append(StringUtil.getLowerCaseChar(autoBean.getFactBeanName()) )
        .append(SUFFIX_DAO).append(SEMI_VALUE);
        sBuffer.append(ENTER_VALUE);
        return sBuffer.toString();
    }
    
    //getsetMethod
    public String producedGetSetMethod(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(producedGetMethod(autoBean.getFactBeanName()));
        sBuffer.append(producedSetMethod(autoBean.getFactBeanName()));
        return sBuffer.toString();
    }
    
    //getter
    public String producedGetMethod(String beanName){
        
    StringBuffer sBuffer = new StringBuffer();
    sBuffer.append(BANK_VALUE_4).append(DEFAULT_PUBLIC).append(BANK_VALUE_1)
        .append(StringUtil.getUpperCaseChar(beanName) )
        .append(SUFFIX_DAO).append(BANK_VALUE_1)
        .append(DEFAULT_GET).append(StringUtil.getUpperCaseChar(beanName) )
        .append(SUFFIX_DAO).append(LEFT_PATEN)
        .append(RIGHT_PATEN).append(LEFT_BRACKETS).append(ENTER_VALUE);
    sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(RETURN_VALUE).append(BANK_VALUE_1)
        .append(StringUtil.getLowerCaseChar(beanName) ).append(SUFFIX_DAO).append(SEMI_VALUE)
        .append(ENTER_VALUE).append(BANK_VALUE_4).append(RIGHT_BRACKETS);
    sBuffer.append(ENTER_VALUE);
    return sBuffer.toString();
    }
    
    //setter
   public String producedSetMethod(String beanName){
        
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(BANK_VALUE_4).append(DEFAULT_PUBLIC).append(BANK_VALUE_1)
            .append(VOID_VALUE).append(BANK_VALUE_1)
            .append(DEFAULT_SET)
            .append(StringUtil.getUpperCaseChar(beanName) )
            .append(SUFFIX_DAO).append(LEFT_PATEN)
            .append(StringUtil.getUpperCaseChar(beanName) )
            .append(SUFFIX_DAO)
            .append(BANK_VALUE_1)
            .append(StringUtil.getLowerCaseChar(beanName) )
            .append(SUFFIX_DAO)
            .append(RIGHT_PATEN).append(LEFT_BRACKETS).append(ENTER_VALUE);
        sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(THIS_VALUE)
            .append(StringUtil.getLowerCaseChar(beanName) )
            .append(SUFFIX_DAO).append(BANK_VALUE_1).append(EQUAL_VALUE)
            .append(StringUtil.getLowerCaseChar(beanName) )
            .append(SUFFIX_DAO).append(SEMI_VALUE)
            .append(ENTER_VALUE).append(BANK_VALUE_4).append(RIGHT_BRACKETS);
        sBuffer.append(ENTER_VALUE);
        
        return sBuffer.toString();
        }
   
   public String producedGetIdAttrValue(AutoBean autoBean){
       List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
       for(AutoAttr attr : autoAttrs){
           if(attr.isPK()){
                return attr.getAttrName();
           }
       }
       return "";
   }
   
   public String producedGetIdAttrType(AutoBean autoBean){
       
       List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
       for(AutoAttr attr : autoAttrs){
           if(attr.isPK()){
                return String.valueOf(attr.getAttrType());
           }
       }
       return "";
   }
   
   public String producedGetBeanObject(AutoBean autoBean){
       String beanObject =StringUtil.getLowerCaseChar(autoBean.getFactBeanName());
       return beanObject;
   }
   
   public String producedModuleDesc(AutoBean autoBean){
       return autoBean.getModuleDesc();
   }
   
    
    public static void main(String[] args){
        AutoBean autoBean = new AutoBean();
        autoBean.setBeanName("Zoo1");
        ServiceImplProduced sip = new ServiceImplProduced();
        System.out.println(sip.producedDaoObject(autoBean));
        System.out.println(sip.producedGetSetMethod(autoBean)); 
       
    }
}
