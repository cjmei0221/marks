package com.cjmei.module.system.autocode.code;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cjmei.module.system.autocode.DBProduced;
import com.cjmei.module.system.autocode.code.util.TableField;
import com.cjmei.module.system.autocode.code.util.TableName;
import com.cjmei.module.system.autocode.extern.ExternAutoCode;
import com.cjmei.module.system.autocode.factory.DefaultExternAutoBeanFactory;
import com.cjmei.module.system.autocode.pojo.AttrType;
import com.cjmei.module.system.autocode.pojo.AutoAttr;
import com.cjmei.module.system.autocode.pojo.AutoBean;
import com.cjmei.module.system.autocode.table.MySqlTableProduced;

public class AutoCodeFactory {

	private static AutoCodeFactory util = null;

	public AutoCodeFactory() {
	}

	public static AutoCodeFactory getInstance() {
		if (util == null) {
			util = new AutoCodeFactory();
		}
		return util;
	}

	public void autoCode(AutoBean autoBean) {
		ExternAutoCode autoCode = new DefaultExternAutoBeanFactory().externAutoCodeBean();
		autoCode.autoProducedCode(autoBean, true);
	}

	public void createTable(AutoBean autoBean) {
		DBProduced dbutil = new MySqlTableProduced();
		dbutil.createTable(autoBean);
	}

	public void autoCodeByEntity(boolean is_createtable, Class<?> class1) {
		AutoBean autoBean = new AutoBean();
		TableName tableName = class1.getAnnotation(TableName.class);
		if(tableName==null){
			autoBean.setTableName(class1.getSimpleName().toLowerCase());
			autoBean.setBeanName(class1.getSimpleName().toLowerCase());
			autoBean.setModuleDesc(class1.getSimpleName().toLowerCase());
		}else{
			String tn=StringUtils.isNotEmpty(tableName.value())?tableName.value():class1.getSimpleName();
			autoBean.setTableName(tn.toLowerCase());
			autoBean.setBeanName(class1.getSimpleName().toLowerCase());
			autoBean.setModuleDesc(tableName.desc()==""?autoBean.getBeanName():tableName.desc());
		}
		List<AutoAttr> attrlist = new ArrayList<AutoAttr>();
		AutoAttr attr = null;
		List<Field> list = getAllFields(class1);
		boolean isPk=false;
		for (Field field : list) {
			attr = new AutoAttr();
			/* 获取注解属性，自定义字段 */
			TableField tableField = field.getAnnotation(TableField.class);
			if (tableField != null) {
				String columnName = field.getName();
				if (StringUtils.isNotEmpty(tableField.value())) {
					columnName = tableField.value();
				}
				attr.setAttrDesc(tableField.desc()==""?columnName:tableField.desc());
				attr.setAttrName(columnName);
				attr.setAttrSize(tableField.size());
				attr.setAttrType(tableField.dataType());
				attr.setPK(tableField.ispk());
				if(tableField.ispk()){
					isPk=true;
				}
				attr.setSeq("");
				attrlist.add(attr);
				continue;
			}else{
				String columnName = field.getName();
				System.out.println("columnName>"+columnName);
				attr.setAttrDesc(columnName);
				attr.setAttrName(columnName);
				attr.setAttrSize(256);
				attr.setAttrType(AttrType.getAttrTypeByString(field.getType().getSimpleName()));
				System.out.println("AttrType>"+attr.getAttrType().toString());
				attr.setPK(false);
				attr.setSeq("");
				attrlist.add(attr);
				continue;
			}
		}
		if(attrlist.size()>0){
			//若无主键，则设置第一个字段为主键
			System.out.println("isPk>"+isPk);
			if(!isPk){
				attrlist.get(0).setPK(true);
			}
			autoBean.setAutoAttrs(attrlist);
			this.autoCode(autoBean);
			if(is_createtable){
				this.createTable(autoBean);
			}
		}
		
	}

	/**
	 * 获取该类的所有属性列表
	 * 
	 * @param clazz
	 *            反射类
	 * @return
	 */
	private static List<Field> getAllFields(Class<?> clazz) {
		List<Field> result = new LinkedList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {

			/* 过滤 transient关键字修饰的属性 */
			if (Modifier.isTransient(field.getModifiers())) {
				continue;
			}

			/* 过滤注解非表字段属性 */
			TableField tableField = field.getAnnotation(TableField.class);
			if (tableField == null || tableField.exist()) {
				result.add(field);
			}
		}

		/* 处理父类字段 */
		Class<?> superClass = clazz.getSuperclass();
		if (superClass.equals(Object.class)) {
			return result;
		}
		result.addAll(getAllFields(superClass));
		return result;
	}
}
