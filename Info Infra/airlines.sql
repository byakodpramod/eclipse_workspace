-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 25, 2016 at 06:50 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `airlines`
--
CREATE DATABASE IF NOT EXISTS `airlines` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `airlines`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `flight919`
--

CREATE TABLE IF NOT EXISTS `flight919` (
  `seat` varchar(10) DEFAULT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `seat_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=93 ;

--
-- Dumping data for table `flight919`
--

INSERT INTO `flight919` (`seat`, `user_id`, `ticket_id`, `seat_status`) VALUES
('4', NULL, 11, 'null'),
('5', NULL, 12, 'null'),
('6', NULL, 13, 'null'),
('7', NULL, 14, 'null'),
('8', NULL, 15, 'null'),
('9', NULL, 16, 'null'),
('10', NULL, 17, 'null'),
('11', NULL, 18, 'null'),
('12', NULL, 19, 'null'),
('13', NULL, 20, 'null'),
('14', NULL, 22, 'null'),
('15', NULL, 23, 'null'),
('16', NULL, 24, 'null'),
('17', NULL, 25, 'null'),
('18', NULL, 26, 'null'),
('19', NULL, 27, 'null'),
('20', NULL, 28, 'null'),
('21', NULL, 29, 'null'),
('22', NULL, 30, 'null'),
('23', NULL, 31, 'null'),
('24', NULL, 32, 'null'),
('25', NULL, 33, 'null'),
('26', NULL, 34, 'null'),
('27', NULL, 35, 'null'),
('28', NULL, 36, 'null'),
('29', NULL, 37, 'null'),
('30', NULL, 38, 'null'),
('31', NULL, 39, 'null'),
('32', NULL, 40, 'null'),
('33', NULL, 41, 'null'),
('34', NULL, 42, 'null'),
('35', NULL, 43, 'null'),
('36', NULL, 44, 'null'),
('37', NULL, 45, 'null'),
('38', NULL, 46, 'null'),
('39', NULL, 47, 'null'),
('40', NULL, 48, 'null'),
('41', NULL, 49, 'null'),
('42', NULL, 50, 'null'),
('43', NULL, 51, 'null'),
('44', NULL, 52, 'null'),
('45', NULL, 53, 'null'),
('46', NULL, 54, 'null'),
('47', NULL, 55, 'null'),
('48', NULL, 56, 'null'),
('49', NULL, 57, 'null'),
('50', NULL, 58, 'null'),
('51', NULL, 59, 'null'),
('52', NULL, 60, 'null'),
('53', NULL, 61, 'null'),
('54', NULL, 62, 'null'),
('55', NULL, 63, 'null'),
('56', NULL, 64, 'null'),
('57', NULL, 65, 'null'),
('58', NULL, 66, 'null'),
('59', NULL, 67, 'null'),
('60', NULL, 68, 'null'),
('61', NULL, 69, 'null'),
('62', NULL, 70, 'null'),
('63', NULL, 71, 'null'),
('64', NULL, 72, 'null'),
('65', NULL, 73, 'null'),
('66', NULL, 74, 'null'),
('67', NULL, 75, 'null'),
('68', NULL, 76, 'null'),
('69', NULL, 77, 'null'),
('70', NULL, 78, 'null'),
('71', NULL, 79, 'null'),
('72', NULL, 80, 'null'),
('73', NULL, 81, 'null'),
('74', NULL, 82, 'null'),
('75', NULL, 83, 'null'),
('76', NULL, 84, 'null'),
('77', NULL, 85, 'null'),
('78', NULL, 86, 'null'),
('79', NULL, 87, 'null'),
('80', NULL, 88, 'null'),
(NULL, NULL, 89, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` varchar(30) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `fname`, `lname`, `password`, `status`) VALUES
('kartik', 'kartik', 'tanksali', '123456', 'luxury'),
('pooja@gmail.com', 'Pooja', 'Joshi', '123456', 'standard');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flight919`
--
ALTER TABLE `flight919`
  ADD CONSTRAINT `flight919_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `flight919_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
