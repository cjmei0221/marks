package com.marks.common.util.string;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class IStringUtil {

	// 判断字符是否为空
	public static boolean isEmpty(String source) { // 判断字符是否为null
		if (source == null || source.isEmpty() || "".equals(source.trim())) {
			return true;
		} else {
			return false;
		}
	}

	// 判断字符是否为空
	public static boolean isNotEmpty(String source) { // 判断字符是否为null
		if (source == null || source.isEmpty() || "".equals(source.trim())) {
			return false;
		} else {
			return true;
		}
	}

	public static String objectToString(Object object) {
		return String.valueOf(object);
	}

	public static BigDecimal Object2BigDecimal(Object object) {
		if (object != null && isNumberic(object.toString())) {
			return new BigDecimal(object.toString());
		} else {
			return BigDecimal.ZERO;
		}
	}

	// 去除字符前面的0
	public static String replaceFirstZero(String orgStr) {
		return orgStr.replaceFirst("^0*", "");
	}

	// 去除字符后面的0
	public static String replaceLastZero(String orgStr) {
		return orgStr.replaceFirst("0*$", "");
	}

	// 去除字符前面的空格
	public static String replaceFirstEmptyStr(String orgStr) {
		return orgStr.replaceFirst("^ *", "");
	}

	// 去除字符后面的空格
	public static String replaceLastEmptyStr(String orgStr) {
		return orgStr.replaceFirst(" *$", "");
	}

	// 根据原始字符串和字符位数，不足位向后补空格。
	public static String getLastEmptyStr(String orgStr, Integer length) {
		String emptyStr = "                                                                                                    ";// 定义一个100长度的空字符串
		Integer diffLen = length - orgStr.length();
		if (diffLen > 0) {
			if (diffLen > 100) {
				int loop = diffLen / 100;
				int size = diffLen % 100;
				for (int i = 0; i < loop; i++) {
					orgStr = orgStr + emptyStr;
				}
				orgStr = orgStr + emptyStr.substring(0, size);
			} else {
				orgStr = orgStr + emptyStr.substring(0, diffLen);
			}
		}
		return orgStr;
	}

	// 根据原始字符串和字符位数，不足位向前补空格。
	public static String getFirstEmptyStr(String orgStr, Integer length) {
		String emptyStr = "                                                                                                    ";// 定义一个100长度的空字符串
		Integer diffLen = length - orgStr.length();
		if (diffLen > 0) {
			if (diffLen > 100) {
				int loop = diffLen / 100;
				int size = diffLen % 100;
				for (int i = 0; i < loop; i++) {
					orgStr = emptyStr + orgStr;
				}
				orgStr = emptyStr.substring(0, size) + orgStr;
			} else {
				orgStr = emptyStr.substring(0, diffLen) + orgStr;
			}
		}
		return orgStr;
	}

	// 判断字符串是否是数字格式。
	public static boolean isNumberic(String source) {
		if (isEmpty(source)) {
			return false;
		}
		return source.matches("^-?[0-9]+.?[0-9]*$");
	}

	// 判断字符是否是Double类型格式。
	public static boolean isDouble(String source) {
		if (isEmpty(source)) {
			return false;
		}
		return source.matches("^-?([0-9]+.?)?[0-9]+$");
	}

	/**** 将乱码格式转为UTF-8的编码字符显示 ****/
	public static String getUTF8(String str) {
		str = str + "";
		try {
			if (str.equals(new String(str.getBytes("iso8859-1"), "iso8859-1"))) {
				str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return str;
	}

	// 判断是否是邮件格式。
	public static boolean isEmail(String source) {
		if (isEmpty(source)) {
			return false;
		}
		return source.matches("^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
	}

	// 判断是否是手机格式
	public static boolean isMobile(String source) {
		if (isEmpty(source)) {
			return false;
		}
		if (source.length() != 11) {
			return false;
		}
		if (!isNumberic(source)) {
			return false;
		}
		if (!(source.startsWith("13") || source.startsWith("15") || source.startsWith("16") || source.startsWith("18")
				|| source.startsWith("147"))) {
			return false;
		}
		return true;
	}

}
