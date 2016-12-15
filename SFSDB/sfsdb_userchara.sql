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
-- Table structure for table `userchara`
--

DROP TABLE IF EXISTS `userchara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userchara` (
  `userID` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `slot1` int(11) DEFAULT NULL,
  `slot2` int(11) DEFAULT NULL,
  `slot3` int(11) DEFAULT NULL,
  `chara1` int(11) DEFAULT NULL,
  `chara2` int(11) DEFAULT NULL,
  `chara3` int(11) DEFAULT NULL,
  `chara4` int(11) DEFAULT NULL,
  `chara5` int(11) DEFAULT NULL,
  `chara6` int(11) DEFAULT NULL,
  `chara7` int(11) DEFAULT NULL,
  `chara8` int(11) DEFAULT NULL,
  `chara9` int(11) DEFAULT NULL,
  `chara10` int(11) DEFAULT NULL,
  `chara11` int(11) DEFAULT NULL,
  `chara12` int(11) DEFAULT NULL,
  `cahra13` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userchara`
--

LOCK TABLES `userchara` WRITE;
/*!40000 ALTER TABLE `userchara` DISABLE KEYS */;
INSERT INTO `userchara` VALUES (1,'kojima','1111',1,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1),(2,'akimoto','2222',4,5,6,0,0,0,1,1,1,1,1,1,1,1,1,0),(3,'sakoda','3333',7,8,9,1,1,1,1,1,1,1,1,1,1,1,0,0);
/*!40000 ALTER TABLE `userchara` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-15 15:42:10
