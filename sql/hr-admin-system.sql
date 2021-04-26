DROP DATABASE IF EXISTS `hr_admin_system`;
CREATE DATABASE `hr_admin_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hr_admin_system`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `parent_id`   bigint(20)  DEFAULT '0' COMMENT '父ID',
    `name`        varchar(50) DEFAULT NULL COMMENT '部门名称',
    `group_list`  varchar(50) DEFAULT '' COMMENT '组列表(虚数学院->总院-某分院)',
    `order`       int(5)      DEFAULT '0' COMMENT '排序',
    `leader`      varchar(20) DEFAULT NULL COMMENT '部门负责人',
    `mobile`      varchar(11) DEFAULT NULL COMMENT '部门负责人手机',
    `email`       varchar(60) DEFAULT NULL COMMENT '部门负责人邮箱',
    `status`      char(1)     DEFAULT '0' COMMENT '状态, 0可用, 1不可用',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `post_code`   varchar(64) DEFAULT NULL COMMENT '岗位代码',
    `name`        varchar(64) DEFAULT NULL COMMENT '岗位名称',
    `order`       int(5)      DEFAULT '0' COMMENT '排序',
    `status`      char(1)     DEFAULT '0' COMMENT '状态',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `username`    varchar(20)  DEFAULT NULL COMMENT '用户名',
    `password`    varchar(256) DEFAULT NULL COMMENT '密码',
    `nickname`    varchar(20)  DEFAULT NULL COMMENT '昵称',
    `email`       varchar(60)  DEFAULT NULL COMMENT '邮箱',
    `avatar`      varchar(256) DEFAULT NULL COMMENT '头像',
    `mobile`      varchar(11)  DEFAULT NULL COMMENT '手机号',
    `sex`         char(1)      DEFAULT NULL COMMENT '性别',
    `status`      char(1)      DEFAULT '0' COMMENT '状态',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `remark`      varchar(256) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `user_id` bigint(20) NOT NULL COMMENT '管理员ID',
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `id`          bigint(20) NOT NULL COMMENT '菜单ID',
    `name`        varchar(50) DEFAULT NULL COMMENT '菜单名称',
    `icon`        varchar(50) DEFAULT NULL COMMENT '图标',
    `url`         varchar(50) DEFAULT NULL COMMENT 'URL',
    `parent_id`   bigint(20)  DEFAULT NULL COMMENT '上级菜单ID',
    `order`       int(5)      DEFAULT NULL COMMENT '排序',
    `status`      char(1)     DEFAULT '0' COMMENT '状态',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `res_key`   varchar(50) DEFAULT NULL,
    `res_name`  varchar(50) DEFAULT NULL,
    `parent_id` bigint(20)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `resource_menu`;
CREATE TABLE `resource_menu`
(
    `resource_id` bigint(20) NOT NULL,
    `menu_id`     bigint(20) NOT NULL,
    PRIMARY KEY (`resource_id`, `menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(20) DEFAULT NULL COMMENT '角色名称',
    `status`      char(1)     DEFAULT '0' COMMENT '状态',
    `order`       int(5)      DEFAULT NULL COMMENT '排序',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`
(
    `role_id`     bigint(20) NOT NULL,
    `resource_id` bigint(20) NOT NULL,
    PRIMARY KEY (`role_id`, `resource_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `role_department`;
CREATE TABLE `role_department`
(
    `role_id`       bigint(20) NOT NULL COMMENT '角色ID',
    `department_id` bigint(20) NOT NULL COMMENT '部门ID',
    PRIMARY KEY (`role_id`, `department_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `user_post`;
CREATE TABLE `user_post`
(
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
    PRIMARY KEY (`user_id`, `post_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


SET FOREIGN_KEY_CHECKS = 1;
