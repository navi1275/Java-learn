package com.navi.dto;

import lombok.Data;

/**
 * BaseResponseDTO Class
 *
 * @author navi
 * @date 2019-04-10
 * @since 1.0.0
 */
@Data
public class BaseResponseDTO<T> {

    private T data;

    private String msg;

    private String code;
}
