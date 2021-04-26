package com.hr.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Data
@TableName("resource_menu")
public class ResourceMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resource_id", type = IdType.ID_WORKER)
    private Long resourceId;

    private Long menuId;


}
