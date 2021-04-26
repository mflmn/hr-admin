package com.hr.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.system.entity.Resource;
import com.hr.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<Resource> queryResourceListByUserId(Long id);
}
