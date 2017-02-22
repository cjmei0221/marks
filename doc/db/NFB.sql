prompt PL/SQL Developer import file
prompt Created on 2017年2月23日 by cjmei
set feedback off
set define off
prompt Creating TB_AUTOCODE_ATTR...
create table TB_AUTOCODE_ATTR
(
  ATTRNAME  VARCHAR2(50) not null,
  ATTRTYPE  VARCHAR2(50),
  ISPK      NUMBER(1) default 0,
  SEQ       VARCHAR2(50),
  ATTRSIZE  NUMBER(4),
  ATTRDESC  VARCHAR2(50),
  TABLENAME VARCHAR2(50) not null,
  SORT      NUMBER(2) default 0,
  NOTE      NVARCHAR2(200)
)
;
alter table TB_AUTOCODE_ATTR
  add primary key (ATTRNAME, TABLENAME);

prompt Creating TB_AUTOCODE_BEAN...
create table TB_AUTOCODE_BEAN
(
  TABLENAME      VARCHAR2(50) not null,
  BEANNAME       VARCHAR2(50),
  MODULEDESC     VARCHAR2(1024),
  IS_CREATETABLE NUMBER(1) default 0,
  CREATETIME     DATE,
  IS_AUTH        NUMBER(1),
  UPDATETIME     DATE,
  PARENTPACKAGE  VARCHAR2(50),
  DESCRIPTION    NVARCHAR2(350),
  ISAUTO         NUMBER(1) default 1
)
;
comment on column TB_AUTOCODE_BEAN.IS_CREATETABLE
  is '0：不生成  1：生成';
alter table TB_AUTOCODE_BEAN
  add primary key (TABLENAME);

prompt Creating TB_MALL_ADVISE...
create table TB_MALL_ADVISE
(
  ID         VARCHAR2(50) not null,
  CONTENT    VARCHAR2(1024),
  LABEL      VARCHAR2(512),
  NUM        NUMBER(5),
  CREATETIME DATE,
  UPDATETIME DATE,
  USERID     VARCHAR2(50),
  MOBILE     VARCHAR2(50)
)
;
alter table TB_MALL_ADVISE
  add primary key (ID);

prompt Creating TB_MALL_GOOD_IMG...
create table TB_MALL_GOOD_IMG
(
  ID         VARCHAR2(50) not null,
  GOODID     VARCHAR2(50),
  IMGTYPE    NUMBER(1),
  IMGURL     VARCHAR2(255),
  CREATETIME DATE,
  SORT       NUMBER(2),
  IMGNAME    VARCHAR2(50)
)
;
comment on column TB_MALL_GOOD_IMG.IMGTYPE
  is '图片类型  1：主图  2：详图';
comment on column TB_MALL_GOOD_IMG.SORT
  is '排序';

prompt Creating TB_MALL_GOOD_INFO...
create table TB_MALL_GOOD_INFO
(
  GOODID        VARCHAR2(50) not null,
  GOODNAME      VARCHAR2(1024),
  GOODPRICE     NUMBER(12),
  UNIT          VARCHAR2(50),
  IMAGEURL      VARCHAR2(1024),
  CREATETIME    TIMESTAMP(6),
  UPDATETIME    TIMESTAMP(6),
  CREATOR       VARCHAR2(50),
  BRAND         VARCHAR2(150),
  MADEIN        VARCHAR2(150),
  MATERIAL      VARCHAR2(255),
  DESCRIPTION   NVARCHAR2(255),
  REMARK        NVARCHAR2(255),
  SKU_NUM       VARCHAR2(50),
  ONSALE_STATUS NUMBER(2) default 2,
  ONSALE_TIME   TIMESTAMP(6),
  WEIGHT        VARCHAR2(50),
  WEIGHT_UNIT   VARCHAR2(50)
)
;
comment on column TB_MALL_GOOD_INFO.SKU_NUM
  is 'SKU编码';
comment on column TB_MALL_GOOD_INFO.ONSALE_STATUS
  is '上架状态  1：上架  2：未上架  3：下架 ';
alter table TB_MALL_GOOD_INFO
  add primary key (GOODID);

prompt Creating TB_NOTE_DIARY...
create table TB_NOTE_DIARY
(
  ID         VARCHAR2(50) not null,
  TITLE      NVARCHAR2(1024),
  UPDATETIME TIMESTAMP(6),
  CREATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(50),
  CONTENT    NVARCHAR2(2000),
  MOBILE     VARCHAR2(50)
)
;
alter table TB_NOTE_DIARY
  add primary key (ID);

prompt Creating TB_NOTE_GAINS...
create table TB_NOTE_GAINS
(
  ID         VARCHAR2(50) not null,
  LVL        VARCHAR2(10),
  LVLNAME    NVARCHAR2(255),
  TITLE      NVARCHAR2(512),
  CONTENT    NVARCHAR2(2000),
  LABELS     NVARCHAR2(255),
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(155),
  UPDATER    VARCHAR2(155),
  MOBILE     VARCHAR2(50)
)
;
alter table TB_NOTE_GAINS
  add primary key (ID);

prompt Creating TB_NOTE_QUESTION...
create table TB_NOTE_QUESTION
(
  ID         VARCHAR2(50) not null,
  LVL        VARCHAR2(10),
  LVLNAME    NVARCHAR2(255),
  QUESTION   NVARCHAR2(512),
  SOLUTION   NVARCHAR2(2000),
  LABELS     NVARCHAR2(255),
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(155),
  UPDATER    VARCHAR2(155),
  MOBILE     VARCHAR2(50)
)
;
alter table TB_NOTE_QUESTION
  add primary key (ID);

prompt Creating TB_NOTE_TRANSACTION...
create table TB_NOTE_TRANSACTION
(
  ID          VARCHAR2(50) not null,
  TRANTYPE    NUMBER(1),
  TRANDATE    TIMESTAMP(6),
  ISREPEAT    NUMBER(1),
  TRANCONTENT NVARCHAR2(250),
  AHEADDAYS   NUMBER(2),
  TRANTIME    VARCHAR2(20),
  ISAHEAD     NUMBER(1),
  CREATETIME  TIMESTAMP(6),
  UPDATETIME  TIMESTAMP(6),
  CREATOR     VARCHAR2(150)
)
;
alter table TB_NOTE_TRANSACTION
  add primary key (ID);

prompt Creating TB_ORG_INFO...
create table TB_ORG_INFO
(
  ORGID      VARCHAR2(50) not null,
  CREATOR    VARCHAR2(50),
  ORGNAME    VARCHAR2(256),
  CREATETIME DATE,
  UPDATETIME DATE,
  USEFLAG    NUMBER(1) default 1,
  PARENTID   VARCHAR2(50) default 0,
  LVL        NUMBER(1) default 1,
  COMPANYID  VARCHAR2(50),
  ORGTYPE    NUMBER(1) default 0,
  ISMAIN     NUMBER(1) default 0,
  CHILDNUM   NUMBER(4) default 0
)
;
comment on column TB_ORG_INFO.USEFLAG
  is '0:禁用 1：启用';
comment on column TB_ORG_INFO.LVL
  is '最高管理员';
comment on column TB_ORG_INFO.ORGTYPE
  is '0:普通组织  1：公司';
comment on column TB_ORG_INFO.ISMAIN
  is '0:非主 1：主公司';
comment on column TB_ORG_INFO.CHILDNUM
  is '子节点数';
alter table TB_ORG_INFO
  add primary key (ORGID);

