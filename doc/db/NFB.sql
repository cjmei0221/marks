
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

CREATE TABLE TB_NOTE_reminder (
	ID VARCHAR2 (50),
	remind_TYPE NUMBER (2),
  calendar_type NUMBER (1),
	remind_date VARCHAR2 (30),
  remind_TIME VARCHAR2 (30),
	IS_REPEAT NUMBER (1),
	remind_CONTENT NVARCHAR2 (200),
	before_DAYS NUMBER (3),
	IS_before NUMBER (1),
	CREATETIME TIMESTAMP,
	UPDATETIME TIMESTAMP,
	CREATOR NVARCHAR2 (100)
);

alter table TB_NOTE_reminder
  add primary key (ID);


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

insert into TB_NOTE_GAINS (ID, LVL, LVLNAME, TITLE, CONTENT, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('626CD39ACFA54C3AA8090BE31C2DF3DA', 'L1', '经验', '项目管理', '步骤<br/><br/>1，确定需求<br/><br/>2，开发前确定好基础架构，数据库设计<br/><br/>3，安排工作任务，找到人员之间的较好的切合点，减少人员工作中的冲突', '项目管理', to_timestamp('01-12-2016 22:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 22:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
commit;

insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('7793CF70A29A4DBD91E9EF7A8A850084', 'L2', '较严重', 'linux tomcat服务器进程自动关闭问题', '1，tomcat 内存默认是128M 故需要加大内存 在bin/catalina.sh 最上面(即cygwin=false 上面)添加 JAVA_OPTS="-Xms1024m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=256m"<br/><br/>2，监控内存<br/>    在bin/catalina.sh 最上面(即cygwin=false 上面)添加如下：<br/>    JAVA_OPTS="-Xms2048m -Xmx2048m -XX:PermSize=256M -XX:MaxPermSize=512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:/home/dmz_vip_mobile/apache-tomcat-7. 0.62/logs/gc.log" if [ "$1" = "start" ];then echo "set console"; # JAVA_OPTS="$JAVA_OPTS -Xms256m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=256m" JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=60001 -Djava.rmi.server.hostname=112.74.185.128"; JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false"; JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false"; # JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.pwd.file=/root/soft/jdk7/jre/lib/management/jmxremote.password" else echo "no startup"; fi;<br/>    然后在java jdk 的bin目录中运行 jconsole.exe 监控此tomcat的运行内存', 'tomcat服务器进程自动关闭问题', to_timestamp('01-12-2016 20:09:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 20:09:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('AFE86EB25CF9463EA22F2B12E54AC86D', 'L3', '一般', 'tomcat乱码问题', '配置 bin/server.xml文件<br/><Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"　redirectPort="8443" URIEncoding="UTF-8" /\> 　　     <Connector port="8009" protocol="AJP/1.3" redirectPort="8443"  URIEncoding="UTF-8"/\> 　　<br/>在port ="8080"或者port ="8009"加入URIEncoding="UTF-8" 就好了。', 'tomcat 乱码问题', to_timestamp('01-12-2016 20:16:09.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('01-12-2016 21:13:29.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'U1000008', null);
insert into TB_NOTE_QUESTION (ID, LVL, LVLNAME, QUESTION, SOLUTION, LABELS, CREATETIME, UPDATETIME, CREATOR, UPDATER, MOBILE)
values ('CCA0D96E65E244E48599B09C3569BE5C', 'L3', '一般', 'vue存在页面假死状态，vue还存在字段中html标签，不能编译', '现初步认为是sui mobile问题，可以不使用sui mobile的js文件，将css page和pagegroup去掉即可', 'vue', to_timestamp('22-12-2016 19:36:02.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:03:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'U1000008', 'admin', null);
commit;



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

insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_host_url', 'http://127.0.0.1:6080', '访问center功能路径', 'weixin', to_date('06-11-2016', 'dd-mm-yyyy'), to_date('08-02-2017 18:31:20', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;

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

insert into TB_SYS_ROLE (ROLEID, ROLENAME, CREATETIME, UPDATETIME, CREATOR, USERTYPE, COMPANYID, LVL, SHOWFLAG)
values ('Marks_VIP', '会员', to_timestamp('07-01-2017 23:46:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:04:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'VIP', 'Marks', 9, 0);
insert into TB_SYS_ROLE (ROLEID, ROLENAME, CREATETIME, UPDATETIME, CREATOR, USERTYPE, COMPANYID, LVL, SHOWFLAG)
values ('Marks_ADMIN', '管理员', to_timestamp('17-02-2017 21:51:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('17-02-2017 21:51:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'ADMIN', 'Marks', 2, 1);
commit;

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

insert into TB_VIP_INFO (USERID, REALNAME, GENDER, BIRTHDATE, EMAIL, SIGNATURE, CREATETIME, UPDATETIME)
values ('U1000018', 'meckiy', '1', '2017-01-08', 'cjmei0221@163.com', '淡，即凡；泊，为平；宁，乃安；静，是寂。', to_timestamp('08-01-2017 20:38:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 20:47:08.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
insert into TB_VIP_INFO (USERID, REALNAME, GENDER, BIRTHDATE, EMAIL, SIGNATURE, CREATETIME, UPDATETIME)
values ('U1000008', 'meckiy', '1', '1989-02-21', 'cjmei0221@163.com', '淡，即凡；泊，即平；宁，乃安；静，是寂', to_timestamp('08-01-2017 20:51:05.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:00:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'));
commit;


insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('wxtest012', '测试012', 'wx1102d8ed48b46f5e', 'c655d6de4b8fa4587fca8691ed478996', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=wxtest012', null, null, 'admin', to_date('17-11-2016 14:44:07', 'dd-mm-yyyy hh24:mi:ss'), '/', 'test_012 ', 0, 0, to_date('11-01-2017 21:07:24', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('ctest', 'cjmei0221测试服务号', 'wxfa54b3d1eafa3510', '15411cc0a1cd4eea2003581717ec0d59', null, 'null/WECHAT/HANDLER?accountid=ctest', null, null, 'admin', to_date('25-11-2016 11:03:09', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 1, 0, to_date('11-01-2017 20:15:38', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('qy_cjmei', 'C团队', 'wx89e520f1912d47a2', 'o9cj_Mo84hGY0x1nu4uDzGV8mfrkoBRpQehiCHkKOp3g5i6oUxM-BzH2vcgax8fx', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=qy_cjmei', null, null, 'admin', to_date('17-11-2016 14:13:13', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 0, 1, to_date('11-01-2017 20:37:23', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
commit;

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

prompt 5 records loaded
prompt Loading TB_WX_TEMPLATE...
insert into TB_WX_TEMPLATE (YWTYPE, ACCOUNTID, TEMPLATE_ID, TEMPLATE_NAME, FIRST_CONTENT, REMARK_CONTENT, DETAILURL, STATUS, CREATETIME, UPDATETIME, CREATOR)
values ('wxtemplate_dairy', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', '日记提醒', '您今天写了日记吗？', '还没写，快去写吧', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', 1, to_date('27-11-2016 22:40:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:17:36', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;

insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1so5GFsBZW5SzzJpn3-nLSUY', '心诺静', 0, '中国', '广东', '广州', 2, 'http://wx.qlogo.cn/mmopen/QMxicdt4bY1cYiaTXvyYyfictfCLcywF3mGxLezDKRHviaxyH7Fod0nFaFOGdHedaFekxiaNsUEpxgYGCGtDX3WyQIoGRkRgEGhzh/0', 'zh_CN', 1, to_timestamp('01-09-2016 11:09:05.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('25-11-2016 11:10:57.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1, null, null, 1);
insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1ssBayAbCXfLE7s38H0wuPxk', '呐呐呐呐呐～', 0, '中国', '天津', '南开', 2, 'http://wx.qlogo.cn/mmopen/QMxicdt4bY1c4ibcuarYHq7OI0rf6DjAKOBDDFI4UibwtejiayKUshXRDvnAyCsxcfX5ibxibWnCzeJFUA4IPc7vxoibObKTAjcTWGh/0', 'zh_CN', 1, to_timestamp('22-12-2016 22:10:53.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('22-12-2016 22:49:40.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 0, null, null, 1);
insert into TB_WX_USER (OPENID, NICKNAME, GROUPID, COUNTRY, PROVINCE, CITY, SEX, IMAGEURL, LANGUAGE, ISSUBSCRIBE, SUBSCRIBETIME, UPDATETIME, ACCOUNTID, CREATETIME, USEFLAG, QRNO, REMARK, DAIRYFLAG)
values ('oDkf1sjIyT3VlYm_D2GNHlkh0-yQ', 'Seven', 0, null, null, null, 1, 'http://wx.qlogo.cn/mmopen/ItibBichAC9UJDtDT1wkQKYahIcAummpjCsp43kdDJIxUzEGg5zib547JhPwb0v7uwSN1G6dcTsR6chrwOlPmzacStRQK60QLJ6/0', 'zh_CN', 1, to_timestamp('09-01-2017 09:18:41.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('10-01-2017 19:31:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'ctest', to_timestamp('10-01-2017 19:31:11.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 0, null, null, 1);
commit;

