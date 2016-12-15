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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
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
  `chara13` int(11) DEFAULT NULL,
  `chara14` int(11) DEFAULT NULL,
  `chara15` int(11) DEFAULT NULL,
  `chara16` int(11) DEFAULT NULL,
  `chara17` int(11) DEFAULT NULL,
  `chara18` int(11) DEFAULT NULL,
  `chara19` int(11) DEFAULT NULL,
  `chara20` int(11) DEFAULT NULL,
  `chara21` int(11) DEFAULT NULL,
  `chara22` int(11) DEFAULT NULL,
  `chara23` int(11) DEFAULT NULL,
  `chara24` int(11) DEFAULT NULL,
  `chara25` int(11) DEFAULT NULL,
  `turn` int(11) NOT NULL,
  `bestturn` varchar(45) DEFAULT NULL,
  `gachacount` int(11) NOT NULL DEFAULT '5',
  `nextenemy` int(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `highscore` int(11) DEFAULT '0',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kojima','1111',8,2,11,5,9,6,13,16,26,23,36,51,53,50,40,50,9,3,6,9,6,4,10,10,3,4,1,1,0,'99999',275,3,35,958),(2,'akimoto','2222',7,25,8,0,1,0,2,2,5,4,7,6,7,9,4,8,0,0,1,0,0,0,0,0,1,0,0,1,0,'99999',489,2,80,875),(3,'sakoda','3333',7,8,9,1,1,1,1,1,1,1,1,2,1,2,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,'99999',5,1,0,80),(4,'aaaa','1111',4,5,6,0,0,0,3,6,2,0,0,0,1,1,1,2,1,1,2,0,0,1,3,2,1,0,0,0,0,'99999',4,2,36,0),(5,'a','a',22,7,6,0,0,0,2,1,1,1,0,0,0,0,1,0,2,0,0,1,1,0,0,2,2,1,0,0,0,'99999',0,2,112,0),(6,'1234','1234',1,2,3,3,3,2,3,2,3,1,1,1,1,1,4,2,2,1,8,3,7,1,6,5,1,7,0,0,0,'99999',0,1,0,932),(7,'aaaaa','aaaaa',2,12,14,0,1,0,0,0,2,1,0,0,0,0,1,0,1,3,0,1,1,2,0,2,1,0,0,0,0,'99999',49,1,0,1144),(8,'aaaaaq','11111',2,14,22,0,1,0,0,0,0,0,0,0,0,0,0,0,2,1,1,0,2,1,0,0,1,0,0,0,0,'99999',14,3,296,0),(9,'ああああ','ああ',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,'99999',5,1,0,0),(10,'ゆいと','ああ',1,3,2,1,2,1,0,0,0,1,2,0,1,4,1,0,0,5,2,2,1,3,2,2,3,0,0,0,0,'99999',8,1,0,1062),(11,'つかもと','7519',2,1,3,1,1,1,0,1,0,1,1,0,4,0,0,1,1,1,0,1,1,4,2,4,3,3,0,0,0,'99999',8,1,0,982),(12,'ｍｙ','m',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,'99999',5,1,0,0),(13,'my','q',12,2,24,1,2,0,1,1,1,1,1,0,1,3,2,2,1,0,2,2,1,2,2,0,1,1,1,0,0,'99999',8,1,0,940),(14,'ito_12345','aaaa',11,24,10,1,2,3,2,6,1,3,2,3,4,3,3,2,2,3,4,1,2,4,7,6,4,1,1,0,0,'99999',11,1,0,1208),(15,'888012','kaz',2,18,22,0,1,0,1,0,1,0,2,2,0,3,2,0,1,0,2,3,1,0,1,2,3,3,0,0,0,'99999',9,1,0,928),(16,'12345','54321',22,9,23,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,'99999',4,2,128,0),(17,'nekojasan','1192kamakura',12,2,13,5,2,2,3,4,3,0,1,3,4,2,8,5,4,1,2,5,6,2,4,3,8,2,0,0,0,'99999',0,1,0,1208),(18,'e1n13080','10kame03',1,2,14,1,1,0,1,1,1,0,2,2,0,2,1,2,1,1,1,2,3,0,1,2,1,2,0,0,0,'99999',8,1,0,923),(19,'りょーじ','19950923',22,13,24,5,1,3,1,4,2,2,2,2,4,1,0,5,2,5,1,4,7,1,3,7,3,2,1,0,0,'99999',11,1,0,1134),(20,'yasubey','yasu',2,13,22,0,1,0,0,0,0,1,0,0,0,1,1,1,1,2,1,0,1,0,1,0,1,0,0,0,0,'99999',0,2,128,0),(21,'てん','00000',2,14,18,0,2,0,0,0,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,'99999',4,2,128,0),(22,'aaa','aaa',19,17,6,1,2,0,0,0,1,0,1,0,0,1,2,0,0,0,0,1,1,1,0,2,1,1,0,0,0,'99999',0,3,234,0),(23,'ffffff','aaaaa',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,'99999',5,1,0,0),(24,'kkkkk','aaaaa',2,3,9,0,1,2,0,0,1,1,0,1,1,0,0,0,1,2,1,1,1,0,0,0,2,0,0,0,0,'99999',0,3,236,0),(25,'e1q08056','85372',1,7,5,4,1,0,0,2,0,1,2,0,2,1,0,1,1,1,1,1,1,0,1,2,2,2,0,0,0,'99999',9,1,0,874),(26,'~~~~~aaaa---~~~','abc',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,'99999',5,1,0,0),(27,'as','abc',10,18,22,0,1,0,0,1,0,0,2,0,1,1,0,0,0,0,0,0,1,1,0,1,2,1,0,0,0,'99999',0,2,144,0),(28,'qwerty','asdfg',2,24,11,0,1,0,2,1,0,0,1,1,2,3,0,2,1,1,0,1,2,0,1,2,3,1,1,1,0,'99999',8,1,0,864),(29,'karasuda','wataru',2,12,6,0,1,0,0,0,1,1,0,1,0,0,2,1,0,0,1,1,2,1,0,0,1,3,0,0,0,'99999',0,3,273,0),(30,'e1','e1',1,6,2,2,2,0,2,2,1,2,0,1,1,2,1,0,1,2,2,0,1,2,2,0,3,1,0,0,0,'99999',8,1,0,956),(31,'inuyosi','Inuyosi0821',1,2,24,1,2,0,2,1,0,1,1,0,3,1,2,3,3,1,1,1,3,0,0,0,4,0,2,0,0,'99999',8,1,0,981),(32,'walk_to_work','otaku',2,3,11,0,1,1,0,2,0,1,0,1,1,1,1,5,1,1,1,1,4,0,2,0,2,1,0,0,0,'99999',9,1,0,918),(33,'今でしょ！','imadesho',14,2,22,2,1,0,3,1,0,2,0,2,4,3,0,2,4,2,2,0,3,1,0,1,3,0,0,0,0,'99999',12,1,0,1280),(34,'りょーくん','ryokun',2,3,11,0,1,2,0,1,1,1,3,2,0,1,3,1,2,1,0,2,2,3,0,1,2,2,0,1,0,'99999',8,1,0,1033),(35,'heartfull_botti','aaaa',1,3,2,2,1,2,1,2,0,1,0,1,3,0,2,2,1,1,0,3,2,1,1,1,5,1,0,0,0,'99999',8,1,0,1052),(36,'akimoto2','2222',2,18,22,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,'99999',5,1,0,0),(37,'akimoto3','2222',2,6,22,0,2,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,2,0,2,0,1,2,0,0,0,'99999',33,1,0,1176);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
