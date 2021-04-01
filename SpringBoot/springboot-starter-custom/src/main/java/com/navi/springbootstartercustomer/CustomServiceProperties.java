package com.navi.springbootstartercustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CustomerService Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@Data
@ConfigurationProperties("custom.service")
public class CustomServiceProperties {

    private String prefix;
    private String suffix;

}
