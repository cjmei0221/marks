/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : marks

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 12/23/2020 08:45:18 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `TB_ACCT_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ACCT_INFO`;
CREATE TABLE `TB_ACCT_INFO` (
  `userid` varchar(50) NOT NULL COMMENT '系统编号 ',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户名称 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `balAmt` varchar(20) DEFAULT NULL COMMENT '可用余额 ',
  `lockAmt` varchar(20) DEFAULT NULL COMMENT '冻结金额 ',
  `totalAmt` varchar(20) DEFAULT NULL COMMENT '总额 ',
  `first_recharge_time` varchar(20) DEFAULT NULL COMMENT '首次充值时间 ',
  `last_recharge_time` varchar(20) DEFAULT NULL COMMENT '最后充值时间 ',
  `cashAmt` varchar(20) DEFAULT NULL COMMENT '实充金额 ',
  `sendAmt` varchar(20) DEFAULT NULL COMMENT '赠送金额 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `grand_recharge_cashAmt` varchar(20) DEFAULT NULL COMMENT '累计实充金额 ',
  `grand_recharge_sendAmt` varchar(20) DEFAULT NULL COMMENT '累计赠送金额 ',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐户信息null';

-- ----------------------------
--  Table structure for `TB_ACCT_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ACCT_LOG`;
CREATE TABLE `TB_ACCT_LOG` (
  `id` varchar(50) NOT NULL COMMENT '单号 ',
  `userid` varchar(50) DEFAULT NULL COMMENT '用户系统编号 帐户基本信息',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户姓名 ',
  `ywCode` varchar(50) DEFAULT NULL COMMENT '业务编号 point:积分 amt：充值',
  `ywName` varchar(100) DEFAULT NULL COMMENT '业务类型 ',
  `tranCode` varchar(50) DEFAULT NULL COMMENT '交易编号 ',
  `tranName` varchar(100) DEFAULT NULL COMMENT '交易类型 ',
  `tranStatus` int(11) DEFAULT NULL COMMENT '交易状态 ',
  `tranAmt` varchar(20) DEFAULT NULL COMMENT '交易金额 ',
  `tranPoint` int(11) DEFAULT NULL COMMENT '交易积分 ',
  `tranTime` varchar(20) DEFAULT NULL COMMENT '交易时间 ',
  `tranDesc` varchar(255) DEFAULT NULL COMMENT '交易描述 ',
  `balAmt` varchar(20) DEFAULT NULL COMMENT '剩余金额 ',
  `balPoint` int(11) DEFAULT NULL COMMENT '剩余积分 ',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `cashAmt` varchar(20) DEFAULT '0' COMMENT '实充金额',
  `sendAmt` varchar(20) DEFAULT '0' COMMENT '赠送金额',
  `channelId` varchar(50) DEFAULT NULL COMMENT '渠道编号',
  `channel` varchar(100) DEFAULT NULL COMMENT '渠道',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号',
  `orgId` varchar(20) DEFAULT NULL COMMENT '机构编号',
  `orgName` varchar(20) DEFAULT NULL COMMENT '机构',
  `operatorCode` varchar(50) DEFAULT NULL COMMENT '操作人编号',
  `operatorName` varchar(100) DEFAULT NULL COMMENT '操作人',
  `orderId` varchar(50) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易记录用户交易记录';

-- ----------------------------
--  Table structure for `TB_ACCT_POINT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ACCT_POINT`;
CREATE TABLE `TB_ACCT_POINT` (
  `userid` varchar(50) NOT NULL COMMENT '系统编号 ',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户姓名 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `grand_total_point` int(11) DEFAULT NULL COMMENT '累计积分 ',
  `balPoint` int(11) DEFAULT NULL COMMENT '可用积分 ',
  `first_point_time` varchar(20) DEFAULT NULL COMMENT '首次积分时间 ',
  `last_point_time` varchar(20) DEFAULT NULL COMMENT '最后积分时间 ',
  `lossPoint` int(11) DEFAULT NULL COMMENT '失效积分 ',
  `soonPoint` int(11) DEFAULT NULL COMMENT '即将失效积分 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户积分null';

-- ----------------------------
--  Table structure for `TB_ASSET_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ASSET_LOG`;
CREATE TABLE `TB_ASSET_LOG` (
  `id` varchar(50) NOT NULL COMMENT '主键 ',
  `userid` varchar(50) DEFAULT NULL COMMENT '用户ID ',
  `username` varchar(150) DEFAULT NULL COMMENT '用户名称 ',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号码 ',
  `tranType` int(11) DEFAULT NULL COMMENT '交易类型 0:支出 1:收入',
  `itemType` varchar(50) DEFAULT NULL COMMENT '交易项目编号 ',
  `itemName` varchar(150) DEFAULT NULL COMMENT '交易名称 ',
  `fromer` varchar(150) DEFAULT NULL COMMENT '支付方 ',
  `toer` varchar(150) DEFAULT NULL COMMENT '收款方 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `tranTime` varchar(50) DEFAULT NULL COMMENT '交易时间 ',
  `tranYear` varchar(50) DEFAULT NULL COMMENT '年份 ',
  `tranMonth` varchar(50) DEFAULT NULL COMMENT '月份 ',
  `idNo` varchar(50) DEFAULT NULL COMMENT '账号 ',
  `idName` varchar(150) DEFAULT NULL COMMENT '账户名称 ',
  `tranAmount` varchar(20) DEFAULT NULL COMMENT '交易金额元',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_AUTOCODE_ATTR`
-- ----------------------------
DROP TABLE IF EXISTS `TB_AUTOCODE_ATTR`;
CREATE TABLE `TB_AUTOCODE_ATTR` (
  `attrname` varchar(50) NOT NULL,
  `attrtype` varchar(50) DEFAULT NULL,
  `ispk` int(1) DEFAULT '0',
  `seq` varchar(50) DEFAULT NULL,
  `attrsize` int(4) DEFAULT NULL,
  `attrdesc` varchar(50) DEFAULT NULL,
  `idNo` varchar(50) NOT NULL,
  `sort` int(2) DEFAULT '0',
  `note` varchar(200) DEFAULT NULL,
  `isquery` varchar(50) DEFAULT NULL COMMENT '是否是查询字段 NO：不是 YES：是',
  PRIMARY KEY (`attrname`,`idNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_AUTOCODE_BEAN`
-- ----------------------------
DROP TABLE IF EXISTS `TB_AUTOCODE_BEAN`;
CREATE TABLE `TB_AUTOCODE_BEAN` (
  `beanname` varchar(50) DEFAULT NULL,
  `moduledesc` varchar(1024) DEFAULT NULL,
  `is_createtable` int(1) DEFAULT '0' COMMENT '0：不生成  1：生成',
  `createtime` datetime DEFAULT NULL,
  `is_auth` int(1) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `parentpackage` varchar(50) DEFAULT NULL,
  `description` varchar(350) DEFAULT NULL,
  `isauto` int(1) DEFAULT '1',
  `idNo` varchar(50) NOT NULL COMMENT '编号 主键',
  `tablename` varchar(50) NOT NULL COMMENT '表名',
  PRIMARY KEY (`idNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_FEE_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_FEE_LOG`;
CREATE TABLE `TB_FEE_LOG` (
  `id` varchar(50) NOT NULL COMMENT '单号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `feeCode` varchar(50) DEFAULT NULL COMMENT '科目编号 ',
  `feeName` varchar(150) DEFAULT NULL COMMENT '科目名称 ',
  `itemCode` varchar(50) DEFAULT NULL COMMENT '条目编号 ',
  `itemName` varchar(200) DEFAULT NULL COMMENT '条目名称 ',
  `tranTime` varchar(20) DEFAULT NULL COMMENT '交易时间 ',
  `tranAmt` varchar(20) DEFAULT NULL COMMENT '交易金额 ',
  `inOrOut` int(11) DEFAULT NULL COMMENT '收支 0:支出 1:收入',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注 ',
  `payeeName` varchar(100) DEFAULT NULL COMMENT '收款人 ',
  `payeeOrgId` varchar(50) DEFAULT NULL COMMENT '机构 ',
  `payeeOrgName` varchar(150) DEFAULT NULL COMMENT '机构 ',
  `payeeCode` varchar(50) DEFAULT NULL COMMENT '编号 ',
  `i_year` int(5) NOT NULL COMMENT '年 ',
  `i_month` int(2) NOT NULL COMMENT '月 ',
  `idNo` varchar(50) DEFAULT NULL COMMENT '关联单号 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `i_season` int(1) NOT NULL COMMENT '季度',
  `creator` varchar(120) DEFAULT NULL,
  `isDel` int(1) DEFAULT '0' COMMENT '是否可删除 0:不可删除 1:可删除',
  `tranDate` varchar(20) DEFAULT NULL COMMENT '交易日期',
  `salesManCode` varchar(50) DEFAULT NULL,
  `salesMan` varchar(100) DEFAULT NULL,
  `whMan` varchar(100) DEFAULT NULL,
  `whManCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`i_year`,`i_month`,`i_season`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用明细null';

-- ----------------------------
--  Table structure for `TB_FEE_TYPE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_FEE_TYPE`;
CREATE TABLE `TB_FEE_TYPE` (
  `typeId` varchar(50) NOT NULL COMMENT '科目 ',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '科目编号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `typeName` varchar(150) DEFAULT NULL COMMENT '科目名称 ',
  `inOrOut` int(11) DEFAULT NULL COMMENT '费用类型 0:支出 1:收入',
  `status` int(11) DEFAULT NULL COMMENT '启禁用 0:禁用 1:启用',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `updater` varchar(150) DEFAULT NULL COMMENT '更新者 ',
  `delFlag` int(11) DEFAULT NULL COMMENT '删除标识 0:不可删除 1:可删除',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用科目null';

-- ----------------------------
--  Table structure for `TB_IMAGE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_IMAGE`;
CREATE TABLE `TB_IMAGE` (
  `picid` varchar(50) NOT NULL,
  `picname` varchar(255) DEFAULT NULL,
  `picurl` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`picid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_ADVISE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_ADVISE`;
CREATE TABLE `TB_MALL_ADVISE` (
  `id` varchar(50) NOT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `label` varchar(512) DEFAULT NULL,
  `num` int(5) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_BRAND`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_BRAND`;
CREATE TABLE `TB_MALL_BRAND` (
  `BRANDID` varchar(50) NOT NULL,
  `BRANDNAME` varchar(150) DEFAULT NULL,
  `PICURL` varchar(250) DEFAULT NULL,
  `TYPEID` varchar(50) DEFAULT NULL,
  `TYPENAME` varchar(150) DEFAULT NULL,
  `CREATETIME` varchar(50) DEFAULT NULL,
  `UPDATETIME` varchar(50) DEFAULT NULL,
  `LOGO` varchar(50) DEFAULT NULL,
  `CREATOR` varchar(100) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`BRANDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_CATEGORY`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_CATEGORY`;
CREATE TABLE `TB_MALL_CATEGORY` (
  `typeId` varchar(50) NOT NULL,
  `typeName` varchar(150) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `parentId` varchar(50) DEFAULT NULL,
  `parentName` varchar(150) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `lvl1Id` varchar(50) DEFAULT NULL,
  `lvl1Name` varchar(150) DEFAULT NULL,
  `lvl2Id` varchar(50) DEFAULT NULL,
  `lvl2Name` varchar(150) DEFAULT NULL,
  `lvl3Id` varchar(50) DEFAULT NULL,
  `lvl3Name` varchar(150) DEFAULT NULL,
  `lvl4Id` varchar(50) DEFAULT NULL,
  `lvl4Name` varchar(50) DEFAULT NULL,
  `lvl5Id` varchar(50) DEFAULT NULL,
  `lvl5Name` varchar(150) DEFAULT NULL,
  `lvl` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `typeCode` varchar(50) DEFAULT NULL COMMENT '自编号',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_DISPATCH_GOOD`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_DISPATCH_GOOD`;
CREATE TABLE `TB_MALL_DISPATCH_GOOD` (
  `orderGoodId` varchar(50) NOT NULL COMMENT '商品单号 ',
  `orderId` varchar(50) DEFAULT NULL COMMENT '订单编号 ',
  `goodId` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodName` varchar(50) DEFAULT NULL COMMENT '商品名称 ',
  `barNo` varchar(50) DEFAULT NULL COMMENT '商品条码 ',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位 ',
  `rank` varchar(50) DEFAULT NULL COMMENT '规格 ',
  `model` varchar(50) DEFAULT NULL COMMENT '型号 ',
  `typeId` varchar(50) DEFAULT NULL COMMENT '品类编号 ',
  `typeName` varchar(50) DEFAULT NULL COMMENT '品类 ',
  `brandId` varchar(50) DEFAULT NULL COMMENT '品牌 ',
  `brandName` varchar(50) DEFAULT NULL COMMENT '品牌 ',
  `nums` int(11) DEFAULT NULL COMMENT '数量 ',
  `sendNums` int(11) DEFAULT NULL COMMENT '赠送数量 ',
  `purchaseNums` int(11) DEFAULT NULL COMMENT '采购数量 ',
  `costPrice` varchar(50) DEFAULT NULL COMMENT '采购价 ',
  `payPrice` varchar(50) DEFAULT NULL COMMENT '实购价 ',
  `amt` varchar(50) DEFAULT NULL COMMENT '小计 ',
  `payableAmt` varchar(50) DEFAULT NULL COMMENT '应付金额 ',
  `payAmt` varchar(50) DEFAULT NULL COMMENT '实付金额 ',
  `unpayAmt` varchar(50) DEFAULT NULL COMMENT '未付金额 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `stockType` int(11) DEFAULT NULL COMMENT '库存方式 ',
  `stockTypeName` varchar(100) DEFAULT NULL COMMENT '库存方式 ',
  `taxRate` int(4) DEFAULT NULL COMMENT '税率',
  `taxAmt` varchar(20) DEFAULT NULL COMMENT '税额',
  `salePrice` varchar(20) DEFAULT NULL COMMENT '售价',
  `saleAmt` varchar(20) DEFAULT NULL COMMENT '售价金额',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `hadReceiveNums` int(11) DEFAULT NULL COMMENT '已收数量',
  `hadDispatchNums` int(11) DEFAULT NULL COMMENT '已发数量',
  `hadRefundNums` int(11) DEFAULT '0' COMMENT '退货数量',
  `dispatchPrice` varchar(20) DEFAULT NULL COMMENT '配送价',
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orderGoodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购商品null';

-- ----------------------------
--  Table structure for `TB_MALL_DISPATCH_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_DISPATCH_INFO`;
CREATE TABLE `TB_MALL_DISPATCH_INFO` (
  `orderId` varchar(50) NOT NULL COMMENT '单号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `status` int(11) DEFAULT NULL COMMENT '单状态 ',
  `receiveOrgId` varchar(50) DEFAULT NULL COMMENT '要货门店 ',
  `receiveOrgName` varchar(150) DEFAULT NULL COMMENT '要货门店 ',
  `i_year` int(11) DEFAULT NULL COMMENT '年份 ',
  `i_month` int(11) DEFAULT NULL COMMENT '月份 ',
  `i_season` int(11) DEFAULT NULL COMMENT '季度 ',
  `commitTime` varchar(20) DEFAULT NULL COMMENT '下单时间 ',
  `cashDate` varchar(20) DEFAULT NULL COMMENT '下单日期 ',
  `totalAmt` varchar(20) DEFAULT NULL COMMENT '商品总额 ',
  `payableAmt` varchar(20) DEFAULT NULL COMMENT '应付金额 ',
  `payAmt` varchar(20) DEFAULT NULL COMMENT '实付金额 ',
  `unpayAmt` varchar(20) DEFAULT NULL COMMENT '未付金额 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `totalNums` int(11) DEFAULT NULL COMMENT '总数量 ',
  `salesAmt` varchar(20) DEFAULT NULL COMMENT '优惠金额 ',
  `sendNums` int(11) DEFAULT NULL COMMENT '赠送总数 ',
  `receiveNums` int(11) DEFAULT NULL COMMENT '收货数量 ',
  `dispatchNums` int(11) DEFAULT NULL COMMENT '配送数量 ',
  `sendOrgId` varchar(50) DEFAULT NULL COMMENT '发货门店 ',
  `sendOrgName` varchar(150) DEFAULT NULL COMMENT '发货门店 ',
  `applyManId` varchar(50) DEFAULT NULL COMMENT '申请人编号 ',
  `applyManCode` varchar(50) DEFAULT NULL COMMENT '申请人编号 ',
  `applyMan` varchar(50) DEFAULT NULL COMMENT '申请人 ',
  `sendContactor` varchar(100) DEFAULT NULL COMMENT '联系人 ',
  `sendContact` varchar(50) DEFAULT NULL COMMENT '联系电话 ',
  `checkStatus` int(11) DEFAULT NULL COMMENT '审核状态 ',
  `checkTime` varchar(50) DEFAULT NULL COMMENT '审核时间 ',
  `checkCode` varchar(50) DEFAULT NULL COMMENT '审核人 ',
  `checker` varchar(100) DEFAULT NULL COMMENT '审核人 ',
  `ywCode` varchar(50) DEFAULT NULL COMMENT '业务编号 ',
  `ywName` varchar(50) DEFAULT NULL COMMENT '业务名称 ',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '类别编号 ',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类别 ',
  `statusName` varchar(50) DEFAULT NULL COMMENT '状态名称 ',
  `checkStatusName` varchar(50) DEFAULT NULL COMMENT '审核状态 ',
  `creatorCode` varchar(50) DEFAULT NULL COMMENT '制单人编号',
  `creator` varchar(100) DEFAULT NULL COMMENT '制单人',
  `deadlineDate` varchar(50) DEFAULT NULL COMMENT '交货期限',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `refundNums` int(11) DEFAULT '0' COMMENT '退货数量',
  `oldOrderId` varchar(50) DEFAULT NULL COMMENT '原订单',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购单null';

-- ----------------------------
--  Table structure for `TB_MALL_GOOD_IMG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_GOOD_IMG`;
CREATE TABLE `TB_MALL_GOOD_IMG` (
  `id` varchar(50) NOT NULL,
  `goodid` varchar(50) DEFAULT NULL,
  `imgtype` int(1) DEFAULT NULL COMMENT '图片类型  1：主图  2：详图',
  `imgurl` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `sort` int(2) DEFAULT NULL COMMENT '排序',
  `imgname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_GOOD_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_GOOD_INFO`;
CREATE TABLE `TB_MALL_GOOD_INFO` (
  `goodid` varchar(50) NOT NULL COMMENT '系统编号',
  `goodname` varchar(1024) DEFAULT NULL,
  `tradePrice` varchar(30) DEFAULT NULL COMMENT '批发价',
  `unit` varchar(50) DEFAULT NULL,
  `imageurl` varchar(1024) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `brandName` varchar(150) DEFAULT NULL,
  `madein` varchar(150) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `onsale_status` int(2) DEFAULT '2' COMMENT '上架状态  1：上架  2：未上架  3：下架 ',
  `onsale_time` datetime DEFAULT NULL,
  `weight` varchar(50) DEFAULT NULL,
  `weight_unit` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL COMMENT '组织ID',
  `updater` varchar(250) DEFAULT NULL,
  `brandId` varchar(50) DEFAULT NULL,
  `rank` varchar(50) DEFAULT NULL COMMENT '规格',
  `model` varchar(50) DEFAULT NULL COMMENT '型号',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `barNo` varchar(50) DEFAULT NULL COMMENT '商品条码',
  `salePrice` varchar(30) DEFAULT NULL COMMENT '售价',
  `minPrice` varchar(30) DEFAULT NULL COMMENT '最低价',
  `typeId` varchar(50) DEFAULT NULL COMMENT '品类ID',
  `typeName` varchar(120) DEFAULT NULL COMMENT '类目',
  `goodType` int(1) DEFAULT '0' COMMENT '商品类型 0:商品 1:赠品和商品 2:赠品',
  `stockManageType` int(2) DEFAULT '0' COMMENT '库存管理方式 0:一瓶一码 1:数量管理',
  `costPrice` varchar(30) DEFAULT NULL COMMENT '进货价',
  `supplierId` varchar(50) DEFAULT NULL COMMENT '供应商ID',
  `supplier` varchar(120) DEFAULT NULL COMMENT '供应商',
  `validDays` int(10) DEFAULT '0' COMMENT '保质期 天',
  `isWarnDays` int(1) DEFAULT '0' COMMENT '是否提醒 1:提醒 0:不提醒',
  `beforeWarnDays` int(10) DEFAULT '0' COMMENT '提前提醒天数',
  `point` int(10) DEFAULT '0' COMMENT '可积分',
  `needPoint` int(10) DEFAULT '0' COMMENT '兑换积分',
  `vipPrice` varchar(20) DEFAULT NULL COMMENT '会员价',
  `materialType` int(1) DEFAULT NULL COMMENT '类型 0:实物商品,1:虚拟商品',
  `materialTypeName` varchar(100) DEFAULT NULL COMMENT '类型 0:实物商品,1:虚拟商品',
  `helpCode` varchar(50) DEFAULT NULL COMMENT '助记码',
  `dispatchPrice` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`goodid`),
  KEY `idx_tb_mall_good_info_brandId` (`brandId`),
  KEY `idx_tb_mall_good_info_typeid` (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_GOOD_PRICE_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_GOOD_PRICE_LOG`;
CREATE TABLE `TB_MALL_GOOD_PRICE_LOG` (
  `id` varchar(50) NOT NULL COMMENT '主键 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `salePrice` varchar(20) DEFAULT NULL COMMENT '售价 ',
  `vipPrice` varchar(20) DEFAULT NULL COMMENT '会员价 ',
  `dispatchPrice` varchar(20) DEFAULT NULL COMMENT '配送价 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `shopId` varchar(50) DEFAULT NULL COMMENT '门店编号 ',
  `shopName` varchar(100) DEFAULT NULL COMMENT '门店名称 ',
  `goodName` varchar(255) DEFAULT NULL COMMENT '商品名称 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `goodId` varchar(20) DEFAULT NULL COMMENT '商品ID ',
  `tradePrice` varchar(20) DEFAULT NULL COMMENT '批发价 ',
  `minPrice` varchar(20) DEFAULT NULL COMMENT '最低价 ',
  `costPrice` varchar(20) DEFAULT NULL COMMENT '进货价 ',
  `batchId` varchar(50) DEFAULT NULL COMMENT '批次编号 ',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者 ',
  `creatorCode` varchar(50) DEFAULT NULL COMMENT '创建编号 ',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注 ',
  `checkStatus` int(11) DEFAULT NULL COMMENT '审核状态 ',
  `checkerCode` varchar(50) DEFAULT NULL COMMENT '审核人编号 ',
  `checker` varchar(50) DEFAULT NULL COMMENT '审核人 ',
  `checkTime` varchar(20) DEFAULT NULL COMMENT '审核时间 ',
  `typeCode` int(11) DEFAULT NULL COMMENT '类型编号 ',
  `typeName` varchar(50) DEFAULT NULL COMMENT '类型 ',
  `onsale_status` int(11) DEFAULT NULL COMMENT '上下架 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调价单门店商品价格修改日志';

-- ----------------------------
--  Table structure for `TB_MALL_GOOD_SHOP`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_GOOD_SHOP`;
CREATE TABLE `TB_MALL_GOOD_SHOP` (
  `goodShopId` varchar(50) NOT NULL COMMENT '主键 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `salePrice` varchar(20) DEFAULT NULL COMMENT '售价 ',
  `vipPrice` varchar(20) DEFAULT NULL COMMENT '会员价 ',
  `dispatchPrice` varchar(20) DEFAULT NULL COMMENT '配送价 ',
  `onsale_status` int(11) DEFAULT NULL COMMENT '上下架 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `shopId` varchar(50) DEFAULT NULL COMMENT '门店编号 ',
  `shopName` varchar(100) DEFAULT NULL COMMENT '门店名称 ',
  `goodName` varchar(255) DEFAULT NULL COMMENT '商品名称 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  PRIMARY KEY (`goodShopId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店商品门店商品';

-- ----------------------------
--  Table structure for `TB_MALL_GOOD_TAG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_GOOD_TAG`;
CREATE TABLE `TB_MALL_GOOD_TAG` (
  `tagId` varchar(50) NOT NULL COMMENT '标签ID ',
  `tagName` varchar(50) DEFAULT NULL COMMENT '标签 ',
  `picUrl` varchar(150) DEFAULT NULL COMMENT '图片 ',
  `typeId` varchar(50) DEFAULT NULL COMMENT '品类ID ',
  `typeName` varchar(150) DEFAULT NULL COMMENT '品类 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `logo` varchar(50) DEFAULT NULL COMMENT 'logo ',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司ID ',
  `status` int(11) DEFAULT NULL COMMENT '启禁用 0:禁用。1启动',
  `tagType` int(11) DEFAULT NULL COMMENT '标签类别 0:价格 1:年龄段',
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_ORDER_GOOD`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_ORDER_GOOD`;
CREATE TABLE `TB_MALL_ORDER_GOOD` (
  `orderGoodId` varchar(50) NOT NULL COMMENT '订单商品编号 ',
  `orderId` varchar(50) DEFAULT NULL COMMENT '订单编号 ',
  `goodId` varchar(50) DEFAULT NULL COMMENT '商品系统编号 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodName` varchar(255) DEFAULT NULL COMMENT '商品名称 ',
  `barNo` varchar(50) DEFAULT NULL COMMENT '商品条码 ',
  `picUrl` varchar(255) DEFAULT NULL COMMENT '列表图片 ',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位 ',
  `rank` varchar(50) DEFAULT NULL COMMENT '规格 ',
  `typeId` varchar(50) DEFAULT NULL COMMENT '类别编号 ',
  `typeName` varchar(150) DEFAULT NULL COMMENT '类别名称 ',
  `brandId` varchar(50) DEFAULT NULL COMMENT '品牌编号 ',
  `brandName` varchar(150) DEFAULT NULL COMMENT '品牌名称 ',
  `nums` int(11) DEFAULT NULL COMMENT '数量 ',
  `salePrice` varchar(50) DEFAULT NULL COMMENT '通用售价 ',
  `payableAmt` varchar(50) DEFAULT NULL COMMENT '应付金额 ',
  `payAmt` varchar(50) DEFAULT NULL COMMENT '实付金额 ',
  `cashAmt` varchar(20) DEFAULT NULL COMMENT '现金金额 ',
  `wxAmt` varchar(20) DEFAULT NULL COMMENT '微信金额 ',
  `alipayAmt` varchar(20) DEFAULT NULL COMMENT '支付宝金额 ',
  `otherAmt` varchar(20) DEFAULT NULL COMMENT '其他金额 ',
  `salesAmt` varchar(50) DEFAULT NULL COMMENT '促销金额 ',
  `discountAmt` varchar(50) DEFAULT NULL COMMENT '折扣金额 ',
  `fullCutAmt` varchar(50) DEFAULT NULL COMMENT '满减金额 ',
  `couponAmt` varchar(50) DEFAULT NULL COMMENT '优惠券金额 ',
  `pointAmt` varchar(50) DEFAULT NULL COMMENT '积分抵扣金额 ',
  `mlAmt` varchar(50) DEFAULT NULL COMMENT '抹零金额 ',
  `simpleDiscountAmt` varchar(50) DEFAULT NULL COMMENT '议价金额 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `costAmt` varchar(50) DEFAULT NULL COMMENT '进货金额 ',
  `costPrice` varchar(30) DEFAULT NULL COMMENT '进货价 ',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `salePriceAmt` varchar(20) DEFAULT NULL COMMENT '计算金额',
  `payRate` varchar(20) DEFAULT NULL COMMENT '支付占比',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号',
  `lvl1Id` varchar(50) DEFAULT NULL COMMENT '一级类别',
  `lvl1Name` varchar(150) DEFAULT NULL COMMENT '一级类别',
  `lvl2Id` varchar(50) DEFAULT NULL COMMENT '二级类别',
  `lvl2Name` varchar(150) DEFAULT NULL COMMENT '二级类别',
  `lvl3Id` varchar(50) DEFAULT NULL COMMENT '三级类别',
  `lvl3Name` varchar(150) DEFAULT NULL COMMENT '三级类别',
  `lvl4Id` varchar(50) DEFAULT NULL COMMENT '四级类别',
  `lvl4Name` varchar(150) DEFAULT NULL COMMENT '四级类别',
  `lvl5Id` varchar(50) DEFAULT NULL COMMENT '五级类别',
  `lvl5Name` varchar(150) DEFAULT NULL COMMENT '五级类别',
  `nowPrice` varchar(20) DEFAULT NULL COMMENT '售价',
  `nowPriceAmt` varchar(20) DEFAULT NULL COMMENT '现价金额',
  `usePoint` int(10) DEFAULT '0' COMMENT '扣减积分',
  `point` int(10) DEFAULT '0' COMMENT '可积积分',
  `goodManDiscountAmt` varchar(20) DEFAULT '0' COMMENT '单品人工议价金额',
  `storedAmt` varchar(20) DEFAULT NULL COMMENT '储值卡支付金额',
  `recevieAmt` varchar(20) DEFAULT NULL COMMENT '收款金额',
  `payPrice` varchar(20) DEFAULT NULL COMMENT '成交价',
  `helpCode` varchar(50) DEFAULT NULL,
  `hadRefundAmt` varchar(20) DEFAULT NULL,
  `hadRefundNums` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `oldOrderGoodId` varchar(50) DEFAULT NULL,
  `balStockNums` int(11) DEFAULT NULL,
  `balStockAmt` varchar(20) DEFAULT NULL,
  `companyName` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `sendNums` int(10) DEFAULT NULL COMMENT '赠送数量',
  `sendAmt` varchar(20) DEFAULT NULL,
  `payNums` int(10) DEFAULT NULL,
  PRIMARY KEY (`orderGoodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品订单商品';

-- ----------------------------
--  Table structure for `TB_MALL_ORDER_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_ORDER_INFO`;
CREATE TABLE `TB_MALL_ORDER_INFO` (
  `orderId` varchar(50) NOT NULL COMMENT '订单编号 ',
  `orderStatus` int(11) DEFAULT NULL COMMENT '订单状态 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `orgId` varchar(50) DEFAULT NULL COMMENT '机构编号 ',
  `orgName` varchar(150) DEFAULT NULL COMMENT '机构名称 ',
  `areaId` varchar(50) DEFAULT NULL COMMENT '区域编号 ',
  `areaName` varchar(150) DEFAULT NULL COMMENT '区域名称 ',
  `i_year` int(5) DEFAULT NULL COMMENT '年份 ',
  `i_month` int(2) DEFAULT NULL COMMENT '月份 ',
  `i_season` int(1) DEFAULT NULL COMMENT '季度 ',
  `commitTime` varchar(30) DEFAULT NULL COMMENT '下单时间 ',
  `cashDate` varchar(20) DEFAULT NULL COMMENT '收银日期 ',
  `payableAmt` varchar(20) DEFAULT NULL COMMENT '小计总额',
  `payAmt` varchar(20) DEFAULT NULL COMMENT '实付金额 ',
  `salesAmt` varchar(20) DEFAULT NULL COMMENT '促销总额 ',
  `discountAmt` varchar(20) DEFAULT NULL COMMENT '折扣总额 ',
  `fullCutAmt` varchar(20) DEFAULT NULL COMMENT '满减总额 ',
  `couponAmt` varchar(20) DEFAULT NULL COMMENT '优惠券金额 ',
  `malingAmt` varchar(20) DEFAULT NULL COMMENT '抹零金额 ',
  `simpleDiscountAmt` varchar(20) DEFAULT NULL COMMENT '议价总额 ',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注 ',
  `payTypeCode` varchar(50) DEFAULT NULL COMMENT '支付方式编号 ',
  `payTypeName` varchar(100) DEFAULT NULL COMMENT '支付方式名称 ',
  `cashAmt` varchar(20) DEFAULT NULL COMMENT '现金金额 ',
  `wxAmt` varchar(50) DEFAULT NULL COMMENT '微信金额 ',
  `alipayAmt` varchar(50) DEFAULT NULL COMMENT '支付宝金额 ',
  `otherAmt` varchar(50) DEFAULT NULL COMMENT '其他金额 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `payStatus` int(11) DEFAULT NULL COMMENT '支付状态 ',
  `cashType` varchar(50) DEFAULT NULL COMMENT '业务编号 ',
  `cashTypeName` varchar(150) DEFAULT NULL COMMENT '业务名称 ',
  `pointAmt` varchar(50) DEFAULT NULL COMMENT '积分抵扣金额 ',
  `point` int(11) DEFAULT NULL COMMENT '积分 ',
  `cashManId` varchar(50) DEFAULT NULL COMMENT '收银员编号 ',
  `cashMan` varchar(50) DEFAULT NULL COMMENT '收银员名称 ',
  `guiderId` varchar(50) DEFAULT NULL COMMENT '导购员编号 ',
  `guiderName` varchar(50) DEFAULT NULL COMMENT '导购员名称 ',
  `vipId` varchar(50) DEFAULT NULL COMMENT '会员编号 ',
  `vipName` varchar(50) DEFAULT NULL COMMENT '会员名称 ',
  `vipMobile` varchar(50) DEFAULT NULL COMMENT '会员手机号 ',
  `receiveTel` varchar(50) DEFAULT NULL COMMENT '收货手机号 ',
  `receiver` varchar(50) DEFAULT NULL COMMENT '收货人 ',
  `receiveAddr` varchar(50) DEFAULT NULL COMMENT '收货地址 ',
  `orderStatusName` varchar(100) DEFAULT NULL COMMENT '订单状态名称 ',
  `costAmt` varchar(50) DEFAULT NULL COMMENT '进货金额 ',
  `nums` int(11) DEFAULT NULL COMMENT '数量 ',
  `salePriceAmt` varchar(20) DEFAULT NULL COMMENT '计算总额',
  `ywType` varchar(20) DEFAULT NULL COMMENT '业务类型',
  `ywName` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `nowPriceAmt` varchar(20) DEFAULT NULL COMMENT '现价金额',
  `cashManCode` varchar(50) DEFAULT NULL COMMENT '收银员编号',
  `guiderCode` varchar(50) DEFAULT NULL COMMENT '导购编号',
  `vipCode` varchar(50) DEFAULT NULL COMMENT '会员编号',
  `usePoint` int(10) DEFAULT '0' COMMENT '扣减积分',
  `storedAmt` varchar(20) DEFAULT NULL COMMENT '储值卡支付金额',
  `recevieAmt` varchar(20) DEFAULT NULL COMMENT '收款金额',
  `payingAmt` varchar(20) DEFAULT NULL COMMENT '应付金额',
  `hadRefundNums` int(11) DEFAULT NULL,
  `hadRefundAmt` varchar(20) DEFAULT NULL,
  `channelId` varchar(50) DEFAULT NULL,
  `channel` varchar(100) DEFAULT NULL,
  `oldOrderId` varchar(50) DEFAULT NULL,
  `companyName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单管理订单信息';

-- ----------------------------
--  Table structure for `TB_MALL_STOCK`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_STOCK`;
CREATE TABLE `TB_MALL_STOCK` (
  `stockId` varchar(50) NOT NULL COMMENT '库存编号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `orgId` varchar(50) DEFAULT NULL COMMENT '机构编号 ',
  `orgName` varchar(50) DEFAULT NULL COMMENT '机构名称 ',
  `goodId` varchar(50) DEFAULT NULL COMMENT '商品系统编号 ',
  `stockNums` int(11) DEFAULT NULL COMMENT '库存数量 ',
  `stockAmount` varchar(50) DEFAULT NULL COMMENT '库存金额 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `secondNums` int(11) DEFAULT NULL COMMENT '次品数量 ',
  `secondAmount` varchar(50) DEFAULT NULL COMMENT '次品金额 ',
  `holdNums` int(11) DEFAULT NULL COMMENT '预占数量 ',
  `holdAmount` varchar(50) DEFAULT NULL COMMENT '预占金额 ',
  `scrapNums` int(10) DEFAULT NULL COMMENT '报废数量 ',
  `scrapAmount` varchar(50) DEFAULT NULL COMMENT '报废金额 ',
  `giftNums` int(10) DEFAULT NULL COMMENT '赠品数量 ',
  `giftAmount` varchar(50) DEFAULT NULL COMMENT '赠品金额 ',
  `totalNums` int(10) DEFAULT NULL COMMENT '总数量 库存 预占 赠品，不含残次品、报废商品',
  `totalAmount` varchar(50) DEFAULT NULL COMMENT '总金额 库存 预占 赠品，不含残次品、报废商品',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `barNo` varchar(30) DEFAULT NULL COMMENT '商品条码',
  `goodName` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `saleAmt` varchar(20) DEFAULT NULL COMMENT '售出金额',
  `saleNums` int(10) DEFAULT NULL COMMENT '售出数量',
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_STOCK_ADJUST_GOOD`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_STOCK_ADJUST_GOOD`;
CREATE TABLE `TB_MALL_STOCK_ADJUST_GOOD` (
  `orderGoodId` varchar(50) NOT NULL COMMENT '主键 ',
  `orderId` varchar(50) DEFAULT NULL COMMENT '单号 ',
  `goodId` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodName` varchar(250) DEFAULT NULL COMMENT '商品名称 ',
  `barNo` varchar(50) DEFAULT NULL COMMENT '商品条码 ',
  `helpCode` varchar(50) DEFAULT NULL COMMENT '助记码 ',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位 ',
  `rank` varchar(50) DEFAULT NULL COMMENT '规格 ',
  `model` varchar(50) DEFAULT NULL COMMENT '型号 ',
  `typeId` varchar(50) DEFAULT NULL COMMENT '类别 ',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类别 ',
  `brandId` varchar(50) DEFAULT NULL COMMENT '品牌 ',
  `brandName` varchar(100) DEFAULT NULL COMMENT '品牌 ',
  `nums` int(11) DEFAULT NULL COMMENT '数量 ',
  `costPrice` varchar(20) DEFAULT NULL COMMENT '进价 ',
  `stockType` int(11) DEFAULT NULL COMMENT '库存管理方式 ',
  `stockTypeName` varchar(50) DEFAULT NULL COMMENT '库存管理方式 ',
  `dispatchPrice` varchar(20) DEFAULT NULL COMMENT '配送价 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orderGoodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调整商品null';

-- ----------------------------
--  Table structure for `TB_MALL_STOCK_ADJUST_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_STOCK_ADJUST_INFO`;
CREATE TABLE `TB_MALL_STOCK_ADJUST_INFO` (
  `orderId` varchar(50) NOT NULL COMMENT '单号 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `orgId` varchar(50) DEFAULT NULL COMMENT '机构编号 ',
  `orgName` varchar(100) DEFAULT NULL COMMENT '机构名称 ',
  `totalNums` int(11) DEFAULT NULL COMMENT '总数量 ',
  `totalAmt` varchar(20) DEFAULT NULL COMMENT '总金额 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `creatorCode` varchar(50) DEFAULT NULL COMMENT '制单人编号 ',
  `creatorName` varchar(100) DEFAULT NULL COMMENT '制单人 ',
  `createDate` varchar(50) DEFAULT NULL COMMENT '创建日期 ',
  `status` int(11) DEFAULT NULL COMMENT '单状态 ',
  `checkStatus` int(11) DEFAULT NULL COMMENT '审核状态 ',
  `checkerId` varchar(50) DEFAULT NULL COMMENT '审核人 ',
  `checker` varchar(100) DEFAULT NULL COMMENT '审核人 ',
  `checkTime` varchar(50) DEFAULT NULL COMMENT '审核时间 ',
  `ywCode` varchar(50) DEFAULT NULL COMMENT '业务类型 ',
  `ywName` varchar(100) DEFAULT NULL COMMENT '业务类型 ',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '类别 ',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类别 ',
  `companyId` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存调整单null';

-- ----------------------------
--  Table structure for `TB_MALL_STOCK_BATCH`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_STOCK_BATCH`;
CREATE TABLE `TB_MALL_STOCK_BATCH` (
  `batchId` varchar(50) NOT NULL COMMENT '批次号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `orgId` varchar(50) DEFAULT NULL COMMENT '机构编号 ',
  `orgName` varchar(150) DEFAULT NULL COMMENT '机构名称 ',
  `nums` int(11) DEFAULT NULL COMMENT '数量 ',
  `amount` varchar(50) DEFAULT NULL COMMENT '金额 ',
  `goodId` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `goodName` varchar(250) DEFAULT NULL COMMENT '商品名称 ',
  `goodNo` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `barNo` varchar(50) DEFAULT NULL COMMENT '国际条码 ',
  `stockType` int(11) DEFAULT NULL COMMENT '库存管理方式 ',
  `ywCode` int(11) DEFAULT NULL COMMENT '业务类型 ',
  `costPrice` varchar(50) DEFAULT NULL COMMENT '进货价 ',
  `productDate` varchar(50) DEFAULT NULL COMMENT '生产日期 ',
  `expireDate` varchar(50) DEFAULT NULL COMMENT '到期日期 ',
  `supplierId` varchar(50) DEFAULT NULL COMMENT '供应商编号 ',
  `supplierName` varchar(150) DEFAULT NULL COMMENT '供应商 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `updater` varchar(150) DEFAULT NULL COMMENT '更新者 ',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注 ',
  `saleNums` int(10) DEFAULT NULL COMMENT '售出数量',
  `saleAmount` varchar(20) DEFAULT NULL COMMENT '售出金额',
  `balNums` int(10) DEFAULT '0' COMMENT '剩余数量',
  `balAmt` varchar(20) DEFAULT NULL COMMENT '剩余金额',
  `stockId` varchar(50) DEFAULT NULL COMMENT '库存编号',
  `ywName` varchar(100) DEFAULT NULL,
  `operator` varchar(100) DEFAULT NULL,
  `tradePrice` varchar(20) DEFAULT NULL,
  `tradePriceAmt` varchar(20) DEFAULT NULL,
  `goodType` int(2) DEFAULT '0' COMMENT '商品类型',
  `goodTypeName` varchar(50) DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL COMMENT '收货单号',
  `stockBalAmt` varchar(20) DEFAULT NULL,
  `stockBalNums` int(11) DEFAULT NULL,
  `dispatchOutNums` int(10) DEFAULT NULL COMMENT '配送数量',
  `dispatchOutAmt` varchar(20) DEFAULT NULL,
  `outNums` int(11) DEFAULT NULL,
  `outAmt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`batchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_TRACE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_TRACE`;
CREATE TABLE `TB_MALL_TRACE` (
  `traceId` varchar(50) NOT NULL,
  `barcode` varchar(50) DEFAULT NULL,
  `goodId` varchar(50) DEFAULT NULL,
  `goodNo` varchar(50) DEFAULT NULL,
  `barNo` varchar(50) DEFAULT NULL,
  `goodName` varchar(512) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  `updatetime` varchar(50) DEFAULT NULL,
  `stockStatus` int(11) DEFAULT NULL,
  `cgNo` varchar(50) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `salePrice` varchar(30) DEFAULT NULL,
  `costPrice` varchar(30) DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL,
  `orderGoodId` varchar(50) DEFAULT NULL,
  `isGift` int(11) DEFAULT NULL,
  `oriTraceId` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `orgid` varchar(50) DEFAULT NULL,
  `orgname` varchar(150) DEFAULT NULL,
  `typeId` varchar(50) DEFAULT NULL,
  `typeName` varchar(150) DEFAULT NULL,
  `brandId` varchar(50) DEFAULT NULL,
  `brandName` varchar(150) DEFAULT NULL,
  `productDate` varchar(30) DEFAULT NULL,
  `supplierId` varchar(50) DEFAULT NULL,
  `supplierName` varchar(150) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `stockInDate` varchar(30) DEFAULT NULL,
  `endDate` varchar(30) DEFAULT NULL,
  `expireDate` varchar(20) DEFAULT NULL COMMENT '到期日期',
  `batchId` varchar(50) DEFAULT NULL COMMENT '批次号',
  PRIMARY KEY (`traceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_TRACE_BARCODE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_TRACE_BARCODE`;
CREATE TABLE `TB_MALL_TRACE_BARCODE` (
  `barcode` varchar(50) NOT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `goodId` varchar(50) DEFAULT NULL,
  `goodNo` varchar(50) DEFAULT NULL,
  `barNo` varchar(50) DEFAULT NULL,
  `goodName` varchar(512) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  `updatetime` varchar(50) DEFAULT NULL,
  `traceId` varchar(50) DEFAULT NULL,
  `activeStatus` int(1) DEFAULT NULL,
  `stockStatus` int(11) DEFAULT NULL,
  `orgid` varchar(50) DEFAULT NULL,
  `orgname` varchar(50) DEFAULT NULL,
  `productDate` varchar(50) DEFAULT NULL,
  `isWarnDays` int(1) DEFAULT '0',
  `beforeWarnDays` int(10) DEFAULT '0' COMMENT '提前天数',
  `expireDate` varchar(20) DEFAULT NULL COMMENT '过期日期',
  `batchId` varchar(50) DEFAULT NULL COMMENT '批次号',
  `typeId` varchar(50) DEFAULT NULL COMMENT '类别编号',
  `typeName` varchar(120) DEFAULT NULL COMMENT '类别',
  `brandId` varchar(50) DEFAULT NULL COMMENT '品牌编号',
  `brandName` varchar(120) DEFAULT NULL COMMENT '品牌',
  `costPrice` varchar(20) DEFAULT NULL COMMENT '进货价',
  `endDate` varchar(20) DEFAULT NULL COMMENT '结束时间',
  `price` varchar(20) DEFAULT NULL COMMENT '原价',
  `salePrice` varchar(20) DEFAULT NULL COMMENT '售价',
  `orderId` varchar(50) DEFAULT NULL COMMENT '订单号',
  `orderGoodId` varchar(50) DEFAULT NULL COMMENT '订单商品编号',
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(120) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_MALL_TRACE_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_MALL_TRACE_LOG`;
CREATE TABLE `TB_MALL_TRACE_LOG` (
  `id` varchar(50) NOT NULL,
  `traceId` varchar(50) DEFAULT NULL,
  `barCode` varchar(50) DEFAULT NULL,
  `goodId` varchar(50) DEFAULT NULL,
  `goodNo` varchar(50) DEFAULT NULL,
  `barNo` varchar(50) DEFAULT NULL,
  `goodName` varchar(500) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  `typeId` varchar(50) DEFAULT NULL,
  `typeName` varchar(150) DEFAULT NULL,
  `brandId` varchar(50) DEFAULT NULL,
  `brandName` varchar(150) DEFAULT NULL,
  `stockStatus` int(11) DEFAULT NULL,
  `operator` varchar(150) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `orgid` varchar(50) DEFAULT NULL,
  `orgname` varchar(150) DEFAULT NULL,
  `remarks` varchar(512) DEFAULT NULL,
  `batchId` varchar(50) DEFAULT NULL COMMENT '批次号',
  `operateCode` int(2) DEFAULT NULL COMMENT '操作代码',
  `operate` varchar(250) DEFAULT NULL COMMENT '操作内容',
  `nums` int(10) DEFAULT NULL COMMENT '数量',
  `amount` varchar(20) DEFAULT NULL COMMENT '金额',
  `goodType` int(2) DEFAULT NULL,
  `goodTypeName` varchar(50) DEFAULT NULL,
  `ywCode` int(2) DEFAULT NULL,
  `ywName` varchar(50) DEFAULT NULL,
  `balAmt` varchar(20) DEFAULT NULL,
  `balNums` int(11) DEFAULT NULL,
  `stockId` varchar(50) DEFAULT NULL COMMENT '库存编号',
  `stockBalAmt` varchar(20) DEFAULT NULL,
  `stockBalNums` int(11) DEFAULT NULL,
  `outAmt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_ORG_AREA`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ORG_AREA`;
CREATE TABLE `TB_ORG_AREA` (
  `areaId` varchar(50) NOT NULL,
  `areaName` varchar(150) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `lvl` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `parentId` varchar(50) DEFAULT NULL,
  `lvl1Id` varchar(50) DEFAULT NULL,
  `lvl1Name` varchar(150) DEFAULT NULL,
  `lvl2Id` varchar(50) DEFAULT NULL,
  `lvl2Name` varchar(150) DEFAULT NULL,
  `lvl3Id` varchar(50) DEFAULT NULL,
  `lvl3Name` varchar(150) DEFAULT NULL,
  `lvl4Id` varchar(50) DEFAULT NULL,
  `lvl4Name` varchar(150) DEFAULT NULL,
  `lvl5Id` varchar(50) DEFAULT NULL,
  `lvl5Name` varchar(150) DEFAULT NULL,
  `parentName` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_ORG_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_ORG_INFO`;
CREATE TABLE `TB_ORG_INFO` (
  `orgid` varchar(50) NOT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `orgname` varchar(256) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `useflag` int(1) DEFAULT '1',
  `parentid` varchar(50) DEFAULT '0',
  `lvl` int(1) DEFAULT '1',
  `companyid` varchar(50) DEFAULT NULL,
  `orgtype` int(1) DEFAULT '0',
  `ismain` int(1) DEFAULT '0',
  `childnum` int(4) DEFAULT '0',
  `logoid` varchar(50) DEFAULT NULL,
  `lvl2Id` varchar(50) DEFAULT NULL,
  `lvl2Name` varchar(120) DEFAULT NULL,
  `lvl3Id` varchar(50) DEFAULT NULL,
  `lvl4Id` varchar(50) DEFAULT NULL,
  `lvl5Id` varchar(50) DEFAULT NULL,
  `lvl6Id` varchar(50) DEFAULT NULL,
  `lvl3Name` varchar(120) DEFAULT NULL,
  `lvl4Name` varchar(120) DEFAULT NULL,
  `lvl5Name` varchar(120) DEFAULT NULL,
  `lvl6Name` varchar(120) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `linkman` varchar(120) DEFAULT NULL COMMENT '联系人',
  `linkTel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `orgCategory` int(1) DEFAULT '1' COMMENT '公司',
  `parentName` varchar(120) DEFAULT NULL,
  `checkStatus` int(11) DEFAULT '1' COMMENT '1',
  `checkerId` varchar(50) DEFAULT NULL,
  `checker` varchar(100) DEFAULT NULL,
  `checkTime` varchar(20) DEFAULT NULL,
  `orgCode` varchar(50) DEFAULT NULL,
  `provinceCode` varchar(50) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `cityCode` varchar(50) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `areaCode` varchar(50) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_PAY_ACCT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PAY_ACCT`;
CREATE TABLE `TB_PAY_ACCT` (
  `id` varchar(50) NOT NULL COMMENT '主键 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司ID ',
  `payTypeCode` varchar(50) DEFAULT NULL COMMENT '支付方式编号 OrderUtil中PayType枚举',
  `payType` varchar(150) DEFAULT NULL COMMENT '支付方式 ',
  `mch_id` varchar(50) DEFAULT NULL COMMENT '商户号 ',
  `key1` varchar(50) DEFAULT NULL COMMENT '密钥1 微信支付中的密钥',
  `key2` varchar(50) DEFAULT NULL COMMENT '密钥2 微信支付中的密码',
  `mch_name` varchar(150) DEFAULT NULL COMMENT '商户名 ',
  `keyStorePath` varchar(512) DEFAULT NULL COMMENT '证书文件路径 ',
  `accountId` varchar(50) DEFAULT NULL COMMENT '公众号ID ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `payTypeId` varchar(50) DEFAULT NULL COMMENT '支付方式主键 支付方式表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_PAY_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PAY_LOG`;
CREATE TABLE `TB_PAY_LOG` (
  `id` varchar(50) NOT NULL COMMENT '编号 ',
  `itemCode` varchar(50) DEFAULT NULL COMMENT '业务类型 ',
  `orderId` varchar(50) DEFAULT NULL COMMENT '订单编号 ',
  `itemName` varchar(150) DEFAULT NULL COMMENT '科目名称 ',
  `orderAmt` varchar(20) DEFAULT NULL COMMENT '订单金额 ',
  `cashAmt` varchar(20) DEFAULT NULL COMMENT '现金金额 ',
  `cardAmt` varchar(20) DEFAULT NULL COMMENT '刷卡金额 ',
  `alipayAmt` varchar(20) DEFAULT NULL COMMENT '支付宝金额 ',
  `wxpayAmt` varchar(20) DEFAULT NULL COMMENT '微信金额 ',
  `unionAmt` varchar(20) DEFAULT NULL COMMENT '银联支付金额 ',
  `depositAmt` varchar(20) DEFAULT NULL COMMENT '储值卡支付金额 ',
  `otherAmt` varchar(20) DEFAULT NULL COMMENT '其他支付金额 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `remarks` varchar(50) DEFAULT NULL COMMENT '备注 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_PROJECT_SALES_DETAIL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PROJECT_SALES_DETAIL`;
CREATE TABLE `TB_PROJECT_SALES_DETAIL` (
  `id` varchar(50) NOT NULL COMMENT 'ID ',
  `projectCode` varchar(50) DEFAULT NULL COMMENT '方案编号 ',
  `projectName` varchar(150) DEFAULT NULL COMMENT '方案名称 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `ywCode` int(11) DEFAULT NULL COMMENT '业务编号 ',
  `ywName` varchar(100) DEFAULT NULL COMMENT '业务名称 ',
  `typeCode` int(11) DEFAULT NULL COMMENT '类型编号 ',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类型名称 ',
  `isAward` int(11) DEFAULT NULL COMMENT '是否有奖品 0:无 1:有',
  `awardTypeCode` int(11) DEFAULT NULL COMMENT '奖品类型 ',
  `awardTypeName` varchar(50) DEFAULT NULL COMMENT '奖品类型 ',
  `itemCode` varchar(50) DEFAULT NULL COMMENT '奖项编号 ',
  `itemName` varchar(100) DEFAULT NULL COMMENT '奖项名称 ',
  `itemValue` varchar(50) DEFAULT NULL COMMENT '奖项值 ',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注 ',
  `idNo` varchar(50) DEFAULT NULL COMMENT '关联编号 ',
  `idName` varchar(150) DEFAULT NULL COMMENT '关联名称 ',
  `userId` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称 ',
  `roleType` varchar(50) DEFAULT NULL COMMENT '用户角色 ',
  `roleName` varchar(50) DEFAULT NULL COMMENT '用户角色 ',
  `userTel` varchar(50) DEFAULT NULL COMMENT '手机号码 ',
  `orgId` varchar(50) DEFAULT NULL COMMENT '机构编号 ',
  `orgName` varchar(50) DEFAULT NULL COMMENT '机构名称 ',
  `openid` varchar(50) DEFAULT NULL COMMENT 'OPENID ',
  `batchId` varchar(50) DEFAULT NULL COMMENT '批次号 ',
  `status` int(11) DEFAULT NULL COMMENT '状态 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `saleAmt` varchar(20) DEFAULT NULL COMMENT '销售金额 ',
  `costAmt` varchar(20) DEFAULT NULL COMMENT '成本金额 ',
  `receiveTel` varchar(50) DEFAULT NULL COMMENT '收货电话 ',
  `receiveUser` varchar(100) DEFAULT NULL COMMENT '收货人 ',
  `receiveAddr` varchar(500) DEFAULT NULL COMMENT '收货地址 ',
  `awardVal` varchar(50) DEFAULT NULL,
  `awardName` varchar(250) DEFAULT NULL,
  `awardCode` varchar(50) DEFAULT NULL,
  `itemTypeCode` int(2) DEFAULT NULL,
  `itemTypeName` varchar(200) DEFAULT NULL,
  `startDate` varchar(30) DEFAULT NULL,
  `endDate` varchar(30) DEFAULT NULL,
  `checkOrgId` varchar(50) DEFAULT NULL,
  `checkOrgName` varchar(100) DEFAULT NULL,
  `checkTime` varchar(30) DEFAULT NULL,
  `checkerCode` varchar(50) DEFAULT NULL,
  `checker` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销明细null';

-- ----------------------------
--  Table structure for `TB_PROJECT_SALES_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PROJECT_SALES_INFO`;
CREATE TABLE `TB_PROJECT_SALES_INFO` (
  `projectCode` varchar(50) NOT NULL COMMENT '方案编号 ',
  `projectName` varchar(255) DEFAULT NULL COMMENT '方案名称 ',
  `ywCode` int(11) DEFAULT NULL COMMENT '业务编号 ',
  `ywName` varchar(100) DEFAULT NULL COMMENT '业务名称 ',
  `typeCode` int(11) DEFAULT NULL COMMENT '类型编号 ',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类型名称 ',
  `startDate` varchar(20) DEFAULT NULL COMMENT '开始日期 ',
  `endDate` varchar(20) DEFAULT NULL COMMENT '结束日期 ',
  `intro` varchar(4000) DEFAULT NULL COMMENT '方案介绍 ',
  `daylimit` int(11) DEFAULT NULL COMMENT '每人每日限制数 ',
  `totallimit` int(11) DEFAULT NULL COMMENT '总限制数 ',
  `limitAreaFlag` int(11) DEFAULT NULL COMMENT '是否限制门店 ',
  `limitAreaCodes` varchar(3000) DEFAULT NULL COMMENT '门店编号 ',
  `limitAreaNames` varchar(4000) DEFAULT NULL COMMENT '门店名称 ',
  `limitGoodFlag` int(11) DEFAULT NULL COMMENT '是否限制商品 ',
  `limitGoodNos` varchar(50) DEFAULT NULL COMMENT '商品编号 ',
  `limitGoodNames` varchar(50) DEFAULT NULL COMMENT '商品名称 ',
  `projectVal` varchar(50) DEFAULT NULL COMMENT '方案值 如优惠券值',
  `useLimit` varchar(10) DEFAULT NULL COMMENT '使用条件 ',
  `sceneCode` int(11) DEFAULT NULL COMMENT '使用场景 ',
  `scene` varchar(50) DEFAULT NULL COMMENT '使用场景 ',
  `createtime` varchar(20) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `creator` varchar(150) DEFAULT NULL COMMENT '创建者 ',
  `updater` varchar(150) DEFAULT NULL COMMENT '更新者 ',
  `status` int(11) DEFAULT NULL COMMENT '状态 1:启用 0:禁用',
  `checkStatus` int(11) DEFAULT NULL COMMENT '审核状态 ',
  `checkTime` varchar(20) DEFAULT NULL COMMENT '审核时间 ',
  `checker` varchar(150) DEFAULT NULL COMMENT '审核者 ',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `pushLimit` varchar(10) DEFAULT NULL,
  `notJoinFlag` int(1) DEFAULT NULL,
  `notJoinGoodTypes` text,
  `notJoinBrands` text,
  `notJoinGoods` text,
  PRIMARY KEY (`projectCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='促销方案促销方案 促销信息 优惠券等';

-- ----------------------------
--  Table structure for `TB_PROJECT_SALES_ITEM`
-- ----------------------------
DROP TABLE IF EXISTS `TB_PROJECT_SALES_ITEM`;
CREATE TABLE `TB_PROJECT_SALES_ITEM` (
  `itemId` varchar(50) NOT NULL COMMENT '系统编号 ',
  `itemCode` varchar(50) DEFAULT NULL COMMENT '条目编号 ',
  `itemName` varchar(250) DEFAULT NULL COMMENT '条目名称 ',
  `limitNums` varchar(50) DEFAULT NULL COMMENT '限制数量 ',
  `itemTypeCode` int(11) DEFAULT NULL COMMENT '类型编号 0:折扣 1:赠送',
  `itemTypeName` varchar(50) DEFAULT NULL COMMENT '类型 ',
  `itemVal1` varchar(50) DEFAULT NULL COMMENT '条目值1 ',
  `itemVal2` varchar(50) DEFAULT NULL COMMENT '条目值2 ',
  `updatetime` varchar(30) DEFAULT NULL COMMENT '更新时间 ',
  `sort` int(11) DEFAULT NULL COMMENT '排序 ',
  `createtime` varchar(30) DEFAULT NULL COMMENT '创建时间 ',
  `projectCode` varchar(50) DEFAULT NULL COMMENT '方案编号 ',
  `projectName` varchar(250) DEFAULT NULL COMMENT '方案名称 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案条目方案细项';

-- ----------------------------
--  Table structure for `TB_SYS_CONF`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_CONF`;
CREATE TABLE `TB_SYS_CONF` (
  `ckey` varchar(50) NOT NULL,
  `cvalue` varchar(2000) DEFAULT NULL,
  `ckeyname` varchar(100) DEFAULT NULL,
  `companyid` varchar(50) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ckey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_DATADIR_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_DATADIR_INFO`;
CREATE TABLE `TB_SYS_DATADIR_INFO` (
  `ckey` varchar(50) NOT NULL,
  `parentkey` varchar(50) NOT NULL,
  `cvalue` varchar(200) DEFAULT NULL,
  `companyid` varchar(200) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ckey`,`parentkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_FUNC`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_FUNC`;
CREATE TABLE `TB_SYS_FUNC` (
  `funcid` varchar(50) NOT NULL,
  `menuid` varchar(50) NOT NULL,
  `operid` varchar(50) NOT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`funcid`),
  KEY `IDX_TB_SYS_FUNC_URL` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_LOG`;
CREATE TABLE `TB_SYS_LOG` (
  `id` varchar(50) NOT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `menuname` varchar(255) DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  `retain1` varchar(255) DEFAULT NULL,
  `retain2` varchar(1024) DEFAULT NULL,
  `retain3` varchar(255) DEFAULT NULL,
  `source` int(2) DEFAULT '0' COMMENT '来源0:内管，1消息中心 2：前端',
  `menuid` varchar(50) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_LOG_PARAM`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_LOG_PARAM`;
CREATE TABLE `TB_SYS_LOG_PARAM` (
  `url` varchar(250) NOT NULL,
  `source` int(2) NOT NULL DEFAULT '0',
  `menuname` varchar(255) DEFAULT NULL,
  `opername` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`url`,`source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_MENU`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_MENU`;
CREATE TABLE `TB_SYS_MENU` (
  `menuid` varchar(50) NOT NULL,
  `parentid` varchar(50) DEFAULT NULL,
  `menuitem` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `lvl` int(1) DEFAULT '3' COMMENT '级别',
  `lvl1Menuid` varchar(50) DEFAULT NULL,
  `lvl2Menuid` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '启禁用 1:启用 2:禁用',
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_OPERATE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_OPERATE`;
CREATE TABLE `TB_SYS_OPERATE` (
  `opername` varchar(50) NOT NULL,
  `operid` varchar(50) NOT NULL,
  `picicon` varchar(50) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`operid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_ROLE`;
CREATE TABLE `TB_SYS_ROLE` (
  `roleid` varchar(50) NOT NULL,
  `rolename` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `roleType` varchar(50) DEFAULT NULL,
  `companyid` varchar(50) DEFAULT NULL,
  `lvl` int(4) DEFAULT '0',
  `showflag` int(1) DEFAULT '1',
  `delFlag` int(1) DEFAULT '1' COMMENT '删除标识  1:可删除 0:不可删除',
  `orgId` varchar(50) DEFAULT NULL,
  `orgName` varchar(120) DEFAULT NULL,
  `roleYwType` int(2) DEFAULT '0' COMMENT '业务类型 0:系统角色  1:用户角色',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_SYS_ROLE_FUNC`
-- ----------------------------
DROP TABLE IF EXISTS `TB_SYS_ROLE_FUNC`;
CREATE TABLE `TB_SYS_ROLE_FUNC` (
  `roleid` varchar(50) NOT NULL,
  `funcid` varchar(50) NOT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleid`,`funcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_USER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER`;
CREATE TABLE `TB_USER` (
  `userid` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `bind_mobile` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL,
  `activeflag` int(1) NOT NULL DEFAULT '0',
  `createtime` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updatetime` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `companyid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `token` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
  `openid` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `roleId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skin` int(2) DEFAULT '0',
  `bindflag` int(1) DEFAULT '0',
  `accountid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `orgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '默认机构ID',
  `orgName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL,
  `hideFlag` int(1) DEFAULT '0' COMMENT '隐藏用户标识 0:不隐藏 1:隐藏',
  `orgType` int(2) DEFAULT NULL COMMENT '机构类型',
  `orgCategory` int(1) DEFAULT '1' COMMENT '机构分类',
  `roleName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL,
  `roleType` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户类型',
  `parentOrgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级机构编号',
  `parentOrgName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级机构名称',
  `roleLvl` int(2) DEFAULT NULL,
  `userCode` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` int(1) DEFAULT '0' COMMENT '0:未知 1:男 2:女',
  `birthday` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '生日',
  `signature` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '个性签名',
  `idNumber` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `email` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮件',
  `entryDate` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '入职日期',
  `channelId` varchar(50) COLLATE utf8mb4_bin DEFAULT 'manage' COMMENT '渠道',
  `channel` varchar(120) COLLATE utf8mb4_bin DEFAULT '管理端' COMMENT '渠道',
  `roleYwType` int(2) DEFAULT '0' COMMENT '系统用户',
  `userRoleOrgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限关联主键',
  `companyName` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `remarks` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
  `labels` text COLLATE utf8mb4_bin,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Table structure for `TB_USER_EXT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_EXT`;
CREATE TABLE `TB_USER_EXT` (
  `userid` varchar(50) NOT NULL COMMENT '系统编号 ',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号 ',
  `userName` varchar(150) DEFAULT NULL COMMENT '用户姓名 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `lvlId` varchar(50) DEFAULT NULL COMMENT '等级编号 ',
  `lvlName` varchar(100) DEFAULT NULL COMMENT '等级名称 ',
  `first_operate_time` varchar(20) DEFAULT NULL COMMENT '首次操作时间 ',
  `last_operate_time` varchar(20) DEFAULT NULL COMMENT '最后操作时间 ',
  `first_consume_time` varchar(20) DEFAULT NULL COMMENT '首次消费时间 ',
  `last_consume_time` varchar(20) DEFAULT NULL COMMENT '最后消费时间 ',
  `grand_total_point` int(11) DEFAULT NULL COMMENT '累计积分 ',
  `grand_total_consume_amt` varchar(20) DEFAULT NULL COMMENT '累计消费金额 ',
  `grand_total_consume_nums` int(11) DEFAULT NULL COMMENT '累计消费次数 ',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间 ',
  `lvl` int(2) DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展表记录用户扩展信息';

-- ----------------------------
--  Table structure for `TB_USER_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_LOG`;
CREATE TABLE `TB_USER_LOG` (
  `userid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL,
  `bind_mobile` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL,
  `activeflag` int(1) DEFAULT '0',
  `createtime` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updatetime` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `creator` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `companyid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `token` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
  `openid` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `roleId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `skin` int(2) DEFAULT '0',
  `bindflag` int(1) DEFAULT '0',
  `accountid` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `orgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '默认机构ID',
  `orgName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL,
  `hideFlag` int(1) DEFAULT '0' COMMENT '隐藏用户标识 0:不隐藏 1:隐藏',
  `orgType` int(2) DEFAULT NULL COMMENT '机构类型',
  `orgCategory` int(1) DEFAULT '1' COMMENT '机构分类',
  `roleName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL,
  `roleType` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户类型',
  `parentOrgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级机构编号',
  `parentOrgName` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级机构名称',
  `roleLvl` int(2) DEFAULT NULL,
  `userCode` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` int(1) DEFAULT '0' COMMENT '0:未知 1:男 2:女',
  `birthday` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '生日',
  `signature` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '个性签名',
  `idNumber` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `email` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮件',
  `entryDate` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '入职日期',
  `channelId` varchar(50) COLLATE utf8mb4_bin DEFAULT 'manage' COMMENT '渠道',
  `channel` varchar(120) COLLATE utf8mb4_bin DEFAULT '管理端' COMMENT '渠道',
  `roleYwType` int(2) DEFAULT '0' COMMENT '系统用户',
  `userRoleOrgId` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限关联主键',
  `companyName` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `remarks` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Table structure for `TB_USER_LVL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_LVL`;
CREATE TABLE `TB_USER_LVL` (
  `lvlId` varchar(50) NOT NULL COMMENT '等级编号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司ID ',
  `lvlName` varchar(150) DEFAULT NULL COMMENT '等级名称 ',
  `lvl` int(11) DEFAULT NULL COMMENT '等级 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新者 ',
  `delFlag` int(11) DEFAULT NULL COMMENT '是否可以删除标识 内部使用',
  `upPointFlag` int(11) DEFAULT NULL COMMENT '是否积分升级 ',
  `upPoint` int(11) DEFAULT NULL COMMENT '升级积分 ',
  `upAmtFlag` int(11) DEFAULT NULL COMMENT '是否金额升级 ',
  `upAmt` varchar(20) DEFAULT NULL COMMENT '升级金额 ',
  PRIMARY KEY (`lvlId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户等级用户等级';

-- ----------------------------
--  Table structure for `TB_USER_ORG_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_USER_ORG_ROLE`;
CREATE TABLE `TB_USER_ORG_ROLE` (
  `userid` varchar(50) NOT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  `roleId` varchar(50) NOT NULL,
  `roleName` varchar(120) DEFAULT NULL COMMENT '角色名称',
  `roleType` varchar(50) DEFAULT NULL COMMENT '用户类型',
  `roleLvl` int(2) DEFAULT NULL,
  `orgId` varchar(50) DEFAULT NULL,
  `orgName` varchar(120) DEFAULT NULL,
  `orgType` int(2) DEFAULT NULL,
  `orgCategory` int(1) DEFAULT NULL,
  `parentOrgId` varchar(50) DEFAULT NULL,
  `parentOrgName` varchar(120) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `userRoleOrgId` varchar(50) NOT NULL,
  PRIMARY KEY (`userRoleOrgId`),
  KEY `idx_user_org_role_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WORK`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WORK`;
CREATE TABLE `TB_WORK` (
  `workId` varchar(50) NOT NULL COMMENT '工作编号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `idNo` varchar(50) DEFAULT NULL COMMENT '主键 ',
  `applyManId` varchar(50) DEFAULT NULL COMMENT '申请人编号 ',
  `applyMan` varchar(150) DEFAULT NULL COMMENT '申请人 ',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '类型编号 ',
  `typeName` varchar(50) DEFAULT NULL COMMENT '类型名称 ',
  `nextStepId` varchar(50) DEFAULT NULL COMMENT '当前步骤编号 ',
  `nextStepName` varchar(50) DEFAULT NULL COMMENT '步骤名称 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `nextUserid` varchar(50) DEFAULT NULL COMMENT '下一步编号 ',
  `nextUsername` varchar(150) DEFAULT NULL COMMENT '下一步名称 ',
  `operatorStatus` int(11) DEFAULT NULL COMMENT '操作状态 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `currUserid` varchar(50) DEFAULT NULL COMMENT '当前操作人编号 ',
  `currUsername` varchar(150) DEFAULT NULL COMMENT '当前操作人 ',
  `pageUrl` varchar(512) DEFAULT NULL COMMENT '页面路径 ',
  `currRoleid` varchar(50) DEFAULT NULL COMMENT '当前角色编号 ',
  `nextRoleid` varchar(50) DEFAULT NULL COMMENT '下一步角色编号 ',
  `currRolename` varchar(150) DEFAULT NULL COMMENT '当前角色 ',
  `nextRolename` varchar(150) DEFAULT NULL COMMENT '下一步角色 ',
  `applyOrgId` varchar(50) DEFAULT NULL COMMENT '申请人所属机构编号 ',
  `applyOrgName` varchar(150) DEFAULT NULL COMMENT '申请人所属机构 ',
  `nextStep` int(2) DEFAULT '0',
  `idName` varchar(255) DEFAULT NULL COMMENT '业务名称',
  `nextDealType` int(2) DEFAULT '0' COMMENT '处理方式 0:按指定角色 1:按同级职位 2:按上级职位',
  `dealModel` int(1) DEFAULT NULL COMMENT '处理模式 同isAuto',
  PRIMARY KEY (`workId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WORK_STEP`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WORK_STEP`;
CREATE TABLE `TB_WORK_STEP` (
  `stepId` varchar(50) NOT NULL COMMENT '步骤编号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `wrokId` varchar(50) DEFAULT NULL COMMENT '工作流编号 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `step` varchar(50) DEFAULT NULL COMMENT '序号 ',
  `stepName` varchar(150) DEFAULT NULL COMMENT '步骤名称 ',
  `roleId` varchar(50) DEFAULT NULL COMMENT '角色编号 ',
  `roleName` varchar(150) DEFAULT NULL COMMENT '角色名称 ',
  `operatorId` varchar(50) DEFAULT NULL COMMENT '操作人编号 ',
  `operatorName` varchar(150) DEFAULT NULL COMMENT '操作人姓名 ',
  `endTime` varchar(50) DEFAULT NULL COMMENT '结束时间 ',
  `operateStatus` int(11) DEFAULT NULL COMMENT '操作状态 ',
  `operatorOrgId` varchar(50) DEFAULT NULL COMMENT '操作人机构编号 ',
  `operatorOrgName` varchar(150) DEFAULT NULL COMMENT '机构名称 ',
  `remarks` varchar(512) DEFAULT NULL COMMENT '备注 ',
  PRIMARY KEY (`stepId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WORK_TYPE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WORK_TYPE`;
CREATE TABLE `TB_WORK_TYPE` (
  `typeId` varchar(50) NOT NULL COMMENT '工作主键 ',
  `typeName` varchar(150) DEFAULT NULL COMMENT '工作名称 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '工作编号 ',
  `dbscheme` varchar(50) DEFAULT NULL COMMENT '数据库用户 ',
  `tbName` varchar(50) DEFAULT NULL COMMENT '数据库表名 ',
  `idField` varchar(50) DEFAULT NULL COMMENT '主键字段名 ',
  `checkField` varchar(50) DEFAULT NULL COMMENT '审核状态字段 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `updater` varchar(100) DEFAULT NULL COMMENT '更新人 ',
  `linkUrl` varchar(512) DEFAULT NULL COMMENT '链接 ',
  `isAuto` int(1) DEFAULT '0' COMMENT '系统处理 0:系统处理 1:自行处理',
  `classType` varchar(150) DEFAULT NULL COMMENT '类名 ',
  `checkerField` varchar(50) DEFAULT NULL,
  `checkerIdField` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WORK_TYPE_STEP`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WORK_TYPE_STEP`;
CREATE TABLE `TB_WORK_TYPE_STEP` (
  `stepId` varchar(50) NOT NULL COMMENT '步骤编号 ',
  `step` int(11) DEFAULT NULL COMMENT '步骤序号 ',
  `companyId` varchar(50) DEFAULT NULL COMMENT '公司编号 ',
  `stepName` varchar(150) DEFAULT NULL COMMENT '步骤名称 ',
  `roleId` varchar(50) DEFAULT NULL COMMENT '角色编号 ',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间 ',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间 ',
  `updater` varchar(100) DEFAULT NULL COMMENT '更新者 ',
  `typeId` varchar(50) DEFAULT NULL COMMENT '类别编号 ',
  `isCheckOk` int(11) DEFAULT NULL COMMENT '是否为审核通过 是否为审核通过 0:不是。1:是',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称 ',
  `dealType` varchar(1) DEFAULT NULL COMMENT '处理方式 0:按指定角色 1:按同级职位 2:按上级职位',
  PRIMARY KEY (`stepId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_ACCESS_TOKEN`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_ACCESS_TOKEN`;
CREATE TABLE `TB_WX_ACCESS_TOKEN` (
  `accountid` varchar(100) NOT NULL,
  `accesstoken` varchar(255) NOT NULL,
  `puttime` varchar(20) DEFAULT '0',
  `expires_in` varchar(20) DEFAULT '0',
  `updatetime` date DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_ACCOUNT`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_ACCOUNT`;
CREATE TABLE `TB_WX_ACCOUNT` (
  `accountid` varchar(50) NOT NULL,
  `accountname` varchar(100) DEFAULT NULL,
  `appid` varchar(50) DEFAULT NULL,
  `appsecret` varchar(100) DEFAULT NULL,
  `authdomain` varchar(300) DEFAULT NULL,
  `url` varchar(400) DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  `aeskey` varchar(50) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `server_context` varchar(50) DEFAULT NULL,
  `wx_acctno` varchar(100) DEFAULT NULL,
  `is_service` int(1) DEFAULT '0',
  `accttype` int(1) DEFAULT '0',
  `updatetime` date DEFAULT NULL,
  `orgid` varchar(50) DEFAULT NULL,
  `companyid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`accountid`),
  KEY `TB_WX_ACCOUNT_NAMEIDX` (`accountname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_AUTO_REPLAY`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_AUTO_REPLAY`;
CREATE TABLE `TB_WX_AUTO_REPLAY` (
  `ckey` varchar(200) DEFAULT NULL,
  `creplay` varchar(2000) DEFAULT NULL,
  `ctype` varchar(50) NOT NULL,
  `ctypename` varchar(100) DEFAULT NULL,
  `accountid` varchar(50) DEFAULT NULL,
  `replaytype` varchar(20) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `delflag` int(1) DEFAULT '1',
  `ckeyname` varchar(500) DEFAULT NULL,
  `itemType` int(2) DEFAULT NULL,
  `ckeyCode` int(10) DEFAULT NULL,
  `newsTxt` varchar(512) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ctype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_AUTO_REPLAY_NEWSITEM`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_AUTO_REPLAY_NEWSITEM`;
CREATE TABLE `TB_WX_AUTO_REPLAY_NEWSITEM` (
  `id` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `picurl` varchar(200) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `sort` int(10) DEFAULT NULL,
  `accountid` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_CHAT_MSG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_CHAT_MSG`;
CREATE TABLE `TB_WX_CHAT_MSG` (
  `id` varchar(50) NOT NULL,
  `c_type` int(1) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `c_content` varchar(2048) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `c_replaytype` varchar(50) DEFAULT NULL,
  `session_id` varchar(50) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `accountid` varchar(50) DEFAULT NULL,
  `is_replay` int(1) DEFAULT '0' COMMENT '是否回复 0：未回复 1：回复',
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_CHAT_SESSION`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_CHAT_SESSION`;
CREATE TABLE `TB_WX_CHAT_SESSION` (
  `session_id` varchar(50) NOT NULL,
  `accountid` varchar(50) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `createlong` int(10) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `c_content` varchar(2048) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT '0' COMMENT '0:回话 1：非回话',
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_MENU`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_MENU`;
CREATE TABLE `TB_WX_MENU` (
  `ID` varchar(32) NOT NULL,
  `PARENT_ID` varchar(32) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `TYPE` varchar(32) DEFAULT NULL,
  `CONTENT` varchar(1000) DEFAULT NULL,
  `SORT` int(2) DEFAULT '0',
  `ACCOUNTID` varchar(50) DEFAULT NULL,
  `LVL` int(1) DEFAULT '1',
  `MENUTYPE` int(2) DEFAULT NULL,
  `TAGID` varchar(20) DEFAULT NULL,
  `MENUID` varchar(50) DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_MENU_URL`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_MENU_URL`;
CREATE TABLE `TB_WX_MENU_URL` (
  `id` varchar(50) NOT NULL,
  `menuname` varchar(100) DEFAULT NULL,
  `menuurl` varchar(1000) DEFAULT NULL,
  `accountid` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_MODULE_MSG`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_MODULE_MSG`;
CREATE TABLE `TB_WX_MODULE_MSG` (
  `id` varchar(64) NOT NULL,
  `accountid` varchar(64) DEFAULT NULL,
  `template_id` varchar(64) DEFAULT NULL,
  `touser` varchar(64) DEFAULT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `data` varchar(2048) DEFAULT NULL,
  `needflag` int(1) DEFAULT '1',
  `sendflag` int(1) DEFAULT '0',
  `sendtimes` int(1) DEFAULT '0',
  `createtime` varchar(20) DEFAULT NULL,
  `sendtime` varchar(20) DEFAULT NULL,
  `msgid` varchar(64) DEFAULT NULL,
  `push_code` varchar(64) DEFAULT NULL,
  `push_msg` varchar(1024) DEFAULT NULL,
  `resultcode` varchar(64) DEFAULT NULL,
  `resultmsg` varchar(1024) DEFAULT NULL,
  `note` varchar(528) DEFAULT NULL,
  `resulttime` varchar(20) DEFAULT NULL,
  `create_stamp` int(10) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_QRCODE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_QRCODE`;
CREATE TABLE `TB_WX_QRCODE` (
  `id` varchar(50) NOT NULL,
  `qrno` varchar(50) DEFAULT NULL,
  `qrname` varchar(200) DEFAULT NULL,
  `qrtype` varchar(50) DEFAULT NULL,
  `qrurl` varchar(1024) DEFAULT NULL,
  `accountid` varchar(200) DEFAULT NULL,
  `qrpath` varchar(1024) DEFAULT NULL,
  `scenetype` int(1) DEFAULT '1',
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `companyid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_TAGS`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_TAGS`;
CREATE TABLE `TB_WX_TAGS` (
  `ID` varchar(50) DEFAULT NULL,
  `TAGID` int(10) NOT NULL,
  `NAME` varchar(150) DEFAULT NULL,
  `FANS_COUNT` int(10) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `UPDATETIME` datetime DEFAULT NULL,
  `UPDATER` varchar(150) DEFAULT NULL,
  `ACCOUNTID` varchar(50) NOT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TAGID`,`ACCOUNTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_TEMPLATE`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_TEMPLATE`;
CREATE TABLE `TB_WX_TEMPLATE` (
  `ywtype` varchar(36) NOT NULL,
  `accountid` varchar(36) NOT NULL,
  `template_id` varchar(50) DEFAULT NULL,
  `template_name` varchar(50) DEFAULT NULL,
  `first_content` varchar(50) DEFAULT NULL,
  `remark_content` varchar(1024) DEFAULT NULL,
  `detailurl` varchar(1024) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `createtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ywtype`,`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `TB_WX_USER`
-- ----------------------------
DROP TABLE IF EXISTS `TB_WX_USER`;
CREATE TABLE `TB_WX_USER` (
  `openid` varchar(50) NOT NULL,
  `nickname` varchar(256) DEFAULT NULL,
  `groupid` int(11) NOT NULL DEFAULT '0',
  `country` varchar(256) DEFAULT NULL,
  `province` varchar(256) DEFAULT NULL,
  `city` varchar(256) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `imageurl` varchar(1024) DEFAULT NULL,
  `language` varchar(32) DEFAULT NULL,
  `issubscribe` int(11) NOT NULL DEFAULT '1',
  `subscribetime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `accountid` varchar(50) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `useflag` int(11) DEFAULT '0',
  `qrno` varchar(50) DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  `dairyflag` int(1) DEFAULT '0',
  `companyId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`openid`,`accountid`),
  KEY `IDX_WX_USER_ISSUBSCRIBE` (`issubscribe`),
  KEY `IDX_WX_USER_NICKNAME` (`nickname`),
  KEY `IDX_WX_USER_SUBSCRIBETIME` (`subscribetime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_note_diary`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note_diary`;
CREATE TABLE `tb_note_diary` (
  `id` varchar(50) NOT NULL,
  `title` varchar(1024) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `content` mediumtext,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `tb_note_gains`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note_gains`;
CREATE TABLE `tb_note_gains` (
  `id` varchar(50) NOT NULL,
  `lvl` varchar(10) DEFAULT NULL,
  `lvlname` varchar(255) DEFAULT NULL,
  `title` varchar(512) DEFAULT NULL,
  `content` mediumtext,
  `labels` varchar(255) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `creator` varchar(155) DEFAULT NULL,
  `updater` varchar(155) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `tb_note_plan`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note_plan`;
CREATE TABLE `tb_note_plan` (
  `id` varchar(50) NOT NULL,
  `plantxt` varchar(4000) DEFAULT NULL,
  `completetxt` varchar(4000) DEFAULT NULL,
  `iscomplete` varchar(50) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `tb_note_question`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note_question`;
CREATE TABLE `tb_note_question` (
  `id` varchar(50) NOT NULL,
  `lvl` varchar(10) DEFAULT NULL,
  `lvlname` varchar(255) DEFAULT NULL,
  `question` varchar(512) DEFAULT NULL,
  `solution` varchar(2000) DEFAULT NULL,
  `labels` varchar(255) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `creator` varchar(155) DEFAULT NULL,
  `updater` varchar(155) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `tb_note_reminder`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note_reminder`;
CREATE TABLE `tb_note_reminder` (
  `id` varchar(50) NOT NULL,
  `remind_type` int(2) DEFAULT NULL COMMENT '0：普通 1：特殊日子',
  `calendar_type` int(1) DEFAULT '0' COMMENT '0:公历 1：农历',
  `remind_date` varchar(50) DEFAULT NULL,
  `remind_time` varchar(30) DEFAULT NULL,
  `is_repeat` int(1) DEFAULT '0' COMMENT '0：不重复 1：重复，默认不重复',
  `remind_content` varchar(200) DEFAULT NULL,
  `before_days` int(3) DEFAULT NULL,
  `is_before` int(1) DEFAULT '0' COMMENT '0：不提前 1：提前',
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  `creator` varchar(100) DEFAULT NULL,
  `needflag` int(1) DEFAULT '1' COMMENT '1:发送 0：不发送',
  `holiday_type` int(4) DEFAULT '0' COMMENT '特殊日子类型 1：生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Function structure for `getChildidList`
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildidList`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildidList`(rootId VARCHAR(32)) RETURNS text CHARSET utf8
BEGIN 
DECLARE sTemp text; 
DECLARE sTempChd text; 
SET@@group_concat_max_len = 102400; 
SET sTemp = '$'; 
SET sTempChd = rootId; 
 
WHILE sTempChd IS NOT NULL DO 
SET sTemp = concat(sTemp, ',', sTempChd); 
SELECT 
group_concat(orgid) INTO sTempChd 
FROM 
tb_org_info
WHERE 
FIND_IN_SET(PARENTID, sTempChd) > 0; 
END WHILE; 
SET@@group_concat_max_len = 1024; 
RETURN SUBSTRING(sTemp,3); 
END
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
