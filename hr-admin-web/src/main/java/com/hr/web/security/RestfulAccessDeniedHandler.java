package com.hr.web.security;

import com.alibaba.fastjson.JSONObject;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(403);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONObject.toJSONString(new CommonResult<CommonErrorCode>(CommonErrorCode.WITHOUT_PERMISSION.getFlag(), CommonErrorCode.WITHOUT_PERMISSION.getCode(), CommonErrorCode.WITHOUT_PERMISSION.getMessage())));
        response.getWriter().flush();
    }
}

