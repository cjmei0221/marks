package com.marks.module.sys.filter;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * <p class="detail">
 * 功能：封装的请求处理特殊字符
 * </p>
 * 
 * @ClassName: TsRequest
 * @version V1.0
 * @date 2014年9月25日
 * @author wangsheng
 */
public class TsRequest extends HttpServletRequestWrapper {
	private Map params;

	public TsRequest(HttpServletRequest request, Map newParams) {
		super(request);
		this.params = newParams;
	}

	public Map getParameterMap() {
		return params;
	}

	public Enumeration getParameterNames() {
		Vector l = new Vector(params.keySet());
		return l.elements();
	}

	public String[] getParameterValues(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] value = (String[]) v;
			filerParams(value);
			return (String[]) value;
		} else if (v instanceof String) {
			String value = (String) v;
			filerParams(new String[]{value});
			return new String[] { (String) value };
		} else {
			return new String[] { v.toString() };
		}
	}

	public String getParameter(String name) {
		Object v = params.get(name);
		if (v == null) {
			return null;
		} else if (v instanceof String[]) {
			String[] strArr = (String[]) v;
			if (strArr.length > 0) {
				filerParams(strArr);
				String value = strArr[0];
				return value;
			} else {
				return null;
			}
		} else if (v instanceof String) {
			String value = (String) v;
			filerParams(new String[]{value});
			return (String) value;
		} else {
			return v.toString();
		}
	}

	public static void filerParams(String[] params) {
		if (params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				params[i] = params[i].replaceAll("<", "&lt;");
				params[i] = params[i].replaceAll(">", "&gt;");
			}
		}
	}
}