prompt Creating TB_SYS_CONF...
create table TB_SYS_CONF
(
  CKEY       VARCHAR2(50) not null,
  CVALUE     VARCHAR2(2000),
  CKEYNAME   VARCHAR2(100),
  COMPANYID  VARCHAR2(50),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
;
comment on column TB_SYS_CONF.CKEY
  is '主键';
comment on column TB_SYS_CONF.CVALUE
  is '主键值';
comment on column TB_SYS_CONF.CKEYNAME
  is '主键名称';
comment on column TB_SYS_CONF.COMPANYID
  is '主键类型';
comment on column TB_SYS_CONF.CREATETIME
  is '创建时间';
comment on column TB_SYS_CONF.UPDATETIME
  is '更新时间';
comment on column TB_SYS_CONF.CREATOR
  is '创建者';
alter table TB_SYS_CONF
  add primary key (CKEY);

prompt Creating TB_SYS_DATADIR_INFO...
create table TB_SYS_DATADIR_INFO
(
  CKEY       VARCHAR2(50) not null,
  PARENTKEY  VARCHAR2(50) not null,
  CVALUE     VARCHAR2(200),
  COMPANYID  VARCHAR2(200),
  SORT       NUMBER(4),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
;
comment on column TB_SYS_DATADIR_INFO.CKEY
  is '主键';
comment on column TB_SYS_DATADIR_INFO.PARENTKEY
  is '父主键';
comment on column TB_SYS_DATADIR_INFO.CVALUE
  is '主键值';
comment on column TB_SYS_DATADIR_INFO.COMPANYID
  is '类型名称';
comment on column TB_SYS_DATADIR_INFO.SORT
  is '排序';
comment on column TB_SYS_DATADIR_INFO.CREATETIME
  is '创建时间';
comment on column TB_SYS_DATADIR_INFO.UPDATETIME
  is '更新时间';
comment on column TB_SYS_DATADIR_INFO.CREATOR
  is '创建者';
alter table TB_SYS_DATADIR_INFO
  add primary key (CKEY, PARENTKEY);

prompt Creating TB_SYS_FUNC...
create table TB_SYS_FUNC
(
  FUNCID     VARCHAR2(50) not null,
  MENUID     VARCHAR2(50) not null,
  OPERID     VARCHAR2(50) not null,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  URL        VARCHAR2(255)
)
;
alter table TB_SYS_FUNC
  add primary key (FUNCID);
create index IDX_TB_SYS_FUNC_URL on TB_SYS_FUNC (URL);

prompt Creating TB_SYS_LOG...
create table TB_SYS_LOG
(
  ID         VARCHAR2(50) not null,
  USERID     VARCHAR2(50),
  USERNAME   VARCHAR2(50),
  CREATETIME DATE,
  IP         VARCHAR2(50),
  MENUNAME   VARCHAR2(255),
  OPERNAME   VARCHAR2(255),
  RETAIN1    VARCHAR2(255),
  RETAIN2    VARCHAR2(1024),
  RETAIN3    VARCHAR2(255),
  SOURCE     NUMBER(2) default 0
)
;
comment on column TB_SYS_LOG.RETAIN3
  is '公司ID';
comment on column TB_SYS_LOG.SOURCE
  is '来源0:内管，1消息中心 2：前端';
alter table TB_SYS_LOG
  add primary key (ID);

prompt Creating TB_SYS_LOG_PARAM...
create table TB_SYS_LOG_PARAM
(
  URL        VARCHAR2(250) not null,
  SOURCE     NUMBER(2) default 0 not null,
  MENUNAME   VARCHAR2(255),
  OPERNAME   VARCHAR2(255),
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(100),
  ID         VARCHAR2(50)
)
;
alter table TB_SYS_LOG_PARAM
  add primary key (URL, SOURCE);

prompt Creating TB_SYS_MENU...
create table TB_SYS_MENU
(
  MENUID     VARCHAR2(50) not null,
  PARENTID   VARCHAR2(50),
  MENUITEM   VARCHAR2(200),
  URL        VARCHAR2(200),
  SORT       NUMBER(4),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
;
alter table TB_SYS_MENU
  add primary key (MENUID);

prompt Creating TB_SYS_OPERATE...
create table TB_SYS_OPERATE
(
  OPERNAME   VARCHAR2(50) not null,
  OPERID     VARCHAR2(50) not null,
  PICICON    VARCHAR2(50),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  SORT       NUMBER
)
;
alter table TB_SYS_OPERATE
  add primary key (OPERID);

prompt Creating TB_SYS_ROLE...
create table TB_SYS_ROLE
(
  ROLEID     VARCHAR2(50) not null,
  ROLENAME   VARCHAR2(50),
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(50),
  USERTYPE   VARCHAR2(50),
  COMPANYID  VARCHAR2(50),
  LVL        NUMBER(4) default 0,
  SHOWFLAG   NUMBER(1) default 1
)
;
alter table TB_SYS_ROLE
  add primary key (ROLEID);

prompt Creating TB_SYS_ROLE_FUNC...
create table TB_SYS_ROLE_FUNC
(
  ROLEID     VARCHAR2(50) not null,
  FUNCID     VARCHAR2(50) not null,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
;
alter table TB_SYS_ROLE_FUNC
  add primary key (ROLEID, FUNCID);

prompt Creating TB_SYS_USER...
create table TB_SYS_USER
(
  USERID      VARCHAR2(50) not null,
  USERNAME    VARCHAR2(50) not null,
  PASSWORD    VARCHAR2(250) not null,
  BIND_MOBILE VARCHAR2(16),
  ACTIVEFLAG  NUMBER(1) default 0 not null,
  CREATETIME  TIMESTAMP(6),
  UPDATETIME  TIMESTAMP(6),
  CREATOR     VARCHAR2(50),
  COMPANYID   VARCHAR2(50),
  TOKEN       VARCHAR2(512),
  OPENID      VARCHAR2(64),
  ROLEID      VARCHAR2(50),
  SKIN        NUMBER(2) default 0,
  BINDFLAG    NUMBER(1) default 1
)
;
alter table TB_SYS_USER
  add primary key (USERID);

prompt Creating TB_SYS_USER_ORG...
create table TB_SYS_USER_ORG
(
  USERID     VARCHAR2(50) not null,
  ORGID      VARCHAR2(50) not null,
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(150)
)
;
alter table TB_SYS_USER_ORG
  add primary key (USERID, ORGID);

prompt Creating TB_VIP_INFO...
create table TB_VIP_INFO
(
  USERID     VARCHAR2(50) not null,
  REALNAME   VARCHAR2(50),
  GENDER     VARCHAR2(1),
  BIRTHDATE  VARCHAR2(20),
  EMAIL      VARCHAR2(20),
  SIGNATURE  NVARCHAR2(100),
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6)
)
;
alter table TB_VIP_INFO
  add primary key (USERID);

prompt Creating TB_WX_ACCESS_TOKEN...
create table TB_WX_ACCESS_TOKEN
(
  ACCOUNTID   VARCHAR2(100) not null,
  ACCESSTOKEN VARCHAR2(255) not null,
  PUTTIME     VARCHAR2(20) default 0,
  EXPIRES_IN  VARCHAR2(20) default 0,
  UPDATETIME  DATE
)
;
alter table TB_WX_ACCESS_TOKEN
  add primary key (ACCOUNTID);

prompt Creating TB_WX_ACCOUNT...
create table TB_WX_ACCOUNT
(
  ACCOUNTID      VARCHAR2(50) not null,
  ACCOUNTNAME    VARCHAR2(100),
  APPID          VARCHAR2(50),
  APPSECRET      VARCHAR2(100),
  AUTHDOMAIN     VARCHAR2(300),
  URL            VARCHAR2(400),
  TOKEN          VARCHAR2(32),
  AESKEY         VARCHAR2(50),
  CREATOR        VARCHAR2(50),
  CREATETIME     DATE,
  SERVER_CONTEXT VARCHAR2(50),
  WX_ACCTNO      VARCHAR2(100),
  IS_SERVICE     NUMBER(1) default 0,
  ACCTTYPE       NUMBER(1) default 0,
  UPDATETIME     DATE,
  ORGID          VARCHAR2(50),
  COMPANYID      VARCHAR2(50)
)
;
comment on column TB_WX_ACCOUNT.ACCOUNTID
  is '账号';
comment on column TB_WX_ACCOUNT.ACCOUNTNAME
  is '名称';
comment on column TB_WX_ACCOUNT.AUTHDOMAIN
  is '域名';
comment on column TB_WX_ACCOUNT.URL
  is '回调路径';
comment on column TB_WX_ACCOUNT.CREATOR
  is '创建者';
comment on column TB_WX_ACCOUNT.CREATETIME
  is '创建时间';
comment on column TB_WX_ACCOUNT.SERVER_CONTEXT
  is '访问上下文';
comment on column TB_WX_ACCOUNT.WX_ACCTNO
  is '微信号';
comment on column TB_WX_ACCOUNT.IS_SERVICE
  is '1:提供服务，0：不提供服务';
comment on column TB_WX_ACCOUNT.ACCTTYPE
  is '0:服务号 1：企业号 2:订阅号';
comment on column TB_WX_ACCOUNT.ORGID
  is '组织ID';
create index TB_WX_ACCOUNT_NAMEIDX on TB_WX_ACCOUNT (ACCOUNTNAME);

prompt Creating TB_WX_AUTO_REPLAY...
create table TB_WX_AUTO_REPLAY
(
  CKEY       VARCHAR2(200),
  CREPLAY    VARCHAR2(2000),
  CTYPE      VARCHAR2(50) not null,
  CTYPENAME  VARCHAR2(100),
  ACCOUNTID  VARCHAR2(50),
  REPLAYTYPE VARCHAR2(20),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  DELFLAG    NUMBER(1) default 1
)
;
alter table TB_WX_AUTO_REPLAY
  add primary key (CTYPE);

prompt Creating TB_WX_AUTO_REPLAY_NEWSITEM...
create table TB_WX_AUTO_REPLAY_NEWSITEM
(
  ID          VARCHAR2(50) not null,
  TITLE       VARCHAR2(100),
  DESCRIPTION VARCHAR2(300),
  PICURL      VARCHAR2(200),
  URL         VARCHAR2(1000),
  SORT        NUMBER(10),
  ACCOUNTID   VARCHAR2(50),
  CREATETIME  TIMESTAMP(6),
  UPDATETIME  TIMESTAMP(6),
  CREATOR     VARCHAR2(50)
)
;
alter table TB_WX_AUTO_REPLAY_NEWSITEM
  add primary key (ID);

prompt Creating TB_WX_CHAT_MSG...
create table TB_WX_CHAT_MSG
(
  ID           VARCHAR2(50) not null,
  TOUSERNAME   VARCHAR2(50),
  FROMUSERNAME VARCHAR2(50),
  MSGID        VARCHAR2(100),
  MSGTYPE      VARCHAR2(50),
  PICURL       VARCHAR2(200),
  MEDIAID      VARCHAR2(50),
  CONTENT      VARCHAR2(2000),
  ACCOUNTID    VARCHAR2(50),
  CREATETIME   DATE,
  FORMAT       VARCHAR2(100),
  RECOGNITION  VARCHAR2(255),
  LOCATION_X   VARCHAR2(50),
  LOCATION_Y   VARCHAR2(50),
  SCALE        VARCHAR2(20),
  THUMBMEDIAID VARCHAR2(50),
  TITLE        VARCHAR2(255),
  DESCRIPTION  VARCHAR2(255),
  URL          VARCHAR2(255),
  EVENT        VARCHAR2(255),
  EVENTKEY     VARCHAR2(255),
  TICKET       VARCHAR2(255),
  LABEL        VARCHAR2(255),
  ISREQUEST    CHAR(1)
)
;
alter table TB_WX_CHAT_MSG
  add primary key (ID);
create index IDX_WX_CHAT_MSG_ACCOUNTID on TB_WX_CHAT_MSG (ACCOUNTID);
create index IDX_WX_CHAT_MSG_FROMUSER on TB_WX_CHAT_MSG (FROMUSERNAME);
create index IDX_WX_CHAT_MSG_TOUSER on TB_WX_CHAT_MSG (TOUSERNAME);

prompt Creating TB_WX_CHAT_NEWS_MSG...
create table TB_WX_CHAT_NEWS_MSG
(
  ID          VARCHAR2(50) not null,
  CHAT_ID     VARCHAR2(50) not null,
  TITLE       VARCHAR2(100),
  DESCRIPTION VARCHAR2(255),
  PICURL      VARCHAR2(100),
  URL         VARCHAR2(200)
)
;
alter table TB_WX_CHAT_NEWS_MSG
  add primary key (ID);
create index IDX_WX_CHAT_NEWS_MSG_CHATID on TB_WX_CHAT_NEWS_MSG (CHAT_ID);

prompt Creating TB_WX_MENU...
create table TB_WX_MENU
(
  ID        VARCHAR2(32) not null,
  PARENT_ID VARCHAR2(32),
  NAME      VARCHAR2(100),
  TYPE      VARCHAR2(32),
  CONTENT   VARCHAR2(1000),
  SORT      NUMBER(2) default 0,
  ACCOUNTID VARCHAR2(50),
  LVL       NUMBER(1) default 1
)
;
alter table TB_WX_MENU
  add primary key (ID);

prompt Creating TB_WX_MENU_URL...
create table TB_WX_MENU_URL
(
  ID        VARCHAR2(50) not null,
  MENUNAME  VARCHAR2(100),
  MENUURL   VARCHAR2(1000),
  ACCOUNTID VARCHAR2(50)
)
;
alter table TB_WX_MENU_URL
  add primary key (ID);

prompt Creating TB_WX_MODULE_MSG...
create table TB_WX_MODULE_MSG
(
  ID          VARCHAR2(64) not null,
  ACCOUNTID   VARCHAR2(64),
  TEMPLATE_ID VARCHAR2(64),
  TOUSER      VARCHAR2(64),
  URL         VARCHAR2(1024),
  DATA        VARCHAR2(2048),
  NEEDFLAG    NUMBER(1) default 1,
  SENDFLAG    NUMBER(1) default 0,
  SENDTIMES   NUMBER(1) default 0,
  CREATETIME  DATE,
  SENDTIME    DATE,
  MSGID       VARCHAR2(64),
  PUSH_CODE   VARCHAR2(64),
  PUSH_MSG    VARCHAR2(1024),
  RESULTCODE  VARCHAR2(64),
  RESULTMSG   VARCHAR2(1024),
  NOTE        VARCHAR2(528)
)
;
alter table TB_WX_MODULE_MSG
  add primary key (ID);

prompt Creating TB_WX_QRCODE...
create table TB_WX_QRCODE
(
  ID         VARCHAR2(50) not null,
  QRNO       VARCHAR2(50),
  QRNAME     VARCHAR2(200),
  QRTYPE     VARCHAR2(50),
  QRURL      VARCHAR2(1024),
  ACCOUNTID  VARCHAR2(200),
  QRPATH     VARCHAR2(1024),
  SCENETYPE  NUMBER(1) default 1,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  COMPANYID  VARCHAR2(50)
)
;
alter table TB_WX_QRCODE
  add primary key (ID);

prompt Creating TB_WX_TEMPLATE...
create table TB_WX_TEMPLATE
(
  YWTYPE         VARCHAR2(36) not null,
  ACCOUNTID      VARCHAR2(36) not null,
  TEMPLATE_ID    VARCHAR2(50),
  TEMPLATE_NAME  VARCHAR2(50),
  FIRST_CONTENT  VARCHAR2(50),
  REMARK_CONTENT VARCHAR2(1024),
  DETAILURL      VARCHAR2(1024),
  STATUS         NUMBER(1) default 0,
  CREATETIME     DATE,
  UPDATETIME     DATE,
  CREATOR        VARCHAR2(50)
)
;
comment on column TB_WX_TEMPLATE.STATUS
  is '0：启用 1：失效';
alter table TB_WX_TEMPLATE
  add primary key (YWTYPE, ACCOUNTID);

prompt Creating TB_WX_USER...
create table TB_WX_USER
(
  OPENID        VARCHAR2(50) not null,
  NICKNAME      VARCHAR2(256),
  GROUPID       NUMBER default 0 not null,
  COUNTRY       VARCHAR2(256),
  PROVINCE      VARCHAR2(256),
  CITY          VARCHAR2(256),
  SEX           NUMBER,
  IMAGEURL      VARCHAR2(1024),
  LANGUAGE      VARCHAR2(32),
  ISSUBSCRIBE   NUMBER default 1 not null,
  SUBSCRIBETIME TIMESTAMP(6),
  UPDATETIME    TIMESTAMP(6),
  ACCOUNTID     VARCHAR2(50) not null,
  CREATETIME    TIMESTAMP(6),
  USEFLAG       NUMBER default 0,
  QRNO          VARCHAR2(50),
  REMARK        VARCHAR2(250),
  DAIRYFLAG     NUMBER(1) default 0
)
;
comment on column TB_WX_USER.USEFLAG
  is '黑名单标识 0：正常 1：黑户';
comment on column TB_WX_USER.DAIRYFLAG
  is '日记提醒标识 1：推送 0：不推送';
alter table TB_WX_USER
  add primary key (OPENID, ACCOUNTID);
create index IDX_WX_USER_ISSUBSCRIBE on TB_WX_USER (ISSUBSCRIBE);
create index IDX_WX_USER_NICKNAME on TB_WX_USER (NICKNAME);
create index IDX_WX_USER_SUBSCRIBETIME on TB_WX_USER (SUBSCRIBETIME);

prompt Creating TESTCODE...
create table TESTCODE
(
  ID   VARCHAR2(50) not null,
  NAME VARCHAR2(50)
)
;
alter table TESTCODE
  add primary key (ID);

prompt Loading TB_AUTOCODE_ATTR...
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('test', 'String', 1, null, 50, 'test', 'test_user', null, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('testname', 'String', 0, null, 50, 'testname', 'test_user', null, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'testcode', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('goodName', 'String', 0, null, 1024, '商品名称', 'tb_mall_good_info', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('goodPrice', 'Integer', 0, null, 12, '商品单价', 'tb_mall_good_info', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('unit', 'String', 0, null, 50, '商品单位', 'tb_mall_good_info', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('imageUrl', 'String', 0, null, 1024, '商品主图', 'tb_mall_good_info', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 7, '创建时间', 'tb_mall_good_info', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 7, '更新时间', 'tb_mall_good_info', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('name', 'String', 0, null, 50, 'Name', 'testcode', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('goodId', 'String', 1, null, 50, '商品ID', 'tb_mall_good_info', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'tb_mall_good_info', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_NOTE_GAINS', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvl', 'String', 0, null, 50, '级别', 'TB_NOTE_GAINS', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvlName', 'String', 0, null, 50, '级别名称', 'TB_NOTE_GAINS', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('title', 'String', 0, null, 50, '标题', 'TB_NOTE_GAINS', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('content', 'String', 0, null, 50, '内容', 'TB_NOTE_GAINS', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('labels', 'String', 0, null, 50, '标签', 'TB_NOTE_GAINS', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_NOTE_GAINS', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_NOTE_GAINS', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_NOTE_GAINS', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updater', 'String', 0, null, 50, '更新者', 'TB_NOTE_GAINS', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('asdf', null, 0, null, null, null, 'test', null, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('roleid', 'String', 1, null, 50, '角色ID', 'TB_SYS_ROLE', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_SYS_ROLE', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_SYS_ROLE', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('rolename', 'String', 0, null, 50, '角色名称', 'TB_SYS_ROLE', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_SYS_ROLE', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userType', 'String', 0, null, 50, '用户类型', 'TB_SYS_ROLE', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('companyId', 'String', 0, null, 50, '公司ID', 'TB_SYS_ROLE', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvl', 'Integer', 0, null, 50, '级别', 'TB_SYS_ROLE', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('showFlag', 'String', 0, null, 50, '是否单独维护', 'TB_SYS_ROLE', 8, '0：否 1：是');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userid', 'String', 1, null, 50, '用户ID', 'TB_SYS_USER', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('username', 'String', 0, null, 150, '用户名称', 'TB_SYS_USER', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('password', 'String', 0, null, 50, '用户密码', 'TB_SYS_USER', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('bind_mobile', 'String', 0, null, 50, '绑定手机号码', 'TB_SYS_USER', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('activeFlag', 'Integer', 0, null, 1, '激活标识', 'TB_SYS_USER', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 7, '创建时间', 'TB_SYS_USER', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 7, '更新时间', 'TB_SYS_USER', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_SYS_USER', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('orgid', 'String', 0, null, 50, '组织ID', 'TB_SYS_USER', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('companyId', 'String', 0, null, 50, '公司ID', 'TB_SYS_USER', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('token', 'String', 0, null, 512, '口令', 'TB_SYS_USER', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('openid', 'String', 0, null, 50, 'openid', 'TB_SYS_USER', 11, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userType', 'String', 0, null, 50, '用户类型', 'TB_SYS_USER', 12, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('menuName', 'String', 0, null, 50, '菜单名称', 'TB_WX_MENU_URL', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('menuUrl', 'String', 0, null, 50, '菜单URL', 'TB_WX_MENU_URL', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_MENU_URL', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_WX_MENU', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('parent_id', 'String', 0, null, 50, '父ID', 'TB_WX_MENU', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('name', 'String', 0, null, 50, '菜单名称', 'TB_WX_MENU', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('type', 'String', 0, null, 50, '菜单类型', 'TB_WX_MENU', 3, 'view：链接 click：点击：1：一级菜单');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('content', 'String', 0, null, 50, '访问内容', 'TB_WX_MENU', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sort', 'Integer', 0, null, 50, '排序', 'TB_WX_MENU', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众ID', 'TB_WX_MENU', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_WX_AUTO_REPLAY_NEWSITEM', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('title', 'String', 0, null, 50, '标题', 'TB_WX_AUTO_REPLAY_NEWSITEM', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('description', 'String', 0, null, 50, '描述', 'TB_WX_AUTO_REPLAY_NEWSITEM', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('picUrl', 'String', 0, null, 50, '图片路径', 'TB_WX_AUTO_REPLAY_NEWSITEM', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('url', 'String', 0, null, 50, '链接', 'TB_WX_AUTO_REPLAY_NEWSITEM', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sort', 'Integer', 0, null, 50, '排序', 'TB_WX_AUTO_REPLAY_NEWSITEM', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '服务号ID', 'TB_WX_AUTO_REPLAY_NEWSITEM', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_AUTO_REPLAY_NEWSITEM', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_AUTO_REPLAY_NEWSITEM', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_WX_AUTO_REPLAY_NEWSITEM', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('cparentType', 'String', 1, null, 50, '父ID', 'TB_WX_AUTO_REPLAY', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ckey', 'String', 0, null, 50, '关键字', 'TB_WX_AUTO_REPLAY', 1, '关键字英文全部小写');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creplay', 'String', 0, null, 50, '回复内容', 'TB_WX_AUTO_REPLAY', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ctype', 'String', 0, null, 50, 'ID', 'TB_WX_AUTO_REPLAY', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ctypeName', 'String', 0, null, 50, '名称', 'TB_WX_AUTO_REPLAY', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_AUTO_REPLAY', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('replayType', 'String', 0, null, 50, '回复方式', 'TB_WX_AUTO_REPLAY', 6, 'NEWS：图文 MODULE：指令 TEXT：文本');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_AUTO_REPLAY', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_AUTO_REPLAY', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_WX_AUTO_REPLAY', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_WX_MENU_URL', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvl', 'String', 0, null, 50, 'LVL', 'TB_WX_MENU', 7, '0：公众号 1：一级菜单 2：二级菜单');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('cvalue', 'String', 0, null, 50, '主键值', 'TB_SYS_CONF', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ckeyName', 'String', 0, null, 50, '主键描述', 'TB_SYS_CONF', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ctype', 'String', 0, null, 50, '公司ID', 'TB_SYS_CONF', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ctypename', 'String', 0, null, 50, '公司名称', 'TB_SYS_CONF', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_SYS_CONF', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_SYS_CONF', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_SYS_CONF', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_SYS_LOG', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userid', 'String', 0, null, 50, '用户ID', 'TB_SYS_LOG', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('username', 'String', 0, null, 50, '用户姓名', 'TB_SYS_LOG', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_SYS_LOG', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ip', 'String', 0, null, 50, 'IP', 'TB_SYS_LOG', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('menuname', 'String', 0, null, 50, '菜单名称', 'TB_SYS_LOG', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('opername', 'String', 0, null, 50, '操作名称', 'TB_SYS_LOG', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('retain2', 'String', 0, null, 50, '访问URL', 'TB_SYS_LOG', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('source', 'String', 0, null, 50, '来源', 'TB_SYS_LOG', 8, '0:内管，1消息中心 2：前端');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('retain3', 'String', 0, null, 50, '公司ID', 'TB_SYS_LOG', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('retain1', 'String', 0, null, 50, '访问结果', 'TB_SYS_LOG', 10, '暂无用');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ckey', 'String', 1, null, 50, '主键', 'TB_SYS_DATADIR_INFO', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('parentkey', 'String', 0, null, 50, '父主键', 'TB_SYS_DATADIR_INFO', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('cvalue', 'String', 0, null, 50, '主键值', 'TB_SYS_DATADIR_INFO', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('typename', 'String', 0, null, 50, '公司ID', 'TB_SYS_DATADIR_INFO', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sort', 'Integer', 0, null, 50, '排序', 'TB_SYS_DATADIR_INFO', 4, null);
commit;
prompt 100 records committed...
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'String', 0, null, 50, '创建时间', 'TB_SYS_DATADIR_INFO', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'String', 0, null, 50, '更新时间', 'TB_SYS_DATADIR_INFO', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_SYS_DATADIR_INFO', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ckey', 'String', 1, null, 50, '主键', 'TB_SYS_CONF', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ID', 'String', 1, null, 50, 'ID', 'tb_mall_advise', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('content', 'String', 0, null, 1024, '商品描述', 'tb_mall_advise', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('label', 'String', 0, null, 512, '标签', 'tb_mall_advise', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('num', 'Integer', 0, null, 5, '定制数量', 'tb_mall_advise', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 7, '创建时间', 'tb_mall_advise', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 7, '更新时间', 'tb_mall_advise', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userid', 'String', 0, null, 50, '用户ID', 'tb_mall_advise', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('mobile', 'String', 0, null, 50, '手机号码', 'tb_mall_advise', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('orgid', 'String', 1, null, 50, '机构ID', 'tb_org_info', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'tb_org_info', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('orgname', 'String', 0, null, 256, '机构名称', 'tb_org_info', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 7, '创建时间', 'tb_org_info', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 7, '更新时间', 'tb_org_info', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('useflag', 'Integer', 0, null, 1, '启用标识', 'tb_org_info', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvl', 'Integer', 0, null, 50, '级别', 'tb_org_info', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('companyId', 'String', 0, null, 50, '公司ID', 'tb_org_info', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_NOTE_QUESTION', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvl', 'Integer', 0, null, 50, '级别', 'TB_NOTE_QUESTION', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('lvlName', 'String', 0, null, 50, '级别名称', 'TB_NOTE_QUESTION', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('question', 'String', 0, null, 50, '问题', 'TB_NOTE_QUESTION', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('solution', 'String', 0, null, 50, '解决方案', 'TB_NOTE_QUESTION', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('labels', 'String', 0, null, 50, '标签', 'TB_NOTE_QUESTION', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createDate', 'String', 0, null, 50, '创建日期', 'TB_NOTE_QUESTION', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_NOTE_QUESTION', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_NOTE_QUESTION', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_NOTE_QUESTION', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updater', 'String', 0, null, 50, '更新者', 'TB_NOTE_QUESTION', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('userid', 'String', 1, null, 50, 'USERID', 'tb_vip_info', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('realname', 'String', 0, null, 50, '真实姓名', 'tb_vip_info', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('gender', 'String', 0, null, 50, '性别', 'tb_vip_info', 2, '1：女 2：男');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('birthdate', 'String', 0, null, 50, '生日', 'tb_vip_info', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('email', 'String', 0, null, 50, '邮箱', 'tb_vip_info', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('signature', 'String', 0, null, 50, '签名', 'tb_vip_info', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'tb_vip_info', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'tb_vip_info', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_NOTE_Transaction', 0, '主键');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('tranType', 'Integer', 0, null, 1, '事务类型', 'TB_NOTE_Transaction', 1, '0：普通 1：特殊日子');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('tranDate', 'Date', 0, null, 50, '特殊日期', 'TB_NOTE_Transaction', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('isRepeat', 'Integer', 0, null, 1, '是否重复', 'TB_NOTE_Transaction', 3, '0：不重复 1：重复，默认不重复');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('tranContent', 'String', 0, null, 250, '提醒内容', 'TB_NOTE_Transaction', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('aheadDays', 'Integer', 0, null, 2, '提前天数', 'TB_NOTE_Transaction', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('tranTime', 'String', 0, null, 20, '提醒时间', 'TB_NOTE_Transaction', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('isAhead', 'Integer', 0, null, 1, '是否提前提醒', 'TB_NOTE_Transaction', 7, '0：不提前 1：提前');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_NOTE_Transaction', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_NOTE_Transaction', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 150, '创建者', 'TB_NOTE_Transaction', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrName', 'String', 0, null, 50, '名称', 'TB_WX_QRCODE', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrType', 'String', 0, null, 50, '类型', 'TB_WX_QRCODE', 2, '0：链接 1：公众号');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrUrl', 'String', 0, null, 50, '链接', 'TB_WX_QRCODE', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_QRCODE', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrPath', 'String', 0, null, 50, '图片路径', 'TB_WX_QRCODE', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sceneType', 'String', 0, null, 50, '场景类型', 'TB_WX_QRCODE', 6, '0：临时 1：永久');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_QRCODE', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_QRCODE', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_WX_QRCODE', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'TB_WX_MODULE_MSG', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_MODULE_MSG', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('template_id', 'String', 0, null, 50, '模板ID', 'TB_WX_MODULE_MSG', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('touser', 'String', 0, null, 50, '接受者', 'TB_WX_MODULE_MSG', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('url', 'String', 0, null, 50, '访问URL', 'TB_WX_MODULE_MSG', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('data', 'String', 0, null, 50, '内容', 'TB_WX_MODULE_MSG', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('needFlag', 'Integer', 0, null, 50, '需要发送标识', 'TB_WX_MODULE_MSG', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sendFlag', 'Integer', 0, null, 50, '发送标识', 'TB_WX_MODULE_MSG', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sendTimes', 'Integer', 0, null, 50, '发送次数', 'TB_WX_MODULE_MSG', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_MODULE_MSG', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sendtime', 'Date', 0, null, 50, '发送时间', 'TB_WX_MODULE_MSG', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('msgId', 'String', 0, null, 50, '消息ID', 'TB_WX_MODULE_MSG', 11, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('push_code', 'String', 0, null, 50, '推送返回码', 'TB_WX_MODULE_MSG', 12, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('push_msg', 'String', 0, null, 50, '推送返回信息', 'TB_WX_MODULE_MSG', 13, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('resultCode', 'String', 0, null, 50, '推送结果码', 'TB_WX_MODULE_MSG', 14, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('resultMsg', 'String', 0, null, 50, '推送结果消息', 'TB_WX_MODULE_MSG', 15, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('note', 'String', 0, null, 50, '备注', 'TB_WX_MODULE_MSG', 16, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, 'ID', 'tb_testcode', 0, '234234');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('name', 'String', 0, null, 50, 'Name', 'tb_testcode', 1, '2342345');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'tb_testcode', 2, '创建时间');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('id', 'String', 1, null, 50, '主键', 'TB_SYS_LOG_PARAM', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('source', 'Integer', 0, null, 50, '来源', 'TB_SYS_LOG_PARAM', 1, '0：内管日志 1：接口日志 2：前端日志');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('menuName', 'String', 0, null, 50, '功能名称', 'TB_SYS_LOG_PARAM', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('operName', 'String', 0, null, 50, '操作名称', 'TB_SYS_LOG_PARAM', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'tb_diary', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('content', 'String', 0, null, 4028, '正文', 'tb_diary', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'tb_diary', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_SYS_LOG_PARAM', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_SYS_LOG_PARAM', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_SYS_LOG_PARAM', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('url', 'String', 0, null, 50, '访问链接', 'TB_SYS_LOG_PARAM', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ID', 'String', 1, null, 50, '主键', 'tb_diary', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('time', 'Date', 0, null, 7, '日记时间', 'tb_diary', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('title', 'String', 0, null, 1024, '标题', 'tb_diary', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'tb_diary', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountId', 'String', 1, null, 50, '公众号ID', 'TB_WX_ACCOUNT', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('authdoman', 'String', 0, null, 256, '授权域名', 'TB_WX_ACCOUNT', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('appsecret', 'String', 0, null, 50, 'APPSECRET', 'TB_WX_ACCOUNT', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('appid', 'String', 0, null, 50, 'APPID', 'TB_WX_ACCOUNT', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('orgid', 'String', 0, null, 50, '机构ID', 'TB_WX_ACCOUNT', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountname', 'String', 0, null, 150, '公众号名称', 'TB_WX_ACCOUNT', 5, null);
commit;
prompt 200 records committed...
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_ACCOUNT', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accttype', 'Integer', 0, null, 1, '公众号类型', 'TB_WX_ACCOUNT', 7, '0：服务号 1：企业号 2：订阅号');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('is_service', 'Integer', 0, null, 1, '是否提供服务', 'TB_WX_ACCOUNT', 8, '0：不提供 1：提供');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('wx_acctno', 'String', 0, null, 50, '微信号', 'TB_WX_ACCOUNT', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('server_context', 'String', 0, null, 50, '上下文', 'TB_WX_ACCOUNT', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_ACCOUNT', 11, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_WX_ACCOUNT', 12, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('aeskey', 'String', 0, null, 50, '加密秘钥', 'TB_WX_ACCOUNT', 13, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('token', 'String', 0, null, 50, '令牌', 'TB_WX_ACCOUNT', 14, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('url', 'String', 0, null, 1024, '回调路径', 'TB_WX_ACCOUNT', 15, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('openid', 'String', 1, null, 50, 'OPENID', 'TB_WX_USER', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('nickname', 'String', 0, null, 50, '昵称', 'TB_WX_USER', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('groupid', 'Integer', 0, null, 50, '分组ID', 'TB_WX_USER', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('country', 'String', 0, null, 50, '国家', 'TB_WX_USER', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('province', 'String', 0, null, 50, '省', 'TB_WX_USER', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('city', 'String', 0, null, 50, '市', 'TB_WX_USER', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('sex', 'Integer', 0, null, 50, '性别', 'TB_WX_USER', 6, '1：男 2：女 0：未知');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('imageUrl', 'String', 0, null, 50, '头像路径', 'TB_WX_USER', 7, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('language', 'String', 0, null, 50, '语言', 'TB_WX_USER', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('issubscribe', 'Integer', 0, null, 50, '关注', 'TB_WX_USER', 9, '0：未关注 1：已关注');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('subscribetime', 'Date', 0, null, 50, '关注时间', 'TB_WX_USER', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_USER', 11, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_USER', 12, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_USER', 13, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('useflag', 'Integer', 0, null, 50, '启用标识', 'TB_WX_USER', 14, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrNo', 'String', 0, null, 50, '二维码标识', 'TB_WX_USER', 15, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('remark', 'String', 0, null, 50, '备注', 'TB_WX_USER', 16, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('ywType', 'String', 1, null, 50, '业务类型', 'TB_WX_TEMPLATE', 0, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('accountid', 'String', 0, null, 50, '公众号ID', 'TB_WX_TEMPLATE', 1, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('template_id', 'String', 0, null, 50, '微信模板ID', 'TB_WX_TEMPLATE', 2, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('template_name', 'String', 0, null, 50, '微信模板标题', 'TB_WX_TEMPLATE', 3, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('first_content', 'String', 0, null, 50, '首行内容', 'TB_WX_TEMPLATE', 4, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('remark_content', 'String', 0, null, 50, '尾行内容', 'TB_WX_TEMPLATE', 5, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('detailUrl', 'String', 0, null, 50, '访问URL', 'TB_WX_TEMPLATE', 6, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('status', 'Integer', 0, null, 50, '启用标识', 'TB_WX_TEMPLATE', 7, '0：禁用 1：启用');
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('createtime', 'Date', 0, null, 50, '创建时间', 'TB_WX_TEMPLATE', 8, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('updatetime', 'Date', 0, null, 50, '更新时间', 'TB_WX_TEMPLATE', 9, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('creator', 'String', 0, null, 50, '创建者', 'TB_WX_TEMPLATE', 10, null);
insert into TB_AUTOCODE_ATTR (ATTRNAME, ATTRTYPE, ISPK, SEQ, ATTRSIZE, ATTRDESC, TABLENAME, SORT, NOTE)
values ('qrNo', 'String', 1, null, 50, '标识', 'TB_WX_QRCODE', 0, null);
commit;
prompt 239 records loaded
prompt Loading TB_AUTOCODE_BEAN...
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_ROLE', 'SysRole', '用户类型', 0, null, 1, to_date('10-01-2017 22:19:34', 'dd-mm-yyyy hh24:mi:ss'), 'system', '用户类型', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('tb_diary', 'Diary', '我的日记', 0, null, 0, to_date('10-01-2017 19:40:03', 'dd-mm-yyyy hh24:mi:ss'), 'note', '日记功能', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('tb_org_info', 'OrgInfo', '机构管理', 1, null, 1, to_date('10-01-2017 22:04:48', 'dd-mm-yyyy hh24:mi:ss'), 'system', '组织架构,包括公司', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_ACCOUNT', 'WxAccount', '公众号管理', 0, null, 0, to_date('10-01-2017 19:44:49', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '微信公众号功能', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('testcode', 'TestCode', '测试代码', 1, to_date('18-02-2017 11:35:30', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('18-02-2017 11:35:30', 'dd-mm-yyyy hh24:mi:ss'), 'autocode', '测试', 1);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_USER', 'SysUser', '用户管理', 0, to_date('23-10-2016 11:54:33', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('10-01-2017 22:23:18', 'dd-mm-yyyy hh24:mi:ss'), 'system', '用户管理，关联角色和组织架构', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('tb_mall_good_info', 'GoodInfo', '商品管理', 1, to_date('26-10-2016 21:01:18', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('26-10-2016 21:13:05', 'dd-mm-yyyy hh24:mi:ss'), 'mall', null, 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('tb_mall_advise', 'Advise', '客户定制', 1, to_date('26-10-2016 21:10:24', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 22:37:50', 'dd-mm-yyyy hh24:mi:ss'), 'mall', '客户定制商品', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('tb_vip_info', 'VipInfo', '会员信息', 0, to_date('08-01-2017 19:54:03', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('09-01-2017 23:56:30', 'dd-mm-yyyy hh24:mi:ss'), 'note', '会员存档信息', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_USER', 'WxUser', '粉丝管理', 0, to_date('06-11-2016 19:10:56', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 19:48:51', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '公众号关注粉丝', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_MENU', 'WxMenu', '微信菜单管理', 0, to_date('06-11-2016 21:27:33', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:14:59', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '微信菜单', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_MENU_URL', 'WxMenuUrl', '微信菜单URL', 0, to_date('06-11-2016 21:31:26', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:11:04', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '菜单链接URL', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_QRCODE', 'Qrcode', '二维码管理', 0, to_date('25-11-2016 11:33:55', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 19:54:29', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '二维码管理，包括公众号二维码，链接二维码', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_LOG', 'SysLog', '系统日志', 0, to_date('27-11-2016 21:09:51', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:19:35', 'dd-mm-yyyy hh24:mi:ss'), 'system', '系统访问日志', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_NOTE_QUESTION', 'Question', '工作问题记录', 0, to_date('30-11-2016 21:05:43', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('30-11-2016 21:05:43', 'dd-mm-yyyy hh24:mi:ss'), 'note', null, 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_NOTE_GAINS', 'Gains', '心得记录', 0, to_date('01-12-2016 21:05:36', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('01-12-2016 21:12:54', 'dd-mm-yyyy hh24:mi:ss'), 'note', null, 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_AUTO_REPLAY', 'WxAutoReplay', '微信回复管理', 0, to_date('06-11-2016 21:37:48', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:09:32', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '微信公众号自动回复', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_AUTO_REPLAY_NEWSITEM', 'NewsItem', '回复图文管理', 0, to_date('06-11-2016 21:43:26', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:06:21', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '微信公众号自动回复图文消息管理', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_CONF', 'SysConf', '系统参数', 0, to_date('27-11-2016 17:47:24', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:27:28', 'dd-mm-yyyy hh24:mi:ss'), 'system', '系统参数设置，只可编辑', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_DATADIR_INFO', 'DataDir', '数据字典', 0, to_date('27-11-2016 17:50:38', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 20:25:25', 'dd-mm-yyyy hh24:mi:ss'), 'system', '数据字典', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_TEMPLATE', 'WxTemplate', '微信模板', 0, to_date('27-11-2016 21:52:01', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('10-01-2017 19:51:01', 'dd-mm-yyyy hh24:mi:ss'), 'wx', '微信模板配置', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_WX_MODULE_MSG', 'ModuleMsg', '模板消息', 0, to_date('28-11-2016 19:23:23', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('28-11-2016 19:23:23', 'dd-mm-yyyy hh24:mi:ss'), 'wx', null, 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_SYS_LOG_PARAM', 'SysLogParam', '日志参数', 0, to_date('07-01-2017 20:47:37', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('10-01-2017 19:37:01', 'dd-mm-yyyy hh24:mi:ss'), 'system', '系统访问日志', 0);
insert into TB_AUTOCODE_BEAN (TABLENAME, BEANNAME, MODULEDESC, IS_CREATETABLE, CREATETIME, IS_AUTH, UPDATETIME, PARENTPACKAGE, DESCRIPTION, ISAUTO)
values ('TB_NOTE_Transaction', 'Transaction', '事务提醒', 0, to_date('11-01-2017 21:38:55', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('11-01-2017 21:48:14', 'dd-mm-yyyy hh24:mi:ss'), 'note', '1，事务提醒 ，特殊日子可设置每年提醒，普通事务提醒，默认明天；<br/>2，提醒时间是9点提醒<br/>3，可设置提前提醒', 1);
commit;
prompt 24 records loaded
prompt Loading TB_MALL_ADVISE...
prompt Table is empty
prompt Loading TB_MALL_GOOD_IMG...
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('4248071FFDDF4C8CBAD44BF0E1E1B633', 'P20161207195921897', 1, 'ftp://127.0.0.1/images/20161207195602247.jpg', to_date('07-12-2016 23:06:30', 'dd-mm-yyyy hh24:mi:ss'), 1, 'image1');
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('6BD7F1066C4F4D2DB93FE538A9171179', 'P20161207195921897', 1, 'ftp://127.0.0.1/images/20161207195605491.png', to_date('07-12-2016 23:06:30', 'dd-mm-yyyy hh24:mi:ss'), 2, 'image2');
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('6021279F3C674CEE9D3474DAFE4A2024', 'P20161207195921897', 2, 'ftp://127.0.0.1/images/20161207195609527.jpg', to_date('07-12-2016 23:06:30', 'dd-mm-yyyy hh24:mi:ss'), 1, 'image1');
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('198EBB35CD5E433A8161A927F2395DAD', 'P20161207195921897', 2, 'ftp://127.0.0.1/images/20161207195613187.jpg', to_date('07-12-2016 23:06:30', 'dd-mm-yyyy hh24:mi:ss'), 2, 'image2');
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('0FCE40327E8746F0940063361FBEBBE2', 'P20161207230617377', 1, 'ftp://127.0.0.1/images/20161207230606717.jpg', to_date('07-12-2016 23:06:17', 'dd-mm-yyyy hh24:mi:ss'), 1, 'image1');
insert into TB_MALL_GOOD_IMG (ID, GOODID, IMGTYPE, IMGURL, CREATETIME, SORT, IMGNAME)
values ('01846B2DF8B14979BA0AC0573CB46B43', 'P20161207230617377', 2, 'ftp://127.0.0.1/images/20161207230609919.jpg', to_date('07-12-2016 23:06:17', 'dd-mm-yyyy hh24:mi:ss'), 1, 'image1');
commit;
prompt 6 records loaded
prompt Loading TB_MALL_GOOD_INFO...
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161026225856988', '测试', 24, '234', 'ftp://127.0.0.1/images/CC46009CEDC9418298E0C2EEF186D4CF.jpg', to_timestamp('26-10-2016 22:58:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('26-10-2016 22:58:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 2, null, null, null);
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161105233644294', '测试2', 12, '件', 'ftp://127.0.0.1/images/1486B5D198E948159DE12AC71E8CCD9F.png', to_timestamp('05-11-2016 23:36:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 23:36:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 2, null, null, null);
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('P20161207195921897', '测试071', 213134, '件', 'ftp://127.0.0.1/images/20161207195540209.jpg', to_timestamp('07-12-2016 19:59:21.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-12-2016 23:06:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '测试', '湖南', '棉', '测试', '测试', 'S0000000001', 1, to_timestamp('07-12-2016 22:00:14.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '23', 'Kg');
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('P20161207230617377', '测试072', 1231234, '件', 'ftp://127.0.0.1/images/20161207230601542.jpg', to_timestamp('07-12-2016 23:06:17.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-12-2016 23:07:04.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '测试', '测试', '测试', '测试啊', '测试b', 'S0000000002', 1, to_timestamp('07-12-2016 23:07:04.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '12', 'Kg');
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161105233748227', '测试3', 232, '件', 'ftp://127.0.0.1/images/5CD26C2D3A4249B2AA703A012BDE0DB0.jpg', to_timestamp('05-11-2016 23:37:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 23:37:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 2, null, null, null);
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161105233811906', '测试4', 45, '件', 'ftp://127.0.0.1/images/CD5C905BAA54478AAA4BD188026A5607.jpg', to_timestamp('05-11-2016 23:38:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 23:38:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 2, null, null, null);
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161105233851212', '测试5', 34, '件', 'ftp://127.0.0.1/images/4479EF6CCD004911AE1A58E095F2A910.jpg', to_timestamp('05-11-2016 23:38:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 23:38:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 2, null, null, null);
insert into TB_MALL_GOOD_INFO (GOODID, GOODNAME, GOODPRICE, UNIT, IMAGEURL, CREATETIME, UPDATETIME, CREATOR, BRAND, MADEIN, MATERIAL, DESCRIPTION, REMARK, SKU_NUM, ONSALE_STATUS, ONSALE_TIME, WEIGHT, WEIGHT_UNIT)
values ('G20161105233914371', '测试6', 3454, '件', 'ftp://127.0.0.1/images/13C7C009C3614DCE9B3E82911965AB0D.jpg', to_timestamp('05-11-2016 23:39:14.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-12-2016 22:02:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, null, null, null, 3, to_timestamp('07-12-2016 22:02:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, null);
commit;
prompt 8 records loaded
prompt Loading TB_NOTE_DIARY...
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('4955B229AE7D4F7F9BF482A431E2B88C', '承受', to_timestamp('20-10-2016 01:54:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('19-10-2016 22:58:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '别了<br/>萧瑟的秋风<br/>尽管吹走了<br/>不舍的落叶<br/>带来了<br/>满地的萎苕<br/>我只等待着那一刻<br/>背靠青山 萧秋别月<br/> <br/>悲风吹寒了<br/>满腔热血<br/>我愿舍去<br/>幸福的青山<br/>去承受<br/>那跨越千年的孤寂<br/>去换来那一片<br/>痛的白皑<br/>只望来年的<br/>面朝大海 春暖花开', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('1E9C5B7300994E62A2E07F0D00845CDF', '一切都不要太迟', to_timestamp('20-10-2016 01:55:02.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('20-10-2016 01:01:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '  追風<br/> <br/>一切都不要太迟<br/>我们都是在一次有限地生命中完成我们的人生，所以我们没有那么多时间留给遗憾！<br/>我们每一个人都在赛一场长跑，一场.只有一次机会的长跑 一场.不能输掉的长跑.因为我们有个强劲的对手：“遗憾”，它就像一个倔强的小强一直追着你跑，让你害怕。如果你没有勇气跨越阻碍的话!终会被它追上。<br/> <br/> <br/>一切都不要太迟<br/>你不勇敢，没人会替你勇敢.这是领悟者的话语。你不前行，有人会替你前行.这是我的话语。。领悟了的人后悔太迟 爱的太迟 醒悟太迟 明白得太迟。而前行的人别后悔太迟 别爱的太迟 别醒悟太迟 别明白得太迟。..遗憾”是最让人埋怨自己的东西，可以说它让我们最痛，而我们都会有痛这是无法否定的，但我们并不是要遗憾的痛，而是前行的痛。带上勇气，头也不回的前行，让将来的你告诉自己无怨无悔。<br/> <br/> <br/>一切都不要太迟<br/>有人不小心绊倒受了伤会默默地爬起来，然后继续前行..痛吗？会..他们一定会痛，但比起痛他们更想看看前方的风景有多么迷人。但有个人不小心绊倒受了伤，却因为痛不想爬起来，但他看着经过的人一次次绊倒一次次爬起却好像在欣赏一样。舒服吗？呵呵...肯定的.因为不用痛。直到他，偶然瞟见远方那步入眼帘的风景.他被深深吸引了，他想爬起来前行去看看远方的风景，那吸引自己的地方。。但晚了...他已经失去了爬起来的能力。他后悔，他伤心，远方明明是自己想去的地方，自己却去不了。。我们都是在一个地方起跑，经历一样的道路和一样的风景，连挡在我们路前地石子都一样，唯一不同的是，你趴着地时候我还在继续前行...<br/> <br/> <br/>一切都不要太迟<br/>不管是爱情，亲情，友情还是梦想，一切都不要太迟。往往我们会发现，我们被遗憾追上，就只差那么点勇气。...我如果说出来了，还会这样吗？我如果坚持一点，还会这样吗？我如果在意一点，还会这样吗？我们没有如果。告诉自己，一切都不要太迟，我要前行，那怕会受伤，会丢脸 我也不想遗憾。<br/> <br/> <br/>告 诉 自 己一 切 都 不 会 太 迟', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('A29CF812BED44556B5C0B54BCB6D3A6C', '学习', to_timestamp('20-10-2016 22:51:46.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('20-10-2016 22:51:46.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天想做一个每天一篇的日记，微信模板消息推送的提醒<br/>督促弟弟，或者亲朋好友学习<br/>但是服务号没有，唉', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('A4628844EA8449AF90CA4A836A30F8FB', '做一个写日记的功能', to_timestamp('20-10-2016 22:53:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('20-10-2016 22:53:30.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天突发奇想，想做一个写日记的功能模块', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('8705DD4E0E4949229427A2CD4B665809', '反思', to_timestamp('17-11-2016 18:40:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-11-2016 18:40:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '我是不是太啰嗦了，有时候是的吧，要控制住啊，曹纪梅', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('2CE820974342414DBE9ACE499C1583F1', '心累', to_timestamp('20-12-2016 21:24:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('20-12-2016 21:24:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '如果一个人的心累了，一个雪白的世界，也许是最好的慰藉！', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('128753CC25BC46FBA971BCB8772E4265', '事务提醒功能', to_timestamp('10-01-2017 23:18:28.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 23:17:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天优化了组织机构，并且也优化微信自动回复功能，但是现在又想添加事务提醒功能了', '18680221791');
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('8CC6F513761D42C5B6A98E4C55FE214F', null, to_timestamp('23-11-2016 14:01:43.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('23-11-2016 14:01:43.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '我还是决定把日记管理系统先开发完成了。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('D4E5862B907544FCB7276D9F1F2819D2', '反思', to_timestamp('04-12-2016 14:37:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('04-12-2016 14:36:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '    从小就追求快乐，并真心地认为人应该活得轻松快乐，如果要说缘由，也许是小时候看到太多人哭了吧。<br/>    <br/>    但是一个人若是强制自己快乐，也许是痛苦的源泉，正如我。 曾经我强制自己快乐，不准自己哭，把悲伤和痛苦深藏心中，笑着面对生活，结果却给了自己两个深深的伤害，一是眼睛，本来我的眼睛和视力是非常好的，可是长期的不哭使得眼睛干涩疼痛，到了后期希望自己哭却已经没有眼泪，干痛的眼睛折磨了我初中和高中的生活，直到大学，才慢慢正常；二是，当内心的压抑过于长久，一旦开始释放，似乎要爆发，可是理智上却要压制，很是痛苦，从小学开始隐藏痛苦，高中开始释放，到大学毕业2年后放下，这个时间真的很漫长。<br/><br/>    也许到今天，我才开始明白追求快乐是好的，但是强制快乐只会给自己带来多的痛苦，随其自然，在快乐时快乐，在悲伤时就悲伤。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('668E2536E55E416889E7EA11A723ED60', '痕迹系统', to_timestamp('08-01-2017 22:04:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 22:04:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天痕迹系统终于开发完成了，值得开心一下', '18680221791');
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('19B7817FFD3742ABA321B0765326052D', '仪态', to_timestamp('02-12-2016 23:04:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('02-12-2016 23:04:52.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '也许自己太自私了吧，看似不以自己为中心，其实是以自己为中心，总是把自己的事看得太重了。<br/>曹纪梅你的仪容呢？坐有坐相，站有站相。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('41FE713B51D74EB98678876181A85561', null, to_timestamp('23-10-2016 21:10:28.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('23-10-2016 21:10:28.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '加了一天班，折腾这个系统，折腾了一个星期，累！', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('28952BE4629043CD8DF2AAA70A33C3C3', '回家', to_timestamp('28-11-2016 19:07:50.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('28-11-2016 19:07:50.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '每年都不想回家，可是每年都回去了，晕', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('7B4F923EC4B1425ABA718768E08390D8', '我做错了吗', to_timestamp('03-12-2016 22:06:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('03-12-2016 22:06:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天我向斌哥，提了一些建议，向领导提建议，对吗？', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('208848197A3F4CA8B0FED1413FF515B6', '悟', to_timestamp('17-12-2016 23:40:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-12-2016 23:40:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '     最近看了较多的破案的，里面常常提到命运。<br/>     命运，是选择和被选择的过程。<br/>     命运，像太极八卦，黑与白，往往由性格决定，而一个人的性格或者说执念大部分是有家庭决定的。一个健康的家庭，有更多的去选择的勇气；一个悲剧的家庭，人往往缺乏信息和勇气去选择而常常被选择，即常常被命运捉弄。<br/>     选择，也有两种，一是顺势选择；一是逆势选择。犹如水，水势注定是往地势低的地方流，流的方向是可以较为简单的改变的。命运，即被选择，也是有一定的趋势。<br/>     在命运的趋势，人可以选择自己的去向，这个需要智慧和勇气，并付出较小的代价。任何选择都是要付出代价，因为得与失，在一定程度上是平衡的<br/>     水要逆流，不是不可以，但是需要付出巨大努力。打破常规，逆势而为，是需要巨大的勇气和坚定的决心，付出时间和努力，甚至付出巨大的代价，才能改变命运。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('4BE8B06A37484769B7E52E4AE2A46EF9', '广州的绿', to_timestamp('17-12-2016 23:49:03.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-12-2016 23:49:03.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '     记得初来广州时，也是一个冬天，看到这里葱葱郁郁，感觉这里绿化非常好。<br/>     现在已经12月份这里依旧温如春天，这些花草树木犹如没有凋落的时候，于是我又开始想念家乡的一年四季分明了。<br/>     花开花落本是常态，可现在的人似乎过于追求年轻，追求盛世美颜。有时觉得这是一种病态。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('95E5E06D2A2E43828C78E51450816F23', '人生', to_timestamp('08-01-2017 09:09:21.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 09:07:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '别人的人生怎么样，我不知道，但是我的人生是熬的，所以在这个尴尬的时期，嫁了吧，熬过这段时间。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('11A275996939481A97D74225FD03F166', null, to_timestamp('05-11-2016 16:32:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 16:32:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '好久没有写日记，今天继续吧', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('5893D07F58174B5B8DD018161A583591', '定制商城', to_timestamp('05-11-2016 16:33:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 16:33:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '虽然页面不太会写但是我还是决定把定制商城开发完成，所以继续加油吧', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('AC57C3FBD25743CCB2E5E67621A57069', '测试', to_timestamp('05-11-2016 16:33:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-11-2016 16:33:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '这个算是测试吧', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('3C29C18EA03448FDAF80DF7607A68DA3', '文章', to_timestamp('07-11-2016 21:01:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-11-2016 21:01:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '老爸又督促我，要我学习写文章了，在他眼里，读过大学的人，就是知识分子，是会写文章的，可惜我不会。<br/>常常看着路，路上的人，路上的车，可却不知道，他们在想什么，路上的车为什么这么匆忙，渐渐地发现，路上的人和路上的车一样，那么匆忙，参与工作以后，也常常看着路，路上的人，路上的车，渐渐地感觉到人和车一样，像机械一样的活着，在既定的轨道上前行，也许感情是这无聊的生活的调剂，让人类与机械不同吧<br/>也许是我在乎的人太少，在乎的事也很少，无感罢了，所以才不会写文章。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('3B34C2F6C5FE4C248AA51A5855434A49', '警告', to_timestamp('07-11-2016 21:02:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-11-2016 21:02:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '以后不能吃辣椒及辛辣的食物，记住啊', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('4E53D632E9B04739B145C35911C56198', '河北出差', to_timestamp('22-11-2016 15:16:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('22-11-2016 15:16:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '真的不想来河北石家庄了，也不想见到客户了', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('7B6F1003353341C194E5EC12902103D4', '部门反省', to_timestamp('30-11-2016 20:27:29.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('30-11-2016 19:58:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '昨天部门反省，我也该反省了。<br/>我该多学习学习了。<br/>所以我打算写一个问题管理系统', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('9BBE9E324213452792F4F591E3EA0ABC', '忍住', to_timestamp('01-12-2016 20:46:14.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 20:46:14.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '曹纪梅，你需要学会忍住，不要心直口快；<br/><br/>曹纪梅，你要修正自己的仪态，坐得有坐像，站得有站像。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('EEA66AF9749441098B446CF816966B1B', null, to_timestamp('10-12-2016 20:46:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-12-2016 20:46:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '魂已曲，心已忘。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('F6E2EA937AD748AB917768D798075B51', '白珠', to_timestamp('21-02-2017 21:20:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('21-02-2017 21:18:49.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '有了笔芯，圆珠笔就可以尽情挥洒；<br/>有了白板，黑色开始了新的活法；<br/>有了黑白，写就的是迷人的山水画。<br/><br/>有了春风，树儿娇娇；<br/>有了春雨，花儿窈窕；<br/>有了花儿，蝶儿痴笑。', '18680221791');
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('A993279251254A5A817FE82322F8CD62', '我的毛病', to_timestamp('23-10-2016 22:40:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('23-10-2016 22:40:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '选择困难症、舞台恐惧症、人群恐惧症、强迫症、姓名健忘症，还有什么症呢？', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('1D2638DD4AD24C41ADF12B00FA120D2C', '反省', to_timestamp('24-10-2016 21:01:31.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('24-10-2016 21:01:31.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '最新有些高调了，心里的情绪压抑不住，直接往外发泄；<br/>不应该这样的，做人也好，做事也好，应该低调地把自己的活干好的', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('515BECD0152A4CBD98F6F8900A1FFB0F', '入世', to_timestamp('24-10-2016 22:02:08.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('24-10-2016 22:02:08.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '曾经我总是怀疑自己不能适应这个社会，现在也是。<br/>社会总是逼你走上这条路，又嫌弃你在这条路上走得太远。<br/><br/>小时候，胆小，内心住着一个小公主，站在河边怕掉下去，走在山旁怕幽灵带走，黑夜中怕淹没再也回不来，一个人睡在床上怕第二天不知道在哪里，遇到不如意的事情就会哭泣。<br/><br/>但是她的心，犹如公主一样住着个天使，父母辛苦时，她会做好吃的犒劳父母，邻居需要帮忙时，她主动去帮忙，别人哭时，她也跟着哭，尽管不知道为什么，她就想着让他们开心。渐渐地，她发现太多人在哭，太多人在难过，自己根本就无能为力，就在心中暗暗发誓自己一定要笑，要开心地过一辈子。<br/><br/>她一个人在家乡那个不足百户的山谷里快乐的生活，有一群小伙伴们一起玩耍，她做过很多事，割草，砍柴，砍树，插秧，收割，在中午炙热的太阳下遥望着金黄的稻谷，每天看着太阳东升西落，打雷时，整个村庄犹如大军压境，闪电时，天空都被撕开了两半，她喜欢这样的生活，在这里，她觉得自己每一个细胞都是开心的，就是干着别人说的辛苦的农活，她也觉得是开心的。<br/><br/>然而上帝总是锻炼人的，故而，在她十岁左右，她的心承受了她承受不住的痛苦，也许她的承受能力太低了。她能够承受别人的哭泣，但是她不能忍受自己的父母的吵架，妈妈的伤心和哭泣，她想到了死，可是他不知道怎样死的方式，因而她常常一个睡在床上，就当自己死了，她渐渐封闭自己，不和任何人吐露自己的心声，她封闭了自己的心，但是在外界看来她是正常的，她照样和伙伴们玩，照样玩的开心，但是从来不多说一句与自己有关的话。慢慢地，她开始了180度转变，她想着自己连死都不怕，还怕什么，她胆子大了起来，敢一个人去任何地方，她把自己当男孩一样培养自己，喜欢做男孩做的事情，她很努力，她想改变去改变父母，去改变自己的家，可是不管怎样努力，她的家还是那样冰冷，那样的没有温度，因而她的心也越来越冷，她在初中时就说自己的心是冰，时间越长冰越厚，有时，也融化过，但是后面更冷。<br/><br/>也许量变会引起质变，当你自己把自己当男人时，别人也会把你当男人，也会是太久了，思维也变得男性化了。<br/><br/>时间长了，你突破自己的心结了，你又可以开心的生活了，可是这时候你已经长大了，你该出嫁了，上帝又开始锻炼你了，没有男人喜欢男人一样的女人，你会嫁不出去，尽管你也不想嫁，但是这个社会对单身女人是苛刻的。<br/><br/>是环境将我变成一个男人，而现在却我变成一个让人喜爱的女人，我想说我做不到。', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('7349AFEF64074C12BD87B4865838AE28', '架构与权限控制', to_timestamp('08-11-2016 22:40:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-11-2016 22:40:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '公司有一套权限，但是总是觉得美中不足，现在我决定将组织架构直接绑定在角色用进行全套控制', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('A3678B3603C4423D8E882F9B39932753', '回家', to_timestamp('21-12-2016 20:20:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('21-12-2016 20:20:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '    元旦定了票回家，和老爸说的时候，老爸又心疼钱，我总是在问，到底是钱重要呢？还是人重要呢？', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('75CAF22DBB4749DDA02C45A1C6FF2074', '年會', to_timestamp('05-01-2017 22:28:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('04-01-2017 21:17:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '從滿期望的年會，什麽都沒有得到，反而失望，也許人真的不該有什麽期待或者希望吧！活得實在些吧！<br/>', null);
insert into TB_NOTE_DIARY (ID, TITLE, UPDATETIME, CREATETIME, CREATOR, CONTENT, MOBILE)
values ('AC29774FF1344BE99E97AAFDF8B52816', '程序说明文件', to_timestamp('09-01-2017 18:25:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('09-01-2017 18:25:08.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', '今天优化了自动生成代码，故而现在又想添加新的功能，程序说明文档', '18680221791');
commit;
prompt 34 records loaded
prompt Loading TB_NOTE_GAINS...
insert into TB_NOTE_GAINS (ID, LVL, LVLNAME, TITLE, CONTENT, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('626CD39ACFA54C3AA8090BE31C2DF3DA', 'L1', '经验', '项目管理', '步骤<br/><br/>1，确定需求<br/><br/>2，开发前确定好基础架构，数据库设计<br/><br/>3，安排工作任务，找到人员之间的较好的切合点，减少人员工作中的冲突', '项目管理', to_timestamp('01-12-2016 22:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 22:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
commit;
prompt 1 records loaded
prompt Loading TB_NOTE_QUESTION...
insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('7793CF70A29A4DBD91E9EF7A8A850084', 'L2', '较严重', 'linux tomcat服务器进程自动关闭问题', '1，tomcat 内存默认是128M 故需要加大内存 在bin/catalina.sh 最上面(即cygwin=false 上面)添加 JAVA_OPTS="-Xms1024m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=256m"<br/><br/>2，监控内存<br/>    在bin/catalina.sh 最上面(即cygwin=false 上面)添加如下：<br/>    JAVA_OPTS="-Xms2048m -Xmx2048m -XX:PermSize=256M -XX:MaxPermSize=512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:/home/dmz_vip_mobile/apache-tomcat-7. 0.62/logs/gc.log" if [ "$1" = "start" ];then echo "set console"; # JAVA_OPTS="$JAVA_OPTS -Xms256m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=256m" JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=60001 -Djava.rmi.server.hostname=112.74.185.128"; JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false"; JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false"; # JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.pwd.file=/root/soft/jdk7/jre/lib/management/jmxremote.password" else echo "no startup"; fi;<br/>    然后在java jdk 的bin目录中运行 jconsole.exe 监控此tomcat的运行内存', 'tomcat服务器进程自动关闭问题', to_timestamp('01-12-2016 20:09:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 20:09:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('AFE86EB25CF9463EA22F2B12E54AC86D', 'L3', '一般', 'tomcat乱码问题', '配置 bin/server.xml文件<br/><Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"　redirectPort="8443" URIEncoding="UTF-8" /\> 　　     <Connector port="8009" protocol="AJP/1.3" redirectPort="8443"  URIEncoding="UTF-8"/\> 　　<br/>在port ="8080"或者port ="8009"加入URIEncoding="UTF-8" 就好了。', 'tomcat 乱码问题', to_timestamp('01-12-2016 20:16:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 21:13:29.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('CCA0D96E65E244E48599B09C3569BE5C', 'L3', '一般', 'vue存在页面假死状态，vue还存在字段中html标签，不能编译', '现初步认为是sui mobile问题，可以不使用sui mobile的js文件，将css page和pagegroup去掉即可', 'vue', to_timestamp('22-12-2016 19:36:02.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:03:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'admin', null);
commit;
prompt 3 records loaded
prompt Loading TB_NOTE_TRANSACTION...
insert into TB_NOTE_TRANSACTION (ID, TRANTYPE, TRANDATE, ISREPEAT, TRANCONTENT, AHEADDAYS, TRANTIME, ISAHEAD, CREATETIME, UPDATETIME, CREATOR)
values ('105CE8E0A61949638E862035AACDEFE0', 1, to_timestamp('12-01-2017 23:50:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, '12', 4, '123', 1, to_timestamp('11-01-2017 23:51:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('11-01-2017 23:51:43.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '12');
insert into TB_NOTE_TRANSACTION (ID, TRANTYPE, TRANDATE, ISREPEAT, TRANCONTENT, AHEADDAYS, TRANTIME, ISAHEAD, CREATETIME, UPDATETIME, CREATOR)
values ('F835E5FFF0E04B80BF1F8E23FE76BAC3', 2, to_timestamp('12-01-2017 00:06:37.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, '2', 2, '12345678901234567890', 1, to_timestamp('12-01-2017 00:06:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('12-01-2017 00:23:43.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1');
insert into TB_NOTE_TRANSACTION (ID, TRANTYPE, TRANDATE, ISREPEAT, TRANCONTENT, AHEADDAYS, TRANTIME, ISAHEAD, CREATETIME, UPDATETIME, CREATOR)
values ('AD315788A8384B59AEEFA1DDD9BFDE9D', 1, to_timestamp('11-01-2017 21:50:42.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, '阿斯蒂芬', 2, '123', 1, to_timestamp('12-01-2017 21:51:29.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('11-01-2017 21:51:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'df');
commit;
prompt 3 records loaded
prompt Loading TB_ORG_INFO...
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('N', 'admin', '农富宝', to_date('20-10-2016 20:59:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 20:59:46', 'dd-mm-yyyy hh24:mi:ss'), 1, '0', 1, 'N', 1, 0, 2);
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('Marks', 'admin', '痕迹', to_date('07-01-2017 22:59:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 22:59:45', 'dd-mm-yyyy hh24:mi:ss'), 1, '0', 1, 'Marks', 1, 1, 1);
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('Marks01', 'admin', '测试1', to_date('17-02-2017 21:50:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-02-2017 21:50:15', 'dd-mm-yyyy hh24:mi:ss'), 1, 'Marks', 2, 'Marks', 0, 0, 0);
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('test2', 'admin', 'test2', to_date('10-01-2017 21:49:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-01-2017 21:49:03', 'dd-mm-yyyy hh24:mi:ss'), 1, 'N', 2, 'N', 0, 0, 0);
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('test1', 'admin', 'test1', to_date('10-01-2017 21:48:43', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-01-2017 21:48:43', 'dd-mm-yyyy hh24:mi:ss'), 1, 'N', 2, 'N', 0, 0, 0);
commit;
prompt 5 records loaded
prompt Loading TB_SYS_CONF...
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_host_url', 'http://127.0.0.1:6080', '访问center功能路径', 'weixin', to_date('06-11-2016', 'dd-mm-yyyy'), to_date('08-02-2017 18:31:20', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 1 records loaded
prompt Loading TB_SYS_DATADIR_INFO...
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('question_level', '0', '问题级别', null, 2, to_date('30-11-2016 21:40:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:40:15', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L1', 'question_level', '严重', null, 5, to_date('30-11-2016 21:45:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:45:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L3', 'question_level', '一般', null, 3, to_date('30-11-2016 21:45:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:45:55', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxtemplate_dairy', 'wxtemplate_ywtype', '日记提醒', null, 1, to_date('27-11-2016 22:13:17', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 22:13:17', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L2', 'question_level', '较严重', null, 4, to_date('30-11-2016 21:44:56', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:45:30', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L2', 'gains_level', '普通', null, 2, to_date('01-12-2016 21:51:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:51:51', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L1', 'gains_level', '经验', null, 3, to_date('01-12-2016 21:51:21', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:57:56', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxtemplate_ywtype', '0', '微信模板-业务类型', null, 1, to_date('27-11-2016 22:12:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 22:12:48', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('gains_level', '0', '所得级别', null, 2, to_date('01-12-2016 21:50:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:50:31', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L3', 'gains_level', '技术', null, 1, to_date('01-12-2016 21:52:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:52:48', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 10 records loaded
prompt Loading TB_SYS_FUNC...
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FB548F9A221041E1A70A0A30D12F3457', '20161016024730740', 'query', to_date('16-10-2016 02:48:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('49A155C4DBBF4A56907BFA4B60B4FAF1', '20161016024730740', 'edit', to_date('16-10-2016 02:48:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:23', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9A05C58D23E64D82A8A0FC1448EB732D', '20161016024730740', 'add', to_date('16-10-2016 02:48:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:12', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('699C293D715340D392CD4E113B864D20', '20161016024730740', 'delete', to_date('16-10-2016 02:48:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C3A5BC0B6477434E9E3942C16353834A', 'diary', 'edit', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/diary/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9CFAB7B9645F4EB48F69A3E900B51CDB', 'diary', 'delete', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/diary/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6BFC445EB2FC46D3B49582B319BB503E', '20161016024730740', 'autoCodeBtn', to_date('20-10-2016 02:10:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 02:10:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/autocode');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0784E15BB48B4061A038499DC17B45C3', 'sysRole', 'edit', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysRole/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('34D4A51F71A3452DA20B5C89272F7121', 'diary', 'query', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/diary/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('729986573F3F498AB804BD1B7CC58466', 'diary', 'add', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/diary/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0EE456741D42426DB6448E5C6DDFDA8E', 'sysRole', 'delete', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysRole/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('40B743A6291A435AAE743CA93499AD8F', 'orgInfo', 'query', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('475B85B975C441E9B720FAC82ECAB89A', 'orgInfo', 'add', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('D5FFAAAD152F4023BDEC443B8CECA7C6', 'sysRole', 'query', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysRole/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('588848E727F14FCAA21623A6894C2DDB', 'sysRole', 'add', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysRole/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('35EA71BD598246AFB5769EA6730A1254', 'orgInfo', 'edit', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('165FEFC91D0F4A26B232D2A1D59F4D37', 'orgInfo', 'delete', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('D650F41753614EF68D65AD237334627C', 'wxAccount', 'query', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAccount/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('AE5067796D694BAFB287D18529BAFFE2', 'wxAccount', 'add', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAccount/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A9EDBB5CBFAA49CEB53C12A3C516BE85', 'wxAccount', 'edit', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAccount/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7C045D9CA9D5456FAF856490836AA6C8', 'wxAccount', 'delete', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAccount/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E0214CC842524D61A1CADB4B25F28C6D', '20161023003925948', 'query', to_date('23-10-2016 00:39:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:39:48', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/framelist');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('751789E53BAA42428D477E49B00572C5', '20161023003925948', 'add', to_date('23-10-2016 00:39:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:39:59', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('140845F24CC241B7AB3783B93F98724B', '20161023003925948', 'edit', to_date('23-10-2016 00:40:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:40:09', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2DA34B5B4BF643E89DD5B6C791CD630A', '20161023003925948', 'delete', to_date('23-10-2016 00:40:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:40:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/orgInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4C7AA4B348454752BEF6F9EC55402280', 'sysRole', 'addFunc', to_date('23-10-2016 00:47:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:47:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysRole/funclist');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C58C67CD6EA94BB2963C9714C6F9F90B', 'goodInfo', 'query', to_date('26-10-2016 21:13:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/goodInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3DA8897C41E8473A99C5492100190412', 'goodInfo', 'add', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/goodInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2309E4BC9A924651B31F785C830728B6', 'goodInfo', 'edit', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/goodInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0F54D4F78A8D491FA43C3FBF60A9B1CF', 'goodInfo', 'delete', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/goodInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E24E30A2E2674303B6C9B62B36D79ADC', 'advise', 'query', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/advise/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8890D1E058DB4B7894B2D7B2BCC696A7', 'advise', 'add', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/advise/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A10AF55DA5C548E294DBD10A10F92E46', 'advise', 'edit', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/advise/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('062D833DD050478A8B6D5503CD347F60', 'advise', 'delete', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/advise/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2DFE8F4215A34E4AB1A603C36242F923', 'wxMenu', 'syncWx', to_date('17-11-2016 19:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-11-2016 19:03:58', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenu/syncWxMenu');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0CC56B98214E4C8FB8439F341AFEEE28', 'vipInfo', 'resetPwdBtn', to_date('08-01-2017 21:40:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 21:40:52', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/resetPwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('633836EDCC0E40329B2BEBB34FA2B5FB', '2', 'add', to_date('23-10-2016 18:03:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:03:59', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('DA0BA7D60DD6461E85EA1EFB4E56AC1D', '2', 'edit', to_date('23-10-2016 18:04:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:04:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6232F8C5272A489CB66E54091718E5AD', '2', 'query', to_date('23-10-2016 18:03:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:03:47', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysMenu/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('831A77AF2FB5418FB6290E19ACB03F72', 'sysUser', 'edit', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7F15BED5384E401AA13B8FE99FDD79E5', 'sysUser', 'delete', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FA00FAE5BE8249519544EAB937CED130', 'sysUser', 'query', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('81F44FFCFB484D1B9B2B28B8B44038FD', 'sysUser', 'add', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9B746C1302684616B012733A4E791179', 'goodInfo', 'onsaleBtn', to_date('07-12-2016 20:31:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-12-2016 20:31:07', 'dd-mm-yyyy hh24:mi:ss'), null, '/goodSale/onsale');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A4847B5D9E2C404BAFFCA1925B4C651B', '20161203195018623', 'edit', to_date('03-12-2016 19:54:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:54:50', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/updatePwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6061F2E92C214F4E98AA9F8A6862CD58', '20161203195318395', 'edit', to_date('03-12-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/updateMobile');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A0BEFFBB0FDA42F38280FBE35A670977', 'wxAccount', 'syncWxFans', to_date('22-12-2016 22:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2016 22:30:28', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxUser/sync');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('81B28ED45F1A427ABBA9025E4D917AD0', 'sysLogParam', 'add', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysLogParam/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('351B1DF16E6444258F142C4FD767FCEE', 'sysLogParam', 'query', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysLogParam/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A6907ADFCD4B4E048DDA0632C2D5062F', 'sysLogParam', 'edit', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysLogParam/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('5AA2258E1404444BAE135783DD56DC03', 'sysLogParam', 'delete', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysLogParam/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('92078E74B6784886BA2956AE553BFA69', '20160928203125806', 'query', to_date('30-09-2016 14:38:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:38:50', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysOperate/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A716C1E44907420AAD6CA5AC638541C8', '20160928203125806', 'add', to_date('30-09-2016 14:39:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:39:01', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysOperate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7EF6056FFFDE4EE6BBF84F86EF66BF28', '20160928203125806', 'edit', to_date('30-09-2016 14:39:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:39:06', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysOperate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0073BE06AA6A49D783E9E033131A5C57', '2', 'addFunc', to_date('30-09-2016 15:43:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 15:43:44', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysMenu/initFunc');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C1060CF0D3CE49A19BB7AEB3AF622B0C', '2', 'delete', to_date('30-09-2016 15:45:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 15:45:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysMenu/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('37A16BCD5D0E462EB892CDC9BB3D28EA', '20160928203125806', 'delete', to_date('30-09-2016 16:11:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 16:11:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysOperate/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A3E3FFABB3264BEC9D20C47EA542B2F0', 'moduleMsg', 'query', to_date('28-11-2016 19:23:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-11-2016 19:23:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/moduleMsg/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E9AFCA0B219A48F2B26C3407B89F6D4F', 'vipInfo', 'query', to_date('08-01-2017 19:55:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 19:55:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/vipInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3E71A3CE7AB34607BDC570E72EBB6444', 'qrcode', 'add', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/qrcode/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('AFF47427547E413D8A4E6E9D8658BB17', 'qrcode', 'query', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/qrcode/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F43CE8D5ABDB46148E26B8C6A7C513D7', 'wxMenu', 'query', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenu/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CB28B8D3B8E846C7A355249B8A6D14BC', 'wxMenu', 'add', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('374088A1D165445AB7496D87B9A5175E', 'wxMenu', 'edit', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenu/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('58F8C1A54B244D07986F391AD5CB9E5D', 'wxUser', 'query', to_date('06-11-2016 19:11:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 19:11:31', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxUser/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2B12F2FF49C242F4963A550AC1AA4D52', 'qrcode', 'edit', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/qrcode/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E5934CC56BEF43ECBF47AC07890713AC', 'wxMenu', 'delete', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenu/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0C86A52B779342DA92F4F6027B3251FE', 'wxMenuUrl', 'query', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenuUrl/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('805B2E58E7CB46CFAC9629FE35F9E051', 'wxMenuUrl', 'add', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenuUrl/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('21B1268FD84F4B1C8945C8E9731F0F49', 'wxMenuUrl', 'edit', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenuUrl/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F9B4C69C5F864657A55BF9560AAD7AC9', 'wxMenuUrl', 'delete', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxMenuUrl/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('34CC225109974D0296DD538ED1A229C0', 'wxAutoReplay', 'query', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAutoReplay/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('941ABAFE35D6480B95D0178B760BB1DB', 'wxAutoReplay', 'add', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAutoReplay/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('56AF2BA7BBD643D8B66F1FEDB2F8D650', 'wxAutoReplay', 'edit', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAutoReplay/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A88AB1777C264C8387A4CF7B9C961048', 'wxAutoReplay', 'delete', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxAutoReplay/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A3FEA09B72BA41868AA07D6818117AC0', 'newsItem', 'query', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/newsItem/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FB4C99E9FB1A42F19B86FFC3DA761824', 'newsItem', 'add', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/newsItem/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8D4EC97F07AA48C0BA5F5F55A302532E', 'newsItem', 'edit', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/newsItem/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6FB911AF50884CB9B52D3A6D9D3D4B03', 'newsItem', 'delete', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/newsItem/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('55371B38A22F4D078947A10E51837D47', 'qrcode', 'delete', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/qrcode/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('18B306C4A74149609A3FDC36F86F902A', 'sysConf', 'query', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysConf/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B0E3BAAA2955492FADE23C35F774BCC3', 'sysConf', 'add', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysConf/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B31E5C8F9DDB434CA70DDCC8204A74F3', 'sysConf', 'edit', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysConf/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('431D29CBA6B64D92821180C1DB4335DE', 'sysConf', 'delete', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysConf/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F52536BB355D4216AA5F541601ABA4E0', 'dataDir', 'query', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/dataDir/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C50921BE08CE4C47BEC824DA733F4CFD', 'dataDir', 'add', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/dataDir/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('88EA18C8BA4847119DEFC9146B7C7F1F', 'dataDir', 'edit', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/dataDir/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3EC98DB80F6440269D3628766217A68E', 'dataDir', 'delete', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/dataDir/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A947C38F31814E67830E922BA2FD5926', 'wxTemplate', 'query', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxTemplate/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('352724802F66473AA600570AB00C61D4', 'wxTemplate', 'add', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxTemplate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CB6D94D479C34121A38F5B40B91106D2', 'wxTemplate', 'edit', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxTemplate/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8B31D84CC47A466C8132F6C0D212D442', 'wxTemplate', 'delete', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxTemplate/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('440141C13AB345BC991774CDD7614909', 'question', 'query', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/question/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E95BB25BFFAF4C13864DBC3A02B9306D', 'question', 'add', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/question/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CD2780A03F02413E9D18F66323064595', 'question', 'edit', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/question/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F26FD1B3DCBF43D38E37529BC60E12F3', 'question', 'delete', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/question/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('BFBB32ADDE9C42B4ADECACACC04DF0A5', 'gains', 'edit', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/gains/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('56FC1334D6A54B28B41C552156EA7E2C', 'gains', 'delete', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/gains/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B527659F90594CD4844E2A2F22223E2A', 'vipInfo', 'activeBtn', to_date('08-01-2017 21:42:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 21:42:39', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/updateActiveFlag');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F2B99E17C4EC4CB399A1F4D435C28909', 'gains', 'query', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/gains/list');
commit;
prompt 100 records committed...
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9E081346B9F5409EB8E8D79A988515E3', 'gains', 'add', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/gains/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('86BC5FE8B3624C5B96922DA0D299D843', 'sysLog', 'query', to_date('27-11-2016 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysLog/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4DF3F72BB4EC46F484217B2A43976506', 'transaction', 'add', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null, '/transaction/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('10ACD5DC793A4D5A9F4228195CF57B77', 'wxUser', 'dairyBtn', to_date('03-12-2016 18:50:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 18:50:26', 'dd-mm-yyyy hh24:mi:ss'), null, '/wxUser/dairy');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('028280270812450986EE5E8552E692EC', 'sysUser', 'resetPwdBtn', to_date('03-12-2016 19:27:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:27:01', 'dd-mm-yyyy hh24:mi:ss'), null, '/sysUser/resetPwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('1A3986FDB20849B5803407BB690F16DC', 'transaction', 'edit', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null, '/transaction/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4BF2476CDA2347BF8D99668774CA901C', 'transaction', 'delete', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null, '/transaction/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4A911E4E08FE45BF95EE3CC1BA5F3B78', '20161016024730740', 'introBtn', to_date('09-01-2017 23:03:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:44', 'dd-mm-yyyy hh24:mi:ss'), null, '/autoCode/autocodeIntroFile');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('EA8356660C5C44148C2F2ADAE541F378', 'transaction', 'query', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null, '/transaction/list');
commit;
prompt 109 records loaded
prompt Loading TB_SYS_LOG...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A59B863EEDA440F1B56FBDE94FCD557C', 'admin', '超级管理员', to_date('18-02-2017 11:33:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F94A8B23F52740D293E272D89022B95F', 'admin', '超级管理员', to_date('18-02-2017 11:35:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '新增', '0', '/autoCode/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EE8E5CDF4F5441499FC186F60D4B2837', 'admin', '超级管理员', to_date('18-02-2017 11:35:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9936C620A32A4FEA8F712CB1292D7B35', 'admin', '超级管理员', to_date('18-02-2017 11:35:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('73F2543694EF49D99749F203495AACA7', 'admin', '超级管理员', to_date('18-02-2017 11:41:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0F40C42A6C17455B8B0E79C14ED4C98C', 'admin', '超级管理员', to_date('18-02-2017 11:41:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '删除', '0', '/sysMenu/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6CFE4935880D47AC8BE0197ECB6ABD94', 'admin', '超级管理员', to_date('18-02-2017 11:41:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6209B242658A4D3AA5525E338D1BA013', 'admin', '超级管理员', to_date('18-02-2017 11:41:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '删除', '0', '/sysMenu/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0231CEF9CB774BDF9E10368A8EFC949F', 'admin', '超级管理员', to_date('18-02-2017 11:41:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3B0E8A522D1E458FBE48DD0C33DF359F', null, null, to_date('18-02-2017 11:41:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('303586721D1F4F1CB5BA8628FCC10E2B', 'admin', '超级管理员', to_date('18-02-2017 11:41:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '会员信息', '查询', '0', '/vipInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('79ECCA57FFE44B469B3229E3DC846371', 'admin', '超级管理员', to_date('18-02-2017 11:42:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CBCD677A698C46C1928A38B60D47FBFE', 'admin', '超级管理员', to_date('18-02-2017 11:32:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('169A8E92C87748F2A07F66984BAB32B7', 'admin', '超级管理员', to_date('18-02-2017 11:32:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A63942520F1141B48864E22739174951', null, null, to_date('21-02-2017 21:18:22', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EA8D7C5F2910444E8D712F201DB0544B', null, null, to_date('21-02-2017 21:18:24', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2FB900ED8D9844DC85E083687DBBFC91', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:44', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EB2E099AF1D547B4A92731CDD8B378D8', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:49', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D0243ABD07B3402AAB1B6C42B5C76A54', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:49', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('15CBDA0E36144116BD29239A10F1899C', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:51', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BE4E30F70BB840F3BBE1D126CC6CA107', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:51', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '详情', '0', '/diary/findDiaryById', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('971C2AA8FF0F453CA80276558EBED0DB', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:53', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('16EDF57AE90E487AB44A0C73F0428CF3', 'admin', '超级管理员', to_date('11-01-2017 20:05:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '模板消息', '查询', '0', '/moduleMsg/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6C3E7B7A8A194D399E548856B87559CF', 'admin', '超级管理员', to_date('11-01-2017 20:09:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('98F6AD48C3ED4EE593E836906371EA81', 'admin', '超级管理员', to_date('11-01-2017 20:09:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '商品管理', '查询', '0', '/goodInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9B9516F962834502AA44AE1CABC0C0FF', 'admin', '超级管理员', to_date('11-01-2017 20:11:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '二维码管理', '查询', '0', '/qrcode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8DD55F7372B24120B2BB3C9C3CF26305', 'admin', '超级管理员', to_date('11-01-2017 20:13:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F096999C0CFA42B583D074D77AB460F1', 'admin', '超级管理员', to_date('11-01-2017 20:14:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('55E9649F2BC44A0D935FBEFC43456982', 'admin', '超级管理员', to_date('11-01-2017 20:05:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9CEC7139938D4D75B6C8AD53D9FCC35A', 'admin', '超级管理员', to_date('11-01-2017 20:05:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E814CB477EEB49ABAD1F2D61315053B8', 'admin', '超级管理员', to_date('11-01-2017 20:14:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CD843537C9884202863FBE936EED2E4F', 'admin', '超级管理员', to_date('11-01-2017 20:15:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6E1E453EB79146F4BA1331897691491A', 'admin', '超级管理员', to_date('11-01-2017 20:15:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C6DDC2D150124BF0BFC625D29638E8DA', 'admin', '超级管理员', to_date('11-01-2017 20:15:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F2B116529A1D403F98D1DE8F7812C4AE', 'admin', '超级管理员', to_date('11-01-2017 20:15:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('17F5A7607A6C49408630F42BCB4A64C8', 'admin', '超级管理员', to_date('11-01-2017 22:09:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F2BB818661754718B4B71A675D51F7AB', 'admin', '超级管理员', to_date('11-01-2017 22:11:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6F732366CF5A4262BBC4A073951FBDD6', 'admin', '超级管理员', to_date('11-01-2017 22:12:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BF0C7BA251AC4593A0160E6DF703FB66', 'admin', '超级管理员', to_date('11-01-2017 22:13:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C7720D54F5ED45C6B2E196B23A53C7E2', 'admin', '超级管理员', to_date('11-01-2017 22:13:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4DB73AC894254C6495500CB6B7D37C06', 'admin', '超级管理员', to_date('11-01-2017 22:13:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5893B04ACC3940EFA51B2A636C63B44A', 'admin', '超级管理员', to_date('11-01-2017 22:14:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('59E60A6AB3364B90AFEBDB8CAFC74214', 'admin', '超级管理员', to_date('11-01-2017 22:14:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CF24992AC7CA4AF099D8EACF10D818E8', 'admin', '超级管理员', to_date('11-01-2017 23:34:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F44B4E34B95847188AE571CA56BEA666', 'admin', '超级管理员', to_date('11-01-2017 23:34:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AA85164691F646F5A66D5E170223D2C7', 'admin', '超级管理员', to_date('11-01-2017 23:34:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('63E72599209440F28A1B3FB35CACA5E9', 'admin', '超级管理员', to_date('11-01-2017 23:39:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F1006F6F0DD34320ADC4A8D899637303', 'admin', '超级管理员', to_date('11-01-2017 23:39:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ACFBF8B9A89F4A2090D1397FCDAE287A', 'admin', '超级管理员', to_date('11-01-2017 23:39:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E4BAB60B3FE840FC945D7A25159D8115', 'admin', '超级管理员', to_date('12-01-2017 00:15:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('77DC6D37965C405F8BF1B8ADA8D10691', 'admin', '超级管理员', to_date('12-01-2017 00:15:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('83EFAE97EDD447DD92B57CCC69FA646A', null, null, to_date('21-02-2017 21:18:22', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C45A918E060349BE80647C2E5F7A43DB', null, null, to_date('21-02-2017 21:18:24', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('76205421BE624180AE16E057BDD8D636', 'admin', '超级管理员', to_date('17-02-2017 21:06:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '二维码管理', '查询', '0', '/qrcode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5C7C685B015E40ABB83E51F9449252E5', 'admin', '超级管理员', to_date('17-02-2017 21:06:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BDE24EF1AC4449FAA0E7832A411F27D2', 'admin', '超级管理员', to_date('17-02-2017 21:06:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CBC860CF04CF4640A72340DF7CE91821', 'admin', '超级管理员', to_date('17-02-2017 21:06:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('401D8E3762F642D186CAC7251259C226', 'admin', '超级管理员', to_date('17-02-2017 21:06:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8FBCE079AFCD487785B677F113C5229D', 'admin', '超级管理员', to_date('17-02-2017 21:09:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4C093C0002CE4D5CA41B5D346485B74A', 'admin', '超级管理员', to_date('17-02-2017 21:12:41', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DCEDF021ACB644E4BF6C97C90A213AEA', 'admin', '超级管理员', to_date('17-02-2017 21:19:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('103276293DC7475A965E73BEF20E6843', 'admin', '超级管理员', to_date('17-02-2017 21:20:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BBE4F469241B4759B7D499980CCFF1A2', 'admin', '超级管理员', to_date('17-02-2017 21:21:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1D43DB1B2D59435BB1DD272BD0574D34', 'admin', '超级管理员', to_date('17-02-2017 21:21:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('19C247B44BF640238697F343157D8092', 'admin', '超级管理员', to_date('17-02-2017 21:25:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '新增', '0', '/sysRole/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('027F9B60C0A0420BB07E7426904DAE39', 'admin', '超级管理员', to_date('17-02-2017 21:25:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D1D80AAE65F4494CB9D197A7638EA389', 'admin', '超级管理员', to_date('17-02-2017 21:25:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '编辑', '0', '/sysRole/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DCB716A23AFC49C6B67D48BA391DC94A', 'admin', '超级管理员', to_date('17-02-2017 21:25:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DD6BA21C9B4F44D09EE5952FEF6B8D83', 'admin', '超级管理员', to_date('17-02-2017 21:25:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6ECF211300E74025ABBD689E0D082201', 'admin', '超级管理员', to_date('17-02-2017 21:25:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C8671413FCE24417AE482C41302D72BC', 'admin', '超级管理员', to_date('17-02-2017 21:06:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '微信模板', '查询', '0', '/wxTemplate/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5C27B8CEAC47416EA87A61B0D609EEC5', 'admin', '超级管理员', to_date('17-02-2017 21:06:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '模板消息', '查询', '0', '/moduleMsg/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DA5B1B25E642400FB1625C3160C52CA0', 'admin', '超级管理员', to_date('17-02-2017 21:27:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('371521AB5350489AB2ADC55179EA123F', 'admin', '超级管理员', to_date('17-02-2017 22:39:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('675A00264F414F9E8AE88B34A35A56B8', 'admin', '超级管理员', to_date('17-02-2017 22:39:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('91B8FB84A71741619EE02F0EAD66EF76', 'admin', '超级管理员', to_date('17-02-2017 22:39:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('088EB746D14D4BB497E1022BDAC20CCB', 'admin', '超级管理员', to_date('17-02-2017 22:39:41', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4D09F42B08C54763AF1B4D042379178F', 'admin', '超级管理员', to_date('17-02-2017 22:39:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F18982EA54C3466A8E997834453A0FBC', null, null, to_date('17-02-2017 22:52:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CDDAD7A78DAE4496A67D30199A690244', 'admin', '超级管理员', to_date('17-02-2017 22:52:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2ED7AB75B2CB4414B89187AC0741AE6C', 'admin', '超级管理员', to_date('17-02-2017 22:52:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FAB9FBC83D7141AD8461CF7DB3FB0576', 'admin', '超级管理员', to_date('17-02-2017 22:53:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('66D7C97A2452443791BCCCE2F6D87BFD', 'admin', '超级管理员', to_date('17-02-2017 22:53:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7BDE1F5CCDF64812ADBBDAD35CF88379', 'admin', '超级管理员', to_date('17-02-2017 23:39:48', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8B86FDEEEAFA4B3B9AB379415EB63F77', 'admin', '超级管理员', to_date('17-02-2017 23:39:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('771BF4BB7C514ED08FC3CFFE67750E7C', 'admin', '超级管理员', to_date('17-02-2017 23:40:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('95433B58341344529986953EC039A7CD', 'admin', '超级管理员', to_date('17-02-2017 23:40:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AF9C76CB91094B87BD96D98B0FBA3B74', 'admin', '超级管理员', to_date('17-02-2017 23:40:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7B6801A9E1CF47249AEAD1643DAFB319', 'admin', '超级管理员', to_date('17-02-2017 23:40:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('67C1BCDC77384BB9BC42ED7EA0B4B630', 'admin', '超级管理员', to_date('17-02-2017 23:40:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5E79C23504D546E6A34A531232E703F2', 'admin', '超级管理员', to_date('17-02-2017 23:40:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '新增', '0', '/sysUser/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('68D959DAA7E54DC6975E4A2CF3AA46AA', 'admin', '超级管理员', to_date('17-02-2017 23:40:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B4506941724542A28C98912EF34AE3CB', 'admin', '超级管理员', to_date('17-02-2017 23:41:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AEB507C6766546C7847DD2ED44EA2AA7', 'admin', '超级管理员', to_date('17-02-2017 23:41:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7EA6F770F964689802EEABB08CEA8A0', 'admin', '超级管理员', to_date('17-02-2017 23:41:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '新增', '0', '/sysUser/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E248D415647A40B79111B17173AA107A', 'admin', '超级管理员', to_date('17-02-2017 23:41:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BB6287DE82974E329384C18484BCA297', 'admin', '超级管理员', to_date('17-02-2017 23:41:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1725C8201BBD4FFA8C3E2C7455F71545', 'admin', '超级管理员', to_date('17-02-2017 23:42:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('361D644E2AA44DE584ECD409591415EF', null, null, to_date('17-02-2017 23:42:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('693A1919B59D47E6BF466DAC120E2C4C', null, null, to_date('17-02-2017 23:42:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
commit;
prompt 100 records committed...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8D34D112252E4963B9CBF53A8ED4F12C', 'U1000023', '测试1234', to_date('17-02-2017 23:42:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A64F83D123FF4363941169070A03DF49', 'U1000023', '测试1234', to_date('17-02-2017 23:42:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('991707AAA9B3442FA2CE655675B7B24A', 'U1000023', '测试1234', to_date('17-02-2017 23:42:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DE052918B3D848408C021BD8EE576865', null, null, to_date('17-02-2017 23:13:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CB1BFBCE37914BFCBFB345079969BFCF', 'admin', '超级管理员', to_date('17-02-2017 23:13:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('69E3EB96E951400389153225DEF5DECE', 'admin', '超级管理员', to_date('17-02-2017 23:13:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('92CE604D3ED54F2084D99E8B261CAE04', 'admin', '超级管理员', to_date('17-02-2017 23:13:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CC786255C7284C85AE7FE8E8365834EB', 'admin', '超级管理员', to_date('17-02-2017 23:13:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0CAB9EFFCCBB4A9496B8375E05907DFF', 'admin', '超级管理员', to_date('17-02-2017 23:13:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('41FF2CBFC6AB44609444BC5C8D402BB3', 'admin', '超级管理员', to_date('17-02-2017 23:13:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0E99F00056294D78B5079F95CEA082A3', 'admin', '超级管理员', to_date('17-02-2017 23:13:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E228EE0AEF704C97B0E6F5EFE1AEDE73', 'admin', '超级管理员', to_date('17-02-2017 23:13:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('41CFE5AF78344D9CA5EE2A942AB97916', 'admin', '超级管理员', to_date('17-02-2017 23:13:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A3290F384401424EBE99AA63E990FCEB', 'admin', '超级管理员', to_date('17-02-2017 23:13:41', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('472717CE5E8047FDA787DB9FDF00637E', 'admin', '超级管理员', to_date('17-02-2017 23:13:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E09447746A884CC5BFFF93ACD3971CF6', 'admin', '超级管理员', to_date('17-02-2017 23:14:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D440EA6BAAAB486D94737B3775EBC0B1', 'admin', '超级管理员', to_date('17-02-2017 23:14:26', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F41794B73E3A40E99A37EC4987B30710', 'admin', '超级管理员', to_date('17-02-2017 23:14:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('69B6CA646CE2421EAD6E27614925CBE2', 'admin', '超级管理员', to_date('17-02-2017 23:14:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E4EC0FB71FAB44489A693896EB941F87', 'admin', '超级管理员', to_date('17-02-2017 23:15:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('57D525598B4F4ABC8E52F3AB0C67AA06', 'admin', '超级管理员', to_date('17-02-2017 23:15:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('27A14AD01F924FE5A2F5F8DBAFD81F0B', 'admin', '超级管理员', to_date('17-02-2017 23:16:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('34AB496C08D64651B2960D09DA2181EE', 'admin', '超级管理员', to_date('17-02-2017 23:16:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6D31DB98C0244FA5825C55BF889FFD92', 'admin', '超级管理员', to_date('17-02-2017 23:16:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CCEA76DFFB1B4AAA9E9E0B26700A81F5', 'admin', '超级管理员', to_date('17-02-2017 23:27:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C2383B560F0143669E30A20C78E89CC1', 'admin', '超级管理员', to_date('17-02-2017 23:27:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('59D09C2FE0804760B1BC921DA9301F17', 'admin', '超级管理员', to_date('17-02-2017 23:28:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6EA2A91A351C49BBAAC71E82F8FBDAAA', 'admin', '超级管理员', to_date('17-02-2017 23:28:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B8F09D4069C142A0A5A4057FE4B6F855', 'admin', '超级管理员', to_date('17-02-2017 23:28:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5B8C0CAACC40458CBA1A059337151B05', 'admin', '超级管理员', to_date('17-02-2017 23:29:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FDFE513E94DD457FBE8FE9E2C8EE30B3', 'admin', '超级管理员', to_date('17-02-2017 23:29:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EB5AD087604A456C941299212B3E49B0', 'admin', '超级管理员', to_date('17-02-2017 23:29:26', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EE4FB303C4734602BA545D5502C75B5D', 'admin', '超级管理员', to_date('17-02-2017 23:30:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('742F1725A4394E2BB549C1F4FB0A4463', 'admin', '超级管理员', to_date('17-02-2017 23:30:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8DC7144014FE4A1B9D886757EC5AE81D', 'admin', '超级管理员', to_date('17-02-2017 23:30:16', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3059A781F15E4D05B95DCE16F28FDCE5', 'admin', '超级管理员', to_date('17-02-2017 23:30:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7C57247092249F88E91D603A447A1B7', 'admin', '超级管理员', to_date('17-02-2017 23:30:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F3C2CBAB85BF4753808B8C8D00E2E071', 'admin', '超级管理员', to_date('12-01-2017 00:00:47', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D4F9BD7AD3FA443EAD2E1E8727775029', null, null, to_date('18-02-2017 11:18:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B016B17464B945118339D3D6C93BCF34', 'admin', '超级管理员', to_date('18-02-2017 11:18:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F06593F1B54F46F3B54DD9A0FD783591', 'admin', '超级管理员', to_date('18-02-2017 11:19:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4223170A7BE348268A7E64F90075FC8C', 'admin', '超级管理员', to_date('18-02-2017 11:19:16', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '删除', '0', '/orgInfo/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FC3127C468524225A1E803D3FAF9A7BF', 'admin', '超级管理员', to_date('18-02-2017 11:19:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('375E6FB888784279BD922FF53E290963', 'admin', '超级管理员', to_date('18-02-2017 11:19:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '删除', '0', '/orgInfo/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('326DAF219F4C4516941E568EDF336916', 'admin', '超级管理员', to_date('18-02-2017 11:19:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('26FDA38F0B294CC3A61565FA1D640506', 'admin', '超级管理员', to_date('18-02-2017 11:19:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4AFC87B712164EE3B22EB7776D0DF78A', 'admin', '超级管理员', to_date('18-02-2017 11:23:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('489213C48B5F4142B46CDC581CB0F61B', 'admin', '超级管理员', to_date('18-02-2017 11:24:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D8C9F5AE56D3472AA47B0787A9E9C3BD', 'admin', '超级管理员', to_date('18-02-2017 11:24:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C1F66D56A6134FA29E43BA9C88AA2601', 'admin', '超级管理员', to_date('12-01-2017 00:00:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('964A096723A84EBCABB9382FDC193785', 'admin', '超级管理员', to_date('12-01-2017 00:00:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FFC30876C2D04D10A200A841BAA1FB3A', 'admin', '超级管理员', to_date('17-02-2017 23:39:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6EA131D8316740DABF548593915A2A1A', 'admin', '超级管理员', to_date('17-02-2017 23:39:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7C76D0B814054D6C9197E254426420A2', 'admin', '超级管理员', to_date('11-01-2017 21:09:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '操作类型', '查询', '0', '/sysOperate/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('819E6D94E1034D75AEF2F4EB0B7A694F', 'admin', '超级管理员', to_date('11-01-2017 21:10:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('61F58B5F7ECB47DEA169EC82B91A015E', 'admin', '超级管理员', to_date('11-01-2017 21:10:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9FD1F74301524555AD9266B3FC9AA60A', 'admin', '超级管理员', to_date('11-01-2017 21:11:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BDC4CB77535242F7B5A0AC0E8B8F04CB', 'admin', '超级管理员', to_date('11-01-2017 21:11:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '备忘记录', '查询', '0', '/gains/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F0BF322BA0D440CBB6083CE2142DFAC2', 'admin', '超级管理员', to_date('11-01-2017 21:11:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('726FB084E95A42B394D49BC7AB137BBC', 'admin', '超级管理员', to_date('11-01-2017 21:11:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '会员信息', '查询', '0', '/vipInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3882D221A1B4417FA49C814D57A98F72', 'admin', '超级管理员', to_date('11-01-2017 21:11:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3C665939F8424470843EEBF0A78D4742', 'admin', '超级管理员', to_date('11-01-2017 21:11:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '功能管理', '0', '/sysMenu/initFunc', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B02968A12AE644CFBBB43DCC50339733', 'admin', '超级管理员', to_date('11-01-2017 21:12:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A4AEB701E8EA4EB3B093F55245B6182E', 'admin', '超级管理员', to_date('11-01-2017 21:12:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DF12ADEFF2D144069913DB1918FDED05', 'admin', '超级管理员', to_date('11-01-2017 21:12:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4946D5BBB98147A185EB6CBC657289B3', 'admin', '超级管理员', to_date('11-01-2017 21:12:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F668147509BE4526968278C750EB6D3E', 'admin', '超级管理员', to_date('11-01-2017 21:14:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9F42E264D02346468F1B2ABE84A1C5A7', 'admin', '超级管理员', to_date('11-01-2017 21:14:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4A45AC58909D45CD81741E82696DA1BE', 'admin', '超级管理员', to_date('11-01-2017 21:14:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D49E714DD1E24E95B75402ACC1280787', 'admin', '超级管理员', to_date('11-01-2017 21:14:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('735FC9EF6507470485B0C322627C5A92', 'admin', '超级管理员', to_date('11-01-2017 21:14:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B8C5C73E4660407DBE136C9D285A3D37', 'admin', '超级管理员', to_date('11-01-2017 21:14:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '数据字典', '查询', '0', '/dataDir/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6AC234A4F11A47FA8C7814D806A55C44', 'admin', '超级管理员', to_date('11-01-2017 21:16:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('01407D6F659B4EC1AD8DC058B43C0537', 'admin', '超级管理员', to_date('11-01-2017 21:16:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0A878FD4E71B46BDBF509C0A9EB1F5BB', 'admin', '超级管理员', to_date('11-01-2017 21:41:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D314F07731294A46983617E889F67021', 'admin', '超级管理员', to_date('11-01-2017 21:42:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('217A9EE73684433A94D624E2B4F7A00B', 'admin', '超级管理员', to_date('11-01-2017 21:42:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4E225733B2D84F1388E0FCC7B73EADBB', 'admin', '超级管理员', to_date('11-01-2017 21:42:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统菜单', '查询', '0', '/sysMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DAFB9DB374A346799DE8A8E3246A7A4A', 'admin', '超级管理员', to_date('11-01-2017 21:42:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6248F2ADFCD4482DA4301321826D58A2', 'admin', '超级管理员', to_date('11-01-2017 21:44:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F3B47FEDCA7C4F87A165920A8C90A136', 'admin', '超级管理员', to_date('11-01-2017 21:45:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A2139A58FD3342498218C8B3B6400FE5', 'admin', '超级管理员', to_date('11-01-2017 21:46:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B10E487605FF463E9B63996CA7ACCB6A', 'admin', '超级管理员', to_date('11-01-2017 21:46:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C1BBDA1D24AF455AA670F3647B24AE00', null, null, to_date('17-02-2017 21:05:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('665023D3CFDF44F7885DAD2B2B3A23A8', 'admin', '超级管理员', to_date('17-02-2017 21:05:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BE1EAFEB225940A7AC8E362B7F3962D3', 'admin', '超级管理员', to_date('17-02-2017 21:05:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '备忘记录', '查询', '0', '/gains/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('40FF97E9C07442B0BD5441C2E23CFD63', 'admin', '超级管理员', to_date('17-02-2017 21:05:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BA1250B343BF4BD4B1132712CE23E6FA', 'admin', '超级管理员', to_date('17-02-2017 21:05:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '问题记录', '查询', '0', '/question/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1D176D38E74241C88DEFBDFCC0238092', 'admin', '超级管理员', to_date('17-02-2017 21:05:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '会员信息', '查询', '0', '/vipInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5939405F13C444A79DD312D4017C0849', 'admin', '超级管理员', to_date('17-02-2017 21:05:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FBD2913F865143AF9759C60BF4D19C44', 'admin', '超级管理员', to_date('17-02-2017 21:05:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '客户定制', '查询', '0', '/advise/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B72DE842AFA840DD8A559F1EEEA2C2F2', 'admin', '超级管理员', to_date('17-02-2017 21:05:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '商品管理', '查询', '0', '/goodInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BFA0EB985E9845FCBAB865FF96AFA519', 'admin', '超级管理员', to_date('17-02-2017 21:06:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '微信回复管理', '查询', '0', '/wxAutoReplay/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E489D920916941DB9A2D59A579EFB55F', 'admin', '超级管理员', to_date('17-02-2017 21:06:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('25652F0F03914BAAAC2E4BE2E341DC24', 'admin', '超级管理员', to_date('17-02-2017 21:06:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '粉丝管理', '查询', '0', '/wxUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4081B698FF63458D88A7D9E96E4B259A', 'admin', '超级管理员', to_date('17-02-2017 21:06:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6AC4FC75B0AD4F5BA11E9776AAE031C8', 'admin', '超级管理员', to_date('17-02-2017 21:06:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '微信菜单管理', '查询', '0', '/wxMenu/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A16040F24E394E0CB49AF2F78CDB1437', 'admin', '超级管理员', to_date('17-02-2017 21:06:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '微信菜单URL', '查询', '0', '/wxMenuUrl/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F18D9AB63905419888A376758FEBA53B', 'admin', '超级管理员', to_date('17-02-2017 21:06:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('67E9099FFAB94BB0BA750104A0D7C565', 'admin', '超级管理员', to_date('17-02-2017 21:06:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
commit;
prompt 200 records committed...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9A9261B2E3894A60AD86282FA0486FEC', 'admin', '超级管理员', to_date('17-02-2017 21:06:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('54F09D574324491D83743D24B7DAA4F9', 'admin', '超级管理员', to_date('17-02-2017 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('284F81A35B4349719904F755FA8B65EC', 'admin', '超级管理员', to_date('17-02-2017 21:07:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('335CDABBAF194836A81C0C47CC170A45', 'admin', '超级管理员', to_date('17-02-2017 21:07:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('06B7B7B9475F4659A2EB4E608F961A42', 'admin', '超级管理员', to_date('17-02-2017 21:07:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9AC63540DA9E40CB842A2487D7739E1F', 'admin', '超级管理员', to_date('17-02-2017 21:07:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8D3B71E5A262467FB4AA38AE7DDFCF1A', 'admin', '超级管理员', to_date('17-02-2017 21:07:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E196C1BA6451493A8A006AEC6FFE7432', 'admin', '超级管理员', to_date('17-02-2017 21:07:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('027E36231BB54677B1A7CA047E3A0E9C', 'admin', '超级管理员', to_date('17-02-2017 21:30:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('206348544BDB4EE59466133F3A581924', 'admin', '超级管理员', to_date('17-02-2017 21:31:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '新增', '0', '/sysRole/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('29BA8091D57049648D47499F11379A92', 'admin', '超级管理员', to_date('17-02-2017 21:31:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('020914CF98CE4D75952D55548123591B', null, null, to_date('17-02-2017 21:57:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AB0FCC8B4F4541858C55139976A151D7', 'U1000021', '测试3', to_date('17-02-2017 21:57:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D8B6A867933C4D5194695DDD35D56582', 'U1000021', '测试3', to_date('17-02-2017 21:57:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AC37B5CBFB2540138A09DE593B68391B', 'U1000021', '测试3', to_date('17-02-2017 21:57:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('87170D2331E3459DB0D22FE90BC70885', 'U1000021', '测试3', to_date('17-02-2017 21:58:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('56EE8AA8E76C429B95F5FA894A8DF88C', 'U1000021', '测试3', to_date('17-02-2017 21:58:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5A88D47A887C43F88299155B8CB0CD05', null, null, to_date('17-02-2017 22:05:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('915757FB0BC041B0B3FF06519EBDA544', 'U1000021', '测试3', to_date('17-02-2017 22:06:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E4B1655A2E5D48BF88F7AC921646E9F2', 'admin', '超级管理员', to_date('08-02-2017 18:26:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8D2B51DF1C5D432AB89642F9AC034393', 'admin', '超级管理员', to_date('08-02-2017 18:26:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5450B88AE82A49CA9EF5706B2AF086CE', 'admin', '超级管理员', to_date('08-02-2017 18:26:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('30213D1BA5B94D2D9D4899B7EC7AD67B', 'admin', '超级管理员', to_date('08-02-2017 18:26:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('52E2BD523DCF4BFAA1C9B9AD05A90526', 'admin', '超级管理员', to_date('08-02-2017 18:28:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A5E4A212BE0D4BE9AC2FE5B01B99BA1D', 'admin', '超级管理员', to_date('08-02-2017 18:31:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D0690C601CA744F08D24A17575F69C1F', 'admin', '超级管理员', to_date('08-02-2017 18:31:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统参数', '编辑', '0', '/sysConf/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DAAD94179D064C089CCAA26B7D833083', 'admin', '超级管理员', to_date('08-02-2017 18:31:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统参数', '查询', '0', '/sysConf/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A5F5DDC7299345A9990BDA72A281AAE4', null, null, to_date('11-01-2017 22:02:33', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9A598216C5464EE39C9FF3E62E46D111', 'admin', '超级管理员', to_date('11-01-2017 23:48:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3442D5AFBB5A4A9D832F61835C87465A', 'admin', '超级管理员', to_date('11-01-2017 23:48:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C65E1AC473424911990442A554C59BE8', 'admin', '超级管理员', to_date('08-02-2017 18:31:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5EA84B87406E4A4C925BCBCE808D3599', null, null, to_date('08-02-2017 18:39:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3951DB080EDA4F48A16E36206BF4232A', null, null, to_date('17-02-2017 20:56:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('157CF08085E848D6959FB9B5593D2785', null, null, to_date('17-02-2017 21:04:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('81707712906443D88D4A0974F6015CED', null, null, to_date('17-02-2017 21:09:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3EBD90C596D84D1D985968169779FEA6', 'admin', '超级管理员', to_date('17-02-2017 21:09:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6A514BABE79848E19C5111EFA7106FF2', 'admin', '超级管理员', to_date('17-02-2017 21:10:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FA7FDA3F43E54A55A2FA41AC5C12B82A', 'admin', '超级管理员', to_date('17-02-2017 21:10:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E7F358888195423D9189CE20C002A3BA', 'admin', '超级管理员', to_date('17-02-2017 21:11:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '新增', '0', '/sysUser/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2DA9627C90DD4E48A69FDA05183765CC', 'admin', '超级管理员', to_date('17-02-2017 21:11:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EA7853B9C7C846E3B73534DC81E4F854', null, null, to_date('17-02-2017 21:24:30', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9930C4C70A1945ED837DE4DE023C6F74', null, null, to_date('17-02-2017 21:30:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D2C3CE02C3774CFA96E63E3E17195FF2', 'admin', '超级管理员', to_date('17-02-2017 21:30:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A958F7340D304513826C5E848019DD30', 'admin', '超级管理员', to_date('17-02-2017 21:32:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8B699870F9964B92B57F5AFBD4543035', 'admin', '超级管理员', to_date('17-02-2017 21:32:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2457C44EFD2F4020A60C75A413807CE1', 'admin', '超级管理员', to_date('17-02-2017 21:32:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('533B40BC88EA4935A7970A3ADB28E871', 'admin', '超级管理员', to_date('17-02-2017 21:33:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9B339DD5C0BD48EF9265D59F69C9CACA', 'admin', '超级管理员', to_date('17-02-2017 21:33:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F2316A0FF2CE4261925A956A4AE316EE', 'admin', '超级管理员', to_date('17-02-2017 21:35:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E41C8C1471F84844984CEA3EB8A41B67', 'admin', '超级管理员', to_date('17-02-2017 21:36:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6C6CB50459B54BECA72C0F84BE440F72', 'admin', '超级管理员', to_date('17-02-2017 21:37:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E14B3A55A731483EA5D41605E5CBCB33', 'admin', '超级管理员', to_date('17-02-2017 21:39:41', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4F20578DE94D44BCA70F28EE226BD52F', 'admin', '超级管理员', to_date('17-02-2017 21:39:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('30BF594B53A64286B0D4237EC1CDF2B4', 'admin', '超级管理员', to_date('17-02-2017 21:39:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4774FC24924E4FBF8970CDAE8AEBFBD0', 'admin', '超级管理员', to_date('17-02-2017 21:40:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BD16E3B2A02F40909D40ED6F1D11C292', 'admin', '超级管理员', to_date('17-02-2017 21:40:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('13B9D835A51142E291E0CF3263F83973', null, null, to_date('17-02-2017 21:49:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C4785D4AFB1C4FA889F63ABB6E946437', null, null, to_date('17-02-2017 21:57:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('19ED6203782A4D4591C6087701E861D6', null, null, to_date('17-02-2017 22:05:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A6C5F6148F2C499FB5852EAEB6DC8B57', 'U1000021', '测试3', to_date('17-02-2017 22:06:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8CAD91532650430485BE7DB8BFD4B290', 'U1000021', '测试3', to_date('17-02-2017 22:06:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AC19911E5DC143AD815A6E98BDF2261C', null, null, to_date('17-02-2017 22:06:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('902498C729F04820831A8EF6B9CF0CC8', 'admin', '超级管理员', to_date('17-02-2017 22:06:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('79D90C5FA3A34F59BA4F821476C1B1A2', 'admin', '超级管理员', to_date('17-02-2017 22:06:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F31F3585EA58493E9C6BF80DB68A8F26', 'admin', '超级管理员', to_date('17-02-2017 22:06:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('69AA2495FE3A440E9C03BC60CA7207D0', null, null, to_date('17-02-2017 22:18:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('293CDE889D83469EA30AB54D09276582', 'admin', '超级管理员', to_date('17-02-2017 22:18:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('89AF1FCBB0B54A6C99ABBBDB65374A56', 'admin', '超级管理员', to_date('17-02-2017 22:18:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FD159F9307CA4E9A92AFC8F193365E9C', 'admin', '超级管理员', to_date('17-02-2017 22:18:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1FF80878551741159154DD2B9536525B', 'admin', '超级管理员', to_date('17-02-2017 22:19:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('59CABC2493E94BB79E3F029AC30EBDB8', 'admin', '超级管理员', to_date('17-02-2017 22:19:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1217B291AEAD437D84205D353BC9D436', 'admin', '超级管理员', to_date('17-02-2017 22:19:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('78BBFA3EC5E2406885256BD12202998E', 'admin', '超级管理员', to_date('17-02-2017 22:19:16', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('015BEB4F55634D23924B871D8885FD98', 'admin', '超级管理员', to_date('17-02-2017 22:34:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3F23EB8FA97D4818B832D907713BEE27', 'admin', '超级管理员', to_date('17-02-2017 22:52:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8AE5AE55787C4683B1A411858CB52F14', null, null, to_date('17-02-2017 22:52:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F390788895454130BB2AAAD346EEAC03', 'admin', '超级管理员', to_date('17-02-2017 23:30:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2D925E29045B4ECCA41EA13A48765155', 'admin', '超级管理员', to_date('17-02-2017 23:30:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9FD02EA6C4FA463AB27185FCC5419A10', 'admin', '超级管理员', to_date('17-02-2017 23:30:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7A7ECE03352F40619D1E0E886F706405', 'admin', '超级管理员', to_date('17-02-2017 23:30:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('55A3C278D9954BD4ACDF731693574BD6', 'admin', '超级管理员', to_date('17-02-2017 23:30:47', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3D38A5C8785748BDA383B2EBBCF2B00C', 'admin', '超级管理员', to_date('17-02-2017 23:37:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AEEFEC2E916F46F4B7A7EA2EB0194DEC', 'admin', '超级管理员', to_date('17-02-2017 23:37:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2ED498C102E147D7B132BF3B197248D0', 'admin', '超级管理员', to_date('17-02-2017 23:37:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('72277DFAF2AD46C9A5C11045DB4DBF35', 'admin', '超级管理员', to_date('17-02-2017 23:37:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8F7A17DCE681433EB0B632F88D457C2E', 'admin', '超级管理员', to_date('17-02-2017 23:37:48', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6AC9D6279BA3484A88451BA54CE3963F', 'admin', '超级管理员', to_date('17-02-2017 23:37:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('731DA5A0AE154CFE945E18FC45CD7D1F', 'admin', '超级管理员', to_date('17-02-2017 23:37:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1C4D8ED4B4154638801A066225DC3F4F', null, null, to_date('13-01-2017 22:23:00', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C5C8A340F8174A0D8972D0FA13A075BC', null, null, to_date('13-01-2017 22:23:00', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F4A76D39650B4BA98E062BC50BC1CB16', 'admin', '超级管理员', to_date('18-02-2017 11:19:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('75404A0CD11248248665CDD23890E50B', 'admin', '超级管理员', to_date('18-02-2017 11:20:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B7C1CE78CAA943ECBE0E9ACF268D30EA', 'admin', '超级管理员', to_date('18-02-2017 11:24:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('43913ECDF2C44C93AB07529B7683A56D', 'admin', '超级管理员', to_date('18-02-2017 11:24:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5788DD7D29BD4A2E8618626586EC774C', 'admin', '超级管理员', to_date('18-02-2017 11:24:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D9D2F5A78277473FB3AC09963F3E69A8', null, null, to_date('18-02-2017 11:25:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ACD4EA16C6FE40159F9D18E5AA24570C', 'admin', '超级管理员', to_date('18-02-2017 11:26:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A9A0845AFA68480D86361AB98ABA317D', 'admin', '超级管理员', to_date('18-02-2017 11:26:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('10A2FCB63CE04EB18FCAADEF51C30A37', 'admin', '超级管理员', to_date('18-02-2017 11:26:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('173823F4106B40CF8B492459D9E4BD6D', null, null, to_date('18-02-2017 11:30:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
commit;
prompt 300 records committed...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2819CCCAA8934D638D653636803FC4AD', 'admin', '超级管理员', to_date('18-02-2017 11:30:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8D8785CE5579407DB22881663D83EE00', null, null, to_date('18-02-2017 11:32:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B9FD1BF46FCD4C0AB297ECAC95D9B5CB', null, null, to_date('18-02-2017 11:38:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('58A5423BA0534EA5963DAD71EB10A09F', 'admin', '超级管理员', to_date('18-02-2017 11:38:21', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6BB3ADDBC6C546AE8AE7D7DB09686B15', 'admin', '超级管理员', to_date('18-02-2017 11:38:26', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '新增', '0', '/testCode/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A6AC315EBA074630B10CF75382B8DBBE', 'admin', '超级管理员', to_date('18-02-2017 11:38:26', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('12B5C34F01E04EF788BF571B2627AB6C', 'admin', '超级管理员', to_date('18-02-2017 11:38:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '新增', '0', '/testCode/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F5975A99174648BC86A593C8967C25EB', 'admin', '超级管理员', to_date('18-02-2017 11:38:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D68FD4A903FE48E392FA136ADA014D78', 'admin', '超级管理员', to_date('18-02-2017 11:38:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '删除', '0', '/testCode/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B8F7D8687D064D3EB7442A1F51060801', 'admin', '超级管理员', to_date('18-02-2017 11:44:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日志参数', '查询', '0', '/sysLogParam/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A8BD73081DFD405E96E93590DAE496C9', 'admin', '超级管理员', to_date('18-02-2017 11:44:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2F5347CDF0694DE58F5264DB34602F69', 'admin', '超级管理员', to_date('18-02-2017 11:44:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('17F4B6481E4D4CB28141F68A8EBA68FB', 'admin', '超级管理员', to_date('18-02-2017 11:44:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('97AC4EBA1C024AFE810573CCCEDBB762', 'admin', '超级管理员', to_date('18-02-2017 11:44:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B594209300904FB186D11146DB2A120F', 'admin', '超级管理员', to_date('18-02-2017 11:44:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A80C6F69FD314F97A46C1ECE9C56D17A', 'admin', '超级管理员', to_date('18-02-2017 11:44:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('13A3E10CF5EA4CD4B4700BAF4DCCC9FC', 'admin', '超级管理员', to_date('18-02-2017 11:44:56', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7E950719E27467EB283350CD7EAED9D', 'admin', '超级管理员', to_date('18-02-2017 11:44:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('573C90E6879D4C5EBA8B9026D118F941', 'admin', '超级管理员', to_date('18-02-2017 11:44:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FC86968FB6D142D1AF604B045AE11E1E', 'admin', '超级管理员', to_date('18-02-2017 11:44:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CC265B1E590448CBBC8FF195633DBE40', 'admin', '超级管理员', to_date('18-02-2017 11:44:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1E7E13B01D8645EFB70D945A02D8DDCA', 'admin', '超级管理员', to_date('18-02-2017 11:44:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6CD47640BFB24CD3976AED2FE9C3827B', 'admin', '超级管理员', to_date('18-02-2017 11:44:58', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C0DD3C63DF6D469DAD0AD56779C2DA3E', 'U1000023', '测试1234', to_date('17-02-2017 23:43:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B776B4A91EC04F419FAEAE9BA1D508A9', null, null, to_date('18-02-2017 11:15:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E9E0D026A0AF493C9A3DCB32CF0FF006', 'admin', '超级管理员', to_date('18-02-2017 11:38:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '删除', '0', '/testCode/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('212F06E05983412BBFE9300B515CFF54', 'admin', '超级管理员', to_date('18-02-2017 11:38:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ACC4A52A41B04AFDAA167D974D0F7392', 'admin', '超级管理员', to_date('18-02-2017 11:38:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '编辑', '0', '/testCode/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('74C9328C17084B1DA0E6584B5CC8A6B6', 'admin', '超级管理员', to_date('18-02-2017 11:38:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5CD48BAA298149788D2633BB2C046620', 'admin', '超级管理员', to_date('18-02-2017 11:38:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '测试代码', '查询', '0', '/testCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C819636E890C4167A1C5E227F682CF37', 'U1000023', '测试1234', to_date('17-02-2017 23:42:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E3B66014E32C415F9A20687FD6B6CE3B', 'U1000023', '测试1234', to_date('17-02-2017 23:42:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('50BC7619D10347A1B8D9A35AF6F04EE8', 'admin', '超级管理员', to_date('08-02-2017 18:26:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('576435E6DEEA44F39621F7EF2334D1FF', 'U1000008', 'cjmei', to_date('08-02-2017 18:39:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '痕迹', '登录', '0', '/login', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C22C4CF39A6445F59434FC1F8B134FA3', 'U1000008', 'cjmei', to_date('08-02-2017 18:39:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('066D4C94C5B945E9A498D6BBDC5E889C', 'U1000008', 'cjmei', to_date('08-02-2017 18:39:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('618BB8A097CF4C20BDC2459CE10FF18F', 'U1000008', 'cjmei', to_date('08-02-2017 18:39:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A30709BA5B19455EBFAD0004FF31016C', 'U1000008', 'cjmei', to_date('08-02-2017 18:39:48', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('534112255008431BA8AE2C1E3E405D5E', null, null, to_date('09-02-2017 07:32:25', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6EC0C2E80FA24531A990FA9101F4701A', null, null, to_date('09-02-2017 07:32:25', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E0BFD70A77EC49BE8658ED7C182DEF52', null, null, to_date('09-02-2017 07:32:26', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0C800DFDF1604EC5A4F31C751AC2E59F', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:39', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '痕迹', '登录', '0', '/login', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B200F35D5975429BA84232A089D1B3C1', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:39', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9C2214200FD540A480FCE2CBE8088253', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:39', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('76CBDB139C3745F9900F83D54BCC8A89', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:40', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9A3F34D0F0F14EDBA0886486D3E3F6D6', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:40', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '详情', '0', '/diary/findDiaryById', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('67C34D397F9C425D907CD14131E17685', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:42', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '详情', '0', '/diary/findDiaryById', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6808DF59918F4742A198199105B0487A', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:44', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3265A603F2984DAAB8EA891195C2B9E4', 'admin', '超级管理员', to_date('18-02-2017 11:44:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3C18AEF5283E4730B388BAD2053CADD4', 'admin', '超级管理员', to_date('18-02-2017 11:44:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7BC8861C10064C7E94C93D41EDC20FF5', 'admin', '超级管理员', to_date('18-02-2017 11:44:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('368E3A7C24694505BC707F22F97E2A8D', 'admin', '超级管理员', to_date('18-02-2017 11:45:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('034B54B525134C0C8B4570742056F62E', 'admin', '超级管理员', to_date('18-02-2017 11:45:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D30F0D88603B497BB5A3412F597AFADF', 'admin', '超级管理员', to_date('18-02-2017 11:45:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('990261AD563D495881DACA5348CF2BDB', 'admin', '超级管理员', to_date('18-02-2017 11:45:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('68C7656F501048A5814BFA3DC6258E23', 'admin', '超级管理员', to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('83524EC0B4DE4470A54B37C7E3DDBCA9', 'admin', '超级管理员', to_date('18-02-2017 11:42:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3882DBDC503943F6880F4D0B3EDD3EE3', 'admin', '超级管理员', to_date('18-02-2017 11:44:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6FBDB3B1D6894268ADC7E36D61712E4F', 'admin', '超级管理员', to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8DF36762F87A49A6914B6C5E0422571F', 'admin', '超级管理员', to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3B157CFE0DCB403CA7E3FF61803CB963', 'admin', '超级管理员', to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3E25688FFFB04F01A795F9C5E6F6D4F4', 'admin', '超级管理员', to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7006F1650DD40A3AEF09015BD241630', 'admin', '超级管理员', to_date('18-02-2017 11:45:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('78F78104142B48D0A776E73549DE3B39', 'admin', '超级管理员', to_date('18-02-2017 11:45:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8E0A3C486DCC4CB0A36BAE22D462A332', 'admin', '超级管理员', to_date('18-02-2017 11:45:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D99FB00B1A1546C2BB3AED65300F83B4', 'admin', '超级管理员', to_date('18-02-2017 11:45:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('132003AAF7604F788C48B01EBA71C3A0', 'admin', '超级管理员', to_date('18-02-2017 11:45:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EF783F4E57D84D1AA6D46437E5DA49DB', 'admin', '超级管理员', to_date('18-02-2017 11:45:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('64549B2782724C39BAB9393385C33347', 'admin', '超级管理员', to_date('18-02-2017 11:45:03', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7029DCF559484D69B06A93013B65E03A', 'admin', '超级管理员', to_date('18-02-2017 11:45:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4D9A1C7E480C440FB143D5188DF484F9', 'admin', '超级管理员', to_date('18-02-2017 11:45:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('64D09EC466974A26BBC8E2682F9092A5', 'admin', '超级管理员', to_date('18-02-2017 11:45:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('70477E8CFCEA48CDBF52304540F31677', 'admin', '超级管理员', to_date('18-02-2017 11:45:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6072E027C1C34228A58010A7120F82BA', 'admin', '超级管理员', to_date('18-02-2017 11:45:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2DC51007DCCD4BD084D5AFBF7F5EF4F0', 'admin', '超级管理员', to_date('18-02-2017 11:45:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AC227E55CA8A4499BDE66B6EC4BF74E8', 'admin', '超级管理员', to_date('18-02-2017 11:45:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8C3AAA27F10B4E5FBDD9CB0BD60B4A7E', 'admin', '超级管理员', to_date('18-02-2017 11:45:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0094EE923AD84C198C6D22A19E91E10C', 'admin', '超级管理员', to_date('18-02-2017 11:45:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5FC472A168D84D94B8F47346C9BE6EFD', 'admin', '超级管理员', to_date('18-02-2017 11:45:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('23E55BB8F5D748728FB1FF8F240C4388', 'admin', '超级管理员', to_date('18-02-2017 11:45:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('29DFB458E2F04F18B797A4793C218501', 'admin', '超级管理员', to_date('18-02-2017 11:45:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1D0BF4D8F5F34E31927745B82611AADE', 'admin', '超级管理员', to_date('18-02-2017 11:45:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FAE5B55F9DC24A2D8F52A143E4BDABD2', 'admin', '超级管理员', to_date('18-02-2017 11:45:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('414B4A8BC5B4458CBD5FC8B147DEFEB0', 'admin', '超级管理员', to_date('18-02-2017 11:45:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DCFD05623A5E4C4EB7B88641A04B854C', 'admin', '超级管理员', to_date('18-02-2017 11:45:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D27BFC44265148269F799F074D6C3D99', 'admin', '超级管理员', to_date('18-02-2017 11:45:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FC2CABC8C5384B8C80B9409B6D7D779B', 'admin', '超级管理员', to_date('18-02-2017 11:45:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('05337D9D5DA44A3DAD52FB6B5ECB7C74', 'admin', '超级管理员', to_date('18-02-2017 11:45:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('773D132CF8C34E4D9E5A478422067108', 'admin', '超级管理员', to_date('18-02-2017 11:45:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DA4050B4BCD34D849CDCCA413B415BF4', 'admin', '超级管理员', to_date('18-02-2017 11:45:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2291B1E0ABCF4235B359F8A427D2ABB7', 'admin', '超级管理员', to_date('18-02-2017 11:45:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '系统日志', '查询', '0', '/sysLog/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('764F9B2E52484849AF1EA2080CC8C0BA', null, null, to_date('21-02-2017 21:18:22', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/vipInfo/findVipInfoById', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('210FA15F60D746D39920A01AD0A5B473', null, null, to_date('21-02-2017 21:18:24', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9551919331ED4F639E06831766437583', 'admin', '超级管理员', to_date('17-02-2017 22:34:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EEBB8C793DA5470B906D242DF5C1112A', 'admin', '超级管理员', to_date('17-02-2017 22:34:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6DEC103830A8480CB099A77849CC9F04', 'admin', '超级管理员', to_date('17-02-2017 22:34:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('4A918814FDE64198ACDF95A003C5741B', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:41', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '痕迹', '登录', '0', '/login', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F2A06C2E207E4B2DAF4C1167CE84FC06', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:41', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5A6FAD48FE2F49B5842B3714874FE8A3', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:42', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AE03D4605063439E94C5C177430789E3', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:44', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getUUID', null, 2);
commit;
prompt 400 records committed...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8032FC557BD446B4B8CE1B5113F181B7', 'U1000008', 'cjmei', to_date('21-02-2017 21:18:49', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '添加', '0', '/diary/save', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B275AE98D69F4CF9AD16E8C41657CDC0', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:36', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '添加', '0', '/diary/save', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('259D8B65EDAE4FF49CCDB2E9AE937319', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:48', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '添加', '0', '/diary/save', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('58FC921B7B1E48F3845EE716A7E9A517', 'U1000008', 'cjmei', to_date('21-02-2017 21:19:53', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '详情', '0', '/diary/findDiaryById', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('92ED569AC2CB488A97E87939FCA2774F', 'U1000008', 'cjmei', to_date('21-02-2017 21:20:09', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '修改', '0', '/diary/update', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7BA6F6E1EB634130B3FCB583756AD8D5', 'U1000008', 'cjmei', to_date('21-02-2017 21:20:13', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0CFD9CCE9E7B47F881D2E0A339EB183C', 'U1000008', 'cjmei', to_date('21-02-2017 21:20:13', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6C0E0C3B7C004759B1885411D3E20B9C', 'admin', '超级管理员', to_date('11-01-2017 23:49:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A78CAFAC9CAB4489BF7EC50E1C81BADE', 'admin', '超级管理员', to_date('11-01-2017 23:49:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7C9C8987E114FB7AF7171430FB6C6A5', 'admin', '超级管理员', to_date('11-01-2017 23:50:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('28824094A4664730BF8D0BDEC4FD2E4E', 'admin', '超级管理员', to_date('11-01-2017 23:51:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '1', '/transaction/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C7CF8B2C48ED43D4BC1B8E70A6DFE372', 'admin', '超级管理员', to_date('11-01-2017 23:51:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '0', '/transaction/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B690A3EC5D7A45779E312904D8BF528B', 'admin', '超级管理员', to_date('11-01-2017 23:51:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DB994CCE29C34AAEBFFA5D098970D0AB', 'admin', '超级管理员', to_date('11-01-2017 23:51:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '编辑', '0', '/transaction/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('908068AC3FFD47C9B2C58B4A62E4C507', 'admin', '超级管理员', to_date('11-01-2017 23:51:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CA7861F817664E30BB9B64B0F8763293', 'admin', '超级管理员', to_date('12-01-2017 00:00:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D6B1070E63964AC1BFEE70B7F5636B2C', 'admin', '超级管理员', to_date('12-01-2017 00:01:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CAE6F957835249E59750C3EFCD166CD7', 'admin', '超级管理员', to_date('12-01-2017 00:01:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('74941A7F87654317AC60C2C94CB48163', 'admin', '超级管理员', to_date('12-01-2017 00:02:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F50C08C5752541FDBB3A156D9AF8C4F1', 'admin', '超级管理员', to_date('12-01-2017 00:03:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('85A33FA9B81B4BD9A6458547BDF92AA5', 'admin', '超级管理员', to_date('12-01-2017 00:03:13', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('20DC21091C9F4CDB9AC99026A79E1B0D', 'admin', '超级管理员', to_date('12-01-2017 00:03:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('55278FC1906E4411AA5EBC77D1CAFCA9', 'admin', '超级管理员', to_date('12-01-2017 00:04:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F4FA8751EB5544E4A9F695D7B4B66723', 'admin', '超级管理员', to_date('12-01-2017 00:04:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9075FE35B95D497BB5BE4A46344EB7CA', 'admin', '超级管理员', to_date('12-01-2017 00:05:40', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ADD50AF45049414DA6BF1811503E00C6', 'admin', '超级管理员', to_date('12-01-2017 00:05:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6CB9656951244A40979CBDAEE1F6CDEE', 'admin', '超级管理员', to_date('12-01-2017 00:05:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A8E534B61C3240B29CF4A137684FAB23', 'admin', '超级管理员', to_date('12-01-2017 00:05:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D5BA90E7FDA54CCC995B6DFA06A6AECE', 'admin', '超级管理员', to_date('12-01-2017 00:06:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('33EB986B973E41139E8C0A5903723683', 'admin', '超级管理员', to_date('12-01-2017 00:06:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('57941C2DE0854DE290C901FAF73D5AE1', 'admin', '超级管理员', to_date('12-01-2017 00:06:26', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C1F7F632239849DCAAC7BD84C1AAC355', 'admin', '超级管理员', to_date('12-01-2017 00:06:47', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '0', '/transaction/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ADC7F6DCD63F4D3F9055D4036C786D29', 'admin', '超级管理员', to_date('12-01-2017 00:06:47', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A46D4AE459754D838373C549962BD7DD', 'admin', '超级管理员', to_date('12-01-2017 00:15:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('244BCD8D472F478BA3BBCA0020A17E25', 'admin', '超级管理员', to_date('12-01-2017 00:16:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C62F768EE9E94DC080020906A1911AFF', 'admin', '超级管理员', to_date('12-01-2017 00:16:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('06904BDE937042889FF4E703BF63572D', 'admin', '超级管理员', to_date('12-01-2017 00:16:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BBD726A6524F4B5DB854F5889625AE71', 'admin', '超级管理员', to_date('12-01-2017 00:17:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7C5F62E1EEBF4FF4B36089E533E06788', 'admin', '超级管理员', to_date('12-01-2017 00:17:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BCC6A1EB515F4207BBA2491BC11CEE25', 'admin', '超级管理员', to_date('12-01-2017 00:21:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('032037761CB84CC0892C723742778795', 'admin', '超级管理员', to_date('12-01-2017 00:21:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E6F9B60F71B2497C924B1D52DE1E8CD5', 'admin', '超级管理员', to_date('12-01-2017 00:21:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A1683B348B6E4D0D989DB79801EB4F33', 'admin', '超级管理员', to_date('12-01-2017 00:21:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1535164E19D948299A1564AE39D0B930', 'admin', '超级管理员', to_date('12-01-2017 00:23:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('12AE20A655F5438F8ED9C5F16A6E73D6', 'admin', '超级管理员', to_date('11-01-2017 23:48:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('51936143C2544A758E6E09585EAD36C1', 'admin', '超级管理员', to_date('11-01-2017 23:49:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9A35AE643BEE47D89923A57669084CBF', 'admin', '超级管理员', to_date('12-01-2017 00:23:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9D8813385FC247FA9B75B58FBB74D07F', 'admin', '超级管理员', to_date('12-01-2017 00:23:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '编辑', '0', '/transaction/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B68FA50D2A934B2EBA1379A1CADDA976', 'admin', '超级管理员', to_date('12-01-2017 00:23:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B62F45E78B4542AC93137A2B29770C92', null, null, to_date('13-01-2017 22:23:00', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1114298DFFCF479494919B7961AE7AE4', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3A170942CBFD4E6FB001493D3D4054E4', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EDC7AD36EFA146509B69B38ED42DC522', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/question/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('ED39EB9F0F764DEE92E01811C0F945C7', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/gains/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C5A7BE10EAED4823A636E3C313F54978', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:16', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('752B64E882CB4D15B6183F62150EB8AF', null, null, to_date('17-02-2017 21:24:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5A37DE990BBF4AA9A49168D72BA33010', 'admin', '超级管理员', to_date('17-02-2017 21:24:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('513F0EE4144C4E88BE87B7253B231051', null, null, to_date('17-02-2017 21:49:22', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('188C7B3FFE9945C3972E44C0D87221E2', 'admin', '超级管理员', to_date('17-02-2017 21:49:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('96BD9922CD6244E6BD03E3170F6995D6', 'admin', '超级管理员', to_date('17-02-2017 21:49:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BF4E910861474C838861313305E91B98', 'admin', '超级管理员', to_date('17-02-2017 21:50:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '新增', '0', '/orgInfo/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('12C3777928FE47979FA5BCCF73F1DCCF', 'admin', '超级管理员', to_date('17-02-2017 21:50:15', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D8CE1995153046D2AA71747390C3334B', 'admin', '超级管理员', to_date('17-02-2017 21:50:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('464CFF3A1F0243C6BBA76A600AD006CD', 'admin', '超级管理员', to_date('17-02-2017 21:50:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('182059E09DFA443FAD8CEE8495526FDE', 'admin', '超级管理员', to_date('17-02-2017 21:50:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('164529D94E8E41ED93F83CBB525AA280', 'admin', '超级管理员', to_date('17-02-2017 21:51:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '删除', '0', '/sysRole/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E2569624753E4127BAE463CC491AC4D5', 'admin', '超级管理员', to_date('17-02-2017 21:51:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('064F01F6D61247849AAF6452FFE4AE5F', 'admin', '超级管理员', to_date('17-02-2017 21:51:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '新增', '0', '/sysRole/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7F071D8D1DCD40F2A958B83EF622DFB5', 'admin', '超级管理员', to_date('17-02-2017 21:51:36', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FC3F906A66514A649F18D722AEDD9557', 'admin', '超级管理员', to_date('17-02-2017 21:51:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '功能管理', '0', '/sysRole/funclist', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8224B8AFCA0C4E6FB70A94F5B5EF7FDF', 'admin', '超级管理员', to_date('17-02-2017 21:52:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('05A300F683AA4145879DFBF748059CF1', 'admin', '超级管理员', to_date('17-02-2017 21:52:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DD6D78711CA045FA8C00048E43182EC1', 'admin', '超级管理员', to_date('17-02-2017 21:52:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2A37885F98C045FBAF9C4480C6A64E7D', 'admin', '超级管理员', to_date('17-02-2017 21:53:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '新增', '0', '/sysUser/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6FFCA0ED14D9416A91D0B734B9E13B9F', 'admin', '超级管理员', to_date('17-02-2017 21:53:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('044BCEA3A8574E62A42005530175A221', null, null, to_date('17-02-2017 21:53:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('92C530FA1D334AA2BE5DAACD7FE7B1EA', null, null, to_date('17-02-2017 21:53:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5198D0ECC3FF4FB78F1751FE8C0BA9E3', 'U1000021', '测试3', to_date('17-02-2017 21:53:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '组织管理', '查询', '0', '/orgInfo/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7B86951F24E44036B87DAD94DB82FEE9', 'U1000021', '测试3', to_date('17-02-2017 21:53:28', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公司管理', '查询', '0', '/orgInfo/framelist', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('48F906A359814741B0B719C4D3081686', 'U1000021', '测试3', to_date('17-02-2017 21:53:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9FD03284C38443DDB6588FF82BC6A840', 'U1000021', '测试3', to_date('17-02-2017 21:53:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户类型', '查询', '0', '/sysRole/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AC20327C9AA34AB08D14B116D297A0B4', 'U1000021', '测试3', to_date('17-02-2017 21:53:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'Marks', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FF8A35235DA04662B935CA6E0B3D26D3', 'admin', '超级管理员', to_date('17-02-2017 22:39:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('DDAFE54192D94E7AA1CFF4BD2B677747', null, null, to_date('17-02-2017 20:39:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('809F268CED6049099396546F365A8CDD', 'U1000008', 'cjmei', to_date('17-02-2017 20:39:10', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '痕迹', '登录', '0', '/login', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('508521D30AA341B3BD0751347B09C260', null, null, to_date('11-01-2017 22:06:33', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EC755934C46A43C690D942201B26F388', null, null, to_date('11-01-2017 22:06:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AFA4DD20714847ECB46D6C969B0C35EC', null, null, to_date('11-01-2017 22:06:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EEE3E7004E2843988E49EFB10FF357E7', null, null, to_date('11-01-2017 22:06:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8BAEE9DCA06743C88BF543076D7B7B33', null, null, to_date('11-01-2017 22:08:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C30DD26EE6CB4E1FAB0EB6742A03487D', null, null, to_date('11-01-2017 22:08:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('023DA9A67A7243C0AF3370ACD3EBA054', null, null, to_date('18-02-2017 11:32:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E4269BE792E745769ED4CED17585E9EA', null, null, to_date('18-02-2017 11:41:20', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/login', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('90CCD5C628C04345AF9ADAF3EDD406BA', null, null, to_date('21-02-2017 21:18:22', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('125A5180078E41AFB7D4372FC72723FC', null, null, to_date('21-02-2017 21:18:22', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.105', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8EA03207B72049E5B92644185838BFA7', null, null, to_date('11-01-2017 22:02:33', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', '日记', '查询', '0', '/diary/list', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C8F677F3BFBA4EE2928C774FF84CEE55', null, null, to_date('11-01-2017 22:02:33', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', 'Marks', 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E3816A7013CE496CA418CA1699CC4710', 'admin', '超级管理员', to_date('11-01-2017 20:18:54', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B143132897E34981A6AC426F1FFD35A6', 'admin', '超级管理员', to_date('11-01-2017 20:20:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '商品管理', '查询', '0', '/goodInfo/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('605985649BCC496E957623270FE5240C', 'admin', '超级管理员', to_date('11-01-2017 20:22:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
commit;
prompt 500 records committed...
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FD9EB341590B45529F1EF395EFEC6052', 'admin', '超级管理员', to_date('11-01-2017 20:26:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('918719E78FFD4390829EADE2A03A5928', 'admin', '超级管理员', to_date('11-01-2017 20:26:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1CEABE05E9B945B2873B0D4225D3A606', 'admin', '超级管理员', to_date('11-01-2017 20:28:06', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('180F0BEC4EF4462C93AE71C8202969D7', 'admin', '超级管理员', to_date('11-01-2017 20:31:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('118A0AA84E3A42C7BC068A103BEA5F69', 'admin', '超级管理员', to_date('11-01-2017 20:36:27', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FE1A5847781A49339AAC2BF51AEEFC79', 'admin', '超级管理员', to_date('11-01-2017 20:36:35', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('FF114BACF28341E485776FAF802BBBA0', 'admin', '超级管理员', to_date('11-01-2017 20:37:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '新增', '0', '/newsItem/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0A085BB4006542A5B68F174E14B2E3E0', 'admin', '超级管理员', to_date('11-01-2017 20:37:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D7E9BB126F7346ADACD40B93B1DF5DE0', 'admin', '超级管理员', to_date('11-01-2017 20:37:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CFC76A9D3DFE4D8A9CFA17ABE366DEDC', 'admin', '超级管理员', to_date('11-01-2017 20:37:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D809F87214F7499EBD19A4CB32080D9F', 'admin', '超级管理员', to_date('11-01-2017 20:37:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3DBD4E08A7E844868D96A26FEF0AC3C7', 'admin', '超级管理员', to_date('11-01-2017 20:37:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('6C543F44EF194A7BB6D36C1DF05E0740', 'admin', '超级管理员', to_date('11-01-2017 20:37:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B05E45032C954398AAEE9F75DBE39B01', 'admin', '超级管理员', to_date('11-01-2017 20:37:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('BCE8AA7D41994C998DB7209C9FF9D305', 'admin', '超级管理员', to_date('11-01-2017 20:38:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('88C947E8535F41A2879164F98017E1A9', 'admin', '超级管理员', to_date('11-01-2017 20:45:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8FA4C83D6EEA4DA2B7DD760ABF3ABC97', 'admin', '超级管理员', to_date('11-01-2017 20:47:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '新增', '0', '/wxAccount/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F26EF93035B645BCA0BAAF76870021B3', 'admin', '超级管理员', to_date('11-01-2017 20:47:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C62B54CEBCE84427A7B85DE6F1B74FE8', 'admin', '超级管理员', to_date('11-01-2017 20:47:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '删除', '0', '/wxAccount/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('480A099895D144B38C891D6E23EAB433', 'admin', '超级管理员', to_date('11-01-2017 20:47:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('537E738B15B64946ACEA2485B41D2C40', 'admin', '超级管理员', to_date('11-01-2017 20:51:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '新增', '0', '/wxAccount/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E0ADAE79818D4A2C8830A4699ED3FD16', 'admin', '超级管理员', to_date('11-01-2017 20:51:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2BB1D09075E0472AA461DCAAB32E5407', 'admin', '超级管理员', to_date('11-01-2017 20:58:48', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '粉丝管理', '查询', '0', '/wxUser/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9F21B0B464D74622B70683953483E319', 'admin', '超级管理员', to_date('11-01-2017 20:59:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '新增', '0', '/newsItem/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('61FFB9E93BC94DABBDDD6DB7A3760B8E', 'admin', '超级管理员', to_date('11-01-2017 20:59:11', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('1AD024EF4BA34E3E891A57E10FE90B09', 'admin', '超级管理员', to_date('11-01-2017 21:00:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CD29748241034527845BCBBEA3CD5DAB', 'admin', '超级管理员', to_date('11-01-2017 21:00:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('CDA445F1222B4961ACB5036ED6DCD732', 'admin', '超级管理员', to_date('11-01-2017 21:01:00', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('56C7D42973C54E13B7FC8CF3ECC8CA8E', 'admin', '超级管理员', to_date('11-01-2017 21:02:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '回复图文管理', '查询', '0', '/newsItem/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E7AC0194B5164C7389A6A941B0B1617D', 'admin', '超级管理员', to_date('11-01-2017 21:06:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '删除', '0', '/wxAccount/delete', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('3C1B1FEB476D42758EC00512B192B66E', 'admin', '超级管理员', to_date('11-01-2017 21:06:57', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('A51AB846D29B40B89A294622CEDBAF8D', 'admin', '超级管理员', to_date('11-01-2017 21:07:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '编辑', '0', '/wxAccount/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('10A7308636C949B5B0A85D0ED9A6DF0D', 'admin', '超级管理员', to_date('11-01-2017 21:07:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8F7B2A5D83074882924AB7ABB0A19372', 'admin', '超级管理员', to_date('11-01-2017 21:17:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('68A4C72465B04D5194521AF0CD6E10E2', 'admin', '超级管理员', to_date('11-01-2017 21:17:39', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('961176CCEE4D4B9694E8545FEC552E47', 'admin', '超级管理员', to_date('11-01-2017 21:18:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('27278C66D02F4FFBBFCB110F2200A1CF', 'admin', '超级管理员', to_date('11-01-2017 21:18:37', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('89993EF8EACF405A91DD841FCB82CFAE', 'admin', '超级管理员', to_date('11-01-2017 21:19:02', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('95691C1488014810912984C99C4AA78A', 'admin', '超级管理员', to_date('11-01-2017 21:19:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7FBE2C9B55EA4BCEB64689349E809B32', 'admin', '超级管理员', to_date('11-01-2017 21:19:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D2DB49557B50497A8D0E255A1CE0C8C1', 'admin', '超级管理员', to_date('11-01-2017 21:19:24', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('759C94C7BA0A471AA950CE17DC1DA68C', 'admin', '超级管理员', to_date('11-01-2017 21:19:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('B7797AF1F93347B3B48782018AC49BB0', 'admin', '超级管理员', to_date('11-01-2017 21:19:31', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生产文档', '0', '/autoCode/autocodeIntroFile', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('7176FB3D569245849D0BDA84F525AB97', 'admin', '超级管理员', to_date('11-01-2017 21:19:44', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C594E1CB10AE4FDB8D627B7AA8316AD7', 'admin', '超级管理员', to_date('11-01-2017 21:19:50', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '客户定制', '查询', '0', '/advise/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EE057702FA114CD88439C5D29E0646F3', 'admin', '超级管理员', to_date('11-01-2017 21:19:52', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5CABC3640D1B452B9D1535660818B91A', 'admin', '超级管理员', to_date('11-01-2017 21:20:32', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('C184CE8AE02D4055A9A31DB52DD6DBAF', 'admin', '超级管理员', to_date('11-01-2017 21:21:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E709B3D0876149728BDCE10614B05E37', 'admin', '超级管理员', to_date('11-01-2017 21:38:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '新增', '0', '/autoCode/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('97090A5EAD0346789CD5EA9C094B028F', 'admin', '超级管理员', to_date('11-01-2017 21:38:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('325E14BC5D2B419D8617102FAED5E067', 'admin', '超级管理员', to_date('11-01-2017 20:18:45', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('30571B16EA164F39A16E67C98F7BF856', 'admin', '超级管理员', to_date('11-01-2017 20:18:51', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '公众号管理', '查询', '0', '/wxAccount/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('82F7986BC7F040AB977E55F8548C0DDA', 'admin', '超级管理员', to_date('11-01-2017 21:46:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D4347EF6F0DC4CEDA146D9E9A12DE994', 'admin', '超级管理员', to_date('11-01-2017 21:46:49', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('41FC20653F2842579DA2B9AC8FA333F0', 'admin', '超级管理员', to_date('11-01-2017 21:47:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E2908D15959241F1B01D53F324124902', 'admin', '超级管理员', to_date('11-01-2017 21:47:17', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8DA2EAAFEBF74247B56F697C3F84B1AB', 'admin', '超级管理员', to_date('11-01-2017 21:47:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F664AC8471EB400DB202F203142C8B75', 'admin', '超级管理员', to_date('11-01-2017 21:47:55', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('8013FA7F78FB4C79BB4426E51385D3A3', 'admin', '超级管理员', to_date('11-01-2017 21:48:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '编辑', '0', '/autoCode/update', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('D5F76CBEB19E4CADB9BA33DD81F8C2C8', 'admin', '超级管理员', to_date('11-01-2017 21:48:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('30DC5C3EA4054C2482D448E6C7D80AF7', 'admin', '超级管理员', to_date('11-01-2017 21:48:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9F4767DB9205464D813A181BA44B2B8C', 'admin', '超级管理员', to_date('11-01-2017 21:49:25', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5514D15AD70548C981297E3BE7DAABB1', 'admin', '超级管理员', to_date('11-01-2017 21:49:29', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('089FD29ADBC44D9F989062EFE988336F', 'admin', '超级管理员', to_date('11-01-2017 21:51:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '新增', '0', '/transaction/save', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0E5D1230318E49138BD2F91B1CD65AB1', 'admin', '超级管理员', to_date('11-01-2017 21:51:42', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5927E25E120C42679604940F0B46E942', 'admin', '超级管理员', to_date('11-01-2017 21:53:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('E1DEA66EA61E449C9D3AE22A99B27E56', 'admin', '超级管理员', to_date('11-01-2017 21:55:14', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F72AE5D591A04A619CD86C38454BD98C', 'admin', '超级管理员', to_date('11-01-2017 21:55:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AD5055CFED04453F964C3F8D8265FAFD', 'admin', '超级管理员', to_date('11-01-2017 21:55:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2CDCFC12E0C24B21B7873A7E29676B74', 'admin', '超级管理员', to_date('11-01-2017 21:55:53', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('9A3D400FFF12450DB8E4D75185298F1D', 'admin', '超级管理员', to_date('11-01-2017 21:55:59', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('720FE7315F7E4B97B8756A00DECF453F', 'admin', '超级管理员', to_date('11-01-2017 22:15:05', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5409122B2CBC4604A19BD6B922F1CEB8', 'admin', '超级管理员', to_date('11-01-2017 22:15:07', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('14E408F1235F46E68F0FD1B4A40A3C56', 'admin', '超级管理员', to_date('11-01-2017 22:17:09', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('60E0BDB794DA4C44B4F77CE1661A6803', 'admin', '超级管理员', to_date('11-01-2017 22:17:18', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5366414453674FED904C58967886716E', 'admin', '超级管理员', to_date('11-01-2017 22:17:23', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('5715B9C207AE4CC5A3BBE765090BFE63', 'admin', '超级管理员', to_date('11-01-2017 22:17:34', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '查询', '0', '/autoCode/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('2BA19B9FA80145558FC53931FC1B8AE8', 'admin', '超级管理员', to_date('11-01-2017 22:17:38', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '事务提醒', '查询', '0', '/transaction/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('708D36E89CC747B9B0D713D28F11037B', 'admin', '超级管理员', to_date('11-01-2017 22:17:43', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('F671B708B0AC4A56B3DF3621ED62EFFA', 'admin', '超级管理员', to_date('11-01-2017 22:17:46', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('EDC4B4B900574CF39A01E4D6CD465985', 'admin', '超级管理员', to_date('11-01-2017 22:18:12', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '我的日记', '查询', '0', '/diary/list', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('AFDDF512088B4693B46F22DB1752CE96', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:42', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('0F1184AD0412425FAF2FF511DD69C789', 'U1000008', 'cjmei', to_date('09-02-2017 07:32:44', 'dd-mm-yyyy hh24:mi:ss'), '192.168.1.100', null, null, '0', '/getInfo', null, 2);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('043A14F83F7C44F78A53C4180D71B2E5', null, null, to_date('17-02-2017 23:13:08', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '用户管理', '查询', '0', '/sysUser/list', 'OM', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('95D8A348043D47B69841475FD8E0218F', 'admin', '超级管理员', to_date('11-01-2017 20:09:19', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '登录管理', '登录', '0', '/sys/login', '0', 0);
insert into TB_SYS_LOG (ID, USERID, USERNAME, CREATETIME, IP, MENUNAME, OPERNAME, RETAIN1, RETAIN2, RETAIN3, SOURCE)
values ('54AB349CB29B4AD0B33FD994231CBB52', 'admin', '超级管理员', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), '0:0:0:0:0:0:0:1', '生成代码', '生成代码', '0', '/autoCode/autocode', '0', 0);
commit;
prompt 586 records loaded
prompt Loading TB_SYS_LOG_PARAM...
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/wechat/createWXMenu', 1, '微信菜单', '同步', to_timestamp('07-01-2017 21:13:26.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:13:26.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '0FA563075BA242B5BCEA8BA88278E299');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/login', 2, '痕迹', '登录', to_timestamp('07-01-2017 21:38:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:38:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '1DC12C11DF88478598754FC7975A1D49');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/diary/list', 2, '日记', '查询', to_timestamp('07-01-2017 21:36:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:36:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '543B4F72BB79444B9AE7892044F0B42B');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/diary/save', 2, '日记', '添加', to_timestamp('07-01-2017 21:37:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:37:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'F48446BFE6BF4F73B4E86CB3CAE46658');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/diary/update', 2, '日记', '修改', to_timestamp('07-01-2017 21:37:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:37:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '68F42736FA4E4F8C94D67868E1FC910F');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/diary/findDiaryById', 2, '日记', '详情', to_timestamp('07-01-2017 21:38:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:38:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'D2CA1EC951F14BDC98D467F1D6A3A48D');
commit;
prompt 6 records loaded
prompt Loading TB_SYS_MENU...
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20160928203125806', '1', '操作类型', 'page/system/operate/sysOperate.jsp', 2, to_date('28-09-2016 20:31:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-09-2016 20:36:19', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysRole', 'system', '用户类型', 'page/system/sysrole/sysRole.jsp', 2, null, to_date('10-01-2017 23:11:48', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161016024730740', '1', '生成代码', 'page/autocode/autocode/autoCode.jsp', 3, to_date('16-10-2016 02:47:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:47:30', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('diary', 'note', '我的日记', 'page/note/diary/diary.jsp', 1, null, to_date('08-01-2017 20:41:07', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('orgInfo_parentid', '0', '架构', '#', 197, null, to_date('30-11-2016 21:16:04', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('orgInfo', 'orgInfo_parentid', '组织管理', 'page/system/orginfo/orgInfo.jsp', 1, null, to_date('20-10-2016 19:55:52', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxAccount', 'wxMenuUrl_parentid', '公众号管理', 'page/wx/wxaccount/wxAccount.jsp', 4, null, to_date('10-01-2017 23:10:44', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161023003925948', 'orgInfo_parentid', '公司管理', 'page/system/orginfo/companyInfo.jsp', 2, to_date('23-10-2016 00:39:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:39:25', 'dd-mm-yyyy hh24:mi:ss'), '曹纪梅');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('goodInfo_parentid', '0', '商品', '#', 10, null, to_date('30-11-2016 21:15:07', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('goodInfo', 'goodInfo_parentid', '商品管理', 'page/mall/goodinfo/goodInfo.jsp', 2, null, to_date('10-01-2017 23:09:05', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('advise', 'goodInfo_parentid', '客户定制', 'page/mall/advise/advise.jsp', 1, null, to_date('10-01-2017 22:37:37', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('1', '0', '菜单', '#', 200, to_date('30-07-2016 13:35:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:16:37', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('2', '1', '系统菜单', 'page/system/menu/sysMenu.jsp', 1, to_date('27-07-2016 13:36:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-07-2016 13:36:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysUser', 'system', '用户管理', 'page/system/sysuser/sysUser.jsp', 1, null, to_date('08-11-2016 18:50:24', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0', '系统', '#', 199, to_date('30-07-2016 13:36:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:16:25', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203194846615', '0', '个人中心', '#', 41, to_date('03-12-2016 19:48:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:48:46', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203195318395', '20161203194846615', '重置手机', 'page/system/sysuser/changeMobile.jsp', 2, to_date('03-12-2016 19:53:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 20:02:17', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysLogParam', 'sysLog_parentid', '日志参数', 'page/system/syslogparam/sysLogParam.jsp', 2, null, to_date('07-01-2017 21:31:53', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('vipInfo', 'note', '会员信息', 'page/note/vipinfo/vipInfo.jsp', 4, null, to_date('08-01-2017 20:41:53', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('note', '0', '痕迹', '#', 1, null, to_date('08-01-2017 19:57:21', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('moduleMsg', 'wxMenuUrl_parentid', '模板消息', 'page/wx/modulemsg/moduleMsg.jsp', 11, null, to_date('10-01-2017 23:10:32', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxUser', 'wxMenuUrl_parentid', '粉丝管理', 'page/wx/wxuser/wxUser.jsp', 3, null, to_date('10-01-2017 23:10:06', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('qrcode_parentid', '0', '二维码', '#', 31, null, to_date('30-11-2016 21:15:50', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxMenu', 'wxMenuUrl_parentid', '微信菜单管理', 'page/wx/wxmenu/wxMenu.jsp', 5, null, to_date('10-01-2017 23:10:56', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxMenuUrl_parentid', '0', '微信', '#', 30, null, to_date('30-11-2016 21:15:43', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxMenuUrl', 'wxMenuUrl_parentid', '微信菜单URL', 'page/wx/wxmenuurl/wxMenuUrl.jsp', 6, null, to_date('10-01-2017 23:11:03', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('qrcode', 'qrcode_parentid', '二维码管理', 'page/wx/qrcode/qrcode.jsp', 1, null, null, null);
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxAutoReplay', 'wxMenuUrl_parentid', '微信回复管理', 'page/wx/wxautoreplay/wxAutoReplay.jsp', 1, null, to_date('10-01-2017 23:09:28', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('question', 'note', '问题记录', 'page/note/question/question.jsp', 3, null, to_date('08-01-2017 20:42:02', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('newsItem', 'wxMenuUrl_parentid', '回复图文管理', 'page/wx/newsitem/newsItem.jsp', 2, null, to_date('10-01-2017 23:09:53', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysConf', 'system', '系统参数', 'page/system/sysconf/sysConf.jsp', 3, null, to_date('10-01-2017 23:11:29', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxTemplate', 'wxMenuUrl_parentid', '微信模板', 'page/wx/wxtemplate/wxTemplate.jsp', 10, null, to_date('10-01-2017 23:10:27', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('dataDir', 'system', '数据字典', 'page/system/datadir/dataDir.jsp', 4, null, to_date('10-01-2017 23:11:38', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('gains', 'note', '备忘记录', 'page/note/gains/gains.jsp', 2, null, to_date('08-01-2017 20:41:23', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysLog_parentid', '0', '日志', '#', 198, null, to_date('30-11-2016 21:16:15', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysLog', 'sysLog_parentid', '系统日志', 'page/system/syslog/sysLog.jsp', 1, null, to_date('07-01-2017 21:31:15', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203195018623', '20161203194846615', '修改密码', 'page/system/sysuser/changePwd.jsp', 1, to_date('03-12-2016 19:50:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:50:18', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('transaction', 'note', '事务提醒', 'page/note/transaction/transaction.jsp', 100, to_date('11-01-2017 21:39:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:03', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 38 records loaded
prompt Loading TB_SYS_OPERATE...
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('启禁用', 'activeBtn', 'icon-edit', to_date('08-01-2017 21:41:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 21:41:54', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 20);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('查询', 'query', 'icon-search', null, null, null, 0);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('新增', 'add', 'icon-add', null, null, null, 1);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('编辑', 'edit', 'icon-edit', null, null, null, 2);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('日记提醒', 'dairyBtn', 'icon-edit', to_date('03-12-2016 18:49:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:45:10', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 11);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('上下架', 'onsaleBtn', 'icon-edit', to_date('07-12-2016 20:29:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-12-2016 20:29:07', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 12);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('更新粉丝', 'syncWxFans', 'icon-edit', to_date('22-12-2016 22:27:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2016 22:27:59', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 30);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('生成代码', 'autoCodeBtn', 'icon-save', to_date('20-10-2016 02:05:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 02:05:58', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 6);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('删除', 'delete', 'icon-remove', to_date('30-09-2016 15:40:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:22:50', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 5);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('功能管理', 'addFunc', 'icon-edit', to_date('30-09-2016 15:41:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 15:41:38', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 3);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('同步微信', 'syncWx', 'icon-edit', to_date('17-11-2016 19:03:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-11-2016 19:03:08', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 7);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('重置密码', 'resetPwdBtn', 'icon-edit', to_date('26-11-2016 09:59:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-11-2016 09:59:09', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 10);
insert into TB_SYS_OPERATE (OPERNAME, OPERID, PICICON, CREATETIME, UPDATETIME, CREATOR, SORT)
values ('生产文档', 'introBtn', 'icon-save', to_date('09-01-2017 23:03:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:12', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 30);
commit;
prompt 13 records loaded
prompt Loading TB_SYS_ROLE...
insert into TB_SYS_ROLE (ROLEID, ROLENAME, CREATETIME, UPDATETIME, CREATOR, USERTYPE, COMPANYID, LVL, SHOWFLAG)
values ('Marks_VIP', '会员', to_timestamp('07-01-2017 23:46:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:04:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'VIP', 'Marks', 9, 0);
insert into TB_SYS_ROLE (ROLEID, ROLENAME, CREATETIME, UPDATETIME, CREATOR, USERTYPE, COMPANYID, LVL, SHOWFLAG)
values ('Marks_ADMIN', '管理员', to_timestamp('17-02-2017 21:51:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:51:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'ADMIN', 'Marks', 2, 1);
commit;
prompt 2 records loaded
prompt Loading TB_SYS_ROLE_FUNC...
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '34D4A51F71A3452DA20B5C89272F7121', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '729986573F3F498AB804BD1B7CC58466', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C3A5BC0B6477434E9E3942C16353834A', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9CFAB7B9645F4EB48F69A3E900B51CDB', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A9EDBB5CBFAA49CEB53C12A3C516BE85', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '7C045D9CA9D5456FAF856490836AA6C8', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A0BEFFBB0FDA42F38280FBE35A670977', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A947C38F31814E67830E922BA2FD5926', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F2B99E17C4EC4CB399A1F4D435C28909', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9E081346B9F5409EB8E8D79A988515E3', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '56FC1334D6A54B28B41C552156EA7E2C', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '440141C13AB345BC991774CDD7614909', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E95BB25BFFAF4C13864DBC3A02B9306D', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CD2780A03F02413E9D18F66323064595', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F26FD1B3DCBF43D38E37529BC60E12F3', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E9AFCA0B219A48F2B26C3407B89F6D4F', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0CC56B98214E4C8FB8439F341AFEEE28', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B527659F90594CD4844E2A2F22223E2A', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C58C67CD6EA94BB2963C9714C6F9F90B', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3DA8897C41E8473A99C5492100190412', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2309E4BC9A924651B31F785C830728B6', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0F54D4F78A8D491FA43C3FBF60A9B1CF', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9B746C1302684616B012733A4E791179', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E24E30A2E2674303B6C9B62B36D79ADC', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8890D1E058DB4B7894B2D7B2BCC696A7', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A10AF55DA5C548E294DBD10A10F92E46', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '062D833DD050478A8B6D5503CD347F60', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'D650F41753614EF68D65AD237334627C', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'AE5067796D694BAFB287D18529BAFFE2', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '352724802F66473AA600570AB00C61D4', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CB6D94D479C34121A38F5B40B91106D2', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8B31D84CC47A466C8132F6C0D212D442', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A3E3FFABB3264BEC9D20C47EA542B2F0', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '58F8C1A54B244D07986F391AD5CB9E5D', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '10ACD5DC793A4D5A9F4228195CF57B77', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F43CE8D5ABDB46148E26B8C6A7C513D7', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CB28B8D3B8E846C7A355249B8A6D14BC', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '374088A1D165445AB7496D87B9A5175E', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E5934CC56BEF43ECBF47AC07890713AC', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2DFE8F4215A34E4AB1A603C36242F923', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0C86A52B779342DA92F4F6027B3251FE', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '805B2E58E7CB46CFAC9629FE35F9E051', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '21B1268FD84F4B1C8945C8E9731F0F49', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F9B4C69C5F864657A55BF9560AAD7AC9', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '34CC225109974D0296DD538ED1A229C0', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '941ABAFE35D6480B95D0178B760BB1DB', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '56AF2BA7BBD643D8B66F1FEDB2F8D650', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A88AB1777C264C8387A4CF7B9C961048', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A3FEA09B72BA41868AA07D6818117AC0', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'FB4C99E9FB1A42F19B86FFC3DA761824', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8D4EC97F07AA48C0BA5F5F55A302532E', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6FB911AF50884CB9B52D3A6D9D3D4B03', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'AFF47427547E413D8A4E6E9D8658BB17', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3E71A3CE7AB34607BDC570E72EBB6444', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2B12F2FF49C242F4963A550AC1AA4D52', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '55371B38A22F4D078947A10E51837D47', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A4847B5D9E2C404BAFFCA1925B4C651B', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6061F2E92C214F4E98AA9F8A6862CD58', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '40B743A6291A435AAE743CA93499AD8F', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '475B85B975C441E9B720FAC82ECAB89A', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '35EA71BD598246AFB5769EA6730A1254', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '165FEFC91D0F4A26B232D2A1D59F4D37', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E0214CC842524D61A1CADB4B25F28C6D', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '751789E53BAA42428D477E49B00572C5', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '140845F24CC241B7AB3783B93F98724B', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2DA34B5B4BF643E89DD5B6C791CD630A', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '86BC5FE8B3624C5B96922DA0D299D843', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '351B1DF16E6444258F142C4FD767FCEE', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '81B28ED45F1A427ABBA9025E4D917AD0', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A6907ADFCD4B4E048DDA0632C2D5062F', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '5AA2258E1404444BAE135783DD56DC03', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F52536BB355D4216AA5F541601ABA4E0', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C50921BE08CE4C47BEC824DA733F4CFD', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '88EA18C8BA4847119DEFC9146B7C7F1F', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3EC98DB80F6440269D3628766217A68E', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'FA00FAE5BE8249519544EAB937CED130', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '81F44FFCFB484D1B9B2B28B8B44038FD', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '831A77AF2FB5418FB6290E19ACB03F72', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '7F15BED5384E401AA13B8FE99FDD79E5', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '028280270812450986EE5E8552E692EC', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'D5FFAAAD152F4023BDEC443B8CECA7C6', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '588848E727F14FCAA21623A6894C2DDB', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0784E15BB48B4061A038499DC17B45C3', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '4C7AA4B348454752BEF6F9EC55402280', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0EE456741D42426DB6448E5C6DDFDA8E', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '18B306C4A74149609A3FDC36F86F902A', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B0E3BAAA2955492FADE23C35F774BCC3', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B31E5C8F9DDB434CA70DDCC8204A74F3', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '431D29CBA6B64D92821180C1DB4335DE', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6232F8C5272A489CB66E54091718E5AD', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '633836EDCC0E40329B2BEBB34FA2B5FB', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'DA0BA7D60DD6461E85EA1EFB4E56AC1D', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0073BE06AA6A49D783E9E033131A5C57', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C1060CF0D3CE49A19BB7AEB3AF622B0C', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '92078E74B6784886BA2956AE553BFA69', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A716C1E44907420AAD6CA5AC638541C8', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '7EF6056FFFDE4EE6BBF84F86EF66BF28', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '37A16BCD5D0E462EB892CDC9BB3D28EA', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'FB548F9A221041E1A70A0A30D12F3457', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 100 records committed...
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9A05C58D23E64D82A8A0FC1448EB732D', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '49A155C4DBBF4A56907BFA4B60B4FAF1', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '699C293D715340D392CD4E113B864D20', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6BFC445EB2FC46D3B49582B319BB503E', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '4A911E4E08FE45BF95EE3CC1BA5F3B78', to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:58', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '729986573F3F498AB804BD1B7CC58466', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'C3A5BC0B6477434E9E3942C16353834A', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '9CFAB7B9645F4EB48F69A3E900B51CDB', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '440141C13AB345BC991774CDD7614909', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'E95BB25BFFAF4C13864DBC3A02B9306D', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'CD2780A03F02413E9D18F66323064595', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'F26FD1B3DCBF43D38E37529BC60E12F3', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'F2B99E17C4EC4CB399A1F4D435C28909', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '9E081346B9F5409EB8E8D79A988515E3', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '56FC1334D6A54B28B41C552156EA7E2C', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '34D4A51F71A3452DA20B5C89272F7121', to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 10:14:00', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'EA8356660C5C44148C2F2ADAE541F378', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '4DF3F72BB4EC46F484217B2A43976506', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '1A3986FDB20849B5803407BB690F16DC', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '4BF2476CDA2347BF8D99668774CA901C', to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 21:39:04', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 121 records loaded
prompt Loading TB_SYS_USER...
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000008', 'cjmei', 'B15A268148D9C5A9363E915581CE1819', '18680221791', 1, to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:44:59.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_VIP', 5, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000018', '18210012743', 'B15A268148D9C5A9363E915581CE1819', '18210012749', 1, to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:54:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '18210012743', 'Marks', null, null, 'Marks_VIP', 6, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('admin', '超级管理员', 'CBD701EBDED1BD076B763EF3ABAF501E', '18210012743', 1, to_timestamp('24-07-2016 15:30:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:07:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 2, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000019', '测试', 'B15A268148D9C5A9363E915581CE1819', '18210012745', 1, to_timestamp('10-01-2017 22:12:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 22:12:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000021', '测试3', 'B15A268148D9C5A9363E915581CE1819', '18610021234', 1, to_timestamp('17-02-2017 21:53:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:53:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000022', '测试34', 'B15A268148D9C5A9363E915581CE1819', '18690221872', 1, to_timestamp('17-02-2017 23:40:58.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 23:40:58.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000023', '测试1234', 'B15A268148D9C5A9363E915581CE1819', '18612341234', 1, to_timestamp('17-02-2017 23:41:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 23:41:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, OPENID, ROLEID, SKIN, BINDFLAG)
values ('U1000020', '测试2', 'B15A268148D9C5A9363E915581CE1819', '18610012734', 1, to_timestamp('17-02-2017 21:11:19.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:11:19.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
commit;
prompt 8 records loaded
prompt Loading TB_SYS_USER_ORG...
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000008', 'Marks', to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000018', 'Marks', to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '18210012743');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000019', 'Marks', to_timestamp('10-01-2017 22:12:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 22:12:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000021', 'Marks01', to_timestamp('17-02-2017 21:53:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:53:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000022', 'Marks01', to_timestamp('17-02-2017 23:40:58.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 23:40:58.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000023', 'Marks01', to_timestamp('17-02-2017 23:41:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 23:41:27.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('admin', 'Marks', to_timestamp('08-01-2017 21:07:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:07:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null);
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000020', 'Marks', to_timestamp('17-02-2017 21:11:19.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:11:19.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
commit;
prompt 8 records loaded
prompt Loading TB_VIP_INFO...
insert into TB_VIP_INFO (USERID, REALNAME, GENDER, BIRTHDATE, EMAIL, SIGNATURE, CREATETIME, UPDATETIME)
values ('U1000018', 'meckiy', '1', '2017-01-08', 'cjmei0221@163.com', '淡，即凡；泊，为平；宁，乃安；静，是寂。', to_timestamp('08-01-2017 20:38:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 20:47:08.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into TB_VIP_INFO (USERID, REALNAME, GENDER, BIRTHDATE, EMAIL, SIGNATURE, CREATETIME, UPDATETIME)
values ('U1000008', 'meckiy', '1', '1989-02-21', 'cjmei0221@163.com', '淡，即凡；泊，即平；宁，乃安；静，是寂', to_timestamp('08-01-2017 20:51:05.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:00:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;
prompt 2 records loaded
prompt Loading TB_WX_ACCESS_TOKEN...
insert into TB_WX_ACCESS_TOKEN (ACCOUNTID, ACCESSTOKEN, PUTTIME, EXPIRES_IN, UPDATETIME)
values ('wxtest012', 'PCByC74pWQZYc5MtGqWun5j0-FiYJdGHP8kTL3n_lb0Y1m7qBeX1XGl_JiTArZIEBhzio957bAGC5t5xRfgpILq9Z1C2bjvKVhzEjo1m08F2jFIhcPHbHDL4zVAeyl-RCMPkCEAMWZ', '1482418111292', '7200', to_date('22-12-2016 22:48:31', 'dd-mm-yyyy hh24:mi:ss'));
insert into TB_WX_ACCESS_TOKEN (ACCOUNTID, ACCESSTOKEN, PUTTIME, EXPIRES_IN, UPDATETIME)
values ('ctest', 'nFEiMX0qKvg9mDbJUShK0mftkQiF1ZSLWQlhhSAZ07tumA8l82bAf_rKRsWg57KuDVXY-hzANwed373izAjMUEBI4QWJf-MWvUm34Bb93tmH4lqhHZ0UY6cRCTWROc93KHAaADAXUN', '1487685666728', '7199', to_date('21-02-2017 22:01:06', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 2 records loaded
prompt Loading TB_WX_ACCOUNT...
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('wxtest012', '测试012', 'wx1102d8ed48b46f5e', 'c655d6de4b8fa4587fca8691ed478996', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=wxtest012', null, null, 'admin', to_date('17-11-2016 14:44:07', 'dd-mm-yyyy hh24:mi:ss'), '/', 'test_012 ', 0, 0, to_date('11-01-2017 21:07:24', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('ctest', 'cjmei0221测试服务号', 'wxfa54b3d1eafa3510', '15411cc0a1cd4eea2003581717ec0d59', null, 'null/WECHAT/HANDLER?accountid=ctest', null, null, 'admin', to_date('25-11-2016 11:03:09', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 1, 0, to_date('11-01-2017 20:15:38', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('qy_cjmei', 'C团队', 'wx89e520f1912d47a2', 'o9cj_Mo84hGY0x1nu4uDzGV8mfrkoBRpQehiCHkKOp3g5i6oUxM-BzH2vcgax8fx', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=qy_cjmei', null, null, 'admin', to_date('17-11-2016 14:13:13', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 0, 1, to_date('11-01-2017 20:37:23', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
commit;
prompt 3 records loaded
prompt Loading TB_WX_AUTO_REPLAY...
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG)
values ('teset', 'N100000012,N100000009', '1E621C7BFE3E4C1196E5BC178DC2002F', '测试234', 'wxtest012', 'NEWS', to_date('25-11-2016 10:15:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 10:32:53', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 0);
commit;
prompt 1 records loaded
prompt Loading TB_WX_AUTO_REPLAY_NEWSITEM...
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000009', '测试', '334345', 'ftp://127.0.0.1/images/68985322F99A426A8376408F28EAD0F5.jpg', '维维45', 3, 'wxtest012', to_timestamp('24-11-2016 18:07:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('24-11-2016 18:07:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000012', 'wqwerq', '5345', 'ftp://127.0.0.1/images/DD817AC23D93417999C83832934B88E2.jpg', '234523', 2345, 'wxtest012', to_timestamp('24-11-2016 18:53:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('24-11-2016 18:53:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000013', '測試', '測試', 'ftp://127.0.0.1/images/20170111203645470.jpg', 'https://www.baidu.com', 2, 'ctest', to_timestamp('11-01-2017 20:37:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('11-01-2017 20:37:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000014', 'ces', 'ces', 'ftp://127.0.0.1/images/201701112058586.jpg', 'cs', 2, 'wxtest012', to_timestamp('11-01-2017 20:59:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('11-01-2017 20:59:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
commit;
prompt 4 records loaded
prompt Loading TB_WX_CHAT_MSG...
prompt Table is empty
prompt Loading TB_WX_CHAT_NEWS_MSG...
prompt Table is empty
prompt Loading TB_WX_MENU...
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('8F877DEE46A14CF492E72FAD4FD2B739', 'wxtest012', '测试1', 'view', 'http://www.baidu.com', 1, 'wxtest012', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('EC46566839D64430BCB33C5CA7632DAD', 'ctest', '痕迹', '1', '#', 1, 'ctest', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('BF9153133E8C4E5B8DFAEF655E328DB7', 'EC46566839D64430BCB33C5CA7632DAD', '备忘', 'view', 'http://192.168.1.105:8080/mobile/view/note/gains/list.html', 2, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('26CB0FA34F4E47DCA4CB68CF887D3F17', 'EC46566839D64430BCB33C5CA7632DAD', '日记', 'view', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', 1, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('42B3A5D791F54772AD235379E3BFD622', 'EC46566839D64430BCB33C5CA7632DAD', '问题', 'view', 'http://192.168.1.105:8080/mobile/view/note/question/list.html', 3, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('9C53C598166F442694BB19507A5DFB34', 'ctest', '我', 'view', 'http://192.168.1.105:8080/mobile/view/note/owner/myInfo.html', 2, 'ctest', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('F9EF2E2295054A7796C9DE393CDBA9CB', '8F877DEE46A14CF492E72FAD4FD2B739', '测试2', 'view', 'https://www.baidu.com', 2, 'wxtest012', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('ED7A8C4367A543C8ADA6A57A14F19700', '8F877DEE46A14CF492E72FAD4FD2B739', '测试3', 'view', 'https://www.baidu.com', 1, 'wxtest012', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('0B711EA4D8404F3589295C860058BA0D', 'wxtest012', 'ces1', 'view', 'https://www.baidu.com', 2, 'wxtest012', 1);
commit;
prompt 9 records loaded
prompt Loading TB_WX_MENU_URL...
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('EAC991E5044D4A5BA6E970B78E6F0ECE', 'ces', '23123', 'wxtest012');
commit;
prompt 1 records loaded
prompt Loading TB_WX_MODULE_MSG...
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('EEB7D4AA1243498696A8FB89AEB12D13', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-22","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('22-12-2016 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2016 22:04:01', 'dd-mm-yyyy hh24:mi:ss'), '415313545', '0000', null, null, null, '2016-12-22 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('A7C98BC03C3546F1BDC02F07C639D825', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/owner/login.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-07","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('07-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:23:02', 'dd-mm-yyyy hh24:mi:ss'), '415647991', '0000', null, null, null, '2017-01-07 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('62EF107DF4E9417DAF8077A662A2A010', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/owner/login.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-07","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('07-01-2017 22:04:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:23:02', 'dd-mm-yyyy hh24:mi:ss'), '415647993', '0000', null, null, null, '2017-01-07 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('5B94E489735B435EA3C95A17F2660202', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-08","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('08-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415656304', '0000', null, null, null, '2017-01-08 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('A701931330E446FF97DC48A4D9D6C795', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-08","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('08-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416213483', '0000', null, null, null, '2017-02-08 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('C469E0610FF84802B45B38295C63C813', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-09","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('09-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-02-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '416227592', '0000', null, null, null, '2017-02-09 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('974E4DBDE55A47D899F79BF77C560E7C', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-09","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('09-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-02-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '416227593', '0000', null, null, null, '2017-02-09 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('069CC65ABC7A4A708AD2DF577DC8FF62', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-09","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('09-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-02-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '416227594', '0000', null, null, null, '2017-02-09 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('97862A3743714C52B01339D5C1D35E96', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-17","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('17-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '416368337', '0000', null, null, null, '2017-02-17 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('154D2AF5E6F74E27B69DA8BC41571588', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-18","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('18-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416377520', '0000', null, null, null, '2017-02-18 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('749D69ECAA7A4C4AACB4220145D2A30F', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-19","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('19-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416389027', '0000', null, null, null, '2017-02-19 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('57A5A0ED0D8D48FB87BF6DE02A4F6BF6', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-20","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('20-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-02-2017 22:01:06', 'dd-mm-yyyy hh24:mi:ss'), '416402765', '0000', null, null, null, '2017-02-20 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('27E4E7ECF41A4117B0299F3FE4C848AD', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-21","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('21-02-2017 22:00:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-02-2017 22:01:07', 'dd-mm-yyyy hh24:mi:ss'), '416422357', '0000', null, null, null, '2017-02-21 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('07BD0F2E10104B64A01EE2733A8D7869', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-21","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('21-02-2017 22:00:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-02-2017 22:01:07', 'dd-mm-yyyy hh24:mi:ss'), '416422356', '0000', null, null, null, '2017-02-21 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('5439643EBE8B4498BE13735C9D5578F3', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-04","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('04-01-2017 22:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-01-2017 23:28:02', 'dd-mm-yyyy hh24:mi:ss'), '415595555', '0000', null, null, null, '2017-01-04 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('FC19EB1D8B46464FA146A85D552C8E47', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-07","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('07-12-2016 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-12-2016 23:15:02', 'dd-mm-yyyy hh24:mi:ss'), '415151712', '0000', null, null, null, '2016-12-07 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('B1E968C7630C415CBB94F9B5BC01A98D', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/owner/login.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-07","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('07-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:23:02', 'dd-mm-yyyy hh24:mi:ss'), '415647992', '0000', null, null, null, '2017-01-07 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('6C1CC1D93A6C48459DCEA0EC295C26D0', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/owner/login.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-07","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('07-01-2017 22:04:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:23:02', 'dd-mm-yyyy hh24:mi:ss'), '415647990', '0000', null, null, null, '2017-01-07 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('A3670DB11A394AED8ACD0054F233706D', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-08","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('08-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415656305', '0000', null, null, null, '2017-01-08 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('48584B98BC7D49F1A1606820F03664F4', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-09","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('09-01-2017 16:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 16:31:00', 'dd-mm-yyyy hh24:mi:ss'), '415668301', '0000', null, null, null, '2017-01-09 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('DA06CF749D224E3AA77F369ECDB9B608', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-10","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('10-01-2017 17:41:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-01-2017 19:29:01', 'dd-mm-yyyy hh24:mi:ss'), '415734680', '0000', null, null, null, '2017-01-10 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('CF094E7273C24DAC9EB0274B3413C529', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-12","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('12-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '415775269', '0000', null, null, null, '2017-01-12 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('37FD2CBCB12F412680EE58D838366A59', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-08","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('08-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416213486', '0000', null, null, null, '2017-02-08 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('8879F8C06EE54C1EBB0382B02E70113D', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-03","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('03-12-2016 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-12-2016 23:15:05', 'dd-mm-yyyy hh24:mi:ss'), '415151716', '0000', null, null, null, '2016-12-03 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('F1C64A6213CE44BE857A5ECD6947FA92', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-06","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('06-12-2016 22:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-12-2016 23:15:02', 'dd-mm-yyyy hh24:mi:ss'), '415151711', '0000', null, null, null, '2016-12-06 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('8B39AE5FD0354BD2B31DBCB631E47F76', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-18","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('18-12-2016 22:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-12-2016 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415179512', '0000', null, null, null, '2016-12-18 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('C460276554D145479AC5A5769DE77BBB', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 20:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 20:05:01', 'dd-mm-yyyy hh24:mi:ss'), '415754866', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('66F50C7CD02F4BA99EC2F0249D061914', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-18","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('18-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '416377518', '0000', null, null, null, '2017-02-18 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('D7EFB300A13448B48DB80A45431E69E0', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-19","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('19-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416389026', '0000', null, null, null, '2017-02-19 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('2F31E5B8204F489EB30DCA51DB74DD89', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-02-20","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('20-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-02-2017 22:01:07', 'dd-mm-yyyy hh24:mi:ss'), '416402767', '0000', null, null, null, '2017-02-20 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('19354771A3DB4A0CB0E4404423D271C0', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-20","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('20-02-2017 22:00:04', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-02-2017 22:01:06', 'dd-mm-yyyy hh24:mi:ss'), '416402766', '0000', null, null, null, '2017-02-20 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('E280F289303444DB8BAF5CCEEBBAF7D0', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-11-30","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('30-11-2016 20:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 20:05:01', 'dd-mm-yyyy hh24:mi:ss'), '414713422', '0000', null, null, null, '日记提醒 2016-11-30');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('9DEB55B0C25346D2BD40CEA4EA23FF6E', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-20","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('20-12-2016 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2016 22:04:01', 'dd-mm-yyyy hh24:mi:ss'), '415313546', '0000', null, null, null, '2016-12-20 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('3CF92E73481B4A4084AFD914C1D64D9F', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/owner/login.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-04","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 2, to_date('04-01-2017 22:00:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('05-01-2017 23:33:01', 'dd-mm-yyyy hh24:mi:ss'), '415595623', '0000', null, null, null, '2017-01-04 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('E1409CE903C441F1842C4D69369AE341', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-09","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('09-01-2017 16:30:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 16:31:00', 'dd-mm-yyyy hh24:mi:ss'), '415668302', '0000', null, null, null, '2017-01-09 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('061CE51A0DAC4F20A724656CDCD49C83', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 20:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 20:05:01', 'dd-mm-yyyy hh24:mi:ss'), '415754860', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('982880B56DDF42B08014A2F981D2FDD6', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-11-28","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('28-11-2016 21:23:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-11-2016 21:24:05', 'dd-mm-yyyy hh24:mi:ss'), '414652251', '0000', null, null, null, '2016-11-28 心诺静 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('0748638213554EF5B217E93A6E9C0ADE', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '415757248', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('F358037685404B98970A21DA116DE4BC', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '415757249', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('C98ADCD2796E47E2B0901EF8FAE52174', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-01-12","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('12-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '415775270', '0000', null, null, null, '2017-01-12 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('6453AD2EE4DF47289687583FE9B58B5C', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-13","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('13-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-01-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415799788', '0000', null, null, null, '2017-01-13 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('E4FEEC2C8A574A8688EE181C19E9E660', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-13","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('13-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-01-2017 22:01:00', 'dd-mm-yyyy hh24:mi:ss'), '415799786', '0000', null, null, null, '2017-01-13 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('2002C3DD69F34433863159811BCACBF7', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-01-13","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('13-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-01-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415799787', '0000', null, null, null, '2017-01-13 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('6E58B6ABB8F04FF0AB60E9CD10132ED0', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-08","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('08-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416213485', '0000', null, null, null, '2017-02-08 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('1A5B240692BA40E1B204A791C8FE8E0D', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-17","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('17-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '416368335', '0000', null, null, null, '2017-02-17 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('F5364C360B614E0A83EAA65D6844F4FE', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-18","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('18-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '416377519', '0000', null, null, null, '2017-02-18 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('25A5692DBDF04AD3AB478A9EF6D8063F', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-11-28","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('28-11-2016 21:23:43', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-11-2016 21:24:01', 'dd-mm-yyyy hh24:mi:ss'), '414652250', '0000', null, null, null, '2016-11-28 心诺静 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('C8311633335D42869ADEECE5962DBDF8', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', null, '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2016-12-01","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('01-12-2016 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 22:21:04', 'dd-mm-yyyy hh24:mi:ss'), '414740409', '0000', null, null, null, '2016-12-01 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('8ADAE8697FD14598AD53A84BFB9110DE', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-01-10","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('10-01-2017 17:41:24', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-01-2017 19:29:01', 'dd-mm-yyyy hh24:mi:ss'), '415734679', '0000', null, null, null, '2017-01-10 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('01361DB7EC5249B7B4F8CFE3DA0FF34E', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 20:04:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 20:05:01', 'dd-mm-yyyy hh24:mi:ss'), '415754864', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('049EBDE4E9854AC99F7C50E26769737E', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-11","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('11-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-01-2017 22:01:01', 'dd-mm-yyyy hh24:mi:ss'), '415757247', '0000', null, null, null, '2017-01-11 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('66C10FE85B7644A88B556A0DB8C6DBB5', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1so5GFsBZW5SzzJpn3-nLSUY', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"心诺静","color":"#000000"},"keyword2":{"value":"2017-01-12","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('12-01-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-01-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '415775271', '0000', null, null, null, '2017-01-12 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('F0C175ED1B8349D5A35220A70C417B02', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1ssBayAbCXfLE7s38H0wuPxk', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"呐呐呐呐呐～","color":"#000000"},"keyword2":{"value":"2017-02-17","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('17-02-2017 22:00:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-02-2017 11:45:01', 'dd-mm-yyyy hh24:mi:ss'), '416368336', '0000', null, null, null, '2017-02-17 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('53858A8B0FA3433096D737490E63BE7C', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-19","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('19-02-2017 22:00:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-02-2017 22:01:02', 'dd-mm-yyyy hh24:mi:ss'), '416389025', '0000', null, null, null, '2017-02-19 日记提醒');
insert into TB_WX_MODULE_MSG (ID, ACCOUNTID, TEMPLATE_ID, TOUSER, URL, DATA, NEEDFLAG, SENDFLAG, SENDTIMES, CREATETIME, SENDTIME, MSGID, PUSH_CODE, PUSH_MSG, RESULTCODE, RESULTMSG, NOTE)
values ('FFA1E02140DF42F5A665DCB150C5B6CA', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', 'oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', '{"first":{"value":"您今天写了日记吗？","color":"#000000"},"keyword1":{"value":"Seven","color":"#000000"},"keyword2":{"value":"2017-02-21","color":"#000000"},"remark":{"value":"还没写，快去写吧","color":"#000000"}}', 1, 1, 1, to_date('21-02-2017 22:00:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('21-02-2017 22:01:07', 'dd-mm-yyyy hh24:mi:ss'), '416422355', '0000', null, null, null, '2017-02-21 日记提醒');
commit;
prompt 55 records loaded
prompt Loading TB_WX_QRCODE...
insert into TB_WX_QRCODE (ID, QRNO, QRNAME, QRTYPE, QRURL, ACCOUNTID, QRPATH, SCENETYPE, CREATETIME, UPDATETIME, CREATOR, COMPANYID)
values ('7DAA8E940FA14851968C22D9F44E74A7', null, 'erwe45345', '0', 'https://www.baidu.com', null, 'ftp://127.0.0.1/images/1F4EB7BFF1BB4DF28477275E48737D92.png', 1, to_date('25-11-2016 19:47:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 19:51:14', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null);
insert into TB_WX_QRCODE (ID, QRNO, QRNAME, QRTYPE, QRURL, ACCOUNTID, QRPATH, SCENETYPE, CREATETIME, UPDATETIME, CREATOR, COMPANYID)
values ('FC560F9248094DD8AB79483383F2A7C7', '12', '广州', '1', null, 'ctest', 'ftp://127.0.0.1/images/20161125200433243.jpeg', 1, to_date('25-11-2016 20:04:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-11-2016 09:12:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null);
insert into TB_WX_QRCODE (ID, QRNO, QRNAME, QRTYPE, QRURL, ACCOUNTID, QRPATH, SCENETYPE, CREATETIME, UPDATETIME, CREATOR, COMPANYID)
values ('78DD6BF1C0DB46219B6B5595C7825541', null, '45345345', '0', 'https://www.baidu.com', null, 'ftp://127.0.0.1/images/20161125195124965.png', 1, to_date('25-11-2016 19:51:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 19:51:27', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null);
insert into TB_WX_QRCODE (ID, QRNO, QRNAME, QRTYPE, QRURL, ACCOUNTID, QRPATH, SCENETYPE, CREATETIME, UPDATETIME, CREATOR, COMPANYID)
values ('640701C0F98C40D8821A3C31994EB3E0', '199999', '45345345', '1', null, 'ctest', 'ftp://127.0.0.1/images/20161125195540804.jpeg', 0, to_date('25-11-2016 19:55:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 19:55:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null);
insert into TB_WX_QRCODE (ID, QRNO, QRNAME, QRTYPE, QRURL, ACCOUNTID, QRPATH, SCENETYPE, CREATETIME, UPDATETIME, CREATOR, COMPANYID)
values ('0BF613DF4F724FC4862C2DF3838661FB', null, 'ces', '0', 'https://www.baidu.com', null, 'ftp://127.0.0.1/images/20161126080234771.png', 1, to_date('26-11-2016 08:02:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-11-2016 08:02:51', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null);
commit;
prompt 5 records loaded
prompt Loading TB_WX_TEMPLATE...
insert into TB_WX_TEMPLATE (YWTYPE, ACCOUNTID, TEMPLATE_ID, TEMPLATE_NAME, FIRST_CONTENT, REMARK_CONTENT, DETAILURL, STATUS, CREATETIME, UPDATETIME, CREATOR)
values ('wxtemplate_dairy', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', '日记提醒', '您今天写了日记吗？', '还没写，快去写吧', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', 1, to_date('27-11-2016 22:40:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:17:36', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 1 records loaded
prompt Loading TB_WX_USER...
insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1so5GFsBZW5SzzJpn3-nLSUY', '心诺静', 0, '中国', '广东', '广州', 2, 'http://wx.qlogo.cn/mmopen/QMxicdt4bY1cYiaTXvyYyfictfCLcywF3mGxLezDKRHviaxyH7Fod0nFaFOGdHedaFekxiaNsUEpxgYGCGtDX3WyQIoGRkRgEGhzh/0', 'zh_CN', 1, to_timestamp('01-09-2016 11:09:05.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('25-11-2016 11:10:57.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, null, null, 1);
insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1ssBayAbCXfLE7s38H0wuPxk', '呐呐呐呐呐～', 0, '中国', '天津', '南开', 2, 'http://wx.qlogo.cn/mmopen/QMxicdt4bY1c4ibcuarYHq7OI0rf6DjAKOBDDFI4UibwtejiayKUshXRDvnAyCsxcfX5ibxibWnCzeJFUA4IPc7vxoibObKTAjcTWGh/0', 'zh_CN', 1, to_timestamp('22-12-2016 22:10:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('22-12-2016 22:49:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 0, null, null, 1);
insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'Seven', 0, null, null, null, 1, 'http://wx.qlogo.cn/mmopen/ItibBichAC9UJDtDT1wkQKYahIcAummpjCsp43kdDJIxUzEGg5zib547JhPwb0v7uwSN1G6dcTsR6chrwOlPmzacStRQK60QLJ6/0', 'zh_CN', 1, to_timestamp('09-01-2017 09:18:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('10-01-2017 19:31:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 0, null, null, 1);
commit;
prompt 3 records loaded
prompt Loading TESTCODE...
prompt Table is empty
set feedback on
set define on
prompt Done.
