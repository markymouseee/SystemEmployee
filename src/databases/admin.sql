-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2024 at 11:47 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(200) NOT NULL,
  `uid` int(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `uid`, `name`, `username`, `email`, `password`, `role`) VALUES
(1, 1, 'Mark Noriel Sanama', 'superadmin', 'sanamamarknoriel@gmail.com', '$2a$12$v0alf4zOtpszcxtdZg6f0uTaiy/9u.CH.gQbeSMYnrQyInVw5YFtS', 'Super Admin'),
(2, 2, 'Rey Jhon Pedroso', 'reyjhon', 'reyjohn@admin.com', '$2a$12$K73lRN9GqCMRkS/UjLEZFubLlJ10FjR/p0GovQ0ZaD2d5vnyFEqzW', 'Admin'),
(3, 3, 'Brilliant Agunod', 'brilliant', 'brilliant@admin.com', '$2a$12$1pIS.XvnveqPmKhTnXNKiu3gOdSdVSN9xNrkvn0Pbr0I5Li4mjcOS', 'Admin'),
(4, 4, 'Vincent Carillo', 'vincent', 'vincent@user.com', '$2a$12$aj0LPUjmC7U6OEtVtxaR/el6M1qTeRimo6gmes.CzaX6dhrsoQtNa', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
