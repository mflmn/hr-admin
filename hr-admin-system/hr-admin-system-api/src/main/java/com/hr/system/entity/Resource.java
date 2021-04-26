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
@TableName("resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String resKey;

    private String resName;

    private Long parentId;


}
