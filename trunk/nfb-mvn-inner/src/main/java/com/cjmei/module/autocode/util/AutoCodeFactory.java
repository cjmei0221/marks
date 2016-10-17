package com.cjmei.module.autocode.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cjmei.module.autocode.core.DBProduced;
import com.cjmei.module.autocode.core.code.StringUtils;
import com.cjmei.module.autocode.core.code.util.TableField;
import com.cjmei.module.autocode.core.code.util.TableName;
import com.cjmei.module.autocode.core.config.AutoConfig;
import com.cjmei.module.autocode.core.extern.ExternAutoCode;
import com.cjmei.module.autocode.core.factory.DefaultExternAutoBeanFactory;
import com.cjmei.module.autocode.core.pojo.AutoAttr;
import com.cjmei.module.autocode.core.pojo.AutoBean;
import com.cjmei.module.autocode.core.table.OracleTableProduced;
import com.cjmei.module.autocode.core.webpage.html.htmlpage.HtmlPageProduced;
import com.cjmei.module.autocode.test.TestCode;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.service.SysMenuService;
import com.cjmei.module.system.sys.service.SysRoleService;

public class AutoCodeFactory {
	
	private static AutoCodeFactory util = null;

	private AutoCodeFactory() {
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
		try {
			
			DBProduced oracleutil = new OracleTableProduced();
			System.out.println(oracleutil.createTableSql(autoBean));
			oracleutil.createTable(autoBean);
		} catch (Exception e) {

		}

		/*
		 * try { DBProduced dbutil = new MySqlTableProduced();
		 * dbutil.createTable(autoBean); } catch (Exception e) {
		 * 
		 * }
		 */

	}

	public AutoBean getAutoBeanByEntity(Class<?> class1) {
		AutoBean autoBean = new AutoBean();
		TableName tableName = class1.getAnnotation(TableName.class);
		if (tableName == null) {
			autoBean.setTableName(class1.getSimpleName().toUpperCase());
			autoBean.setBeanName(class1.getSimpleName().toLowerCase());
			autoBean.setModuleDesc(class1.getSimpleName());
		} else {
			String tn = StringUtils.isNotEmpty(tableName.value()) ? tableName.value() : class1.getSimpleName();
			autoBean.setTableName(tn.toUpperCase());
			autoBean.setBeanName(class1.getSimpleName());
			autoBean.setModuleDesc(tableName.desc() == "" ? autoBean.getBeanName() : tableName.desc());
		}
		List<AutoAttr> attrlist = new ArrayList<AutoAttr>();
		AutoAttr attr = null;
		List<Field> list = getAllFields(class1);
		boolean isPk = false;
		for (Field field : list) {
			attr = new AutoAttr();
			/* 获取注解属性，自定义字段 */
			TableField tableField = field.getAnnotation(TableField.class);
			if (tableField != null) {
				String columnName = field.getName();
				if (StringUtils.isNotEmpty(tableField.value())) {
					columnName = tableField.value();
				}
				attr.setAttrDesc(tableField.desc() == "" ? columnName : tableField.desc());
				attr.setAttrName(columnName);
				attr.setAttrSize(tableField.size());
				attr.setAttrType(tableField.dataType());
				attr.setPK(tableField.ispk());
				if (tableField.ispk()) {
					isPk = true;
				}
				attr.setSeq("");
				attrlist.add(attr);
				continue;
			} /*
				 * else { String columnName = field.getName();
				 * attr.setAttrDesc(columnName); attr.setAttrName(columnName);
				 * attr.setAttrSize(256);
				 * attr.setAttrType(AttrType.getAttrTypeByString(field.getType()
				 * .getSimpleName())); attr.setPK(false); attr.setSeq("");
				 * attrlist.add(attr); continue; }
				 */
		}
		if (attrlist.size() > 0) {
			// 若无主键，则设置第一个字段为主键
			if (!isPk) {
				attrlist.get(0).setPK(true);
			}
			autoBean.setAutoAttrs(attrlist);
			return autoBean;
		}
		return null;
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

	/**
	 * 
	 * autoCodeByEntity:描述 <br/>
	 *
	 * @param isAuth 是否授权
	 * @param is_createtable 是否创建
	 * @param class1
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public void autoCodeByEntity(boolean is_createtable, Class<?> class1) {
		AutoBean autoBean = getAutoBeanByEntity(class1);
		if (autoBean != null) {
			this.autoCode(autoBean);
			if (is_createtable) {
				this.createTable(autoBean);
			}
			
		}
	}

	
	public static void main(String[] args) {
		OracleTableProduced oracleTableProduced = new OracleTableProduced();
		System.out.println(
				oracleTableProduced.createTableSql(AutoCodeFactory.getInstance().getAutoBeanByEntity(TestCode.class)));
	}
}
