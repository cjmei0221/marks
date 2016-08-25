package com.grgbanking.inner.util.encrypt;

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
		System.out.println(EncryptUtil.encrypt("111111"));
	}
}
