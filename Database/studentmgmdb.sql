-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: studentmgmdb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `s_attendence`
--
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentmgmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `studentmgmdb`;

DROP TABLE IF EXISTS `s_attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_attendence` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `lecture_title` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subject_id` bigint DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `classes` bigint DEFAULT NULL,
  `user` bigint DEFAULT NULL,
  `subject` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4hxx99d5n0a7yjn0ekiye5s7y` (`user`),
  KEY `FKk6cxiwq3timvjksxlv80bsab3` (`subject`),
  KEY `FKsagejnyk2c5a3fachg99ck03r` (`classes`),
  CONSTRAINT `FK4hxx99d5n0a7yjn0ekiye5s7y` FOREIGN KEY (`user`) REFERENCES `s_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKk6cxiwq3timvjksxlv80bsab3` FOREIGN KEY (`subject`) REFERENCES `s_subject` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKsagejnyk2c5a3fachg99ck03r` FOREIGN KEY (`classes`) REFERENCES `s_classes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_attendence`
--

LOCK TABLES `s_attendence` WRITE;
/*!40000 ALTER TABLE `s_attendence` DISABLE KEYS */;
INSERT INTO `s_attendence` VALUES (1,'Admin@admin.com','2022-09-19 18:22:23.772000','Admin@admin.com','2022-09-19 18:22:23.772000',1,'Grade 1','19/09/2022','What is Physics?','PRESENT',1,'Physics',2,1,2,1),(2,'Admin@admin.com','2022-09-19 18:23:30.449000','Admin@admin.com','2022-09-19 18:23:30.449000',2,'Grade 2','17/09/2022','What is Chemistry?','ABSENT',2,'Chemistry',3,2,3,2),(3,'Admin@admin.com','2022-09-19 18:26:01.563000','Admin@admin.com','2022-09-19 18:26:01.563000',1,'Grade 11','17/09/2022','Differential Equation','PRESENT',3,'Maths',3,1,3,3);
/*!40000 ALTER TABLE `s_attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_classes`
--

DROP TABLE IF EXISTS `s_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_classes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `class_description` varchar(555) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_classes`
--

LOCK TABLES `s_classes` WRITE;
/*!40000 ALTER TABLE `s_classes` DISABLE KEYS */;
INSERT INTO `s_classes` VALUES (1,'Admin@admin.com','2022-09-19 18:24:33.537000','Admin@admin.com','2022-09-19 18:24:33.537000','This is Grade 11','Grade 11'),(2,'Admin@admin.com','2022-09-19 18:24:51.895000','Admin@admin.com','2022-09-19 18:24:51.895000','This is Grade 12','Grade12');
/*!40000 ALTER TABLE `s_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_fee`
--

DROP TABLE IF EXISTS `s_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_fee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `balance_fee` decimal(19,2) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `paid_fee` decimal(19,2) DEFAULT NULL,
  `total_fee` decimal(19,2) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2obaca95ihu8twcqx2jd6s6o` (`user`),
  CONSTRAINT `FKj2obaca95ihu8twcqx2jd6s6o` FOREIGN KEY (`user`) REFERENCES `s_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_fee`
--

LOCK TABLES `s_fee` WRITE;
/*!40000 ALTER TABLE `s_fee` DISABLE KEYS */;
INSERT INTO `s_fee` VALUES (1,'Admin@admin.com','2022-09-19 18:20:53.086000','Admin@admin.com','2022-09-19 18:20:53.086000',1000.00,3000.00,'13/01/2022','January',2000.00,5000.00,2,2),(2,'Admin@admin.com','2022-09-19 18:21:43.022000','Admin@admin.com','2022-09-19 18:21:43.022000',3666.00,2000.00,'18/09/2022','December',3000.00,5000.00,3,3);
/*!40000 ALTER TABLE `s_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_marksheet`
--

DROP TABLE IF EXISTS `s_marksheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_marksheet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `chemistry` bigint DEFAULT NULL,
  `maths` bigint DEFAULT NULL,
  `physics` bigint DEFAULT NULL,
  `roll_no` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoosun1gxyddpmdmhopjj4kbeu` (`user`),
  CONSTRAINT `FKoosun1gxyddpmdmhopjj4kbeu` FOREIGN KEY (`user`) REFERENCES `s_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_marksheet`
--

LOCK TABLES `s_marksheet` WRITE;
/*!40000 ALTER TABLE `s_marksheet` DISABLE KEYS */;
INSERT INTO `s_marksheet` VALUES (1,'faculty1@gmail.com','2022-09-19 18:28:24.549000','faculty1@gmail.com','2022-09-19 18:28:24.549000',20,20,20,'D14334',2,2),(2,'faculty1@gmail.com','2022-09-19 18:28:45.190000','faculty1@gmail.com','2022-09-19 18:28:45.190000',10,10,20,'D14335',3,3);
/*!40000 ALTER TABLE `s_marksheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_subject`
--

DROP TABLE IF EXISTS `s_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_subject` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `subject_description` varchar(555) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_subject`
--

LOCK TABLES `s_subject` WRITE;
/*!40000 ALTER TABLE `s_subject` DISABLE KEYS */;
INSERT INTO `s_subject` VALUES (1,'Admin@admin.com','2022-09-19 18:19:28.866000','Admin@admin.com','2022-09-19 18:19:28.866000','Physics is a very important subject','Physics'),(2,'Admin@admin.com','2022-09-19 18:19:44.743000','Admin@admin.com','2022-09-19 18:19:44.743000','Chemistry is a very important subject','Chemistry'),(3,'Admin@admin.com','2022-09-19 18:20:08.996000','Admin@admin.com','2022-09-19 18:20:08.996000','Maths is a very interesting subject','Maths');
/*!40000 ALTER TABLE `s_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user`
--

DROP TABLE IF EXISTS `s_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `role_name` varchar(225) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (1,NULL,NULL,NULL,NULL,'ABC','8888888888','India','BE','10/02/1994','Admin','Female','Admin','Admin@admin.com','Admin@123',1,'ADMIN','D K School','Maharashtra'),(2,'Admin@admin.com','2022-09-19 18:14:38.613000','Admin@admin.com','2022-09-19 18:14:38.613000','Bhusawal','9999999999','India','BE','11/02/1993','Test','Male','Test','student1@gmail.com','Student@123',2,'STUDENT','PQR','Maharashtra'),(3,'Admin@admin.com','2022-09-19 18:15:51.135000','Admin@admin.com','2022-09-19 18:15:51.135000','Mumbai','9696969696','India','BCA','31/08/1992','Demo','Female','Demo','demo@demo.com','Demo@123',2,'STUDENT','ABC','Maharashtra'),(4,'Admin@admin.com','2022-09-19 18:17:46.737000','Admin@admin.com','2022-09-19 18:17:46.737000','Pune','8585858585','India','PHD','10/02/1974','DemoFaculty','Female','DemoFaculty','faculty1@gmail.com','Faculty@123',3,'FACULTY','PQR','Maharashtra');
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19 18:34:50
