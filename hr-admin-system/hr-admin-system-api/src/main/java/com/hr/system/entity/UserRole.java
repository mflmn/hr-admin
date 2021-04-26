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
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员ID
     */
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
