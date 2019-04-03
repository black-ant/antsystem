/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : antsystem

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 03/04/2019 17:46:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for carinfo
-- ----------------------------
DROP TABLE IF EXISTS `carinfo`;
CREATE TABLE `carinfo`  (
  `sn` bigint(20) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_id` bigint(20) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `driver_id` bigint(20) NULL DEFAULT NULL,
  `latitude` double NULL DEFAULT NULL,
  `longitude` double NULL DEFAULT NULL,
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carinfo
-- ----------------------------
INSERT INTO `carinfo` VALUES (1, '1', 1, '2019-03-27 16:32:59', 1, 30.57146, 114.250731);
INSERT INTO `carinfo` VALUES (2, '1', 1, '2019-03-29 16:33:43', 1, 30.58146, 114.250731);
INSERT INTO `carinfo` VALUES (0, NULL, NULL, NULL, NULL, NULL, 114.250731);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL,
  `age` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '顾客年龄',
  `level` int(100) NULL DEFAULT 0 COMMENT '顾客平台等级',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '顾客电话',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '顾客姓名',
  `default_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '默认地址',
  `customer_id` int(11) NULL DEFAULT NULL,
  `default_address_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '默认地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKh1tr758dxi1qqbqnrjgp85rfg`(`customer_id`) USING BTREE,
  CONSTRAINT `FKh1tr758dxi1qqbqnrjgp85rfg` FOREIGN KEY (`customer_id`) REFERENCES `customer_address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (10001, '1', 0, '15800000066', '刚', '21', NULL, '21');

-- ----------------------------
-- Table structure for customer_address
-- ----------------------------
DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address`  (
  `id` int(11) NOT NULL,
  `city` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址城市',
  `customer_id` int(11) NULL DEFAULT NULL,
  `del_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址',
  `del_address_detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货详细地址',
  `del_mobile` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货收货人姓名',
  `del_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货收货人姓名',
  `del_place` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地区编号',
  `del_type` int(10) NULL DEFAULT 0 COMMENT '收货类型',
  `del_zip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货邮编',
  `district` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址区域',
  `latitude` double(6, 6) NULL DEFAULT 0.000000 COMMENT '纬度',
  `longitude` double(6, 6) NULL DEFAULT 0.000000 COMMENT '经度',
  `province` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址省份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer_address
-- ----------------------------
INSERT INTO `customer_address` VALUES (21, '北京城区东城区', 10001, '北京城区东城区', '123', '15800000066', '曾先生', NULL, 123, NULL, '东城区', 0.000000, 0.000000, '北京市');
INSERT INTO `customer_address` VALUES (22, '武汉', 10001, '武汉市硚口区', '宗关', '15800000023', '张女士', '', 1, '', '硚口区', 0.000000, 0.000000, '湖北省');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `depid` int(30) NOT NULL COMMENT '??id',
  `depdes` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `depname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `deptype` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `power` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  PRIMARY KEY (`depid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (100001, '测试', 'IT', '1', 'A001');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (22);
INSERT INTO `hibernate_sequence` VALUES (22);
INSERT INTO `hibernate_sequence` VALUES (22);

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `procode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sid` varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insnum` int(11) NOT NULL,
  `outnum` int(11) NOT NULL,
  `prodesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`procode`, `sid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('001', '1', 1, 1, '货品1', NULL);
INSERT INTO `inventory` VALUES ('002', '1', 1, 1, '货品2', NULL);
INSERT INTO `inventory` VALUES ('001', '2', 1, 1, '货品1', NULL);

-- ----------------------------
-- Table structure for item_sku_property
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_property`;
CREATE TABLE `item_sku_property`  (
  `id` int(3) NOT NULL DEFAULT 0 COMMENT '规格编号',
  `add_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '属性文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for item_sku_property_key
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_property_key`;
CREATE TABLE `item_sku_property_key`  (
  `id` int(11) NOT NULL,
  `add_time` datetime(0) NULL DEFAULT NULL,
  `mustneed` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_sku_property_key
-- ----------------------------
INSERT INTO `item_sku_property_key` VALUES (1, '2019-04-03 17:12:18', b'1', '颜色', 1);

-- ----------------------------
-- Table structure for item_sku_property_reference
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_property_reference`;
CREATE TABLE `item_sku_property_reference`  (
  `id` int(11) NOT NULL,
  `add_time` datetime(0) NULL DEFAULT NULL,
  `goodsid` int(11) NULL DEFAULT NULL,
  `issku` bit(1) NULL DEFAULT NULL,
  `skuid` int(11) NULL DEFAULT NULL,
  `skukeyid` int(11) NULL DEFAULT NULL,
  `skuvalueid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_sku_property_reference
-- ----------------------------
INSERT INTO `item_sku_property_reference` VALUES (1, '2019-04-03 17:44:31', 1, b'1', 2, 1, 1);

-- ----------------------------
-- Table structure for item_sku_property_value
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_property_value`;
CREATE TABLE `item_sku_property_value`  (
  `id` int(11) NOT NULL,
  `add_time` datetime(0) NULL DEFAULT NULL,
  `keyid` int(11) NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_sku_property_value
-- ----------------------------
INSERT INTO `item_sku_property_value` VALUES (1, '2019-04-03 17:12:36', 1, '白色');
INSERT INTO `item_sku_property_value` VALUES (2, '2019-04-03 17:12:46', 1, '玫瑰色');
INSERT INTO `item_sku_property_value` VALUES (3, '2019-04-05 17:13:18', 2, '10*10');
INSERT INTO `item_sku_property_value` VALUES (4, '2019-04-03 17:13:43', 2, '10*20');

-- ----------------------------
-- Table structure for login_code
-- ----------------------------
DROP TABLE IF EXISTS `login_code`;
CREATE TABLE `login_code`  (
  `sn` bigint(20) NOT NULL,
  `enddate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logincode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logistics_order
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order`;
CREATE TABLE `logistics_order`  (
  `orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logistics_order_item
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order_item`;
CREATE TABLE `logistics_order_item`  (
  `orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logistics_order_items
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order_items`;
CREATE TABLE `logistics_order_items`  (
  `logistics_order_orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `items_orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `UK_3i0dnjk013jmatnnn8wxuywip`(`items_orderid`) USING BTREE,
  INDEX `FKtqoo31f3she7sie8eni4dxoa9`(`logistics_order_orderid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logistics_order_log
-- ----------------------------
DROP TABLE IF EXISTS `logistics_order_log`;
CREATE TABLE `logistics_order_log`  (
  `logid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`logid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part_type
-- ----------------------------
DROP TABLE IF EXISTS `part_type`;
CREATE TABLE `part_type`  (
  `pid` int(30) NOT NULL COMMENT '??ID',
  `pdes` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `pname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `power` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  `ptype` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shopid` int(11) NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` int(11) NULL DEFAULT NULL,
  `linkman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `linkphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logindate` datetime(0) NULL DEFAULT NULL,
  `shopdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shoplevel` int(11) NULL DEFAULT NULL,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopstatus` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`shopid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (2147483647, '2019-03-17 23:12:47', 1, 'test', '123456', '2019-03-17 23:12:59', '测试', 1, 'test', 1);
INSERT INTO `shop` VALUES (100001, '2019-03-30 16:38:24', NULL, 'GG', '15800000066', NULL, '111', NULL, '刚', NULL);

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods`  (
  `id` int(11) NOT NULL,
  `alias` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '系统生成唯一ID',
  `create_date` datetime(0) NULL DEFAULT NULL,
  `goodscate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品类别',
  `goodscode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商家自定义货号',
  `goodsdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '货品描述',
  `goodsprice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsstyle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品风格',
  `goodstitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '货品标题',
  `goodstype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品类型',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale_staus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '店铺ID',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '货品副标题',
  `update_date` datetime(0) NULL DEFAULT NULL,
  `volume` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES (1, 'code0001', '2019-04-05 17:40:36', '1', 'code1', '登山背包', '999', '1', '大型登山背包，雪地包', '1', '加厚', '1', '1', '10001', '66*99', 1, '1', '2019-04-03 17:41:58', '1');

-- ----------------------------
-- Table structure for shop_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_sku`;
CREATE TABLE `shop_goods_sku`  (
  `unique_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `goods_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imageurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_id` int(11) NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `properties` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quantity` int(6) NULL DEFAULT 0 COMMENT '库存',
  `sale_num` int(6) NULL DEFAULT 0 COMMENT '销量',
  `shop_id` int(11) NULL DEFAULT NULL,
  `sku_id` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `with_hold_quantity` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`unique_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_goods_sku
-- ----------------------------
INSERT INTO `shop_goods_sku` VALUES ('sku0001', '2019-04-04 17:42:34', '1', NULL, 1, 999, '白色-大号', 999, 1, 10001, 1, 1, '2019-04-03 17:43:51', NULL);

-- ----------------------------
-- Table structure for shop_return_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_return_order`;
CREATE TABLE `shop_return_order`  (
  `orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_return_order
-- ----------------------------
INSERT INTO `shop_return_order` VALUES ('S1102231', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for shop_return_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `shop_return_orderitem`;
CREATE TABLE `shop_return_orderitem`  (
  `orderid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sn` varchar(22) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`, `sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_return_orderitem
-- ----------------------------
INSERT INTO `shop_return_orderitem` VALUES ('S1102231', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shop_return_orderitem` VALUES ('S1102231', '2', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for shop_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `shop_warehouse`;
CREATE TABLE `shop_warehouse`  (
  `warehouseid` int(11) NOT NULL,
  `warehouseaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehousetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`warehouseid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for trade_order
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '唯一交易ID',
  `buyer_message` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '订单备注',
  `buyuserid` int(100) NULL DEFAULT 0 COMMENT '买家编号1',
  `close_type` int(10) NULL DEFAULT 0 COMMENT '关闭类型',
  `consign_time` decimal(9, 2) NULL DEFAULT NULL COMMENT ' 发货时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `del_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址',
  `del_address_detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货详细地址',
  `del_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货收货人姓名',
  `del_place` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地区编号',
  `del_type` int(10) NULL DEFAULT 0 COMMENT '收货类型',
  `del_zip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货邮编',
  `discount_fee` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '优惠费用',
  `goodscode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '货品编号',
  `num` int(100) NULL DEFAULT 0 COMMENT '交易数量',
  `ordernum` int(10) NULL DEFAULT 0 COMMENT '订单数量',
  `outer_tid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '第三方ID',
  `pay_time` decimal(9, 2) NULL DEFAULT NULL COMMENT '付款时间',
  `pay_type` int(10) NULL DEFAULT 0 COMMENT '支付类型',
  `payorderid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '支付流水ID',
  `price` decimal(9, 2) NOT NULL COMMENT '订单价格',
  `realfee` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '实付',
  `refunded_fee` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '退款',
  `shop_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '店铺ID',
  `sign_time` decimal(9, 2) NULL DEFAULT NULL COMMENT ' 签收时间',
  `status` int(100) NULL DEFAULT 0 COMMENT '交易状态',
  `total_fee` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '订单总价',
  `transfee` decimal(9, 2) NULL DEFAULT 0.00 COMMENT '配送费',
  `type` int(100) NULL DEFAULT 0 COMMENT '交易类型',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for trade_order_item
-- ----------------------------
DROP TABLE IF EXISTS `trade_order_item`;
CREATE TABLE `trade_order_item`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_messages` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品备注',
  `discount_fee` decimal(9, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `goods_type` int(10) NULL DEFAULT 0 COMMENT '商品总类型',
  `item_id` int(100) NULL DEFAULT 0 COMMENT '商品ID',
  `item_type` int(10) NULL DEFAULT 0 COMMENT '商品类型',
  `num` decimal(9, 2) NULL DEFAULT NULL COMMENT '商品数量',
  `payment` decimal(9, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `price` decimal(9, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `refunded_fee` decimal(9, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `rid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '交易编号',
  `shop_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '店铺ID',
  `sku_id` int(10) NULL DEFAULT 0 COMMENT 'SKU编号',
  `sku_properties_name` int(10) NULL DEFAULT 0 COMMENT 'SKU值',
  `snapshot_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品快照编号',
  `status` int(10) NULL DEFAULT 0 COMMENT '交易状态',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品标题',
  `total_fee` decimal(9, 2) NULL DEFAULT NULL COMMENT '商品总价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log`  (
  `sn` int(11) NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `logip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_platform
-- ----------------------------
DROP TABLE IF EXISTS `user_platform`;
CREATE TABLE `user_platform`  (
  `userid` bigint(20) NOT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `systemdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `systemname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `useraccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userage` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userlevel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersex` bit(1) NULL DEFAULT NULL,
  `usertype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_platform
-- ----------------------------
INSERT INTO `user_platform` VALUES (1, '2019-01-27 20:30:39', '1', '1', '11', '11', '11', '1', '1', '1', b'1', '1');
INSERT INTO `user_platform` VALUES (16, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, '1', b'1', NULL);

-- ----------------------------
-- Table structure for user_platform_userroles
-- ----------------------------
DROP TABLE IF EXISTS `user_platform_userroles`;
CREATE TABLE `user_platform_userroles`  (
  `user_platform_userid` bigint(20) NOT NULL,
  `userroles_id` bigint(20) NOT NULL,
  `user_platform_entity_userid` bigint(20) NOT NULL,
  UNIQUE INDEX `UK_tnw200ig7rc88bjn0rew8xhdp`(`userroles_id`) USING BTREE,
  INDEX `FKhqtu32b6rtb7mupgtwlwymbgm`(`user_platform_userid`) USING BTREE,
  INDEX `FKliieroe16e1j8ct2vo1tu1ahv`(`user_platform_entity_userid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_roles_authorities
-- ----------------------------
DROP TABLE IF EXISTS `user_roles_authorities`;
CREATE TABLE `user_roles_authorities`  (
  `user_roles_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_roles_id`, `authorities_id`) USING BTREE,
  INDEX `FK8eq5vblgxrw5xlxk7da54ulbk`(`authorities_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user_shop
-- ----------------------------
DROP TABLE IF EXISTS `user_shop`;
CREATE TABLE `user_shop`  (
  `userid` int(11) NOT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_source
-- ----------------------------
DROP TABLE IF EXISTS `user_source`;
CREATE TABLE `user_source`  (
  `userid` bigint(20) NOT NULL,
  `companylevel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `companymobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `createuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `systemdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `systemname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `useraccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userage` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usercompany` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersex` bit(1) NULL DEFAULT NULL,
  `usertype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_source_userroles
-- ----------------------------
DROP TABLE IF EXISTS `user_source_userroles`;
CREATE TABLE `user_source_userroles`  (
  `user_source_userid` bigint(20) NOT NULL,
  `userroles_id` bigint(20) NOT NULL,
  UNIQUE INDEX `UK_gmumwo2iewrudeeh71caq70jt`(`userroles_id`) USING BTREE,
  INDEX `FKms4l77b4xik2t7wmjj4930sc`(`user_source_userid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user_summary
-- ----------------------------
DROP TABLE IF EXISTS `user_summary`;
CREATE TABLE `user_summary`  (
  `sn` bigint(20) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userfrom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_summary_userroles
-- ----------------------------
DROP TABLE IF EXISTS `user_summary_userroles`;
CREATE TABLE `user_summary_userroles`  (
  `user_summary_sn` bigint(20) NOT NULL,
  `userroles_id` bigint(20) NOT NULL,
  INDEX `FKijpsg9w8kqo35osm5594acv9y`(`userroles_id`) USING BTREE,
  INDEX `FK56lpmj9d6stets95arkgyhgfw`(`user_summary_sn`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token`  (
  `userid` bigint(20) NOT NULL,
  `deviceid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `devicetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `failuredate` datetime(0) NULL DEFAULT NULL,
  `loginip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tokenseed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updatedate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
