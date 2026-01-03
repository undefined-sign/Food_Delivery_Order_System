/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.39 : Database - food_delivery_order_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`food_delivery_order_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `food_delivery_order_system`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`descn`) values (1,'酒水饮料','各类饮品和酒水'),(2,'凉菜','开胃凉拌菜品'),(3,'热菜','现炒热食主菜'),(4,'主食','米饭面条等主食');

/*Table structure for table `discount` */

DROP TABLE IF EXISTS `discount`;

CREATE TABLE `discount` (
  `level` enum('1','2','3','4','5','6') NOT NULL,
  `discount_rate` decimal(4,2) NOT NULL,
  PRIMARY KEY (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `discount` */

insert  into `discount`(`level`,`discount_rate`) values ('1','0.98'),('2','0.95'),('3','0.90'),('4','0.85'),('5','0.80'),('6','0.75');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `member_number` int NOT NULL AUTO_INCREMENT,
  `level` enum('1','2','3','4','5','6') DEFAULT '1',
  `points` int DEFAULT '0',
  `tel` varchar(50) NOT NULL,
  PRIMARY KEY (`member_number`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `member` */

insert  into `member`(`member_number`,`level`,`points`,`tel`) values (1001,'1',109,'19562578965'),(1002,'6',1086,'19568975624'),(1003,'2',1001,'18345697852');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `category_id` int NOT NULL,
  `quity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `idx_dish_name` (`dish_name`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `menu_chk_1` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `menu` */

insert  into `menu`(`id`,`dish_name`,`price`,`category_id`,`quity`) values (1,'鲜榨橙汁','20.00',1,49),(2,'冰镇酸梅汤','18.00',1,50),(3,'椰汁西米露','28.00',1,50),(4,'青岛啤酒','15.00',1,100),(5,'铁观音茶','20.00',1,99),(6,'凉拌黄瓜','16.00',2,100),(7,'酱香牛肉','48.00',2,100),(8,'酸辣木耳','22.00',2,100),(9,'皮蛋豆腐','26.00',2,0),(10,'口水鸡','38.00',2,100),(11,'宫保鸡丁','42.00',3,100),(12,'水煮牛肉','68.00',3,100),(13,'麻婆豆腐','36.00',3,100),(14,'清蒸鲈鱼','88.00',3,100),(15,'红烧排骨','58.00',3,100),(16,'扬州炒饭','28.00',4,100),(17,'葱油拌面','22.00',4,100),(18,'猪肉水饺','32.00',4,100),(19,'鲜肉小笼包','26.00',4,100),(20,'三鲜炒米粉','30.00',4,100),(21,'农夫山泉','3.00',1,50),(22,'冰红茶','3.00',1,50),(23,'凉拌三丝','15.00',2,50),(24,'大盘鸡','25.00',3,0),(25,'牛肉拌面','14.00',4,50),(28,'绿茶','3.00',1,500),(29,'海碧','2.00',1,500);

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `menu_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_header` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `order_detail_chk_1` CHECK ((`quantity` > 0)),
  CONSTRAINT `order_detail_chk_2` CHECK ((`price` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order_detail` */

insert  into `order_detail`(`id`,`order_id`,`menu_id`,`quantity`,`price`) values (25,23,1,2,'25.00'),(26,23,2,1,'18.00'),(27,24,20,2,'29.40'),(29,25,9,1,'19.50'),(30,26,16,1,'28.00'),(34,29,5,1,'20.00'),(36,30,1,1,'19.60');

/*Table structure for table `order_header` */

DROP TABLE IF EXISTS `order_header`;

CREATE TABLE `order_header` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT '0.00',
  `STATUS` enum('00','01','10') NOT NULL DEFAULT '00',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `idx_order_time` (`order_time`),
  CONSTRAINT `order_header_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order_header` */

insert  into `order_header`(`id`,`user_id`,`address`,`order_time`,`total_amount`,`STATUS`) values (23,1001,'河南科技大学西苑校区北院','2025-12-31 11:54:32','68.00','01'),(24,1001,'河南科技大学西苑校区北院','2025-12-31 11:54:52','58.80','10'),(25,1004,'河南科技大学西苑校区南院','2025-12-31 11:55:51','19.50','01'),(26,1004,'河南科技大学西苑校区南院','2025-12-31 11:56:07','28.00','10'),(29,1001,'河南科技大学西苑北院','2026-01-02 20:53:36','20.00','01'),(30,1001,'河南科技大学西苑北院','2026-01-02 21:14:33','19.60','00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` enum('男','女','其他') NOT NULL,
  `tel` varchar(50) NOT NULL,
  `STATUS` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1018 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`sex`,`tel`,`STATUS`) values (1001,'张三','zhangsan123','男','13800010001','0'),(1002,'李四','lisi456','男','13900020002','1'),(1003,'王芳','wangfang789','女','13700030003','1'),(1004,'刘洋','liuyang111','男','13600040004','0'),(1005,'陈婷','chenting222','女','13500050005','0'),(1006,'赵敏','zhaomin333','女','13400060006','0'),(1007,'周杰','zhoujie444','男','13300070007','0'),(1008,'吴倩','wuqian555','女','13200080008','0'),(1009,'郑浩','zhenghao666','男','13100090009','1'),(1010,'孙莉','sunli777','女','13000100010','0'),(1012,'马超','machao999','男','15100120012','0'),(1016,'张三2','zjy123456','男','19562576829','0'),(1017,'Tom','tom123654','男','19568798536','0');

/* Trigger structure for table `member` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `level_points` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `level_points` BEFORE UPDATE ON `member` FOR EACH ROW BEGIN
    -- 仅在积分增加时触发
    IF NEW.points > OLD.points THEN
        -- 计算新等级（每1000分升1级，最高6级）
        SET @calc_level = LEAST(FLOOR(NEW.points / 1000) + 1, 6);
        
        -- 仅当新等级高于原等级时更新
        IF @calc_level > OLD.level THEN
            SET NEW.level = @calc_level;
        END IF;
    END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `order_detail` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `insert_order_total` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `insert_order_total` AFTER INSERT ON `order_detail` FOR EACH ROW BEGIN
  UPDATE order_header oh
  SET total_amount = (
    SELECT SUM(price * quantity)
    FROM order_detail
    WHERE order_id = NEW.order_id
  )
  WHERE id = NEW.order_id;
  
END */$$


DELIMITER ;

/* Trigger structure for table `order_detail` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_menu_quantity` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_menu_quantity` AFTER INSERT ON `order_detail` FOR EACH ROW BEGIN
    UPDATE menu
    SET quity = quity - NEW.quantity
    WHERE id = NEW.menu_id;
END */$$


DELIMITER ;

/* Trigger structure for table `order_detail` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `delete_order_detail` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `delete_order_detail` AFTER DELETE ON `order_detail` FOR EACH ROW BEGIN
    -- 更新订单总金额
    UPDATE order_header oh
    SET total_amount = (
        SELECT SUM(price * quantity)
        FROM order_detail
        WHERE order_id = OLD.order_id
    )
    WHERE id = OLD.order_id;
    
 
END */$$


DELIMITER ;

/* Trigger structure for table `order_detail` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `restore_menu_quantity` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `restore_menu_quantity` AFTER DELETE ON `order_detail` FOR EACH ROW BEGIN
    -- 恢复库存
    UPDATE menu
    SET quity = quity + OLD.quantity
    WHERE id = OLD.menu_id;
    
    -- 检查订单是否为空
    SET @detail_count = (
        SELECT COUNT(*) 
        FROM order_detail 
        WHERE order_id = OLD.order_id
    );
    
    -- 如果订单为空，删除订单头
    IF @detail_count = 0  THEN
        DELETE FROM order_header WHERE id = OLD.order_id;
    END IF;
END */$$


DELIMITER ;

/*Table structure for table `member_discount_view` */

DROP TABLE IF EXISTS `member_discount_view`;

/*!50001 DROP VIEW IF EXISTS `member_discount_view` */;
/*!50001 DROP TABLE IF EXISTS `member_discount_view` */;

/*!50001 CREATE TABLE  `member_discount_view`(
 `member_number` int ,
 `member_level` enum('1','2','3','4','5','6') ,
 `points` int ,
 `discount_rate` decimal(4,2) ,
 `tel` varchar(50) 
)*/;

/*Table structure for table `order_summary_view` */

DROP TABLE IF EXISTS `order_summary_view`;

/*!50001 DROP VIEW IF EXISTS `order_summary_view` */;
/*!50001 DROP TABLE IF EXISTS `order_summary_view` */;

/*!50001 CREATE TABLE  `order_summary_view`(
 `用户账号` int ,
 `用户名` varchar(50) ,
 `订单号` int ,
 `类别` varchar(50) ,
 `菜名` varchar(100) ,
 `菜品编号` int ,
 `单价` decimal(10,2) ,
 `数量` int ,
 `地址` varchar(255) ,
 `下单日期` date ,
 `总金额` decimal(20,2) ,
 `状态` enum('00','01','10') 
)*/;

/*View structure for view member_discount_view */

/*!50001 DROP TABLE IF EXISTS `member_discount_view` */;
/*!50001 DROP VIEW IF EXISTS `member_discount_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `member_discount_view` AS select `m`.`member_number` AS `member_number`,`m`.`level` AS `member_level`,`m`.`points` AS `points`,`d`.`discount_rate` AS `discount_rate`,`m`.`tel` AS `tel` from (`member` `m` join `discount` `d` on((`m`.`level` = `d`.`level`))) */;

/*View structure for view order_summary_view */

/*!50001 DROP TABLE IF EXISTS `order_summary_view` */;
/*!50001 DROP VIEW IF EXISTS `order_summary_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `order_summary_view` AS select `u`.`id` AS `用户账号`,`u`.`name` AS `用户名`,`oh`.`id` AS `订单号`,`c`.`name` AS `类别`,`m`.`dish_name` AS `菜名`,`m`.`id` AS `菜品编号`,`od`.`price` AS `单价`,`od`.`quantity` AS `数量`,`oh`.`address` AS `地址`,cast(`oh`.`order_time` as date) AS `下单日期`,(`od`.`price` * `od`.`quantity`) AS `总金额`,`oh`.`STATUS` AS `状态` from ((((`order_header` `oh` join `order_detail` `od` on((`oh`.`id` = `od`.`order_id`))) join `menu` `m` on((`od`.`menu_id` = `m`.`id`))) join `category` `c` on((`m`.`category_id` = `c`.`id`))) join `user` `u` on((`oh`.`user_id` = `u`.`id`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
