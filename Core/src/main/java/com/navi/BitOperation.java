package com.navi;

/**
 * BitOperation Class
 *
 * @author navi
 * @date 2019-03-25
 * @since 1.0.0
 */
public class BitOperation {

    public static void main(String[] args) {
        // Specifically, using & -1 with any value will always result in the original value, as will anyValue ^ 0 and anyValue | 0.
        // 对任何值使用＆-1、^0、|0计算，将都会是原始值
        System.out.println(-1 & -1);
        System.out.println(-10 ^ 0);
        System.out.println(-1 | 0);

    }
}
