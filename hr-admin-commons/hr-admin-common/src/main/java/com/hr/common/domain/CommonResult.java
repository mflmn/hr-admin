package com.hr.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuelimin
 * @description
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult<T> implements Serializable {
    private boolean flag;
    private String code;
    private String message;
    private T result;

    public CommonResult(boolean flag, String code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(CommonErrorCode.SUCCESS.getFlag(), CommonErrorCode.SUCCESS.getCode(), CommonErrorCode.SUCCESS.getMessage());
    }

    public static <T> CommonResult<T> success(T result) {
        return new CommonResult<T>(CommonErrorCode.SUCCESS.getFlag(), CommonErrorCode.SUCCESS.getCode(), CommonErrorCode.SUCCESS.getMessage(), result);
    }

    public static <T> CommonResult<T> success(T result, String message) {
        return new CommonResult<T>(CommonErrorCode.SUCCESS.getFlag(), CommonErrorCode.SUCCESS.getCode(), message, result);
    }
}


