package com.navi;

import java.util.regex.Pattern;

/**
 * ByteTest Class
 *
 * @author navi
 * @date 2019-07-09
 * @since 1.0.0
 */
public class ByteTest {

    public static void main2(String[] args) {
        int a = -6;

        for (int i = 0; i < 32; i++){
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }

        System.out.println();
        System.out.println(0x80000000 >>> 1);
        System.out.println(0x80000000);
    }

    public static void main(String[] args) {
        System.out.println(Pattern.matches("^-?([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$", "21,123,123,123.00"));

        System.out.println("260,512.00".replaceAll(",", ""));

        while (true){

        }
    }
}
