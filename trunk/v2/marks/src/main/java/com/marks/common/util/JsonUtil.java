package com.marks.common.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.marks.common.annotation.JsonObject;
import com.marks.common.annotation.JsonObjectProperty;
import com.marks.common.annotation.JsonProperty;
import com.marks.common.domain.Result;
import com.marks.module.core.data.StaticData;

/**
 * json工具类
 * @author lzjie
 */
public class JsonUtil {
	
	protected static void obj2json(String name,JSONObject json,Object obj) throws JSONException{
		//log.info("转化对象obj2json[" + obj + "]");
		if (json != null && !StringUtils.isBlank(name)){
			
			if (obj != null && obj instanceof Collection){
				obj = ((Collection)obj).toArray();
			}
			
			if (obj == null){
				json.put(name, "");
			}
			else if(obj instanceof Number){
				json.put(name, obj);
			}
			else if(obj.getClass().isPrimitive()||obj.getClass().getName().startsWith("java.lang.")){
				json.put(name, obj.toString());
			}
			else if(obj instanceof Date){
				Date date = (Date)obj;
				SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				json.put(name, SIMPLE_DATE_FORMAT.format(date));
			}
			else if (obj instanceof Map){
				JSONObject  o = new JSONObject();
				Map map = (Map)obj;
				Iterator it = map.keySet().iterator();
				while(it.hasNext()){
					Object key = it.next();
					Object v = map.get(key);
					if (key != null){
						obj2json(key.toString(),o,v);						
					}
				}
				json.put(name, o);
			}
			else if (obj instanceof Object[]){
				JSONArray jsonArray = new JSONArray();
				Object []array = (Object[])obj;
				int len = array.length;
				for(int i = 0 ; i < len ; i++){
					Object o = array[i];					
					if (o == null){
						
					}
					else if(o instanceof Number){
						jsonArray.put(obj);
					}
					else if (o instanceof String){
						jsonArray.put((String)o);
					}
					else if(o.getClass().isPrimitive() || o.getClass().getName().startsWith("java.lang.")){
						jsonArray.put(obj.toString());
					}
					else if(o instanceof Date){
						Date date = (Date)o;
						SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						jsonArray.put(SIMPLE_DATE_FORMAT.format(date));
					}
					else{
						JSONObject j = new JSONObject();
						customObject2json(j,o);
						jsonArray.put(j);
					}
				}
				json.put(name, jsonArray);
			}
			else{
				JSONObject jsonObject = new JSONObject();
				customObject2json(jsonObject,obj);
				json.put(name, jsonObject);
			}
		}
	}
	
	/**
	 * 自定义对象转化为json
	 * @param json
	 * @param obj
	 */
	protected static void customObject2json(JSONObject json,Object obj) throws JSONException{
		
		boolean isAnnotation  = obj.getClass().isAnnotationPresent(JsonObject.class);
		Method methods[] = obj.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (isAnnotation && !(methods[i].isAnnotationPresent(JsonProperty.class) 
									|| methods[i].isAnnotationPresent(JsonObjectProperty.class))){
				continue;
			}
				
			String methodName = methods[i].getName();
			if (methodName.startsWith("get") && !"getClass".equals(methodName)) {
				
				String fieldName = null;
				Object value = null;
				try {
					value = methods[i].invoke(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (isAnnotation){
					if (methods[i].isAnnotationPresent(JsonProperty.class)){
						JsonProperty jp = methods[i].getAnnotation(JsonProperty.class);
						fieldName = jp.name();
						obj2json(fieldName,json,value);
					}
					else{
						if (value != null){
							if (value instanceof Map){
								Map map = (Map)value;
								Iterator it = map.entrySet().iterator();
								while(it.hasNext()){
									Entry en = (Entry)it.next();
									Object key = en.getKey();
									Object v = en.getValue();
									if (key instanceof String){
										obj2json((String)key,json,v);
									}
								}
							}
							else if (value instanceof Collection){
								Collection col = (Collection)value;
								Iterator it = col.iterator();
								while(it.hasNext()){
									Object v = it.next();
									customObject2json(json,v);
								}
							}
						}
					}
				}
				else{
					fieldName = parseFieldName(methodName);
					obj2json(fieldName,json,value);
				}
			}
		}
	}
	
	
	public static String object2json(Result obj){
		JSONObject json = new JSONObject();
		try {
			customObject2json(json,obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public static void output(HttpServletResponse response,Result rtn){
		try {
			String json = object2json(rtn);
			if("Y".equals(StaticData.getSysConf("out_log_flag"))){
				log.info("回应数据[" + json + "]");
			}
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void output(HttpServletResponse response,String json){
		try {
			if("Y".equals(StaticData.getSysConf("out_log_flag"))){
				log.info("回应数据[" + json + "]");
			}
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 取得分页大小
	 * @param json
	 * @return
	 */
	public static int getPageSize(JSONObject json){
		if (json == null){
			return 20;
		}
		else{
			try {
				return json.getInt("page_size");
			} catch (JSONException e) {
				return 20;
			}
		}
	}
	
	/***
	 * 取得分页的页号
	 * @param json
	 * @return
	 * @throws JSONException
	 */
	public static int getPageNumber(JSONObject json){
		if (json == null){
			return 1;
		}
		else{
			try{
				return json.getInt("page_number");
			}
			catch(JSONException ex){
				return 1;
			}
		}
	}
	
	// 根据方法名转json
	private static String parseFieldName(String method) {
		String field = method.trim().substring(3);
		if (field.equals(field.toUpperCase()))
			return field;
		else
			return (new StringBuilder(String.valueOf(field.substring(0, 1).toLowerCase()))).append(field.substring(1))
					.toString();
	}
	
	private static final Map<String,String> replaceMap = new HashMap<String,String>();
	
	static{
		replaceMap.put("\r", "\\r");
		replaceMap.put("\n", "\\n");
		replaceMap.put("\"", "\\\"");
		replaceMap.put("/", "\\/");
		replaceMap.put("\b", "\\b");
		replaceMap.put("\f", "\\f");
		replaceMap.put("\t", "\\t");
		replaceMap.put("\\", "\\\\");
		replaceMap.put("\"", "\\\"");
	}
	
	public static boolean isRetSuccess(String result) throws JSONException{
		JSONObject json=new JSONObject(result);
		if(json.optInt("retcode", 0)==0)
			return true;
		return false;
	}
	
	protected static Logger log = Logger.getLogger(JsonUtil.class);
}
