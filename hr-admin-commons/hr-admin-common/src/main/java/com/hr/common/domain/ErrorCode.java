package com.hr.common.domain;

/**
 * @author yuelimin
 * @description 封装API错误码
 * @since 1.8
 */
public interface ErrorCode {
    boolean getFlag();

    String getCode();

    String getMessage();
}


