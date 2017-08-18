package com.marks.module.inner.autocode.core.produced.backstagecode.pojo;

import java.util.ArrayList;
import java.util.List;

import com.marks.module.inner.autocode.core.produced.backstagecode.AbstractCodeProduced;
import com.marks.module.inner.autocode.core.produced.pojo.AttrType;
import com.marks.module.inner.autocode.core.produced.pojo.AutoAttr;
import com.marks.module.inner.autocode.core.produced.pojo.AutoBean;
import com.marks.module.inner.autocode.core.produced.util.StringUtil;

/**
 * 实体处理方案
 * @author ykai5
 *
 */
public class PojoProduced extends AbstractCodeProduced {

	public String getFileNameAfter() {
		return "";
	}

	public String producedPackageUrl(AutoBean autoBean) {
		String packageUrl =  StringUtil.StringJoin( autoBean.getDefaultPackageUrl(),
				autoBean.getFactBeanName().toLowerCase(),DOT_VALUE,autoBean.getDefaultPojo()); 
//		setFileSrc(outFileContent, packageUrl);
		return packageUrl;
	}
	
	@Override
	public String getFileSrc(AutoBean autoBean) {
		return producedPackageUrl(autoBean);
	}

	
	
	/**
	 * 生成field列表
	 * @param autoBean
	 * @return
	 */
	public  String producedFields(AutoBean autoBean){
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		StringBuffer sBuffer = new StringBuffer();
		for(AutoAttr autoAttr:autoAttrs){
			String attrName = autoAttr.getAttrName();
			AttrType type = autoAttr.getAttrType();
			String attrDesc = autoAttr.getAttrDesc();
			sBuffer.append(producedGetAttrDesc(attrDesc,autoAttr.getNote()));
			sBuffer.append(BANK_VALUE_4).append(DEFAULT_PRIVATE).append(BANK_VALUE_1).append(type.getJavaType())
			.append(BANK_VALUE_1).append(attrName).append(SEMI_VALUE);
			sBuffer.append(ENTER_VALUE);
		}
		return sBuffer.toString();
	}
	
	/**
	 * 生产打印日志
	 * producedFieldStr:描述 <br/>
	 *
	 * @param autoBean
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public  String producedFieldStr(AutoBean autoBean){
		List<AutoAttr> autoAttrs = autoBean.getAutoAttrs();
		StringBuffer sBuffer = new StringBuffer();
		for(AutoAttr autoAttr:autoAttrs){
			String attrName = autoAttr.getAttrName();
			sBuffer.append("+\" - "+attrName+":\" +String.valueOf("+String.valueOf(attrName)+")");
		}
		return sBuffer.toString().substring(1);
	}
	
	
	public String producedGetAttrDesc(String attrDesc,String note){
	    StringBuffer sBuffer = new StringBuffer();
	    sBuffer.append(BANK_VALUE_4).append(DESC_1).append(ENTER_VALUE);
	    sBuffer.append(BANK_VALUE_4).append(DESC_2).append(attrDesc).append(ENTER_VALUE);
	    sBuffer.append(BANK_VALUE_4).append(DESC_2).append(note==null?"":note).append(ENTER_VALUE);
	    sBuffer.append(BANK_VALUE_4).append(DESC_3).append(ENTER_VALUE);
	    return sBuffer.toString();
	}
	/**
	 * 生成getset方法列表
	 * @param autoBean
	 * @return
	 */
	public  String producedGetSetMethod(AutoBean autoBean){
		StringBuffer sBuffer = new StringBuffer();
		for(AutoAttr autoAttr:autoBean.getAutoAttrs()){
			String attrName = autoAttr.getAttrName();
			AttrType type = autoAttr.getAttrType();
			sBuffer.append(ENTER_VALUE);
			sBuffer.append(groupGetMethod(type, attrName));
			sBuffer.append(groupSetMethod(type, attrName));
		}
		
		return sBuffer.toString();
	}
	
	/**
	 * getter()生成
	 * @param type
	 * @param attrName
	 * @return String
	 */
	public StringBuffer groupGetMethod(AttrType type,String attrName){
		StringBuffer sBuffer = new StringBuffer();
		    sBuffer.append(BANK_VALUE_4).append(DEFAULT_PUBLIC).append(BANK_VALUE_1)
		        .append(type.getJavaType())
		        .append(BANK_VALUE_1).append(DEFAULT_GET)
                .append(StringUtil.getUpperCaseChar(attrName) )
                .append(LEFT_PATEN).append(RIGHT_PATEN).append(LEFT_BRACKETS);
            sBuffer.append(ENTER_VALUE);
            sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(RETURN_VALUE).append(BANK_VALUE_1)
                .append(attrName)
                .append(SEMI_VALUE);
            sBuffer.append(ENTER_VALUE).append(BANK_VALUE_4).append(RIGHT_BRACKETS);
            sBuffer.append(ENTER_VALUE);
		return sBuffer;
	}
	
	/**
	 * setter()生成
	 */
	public StringBuffer groupSetMethod(AttrType type,String attrName){
		StringBuffer sBuffer = new StringBuffer();
		
		 sBuffer.append(BANK_VALUE_4).append(DEFAULT_PUBLIC).append(BANK_VALUE_1).append(VOID_VALUE).append(BANK_VALUE_1).append(DEFAULT_SET).
	        append(StringUtil.getUpperCaseChar(attrName) )
	            .append(LEFT_PATEN).append(type.getJavaType()).append(BANK_VALUE_1).append(attrName)
	            .append(RIGHT_PATEN).append(LEFT_BRACKETS);
	        sBuffer.append(ENTER_VALUE);
	        sBuffer.append(BANK_VALUE_4).append(BANK_VALUE_4).append(THIS_VALUE)
	           .append(attrName)
	           .append(BANK_VALUE_1).append(EQUAL_VALUE).append(BANK_VALUE_1)
	           .append(attrName)
	           .append(SEMI_VALUE);
	        sBuffer.append(ENTER_VALUE).append(BANK_VALUE_4).append(RIGHT_BRACKETS);
	        sBuffer.append(ENTER_VALUE);
		return sBuffer;
	}
	
	public void testFields(){
	    AutoBean autoBean = new AutoBean();
        List<AutoAttr> autoAttrs = new ArrayList<AutoAttr>();
        AutoAttr autoAttr = new AutoAttr();
        AutoAttr autoAttr1 = new AutoAttr();
        autoAttr.setAttrName("goodId");
        autoAttr.setAttrType(AttrType.Integer);
        autoAttr1.setAttrName("goodName");
        autoAttr1.setAttrType(AttrType.String);
        autoAttrs.add(autoAttr);
        autoAttrs.add(autoAttr1);
        autoBean.setAutoAttrs(autoAttrs);
        String fields = new PojoProduced().producedFields(autoBean);
        System.out.println(fields);
	}
	
	public static void main(String[] args) {
		new PojoProduced().testFields();
	}
	
}
