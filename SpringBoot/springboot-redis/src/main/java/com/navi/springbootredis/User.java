package com.navi.springbootredis;

import lombok.Data;

import java.io.Serializable;

/**
 * User Class
 *
 * @author navi
 * @date 2019-07-19
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3257997965143501464L;

    private Long id;
    private String username;
    private String password;
}
