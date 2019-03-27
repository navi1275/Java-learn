package com.navi.entity;

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

    private Integer id;

    private String deptNo;

    private String deptName;

    private String location;


}
