/*
Navicat MySQL Data Transfer

Source Server         : blah
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : 341

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2013-11-29 23:27:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for animals
-- ----------------------------
DROP TABLE IF EXISTS `animals`;
CREATE TABLE `animals` (
  `species` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `DOB` date NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `date_acquired` datetime NOT NULL,
  PRIMARY KEY (`species`,`name`),
  KEY `species` (`species`) USING HASH,
  KEY `name` (`name`) USING HASH,
  KEY `DOB` (`DOB`) USING BTREE,
  KEY `acquired` (`date_acquired`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animals
-- ----------------------------

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ssn` int(9) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `address` varchar(40) NOT NULL,
  `salary` double(20,0) NOT NULL,
  `DOB` date NOT NULL,
  `startDate` date NOT NULL,
  `sickDaysTaken` int(2) NOT NULL,
  `vacationDaysLeft` int(2) NOT NULL,
  PRIMARY KEY (`ssn`),
  KEY `ssn` (`ssn`) USING HASH,
  KEY `salary` (`salary`) USING BTREE,
  KEY `name` (`firstname`,`lastname`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('111111111', 'Bob', 'Goodman', '123 Zoo Road', '43000', '1967-03-04', '1999-12-11', '0', '5');
INSERT INTO `employees` VALUES ('123456789', 'James', 'Monroe', '123 East Street', '13000', '1945-11-11', '2013-11-11', '3', '28');

-- ----------------------------
-- Table structure for habitatmanagers
-- ----------------------------
DROP TABLE IF EXISTS `habitatmanagers`;
CREATE TABLE `habitatmanagers` (
  `habitatName` varchar(25) NOT NULL,
  `ssn` int(9) NOT NULL,
  `since` date NOT NULL,
  PRIMARY KEY (`habitatName`,`ssn`),
  KEY `habitatManagerSSN` (`ssn`),
  CONSTRAINT `habitatManagerHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `habitatManagerSSN` FOREIGN KEY (`ssn`) REFERENCES `employees` (`ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of habitatmanagers
-- ----------------------------

-- ----------------------------
-- Table structure for habitats
-- ----------------------------
DROP TABLE IF EXISTS `habitats`;
CREATE TABLE `habitats` (
  `name` varchar(25) NOT NULL,
  `memberCost` double(25,0) NOT NULL,
  `nonmemberCost` double(25,0) NOT NULL,
  `membershipFee` double(25,0) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of habitats
-- ----------------------------
INSERT INTO `habitats` VALUES ('Mammal', '15', '30', '5');
INSERT INTO `habitats` VALUES ('Reptile', '30', '45', '10');

-- ----------------------------
-- Table structure for livesin
-- ----------------------------
DROP TABLE IF EXISTS `livesin`;
CREATE TABLE `livesin` (
  `species` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `penID` int(25) NOT NULL,
  PRIMARY KEY (`species`,`name`),
  KEY `name` (`name`) USING HASH,
  KEY `penID` (`penID`) USING HASH,
  CONSTRAINT `name` FOREIGN KEY (`name`) REFERENCES `animals` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `penID` FOREIGN KEY (`penID`) REFERENCES `pens` (`penID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `species` FOREIGN KEY (`species`) REFERENCES `animals` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of livesin
-- ----------------------------

-- ----------------------------
-- Table structure for locations
-- ----------------------------
DROP TABLE IF EXISTS `locations`;
CREATE TABLE `locations` (
  `locationName` varchar(25) NOT NULL,
  `mapCoordinates` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`locationName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of locations
-- ----------------------------
INSERT INTO `locations` VALUES ('Crocs', 'R1');
INSERT INTO `locations` VALUES ('Turtles', 'R2');
INSERT INTO `locations` VALUES ('Whales', 'M1');

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `memberID` int(25) NOT NULL,
  `habitatName` varchar(25) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `address` varchar(40) NOT NULL,
  `DOB` date NOT NULL,
  `membershipStart` date NOT NULL,
  `membershipExpiration` date NOT NULL,
  `timesVisited` int(10) NOT NULL,
  PRIMARY KEY (`memberID`,`habitatName`),
  KEY `memberHabitat` (`habitatName`),
  KEY `memberID` (`memberID`),
  KEY `membershipStart` (`membershipStart`) USING BTREE,
  KEY `membershipExpiration` (`membershipExpiration`) USING BTREE,
  KEY `name` (`firstName`,`lastName`) USING HASH,
  CONSTRAINT `memberHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('1', 'Reptile', 'Michael', 'Harkins', 'here', '2013-05-14', '2013-11-04', '2013-11-16', '1');
INSERT INTO `members` VALUES ('2', 'Mammal', 'Michael', 'Harkins', 'here', '2013-11-27', '2013-10-29', '2013-11-29', '1');

-- ----------------------------
-- Table structure for membervisits
-- ----------------------------
DROP TABLE IF EXISTS `membervisits`;
CREATE TABLE `membervisits` (
  `memberID` int(15) NOT NULL,
  `habitatName` varchar(25) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`memberID`,`habitatName`,`date`),
  KEY `membersHabitat` (`habitatName`),
  CONSTRAINT `memberIVisitD` FOREIGN KEY (`memberID`) REFERENCES `members` (`memberID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `membersHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membervisits
-- ----------------------------
INSERT INTO `membervisits` VALUES ('2', 'Mammal', '2013-11-29');
INSERT INTO `membervisits` VALUES ('1', 'Reptile', '2013-11-29');

-- ----------------------------
-- Table structure for nonmembervisits
-- ----------------------------
DROP TABLE IF EXISTS `nonmembervisits`;
CREATE TABLE `nonmembervisits` (
  `visitorID` int(15) NOT NULL,
  `habitatName` varchar(25) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`visitorID`,`habitatName`,`date`),
  KEY `nonMemberHabitat` (`habitatName`),
  CONSTRAINT `nonMemberHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nonmembervisits
-- ----------------------------
INSERT INTO `nonmembervisits` VALUES ('1', 'Reptile', '2013-11-29');

-- ----------------------------
-- Table structure for penkeepers
-- ----------------------------
DROP TABLE IF EXISTS `penkeepers`;
CREATE TABLE `penkeepers` (
  `penID` int(25) NOT NULL,
  `ssn` int(9) NOT NULL,
  `since` date NOT NULL,
  PRIMARY KEY (`penID`,`ssn`),
  KEY `penkeeperSSN` (`ssn`),
  CONSTRAINT `penkeeperPenID` FOREIGN KEY (`penID`) REFERENCES `pens` (`penID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `penkeeperSSN` FOREIGN KEY (`ssn`) REFERENCES `employees` (`ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of penkeepers
-- ----------------------------
INSERT INTO `penkeepers` VALUES ('1', '123456789', '2013-11-26');
INSERT INTO `penkeepers` VALUES ('2', '123456789', '2013-11-26');

-- ----------------------------
-- Table structure for pens
-- ----------------------------
DROP TABLE IF EXISTS `pens`;
CREATE TABLE `pens` (
  `penID` int(25) NOT NULL,
  `locationName` varchar(25) NOT NULL,
  `habitatName` varchar(25) NOT NULL,
  `climate` varchar(25) NOT NULL,
  `food` varchar(25) NOT NULL,
  `mealsPerDay` int(3) NOT NULL,
  `lastClean` date NOT NULL,
  PRIMARY KEY (`penID`),
  KEY `penID` (`penID`) USING HASH,
  KEY `location` (`locationName`),
  KEY `habitat` (`habitatName`),
  CONSTRAINT `habitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `location` FOREIGN KEY (`locationName`) REFERENCES `locations` (`locationName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pens
-- ----------------------------
INSERT INTO `pens` VALUES ('1', 'Crocs', 'Reptile', 'Rainy', 'Mice', '4', '2013-11-04');
INSERT INTO `pens` VALUES ('2', 'Turtles', 'Reptile', 'Cold', 'Plants', '12', '2013-11-13');
INSERT INTO `pens` VALUES ('3', 'Whales', 'Mammal', 'Water', 'Small Stuff', '20', '2013-11-15');

-- ----------------------------
-- Table structure for timesvisited
-- ----------------------------
DROP TABLE IF EXISTS `timesvisited`;
CREATE TABLE `timesvisited` (
  `habitatName` varchar(25) NOT NULL,
  `date` date NOT NULL,
  `nonmemberVisits` int(15) NOT NULL,
  `memberVisits` int(15) NOT NULL,
  PRIMARY KEY (`habitatName`,`date`),
  CONSTRAINT `timesVisitedHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timesvisited
-- ----------------------------
INSERT INTO `timesvisited` VALUES ('Mammal', '2013-11-29', '0', '1');
INSERT INTO `timesvisited` VALUES ('Reptile', '2013-11-29', '0', '1');
DROP TRIGGER IF EXISTS `incrementMemberVisits`;
DELIMITER ;;
CREATE TRIGGER `incrementMemberVisits` BEFORE INSERT ON `membervisits` FOR EACH ROW UPDATE Members
SET timesVisited = timesVisited + 1
WHERE memberID = NEW.memberID
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `IncrementTimesVisitedMember`;
DELIMITER ;;
CREATE TRIGGER `IncrementTimesVisitedMember` AFTER INSERT ON `membervisits` FOR EACH ROW INSERT INTO TimesVisited (habitatName,date,nonmemberVisits,memberVisits) VALUES (NEW.habitatName,NEW.date,0,1)
ON DUPLICATE KEY
UPDATE memberVisits = memberVisits + 1
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `incrementTimesVisited`;
DELIMITER ;;
CREATE TRIGGER `incrementTimesVisited` AFTER INSERT ON `nonmembervisits` FOR EACH ROW INSERT INTO TimesVisited (habitatName,date,nonmemberVisits,memberVisits) VALUES (NEW.habitatName,NEW.date,1,0)
ON DUPLICATE KEY
UPDATE nonmemberVisits = nonmemberVisits + 1
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `pensOneHabitat`;
DELIMITER ;;
CREATE TRIGGER `pensOneHabitat` AFTER INSERT ON `penkeepers` FOR EACH ROW begin
declare test int;
set test = (select COUNT( DISTINCT habitatname) from penkeepers LEFT JOIN pens on (penkeepers.penid = pens.penid) where new.ssn = penkeepers.ssn);
if(test > 1) then
signal sqlstate '02134' set message_text = 'cannot have pens for same penkeeper in different habitats';
end if;
END
;;
DELIMITER ;
