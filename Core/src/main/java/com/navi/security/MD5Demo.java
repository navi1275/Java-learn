package com.navi.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Demo Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-25
 * @since 1.0.0
 */
public class MD5Demo {

    public static void main(String[] args) {
        // String encode = encode("1234567890");
        // System.out.println(encode);
        System.out.println(-14 >> 2);
        System.out.println(-14 << 2);
    }

    public static String encode(String source) {

        MessageDigest md = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance("MD5");
            digest = md.digest(source.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return bytesToHex(digest);


    }


    /**
     * hex字符串转byte数组
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex){
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){
            //奇数
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex="0"+inHex;
        }else {
            //偶数
            result = new byte[(hexlen/2)];
        }
        int j=0;
        for (int i = 0; i < hexlen; i+=2){
            result[j]=hexToByte(inHex.substring(i,i+2));
            j++;
        }
        return result;
    }

    /**
     * Hex字符串转byte
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte
     */
    public static byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex,16);
    }


    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            int num = bytes[i] & 0xFF;
            String hex = Integer.toHexString(num);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}


