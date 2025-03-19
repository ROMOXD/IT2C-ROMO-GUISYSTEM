-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2025 at 12:59 PM
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
  `u_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_cnum`, `u_usern`, `u_pass`, `u_gen`, `u_age`, `u_type`, `u_status`) VALUES
(1, 'Mark Kevin', 'Romo', 'mrkvnurm80@gmail.com', 9454278301, 'ROMOXD', '12345678', 'Male', 19, 'Admin', 'Active'),
(2, 'Roronoa ', 'Zoro', 'santoryou@gmail.com', 9123456789, 'zoro69', '12345678', 'Male', 23, 'Room Coordinator', 'Active'),
(3, 'Mark Kevin ', 'Romo', 'mrkvnurm80@gmail.com', 9454278301, 'romoblabla', '12345678', 'Male', 19, 'Front Desk Staff', 'Active'),
(4, 'Mark', 'Romo', 'romo@gmail.com', 9454278301, 'romo69', '12345678', 'Male', 19, 'sheeeshh', 'Active'),
(5, 'Mugiwara', 'Luffy', 'strawhat69@gmail.com', 9338423427, 'strawhat69', '12345678', 'Male', 19, 'Admin', 'Inactive'),
(6, 'Mark Kevin', 'Romo', 'romosimp@gmail.com', 213435, 'simp69', '45368456385', 'Male', 19, 'Front Desk Staff', 'Inactive'),
(7, 'Mark Kevin', 'Romo', 'mrkvnurm79@gmail.com', 2135435645, 'wahaha', '12345678', 'Male', 19, 'Front Desk Staff', 'Inactive'),
(8, 'test', 'test', 'test@gmail.com', 94454278301, 'wahaaha', '12345678', 'Male', 19, 'Front Desk Staff', 'Inactive'),
(9, 'testt', 'testt', 'testt@gmail.com', 213454453, 'user', '12345678', 'Male', 19, 'Hotel Manager ^Admin^', 'Inactive'),
(10, 'OMOR', 'SHESSHH', 'romm@gmail.com', 213454453, 'RAMO', '12345678', 'Male', 23, 'Front Desk Staff', 'Active'),
(11, 'DIGGLE', 'DIGGIE', 'OMOR@gmail.com', 9454278301, 'DIGGY8080', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 12, 'Admin', 'Active'),
(12, 'ROMO', 'ROMO', 'romo80@gmail.com', 83294362734, 'ROMO801', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Male', 19, '123', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
