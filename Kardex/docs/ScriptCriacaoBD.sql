-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Kardex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Kardex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Kardex` DEFAULT CHARACTER SET utf8 ;
USE `Kardex` ;

-- -----------------------------------------------------
-- Table `Kardex`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Kardex`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `localizacao` VARCHAR(30) NULL,
  `qtdemaxima` INT NULL,
  `qtdeminima` INT NULL,
  `qtdeestoque` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Kardex`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Kardex`.`Fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NULL,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(20) NULL,
  `email` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Kardex`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Kardex`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NULL,
  `nome` VARCHAR(45) NULL,
  `celular` VARCHAR(20) NULL,
  `email` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Kardex`.`Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Kardex`.`Entrada` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL,
  `doc` VARCHAR(20) NULL,
  `qtde` INT NULL,
  `valor` DOUBLE NULL,
  `produto` INT NOT NULL,
  `fornecedor` INT NOT NULL,
  PRIMARY KEY (`id`, `produto`, `fornecedor`),
  INDEX `fk_Entrada_Produto_idx` (`produto` ASC) VISIBLE,
  INDEX `fk_Entrada_Fornecedor1_idx` (`fornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_Entrada_Produto`
    FOREIGN KEY (`produto`)
    REFERENCES `Kardex`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Fornecedor`
    FOREIGN KEY (`fornecedor`)
    REFERENCES `Kardex`.`Fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Kardex`.`Saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Kardex`.`Saida` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL,
  `doc` VARCHAR(20) NULL,
  `qtrde` INT NULL,
  `valor` DOUBLE NULL,
  `cliente` INT NOT NULL,
  `produto` INT NOT NULL,
  PRIMARY KEY (`id`, `cliente`, `produto`),
  INDEX `fk_Saida_Cliente1_idx` (`cliente` ASC) VISIBLE,
  INDEX `fk_Saida_Produto1_idx` (`produto` ASC) VISIBLE,
  CONSTRAINT `fk_Saida_Cliente`
    FOREIGN KEY (`cliente`)
    REFERENCES `Kardex`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Saida_Produto`
    FOREIGN KEY (`produto`)
    REFERENCES `Kardex`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
