package com.navi.zuul;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

// 开启zuul代理
@EnableZuulProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    // 注入负载均衡算法, zuul配置路由routes使用服务名是，使用该算法
    @Bean
    public IRule loadbalancer(){
        return  new RandomRule();
    }
}
