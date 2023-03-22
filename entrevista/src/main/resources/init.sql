DELIMITER $$
DROP PROCEDURE IF EXISTS `SP_CREATE_PERSONA`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CREATE_PERSONA` (IN `nombre` VARCHAR(80), IN `email` VARCHAR(80), IN `edad` INT,IN `dni` VARCHAR(80))   BEGIN
	DECLARE existPerson INT;

	SELECT COUNT(*)
	INTO existPerson
	FROM personas p
	WHERE p.email = email OR p.dni = dni;


	IF existPerson = 0 THEN
		INSERT INTO personas (nombre,edad,email,dni) VALUES(nombre,edad,email,dni);
	ELSE
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La persona con el email o DNI proporcionado ya existe.';
	END IF;

END$$

DELIMITER ;

--------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------
--
--DELIMITER $$
--DROP PROCEDURE IF EXISTS `SP_UPDATE_PERSONA`$$
--CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CREATE_PERSONA` (IN `nombre` VARCHAR(80), IN `email` VARCHAR(80), IN `edad` INT,IN `dni` VARCHAR(80))   BEGIN
--	DECLARE existPerson INT;
--
--	SELECT COUNT(*)
--	INTO existPerson
--	FROM personas p
--	WHERE p.email = email OR p.dni = dni;
--
--
--	IF existPerson = 0 THEN
--		INSERT INTO personas (nombre,edad,email,dni) VALUES(nombre,edad,email,dni);
--	ELSE
--		SIGNAL SQLSTATE '45000'
--        SET MESSAGE_TEXT = 'La persona con el email o DNI proporcionado ya existe.';
--	END IF;
--
--END$$
--
--DELIMITER ;
