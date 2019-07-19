package com.navi.entity;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author navi
 * @since 2018-12-06
 */
@Data
@TableName("dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    @TableField("dept_no")
    private String deptNo;

    @TableField("dept_name")
    private String deptName;

    private String location;

}
