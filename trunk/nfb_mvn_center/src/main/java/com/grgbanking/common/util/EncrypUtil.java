package com.grgbanking.common.util;

import org.apache.log4j.Logger;

public class EncrypUtil {
	private static Logger logger = Logger.getLogger(EncrypUtil.class);
	public static String encrypt(String src){
		String res=src;
		try {
			res=DESUtil.desCrypto(src);
		} catch (Exception e) {
			logger.info("desCrypto error",e);
		}
		return res;
	}
	public static String decrypt(String src){
		String res=src;
		try {
			res=DESUtil.decrypt(src);
		} catch (Exception e) {
			logger.info("decrypt error",e);
		}
		return res;
	}
	public static void main(String[] args) throws Exception {
		String str="oracle";
		System.out.println(EncrypUtil.encrypt(str));
		String res=EncrypUtil.encrypt(str);
		System.out.println(EncrypUtil.decrypt(res));
	}

}
