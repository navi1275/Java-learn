package com.navi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

/**
 * User Class
 *
 * @author navi
 * @date 2019-04-25
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 4252852207825789119L;
    private Integer id;

    private String name;

    private Integer age;
}
