package com.navi.config;

import com.navi.factory.ProxyFactory;

/**
 * ReferenceConfig Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */

public class ReferenceConfig<T> {

    private Class<?> interfaceClass;
    // 接口代理ass<?> interfac类引用
    private transient volatile T ref;

    public synchronized T get() {
        if (ref == null) {
            init();
        }
        return ref;
    }

    private void init() {
        ref = new ProxyFactory(interfaceClass).getProxyObject();
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
