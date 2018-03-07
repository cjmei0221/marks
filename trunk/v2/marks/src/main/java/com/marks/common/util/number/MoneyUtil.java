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
			return "0.00";
		}
		if (null == addValue || "".equals(addValue)) {
			return "0.00";
		}
		BigDecimal bigDecimal = new BigDecimal(oriValue);
		BigDecimal bigDecimal2 = new BigDecimal(addValue);
		// 减法
		BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
		int scale = 2;// 保留2位小数
		bigDecimalMultiply = bigDecimalMultiply.setScale(scale, BigDecimal.ROUND_HALF_UP);
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
		if (null == addValue || "".equals(addValue)) {
			addValue = "1";
		}
		Double d = Double.parseDouble(addValue);
		if (d == 0) {
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
		BigDecimal bigDecimal = new BigDecimal(value1);
		BigDecimal bigDecimal2 = new BigDecimal(value2);
		if (bigDecimal.compareTo(bigDecimal2) >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(MoneyUtil.compare("0.01", "0.012"));
	}
}
