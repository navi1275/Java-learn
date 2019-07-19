package com.navi.metadata;

import lombok.Data;

/**
 * RequestInfo Class
 *
 * @author navi
 * @date 2019-04-02
 * @since 1.0.0
 */
@Data
public class RequestInfo {

    private String id;

    private String className;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] parameters;


}
