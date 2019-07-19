package com.navi.config;

import org.springframework.beans.factory.FactoryBean;

/**
 * ReferenceBean Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */
public class ReferenceBean<T> extends ReferenceConfig<T> implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

}
