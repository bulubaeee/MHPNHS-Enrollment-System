-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: dbsoria
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('ambyu','lance'),('bet','log'),('gab','semana'),('hos','a7bjgobt'),('shaine','ky');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `username` varchar(255) NOT NULL,
  `password` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('alizzah',_binary 'æã%OK√ôO√ëOÅ(0\’\n'),('francis',_binary 'JáûH¥2?ö\»\∆y¶\œ$h'),('juan',_binary 'ªëR\»\—TÙìT7B\n4≤'),('lance',_binary 'º\≈\Íı˚q}»¶	,\ o\Õ\·E'),('tongbe',_binary 'E\ÓR\nS8ts~tÀ∑\Ë1');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `user` varchar(255) NOT NULL,
  `path` tinyblob,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES ('aa',_binary 'C:\\Users\\buluba\\Desktop\\icon\\checklist.png'),('francis',_binary 'C:\\Users\\buluba\\Desktop\\gosu.jpg'),('gg',_binary 'C:\\Users\\buluba\\Desktop\\gosu.jpg');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poweruser`
--

DROP TABLE IF EXISTS `poweruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poweruser` (
  `pu` int(1) DEFAULT NULL,
  `sy_index` int(10) DEFAULT NULL,
  `sem_index` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poweruser`
--

