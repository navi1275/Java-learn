package com.navi.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController Class
 *
 * @author navi
 * @date 2019-04-03
 * @since 1.0.0
 */

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
