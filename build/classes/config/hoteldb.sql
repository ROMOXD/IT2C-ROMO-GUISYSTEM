-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2025 at 04:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bookings`
--

CREATE TABLE `tbl_bookings` (
  `b_id` int(50) NOT NULL,
  `rm_id` int(50) NOT NULL,
  `rm_type` varchar(255) NOT NULL,
  `rm_status` varchar(255) NOT NULL,
  `g_fname` varchar(255) NOT NULL,
  `g_lname` varchar(255) NOT NULL,
  `g_age` int(50) NOT NULL,
  `g_email` varchar(255) NOT NULL,
  `b_cin` varchar(255) NOT NULL,
  `b_cout` varchar(255) NOT NULL,
  `time_in` varchar(255) NOT NULL,
  `b_cash` float NOT NULL,
  `b_change` float NOT NULL,
  `b_status` varchar(255) NOT NULL,
  `g_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_bookings`
--

INSERT INTO `tbl_bookings` (`b_id`, `rm_id`, `rm_type`, `rm_status`, `g_fname`, `g_lname`, `g_age`, `g_email`, `b_cin`, `b_cout`, `time_in`, `b_cash`, `b_change`, `b_status`, `g_image`) VALUES
(3, 4, 'Standard Room', 'Booked', 'Jasmine', 'Flores', 26, 'jasminef87@gmail.com', '2025-05-02', '2025-05-03', '1 Days', 1000, 500, 'Approved', 'src/UserImages/anime15.png'),
(4, 9, 'Deluxe Room', 'Booked', 'Sophia', 'Reyes', 35, 'sophiar01@yahoo.com', '2025-05-04', '2025-05-05', '1 Days', 800, 50, 'Approved', 'src/UserImages/anime18.png'),
(5, 14, 'Suite Room', 'Booked', 'Zoe', 'Ramos', 25, 'zoeramos@hotmail.com', '2025-05-06', '2025-05-07', '1 Days', 1500, 500, 'Approved', ''),
(6, 15, 'Suite Room', 'Booked', 'Stella', 'Mendoza', 32, 'stellamendoza@gmail.com', '2025-05-08', '2025-05-09', '1 Days', 2000, 1000, 'Approved', ''),
(7, 5, 'Standard Room', 'Booked', 'Maria Angela', 'Dela Cruz', 32, 'maria.delacruz@gmail.com', '2025-05-19', '2025-05-25', '6 Days', 1000, 500, 'Approved', ''),
(8, 6, 'Standard Room', 'Booked', 'Anthonio ', 'Reyes', 45, 'antonio.reyes@email.com', '2025-05-19', '2025-05-22', '3 Days', 1000, 500, 'Approved', ''),
(9, 7, 'Standard Room', 'Booked', 'Ian', 'Brent', 20, 'gojira@scc.com', '2025-05-21', '2025-05-23', '2 Days', 1500, 1000, 'Checked-Out', ''),
(10, 17, 'Suite Room', 'Booked', 'Anthony', 'Teves', 20, 'tevs@gmail.com', '2025-05-21', '2025-05-24', '3 Days', 4000, 3000, 'Pending', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(50) NOT NULL,
  `usr_id` int(50) NOT NULL,
  `l_actions` varchar(255) NOT NULL,
  `l_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`l_id`, `usr_id`, `l_actions`, `l_date`) VALUES
