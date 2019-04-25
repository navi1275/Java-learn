package com.navi.observer;

/**
 * Observer Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
public interface Observer {

    /**
     * 更新状态
     * @param msg
     */
    void update(String msg);

    /**
     * 获取观察者名称
     */
    String getName();
}
