package com.navi.mvc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganxf
 * @since 2018-12-06
 */
@Data
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer deptno;

    private String dname;

    private String loc;


}
