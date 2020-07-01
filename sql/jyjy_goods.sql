/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云服务器
Source Server Version : 50729
Source Host           : 111.229.84.46:13306
Source Database       : jyjy_goods

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-07-01 21:47:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for filter
-- ----------------------------
DROP TABLE IF EXISTS `filter`;
CREATE TABLE `filter` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `xts_id` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `love` int(11) DEFAULT NULL,
  `sold` int(11) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filter
-- ----------------------------
INSERT INTO `filter` VALUES ('10', null, '1', '人像', 'http://111.229.84.46:8080/JYJY/upload/1593254676147.png', '人像精修', '10.00', '0', '0', 'http://111.229.84.46:8080/JYJY/upload/1593254685662.png', '0', '2020-06-27 18:44:57', '2020-06-27 18:44:57');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `xts_id` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `goods_type` char(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `xts_level` char(1) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `urgent_level` char(1) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('6', '5', null, '0', '0', null, '没有需求', '证件照', null, 'http://111.229.84.46:8080/JYJY/upload/1593251118256.jpg', '0', '9.00', '2', '1', '123456', null, '0', '2020-06-27 17:45:40', '2020-06-27 17:45:40');
INSERT INTO `goods` VALUES ('7', '5', null, '0', '0', null, '测试的需求', '人像', null, 'http://111.229.84.46:8080/JYJY/upload/1593255729663.jpeg', '0', '9.00', '2', '1', '1523478908', null, '0', '2020-06-27 19:02:43', '2020-06-27 19:02:43');
INSERT INTO `goods` VALUES ('8', '5', null, '0', '0', null, '111', 'PS抠图', null, 'http://111.229.84.46:8080/JYJY/upload/1593258677021.jpg', '0', '10.00', '3', '1', '111', null, '0', '2020-06-27 19:51:31', '2020-06-27 19:51:31');
INSERT INTO `goods` VALUES ('9', '5', null, '0', '0', null, '呜呜呜', '证件照', null, 'http://111.229.84.46:8080/JYJY/upload/1593261792770.jpg', '0', '10.00', '3', '1', '111', null, '0', '2020-06-27 20:43:31', '2020-06-27 20:43:31');
INSERT INTO `goods` VALUES ('10', '5', null, '0', '0', null, '啦啦啦', '风景', null, 'http://111.229.84.46:8080/JYJY/upload/1593261991427.jpeg', '0', '20.00', '3', '1', '11111111', null, '0', '2020-06-27 20:46:50', '2020-06-27 20:46:50');
INSERT INTO `goods` VALUES ('11', '5', null, '0', '0', null, '哎呀', '证件照', null, 'http://111.229.84.46:8080/JYJY/upload/1593262486583.jpeg', '0', '9.00', '2', '1', '11', null, '0', '2020-06-27 20:55:00', '2020-06-27 20:55:00');
INSERT INTO `goods` VALUES ('12', '5', null, '0', '0', null, '无需求描述', '证件照', null, 'http://111.229.84.46:8080/JYJY/upload/1593262574848.jpg', '0', '3.00', '2', '1', '11', null, '0', '2020-06-27 20:56:26', '2020-06-27 20:56:26');
INSERT INTO `goods` VALUES ('13', '5', null, '0', '0', null, '11', '风景', null, 'http://111.229.84.46:8080/JYJY/upload/1593264722911.jpg', '0', '6.00', '2', '1', '111', null, '0', '2020-06-27 21:32:14', '2020-06-27 21:32:14');
INSERT INTO `goods` VALUES ('14', '5', null, '0', '0', null, '测试需求', 'PS抠图', null, 'http://111.229.84.46:8080/JYJY/upload/1593272624926.png', '0', '20.00', '3', '1', '123', null, '0', '2020-06-27 23:44:11', '2020-06-27 23:44:11');
INSERT INTO `goods` VALUES ('15', '5', null, '0', '0', null, '测试需求', '证件照', null, 'http://111.229.84.46:8080/JYJY/upload/1593272851894.jpg', '0', '20.00', '3', '1', '123456', null, '0', '2020-06-27 23:47:51', '2020-06-27 23:47:51');
INSERT INTO `goods` VALUES ('16', '5', null, '0', '0', null, '这里是测试需求', '风景', null, 'http://111.229.84.46:8080/JYJY/upload/1593273404474.jpeg', '0', '20.00', '3', '1', '112233@qq.com', null, '0', '2020-06-27 23:57:06', '2020-06-27 23:57:06');
