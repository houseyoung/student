/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.53-community-log : Database - db_student
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_student` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_student`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` int(1) NOT NULL COMMENT '管理员角色：1、全局管理员，2、班级管理员',
  `class_id` int(10) DEFAULT NULL COMMENT '班级ID（仅班级管理员需要）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_admin` */

/*Table structure for table `t_class` */

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '班级名称',
  `department_id` int(10) NOT NULL COMMENT '系ID',
  `school_id` int(10) NOT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_class` */

insert  into `t_class`(`id`,`class_name`,`department_id`,`school_id`) values (1,'软件1班',1,1),(2,'软件2班',1,1),(3,'软件3班',1,1),(7,'图书馆1班',8,2);

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '课程名称',
  `course_hour` int(10) DEFAULT NULL COMMENT '课时',
  `credit` int(10) DEFAULT NULL COMMENT '学分',
  `teacher_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '授课教师',
  `place` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上课地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_course` */

insert  into `t_course`(`id`,`course_name`,`course_hour`,`credit`,`teacher_name`,`place`) values (1,'C++程序设计',30,3,'周东岱','314');

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '系名称',
  `school_id` int(10) NOT NULL COMMENT '学院ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_department` */

insert  into `t_department`(`id`,`department_name`,`school_id`) values (1,'软件工程',1),(4,'计算机应用技术',2),(8,'图书馆学',2);

/*Table structure for table `t_health` */

DROP TABLE IF EXISTS `t_health`;

CREATE TABLE `t_health` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `height` int(3) DEFAULT NULL COMMENT '身高',
  `weight` int(3) DEFAULT NULL COMMENT '体重',
  `nutrition` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '营养状况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_health` */

/*Table structure for table `t_school` */

DROP TABLE IF EXISTS `t_school`;

CREATE TABLE `t_school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学院名称',
  `university` varchar(50) COLLATE utf8_turkish_ci NOT NULL COMMENT '学校名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

/*Data for the table `t_school` */

insert  into `t_school`(`id`,`school_name`,`university`) values (1,'信息与软件工程学院','东北师范大学'),(2,'计算机科学与信息技术学院','东北师范大学'),(7,'传媒科学学院','东北师范大学');

/*Table structure for table `t_score` */

DROP TABLE IF EXISTS `t_score`;

CREATE TABLE `t_score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) NOT NULL COMMENT '课程ID',
  `student_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '学号',
  `score` int(3) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_score` */

/*Table structure for table `t_student` */

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

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`student_id`,`password`,`name`,`sex`,`class_id`,`department_id`,`school_id`,`birthday`,`hometown`,`interest`) values (1,'2011012488','2011012488','杨昌昊','男',1,1,1,'1993-01-23','山东省济南市','读书');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`role`) values (3,'admin','21232f297a57a5a743894a0e4a801fc3','1'),(4,'role2','84ccdc5607f6af253d3ad709b382ef3f','2');

/* Procedure structure for procedure `1` */

/*!50003 DROP PROCEDURE IF EXISTS  `1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `1`()
SELECT * FROM t_school */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
