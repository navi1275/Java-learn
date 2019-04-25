package com.navi.observer;

/**
 * UserObserver Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
public class UserObserver implements Observer {

    private String name;
    private String message;

    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.message = msg;
        read();
    }

    @Override
    public String getName() {
        return name;
    }

    public void read(){
        System.out.println(name + " 接收到消息：" + message);
    }
}
