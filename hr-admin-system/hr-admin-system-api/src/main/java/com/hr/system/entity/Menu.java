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
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * URL
     */
    private String url;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 状态
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
