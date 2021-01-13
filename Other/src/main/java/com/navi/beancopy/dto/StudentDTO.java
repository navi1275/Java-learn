package com.navi.beancopy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

/**
 * StudentDTO Class
 *
 * @author ganxf
 * @date 2020/8/14
 */
@Mapper
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private Integer age;
    private String good;
    private String birthday;

    private Course course;
}
