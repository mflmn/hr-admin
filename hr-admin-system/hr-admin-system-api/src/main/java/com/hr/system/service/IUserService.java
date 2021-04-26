package com.hr.system.service;

import com.hr.common.exception.BusinessException;
import com.hr.system.dto.ResourceDto;
import com.hr.system.dto.UserDto;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface IUserService {
    /**
     * 根据用户id获取资源列表
     *
     * @param userId
     * @return
     */
    List<ResourceDto> findResourceListByUserId(Long userId);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     * @throws BusinessException
     */
    UserDto findUserByUsername(String username) throws BusinessException;
}
