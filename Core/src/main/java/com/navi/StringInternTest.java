package com.navi;

/**
 * StringInternTest Class
 *
 * @author ganxf
 * @date 2020/6/23
 */
public class StringInternTest {

    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}


