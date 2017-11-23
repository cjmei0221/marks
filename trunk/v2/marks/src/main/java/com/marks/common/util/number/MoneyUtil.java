package com.marks.common.util.number;

import java.math.BigDecimal;

public class MoneyUtil {
	/**
	 * 加法
	 * 
	 * @param oriValue
	 * @param addValue
	 * @return
	 */
	public static String add(String oriValue, String addValue) {
		if (null == oriValue || "".equals(oriValue)) {
			oriValue = "0.00";
		}
		if (null == addValue || "".equals(addValue)) {
			addValue = "0.00";
		}
		BigDecimal bigDecimal = new BigDecimal(oriValue);
		BigDecimal bigDecimal2 = new BigDecimal(addValue);
		BigDecimal bigDecimalAdd = bigDecimal.add(bigDecimal2);
		return bigDecimalAdd.toString();
	}

	/**
	 * 减法
	 * 
	 * @param oriValue
	 * @param addValue
	 * @return
	 */
	public static String subtract(String oriValue, String addValue) {
		if (null == oriValue || "".equals(oriValue)) {
			oriValue = "0.00";
		}
		if (null == addValue || "".equals(addValue)) {
			addValue = "0.00";
		}
		BigDecimal bigDecimal = new BigDecimal(oriValue);
		BigDecimal bigDecimal2 = new BigDecimal(addValue);
		// 减法
		BigDecimal bigDecimalSubtract = bigDecimal.subtract(bigDecimal2);
		return bigDecimalSubtract.toString();
	}

	/**
	 * 乘法
	 * 
	 * @param oriValue
	 * @param addValue
	 * @return
	 */
	public static String multiply(String oriValue, String addValue) {
		if (null == oriValue || "".equals(oriValue)) {
			return oriValue;
		}
		BigDecimal bigDecimal = new BigDecimal(oriValue);
		BigDecimal bigDecimal2 = new BigDecimal(addValue);
		// 减法
		BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
		return bigDecimalMultiply.toString();
	}

	/**
	 * 除法
	 * 
	 * @param oriValue
	 * @param addValue
	 * @return
	 */
	public static String divide(String oriValue, String addValue) {
		if (null == oriValue || "".equals(oriValue)) {
			oriValue = "0.00";
		}
		if (null == addValue || "".equals(addValue) || "0".equals(addValue)) {
			addValue = "1";
		}
		BigDecimal bigDecimal = new BigDecimal(oriValue);
		BigDecimal bigDecimal2 = new BigDecimal(addValue);
		// 减法
		int scale = 2;// 保留2位小数
		BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, scale, BigDecimal.ROUND_HALF_UP);
		return bigDecimalDivide.toString();
	}

	public static boolean compare(String value1, String value2) {
		if (null == value1 || "".equals(value1)) {
			value1 = "0";
		}
		if (null == value2 || "".equals(value2)) {
			value2 = "0";
		}
		double v1 = Double.parseDouble(value1);
		double v2 = Double.parseDouble(value2);
		if (v1 >= v2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		double d1 = 0.01d;
		double d2 = 0.09d;
		System.out.println(d1 + d2);
	}
}
