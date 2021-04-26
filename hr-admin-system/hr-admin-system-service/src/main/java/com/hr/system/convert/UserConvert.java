package com.hr.system.convert;

import com.hr.system.dto.UserDto;
import com.hr.system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserDto entity2dto(User user);

    User dto2entity(UserDto userDto);

    List<UserDto> entityList2dtoList(List<User> users);
}
