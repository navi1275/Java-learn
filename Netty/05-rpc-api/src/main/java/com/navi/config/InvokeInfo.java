package com.navi.config;

import lombok.Data;

import java.io.Serializable;

/**
 * InvokeInfo Class
 *
 * @author ganxf
 * @date 2020/9/10
 */
@Data
public class InvokeInfo implements Serializable {

    private static final long serialVersionUID = -7826159875436475949L;
    // 服务类名
    private String clazzName;
    // 调用方法名
    private String methodName;
    // 参数类型
    private Class<?>[] paramTypes;
    // 参数值
    private Object[] paramValues;

}
