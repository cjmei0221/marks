package com.marks.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IDUtil {

	/**
	 * 使用UUID作为主键
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().replace("-", "").toUpperCase();
		return id;
	}

	/**
	 * 使用时间为主键
	 * 
	 * @return
	 */
	// public static String getTimeID(String partten) {
	// SimpleDateFormat sdf = new SimpleDateFormat(partten);
	// return sdf.format(new Date());
	// }

	// public static String getTimeID() {
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
	// return sdf.format(new Date());
	// }

	public static String getSecondID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}

	/**
	 * 获取年月日作为ID
	 * 
	 * @return
	 */
	public static String getDateID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}

	/**
	 * 使用时间为主键
	 * 
	 * @return
	 */
	public static String getDateSID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_" + IDUtil.getID(4));
		return sdf.format(new Date());
	}

	/**
	 * 使用时间为主键
	 * 
	 * @return
	 */
	public static String getID(int size) {
		String str = System.currentTimeMillis() + "";
		String idStr = System.currentTimeMillis() + IDUtil.getRandom(1000, 9999) + IDUtil.getRandom(1000, 9999)
				+ str.substring(str.length() - 2, str.length());
		if (size > idStr.length()) {
			size = idStr.length();
		}
		return idStr.substring(idStr.length() - size, idStr.length());
	}

	/**
	 * 使用时间为主键
	 * 
	 * @return
	 */
//	public static String getIdNo() {
//		String str = System.currentTimeMillis() + "";
//		String date = IDUtil.getDateID();
//		String idStr = date.substring(0, 4) + "_" + date.substring(4) + "_" + IDUtil.getRandom(1000, 9999) + "_"
//				+ str.substring(str.length() - 4, str.length());
//		return idStr;
//	}

	public static String getRandom(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);
	}

	public static String getNumID() {
		return IDUtil.getSecondID() + IDUtil.getID(6);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.println(IDUtil.getRandom(0, 6));
		}
	}

	public static String getProjectCode() {
		String date = IDUtil.getNumID();
		return date.substring(0, 4) + "-" + date.substring(4, 8) + "-" + date.substring(8, 12) + "-" + date.substring(12, 16);
	}

}
