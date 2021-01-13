package com.navi.chapter02;

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

        AsyncTimeClientHandler handler = new AsyncTimeClientHandler("127.0.0.1", port);

        new Thread(handler, "aio-client-001").start();
    }
}
