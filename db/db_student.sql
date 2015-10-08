/*
 Navicat Premium Data Transfer

 Source Server         : houseyoung
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : db_student

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 10/08/2015 23:40:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` int(1) NOT NULL COMMENT '管理员角色：1、全局管理员，2、班级管理员',
  `class_id` int(10) DEFAULT NULL COMMENT '班级ID（仅班级管理员需要）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级名称',
  `department_id` int(10) NOT NULL COMMENT '系ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程名称',
  `class_hour` int(10) DEFAULT NULL COMMENT '课时',
  `credit` int(10) DEFAULT NULL COMMENT '学分',
  `place` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '系名称',
  `school_id` int(10) NOT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_department`
-- ----------------------------
BEGIN;
INSERT INTO `t_department` VALUES ('1', '软件工程', '1'), ('4', '计算机应用技术', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_health`
-- ----------------------------
DROP TABLE IF EXISTS `t_health`;
CREATE TABLE `t_health` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `height` int(3) DEFAULT NULL COMMENT '身高',
  `weight` int(3) DEFAULT NULL COMMENT '体重',
  `nutrition` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '营养状况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_school`
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学院名称',
  `university` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学校名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
--  Records of `t_school`
-- ----------------------------
BEGIN;
INSERT INTO `t_school` VALUES ('1', '信息与软件工程学院', '东北师范大学'), ('2', '计算机科学与信息技术学院', '东北师范大学');
COMMIT;

-- ----------------------------
--  Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) NOT NULL COMMENT '课程ID',
  `student_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `score` int(3) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录密码',
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `class_id` int(10) NOT NULL COMMENT '班级ID',
  `department_id` int(10) NOT NULL COMMENT '系ID',
  `school_id` int(10) NOT NULL COMMENT '学院ID',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `hometown` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `interest` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_student`
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES ('1', '2011012488', '2011012488', '杨昌昊', '男', '1', '1', '1', '1993-01-23', '山东省济南市', '读书');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('3', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1'), ('4', 'role2', '84ccdc5607f6af253d3ad709b382ef3f', '2');
COMMIT;

-- ----------------------------
--  Procedure structure for `1`
-- ----------------------------
DROP PROCEDURE IF EXISTS `1`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `1`()
SELECT * FROM t_school
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