(207, 21, 'Logged In from the System', '2025-05-21 18:53:42'),
(208, 21, 'Logged Out from the System', '2025-05-21 18:54:33'),
(209, 21, 'Logged In from the System', '2025-05-21 20:05:36'),
(210, 21, 'Added Booking Record with ID of 11', '2025-05-21 20:07:19'),
(211, 21, 'Logged Out from the System', '2025-05-21 20:13:21'),
(212, 21, 'Logged In from the System', '2025-05-21 20:22:22'),
(213, 21, 'Updated Booking Record with ID of 11', '2025-05-21 20:22:49'),
(214, 21, 'Logged Out from the System', '2025-05-21 20:23:42'),
(215, 21, 'Logged In from the System', '2025-05-21 21:12:37'),
(216, 21, 'Deleted Booking Record with ID of 11', '2025-05-21 21:13:42'),
(217, 21, 'Added User Record with ID of 33', '2025-05-21 21:14:43'),
(218, 21, 'Updated User Record with ID of 33', '2025-05-21 21:15:41'),
(219, 21, 'Deleted User Record with ID of 33', '2025-05-21 21:15:46'),
(220, 21, 'Added Room Record with ID of 39', '2025-05-21 21:16:32'),
(221, 21, 'Updated Room Record with ID of 39', '2025-05-21 21:16:49'),
(222, 21, 'Deleted Room Record with ID of 39', '2025-05-21 21:16:58'),
(223, 21, 'Logged Out from the System', '2025-05-21 21:17:00'),
(224, 21, 'Logged In from the System', '2025-05-22 20:11:26'),
(225, 21, 'Logged Out from the System', '2025-05-22 20:16:09'),
(226, 21, 'Logged In from the System', '2025-05-22 20:31:30'),
(227, 21, 'Logged Out from the System', '2025-05-22 20:31:37'),
(228, 21, 'Logged In from the System', '2025-05-22 20:31:55'),
(229, 21, 'Logged Out from the System', '2025-05-22 20:32:36'),
(230, 21, 'Logged In from the System', '2025-05-22 20:49:21'),
(231, 21, 'Logged Out from the System', '2025-05-22 20:49:51'),
(232, 34, 'Logged In from the System', '2025-05-26 18:31:36'),
(233, 34, 'Logged Out from the System', '2025-05-26 18:33:14'),
(234, 21, 'Logged In from the System', '2025-05-26 18:33:25'),
(235, 21, 'Updated User Record with ID of 34', '2025-05-26 18:35:04'),
(236, 21, 'Logged Out from the System', '2025-05-26 18:35:07'),
(237, 34, 'Logged In from the System', '2025-05-26 18:35:16'),
(238, 34, 'Logged Out from the System', '2025-05-26 18:35:39'),
(239, 21, 'Logged In from the System', '2025-05-26 18:35:47'),
(240, 21, 'Updated User Record with ID of 34', '2025-05-26 18:36:25'),
(241, 21, 'Logged Out from the System', '2025-05-26 18:36:28'),
(242, 21, 'Logged In from the System', '2025-05-26 18:36:34'),
(243, 21, 'Logged Out from the System', '2025-05-26 18:36:40'),
(244, 34, 'Logged In from the System', '2025-05-26 18:36:48'),
(245, 34, 'Logged Out from the System', '2025-05-26 18:36:55'),
(246, 21, 'Logged In from the System', '2025-05-26 18:37:10'),
(247, 21, 'Updated User Record with ID of 34', '2025-05-26 18:38:33'),
(248, 21, 'Logged Out from the System', '2025-05-26 18:38:47'),
(249, 34, 'Logged In from the System', '2025-05-26 18:38:55'),
(250, 34, 'Logged Out from the System', '2025-05-26 18:39:05'),
(251, 21, 'Logged In from the System', '2025-05-26 18:39:13'),
(252, 21, 'Updated User Record with ID of 34', '2025-05-26 18:39:55'),
(253, 21, 'Logged Out from the System', '2025-05-26 18:39:58'),
(254, 21, 'Logged In from the System', '2025-05-26 18:40:06'),
(255, 21, 'Logged Out from the System', '2025-05-26 18:40:10'),
(256, 34, 'Logged In from the System', '2025-05-26 18:40:16'),
(257, 34, 'Logged Out from the System', '2025-05-26 18:40:29'),
(258, 21, 'Logged In from the System', '2025-05-26 18:43:04'),
(259, 21, 'Updated User Record with ID of 34', '2025-05-26 18:44:15'),
(260, 21, 'Logged Out from the System', '2025-05-26 18:44:17'),
(261, 34, 'Logged In from the System', '2025-05-26 18:44:28'),
(262, 34, 'Logged Out from the System', '2025-05-26 18:44:50'),
(263, 21, 'Logged In from the System', '2025-05-26 18:45:02'),
(264, 21, 'Logged Out from the System', '2025-05-26 18:45:06'),
(265, 21, 'Logged In from the System', '2025-05-26 18:58:52'),
(266, 21, 'Logged Out from the System', '2025-05-26 18:59:25'),
(267, 21, 'Logged In from the System', '2025-05-26 19:05:59'),
(268, 21, 'Logged Out from the System', '2025-05-26 19:06:32'),
(269, 21, 'Logged In from the System', '2025-05-26 19:31:30'),
(270, 21, 'Logged Out from the System', '2025-05-26 19:32:47'),
(271, 21, 'Logged In from the System', '2025-05-26 19:37:12'),
(272, 21, 'Logged Out from the System', '2025-05-26 19:37:30'),
(273, 21, 'Logged In from the System', '2025-05-26 19:57:36'),
(274, 21, 'Logged Out from the System', '2025-05-26 19:58:26'),
(275, 21, 'Logged In from the System', '2025-05-26 20:00:12'),
(276, 21, 'Logged Out from the System', '2025-05-26 20:01:26'),
(277, 21, 'Logged In from the System', '2025-05-26 20:24:45'),
(278, 21, 'Logged Out from the System', '2025-05-26 20:25:39'),
(279, 21, 'Logged In from the System', '2025-05-30 19:31:36'),
(280, 21, 'Logged Out from the System', '2025-05-30 19:32:51'),
(281, 21, 'Logged In from the System', '2025-05-30 19:35:08');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_recovery`
--

CREATE TABLE `tbl_recovery` (
  `r_id` int(50) NOT NULL,
  `user_id` int(50) NOT NULL,
  `f_ans` varchar(255) NOT NULL,
  `s_ans` varchar(255) NOT NULL,
  `t_ans` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_room`
