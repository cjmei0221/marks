package com.marks.common.util.map;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.marks.common.util.string.IStringUtil;
import com.marks.module.autocode.web.pojo.AutoCodeAttr;
import com.marks.module.core.controller.SupportContorller;

public class MapToObjUtil {
	private static MapToObjUtil util = null;

	public static MapToObjUtil getInstance() {
		if (util == null) {
			util = new MapToObjUtil();
		}
		return util;
	}

	private MapToObjUtil() {
	}
	private static Logger logger = Logger.getLogger(MapToObjUtil.class);

	public <T> T getModel(Class<T> t, Map<String, String> map) {
		Map<String, String> paramMap = map;
		Iterator<String> iter = paramMap.keySet().iterator();
		T object = null;
		try {
			object = t.newInstance();
			// Field[] fields = object.getClass().getDeclaredFields();
			List<Field> fields = SupportContorller.getClassFields(t, true);
			while (iter.hasNext()) {
				Method getMethod;
				String key = iter.next();
				String param = key;
				Field field = isExistField(fields, param);
				if (field == null)
					continue;
				// Field field = object.getClass().getDeclaredField(param);
				field.setAccessible(true);
				String value = paramMap.get(key);

				if (value == null || value.equals(""))
					continue;
				value = IStringUtil.getUTF8(value);
				getMethod = object.getClass().getMethod("get" + SupportContorller.toUpperFirst(param));
				Class c = getMethod.getReturnType();
				Method method = object.getClass().getMethod("set" + SupportContorller.toUpperFirst(param), c);
				if (c.getName().indexOf("int") >= 0 || c.getName().indexOf("Integer") >= 0) {
					method.invoke(object, Integer.parseInt(value));
					continue;
				}

				if (c.getName().indexOf("Date") >= 0) {
					String format = "yyyy-MM-dd";
					if (value.indexOf(":") > 0) {
						format = "yyyy-MM-dd HH:mm:ss";
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
					String format = "yyyy-MM-dd";
					if (value.indexOf(":") > 0) {
						format = "yyyy-MM-dd HH:mm:ss";
					}
					SimpleDateFormat dateformat = new SimpleDateFormat(format);
					dateformat.parse(value);
					Timestamp time = new Timestamp(dateformat.parse(value).getTime());
					method.invoke(object, time);
					continue;
				}
				method.invoke(object, value);

			}
		} catch (Exception e) {
			logger.error("MapToObjUtil", e);
			throw new RuntimeException();
		}
		return object;
	}

	public Field isExistField(List<Field> fields, String param) {
		for (Field field : fields) {
			if (field.getName().equals(param))
				return field;
		}
		return null;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("attrName", "test");
		map.put("isPK", "1");
		map.put("isQuery", "YES");
		AutoCodeAttr a = MapToObjUtil.getInstance().getModel(AutoCodeAttr.class, map);
		System.out.println(a);
		System.out.println(a.getIsPK());
	}
}
