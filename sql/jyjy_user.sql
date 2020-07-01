/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云服务器
Source Server Version : 50729
Source Host           : 111.229.84.46:13306
Source Database       : jyjy_user

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-07-01 21:48:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform_scale` decimal(10,2) DEFAULT NULL,
  `platform_income` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES ('1', '0.20', '100202.00', '2020-06-11 03:59:32', '2020-06-11 03:59:32');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `shop_level` char(1) DEFAULT NULL,
  `shop_value` int(11) DEFAULT NULL,
  `shop_scale` decimal(10,2) DEFAULT NULL,
  `shop_income` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '小店1', '130XXXX1234', '1', '400', '0.10', '10050.50', '2020-06-11 03:59:32', '2020-06-11 03:59:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '微信唯一标识openid',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',
  `avatarurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像图片地址',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户性别',
  `location` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户手机号码',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '用户1', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '0', '广东，珠海，香洲区', '130XXXX1234', '2020-06-11 03:59:32', '2020-06-11 03:59:32');
INSERT INTO `user` VALUES ('2', '2', '用户2', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '1', '广东，珠海，香洲区', '130XXXX1234', '2020-06-11 03:59:32', '2020-06-11 03:59:32');
INSERT INTO `user` VALUES ('3', '3', '用户3', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '0', '广东，珠海，香洲区', '130XXXX1234', '2020-06-11 03:59:32', '2020-06-11 03:59:32');
INSERT INTO `user` VALUES ('4', '4', '用户4', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '1', '广东，珠海，香洲区', '130XXXX1234', '2020-06-11 03:59:32', '2020-06-11 03:59:32');
INSERT INTO `user` VALUES ('5', 'o6h5P5TTCTWDrgceDpz_cnEaPzdM', null, null, null, null, null, '2020-06-20 20:05:37', '2020-06-20 20:05:37');
INSERT INTO `user` VALUES ('6', null, '用户4', null, null, null, '130XXXX1234', '2020-07-01 20:07:35', null);

-- ----------------------------
-- Table structure for xts
-- ----------------------------
DROP TABLE IF EXISTS `xts`;
CREATE TABLE `xts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `xts_status` char(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `idcard_image` varchar(255) DEFAULT NULL,
  `auth_image` varchar(255) DEFAULT NULL,
  `xts_level` char(1) DEFAULT NULL,
  `xts_value` int(11) DEFAULT NULL,
  `xts_scale` decimal(10,2) DEFAULT NULL,
  `xts_income` decimal(10,2) DEFAULT NULL,
  `jts_status` char(1) DEFAULT NULL,
  `jts_level` char(1) DEFAULT NULL,
  `jts_value` int(11) DEFAULT NULL,
  `jts_scale` decimal(10,2) DEFAULT NULL,
  `jts_income` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xts
-- ----------------------------
INSERT INTO `xts` VALUES ('1', '1', null, '1', '修图师1', '', '130XXXX1234', '44XXXX20200101XXXX', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '1', '490', '0.52', '5120.00', '1', '0', '488', '0.10', '850.50', '2020-06-10 01:23:12', '2020-06-11 04:10:47');
INSERT INTO `xts` VALUES ('2', '2', null, '1', '修图师2', null, '130XXXX1234', '44XXXX20200101XXXX', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '0', '100', '0.50', '6000.00', '0', '1', '150', '0.11', '1200.00', '2020-06-10 01:23:12', '2020-06-11 04:10:47');
INSERT INTO `xts` VALUES ('3', '2', null, '1', '修图师3', null, '130XXXX1234', '44XXXX20200101XXXX', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', 'http://111.229.84.46:8080/JYJY/upload/1586184809127.jpg', '2', '800', '0.55', '10000.00', '1', '2', '400', '0.12', '5000.00', '2020-06-10 01:23:12', '2020-06-11 04:10:47');
