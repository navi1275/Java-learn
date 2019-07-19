package com.navi.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * SamRPCNamespaceHandler Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */
public class SamRPCNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference", new SamRPCBeanDefinitionParser());
    }
}
