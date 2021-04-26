package com.hr.web.security;

import com.alibaba.fastjson.JSONObject;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.domain.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public class RestfulAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONObject.toJSONString(new CommonResult<CommonErrorCode>(CommonErrorCode.UNAUTHORIZED.getFlag(), CommonErrorCode.UNAUTHORIZED.getCode(), CommonErrorCode.UNAUTHORIZED.getMessage())));
        response.getWriter().flush();
    }
}

