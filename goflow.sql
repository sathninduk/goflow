-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Oct 28, 2023 at 04:20 AM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `goflow`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(70) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`, `latitude`, `longitude`) VALUES
(1, 'Colombo', 6.9271, 79.8612),
(2, 'Kandy', 7.2906, 80.6337),
(3, 'Galle', 6.0535, 80.217),
(4, 'Jaffna', 9.6615, 80.0255),
(5, 'Negombo', 7.2095, 79.8357),
(6, 'Anuradhapura', 8.3114, 80.4037),
(7, 'Polonnaruwa', 7.9403, 81.0188),
(8, 'Matara', 5.9545, 80.5511),
(9, 'Batticaloa', 7.7333, 81.698),
(10, 'Trincomalee', 8.5879, 81.2152),
(11, 'Kalmunai', 7.4167, 81.8167),
(12, 'Gampola', 7.1155, 80.5325),
(13, 'Chilaw', 7.5752, 79.8032),
(14, 'Haputale', 6.7675, 80.9623),
(15, 'Matale', 7.4675, 80.6234),
(16, 'Weligama', 5.9667, 80.4167),
(17, 'Balangoda', 6.6604, 80.6993),
(18, 'Bandarawela', 6.8323, 80.9827),
(19, 'Beruwala', 6.4783, 79.9738),
(20, 'Boralesgamuwa', 6.8525, 79.959),
(21, 'Battaramulla', 6.9178, 79.9581),
(22, 'Chavakachcheri', 9.6427, 80.1542),
(23, 'Dehiwala-Mount Lavinia', 6.8324, 79.8622),
(24, 'Ella', 6.877, 81.0692),
(25, 'Embilipitiya', 6.3144, 80.8437),
(26, 'Gampaha', 7.0873, 80.014),
(27, 'Hatton', 6.8995, 80.595),
(28, 'Horana', 6.7178, 80.0633),
(29, 'Kalutara', 6.5833, 79.9608),
(30, 'Kegalle', 7.2515, 80.3464),
(31, 'Kelaniya', 6.9602, 79.9569),
(32, 'Kuliyapitiya', 7.4712, 80.045),
(33, 'Kurunegala', 7.4877, 80.3634),
(34, 'Maharagama', 6.8522, 79.9587),
(35, 'Mannar', 8.976, 79.9093),
(36, 'Mullaitivu', 9.267, 80.8141),
(37, 'Nuwara Eliya', 6.9707, 80.7832),
(38, 'Panadura', 6.7131, 79.9073),
(39, 'Puttalam', 8.0349, 79.8282),
(40, 'Ratnapura', 6.7051, 80.3843),
(41, 'Wattala', 6.9894, 79.9024),
(42, 'Wellawaya', 6.7464, 81.103),
(43, 'Warakapola', 7.1995, 80.0221),
(44, 'Wennappuwa', 7.3316, 79.8324),
(45, 'Hikkaduwa', 6.1391, 80.103),
(46, 'Ambalangoda', 6.2333, 80.0569),
(47, 'Ampara', 7.2955, 81.6724),
(48, 'Badulla', 6.9934, 81.055),
(49, 'Hambantota', 6.123, 81.1218),
(50, 'Kattankudy', 7.7194, 81.6981),
(51, 'Kilinochchi', 9.3962, 80.3996),
(52, 'Point Pedro', 9.8167, 80.2333),
(53, 'Valvettithurai', 9.8167, 80.1833),
(54, 'Akurana', 7.4215, 80.5757),
(55, 'Avissawella', 6.9541, 80.2452),
(56, 'Balapitiya', 6.2442, 80.0562),
(57, 'Bentota', 6.4204, 79.998),
(58, 'Dambulla', 7.8604, 80.651),
(59, 'Delgoda', 6.9558, 79.9904),
(60, 'Eheliyagoda', 6.792, 80.3495),
(61, 'Eravur', 7.7, 81.6167),
(62, 'Homagama', 6.8419, 80.0023),
(63, 'Ja-Ela', 7.084, 79.9584),
(64, 'Kadugannawa', 7.2515, 80.5026),
(65, 'Kaduwela', 6.9478, 79.9847),
(66, 'Katunayake', 7.1674, 79.8831),
(67, 'Kolonnawa', 6.9381, 79.9584),
(68, 'Minuwangoda', 7.1719, 79.975),
(69, 'Monaragala', 6.8781, 81.3459),
(70, 'Moratuwa', 6.773, 79.8822),
(71, 'Nawalapitiya', 7.0459, 80.24),
(72, 'Peliyagoda', 6.9892, 79.9467),
(73, 'Rikillagaskada', 7.1401, 80.7783),
(74, 'Sri Jayawardenepura Kotte', 6.9271, 79.8612),
(75, 'Tangalle', 6.022, 80.7954),
(76, 'Vavuniya', 8.7517, 80.4982),
(77, 'Wattegama', 7.356, 80.6781),
(78, 'Baddegama', 6.1384, 80.1791),
(79, 'Battaramulla South', 6.9245, 79.9583),
(80, 'Bogahawatte', 6.703, 80.2439),
(81, 'Bulathkohupitiya', 7.058, 80.2513),
(82, 'Buthpitiya', 6.8995, 80.0859),
(83, 'Buttala', 6.3661, 81.3422),
(84, 'Cheddikulam', 8.7767, 80.5092),
(85, 'Chunnakam', 9.7833, 80.1556),
(86, 'Colombo Fort', 6.9416, 79.8453),
(87, 'Darga Town', 6.8911, 79.9031),
(88, 'Dekatana', 7.011, 80.076),
(89, 'Deniyaya', 6.3426, 80.5545),
(90, 'Dharga Town', 6.8911, 79.9031),
(91, 'Dikwella', 5.9694, 80.6891),
(92, 'Egodauyana', 6.9833, 79.9833),
(93, 'Elpitiya', 6.2885, 80.0836),
(94, 'Galagedara', 7.3684, 80.5672),
(95, 'Galkissa', 6.8381, 79.8663),
(96, 'Gelioya', 7.3275, 80.6632),
(97, 'Hakmana', 6.192, 80.7719),
(98, 'Halawatha', 6.9784, 79.9587),
(99, 'Hanwella Ihala', 6.9025, 80.1074),
(100, 'Harispattuwa', 7.3776, 80.707),
(101, 'Hendala', 6.9857, 79.9166),
(102, 'Hulanuge', 6.7393, 80.3051),
(103, 'Ingiriya', 6.6492, 80.1165),
(104, 'Jaela', 7.0855, 79.9626),
(105, 'Jawatte', 6.9113, 79.886),
(106, 'Kadawatha', 6.9806, 79.9589),
(107, 'Kahatuduwa', 6.6997, 80.0399),
(108, 'Kalawana', 6.4979, 80.3223),
(109, 'Kalkudah', 7.7333, 81.0167),
(110, 'Kiriwaththuduwa', 6.8019, 79.9507),
(111, 'Kochchikade', 7.2335, 79.9833),
(112, 'Kosgoda', 6.3409, 80.0443),
(113, 'Kotikawatta', 6.9383, 79.9843),
(114, 'Kotmale', 7.2491, 80.6712),
(115, 'Lindula', 6.9774, 80.2592),
(116, 'Lunuwila', 7.686, 80.003),
(117, 'Madampagama', 6.1691, 80.1822),
(118, 'Madulsima', 6.896, 80.842),
(119, 'Maho', 7.4484, 80.0451),
(120, 'Mathugama', 6.5298, 80.111),
(121, 'Mawathagama', 7.3661, 80.437),
(122, 'Mawanella', 7.2534, 80.3293),
(123, 'Neluwa', 6.3086, 80.4922),
(124, 'Nittambuwa', 7.1675, 80.0352),
(125, 'Obadawatta', 6.9122, 79.9525),
(126, 'Padukka', 6.8551, 80.1101),
(127, 'Pannala', 7.2983, 80.0177),
(128, 'Pugoda', 7.0524, 79.9812),
(129, 'Rakwana', 6.4676, 80.6511),
(130, 'Rambukkana', 7.2581, 80.3465),
(131, 'Ratmalana', 6.8252, 79.8873),
(132, 'Ruwanwella', 7.0397, 80.093),
(133, 'Talawakele', 6.9226, 80.5311),
(134, 'Teldeniya', 7.2671, 80.6683),
(135, 'Thalangama', 6.9467, 79.9625),
(136, 'Wadduwa', 6.7126, 79.947),
(137, 'Wariyapola', 7.6509, 80.1206),
(138, 'Weeraketiya', 6.144, 80.7291),
(139, 'Wellampitiya', 6.9373, 79.9208);

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id` int(11) NOT NULL,
  `name` varchar(70) NOT NULL,
  `email` varchar(70) NOT NULL,
  `vehicle_type` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `name`, `email`, `vehicle_type`, `password`, `tel`, `status`) VALUES