--

CREATE TABLE `tbl_room` (
  `room_id` int(50) NOT NULL,
  `r_type` varchar(255) NOT NULL,
  `r_price` float NOT NULL,
  `r_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_room`
--

INSERT INTO `tbl_room` (`room_id`, `r_type`, `r_price`, `r_status`) VALUES
(4, 'Standard Room', 500, 'Booked'),
(5, 'Standard Room', 500, 'Booked'),
(6, 'Standard Room', 500, 'Booked'),
(7, 'Standard Room', 500, 'Vacant'),
(8, 'Standard Room', 500, 'Vacant'),
(9, 'Deluxe Room', 750, 'Booked'),
(10, 'Deluxe Room', 750, 'Vacant'),
(11, 'Deluxe Room', 750, 'Vacant'),
(12, 'Deluxe Room', 750, 'Vacant'),
(13, 'Deluxe Room', 750, 'Vacant'),
(14, 'Suite Room', 1000, 'Booked'),
(15, 'Suite Room', 1000, 'Booked'),
(16, 'Suite Room', 1000, 'Vacant'),
(17, 'Suite Room', 1000, 'Booked'),
(18, 'Suite Room', 1000, 'Vacant'),
(19, 'Standard Room', 500, 'Vacant'),
(20, 'Standard Room', 500, 'Vacant'),
(21, 'Standard Room', 500, 'Vacant'),
(22, 'Standard Room', 500, 'Vacant'),
(23, 'Standard Room', 500, 'Vacant'),
(24, 'Deluxe Room', 750, 'Vacant'),
(25, 'Deluxe Room', 750, 'Vacant'),
(26, 'Deluxe Room', 750, 'Vacant'),
(27, 'Deluxe Room', 750, 'Vacant'),
(28, 'Deluxe Room', 750, 'Vacant'),
(29, 'Suite Room', 1000, 'Vacant'),
(30, 'Suite Room', 1000, 'Vacant'),
(31, 'Suite Room', 1000, 'Vacant'),
(32, 'Suite Room', 1000, 'Vacant'),
(33, 'Suite Room', 1000, 'Vacant'),
(34, 'Standard Room', 500, 'Vacant'),
(35, 'Standard Room', 500, 'Vacant'),
(36, 'Standard Room', 500, 'Vacant'),
(37, 'Standard Room', 500, 'Vacant'),
(38, 'Standard Room', 500, 'Vacant');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(50) NOT NULL,
  `u_fname` varchar(255) NOT NULL,
  `u_lname` varchar(255) NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_cnum` bigint(50) NOT NULL,
  `u_usern` varchar(255) NOT NULL,
  `u_pass` varchar(150) NOT NULL,
  `u_gen` varchar(255) NOT NULL,
  `u_age` int(50) NOT NULL,
  `u_type` varchar(255) NOT NULL,
  `u_status` varchar(255) NOT NULL,
  `u_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_cnum`, `u_usern`, `u_pass`, `u_gen`, `u_age`, `u_type`, `u_status`, `u_image`) VALUES
(21, 'Mark Kevin', 'ROMO', 'mrkvnurm79@gmail.com', 9123456789, 'ROMOXD', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 20, 'Admin', 'Active', 'src/UserImages/Couple Pfps.png'),
(22, 'Timothy', 'Rivera', 'kennethcruz@yahoo.com', 9140660738, 'trivera190', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 29, 'User', 'Inactive', ''),
(23, 'Bethany', 'Williams', 'nathaniel65@gmail.com', 9443719717, 'bwilliams295', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Female', 36, 'Admin', 'Inactive', ''),
(24, 'Gary', 'Garcia', 'ashleycastaneda@yahoo.com', 9282979366, 'ggarcia554', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 32, 'Admin', 'Inactive', ''),
(25, 'Phillip', 'Gutierrez', 'tyler42@miller.com', 9709181669, 'pgutierrez205', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 23, 'User', 'Inactive', ''),
(26, 'Amanda', 'Hart', 'jessica85@yahoo.com', 9976293567, 'ahart527', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Female', 54, 'Admin', 'Inactive', ''),
(27, 'Daniel', 'Fleming', 'williamsharon@smith.net', 9632445527, 'dfleming182', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 40, 'Admin', 'Inactive', ''),
(28, 'Rachel', 'Olsen', 'sherrynichols@yahoo.com', 9438796545, 'rolsen289', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Female', 33, 'User', 'Inactive', ''),
(29, 'Matthew', 'Dean', 'derek36@gmail.com', 9499421800, 'mdean939', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 26, 'User', 'Inactive', ''),
(30, 'Emma', 'Goodwin', 'frenchkimberly@hotmail.com', 9071234529, 'egoodwin517', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Female', 43, 'Admin', 'Inactive', ''),
(31, 'Isaac', 'Sharp', 'brandonbaker@yahoo.com', 9286479906, 'isharp112', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 24, 'Admin', 'Active', ''),
(32, 'Zachary', 'Zachary Spencer', 'fryeashley@gmail.com', 9171088828, 'zspencer911', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 28, 'Admin', 'Active', ''),
(34, 'Carl Joseph', 'Romo', 'carlromo70@gmail.com', 9123456789, 'CARL', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 25, 'User', 'Active', 'src/UserImages/anime7.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  ADD PRIMARY KEY (`b_id`),
  ADD KEY `roomid` (`rm_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `usrid` (`usr_id`);

--
-- Indexes for table `tbl_recovery`
--
ALTER TABLE `tbl_recovery`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `userid` (`user_id`);

--
-- Indexes for table `tbl_room`
--
ALTER TABLE `tbl_room`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  MODIFY `b_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=282;

--
-- AUTO_INCREMENT for table `tbl_recovery`
--
ALTER TABLE `tbl_recovery`
  MODIFY `r_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_room`
--
ALTER TABLE `tbl_room`
  MODIFY `room_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  ADD CONSTRAINT `roomid` FOREIGN KEY (`rm_id`) REFERENCES `tbl_room` (`room_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `usrid` FOREIGN KEY (`usr_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_recovery`
--
ALTER TABLE `tbl_recovery`
  ADD CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