LOCK TABLES `poweruser` WRITE;
/*!40000 ALTER TABLE `poweruser` DISABLE KEYS */;
INSERT INTO `poweruser` VALUES (0,2,2);
/*!40000 ALTER TABLE `poweruser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblacc`
--

DROP TABLE IF EXISTS `tblacc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblacc` (
  `username` varchar(255) NOT NULL,
  `password` varbinary(255) DEFAULT NULL,
  `signed` int(1) DEFAULT NULL,
  `first` int(1) DEFAULT NULL,
  `blocked` int(1) DEFAULT NULL,
  `attempts` int(1) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `admin` int(1) DEFAULT NULL,
  `bday` varchar(255) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `secret_question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `archive` int(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblacc`
--

LOCK TABLES `tblacc` WRITE;
/*!40000 ALTER TABLE `tblacc` DISABLE KEYS */;
INSERT INTO `tblacc` VALUES ('123',_binary 'Mw	ô¥˛\∆Kπ∞w',0,1,0,0,'asd','asd','asd',1,'January 1, 2016',4,'What was your first pet`s name?','asd','4234','Female','Master Teacher II',0),('aa',_binary 'Y1.%^¢¨˝õx)\Óı¡Ω',0,1,0,0,'Char','E D','Gar',1,'January 1, 2015',5,'What was your first pet`s name?','hos','0932332','Female','Teacher I',0),('abc',_binary '\€_ö|Ø\“u\ \¬¢\…',0,1,0,0,'fsdfds','fdsfs','fdsf',1,'January 1, 2015',5,'What was your first pet`s name?','hos','fdsf','null','Other',0),('asd',_binary 'U–Ä*Ω\»\ÂT?\Â$Tm	Ä',0,1,0,0,'asd','asd','asd',1,'January 1, 2017',3,'What`s the name of your first Teacher','fdg','2','Female','Master Teacher I',0),('charlemagnechaves',_binary 'äÇ7\rG≤T1\ZMàó¸\Ó\Ô…Ö<•\‰Ú\…V≠∏¢@,¥',0,1,0,0,'Charlemagne Fitch Moriah','Dumaquita','Chaves',1,'January 12, 1998',21,'What was your first pet`s name?','almond','0997922918//8','Female','Teacher I',0),('dfgdfgd',_binary '\·4G≤Xïÿ™`\\jZi°_',0,0,0,0,'gfdgdfg','dfgdfg','gdfgdfhd',1,'January 1, 2014',6,'What`s the name of the city where your parents met?','fdsfds','432432','Female','Teacher III',0),('dfsf',_binary 'jÙ\ŸQ\ÎümvPOC¸p5\‚F',0,0,0,0,'fdsf','fdsf','fdsf',1,'January 1, 2016',4,'What`s the name of the city where your parents met?','fdsf','423','Female','Master Teacher I',0),('fdsfds',_binary '{µwµ†õ{+Tmˆ°t',0,0,0,0,'fdsf','fdsf','aa',1,'January 1, 2017',3,'What`s the name of the city where you were born?','fdsf','fds','Male','Teacher I',0),('fdsfdsf',_binary 'H\n[\’I%Ã±äçic;\Z',0,0,0,0,'fdsf','dsfdsf','fdsfdsf',0,'January 20, 2017',3,'What`s the name of the city where your parents met?','fdsfdsfdsf','43242','Female','Administrator',0),('fq',_binary 'ò]∆ñ!M;YÒ√¶ïU¯#=',0,1,0,0,'Francis','Clemente','comboy',1,'January 1, 2005',15,'What was your first pet`s name?','hos','1','Male','Administrative officer II',0),('francis',_binary 'à)\“&Ú\ÌôR\Œ\rF\Zj',0,1,0,0,'Francis','Dela Rama','Comboy',1,'May 1, 1998',21,'What was your first pet`s name?','Hos','','Male','Master Teacher III',0),('francisqwaszx',_binary 'JáûH¥2?ö\»\∆y¶\œ$h',0,1,0,0,'Francis','Clemente','Comboy',1,'May 1, 1996',23,'What`s the name of the city where your parents met?','malolos','09437437','Male','Teacher III',0),('fsdf',_binary 'g\Âo1kz•/¨˝ò\ŸC°',0,0,0,0,'fdsf','fdsf','fdhg',1,'January 1, 2016',4,'What`s the name of the city where your parents met?','gdfg','432','Female','Master Teacher I',0),('gdfg',_binary 'π˙;\”Pä8\›9T%5LXo§',0,0,0,0,'fdsf','gdfgd','gfdhdj',1,'January 1, 2015',5,'What`s the name of the city where your parents met?','dsgfdg','4324','null','Teacher I',0),('gems',_binary 'lo\Í)¸!\0\03&+ø',0,1,0,0,'Christian','Gems','Simeon',0,'December 1, 1950',69,'What`s the name of the city where you were born?','gdfg','3012938','Male','Special Science Teacher I',0),('gg',_binary '\ŒJ\\{\Ôõ\÷%\‹Q±\Ÿ`∏8',0,1,0,0,'ggghyh','gg','gg',0,'March 1, 2016',3,'What was your first pet`s name?','gg','464646','Male','Teacher I',0),('ghdfhdgdf',_binary 'èÅƒØL`\Âm∑¢®âó',0,0,0,0,'fds','fdsf','fds',1,'January 1, 2015',5,'What`s the name of the city where your parents met?','fsdf','4324','Female','Teacher I',0),('hehe',_binary '\Ë^\«X~Q=¿]∫+˘',0,1,0,0,'hehe','hehe','hehe',1,'January 1, 2017',3,'What`s the name of the city where your parents met?','hehe','123','Female','Master Teacher II',0),('hhh',_binary 'Ä3U©dÅ”ΩÛ/`¥Û',0,0,0,0,'hhh','hhh','hhh',1,'January 1, 2015',5,'What was your first pet`s name?','hos','hhh','null','Teacher I',0),('pao',_binary 'q≥.4D	36\ÈV^ò\Zl',0,1,0,0,'Paolo','F','De Guzman',1,'January 1, 1994',26,'What was your first pet`s name?','hos','42352352352','Male','Teacher III',0),('qw',_binary 'µ\›]7{°oö0º5\÷\Àf',0,1,0,0,'qq','qq','qq',1,'January 1, 2017',3,'What`s the name of the city where your parents met?','qq','1','null','Master Teacher I',0),('qwe',_binary 'Ú[\“[Æ∏ﬂºøÑrî#M;',0,1,0,0,'qwe','qwe','qwe',1,'January 1, 2016',4,'What`s the name of the city where your parents met?','qwe','12','null','Teacher I',0),('sfdsgsdhg',_binary 'ì\ÎQ~{ÄMj’í{≤¬é\√\·',0,0,0,0,'fdsf','sdf','fdsf',1,'January 1, 2016',4,'What`s the name of the city where your parents met?','fgdsgf','4324','Female','Teacher I',0),('User',_binary '¸¥|ì?áÅ§\‘˙\È/˝',0,1,0,0,'User','User','User',0,'January 1, 2017',3,'What was your first pet`s name?','Hos','312301230','Male','Registrar',0);
/*!40000 ALTER TABLE `tblacc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblhistory`
--

DROP TABLE IF EXISTS `tblhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhistory` (
  `user` varchar(255) DEFAULT NULL,
  `ginawa` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhistory`
--

LOCK TABLES `tblhistory` WRITE;
/*!40000 ALTER TABLE `tblhistory` DISABLE KEYS */;
INSERT INTO `tblhistory` VALUES ('aa',' has archived fds, ffds, fdsf','2020/02/18 16:34:11'),('aa',' has archived fds, ffdsf, fdsf','2020/02/18 16:34:12'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/18 16:34:12'),('aa',' has archived Comboy, Francis','2020/02/18 16:34:12'),('aa',' has archived fdsfdsf, dsfdsf, dsfds','2020/02/18 16:34:13'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/18 16:34:13'),('aa',' has archived fdsfsdfdsf, sdfds, sdfdsf','2020/02/18 16:34:14'),('aa',' has archived gdf, gfdgdf, gdfgdf','2020/02/18 16:34:15'),('aa',' has archived sdfd, sfsdf, fdsf','2020/02/18 16:34:15'),('aa',' has archived fds, fdsfsd, fdsfds','2020/02/18 16:34:15'),('aa',' has archived fds, fdsfsdhfgh, fdsfds','2020/02/18 16:34:16'),('aa',' has archived fdsf, dsfdsf, dsfdsf','2020/02/18 16:34:16'),('aa',' has archived gfdsfdsfdsfsf, fdsfds, fdsfhgdfh','2020/02/18 16:34:16'),('aa',' has archived sdfdsfdsfdsfdsf, fdsfds, fdsfsdfs','2020/02/18 16:34:17'),('aa',' has archived fsfdsfdsf, fdsf, dsfdsfdsfds','2020/02/18 16:34:18'),('aa',' has archived fdsf, fsfs, fdsfds','2020/02/18 16:34:18'),('francis',' has retrieved a ','2020/02/18 16:34:28'),('francis',' has retrieved a ','2020/02/18 16:34:28'),('francis',' has retrieved a ','2020/02/18 16:34:28'),('francis',' has retrieved a ','2020/02/18 16:34:29'),('francis',' has retrieved a ','2020/02/18 16:34:29'),('francis',' has retrieved a ','2020/02/18 16:34:29'),('francis',' has retrieved a ','2020/02/18 16:34:29'),('francis',' has retrieved a ','2020/02/18 16:34:29'),('francis',' has retrieved a ','2020/02/18 16:34:30'),('francis',' has retrieved a ','2020/02/18 16:34:30'),('francis',' has retrieved a ','2020/02/18 16:34:30'),('francis',' has retrieved a ','2020/02/18 16:34:30'),('francis',' has retrieved a ','2020/02/18 16:34:31'),('francis',' has retrieved a ','2020/02/18 16:34:31'),('francis',' has retrieved a ','2020/02/18 16:34:31'),('francis',' has retrieved a ','2020/02/18 16:34:31'),('aa',' has archived fds, ffdsf, fdsf','2020/02/18 16:37:46'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/18 16:37:46'),('aa',' has archived sdfd, sfsdf, fdsf','2020/02/18 16:37:46'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/18 16:37:52'),('aa',' has retrieved fgdfgdf, gfdgdf gfdgfd','2020/02/18 16:37:53'),('aa',' has retrieved sdfd, sfsdf fdsf','2020/02/18 16:37:53'),('aa',' has archived fds, ffdsf, fdsf','2020/02/18 17:34:08'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/18 17:34:09'),('aa',' has archived Comboy, Francis','2020/02/18 17:34:10'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/18 17:43:52'),('aa',' has retrieved fdsf, fdsf fdsfds','2020/02/18 17:43:52'),('aa',' has retrieved Comboy, Francis ','2020/02/18 17:43:52'),('aa',' has archived fds, ffds, fdsf','2020/02/18 17:44:00'),('aa',' has archived fds, ffdsf, fdsf','2020/02/18 17:44:00'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/18 17:44:01'),('aa',' has archived Comboy, Francis','2020/02/18 17:44:01'),('aa',' has archived fdsfdsf, dsfdsf, dsfds','2020/02/18 17:44:01'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/18 17:44:02'),('aa',' has archived fdsfsdfdsf, sdfds, sdfdsf','2020/02/18 17:44:02'),('aa',' has archived gdf, gfdgdf, gdfgdf','2020/02/18 17:44:02'),('aa',' has archived sdfd, sfsdf, fdsf','2020/02/18 17:44:03'),('aa',' has archived fds, fdsfsd, fdsfds','2020/02/18 17:44:03'),('aa',' has archived fds, fdsfsdhfgh, fdsfds','2020/02/18 17:44:03'),('aa',' has archived fdsf, dsfdsf, dsfdsf','2020/02/18 17:44:03'),('aa',' has archived gfdsfdsfdsfsf, fdsfds, fdsfhgdfh','2020/02/18 17:44:04'),('aa',' has archived sdfdsfdsfdsfdsf, fdsfds, fdsfsdfs','2020/02/18 17:44:04'),('aa',' has archived fsfdsfdsf, fdsf, dsfdsfdsfds','2020/02/18 17:44:05'),('aa',' has archived fdsf, fsfs, fdsfds','2020/02/18 17:44:05'),('aa',' has retrieved fds, ffds fdsf','2020/02/18 18:36:43'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/18 18:36:43'),('aa',' has retrieved fdsf, fdsf fdsfds','2020/02/18 18:36:43'),('aa',' has retrieved Comboy, Francis ','2020/02/18 18:36:44'),('aa',' has retrieved fdsfdsf, dsfdsf dsfds','2020/02/18 18:36:44'),('aa',' has retrieved fgdfgdf, gfdgdf gfdgfd','2020/02/18 18:36:44'),('aa',' has retrieved fdsfsdfdsf, sdfds sdfdsf','2020/02/18 18:36:45'),('aa',' has retrieved gdf, gfdgdf gdfgdf','2020/02/18 18:36:45'),('aa',' has retrieved sdfd, sfsdf fdsf','2020/02/18 18:36:45'),('aa',' has retrieved fds, fdsfsd fdsfds','2020/02/18 18:36:45'),('aa',' has retrieved fds, fdsfsdhfgh fdsfds','2020/02/18 18:36:45'),('aa',' has retrieved fdsf, dsfdsf dsfdsf','2020/02/18 18:36:45'),('aa',' has retrieved gfdsfdsfdsfsf, fdsfds fdsfhgdfh','2020/02/18 18:36:46'),('aa',' has retrieved sdfdsfdsfdsfdsf, fdsfds fdsfsdfs','2020/02/18 18:36:46'),('aa',' has retrieved fsfdsfdsf, fdsf dsfdsfdsfds','2020/02/18 18:36:46'),('aa',' has retrieved fdsf, fsfs fdsfds','2020/02/18 18:36:46'),('aa',' has archived fds, ffds, fdsf','2020/02/18 19:56:49'),('aa',' has archived fds, ffdsf, fdsf','2020/02/18 19:56:49'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/18 19:56:49'),('aa',' has archived Comboy, Francis','2020/02/18 19:56:50'),('aa',' has archived fdsfdsf, dsfdsf, dsfds','2020/02/18 19:56:50'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/18 19:56:50'),('aa',' has archived sdfd, sfsdf, fdsf','2020/02/18 21:08:21'),('aa',' has archived sdfdsfdsfdsfdsf, fdsfds, fdsfsdfs','2020/02/18 21:08:21'),('aa',' has retrieved fds, ffds fdsf','2020/02/18 22:33:50'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/18 22:33:50'),('aa',' has retrieved Comboy, Francis ','2020/02/18 22:33:50'),('aa',' has archived fds, ffdsf, fdsf','2020/02/19 19:02:48'),('aa',' has archived fdsfsdfdsf, sdfds, sdfdsf','2020/02/19 19:02:48'),('aa',' has archived fds, fdsfsd, fdsfds','2020/02/19 19:02:49'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/19 19:02:57'),('aa',' has retrieved fdsf, fdsf fdsfds','2020/02/19 19:02:58'),('aa',' has retrieved fdsfdsf, dsfdsf dsfds','2020/02/19 19:02:58'),('aa',' has retrieved fgdfgdf, gfdgdf gfdgfd','2020/02/19 19:02:58'),('aa',' has retrieved fdsfsdfdsf, sdfds sdfdsf','2020/02/19 19:02:59'),('aa',' has retrieved sdfd, sfsdf fdsf','2020/02/19 19:02:59'),('aa',' has retrieved fds, fdsfsd fdsfds','2020/02/19 19:02:59'),('aa',' has retrieved sdfdsfdsfdsfdsf, fdsfds fdsfsdfs','2020/02/19 19:03:00'),('aa',' has archived fds, ffds, fdsf','2020/02/19 19:20:36'),('aa',' has archived fds, ffdsf, fdsf','2020/02/19 19:20:36'),('aa',' has archived fdsfdsf, dsfdsf, dsfds','2020/02/19 19:20:37'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/19 19:20:37'),('aa',' has archived fdsfsdfdsf, sdfds, sdfdsf','2020/02/19 19:20:38'),('aa',' has archived sdfd, sfsdf, fdsf','2020/02/19 19:20:38'),('aa',' has enrolled a student','2020/02/19 19:21:15'),('aa',' has added fdsf, fdsf, fdsfsd to the masterlist','2020/02/19 19:23:46'),('aa',' has added fdsf, fdsf, fdsfsd to the masterlist','2020/02/19 19:23:56'),('aa',' has deleted teacher Paolo, F De Guzman','2020/02/19 20:52:34'),('aa',' has deleted5435435435, fdsfdsf dsfdsf (STUDENT) ','2020/02/19 20:55:55'),('aa',' has archived teacher Francis, Clemente, comboy','2020/02/19 20:56:11'),('aa',' has deletedFrancis, Clemente comboy (TEACHER) ','2020/02/19 20:56:17'),('aa',' has archived user qq','2020/02/19 21:02:10'),('aa',' has archived user qq','2020/02/19 21:03:10'),('aa',' has deleted qq, qq qq (USER) ','2020/02/19 21:07:37'),('aa',' has archived teacher gfdgdfg, dfgdfg, gdfgdfhd','2020/02/19 21:10:37'),('aa',' has archived teacher fsdfds, fdsfs, fdsf','2020/02/19 21:10:52'),('aa',' has archived teacher gfdgdfg, dfgdfg, gdfgdfhd','2020/02/19 21:11:55'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/19 21:16:01'),('aa',' has retrieved fgdfgdf, gfdgdf gfdgfd','2020/02/19 21:17:02'),('aa',' has archived teacher fsdfds, fdsfs, fdsf','2020/02/19 21:18:00'),('aa',' has archived fgdfgdf, gfdgdf, gfdgfd','2020/02/19 21:18:26'),('aa',' has archived Comboy, Francis','2020/02/19 21:18:37'),('aa',' has archived fds, ffdsf, fdsf','2020/02/19 21:20:40'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/19 21:20:41'),('aa',' has archived gdf, gfdgdf, gdfgdf','2020/02/19 21:20:41'),('aa',' has archived fds, fdsfsd, fdsfds','2020/02/19 21:20:42'),('aa',' has archived fds, fdsfsdhfgh, fdsfds','2020/02/19 21:20:42'),('aa',' has archived fdsf, dsfdsf, dsfdsf','2020/02/19 21:20:43'),('aa',' has archived gfdsfdsfdsfsf, fdsfds, fdsfhgdfh','2020/02/19 21:20:44'),('aa',' has archived sdfdsfdsfdsfdsf, fdsfds, fdsfsdfs','2020/02/19 21:20:44'),('aa',' has archived fsfdsfdsf, fdsf, dsfdsfdsfds','2020/02/19 21:20:44'),('aa',' has archived fdsf, fsfs, fdsfds','2020/02/19 21:20:45'),('aa',' has archived fdsf, fdsf, fdsfsd','2020/02/19 21:20:45'),('aa',' has retrieved fds, ffds fdsf','2020/02/19 21:20:50'),('aa',' has retrieved fds, ffdsf fdsf','2020/02/19 21:20:51'),('aa',' has retrieved fdsf, fdsf fdsfds','2020/02/19 21:20:51'),('aa',' has retrieved Comboy, Francis ','2020/02/19 21:20:51'),('aa',' has retrieved fgdfgdf, gfdgdf gfdgfd','2020/02/19 21:20:52'),('aa',' has retrieved gdf, gfdgdf gdfgdf','2020/02/19 21:20:52'),('aa',' has retrieved fds, fdsfsd fdsfds','2020/02/19 21:20:52'),('aa',' has retrieved fds, fdsfsdhfgh fdsfds','2020/02/19 21:20:52'),('aa',' has retrieved fdsf, dsfdsf dsfdsf','2020/02/19 21:20:53'),('aa',' has retrieved gfdsfdsfdsfsf, fdsfds fdsfhgdfh','2020/02/19 21:20:53'),('aa',' has retrieved sdfdsfdsfdsfdsf, fdsfds fdsfsdfs','2020/02/19 21:20:53'),('aa',' has retrieved fsfdsfdsf, fdsf dsfdsfdsfds','2020/02/19 21:20:54'),('aa',' has retrieved fdsf, fsfs fdsfds','2020/02/19 21:20:54'),('aa',' has retrieved fdsf, fdsf fdsfsd','2020/02/19 21:20:54'),('aa',' has archived fdsf, fdsf, fdsfds','2020/02/19 21:21:03'),('aa',' has archived gdf, gfdgdf, gdfgdf','2020/02/19 21:21:04'),('aa',' has archived fdsf, dsfdsf, dsfdsf','2020/02/19 21:21:04'),('aa',' has archived fds, ffds, fdsf','2020/02/19 21:21:15'),('aa',' has archived Comboy, Francis','2020/02/19 21:21:15'),('aa',' has archived gfdsfdsfdsfsf, fdsfds, fdsfhgdfh','2020/02/19 21:21:15'),('aa',' has promoted fgdfgdf, gfdgdf','2020/02/19 21:21:27'),('aa',' has promoted fds, fdsfsd','2020/02/19 21:21:27'),('aa',' has promoted sdfdsfdsfdsfdsf, fdsfds','2020/02/19 21:21:28'),('aa',' has deleted 6345643543534, gfdsfdsfdsfsf fdsfds (STUDENT) ','2020/02/19 21:22:29'),('aa',' has retrieved fdsf, dsfdsf dsfdsf','2020/02/19 21:22:49'),('aa',' has archived teacher fsdfds, fdsfs, fdsf','2020/02/19 21:23:10'),('aa',' has deletedfsdfds, fdsfs fdsf (TEACHER) ','2020/02/19 21:23:17'),('aa',' has archived user fdsfdsf','2020/02/19 21:26:01'),('aa',' has archived user fdsfs','2020/02/19 21:26:04'),('aa',' has deleted fdsf, dsfdsf fdsgdsgds (USER) ','2020/02/19 21:26:44'),('aa',' has promoted fdsf, fdsf','2020/02/19 21:27:32'),('aa',' has promoted fdsf, fsfs','2020/02/19 21:29:05'),('aa',' has added fsfdsfdsf, fdsf, dsfdsfdsfds to the masterlist','2020/02/19 21:29:14'),('aa',' has promoted fsfdsfdsf, fdsf','2020/02/19 21:29:20');
/*!40000 ALTER TABLE `tblhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblprof`
--

DROP TABLE IF EXISTS `tblprof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblprof` (
  `lrn` varchar(255) DEFAULT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  `fchoice` varchar(255) DEFAULT NULL,
  `schoice` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `date_archived` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `Student_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblprof`
--

LOCK TABLES `tblprof` WRITE;
/*!40000 ALTER TABLE `tblprof` DISABLE KEYS */;
INSERT INTO `tblprof` VALUES ('54435345','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',1,'2/6/2020','2/19/2020','Completer','Old Student'),('423432','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',3,'2/6/2020','2/19/2020','Drop Out','Old Student'),('535345','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',4,'2/6/2020','2/19/2020','Completer','Old Student'),('3007051120090','300751','Science, Technology, Engineering and Mathematics (STEM) - ENGINEERING','Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION',6,'2/6/2020','2/19/2020','Completer','Old Student'),('434234','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',9,'2/9/2020',NULL,NULL,'Old Student'),('43534543543','300751','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)','Technical-Vocational-Livelihood (IA)-REPAIR AND INSTALLATION',11,'2/11/2020','2/19/2020','Completer','Old Student'),('543535','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-ANIMATION',13,'2/11/2020','2/19/2020','Completer','Transferee'),('5435345435','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',15,'2/11/2020','2/19/2020','Drop Out','Old Student'),('543534543566546','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',16,'2/11/2020','2/19/2020','Drop Out','Transferee'),('5435435435435435435435','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',17,'2/11/2020','2/19/2020','Completer','Senior High Freshman'),('543543534543','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',19,'2/11/2020','2/19/2020','Drop Out','Old Student'),('5435435435435435','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',20,'2/11/2020','2/19/2020','Drop Out','Old Student'),('4324324','300751','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)','Technical-Vocational-Livelihood (HE)-BREAD AND PASTRY PRODUCTION',21,'2/16/2020','2/19/2020','Drop Out','Old Student'),('4234324324','300751','Technical-Vocational-Livelihood (ICT)-PROGRAMMING','Technical-Vocational-Livelihood (ICT)-COMPUTER SYSTEM SERVICING (CSS)',22,'2/19/2020','2/19/2020','Drop Out','Old Student');
/*!40000 ALTER TABLE `tblprof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblprofacadinfo`
--

DROP TABLE IF EXISTS `tblprofacadinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblprofacadinfo` (
  `nolsa` varchar(255) DEFAULT NULL,
  `yearcom` varchar(255) DEFAULT NULL,
  `schl_add` varchar(255) DEFAULT NULL,
  `reg` varchar(255) DEFAULT NULL,
  `tos` varchar(255) DEFAULT NULL,
  `Pname` varchar(255) DEFAULT NULL,
  `eag` varchar(255) DEFAULT NULL,
  `et` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `archived` int(1) NOT NULL,
  `section` varchar(255) DEFAULT NULL,
  `choice` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblprofacadinfo`
--

LOCK TABLES `tblprofacadinfo` WRITE;
/*!40000 ALTER TABLE `tblprofacadinfo` DISABLE KEYS */;
INSERT INTO `tblprofacadinfo` VALUES ('fdsf','fsf','fdsf','fdsf','','','GRADE 12','fsfs',1,1,'TVL-1',1),('fdsf','dsfd','sfs','fdsf','Public','','GRADE 12','fdsf',3,0,'TVL-1',1),('fdsfds','fds','fds','fdsfs','Public','','GRADE 12','fdsf',4,1,'TVL-1',1),('gdf','gfd','gdfg','dfgf','','','GRADE 12','gdfgfd',6,1,'STEM-D',1),('fdsf','fds','fdsf','fdsf','Public','','GRADE 12','fdsfs',9,0,'TVL-1',1),('gdfg','dfgd','gdfgdg','gfdgd','Public','','GRADE 12','gfdgfdg',11,0,'TVL-2',1),('gfdg','gfdg','gfdg','gfdgfd','Public','','GRADE 11','gdfgfd',13,1,'TVL-1',1),('fdsf','fdsf','fds','fdsfds','Public','','GRADE 12','fdsfs',15,0,'TVL-1',1),('fdsf','fdsf','fds','fdsfds','Public','','GRADE 11','fdsfs',16,0,'TVL-1',1),('sdfd','sfds','fdsfds','fdsfds','Public','','GRADE 11','fdsfds',17,0,'TVL-1',1),('fdsfdsfsf','dsf','sfs','fsf','Public','','GRADE 12','fdsfdsfdsf',19,0,'TVL-1',1),('fdsf','dsf','fdsf','fdsfsf','Public','','GRADE 12','fdsfdsfdsf',20,0,'TVL-2',2),('fdsf','fdsf','sf','sfsfs','Public','','GRADE 12','fdsfs',21,0,'TVL-2',1),('fdsf','fds','fsd','fds','Public','','GRADE 12','fdsf',22,0,'TVL-1',1);
/*!40000 ALTER TABLE `tblprofacadinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproffaminfo`
--

DROP TABLE IF EXISTS `tblproffaminfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproffaminfo` (
  `fathername` varchar(255) DEFAULT NULL,
  `fatheroccu` varchar(255) DEFAULT NULL,
  `mothername` varchar(255) DEFAULT NULL,
  `motheroccu` varchar(255) DEFAULT NULL,
  `guardianname` varchar(255) DEFAULT NULL,
  `guardianoccu` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproffaminfo`
--

LOCK TABLES `tblproffaminfo` WRITE;
/*!40000 ALTER TABLE `tblproffaminfo` DISABLE KEYS */;
INSERT INTO `tblproffaminfo` VALUES ('','','','','fdsf','',1),('','','','','fdsf','fdsf',3),('fdsf','fdsf','dsfs','fs','fdsf','sfs',4),('','','','','gfdg','gfdg',6),('','','','','dsfds','fdsf',9),('gfdg','gdfg','gdfg','gdfg','fdg','fdgfdgfd',11),('gfd','gfdg','gdfg','','gdfg','gfdg',13),('dsfdsf','dsfs','','','fdsfs','fdsfds',15),('dsfdsf','dsfs','','','fdsfs','fdsfds',16),('','','','','fdsf','fdsf',17),('','','','','fdsfs','dfds',19),('','','','','dsfds','fdsfs',20),('','','','','fdsf','fdsf',21),('','','','','fdsf','fdsf',22);
/*!40000 ALTER TABLE `tblproffaminfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblprofperinfo`
--

DROP TABLE IF EXISTS `tblprofperinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblprofperinfo` (
  `lname` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `nname` varchar(255) DEFAULT NULL,
  `bdate` varchar(255) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `citizenship` varchar(255) DEFAULT NULL,
  `bplace` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semester` varchar(255) DEFAULT NULL,
  `Sy` varchar(255) DEFAULT NULL,
  `gwa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblprofperinfo`
--

LOCK TABLES `tblprofperinfo` WRITE;
/*!40000 ALTER TABLE `tblprofperinfo` DISABLE KEYS */;
INSERT INTO `tblprofperinfo` VALUES ('fds','ffds','fdsf','fdsf','January 1, 2001',19,'fdsfdsfdsfds','fdsfsfds','fdsfds','Male',1,'Second Semester','2020-2021','85.99'),('fds','ffdsf','fdsf','fdsf','January 1, 1989',31,'fdsf','fdsf','fdsf','Male',3,'Second Semester','2020-2021',''),('fdsf','fdsf','fdsfds','fdsf','January 1, 1999',21,'fdsf','fdsf','fdsf','Male',4,'Second Semester','2020-2021',''),('Comboy','Francis','','Francis','May 30, 1994',25,'fsdf','fdsf','fdsf','Male',6,'Second Semester','2020-2021',''),('fsdf','ETO YUN','','fsdf','January 1, 1992',28,'fdsf','fds','fds','Male',9,'First Semester','2021-2022',''),('fgdfgdf','gfdgdf','gfdgfd','gdfgfd','January 1, 1992',28,'gfdgfd','fdgfd','gfdgdf','Female',11,'First Semester','2021-2022','99.99'),('gdf','gfdgdf','gdfgdf','gdfgfd','January 1, 1984',36,'gdfgfd','gdfg','dfgdfg','Male',13,'Second Semester','2020-2021','99.70'),('fds','fdsfsd','fdsfds','fdsf','January 1, 1990',30,'fdsfds','fdsf','dsfdsf','Female',15,'First Semester','2021-2022',''),('fds','fdsfsdhfgh','fdsfds','fdsf','January 1, 1990',30,'fdsfds','fdsf','dsfdsf','Female',16,'Second Semester','2020-2021',''),('fdsf','dsfdsf','dsfdsf','fdsfds','January 1, 1986',34,'fdsfds','fdsfds','fdsfds','Male',17,'Second Semester','2020-2021',''),('sdfdsfdsfdsfdsf','fdsfds','fdsfsdfs','fdsfdsf','January 1, 1984',36,'fdsfdsfs','fdsfdsf','fdsf','Male',19,'First Semester','2021-2022',''),('fsfdsfdsf','fdsf','dsfdsfdsfds','fdsfsdf','January 1, 1988',32,'fdsfds','fdsf','dsfdsf','Female',20,'First Semester','2021-2022',''),('fdsf','fsfs','fdsfds','fdsfs','January 1, 1979',41,'fdsfs','fdsf','sfsf','Male',21,'First Semester','2021-2022',''),('fdsf','fdsf','fdsfsd','fdsfds','January 1, 2001',19,'fdsf','fdsf','fdsf','Male',22,'First Semester','2021-2022','');
/*!40000 ALTER TABLE `tblprofperinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblrc`
--

DROP TABLE IF EXISTS `tblrc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblrc` (
  `lrn` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `e_form` varchar(255) DEFAULT NULL,
  `g_card` varchar(255) DEFAULT NULL,
  `f137` varchar(255) DEFAULT NULL,
  `nso` varchar(255) DEFAULT NULL,
  `gm` varchar(255) DEFAULT NULL,
  `ncae` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `archived` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblrc`
--

LOCK TABLES `tblrc` WRITE;
/*!40000 ALTER TABLE `tblrc` DISABLE KEYS */;
INSERT INTO `tblrc` VALUES ('54435345','ffds fdsf fds','1','1','1','1','1','1',1,'Enrolled',1),('423432','ffdsf fdsf fds','1','1','1','1','1','1',3,'Enrolled',0),('535345','fdsf fdsfds fdsf','1','1','1','1','1','1',4,'Enrolled',1),('3007051120090','Francis Clemente Comboy','1','1','1','1','1','1',6,'Enrolled',1),('434234','ETO YUN  fsdf','0','0','0','0','0','0',9,'Pending',0),('43534543543','gfdgdf gfdgfd fgdfgdf','1','0','0','0','0','0',11,'Pending',0),('543535','gfdgdf gdfgdf gdf','0','0','0','0','0','0',13,'Pending',1),('5435345435','fdsfsd fdsfds fds','1','0','1','0','1','0',15,'Pending',0),('543534543566546','fdsfsdhfgh fdsfds fds','1','0','1','1','1','1',16,'Pending',0),('5435435435435435435435','dsfdsf dsfdsf fdsf','1','1','0','1','1','1',17,'Pending',0),('543543534543','fdsfds fdsfsdfs sdfdsfdsfdsfdsf','0','0','0','0','0','0',19,'Pending',0),('5435435435435435','fdsf dsfdsfdsfds fsfdsfdsf','1','1','1','1','1','1',20,'Enrolled',0),('4324324','fsfs fdsfds fdsf','0','0','0','0','0','0',21,'Pending',0),('4234324324','fdsf fdsfsd fdsf','0','0','0','0','0','0',22,'Pending',0);
/*!40000 ALTER TABLE `tblrc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsub`
--

DROP TABLE IF EXISTS `tblsub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblsub` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `s1` varchar(255) DEFAULT NULL,
  `s2` varchar(255) DEFAULT NULL,
  `s3` varchar(255) DEFAULT NULL,
  `s4` varchar(255) DEFAULT NULL,
  `s5` varchar(255) DEFAULT NULL,
  `s6` varchar(255) DEFAULT NULL,
  `s7` varchar(255) DEFAULT NULL,
  `s8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsub`
--

LOCK TABLES `tblsub` WRITE;
/*!40000 ALTER TABLE `tblsub` DISABLE KEYS */;
INSERT INTO `tblsub` VALUES (1,'General Mathematics','Earth and Life Science','Reading and Writing Skiils','null','null','null','null','null'),(3,'null','null','null','null','null','null','null','null'),(4,'Oral Communication in Context','General Mathematics','Earth and Life Science','Reading and Writing Skiils','Empowerment Technologies','Physical Science','Media and Information Literacy','null'),(6,'null','null','null','null','null','null','null','null'),(9,'null','null','null','null','null','null','null','null'),(11,'Komunikasyon at Pananaliksik sa Wika at kulturang Filipino','General Mathematics','Earth and Life Science','Understanding Culture Society and Politics','English for Academic and Proffessional Purposes','21st Literature from the philippines and the World','Pagbasa at Pagsusuri ng iba`t ibang Teksto Tungo sa Pananaliksik','Statistics and Probability'),(13,'null','null','null','null','null','null','null','null'),(15,'Earth and Life Science','Reading and Writing Skiils','Contemporary Philippine Arts from the Regions','null','null','null','null','null'),(16,'Earth and Life Science','Reading and Writing Skiils','Contemporary Philippine Arts from the Regions','null','null','null','null','null'),(17,'null','null','null','null','null','null','null','null'),(19,'null','null','null','null','null','null','null','null'),(20,'Earth and Life Science','21st Literature from the philippines and the World','Reading and Writing Skiils','Contemporary Philippine Arts from the Regions','Empowerment Technologies','Physical Science','Personal Development','Pagsulat Sa Filipino sa Piling Larang'),(21,'Earth and Life Science','English for Academic and Proffessional Purposes','Reading and Writing Skiils','Media and Information Literacy','null','null','null','null'),(22,'Oral Communication in Context','Introduction to The Philosophy of the Human Person/Pambungad na Pilosopya ng Tao','Understanding Culture Society and Politics','English for Academic and Proffessional Purposes','21st Literature from the philippines and the World','Pagbasa at Pagsusuri ng iba`t ibang Teksto Tungo sa Pananaliksik','Statistics and Probability','Empowerment Technologies');
/*!40000 ALTER TABLE `tblsub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltm`
--

DROP TABLE IF EXISTS `tbltm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltm` (
  `fname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `desig` varchar(255) DEFAULT NULL,
  `advisory` varchar(255) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `archive` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltm`
--

LOCK TABLES `tbltm` WRITE;
/*!40000 ALTER TABLE `tbltm` DISABLE KEYS */;
INSERT INTO `tbltm` VALUES ('gfdgdfg','dfgdfg','gdfgdfhd','Teacher III',NULL,1,0),('fdsf','dsfdsf','fdsfdsf','Administrator',NULL,5,NULL),('fdsf','dsfdsf','fdsgdsgds','Administrative officer II',NULL,6,NULL);
/*!40000 ALTER TABLE `tbltm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-20  0:04:05
