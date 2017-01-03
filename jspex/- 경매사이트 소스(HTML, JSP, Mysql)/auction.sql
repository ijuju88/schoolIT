-- MySQL dump 10.13  Distrib 5.5.12, for Win32 (x86)
--
-- Host: localhost    Database: auction
-- ------------------------------------------------------
-- Server version	5.5.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `user` char(12) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `readcnt` int(11) NOT NULL,
  `file1` text,
  `file2` text,
  `adddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `upddate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `seller` char(12) NOT NULL,
  `buyer` char(12) NOT NULL,
  `com_number` int(11) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `com_name` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `com_context` text,
  `keyword` varchar(255) DEFAULT NULL,
  `photo1` text,
  `photo2` text,
  `photo3` text,
  `readcnt` int(11) DEFAULT '0',
  `price` int(11) NOT NULL,
  `imm_price` int(11) NOT NULL,
  `deliver` char(30) DEFAULT NULL,
  `deliver_method` char(30) DEFAULT NULL,
  `cond` int(11) DEFAULT '1',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES ('leehee9090','no',1,2,'코알라','no','맛있는 코알라 팝니다요!ㅋㅋㅋㅋ',NULL,'Koala.jpg',NULL,NULL,7,205000,500000,'우체국','착불',2),('lovedad','no',1,3,'펭귄팔아요~','no','귀엽죠!? ㅋ',NULL,'Penguins.jpg',NULL,NULL,6,300000,300000,'우체국','후불',0),('jk8822','no',1,5,'국화꽃 팔아여!','no','국화꽃을 팜니다요~',NULL,'Tulips.jpg',NULL,NULL,4,11200,12000,'한진택배','착불',0),('leehee9090','no',1,6,'해파리','no','해파리 귀엽죠?',NULL,'Jellyfish1.jpg',NULL,NULL,0,50000,50000,'우체국','착불',2),('method1','no',1,7,'닌텐도 게임!','no','\r\n 화제의 닌텐도 게임입니다!! ',NULL,'nds.jpg','nds2.jpg',NULL,3,33000,150000,'우체국','후불',2),('method1','no',1,9,'미니게임기!','no','\r\n 누구나 재미있게 즐길수 있는 미니게임기입니다!^^',NULL,'game3.jpg',NULL,NULL,3,41000,85000,'한진택배','착불',2),('method2','no',1,10,'이쁜 꽃 팔아요','no','꽃이쁘죠?? ㅎ.ㅎ 빨리 사세요',NULL,'Hydrangeas.jpg',NULL,NULL,1,3000,20000,'한진택배','착불',0),('jk8822','no',1,11,'등대','no','등대팔아요ㅋ',NULL,'Lighthouse.jpg',NULL,NULL,1,81000,1000000,'한진택배','착불',2),('jk8822','no',1,12,'일렉기타','no','\r\n 싱크로율 강한 멋진 일렉기타!',NULL,'기타1.jpg',NULL,NULL,1,56000,158000,'우체국','착불',2),('jk8822','no',1,13,'통기타~','no','\r\n소리가 말고 좋은 통기타에요\r\n\r\n많이많이 사주세요! ㅠㅠ',NULL,'기타2.bmp',NULL,NULL,0,25000,120000,'한진택배','착불',1),('jk8822','no',1,14,'스윙 일렉기타','no','일렉기타의 표본이죠/! ㅎㅎㅎ',NULL,'기타3.jpg',NULL,NULL,0,55000,190000,'한진택배','착불',0),('leehee9090','no',1,15,'좋아하는 자전거!','no','자전거 갖고싶당!ㅋㅋ',NULL,'자전거1.bmp',NULL,NULL,0,3500,95000,'한진택배','착불',1),('method1','no',1,18,'플레이스테이션3','no','완전 대박 좋아!',NULL,'game13.jpg',NULL,NULL,0,15000,95000,'한진택배','착불',1),('method1','no',1,19,'아이폰','no','아이폰 꼬진거 하나 팔아요~',NULL,'아이폰.jpg',NULL,NULL,0,110000,180000,'우체국','착불',1),('lovedad','no',1,20,'갤스2','no','갤갤 갤스2!',NULL,'갤스2_1.jpg',NULL,NULL,0,150000,450000,'한진택배','착불',1),('leehee9090','no',1,21,'내 아이폰','no','ㅋㅋ 좀 망가져서 싸게팝니다\r\n\r\n아이폰 싸게 사세요!',NULL,'아이폰2.gif',NULL,NULL,0,7500,15000,'한진택배','착불',1),('leehee9090','no',1,22,'기타','no','\r\n 제가 소중히 아끼는 기타입니다~ ㅎㅎ',NULL,'기타31.jpg',NULL,NULL,0,8800,150000,'한진택배','착불',1);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` char(12) NOT NULL,
  `password` char(18) NOT NULL,
  `name` char(10) DEFAULT NULL,
  `jumin1` int(11) DEFAULT NULL,
  `jumin2` int(11) DEFAULT NULL,
  `gender` char(10) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `postnum` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phonenumber` char(20) DEFAULT NULL,
  `cellurphone` char(20) DEFAULT NULL,
  `intro` text,
  `habit` varchar(255) DEFAULT NULL,
  `account_name` char(10) DEFAULT NULL,
  `account_bank` char(20) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('jk8822','1233','이찬희',910506,1063319,'남자','ㄷㅁㄴㅇ','ㅈㅇㅈㅇ',335642,'leehee9090@naver.com','01088888999','03252311232','','','이찬희','국민은행','351-3382910-3212'),('jk9922','l07127','����',910506,1063319,'����','����� ��õ�� ��3��','���ϵ� ������',213323,'leehee9090@nate.com','0108889998','01086197758','','','����','��������','\n;\nas;\n;\n'),('leehee9090','l07127','����',910506,1063319,'����','����� ��õ�� ','��3�� ������',123323,'leehee9090@nate.com','0325640282','01086197758','','','����','��������','831-4321-12333'),('lovedad','74good','최정숙',670915,2064118,'여자','인천시 서구 당하동','122B 2L 산에들에 302호',193673,'lovedad@nate.com','0325640282','01086197758','','','최정숙','국민은행','221-2321-32122'),('method1','1579','이나리',660530,1053218,'남자','서울시 서초구 서초1동','1531-3',189753,'leehee9090@naver.com','','01055353351','안녕하세요!','','이나리','우리은행','351-2321-32122'),('method2','1233','이찬희',910506,1063319,'남자','서울시 양천구','목3동 1561-3',123232,'leehee9090@nate.com','','01086197758','','','이찬희','국민은행','95-4421-35122');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_auction`
--

DROP TABLE IF EXISTS `member_auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_auction` (
  `id` char(12) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `com_number` int(11) NOT NULL,
  `auction_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`auction_number`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_auction`
--

LOCK TABLES `member_auction` WRITE;
/*!40000 ALTER TABLE `member_auction` DISABLE KEYS */;
INSERT INTO `member_auction` VALUES ('jk8822',175000,3,13),('jk8822',15000,4,14),('jk8822',19000,1,15),('jk8822',205000,2,16),('leehee9090',15000,4,17),('leehee9090',19000,1,18),('leehee9090',10200,5,19),('leehee9090',205000,2,20),('leehee9090',180000,3,21),('jk8822',11200,5,22),('jk8822',33000,7,23),('jk8822',94000,8,24),('jk8822',41000,9,25),('method2',41000,9,26),('jk8822',3000,10,27),('leehee9090',81000,11,28),('leehee9090',56000,12,29);
/*!40000 ALTER TABLE `member_auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_buy`
--

DROP TABLE IF EXISTS `member_buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_buy` (
  `id` char(12) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `com_number` int(11) NOT NULL,
  `buy_number` int(11) NOT NULL AUTO_INCREMENT,
  `cond` int(11) DEFAULT '1',
  PRIMARY KEY (`buy_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_buy`
--

LOCK TABLES `member_buy` WRITE;
/*!40000 ALTER TABLE `member_buy` DISABLE KEYS */;
INSERT INTO `member_buy` VALUES ('jk8822',11200,5,1,1),('jk8822',205000,2,2,1),('jk8822',3000,10,3,1),('leehee9090',81000,11,4,1),('jk8822',33000,7,5,1),('leehee9090',56000,12,6,1),('leehee9090',190000,14,7,1),('leehee9090',190000,14,8,1),('method1',50000,6,9,1),('method1',50000,6,10,1),('method1',300000,3,11,1),('jk8822',41000,9,12,1);
/*!40000 ALTER TABLE `member_buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_sell`
--

DROP TABLE IF EXISTS `member_sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_sell` (
  `id` char(12) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `com_number` int(11) NOT NULL,
  `sell_number` int(11) NOT NULL AUTO_INCREMENT,
  `cond` int(11) DEFAULT '1',
  PRIMARY KEY (`sell_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_sell`
--

LOCK TABLES `member_sell` WRITE;
/*!40000 ALTER TABLE `member_sell` DISABLE KEYS */;
INSERT INTO `member_sell` VALUES ('jk8822',11200,5,1,1),('leehee9090',205000,2,2,1),('method2',3000,10,3,1),('jk8822',81000,11,4,1),('method1',33000,7,5,1),('jk8822',56000,12,6,1),('jk8822',190000,14,7,1),('jk8822',190000,14,8,1),('leehee9090',50000,6,9,1),('leehee9090',50000,6,10,1),('lovedad',300000,3,11,1),('method1',41000,9,12,1);
/*!40000 ALTER TABLE `member_sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qa`
--

DROP TABLE IF EXISTS `qa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qa` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `user` char(12) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `readcnt` int(11) NOT NULL,
  `file1` text,
  `file2` text,
  `adddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `upddate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qa`
--

LOCK TABLES `qa` WRITE;
/*!40000 ALTER TABLE `qa` DISABLE KEYS */;
/*!40000 ALTER TABLE `qa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zipcode`
--

DROP TABLE IF EXISTS `zipcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipcode` (
  `zipcode` char(7) DEFAULT NULL,
  `sido` char(4) DEFAULT NULL,
  `gugun` char(17) DEFAULT NULL,
  `dong` varchar(52) DEFAULT NULL,
  `bunji` varchar(17) DEFAULT NULL,
  `seq` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zipcode`
--

LOCK TABLES `zipcode` WRITE;
/*!40000 ALTER TABLE `zipcode` DISABLE KEYS */;
/*!40000 ALTER TABLE `zipcode` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-06-20 22:52:39
