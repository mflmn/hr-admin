package com.hr.system.convert;

import com.hr.system.dto.ResourceDto;
import com.hr.system.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Mapper
public interface ResourceConvert {
    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

    ResourceDto entity2dto(Resource resource);

    Resource dto2entity(ResourceDto resourceDto);

    List<ResourceDto> entityList2dtoList(List<Resource> resources);
}
