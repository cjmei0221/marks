package com.marks.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class IDUtil {
	
	/**
	 * 使用UUID作为主键
	 * @return
	 */
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString().replace("-", "").toUpperCase();
		return id;
	}
	/**
	 * 使用时间为主键
	 * @return
	 */
	public static String getTimeID(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss_S");
		return sdf.format(new Date());
	}
	/**
	 * 获取年月日作为ID
	 * @return
	 */
	public static String getDateID(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	/*public static void main(String[] args) {
		System.out.println(IDUtil.getTimeID());
	}*/
}
