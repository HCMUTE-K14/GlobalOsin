-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema globalosin
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema globalosin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `globalosin` DEFAULT CHARACTER SET utf8 ;
USE `globalosin` ;

-- -----------------------------------------------------
-- Table `globalosin`.`tbl_province_city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globalosin`.`tbl_province_city` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `date_created` DATETIME NULL,
  `date_modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `globalosin`.`tbl_district`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globalosin`.`tbl_district` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `province_city_id` VARCHAR(45) NULL DEFAULT NULL,
  `date_created` DATETIME NULL,
  `date_modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `province_city_id_idx` (`province_city_id` ASC),
  CONSTRAINT `province_city_id`
    FOREIGN KEY (`province_city_id`)
    REFERENCES `globalosin`.`tbl_province_city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `globalosin`.`tbl_wand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globalosin`.`tbl_wand` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `district_id` VARCHAR(45) NULL DEFAULT NULL,
  `date_created` DATETIME NULL,
  `date_modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `district_id_idx` (`district_id` ASC),
  CONSTRAINT `district_id`
    FOREIGN KEY (`district_id`)
    REFERENCES `globalosin`.`tbl_district` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `globalosin`.`tbl_street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globalosin`.`tbl_street` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `wand_id` VARCHAR(45) NULL DEFAULT NULL,
  `date_created` DATETIME NULL,
  `date_modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `wand_id_idx` (`wand_id` ASC),
  CONSTRAINT `wand_id`
    FOREIGN KEY (`wand_id`)
    REFERENCES `globalosin`.`tbl_wand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `globalosin`.`tbl_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `globalosin`.`tbl_address` (
  `id` VARCHAR(45) NOT NULL,
  `full_address` VARCHAR(45) NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `street_id` VARCHAR(45) NULL,
  `wand_id` VARCHAR(45) NULL,
  `district_id` VARCHAR(45) NULL,
  `province_city_id` VARCHAR(45) NULL,
  `date_created` DATETIME NULL,
  `date_modified` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `street_id_idx` (`street_id` ASC),
  INDEX `wand_id_idx` (`wand_id` ASC),
  INDEX `district_id_idx` (`district_id` ASC),
  INDEX `province_city_id_idx` (`province_city_id` ASC),
  CONSTRAINT `address_street_id`
    FOREIGN KEY (`street_id`)
    REFERENCES `globalosin`.`tbl_street` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `address_wand_id`
    FOREIGN KEY (`wand_id`)
    REFERENCES `globalosin`.`tbl_wand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `address_district_id`
    FOREIGN KEY (`district_id`)
    REFERENCES `globalosin`.`tbl_district` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `address_province_city_id`
    FOREIGN KEY (`province_city_id`)
    REFERENCES `globalosin`.`tbl_province_city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
