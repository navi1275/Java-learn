package com.navi.chapter01;

/**
 * TimeClient Class
 *
 * @author navi
 * @date 30/03/2018
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8083;

        if(args != null || args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (Exception e){

            }
        }

        TimeClientHandler handler = new TimeClientHandler("", port);

        new Thread(handler, "nio-client-001").start();
    }
}
