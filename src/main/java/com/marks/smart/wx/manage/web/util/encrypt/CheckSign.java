package com.marks.smart.wx.manage.web.util.encrypt;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.smart.wx.manage.web.mp.SHAUtil;

public class CheckSign {
	private static Logger logger = Logger.getLogger(CheckSign.class);
	/**
	 * 校验Sha
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	public static boolean checkSha(HttpServletRequest request, String token) {
		try {
			return checkSignature(request, token);
		} catch (NoSuchAlgorithmException e) {
			logger.info("NoSuchAlgorithmException:", e);
			return false;
		}
	}

	/**
	 * 验证签名
	 * 
	 * @param request
	 * @param token
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean checkSignature(HttpServletRequest request, String token) throws NoSuchAlgorithmException {
		logger.info("--------------------checkSignature,token:" + token);
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");

		logger.info("--------------signature=" + signature + ",timestamp=" + timestamp + ",nonce=" + nonce);

	/*	long timefromdb = 999 * 1000;
		long systimes = (new Date()).getTime();
		long revtimes = Long.parseLong(timestamp) * 1000;
		long starttimes = systimes - timefromdb;
		long endtimes = systimes + timefromdb;*/

		String[] tempArr = new String[] { token, timestamp, nonce };
		Arrays.sort(tempArr);
		String tempStr = tempArr[0] + tempArr[1] + tempArr[2];
		tempStr = SHAUtil.digestSHA(tempStr);
		if (tempStr.equalsIgnoreCase(signature)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String signature = "352352";
		String timestamp = System.currentTimeMillis()/1000+"";
		String nonce = "3523524";

		
	/*	long timefromdb = 999 * 1000;
		long systimes = (new Date()).getTime();
		long revtimes = Long.parseLong(timestamp) * 1000;
		long starttimes = systimes - timefromdb;
		long endtimes = systimes + timefromdb;*/

		String[] tempArr = new String[] { "3523452", timestamp, nonce };
		Arrays.sort(tempArr);
		String tempStr = tempArr[0] + tempArr[1] + tempArr[2];
		System.out.println(tempStr);
		tempStr = SHAUtil.digestSHA(tempStr);

	}
}
