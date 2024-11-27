-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2024 at 12:31 AM
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
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `section` varchar(255) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `room` varchar(255) NOT NULL,
  `teachers_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_id`, `class_name`, `section`, `subject`, `room`, `teachers_id`) VALUES
(1, 'Joed\'s Class', '2102', 'Object-Oriented-Programming', 'HEB 210', NULL),
(2, 'DSA - 121', '1102', 'Data Structures and Algorithm', 'heb 201', NULL),
(6, 'data', '101', 'data', 'heb 211', 1),
(7, 'math', '102', 'mathe', 'heb 111', 1);

-- --------------------------------------------------------

--
-- Table structure for table `classwork`
--

CREATE TABLE `classwork` (
  `classwork_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` enum('active','completed','archived') DEFAULT 'active',
  `points` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `student_firstname` varchar(255) NOT NULL,
  `student_lastname` varchar(255) NOT NULL,
  `classwork_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `section_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `student_firstname`, `student_lastname`, `classwork_id`, `class_id`, `subject_id`, `section_id`) VALUES
(2, 'Juan', 'De La Cruz', NULL, NULL, NULL, NULL),
(3, 'John Eduard', 'De Villa', NULL, NULL, NULL, NULL),
(4, 'Joed', 'D.', NULL, NULL, NULL, NULL),
(5, 'John Eduard', 'De Villa', NULL, NULL, NULL, NULL),
(6, 'Felman', 'Eleponga', NULL, NULL, NULL, NULL),
(7, 'John Eduard', 'De Villa', NULL, NULL, NULL, NULL),
(8, 'joed', 'joed', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `student_classwork`
--

CREATE TABLE `student_classwork` (
  `student_classwork_id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `classwork_id` int(11) DEFAULT NULL,
  `grade` decimal(5,2) DEFAULT NULL,
  `submission_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  `subject_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(3, 'Joed D.', 'pogiako', 'joedD@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `teacher_id` (`teachers_id`);

--
-- Indexes for table `classwork`
--
ALTER TABLE `classwork`
  ADD PRIMARY KEY (`classwork_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `student_classwork`
--
ALTER TABLE `student_classwork`
  ADD PRIMARY KEY (`student_classwork_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `classwork_id` (`classwork_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);

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
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `classwork`
--
ALTER TABLE `classwork`
  MODIFY `classwork_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student_classwork`
--
ALTER TABLE `student_classwork`
  MODIFY `student_classwork_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `teachers_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`teachers_id`) REFERENCES `teachers` (`teachers_id`);

--
-- Constraints for table `classwork`
--
ALTER TABLE `classwork`
  ADD CONSTRAINT `classwork_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE;

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE;

--
-- Constraints for table `student_classwork`
--
ALTER TABLE `student_classwork`
  ADD CONSTRAINT `student_classwork_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `student_classwork_ibfk_2` FOREIGN KEY (`classwork_id`) REFERENCES `classwork` (`classwork_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
