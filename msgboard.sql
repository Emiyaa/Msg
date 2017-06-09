/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : msgboard

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2017-06-09 17:55:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `messages`
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `msgId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `msgTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `msgContent` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`msgId`),
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('1', '2016-11-09 19:02:39', '测试', '1');
INSERT INTO `messages` VALUES ('18', '2016-11-09 19:03:05', '测试', '1');
INSERT INTO `messages` VALUES ('19', '2016-11-09 19:03:12', '测试', '1');
INSERT INTO `messages` VALUES ('20', '2016-11-09 19:03:21', '测试', '1');
INSERT INTO `messages` VALUES ('21', '2016-11-09 19:03:23', '测试', '1');
INSERT INTO `messages` VALUES ('22', '2016-11-09 19:03:26', '测试', '1');
INSERT INTO `messages` VALUES ('23', '2016-11-09 19:03:29', '测试', '1');
INSERT INTO `messages` VALUES ('24', '2016-11-09 19:03:32', '测试', '1');
INSERT INTO `messages` VALUES ('25', '2016-11-09 19:03:34', '测试', '1');
INSERT INTO `messages` VALUES ('26', '2016-11-09 19:03:35', '测试', '1');
INSERT INTO `messages` VALUES ('27', '2016-11-09 19:03:36', '测试', '1');
INSERT INTO `messages` VALUES ('28', '2016-11-09 19:03:36', '测试', '1');
INSERT INTO `messages` VALUES ('29', '2016-11-09 19:03:37', '测试', '1');
INSERT INTO `messages` VALUES ('30', '2016-11-09 19:03:38', '测试', '1');
INSERT INTO `messages` VALUES ('31', '2016-11-09 19:03:38', '测试', '1');
INSERT INTO `messages` VALUES ('32', '2016-11-09 19:03:39', '测试', '1');
INSERT INTO `messages` VALUES ('33', '2016-11-09 19:36:32', 'acg', '2');
INSERT INTO `messages` VALUES ('34', '2016-12-12 18:49:41', '阿萨德刚', '2');
INSERT INTO `messages` VALUES ('35', '2016-12-12 18:49:44', '十分蛋糕', '2');
INSERT INTO `messages` VALUES ('36', '2016-12-12 18:49:47', '啊是的噶', '2');
INSERT INTO `messages` VALUES ('37', '2016-12-12 18:49:50', '转发财富s', '2');
INSERT INTO `messages` VALUES ('38', '2016-12-12 18:49:53', 'sdfh ', '2');
INSERT INTO `messages` VALUES ('39', '2016-12-12 18:49:55', 'dfga d', '2');
INSERT INTO `messages` VALUES ('40', '2016-12-12 18:49:58', 'zfh afxn', '2');
INSERT INTO `messages` VALUES ('41', '2016-12-12 18:50:00', 'sjsfjaj', '2');
INSERT INTO `messages` VALUES ('42', '2016-12-12 18:50:29', '啊速度啊', '2');
INSERT INTO `messages` VALUES ('43', '2016-12-12 18:50:32', '阿萨德刚ads ', '2');
INSERT INTO `messages` VALUES ('44', '2016-12-12 18:50:35', '按单个ads', '2');
INSERT INTO `messages` VALUES ('45', '2016-12-12 18:51:08', '阿莎', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(25) DEFAULT NULL,
  `userNickName` varchar(25) DEFAULT NULL,
  `userPassword` varchar(25) DEFAULT NULL,
  `userBirthday` date DEFAULT NULL,
  `userMobile` varchar(15) DEFAULT NULL,
  `userMail` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'administrator', 'admin', '1993-04-18', '18772101437', '18772101437@163.com');
INSERT INTO `users` VALUES ('2', 'John', '萌大大', 'admin', '1993-04-18', '18772101417', '18772101417@163.com');
