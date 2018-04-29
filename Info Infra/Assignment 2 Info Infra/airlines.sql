-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2016 at 09:24 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlines`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL
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

CREATE TABLE `flight919` (
  `seat` varchar(10) DEFAULT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `ticket_id` int(11) NOT NULL,
  `seat_status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight919`
--

INSERT INTO `flight919` (`seat`, `user_id`, `ticket_id`, `seat_status`) VALUES
('1', 'fsmith@gmail.com', 176, 'booked'),
('2', NULL, 177, 'null'),
('3', NULL, 178, 'null'),
('4', NULL, 179, 'null'),
('5', NULL, 180, 'null'),
('6', NULL, 181, 'null'),
('7', NULL, 182, 'null'),
('8', NULL, 183, 'null'),
('9', NULL, 184, 'null'),
('10', NULL, 185, 'null'),
('11', NULL, 186, 'null'),
('12', NULL, 187, 'null'),
('13', NULL, 188, 'null'),
('14', NULL, 189, 'null'),
('15', NULL, 190, 'null'),
('16', NULL, 191, 'null'),
('17', NULL, 192, 'null'),
('18', NULL, 193, 'null'),
('19', NULL, 194, 'null'),
('20', NULL, 195, 'null'),
('21', NULL, 196, 'null'),
('22', 'fsmith@gmail.com', 197, 'booked'),
('23', 'kjones@gmail.com', 198, 'booked'),
('24', NULL, 199, 'null'),
('25', NULL, 200, 'null'),
('26', 'fsmith@gmail.com', 201, 'booked'),
('27', NULL, 202, 'null'),
('28', NULL, 203, 'null'),
('29', NULL, 204, 'null'),
('30', NULL, 205, 'null'),
('31', NULL, 206, 'null'),
('32', NULL, 207, 'null'),
('33', NULL, 208, 'null'),
('34', NULL, 209, 'null'),
('35', NULL, 210, 'null'),
('36', NULL, 211, 'null'),
('37', NULL, 212, 'null'),
('38', NULL, 213, 'null'),
('39', NULL, 214, 'null'),
('40', NULL, 215, 'null'),
('41', NULL, 216, 'null'),
('42', NULL, 217, 'null'),
('43', NULL, 218, 'null'),
('44', NULL, 219, 'null'),
('45', NULL, 220, 'null'),
('46', NULL, 221, 'null'),
('47', NULL, 222, 'null'),
('48', NULL, 223, 'null'),
('49', NULL, 224, 'null'),
('50', NULL, 225, 'null'),
('51', NULL, 226, 'null'),
('52', NULL, 227, 'null'),
('53', NULL, 228, 'null'),
('54', NULL, 229, 'null'),
('55', NULL, 230, 'null'),
('56', NULL, 231, 'null'),
('57', NULL, 232, 'null'),
('58', NULL, 233, 'null'),
('59', NULL, 234, 'null'),
('60', NULL, 235, 'null'),
('61', NULL, 236, 'null'),
('62', NULL, 237, 'null'),
('63', NULL, 238, 'null'),
('64', NULL, 239, 'null'),
('65', NULL, 240, 'null'),
('66', NULL, 241, 'null'),
('67', NULL, 242, 'null'),
('68', NULL, 243, 'null'),
('69', NULL, 244, 'null'),
('70', NULL, 245, 'null'),
('71', NULL, 246, 'null'),
('72', NULL, 247, 'null'),
('73', NULL, 248, 'null'),
('74', NULL, 249, 'null'),
('75', NULL, 250, 'null'),
('76', NULL, 251, 'null'),
('77', NULL, 252, 'null'),
('78', NULL, 253, 'null'),
('79', NULL, 254, 'null'),
('80', NULL, 255, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` varchar(30) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `login_flag` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `fname`, `lname`, `password`, `status`, `login_flag`) VALUES
('akash@gmail.com', 'Akash', 'Goled', '123456', 'standard', 'N'),
('fsmith@gmail.com', 'afron', 'doe', 'ids520', 'luxury', 'N'),
('kartik', 'kartik', 'tanksali', '123456', 'luxury', 'N'),
('kjones@gmail.com', 'kjones', 'doe', 'abcdef', 'standard', 'Y');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `flight919`
--
ALTER TABLE `flight919`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flight919`
--
ALTER TABLE `flight919`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=256;
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
