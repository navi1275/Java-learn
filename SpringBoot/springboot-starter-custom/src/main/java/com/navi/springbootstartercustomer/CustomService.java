package com.navi.springbootstartercustomer;

import lombok.AllArgsConstructor;

/**
 * CustomerService Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@AllArgsConstructor
public class CustomService {

    private String prefix;
    private String suffix;

    public String wrap(String content){
        if(content == null || content.equals("")){
            content = "custom";
        }
        return prefix + content + suffix;
    }
}
