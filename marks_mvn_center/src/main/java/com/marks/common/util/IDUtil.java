package com.marks.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class IDUtil {
	
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString().replace("-", "").toUpperCase();
		return id;
	}
	
	public static String getTimeID(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssS");
		return sdf.format(new Date());
	}
	
}
