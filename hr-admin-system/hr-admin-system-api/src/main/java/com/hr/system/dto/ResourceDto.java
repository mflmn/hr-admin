package com.hr.system.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Data
@ApiModel(value = "ResourceDto", description = "")
public class ResourceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String resKey;

    private String resName;

    private Long parentId;


}