(5, 'bim', 'bim@gmail.com', '4', 'd722dbcb93d6ca952b49928b37cac8e1', '1234', 0),
(6, 'kamesh', 'k@gmail.com', '7', '827ccb0eea8a706c4c34a16891f84e7b', '1234567', 0),
(9, 'bimsara', 'bimsarasw@gmail.com', '5', '202cb962ac59075b964b07152d234b70', '077654123', 0),
(10, 'kamesh', 'kamesh @123', '5', '289dff07669d7a23de0ef88d2f7129e7', '0701234321', 0),
(12, 'himaya', 'himaya@gmail.com', '4', 'd254c8a084d4545bd80577481aa03076', '077656789', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ride`
--

CREATE TABLE `ride` (
  `rideId` int(11) NOT NULL,
  `start_latitude` float NOT NULL,
  `start_longitude` float NOT NULL,
  `end_latitude` float NOT NULL,
  `end_longitude` float NOT NULL,
  `vehicle_type` int(11) NOT NULL,
  `distance` float NOT NULL DEFAULT '0',
  `fare` float NOT NULL DEFAULT '0',
  `date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rider_id` int(11) NOT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'wait_driver'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ride`
--

INSERT INTO `ride` (`rideId`, `start_latitude`, `start_longitude`, `end_latitude`, `end_longitude`, `vehicle_type`, `distance`, `fare`, `date_time`, `rider_id`, `driver_id`, `status`) VALUES
(9, 6.88842, 79.8937, 6.9478, 79.9847, 4, 12.02, 1202, '2023-10-21 20:58:43', 10, 2, 'completed'),
(11, 6.9271, 79.8612, 6.89006, 79.8951, 4, 5.57, 557, '2023-10-21 21:43:13', 10, 2, 'completed'),
(14, 6.9478, 79.9847, 6.9271, 79.8612, 4, 13.82, 1382, '2023-10-22 08:09:16', 10, 2, 'completed'),
(32, 6.91568, 79.9739, 6.9806, 79.9589, 4, 7.41, 741, '2023-10-25 09:54:15', 10, 5, 'completed'),
(33, 6.93831, 79.8489, 6.94095, 79.8768, 4, 3.09, 309, '2023-10-27 06:47:49', 11, 5, 'completed'),
(34, 6.81173, 80.2088, 6.9394, 79.8476, 4, 42.32, 4232, '2023-10-27 06:50:51', 11, 5, 'completed'),
(35, 7.0457, 79.942, 6.95148, 79.9444, 4, 10.48, 1048, '2023-10-27 06:51:24', 11, 5, 'completed'),
(36, 6.94994, 80.2565, 6.9303, 79.863, 4, 43.49, 4349, '2023-10-27 06:51:53', 11, 5, 'completed'),
(38, 6.95804, 79.8879, 6.9168, 79.8804, 4, 4.66, 466, '2023-10-27 06:53:06', 11, 5, 'completed');

-- --------------------------------------------------------

--
-- Table structure for table `rider`
--

CREATE TABLE `rider` (
  `id` int(11) NOT NULL,
  `name` varchar(70) NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` varchar(250) NOT NULL,
  `tel` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rider`
--

INSERT INTO `rider` (`id`, `name`, `email`, `password`, `tel`) VALUES
(11, 'Sathnindu', 'sathnindu@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0711427659'),
(12, 'Samindi', 'samindi@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0714322121'),
(13, 'Nimal', 'Nimal@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0715433467'),
(14, 'Priyantha', 'priyantha@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0784356778'),
(15, 'Kumara', 'kumara@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0774567898'),
(16, 'Dilhara', 'dilhara@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0712345678'),
(17, 'Sumudu', 'sumudu@gmail.com', 'd722dbcb93d6ca952b49928b37cac8e1', '0774567665');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_type`
--

CREATE TABLE `vehicle_type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `rate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle_type`
--

INSERT INTO `vehicle_type` (`id`, `name`, `rate`) VALUES
(4, 'Tuk', 100),
(5, 'Car', 300),
(7, 'Bike', 50),
(8, 'lorry', 1000),
(9, 'van', 800);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `ride`
--
ALTER TABLE `ride`
  ADD PRIMARY KEY (`rideId`);

--
-- Indexes for table `rider`
--
ALTER TABLE `rider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `ride`
--
ALTER TABLE `ride`
  MODIFY `rideId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `rider`
--
ALTER TABLE `rider`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `vehicle_type`
--
ALTER TABLE `vehicle_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
