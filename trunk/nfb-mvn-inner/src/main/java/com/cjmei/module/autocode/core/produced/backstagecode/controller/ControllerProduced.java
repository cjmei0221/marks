/**
 * File Name: cluster.scheme.autocode.backstagecode.controller.ControllerProduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年5月23日上午8:14:13
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.autocode.core.produced.backstagecode.controller;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.autocode.core.produced.backstagecode.AbstractCodeProduced;
import com.cjmei.module.autocode.core.produced.backstagecode.CodeProduced;
import com.cjmei.module.autocode.core.produced.backstagecode.service.ServiceImplProduced;
import com.cjmei.module.autocode.core.produced.pojo.AttrType;
import com.cjmei.module.autocode.core.produced.pojo.AutoAttr;
import com.cjmei.module.autocode.core.produced.pojo.AutoBean;
import com.cjmei.module.autocode.core.produced.util.StringUtil;

/**
 * File Name: cluster.scheme.autocode.backstagecode.controller.ControllerProduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年5月23日上午8:14:13
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public class ControllerProduced extends AbstractCodeProduced{
    @Override
    //后缀
    public String getFileNameAfter() {
        String result = StringUtil.StringJoin(StringUtil.getUpperCaseChar( CodeProduced.DEFAULT_CONTROLLER ));
        return result;
    }

    @Override
    public String producedPackageUrl(AutoBean autoBean) {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(autoBean.getDefaultPackageUrl()).append(autoBean.getFactBeanName().toLowerCase())
        .append(DOT_VALUE).append(autoBean.getDefaultController());
        //TODO 改为代理注入方案
//        setFileSrc(outFileContent, sBuffer.toString());
        return sBuffer.toString();
    }
    
	public String getFileSrc(AutoBean autoBean) {
		return producedPackageUrl(autoBean);
	}
    
    //service url
    public String producedServicePackageUrl(AutoBean autoBean){
        ServiceImplProduced service  = new ServiceImplProduced();
        String serviceUrl = service.producedServiceInterfacePackageUrl(autoBean);
        
        return serviceUrl;
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
    
   /* public String producedLowerCode(AutoBean autoBean){
        String lowerBeanName = autoBean.getFactBeanName().toLowerCase();
        return lowerBeanName;
    }*/
    
    //模块描述
    public String producedGetModuleDesc(AutoBean autoBean){
        return autoBean.getModuleDesc();
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
   
   public String producedGetIdAttrName(AutoBean autoBean){
       
       List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
       for(AutoAttr attr : autoAttrs){
           if(attr.isPK()){
                return StringUtil.getUpperCaseChar(attr.getAttrName());
           }
       }
       return "";
   }
  
   
    public static void main(String[] args){
        AutoBean autoBean = new AutoBean();
        autoBean.setBeanName("ZOo1");
        List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
        AutoAttr autoAttr = new AutoAttr();
        AutoAttr autoAttr1 = new AutoAttr();
        autoAttr.setAttrName("bookId");
        autoAttr.setAttrType(AttrType.Integer);
        autoAttr1.setAttrName("bookName");
        autoAttr1.setAttrType(AttrType.String);
        autoAttrs.add(autoAttr);
        autoAttrs.add(autoAttr1);
        autoBean.setAutoAttrs(autoAttrs);
        ControllerProduced controllerProduced = new ControllerProduced();
        System.out.println(controllerProduced.producedBeanObject(autoBean));
        System.out.println(controllerProduced.producedBeanName(autoBean));
    }
}
