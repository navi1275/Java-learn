package com.navi.create.builder;

import lombok.Builder;
import lombok.Data;

/**
 * Student Class
 *
 * @author ganxf
 * @date 2019-11-18
 */
@Data
@Builder
public class Student {

    private String name;

    private int age;

    private String gender;

    private String like;
}
