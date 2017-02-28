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

Date: 2017-02-28 16:10:19
*/


-- ----------------------------
-- Table structure for TB_AUTOCODE_ATTR
-- ----------------------------
DROP TABLE TB_AUTOCODE_ATTR;
CREATE TABLE TB_AUTOCODE_ATTR (
ATTRNAME VARCHAR2(50 BYTE) NOT NULL ,
ATTRTYPE VARCHAR2(50 BYTE) NULL ,
ISPK NUMBER(1) DEFAULT 0  NULL ,
SEQ VARCHAR2(50 BYTE) NULL ,
ATTRSIZE NUMBER(4) NULL ,
ATTRDESC VARCHAR2(50 BYTE) NULL ,
TABLENAME VARCHAR2(50 BYTE) NOT NULL ,
SORT NUMBER(2) DEFAULT 0  NULL ,
NOTE NVARCHAR2(200) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_AUTOCODE_ATTR
-- ----------------------------
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_NOTE_REMINDER', '0', '主键');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remind_type', 'Integer', '0', null, '1', '事务类型', 'TB_NOTE_REMINDER', '1', '0：普通 1：特殊日子');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remind_date', 'String', '0', null, '50', '特殊日期', 'TB_NOTE_REMINDER', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('is_repeat', 'Integer', '0', null, '1', '是否重复', 'TB_NOTE_REMINDER', '3', '0：不重复 1：重复，默认不重复');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remind_content', 'String', '0', null, '250', '提醒内容', 'TB_NOTE_REMINDER', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('before_days', 'Integer', '0', null, '2', '提前天数', 'TB_NOTE_REMINDER', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remind_time', 'String', '0', null, '20', '提醒时间', 'TB_NOTE_REMINDER', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('is_before', 'Integer', '0', null, '1', '是否提前提醒', 'TB_NOTE_REMINDER', '7', '0：不提前 1：提前');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_NOTE_REMINDER', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_NOTE_REMINDER', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '150', '创建者', 'TB_NOTE_REMINDER', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('calendar_type', 'Integer', '0', null, '50', '日历类型', 'TB_NOTE_REMINDER', '11', '0：公历  1：农历');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('goodName', 'String', '0', null, '1024', '商品名称', 'tb_mall_good_info', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('goodPrice', 'Integer', '0', null, '12', '商品单价', 'tb_mall_good_info', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('unit', 'String', '0', null, '50', '商品单位', 'tb_mall_good_info', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('imageUrl', 'String', '0', null, '1024', '商品主图', 'tb_mall_good_info', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '7', '创建时间', 'tb_mall_good_info', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '7', '更新时间', 'tb_mall_good_info', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('goodId', 'String', '1', null, '50', '商品ID', 'tb_mall_good_info', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'tb_mall_good_info', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_NOTE_GAINS', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvl', 'String', '0', null, '50', '级别', 'TB_NOTE_GAINS', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvlName', 'String', '0', null, '50', '级别名称', 'TB_NOTE_GAINS', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('title', 'String', '0', null, '50', '标题', 'TB_NOTE_GAINS', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('content', 'String', '0', null, '50', '内容', 'TB_NOTE_GAINS', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('labels', 'String', '0', null, '50', '标签', 'TB_NOTE_GAINS', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_NOTE_GAINS', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_NOTE_GAINS', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_NOTE_GAINS', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updater', 'String', '0', null, '50', '更新者', 'TB_NOTE_GAINS', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('roleid', 'String', '1', null, '50', '角色ID', 'TB_SYS_ROLE', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_SYS_ROLE', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_SYS_ROLE', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('rolename', 'String', '0', null, '50', '角色名称', 'TB_SYS_ROLE', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_SYS_ROLE', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userType', 'String', '0', null, '50', '用户类型', 'TB_SYS_ROLE', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('companyId', 'String', '0', null, '50', '公司ID', 'TB_SYS_ROLE', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvl', 'Integer', '0', null, '50', '级别', 'TB_SYS_ROLE', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('showFlag', 'String', '0', null, '50', '是否单独维护', 'TB_SYS_ROLE', '8', '0：否 1：是');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userid', 'String', '1', null, '50', '用户ID', 'TB_SYS_USER', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('username', 'String', '0', null, '150', '用户名称', 'TB_SYS_USER', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('password', 'String', '0', null, '50', '用户密码', 'TB_SYS_USER', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('bind_mobile', 'String', '0', null, '50', '绑定手机号码', 'TB_SYS_USER', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('activeFlag', 'Integer', '0', null, '1', '激活标识', 'TB_SYS_USER', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '7', '创建时间', 'TB_SYS_USER', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '7', '更新时间', 'TB_SYS_USER', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_SYS_USER', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('orgid', 'String', '0', null, '50', '组织ID', 'TB_SYS_USER', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('companyId', 'String', '0', null, '50', '公司ID', 'TB_SYS_USER', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('token', 'String', '0', null, '512', '口令', 'TB_SYS_USER', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('openid', 'String', '0', null, '50', 'openid', 'TB_SYS_USER', '11', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userType', 'String', '0', null, '50', '用户类型', 'TB_SYS_USER', '12', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('menuName', 'String', '0', null, '50', '菜单名称', 'TB_WX_MENU_URL', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('menuUrl', 'String', '0', null, '50', '菜单URL', 'TB_WX_MENU_URL', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_MENU_URL', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_WX_MENU', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('parent_id', 'String', '0', null, '50', '父ID', 'TB_WX_MENU', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('name', 'String', '0', null, '50', '菜单名称', 'TB_WX_MENU', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('type', 'String', '0', null, '50', '菜单类型', 'TB_WX_MENU', '3', 'view：链接 click：点击：1：一级菜单');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('content', 'String', '0', null, '50', '访问内容', 'TB_WX_MENU', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sort', 'Integer', '0', null, '50', '排序', 'TB_WX_MENU', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众ID', 'TB_WX_MENU', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_WX_AUTO_REPLAY_NEWSITEM', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('title', 'String', '0', null, '50', '标题', 'TB_WX_AUTO_REPLAY_NEWSITEM', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('description', 'String', '0', null, '50', '描述', 'TB_WX_AUTO_REPLAY_NEWSITEM', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('picUrl', 'String', '0', null, '50', '图片路径', 'TB_WX_AUTO_REPLAY_NEWSITEM', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('url', 'String', '0', null, '50', '链接', 'TB_WX_AUTO_REPLAY_NEWSITEM', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sort', 'Integer', '0', null, '50', '排序', 'TB_WX_AUTO_REPLAY_NEWSITEM', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '服务号ID', 'TB_WX_AUTO_REPLAY_NEWSITEM', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_AUTO_REPLAY_NEWSITEM', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_AUTO_REPLAY_NEWSITEM', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_WX_AUTO_REPLAY_NEWSITEM', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('cparentType', 'String', '1', null, '50', '父ID', 'TB_WX_AUTO_REPLAY', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ckey', 'String', '0', null, '50', '关键字', 'TB_WX_AUTO_REPLAY', '1', '关键字英文全部小写');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creplay', 'String', '0', null, '50', '回复内容', 'TB_WX_AUTO_REPLAY', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ctype', 'String', '0', null, '50', 'ID', 'TB_WX_AUTO_REPLAY', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ctypeName', 'String', '0', null, '50', '名称', 'TB_WX_AUTO_REPLAY', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_AUTO_REPLAY', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('replayType', 'String', '0', null, '50', '回复方式', 'TB_WX_AUTO_REPLAY', '6', 'NEWS：图文 MODULE：指令 TEXT：文本');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_AUTO_REPLAY', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_AUTO_REPLAY', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_WX_AUTO_REPLAY', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_WX_MENU_URL', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvl', 'String', '0', null, '50', 'LVL', 'TB_WX_MENU', '7', '0：公众号 1：一级菜单 2：二级菜单');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('cvalue', 'String', '0', null, '50', '主键值', 'TB_SYS_CONF', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ckeyName', 'String', '0', null, '50', '主键描述', 'TB_SYS_CONF', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ctype', 'String', '0', null, '50', '公司ID', 'TB_SYS_CONF', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ctypename', 'String', '0', null, '50', '公司名称', 'TB_SYS_CONF', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_SYS_CONF', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_SYS_CONF', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_SYS_CONF', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_SYS_LOG', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userid', 'String', '0', null, '50', '用户ID', 'TB_SYS_LOG', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('username', 'String', '0', null, '50', '用户姓名', 'TB_SYS_LOG', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_SYS_LOG', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ip', 'String', '0', null, '50', 'IP', 'TB_SYS_LOG', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('menuname', 'String', '0', null, '50', '菜单名称', 'TB_SYS_LOG', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('opername', 'String', '0', null, '50', '操作名称', 'TB_SYS_LOG', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('retain2', 'String', '0', null, '50', '访问URL', 'TB_SYS_LOG', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('source', 'String', '0', null, '50', '来源', 'TB_SYS_LOG', '8', '0:内管，1消息中心 2：前端');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('retain3', 'String', '0', null, '50', '公司ID', 'TB_SYS_LOG', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('retain1', 'String', '0', null, '50', '访问结果', 'TB_SYS_LOG', '10', '暂无用');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ckey', 'String', '1', null, '50', '主键', 'TB_SYS_DATADIR_INFO', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('parentkey', 'String', '0', null, '50', '父主键', 'TB_SYS_DATADIR_INFO', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('cvalue', 'String', '0', null, '50', '主键值', 'TB_SYS_DATADIR_INFO', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('typename', 'String', '0', null, '50', '公司ID', 'TB_SYS_DATADIR_INFO', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sort', 'Integer', '0', null, '50', '排序', 'TB_SYS_DATADIR_INFO', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'String', '0', null, '50', '创建时间', 'TB_SYS_DATADIR_INFO', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'String', '0', null, '50', '更新时间', 'TB_SYS_DATADIR_INFO', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_SYS_DATADIR_INFO', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ckey', 'String', '1', null, '50', '主键', 'TB_SYS_CONF', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ID', 'String', '1', null, '50', 'ID', 'tb_mall_advise', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('content', 'String', '0', null, '1024', '商品描述', 'tb_mall_advise', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('label', 'String', '0', null, '512', '标签', 'tb_mall_advise', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('num', 'Integer', '0', null, '5', '定制数量', 'tb_mall_advise', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '7', '创建时间', 'tb_mall_advise', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '7', '更新时间', 'tb_mall_advise', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userid', 'String', '0', null, '50', '用户ID', 'tb_mall_advise', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('mobile', 'String', '0', null, '50', '手机号码', 'tb_mall_advise', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('orgid', 'String', '1', null, '50', '机构ID', 'tb_org_info', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'tb_org_info', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('orgname', 'String', '0', null, '256', '机构名称', 'tb_org_info', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '7', '创建时间', 'tb_org_info', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '7', '更新时间', 'tb_org_info', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('useflag', 'Integer', '0', null, '1', '启用标识', 'tb_org_info', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvl', 'Integer', '0', null, '50', '级别', 'tb_org_info', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('companyId', 'String', '0', null, '50', '公司ID', 'tb_org_info', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_NOTE_QUESTION', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvl', 'Integer', '0', null, '50', '级别', 'TB_NOTE_QUESTION', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('lvlName', 'String', '0', null, '50', '级别名称', 'TB_NOTE_QUESTION', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('question', 'String', '0', null, '50', '问题', 'TB_NOTE_QUESTION', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('solution', 'String', '0', null, '50', '解决方案', 'TB_NOTE_QUESTION', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('labels', 'String', '0', null, '50', '标签', 'TB_NOTE_QUESTION', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createDate', 'String', '0', null, '50', '创建日期', 'TB_NOTE_QUESTION', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_NOTE_QUESTION', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_NOTE_QUESTION', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_NOTE_QUESTION', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updater', 'String', '0', null, '50', '更新者', 'TB_NOTE_QUESTION', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('userid', 'String', '1', null, '50', 'USERID', 'tb_vip_info', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('realname', 'String', '0', null, '50', '真实姓名', 'tb_vip_info', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('gender', 'String', '0', null, '50', '性别', 'tb_vip_info', '2', '1：女 2：男');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('birthdate', 'String', '0', null, '50', '生日', 'tb_vip_info', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('email', 'String', '0', null, '50', '邮箱', 'tb_vip_info', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('signature', 'String', '0', null, '50', '签名', 'tb_vip_info', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'tb_vip_info', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'tb_vip_info', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrName', 'String', '0', null, '50', '名称', 'TB_WX_QRCODE', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrType', 'String', '0', null, '50', '类型', 'TB_WX_QRCODE', '2', '0：链接 1：公众号');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrUrl', 'String', '0', null, '50', '链接', 'TB_WX_QRCODE', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_QRCODE', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrPath', 'String', '0', null, '50', '图片路径', 'TB_WX_QRCODE', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sceneType', 'String', '0', null, '50', '场景类型', 'TB_WX_QRCODE', '6', '0：临时 1：永久');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_QRCODE', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_QRCODE', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_WX_QRCODE', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', 'ID', 'TB_WX_MODULE_MSG', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_MODULE_MSG', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('template_id', 'String', '0', null, '50', '模板ID', 'TB_WX_MODULE_MSG', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('touser', 'String', '0', null, '50', '接受者', 'TB_WX_MODULE_MSG', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('url', 'String', '0', null, '50', '访问URL', 'TB_WX_MODULE_MSG', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('data', 'String', '0', null, '50', '内容', 'TB_WX_MODULE_MSG', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('needFlag', 'Integer', '0', null, '50', '需要发送标识', 'TB_WX_MODULE_MSG', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sendFlag', 'Integer', '0', null, '50', '发送标识', 'TB_WX_MODULE_MSG', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sendTimes', 'Integer', '0', null, '50', '发送次数', 'TB_WX_MODULE_MSG', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_MODULE_MSG', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sendtime', 'Date', '0', null, '50', '发送时间', 'TB_WX_MODULE_MSG', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('msgId', 'String', '0', null, '50', '消息ID', 'TB_WX_MODULE_MSG', '11', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('push_code', 'String', '0', null, '50', '推送返回码', 'TB_WX_MODULE_MSG', '12', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('push_msg', 'String', '0', null, '50', '推送返回信息', 'TB_WX_MODULE_MSG', '13', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('resultCode', 'String', '0', null, '50', '推送结果码', 'TB_WX_MODULE_MSG', '14', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('resultMsg', 'String', '0', null, '50', '推送结果消息', 'TB_WX_MODULE_MSG', '15', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('note', 'String', '0', null, '50', '备注', 'TB_WX_MODULE_MSG', '16', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('id', 'String', '1', null, '50', '主键', 'TB_SYS_LOG_PARAM', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('source', 'Integer', '0', null, '50', '来源', 'TB_SYS_LOG_PARAM', '1', '0：内管日志 1：接口日志 2：前端日志');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('menuName', 'String', '0', null, '50', '功能名称', 'TB_SYS_LOG_PARAM', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('operName', 'String', '0', null, '50', '操作名称', 'TB_SYS_LOG_PARAM', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'tb_diary', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('content', 'String', '0', null, '4028', '正文', 'tb_diary', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'tb_diary', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_SYS_LOG_PARAM', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_SYS_LOG_PARAM', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_SYS_LOG_PARAM', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('url', 'String', '0', null, '50', '访问链接', 'TB_SYS_LOG_PARAM', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ID', 'String', '1', null, '50', '主键', 'tb_diary', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('time', 'Date', '0', null, '7', '日记时间', 'tb_diary', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('title', 'String', '0', null, '1024', '标题', 'tb_diary', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'tb_diary', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountId', 'String', '1', null, '50', '公众号ID', 'TB_WX_ACCOUNT', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('authdoman', 'String', '0', null, '256', '授权域名', 'TB_WX_ACCOUNT', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('appsecret', 'String', '0', null, '50', 'APPSECRET', 'TB_WX_ACCOUNT', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('appid', 'String', '0', null, '50', 'APPID', 'TB_WX_ACCOUNT', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('orgid', 'String', '0', null, '50', '机构ID', 'TB_WX_ACCOUNT', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountname', 'String', '0', null, '150', '公众号名称', 'TB_WX_ACCOUNT', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_ACCOUNT', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accttype', 'Integer', '0', null, '1', '公众号类型', 'TB_WX_ACCOUNT', '7', '0：服务号 1：企业号 2：订阅号');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('is_service', 'Integer', '0', null, '1', '是否提供服务', 'TB_WX_ACCOUNT', '8', '0：不提供 1：提供');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('wx_acctno', 'String', '0', null, '50', '微信号', 'TB_WX_ACCOUNT', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('server_context', 'String', '0', null, '50', '上下文', 'TB_WX_ACCOUNT', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_ACCOUNT', '11', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_WX_ACCOUNT', '12', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('aeskey', 'String', '0', null, '50', '加密秘钥', 'TB_WX_ACCOUNT', '13', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('token', 'String', '0', null, '50', '令牌', 'TB_WX_ACCOUNT', '14', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('url', 'String', '0', null, '1024', '回调路径', 'TB_WX_ACCOUNT', '15', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('openid', 'String', '1', null, '50', 'OPENID', 'TB_WX_USER', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('nickname', 'String', '0', null, '50', '昵称', 'TB_WX_USER', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('groupid', 'Integer', '0', null, '50', '分组ID', 'TB_WX_USER', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('country', 'String', '0', null, '50', '国家', 'TB_WX_USER', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('province', 'String', '0', null, '50', '省', 'TB_WX_USER', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('city', 'String', '0', null, '50', '市', 'TB_WX_USER', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('sex', 'Integer', '0', null, '50', '性别', 'TB_WX_USER', '6', '1：男 2：女 0：未知');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('imageUrl', 'String', '0', null, '50', '头像路径', 'TB_WX_USER', '7', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('language', 'String', '0', null, '50', '语言', 'TB_WX_USER', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('issubscribe', 'Integer', '0', null, '50', '关注', 'TB_WX_USER', '9', '0：未关注 1：已关注');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('subscribetime', 'Date', '0', null, '50', '关注时间', 'TB_WX_USER', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_USER', '11', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_USER', '12', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_USER', '13', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('useflag', 'Integer', '0', null, '50', '启用标识', 'TB_WX_USER', '14', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrNo', 'String', '0', null, '50', '二维码标识', 'TB_WX_USER', '15', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remark', 'String', '0', null, '50', '备注', 'TB_WX_USER', '16', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('ywType', 'String', '1', null, '50', '业务类型', 'TB_WX_TEMPLATE', '0', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('accountid', 'String', '0', null, '50', '公众号ID', 'TB_WX_TEMPLATE', '1', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('template_id', 'String', '0', null, '50', '微信模板ID', 'TB_WX_TEMPLATE', '2', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('template_name', 'String', '0', null, '50', '微信模板标题', 'TB_WX_TEMPLATE', '3', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('first_content', 'String', '0', null, '50', '首行内容', 'TB_WX_TEMPLATE', '4', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('remark_content', 'String', '0', null, '50', '尾行内容', 'TB_WX_TEMPLATE', '5', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('detailUrl', 'String', '0', null, '50', '访问URL', 'TB_WX_TEMPLATE', '6', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('status', 'Integer', '0', null, '50', '启用标识', 'TB_WX_TEMPLATE', '7', '0：禁用 1：启用');
INSERT INTO TB_AUTOCODE_ATTR VALUES ('createtime', 'Date', '0', null, '50', '创建时间', 'TB_WX_TEMPLATE', '8', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('updatetime', 'Date', '0', null, '50', '更新时间', 'TB_WX_TEMPLATE', '9', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('creator', 'String', '0', null, '50', '创建者', 'TB_WX_TEMPLATE', '10', null);
INSERT INTO TB_AUTOCODE_ATTR VALUES ('qrNo', 'String', '1', null, '50', '标识', 'TB_WX_QRCODE', '0', null);

-- ----------------------------
-- Table structure for TB_AUTOCODE_BEAN
-- ----------------------------
DROP TABLE TB_AUTOCODE_BEAN;
CREATE TABLE TB_AUTOCODE_BEAN (
TABLENAME VARCHAR2(50 BYTE) NOT NULL ,
BEANNAME VARCHAR2(50 BYTE) NULL ,
MODULEDESC VARCHAR2(1024 BYTE) NULL ,
IS_CREATETABLE NUMBER(1) DEFAULT 0  NULL ,
CREATETIME DATE NULL ,
IS_AUTH NUMBER(1) NULL ,
UPDATETIME DATE NULL ,
PARENTPACKAGE VARCHAR2(50 BYTE) NULL ,
DESCRIPTION NVARCHAR2(350) NULL ,
ISAUTO NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_AUTOCODE_BEAN.IS_CREATETABLE IS '0：不生成  1：生成';

-- ----------------------------
-- Records of TB_AUTOCODE_BEAN
-- ----------------------------
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_ROLE', 'SysRole', '用户类型', '0', null, '1', TO_DATE('2017-01-10 22:19:34', 'YYYY-MM-DD HH24:MI:SS'), 'system', '用户类型', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('tb_diary', 'Diary', '我的日记', '0', null, '0', TO_DATE('2017-01-10 19:40:03', 'YYYY-MM-DD HH24:MI:SS'), 'note', '日记功能', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('tb_org_info', 'OrgInfo', '机构管理', '1', null, '1', TO_DATE('2017-01-10 22:04:48', 'YYYY-MM-DD HH24:MI:SS'), 'system', '组织架构,包括公司', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_ACCOUNT', 'WxAccount', '公众号管理', '0', null, '0', TO_DATE('2017-01-10 19:44:49', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '微信公众号功能', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_USER', 'SysUser', '用户管理', '0', TO_DATE('2016-10-23 11:54:33', 'YYYY-MM-DD HH24:MI:SS'), '0', TO_DATE('2017-01-10 22:23:18', 'YYYY-MM-DD HH24:MI:SS'), 'system', '用户管理，关联角色和组织架构', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('tb_mall_good_info', 'GoodInfo', '商品管理', '1', TO_DATE('2016-10-26 21:01:18', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2016-10-26 21:13:05', 'YYYY-MM-DD HH24:MI:SS'), 'mall', null, '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('tb_mall_advise', 'Advise', '客户定制', '1', TO_DATE('2016-10-26 21:10:24', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 22:37:50', 'YYYY-MM-DD HH24:MI:SS'), 'mall', '客户定制商品', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('tb_vip_info', 'VipInfo', '会员信息', '0', TO_DATE('2017-01-08 19:54:03', 'YYYY-MM-DD HH24:MI:SS'), '0', TO_DATE('2017-01-09 23:56:30', 'YYYY-MM-DD HH24:MI:SS'), 'note', '会员存档信息', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_USER', 'WxUser', '粉丝管理', '0', TO_DATE('2016-11-06 19:10:56', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 19:48:51', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '公众号关注粉丝', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_MENU', 'WxMenu', '微信菜单管理', '0', TO_DATE('2016-11-06 21:27:33', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:14:59', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '微信菜单', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_MENU_URL', 'WxMenuUrl', '微信菜单URL', '0', TO_DATE('2016-11-06 21:31:26', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:11:04', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '菜单链接URL', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_QRCODE', 'Qrcode', '二维码管理', '0', TO_DATE('2016-11-25 11:33:55', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 19:54:29', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '二维码管理，包括公众号二维码，链接二维码', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_LOG', 'SysLog', '系统日志', '0', TO_DATE('2016-11-27 21:09:51', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:19:35', 'YYYY-MM-DD HH24:MI:SS'), 'system', '系统访问日志', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_NOTE_QUESTION', 'Question', '工作问题记录', '0', TO_DATE('2016-11-30 21:05:43', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2016-11-30 21:05:43', 'YYYY-MM-DD HH24:MI:SS'), 'note', null, '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_NOTE_GAINS', 'Gains', '心得记录', '0', TO_DATE('2016-12-01 21:05:36', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2016-12-01 21:12:54', 'YYYY-MM-DD HH24:MI:SS'), 'note', null, '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_AUTO_REPLAY', 'WxAutoReplay', '微信回复管理', '0', TO_DATE('2016-11-06 21:37:48', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:09:32', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '微信公众号自动回复', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_AUTO_REPLAY_NEWSITEM', 'NewsItem', '回复图文管理', '0', TO_DATE('2016-11-06 21:43:26', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:06:21', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '微信公众号自动回复图文消息管理', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_CONF', 'SysConf', '系统参数', '0', TO_DATE('2016-11-27 17:47:24', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:27:28', 'YYYY-MM-DD HH24:MI:SS'), 'system', '系统参数设置，只可编辑', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_DATADIR_INFO', 'DataDir', '数据字典', '0', TO_DATE('2016-11-27 17:50:38', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 20:25:25', 'YYYY-MM-DD HH24:MI:SS'), 'system', '数据字典', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_TEMPLATE', 'WxTemplate', '微信模板', '0', TO_DATE('2016-11-27 21:52:01', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2017-01-10 19:51:01', 'YYYY-MM-DD HH24:MI:SS'), 'wx', '微信模板配置', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_WX_MODULE_MSG', 'ModuleMsg', '模板消息', '0', TO_DATE('2016-11-28 19:23:23', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2016-11-28 19:23:23', 'YYYY-MM-DD HH24:MI:SS'), 'wx', null, '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_SYS_LOG_PARAM', 'SysLogParam', '日志参数', '0', TO_DATE('2017-01-07 20:47:37', 'YYYY-MM-DD HH24:MI:SS'), '0', TO_DATE('2017-01-10 19:37:01', 'YYYY-MM-DD HH24:MI:SS'), 'system', '系统访问日志', '0');
INSERT INTO TB_AUTOCODE_BEAN VALUES ('TB_NOTE_REMINDER', 'Reminder', '事务提醒', '0', TO_DATE('2017-01-11 21:38:55', 'YYYY-MM-DD HH24:MI:SS'), '0', TO_DATE('2017-02-23 09:19:38', 'YYYY-MM-DD HH24:MI:SS'), 'note', '1，事务提醒 ，特殊日子可设置每年提醒，普通事务提醒，默认明天；<br/>2，提醒时间是9点提醒<br/>3，可设置提前提醒', '1');

-- ----------------------------
-- Table structure for TB_MALL_ADVISE
-- ----------------------------
DROP TABLE TB_MALL_ADVISE;
CREATE TABLE TB_MALL_ADVISE (
ID VARCHAR2(50 BYTE) NOT NULL ,
CONTENT VARCHAR2(1024 BYTE) NULL ,
LABEL VARCHAR2(512 BYTE) NULL ,
NUM NUMBER(5) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
USERID VARCHAR2(50 BYTE) NULL ,
MOBILE VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_MALL_ADVISE
-- ----------------------------

-- ----------------------------
-- Table structure for TB_MALL_GOOD_IMG
-- ----------------------------
DROP TABLE TB_MALL_GOOD_IMG;
CREATE TABLE TB_MALL_GOOD_IMG (
ID VARCHAR2(50 BYTE) NOT NULL ,
GOODID VARCHAR2(50 BYTE) NULL ,
IMGTYPE NUMBER(1) NULL ,
IMGURL VARCHAR2(255 BYTE) NULL ,
CREATETIME DATE NULL ,
SORT NUMBER(2) NULL ,
IMGNAME VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_MALL_GOOD_IMG.IMGTYPE IS '图片类型  1：主图  2：详图';
COMMENT ON COLUMN TB_MALL_GOOD_IMG.SORT IS '排序';

-- ----------------------------
-- Records of TB_MALL_GOOD_IMG
-- ----------------------------

-- ----------------------------
-- Table structure for TB_MALL_GOOD_INFO
-- ----------------------------
DROP TABLE TB_MALL_GOOD_INFO;
CREATE TABLE TB_MALL_GOOD_INFO (
GOODID VARCHAR2(50 BYTE) NOT NULL ,
GOODNAME VARCHAR2(1024 BYTE) NULL ,
GOODPRICE NUMBER(12) NULL ,
UNIT VARCHAR2(50 BYTE) NULL ,
IMAGEURL VARCHAR2(1024 BYTE) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
BRAND VARCHAR2(150 BYTE) NULL ,
MADEIN VARCHAR2(150 BYTE) NULL ,
MATERIAL VARCHAR2(255 BYTE) NULL ,
DESCRIPTION NVARCHAR2(255) NULL ,
REMARK NVARCHAR2(255) NULL ,
SKU_NUM VARCHAR2(50 BYTE) NULL ,
ONSALE_STATUS NUMBER(2) DEFAULT 2  NULL ,
ONSALE_TIME TIMESTAMP(6)  NULL ,
WEIGHT VARCHAR2(50 BYTE) NULL ,
WEIGHT_UNIT VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_MALL_GOOD_INFO.SKU_NUM IS 'SKU编码';
COMMENT ON COLUMN TB_MALL_GOOD_INFO.ONSALE_STATUS IS '上架状态  1：上架  2：未上架  3：下架 ';

-- ----------------------------
-- Records of TB_MALL_GOOD_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for TB_NOTE_DIARY
-- ----------------------------
DROP TABLE TB_NOTE_DIARY;
CREATE TABLE TB_NOTE_DIARY (
ID VARCHAR2(50 BYTE) NOT NULL ,
TITLE NVARCHAR2(1024) NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
CONTENT NVARCHAR2(2000) NULL ,
MOBILE VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_NOTE_DIARY
-- ----------------------------

-- ----------------------------
-- Table structure for TB_NOTE_GAINS
-- ----------------------------
DROP TABLE TB_NOTE_GAINS;
CREATE TABLE TB_NOTE_GAINS (
ID VARCHAR2(50 BYTE) NOT NULL ,
LVL VARCHAR2(10 BYTE) NULL ,
LVLNAME NVARCHAR2(255) NULL ,
TITLE NVARCHAR2(512) NULL ,
CONTENT NVARCHAR2(2000) NULL ,
LABELS NVARCHAR2(255) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(155 BYTE) NULL ,
UPDATER VARCHAR2(155 BYTE) NULL ,
MOBILE VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_NOTE_GAINS
-- ----------------------------
INSERT INTO TB_NOTE_GAINS VALUES ('20E7D45A7B3B42E39C57B9FF4B8AB459', 'L2', '普通', '台式机本地数据库', '台式机本地数据库<br/><br/>nfb nfb/nfb123<br/>nfb system/123456 wxbank/wxbank', '本地数据库', TO_TIMESTAMP(' 2017-01-05 16:25:38:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 09:48:54:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('A3BAE015B5BC452D96B023B6B4FECB64', 'L2', '普通', '183.60.124.27  服务器', 'oracle mall mall/mall123 system/system <br/>Administrator/Grg2015', null, TO_TIMESTAMP(' 2017-01-05 16:26:13:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('20EA68CC13774B4A9BA293F5EA3DCE27', 'L2', '普通', '公司svn', 'svn http://10.1.3.70/svn/development cjmei 13905953 <br/><br/>http://10.1.3.251/svn/ cjmei 3150422266 ', null, TO_TIMESTAMP(' 2017-01-05 16:26:36:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('F9B85998A6DB4B9FA7B8F7081F87798B', 'L2', '普通', '笔记本地数据库', 'db system/system123 o2ostd/o2ostd123 nfb/nfb123', null, TO_TIMESTAMP(' 2017-01-05 16:27:20:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('47F0D1DB2ED1459DB92A389B180DDF60', 'L2', '普通', '雅士利会员系统  公众号', '公众号后台连接：https://mp.weixin.qq.com/<br/>【账号一：雅士利】<br/>微信公众号账号：qilin.zhu@yashili.cn<br/>微信公众号密码：yashili.cn<br/><br/>商户号 ：1396595802<br/>key:e5bb23797bfea314a3db43d07dbd6a74<br/><br/>开发者ID<br/>AppID(应用ID)wxdedfc157198677dd<br/>AppSecret(应用密钥)91fdb6bed3be6d74ffa591b12c9b8fd5 隐藏 重置<br/><br/>【账号二：欧式】<br/>微信公众号账号：banghao.yao@yashili.cn<br/>微信公众号密码：yashili.cn<br/><br/>商户号：1398033802<br/>key:c20a32785e1a349bbc99a14c7000c497<br/><br/>开发者ID<br/>AppID(应用ID)wxdad80fe081831194<br/>AppSecret(应用密钥)c1fdc2ce4feae40ed7281c9e7044c444 隐藏 重置<br/><br/>【账号三：多美滋】<br/>微信公众号账号：meihong.fan@yashili.cn<br/>微信公众号密码：yashili.cn<br/><br/>商户号：1398045602<br/>key:34c545616dc5fcac8f7181692d90587c<br/><br/>开发者ID<br/>AppID(应用ID)wx232522c7de9eec04<br/>AppSecret(应用密钥)9f5faef80fe8a027d4eb41b935889517 隐藏 重置', null, TO_TIMESTAMP(' 2017-01-05 16:28:36:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('E202A5EC7E9D48AD9B3422C47E584590', 'L2', '普通', '银联支付', '支付卡：<br/>平安银行借记卡：6216261000000000018<br/>证件号：341126197709218366<br/>手机号：13552535506<br/>密码：123456<br/>姓名：全渠道<br/>短信验证码：123456（wap/控件）111111（PC）<br/>（短信验证码记得点下获取验证码之后再输入）<br/><br/><br/><br/>https://open.unionpay.com/ajweb/index<br/>测试 mecki cjmei4436   777290058134882 ', null, TO_TIMESTAMP(' 2017-01-05 16:32:03:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('2794F66AA76F446085A69FC9E4F4FD8C', 'L2', '普通', 'oracle官网', 'oracle cjmei0221@163.com Cjmei4436', null, TO_TIMESTAMP(' 2017-01-05 16:32:56:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('DA0F8B12E6D24E0EA1AB09003FF1C968', 'L2', '普通', '雅士利会员系统 服务器', '数据库服务器：ip:112.74.170.122(172.18.0.2) ? user:root ? ? ?password:YSLdeskry666 oracle oracle123 <br/>数据库 orcl system/System123 ysl_member/ysl_member123456<br/><br/>会员系统web：ip:112.74.185.128(172.18.0.1) ? ?user:root ? ? password:YSLdeskry666<br/><br/><br/>vip_manage/vip_manage666666 <br/>dmz_vip_mobile/dmz123<br/>os_vip_mobile/os123<br/>ysl_vip_mobile/ysl123<br/><br/>sn数据来源：<br/>sqlserver.jdbc.driverClass=com.microsoft.sqlserver.jdbc.SQLServerDriver<br/>sqlserver.jdbc.jdbcUrl=jdbc:sqlserver://61.146.92.248:62810;instanceName=SAP;DatabaseName=SAP;integratedSecurity=false <br/>sqlserver.jdbc.user=grg_sn_pn<br/>sqlserver.jdbc.password=YSLdeskry111', null, TO_TIMESTAMP(' 2017-01-05 16:33:48:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('8B198DBAF62C4AEDBA28199AB3308ED7', 'L2', '普通', '腾讯地图', '腾讯地址获取经纬度：&lt;http://lbs.qq.com/tool/getpoint/index.html', null, TO_TIMESTAMP(' 2017-01-05 16:34:14:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('17DC0BC52B8F40F4A195F046F46C1BA0', 'L2', '普通', 'linux 安装jdk', '安装jdk-7u79-linux-x64.rpm安装包<br/><br/>先执行以下命令给所有用户添加可执行的权限<br/><br/>#chmod +x jdk-7u79-Linux-x64.rpm<br/><br/>//重点是下面的命令<br/><br/>执行rpm -ivh 命令，安装jdk-7u79-linux-x64.rpm<br/><br/>#rpm -ivh jdk-7u79-linux-x64.rpm<br/><br/>出现安装协议等，按接受即可。<br/><br/>配置环境变量的方法1. 修改/etc/profile文件 <br/>如果你的计算机仅仅作为开发使用时推荐使用这种方法，因为所有用户的shell都有权使用这些环境变量，可能会给系统带来安全性问题。 <br/>·用文本编辑器打开/etc/profile <br/>·在profile文件末尾加入： <br/>export JAVA_HOME=/usr/local/jdk1.7.0_71<br/>export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar<br/>export PATH=$JAVA_HOME/bin:$PATH<br/><br/>加载刚设置的变量<br/>source /etc/profile', null, TO_TIMESTAMP(' 2017-01-05 16:35:27:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('D8FC89A406724224B2B5E2BA571476F8', 'L3', '技术', 'oracle创建序列', 'CREATE SEQUENCE emp_sequence  --序列名<br/>INCREMENT BY 1   -- 每次加几个  <br/>START WITH 1       -- 从1开始计数  <br/>NOMAXVALUE        -- 不设置最大值  <br/>NOCYCLE               -- 一直累加，不循环  <br/>CACHE 10;', null, TO_TIMESTAMP(' 2017-01-06 10:25:17:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-07 10:37:05:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('5CD08770260843729F6A2FC0D69B6693', 'L3', '技术', '河北银行微信银行 环境配置', '测试环境<br/><br/>服务号<br/>hebbank1@126.com 	Hebbank20140217<br/>服务号名称	appid	appsecret<br/>朋友财富	wxf48a1a7124d13f7d	5db7fe8ec4d72a14a402627f32b25b93<br/><br/>1309437801@1309437801<br/>548093<br/><br/>企业号<br/>hebbank2@126.com	Hebbank20160110<br/>服务号名称	CorpID	Secret<br/>河北银行朋友财富	wx63ff6d3b16c791ec 	iM4VNtAUpUJI41MUcaA-Dj3dRFwZmcWjLi2NAWsz8NTevBuw8dTMa3vAPRkttXG7<br/><br/>IP	端口	用户名	用户密码	数据库名<br/>APP服务器	139.9.0.125	7002	wxapp	wxapp	<br/>数据库服务器	139.3.1.31	1521	wechat	wechat	wechat2<br/>Web服务器	139.9.0.124	8080		<br/><br/>生产环境<br/>swei303@126.com	hbyhgfyxgsa	wxf6295d28ad099db1	da0938edd51ab5a94a5e3ef335615b77<br/><br/>商户号 1240406702@1240406702 405195 河北银行 wxf6295d28ad099db1	<br/><br/>商户号 1328450101@1328450101 019560 河北银行朋友财富 wx63ff6d3b16c791ec<br/>', '河北银行', TO_TIMESTAMP(' 2017-02-07 10:30:46:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-08 14:49:57:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('1529A5607C434714BA56E21E4AFE6E40', 'L3', '技术', 'oracle 账户被锁', 'SYS@huiyi>alter user scott account unlock;<br/>User altered.', 'oralce', TO_TIMESTAMP(' 2017-02-17 12:00:49:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-17 12:01:05:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('14830583053C4492A6280E467D5C98ED', 'L2', '普通', '你可以不成功，但是不能不成长', '还记得我第一次采访基辛格博士，那时我还在美国留学，刚刚开始做访谈节目，特别没有经验。问的问题都是东一榔头，西一棒子的，比如问：那时周总理请你吃北京烤鸭，你吃了几只啊？<br/><br/>后来在中美建交30周年时，我再次采访了基辛格博士。那时我就知道再也不能问北京烤鸭这类问题了。虽然只有半小时，我们的团队把所有有关的资料都搜集了，从他在哈佛当教授时写的论文，演讲，到他的传记，有那么厚厚的一摞，还有七本书。都看完了，我也晕了，记不清看的是什么。虽然采访只有27分钟，但非常有效。<br/><br/>真是准备了一桶水，最后只用了一滴。但是你这些知识的储备，都能使你在现场把握住问题的走向。<br/><br/>这个采访做完，很多外交方面的专家认为很有深度。虽然我看了那么多资料，可能能用上的也就一两个问题，但事先准备绝对是有用的。所以我一直认为要做功课。我不是一个特别聪明的人，但还算是一个勤奋的人。通过做功课来弥补自己的不足。<br/><br/>我做电视已经17年了，中间也经历了许多挫折。这让我很苦恼，因为我觉得自己已经这么努力了，甚至怀孕的时候，还在进行商业谈判。从小到大，我所接受的教育就是：只要你足够努力，你就会成功。但后来不是这样的。如果一开始，你的策略、你的定位有偏差的话，你无论怎样努力也是不能成功的。<br/><br/>后来我去上海的中欧商学院进修CEO课程，一位老师讲到一个商人和一个士兵的区别：士兵是接到一个命令，哪怕打到最后一发子弹，牺牲了，也要坚守阵地。而商人好像是在一个大厅，随时要注意哪个门能开，他就从哪出去。一直在寻找流动的机会，并不断进出，来获取最大的商业利益。所以听完，我就心中有数了——我自己不是做商人的料。虽然可以很勤奋地去做，但从骨子里这不是我的比较优势。<br/><br/>在我职业生涯的前15年，我都是一直在做加法，做了主持人，我就要求导演：是不是我可以自己来写台词？写了台词，就问导演：可不可以我自己做一次编辑？做完编辑，就问主任：可不可以让我做一次制片人？做了制片人就想：我能不能同时负责几个节目？负责了几个节目后就想能不能办个频道？人生中一直在做加法，加到阳光卫视，我知道了，人生中，你的比较优势可能只有一项或两项。<br/><br/>在做完一系列的加法后，我想该开始做减法了。因为我觉得我需要有一个平衡的生活。我不能这样疯狂地做下去，所以就开始做减法。那么今天我想把自己定位于：一个懂得市场规律的文化人，一个懂得和世界交流的文化人。人在失败中更能认识自己的比较优势。当然我也希望大家付出的代价不要太大就能了解自己的比较优势和缺陷所在。<br/><br/>这一辈子你可以不成功，但是不能不成长。<br/><br/>我想说的是每个人都在成长，这种成长是一个不断发展的动态过程。<br/><br/>也许你在某种场合和时期达到了一种平衡，而平衡是短暂的，可能瞬间即逝，不断被打破。成长是无止境的，生活中很多事是难以把握的，甚至爱情，你可能会变，那个人也可能会变；但是成长是可以把握的，这是对自己的承诺。<br/><br/>我们虽然再努力也成为不了刘翔，但我们仍然能享受奔跑。<br/><br/>可能有人会阻碍你的成功，却没人能阻止你的成长。<br/><br/>换句话说，这一辈子你可以不成功，但是不能不成长！<br/>', null, TO_TIMESTAMP(' 2017-01-05 15:38:13:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('390769A205584B2D90FE078D018DDB58', 'L2', '普通', '一生定要美丽一次', '生长在非洲荒漠地带的依米花，默默无闻，少有人注意过它。许多旅人以为它只是一株草而已。但是，它会在一生中的某个清晨突然绽放出美丽的花朵。<br/><br/>那是无比绚丽的一朵花，似乎要占尽人世间所有色彩一样。它的花瓣儿呈莲叶状儿，每瓣自成一色：红、白、黄、蓝，与非洲大地上空的毒日争艳。<br/><br/>但是，它的花期很短，最多只有两天。两天后它就会随着母株一起枯萎，开花意味着它的生命的终结。<br/><br/>在非洲的荒漠地带，植物的生长需要水分，而开花的植物对水分的需求更大。非洲一般植物都有庞大的根系采水，以供自身的水分需求。但是依米花没有根系，它只有惟一的一条主根，孤独地蜿蜒盘曲着钻入地底深处，寻找有水的地方。那需要幸运和顽强努力，一株依米花往往需要四至五年的时间在干燥的沙漠里寻找水源，然后一点点积聚养分，在完成蓓蕾所需要的全部养分后，它开花了！所以在它最美丽的时候，它因耗尽了自己的所有的养分而凋零。<br/><br/>用五年的时间为开一朵花努力，这是何等顽强而心酸的事情。假若依米花生长在水草丰沃的地方，它将会美丽一辈子的，偏偏，它的家乡在荒漠。<br/><br/>这个世界上，万物都有灿烂一回的时候，这是上苍赐给万物的权利。<br/><br/>人要比依米花智慧和理性，人想灿烂一回的理想要比依米花更强烈。但我们却往往没有一生都不屈不挠和努力，在遭遇困难和阻挠的时候，往往接受环境给予自己安排的命运。<br/><br/>人生的道路有几十年，但像依米花那样地勇往直前的岁月真的太少了。用一生定要美丽一次的心情去努力和坚持，每个人都会比现在做得更好！<br/>', null, TO_TIMESTAMP(' 2017-01-05 15:28:31:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('38695C238CED4B2BBD999ED229CD1FD7', 'L2', '普通', '泉州银行', '联系人：骆剑峰  13459137419 泉州市丰泽区泉秀街181号恒祥大厦（客运中心站对面）<br/>', null, TO_TIMESTAMP(' 2017-01-05 15:58:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('0FF3F7325DA940949DB6C36E44A1A478', 'L2', '普通', '公司禅道登录账号', 'http://10.1.3.159:81/zentao/bug-browse-42-byModule-1472.html  cjmei grgcjmei', null, TO_TIMESTAMP(' 2017-01-05 16:21:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('0A1F88E3EF894E4393DCB856DC9DA4B0', 'L2', '普通', '菜鸟工具', 'https://c.runoob.com/', null, TO_TIMESTAMP(' 2017-01-05 16:22:12:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('BE2605A3DD3D4D509F553179BCD62BB4', 'L2', '普通', '淘宝svn', 'http://code.taobao.org/login/ cjmei cjmei4436', null, TO_TIMESTAMP(' 2017-01-05 16:22:38:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('D83B81F5AAB84D868970A45E593D6D55', 'L2', '普通', '支付宝', '【直供系统支付宝账号】 <br/>网址：https://authsu18.alipay.com/login/index.htm <br/>账号：xiehuang@yashili.cn <br/>密码：yashili123456<br/><br/>开发平台<br/>https://doc.open.alipay.com/doc2/detail?treeId=60&articleId=103564&docType=1', null, TO_TIMESTAMP(' 2017-01-05 16:23:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('FBCCBAF593AE4A17A83262E209F70BEE', 'L2', '普通', '测试公众号 18680221791', '<br/><br/>appID<br/>wxedeb2e122e880665<br/>appsecret<br/>b1603f9f6bc6ca89342002745258d1c2', null, TO_TIMESTAMP(' 2017-01-05 16:23:45:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('06F1FCBDA0DF46F5861D06D1E4BA6A9E', 'L2', '普通', '测试012 公众号', '<br/>appid：wx1102d8ed48b46f5e<br/>appsecret：c655d6de4b8fa4587fca8691ed478996', null, TO_TIMESTAMP(' 2017-01-05 16:24:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 08:49:52:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('14F9AA12887B41C5BCA5431B6C91F522', 'L3', '技术', 'oracle 批量插入数据', 'insert tabName1(x,x) select t.x,t.x from tabName2', 'oracle', TO_TIMESTAMP(' 2017-01-09 10:11:51:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 10:12:51:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('752B70507E48402BA2739869FA8452A0', 'L3', '技术', 'Oracle 树操作 prior ', 'http://www.cnblogs.com/colder/p/4838574.html<br/><br/>查找一个节点的所有直属子节点（所有后代）: select * from tb_menu m start with m.id=1 connect by m.parent=prior m.id;<br/><br/>查找一个节点的所有直属父节点（祖宗）: select * from tb_menu m start with m.id=38 connect by prior m.parent=m.id;<br/><br/>列出当前节点的根节点。 在前面说过，根节点就是start with开始的地方。<br/>select connect_by_root MENUID, SYS_MENU.*<br/>from SYS_MENU <br/>start with MENUID = ''0B51BECA93744E6484F0F6EC0B753686''<br/>connect by prior PARENTID = MENUID;<br/><br/>列出当前节点是否为叶子。 这个比较常见，尤其在动态目录中，在查出的内容是否还有下级节点时，这个函数是很适用的。<br/>select connect_by_isleaf, SYS_MENU.*<br/>from SYS_MENU<br/>start with PARENTID = ''1''<br/>connect by PARENTID = prior MENUID;', 'prior  ', TO_TIMESTAMP(' 2017-01-11 13:28:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-11 13:41:57:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('95324A1C17C44AA9A7B15B0465FBF203', 'L3', '技术', '农历日期', 'http://www.cnblogs.com/jihua/p/jsrili.html?_t_t_t=0.6354162965297201<br/><br/>http://www.open-open.com/code/view/1430808632757', 'java 农历', TO_TIMESTAMP(' 2017-01-11 14:30:37:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-11 14:31:56:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('C2CBB586CCB44929B005538B4ADAA3C3', 'L3', '技术', '电商组织架构设计', '主要使用用户类型   公司管理员  商铺人员  客户<br/>主要形式  公司 -- 商铺 -- 会员    公司 -- 会员', '电商 架构', TO_TIMESTAMP(' 2017-01-12 12:39:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-07 10:30:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('8434ADBB46BD4894A9C5D125E7EFFFDB', 'L3', '技术', 'oracle批量数据处理', '复制表 create table SYS_BUSINESS_UNIT_BAK as select * from SYS_BUSINESS_UNIT where 1=2<br/><br/>复制数据 insert into bs_log2 select * from bs_log where log_id>''3049''  ', 'oracle', TO_TIMESTAMP(' 2017-02-08 14:46:06:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-08 14:48:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('F384674A4A20478E9FB319BB7EE0F1DC', 'L3', '技术', 'oracle行级锁解锁', '1，查看数据库锁,诊断锁的来源及类型 select object_id,session_id,locked_mode from v$locked_object;<br/>2，找出数据库的serial#,以备杀死： select t2.username,t2.sid,t2.serial#,t2.logon_time from v$locked_object t1,v$session t2 where t1.session_id=t2.sid order by t2.logon_time;<br/><br/>3、杀死该session alter system kill session ''77,7042'';<br/>', 'oracle', TO_TIMESTAMP(' 2017-02-14 12:03:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-14 12:04:42:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');
INSERT INTO TB_NOTE_GAINS VALUES ('BCE51B0748744102AF7190D105E7A65C', 'L2', '普通', 'C语言中文网', '网址：http://c.biancheng.net/cpp/<br/>会员：mecy mecy4436', 'C语言中文网 学习', TO_TIMESTAMP(' 2017-02-24 09:55:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-24 09:56:03:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');

-- ----------------------------
-- Table structure for TB_NOTE_QUESTION
-- ----------------------------
DROP TABLE TB_NOTE_QUESTION;
CREATE TABLE TB_NOTE_QUESTION (
ID VARCHAR2(50 BYTE) NOT NULL ,
LVL VARCHAR2(10 BYTE) NULL ,
LVLNAME NVARCHAR2(255) NULL ,
QUESTION NVARCHAR2(512) NULL ,
SOLUTION NVARCHAR2(2000) NULL ,
LABELS NVARCHAR2(255) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(155 BYTE) NULL ,
UPDATER VARCHAR2(155 BYTE) NULL ,
MOBILE VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_NOTE_QUESTION
-- ----------------------------
INSERT INTO TB_NOTE_QUESTION VALUES ('371726855CC540C59B8452B121C48F6A', 'L2', '较严重', 'tomcat连接数过大', '最近服务端上线部署运行一段时间，app访问服务端速度很慢甚至不能访问服务端获取数据<br/><br/>CLOSE_WAIT是只在服务器与客户端通信过程中，因服务器发生了socket未关导致的closed_wait发生，致使监听port打开的句柄数到了过大，且均处于close_wait的状态，最终造成配置的port被占满导致tomcat无法再有多余的连接可供访问，无法再进行通信。<br/><br/>解决办法：<br/><br/>1.修改tomcat连接数，增加acceptCount和maxThreads这两个属性的值，并且使acceptCount大于等于maxThreads：<br/><br/><Connector port=8080 protocol=HTTP/1.1   <br/>           connectionTimeout=20000   <br/>           redirectPort=8443 acceptCount=500 maxThreads=400 />  <br/>2.修改linux的TCP超时时间限制（影响全局，需谨慎）', 'tomcat', TO_TIMESTAMP(' 2017-02-24 08:46:30:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-24 08:48:26:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'admin', '18680221791');

-- ----------------------------
-- Table structure for TB_NOTE_REMINDER
-- ----------------------------
DROP TABLE TB_NOTE_REMINDER;
CREATE TABLE TB_NOTE_REMINDER (
ID VARCHAR2(50 BYTE) NULL ,
REMIND_TYPE NUMBER(2) NULL ,
CALENDAR_TYPE NUMBER(1) NULL ,
REMIND_DATE VARCHAR2(50 BYTE) NULL ,
REMIND_TIME VARCHAR2(30 BYTE) NULL ,
IS_REPEAT NUMBER(1) NULL ,
REMIND_CONTENT NVARCHAR2(200) NULL ,
BEFORE_DAYS NUMBER(3) NULL ,
IS_BEFORE NUMBER(1) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR NVARCHAR2(100) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_NOTE_REMINDER
-- ----------------------------
INSERT INTO TB_NOTE_REMINDER VALUES ('34D5370926034C4FA33B5DD312CA4CD4', '1', '1', '2', '1', '1', '3', '1', '1', TO_TIMESTAMP(' 2017-02-23 09:25:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-23 09:33:26:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1');

-- ----------------------------
-- Table structure for TB_ORG_INFO
-- ----------------------------
DROP TABLE TB_ORG_INFO;
CREATE TABLE TB_ORG_INFO (
ORGID VARCHAR2(50 BYTE) NOT NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
ORGNAME VARCHAR2(256 BYTE) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
USEFLAG NUMBER(1) DEFAULT 1  NULL ,
PARENTID VARCHAR2(50 BYTE) DEFAULT 0  NULL ,
LVL NUMBER(1) DEFAULT 1  NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL ,
ORGTYPE NUMBER(1) DEFAULT 0  NULL ,
ISMAIN NUMBER(1) DEFAULT 0  NULL ,
CHILDNUM NUMBER(4) DEFAULT 0  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_ORG_INFO.USEFLAG IS '0:禁用 1：启用';
COMMENT ON COLUMN TB_ORG_INFO.LVL IS '最高管理员';
COMMENT ON COLUMN TB_ORG_INFO.ORGTYPE IS '0:普通组织  1：公司';
COMMENT ON COLUMN TB_ORG_INFO.ISMAIN IS '0:非主 1：主公司';
COMMENT ON COLUMN TB_ORG_INFO.CHILDNUM IS '子节点数';

-- ----------------------------
-- Records of TB_ORG_INFO
-- ----------------------------
INSERT INTO TB_ORG_INFO VALUES ('N', 'admin', '农富宝', TO_DATE('2016-10-20 20:59:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 20:59:46', 'YYYY-MM-DD HH24:MI:SS'), '1', '0', '1', 'N', '1', '0', '2');
INSERT INTO TB_ORG_INFO VALUES ('Marks', 'admin', '痕迹', TO_DATE('2017-01-07 22:59:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-07 22:59:45', 'YYYY-MM-DD HH24:MI:SS'), '1', '0', '1', 'Marks', '1', '1', '1');
INSERT INTO TB_ORG_INFO VALUES ('Marks01', 'admin', '测试1', TO_DATE('2017-02-17 21:50:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-17 21:50:15', 'YYYY-MM-DD HH24:MI:SS'), '1', 'Marks', '2', 'Marks', '0', '0', '0');
INSERT INTO TB_ORG_INFO VALUES ('test2', 'admin', 'test2', TO_DATE('2017-01-10 21:49:03', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-10 21:49:03', 'YYYY-MM-DD HH24:MI:SS'), '1', 'N', '2', 'N', '0', '0', '0');
INSERT INTO TB_ORG_INFO VALUES ('test1', 'admin', 'test1', TO_DATE('2017-01-10 21:48:43', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-10 21:48:43', 'YYYY-MM-DD HH24:MI:SS'), '1', 'N', '2', 'N', '0', '0', '0');

-- ----------------------------
-- Table structure for TB_SYS_CONF
-- ----------------------------
DROP TABLE TB_SYS_CONF;
CREATE TABLE TB_SYS_CONF (
CKEY VARCHAR2(50 BYTE) NOT NULL ,
CVALUE VARCHAR2(2000 BYTE) NULL ,
CKEYNAME VARCHAR2(100 BYTE) NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_SYS_CONF.CKEY IS '主键';
COMMENT ON COLUMN TB_SYS_CONF.CVALUE IS '主键值';
COMMENT ON COLUMN TB_SYS_CONF.CKEYNAME IS '主键名称';
COMMENT ON COLUMN TB_SYS_CONF.COMPANYID IS '主键类型';
COMMENT ON COLUMN TB_SYS_CONF.CREATETIME IS '创建时间';
COMMENT ON COLUMN TB_SYS_CONF.UPDATETIME IS '更新时间';
COMMENT ON COLUMN TB_SYS_CONF.CREATOR IS '创建者';

-- ----------------------------
-- Records of TB_SYS_CONF
-- ----------------------------
INSERT INTO TB_SYS_CONF VALUES ('wx_host_url', 'http://127.0.0.1:6080', '访问center功能路径', null, TO_DATE('2016-11-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-08 18:31:20', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_CONF VALUES ('out_log_flag', 'N', '输出打印日志标识(Y:输出 N:不输出)', null, null, TO_DATE('2017-02-23 09:36:00', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for TB_SYS_DATADIR_INFO
-- ----------------------------
DROP TABLE TB_SYS_DATADIR_INFO;
CREATE TABLE TB_SYS_DATADIR_INFO (
CKEY VARCHAR2(50 BYTE) NOT NULL ,
PARENTKEY VARCHAR2(50 BYTE) NOT NULL ,
CVALUE VARCHAR2(200 BYTE) NULL ,
COMPANYID VARCHAR2(200 BYTE) NULL ,
SORT NUMBER(4) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.CKEY IS '主键';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.PARENTKEY IS '父主键';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.CVALUE IS '主键值';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.COMPANYID IS '类型名称';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.SORT IS '排序';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.CREATETIME IS '创建时间';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.UPDATETIME IS '更新时间';
COMMENT ON COLUMN TB_SYS_DATADIR_INFO.CREATOR IS '创建者';

-- ----------------------------
-- Records of TB_SYS_DATADIR_INFO
-- ----------------------------
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('question_level', '0', '问题级别', null, '2', TO_DATE('2016-11-30 21:40:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:40:15', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L1', 'question_level', '严重', null, '5', TO_DATE('2016-11-30 21:45:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:45:19', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L3', 'question_level', '一般', null, '3', TO_DATE('2016-11-30 21:45:55', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:45:55', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('wxtemplate_dairy', 'wxtemplate_ywtype', '日记提醒', null, '1', TO_DATE('2016-11-27 22:13:17', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 22:13:17', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L2', 'question_level', '较严重', null, '4', TO_DATE('2016-11-30 21:44:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:45:30', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L2', 'gains_level', '普通', null, '2', TO_DATE('2016-12-01 21:51:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:51:51', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L1', 'gains_level', '经验', null, '3', TO_DATE('2016-12-01 21:51:21', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:57:56', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('wxtemplate_ywtype', '0', '微信模板-业务类型', null, '1', TO_DATE('2016-11-27 22:12:48', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 22:12:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('gains_level', '0', '所得级别', null, '2', TO_DATE('2016-12-01 21:50:31', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:50:31', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_DATADIR_INFO VALUES ('L3', 'gains_level', '技术', null, '1', TO_DATE('2016-12-01 21:52:48', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:52:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin');

-- ----------------------------
-- Table structure for TB_SYS_FUNC
-- ----------------------------
DROP TABLE TB_SYS_FUNC;
CREATE TABLE TB_SYS_FUNC (
FUNCID VARCHAR2(50 BYTE) NOT NULL ,
MENUID VARCHAR2(50 BYTE) NOT NULL ,
OPERID VARCHAR2(50 BYTE) NOT NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
URL VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_FUNC
-- ----------------------------
INSERT INTO TB_SYS_FUNC VALUES ('FB548F9A221041E1A70A0A30D12F3457', '20161016024730740', 'query', TO_DATE('2016-10-16 02:48:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-16 02:48:00', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/list');
INSERT INTO TB_SYS_FUNC VALUES ('49A155C4DBBF4A56907BFA4B60B4FAF1', '20161016024730740', 'edit', TO_DATE('2016-10-16 02:48:23', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-16 02:48:23', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/update');
INSERT INTO TB_SYS_FUNC VALUES ('9A05C58D23E64D82A8A0FC1448EB732D', '20161016024730740', 'add', TO_DATE('2016-10-16 02:48:12', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-16 02:48:12', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/save');
INSERT INTO TB_SYS_FUNC VALUES ('699C293D715340D392CD4E113B864D20', '20161016024730740', 'delete', TO_DATE('2016-10-16 02:48:34', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-16 02:48:34', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/delete');
INSERT INTO TB_SYS_FUNC VALUES ('C3A5BC0B6477434E9E3942C16353834A', 'diary', 'edit', TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/diary/update');
INSERT INTO TB_SYS_FUNC VALUES ('9CFAB7B9645F4EB48F69A3E900B51CDB', 'diary', 'delete', TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/diary/delete');
INSERT INTO TB_SYS_FUNC VALUES ('6BFC445EB2FC46D3B49582B319BB503E', '20161016024730740', 'autoCodeBtn', TO_DATE('2016-10-20 02:10:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 02:10:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/autocode');
INSERT INTO TB_SYS_FUNC VALUES ('0784E15BB48B4061A038499DC17B45C3', 'sysRole', 'edit', TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysRole/update');
INSERT INTO TB_SYS_FUNC VALUES ('34D4A51F71A3452DA20B5C89272F7121', 'diary', 'query', TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/diary/list');
INSERT INTO TB_SYS_FUNC VALUES ('729986573F3F498AB804BD1B7CC58466', 'diary', 'add', TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-19 21:08:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/diary/save');
INSERT INTO TB_SYS_FUNC VALUES ('0EE456741D42426DB6448E5C6DDFDA8E', 'sysRole', 'delete', TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysRole/delete');
INSERT INTO TB_SYS_FUNC VALUES ('40B743A6291A435AAE743CA93499AD8F', 'orgInfo', 'query', TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/list');
INSERT INTO TB_SYS_FUNC VALUES ('475B85B975C441E9B720FAC82ECAB89A', 'orgInfo', 'add', TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/save');
INSERT INTO TB_SYS_FUNC VALUES ('D5FFAAAD152F4023BDEC443B8CECA7C6', 'sysRole', 'query', TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysRole/list');
INSERT INTO TB_SYS_FUNC VALUES ('588848E727F14FCAA21623A6894C2DDB', 'sysRole', 'add', TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 03:23:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysRole/save');
INSERT INTO TB_SYS_FUNC VALUES ('35EA71BD598246AFB5769EA6730A1254', 'orgInfo', 'edit', TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/update');
INSERT INTO TB_SYS_FUNC VALUES ('165FEFC91D0F4A26B232D2A1D59F4D37', 'orgInfo', 'delete', TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 04:04:05', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/delete');
INSERT INTO TB_SYS_FUNC VALUES ('D650F41753614EF68D65AD237334627C', 'wxAccount', 'query', TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAccount/list');
INSERT INTO TB_SYS_FUNC VALUES ('AE5067796D694BAFB287D18529BAFFE2', 'wxAccount', 'add', TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAccount/save');
INSERT INTO TB_SYS_FUNC VALUES ('A9EDBB5CBFAA49CEB53C12A3C516BE85', 'wxAccount', 'edit', TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAccount/update');
INSERT INTO TB_SYS_FUNC VALUES ('7C045D9CA9D5456FAF856490836AA6C8', 'wxAccount', 'delete', TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 21:24:27', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAccount/delete');
INSERT INTO TB_SYS_FUNC VALUES ('E0214CC842524D61A1CADB4B25F28C6D', '20161023003925948', 'query', TO_DATE('2016-10-23 00:39:48', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:39:48', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/framelist');
INSERT INTO TB_SYS_FUNC VALUES ('751789E53BAA42428D477E49B00572C5', '20161023003925948', 'add', TO_DATE('2016-10-23 00:39:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:39:59', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/save');
INSERT INTO TB_SYS_FUNC VALUES ('140845F24CC241B7AB3783B93F98724B', '20161023003925948', 'edit', TO_DATE('2016-10-23 00:40:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:40:09', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/update');
INSERT INTO TB_SYS_FUNC VALUES ('2DA34B5B4BF643E89DD5B6C791CD630A', '20161023003925948', 'delete', TO_DATE('2016-10-23 00:40:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:40:19', 'YYYY-MM-DD HH24:MI:SS'), null, '/orgInfo/delete');
INSERT INTO TB_SYS_FUNC VALUES ('4C7AA4B348454752BEF6F9EC55402280', 'sysRole', 'addFunc', TO_DATE('2016-10-23 00:47:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:47:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysRole/funclist');
INSERT INTO TB_SYS_FUNC VALUES ('C58C67CD6EA94BB2963C9714C6F9F90B', 'goodInfo', 'query', TO_DATE('2016-10-26 21:13:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/goodInfo/list');
INSERT INTO TB_SYS_FUNC VALUES ('3DA8897C41E8473A99C5492100190412', 'goodInfo', 'add', TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), null, '/goodInfo/save');
INSERT INTO TB_SYS_FUNC VALUES ('2309E4BC9A924651B31F785C830728B6', 'goodInfo', 'edit', TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), null, '/goodInfo/update');
INSERT INTO TB_SYS_FUNC VALUES ('0F54D4F78A8D491FA43C3FBF60A9B1CF', 'goodInfo', 'delete', TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:19', 'YYYY-MM-DD HH24:MI:SS'), null, '/goodInfo/delete');
INSERT INTO TB_SYS_FUNC VALUES ('E24E30A2E2674303B6C9B62B36D79ADC', 'advise', 'query', TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/advise/list');
INSERT INTO TB_SYS_FUNC VALUES ('8890D1E058DB4B7894B2D7B2BCC696A7', 'advise', 'add', TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/advise/save');
INSERT INTO TB_SYS_FUNC VALUES ('A10AF55DA5C548E294DBD10A10F92E46', 'advise', 'edit', TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/advise/update');
INSERT INTO TB_SYS_FUNC VALUES ('062D833DD050478A8B6D5503CD347F60', 'advise', 'delete', TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-26 21:13:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/advise/delete');
INSERT INTO TB_SYS_FUNC VALUES ('2DFE8F4215A34E4AB1A603C36242F923', 'wxMenu', 'syncWx', TO_DATE('2016-11-17 19:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-17 19:03:58', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenu/syncWxMenu');
INSERT INTO TB_SYS_FUNC VALUES ('0CC56B98214E4C8FB8439F341AFEEE28', 'vipInfo', 'resetPwdBtn', TO_DATE('2017-01-08 21:40:52', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 21:40:52', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/resetPwd');
INSERT INTO TB_SYS_FUNC VALUES ('633836EDCC0E40329B2BEBB34FA2B5FB', '2', 'add', TO_DATE('2016-10-23 18:03:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 18:03:59', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysMenu/save');
INSERT INTO TB_SYS_FUNC VALUES ('DA0BA7D60DD6461E85EA1EFB4E56AC1D', '2', 'edit', TO_DATE('2016-10-23 18:04:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 18:04:19', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysMenu/save');
INSERT INTO TB_SYS_FUNC VALUES ('6232F8C5272A489CB66E54091718E5AD', '2', 'query', TO_DATE('2016-10-23 18:03:47', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 18:03:47', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysMenu/list');
INSERT INTO TB_SYS_FUNC VALUES ('831A77AF2FB5418FB6290E19ACB03F72', 'sysUser', 'edit', TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/update');
INSERT INTO TB_SYS_FUNC VALUES ('7F15BED5384E401AA13B8FE99FDD79E5', 'sysUser', 'delete', TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/delete');
INSERT INTO TB_SYS_FUNC VALUES ('FA00FAE5BE8249519544EAB937CED130', 'sysUser', 'query', TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/list');
INSERT INTO TB_SYS_FUNC VALUES ('81F44FFCFB484D1B9B2B28B8B44038FD', 'sysUser', 'add', TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 17:41:22', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/save');
INSERT INTO TB_SYS_FUNC VALUES ('9B746C1302684616B012733A4E791179', 'goodInfo', 'onsaleBtn', TO_DATE('2016-12-07 20:31:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-07 20:31:07', 'YYYY-MM-DD HH24:MI:SS'), null, '/goodSale/onsale');
INSERT INTO TB_SYS_FUNC VALUES ('A4847B5D9E2C404BAFFCA1925B4C651B', '20161203195018623', 'edit', TO_DATE('2016-12-03 19:54:50', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:54:50', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/updatePwd');
INSERT INTO TB_SYS_FUNC VALUES ('6061F2E92C214F4E98AA9F8A6862CD58', '20161203195318395', 'edit', TO_DATE('2016-12-03 19:56:02', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:56:02', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/updateMobile');
INSERT INTO TB_SYS_FUNC VALUES ('A0BEFFBB0FDA42F38280FBE35A670977', 'wxAccount', 'syncWxFans', TO_DATE('2016-12-22 22:30:28', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-22 22:30:28', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxUser/sync');
INSERT INTO TB_SYS_FUNC VALUES ('81B28ED45F1A427ABBA9025E4D917AD0', 'sysLogParam', 'add', TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysLogParam/save');
INSERT INTO TB_SYS_FUNC VALUES ('351B1DF16E6444258F142C4FD767FCEE', 'sysLogParam', 'query', TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysLogParam/list');
INSERT INTO TB_SYS_FUNC VALUES ('A6907ADFCD4B4E048DDA0632C2D5062F', 'sysLogParam', 'edit', TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysLogParam/update');
INSERT INTO TB_SYS_FUNC VALUES ('5AA2258E1404444BAE135783DD56DC03', 'sysLogParam', 'delete', TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-07 20:48:32', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysLogParam/delete');
INSERT INTO TB_SYS_FUNC VALUES ('92078E74B6784886BA2956AE553BFA69', '20160928203125806', 'query', TO_DATE('2016-09-30 14:38:50', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 14:38:50', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysOperate/list');
INSERT INTO TB_SYS_FUNC VALUES ('A716C1E44907420AAD6CA5AC638541C8', '20160928203125806', 'add', TO_DATE('2016-09-30 14:39:01', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 14:39:01', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysOperate/save');
INSERT INTO TB_SYS_FUNC VALUES ('7EF6056FFFDE4EE6BBF84F86EF66BF28', '20160928203125806', 'edit', TO_DATE('2016-09-30 14:39:06', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 14:39:06', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysOperate/save');
INSERT INTO TB_SYS_FUNC VALUES ('0073BE06AA6A49D783E9E033131A5C57', '2', 'addFunc', TO_DATE('2016-09-30 15:43:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 15:43:44', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysMenu/initFunc');
INSERT INTO TB_SYS_FUNC VALUES ('C1060CF0D3CE49A19BB7AEB3AF622B0C', '2', 'delete', TO_DATE('2016-09-30 15:45:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 15:45:46', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysMenu/delete');
INSERT INTO TB_SYS_FUNC VALUES ('37A16BCD5D0E462EB892CDC9BB3D28EA', '20160928203125806', 'delete', TO_DATE('2016-09-30 16:11:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 16:11:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysOperate/delete');
INSERT INTO TB_SYS_FUNC VALUES ('A3E3FFABB3264BEC9D20C47EA542B2F0', 'moduleMsg', 'query', TO_DATE('2016-11-28 19:23:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-28 19:23:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/moduleMsg/list');
INSERT INTO TB_SYS_FUNC VALUES ('E9AFCA0B219A48F2B26C3407B89F6D4F', 'vipInfo', 'query', TO_DATE('2017-01-08 19:55:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 19:55:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/vipInfo/list');
INSERT INTO TB_SYS_FUNC VALUES ('3E71A3CE7AB34607BDC570E72EBB6444', 'qrcode', 'add', TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/qrcode/save');
INSERT INTO TB_SYS_FUNC VALUES ('AFF47427547E413D8A4E6E9D8658BB17', 'qrcode', 'query', TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/qrcode/list');
INSERT INTO TB_SYS_FUNC VALUES ('F43CE8D5ABDB46148E26B8C6A7C513D7', 'wxMenu', 'query', TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenu/list');
INSERT INTO TB_SYS_FUNC VALUES ('CB28B8D3B8E846C7A355249B8A6D14BC', 'wxMenu', 'add', TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenu/save');
INSERT INTO TB_SYS_FUNC VALUES ('374088A1D165445AB7496D87B9A5175E', 'wxMenu', 'edit', TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenu/update');
INSERT INTO TB_SYS_FUNC VALUES ('58F8C1A54B244D07986F391AD5CB9E5D', 'wxUser', 'query', TO_DATE('2016-11-06 19:11:31', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 19:11:31', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxUser/list');
INSERT INTO TB_SYS_FUNC VALUES ('2B12F2FF49C242F4963A550AC1AA4D52', 'qrcode', 'edit', TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/qrcode/update');
INSERT INTO TB_SYS_FUNC VALUES ('E5934CC56BEF43ECBF47AC07890713AC', 'wxMenu', 'delete', TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenu/delete');
INSERT INTO TB_SYS_FUNC VALUES ('0C86A52B779342DA92F4F6027B3251FE', 'wxMenuUrl', 'query', TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenuUrl/list');
INSERT INTO TB_SYS_FUNC VALUES ('805B2E58E7CB46CFAC9629FE35F9E051', 'wxMenuUrl', 'add', TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenuUrl/save');
INSERT INTO TB_SYS_FUNC VALUES ('21B1268FD84F4B1C8945C8E9731F0F49', 'wxMenuUrl', 'edit', TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenuUrl/update');
INSERT INTO TB_SYS_FUNC VALUES ('F9B4C69C5F864657A55BF9560AAD7AC9', 'wxMenuUrl', 'delete', TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:34', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxMenuUrl/delete');
INSERT INTO TB_SYS_FUNC VALUES ('34CC225109974D0296DD538ED1A229C0', 'wxAutoReplay', 'query', TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAutoReplay/list');
INSERT INTO TB_SYS_FUNC VALUES ('941ABAFE35D6480B95D0178B760BB1DB', 'wxAutoReplay', 'add', TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAutoReplay/save');
INSERT INTO TB_SYS_FUNC VALUES ('56AF2BA7BBD643D8B66F1FEDB2F8D650', 'wxAutoReplay', 'edit', TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAutoReplay/update');
INSERT INTO TB_SYS_FUNC VALUES ('A88AB1777C264C8387A4CF7B9C961048', 'wxAutoReplay', 'delete', TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:40', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxAutoReplay/delete');
INSERT INTO TB_SYS_FUNC VALUES ('A3FEA09B72BA41868AA07D6818117AC0', 'newsItem', 'query', TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/newsItem/list');
INSERT INTO TB_SYS_FUNC VALUES ('FB4C99E9FB1A42F19B86FFC3DA761824', 'newsItem', 'add', TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/newsItem/save');
INSERT INTO TB_SYS_FUNC VALUES ('8D4EC97F07AA48C0BA5F5F55A302532E', 'newsItem', 'edit', TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/newsItem/update');
INSERT INTO TB_SYS_FUNC VALUES ('6FB911AF50884CB9B52D3A6D9D3D4B03', 'newsItem', 'delete', TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-06 21:45:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/newsItem/delete');
INSERT INTO TB_SYS_FUNC VALUES ('55371B38A22F4D078947A10E51837D47', 'qrcode', 'delete', TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-25 11:34:29', 'YYYY-MM-DD HH24:MI:SS'), null, '/qrcode/delete');
INSERT INTO TB_SYS_FUNC VALUES ('18B306C4A74149609A3FDC36F86F902A', 'sysConf', 'query', TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysConf/list');
INSERT INTO TB_SYS_FUNC VALUES ('B0E3BAAA2955492FADE23C35F774BCC3', 'sysConf', 'add', TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysConf/save');
INSERT INTO TB_SYS_FUNC VALUES ('B31E5C8F9DDB434CA70DDCC8204A74F3', 'sysConf', 'edit', TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysConf/update');
INSERT INTO TB_SYS_FUNC VALUES ('431D29CBA6B64D92821180C1DB4335DE', 'sysConf', 'delete', TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:30', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysConf/delete');
INSERT INTO TB_SYS_FUNC VALUES ('F52536BB355D4216AA5F541601ABA4E0', 'dataDir', 'query', TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), null, '/dataDir/list');
INSERT INTO TB_SYS_FUNC VALUES ('C50921BE08CE4C47BEC824DA733F4CFD', 'dataDir', 'add', TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), null, '/dataDir/save');
INSERT INTO TB_SYS_FUNC VALUES ('88EA18C8BA4847119DEFC9146B7C7F1F', 'dataDir', 'edit', TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), null, '/dataDir/update');
INSERT INTO TB_SYS_FUNC VALUES ('3EC98DB80F6440269D3628766217A68E', 'dataDir', 'delete', TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 17:53:51', 'YYYY-MM-DD HH24:MI:SS'), null, '/dataDir/delete');
INSERT INTO TB_SYS_FUNC VALUES ('A947C38F31814E67830E922BA2FD5926', 'wxTemplate', 'query', TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxTemplate/list');
INSERT INTO TB_SYS_FUNC VALUES ('352724802F66473AA600570AB00C61D4', 'wxTemplate', 'add', TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxTemplate/save');
INSERT INTO TB_SYS_FUNC VALUES ('CB6D94D479C34121A38F5B40B91106D2', 'wxTemplate', 'edit', TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxTemplate/update');
INSERT INTO TB_SYS_FUNC VALUES ('8B31D84CC47A466C8132F6C0D212D442', 'wxTemplate', 'delete', TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 21:52:15', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxTemplate/delete');
INSERT INTO TB_SYS_FUNC VALUES ('440141C13AB345BC991774CDD7614909', 'question', 'query', TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/question/list');
INSERT INTO TB_SYS_FUNC VALUES ('E95BB25BFFAF4C13864DBC3A02B9306D', 'question', 'add', TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/question/save');
INSERT INTO TB_SYS_FUNC VALUES ('CD2780A03F02413E9D18F66323064595', 'question', 'edit', TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/question/update');
INSERT INTO TB_SYS_FUNC VALUES ('F26FD1B3DCBF43D38E37529BC60E12F3', 'question', 'delete', TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:07:18', 'YYYY-MM-DD HH24:MI:SS'), null, '/question/delete');
INSERT INTO TB_SYS_FUNC VALUES ('BFBB32ADDE9C42B4ADECACACC04DF0A5', 'gains', 'edit', TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), null, '/gains/update');
INSERT INTO TB_SYS_FUNC VALUES ('56FC1334D6A54B28B41C552156EA7E2C', 'gains', 'delete', TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), null, '/gains/delete');
INSERT INTO TB_SYS_FUNC VALUES ('B527659F90594CD4844E2A2F22223E2A', 'vipInfo', 'activeBtn', TO_DATE('2017-01-08 21:42:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 21:42:39', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/updateActiveFlag');
INSERT INTO TB_SYS_FUNC VALUES ('F2B99E17C4EC4CB399A1F4D435C28909', 'gains', 'query', TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), null, '/gains/list');
INSERT INTO TB_SYS_FUNC VALUES ('9E081346B9F5409EB8E8D79A988515E3', 'gains', 'add', TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-01 21:13:00', 'YYYY-MM-DD HH24:MI:SS'), null, '/gains/save');
INSERT INTO TB_SYS_FUNC VALUES ('86BC5FE8B3624C5B96922DA0D299D843', 'sysLog', 'query', TO_DATE('2016-11-27 21:09:57', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-27 21:09:57', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysLog/list');
INSERT INTO TB_SYS_FUNC VALUES ('10ACD5DC793A4D5A9F4228195CF57B77', 'wxUser', 'dairyBtn', TO_DATE('2016-12-03 18:50:26', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 18:50:26', 'YYYY-MM-DD HH24:MI:SS'), null, '/wxUser/dairy');
INSERT INTO TB_SYS_FUNC VALUES ('028280270812450986EE5E8552E692EC', 'sysUser', 'resetPwdBtn', TO_DATE('2016-12-03 19:27:01', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:27:01', 'YYYY-MM-DD HH24:MI:SS'), null, '/sysUser/resetPwd');
INSERT INTO TB_SYS_FUNC VALUES ('4A911E4E08FE45BF95EE3CC1BA5F3B78', '20161016024730740', 'introBtn', TO_DATE('2017-01-09 23:03:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:44', 'YYYY-MM-DD HH24:MI:SS'), null, '/autoCode/autocodeIntroFile');
INSERT INTO TB_SYS_FUNC VALUES ('E5D1A0B765CE47E2933BAD1042E502DB', 'reminder', 'query', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/reminder/list');
INSERT INTO TB_SYS_FUNC VALUES ('6353C6E2A9B34E0B898DE04E95461D43', 'reminder', 'add', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/reminder/save');
INSERT INTO TB_SYS_FUNC VALUES ('D96F3B8972264040BD3C906EEF380675', 'reminder', 'edit', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/reminder/update');
INSERT INTO TB_SYS_FUNC VALUES ('95D0615FA08743F998C6B2997314FE9A', 'reminder', 'delete', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null, '/reminder/delete');

-- ----------------------------
-- Table structure for TB_SYS_LOG
-- ----------------------------
DROP TABLE TB_SYS_LOG;
CREATE TABLE TB_SYS_LOG (
ID VARCHAR2(50 BYTE) NOT NULL ,
USERID VARCHAR2(50 BYTE) NULL ,
USERNAME VARCHAR2(50 BYTE) NULL ,
CREATETIME DATE NULL ,
IP VARCHAR2(50 BYTE) NULL ,
MENUNAME VARCHAR2(255 BYTE) NULL ,
OPERNAME VARCHAR2(255 BYTE) NULL ,
RETAIN1 VARCHAR2(255 BYTE) NULL ,
RETAIN2 VARCHAR2(1024 BYTE) NULL ,
RETAIN3 VARCHAR2(255 BYTE) NULL ,
SOURCE NUMBER(2) DEFAULT 0  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_SYS_LOG.RETAIN3 IS '公司ID';
COMMENT ON COLUMN TB_SYS_LOG.SOURCE IS '来源0:内管，1消息中心 2：前端';

-- ----------------------------
-- Records of TB_SYS_LOG
-- ----------------------------
INSERT INTO TB_SYS_LOG VALUES ('0ED0647AA7C34D8090B4AE8BA6BE12A8', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('300519CA4A104829AE152E21C8F0E779', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:44', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4EB912A615BC4E8389E2FAE3EA1BC571', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:57', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('F3B47F808BA54427AA7A708F8D7627C6', 'admin', '超级管理员', TO_DATE('2017-02-24 16:17:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('9CEEF8FA3F5C4EB3A3CE8073254DAE55', 'admin', '超级管理员', TO_DATE('2017-02-24 16:17:27', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('BD9D70C2DE024353AC315E61B64235B4', 'admin', '超级管理员', TO_DATE('2017-02-24 16:17:45', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('E12FBC2806904E969CE55453E6E75AC3', 'admin', '超级管理员', TO_DATE('2017-02-24 16:17:48', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('18A6BC9811004C9082930BE673D331C5', 'admin', '超级管理员', TO_DATE('2017-02-24 16:20:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('D5BBEDAAE3CC48559830152CC783B899', 'admin', '超级管理员', TO_DATE('2017-02-24 16:20:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4D176C8AD47044C5ACDC448D26B4DF2A', 'admin', '超级管理员', TO_DATE('2017-02-24 16:20:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('6046A81DD2BF402D904C53D39E61B4BE', 'admin', '超级管理员', TO_DATE('2017-02-24 16:20:27', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4DE6ABA408964048930331187A0FF18A', 'admin', '超级管理员', TO_DATE('2017-02-24 16:22:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('458CC7178ECD4750BCD8C891538157C7', 'admin', '超级管理员', TO_DATE('2017-02-24 16:22:55', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '备忘记录', '查询', '0', '/gains/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('CB0E38730B82415B82BF7CF61BF6600D', 'admin', '超级管理员', TO_DATE('2017-02-24 16:22:56', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('6A0091AA00AE438F8282FB85EE052223', 'admin', '超级管理员', TO_DATE('2017-02-24 16:22:57', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '会员信息', '查询', '0', '/vipInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('9AC9D098D38440CF96A6E18A23C91C46', 'admin', '超级管理员', TO_DATE('2017-02-24 16:22:58', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('873AF10708FA4685B2A97AD399E2E0B6', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('775994CB2D6A4568B3A619A2014F125D', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:20', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('01C8192DFC4F45BDBF6D9F8A173C9A47', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('1765A7AE806F447CB818232115002228', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('44466D6C2C4647D38B87B946ECA93EA6', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('EDF61831599140E09473137D8C2CEF15', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:30', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('323E36C11CED466AB6E8A45E19941C16', 'admin', '超级管理员', TO_DATE('2017-02-24 16:23:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('E69700CB88CF4909B7622A80AE4DD0B7', 'admin', '超级管理员', TO_DATE('2017-02-24 16:25:08', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('594BE693142E4846856AD1F1FB580D04', 'admin', '超级管理员', TO_DATE('2017-02-24 16:25:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('227359DF298145FE897BDD2C897232F4', 'admin', '超级管理员', TO_DATE('2017-02-24 16:25:35', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('94BA6BBFD1CE4E4FB9A1969D0DBAEF97', 'admin', '超级管理员', TO_DATE('2017-02-24 16:26:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('358B8E337CAE44D6BC22E2573758DEAA', 'admin', '超级管理员', TO_DATE('2017-02-24 16:26:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('B735F0E85B81484E9D239F1DA806D9C2', 'admin', '超级管理员', TO_DATE('2017-02-24 16:26:07', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('276EA13AB48C4F2F988B18F938F5D6E8', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:10', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('13AEB21DF1E44F65B5217F3D3B0561E6', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0CC54BDFFBA7407DAF078313BF139DB7', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('62C12EEDD94E4E8DACA7EE3360FEFAB3', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:44', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('DD2863AEB2C341DB871294BF1B843FA2', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:45', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('6642F1AACD694FD58740544FEFEC8624', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:46', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('91D2F999D3454BBE99FC49F33782628A', 'admin', '超级管理员', TO_DATE('2017-02-24 16:27:47', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '操作类型', '查询', '0', '/sysOperate/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4BA4B4D50D774C8A9CA929142C61ADB7', 'admin', '超级管理员', TO_DATE('2017-02-24 16:41:43', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('57812D6E42994B709E6652F499885CBE', 'admin', '超级管理员', TO_DATE('2017-02-24 16:45:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('46C9200E2AD54F07B1DA90DD6C3610A8', 'admin', '超级管理员', TO_DATE('2017-02-24 16:48:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4D84A4C1914145DE8F4DCCB76E003B54', 'admin', '超级管理员', TO_DATE('2017-02-24 16:52:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信回复管理', '查询', '0', '/wxAutoReplay/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('F121F8BA45EB49568E7FEF4F42332A2F', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('2FDF46DC31B04A81A87FD51CEC235E66', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:56', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('B1848791379C48958F891EBDC8F59ABF', 'admin', '超级管理员', TO_DATE('2017-02-28 15:36:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '商品管理', '查询', '0', '/goodInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('52A3EFEB927F4E859D986DADA782A576', 'admin', '超级管理员', TO_DATE('2017-02-28 15:36:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '客户定制', '查询', '0', '/advise/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('B5AFAFD2B97E4CD1B471C663079DDC3B', 'admin', '超级管理员', TO_DATE('2017-02-28 15:36:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('3D8C1CC0A2094A3F9E470D06B6B59303', 'admin', '超级管理员', TO_DATE('2017-02-28 15:36:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('8D2D671ED7044EB79FEC404D9AF40465', 'admin', '超级管理员', TO_DATE('2017-02-28 15:36:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('25601A36823147A38138EE10D383C89E', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信回复管理', '查询', '0', '/wxAutoReplay/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('6657EA61369C44E1AD266FAD9D16FEB3', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '粉丝管理', '查询', '0', '/wxUser/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('BD5650E17D5B4755AC15278AF8FDC1F0', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:12', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('AF6E8D34572E4DA4BDD663E7D839392B', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('D78C50B60265433784F72E0E984AE958', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信菜单URL', '查询', '0', '/wxMenuUrl/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('A3DA813AF3A3422B9ACB093A07D30233', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信模板', '查询', '0', '/wxTemplate/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('1A0D04D88D7642FE9F3B0482132BCC3A', 'admin', '超级管理员', TO_DATE('2017-02-28 15:37:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信菜单管理', '查询', '0', '/wxMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('D3BC80E2A32E4FCF9E00BC6BEBC6B7AB', null, null, TO_DATE('2017-02-23 08:56:46', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('FB58F4B6363E44E9A119EF63BBE0E5F6', null, null, TO_DATE('2017-02-23 08:56:47', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('0E47B4F43C9A4FA69B502ECB3860D44A', null, null, TO_DATE('2017-02-23 09:13:48', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('1163134FA26B450D8E87CB9AE1B59FF8', 'admin', '超级管理员', TO_DATE('2017-02-23 09:13:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('C06C3B0A94D14D69AEBE3D64F202CF6F', 'admin', '超级管理员', TO_DATE('2017-02-23 09:14:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('05DBB841890845FFAD3F3CF1E363AA91', 'admin', '超级管理员', TO_DATE('2017-02-23 09:14:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('DFD50313CD044239AEFF0669E994A98E', 'admin', '超级管理员', TO_DATE('2017-02-23 09:14:18', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('42382E53CD88405F811F2CDFA771CBDA', 'admin', '超级管理员', TO_DATE('2017-02-23 09:19:08', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('CD245E0B734C4981B4830AEFCD09B029', 'admin', '超级管理员', TO_DATE('2017-02-23 09:19:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('EBAD54EAA5414C4D95A8320C3CAF1DCC', 'admin', '超级管理员', TO_DATE('2017-02-23 09:19:38', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B80F1221DE314BF4A1D2C00B4C93A2D0', 'admin', '超级管理员', TO_DATE('2017-02-23 09:19:38', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('1BE050C0646F422DAD6F4FF66B83C1FF', 'admin', '超级管理员', TO_DATE('2017-02-23 09:19:46', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('BACBCE6C37104BD0900B2CEBDA235B08', null, null, TO_DATE('2017-02-23 09:32:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('DD2549716E1945EFBDEBDD926EC1DDC7', null, null, TO_DATE('2017-02-23 09:32:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('A48BEEF73AD24B76B8E6FFB56A1E39F6', 'admin', '超级管理员', TO_DATE('2017-02-23 09:32:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B784726A700C4376BB35A4243CA4F2B0', 'admin', '超级管理员', TO_DATE('2017-02-23 09:32:32', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('02F4D86E05A74D9DAF9289B864E4ECFE', null, null, TO_DATE('2017-02-23 09:33:08', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('4F3837ABFC18419E8F7323AA107C53BB', 'admin', '超级管理员', TO_DATE('2017-02-23 09:33:10', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('1D76CA4A6C6A4D6AAE3ED186A2913B98', 'admin', '超级管理员', TO_DATE('2017-02-23 09:33:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '编辑', '0', '/reminder/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('6C7053072EA942C7988EFDAE6A721C31', 'admin', '超级管理员', TO_DATE('2017-02-23 09:33:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('39F3DC47EDAD4937957CD83FDB509C89', 'admin', '超级管理员', TO_DATE('2017-02-23 09:34:35', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B2C437E90E01473AAD3D054F4E08C2A0', 'admin', '超级管理员', TO_DATE('2017-02-23 09:34:35', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('87004B6B17BA4B7E89BAED5C3F848633', 'admin', '超级管理员', TO_DATE('2017-02-23 09:34:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '编辑', '0', '/sysConf/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('D4B6B04FDB8546E18F317E2F203AF860', 'admin', '超级管理员', TO_DATE('2017-02-23 09:34:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('DFA2E2B814F44B4B99346B26F1ED14DF', null, null, TO_DATE('2017-02-23 09:35:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('9ED74F039B22499FA418823059778359', null, null, TO_DATE('2017-02-23 09:35:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('75B9802B06BC4964BE22051F3CFCA97E', 'admin', '超级管理员', TO_DATE('2017-02-23 09:35:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '会员信息', '查询', '0', '/vipInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('44C745DE31FE48D9BD8FD0C217BC11C5', 'admin', '超级管理员', TO_DATE('2017-02-23 09:35:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3219D691BE7846D282697C6112C0CC1E', 'admin', '超级管理员', TO_DATE('2017-02-23 09:35:55', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3EDBC6D286104DDDA8366A03F43A2BC3', 'admin', '超级管理员', TO_DATE('2017-02-23 09:36:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '编辑', '0', '/sysConf/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('2D6CF05C9F914FA1ADF87AC11CA4E10B', 'admin', '超级管理员', TO_DATE('2017-02-23 09:36:06', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('8B7319F735B24BA9B89C8B4D51DBCF28', null, null, TO_DATE('2017-02-23 09:40:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '新增', '0', '/sysConf/save', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('1EC614424D6448CDBEEE8C87F3FE987E', null, null, TO_DATE('2017-02-23 09:40:33', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('52EEFFBAA5FC4C2DBA219904B31DC9B1', null, null, TO_DATE('2017-02-23 09:43:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('FBD9023DDB0E4BA587138E5A4D3E6CFC', 'admin', '超级管理员', TO_DATE('2017-02-23 09:43:32', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('62F677B8BF764661ABB98C1B8FEF1904', 'admin', '超级管理员', TO_DATE('2017-02-23 09:43:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '新增', '0', '/sysConf/save', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3560EE3E4A7B4709A7A9B10CA69F30B3', 'admin', '超级管理员', TO_DATE('2017-02-23 09:43:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3FDBC18305BB40B4ADF7FC86BD3D05A1', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('987B9164631D47528ABE219B0E39F6B1', null, null, TO_DATE('2017-02-23 09:50:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('528AB16568714EAB8052FC7F87E2C094', null, null, TO_DATE('2017-02-23 09:50:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('B129CF9E175A4910B5E2E6EE65331EB3', 'admin', '超级管理员', TO_DATE('2017-02-23 09:50:32', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('0F777882C8F347E7BBE0B41EA5AF24E6', 'admin', '超级管理员', TO_DATE('2017-02-23 09:51:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('7117106A8E8F4885844DF88AFA5E7E4C', null, null, TO_DATE('2017-02-23 09:53:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('482C4CDFACFC454BA9C7F3E6077E075A', null, null, TO_DATE('2017-02-23 09:53:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('E0B69250971843BA81CAD615C018E612', 'admin', '超级管理员', TO_DATE('2017-02-23 09:54:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('64D858E688C947C798B995C38C568542', null, null, TO_DATE('2017-02-23 09:55:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('B70D3420F8C548198E13A69452E689CD', 'admin', '超级管理员', TO_DATE('2017-02-23 09:55:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('1F75793EA3044BA9BCF6EC6B645183E4', 'admin', '超级管理员', TO_DATE('2017-02-23 09:55:36', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('76D6A09AC66A4CEEB7B3DBB648107798', null, null, TO_DATE('2017-02-23 09:58:14', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('7E28EAF8C0F0455B994241C5924D7EA9', null, null, TO_DATE('2017-02-23 09:58:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('8E0BEDCE7C7E4C2B8391C190A876C80E', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:58:30', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('565FFF7E737347FB93F5E76D74CB50CD', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:58:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '新增', '0', '/sysConf/save', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('8A4FBF74E6B34920B3E16E1EF4400082', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:58:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('D1AA398183F747BDBD473B3DC7711425', null, null, TO_DATE('2017-02-23 09:58:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('A812F402BFEB428793ED8B20AEEA3473', 'admin', '超级管理员', TO_DATE('2017-02-23 09:58:55', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('DF1335DFF70841C7A34A66D9021DC383', 'admin', '超级管理员', TO_DATE('2017-02-23 09:58:57', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('F948D363F2E2427FBF3FABA572E114C1', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '删除', '0', '/dataDir/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('FA0BBEC36BB24E24A9B0A2B65A93BFDB', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('71308594C8A049A8ABD8637126D5FDE9', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:07', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '删除', '0', '/sysConf/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('C9AD888F8309433980261C385C962590', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:07', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('EFBD285D6B974E5AA36F7EC53A223594', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '删除', '0', '/sysConf/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('14A963A8C4D049E6BD0DDF069DC954D5', null, null, TO_DATE('2017-02-23 08:52:17', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('077822C9C402463AB15AE0D2A868287D', null, null, TO_DATE('2017-02-23 08:52:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('6468F99A707C4F8F88B3DB1D7443505D', null, null, TO_DATE('2017-02-23 08:52:22', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('DFCDB44798B3468597134D0490C5BE1A', null, null, TO_DATE('2017-02-23 08:54:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('AE47459359004F7CBAC1AEECF917FF26', 'admin', '超级管理员', TO_DATE('2017-02-23 08:54:38', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('398B3AED7FD94255BD1E0FFC33DA9ECB', 'admin', '超级管理员', TO_DATE('2017-02-23 08:54:44', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '删除', '0', '/autoCode/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('920F70EE24A344E3A5280DB1BCC717D5', 'admin', '超级管理员', TO_DATE('2017-02-23 08:54:44', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('C78D4089C27F4C479D2377E1EC97E149', 'admin', '超级管理员', TO_DATE('2017-02-23 08:56:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('D48F1387D9414074ADDAE00158F83CFD', 'admin', '超级管理员', TO_DATE('2017-02-23 08:57:08', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('834D25F2CEF4449E8A19B38A8447FAA2', 'admin', '超级管理员', TO_DATE('2017-02-23 08:58:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('DD25A49EA0F14FE1AB469A5A973167AF', 'admin', '超级管理员', TO_DATE('2017-02-23 08:59:38', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('5BEC6EC0D3094194A0D5A75EB0FED2CB', 'admin', '超级管理员', TO_DATE('2017-02-23 09:02:03', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('376EE1402BEC4D11AAF40C82CD1382B4', 'admin', '超级管理员', TO_DATE('2017-02-23 09:02:46', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('95A5FEF21CE74FD6B468AB2CCB838ACC', 'admin', '超级管理员', TO_DATE('2017-02-23 09:05:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('F7C87FA956564A3BA5ACDAA7FEC94ADC', 'admin', '超级管理员', TO_DATE('2017-02-23 09:05:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('504EDFC0C8D24F49AA8CC91C4B707890', 'admin', '超级管理员', TO_DATE('2017-02-23 09:06:40', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('C33269DAFCB74704973BC768E6093A27', 'admin', '超级管理员', TO_DATE('2017-02-23 09:06:40', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('17B1C13302C44F3985AB6E3E1EEA0DF0', 'admin', '超级管理员', TO_DATE('2017-02-23 09:09:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('44CA09ADAA724D0FAD042C39793A89A1', 'admin', '超级管理员', TO_DATE('2017-02-23 09:09:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '删除', '0', '/sysMenu/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('F61488599B564BF6865F6D66B5795398', 'admin', '超级管理员', TO_DATE('2017-02-23 09:09:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('34CF002B769945B4BC4E0C8BA0297342', null, null, TO_DATE('2017-02-23 09:09:17', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('1E55B81487DF486B9DA9C5417BC0D2F1', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('2165EC893A2F4CEDA124DE438C10B871', 'admin', '超级管理员', TO_DATE('2017-02-23 09:59:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('A40EB2DB0BF940B49782FAA7CE88C10A', null, null, TO_DATE('2017-02-23 10:01:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('8B54A69BDA4D4F0EA2C53504E4DFC700', null, null, TO_DATE('2017-02-23 10:01:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('3FF8C75B14364DB0BE933602EBCE4AD8', 'admin', '超级管理员', TO_DATE('2017-02-23 10:01:32', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '客户定制', '查询', '0', '/advise/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('0446D7F982BF409183A6BC20ACEA0473', 'admin', '超级管理员', TO_DATE('2017-02-24 08:46:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '痕迹', '登录', '0', '/login', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('5650AC914BD64DBC834ABBE5E5164062', 'admin', '超级管理员', TO_DATE('2017-02-24 08:46:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('37B118A527FE4D7D87493BDBC1BD5E8B', 'admin', '超级管理员', TO_DATE('2017-02-24 08:46:22', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('FAA55843E2CB4596B340E637958AC6C1', 'admin', '超级管理员', TO_DATE('2017-02-24 08:46:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/getUUID', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('8A4BF522DD384F8196D7A06E0552C9B9', 'admin', '超级管理员', TO_DATE('2017-02-24 08:46:30', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('30AAF5DBDF2643CE9620B8178E10A3B1', 'admin', '超级管理员', TO_DATE('2017-02-24 08:47:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('362A380413AE4FB29390E50B923A8512', 'admin', '超级管理员', TO_DATE('2017-02-24 08:47:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('93B9847290E3468F858ACA50EC0E9F88', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:03', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('B08FA6A5F1084731849FF17BBB7C4949', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('D64EC1F19F6A41BBA191262566FA91F6', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('82E8895EAA3A4E3E8FD106C0E84D66BF', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('F57DDFF50ED5493295F5857767753D7F', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('CABE0B3C6A5A4F05B377501C9D0714F8', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('52B4F36EE1654D3F9692E2BBA8AAFE61', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('4D92EA83D9CF4BF6B65365D51766F7C2', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('2D4FD75890144B69A2197A301FDAEE9D', 'admin', '超级管理员', TO_DATE('2017-02-24 08:48:27', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('0FCFFA846C414C019B5B247BD732AEB9', 'admin', '超级管理员', TO_DATE('2017-02-24 09:09:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('21AE3F12A3C948A5A1C3FE5B41EB02F4', 'admin', '超级管理员', TO_DATE('2017-02-24 09:19:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('8618C24438304ADE953A8D994A1656B1', 'admin', '超级管理员', TO_DATE('2017-02-24 09:19:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('3488DAD1566D46CE8067E95BBDF51321', null, null, TO_DATE('2017-02-24 09:23:34', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('688F1604D0C84ACA9738602A90C0AC58', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:35', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('11F953D76C1548F788C860B74B5A4063', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:37', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('1B964DDA56D345ED836EA39D9CA997B4', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:47', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('1E592F9A31E7451381FC6368C81C0FA8', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:48', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('5642759E047C40B8999AC3DF76CF3F58', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:49', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('2F0104F742DE439F8B202ED974DBE0F3', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('174E942C67904F14A54925E65C19C890', 'admin', '超级管理员', TO_DATE('2017-02-24 09:23:55', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('98AD298D334044A59735A54495BDD3C2', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:02', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '退出', '0', '/logout', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('8124FCFAC2A84D53A3F20B095F031DF6', null, null, TO_DATE('2017-02-24 09:54:51', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', 'Marks', '2');
INSERT INTO TB_SYS_LOG VALUES ('DAF3E75DE4954CFFA5B8CA9B6233D6BB', 'admin', '超级管理员', TO_DATE('2017-02-24 09:54:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '痕迹', '登录', '0', '/login', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('2E063FEB2C7C492BB3C69EB0ABAFE477', 'admin', '超级管理员', TO_DATE('2017-02-24 09:54:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('E32B12718AA94A659A709FB7C1BD7F5B', 'admin', '超级管理员', TO_DATE('2017-02-24 09:54:55', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/getUUID', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('56F305F4B7364E93AACCFE62DA013E58', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:02', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('27BC307BC87D4AC288877EB569B2D1FA', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:18', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('536004798CD943A588FAE479DB7692C9', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('D7266132D99F4A7BB6BB7F67181B72B4', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:34', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('4E03E9F257F24CDAA2680F19BA30DE22', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:35', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('ED278BD8A6C34D1695B8605E8B33C9A0', 'admin', '超级管理员', TO_DATE('2017-02-24 09:55:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('7135D39F10814F479C6A8B08F0F8DFA5', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:07', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('932E1DD449674AC29C2500455015C37A', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:08', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('C492A3C5D4954950AD173F9E75D03322', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('00869A67673C4892A3BE31BC236CD271', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:18', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('CDEEEDD30DE444CCBCAE903C8A777063', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:25', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('6D03BD80A07F4FBA881E754468AF9F90', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('77B85C6DCEE5401FA5675D18672270AE', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:34', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('9460F886D1504C4688F75E4B9478C869', 'admin', '超级管理员', TO_DATE('2017-02-23 09:44:37', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('46F7342C6B8844B89A4BEA14A214AE75', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '新增', '0', '/sysRole/save', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('01FF15A62BDB4A1D9FA8AA4ADDAFCB35', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:11', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B9BE0CE405F6435F810CB45C1D6E2219', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('E9FF56B3833740A89B6B366B3A49EC34', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:17', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('78B1824144D94015B4562D58C5F01D84', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('02D1EA538DF04BD48E08ACB131547D2F', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('E34BC35306F64D278B9D11279D50A812', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:39', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '新增', '0', '/sysUser/save', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3392AF1D85D7456B9C56AFC271A4C5BA', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:39', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('4B3F674E676B4E70A765D4CD169BB74F', 'admin', '超级管理员', TO_DATE('2017-02-23 09:45:48', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('24DA7AC0986D4832A04649DDAC84FE60', null, null, TO_DATE('2017-02-23 09:46:22', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('BC4AB926249A4B3A97F5096430C0C6E4', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:23', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('73DDAA34A7BF40D2A9213754C854790B', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('9EB8758422A9421C90DABD4BAC873570', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '新增', '0', '/sysConf/save', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('A41904E0A9EE4894A3FE827A97791025', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('54129F6946734693A4E1EB87030EAE89', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '删除', '0', '/sysConf/delete', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('7E38ED399B034943825804A16E5F9178', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:46:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('64718987C6B14EE586B768AF4CC11E4A', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:47:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '新增', '0', '/dataDir/save', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('B6657CFD34EB4963833A339299D5C18F', 'U10000040', '18210012743', TO_DATE('2017-02-23 09:47:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', 'N', '0');
INSERT INTO TB_SYS_LOG VALUES ('82B6200635F0445BA5AE1F145022592F', null, null, TO_DATE('2017-02-23 09:47:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('296BCC3B379344D7AABEC483C961EE91', 'admin', '超级管理员', TO_DATE('2017-02-23 09:47:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('337678754D934601AA942261A010B056', 'admin', '超级管理员', TO_DATE('2017-02-23 09:47:30', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('266CAC866075470D8555A383065F7C63', 'admin', '超级管理员', TO_DATE('2017-02-23 09:47:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('2C11276522CD4001A8B5B7B680DBF8F8', 'admin', '超级管理员', TO_DATE('2017-02-23 09:47:36', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('9D225FBE90284707B9EF892B21102EA4', 'admin', '超级管理员', TO_DATE('2017-02-23 09:47:49', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('D9407E84E25746879A866641B905BA7C', 'admin', '超级管理员', TO_DATE('2017-02-23 09:49:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('73719BBAE86244D6AF509DCC71C3B6FC', 'admin', '超级管理员', TO_DATE('2017-02-24 09:15:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('757550F8DE63474E9EE3B29B5BDE96FA', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:03', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('BCF8CF58EE044036B591D9469201A297', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:06', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('B1599F113F994F229E9454216A34BAFE', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:12', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('FD95BC7516004E47AF957D88E87A4AAD', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:12', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('7C6F08FC027D4252AE6021D5FE64710D', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0E5D0DCA13BE45EC9C0359708A010890', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:14', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('80F51034255B4897B75EB05820CD851E', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('A9BB0B0983154027BBAB290580CE8EE8', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:15', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('F0ECE6E88D9146B4AD686E219438A721', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:17', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('04395365F3714A7AA04BD31C5E8F0767', 'admin', '超级管理员', TO_DATE('2017-02-24 09:24:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('FCDFE58D90094281847CF095CF79D6B5', 'admin', '超级管理员', TO_DATE('2017-02-24 09:56:03', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/save', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('3B72AAA58DE545DCB0E3D61C63EEAF54', 'admin', '超级管理员', TO_DATE('2017-02-24 09:56:03', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, '2');
INSERT INTO TB_SYS_LOG VALUES ('0D42EB9D1D9B46F2B1702A445D334823', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('58E5059689F743B4AF410EC0CAC028B9', 'admin', '超级管理员', TO_DATE('2017-02-23 09:09:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('8508B47094B14F0B9A3E9EB780D7AB07', 'admin', '超级管理员', TO_DATE('2017-02-23 09:10:32', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('07D0DC70640040469E9A7BAC4370FB71', 'admin', '超级管理员', TO_DATE('2017-02-23 09:10:39', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('CDA84CBD5CBE432BBB49AFEB4F2A1966', 'admin', '超级管理员', TO_DATE('2017-02-23 09:10:39', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B48E1904A601466E95B6CAB5E0543305', 'admin', '超级管理员', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('27D89AF6C833465E8F2D6EF7057CFB6B', null, null, TO_DATE('2017-02-23 09:11:34', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('6ADDFFDA7E41445CAF2966D0CE45B865', 'admin', '超级管理员', TO_DATE('2017-02-23 09:11:36', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('8A1DBB0CC0C946698EDCA45D1F7BD555', null, null, TO_DATE('2017-02-23 09:17:31', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('0D28DF0D5BB84D48BB52B60E93E81261', 'admin', '超级管理员', TO_DATE('2017-02-23 09:17:33', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('2B04276E7CB742D99B4C816A1BFDC024', 'admin', '超级管理员', TO_DATE('2017-02-23 09:18:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '0', '/reminder/save', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('B849D63DDD224C3191463340FC92E61E', 'admin', '超级管理员', TO_DATE('2017-02-23 09:18:53', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('52B77928F5E04431876539B68F067776', null, null, TO_DATE('2017-02-23 09:23:29', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('E0AC0D5858BC4BC0BF314EF26B05472A', null, null, TO_DATE('2017-02-23 09:23:30', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('B155C085AB6F4FF5A82EB4413F2CD01B', 'admin', '超级管理员', TO_DATE('2017-02-23 09:23:33', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3F217DAF045F4D09843AFDC45497A1EF', 'admin', '超级管理员', TO_DATE('2017-02-23 09:23:37', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('D29ED22B705B41C4A0A92419E3189361', null, null, TO_DATE('2017-02-23 09:24:40', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('168FF52CB7A0446BAC91E7059ADA0AC9', null, null, TO_DATE('2017-02-23 09:24:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', '0');
INSERT INTO TB_SYS_LOG VALUES ('5CF58C51AA27405481DECF3C03F63C3A', 'admin', '超级管理员', TO_DATE('2017-02-23 09:24:43', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('34A10EC9614840D3A6662CF3F6D6431B', 'admin', '超级管理员', TO_DATE('2017-02-23 09:24:54', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '删除', '0', '/reminder/delete', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('A352885345B849C8918507BD4F487454', 'admin', '超级管理员', TO_DATE('2017-02-23 09:24:54', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('708A6646169E43B8B674DD911450E302', 'admin', '超级管理员', TO_DATE('2017-02-23 09:25:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '0', '/reminder/save', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('DEDFA3A48F554EC2BF8DAAF1947020E3', 'admin', '超级管理员', TO_DATE('2017-02-23 09:25:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/reminder/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('F044E7C68A8A4715850BE13BF18D0B24', 'admin', '超级管理员', TO_DATE('2017-02-23 09:25:54', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', '0');
INSERT INTO TB_SYS_LOG VALUES ('3C98AD8F3D4C4A888AEA93A94D363A10', 'admin', '超级管理员', TO_DATE('2017-02-24 09:19:26', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('4D5D7D15520349E6A8BE3B9C152E3A3A', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('34DD5A4156A944B5A1C6F67B53C8A4D4', 'admin', '超级管理员', TO_DATE('2017-02-24 16:16:54', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('E4643B7CF8974C8CB7278B15F5DBCB91', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '退出', '0', '/logout', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('7974D68D18CF40BD8F844AD41F929CAE', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:10', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('8116F630558B484397C21AD0BCAACA15', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:24', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('C817A70EF1114E4A985D08E48ED79E74', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:46', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('2E7CF547125A497DA905EC03A3CF18E1', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:48', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('2A8A8778948141C59DDA7E81642082AA', 'admin', '超级管理员', TO_DATE('2017-02-24 16:28:49', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('1E047B5F6C3240028DABDA7D7B792CAB', 'admin', '超级管理员', TO_DATE('2017-02-24 16:36:41', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('599E6A21CBC547E7B2180B93907CBED4', 'admin', '超级管理员', TO_DATE('2017-02-24 16:36:52', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('C63D8133C6084C3B85F8FB6EDA047FCD', 'admin', '超级管理员', TO_DATE('2017-02-24 16:36:59', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('2A1582316EE44BEBBAC9595BC0932AE8', 'admin', '超级管理员', TO_DATE('2017-02-24 16:36:59', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '新增', '0', '/sysMenu/save', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('07F05F013F764186875E58BA89331ECD', 'admin', '超级管理员', TO_DATE('2017-02-24 16:36:59', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('80BD373FAC2249C99C9481783D34742E', 'admin', '超级管理员', TO_DATE('2017-02-24 16:37:05', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0D39CF60A40E4C2B86814016BA36F614', 'admin', '超级管理员', TO_DATE('2017-02-24 16:40:13', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('3B085ABA6597470B9AB0D262379C454F', 'admin', '超级管理员', TO_DATE('2017-02-24 16:41:10', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('3DBEE0EEEA8D453A8B6AA4B87483D42C', 'admin', '超级管理员', TO_DATE('2017-02-24 16:41:21', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('BD68A90A02FB45B8BDB96D32722C5117', 'admin', '超级管理员', TO_DATE('2017-02-24 16:50:37', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('B31B2AB69EF446A48FCF8FA71AD943D2', 'admin', '超级管理员', TO_DATE('2017-02-24 16:50:39', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('04510F4EDA754F5DA054F168D8167B67', 'admin', '超级管理员', TO_DATE('2017-02-24 16:52:01', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('882158478CE944FCB25CFB238074DEF9', 'admin', '超级管理员', TO_DATE('2017-02-24 16:52:04', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '操作类型', '查询', '0', '/sysOperate/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0324D8AA3A144888A8F8C5AC05832790', 'admin', '超级管理员', TO_DATE('2017-02-24 16:52:45', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('391A93F34F4341868E1A8EFD7EEAF90F', 'admin', '超级管理员', TO_DATE('2017-02-28 15:30:44', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('C4EA9C3D046740DE8ED17103EB3B6899', 'admin', '超级管理员', TO_DATE('2017-02-28 15:30:56', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('072D234A58694845B3849B60B62A1AB0', 'admin', '超级管理员', TO_DATE('2017-02-28 15:30:57', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '操作类型', '查询', '0', '/sysOperate/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('EF8271E56E3B45A6B1F81A1CBAC0168C', 'admin', '超级管理员', TO_DATE('2017-02-28 15:31:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信回复管理', '查询', '0', '/wxAutoReplay/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('7F62C6099D6548E782E34B2109C5375B', 'admin', '超级管理员', TO_DATE('2017-02-28 15:31:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信回复管理', '新增', '0', '/wxAutoReplay/save', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('54BFE012694D4D1C8C89A7FA4B39A72C', 'admin', '超级管理员', TO_DATE('2017-02-28 15:31:28', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信回复管理', '查询', '0', '/wxAutoReplay/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('196AFE5A034D488F95031711BD1F79F4', 'admin', '超级管理员', TO_DATE('2017-02-28 15:31:36', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('7420A6BD6EB8463CB2C7ABA4BDA7A770', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:09', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '粉丝管理', '查询', '0', '/wxUser/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('9C9707E0C69749A5B188B9E97188F727', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:16', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '模板消息', '查询', '0', '/moduleMsg/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('C34664A82FA24152A8E5A80E561D2E4A', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:17', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信模板', '查询', '0', '/wxTemplate/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('AE697D62695347F3B9F57CC21DD37666', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:18', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信菜单URL', '查询', '0', '/wxMenuUrl/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0256BAFFD5E349568BC27FF463313695', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '微信菜单管理', '查询', '0', '/wxMenu/list', null, '0');
INSERT INTO TB_SYS_LOG VALUES ('0A6D60BE243B4E269D2CC245BCECC1D2', 'admin', '超级管理员', TO_DATE('2017-02-28 15:32:19', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', null, '0');

-- ----------------------------
-- Table structure for TB_SYS_LOG_PARAM
-- ----------------------------
DROP TABLE TB_SYS_LOG_PARAM;
CREATE TABLE TB_SYS_LOG_PARAM (
URL VARCHAR2(250 BYTE) NOT NULL ,
SOURCE NUMBER(2) DEFAULT 0  NOT NULL ,
MENUNAME VARCHAR2(255 BYTE) NULL ,
OPERNAME VARCHAR2(255 BYTE) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(100 BYTE) NULL ,
ID VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_LOG_PARAM
-- ----------------------------
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/wechat/createWXMenu', '1', '微信菜单', '同步', TO_TIMESTAMP(' 2017-01-07 21:13:26:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:13:26:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', '0FA563075BA242B5BCEA8BA88278E299');
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/login', '2', '痕迹', '登录', TO_TIMESTAMP(' 2017-01-07 21:38:45:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:38:45:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', '1DC12C11DF88478598754FC7975A1D49');
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/diary/list', '2', '日记', '查询', TO_TIMESTAMP(' 2017-01-07 21:36:48:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:36:48:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', '543B4F72BB79444B9AE7892044F0B42B');
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/diary/save', '2', '日记', '添加', TO_TIMESTAMP(' 2017-01-07 21:37:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:37:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'F48446BFE6BF4F73B4E86CB3CAE46658');
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/diary/update', '2', '日记', '修改', TO_TIMESTAMP(' 2017-01-07 21:37:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:37:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', '68F42736FA4E4F8C94D67868E1FC910F');
INSERT INTO TB_SYS_LOG_PARAM VALUES ('/diary/findDiaryById', '2', '日记', '详情', TO_TIMESTAMP(' 2017-01-07 21:38:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-07 21:38:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'D2CA1EC951F14BDC98D467F1D6A3A48D');

-- ----------------------------
-- Table structure for TB_SYS_MENU
-- ----------------------------
DROP TABLE TB_SYS_MENU;
CREATE TABLE TB_SYS_MENU (
MENUID VARCHAR2(50 BYTE) NOT NULL ,
PARENTID VARCHAR2(50 BYTE) NULL ,
MENUITEM VARCHAR2(200 BYTE) NULL ,
URL VARCHAR2(200 BYTE) NULL ,
SORT NUMBER(4) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_MENU
-- ----------------------------
INSERT INTO TB_SYS_MENU VALUES ('20160928203125806', '1', '操作类型', 'page/system/operate/sysOperate.jsp', '2', TO_DATE('2016-09-28 20:31:25', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-28 20:36:19', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('sysRole', 'system', '用户类型', 'page/system/sysrole/sysRole.jsp', '2', null, TO_DATE('2017-01-10 23:11:48', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('20161016024730740', '1', '生成代码', 'page/autocode/autocode/autoCode.jsp', '3', TO_DATE('2016-10-16 02:47:30', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-16 02:47:30', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('diary', 'note', '我的日记', 'page/note/diary/diary.jsp', '1', null, TO_DATE('2017-01-08 20:41:07', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('orgInfo_parentid', '0', '架构', '#', '197', null, TO_DATE('2016-11-30 21:16:04', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('orgInfo', 'orgInfo_parentid', '组织管理', 'page/system/orginfo/orgInfo.jsp', '1', null, TO_DATE('2016-10-20 19:55:52', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxAccount', 'wxMenuUrl_parentid', '公众号管理', 'page/wx/wxaccount/wxAccount.jsp', '4', null, TO_DATE('2017-01-10 23:10:44', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('20161023003925948', 'orgInfo_parentid', '公司管理', 'page/system/orginfo/companyInfo.jsp', '2', TO_DATE('2016-10-23 00:39:25', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-23 00:39:25', 'YYYY-MM-DD HH24:MI:SS'), '曹纪梅');
INSERT INTO TB_SYS_MENU VALUES ('goodInfo_parentid', '0', '商品', '#', '10', null, TO_DATE('2016-11-30 21:15:07', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('goodInfo', 'goodInfo_parentid', '商品管理', 'page/mall/goodinfo/goodInfo.jsp', '2', null, TO_DATE('2017-01-10 23:09:05', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('advise', 'goodInfo_parentid', '客户定制', 'page/mall/advise/advise.jsp', '1', null, TO_DATE('2017-01-10 22:37:37', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('1', '0', '菜单', '#', '200', TO_DATE('2016-07-30 13:35:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:16:37', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('2', '1', '系统菜单', 'page/system/menu/sysMenu.jsp', '1', TO_DATE('2016-07-27 13:36:03', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-07-30 13:36:19', 'YYYY-MM-DD HH24:MI:SS'), 'admin');
INSERT INTO TB_SYS_MENU VALUES ('sysUser', 'system', '用户管理', 'page/system/sysuser/sysUser.jsp', '1', null, TO_DATE('2016-11-08 18:50:24', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('system', '0', '系统', '#', '199', TO_DATE('2016-07-30 13:36:10', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-30 21:16:25', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('20161203194846615', '0', '个人中心', '#', '41', TO_DATE('2016-12-03 19:48:46', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:48:46', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('20161203195318395', '20161203194846615', '重置手机', 'page/system/sysuser/changeMobile.jsp', '2', TO_DATE('2016-12-03 19:53:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 20:02:17', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('sysLogParam', 'sysLog_parentid', '日志参数', 'page/system/syslogparam/sysLogParam.jsp', '2', null, TO_DATE('2017-01-07 21:31:53', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('vipInfo', 'note', '会员信息', 'page/note/vipinfo/vipInfo.jsp', '4', null, TO_DATE('2017-01-08 20:41:53', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('note', '0', '痕迹', '#', '1', null, TO_DATE('2017-01-08 19:57:21', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('moduleMsg', 'wxMenuUrl_parentid', '模板消息', 'page/wx/modulemsg/moduleMsg.jsp', '11', null, TO_DATE('2017-01-10 23:10:32', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxUser', 'wxMenuUrl_parentid', '粉丝管理', 'page/wx/wxuser/wxUser.jsp', '3', null, TO_DATE('2017-01-10 23:10:06', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('qrcode_parentid', '0', '二维码', '#', '31', null, TO_DATE('2016-11-30 21:15:50', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxMenu', 'wxMenuUrl_parentid', '微信菜单管理', 'page/wx/wxmenu/wxMenu.jsp', '5', null, TO_DATE('2017-01-10 23:10:56', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxMenuUrl_parentid', '0', '微信', '#', '30', null, TO_DATE('2016-11-30 21:15:43', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxMenuUrl', 'wxMenuUrl_parentid', '微信菜单URL', 'page/wx/wxmenuurl/wxMenuUrl.jsp', '6', null, TO_DATE('2017-01-10 23:11:03', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('qrcode', 'qrcode_parentid', '二维码管理', 'page/wx/qrcode/qrcode.jsp', '1', null, null, null);
INSERT INTO TB_SYS_MENU VALUES ('wxAutoReplay', 'wxMenuUrl_parentid', '微信回复管理', 'page/wx/wxautoreplay/wxAutoReplay.jsp', '1', null, TO_DATE('2017-01-10 23:09:28', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('question', 'note', '问题记录', 'page/note/question/question.jsp', '3', null, TO_DATE('2017-02-24 16:36:59', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('newsItem', 'wxMenuUrl_parentid', '回复图文管理', 'page/wx/newsitem/newsItem.jsp', '2', null, TO_DATE('2017-01-10 23:09:53', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('sysConf', 'system', '系统参数', 'page/system/sysconf/sysConf.jsp', '3', null, TO_DATE('2017-01-10 23:11:29', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('wxTemplate', 'wxMenuUrl_parentid', '微信模板', 'page/wx/wxtemplate/wxTemplate.jsp', '10', null, TO_DATE('2017-01-10 23:10:27', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('dataDir', 'system', '数据字典', 'page/system/datadir/dataDir.jsp', '4', null, TO_DATE('2017-01-10 23:11:38', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('gains', 'note', '备忘记录', 'page/note/gains/gains.jsp', '2', null, TO_DATE('2017-01-08 20:41:23', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('sysLog_parentid', '0', '日志', '#', '198', null, TO_DATE('2016-11-30 21:16:15', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('sysLog', 'sysLog_parentid', '系统日志', 'page/system/syslog/sysLog.jsp', '1', null, TO_DATE('2017-01-07 21:31:15', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('20161203195018623', '20161203194846615', '修改密码', 'page/system/sysuser/changePwd.jsp', '1', TO_DATE('2016-12-03 19:50:18', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:50:18', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员');
INSERT INTO TB_SYS_MENU VALUES ('reminder', 'note', '事务提醒', 'page/note/reminder/reminder.jsp', '100', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for TB_SYS_OPERATE
-- ----------------------------
DROP TABLE TB_SYS_OPERATE;
CREATE TABLE TB_SYS_OPERATE (
OPERNAME VARCHAR2(50 BYTE) NOT NULL ,
OPERID VARCHAR2(50 BYTE) NOT NULL ,
PICICON VARCHAR2(50 BYTE) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
SORT NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_OPERATE
-- ----------------------------
INSERT INTO TB_SYS_OPERATE VALUES ('启禁用', 'activeBtn', 'icon-edit', TO_DATE('2017-01-08 21:41:54', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 21:41:54', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '20');
INSERT INTO TB_SYS_OPERATE VALUES ('查询', 'query', 'icon-search', null, null, null, '0');
INSERT INTO TB_SYS_OPERATE VALUES ('新增', 'add', 'icon-add', null, null, null, '1');
INSERT INTO TB_SYS_OPERATE VALUES ('编辑', 'edit', 'icon-edit', null, null, null, '2');
INSERT INTO TB_SYS_OPERATE VALUES ('日记提醒', 'dairyBtn', 'icon-edit', TO_DATE('2016-12-03 18:49:22', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-03 19:45:10', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '11');
INSERT INTO TB_SYS_OPERATE VALUES ('上下架', 'onsaleBtn', 'icon-edit', TO_DATE('2016-12-07 20:29:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-07 20:29:07', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '12');
INSERT INTO TB_SYS_OPERATE VALUES ('更新粉丝', 'syncWxFans', 'icon-edit', TO_DATE('2016-12-22 22:27:59', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-12-22 22:27:59', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '30');
INSERT INTO TB_SYS_OPERATE VALUES ('生成代码', 'autoCodeBtn', 'icon-save', TO_DATE('2016-10-20 02:05:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 02:05:58', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '6');
INSERT INTO TB_SYS_OPERATE VALUES ('删除', 'delete', 'icon-remove', TO_DATE('2016-09-30 15:40:23', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-20 03:22:50', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '5');
INSERT INTO TB_SYS_OPERATE VALUES ('功能管理', 'addFunc', 'icon-edit', TO_DATE('2016-09-30 15:41:38', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-09-30 15:41:38', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '3');
INSERT INTO TB_SYS_OPERATE VALUES ('同步微信', 'syncWx', 'icon-edit', TO_DATE('2016-11-17 19:03:08', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-17 19:03:08', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '7');
INSERT INTO TB_SYS_OPERATE VALUES ('重置密码', 'resetPwdBtn', 'icon-edit', TO_DATE('2016-11-26 09:59:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-11-26 09:59:09', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '10');
INSERT INTO TB_SYS_OPERATE VALUES ('生产文档', 'introBtn', 'icon-save', TO_DATE('2017-01-09 23:03:12', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:12', 'YYYY-MM-DD HH24:MI:SS'), '超级管理员', '30');

-- ----------------------------
-- Table structure for TB_SYS_ROLE
-- ----------------------------
DROP TABLE TB_SYS_ROLE;
CREATE TABLE TB_SYS_ROLE (
ROLEID VARCHAR2(50 BYTE) NOT NULL ,
ROLENAME VARCHAR2(50 BYTE) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
USERTYPE VARCHAR2(50 BYTE) NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL ,
LVL NUMBER(4) DEFAULT 0  NULL ,
SHOWFLAG NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_ROLE
-- ----------------------------
INSERT INTO TB_SYS_ROLE VALUES ('Marks_VIP', '会员', TO_TIMESTAMP(' 2017-01-07 23:46:23:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-08 21:04:34:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'VIP', 'Marks', '9', '0');
INSERT INTO TB_SYS_ROLE VALUES ('Marks_ADMIN', '管理员', TO_TIMESTAMP(' 2017-02-17 21:51:36:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-17 21:51:36:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'ADMIN', 'Marks', '2', '1');
INSERT INTO TB_SYS_ROLE VALUES ('N_SYS', '管理员', TO_TIMESTAMP(' 2017-02-23 09:45:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-23 09:45:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'SYS', 'N', '2', '1');

-- ----------------------------
-- Table structure for TB_SYS_ROLE_FUNC
-- ----------------------------
DROP TABLE TB_SYS_ROLE_FUNC;
CREATE TABLE TB_SYS_ROLE_FUNC (
ROLEID VARCHAR2(50 BYTE) NOT NULL ,
FUNCID VARCHAR2(50 BYTE) NOT NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_ROLE_FUNC
-- ----------------------------
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '34D4A51F71A3452DA20B5C89272F7121', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '729986573F3F498AB804BD1B7CC58466', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'C3A5BC0B6477434E9E3942C16353834A', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '9CFAB7B9645F4EB48F69A3E900B51CDB', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A9EDBB5CBFAA49CEB53C12A3C516BE85', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '7C045D9CA9D5456FAF856490836AA6C8', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A0BEFFBB0FDA42F38280FBE35A670977', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A947C38F31814E67830E922BA2FD5926', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'F2B99E17C4EC4CB399A1F4D435C28909', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '9E081346B9F5409EB8E8D79A988515E3', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '56FC1334D6A54B28B41C552156EA7E2C', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '440141C13AB345BC991774CDD7614909', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E95BB25BFFAF4C13864DBC3A02B9306D', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'CD2780A03F02413E9D18F66323064595', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'F26FD1B3DCBF43D38E37529BC60E12F3', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E9AFCA0B219A48F2B26C3407B89F6D4F', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0CC56B98214E4C8FB8439F341AFEEE28', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'B527659F90594CD4844E2A2F22223E2A', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'C58C67CD6EA94BB2963C9714C6F9F90B', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '3DA8897C41E8473A99C5492100190412', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '2309E4BC9A924651B31F785C830728B6', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0F54D4F78A8D491FA43C3FBF60A9B1CF', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '9B746C1302684616B012733A4E791179', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E24E30A2E2674303B6C9B62B36D79ADC', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '8890D1E058DB4B7894B2D7B2BCC696A7', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A10AF55DA5C548E294DBD10A10F92E46', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '062D833DD050478A8B6D5503CD347F60', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'D650F41753614EF68D65AD237334627C', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'AE5067796D694BAFB287D18529BAFFE2', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '352724802F66473AA600570AB00C61D4', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'CB6D94D479C34121A38F5B40B91106D2', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '8B31D84CC47A466C8132F6C0D212D442', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A3E3FFABB3264BEC9D20C47EA542B2F0', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '58F8C1A54B244D07986F391AD5CB9E5D', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '10ACD5DC793A4D5A9F4228195CF57B77', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'F43CE8D5ABDB46148E26B8C6A7C513D7', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'CB28B8D3B8E846C7A355249B8A6D14BC', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '374088A1D165445AB7496D87B9A5175E', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E5934CC56BEF43ECBF47AC07890713AC', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '2DFE8F4215A34E4AB1A603C36242F923', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0C86A52B779342DA92F4F6027B3251FE', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '805B2E58E7CB46CFAC9629FE35F9E051', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '21B1268FD84F4B1C8945C8E9731F0F49', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'F9B4C69C5F864657A55BF9560AAD7AC9', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '34CC225109974D0296DD538ED1A229C0', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '941ABAFE35D6480B95D0178B760BB1DB', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '56AF2BA7BBD643D8B66F1FEDB2F8D650', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A88AB1777C264C8387A4CF7B9C961048', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A3FEA09B72BA41868AA07D6818117AC0', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'FB4C99E9FB1A42F19B86FFC3DA761824', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '8D4EC97F07AA48C0BA5F5F55A302532E', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '6FB911AF50884CB9B52D3A6D9D3D4B03', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'AFF47427547E413D8A4E6E9D8658BB17', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '3E71A3CE7AB34607BDC570E72EBB6444', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '2B12F2FF49C242F4963A550AC1AA4D52', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '55371B38A22F4D078947A10E51837D47', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A4847B5D9E2C404BAFFCA1925B4C651B', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '6061F2E92C214F4E98AA9F8A6862CD58', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '40B743A6291A435AAE743CA93499AD8F', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '475B85B975C441E9B720FAC82ECAB89A', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '35EA71BD598246AFB5769EA6730A1254', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '165FEFC91D0F4A26B232D2A1D59F4D37', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E0214CC842524D61A1CADB4B25F28C6D', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '751789E53BAA42428D477E49B00572C5', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '140845F24CC241B7AB3783B93F98724B', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '2DA34B5B4BF643E89DD5B6C791CD630A', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '86BC5FE8B3624C5B96922DA0D299D843', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '351B1DF16E6444258F142C4FD767FCEE', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '81B28ED45F1A427ABBA9025E4D917AD0', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A6907ADFCD4B4E048DDA0632C2D5062F', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '5AA2258E1404444BAE135783DD56DC03', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'F52536BB355D4216AA5F541601ABA4E0', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'C50921BE08CE4C47BEC824DA733F4CFD', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '88EA18C8BA4847119DEFC9146B7C7F1F', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '3EC98DB80F6440269D3628766217A68E', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'FA00FAE5BE8249519544EAB937CED130', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '81F44FFCFB484D1B9B2B28B8B44038FD', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '831A77AF2FB5418FB6290E19ACB03F72', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '7F15BED5384E401AA13B8FE99FDD79E5', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '028280270812450986EE5E8552E692EC', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'D5FFAAAD152F4023BDEC443B8CECA7C6', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '588848E727F14FCAA21623A6894C2DDB', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0784E15BB48B4061A038499DC17B45C3', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '4C7AA4B348454752BEF6F9EC55402280', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0EE456741D42426DB6448E5C6DDFDA8E', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '18B306C4A74149609A3FDC36F86F902A', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'B0E3BAAA2955492FADE23C35F774BCC3', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'B31E5C8F9DDB434CA70DDCC8204A74F3', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '431D29CBA6B64D92821180C1DB4335DE', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '6232F8C5272A489CB66E54091718E5AD', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '633836EDCC0E40329B2BEBB34FA2B5FB', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'DA0BA7D60DD6461E85EA1EFB4E56AC1D', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '0073BE06AA6A49D783E9E033131A5C57', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'C1060CF0D3CE49A19BB7AEB3AF622B0C', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '92078E74B6784886BA2956AE553BFA69', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'A716C1E44907420AAD6CA5AC638541C8', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '7EF6056FFFDE4EE6BBF84F86EF66BF28', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '37A16BCD5D0E462EB892CDC9BB3D28EA', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'FB548F9A221041E1A70A0A30D12F3457', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '9A05C58D23E64D82A8A0FC1448EB732D', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '49A155C4DBBF4A56907BFA4B60B4FAF1', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '699C293D715340D392CD4E113B864D20', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '6BFC445EB2FC46D3B49582B319BB503E', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '4A911E4E08FE45BF95EE3CC1BA5F3B78', TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-09 23:03:58', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '729986573F3F498AB804BD1B7CC58466', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'C3A5BC0B6477434E9E3942C16353834A', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '9CFAB7B9645F4EB48F69A3E900B51CDB', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '440141C13AB345BC991774CDD7614909', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'E95BB25BFFAF4C13864DBC3A02B9306D', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'CD2780A03F02413E9D18F66323064595', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'F26FD1B3DCBF43D38E37529BC60E12F3', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'F2B99E17C4EC4CB399A1F4D435C28909', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '9E081346B9F5409EB8E8D79A988515E3', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '56FC1334D6A54B28B41C552156EA7E2C', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_VIP', '34D4A51F71A3452DA20B5C89272F7121', TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-01-08 10:14:00', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', '18B306C4A74149609A3FDC36F86F902A', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', 'B0E3BAAA2955492FADE23C35F774BCC3', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', 'B31E5C8F9DDB434CA70DDCC8204A74F3', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', '431D29CBA6B64D92821180C1DB4335DE', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', 'F52536BB355D4216AA5F541601ABA4E0', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', 'C50921BE08CE4C47BEC824DA733F4CFD', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', '88EA18C8BA4847119DEFC9146B7C7F1F', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('N_SYS', '3EC98DB80F6440269D3628766217A68E', TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:46:07', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'E5D1A0B765CE47E2933BAD1042E502DB', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '6353C6E2A9B34E0B898DE04E95461D43', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', 'D96F3B8972264040BD3C906EEF380675', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_SYS_ROLE_FUNC VALUES ('Marks_ADMIN', '95D0615FA08743F998C6B2997314FE9A', TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-23 09:10:45', 'YYYY-MM-DD HH24:MI:SS'), null);

-- ----------------------------
-- Table structure for TB_SYS_USER
-- ----------------------------
DROP TABLE TB_SYS_USER;
CREATE TABLE TB_SYS_USER (
USERID VARCHAR2(50 BYTE) NOT NULL ,
USERNAME VARCHAR2(50 BYTE) NOT NULL ,
PASSWORD VARCHAR2(250 BYTE) NOT NULL ,
BIND_MOBILE VARCHAR2(16 BYTE) NULL ,
ACTIVEFLAG NUMBER(1) DEFAULT 0  NOT NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL ,
TOKEN VARCHAR2(512 BYTE) NULL ,
OPENID VARCHAR2(64 BYTE) NULL ,
ROLEID VARCHAR2(50 BYTE) NULL ,
SKIN NUMBER(2) DEFAULT 0  NULL ,
BINDFLAG NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_USER
-- ----------------------------
INSERT INTO TB_SYS_USER VALUES ('admin', '超级管理员', 'B15A268148D9C5A9363E915581CE1819', '18680221791', '1', null, null, null, '0', null, null, 'Marks_ADMIN', '0', '1');
INSERT INTO TB_SYS_USER VALUES ('U10000040', '18210012743', 'B15A268148D9C5A9363E915581CE1819', '18210012743', '1', TO_TIMESTAMP(' 2017-02-23 09:45:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-23 09:45:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin', 'N', null, null, 'N_SYS', '0', '1');

-- ----------------------------
-- Table structure for TB_SYS_USER_ORG
-- ----------------------------
DROP TABLE TB_SYS_USER_ORG;
CREATE TABLE TB_SYS_USER_ORG (
USERID VARCHAR2(50 BYTE) NOT NULL ,
ORGID VARCHAR2(50 BYTE) NOT NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(150 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_SYS_USER_ORG
-- ----------------------------
INSERT INTO TB_SYS_USER_ORG VALUES ('admin', 'Marks', TO_TIMESTAMP(' 2017-01-09 09:25:27:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-09 09:25:27:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '18680221791');
INSERT INTO TB_SYS_USER_ORG VALUES ('U10000040', 'test1', TO_TIMESTAMP(' 2017-02-23 09:45:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-02-23 09:45:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'admin');

-- ----------------------------
-- Table structure for TB_VIP_INFO
-- ----------------------------
DROP TABLE TB_VIP_INFO;
CREATE TABLE TB_VIP_INFO (
USERID VARCHAR2(50 BYTE) NOT NULL ,
REALNAME VARCHAR2(50 BYTE) NULL ,
GENDER VARCHAR2(1 BYTE) NULL ,
BIRTHDATE VARCHAR2(20 BYTE) NULL ,
EMAIL VARCHAR2(20 BYTE) NULL ,
SIGNATURE NVARCHAR2(100) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_VIP_INFO
-- ----------------------------
INSERT INTO TB_VIP_INFO VALUES ('admin', 'meckiy', '1', '2017-11-11', 'cimei', '心若静，风奈何', TO_TIMESTAMP(' 2017-01-11 14:28:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), TO_TIMESTAMP(' 2017-01-11 14:28:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'));

-- ----------------------------
-- Table structure for TB_WX_ACCESS_TOKEN
-- ----------------------------
DROP TABLE TB_WX_ACCESS_TOKEN;
CREATE TABLE TB_WX_ACCESS_TOKEN (
ACCOUNTID VARCHAR2(100 BYTE) NOT NULL ,
ACCESSTOKEN VARCHAR2(255 BYTE) NOT NULL ,
PUTTIME VARCHAR2(20 BYTE) DEFAULT 0  NULL ,
EXPIRES_IN VARCHAR2(20 BYTE) DEFAULT 0  NULL ,
UPDATETIME DATE NULL 
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
DROP TABLE TB_WX_ACCOUNT;
CREATE TABLE TB_WX_ACCOUNT (
ACCOUNTID VARCHAR2(50 BYTE) NOT NULL ,
ACCOUNTNAME VARCHAR2(100 BYTE) NULL ,
APPID VARCHAR2(50 BYTE) NULL ,
APPSECRET VARCHAR2(100 BYTE) NULL ,
AUTHDOMAIN VARCHAR2(300 BYTE) NULL ,
URL VARCHAR2(400 BYTE) NULL ,
TOKEN VARCHAR2(32 BYTE) NULL ,
AESKEY VARCHAR2(50 BYTE) NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
CREATETIME DATE NULL ,
SERVER_CONTEXT VARCHAR2(50 BYTE) NULL ,
WX_ACCTNO VARCHAR2(100 BYTE) NULL ,
IS_SERVICE NUMBER(1) DEFAULT 0  NULL ,
ACCTTYPE NUMBER(1) DEFAULT 0  NULL ,
UPDATETIME DATE NULL ,
ORGID VARCHAR2(50 BYTE) NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_WX_ACCOUNT.ACCOUNTID IS '账号';
COMMENT ON COLUMN TB_WX_ACCOUNT.ACCOUNTNAME IS '名称';
COMMENT ON COLUMN TB_WX_ACCOUNT.AUTHDOMAIN IS '域名';
COMMENT ON COLUMN TB_WX_ACCOUNT.URL IS '回调路径';
COMMENT ON COLUMN TB_WX_ACCOUNT.CREATOR IS '创建者';
COMMENT ON COLUMN TB_WX_ACCOUNT.CREATETIME IS '创建时间';
COMMENT ON COLUMN TB_WX_ACCOUNT.SERVER_CONTEXT IS '访问上下文';
COMMENT ON COLUMN TB_WX_ACCOUNT.WX_ACCTNO IS '微信号';
COMMENT ON COLUMN TB_WX_ACCOUNT.IS_SERVICE IS '1:提供服务，0：不提供服务';
COMMENT ON COLUMN TB_WX_ACCOUNT.ACCTTYPE IS '0:服务号 1：企业号 2:订阅号';
COMMENT ON COLUMN TB_WX_ACCOUNT.ORGID IS '组织ID';

-- ----------------------------
-- Records of TB_WX_ACCOUNT
-- ----------------------------
INSERT INTO TB_WX_ACCOUNT VALUES ('wxtest012', '测试012', 'wx1102d8ed48b46f5e', 'c655d6de4b8fa4587fca8691ed478996', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=wxtest012', null, null, 'admin', TO_DATE('2016-11-17 14:44:07', 'YYYY-MM-DD HH24:MI:SS'), '/', 'test_012 ', '0', '0', TO_DATE('2017-01-11 21:07:24', 'YYYY-MM-DD HH24:MI:SS'), 'Marks', 'Marks');
INSERT INTO TB_WX_ACCOUNT VALUES ('ctest', 'cjmei0221测试服务号', 'wxfa54b3d1eafa3510', '15411cc0a1cd4eea2003581717ec0d59', null, 'null/WECHAT/HANDLER?accountid=ctest', null, null, 'admin', TO_DATE('2016-11-25 11:03:09', 'YYYY-MM-DD HH24:MI:SS'), '/', null, '1', '0', TO_DATE('2017-01-11 20:15:38', 'YYYY-MM-DD HH24:MI:SS'), 'Marks', 'Marks');
INSERT INTO TB_WX_ACCOUNT VALUES ('qy_cjmei', 'C团队', 'wx89e520f1912d47a2', 'o9cj_Mo84hGY0x1nu4uDzGV8mfrkoBRpQehiCHkKOp3g5i6oUxM-BzH2vcgax8fx', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=qy_cjmei', null, null, 'admin', TO_DATE('2016-11-17 14:13:13', 'YYYY-MM-DD HH24:MI:SS'), '/', null, '0', '1', TO_DATE('2017-01-11 20:37:23', 'YYYY-MM-DD HH24:MI:SS'), 'Marks', 'Marks');

-- ----------------------------
-- Table structure for TB_WX_AUTO_REPLAY
-- ----------------------------
DROP TABLE TB_WX_AUTO_REPLAY;
CREATE TABLE TB_WX_AUTO_REPLAY (
CKEY VARCHAR2(200 BYTE) NULL ,
CREPLAY VARCHAR2(2000 BYTE) NULL ,
CTYPE VARCHAR2(50 BYTE) NOT NULL ,
CTYPENAME VARCHAR2(100 BYTE) NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NULL ,
REPLAYTYPE VARCHAR2(20 BYTE) NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
DELFLAG NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_AUTO_REPLAY
-- ----------------------------
INSERT INTO TB_WX_AUTO_REPLAY VALUES ('34', '43534', 'C9D2D60D442046D9B723BEC005C34AB5', '测试', 'ctest', 'TEXT', TO_DATE('2017-02-28 15:31:28', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2017-02-28 15:31:28', 'YYYY-MM-DD HH24:MI:SS'), 'admin', '1');

-- ----------------------------
-- Table structure for TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
DROP TABLE TB_WX_AUTO_REPLAY_NEWSITEM;
CREATE TABLE TB_WX_AUTO_REPLAY_NEWSITEM (
ID VARCHAR2(50 BYTE) NOT NULL ,
TITLE VARCHAR2(100 BYTE) NULL ,
DESCRIPTION VARCHAR2(300 BYTE) NULL ,
PICURL VARCHAR2(200 BYTE) NULL ,
URL VARCHAR2(1000 BYTE) NULL ,
SORT NUMBER(10) NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
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
DROP TABLE TB_WX_CHAT_MSG;
CREATE TABLE TB_WX_CHAT_MSG (
ID VARCHAR2(50 BYTE) NOT NULL ,
TOUSERNAME VARCHAR2(50 BYTE) NULL ,
FROMUSERNAME VARCHAR2(50 BYTE) NULL ,
MSGID VARCHAR2(100 BYTE) NULL ,
MSGTYPE VARCHAR2(50 BYTE) NULL ,
PICURL VARCHAR2(200 BYTE) NULL ,
MEDIAID VARCHAR2(50 BYTE) NULL ,
CONTENT VARCHAR2(2000 BYTE) NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NULL ,
CREATETIME DATE NULL ,
FORMAT VARCHAR2(100 BYTE) NULL ,
RECOGNITION VARCHAR2(255 BYTE) NULL ,
LOCATION_X VARCHAR2(50 BYTE) NULL ,
LOCATION_Y VARCHAR2(50 BYTE) NULL ,
SCALE VARCHAR2(20 BYTE) NULL ,
THUMBMEDIAID VARCHAR2(50 BYTE) NULL ,
TITLE VARCHAR2(255 BYTE) NULL ,
DESCRIPTION VARCHAR2(255 BYTE) NULL ,
URL VARCHAR2(255 BYTE) NULL ,
EVENT VARCHAR2(255 BYTE) NULL ,
EVENTKEY VARCHAR2(255 BYTE) NULL ,
TICKET VARCHAR2(255 BYTE) NULL ,
LABEL VARCHAR2(255 BYTE) NULL ,
ISREQUEST CHAR(1 BYTE) NULL 
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
DROP TABLE TB_WX_CHAT_NEWS_MSG;
CREATE TABLE TB_WX_CHAT_NEWS_MSG (
ID VARCHAR2(50 BYTE) NOT NULL ,
CHAT_ID VARCHAR2(50 BYTE) NOT NULL ,
TITLE VARCHAR2(100 BYTE) NULL ,
DESCRIPTION VARCHAR2(255 BYTE) NULL ,
PICURL VARCHAR2(100 BYTE) NULL ,
URL VARCHAR2(200 BYTE) NULL 
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
DROP TABLE TB_WX_MENU;
CREATE TABLE TB_WX_MENU (
ID VARCHAR2(32 BYTE) NOT NULL ,
PARENT_ID VARCHAR2(32 BYTE) NULL ,
NAME VARCHAR2(100 BYTE) NULL ,
TYPE VARCHAR2(32 BYTE) NULL ,
CONTENT VARCHAR2(1000 BYTE) NULL ,
SORT NUMBER(2) DEFAULT 0  NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NULL ,
LVL NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_MENU
-- ----------------------------
INSERT INTO TB_WX_MENU VALUES ('8F877DEE46A14CF492E72FAD4FD2B739', 'wxtest012', '测试1', 'view', 'http://www.baidu.com', '1', 'wxtest012', '1');
INSERT INTO TB_WX_MENU VALUES ('EC46566839D64430BCB33C5CA7632DAD', 'ctest', '痕迹', '1', '#', '1', 'ctest', '1');
INSERT INTO TB_WX_MENU VALUES ('BF9153133E8C4E5B8DFAEF655E328DB7', 'EC46566839D64430BCB33C5CA7632DAD', '备忘', 'view', 'http://192.168.1.105:8080/mobile/view/note/gains/list.html', '2', 'ctest', '2');
INSERT INTO TB_WX_MENU VALUES ('26CB0FA34F4E47DCA4CB68CF887D3F17', 'EC46566839D64430BCB33C5CA7632DAD', '日记', 'view', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '1', 'ctest', '2');
INSERT INTO TB_WX_MENU VALUES ('42B3A5D791F54772AD235379E3BFD622', 'EC46566839D64430BCB33C5CA7632DAD', '问题', 'view', 'http://192.168.1.105:8080/mobile/view/note/question/list.html', '3', 'ctest', '2');
INSERT INTO TB_WX_MENU VALUES ('9C53C598166F442694BB19507A5DFB34', 'ctest', '我', 'view', 'http://192.168.1.105:8080/mobile/view/note/owner/myInfo.html', '2', 'ctest', '1');
INSERT INTO TB_WX_MENU VALUES ('F9EF2E2295054A7796C9DE393CDBA9CB', '8F877DEE46A14CF492E72FAD4FD2B739', '测试2', 'view', 'https://www.baidu.com', '2', 'wxtest012', '2');
INSERT INTO TB_WX_MENU VALUES ('ED7A8C4367A543C8ADA6A57A14F19700', '8F877DEE46A14CF492E72FAD4FD2B739', '测试3', 'view', 'https://www.baidu.com', '1', 'wxtest012', '2');
INSERT INTO TB_WX_MENU VALUES ('0B711EA4D8404F3589295C860058BA0D', 'wxtest012', 'ces1', 'view', 'https://www.baidu.com', '2', 'wxtest012', '1');

-- ----------------------------
-- Table structure for TB_WX_MENU_URL
-- ----------------------------
DROP TABLE TB_WX_MENU_URL;
CREATE TABLE TB_WX_MENU_URL (
ID VARCHAR2(50 BYTE) NOT NULL ,
MENUNAME VARCHAR2(100 BYTE) NULL ,
MENUURL VARCHAR2(1000 BYTE) NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_MENU_URL
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_MODULE_MSG
-- ----------------------------
DROP TABLE TB_WX_MODULE_MSG;
CREATE TABLE TB_WX_MODULE_MSG (
ID VARCHAR2(64 BYTE) NOT NULL ,
ACCOUNTID VARCHAR2(64 BYTE) NULL ,
TEMPLATE_ID VARCHAR2(64 BYTE) NULL ,
TOUSER VARCHAR2(64 BYTE) NULL ,
URL VARCHAR2(1024 BYTE) NULL ,
DATA VARCHAR2(2048 BYTE) NULL ,
NEEDFLAG NUMBER(1) DEFAULT 1  NULL ,
SENDFLAG NUMBER(1) DEFAULT 0  NULL ,
SENDTIMES NUMBER(1) DEFAULT 0  NULL ,
CREATETIME DATE NULL ,
SENDTIME DATE NULL ,
MSGID VARCHAR2(64 BYTE) NULL ,
PUSH_CODE VARCHAR2(64 BYTE) NULL ,
PUSH_MSG VARCHAR2(1024 BYTE) NULL ,
RESULTCODE VARCHAR2(64 BYTE) NULL ,
RESULTMSG VARCHAR2(1024 BYTE) NULL ,
NOTE VARCHAR2(528 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_WX_MODULE_MSG
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_QRCODE
-- ----------------------------
DROP TABLE TB_WX_QRCODE;
CREATE TABLE TB_WX_QRCODE (
ID VARCHAR2(50 BYTE) NOT NULL ,
QRNO VARCHAR2(50 BYTE) NULL ,
QRNAME VARCHAR2(200 BYTE) NULL ,
QRTYPE VARCHAR2(50 BYTE) NULL ,
QRURL VARCHAR2(1024 BYTE) NULL ,
ACCOUNTID VARCHAR2(200 BYTE) NULL ,
QRPATH VARCHAR2(1024 BYTE) NULL ,
SCENETYPE NUMBER(1) DEFAULT 1  NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL ,
COMPANYID VARCHAR2(50 BYTE) NULL 
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
DROP TABLE TB_WX_TEMPLATE;
CREATE TABLE TB_WX_TEMPLATE (
YWTYPE VARCHAR2(36 BYTE) NOT NULL ,
ACCOUNTID VARCHAR2(36 BYTE) NOT NULL ,
TEMPLATE_ID VARCHAR2(50 BYTE) NULL ,
TEMPLATE_NAME VARCHAR2(50 BYTE) NULL ,
FIRST_CONTENT VARCHAR2(50 BYTE) NULL ,
REMARK_CONTENT VARCHAR2(1024 BYTE) NULL ,
DETAILURL VARCHAR2(1024 BYTE) NULL ,
STATUS NUMBER(1) DEFAULT 0  NULL ,
CREATETIME DATE NULL ,
UPDATETIME DATE NULL ,
CREATOR VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_WX_TEMPLATE.STATUS IS '0：启用 1：失效';

-- ----------------------------
-- Records of TB_WX_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Table structure for TB_WX_USER
-- ----------------------------
DROP TABLE TB_WX_USER;
CREATE TABLE TB_WX_USER (
OPENID VARCHAR2(50 BYTE) NOT NULL ,
NICKNAME VARCHAR2(256 BYTE) NULL ,
GROUPID NUMBER DEFAULT 0  NOT NULL ,
COUNTRY VARCHAR2(256 BYTE) NULL ,
PROVINCE VARCHAR2(256 BYTE) NULL ,
CITY VARCHAR2(256 BYTE) NULL ,
SEX NUMBER NULL ,
IMAGEURL VARCHAR2(1024 BYTE) NULL ,
LANGUAGE VARCHAR2(32 BYTE) NULL ,
ISSUBSCRIBE NUMBER DEFAULT 1  NOT NULL ,
SUBSCRIBETIME TIMESTAMP(6)  NULL ,
UPDATETIME TIMESTAMP(6)  NULL ,
ACCOUNTID VARCHAR2(50 BYTE) NOT NULL ,
CREATETIME TIMESTAMP(6)  NULL ,
USEFLAG NUMBER DEFAULT 0  NULL ,
QRNO VARCHAR2(50 BYTE) NULL ,
REMARK VARCHAR2(250 BYTE) NULL ,
DAIRYFLAG NUMBER(1) DEFAULT 0  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN TB_WX_USER.USEFLAG IS '黑名单标识 0：正常 1：黑户';
COMMENT ON COLUMN TB_WX_USER.DAIRYFLAG IS '日记提醒标识 1：推送 0：不推送';

-- ----------------------------
-- Records of TB_WX_USER
-- ----------------------------

-- ----------------------------
-- View structure for VIEW_SYS_ROLE_FUNC
-- ----------------------------
CREATE OR REPLACE FORCE VIEW VIEW_SYS_ROLE_FUNC AS 
SELECT DISTINCT
  tso.OPERID,
  tso.OPERNAME,
  tso.PICICON,
  TSR.MENUID,
  tsr.FUNCID,
  TSRF.ROLEID,
  TSO.sort SORT
FROM
  TB_SYS_OPERATE tso
JOIN TB_SYS_FUNC tsr ON tso.operid = tsr.operid
LEFT JOIN TB_SYS_ROLE_FUNC tsrf ON tsr.funcid = tsrf.funcid
ORDER BY
  TSO.sort;

-- ----------------------------
-- View structure for VIEW_SYS_ROLE_MENU
-- ----------------------------
CREATE OR REPLACE FORCE VIEW VIEW_SYS_ROLE_MENU AS 
SELECT DISTINCT
  tsm.MENUID,
  tsm.PARENTID,
  tsm.MENUITEM,
  tsm.URL,
  tsm.SORT nsort,
  tsrf.ROLEID
FROM
  TB_SYS_MENU tsm
LEFT JOIN TB_SYS_FUNC tsf ON TSM.MENUID = TSF.MENUID
LEFT JOIN TB_SYS_ROLE_FUNC tsrf ON tsf.FUNCID = tsrf.FUNCID
order by tsm.SORT;

-- ----------------------------
-- Sequence structure for SEQ_SYS_USER
-- ----------------------------
DROP SEQUENCE SEQ_SYS_USER;
CREATE SEQUENCE SEQ_SYS_USER
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 10000050
 CACHE 10;

-- ----------------------------
-- Sequence structure for SEQ_WX_AUTO_REPLAY_NEWS
-- ----------------------------
DROP SEQUENCE SEQ_WX_AUTO_REPLAY_NEWS;
CREATE SEQUENCE SEQ_WX_AUTO_REPLAY_NEWS
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999
 START WITH 100000015
 NOCACHE 
 CYCLE ;

-- ----------------------------
-- Indexes structure for table TB_AUTOCODE_ATTR
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_AUTOCODE_ATTR
-- ----------------------------
ALTER TABLE TB_AUTOCODE_ATTR ADD CHECK (ATTRNAME IS NOT NULL);
ALTER TABLE TB_AUTOCODE_ATTR ADD CHECK (TABLENAME IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_AUTOCODE_ATTR
-- ----------------------------
ALTER TABLE TB_AUTOCODE_ATTR ADD PRIMARY KEY (ATTRNAME, TABLENAME);

-- ----------------------------
-- Indexes structure for table TB_AUTOCODE_BEAN
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_AUTOCODE_BEAN
-- ----------------------------
ALTER TABLE TB_AUTOCODE_BEAN ADD CHECK (TABLENAME IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_AUTOCODE_BEAN
-- ----------------------------
ALTER TABLE TB_AUTOCODE_BEAN ADD PRIMARY KEY (TABLENAME);

-- ----------------------------
-- Indexes structure for table TB_MALL_ADVISE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_MALL_ADVISE
-- ----------------------------
ALTER TABLE TB_MALL_ADVISE ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_MALL_ADVISE
-- ----------------------------
ALTER TABLE TB_MALL_ADVISE ADD PRIMARY KEY (ID);

-- ----------------------------
-- Checks structure for table TB_MALL_GOOD_IMG
-- ----------------------------
ALTER TABLE TB_MALL_GOOD_IMG ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Indexes structure for table TB_MALL_GOOD_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_MALL_GOOD_INFO
-- ----------------------------
ALTER TABLE TB_MALL_GOOD_INFO ADD CHECK (GOODID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_MALL_GOOD_INFO
-- ----------------------------
ALTER TABLE TB_MALL_GOOD_INFO ADD PRIMARY KEY (GOODID);

-- ----------------------------
-- Indexes structure for table TB_NOTE_DIARY
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_NOTE_DIARY
-- ----------------------------
ALTER TABLE TB_NOTE_DIARY ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_NOTE_DIARY
-- ----------------------------
ALTER TABLE TB_NOTE_DIARY ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_NOTE_GAINS
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_NOTE_GAINS
-- ----------------------------
ALTER TABLE TB_NOTE_GAINS ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_NOTE_GAINS
-- ----------------------------
ALTER TABLE TB_NOTE_GAINS ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_NOTE_QUESTION
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_NOTE_QUESTION
-- ----------------------------
ALTER TABLE TB_NOTE_QUESTION ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_NOTE_QUESTION
-- ----------------------------
ALTER TABLE TB_NOTE_QUESTION ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_ORG_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_ORG_INFO
-- ----------------------------
ALTER TABLE TB_ORG_INFO ADD CHECK (ORGID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_ORG_INFO
-- ----------------------------
ALTER TABLE TB_ORG_INFO ADD PRIMARY KEY (ORGID);

-- ----------------------------
-- Indexes structure for table TB_SYS_CONF
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_CONF
-- ----------------------------
ALTER TABLE TB_SYS_CONF ADD CHECK (CKEY IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_CONF
-- ----------------------------
ALTER TABLE TB_SYS_CONF ADD PRIMARY KEY (CKEY);

-- ----------------------------
-- Indexes structure for table TB_SYS_DATADIR_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_DATADIR_INFO
-- ----------------------------
ALTER TABLE TB_SYS_DATADIR_INFO ADD CHECK (CKEY IS NOT NULL);
ALTER TABLE TB_SYS_DATADIR_INFO ADD CHECK (PARENTKEY IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_DATADIR_INFO
-- ----------------------------
ALTER TABLE TB_SYS_DATADIR_INFO ADD PRIMARY KEY (CKEY, PARENTKEY);

-- ----------------------------
-- Indexes structure for table TB_SYS_FUNC
-- ----------------------------
CREATE INDEX IDX_TB_SYS_FUNC_URL
ON TB_SYS_FUNC (URL ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_SYS_FUNC
-- ----------------------------
ALTER TABLE TB_SYS_FUNC ADD CHECK (FUNCID IS NOT NULL);
ALTER TABLE TB_SYS_FUNC ADD CHECK (MENUID IS NOT NULL);
ALTER TABLE TB_SYS_FUNC ADD CHECK (OPERID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_FUNC
-- ----------------------------
ALTER TABLE TB_SYS_FUNC ADD PRIMARY KEY (FUNCID);

-- ----------------------------
-- Indexes structure for table TB_SYS_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_LOG
-- ----------------------------
ALTER TABLE TB_SYS_LOG ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_LOG
-- ----------------------------
ALTER TABLE TB_SYS_LOG ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_SYS_LOG_PARAM
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_LOG_PARAM
-- ----------------------------
ALTER TABLE TB_SYS_LOG_PARAM ADD CHECK (URL IS NOT NULL);
ALTER TABLE TB_SYS_LOG_PARAM ADD CHECK (SOURCE IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_LOG_PARAM
-- ----------------------------
ALTER TABLE TB_SYS_LOG_PARAM ADD PRIMARY KEY (URL, SOURCE);

-- ----------------------------
-- Indexes structure for table TB_SYS_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_MENU
-- ----------------------------
ALTER TABLE TB_SYS_MENU ADD CHECK (MENUID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_MENU
-- ----------------------------
ALTER TABLE TB_SYS_MENU ADD PRIMARY KEY (MENUID);

-- ----------------------------
-- Indexes structure for table TB_SYS_OPERATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_OPERATE
-- ----------------------------
ALTER TABLE TB_SYS_OPERATE ADD CHECK (OPERNAME IS NOT NULL);
ALTER TABLE TB_SYS_OPERATE ADD CHECK (OPERID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_OPERATE
-- ----------------------------
ALTER TABLE TB_SYS_OPERATE ADD PRIMARY KEY (OPERID);

-- ----------------------------
-- Indexes structure for table TB_SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_ROLE
-- ----------------------------
ALTER TABLE TB_SYS_ROLE ADD CHECK (ROLEID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_ROLE
-- ----------------------------
ALTER TABLE TB_SYS_ROLE ADD PRIMARY KEY (ROLEID);

-- ----------------------------
-- Indexes structure for table TB_SYS_ROLE_FUNC
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_ROLE_FUNC
-- ----------------------------
ALTER TABLE TB_SYS_ROLE_FUNC ADD CHECK (ROLEID IS NOT NULL);
ALTER TABLE TB_SYS_ROLE_FUNC ADD CHECK (FUNCID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_ROLE_FUNC
-- ----------------------------
ALTER TABLE TB_SYS_ROLE_FUNC ADD PRIMARY KEY (ROLEID, FUNCID);

-- ----------------------------
-- Indexes structure for table TB_SYS_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_USER
-- ----------------------------
ALTER TABLE TB_SYS_USER ADD CHECK (USERID IS NOT NULL);
ALTER TABLE TB_SYS_USER ADD CHECK (USERNAME IS NOT NULL);
ALTER TABLE TB_SYS_USER ADD CHECK (PASSWORD IS NOT NULL);
ALTER TABLE TB_SYS_USER ADD CHECK (ACTIVEFLAG IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_USER
-- ----------------------------
ALTER TABLE TB_SYS_USER ADD PRIMARY KEY (USERID);

-- ----------------------------
-- Indexes structure for table TB_SYS_USER_ORG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_SYS_USER_ORG
-- ----------------------------
ALTER TABLE TB_SYS_USER_ORG ADD CHECK (USERID IS NOT NULL);
ALTER TABLE TB_SYS_USER_ORG ADD CHECK (ORGID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_SYS_USER_ORG
-- ----------------------------
ALTER TABLE TB_SYS_USER_ORG ADD PRIMARY KEY (USERID, ORGID);

-- ----------------------------
-- Indexes structure for table TB_VIP_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_VIP_INFO
-- ----------------------------
ALTER TABLE TB_VIP_INFO ADD CHECK (USERID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_VIP_INFO
-- ----------------------------
ALTER TABLE TB_VIP_INFO ADD PRIMARY KEY (USERID);

-- ----------------------------
-- Indexes structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------
ALTER TABLE TB_WX_ACCESS_TOKEN ADD CHECK (ACCOUNTID IS NOT NULL);
ALTER TABLE TB_WX_ACCESS_TOKEN ADD CHECK (ACCESSTOKEN IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_ACCESS_TOKEN
-- ----------------------------
ALTER TABLE TB_WX_ACCESS_TOKEN ADD PRIMARY KEY (ACCOUNTID);

-- ----------------------------
-- Indexes structure for table TB_WX_ACCOUNT
-- ----------------------------
CREATE INDEX TB_WX_ACCOUNT_NAMEIDX
ON TB_WX_ACCOUNT (ACCOUNTNAME ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_ACCOUNT
-- ----------------------------
ALTER TABLE TB_WX_ACCOUNT ADD CHECK (ACCOUNTID IS NOT NULL);

-- ----------------------------
-- Indexes structure for table TB_WX_AUTO_REPLAY
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_AUTO_REPLAY
-- ----------------------------
ALTER TABLE TB_WX_AUTO_REPLAY ADD CHECK (CTYPE IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_AUTO_REPLAY
-- ----------------------------
ALTER TABLE TB_WX_AUTO_REPLAY ADD PRIMARY KEY (CTYPE);

-- ----------------------------
-- Indexes structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
ALTER TABLE TB_WX_AUTO_REPLAY_NEWSITEM ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_AUTO_REPLAY_NEWSITEM
-- ----------------------------
ALTER TABLE TB_WX_AUTO_REPLAY_NEWSITEM ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_CHAT_MSG
-- ----------------------------
CREATE INDEX IDX_WX_CHAT_MSG_ACCOUNTID
ON TB_WX_CHAT_MSG (ACCOUNTID ASC)
LOGGING
VISIBLE;
CREATE INDEX IDX_WX_CHAT_MSG_FROMUSER
ON TB_WX_CHAT_MSG (FROMUSERNAME ASC)
LOGGING
VISIBLE;
CREATE INDEX IDX_WX_CHAT_MSG_TOUSER
ON TB_WX_CHAT_MSG (TOUSERNAME ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_CHAT_MSG
-- ----------------------------
ALTER TABLE TB_WX_CHAT_MSG ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_CHAT_MSG
-- ----------------------------
ALTER TABLE TB_WX_CHAT_MSG ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
CREATE INDEX IDX_WX_CHAT_NEWS_MSG_CHATID
ON TB_WX_CHAT_NEWS_MSG (CHAT_ID ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
ALTER TABLE TB_WX_CHAT_NEWS_MSG ADD CHECK (ID IS NOT NULL);
ALTER TABLE TB_WX_CHAT_NEWS_MSG ADD CHECK (CHAT_ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_CHAT_NEWS_MSG
-- ----------------------------
ALTER TABLE TB_WX_CHAT_NEWS_MSG ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_MENU
-- ----------------------------
ALTER TABLE TB_WX_MENU ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_MENU
-- ----------------------------
ALTER TABLE TB_WX_MENU ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_MENU_URL
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_MENU_URL
-- ----------------------------
ALTER TABLE TB_WX_MENU_URL ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_MENU_URL
-- ----------------------------
ALTER TABLE TB_WX_MENU_URL ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_MODULE_MSG
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_MODULE_MSG
-- ----------------------------
ALTER TABLE TB_WX_MODULE_MSG ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_MODULE_MSG
-- ----------------------------
ALTER TABLE TB_WX_MODULE_MSG ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_QRCODE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_QRCODE
-- ----------------------------
ALTER TABLE TB_WX_QRCODE ADD CHECK (ID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_QRCODE
-- ----------------------------
ALTER TABLE TB_WX_QRCODE ADD PRIMARY KEY (ID);

-- ----------------------------
-- Indexes structure for table TB_WX_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_WX_TEMPLATE
-- ----------------------------
ALTER TABLE TB_WX_TEMPLATE ADD CHECK (YWTYPE IS NOT NULL);
ALTER TABLE TB_WX_TEMPLATE ADD CHECK (ACCOUNTID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_TEMPLATE
-- ----------------------------
ALTER TABLE TB_WX_TEMPLATE ADD PRIMARY KEY (YWTYPE, ACCOUNTID);

-- ----------------------------
-- Indexes structure for table TB_WX_USER
-- ----------------------------
CREATE INDEX IDX_WX_USER_ISSUBSCRIBE
ON TB_WX_USER (ISSUBSCRIBE ASC)
LOGGING
VISIBLE;
CREATE INDEX IDX_WX_USER_NICKNAME
ON TB_WX_USER (NICKNAME ASC)
LOGGING
VISIBLE;
CREATE INDEX IDX_WX_USER_SUBSCRIBETIME
ON TB_WX_USER (SUBSCRIBETIME ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table TB_WX_USER
-- ----------------------------
ALTER TABLE TB_WX_USER ADD CHECK (OPENID IS NOT NULL);
ALTER TABLE TB_WX_USER ADD CHECK (GROUPID IS NOT NULL);
ALTER TABLE TB_WX_USER ADD CHECK (ISSUBSCRIBE IS NOT NULL);
ALTER TABLE TB_WX_USER ADD CHECK (ACCOUNTID IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_WX_USER
-- ----------------------------
ALTER TABLE TB_WX_USER ADD PRIMARY KEY (OPENID, ACCOUNTID);
