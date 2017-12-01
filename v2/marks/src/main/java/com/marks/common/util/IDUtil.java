package com.marks.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
	public static String getTimeID(String partten){
		SimpleDateFormat sdf=new SimpleDateFormat(partten);
		return sdf.format(new Date());
	}

	public static String getTimeID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
		return sdf.format(new Date());
	}

	public static String getSecondID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
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
	/**
	 * 使用时间为主键
	 * @return
	 */
	public static String getDateSID(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_S");
		return sdf.format(new Date());
	}
	/**
	 * 使用时间为主键
	 * @return
	 */
	public static String getID(int size){
		String str = System.currentTimeMillis() + "";
		String idStr = System.currentTimeMillis() + "" + IDUtil.getRandom(1000, 9999)
				+ str.substring(str.length() - 4, str.length());
		if(size>idStr.length()){
			size=idStr.length();
		}
		return idStr.substring(idStr.length()-size, idStr.length());
	}
	
	public static String getRandom(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);
	}

	public static String getNumID() {
		return IDUtil.getSecondID() + IDUtil.getID(3) + IDUtil.getRandom(100, 999);
	}

	/*public static void main(String[] args) {
		System.out.println(IDUtil.getTimeID());
	}*/
}
