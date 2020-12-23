package com.marks.common.util.number;

import com.marks.smart.system.autocode.core.produced.util.StringUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtil {
	
	public static double formatDouble(double price){
		DecimalFormat  dformat = new DecimalFormat("######0");  
		String amountStr=dformat.format(price);
		double returnAmount=Double.parseDouble(amountStr);
		return returnAmount;
	}
	
	public static String formatNumber(double amount,String format){
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance(); 
		 df.applyPattern(format); 
		 return df.format(amount/100); 
	}
	public static String formatNum(double amount,String format){
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance(); 
		 df.applyPattern(format); 
		 return df.format(amount); 
	}

	public static boolean isNumeric(String str) {
		try {
			if (StringUtils.isEmpty(str)) {
				return false;
			}
			String reg = "^[-\\+]?[0-9]+(.[0-9]+)?$";
			return str.matches(reg);
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public static void main(String[] args){
		System.out.println(formatNum(1045341.12,"0"));
	}

}
