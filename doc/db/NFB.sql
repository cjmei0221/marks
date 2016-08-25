/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : 127.0.0.1
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : NFB

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-08-25 11:29:40
*/


-- ----------------------------
-- Table structure for TB_CUSTOMER_ADDR
-- ----------------------------
DROP TABLE "NFB"."TB_CUSTOMER_ADDR";
CREATE TABLE "NFB"."TB_CUSTOMER_ADDR" (
"ADDRID" VARCHAR2(50 BYTE) NOT NULL ,
"USERID" VARCHAR2(50 BYTE) NULL ,
"NAME" VARCHAR2(100 BYTE) NULL ,
"MOBILE" VARCHAR2(50 BYTE) NULL ,
"COON_ADDR" VARCHAR2(200 BYTE) NULL ,
"DEFAULTFLAG" NUMBER(1) DEFAULT 0  NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_CUSTOMER_ADDR
-- ----------------------------

-- ----------------------------
-- Table structure for TB_CUSTOMER_INFO
-- ----------------------------
DROP TABLE "NFB"."TB_CUSTOMER_INFO";
CREATE TABLE "NFB"."TB_CUSTOMER_INFO" (
"USERID" VARCHAR2(50 BYTE) NOT NULL ,
"MOBILE" VARCHAR2(50 BYTE) NULL ,
"PASSWD" VARCHAR2(50 BYTE) NULL ,
"UNAME" VARCHAR2(150 BYTE) NULL ,
"GLOBAL_TYPE" VARCHAR2(50 BYTE) DEFAULT 0  NULL ,
"GLOBAL_ID" VARCHAR2(30 BYTE) NULL ,
"HOME_PHONE" VARCHAR2(50 BYTE) NULL ,
"BIRTH_DATE" VARCHAR2(20 BYTE) NULL ,
"OPENID" VARCHAR2(50 BYTE) NULL ,
"ACTIVEFLAG" CHAR(1 BYTE) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"GENDER" VARCHAR2(2 BYTE) NULL ,
"LVL" VARCHAR2(2 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_CUSTOMER_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for TB_SYS_CONF
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_CONF";
CREATE TABLE "NFB"."TB_SYS_CONF" (
"CKEY" VARCHAR2(50 BYTE) NOT NULL ,
"CVALUE" VARCHAR2(2000 BYTE) NULL ,
"CKEYNAME" VARCHAR2(100 BYTE) NULL ,
"CTYPE" VARCHAR2(50 BYTE) NULL ,
"CTYPENAME" VARCHAR2(100 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_CONF
-- ----------------------------

-- ----------------------------
-- Table structure for TB_SYS_DATADIR_INFO
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_DATADIR_INFO";
CREATE TABLE "NFB"."TB_SYS_DATADIR_INFO" (
"CKEY" VARCHAR2(50 BYTE) NOT NULL ,
"PARENTKEY" VARCHAR2(50 BYTE) NOT NULL ,
"CVALUE" VARCHAR2(200 BYTE) NULL ,
"TYPENAME" VARCHAR2(200 BYTE) NULL ,
"SORT" NUMBER(4) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_DATADIR_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for TB_SYS_FUNC
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_FUNC";
CREATE TABLE "NFB"."TB_SYS_FUNC" (
"FUNCID" VARCHAR2(50 BYTE) NOT NULL ,
"MENUID" VARCHAR2(50 BYTE) NOT NULL ,
"OPERID" VARCHAR2(50 BYTE) NOT NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL ,
"url" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_FUNC
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_FUNC" VALUES ('1', '2', '1', null, null, null, '/sysmenu/list');
INSERT INTO "NFB"."TB_SYS_FUNC" VALUES ('2', '2', '2', null, null, null, '/sysmenu/save');
INSERT INTO "NFB"."TB_SYS_FUNC" VALUES ('3', '2', '3', null, null, null, '/sysmenu/save');
INSERT INTO "NFB"."TB_SYS_FUNC" VALUES ('4', '3', '1', null, null, null, '/sysoper/list');
INSERT INTO "NFB"."TB_SYS_FUNC" VALUES ('5', '5', '1', null, null, null, '/sysconf/list');

-- ----------------------------
-- Table structure for TB_SYS_LOG
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_LOG";
CREATE TABLE "NFB"."TB_SYS_LOG" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"USERID" VARCHAR2(50 BYTE) NULL ,
"USERNAME" VARCHAR2(50 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"IP" VARCHAR2(50 BYTE) NULL ,
"menuname" VARCHAR2(255 BYTE) NULL ,
"opername" VARCHAR2(255 BYTE) NULL ,
"retain1" VARCHAR2(255 BYTE) NULL ,
"retain2" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_LOG
-- ----------------------------

-- ----------------------------
-- Table structure for TB_SYS_MENU
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_MENU";
CREATE TABLE "NFB"."TB_SYS_MENU" (
"MENUID" VARCHAR2(50 BYTE) NOT NULL ,
"PARENTID" VARCHAR2(50 BYTE) NULL ,
"MENUITEM" VARCHAR2(200 BYTE) NULL ,
"URL" VARCHAR2(200 BYTE) NULL ,
"SORT" NUMBER(4) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_MENU
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_MENU" VALUES ('1', '0', '菜单管理', '#', '200', TO_DATE('2016-07-30 13:35:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-30 13:36:16', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO "NFB"."TB_SYS_MENU" VALUES ('2', '1', '系统菜单', 'page/system/sysMenu.jsp', '1', TO_DATE('2016-07-27 13:36:03', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-30 13:36:19', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO "NFB"."TB_SYS_MENU" VALUES ('3', '1', '操作类型', 'sys/sysOper.html', '2', TO_DATE('2016-07-30 13:36:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-30 13:36:22', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO "NFB"."TB_SYS_MENU" VALUES ('4', '0', '系统管理', '#', '199', TO_DATE('2016-07-30 13:36:10', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-30 13:36:25', 'YYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for TB_SYS_OPERATE
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_OPERATE";
CREATE TABLE "NFB"."TB_SYS_OPERATE" (
"OPERID" VARCHAR2(50 BYTE) NOT NULL ,
"OPERNAME" VARCHAR2(50 BYTE) NOT NULL ,
"OPERKEY" VARCHAR2(50 BYTE) NOT NULL ,
"PICICON" VARCHAR2(50 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL ,
"sort" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_OPERATE
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_OPERATE" VALUES ('1', '查询', 'query', 'icon-search', null, null, null, '0');
INSERT INTO "NFB"."TB_SYS_OPERATE" VALUES ('2', '新增', 'add', 'icon-add', null, null, null, '1');
INSERT INTO "NFB"."TB_SYS_OPERATE" VALUES ('3', '编辑', 'edit', 'icon-edit', null, null, null, '2');

-- ----------------------------
-- Table structure for TB_SYS_ROLE
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_ROLE";
CREATE TABLE "NFB"."TB_SYS_ROLE" (
"ROLEID" NUMBER(4) NOT NULL ,
"ROLENAME" VARCHAR2(50 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_ROLE
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_ROLE" VALUES ('1', '超级管理员', TO_DATE('2016-07-24 15:33:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-24 15:33:32', 'YYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for TB_SYS_ROLE_FUNC
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_ROLE_FUNC";
CREATE TABLE "NFB"."TB_SYS_ROLE_FUNC" (
"ROLEID" NUMBER(10) NOT NULL ,
"FUNCID" VARCHAR2(50 BYTE) NOT NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_ROLE_FUNC
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_ROLE_FUNC" VALUES ('1', '1', null, null, null);

-- ----------------------------
-- Table structure for TB_SYS_USER
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_USER";
CREATE TABLE "NFB"."TB_SYS_USER" (
"USERID" VARCHAR2(50 BYTE) NOT NULL ,
"USERNAME" VARCHAR2(50 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(50 BYTE) NOT NULL ,
"TEL" VARCHAR2(16 BYTE) NULL ,
"ACTIVEFLAG" NUMBER(1) DEFAULT 0  NOT NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_USER
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_USER" VALUES ('admin', '超级管理员', 'B15A268148D9C5A9363E915581CE1819', null, '0', TO_DATE('2016-07-24 15:30:23', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-24 15:30:27', 'YYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for TB_SYS_USER_ROLE
-- ----------------------------
DROP TABLE "NFB"."TB_SYS_USER_ROLE";
CREATE TABLE "NFB"."TB_SYS_USER_ROLE" (
"USERID" VARCHAR2(50 BYTE) NOT NULL ,
"ROLEID" NUMBER(4) NOT NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_USER_ROLE
-- ----------------------------
INSERT INTO "NFB"."TB_SYS_USER_ROLE" VALUES ('admin', '1', TO_DATE('2016-07-24 15:31:48', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-24 15:31:52', 'YYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for TB_WX_ACCESS_TOKEN
-- ----------------------------
DROP TABLE "NFB"."TB_WX_ACCESS_TOKEN";
CREATE TABLE "NFB"."TB_WX_ACCESS_TOKEN" (
"ACCOUNTID" VARCHAR2(100 BYTE) NOT NULL ,
"ACCESSTOKEN" VARCHAR2(255 BYTE) NOT NULL ,
"PUTTIME" VARCHAR2(20 BYTE) DEFAULT 0  NULL ,
"EXPIRES_IN" VARCHAR2(20 BYTE) DEFAULT 0  NULL ,
"UPDATETIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_ACCESS_TOKEN
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_ACCOUNT
-- ----------------------------
DROP TABLE "NFB"."TB_WX_ACCOUNT";
CREATE TABLE "NFB"."TB_WX_ACCOUNT" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"NAME" VARCHAR2(100 BYTE) NULL ,
"APPID" VARCHAR2(50 BYTE) NULL ,
"APPSECRET" VARCHAR2(100 BYTE) NULL ,
"AUTHDOMAIN" VARCHAR2(300 BYTE) NULL ,
"URL" VARCHAR2(400 BYTE) NULL ,
"TOKEN" VARCHAR2(32 BYTE) NULL ,
"AESKEY" VARCHAR2(50 BYTE) NULL ,
"PICURL" VARCHAR2(1024 BYTE) NULL ,
"ENABLE" NUMBER(1) DEFAULT 0  NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL ,
"CREATETIME" TIMESTAMP(6)  NULL ,
"SERVER_CONTEXT" VARCHAR2(50 BYTE) NULL ,
"WX_ACCTNO" VARCHAR2(100 BYTE) NULL ,
"IS_SERVICE" NUMBER(1) DEFAULT 0  NULL ,
"ACCTYPE" NUMBER(1) DEFAULT 0  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "NFB"."TB_WX_ACCOUNT"."WX_ACCTNO" IS '微信号';
COMMENT ON COLUMN "NFB"."TB_WX_ACCOUNT"."IS_SERVICE" IS '1:提供服务，0：不提供服务';
COMMENT ON COLUMN "NFB"."TB_WX_ACCOUNT"."ACCTYPE" IS '0:服务号 1：企业号 2:订阅号';

-- ----------------------------
-- Records of TB_WX_ACCOUNT
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_AUTO_REPLAY
-- ----------------------------
DROP TABLE "NFB"."TB_WX_AUTO_REPLAY";
CREATE TABLE "NFB"."TB_WX_AUTO_REPLAY" (
"CPARENTTYPE" VARCHAR2(50 BYTE) NULL ,
"CKEY" VARCHAR2(200 BYTE) NULL ,
"CREPLAY" VARCHAR2(2000 BYTE) NULL ,
"CTYPE" VARCHAR2(50 BYTE) NOT NULL ,
"CTYPENAME" VARCHAR2(100 BYTE) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"REPLAYTYPE" VARCHAR2(20 BYTE) NULL ,
"REPLAYMODE" NUMBER(1) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_AUTO_REPLAY
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
DROP TABLE "NFB"."TB_WX_AUTO_REPLAY_NEWSITEM";
CREATE TABLE "NFB"."TB_WX_AUTO_REPLAY_NEWSITEM" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"TITLE" VARCHAR2(100 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(300 BYTE) NULL ,
"PICURL" VARCHAR2(200 BYTE) NULL ,
"URL" VARCHAR2(1000 BYTE) NULL ,
"SORT" NUMBER(10) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"KEY" VARCHAR2(500 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_CHAT_MSG
-- ----------------------------
DROP TABLE "NFB"."TB_WX_CHAT_MSG";
CREATE TABLE "NFB"."TB_WX_CHAT_MSG" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"TOUSERNAME" VARCHAR2(50 BYTE) NULL ,
"FROMUSERNAME" VARCHAR2(50 BYTE) NULL ,
"MSGID" VARCHAR2(100 BYTE) NULL ,
"MSGTYPE" VARCHAR2(50 BYTE) NULL ,
"PICURL" VARCHAR2(200 BYTE) NULL ,
"MEDIAID" VARCHAR2(50 BYTE) NULL ,
"CONTENT" VARCHAR2(2000 BYTE) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"CREATETIME" DATE NULL ,
"FORMAT" VARCHAR2(100 BYTE) NULL ,
"RECOGNITION" VARCHAR2(255 BYTE) NULL ,
"LOCATION_X" VARCHAR2(50 BYTE) NULL ,
"LOCATION_Y" VARCHAR2(50 BYTE) NULL ,
"SCALE" VARCHAR2(20 BYTE) NULL ,
"THUMBMEDIAID" VARCHAR2(50 BYTE) NULL ,
"TITLE" VARCHAR2(255 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL ,
"URL" VARCHAR2(255 BYTE) NULL ,
"EVENT" VARCHAR2(255 BYTE) NULL ,
"EVENTKEY" VARCHAR2(255 BYTE) NULL ,
"TICKET" VARCHAR2(255 BYTE) NULL ,
"LABEL" VARCHAR2(255 BYTE) NULL ,
"ISREQUEST" CHAR(1 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_CHAT_MSG
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_CHAT_NEWS_MSG
-- ----------------------------
DROP TABLE "NFB"."TB_WX_CHAT_NEWS_MSG";
CREATE TABLE "NFB"."TB_WX_CHAT_NEWS_MSG" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"CHAT_ID" VARCHAR2(50 BYTE) NOT NULL ,
"TITLE" VARCHAR2(100 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL ,
"PICURL" VARCHAR2(100 BYTE) NULL ,
"URL" VARCHAR2(200 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_CHAT_NEWS_MSG
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_MENU
-- ----------------------------
DROP TABLE "NFB"."TB_WX_MENU";
CREATE TABLE "NFB"."TB_WX_MENU" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"PARENT_ID" VARCHAR2(32 BYTE) NULL ,
"NAME" VARCHAR2(100 BYTE) NULL ,
"TYPE" VARCHAR2(32 BYTE) NULL ,
"CONTENT" VARCHAR2(1000 BYTE) NULL ,
"POST_FLAG" NUMBER(2) DEFAULT 0  NULL ,
"DELETE_FLAG" NUMBER(1) DEFAULT 0  NULL ,
"SORT" NUMBER(2) DEFAULT 0  NULL ,
"AGENTID" NUMBER(1) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"AUDITSTATE" NUMBER(1) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_MENU
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_MENU_URL
-- ----------------------------
DROP TABLE "NFB"."TB_WX_MENU_URL";
CREATE TABLE "NFB"."TB_WX_MENU_URL" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"MENUNAME" VARCHAR2(100 BYTE) NULL ,
"MENUURL" VARCHAR2(1000 BYTE) NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NULL ,
"URL" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_MENU_URL
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_QRCODE
-- ----------------------------
DROP TABLE "NFB"."TB_WX_QRCODE";
CREATE TABLE "NFB"."TB_WX_QRCODE" (
"ID" VARCHAR2(50 BYTE) NOT NULL ,
"QRNAME" VARCHAR2(200 BYTE) NOT NULL ,
"QRTYPE" VARCHAR2(50 BYTE) NULL ,
"QRURL" VARCHAR2(1024 BYTE) NULL ,
"ACCOUNTID" VARCHAR2(200 BYTE) NULL ,
"QRPATH" VARCHAR2(1024 BYTE) NULL ,
"ORGID" VARCHAR2(50 BYTE) NULL ,
"QRNO" VARCHAR2(50 BYTE) NULL ,
"SCENETYPE" NUMBER(1) NULL ,
"STARTTIME" NUMBER(20) NULL ,
"ENDTIME" NUMBER(20) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_QRCODE
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_TEMPLATE
-- ----------------------------
DROP TABLE "NFB"."TB_WX_TEMPLATE";
CREATE TABLE "NFB"."TB_WX_TEMPLATE" (
"ID" VARCHAR2(36 BYTE) NOT NULL ,
"ACCOUNTID" VARCHAR2(36 BYTE) NULL ,
"TEMPLATEID" VARCHAR2(50 BYTE) NULL ,
"TEMPLATEMNAME" VARCHAR2(50 BYTE) NULL ,
"WTCOLOR" VARCHAR2(50 BYTE) NULL ,
"WTCONTENT" VARCHAR2(1024 BYTE) NULL ,
"DETAILURL" VARCHAR2(1024 BYTE) NULL ,
"CTYPE" CHAR(2 BYTE) NULL ,
"STATUS" CHAR(1 BYTE) DEFAULT 0  NULL ,
"YW_TYPE" NUMBER(2) NULL ,
"CREATETIME" DATE NULL ,
"UPDATETIME" DATE NULL ,
"CREATOR" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "NFB"."TB_WX_TEMPLATE"."STATUS" IS '0：启用 1：失效';

-- ----------------------------
-- Records of TB_WX_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_USER
-- ----------------------------
DROP TABLE "NFB"."TB_WX_USER";
CREATE TABLE "NFB"."TB_WX_USER" (
"OPENID" VARCHAR2(50 BYTE) NOT NULL ,
"NICKNAME" VARCHAR2(256 BYTE) NULL ,
"GROUPID" NUMBER DEFAULT 0  NOT NULL ,
"COUNTRY" VARCHAR2(256 BYTE) NULL ,
"PROVINCE" VARCHAR2(256 BYTE) NULL ,
"CITY" VARCHAR2(256 BYTE) NULL ,
"SEX" NUMBER NULL ,
"IMAGEURL" VARCHAR2(1024 BYTE) NULL ,
"LANGUAGE" VARCHAR2(32 BYTE) NULL ,
"ISSUBSCRIBE" NUMBER DEFAULT 1  NOT NULL ,
"SUBSCRIBETIME" TIMESTAMP(6)  NULL ,
"UPDATETIME" TIMESTAMP(6)  NULL ,
"ACCOUNTID" VARCHAR2(50 BYTE) NOT NULL ,
"CREATETIME" TIMESTAMP(6)  NULL ,
"USEFLAG" NUMBER DEFAULT 0  NULL ,
"QRNO" NUMBER(5) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "NFB"."TB_WX_USER"."USEFLAG" IS '黑名单标识 0：正常 1：黑户';

-- ----------------------------
-- Records of TB_WX_USER
-- ----------------------------

-- ----------------------------
-- View structure for VIEW_SYS_ROLE_FUNC
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "NFB"."VIEW_SYS_ROLE_FUNC" AS 
SELECT DISTINCT
	tso.OPERID,
	tso.OPERNAME,
	tso.OPERKEY,
	tso.PICICON,
	TSR.MENUID,
	TSRF.FUNCID,
	TSRF.ROLEID,
	TSO."sort" SORT
FROM
	TB_SYS_OPERATE tso
JOIN TB_SYS_FUNC tsr ON tso.operid = tsr.operid
LEFT JOIN TB_SYS_ROLE_FUNC tsrf ON tsr.funcid = tsrf.funcid
ORDER BY
	TSO."sort";

-- ----------------------------
-- View structure for VIEW_SYS_ROLE_MENU
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "NFB"."VIEW_SYS_ROLE_MENU" AS 
SELECT DISTINCT
	tsm.MENUID,
	tsm.PARENTID,
	tsm.MENUITEM,
	tsm.URL,
	tsm."SORT" nsort,
	tsrf.ROLEID
FROM
	TB_SYS_MENU tsm
LEFT JOIN TB_SYS_FUNC tsf ON TSM.MENUID = TSF.MENUID
LEFT JOIN TB_SYS_ROLE_FUNC tsrf ON tsf.FUNCID = tsrf.FUNCID 
order by tsm."SORT";

-- ----------------------------
-- Indexes structure for table TB_CUSTOMER_ADDR
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_CUSTOMER_ADDR
-- ----------------------------
ALTER TABLE "NFB"."TB_CUSTOMER_ADDR" ADD CHECK ("ADDRID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_CUSTOMER_ADDR
-- ----------------------------
ALTER TABLE "NFB"."TB_CUSTOMER_ADDR" ADD PRIMARY KEY ("ADDRID");

-- ----------------------------
-- Indexes structure for table TB_CUSTOMER_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_CUSTOMER_INFO
-- ----------------------------
ALTER TABLE "NFB"."TB_CUSTOMER_INFO" ADD CHECK ("USERID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_CUSTOMER_INFO
-- ----------------------------
ALTER TABLE "NFB"."TB_CUSTOMER_INFO" ADD PRIMARY KEY ("USERID");

-- ----------------------------
-- Indexes structure for table TB_SYS_CONF
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_CONF
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_CONF" ADD CHECK ("CKEY" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_CONF
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_CONF" ADD PRIMARY KEY ("CKEY");

-- ----------------------------
-- Indexes structure for table TB_SYS_DATADIR_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_DATADIR_INFO
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_DATADIR_INFO" ADD CHECK ("CKEY" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_DATADIR_INFO" ADD CHECK ("PARENTKEY" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_DATADIR_INFO
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_DATADIR_INFO" ADD PRIMARY KEY ("CKEY", "PARENTKEY");

-- ----------------------------
-- Indexes structure for table TB_SYS_FUNC
-- ----------------------------
CREATE INDEX "NFB"."idx_tb_sys_func_url"
ON "NFB"."TB_SYS_FUNC" ("url" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_SYS_FUNC
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_FUNC" ADD CHECK ("FUNCID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_FUNC" ADD CHECK ("MENUID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_FUNC" ADD CHECK ("OPERID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_FUNC
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_FUNC" ADD PRIMARY KEY ("FUNCID");

-- ----------------------------
-- Indexes structure for table TB_SYS_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_LOG
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_LOG
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_SYS_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_MENU
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_MENU" ADD CHECK ("MENUID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_MENU
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_MENU" ADD PRIMARY KEY ("MENUID");

-- ----------------------------
-- Indexes structure for table TB_SYS_OPERATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_OPERATE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_OPERATE" ADD CHECK ("OPERID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_OPERATE" ADD CHECK ("OPERNAME" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_OPERATE" ADD CHECK ("OPERKEY" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_OPERATE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_OPERATE" ADD PRIMARY KEY ("OPERID");

-- ----------------------------
-- Indexes structure for table TB_SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_ROLE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_ROLE" ADD CHECK ("ROLEID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_ROLE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_ROLE" ADD PRIMARY KEY ("ROLEID");

-- ----------------------------
-- Indexes structure for table TB_SYS_ROLE_FUNC
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_ROLE_FUNC
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_ROLE_FUNC" ADD CHECK ("ROLEID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_ROLE_FUNC" ADD CHECK ("FUNCID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_ROLE_FUNC
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_ROLE_FUNC" ADD PRIMARY KEY ("ROLEID", "FUNCID");

-- ----------------------------
-- Indexes structure for table TB_SYS_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_USER
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_USER" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_USER" ADD CHECK ("ACTIVEFLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_USER
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_USER" ADD PRIMARY KEY ("USERID");

-- ----------------------------
-- Indexes structure for table TB_SYS_USER_ROLE
-- ----------------------------
CREATE INDEX "NFB"."IDX_TB_SYS_USER_ROLE_USERID"
ON "NFB"."TB_SYS_USER_ROLE" ("USERID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_USER_ROLE" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "NFB"."TB_SYS_USER_ROLE" ADD CHECK ("ROLEID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "NFB"."TB_SYS_USER_ROLE" ADD PRIMARY KEY ("USERID", "ROLEID");

-- ----------------------------
-- Indexes structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_ACCESS_TOKEN" ADD CHECK ("ACCOUNTID" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_ACCESS_TOKEN" ADD CHECK ("ACCESSTOKEN" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_ACCESS_TOKEN" ADD PRIMARY KEY ("ACCOUNTID");

-- ----------------------------
-- Indexes structure for table TB_WX_ACCOUNT
-- ----------------------------
CREATE INDEX "NFB"."TB_WX_ACCOUNT_NAMEIDX"
ON "NFB"."TB_WX_ACCOUNT" ("NAME" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_ACCOUNT
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_ACCOUNT" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_ACCOUNT
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_ACCOUNT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_AUTO_REPLAY
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_AUTO_REPLAY
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_AUTO_REPLAY" ADD CHECK ("CTYPE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_AUTO_REPLAY
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_AUTO_REPLAY" ADD PRIMARY KEY ("CTYPE");

-- ----------------------------
-- Indexes structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------

-- ----------------------------
-- Uniques structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_AUTO_REPLAY_NEWSITEM" ADD UNIQUE ("KEY");

-- ----------------------------
-- Checks structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_AUTO_REPLAY_NEWSITEM" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_AUTO_REPLAY_NEWSITEM" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_CHAT_MSG
-- ----------------------------
CREATE INDEX "NFB"."IDX_WX_CHAT_MSG_ACCOUNTID"
ON "NFB"."TB_WX_CHAT_MSG" ("ACCOUNTID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "NFB"."IDX_WX_CHAT_MSG_FROMUSER"
ON "NFB"."TB_WX_CHAT_MSG" ("FROMUSERNAME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "NFB"."IDX_WX_CHAT_MSG_TOUSER"
ON "NFB"."TB_WX_CHAT_MSG" ("TOUSERNAME" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_CHAT_MSG
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_CHAT_MSG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_CHAT_MSG
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_CHAT_MSG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
CREATE INDEX "NFB"."IDX_WX_CHAT_NEWS_MSG_CHATID"
ON "NFB"."TB_WX_CHAT_NEWS_MSG" ("CHAT_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_CHAT_NEWS_MSG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_CHAT_NEWS_MSG" ADD CHECK ("CHAT_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_CHAT_NEWS_MSG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_MENU
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_MENU" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_MENU
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_MENU_URL
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_MENU_URL
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_MENU_URL" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_MENU_URL
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_MENU_URL" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_QRCODE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_QRCODE
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_QRCODE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_QRCODE" ADD CHECK ("QRNAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_QRCODE
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_QRCODE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_TEMPLATE
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_TEMPLATE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_TEMPLATE
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_TEMPLATE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TB_WX_USER
-- ----------------------------
CREATE INDEX "NFB"."IDX_WX_USER_ISSUBSCRIBE"
ON "NFB"."TB_WX_USER" ("ISSUBSCRIBE" ASC)
LOGGING
VISIBLE;
CREATE INDEX "NFB"."IDX_WX_USER_NICKNAME"
ON "NFB"."TB_WX_USER" ("NICKNAME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "NFB"."IDX_WX_USER_SUBSCRIBETIME"
ON "NFB"."TB_WX_USER" ("SUBSCRIBETIME" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_USER
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_USER" ADD CHECK ("OPENID" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_USER" ADD CHECK ("GROUPID" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_USER" ADD CHECK ("ISSUBSCRIBE" IS NOT NULL);
ALTER TABLE "NFB"."TB_WX_USER" ADD CHECK ("ACCOUNTID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_USER
-- ----------------------------
ALTER TABLE "NFB"."TB_WX_USER" ADD PRIMARY KEY ("OPENID", "ACCOUNTID");
