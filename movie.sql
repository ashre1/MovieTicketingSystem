-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2017 at 08:39 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `movie`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `Cus_ID` varchar(5) NOT NULL,
  `Ticket_No` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking1`
--

CREATE TABLE IF NOT EXISTS `booking1` (
  `Cus_ID` varchar(20) NOT NULL,
  `Ticket_No` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking2`
--

CREATE TABLE IF NOT EXISTS `booking2` (
  `Cus_ID` varchar(20) NOT NULL,
  `Ticket_No` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking3`
--

CREATE TABLE IF NOT EXISTS `booking3` (
  `Cus_ID` varchar(20) NOT NULL,
  `Ticket_No` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `Cus_ID` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_ID`, `Name`, `Gender`, `Address`, `Contact`, `Email`) VALUES
('C001', 'qqqqqq', 'Male', 'zzzzzz', 'zn', 'znck'),
('C002', 'yyyyyyyy', 'Male', 'asdhfk', 'jasdk', 'asdjkfak'),
('C003', 'bbbbbbb', 'Female', 'asfd,hf', 'ajksdhjkf', 'sjdhfajk'),
('C004', 'zzzz', 'Male', 'asdkjhlfjk', 'asdfk', 'asjdkj'),
('C005', 'rabina', 'Female', 'samakhusi', '0987654321', 'rabina.maharjan@gmail.com'),
('C006', 'askjd', 'Male', 'asjkdhka', 'askdja', 'asioda');

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE IF NOT EXISTS `details` (
  `ID` varchar(10) NOT NULL,
  `Mov_Name` varchar(100) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Review` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`ID`, `Mov_Name`, `Title`, `Review`) VALUES
('001', 'holiday', 'A soldier is never off duty', 'A Soldier Is Never Off Duty is a 2014 Bollywood action thriller film written and directed by A.R. Murugadoss, and produced by Vipul Shah. It features Akshay Kumar and Sonakshi Sinha in the lead roles, along with Govinda in a supporting role. It is a remake of the 2012 Tamil film Thuppakki which was also directed by A. R. Murugadoss. The film released on 6 June 2014');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Emp_ID` varchar(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Category` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact` varchar(100) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Emp_ID`, `Name`, `UserName`, `Password`, `Gender`, `Category`, `Address`, `Contact`, `Email`) VALUES
('E001', 'bishal', 'bishal', 'bishal', 'Male', 'Frontdesk officer', 'khusibu', '9876543210', 'bishal.baula@yahoo.com'),
('E002', 'ashish', 'ashish', 'ashish', 'Male', 'Admin', 'DhokaTole', '9841523955', 'shresthaashish1@hotmail.com'),
('E003', 'pandey', 'sabita', 'pandey', 'Female', 'Frontdesk Officer', 'samakhusi', '9843320069', 'purbi.pandey@yahoo.com'),
('E004', 'yograj', 'yograj', 'yograj', 'Male', 'Frontdesk Officer', 'jhapa', '0987656789', 'goks.gotiya@yahoo.com');

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `ID` varchar(20) NOT NULL,
  `Image` varchar(200) NOT NULL,
  `Image1` varchar(200) NOT NULL,
  `Img1` varchar(200) NOT NULL,
  `Img2` varchar(200) NOT NULL,
  `Img3` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`ID`, `Image`, `Image1`, `Img1`, `Img2`, `Img3`) VALUES
('001', 'E:\\Project\\MovieTicketingSystem\\src\\com\\MTS\\ui\\pic\\hold070414_2c.jpg', 'E:\\Project\\MovieTicketingSystem\\src\\com\\MTS\\ui\\pic\\main1.jpg', 'E:\\Project\\MovieTicketingSystem\\src\\com\\MTS\\ui\\pic\\N1.jpg', 'E:\\Project\\MovieTicketingSystem\\src\\com\\MTS\\ui\\pic\\N2.jpg', 'E:\\Project\\MovieTicketingSystem\\src\\com\\MTS\\ui\\pic\\N1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `ID` varchar(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Category` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Name`, `Password`, `Category`) VALUES
('E001', 'bishal', 'bishal', 'frontdesk officer'),
('E002', 'ashish', 'ashish', 'Admin'),
('E003', 'sabita', 'pandey', 'Frontdesk Officer'),
('E004', 'yograj', 'yograj', 'Frontdesk Officer');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `Mov_Name` varchar(100) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  `Director` varchar(20) NOT NULL,
  `Release_Date` varchar(20) NOT NULL,
  `Length` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`Mov_Name`, `Genre`, `Director`, `Release_Date`, `Length`) VALUES
('Hate Story', 'Love strory', 'zzz', '2071/04/03', '2hrs 15min'),
('Holiday', 'Action', 'Marc Webb', '01 May 2014', '2 Hrs 22 Min'),
('Kick', 'Action', 'asjdaks', '2071/04/010', '2hrs 30min');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `Number` varchar(20) NOT NULL,
  `Ticket` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`Number`, `Ticket`) VALUES
('A1', 'green'),
('A2', 'green'),
('A3', 'green'),
('A4', 'green'),
('A5', 'green'),
('A6', 'green'),
('A7', 'green'),
('A8', 'green'),
('A9', 'green'),
('A10', 'green'),
('B1', 'green'),
('B2', 'green'),
('B3', 'green'),
('B4', 'green'),
('B5', 'green'),
('B6', 'green'),
('B7', 'green'),
('B8', 'green'),
('B9', 'green'),
('B10', 'green'),
('C1', 'green'),
('C2', 'green'),
('C3', 'green'),
('C4', 'green'),
('C5', 'green'),
('C6', 'green'),
('C7', 'green'),
('C8', 'green'),
('C9', 'green'),
('C10', 'green'),
('D1', 'green'),
('D2', 'green'),
('D3', 'green'),
('D4', 'green'),
('D5', 'green'),
('D6', 'green'),
('D7', 'green'),
('D8', 'green'),
('D9', 'green'),
('D10', 'green'),
('E1', 'green'),
('E2', 'green'),
('E3', 'green'),
('E4', 'green'),
('E5', 'green'),
('E6', 'green'),
('E7', 'green'),
('E8', 'green'),
('E9', 'green'),
('E10', 'green'),
('F1', 'green'),
('F2', 'green'),
('F3', 'green'),
('F4', 'green'),
('F5', 'green'),
('F6', 'green'),
('F7', 'green'),
('F8', 'green'),
('F9', 'green'),
('F10', 'green'),
('G1', 'green'),
('G2', 'green'),
('G3', 'green'),
('G4', 'green'),
('G5', 'green'),
('G6', 'green'),
('G7', 'green'),
('G8', 'green'),
('G9', 'green'),
('G10', 'green'),
('H1', 'green'),
('H2', 'green'),
('H3', 'green'),
('H4', 'green'),
('H5', 'green'),
('H6', 'green'),
('H7', 'green'),
('H8', 'green'),
('H9', 'green'),
('H10', 'green'),
('I1', 'green'),
('I2', 'green'),
('I3', 'green'),
('I4', 'green'),
('I5', 'green'),
('I6', 'green'),
('I7', 'green'),
('I8', 'green'),
('I9', 'green'),
('I10', 'green'),
('J1', 'green'),
('J2', 'green'),
('J3', 'green'),
('J4', 'green'),
('J5', 'green'),
('J6', 'green'),
('J7', 'green'),
('J8', 'green'),
('J9', 'green'),
('J10', 'green');

-- --------------------------------------------------------

--
-- Table structure for table `ticket1`
--

CREATE TABLE IF NOT EXISTS `ticket1` (
  `Number` varchar(25) NOT NULL,
  `Ticket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket1`
--

INSERT INTO `ticket1` (`Number`, `Ticket`) VALUES
('A1', 'green'),
('A2', 'green'),
('A3', 'green'),
('A4', 'green'),
('A5', 'green'),
('A6', 'green'),
('A7', 'green'),
('A8', 'green'),
('A9', 'green'),
('A10', 'green'),
('B1', 'green'),
('B2', 'green'),
('B1', 'green'),
('B2', 'green'),
('B3', 'green'),
('B4', 'green'),
('B5', 'green'),
('B6', 'green'),
('B7', 'green'),
('B8', 'green'),
('B9', 'green'),
('B10', 'green'),
('C1', 'green'),
('C2', 'green'),
('C3', 'green'),
('C4', 'green'),
('C5', 'green'),
('C6', 'green'),
('C7', 'green'),
('C8', 'green'),
('C9', 'green'),
('C10', 'green'),
('D1', 'green'),
('D2', 'green'),
('D3', 'green'),
('D4', 'green'),
('D5', 'green'),
('D6', 'green'),
('D7', 'green'),
('D8', 'green'),
('D9', 'green'),
('D10', 'green'),
('E1', 'green'),
('E2', 'green'),
('E3', 'green'),
('E4', 'green'),
('E5', 'green'),
('E6', 'green'),
('E7', 'green'),
('E8', 'green'),
('E9', 'green'),
('E10', 'green'),
('F1', 'green'),
('F2', 'green'),
('F3', 'green'),
('F4', 'green'),
('F5', 'green'),
('F6', 'green'),
('F7', 'green'),
('F8', 'green'),
('F9', 'green'),
('F10', 'green'),
('G1', 'green'),
('G2', 'green'),
('G3', 'green'),
('G4', 'green'),
('G5', 'green'),
('G6', 'green'),
('G7', 'green'),
('G8', 'green'),
('G9', 'green'),
('G10', 'green'),
('H1', 'green'),
('H2', 'green'),
('H3', 'green'),
('H4', 'green'),
('H5', 'green'),
('H6', 'green'),
('H7', 'green'),
('H8', 'green'),
('H9', 'green'),
('H10', 'green'),
('I1', 'green'),
('I2', 'green'),
('I3', 'green'),
('I4', 'green'),
('I5', 'green'),
('I6', 'green'),
('I7', 'green'),
('I8', 'green'),
('I9', 'green'),
('I10', 'green'),
('J1', 'green'),
('J2', 'green'),
('J3', 'green'),
('J4', 'green'),
('J5', 'green'),
('J6', 'green'),
('J7', 'green'),
('J8', 'green'),
('J9', 'green'),
('J10', 'green');

-- --------------------------------------------------------

--
-- Table structure for table `ticket2`
--

CREATE TABLE IF NOT EXISTS `ticket2` (
  `Number` varchar(25) NOT NULL,
  `Ticket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket2`
--

INSERT INTO `ticket2` (`Number`, `Ticket`) VALUES
('A1', 'green'),
('A2', 'green'),
('A3', 'green'),
('A4', 'green'),
('A5', 'green'),
('A5', 'green'),
('A6', 'green'),
('A7', 'green'),
('A8', 'green'),
('A9', 'green'),
('A10', 'green'),
('B1', 'green'),
('B2', 'green'),
('B3', 'green'),
('B4', 'green'),
('B5', 'green'),
('B6', 'green'),
('B7', 'green'),
('B8', 'green'),
('B9', 'green'),
('B10', 'green'),
('C1', 'green'),
('C2', 'green'),
('C3', 'green'),
('C4', 'green'),
('C5', 'green'),
('C6', 'green'),
('C7', 'green'),
('C8', 'green'),
('C9', 'green'),
('C10', 'green'),
('D1', 'green'),
('D2', 'green'),
('D3', 'green'),
('D4', 'green'),
('D5', 'green'),
('D6', 'green'),
('D7', 'green'),
('D8', 'green'),
('D9', 'green'),
('D10', 'green'),
('E1', 'green'),
('E2', 'green'),
('E3', 'green'),
('E4', 'green'),
('E5', 'green'),
('E6', 'green'),
('E7', 'green'),
('E8', 'green'),
('E9', 'green'),
('E10', 'green'),
('F1', 'green'),
('F2', 'green'),
('F3', 'green'),
('F4', 'green'),
('F5', 'green'),
('F6', 'green'),
('F7', 'green'),
('F8', 'green'),
('F9', 'green'),
('F10', 'green'),
('G1', 'green'),
('G2', 'green'),
('G3', 'green'),
('G4', 'green'),
('G5', 'green'),
('G6', 'green'),
('G7', 'green'),
('G8', 'green'),
('G9', 'green'),
('G10', 'green'),
('H1', 'green'),
('H2', 'green'),
('H3', 'green'),
('H4', 'green'),
('H5', 'green'),
('H6', 'green'),
('H7', 'green'),
('H8', 'green'),
('H9', 'green'),
('H10', 'green'),
('I1', 'green'),
('I2', 'green'),
('I3', 'green'),
('I4', 'green'),
('I5', 'green'),
('I6', 'green'),
('I7', 'green'),
('I8', 'green'),
('I9', 'green'),
('I10', 'green'),
('J1', 'green'),
('J2', 'green'),
('J3', 'green'),
('J4', 'green'),
('J5', 'green'),
('J6', 'green'),
('J7', 'green'),
('J8', 'green'),
('J9', 'green'),
('J10', 'green');

-- --------------------------------------------------------

--
-- Table structure for table `ticket3`
--

CREATE TABLE IF NOT EXISTS `ticket3` (
  `Number` varchar(25) NOT NULL,
  `Ticket` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket3`
--

INSERT INTO `ticket3` (`Number`, `Ticket`) VALUES
('A1', 'green'),
('A2', 'green'),
('A3', 'green'),
('A4', 'green'),
('A4', 'green'),
('A5', 'green'),
('A6', 'green'),
('A7', 'green'),
('A8', 'green'),
('A9', 'green'),
('A10', 'green'),
('B1', 'green'),
('B2', 'green'),
('B3', 'green'),
('B4', 'green'),
('B5', 'green'),
('B6', 'green'),
('B7', 'green'),
('B8', 'green'),
('B9', 'green'),
('B10', 'green'),
('C1', 'green'),
('C2', 'green'),
('C3', 'green'),
('C4', 'green'),
('C5', 'green'),
('C6', 'green'),
('C7', 'green'),
('C8', 'green'),
('C9', 'green'),
('C10', 'green'),
('D1', 'green'),
('D2', 'green'),
('D3', 'green'),
('D4', 'green'),
('D5', 'green'),
('D6', 'green'),
('D7', 'green'),
('D8', 'green'),
('D9', 'green'),
('D10', 'green'),
('E1', 'green'),
('E2', 'green'),
('E3', 'green'),
('E4', 'green'),
('E5', 'green'),
('E6', 'green'),
('E7', 'green'),
('E8', 'green'),
('E9', 'green'),
('E10', 'green'),
('F1', 'green'),
('F2', 'green'),
('F3', 'green'),
('F4', 'green'),
('F5', 'green'),
('F6', 'green'),
('F7', 'green'),
('F8', 'green'),
('F9', 'green'),
('F10', 'green'),
('G1', 'green'),
('G2', 'green'),
('G3', 'green'),
('G4', 'green'),
('G5', 'green'),
('G6', 'green'),
('G7', 'green'),
('G8', 'green'),
('G9', 'green'),
('G10', 'green'),
('H1', 'green'),
('H2', 'green'),
('H3', 'green'),
('H4', 'green'),
('H5', 'green'),
('H6', 'green'),
('H7', 'green'),
('H8', 'green'),
('H9', 'green'),
('H10', 'green'),
('I1', 'green'),
('I2', 'green'),
('I3', 'green'),
('I4', 'green'),
('I5', 'green'),
('I6', 'green'),
('I7', 'green'),
('I8', 'green'),
('I9', 'green'),
('I10', 'green'),
('J1', 'green'),
('J2', 'green'),
('J3', 'green'),
('J4', 'green'),
('J5', 'green'),
('J6', 'green'),
('J7', 'green'),
('J8', 'green'),
('J9', 'green'),
('J10', 'green');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`Cus_ID`);

--
-- Indexes for table `details`
--
ALTER TABLE `details`
 ADD PRIMARY KEY (`Mov_Name`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
 ADD PRIMARY KEY (`Emp_ID`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
 ADD PRIMARY KEY (`Mov_Name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
