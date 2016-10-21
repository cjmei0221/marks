/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : 119.29.22.225
Source Server Version : 110200
Source Host           : 119.29.22.225:1521
Source Schema         : YSL_MEMBER

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-10-21 13:01:53
*/


-- ----------------------------
-- Table structure for WXB_MODULE_MSG
-- ----------------------------
DROP TABLE TB_WX_MODULE_MSG;
CREATE TABLE TB_WX_MODULE_MSG (
ID VARCHAR2(64 BYTE) NOT NULL ,
ACCOUNTID VARCHAR2(64 BYTE) NULL ,
TEMPLATE_ID VARCHAR2(64 BYTE) NULL ,
TOUSER VARCHAR2(64 BYTE) NULL ,
URL VARCHAR2(1024 BYTE) NULL ,
DATA VARCHAR2(2048 BYTE) NULL ,
NEEDFLAG NUMBER(1) DEFAULT 0  NULL ,
SENDFLAG NUMBER(1) DEFAULT 0  NULL ,
SENDTIMES NUMBER(1) DEFAULT 0  NULL ,
CREATETIME DATE NULL ,
SENDTIME DATE NULL ,
MSGID VARCHAR2(64 BYTE) NULL ,
PUSH_CODE VARCHAR2(64 BYTE) NULL ,
PUSH_MSG VARCHAR2(1024 BYTE) NULL ,
RESULTCODE VARCHAR2(64 BYTE) NULL ,
RESULTMSG VARCHAR2(1024 BYTE) NULL 
);

-- ----------------------------
-- Indexes structure for table WXB_MODULE_MSG
-- ----------------------------

-- ----------------------------
-- Checks structure for table WXB_MODULE_MSG
-- ----------------------------
ALTER TABLE TB_WX_MODULE_MSG ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table WXB_MODULE_MSG
-- ----------------------------
ALTER TABLE TB_WX_MODULE_MSG ADD PRIMARY KEY (ID);
