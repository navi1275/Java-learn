package com.navi.beancopy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

/**
 * Course Class
 *
 * @author ganxf
 * @date 2020/8/20
 */
@Mapper
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private String name;
    private String grade;
}
