package com.navi.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * DeptCodeConfig Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Configuration
public class DeptCodeConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
