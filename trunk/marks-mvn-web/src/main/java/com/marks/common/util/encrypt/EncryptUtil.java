package com.marks.common.util.encrypt;

/**
 * 加解密接口工具类型
 * File Name: com.grgbanking.inner.util.encrypt.EncryptUtil.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月28日下午4:31:15
 * @see (optional) 
 * @Copyright (c) 2016, marks  All Rights Reserved.
 */
public class EncryptUtil {
	
	public static String defaultPwd="B15A268148D9C5A9363E915581CE1819";
	/**
	 * 加密方法
	 * encrypt:描述 <br/>
	 *
	 * @param src
	 * @author marks
	 * @throws Exception 
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String encrypt(String src) throws Exception{
		String pwd=AESUtil2.aesDecrypt(src);
		return AESUtil.desCrypDefto(pwd);
	}
	/**
	 * 解密方法
	 * decrypt:描述 <br/>
	 *
	 * @param src
	 * @return
	 * @throws Exception
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String decrypt(String src) throws Exception{
		return AESUtil.decryptDef(src);
	}
	public static void main(String[] args) throws Exception {
		System.out.println();
		System.out.println(EncryptUtil.decrypt(EncryptUtil.encrypt("342352452523452345234546345123414363654563")).length());
	}
}
