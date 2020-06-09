/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.9-log : Database - food_sys_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`food_sys_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `food_sys_db`;

/*Table structure for table `tb_food_item` */

DROP TABLE IF EXISTS `tb_food_item`;

CREATE TABLE `tb_food_item` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` int(100) DEFAULT NULL,
  `qty` int(100) DEFAULT NULL,
  `food_category_id` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_category_id` (`food_category_id`),
  CONSTRAINT `tb_food_item_ibfk_1` FOREIGN KEY (`food_category_id`) REFERENCES `tb_item_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tb_food_item` */

insert  into `tb_food_item`(`id`,`name`,`price`,`qty`,`food_category_id`) values (5,'Veg Burger',480,NULL,3),(6,'Double Cheese Burger',550,NULL,3),(7,'Pepsi 1.5L',100,NULL,4),(8,'7up 1.5L',100,NULL,4),(9,'Fanta 1.5L',100,NULL,4),(10,'Club Sandwhich',150,NULL,5);

/*Table structure for table `tb_item_category` */

DROP TABLE IF EXISTS `tb_item_category`;

CREATE TABLE `tb_item_category` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_item_category` */

insert  into `tb_item_category`(`id`,`name`) values (3,'Burger'),(4,'Drinks'),(5,'Sandwhich');

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `item_qty` int(100) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_time` time DEFAULT NULL,
  `staff_id` int(100) DEFAULT NULL,
  `amount` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

insert  into `tb_order`(`id`,`item_qty`,`order_date`,`order_time`,`staff_id`,`amount`) values (8,5,'2020-02-23','03:01:37',4,2300),(9,5,'2020-02-23','03:07:46',4,1500),(10,2,'2020-02-23','03:14:48',5,200),(11,2,'2020-02-23','03:21:50',5,200),(12,6,'2020-02-25','13:14:35',4,1740);

/*Table structure for table `tb_order_details` */

DROP TABLE IF EXISTS `tb_order_details`;

CREATE TABLE `tb_order_details` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `order_id` int(100) DEFAULT NULL,
  `qty` int(100) DEFAULT NULL,
  `food_item_id` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `food_item_id` (`food_item_id`),
  CONSTRAINT `tb_order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`id`),
  CONSTRAINT `tb_order_details_ibfk_2` FOREIGN KEY (`food_item_id`) REFERENCES `tb_food_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `tb_order_details` */

insert  into `tb_order_details`(`id`,`order_id`,`qty`,`food_item_id`) values (7,8,4,6),(8,8,1,9),(9,9,2,10),(10,9,2,6),(11,9,1,9),(12,10,2,7),(13,11,2,7),(14,12,3,5),(15,12,3,8);

/*Table structure for table `tb_staff` */

DROP TABLE IF EXISTS `tb_staff`;

CREATE TABLE `tb_staff` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_staff` */

insert  into `tb_staff`(`id`,`name`,`email`,`username`,`password`) values (4,'Ali','ali@gmail.com','ali','122'),(5,'Alia','ali@gmail.com','alia','132'),(6,'sano','s@gmail.com','sano','s');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
