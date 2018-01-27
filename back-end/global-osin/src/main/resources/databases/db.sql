CREATE DATABASE  IF NOT EXISTS `globalosin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `globalosin`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: globalosin
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `tbl_acc_email`
--

DROP TABLE IF EXISTS `tbl_acc_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_acc_email` (
  `user_id` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `tbl_account_id` varchar(45) NOT NULL,
  `tbl_email_id` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`email_id`),
  KEY `fk_tbl_acc_email_tbl_account1_idx` (`tbl_account_id`),
  KEY `fk_tbl_acc_email_tbl_email1_idx` (`tbl_email_id`),
  CONSTRAINT `fk_tbl_acc_email_tbl_account1` FOREIGN KEY (`tbl_account_id`) REFERENCES `tbl_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_acc_email_tbl_email1` FOREIGN KEY (`tbl_email_id`) REFERENCES `tbl_email` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_account`
--

DROP TABLE IF EXISTS `tbl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_account` (
  `id` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `date_join` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ping_number` varchar(45) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  `tbl_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_account_tbl_employees1_idx` (`tbl_employees_id`),
  KEY `fk_tbl_account_tbl_customer1_idx` (`tbl_customer_id`),
  CONSTRAINT `fk_tbl_account_tbl_customer1` FOREIGN KEY (`tbl_customer_id`) REFERENCES `tbl_customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_account_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_address`
--

DROP TABLE IF EXISTS `tbl_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_address` (
  `id` varchar(45) NOT NULL,
  `full_address` varchar(45) DEFAULT NULL,
  `street_id` varchar(45) DEFAULT NULL COMMENT 'ID đường  ',
  `wand_id` varchar(45) DEFAULT NULL,
  `district_id` varchar(45) DEFAULT NULL,
  `province_city_id` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_cus_location`
--

DROP TABLE IF EXISTS `tbl_cus_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cus_location` (
  `address_id` varchar(45) NOT NULL,
  `customer_id` varchar(45) NOT NULL,
  `tbl_address_id` varchar(45) NOT NULL,
  `tbl_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`address_id`,`customer_id`),
  KEY `fk_tbl_cus_location_tbl_address1_idx` (`tbl_address_id`),
  KEY `fk_tbl_cus_location_tbl_customer1_idx` (`tbl_customer_id`),
  CONSTRAINT `fk_tbl_cus_location_tbl_address1` FOREIGN KEY (`tbl_address_id`) REFERENCES `tbl_address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_cus_location_tbl_customer1` FOREIGN KEY (`tbl_customer_id`) REFERENCES `tbl_customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `id` int(11) NOT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birth_day` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_dep_manager`
--

DROP TABLE IF EXISTS `tbl_dep_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_dep_manager` (
  `emp_id` varchar(45) NOT NULL,
  `dep_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  `tbl_department_id` varchar(45) NOT NULL,
  PRIMARY KEY (`emp_id`,`dep_id`),
  KEY `fk_tbl_dep_manager_tbl_employees1_idx` (`tbl_employees_id`),
  KEY `fk_tbl_dep_manager_tbl_department1_idx` (`tbl_department_id`),
  CONSTRAINT `fk_tbl_dep_manager_tbl_department1` FOREIGN KEY (`tbl_department_id`) REFERENCES `tbl_department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_dep_manager_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_department`
--

DROP TABLE IF EXISTS `tbl_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_department` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_district`
--

DROP TABLE IF EXISTS `tbl_district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_district` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `province_city_id` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `province_city_id_idx` (`province_city_id`),
  CONSTRAINT `province_city_id` FOREIGN KEY (`province_city_id`) REFERENCES `tbl_province_city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_email`
--

DROP TABLE IF EXISTS `tbl_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_email` (
  `id` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `type_id` varchar(45) DEFAULT NULL,
  `tbl_email_type_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_email_tbl_email_type1_idx` (`tbl_email_type_id`),
  CONSTRAINT `fk_tbl_email_tbl_email_type1` FOREIGN KEY (`tbl_email_type_id`) REFERENCES `tbl_email_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_email_type`
--

DROP TABLE IF EXISTS `tbl_email_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_email_type` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_emp_cus`
--

DROP TABLE IF EXISTS `tbl_emp_cus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_cus` (
  `cus_id` varchar(45) NOT NULL,
  `emp_id` varchar(45) NOT NULL,
  `tbl_customer_id` int(11) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`cus_id`,`emp_id`),
  KEY `fk_tbl_emp_cus_tbl_customer1_idx` (`tbl_customer_id`),
  KEY `fk_tbl_emp_cus_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_emp_cus_tbl_customer1` FOREIGN KEY (`tbl_customer_id`) REFERENCES `tbl_customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_emp_cus_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_emp_dep`
--

DROP TABLE IF EXISTS `tbl_emp_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_dep` (
  `emp_id` varchar(45) NOT NULL,
  `dep_id` varchar(45) NOT NULL,
  `tbl_department_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`,`dep_id`),
  KEY `fk_tbl_emp_dep_tbl_department1_idx` (`tbl_department_id`),
  KEY `fk_tbl_emp_dep_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_emp_dep_tbl_department1` FOREIGN KEY (`tbl_department_id`) REFERENCES `tbl_department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_emp_dep_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_emp_job`
--

DROP TABLE IF EXISTS `tbl_emp_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_job` (
  `emp_id` int(11) NOT NULL,
  `job_id` varchar(45) DEFAULT NULL,
  `tbl_job_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `fk_tbl_emp_job_tbl_job1_idx` (`tbl_job_id`),
  KEY `fk_tbl_emp_job_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_emp_job_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_emp_job_tbl_job1` FOREIGN KEY (`tbl_job_id`) REFERENCES `tbl_job` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_emp_location`
--

DROP TABLE IF EXISTS `tbl_emp_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_location` (
  `address_id` varchar(45) NOT NULL,
  `emp_id` varchar(45) NOT NULL,
  `tbl_address_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`address_id`,`emp_id`),
  KEY `fk_tbl_emp_location_tbl_address1_idx` (`tbl_address_id`),
  KEY `fk_tbl_emp_location_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_emp_location_tbl_address1` FOREIGN KEY (`tbl_address_id`) REFERENCES `tbl_address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_emp_location_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_employees`
--

DROP TABLE IF EXISTS `tbl_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employees` (
  `id` int(11) NOT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `identify_id` varchar(45) DEFAULT NULL COMMENT 'CMND',
  `address_id` varchar(45) DEFAULT NULL,
  `home_town` varchar(45) DEFAULT NULL,
  `strong_point` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_faqs`
--

DROP TABLE IF EXISTS `tbl_faqs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_faqs` (
  `id` int(11) NOT NULL,
  `question` varchar(45) DEFAULT NULL,
  `answer` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_feedback`
--

DROP TABLE IF EXISTS `tbl_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_feedback` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_job`
--

DROP TABLE IF EXISTS `tbl_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_job` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `dep_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_news`
--

DROP TABLE IF EXISTS `tbl_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_news` (
  `id` varchar(45) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `images` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_checked` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_create_id` varchar(45) DEFAULT NULL,
  `user_checked_id` varchar(45) DEFAULT NULL,
  `tag_id` varchar(45) DEFAULT NULL,
  `tbl_news_tag_id` varchar(45) NOT NULL,
  `tbl_account_id` varchar(45) NOT NULL,
  `tbl_account_id1` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_news_tbl_news_tag1_idx` (`tbl_news_tag_id`),
  KEY `fk_tbl_news_tbl_account1_idx` (`tbl_account_id`),
  KEY `fk_tbl_news_tbl_account2_idx` (`tbl_account_id1`),
  CONSTRAINT `fk_tbl_news_tbl_account1` FOREIGN KEY (`tbl_account_id`) REFERENCES `tbl_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_news_tbl_account2` FOREIGN KEY (`tbl_account_id1`) REFERENCES `tbl_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_news_tbl_news_tag1` FOREIGN KEY (`tbl_news_tag_id`) REFERENCES `tbl_news_tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_news_tag`
--

DROP TABLE IF EXISTS `tbl_news_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_news_tag` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_order` (
  `id` varchar(45) NOT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `cus_id` varchar(45) DEFAULT NULL,
  `address_id` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `tbl_address_id` varchar(45) NOT NULL,
  `tbl_customer_id` int(11) NOT NULL,
  `tbl_review_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_order_tbl_address1_idx` (`tbl_address_id`),
  KEY `fk_tbl_order_tbl_customer1_idx` (`tbl_customer_id`),
  KEY `fk_tbl_order_tbl_review1_idx` (`tbl_review_id`),
  CONSTRAINT `fk_tbl_order_tbl_address1` FOREIGN KEY (`tbl_address_id`) REFERENCES `tbl_address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_order_tbl_customer1` FOREIGN KEY (`tbl_customer_id`) REFERENCES `tbl_customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_order_tbl_review1` FOREIGN KEY (`tbl_review_id`) REFERENCES `tbl_review` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_order_emp`
--

DROP TABLE IF EXISTS `tbl_order_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_order_emp` (
  `order_id` varchar(45) NOT NULL,
  `emp_Id` varchar(45) NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  `tbl_order_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`emp_Id`),
  KEY `fk_tbl_order_emp_tbl_order1_idx` (`tbl_order_id`),
  KEY `fk_tbl_order_emp_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_order_emp_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_order_emp_tbl_order1` FOREIGN KEY (`tbl_order_id`) REFERENCES `tbl_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_policy`
--

DROP TABLE IF EXISTS `tbl_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_policy` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_promote`
--

DROP TABLE IF EXISTS `tbl_promote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_promote` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_promote_cus`
--

DROP TABLE IF EXISTS `tbl_promote_cus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_promote_cus` (
  `cus_id` varchar(45) NOT NULL,
  `promote_id` varchar(45) NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  `tbl_promote_id` int(11) NOT NULL,
  `tbl_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`cus_id`,`promote_id`),
  KEY `fk_tbl_promote_cus_tbl_promote1_idx` (`tbl_promote_id`),
  KEY `fk_tbl_promote_cus_tbl_customer1_idx` (`tbl_customer_id`),
  CONSTRAINT `fk_tbl_promote_cus_tbl_customer1` FOREIGN KEY (`tbl_customer_id`) REFERENCES `tbl_customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_promote_cus_tbl_promote1` FOREIGN KEY (`tbl_promote_id`) REFERENCES `tbl_promote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_promote_service`
--

DROP TABLE IF EXISTS `tbl_promote_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_promote_service` (
  `service_id` varchar(45) NOT NULL,
  `promote_id` varchar(45) NOT NULL,
  `tbl_promote_id` int(11) NOT NULL,
  `tbl_service_id` varchar(45) NOT NULL,
  PRIMARY KEY (`service_id`,`promote_id`),
  KEY `fk_tbl_promote_service_tbl_promote1_idx` (`tbl_promote_id`),
  KEY `fk_tbl_promote_service_tbl_service1_idx` (`tbl_service_id`),
  CONSTRAINT `fk_tbl_promote_service_tbl_promote1` FOREIGN KEY (`tbl_promote_id`) REFERENCES `tbl_promote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_promote_service_tbl_service1` FOREIGN KEY (`tbl_service_id`) REFERENCES `tbl_service` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_province_city`
--

DROP TABLE IF EXISTS `tbl_province_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_province_city` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_review`
--

DROP TABLE IF EXISTS `tbl_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_review` (
  `id` varchar(45) NOT NULL,
  `order_id` varchar(45) DEFAULT NULL,
  `rate` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_review_detail`
--

DROP TABLE IF EXISTS `tbl_review_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_review_detail` (
  `review_id` varchar(45) NOT NULL,
  `emp_id` varchar(45) NOT NULL,
  `rate` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  `tbl_review_id` varchar(45) NOT NULL,
  `tbl_employees_id` int(11) NOT NULL,
  PRIMARY KEY (`review_id`,`emp_id`),
  KEY `fk_tbl_review_detail_tbl_review1_idx` (`tbl_review_id`),
  KEY `fk_tbl_review_detail_tbl_employees1_idx` (`tbl_employees_id`),
  CONSTRAINT `fk_tbl_review_detail_tbl_employees1` FOREIGN KEY (`tbl_employees_id`) REFERENCES `tbl_employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_review_detail_tbl_review1` FOREIGN KEY (`tbl_review_id`) REFERENCES `tbl_review` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_service`
--

DROP TABLE IF EXISTS `tbl_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_service` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `tbl_service_cost_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_service_tbl_service_cost1_idx` (`tbl_service_cost_id`),
  CONSTRAINT `fk_tbl_service_tbl_service_cost1` FOREIGN KEY (`tbl_service_cost_id`) REFERENCES `tbl_service_cost` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_service_cost`
--

DROP TABLE IF EXISTS `tbl_service_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_service_cost` (
  `id` varchar(45) NOT NULL,
  `time` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_street`
--

DROP TABLE IF EXISTS `tbl_street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_street` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `wand_id` varchar(45) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`wand_id`),
  KEY `wand_id_idx` (`wand_id`),
  CONSTRAINT `wand_id` FOREIGN KEY (`wand_id`) REFERENCES `tbl_wand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_role` (
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  `tbl_account_id` varchar(45) NOT NULL,
  `tbl_role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_tbl_user_role_tbl_account1_idx` (`tbl_account_id`),
  KEY `fk_tbl_user_role_tbl_role1_idx` (`tbl_role_id`),
  CONSTRAINT `fk_tbl_user_role_tbl_account1` FOREIGN KEY (`tbl_account_id`) REFERENCES `tbl_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_user_role_tbl_role1` FOREIGN KEY (`tbl_role_id`) REFERENCES `tbl_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_wand`
--

DROP TABLE IF EXISTS `tbl_wand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_wand` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `district_id` varchar(45) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `tbl_district_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`tbl_district_id`,`district_id`),
  KEY `fk_tbl_wand_tbl_district1_idx` (`district_id`),
  CONSTRAINT `district_id` FOREIGN KEY (`district_id`) REFERENCES `tbl_district` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'globalosin'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-28  0:05:55
