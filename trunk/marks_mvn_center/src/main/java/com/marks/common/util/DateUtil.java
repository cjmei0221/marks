package com.nfb.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date date,String format){
		if(date==null){
			date=new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(null !=format && format.length()>5){
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(date);
	}
}
