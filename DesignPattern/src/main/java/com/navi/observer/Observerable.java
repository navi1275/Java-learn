package com.navi.observer;

/**
 * Observerable Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
public interface Observerable {

    /**
     * 注册观察者
     * @param obs
     */
    void registerObserver(Observer obs);

    /**
     * 删除观察者
     * @param obs
     */
    void removeObserver(Observer obs);

    /**
     * 通知
     */
    void notifyObserver();

}
