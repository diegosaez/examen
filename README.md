# examen
Sentencia SQL para correr el programa
//MySQL57

CREATE SCHEMA `usuario01` ;

CREATE TABLE `usuario01`.`empleado` (
  `codigo` INT NOT NULL,
  `rut` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(20) NOT NULL,
  `celular` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `sueldo_bruto` VARCHAR(45) NOT NULL,
  `estado_civil` VARCHAR(1) NOT NULL,
  `nom_depto` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo`));
