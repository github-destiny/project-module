/*
Navicat MySQL Data Transfer

Source Server         : cheng
Source Server Version : 50536
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2021-10-20 16:31:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for uploadinfo
-- ----------------------------
DROP TABLE IF EXISTS `uploadinfo`;
CREATE TABLE `uploadinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` char(8) NOT NULL,
  `size` bigint(20) NOT NULL,
  `originname` varchar(50) NOT NULL,
  `time` datetime NOT NULL,
  `path` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
