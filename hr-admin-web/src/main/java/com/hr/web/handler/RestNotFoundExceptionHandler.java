package com.hr.web.handler;

import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@RestController
public class RestNotFoundExceptionHandler implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public CommonResult<CommonErrorCode> handleError() {
        CommonErrorCode u = CommonErrorCode.API_NOT_EXIST;
        return new CommonResult<CommonErrorCode>(u.getFlag(), u.getCode(), u.getMessage());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
