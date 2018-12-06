/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.3.10-MariaDB : Database - meiman_wallet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`meiman_wallet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `meiman_wallet`;

/*Table structure for table `mm_permission` */

DROP TABLE IF EXISTS `mm_permission`;

CREATE TABLE `mm_permission` (
  `id` int(4) NOT NULL,
  `name` varchar(10) NOT NULL COMMENT '权限名称',
  `path` varchar(30) NOT NULL COMMENT '权限路径',
  `parent` int(4) NOT NULL COMMENT '父权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mm_permission` */

insert  into `mm_permission`(`id`,`name`,`path`,`parent`) values 
(1,'全部','/',0),
(2,'签证','/api/visa',1),
(3,'签证列表','/api/vias/list',2),
(4,'签证办理','/api/visa/dovisa',2);

/*Table structure for table `mm_role` */

DROP TABLE IF EXISTS `mm_role`;

CREATE TABLE `mm_role` (
  `id` int(3) NOT NULL COMMENT 'id',
  `name` varchar(5) NOT NULL COMMENT '角色名称',
  `desc` varchar(30) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mm_role` */

insert  into `mm_role`(`id`,`name`,`desc`) values 
(1,'普通用户','普通的用户，可以登录注册使用基本功能');

/*Table structure for table `mm_role_permission` */

DROP TABLE IF EXISTS `mm_role_permission`;

CREATE TABLE `mm_role_permission` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` int(3) DEFAULT NULL COMMENT '角色id',
  `permission` int(4) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `mm_role_permission` */

insert  into `mm_role_permission`(`id`,`role`,`permission`) values 
(1,1,2),
(2,1,3),
(3,1,4);

/*Table structure for table `mm_user` */

DROP TABLE IF EXISTS `mm_user`;

CREATE TABLE `mm_user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL COMMENT '用户登录名',
  `pass` varchar(32) NOT NULL COMMENT '用户密码，md5加密',
  `role` int(3) NOT NULL COMMENT '角色Id，关联角色表',
  `rank` int(3) NOT NULL COMMENT '等级Id，关联等级表',
  `stu` int(1) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Data for the table `mm_user` */

insert  into `mm_user`(`id`,`name`,`pass`,`role`,`rank`,`stu`) values 
(1,'aiwtc','e10adc3949ba59abbe56e057f20f883e',1,1,0),
(2,'aaac','asdfsdf',1,1,1),
(3,'aaac','asdfsdf',1,1,1),
(4,'aaac','asdfsdf',1,1,1),
(5,'aaac','asdfsdf',1,1,1),
(6,'aaac','asdfsdf',1,1,1),
(7,'aaac','asdfsdf',1,1,1),
(8,'aaac','asdfsdf',1,1,1),
(9,'aaac','asdfsdf',1,1,1),
(10,'aaac','asdfsdf',1,1,1),
(11,'aaac','asdfsdf',1,1,1),
(12,'aaac','asdfsdf',1,1,1),
(13,'aaac','asdfsdf',1,1,1),
(14,'aaac','asdfsdf',1,1,1),
(15,'aaac','asdfsdf',1,1,1),
(16,'aaac','asdfsdf',1,1,1),
(17,'aaac','asdfsdf',1,1,1),
(18,'aaac','asdfsdf',1,1,1),
(19,'aaac','asdfsdf',1,1,1),
(20,'aaac','asdfsdf',1,1,1),
(21,'aaac','asdfsdf',1,1,1),
(22,'aaac','asdfsdf',1,1,1),
(23,'aaac','asdfsdf',1,1,1),
(24,'aaac','asdfsdf',1,1,1),
(25,'aaac','asdfsdf',1,1,1),
(26,'aaac','asdfsdf',1,1,1),
(27,'aaac','asdfsdf',1,1,1),
(28,'aaac','asdfsdf',1,1,1),
(29,'aaac','asdfsdf',1,1,1),
(30,'aaac','asdfsdf',1,1,1),
(31,'aaac','asdfsdf',1,1,1),
(32,'aaac','asdfsdf',1,1,1),
(33,'aaac','asdfsdf',1,1,1),
(34,'aaac','asdfsdf',1,1,1),
(35,'aaac','asdfsdf',1,1,1),
(36,'aaac','asdfsdf',1,1,1),
(37,'aaac','asdfsdf',1,1,1),
(38,'aaac','asdfsdf',1,1,1),
(39,'aaac','asdfsdf',1,1,1),
(40,'aaac','asdfsdf',1,1,1),
(41,'aaac','asdfsdf',1,1,1),
(42,'aaac','asdfsdf',1,1,1),
(43,'aaac','asdfsdf',1,1,1),
(44,'aaac','asdfsdf',1,1,1),
(45,'aaac','asdfsdf',1,1,1),
(46,'aaac','asdfsdf',1,1,1),
(47,'aaac','asdfsdf',1,1,1),
(48,'aaac','asdfsdf',1,1,1),
(49,'aaac','asdfsdf',1,1,1),
(50,'aaac','asdfsdf',1,1,1),
(51,'aaac','asdfsdf',1,1,1),
(52,'aaac','asdfsdf',1,1,1),
(53,'aaac','asdfsdf',1,1,1),
(54,'aaac','asdfsdf',1,1,1),
(55,'aaac','asdfsdf',1,1,1),
(56,'aaac','asdfsdf',1,1,1),
(57,'aaac','asdfsdf',1,1,1),
(58,'aaac','asdfsdf',1,1,1),
(59,'aaac','asdfsdf',1,1,1),
(60,'aaac','asdfsdf',1,1,1),
(61,'aaac','asdfsdf',1,1,1),
(62,'aaac','asdfsdf',1,1,1),
(63,'aaac','asdfsdf',1,1,1),
(64,'aaac','asdfsdf',1,1,1),
(65,'aaac','asdfsdf',1,1,1),
(66,'aaac','asdfsdf',1,1,1),
(67,'aaac','asdfsdf',1,1,1),
(68,'aaac','asdfsdf',1,1,1);

/*Table structure for table `mm_user_ext` */

DROP TABLE IF EXISTS `mm_user_ext`;

CREATE TABLE `mm_user_ext` (
  `id` int(5) NOT NULL COMMENT '用户id',
  `email` varchar(31) DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(16) DEFAULT NULL COMMENT '用户电话',
  `ctime` varchar(13) DEFAULT NULL COMMENT '创建时间',
  `btime` varchar(13) DEFAULT NULL COMMENT '生日',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别1男，2女'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mm_user_ext` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
