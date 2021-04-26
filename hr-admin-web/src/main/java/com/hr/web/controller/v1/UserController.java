package com.hr.web.controller.v1;

import com.hr.common.domain.CommonResult;
import com.hr.system.dto.UserDto;
import com.hr.system.service.IUserService;
import com.hr.system.vo.UserLoginVo;
import com.hr.web.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@Api(value = "用户操作", tags = {"System"})
public class UserController {
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Reference(version = "1.0.0")
    private IUserService iUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("获取用户信息")
    @GetMapping("/v1/user/info")
    public CommonResult<UserDto> userInfo(HttpServletRequest request) {
        String substring = request.getHeader(header).substring(tokenHeader.length());
        String userNameFromToken = jwtTokenUtil.getUserNameFromToken(substring);
        UserDto userDto = iUserService.findUserByUsername(userNameFromToken);
        userDto.setPassword(null);
        return CommonResult.success(userDto);
    }

    @ApiOperation("用户退出")
    @PostMapping("/v1/user/logout")
    public CommonResult<String> logout() {
        return CommonResult.success();
    }

    @ApiOperation("用户登录")
    @PostMapping("/v1/user/login")
    public CommonResult<String> login(@RequestBody @Valid UserLoginVo userLoginVo) {
        UserDto user = iUserService.findUserByUsername(userLoginVo.getUsername());
        String token = null;

        if (passwordEncoder.matches(user.getPassword(), userLoginVo.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginVo.getUsername());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            token = jwtTokenUtil.generateToken(userDetails);
        }

        return CommonResult.success(tokenHeader + " " + token);
    }
}
