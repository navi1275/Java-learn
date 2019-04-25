package com.navi;

/**
 * Fibonacci Class
 * 斐波拉切数
 *
 * @author navi
 * @date 2019-04-23
 * @since 1.0.0
 */
public class Fibonacci {

    /**
     * 递归
     * @param n
     * @return
     */
    public static int fibonacci(int n){

        if(n <= 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        return fibonacci(n - 1) + fibonacci( n - 2);
    }

    /**
     * 遍历
     * @param n
     * @return
     */
    public static int fibonacci1(int n){

        if(n <= 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int first = 1, second = 1, third = 0;
        for (int i = 3;  i <= n; i++){
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

    public static void main(String[] args) {

        long f1 = System.currentTimeMillis();
        System.out.println(fibonacci(39));
        long e1 = System.currentTimeMillis();
        System.out.println(e1 - f1);
        long f2 = System.currentTimeMillis();
        System.out.println(fibonacci1(39));
        long e2 = System.currentTimeMillis();
        System.out.println(e2 - f2);

    }
}
