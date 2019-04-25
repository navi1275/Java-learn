package com.navi.concurrent;

/**
 * Sychronize1 Class
 *
 * @author navi
 * @date 2019-04-02
 * @since 1.0.0
 */
public class Sychronize1 {

    public static void main(String[] args) {
        synchronized (Sychronize1.class){
            System.out.println("Synchronize");
        }
    }
}
