package com.hr.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Data
@ApiModel(value = "DepartmentDto", description = "")
public class DepartmentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "父ID")
    private Long parentId;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "组列表(虚数学院->总院-某分院)")
    private String groupList;

    @ApiModelProperty(value = "排序")
    private Integer order;

    @ApiModelProperty(value = "部门负责人")
    private String leader;

    @ApiModelProperty(value = "部门负责人手机")
    private String mobile;

    @ApiModelProperty(value = "部门负责人邮箱")
    private String email;

    @ApiModelProperty(value = "状态, 0可用, 1不可用")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
