-- MySQL dump 10.16  Distrib 10.1.23-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: stoms-v1.0
-- ------------------------------------------------------
-- Server version	10.1.23-MariaDB-9+deb9u1

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
-- Table structure for table `am_buyer`
--

DROP TABLE IF EXISTS `am_buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_buyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_buyer_country_id` (`country_id`),
  CONSTRAINT `am_buyer_country_id` FOREIGN KEY (`country_id`) REFERENCES `am_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_buyer`
--

LOCK TABLES `am_buyer` WRITE;
/*!40000 ALTER TABLE `am_buyer` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_color`
--

DROP TABLE IF EXISTS `am_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_color`
--

LOCK TABLES `am_color` WRITE;
/*!40000 ALTER TABLE `am_color` DISABLE KEYS */;
INSERT INTO `am_color` VALUES (1,NULL,'2017-08-29 19:23:22',NULL,'2017-08-29 19:23:22',0,NULL,NULL,0,'Black'),(2,NULL,'2017-08-29 19:23:41',NULL,'2017-08-29 19:23:41',0,NULL,NULL,0,'White'),(3,NULL,'2017-08-29 19:23:53',NULL,'2017-08-29 19:23:53',0,NULL,NULL,0,'Red');
/*!40000 ALTER TABLE `am_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_country`
--

DROP TABLE IF EXISTS `am_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_country`
--

LOCK TABLES `am_country` WRITE;
/*!40000 ALTER TABLE `am_country` DISABLE KEYS */;
INSERT INTO `am_country` VALUES (1,NULL,'2017-08-29 19:25:03',NULL,'2017-08-29 19:25:03',0,NULL,NULL,0,'Nepal'),(2,NULL,'2017-08-29 19:25:22',NULL,'2017-08-29 19:25:22',0,NULL,NULL,0,'India');
/*!40000 ALTER TABLE `am_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_manufacturer`
--

DROP TABLE IF EXISTS `am_manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_manufacturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_manufacturer`
--

LOCK TABLES `am_manufacturer` WRITE;
/*!40000 ALTER TABLE `am_manufacturer` DISABLE KEYS */;
INSERT INTO `am_manufacturer` VALUES (1,NULL,'2017-08-29 20:33:21',NULL,'2017-08-29 20:33:21',0,NULL,NULL,0,'maruti');
/*!40000 ALTER TABLE `am_manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_model`
--

DROP TABLE IF EXISTS `am_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_model`
--

LOCK TABLES `am_model` WRITE;
/*!40000 ALTER TABLE `am_model` DISABLE KEYS */;
INSERT INTO `am_model` VALUES (1,NULL,'2017-08-29 20:27:02',NULL,'2017-08-29 20:27:02',0,NULL,NULL,0,'test model');
/*!40000 ALTER TABLE `am_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_product`
--

DROP TABLE IF EXISTS `am_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  `color_id` int(11) DEFAULT NULL,
  `manufacturer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_product_model_id` (`model_id`),
  KEY `am_product_color_id` (`color_id`),
  KEY `am_product_manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `am_product_color_id` FOREIGN KEY (`color_id`) REFERENCES `am_color` (`id`),
  CONSTRAINT `am_product_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `am_manufacturer` (`id`),
  CONSTRAINT `am_product_model_id` FOREIGN KEY (`model_id`) REFERENCES `am_model` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_product`
--

LOCK TABLES `am_product` WRITE;
/*!40000 ALTER TABLE `am_product` DISABLE KEYS */;
INSERT INTO `am_product` VALUES (1,NULL,'2017-08-29 21:13:27',NULL,'2017-08-29 22:22:51',1,NULL,'2017-08-29 22:22:51',2,'Test product 1','1s1sfaasdqwdasd',1,1,1),(2,NULL,'2017-08-29 21:28:43',NULL,'2017-08-29 21:28:43',0,NULL,NULL,0,'Test product 2','as123',1,3,1),(3,NULL,'2017-08-29 21:33:43',NULL,'2017-08-29 21:33:43',0,NULL,NULL,0,'Test product 3','234',1,2,1),(4,NULL,'2017-08-29 21:34:22',NULL,'2017-08-29 21:34:22',0,NULL,NULL,0,'Test product 4','123qw',1,2,1);
/*!40000 ALTER TABLE `am_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_product_price`
--

DROP TABLE IF EXISTS `am_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_product_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `cost_price` float NOT NULL,
  `marked_price` float NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_receipt_product_id` (`product_id`),
  CONSTRAINT `am_receipt_product_id` FOREIGN KEY (`product_id`) REFERENCES `am_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_product_price`
--

LOCK TABLES `am_product_price` WRITE;
/*!40000 ALTER TABLE `am_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_receipt`
--

DROP TABLE IF EXISTS `am_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `amount` float NOT NULL,
  `sales_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_receipt_sales_id` (`sales_id`),
  CONSTRAINT `am_receipt_sales_id` FOREIGN KEY (`sales_id`) REFERENCES `am_sales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_receipt`
--

LOCK TABLES `am_receipt` WRITE;
/*!40000 ALTER TABLE `am_receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_resource`
--

DROP TABLE IF EXISTS `am_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource_type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_resource`
--

LOCK TABLES `am_resource` WRITE;
/*!40000 ALTER TABLE `am_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_role`
--

DROP TABLE IF EXISTS `am_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_role`
--

LOCK TABLES `am_role` WRITE;
/*!40000 ALTER TABLE `am_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_role_group`
--

DROP TABLE IF EXISTS `am_role_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_role_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_role_group`
--

LOCK TABLES `am_role_group` WRITE;
/*!40000 ALTER TABLE `am_role_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_role_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_role_group_role`
--

DROP TABLE IF EXISTS `am_role_group_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_role_group_role` (
  `role_id` int(11) NOT NULL,
  `role_group_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`role_group_id`),
  KEY `am_role_group_role_role_id_fk` (`role_id`),
  KEY `am_role_group_role_role_group_id_fk` (`role_group_id`),
  CONSTRAINT `am_role_group_role_role_group_id_fk` FOREIGN KEY (`role_group_id`) REFERENCES `am_role_group` (`id`),
  CONSTRAINT `am_role_group_role_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `am_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_role_group_role`
--

LOCK TABLES `am_role_group_role` WRITE;
/*!40000 ALTER TABLE `am_role_group_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_role_group_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_role_resource`
--

DROP TABLE IF EXISTS `am_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_role_resource` (
  `resource_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`resource_id`,`role_id`),
  KEY `am_role_resource_am_role_id` (`role_id`),
  CONSTRAINT `am_role_resource_am_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `am_resource` (`id`),
  CONSTRAINT `am_role_resource_am_role_id` FOREIGN KEY (`role_id`) REFERENCES `am_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_role_resource`
--

LOCK TABLES `am_role_resource` WRITE;
/*!40000 ALTER TABLE `am_role_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_sales`
--

DROP TABLE IF EXISTS `am_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `amount` float DEFAULT NULL,
  `discount_amount` float DEFAULT NULL,
  `discount_percentage` float DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `is_credit` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `am_sales_buyer_id` (`buyer_id`),
  CONSTRAINT `am_sales_buyer_id` FOREIGN KEY (`buyer_id`) REFERENCES `am_buyer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_sales`
--

LOCK TABLES `am_sales` WRITE;
/*!40000 ALTER TABLE `am_sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_sales_detail`
--

DROP TABLE IF EXISTS `am_sales_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_sales_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `amount` float DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `discount_amount` float DEFAULT NULL,
  `discount_percentage` float DEFAULT NULL,
  `sales_id` int(11) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_sales_detail_sales_id` (`sales_id`),
  KEY `am_sales_detail_product_id` (`product_id`),
  KEY `am_sales_detail_unit_id` (`unit_id`),
  CONSTRAINT `am_sales_detail_product_id` FOREIGN KEY (`product_id`) REFERENCES `am_product` (`id`),
  CONSTRAINT `am_sales_detail_sales_id` FOREIGN KEY (`sales_id`) REFERENCES `am_sales` (`id`),
  CONSTRAINT `am_sales_detail_unit_id` FOREIGN KEY (`unit_id`) REFERENCES `am_unit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_sales_detail`
--

LOCK TABLES `am_sales_detail` WRITE;
/*!40000 ALTER TABLE `am_sales_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_sales_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_sales_return`
--

DROP TABLE IF EXISTS `am_sales_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_sales_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `sales_id` int(11) DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_sales_return_sales_id` (`sales_id`),
  CONSTRAINT `am_sales_return_sales_id` FOREIGN KEY (`sales_id`) REFERENCES `am_sales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_sales_return`
--

LOCK TABLES `am_sales_return` WRITE;
/*!40000 ALTER TABLE `am_sales_return` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_sales_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_sales_return_detail`
--

DROP TABLE IF EXISTS `am_sales_return_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_sales_return_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `sales_return_id` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_sales_return_detail_sales_return_id` (`sales_return_id`),
  KEY `am_sales_return_detail_product_id` (`product_id`),
  KEY `am_sales_return_detail_unit_id` (`unit_id`),
  CONSTRAINT `am_sales_return_detail_product_id` FOREIGN KEY (`product_id`) REFERENCES `am_product` (`id`),
  CONSTRAINT `am_sales_return_detail_sales_return_id` FOREIGN KEY (`sales_return_id`) REFERENCES `am_sales_return` (`id`),
  CONSTRAINT `am_sales_return_detail_unit_id` FOREIGN KEY (`unit_id`) REFERENCES `am_unit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_sales_return_detail`
--

LOCK TABLES `am_sales_return_detail` WRITE;
/*!40000 ALTER TABLE `am_sales_return_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_sales_return_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_stock`
--

DROP TABLE IF EXISTS `am_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `rate` float DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `in_quantity` float DEFAULT NULL,
  `out_quantity` float DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_stock_product_id` (`product_id`),
  KEY `am_stock_unit_id` (`unit_id`),
  CONSTRAINT `am_stock_product_id` FOREIGN KEY (`product_id`) REFERENCES `am_product` (`id`),
  CONSTRAINT `am_stock_unit_id` FOREIGN KEY (`unit_id`) REFERENCES `am_unit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_stock`
--

LOCK TABLES `am_stock` WRITE;
/*!40000 ALTER TABLE `am_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_supplier`
--

DROP TABLE IF EXISTS `am_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bank_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `am_supplier_country_id` (`country_id`),
  CONSTRAINT `am_supplier_country_id` FOREIGN KEY (`country_id`) REFERENCES `am_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_supplier`
--

LOCK TABLES `am_supplier` WRITE;
/*!40000 ALTER TABLE `am_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_unit`
--

DROP TABLE IF EXISTS `am_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `name_english` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_unit`
--

LOCK TABLES `am_unit` WRITE;
/*!40000 ALTER TABLE `am_unit` DISABLE KEYS */;
INSERT INTO `am_unit` VALUES (1,NULL,'2017-08-29 19:22:19',NULL,'2017-08-29 19:22:19',0,NULL,NULL,0,'Piece'),(2,NULL,'2017-08-29 19:22:34',NULL,'2017-08-29 19:22:34',0,NULL,NULL,0,'Dozen');
/*!40000 ALTER TABLE `am_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_user`
--

DROP TABLE IF EXISTS `am_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `middle_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_no` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `active` tinyint(1) DEFAULT '0',
  `u_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  `login_attempt` int(11) DEFAULT '0',
  `first_time_login` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  KEY `user_type_id` (`user_type`),
  CONSTRAINT `user_type_id` FOREIGN KEY (`user_type`) REFERENCES `am_user_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_user`
--

LOCK TABLES `am_user` WRITE;
/*!40000 ALTER TABLE `am_user` DISABLE KEYS */;
INSERT INTO `am_user` VALUES (26,'Admin','admin','admin','9','am@admin.com','am@admin.com','c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec',1,NULL,'1970-01-01 05:30:00',NULL,'1970-01-01 05:30:00',0,NULL,'1970-01-01 05:30:00',1,'',0,0,0);
/*!40000 ALTER TABLE `am_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_user_role`
--

DROP TABLE IF EXISTS `am_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `am_role_group_role_role_id_fk` (`role_id`),
  KEY `am_user_role_user_id_fk` (`user_id`),
  CONSTRAINT `am_user_role_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `am_role` (`id`),
  CONSTRAINT `am_user_role_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `am_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_user_role`
--

LOCK TABLES `am_user_role` WRITE;
/*!40000 ALTER TABLE `am_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_user_role_group`
--

DROP TABLE IF EXISTS `am_user_role_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_user_role_group` (
  `role_group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`role_group_id`,`user_id`),
  KEY `am_user_role_group_role_group_id_fk` (`role_group_id`),
  KEY `am_user_role_group_user_id_fk` (`user_id`),
  CONSTRAINT `am_user_role_group_role_group_id_fk` FOREIGN KEY (`role_group_id`) REFERENCES `am_role_group` (`id`),
  CONSTRAINT `am_user_role_group_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `am_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_user_role_group`
--

LOCK TABLES `am_user_role_group` WRITE;
/*!40000 ALTER TABLE `am_user_role_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `am_user_role_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `am_user_type`
--

DROP TABLE IF EXISTS `am_user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `am_user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_english` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `name_nepali` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `added_by` int(11) DEFAULT NULL,
  `added_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_by` int(11) DEFAULT NULL,
  `deleted_on` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `am_user_type`
--

LOCK TABLES `am_user_type` WRITE;
/*!40000 ALTER TABLE `am_user_type` DISABLE KEYS */;
INSERT INTO `am_user_type` VALUES (1,'Admin','Doctor',NULL,'1970-01-01 05:30:00',NULL,'1970-01-01 05:30:00',0,NULL,'1970-01-01 05:30:00',0);
/*!40000 ALTER TABLE `am_user_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'stoms-v1.0'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-29 22:36:44
