/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云服务器
Source Server Version : 50729
Source Host           : 111.229.84.46:13306
Source Database       : jyjy_order

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-07-01 21:47:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `xts_id` int(11) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES ('1', '3', '1', '1', '1', '投诉1', '修图师和鉴图师都垃圾！', null, '0', '恩恩，我们了解了！', '0', '2020-06-25 19:07:05', '2020-06-25 19:07:05');
INSERT INTO `complaint` VALUES ('2', '49', null, null, '', null, '', null, '0', null, '0', '2020-06-27 19:47:34', '2020-06-27 19:47:34');
INSERT INTO `complaint` VALUES ('3', '49', null, null, '', null, '', null, '0', null, '0', '2020-06-27 19:56:12', '2020-06-27 19:56:12');

-- ----------------------------
-- Table structure for consignee
-- ----------------------------
DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consignee
-- ----------------------------
INSERT INTO `consignee` VALUES ('1', '收货人1', '1380013800', '74107410@qq.com', '这是买家留言！', '广东省珠海市唐家湾北京师范大学珠海分校', '2020-06-25 19:07:05', '2020-06-25 19:07:05');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `xts_id` int(11) DEFAULT NULL,
  `jts_id` int(11) DEFAULT NULL,
  `consignee_id` int(11) DEFAULT NULL,
  `connect_id` int(11) DEFAULT NULL,
  `order_type` char(1) DEFAULT NULL,
  `sub_price` decimal(10,2) DEFAULT NULL,
  `add_price` decimal(10,2) DEFAULT NULL,
  `dis_price` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `filter_comment_value` int(11) DEFAULT NULL,
  `filter_comment_detail` varchar(255) DEFAULT NULL,
  `xts_comment_value` int(11) DEFAULT NULL,
  `xts_comment_detail` varchar(255) DEFAULT NULL,
  `jts_comment_value` int(11) DEFAULT NULL,
  `jts_comment_detail` varchar(255) DEFAULT NULL,
  `pay_status` char(1) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `is_settle` char(1) DEFAULT NULL,
  `is_complaint` char(1) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('49', null, null, null, null, '10', '0', '0.00', '0.00', '0.00', '0.00', null, null, null, null, null, null, '0', '2', '0', '0', '0', '2020-06-27 18:45:24', '2020-06-27 18:45:24');
INSERT INTO `orders` VALUES ('50', null, null, null, null, '10', '0', '0.00', '0.00', '0.00', '0.00', null, null, null, null, null, null, '1', '2', '0', '0', '0', '2020-06-27 18:58:39', '2020-06-27 21:26:48');
INSERT INTO `orders` VALUES ('56', null, null, null, null, '15', '1', '20.00', '5.00', '0.00', '25.00', null, null, null, null, null, null, '1', '1', '0', '0', '0', '2020-06-27 23:47:51', '2020-06-28 00:03:17');
INSERT INTO `orders` VALUES ('57', null, null, null, null, '16', '1', '20.00', '5.00', '0.00', '25.00', null, null, null, null, null, null, '0', '0', '0', '0', '0', '2020-06-27 23:57:06', '2020-06-27 23:57:06');
INSERT INTO `orders` VALUES ('58', null, null, null, null, '10', '0', '10.00', '0.00', '0.00', '10.00', null, null, null, null, null, null, '0', '0', '0', '0', '0', '2020-07-01 17:12:30', '2020-07-01 17:12:30');
