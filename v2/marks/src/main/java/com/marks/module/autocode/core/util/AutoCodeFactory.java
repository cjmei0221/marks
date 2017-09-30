package com.marks.module.autocode.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.marks.module.autocode.core.produced.DBProduced;
import com.marks.module.autocode.core.produced.ModuleProduced;
import com.marks.module.autocode.core.produced.annotation.TableField;
import com.marks.module.autocode.core.produced.annotation.TableName;
import com.marks.module.autocode.core.produced.config.AutoConfig;
import com.marks.module.autocode.core.produced.extern.ExternAutoCode;
import com.marks.module.autocode.core.produced.factory.DefaultExternAutoBeanFactory;
import com.marks.module.autocode.core.produced.pojo.AutoAttr;
import com.marks.module.autocode.core.produced.pojo.AutoBean;
import com.marks.module.autocode.core.produced.table.MySqlTableProduced;
import com.marks.module.autocode.core.produced.table.OracleTableProduced;
import com.marks.module.autocode.core.produced.util.StringUtils;
import com.marks.module.autocode.core.test.TestCode;

public class AutoCodeFactory {
	private static Logger logger = Logger.getLogger(AutoCodeFactory.class);
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

	public void autoCodeOneFile(AutoBean autoBean, ModuleProduced moduleProduced) {
		ExternAutoCode autoCode = new DefaultExternAutoBeanFactory().externAutoCodeBean();
		autoCode.autoProducedCode(autoBean, moduleProduced, true);
	}

	public void createTable(AutoBean autoBean) {
		String dialect = AutoConfig.jdbc_password;
		if ("oracle".equals(dialect)) {
			try {

				DBProduced oracleutil = new OracleTableProduced();
				logger.info(oracleutil.createTableSql(autoBean));
				oracleutil.createTable(autoBean);
			} catch (Exception e) {

			}
		} else {
			try {
				DBProduced dbutil = new MySqlTableProduced();
				dbutil.createTable(autoBean);
			} catch (Exception e) {

			}
		}

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
	 * @param isAuth
	 *            是否授权
	 * @param is_createtable
	 *            是否创建
	 * @param class1
	 * @author marks
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
