package com.navi.springbootstartercustomer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CustomerService Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@Configuration
@ConditionalOnClass(CustomService.class)
@EnableConfigurationProperties(CustomServiceProperties.class)
public class CustomServiceAutoConfiguration {

    @Autowired
    private CustomServiceProperties properties;


    @Bean
    // 通过配置custom.service.enable = true 才注入， 如果没有配置项，默认是true
    @ConditionalOnProperty(name = "custom.service.enable", matchIfMissing = true, havingValue = "true")
    public CustomService customService(){
        return new CustomService(properties.getPrefix(), properties.getSuffix());
    }

    @Bean
    // 没有注入CustomService默认注入这个
    @ConditionalOnMissingBean
    public CustomService customService2(){
        return new CustomService("$1", "$2");
    }


}
