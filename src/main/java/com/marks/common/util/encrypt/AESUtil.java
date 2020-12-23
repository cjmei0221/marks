package com.marks.common.util.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class AESUtil {

	private final static String ADES_KEY = "azxHw3Jx0QqpeomrVROrMmmN";
	
	private final static String DEF_ADES_KEY = "akjsdl934ihJHGJU832kjaasKa";
	
	private final static String PASSWORD_KEY = "req_pwd";

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static byte[] encryptAES(String content, String password)
			throws Exception {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			// for linux random key
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			// kgen.init(128, new SecureRandom(password.getBytes()));
			// for linux random key
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(byteContent);
			return result;
		} catch (Exception e) {
			throw new Exception("Encrypt failed");
		}
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decryptAES(byte[] content, String password)
			throws Exception {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			// for linux random key
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			kgen.init(128, secureRandom);
			// kgen.init(128, new SecureRandom(password.getBytes()));
			// for linux random key
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			throw new Exception("Decrypt failed");
		}
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 生成隨機的加密key
	 * 
	 * @param password
	 * @return
	 */
	public static String genRanKey(String password)throws Exception{
		 MessageDigest digest = null;
		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				throw new Exception("Failed to load the MD5 MessageDigest. ");
			}
		}
		digest.update(String.valueOf(System.currentTimeMillis()).getBytes());
		return new String(digest.digest());
	}

	/**
	 * 生成寫死的默認key
	 * 
	 * @param password
	 * @return
	 */
	public static String genDefKey(){
		return DEF_ADES_KEY;
	}
	
	
	public static String genRanKey() throws Exception{
		return genRanKey(AESUtil.ADES_KEY);
	}
	
	/**
	 * 静态加密
	 * @param datasource
	 * @return
	 * @throws Exception
	 */
	public static String desCrypDefto(String datasource) throws Exception{
		String password = "";
		try{
			password = AESUtil.genDefKey();
			String result = AESUtil.parseByte2HexStr(AESUtil.encryptAES(datasource, password));
			return result;
		}catch(Exception e){
			throw new Exception("Encrypt failed!");
		}
	}
	
	
	/**
	 *根据毫秒值生产动态密文
	 * @param datasource
	 * @return
	 * @throws Exception
	 */
	public static String desCrypto(String datasource)throws Exception{
		String password ="";
		try{
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			
			password = (String) session.getAttribute(AESUtil.PASSWORD_KEY);
			if(password==null||"".equals(password)){
				password = AESUtil.genRanKey();
				session.setAttribute("req_pwd", password);
			}
			
			String result = AESUtil.parseByte2HexStr(AESUtil.encryptAES(datasource, password));
			
			return result;
		}catch(Exception e){
			throw new Exception("AES Encrypt failed!");
		}
		
	}
	
	/**
	 * 静态加密解密方法
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String decryptDef(String src) throws Exception{
		String password = "";
		try{
			password = AESUtil.genDefKey();
			String result = new String(AESUtil.decryptAES(AESUtil.parseHexStr2Byte(src), password));
			return result;
		}catch(Exception e){
			throw new Exception("Decrypt failed!");
		}
	}
	
	public static String decrypt(String src,HttpSession session) throws Exception {
		String password = "";
		try{
			if(session==null){
				Exception ex = new Exception("Decrypt failed,session is null");
				throw ex;
			}
			password = (String) session.getAttribute(PASSWORD_KEY);
			if(password == null || "".equals(password)){
				throw new Exception("AES Decrypt failed! session has not password key!");
			}
			String result = new String(AESUtil.decryptAES(AESUtil.parseHexStr2Byte(src), password));
			return result;
		}catch(Exception e){
			throw new Exception("AES Decrypt faild!["+e.getMessage()+"]");
		}
	}
	
	/**
	 * 动态解密方法
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String src) throws Exception {
		String password = "";
		try{
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			password = (String) session.getAttribute(PASSWORD_KEY);
			if(password == null || "".equals(password)){
				throw new Exception("AES Decrypt failed! session has not password key!");
			}
			String result = new String(AESUtil.decryptAES(AESUtil.parseHexStr2Byte(src), password));
			return result;
		}catch(Exception e){
			throw new Exception("AES Decrypt faild!["+e.getMessage()+"]");
		}
	}
	
	/**
	 * 根据毫秒值生产动态密文
	 * @param datasource
	 * @param pwdkey
	 * @return
	 * @throws Exception
	 */
	public static String desCryptoByPwdkey(String datasource,String pwdkey)throws Exception{
		try{
			String result = AESUtil.parseByte2HexStr(AESUtil.encryptAES(datasource, pwdkey));	
			return result;
		}catch(Exception e){
			throw new Exception("AES Encrypt failed!");
		}
		
	}
	/**
	 * 动态加密解密方法
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPwdkey(String src,String pwdkey) throws Exception {
		try{
			String result = new String(AESUtil.decryptAES(AESUtil.parseHexStr2Byte(src), pwdkey));
			return result;
		}catch(Exception e){
			throw new Exception("AES Decrypt faild!["+e.getMessage()+"]");
		}
	}
	
	/*public static void main(String[] args) throws Exception {
		String str="qreqwer";
		String stres=AESUtil.desCryptoByPwdkey(str, "1231234");
		System.out.println(stres);
		String s=AESUtil.decryptByPwdkey(stres, "1231234");
		System.out.println(s);
	}*/
}
