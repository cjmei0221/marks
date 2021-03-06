package com.marks.common.util.encrypt;

import org.apache.log4j.Logger;

import com.marks.common.util.IDUtil;

/**
 * 加解密接口工具类型
 * File Name: com.grgbanking.inner.util.encrypt.EncryptUtil.java
 *
 * @author:cjmei0221@163.com
 * @Date:2016年7月28日下午4:31:15
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
 * @see (optional)
 */
public class EncryptUtil {
    private static Logger logger = Logger.getLogger(EncryptUtil.class);

    public static String defaultPwd = "B15A268148D9C5A9363E915581CE1819";

    /**
     * 密码转加密
     * encrypt:描述 <br/>
     *
     * @param src
     * @throws Exception
     * @author cjmei
     * @修改记录:(日期,修改人,描述) (可选) <br/>
     */
    public static String encryptPwd(String src) throws Exception {
        String key = IDUtil.getDateID() + IDUtil.getDateID();
        logger.info("src:" + src + "-key:" + key);
        String pwd = AESUtil2.aesDecrypt(src, key);
        return AESUtil.desCrypDefto(pwd);
    }

    public static String encryptPwd2(String src) throws Exception {
        return AESUtil.desCrypDefto(src);
    }

    /**
     * 加密方法
     * encrypt:描述 <br/>
     *
     * @param src
     * @throws Exception
     * @author cjmei
     * @修改记录:(日期,修改人,描述) (可选) <br/>
     */
    public static String encrypt(String src) throws Exception {
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
    public static String decrypt(String src) throws Exception {
        return AESUtil.decryptDef(src);
    }


    /**
     * 加密方法 encrypt:描述 <br/>
     *
     * @param src
     * @throws Exception
     * @author cjmei
     * @修改记录:(日期,修改人,描述) (可选) <br/>
     */
    public static String encryptByKey(String src, String key) throws Exception {
        return AESUtil.desCryptoByPwdkey(src, key);
    }

    /**
     * 解密方法 decrypt:描述 <br/>
     *
     * @param src
     * @return
     * @throws Exception
     * @author cjmei
     * @修改记录:(日期,修改人,描述) (可选) <br/>
     */
    public static String decryptByKey(String src, String key) throws Exception {
        return AESUtil.decryptByPwdkey(src, key);
    }

    public static void main(String[] args) throws Exception {
        String key = "2017121300043659";
        String src = "LS10012|U9947036";
        System.out.println(AESUtil2.aesEncrypt(src, key));

        // System.out.println(EncryptUtil.decrypt(EncryptUtil.encryptPwd("bTAKua+7TtXXvXxrIZdSJQ==")).length());
    }
}
