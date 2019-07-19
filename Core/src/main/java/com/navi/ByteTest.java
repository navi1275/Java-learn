package com.navi;

/**
 * ByteTest Class
 *
 * @author navi
 * @date 2019-07-09
 * @since 1.0.0
 */
public class ByteTest {

    public static void main(String[] args) {
        int a = -6;

        for (int i = 0; i < 32; i++){
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }

        System.out.println();
        System.out.println(0x80000000 >>> 1);
        System.out.println(0x80000000);
    }
}
