/**
 * File Name: cluster.scheme.autocode.webpage.js.jspage.Jsproduced.java
 * 类简述
 * @author:hgwei1@grgbanking.com
 * @Date:2016年6月7日上午9:33:07
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
package com.cjmei.module.system.autocode.webpage.js.jspage;

import java.util.List;

import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.util.StringUtil;
import com.cjmei.module.system.autocode.webpage.js.AbstractJsProduced;

/**
 * File Name: cluster.scheme.autocode.webpage.js.jspage.Jsproduced.java
 * 
 * @author:lffei1@grgbanking.com
 * @Date:2016年6月7日上午9:33:07
 * @see (optional) 
 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
 */
public class JsPageProduced extends AbstractJsProduced{

    /**
     * 
     * @see cluster.scheme.autocode.webpage.js.AbstractJsProduced#getFileSrc(cluster.scheme.autocode.pojo.AutoBean)
     */
    @Override
    public String getFileSrc(AutoBean autoBean) {
        String root = StringUtil.StringJoin(autoBean.getFactBeanName().toLowerCase(),DOT_VALUE,
                DEFAULT_FILE_JS);
        return root;
    }

    /**
     * 
     * @see cluster.scheme.autocode.AbstractProduced#getFileNameAfter()
     */
    @Override
    public String getFileNameAfter() {
        return "";
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
    
    /**
     * 表格生成
     * @param args
     * @author lffei1
     */
    public String producedSetColModel(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        
        List<AutoAttr> attrs = autoBean.getAutoAttrs();
        for(int i=0 ; i < attrs.size();i++){
            String attrName = attrs.get(i).getAttrName();
            if(attrs.get(i).isPK()){
                sBuffer.append(producedSetSpace());
                sBuffer.append(producedGetColValue1(attrName));
                sBuffer.append(producedPkAttr());
            }else if(i < attrs.size()-1 && (!attrs.get(i).isPK()) ){
                sBuffer.append(producedSetSpace());
                sBuffer.append(producedGetColValue1(attrName));
//                sBuffer.append(producedGetColValue2(attrName));
                sBuffer.append(COMMA_VALUE).append(ENTER_VALUE);
            }else{
                sBuffer.append(producedSetSpace());
                sBuffer.append(producedGetColValue1(attrName));
//                sBuffer.append(producedGetColValue2(attrName));
            }
        }
        
        return sBuffer.toString();
    }
    
    //获取每行值属性1
    public String producedGetColValue1(String attrName){
        StringBuffer sBuffer = new StringBuffer();
        
        sBuffer.append(LEFT_BRACKETS);
        sBuffer.append(DEFAULT_NAME)
           .append("\'").append(attrName).append("\'").append(COMMA_VALUE);
        sBuffer.append(DEFAULT_INDEX)
           .append("\'").append(attrName).append("\'").append(COMMA_VALUE);
        sBuffer.append(DEFAULT_WIDTH).append(WIDTH_VALUE).append(COMMA_VALUE);
        sBuffer.append(DEFAULT_ALIGN)
           .append("\"").append(ALIGN_VALUE).append("\"");
        sBuffer.append(RIGHT_BRACKETS);
        return sBuffer.toString();
    }
    
    //获取每行值属性2
    public String producedGetColValue2(String attrName){
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(TRUE_VALUE).append(COMMA_VALUE);
        sBuffer.append(DEFAULT_EDITRULES).append(COlON_VALUE).append(LEFT_BRACKETS);
        sBuffer.append(DEFAULT_REQUIRED).append(COlON_VALUE).append(TRUE_VALUE);
        sBuffer.append(RIGHT_BRACKETS).append(BANK_VALUE_1).append(RIGHT_BRACKETS);
        
        return sBuffer.toString();
    }
    
    //获取主键
    public String producedPKAttrValue(AutoBean autoBean){
        List<AutoAttr> autoAttrs = autoBean.getAutoAttrs(); 
        for(AutoAttr attr : autoAttrs){
            if(attr.isPK()){
                return String.valueOf(attr.getAttrName() );
               
            }
        }       
        return "";
    }
    
    //设置主键的表单属性
    public String producedPkAttr(){
        StringBuffer sBuffer = new StringBuffer();
        
        sBuffer.append(FALSE_VALUE).append(COMMA_VALUE)
        .append(DEFAULT_KEY).append(TRUE_VALUE).append(BANK_VALUE_1).append(COMMA_VALUE)
        .append(HIDDEN_KEY).append(TRUE_VALUE).append(BANK_VALUE_1)
        .append(RIGHT_BRACKETS).append(COMMA_VALUE).append(ENTER_VALUE);
        
        return sBuffer.toString();
    }
    
    //获取表头
    public String producedGetColName(AutoBean autoBean){
        StringBuffer sBuffer = new StringBuffer();
        
        List<AutoAttr> attrs = autoBean.getAutoAttrs();
        for(int i=0 ; i < attrs.size() ; i++){
           if(i!=attrs.size()-1){
               sBuffer.append("\'").append(attrs.get(i).getAttrDesc())
                   .append("\'").append(COMMA_VALUE);
           }else{
               sBuffer.append("\'").append(attrs.get(i).getAttrDesc())
               .append("\'");
           }
        }
        return sBuffer.toString();
    }
    
    //表标题
    public String producedGetCaption(AutoBean autoBean){
        return autoBean.getModuleDesc();
    }
    
    
    //space
    public String producedSetSpace(){
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4).append(BANK_VALUE_4);
        return sBuffer.toString();
    }
    
    /*public static void main(String[] args){
        AutoBean autoBean = new AutoBean();
        autoBean.setTableName("goodInfo");
        List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
        AutoAttr autoAttr = new AutoAttr();
        autoAttr.setAttrName("goodId");
        autoAttr.setAttrDesc("商品ID");
        autoAttr.setAttrType(AttrType.String);
        autoAttr.setPK(true);
        autoAttrs.add(autoAttr);
        JsPageProduced js = new JsPageProduced();
        System.out.println(js.getFileSrc(autoBean));
    }*/
}
