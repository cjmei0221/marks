package com.marks.common.util.encrypt;

import com.marks.common.util.IDUtil;

/**
 * 加解密接口工具类型
 * File Name: com.grgbanking.inner.util.encrypt.EncryptUtil.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月28日下午4:31:15
 * @see (optional) 
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
 */
public class EncryptUtil {
	
	 public static String defaultPwd="B15A268148D9C5A9363E915581CE1819";
	 
	 /**
		 *密码转加密 
		 * encrypt:描述 <br/>
		 *
		 * @param src
		 * @author cjmei
		 * @throws Exception 
		 * @修改记录:(日期,修改人,描述) (可选) <br/>
		 */
		public static String encryptPwd(String src,String createdate) throws Exception{
			String key=createdate+createdate;
			String pwd=AESUtil2.aesDecrypt(src, key);
			return AESUtil.desCrypDefto(pwd);
		}

	/**
	 * 加密方法
	 * encrypt:描述 <br/>
	 *
	 * @param src
	 * @author cjmei
	 * @throws Exception 
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String encrypt(String src) throws Exception{
		return AESUtil.desCrypDefto(src);
	}
	/**
	 * 解密方法
	 * decrypt:描述 <br/>
	 *
	 * @param src
	 * @return
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String decrypt(String src) throws Exception{
		return AESUtil.decryptDef(src);
	}
	public static void main(String[] args) throws Exception {
		String key=IDUtil.getDateID()+IDUtil.getDateID();
		System.out.println(key);
		System.out.println(AESUtil2.aesEncrypt("234123414", key));
		
		System.out.println(EncryptUtil.decrypt(EncryptUtil.encryptPwd("8V9m+H02MMDkDxZJcIpAJw==",key)).length());
	}
}
