package com.navi.consumer.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * DeptCodeConfig Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Configuration
public class DeptCodeConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule customRule(){
        List<Integer> list = Arrays.asList(8071);
        CustomRule customRule = new CustomRule(list);
        return customRule;
    }
}
