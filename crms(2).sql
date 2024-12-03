-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2024 at 09:17 AM
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
-- Database: `crms`
--

-- --------------------------------------------------------

--
-- Table structure for table `archiveclasses`
--

CREATE TABLE `archiveclasses` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `section_code` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `time_deleted` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `archiveclasses`
--

INSERT INTO `archiveclasses` (`class_id`, `class_name`, `section_code`, `subject`, `time_deleted`) VALUES
(12, 'joed', '1102', 'joed', '2024-12-01 06:33:33');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `section_code` int(11) DEFAULT NULL,
  `subject` varchar(50) NOT NULL,
  `teachers_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_id`, `class_name`, `section_code`, `subject`, `teachers_id`) VALUES
(1, 'Joed\'s Class', 2102, 'Object-Oriented-Programming', 3),
(2, 'DSA - 121', 1102, 'Data Structures and Algorithm', 3),
(13, 'Xyreels Class', 1102, 'Math', 5),
(14, 'jojo', 1101, 'Math', 1);

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `grades_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `activity1` double(5,2) DEFAULT NULL,
  `activity2` double(5,2) DEFAULT NULL,
  `activity3` double(5,2) DEFAULT NULL,
  `activity4` double(5,2) DEFAULT NULL,
  `activity5` double(5,2) DEFAULT NULL,
  `midterms` double(5,2) DEFAULT NULL,
  `finals` double(5,2) DEFAULT NULL,
  `project` double(5,2) DEFAULT NULL,
  `ave_grade` double(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`grades_id`, `student_id`, `activity1`, `activity2`, `activity3`, `activity4`, `activity5`, `midterms`, `finals`, `project`, `ave_grade`) VALUES
(1, 35, 91.00, 92.00, 92.00, 97.00, 93.00, 95.00, 96.00, 97.00, 94.12);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(50) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `building` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_name`, `capacity`, `building`) VALUES
(1, 'Heb-201', 50, 'Higher Education Building'),
(2, 'Heb-202', 50, 'Higher Education Building'),
(3, 'Heb-203', 50, 'Higher Education Building'),
(4, 'Heb-204', 50, 'Higher Education Building'),
(5, 'Heb-205', 50, 'Higher Education Building');

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `schedule_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `day_of_week` enum('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday') DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `section_id` int(11) NOT NULL,
  `section_name` varchar(255) DEFAULT NULL,
  `section_code` int(11) DEFAULT NULL,
  `student_count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`section_id`, `section_name`, `section_code`, `student_count`) VALUES
(12, 'BSIT - 1101', 1101, 0),
(14, 'BSIT - 1102', 1102, 0),
(15, 'BSIT - 1103', 1103, 0),
(16, 'BSIT - 1104', 1104, 0),
(17, 'BSIT - 2102', 2102, 0);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `student_firstname` varchar(255) NOT NULL,
  `student_lastname` varchar(255) NOT NULL,
  `section_code` int(11) DEFAULT NULL,
  `average_grade` int(11) DEFAULT NULL,
  `student_account_id` int(11) DEFAULT NULL,
  `account_status` varchar(20) DEFAULT 'PENDING_REGISTRATION'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `student_firstname`, `student_lastname`, `section_code`, `average_grade`, `student_account_id`, `account_status`) VALUES
(35, 'John Eduard', 'De Villa', 1101, 0, NULL, 'PENDING_REGISTRATION'),
(36, 'joed123', '123456', 1103, NULL, NULL, 'PENDING_REGISTRATION'),
(37, 'Neil', 'Delmo', 1102, NULL, 5, 'PENDING_REGISTRATION');

-- --------------------------------------------------------

--
-- Table structure for table `student_accounts`
--

CREATE TABLE `student_accounts` (
  `student_account_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT 'PENDING_ENROLLMENT'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_accounts`
--

INSERT INTO `student_accounts` (`student_account_id`, `full_name`, `password`, `email`, `status`) VALUES
(1, 'Millan Abrenica', 'qwerty', 'millan123@gmail.com', 'PENDING_ENROLLMENT'),
(2, 'qwe', 'qwe', 'qwe', 'PENDING_ENROLLMENT'),
(3, 'Adobo de Mayo', 'asd', 'mayo', 'PENDING_ENROLLMENT'),
(4, 'Jojo Kujo', 'po', 'jojo', 'PENDING_ENROLLMENT'),
(5, 'Neil Delmo', 'zen', 'delmo@gmail.com', 'PENDING_ENROLLMENT');

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `teachers_id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`teachers_id`, `fullname`, `password`, `email`) VALUES
(1, 'Joed Pogi', 'qwerty', 'joed123@gmail.com'),
(3, 'Joed D.', 'pogiako', 'joedD@gmail.com'),
(4, 'asd', 'asd', 'asd'),
(5, 'Xyreel Laguras', 'qwerty', 'laguras123@gmail.com'),
(6, 'Janine Gamez', 'zxcv', 'game');

-- --------------------------------------------------------

--
-- Stand-in structure for view `unmatched_students`
-- (See below for the actual view)
--
CREATE TABLE `unmatched_students` (
`student_id` int(11)
,`student_firstname` varchar(255)
,`student_lastname` varchar(255)
,`section_code` int(11)
,`student_account_id` int(11)
,`full_name` varchar(255)
,`email` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `unmatched_students`
--
DROP TABLE IF EXISTS `unmatched_students`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `unmatched_students`  AS SELECT `s`.`student_id` AS `student_id`, `s`.`student_firstname` AS `student_firstname`, `s`.`student_lastname` AS `student_lastname`, `s`.`section_code` AS `section_code`, `sa`.`student_account_id` AS `student_account_id`, `sa`.`full_name` AS `full_name`, `sa`.`email` AS `email` FROM (`students` `s` left join `student_accounts` `sa` on(concat(`s`.`student_firstname`,' ',`s`.`student_lastname`) = `sa`.`full_name`)) WHERE `sa`.`student_account_id` is null OR `s`.`student_account_id` is null ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `teacher_id` (`teachers_id`),
  ADD KEY `fk_section_code` (`section_code`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`grades_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`schedule_id`),
  ADD UNIQUE KEY `room_id` (`room_id`,`day_of_week`,`start_time`,`end_time`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD PRIMARY KEY (`section_id`),
  ADD UNIQUE KEY `section_code` (`section_code`),
  ADD KEY `fk_section_code` (`section_code`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `fk_section` (`section_code`),
  ADD KEY `student_account_id` (`student_account_id`);

--
-- Indexes for table `student_accounts`
--
ALTER TABLE `student_accounts`
  ADD PRIMARY KEY (`student_account_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`teachers_id`),
  ADD UNIQUE KEY `fullname` (`fullname`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `grades_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sections`
--
ALTER TABLE `sections`
  MODIFY `section_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `student_accounts`
--
ALTER TABLE `student_accounts`
  MODIFY `student_account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teachers_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`teachers_id`) REFERENCES `teachers` (`teachers_id`),
  ADD CONSTRAINT `fk_section_code` FOREIGN KEY (`section_code`) REFERENCES `sections` (`section_code`);

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `schedules_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  ADD CONSTRAINT `schedules_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`student_account_id`) REFERENCES `student_accounts` (`student_account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
