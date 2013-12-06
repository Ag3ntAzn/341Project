/*
Navicat MySQL Data Transfer

Source Server         : 341
Source Server Version : 50534
Source Host           : 54.201.38.30:3306
Source Database       : databaseproject

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2013-12-06 12:57:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `memberid` int(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`memberid`),
  KEY `usernameIndex` (`username`) USING HASH,
  CONSTRAINT `Integer` FOREIGN KEY (`memberid`) REFERENCES `members` (`memberID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('1', 'Hello', 'World');
INSERT INTO `accounts` VALUES ('2', 'password', 'username');
INSERT INTO `accounts` VALUES ('3', 'james', 'james');
INSERT INTO `accounts` VALUES ('4', 'asdf', 'asdf');

-- ----------------------------
-- Table structure for animals
-- ----------------------------
DROP TABLE IF EXISTS `animals`;
CREATE TABLE `animals` (
  `species` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `DOB` date NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `date_acquired` date NOT NULL,
  PRIMARY KEY (`species`,`name`),
  KEY `species` (`species`) USING HASH,
  KEY `name` (`name`) USING HASH,
  KEY `DOB` (`DOB`) USING BTREE,
  KEY `acquired` (`date_acquired`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animals
-- ----------------------------
INSERT INTO `animals` VALUES ('Bat', 'Betty', '2010-05-13', 'Female', '2013-04-25');
INSERT INTO `animals` VALUES ('Bat', 'Mike', '2010-04-12', 'Male', '2013-04-25');
INSERT INTO `animals` VALUES ('Bear', 'Alfred', '2000-03-03', 'Male', '2013-04-13');
INSERT INTO `animals` VALUES ('Bear', 'Jess', '2004-03-12', 'Female', '2013-03-12');
INSERT INTO `animals` VALUES ('Butterfly', 'Daniel', '2007-02-17', 'Male', '2008-01-01');
INSERT INTO `animals` VALUES ('Butterfly', 'Mia', '2008-12-04', 'Female', '2008-12-05');
INSERT INTO `animals` VALUES ('Crab', 'Ava', '2008-02-18', 'Female', '2009-02-04');
INSERT INTO `animals` VALUES ('Crab', 'Crabby', '2009-04-08', 'Male', '2009-05-12');
INSERT INTO `animals` VALUES ('Crocodile', 'Crocy', '1999-02-03', 'Male', '2013-02-09');
INSERT INTO `animals` VALUES ('Crocodile', 'Holly', '1999-03-04', 'Female', '2013-02-09');
INSERT INTO `animals` VALUES ('Duck', 'Grace', '2012-04-08', 'Female', '2013-08-06');
INSERT INTO `animals` VALUES ('Duck', 'Quacky', '2012-04-15', 'Male', '2013-09-22');
INSERT INTO `animals` VALUES ('Eel', 'Charlie', '2001-09-13', 'Male', '2010-11-19');
INSERT INTO `animals` VALUES ('Eel', 'Sophie', '2001-03-12', 'Female', '2010-11-19');
INSERT INTO `animals` VALUES ('Elephant', 'James', '2000-01-01', 'Male', '2013-05-12');
INSERT INTO `animals` VALUES ('Elephant', 'Lauren', '2000-02-02', 'Female', '2013-05-12');
INSERT INTO `animals` VALUES ('Frog', 'Harry', '2011-04-15', 'Male', '2013-07-10');
INSERT INTO `animals` VALUES ('Frog', 'Lily', '2011-08-21', 'Female', '2012-09-18');
INSERT INTO `animals` VALUES ('Hawk', 'Evie', '2010-03-01', 'Female', '2013-09-02');
INSERT INTO `animals` VALUES ('Hawk', 'Thomas', '2009-03-02', 'Male', '2013-09-09');
INSERT INTO `animals` VALUES ('Lizard', 'Harry', '2008-11-02', 'Male', '2013-03-02');
INSERT INTO `animals` VALUES ('Lizard', 'Jess', '2010-02-04', 'Female', '2013-02-03');
INSERT INTO `animals` VALUES ('Owl', 'Amelia', '2008-03-12', 'Female', '2010-11-04');
INSERT INTO `animals` VALUES ('Owl', 'Joshua', '2005-02-13', 'Male', '2010-09-08');
INSERT INTO `animals` VALUES ('Salamander', 'Oliver', '2011-02-11', 'Male', '2012-06-10');
INSERT INTO `animals` VALUES ('Salamander', 'Ruby', '2011-02-12', 'Female', '2012-06-10');
INSERT INTO `animals` VALUES ('Scorpion', 'Ella', '2008-11-02', 'Female', '2010-02-04');
INSERT INTO `animals` VALUES ('Scorpion', 'James', '2003-12-05', 'Male', '2005-03-04');
INSERT INTO `animals` VALUES ('Turtle', 'Mia', '1895-02-01', 'Female', '2010-03-04');
INSERT INTO `animals` VALUES ('Turtle', 'Torty', '1940-01-02', 'Male', '2010-02-03');
INSERT INTO `animals` VALUES ('Whale', 'Jack', '1995-02-12', 'Male', '2010-02-15');
INSERT INTO `animals` VALUES ('Whale', 'Olivia', '1992-03-23', 'Female', '2010-01-13');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ssn` int(9) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `address` varchar(300) NOT NULL,
  `salary` double(20,0) NOT NULL,
  `DOB` date NOT NULL,
  `startDate` date NOT NULL,
  `sickDaysTaken` int(2) NOT NULL,
  `vacationDaysLeft` int(2) NOT NULL,
  `phonenumber` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`ssn`),
  KEY `ssn` (`ssn`) USING HASH,
  KEY `salary` (`salary`) USING BTREE,
  KEY `name` (`firstname`,`lastname`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('111111111', 'Bob', 'Freeman', '123 Zoo Road', '43000', '1967-03-04', '1999-12-11', '0', '5', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('123123123', 'Gordon', 'Freeman', '123 Z Street', '50000', '1945-11-22', '1999-09-02', '3', '2', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('123456789', 'James', 'Monroe', '123 East Street', '13000', '1945-11-11', '2013-11-11', '3', '28', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('222222222', 'Booker', 'DeWitt', '123 Cloud Ave', '100000', '1910-11-12', '2000-09-09', '4', '4', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('333333333', 'Zachary', 'Comstock', '444 Sky Lane', '200000', '1950-10-02', '1999-09-05', '5', '2', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('444444444', 'George', 'Harkins', '999 Cleveland Street', '1000000', '1992-11-30', '2013-04-04', '0', '100', '1234567891011', 'zoo@zoo.zoo');
INSERT INTO `employees` VALUES ('555555555', 'Jonathan', 'Wheelbarrow', '341 DB Street Skeet', '50000000', '1500-11-30', '1010-05-04', '999', '999', '1231231231232', 'making@gmail.com');
INSERT INTO `employees` VALUES ('666666666', 'Emily', 'Weedcracker', '420 Blazin Street', '100000000', '2013-12-10', '2013-12-18', '0', '0', '123456789', 'bluntroller@high4life.com');
INSERT INTO `employees` VALUES ('777777777', 'George', 'Dryington', '123 Washington Street', '1234', '2013-12-12', '2013-12-18', '3', '8', '6302134235', 'dry4life@washers.com');

-- ----------------------------
-- Table structure for habitatmanagers
-- ----------------------------
DROP TABLE IF EXISTS `habitatmanagers`;
CREATE TABLE `habitatmanagers` (
  `habitatName` varchar(25) NOT NULL,
  `ssn` int(9) NOT NULL,
  `since` date NOT NULL,
  PRIMARY KEY (`habitatName`),
  KEY `habitatManagerSSN` (`ssn`),
  CONSTRAINT `habitatManagerHabitat` FOREIGN KEY (`habitatName`) REFERENCES `habitats` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `habitatManagerSSN` FOREIGN KEY (`ssn`) REFERENCES `employees` (`ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of habitatmanagers
-- ----------------------------
INSERT INTO `habitatmanagers` VALUES ('Amphibians', '111111111', '2013-12-01');
INSERT INTO `habitatmanagers` VALUES ('Arthropod', '444444444', '2013-12-05');
INSERT INTO `habitatmanagers` VALUES ('Bird', '123123123', '2013-12-05');
INSERT INTO `habitatmanagers` VALUES ('Mammal', '222222222', '2013-12-01');
INSERT INTO `habitatmanagers` VALUES ('Reptile', '333333333', '2013-12-01');

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
INSERT INTO `habitats` VALUES ('Amphibians', '25', '35', '10');
INSERT INTO `habitats` VALUES ('Arthropod', '15', '35', '5');
INSERT INTO `habitats` VALUES ('Bird', '40', '90', '10');
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
  CONSTRAINT `species` FOREIGN KEY (`species`) REFERENCES `animals` (`species`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of livesin
-- ----------------------------
INSERT INTO `livesin` VALUES ('Crocodile', 'Crocy', '1');
INSERT INTO `livesin` VALUES ('Crocodile', 'Holly', '1');
INSERT INTO `livesin` VALUES ('Turtle', 'Mia', '2');
INSERT INTO `livesin` VALUES ('Turtle', 'Torty', '2');
INSERT INTO `livesin` VALUES ('Whale', 'Jack', '3');
INSERT INTO `livesin` VALUES ('Whale', 'Olivia', '3');
INSERT INTO `livesin` VALUES ('Elephant', 'James', '4');
INSERT INTO `livesin` VALUES ('Elephant', 'Lauren', '4');
INSERT INTO `livesin` VALUES ('Bear', 'Alfred', '5');
INSERT INTO `livesin` VALUES ('Bear', 'Jess', '5');
INSERT INTO `livesin` VALUES ('Bat', 'Betty', '6');
INSERT INTO `livesin` VALUES ('Bat', 'Mike', '6');
INSERT INTO `livesin` VALUES ('Salamander', 'Oliver', '7');
INSERT INTO `livesin` VALUES ('Salamander', 'Ruby', '7');
INSERT INTO `livesin` VALUES ('Frog', 'Harry', '8');
INSERT INTO `livesin` VALUES ('Frog', 'Lily', '8');
INSERT INTO `livesin` VALUES ('Eel', 'Charlie', '9');
INSERT INTO `livesin` VALUES ('Eel', 'Sophie', '9');
INSERT INTO `livesin` VALUES ('Duck', 'Grace', '10');
INSERT INTO `livesin` VALUES ('Duck', 'Quacky', '10');
INSERT INTO `livesin` VALUES ('Hawk', 'Evie', '11');
INSERT INTO `livesin` VALUES ('Hawk', 'Thomas', '11');
INSERT INTO `livesin` VALUES ('Owl', 'Amelia', '12');
INSERT INTO `livesin` VALUES ('Owl', 'Joshua', '12');
INSERT INTO `livesin` VALUES ('Butterfly', 'Daniel', '13');
INSERT INTO `livesin` VALUES ('Butterfly', 'Mia', '13');
INSERT INTO `livesin` VALUES ('Scorpion', 'Ella', '14');
INSERT INTO `livesin` VALUES ('Scorpion', 'James', '14');
INSERT INTO `livesin` VALUES ('Crab', 'Ava', '15');
INSERT INTO `livesin` VALUES ('Crab', 'Crabby', '15');
INSERT INTO `livesin` VALUES ('Lizard', 'Harry', '16');
INSERT INTO `livesin` VALUES ('Lizard', 'Jess', '16');

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
INSERT INTO `locations` VALUES ('Bat', 'M4');
INSERT INTO `locations` VALUES ('Bear', 'M3');
INSERT INTO `locations` VALUES ('Butterfly', 'AR1');
INSERT INTO `locations` VALUES ('Crab', 'AR3');
INSERT INTO `locations` VALUES ('Crocs', 'R1');
INSERT INTO `locations` VALUES ('Duck', 'B1');
INSERT INTO `locations` VALUES ('Eel', 'AM3');
INSERT INTO `locations` VALUES ('Elephants', 'M2');
INSERT INTO `locations` VALUES ('Frog', 'AM2');
INSERT INTO `locations` VALUES ('Hawk', 'B2');
INSERT INTO `locations` VALUES ('Lizard', 'R3');
INSERT INTO `locations` VALUES ('Owl', 'B3');
INSERT INTO `locations` VALUES ('Salamander', 'AM1');
INSERT INTO `locations` VALUES ('Scorpion', 'AR2');
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
  `address` varchar(300) NOT NULL,
  `DOB` date NOT NULL,
  `membershipStart` date NOT NULL,
  `membershipExpiration` date NOT NULL,
  `timesVisited` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phonenumber` varchar(30) NOT NULL,
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
INSERT INTO `members` VALUES ('1', 'Reptile', 'Michael', 'Harkins', 'here', '2013-05-14', '2013-11-04', '2013-11-16', '1', 'igotmoney@money.money', 'DATCASH');
INSERT INTO `members` VALUES ('2', 'Mammal', 'Michael', 'Harkins', 'here', '2013-11-27', '2013-10-29', '2013-11-29', '2', 'igotmoney@money.money', 'GAMBLERS');
INSERT INTO `members` VALUES ('3', 'Arthropod', 'James', 'James', '123  c KS 11111', '1991-11-30', '2013-12-06', '2014-12-06', '0', 'mj@mj.com', '(630) 215-2222');
INSERT INTO `members` VALUES ('4', 'Amphibians', 'asdf', 'asdf', 'asdf asdf asdf AL 12345', '2222-02-02', '2013-12-06', '2014-12-06', '0', 'asdf@asdf.com', '(234) 234-1234');

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
INSERT INTO `membervisits` VALUES ('2', 'Mammal', '2013-12-05');
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
INSERT INTO `nonmembervisits` VALUES ('2', 'Mammal', '2013-12-05');
INSERT INTO `nonmembervisits` VALUES ('1', 'Reptile', '2013-11-29');

-- ----------------------------
-- Table structure for penkeepers
-- ----------------------------
DROP TABLE IF EXISTS `penkeepers`;
CREATE TABLE `penkeepers` (
  `penID` int(25) NOT NULL,
  `ssn` int(9) NOT NULL,
  `since` date NOT NULL,
  PRIMARY KEY (`penID`),
  KEY `penkeeperSSN` (`ssn`),
  CONSTRAINT `penkeeperPenID` FOREIGN KEY (`penID`) REFERENCES `pens` (`penID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `penkeeperSSN` FOREIGN KEY (`ssn`) REFERENCES `employees` (`ssn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of penkeepers
-- ----------------------------
INSERT INTO `penkeepers` VALUES ('1', '123456789', '2013-11-26');
INSERT INTO `penkeepers` VALUES ('2', '123456789', '2013-11-26');
INSERT INTO `penkeepers` VALUES ('3', '666666666', '2011-01-01');
INSERT INTO `penkeepers` VALUES ('4', '555555555', '2011-01-01');
INSERT INTO `penkeepers` VALUES ('5', '444444444', '2011-01-01');
INSERT INTO `penkeepers` VALUES ('6', '111111111', '2011-01-01');
INSERT INTO `penkeepers` VALUES ('7', '123123123', '2011-11-11');
INSERT INTO `penkeepers` VALUES ('8', '123123123', '2011-11-11');
INSERT INTO `penkeepers` VALUES ('9', '123123123', '2013-03-03');
INSERT INTO `penkeepers` VALUES ('10', '222222222', '2012-12-12');
INSERT INTO `penkeepers` VALUES ('11', '222222222', '2012-12-12');
INSERT INTO `penkeepers` VALUES ('12', '222222222', '2012-12-12');
INSERT INTO `penkeepers` VALUES ('13', '333333333', '2012-10-10');
INSERT INTO `penkeepers` VALUES ('14', '333333333', '2012-10-10');
INSERT INTO `penkeepers` VALUES ('15', '333333333', '2012-10-10');
INSERT INTO `penkeepers` VALUES ('16', '123456789', '2013-11-26');

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
INSERT INTO `pens` VALUES ('3', 'Whales', 'Mammal', 'Water', 'Plankton', '20', '2013-11-15');
INSERT INTO `pens` VALUES ('4', 'Elephants', 'Mammal', 'Grassy', 'Food', '9', '2013-11-11');
INSERT INTO `pens` VALUES ('5', 'Bear', 'Mammal', 'Grass', 'Food', '5', '2013-11-11');
INSERT INTO `pens` VALUES ('6', 'Bat', 'Mammal', 'Wet', 'Food', '9', '2013-11-11');
INSERT INTO `pens` VALUES ('7', 'Salamander', 'Amphibians', 'Wet', 'Food', '5', '2013-11-11');
INSERT INTO `pens` VALUES ('8', 'Frog', 'Amphibians', 'Wet', 'Food', '8', '2013-11-11');
INSERT INTO `pens` VALUES ('9', 'Eel', 'Amphibians', 'Wet', 'Food', '9', '2013-11-11');
INSERT INTO `pens` VALUES ('10', 'Duck', 'Bird', 'Warm', 'Food', '10', '2013-11-11');
INSERT INTO `pens` VALUES ('11', 'Hawk', 'Bird', 'Warm', 'Food', '18', '2013-11-11');
INSERT INTO `pens` VALUES ('12', 'Owl', 'Bird', 'Warm', 'Food', '10', '2013-11-11');
INSERT INTO `pens` VALUES ('13', 'Butterfly', 'Arthropod', 'Warm', 'Worm', '15', '2013-11-11');
INSERT INTO `pens` VALUES ('14', 'Scorpion', 'Arthropod', 'Warm', 'Insects', '8', '2013-11-11');
INSERT INTO `pens` VALUES ('15', 'Crab', 'Arthropod', 'Warm', 'Seaweed', '9', '2013-11-11');
INSERT INTO `pens` VALUES ('16', 'Lizard', 'Reptile', 'Wet', 'Insects', '9', '2013-11-11');

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
INSERT INTO `timesvisited` VALUES ('Mammal', '2013-12-05', '1', '1');
INSERT INTO `timesvisited` VALUES ('Reptile', '2013-11-29', '0', '1');
DROP TRIGGER IF EXISTS `oneHabitat`;
DELIMITER ;;
CREATE TRIGGER `oneHabitat` AFTER INSERT ON `habitatmanagers` FOR EACH ROW begin
declare test int;
set test = (select COUNT( ssn) from  habitatmanagers where ssn=new.ssn);
if(test > 1) then
signal sqlstate '02134' set message_text = 'Manager can only manage one habitat';
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `oneHabitatUpdate`;
DELIMITER ;;
CREATE TRIGGER `oneHabitatUpdate` AFTER UPDATE ON `habitatmanagers` FOR EACH ROW begin
declare test int;
set test = (select COUNT( ssn) from  habitatmanagers where ssn=new.ssn);
if(test > 1) then
signal sqlstate '02134' set message_text = 'Manager can only manage one habitat';
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `animalName`;
DELIMITER ;;
CREATE TRIGGER `animalName` AFTER INSERT ON `livesin` FOR EACH ROW begin
declare test int;
set test = (select COUNT( DISTINCT name) from animals where species = new.species and name = new.name);
if(test < 1) then
signal sqlstate '02134' set message_text = 'Name must but from the species the animal is apart of ';
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `animalNameUpdate`;
DELIMITER ;;
CREATE TRIGGER `animalNameUpdate` AFTER UPDATE ON `livesin` FOR EACH ROW begin
declare test int;
set test = (select COUNT( DISTINCT name) from animals where species = new.species and name = new.name);
if(test < 1) then
signal sqlstate '02134' set message_text = 'Name must but from the species the animal is apart of ';
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `incrementMemberVisits`;
DELIMITER ;;
CREATE TRIGGER `incrementMemberVisits` BEFORE INSERT ON `membervisits` FOR EACH ROW UPDATE Members
SET timesVisited = timesVisited + 1
WHERE memberID = NEW.memberID
;
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `IncrementTimesVisitedMember`;
DELIMITER ;;
CREATE TRIGGER `IncrementTimesVisitedMember` AFTER INSERT ON `membervisits` FOR EACH ROW INSERT INTO TimesVisited (habitatName,date,nonmemberVisits,memberVisits) VALUES (NEW.habitatName,NEW.date,0,1)
ON DUPLICATE KEY
UPDATE memberVisits = memberVisits + 1
;
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `incrementTimesVisited`;
DELIMITER ;;
CREATE TRIGGER `incrementTimesVisited` AFTER INSERT ON `nonmembervisits` FOR EACH ROW INSERT INTO TimesVisited (habitatName,date,nonmemberVisits,memberVisits) VALUES (NEW.habitatName,NEW.date,1,0)
ON DUPLICATE KEY
UPDATE nonmemberVisits = nonmemberVisits + 1
;
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
DROP TRIGGER IF EXISTS `pensOneHabitatUpdate`;
DELIMITER ;;
CREATE TRIGGER `pensOneHabitatUpdate` AFTER UPDATE ON `penkeepers` FOR EACH ROW begin
declare test int;
set test = (select COUNT( DISTINCT habitatname) from penkeepers LEFT JOIN pens on (penkeepers.penid = pens.penid) where new.ssn = penkeepers.ssn);
if(test > 1) then
signal sqlstate '02134' set message_text = 'cannot have pens for same penkeeper in different habitats';
end if;
END
;;
DELIMITER ;
