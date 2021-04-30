package com.hr.web.handler;

import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonResult;
import com.hr.common.domain.ErrorCode;
import com.hr.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

/**
 * @author yuelimin
 * @description
 * @since 1.8
 */
@RestControllerAdvice
public class RestGlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestGlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<CommonErrorCode> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        CommonErrorCode u = CommonErrorCode.VALIDATE_INPUT;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public CommonResult<CommonErrorCode> handleAccessIsDenied(Exception e) {
        LOGGER.info(e.getMessage(), e);

        CommonErrorCode u = CommonErrorCode.WITHOUT_PERMISSION;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult<CommonErrorCode> handleNotFound(Exception e) {
        LOGGER.info(e.getMessage(), e);

        CommonErrorCode u = CommonErrorCode.API_NOT_EXIST;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<CommonErrorCode> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LOGGER.info(e.getMessage(), e);

        CommonErrorCode u = CommonErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public CommonResult<CommonErrorCode> handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        LOGGER.info(e.getMessage(), e);

        CommonErrorCode u = CommonErrorCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResult<CommonErrorCode> processException(Exception e) {
        LOGGER.info(e.getMessage(), e);

        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            if (businessException.getErrorCode() != null) {
                ErrorCode errorCode = businessException.getErrorCode();
                return new CommonResult<CommonErrorCode>(errorCode.getFlag(), errorCode.getCode(), errorCode.getMessage());
            }
        }

        CommonErrorCode u = CommonErrorCode.SYSTEM_RESOURCE_ERROR;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }
}

