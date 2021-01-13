package com.navi.chapter02;

/**
 * TimeServer Class
 *
 * @author navi
 * @date 29/03/2018
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8083;

        if(args != null || args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (Exception e){

            }
        }

        AsyncTimeServerHandler server = new AsyncTimeServerHandler(port);

        new Thread(server, "aio-timeserver-001").start();
    }
}
