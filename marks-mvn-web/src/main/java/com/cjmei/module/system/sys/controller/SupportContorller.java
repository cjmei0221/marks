package com.cjmei.module.system.sys.controller;

/**   
 * 文件名：SupportContorller.java</br>
 * 描述： </br>
 * 开发人员：杨凯 </br>
 * 创建时间： 2016-6-2
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名: SupportContorller</br>
 * 包名：module.base.control </br>
 * 描述: </br>
 * 发布版本号：</br>
 * 开发人员： 杨凯</br>
 * 创建时间： 2016-6-2
 */

public abstract class SupportContorller {

	private static Logger logger = Logger.getLogger(SupportContorller.class);

	@Autowired
	private HttpServletRequest request;

	public abstract Logger getLogger();

	public <T> T getModel(Class<T> t) {
		return getModel(t, "");
	}

	public Logger getFactLogger() {
		return getLogger() == null ? logger : getLogger();
	}

	/**
	 * 
	 * 方法名: getModel</br>
	 * 详述: 属性自动装配 开发人员：杨凯 </br>
	 * 创建时间：2016-6-2</br>
	 * 
	 * @param object
	 *            : 反射对象
	 * @param modelName
	 *            页面参数对象
	 * @return
	 */
	public <T> T getModel(Class<T> t, String modelName) {
		Map<String, String[]> paramMap = request.getParameterMap();
		Iterator<String> iter = paramMap.keySet().iterator();
		T object = null;
		try {
			object = t.newInstance();
			// Field[] fields = object.getClass().getDeclaredFields();
			List<Field> fields = getClassFields(t, true);
			while (iter.hasNext()) {
				Method getMethod;
				String key = iter.next();
				String param = key.replace(modelName, "");
				Field field = isExistField(fields, param);
				if (field == null)
					continue;
				// Field field = object.getClass().getDeclaredField(param);
				field.setAccessible(true);
				String value = paramMap.get(key)[0];
				value = convert(value);
				if (value == null || value.equals(""))
					continue;
				getMethod = object.getClass().getMethod("get" + toUpperFirst(param));
				Class c = getMethod.getReturnType();
				Method method = object.getClass().getMethod("set" + toUpperFirst(param), c);
				if (c.getName().indexOf("int") >= 0 || c.getName().indexOf("Integer") >= 0) {
					method.invoke(object, Integer.parseInt(value));
					continue;
				} 
				
				if (c.getName().indexOf("Date") >= 0) {
					String format="yyyy-MM-dd";
					if(value.indexOf(":")>0){
						format="yyyy-MM-dd HH:mm:ss";
					}
					SimpleDateFormat dateformat = new SimpleDateFormat(format);
					
					method.invoke(object, dateformat.parse(value));
					continue;
				} 
				
				if (c.getName().indexOf("double") >= 0 || c.getName().indexOf("Double") >= 0) {
					method.invoke(object, Double.parseDouble(value));
					continue;
				}
				if (c.getName().indexOf("Long") >= 0 || c.getName().indexOf("long") >= 0) {
					method.invoke(object, Long.parseLong(value));
					continue;
				} 
				if (c.getName().indexOf("Timestamp") >= 0) {
					String format="yyyy-MM-dd";
					if(value.indexOf(":")>0){
						format="yyyy-MM-dd HH:mm:ss";
					}
					SimpleDateFormat dateformat = new SimpleDateFormat(format);
					dateformat.parse(value);
					Timestamp time=new Timestamp(dateformat.parse(value).getTime());
					method.invoke(object, time);
					continue;
				} 
				method.invoke(object, value);
				
			}
		} catch (Exception e) {
			getFactLogger().info(e);
			throw new RuntimeException();
		}
		return object;
	}

	/**
	 *  * 获取类实例的属性值  * @param clazz类名  * @param includeParentClass是否包括父类的属性值
	 *  * @return 类名.属性名=属性类型  
	 */

	public static List<Field> getClassFields(Class clazz, boolean includeParentClass) {
		List<Field> fieldList = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			fieldList.add(field);
		}
		if (includeParentClass)
			getParentClassFields(fieldList, clazz.getSuperclass());
		return fieldList;
	}

	/**
	 *  * 获取类实例的父类的属性值  * @param map 类实例的属性值Map  * @param clazz 类名  * @return
	 * 类名.属性名=属性类型  
	 */

	private static List<Field> getParentClassFields(List<Field> fieldList, Class clazz) {

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			fieldList.add(field);
		}
		if (clazz.getSuperclass() == null) {
			return fieldList;
		}
		getParentClassFields(fieldList, clazz.getSuperclass());
		return fieldList;
	}

	public Field isExistField(List<Field> fields, String param) {
		for (Field field : fields) {
			if (field.getName().equals(param))
				return field;
		}
		return null;
	}

	// 第一个字母大写
	public static String toUpperFirst(String str) {
		if (str != null && str != "") {
			str = str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		return str;
	}

	/**
	 * 
	 * 方法名: 复制属性处理</br>
	 * 详述: </br>
	 * 开发人员：杨凯</br>
	 * 创建时间：2014-8-8</br>
	 * 
	 * @param objDest
	 *            ,源对象
	 * @param returnObj
	 *            ,返回对象
	 * @param filterType
	 *            ,过滤类型,规则如:String,Set
	 * @param filterCode
	 *            ,过滤的字段名
	 * @return
	 */
	public Object copyAttr(Object objDest, Object returnObj, List<String> filterType, String... filterCode) {
		for (Field f : objDest.getClass().getDeclaredFields()) {
			try {
				boolean typeboo = true;
				boolean codeboo = true;
				if (filterType != null) {
					for (String type : filterType) {
						if (f.getClass().getName().indexOf(type) >= 0) {
							typeboo = false;
						}
					}
				}
				if (filterCode != null) {
					for (String code : filterCode) {
						if (f.getName().equals(code)) {
							codeboo = false;
						}
					}
				}
				if (codeboo && typeboo) {
					Method getMethod = objDest.getClass().getMethod("get" + toUpperFirst(f.getName()));
					Object objValue = getMethod.invoke(objDest);
					String returnType = getMethod.getReturnType().getName();
					Class c = "int".equals(returnType) ? int.class : Class.forName(returnType);
					Method setMethod = returnObj.getClass().getMethod("set" + toUpperFirst(f.getName()),
							getMethod.getReturnType());
					setMethod.invoke(returnObj, objValue);
				}
			} catch (IllegalArgumentException e) {
				getFactLogger().info("", e);
			} catch (SecurityException e) {
				getFactLogger().info("", e);
			} catch (IllegalAccessException e) {
				getFactLogger().info("", e);
			} catch (NoSuchMethodException e) {
				getFactLogger().info("", e);
			} catch (InvocationTargetException e) {
				getFactLogger().info("", e);
			} catch (ClassNotFoundException e) {
				getFactLogger().info("", e);
			}
		}
		return returnObj;
	}

	public String convert(String value) {
		return value.replaceAll("\r\n", "<br/>").replaceAll("\n", "<br/>");
		//return value;
	}
}
