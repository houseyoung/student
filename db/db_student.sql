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

 Date: 10/24/2015 00:52:59 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(1) NOT NULL COMMENT '管理员角色：1、全局管理员，2、班级管理员',
  `class_id` int(10) DEFAULT NULL COMMENT '班级ID（仅班级管理员需要）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_admin`
-- ----------------------------
BEGIN;
INSERT INTO `t_admin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '1', null), ('3', 'test', '098f6bcd4621d373cade4e832627b4f6', '123', '1', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级名称',
  `department_id` int(10) NOT NULL COMMENT '系ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_class`
-- ----------------------------
BEGIN;
INSERT INTO `t_class` VALUES ('1', '软件1班', '1'), ('2', '软件2班', '1'), ('3', '软件3班', '1'), ('7', '图书馆1班', '8'), ('9', '计算机1班', '4'), ('13', '计算机3班', '4');
COMMIT;

-- ----------------------------
--  Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程名称',
  `course_hour` int(10) DEFAULT NULL COMMENT '课时',
  `credit` int(10) DEFAULT NULL COMMENT '学分',
  `teacher_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '授课教师',
  `place` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_course`
-- ----------------------------
BEGIN;
INSERT INTO `t_course` VALUES ('1', 'C++程序设计', '30', '3', '周东岱', '314'), ('3', 'Java程序设计', '30', '4', '郑晓娟', '三阶');
COMMIT;

-- ----------------------------
--  Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '系名称',
  `school_id` int(10) NOT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_department`
-- ----------------------------
BEGIN;
INSERT INTO `t_department` VALUES ('1', '软件工程', '1'), ('4', '计算机应用技术', '2'), ('8', '图书馆学', '2');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_health`
-- ----------------------------
BEGIN;
INSERT INTO `t_health` VALUES ('1', '2011012488', '173', '60', '良好');
COMMIT;

-- ----------------------------
--  Table structure for `t_school`
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学院名称',
  `university` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学校名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- ----------------------------
--  Records of `t_school`
-- ----------------------------
BEGIN;
INSERT INTO `t_school` VALUES ('1', '信息与软件工程学院', '东北师范大学'), ('2', '计算机科学与信息技术学院', '东北师范大学'), ('7', '传媒科学学院', '东北师范大学');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_score`
-- ----------------------------
BEGIN;
INSERT INTO `t_score` VALUES ('1', '1', '2011012488', '99'), ('3', '3', '2011012488', '98'), ('4', '1', '2011012001', '60');
COMMIT;

-- ----------------------------
--  Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录密码',
  `student_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `class_id` int(10) NOT NULL COMMENT '班级ID',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `hometown` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `interest` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `t_student`
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES ('1', '2011012488', '827ccb0eea8a706c4c34a16891f84e7b', '杨昌昊', '男', '1', '1993-01-01', '山东省济南市', '计算机'), ('3', '2011012002', 'c0da6cbc0094c8bf7edad2d296a9ebe9', '李四', '女', '1', '1992-05-05', '山东省青岛市', '暂无'), ('17', '2011012001', '827ccb0eea8a706c4c34a16891f84e7b', '张三', '男', '7', '1993-06-06', '北京市', '吃饭');
COMMIT;

-- ----------------------------
--  Procedure structure for `1`
-- ----------------------------
DROP PROCEDURE IF EXISTS `1`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `1`()
    DETERMINISTIC
INSERT INTO t_class (class_name, department_id)
        VALUES ("计算机哈哈哈",
        (SELECT t_department.id FROM t_department
          WHERE department_name = "计算机应用技术"
          AND t_school.school_name = "计算机科学与信息技术学院"
          ))
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `2`
-- ----------------------------
DROP PROCEDURE IF EXISTS `2`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `2`()
SELECT id, school_id FROM t_department WHERE department_name = "软件工程"
        AND school_id = (SELECT id FROM t_school WHERE school_name = "信息与软件工程学院")
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
