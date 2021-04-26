package com.hr.system.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hr.common.domain.CommonErrorCode;
import com.hr.common.exception.BusinessException;
import com.hr.system.convert.ResourceConvert;
import com.hr.system.convert.UserConvert;
import com.hr.system.dto.ResourceDto;
import com.hr.system.dto.UserDto;
import com.hr.system.entity.User;
import com.hr.system.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Transactional
@Service(interfaceClass = IUserService.class, version = "1.0.0")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<ResourceDto> findResourceListByUserId(Long userId) {
        return ResourceConvert.INSTANCE.entityList2dtoList(userMapper.queryResourceListByUserId(userId));
    }

    @Override
    public UserDto findUserByUsername(String username) throws BusinessException {
        User user = userMapper.selectOne(new LambdaUpdateWrapper<User>().eq(User::getUsername, username));

        if (user == null) {
            throw new BusinessException(CommonErrorCode.USER_NOT_EXISTS);
        } else if ("0".equals(user.getStatus())) {
            return UserConvert.INSTANCE.entity2dto(user);
        }

        throw new BusinessException(CommonErrorCode.USER_NOT_ACTIVE);
    }
}
