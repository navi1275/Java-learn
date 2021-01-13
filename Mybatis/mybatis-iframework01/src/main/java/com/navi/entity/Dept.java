package com.navi.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Dept Class
 *
 * @author navi
 * @date 2018/11/12
 */
@Data
@ToString
public class Dept {

    private Integer id;

    private Integer deptNo;

    private String deptName;

    private String location;
}
