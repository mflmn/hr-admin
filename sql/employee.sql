/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : hr_admin_system

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 21/05/2021 09:37:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(8) NULL DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `politicId` int(8) NULL DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `departmentId` bigint(11) NULL DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) NULL DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) NULL DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date NULL DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '在职状态',
  `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `contractTerm` double NULL DEFAULT NULL COMMENT '合同期限',
  `conversionTime` date NULL DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date NULL DEFAULT NULL COMMENT '离职日期',
  `beginContract` date NULL DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date NULL DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) NULL DEFAULT NULL COMMENT '工龄',
  `salaryId` int(11) NULL DEFAULT NULL COMMENT '工资账套ID',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `jobId`(`jobLevelId`) USING BTREE,
  INDEX `posId`(`posId`) USING BTREE,
  INDEX `nationId`(`nationId`) USING BTREE,
  INDEX `politicId`(`politicId`) USING BTREE,
  INDEX `workId`(`workID`) USING BTREE,
  INDEX `salaryId`(`salaryId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `departmentId`(`departmentId`) USING BTREE,
  CONSTRAINT `employee_ibfk_6` FOREIGN KEY (`salaryId`) REFERENCES `salary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`politicId`) REFERENCES `politics_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`posId`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级','员级') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称等级',
  `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for politics_status
-- ----------------------------
DROP TABLE IF EXISTS `politics_status`;
CREATE TABLE `politics_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政治面貌',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `basicSalary` int(11) NULL DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) NULL DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) NULL DEFAULT NULL COMMENT '交通补助',
  `allSalary` int(11) NULL DEFAULT NULL COMMENT '应发工资',
  `pensionBase` int(11) NULL DEFAULT NULL COMMENT '养老金基数',
  `pensionPer` float NULL DEFAULT NULL COMMENT '养老金比率',
  `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '启用时间',
  `medicalBase` int(11) NULL DEFAULT NULL COMMENT '医疗基数',
  `medicalPer` float NULL DEFAULT NULL COMMENT '医疗保险比率',
  `accumulationFundBase` int(11) NULL DEFAULT NULL COMMENT '公积金基数',
  `accumulationFundPer` float NULL DEFAULT NULL COMMENT '公积金比率',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
