package com.navi.observer;

import java.util.*;

/**
 * WeChatServer Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
public class WeChatServer implements Observerable {

    private String message;
    private Set<Observer> list;

    @Override
    public void registerObserver(Observer obs) {
        if(list == null){
            list = new HashSet<>();
        }
        list.add(obs);
        System.out.println(obs.getName() + " 订阅了微信公众号服务");
    }

    @Override
    public void removeObserver(Observer obs) {
        if(list != null){
            list.remove(obs);
            System.out.println(obs.getName() + " 取关了微信公众号服务");

        }

    }

    @Override
    public void notifyObserver() {
        if(list != null && !list.isEmpty()) {

            for (Observer obs : list){
                obs.update(message);
            }
        }
    }

    public void createMsg(String message){
        this.message = message;
        System.out.println("微信公众号推送了一条消息：" + message);
        notifyObserver();
    }
}
