package com.navi.chapter01;

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

        MultiplexerTimeServer server = new MultiplexerTimeServer(port);

        new Thread(server, "nio-timeserver-001").start();
    }
}
