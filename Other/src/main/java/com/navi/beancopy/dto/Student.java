package com.navi.beancopy.dto;

import lombok.Data;

import java.util.Date;

/**
 * Student Class
 *
 * @author ganxf
 * @date 2020/8/14
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String good;

    private Date birthday;
}
