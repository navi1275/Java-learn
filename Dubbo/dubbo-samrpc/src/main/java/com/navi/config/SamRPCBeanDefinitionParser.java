package com.navi.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * SamRPCBeanDefinitionParser Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */
public class SamRPCBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected Class<?> getBeanClass(Element element) {
        return ReferenceBean.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String interfaceClassName = element.getAttribute("interface");

        if(StringUtils.hasText(interfaceClassName)){
            builder.addPropertyValue("interfaceClass", interfaceClassName);
        }
    }
}
