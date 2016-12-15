-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 150.89.234.221    Database: sfsdb
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `sfchara`
--

DROP TABLE IF EXISTS `sfchara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sfchara` (
  `charaID` int(11) NOT NULL,
  `charaname` varchar(45) NOT NULL,
  `imgaddr` varchar(45) DEFAULT NULL,
  `atk` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `rareid` double NOT NULL,
  `elm` varchar(45) NOT NULL,
  `atype` int(11) DEFAULT NULL,
  `aefe` double DEFAULT NULL,
  `学科` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`charaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sfchara`
--

LOCK TABLES `sfchara` WRITE;
/*!40000 ALTER TABLE `sfchara` DISABLE KEYS */;
INSERT INTO `sfchara` VALUES (1,'深海教授','深海教授.png',250,350,2,'1',1,500,'IS科'),(2,'井垣准教授','井垣准教授.jpg',200,400,2,'1',2,500,'IS科'),(3,'水谷准教授','水谷准教授.jpg',200,400,2,'1',3,2,'IS科'),(4,'福澤教授','福澤教授.jpg',400,300,2,'2',1,400,'IN科'),(5,'斉藤准教授','斉藤准教授.jpg',450,250,2,'2',2,400,'IS科'),(6,'山内教授','山内教授.jpg',500,200,2,'2',3,1.8,'IN科'),(7,'藤井教授','藤井教授.jpg',200,300,2,'3',1,600,'IC科'),(8,'矢野准教授','矢野准教授',250,250,2,'3',2,600,'IN科'),(9,'小西講師','小西講師.jpg',300,200,2,'3',3,2.5,'IC科'),(10,'武田君','武田君.jpg',200,300,3,'1',1,400,'IS科'),(11,'いとうくん','いとうくん.jpg',300,200,3,'1',2,400,'IS科'),(12,'アカマツ','img_12.png',400,100,3,'1',3,1.7,'IS科'),(13,'アキモト','img_13.png',100,400,3,'1',4,0.5,'IS科'),(14,'イノウエ',NULL,350,150,3,'1',1,500,'IS科'),(15,'キシケン',NULL,300,300,3,'2',1,300,'IS科'),(16,'キシモト',NULL,250,350,3,'2',2,300,'IS科'),(17,'キムラ',NULL,400,200,3,'2',3,1.4,'IS科'),(18,'コジマ',NULL,350,250,3,'2',4,0.7,'IS科'),(19,'コンドウ',NULL,350,150,3,'2',2,350,'IS科'),(20,'ツカモト',NULL,200,200,3,'3',1,500,'IS科'),(21,'ナカタ',NULL,150,250,3,'3',2,500,'IS科'),(22,'ニシムラ',NULL,250,150,3,'3',3,2,'IS科'),(23,'フジモト',NULL,200,200,3,'3',4,0.5,'IS科'),(24,'おばけパン',NULL,400,500,1,'1',1,700,'パン屋'),(25,'ねこ',NULL,500,400,1,'2',2,700,'ねこ');
/*!40000 ALTER TABLE `sfchara` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-15 15:42:09
