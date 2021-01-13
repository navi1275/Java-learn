package com.navi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * CommonResult Class
 *
 * @author ganxf
 * @date 2020/7/2
 */
@Data
@Builder
public class CommonResult<T> {

    private String status;

    private String errorCode;

    private String errorMsg;

    private T body;
}
