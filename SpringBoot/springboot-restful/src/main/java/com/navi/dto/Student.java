package com.navi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student Class
 *
 * @author ganxf
 * @date 2020/7/2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private Integer age;

}
