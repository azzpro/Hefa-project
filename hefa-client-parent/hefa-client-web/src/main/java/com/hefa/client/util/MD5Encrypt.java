package com.hefa.client.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PengBin
 * @ClassName: MD5Encrypt
 * @Description: MD5加密类
 * @date 2016年7月12日 下午4:14:22
 * Copyright © 2016 深圳齐采科技有限公司
 */
@UtilityClass
@Slf4j
public class MD5Encrypt {

    /**
     * @param @param  instr
     * @param @return
     * @param @throws Exception
     * @return String
     * @throws
     * @Title: encryptMD5
     * @Description: MD5加密，英文大写
     * @author: PengBin
     */
    public static String encryptMD5(String instr){
        if (instr == null) {
            return "";
        }
        String outstr = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(instr.getBytes());
            outstr += byte2hex(digest);
        } catch (NoSuchAlgorithmException e) {
            //DO NOTHING
        }
        return outstr;
    }

    /**
     * @param @param  instr
     * @param @param  character
     * @param @return
     * @param @throws Exception
     * @return String
     * @throws
     * @Title: encryptMD5
     * @Description: 使用指定字符集MD5加密，英文大写
     * @author: PengBin
     */
    public static String encryptMD5(String instr, String character) {
        if (instr == null) {
            instr = "";
        }
        if (character == null) {
            character = "UTF-8";
        }
        String outstr = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(instr.getBytes(character));
            outstr += byte2hex(digest);
            return outstr.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            log.error("encryptMD5",e);
        } catch (UnsupportedEncodingException e) {
            log.error("encryptMD5",e);
        }
        return "";
    }

    /**
     * <p>MD5加密，返回大写加密结果</p>
     *
     * @param instr
     * @return
     * @throws Exception
     * @author 黄智聪（13510946256）  2017年3月20日 下午8:39:53
     */
    public static String encryptMD5UpperCase(String instr) {

        if (instr == null) {
            return  "";
        }
        String outstr = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("encryptMD5",e);
        }
        byte[] digest = md.digest(instr.getBytes());
        outstr += byte2hex(digest);

        return outstr.toUpperCase();
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }
}
