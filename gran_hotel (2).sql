-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-11-2019 a las 19:03:21
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gran_hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cantidad_camas`
--

CREATE TABLE `cantidad_camas` (
  `Id_CantCam` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Id_TipoCama` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `Id_Hab` int(11) NOT NULL,
  `Piso` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`Id_Hab`, `Piso`, `Numero`, `Estado`) VALUES
(1, 1, 123, 'Ocupada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `Id_huesped` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `Dni` int(11) NOT NULL,
  `Celular` int(11) NOT NULL,
  `Correo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`Id_huesped`, `Nombre`, `Domicilio`, `Dni`, `Celular`, `Correo`) VALUES
(4, 'Sebastian Salazar', 'mitre 234', 24356745, 15433243, 'lascosta@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `Id_Reserva` int(11) NOT NULL,
  `Huesped` int(11) NOT NULL,
  `Habitacion` int(11) NOT NULL,
  `Importe` double NOT NULL,
  `Cant_Pers` int(11) NOT NULL,
  `FechaIngreso` date NOT NULL,
  `FechaEgreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cama`
--

CREATE TABLE `tipo_cama` (
  `Id_TipoCama` int(11) NOT NULL,
  `Tipo_habitacion` int(11) NOT NULL,
  `Tipo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `Id_TipoHab` int(11) NOT NULL,
  `Tipo_Cama` int(11) NOT NULL,
  `Habitacion` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cantidad_camas`
--
ALTER TABLE `cantidad_camas`
  ADD PRIMARY KEY (`Id_CantCam`),
  ADD KEY `fk_tipocama` (`Id_TipoCama`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`Id_Hab`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`Id_huesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`Id_Reserva`),
  ADD KEY `fk_habitacion` (`Habitacion`),
  ADD KEY `fk_huesped` (`Huesped`);

--
-- Indices de la tabla `tipo_cama`
--
ALTER TABLE `tipo_cama`
  ADD PRIMARY KEY (`Id_TipoCama`),
  ADD KEY `fk_tipocama` (`Tipo_habitacion`);

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`Id_TipoHab`),
  ADD KEY `fk_TipoHabitacion` (`Habitacion`),
  ADD KEY `fk_cantidadCama` (`Tipo_Cama`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cantidad_camas`
--
ALTER TABLE `cantidad_camas`
  MODIFY `Id_CantCam` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `Id_Hab` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `Id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `Id_Reserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_cama`
--
ALTER TABLE `tipo_cama`
  MODIFY `Id_TipoCama` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  MODIFY `Id_TipoHab` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cantidad_camas`
--
ALTER TABLE `cantidad_camas`
  ADD CONSTRAINT `fk_tipocama` FOREIGN KEY (`Id_TipoCama`) REFERENCES `tipo_cama` (`Id_TipoCama`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_habitacion` FOREIGN KEY (`Habitacion`) REFERENCES `habitacion` (`Id_Hab`),
  ADD CONSTRAINT `fk_huesped` FOREIGN KEY (`Huesped`) REFERENCES `huesped` (`Id_huesped`);

--
-- Filtros para la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD CONSTRAINT `fk_TipoHabitacion` FOREIGN KEY (`Habitacion`) REFERENCES `habitacion` (`Id_Hab`),
  ADD CONSTRAINT `fk_cantidadCama` FOREIGN KEY (`Tipo_Cama`) REFERENCES `cantidad_camas` (`Id_CantCam`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
