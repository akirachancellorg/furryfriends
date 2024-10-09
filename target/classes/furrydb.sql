-- MySQL dump 10.13  Distribute 9.0.1, for macos14.4 (x86_64)
--
-- Host: localhost    Database: furry_friends_db
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `furry_friends_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `furry_friends_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `furry_friends_db`;

--
-- Table structure for table `cat`
--

DROP TABLE IF EXISTS `cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat` (
  `id` bigint NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `indoor` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `cat_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat`
--

LOCK TABLES `cat` WRITE;
/*!40000 ALTER TABLE `cat` DISABLE KEYS */;
INSERT INTO `cat` VALUES (6,'Black',1),
                         (7,'Gray',0),
                         (8,'Orange',1),
                         (9,'White',0),
                         (10,'Calico',1);
/*!40000 ALTER TABLE `cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dog`
--

DROP TABLE IF EXISTS `dog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dog` (
  `id` bigint NOT NULL,
  `breed` varchar(255) DEFAULT NULL,
  `trained` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `dog_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog`
--

LOCK TABLES `dog` WRITE;
/*!40000 ALTER TABLE `dog` DISABLE KEYS */;
INSERT INTO `dog` VALUES (1,'Golden Retriever',1),
                         (2,'Labrador Retriever',0),
                         (3,'Beagle',1),
                         (4,'Poodle',1),
                         (5,'Bulldog',0);
/*!40000 ALTER TABLE `dog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bird`
--

DROP TABLE IF EXISTS `bird`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bird` (
    `id` bigint NOT NULL,
    `species` varchar(255) DEFAULT NULL,
    `is_flightless` tinyint (1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `bird_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bird`
--

LOCK TABLES `bird` WRITE;
/*!40000 ALTER TABLE `bird` DISABLE KEYS */;
INSERT INTO `bird` VALUES (11,'Penguin',1),
                          (12,'Shoebill',0),
                          (13,'Dodo',1),
                          (14,'Flamingo',0),
                          (15,'Ostrich',1);
/*!40000 ALTER TABLE `bird` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snake`
--

DROP TABLE IF EXISTS `snake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snake`(
    `id` bigint NOT NULL,
    `species` varchar(255) DEFAULT NULL,
    `is_venomous` tinyint (1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `snake_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snake`
--

LOCK TABLES `snake` WRITE;
/*!40000 ALTER TABLE `snake` DISABLE KEYS */;
INSERT INTO `snake` VALUES (16,'Eastern Indigo Snake',0),
                           (17,'Burmese Python',0),
                           (18,'Boomslang',1),
                           (19,'Rattlesnake',1),
                           (20,'Rat Snake',0);
/*!40000 ALTER TABLE `snake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'Max',3,'DOG'),
                         (2,'Bella',2,'DOG'),
                         (3,'Charlie',5,'DOG'),
                         (4,'Lucy',1,'DOG'),
                         (5,'Cooper',4,'DOG'),
                         (6,'Luna',2,'CAT'),
                         (7,'Milo',3,'CAT'),
                         (8,'Oliver',4,'CAT'),
                         (9,'Simba',6,'CAT'),
                         (10,'Chloe',1,'CAT'),
                         (11,'Jorkin',15,'BIRD'),
                         (12,'Penits',8,'BIRD'),
                         (13,'Floppa',81,'BIRD'),
                         (14,'Hawk',6,'BIRD'),
                         (15,'Tuah',9,'BIRD'),
                         (16,'Bitoy',15,'SNAKE'),
                         (17,'Ekans',23,'SNAKE'),
                         (18,'Schlawg',1,'SNAKE'),
                         (19,'Beyonce',75,'SNAKE'),
                         (20,'Skibidi',8,'SNAKE');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-05  8:33:46
