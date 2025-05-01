-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2025 at 03:27 PM
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
  `b_cash` float NOT NULL,
  `b_change` float NOT NULL,
  `b_status` varchar(255) NOT NULL,
  `g_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_bookings`
--

INSERT INTO `tbl_bookings` (`b_id`, `rm_id`, `rm_type`, `rm_status`, `g_fname`, `g_lname`, `g_age`, `g_email`, `b_cin`, `b_cout`, `b_cash`, `b_change`, `b_status`, `g_image`) VALUES
(3, 4, 'Standard Room', 'Booked', 'Jasmine', 'Flores', 26, 'jasminef87@gmail.com', '2025-05-02', '2025-05-03', 1000, 500, 'Pending', ''),
(4, 9, 'Deluxe Room', 'Booked', 'Sophia', 'Reyes', 35, 'sophiar01@yahoo.com', '2025-05-04', '2025-05-05', 800, 50, 'Approved', ''),
(5, 14, 'Suite Room', 'Booked', 'Zoe', 'Ramos', 25, 'zoeramos@hotmail.com', '2025-05-06', '2025-05-07', 1500, 500, 'Pending', ''),
(6, 15, 'Suite Room', 'Booked', 'Stella', 'Mendoza', 32, 'stellamendoza@gmail.com', '2025-05-08', '2025-05-09', 2000, 1000, 'Pending', '');

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
(6, 21, 'Logged In from the System', '2025-05-01 18:58:47'),
(7, 21, 'Logged In from the System', '2025-05-01 19:02:31'),
(8, 21, 'Logged In from the System', '2025-05-01 19:18:18'),
(9, 21, 'Logged In from the System', '2025-05-01 19:27:04'),
(10, 21, 'Logged Out from the System', '2025-05-01 19:27:26'),
(11, 21, 'Logged In from the System', '2025-05-01 19:27:33'),
(12, 21, 'Logged In from the System', '2025-05-01 19:40:51'),
(13, 21, 'Logged In from the System', '2025-05-01 19:46:35'),
(14, 21, 'Logged In from the System', '2025-05-01 20:07:43'),
(15, 21, 'Logged In from the System', '2025-05-01 20:15:22'),
(16, 21, 'Logged In from the System', '2025-05-01 20:16:20'),
(17, 21, 'Logged In from the System', '2025-05-01 20:17:39'),
(18, 21, 'Logged In from the System', '2025-05-01 20:19:19'),
(19, 21, 'Logged In from the System', '2025-05-01 20:19:43'),
(20, 21, 'Logged In from the System', '2025-05-01 20:20:03'),
(21, 21, 'Logged In from the System', '2025-05-01 20:20:59'),
(22, 21, 'Logged In from the System', '2025-05-01 20:21:35'),
(23, 21, 'Logged In from the System', '2025-05-01 20:22:24'),
(24, 21, 'Logged In from the System', '2025-05-01 20:22:55'),
(25, 21, 'Logged In from the System', '2025-05-01 20:23:40'),
(26, 21, 'Logged In from the System', '2025-05-01 20:25:50'),
(27, 21, 'Logged In from the System', '2025-05-01 20:26:36'),
(28, 21, 'Logged In from the System', '2025-05-01 20:27:26'),
(29, 21, 'Logged In from the System', '2025-05-01 20:27:56'),
(30, 21, 'Logged In from the System', '2025-05-01 20:31:09'),
(31, 21, 'Logged In from the System', '2025-05-01 20:35:26'),
(32, 21, 'Logged In from the System', '2025-05-01 20:36:38'),
(33, 21, 'Logged In from the System', '2025-05-01 20:42:38'),
(34, 21, 'Logged In from the System', '2025-05-01 20:43:13'),
(35, 21, 'Logged In from the System', '2025-05-01 20:43:43'),
(36, 21, 'Logged In from the System', '2025-05-01 20:44:25'),
(37, 21, 'Logged Out from the System', '2025-05-01 20:45:41'),
(38, 32, 'Logged In from the System', '2025-05-01 20:46:00'),
(39, 32, 'Logged Out from the System', '2025-05-01 20:46:28'),
(40, 21, 'Logged In from the System', '2025-05-01 20:46:35'),
(41, 21, 'Logged In from the System', '2025-05-01 20:57:34'),
(42, 21, 'Logged In from the System', '2025-05-01 21:04:45'),
(43, 21, 'Logged Out from the System', '2025-05-01 21:05:26'),
(44, 21, 'Logged In from the System', '2025-05-01 21:05:34'),
(45, 21, 'Logged In from the System', '2025-05-01 21:06:09'),
(46, 21, 'Logged In from the System', '2025-05-01 21:06:44'),
(47, 21, 'Logged In from the System', '2025-05-01 21:07:41'),
(48, 21, 'Logged In from the System', '2025-05-01 21:12:52'),
(49, 21, 'Logged In from the System', '2025-05-01 21:17:30'),
(50, 21, 'Logged In from the System', '2025-05-01 21:19:48'),
(51, 21, 'Logged In from the System', '2025-05-01 21:26:03'),
(52, 21, 'Logged Out from the System', '2025-05-01 21:26:41');

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

--
-- Dumping data for table `tbl_recovery`
--

INSERT INTO `tbl_recovery` (`r_id`, `user_id`, `f_ans`, `s_ans`, `t_ans`) VALUES
(2, 21, '123', '456', '789');

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
(5, 'Standard Room', 500, 'Vacant'),
(6, 'Standard Room', 500, 'Vacant'),
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
(17, 'Suite Room', 1000, 'Vacant'),
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
(31, 'Isaac', 'Sharp', 'brandonbaker@yahoo.com', 9286479906, 'isharp112', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 24, 'Admin', 'Inactive', ''),
(32, 'Zachary', 'Zachary Spencer', 'fryeashley@gmail.com', 9171088828, 'zspencer911', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 28, 'Admin', 'Active', '');

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
  MODIFY `b_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `tbl_recovery`
--
ALTER TABLE `tbl_recovery`
  MODIFY `r_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_room`
--
ALTER TABLE `tbl_room`
  MODIFY `room_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

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
