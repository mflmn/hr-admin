package com.hr.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Data
@TableName("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 组列表(虚数学院->总院-某分院)
     */
    private String groupList;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 部门负责人
     */
    private String leader;

    /**
     * 部门负责人手机
     */
    private String mobile;

    /**
     * 部门负责人邮箱
     */
    private String email;

    /**
     * 状态, 0可用, 1不可用
     */
    private String status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
