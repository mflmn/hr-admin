package com.hr.common.exception;

import com.hr.common.domain.ErrorCode;

/**
 * @author yuelimin
 * @description 自定义异常
 * @since 1.8
 */
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BusinessException() {
        super();
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}


