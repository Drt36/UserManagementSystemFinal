-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 12:35 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `umscw`
--

-- --------------------------------------------------------

--
-- Table structure for table `added`
--

CREATE TABLE `added` (
  `add_id` int(10) UNSIGNED NOT NULL,
  `date1` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `added`
--

INSERT INTO `added` (`add_id`, `date1`) VALUES
(1, '2020-05-26'),
(2, '2020-05-26'),
(3, '2020-05-26'),
(4, '2020-05-27'),
(5, '2020-05-28'),
(6, '2020-05-30'),
(7, '2020-06-02');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `history_id` int(10) UNSIGNED NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `task` varchar(100) DEFAULT NULL,
  `time1` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`history_id`, `email`, `task`, `time1`) VALUES
(348, 'dharmarajthanait25@gmail.com', 'Login into System', 'Thu May 28 14:13:19 NPT 2020'),
(349, 'dharmarajthanait25@gmail.com', 'Logout from System', 'Thu May 28 14:14:41 NPT 2020'),
(350, 'dharmarajthanait25@gmail.com', 'Login into System', 'Thu May 28 20:05:15 NPT 2020'),
(351, 'dharmarajthanait25@gmail.com', 'Logout from System', 'Thu May 28 20:07:21 NPT 2020'),
(355, 'Admnmanagement7@gmail.com', 'Logout from System', 'Sat May 30 09:57:11 NPT 2020'),
(361, 'Admnmanagement7@gmail.com', 'Login into System', 'Sat May 30 10:01:23 NPT 2020'),
(362, 'Admnmanagement7@gmail.com', 'Removed user named as:Sahani', 'Sat May 30 10:01:38 NPT 2020'),
(363, 'Admnmanagement7@gmail.com', 'Logout from System', 'Sat May 30 10:01:50 NPT 2020'),
(367, 'Admnmanagement7@gmail.com', 'Login into System', 'Tue Jun 02 08:05:39 NPT 2020'),
(368, 'Admnmanagement7@gmail.com', 'Removed user named as:dharma', 'Tue Jun 02 08:06:29 NPT 2020'),
(369, 'Admnmanagement7@gmail.com', 'Logout from System', 'Tue Jun 02 08:07:08 NPT 2020'),
(370, 'Admnmanagement7@gmail.com', 'Login into System', 'Sat Jun 06 11:26:49 NPT 2020'),
(371, 'dharmarajthanait25@gmail.com', 'Login into System', 'Sun Jun 07 14:26:16 NPT 2020'),
(372, 'dharmarajthanait25@gmail.com', 'Logout from System', 'Sun Jun 07 14:49:15 NPT 2020');

-- --------------------------------------------------------

--
-- Table structure for table `removed`
--

CREATE TABLE `removed` (
  `remove_id` int(10) UNSIGNED NOT NULL,
  `date1` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `removed`
--

INSERT INTO `removed` (`remove_id`, `date1`) VALUES
(1, '2020-05-26'),
(2, '2020-05-26'),
(3, '2020-05-26'),
(4, '2020-05-27'),
(5, '2020-05-27'),
(6, '2020-05-27'),
(7, '2020-05-27'),
(8, '2020-05-30'),
(9, '2020-06-02');

-- --------------------------------------------------------

--
-- Table structure for table `removeduser`
--

CREATE TABLE `removeduser` (
  `remove_id` int(10) UNSIGNED NOT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `removeduser`
--

INSERT INTO `removeduser` (`remove_id`, `username`) VALUES
(6, 'aatmarai100'),
(7, 'dharmarajthanait36'),
(8, 'drt'),
(9, 'aatmarai100'),
(10, 'dharmaraj,email=dharmarajthanait25@gmail.com'),
(11, 'dharmaraj'),
(12, 'Drt36'),
(13, 'Sahani'),
(14, 'dharma');

-- --------------------------------------------------------

--
-- Table structure for table `resetsupport`
--

CREATE TABLE `resetsupport` (
  `resset_id` int(10) UNSIGNED NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `birthdate` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `password1` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `first_name`, `last_name`, `email`, `is_admin`, `phone_number`, `address`, `birthdate`, `gender`, `password1`) VALUES
(53, 'Admin', 'Super', 'user1', 'Admnmanagement7@gmail.com', 1, '9844710625', 'Kathmandu-32 ', '12/09/2001', 'Male', '7488e331b8b64e5794da3fa4eb10ad5d'),
(68, 'dharmarajthanait25', 'Dharma', 'Thanait', 'dharmarajthanait25@gmail.com', 0, '9844710625', 'Kathmandu-32 koteshwor, Nepal', '12/19/2001', 'Male', '1bbd886460827015e5d605ed44252251');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `added`
--
ALTER TABLE `added`
  ADD PRIMARY KEY (`add_id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`history_id`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `removed`
--
ALTER TABLE `removed`
  ADD PRIMARY KEY (`remove_id`);

--
-- Indexes for table `removeduser`
--
ALTER TABLE `removeduser`
  ADD PRIMARY KEY (`remove_id`);

--
-- Indexes for table `resetsupport`
--
ALTER TABLE `resetsupport`
  ADD PRIMARY KEY (`resset_id`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `added`
--
ALTER TABLE `added`
  MODIFY `add_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `history_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=373;

--
-- AUTO_INCREMENT for table `removed`
--
ALTER TABLE `removed`
  MODIFY `remove_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `removeduser`
--
ALTER TABLE `removeduser`
  MODIFY `remove_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `resetsupport`
--
ALTER TABLE `resetsupport`
  MODIFY `resset_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `resetsupport`
--
ALTER TABLE `resetsupport`
  ADD CONSTRAINT `resetsupport_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
