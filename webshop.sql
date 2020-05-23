/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : webshop

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-05-23 10:07:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `u_id` int(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '阿迪斯', '13123123123', 'asad', '1');
INSERT INTO `address` VALUES ('2', '吼吼', '123123', '幅度高达', '3');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `sex` varchar(12) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `age` int(64) DEFAULT NULL,
  `credit` varchar(32) DEFAULT NULL,
  `sum` int(32) DEFAULT NULL,
  `u_id` int(128) DEFAULT NULL,
  `date` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', 'aa', '男', '广科', '10086', 'aa@aa.com', '16', null, null, '1', null);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int(32) NOT NULL AUTO_INCREMENT,
  `cart_p_name` varchar(64) DEFAULT NULL,
  `cart_date` varchar(128) DEFAULT NULL,
  `cart_p_id` int(32) DEFAULT NULL,
  `cart_order_price` double(128,0) DEFAULT NULL,
  `cart_state` varchar(64) DEFAULT NULL,
  `cart_order_id` varchar(256) DEFAULT NULL,
  `cart_sum` int(32) DEFAULT NULL,
  `cart_img` varchar(256) DEFAULT NULL,
  `u_id` int(255) DEFAULT NULL,
  `cart_p_price` double(128,0) DEFAULT NULL,
  `cart_uuid` varchar(256) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('229', '电脑aaaaa222', '2020-02-24', '30', '1710', '待发货', '0abd44c7905d4c55aa0f60831fa85878', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', 'ffe6f588bb124e078ed4963c108b5c4e', '1');
INSERT INTO `cart` VALUES ('230', '电脑a7777', '2020-02-24', '42', '1710', '待发货', '0abd44c7905d4c55aa0f60831fa85878', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '6310faf0e8c44c8fa7412d146b07e9ce', '1');
INSERT INTO `cart` VALUES ('231', '电脑aaaaa111', '2020-02-24', '18', '1710', '待发货', '0abd44c7905d4c55aa0f60831fa85878', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '86a9ab8dd2b74865bd4001658adf2809', '1');
INSERT INTO `cart` VALUES ('232', '电脑333', '2020-02-24', '36', '1710', '待发货', '3c3c0f51d1634d50add65ef0906ade4b', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '5f1d88e1c9d549dea36b43658ff095ed', '1');
INSERT INTO `cart` VALUES ('233', '电脑aaaaa222', '2020-02-24', '30', '1710', '待发货', '3c3c0f51d1634d50add65ef0906ade4b', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', 'b261cd2edb34454eb3a211fd3678e9b9', '1');
INSERT INTO `cart` VALUES ('234', '电脑aaaaa111', '2020-02-24', '18', '1710', '待发货', '3c3c0f51d1634d50add65ef0906ade4b', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '6a3b85699dbc4429b0cac72984b449ef', '1');
INSERT INTO `cart` VALUES ('235', '电脑aaaaa222', '2020-02-24', '30', '1710', '待发货', '6f1b685aa8a04ed49a616e769b5386ad', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', 'fc4f59bc09f74ff5a1fd8e733119751f', '1');
INSERT INTO `cart` VALUES ('236', '电脑aaaaa222', '2020-02-24', '30', '1710', '购物车', null, '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '525b6f4ecc01452dbb4aeb0779bc6972', '1');
INSERT INTO `cart` VALUES ('237', '电脑333', '2020-02-24', '36', '1710', '购物车', null, '1', '45e0b7afb4a34620968dbaea1987bac0.png', '3', '1900', '2d88e9983410498a8d50ce70d1c925c6', '1');
INSERT INTO `cart` VALUES ('238', '电脑aaaaa222', '2020-02-24', '30', '1710', '待发货', '2fccbc89378542b993436d4bfe520eb6', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '1', '1900', '7e26e68eb93e4b4ea98e3b2e330173d4', '1');
INSERT INTO `cart` VALUES ('239', '电脑aaaaa111', '2020-02-24', '18', '1599', '待发货', 'dec5eb025b6d49e59ad4f6f8bc5951c6', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '1', '1777', 'ad6093ce7aba401db5b4e87abf62fdf9', '1');
INSERT INTO `cart` VALUES ('240', '电脑aaaaa222', '2020-02-24', '30', '1710', '待发货', '4ab2447650544edb82c2187fc13cf8a7', '1', '45e0b7afb4a34620968dbaea1987bac0.png', '1', '1900', 'eda4f42afac64c5393b4f6df0a58ae32', '1');

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `d_id` int(32) NOT NULL AUTO_INCREMENT,
  `classname` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', '电脑');
INSERT INTO `dict` VALUES ('2', '手机');
INSERT INTO `dict` VALUES ('3', '耳机');
INSERT INTO `dict` VALUES ('4', '像机');
INSERT INTO `dict` VALUES ('5', '平板电脑');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `i_id` int(32) NOT NULL AUTO_INCREMENT,
  `img1` varchar(256) DEFAULT NULL,
  `img2` varchar(256) DEFAULT NULL,
  `img3` varchar(256) DEFAULT NULL,
  `img4` varchar(256) DEFAULT NULL,
  `img5` varchar(256) DEFAULT NULL,
  `img6` varchar(256) DEFAULT NULL,
  `p_uuid` varchar(256) DEFAULT NULL,
  `intro` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('1', '140ff8dc2f354ca3a97364477652c72f1.png', '140ff8dc2f354ca3a97364477652c72f2.png', '140ff8dc2f354ca3a97364477652c72f3.png', '140ff8dc2f354ca3a97364477652c72f4.png', null, null, '4ae8b4bd4c9e447e9674ca17571a3879', null);
INSERT INTO `images` VALUES ('6', 'b4321e5c5d89478ea37a1c864ae10a101.png', '6a6099c58ea846f4bd139f75f99d0d9b2.png', '6a6099c58ea846f4bd139f75f99d0d9b3.png', '6a6099c58ea846f4bd139f75f99d0d9b4.png', null, null, 'e367b03f3d2a46beb733b0f5ad641f7a', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa');
INSERT INTO `images` VALUES ('7', '64e0a88ec92a43d8899942b8747f2ce31.png', '64e0a88ec92a43d8899942b8747f2ce32.png', '64e0a88ec92a43d8899942b8747f2ce33.png', '64e0a88ec92a43d8899942b8747f2ce34.png', null, null, 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '夜夜夜夜耶耶耶耶耶耶耶耶耶');
INSERT INTO `images` VALUES ('8', '378233db2b8e40718c38f2a273e19cbc1.png', '378233db2b8e40718c38f2a273e19cbc2.png', '378233db2b8e40718c38f2a273e19cbc3.png', '378233db2b8e40718c38f2a273e19cbc4.png', null, null, 'edd6cfc1911749caa1bb1ba88e1bcc57', '可使肌肤接收看来飞机喀什的冯绍峰');
INSERT INTO `images` VALUES ('9', 'ea6079467f43472696581082ce0b2b391.png', 'ea6079467f43472696581082ce0b2b392.png', 'ea6079467f43472696581082ce0b2b393.png', 'ea6079467f43472696581082ce0b2b394.png', null, null, 'c19761d7936e4d88ae8d895250eee164', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃');
INSERT INTO `images` VALUES ('10', '7b0530f9ffcf435cb9995e7f578980301.png', '7b0530f9ffcf435cb9995e7f578980302.png', '7b0530f9ffcf435cb9995e7f578980303.png', '7b0530f9ffcf435cb9995e7f578980304.png', null, null, '047eeb51f1294723bae035977781a49c', '水水水水水水水水水水水水水水');
INSERT INTO `images` VALUES ('15', '1d19693ecfe14960972faf74a080ed4a1.png', '1d19693ecfe14960972faf74a080ed4a2.png', '1d19693ecfe14960972faf74a080ed4a3.png', '1d19693ecfe14960972faf74a080ed4a4.png', null, null, '34d86ef5fa9b4595a3fe695ba98eb2f1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃');

-- ----------------------------
-- Table structure for love
-- ----------------------------
DROP TABLE IF EXISTS `love`;
CREATE TABLE `love` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `p_id` int(32) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of love
-- ----------------------------
INSERT INTO `love` VALUES ('5', '19', '1');
INSERT INTO `love` VALUES ('7', '22', '1');
INSERT INTO `love` VALUES ('10', '40', '1');
INSERT INTO `love` VALUES ('11', '30', '3');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `p_id` int(32) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(32) DEFAULT NULL,
  `p_price` double(124,0) DEFAULT NULL,
  `p_sum` int(64) DEFAULT NULL,
  `p_keep` int(64) DEFAULT NULL,
  `p_userid` int(64) DEFAULT NULL,
  `p_img` varchar(128) DEFAULT NULL,
  `p_imgid` varchar(256) DEFAULT NULL,
  `p_status` varchar(64) DEFAULT NULL,
  `p_classid` int(64) DEFAULT NULL,
  `intro` varchar(256) DEFAULT NULL,
  `date` varchar(256) DEFAULT NULL,
  `p_uuid` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('18', '电脑aaaaa111', '1777', '1', '29', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('19', '耳机a1111', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('20', '摄像机aa111', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('21', '平板电脑aa1111', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('22', '手机aa111', '2999', '17', '50', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('29', '耳机aaaaaaaaaa2222', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('30', '电脑aaaaa222', '1900', '8', '88', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('31', '耳机a222', '1999', '0', '14', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('32', '摄像机aa222', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('33', '平板电脑222', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('34', '手机3333', '2999', '225', '37', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('35', '耳机aaaaaa3333', '2000', '1', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('36', '电脑333', '1900', '3', '8', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('37', '耳机a1333', '1999', '1', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('38', '摄像机aa333', '1999', '1', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('39', '平板电脑aa444', '3000', '1', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('40', '手机aa55', '2999', '1', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('41', '耳机aaaaaa666a', '2000', '1', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('42', '电脑a7777', '1900', '1', '9', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('43', '耳机a1777', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('44', '摄像机aa777', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('45', '平板电脑aa777', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('46', '手机aa8888', '2999', '0', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('47', '耳机99999', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('48', '电脑a999', '1900', '0', '20', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('49', '耳机a1', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('50', '摄像机aa', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('51', '平板电脑aa', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('52', '手机aa', '2999', '0', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('53', '耳机aaaaa233', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('54', '电脑234', '1900', '0', '20', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('55', '耳机a1234', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('56', '摄像机aa234', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('57', '平板电脑aa', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('58', '手机33442', '2999', '0', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('59', '耳机3424255', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('60', '电脑34', '1900', '0', '20', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('61', '耳机a1', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('62', '摄像机aa', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('63', '平板电脑aa', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('64', '手机aa', '2999', '0', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('65', '耳机aaaaaaaaaaaaaaa', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');
INSERT INTO `product` VALUES ('66', '电脑aaaaa', '1900', '0', '20', '1', '45e0b7afb4a34620968dbaea1987bac0.png', 'e367b03f3d2a46beb733b0f5ad641f7a', '', '1', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃aaa', '2020-02-20', 'e367b03f3d2a46beb733b0f5ad641f7a');
INSERT INTO `product` VALUES ('67', '耳机a1', '1999', '0', '15', '1', '64e0a88ec92a43d8899942b8747f2ce3.png', 'd9fc8b9d5b6d43febde45ad7fd9e64d9', '', '3', '夜夜夜夜耶耶耶耶耶耶耶耶耶', '2020-02-20', 'd9fc8b9d5b6d43febde45ad7fd9e64d9');
INSERT INTO `product` VALUES ('68', '摄像机aa', '1999', '0', '56', '1', '378233db2b8e40718c38f2a273e19cbc.png', 'edd6cfc1911749caa1bb1ba88e1bcc57', '', '4', '可使肌肤接收看来飞机喀什的冯绍峰', '2020-02-20', 'edd6cfc1911749caa1bb1ba88e1bcc57');
INSERT INTO `product` VALUES ('69', '平板电脑aa', '3000', '0', '60', '1', 'ea6079467f43472696581082ce0b2b39.png', 'c19761d7936e4d88ae8d895250eee164', '', '5', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-20', 'c19761d7936e4d88ae8d895250eee164');
INSERT INTO `product` VALUES ('70', '手机aa', '2999', '0', '67', '1', '7b0530f9ffcf435cb9995e7f57898030.png', '047eeb51f1294723bae035977781a49c', '', '2', '水水水水水水水水水水水水水水', '2020-02-20', '047eeb51f1294723bae035977781a49c');
INSERT INTO `product` VALUES ('71', '耳机aaaaaaa34a', '2000', '0', '20', '1', '1d19693ecfe14960972faf74a080ed4a1.png', '34d86ef5fa9b4595a3fe695ba98eb2f1', '', '3', '呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃', '2020-02-23', '34d86ef5fa9b4595a3fe695ba98eb2f1');

-- ----------------------------
-- Table structure for pro_order
-- ----------------------------
DROP TABLE IF EXISTS `pro_order`;
CREATE TABLE `pro_order` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `date` varchar(128) DEFAULT NULL,
  `p_id` int(32) DEFAULT NULL,
  `order_uuid` varchar(256) DEFAULT NULL,
  `order_price` double(128,0) DEFAULT NULL,
  `state` varchar(64) DEFAULT NULL,
  `post` varchar(32) DEFAULT NULL,
  `order_cardid` int(32) DEFAULT NULL,
  `sum` int(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `post_id` varchar(128) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_order
-- ----------------------------
INSERT INTO `pro_order` VALUES ('144', '2020-02-24', null, '0abd44c7905d4c55aa0f60831fa85878', '5130', '待收货', null, '1', null, '幅度高达', '123123', '吼吼', null, '3');
INSERT INTO `pro_order` VALUES ('145', '2020-02-24', null, '3c3c0f51d1634d50add65ef0906ade4b', '5130', '待收货', null, '1', null, '幅度高达', '123123', '吼吼', null, '3');
INSERT INTO `pro_order` VALUES ('146', '2020-02-24', null, '6f1b685aa8a04ed49a616e769b5386ad', '1710', '待发货', null, '1', null, '幅度高达', '123123', '吼吼', null, '3');
INSERT INTO `pro_order` VALUES ('147', '2020-02-24', null, '2fccbc89378542b993436d4bfe520eb6', '1710', '确认收货', null, '1', null, 'asad', '13123123123', '阿迪斯', null, '1');
INSERT INTO `pro_order` VALUES ('148', '2020-02-24', null, 'dec5eb025b6d49e59ad4f6f8bc5951c6', '1599', '已收货', null, null, null, 'asad', '13123123123', '阿迪斯', null, '1');
INSERT INTO `pro_order` VALUES ('149', '2020-02-24', null, '4ab2447650544edb82c2187fc13cf8a7', '1710', '确认收货', null, '1', null, 'asad', '13123123123', '阿迪斯', null, '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(32) DEFAULT NULL,
  `data` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user:admin', '管理员');
INSERT INTO `role` VALUES ('2', 'user:vip', '卖家');
INSERT INTO `role` VALUES ('3', 'user:user', '普通用户');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `role_id` int(32) DEFAULT NULL,
  `u_name` varchar(32) DEFAULT NULL,
  `age` int(32) DEFAULT NULL,
  `sex` varchar(16) DEFAULT NULL,
  `hobby` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1e2bca08d5f3cdc9bef78e52c2aa46be', '1', '管理员', '16', '男', '阿三顶顶', 'qq.com');
INSERT INTO `user` VALUES ('3', '2', '0ac42a83acae6c15a50a89306b9b59a5', '2', '2', null, null, null, null);
INSERT INTO `user` VALUES ('4', '3', '9d56c749a13f7a8fb12b65d4595dd8c1', '3', '3', null, null, null, null);
INSERT INTO `user` VALUES ('5', '4', 'dac6ad6127273afe6371f3d9b96566dc', '3', '4', null, null, null, null);
