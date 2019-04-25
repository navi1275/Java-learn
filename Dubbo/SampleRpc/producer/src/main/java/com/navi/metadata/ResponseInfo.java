package com.navi.metadata;

import lombok.Data;

/**
 * ResponseInfo Class
 *
 * @author navi
 * @date 2019-04-02
 * @since 1.0.0
 */
@Data
public class ResponseInfo {

    private String id;

    private String requestId;

    private String errorCode;

    private String errorMsg;

    private Object data;

}
