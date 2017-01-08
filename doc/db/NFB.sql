--------------------------------------------
-- Export file for user NFB               --
-- Created by cjmei on 2017/1/8, 21:59:09 --
--------------------------------------------

spool NFB.log

prompt
prompt Creating table TB_AUTOCODE_ATTR
prompt ===============================
prompt
create table NFB.TB_AUTOCODE_ATTR
(
  ATTRNAME  VARCHAR2(50) not null,
  ATTRTYPE  VARCHAR2(50),
  ISPK      NUMBER(1) default 0,
  SEQ       VARCHAR2(50),
  ATTRSIZE  NUMBER(4),
  ATTRDESC  VARCHAR2(50),
  TABLENAME VARCHAR2(50) not null,
  SORT      NUMBER(2) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_AUTOCODE_ATTR
  add primary key (ATTRNAME, TABLENAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_AUTOCODE_BEAN
prompt ===============================
prompt
create table NFB.TB_AUTOCODE_BEAN
(
  TABLENAME      VARCHAR2(50) not null,
  BEANNAME       VARCHAR2(50),
  MODULEDESC     VARCHAR2(1024),
  IS_CREATETABLE NUMBER(1) default 0,
  CREATETIME     DATE,
  IS_AUTH        NUMBER(1),
  UPDATETIME     DATE,
  PARENTPACKAGE  VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_AUTOCODE_BEAN.IS_CREATETABLE
  is '0：不生成  1：生成';
alter table NFB.TB_AUTOCODE_BEAN
  add primary key (TABLENAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_MALL_ADVISE
prompt =============================
prompt
create table NFB.TB_MALL_ADVISE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_MALL_ADVISE
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_MALL_GOOD_IMG
prompt ===============================
prompt
create table NFB.TB_MALL_GOOD_IMG
(
  ID         VARCHAR2(50) not null,
  GOODID     VARCHAR2(50),
  IMGTYPE    NUMBER(1),
  IMGURL     VARCHAR2(255),
  CREATETIME DATE,
  SORT       NUMBER(2),
  IMGNAME    VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_MALL_GOOD_IMG.IMGTYPE
  is '图片类型  1：主图  2：详图';
comment on column NFB.TB_MALL_GOOD_IMG.SORT
  is '排序';

prompt
prompt Creating table TB_MALL_GOOD_INFO
prompt ================================
prompt
create table NFB.TB_MALL_GOOD_INFO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_MALL_GOOD_INFO.SKU_NUM
  is 'SKU编码';
comment on column NFB.TB_MALL_GOOD_INFO.ONSALE_STATUS
  is '上架状态  1：上架  2：未上架  3：下架 ';
alter table NFB.TB_MALL_GOOD_INFO
  add primary key (GOODID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_NOTE_DIARY
prompt ============================
prompt
create table NFB.TB_NOTE_DIARY
(
  ID         VARCHAR2(50) not null,
  TITLE      NVARCHAR2(1024),
  UPDATETIME TIMESTAMP(6),
  CREATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(50),
  CONTENT    NVARCHAR2(2000),
  MOBILE     VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_NOTE_DIARY
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_NOTE_GAINS
prompt ============================
prompt
create table NFB.TB_NOTE_GAINS
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_NOTE_GAINS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_NOTE_QUESTION
prompt ===============================
prompt
create table NFB.TB_NOTE_QUESTION
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_NOTE_QUESTION
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_ORG_INFO
prompt ==========================
prompt
create table NFB.TB_ORG_INFO
(
  ORGID      VARCHAR2(50) not null,
  CREATOR    VARCHAR2(50),
  ORGNAME    VARCHAR2(256),
  CREATETIME DATE,
  UPDATETIME DATE,
  USEFLAG    NUMBER(1) default 1,
  PARENTID   VARCHAR2(50) default 0,
  LVL        NUMBER(1) default 1,
  COMPANYID  VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_ORG_INFO.USEFLAG
  is '0:禁用 1：启用';
comment on column NFB.TB_ORG_INFO.LVL
  is '最高管理员';
alter table NFB.TB_ORG_INFO
  add primary key (ORGID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_CONF
prompt ==========================
prompt
create table NFB.TB_SYS_CONF
(
  CKEY       VARCHAR2(50) not null,
  CVALUE     VARCHAR2(2000),
  CKEYNAME   VARCHAR2(100),
  COMPANYID  VARCHAR2(50),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_SYS_CONF.CKEY
  is '主键';
comment on column NFB.TB_SYS_CONF.CVALUE
  is '主键值';
comment on column NFB.TB_SYS_CONF.CKEYNAME
  is '主键名称';
comment on column NFB.TB_SYS_CONF.COMPANYID
  is '主键类型';
comment on column NFB.TB_SYS_CONF.CREATETIME
  is '创建时间';
comment on column NFB.TB_SYS_CONF.UPDATETIME
  is '更新时间';
comment on column NFB.TB_SYS_CONF.CREATOR
  is '创建者';
alter table NFB.TB_SYS_CONF
  add primary key (CKEY)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_DATADIR_INFO
prompt ==================================
prompt
create table NFB.TB_SYS_DATADIR_INFO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_SYS_DATADIR_INFO.CKEY
  is '主键';
comment on column NFB.TB_SYS_DATADIR_INFO.PARENTKEY
  is '父主键';
comment on column NFB.TB_SYS_DATADIR_INFO.CVALUE
  is '主键值';
comment on column NFB.TB_SYS_DATADIR_INFO.COMPANYID
  is '类型名称';
comment on column NFB.TB_SYS_DATADIR_INFO.SORT
  is '排序';
comment on column NFB.TB_SYS_DATADIR_INFO.CREATETIME
  is '创建时间';
comment on column NFB.TB_SYS_DATADIR_INFO.UPDATETIME
  is '更新时间';
comment on column NFB.TB_SYS_DATADIR_INFO.CREATOR
  is '创建者';
alter table NFB.TB_SYS_DATADIR_INFO
  add primary key (CKEY, PARENTKEY)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_FUNC
prompt ==========================
prompt
create table NFB.TB_SYS_FUNC
(
  FUNCID     VARCHAR2(50) not null,
  MENUID     VARCHAR2(50) not null,
  OPERID     VARCHAR2(50) not null,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  URL        VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_FUNC
  add primary key (FUNCID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_TB_SYS_FUNC_URL on NFB.TB_SYS_FUNC (URL)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_LOG
prompt =========================
prompt
create table NFB.TB_SYS_LOG
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_SYS_LOG.RETAIN3
  is '公司ID';
comment on column NFB.TB_SYS_LOG.SOURCE
  is '来源0:内管，1消息中心 2：前端';
alter table NFB.TB_SYS_LOG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_LOG_PARAM
prompt ===============================
prompt
create table NFB.TB_SYS_LOG_PARAM
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_LOG_PARAM
  add primary key (URL, SOURCE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_MENU
prompt ==========================
prompt
create table NFB.TB_SYS_MENU
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_MENU
  add primary key (MENUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_OPERATE
prompt =============================
prompt
create table NFB.TB_SYS_OPERATE
(
  OPERNAME   VARCHAR2(50) not null,
  OPERID     VARCHAR2(50) not null,
  PICICON    VARCHAR2(50),
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50),
  SORT       NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_OPERATE
  add primary key (OPERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_ROLE
prompt ==========================
prompt
create table NFB.TB_SYS_ROLE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_ROLE
  add primary key (ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_ROLE_FUNC
prompt ===============================
prompt
create table NFB.TB_SYS_ROLE_FUNC
(
  ROLEID     VARCHAR2(50) not null,
  FUNCID     VARCHAR2(50) not null,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_ROLE_FUNC
  add primary key (ROLEID, FUNCID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER
prompt ==========================
prompt
create table NFB.TB_SYS_USER
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
  USERTYPE    VARCHAR2(50),
  SKIN        NUMBER(2) default 0,
  BINDFLAG    NUMBER(1) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_USER
  add primary key (USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER_ORG
prompt ==============================
prompt
create table NFB.TB_SYS_USER_ORG
(
  USERID     VARCHAR2(50) not null,
  ORGID      VARCHAR2(50) not null,
  CREATETIME TIMESTAMP(6),
  UPDATETIME TIMESTAMP(6),
  CREATOR    VARCHAR2(150)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_USER_ORG
  add primary key (USERID, ORGID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER_ROLE
prompt ===============================
prompt
create table NFB.TB_SYS_USER_ROLE
(
  USERID     VARCHAR2(50) not null,
  ROLEID     VARCHAR2(50) not null,
  CREATETIME DATE,
  UPDATETIME DATE,
  CREATOR    VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_SYS_USER_ROLE
  add primary key (USERID, ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_TB_SYS_USER_ROLE_USERID on NFB.TB_SYS_USER_ROLE (USERID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_VIP_INFO
prompt ==========================
prompt
create table NFB.TB_VIP_INFO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_VIP_INFO
  add primary key (USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_ACCESS_TOKEN
prompt =================================
prompt
create table NFB.TB_WX_ACCESS_TOKEN
(
  ACCOUNTID   VARCHAR2(100) not null,
  ACCESSTOKEN VARCHAR2(255) not null,
  PUTTIME     VARCHAR2(20) default 0,
  EXPIRES_IN  VARCHAR2(20) default 0,
  UPDATETIME  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_ACCESS_TOKEN
  add primary key (ACCOUNTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_ACCOUNT
prompt ============================
prompt
create table NFB.TB_WX_ACCOUNT
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_WX_ACCOUNT.ACCOUNTID
  is '账号';
comment on column NFB.TB_WX_ACCOUNT.ACCOUNTNAME
  is '名称';
comment on column NFB.TB_WX_ACCOUNT.AUTHDOMAIN
  is '域名';
comment on column NFB.TB_WX_ACCOUNT.URL
  is '回调路径';
comment on column NFB.TB_WX_ACCOUNT.CREATOR
  is '创建者';
comment on column NFB.TB_WX_ACCOUNT.CREATETIME
  is '创建时间';
comment on column NFB.TB_WX_ACCOUNT.SERVER_CONTEXT
  is '访问上下文';
comment on column NFB.TB_WX_ACCOUNT.WX_ACCTNO
  is '微信号';
comment on column NFB.TB_WX_ACCOUNT.IS_SERVICE
  is '1:提供服务，0：不提供服务';
comment on column NFB.TB_WX_ACCOUNT.ACCTTYPE
  is '0:服务号 1：企业号 2:订阅号';
comment on column NFB.TB_WX_ACCOUNT.ORGID
  is '组织ID';
create index NFB.TB_WX_ACCOUNT_NAMEIDX on NFB.TB_WX_ACCOUNT (ACCOUNTNAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_AUTO_REPLAY
prompt ================================
prompt
create table NFB.TB_WX_AUTO_REPLAY
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_AUTO_REPLAY
  add primary key (CTYPE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_AUTO_REPLAY_NEWSITEM
prompt =========================================
prompt
create table NFB.TB_WX_AUTO_REPLAY_NEWSITEM
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_AUTO_REPLAY_NEWSITEM
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_CHAT_MSG
prompt =============================
prompt
create table NFB.TB_WX_CHAT_MSG
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_CHAT_MSG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_CHAT_MSG_ACCOUNTID on NFB.TB_WX_CHAT_MSG (ACCOUNTID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_CHAT_MSG_FROMUSER on NFB.TB_WX_CHAT_MSG (FROMUSERNAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_CHAT_MSG_TOUSER on NFB.TB_WX_CHAT_MSG (TOUSERNAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_CHAT_NEWS_MSG
prompt ==================================
prompt
create table NFB.TB_WX_CHAT_NEWS_MSG
(
  ID          VARCHAR2(50) not null,
  CHAT_ID     VARCHAR2(50) not null,
  TITLE       VARCHAR2(100),
  DESCRIPTION VARCHAR2(255),
  PICURL      VARCHAR2(100),
  URL         VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_CHAT_NEWS_MSG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_CHAT_NEWS_MSG_CHATID on NFB.TB_WX_CHAT_NEWS_MSG (CHAT_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_MENU
prompt =========================
prompt
create table NFB.TB_WX_MENU
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_MENU
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_MENU_URL
prompt =============================
prompt
create table NFB.TB_WX_MENU_URL
(
  ID        VARCHAR2(50) not null,
  MENUNAME  VARCHAR2(100),
  MENUURL   VARCHAR2(1000),
  ACCOUNTID VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_MENU_URL
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_MODULE_MSG
prompt ===============================
prompt
create table NFB.TB_WX_MODULE_MSG
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_MODULE_MSG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_QRCODE
prompt ===========================
prompt
create table NFB.TB_WX_QRCODE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table NFB.TB_WX_QRCODE
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_TEMPLATE
prompt =============================
prompt
create table NFB.TB_WX_TEMPLATE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_WX_TEMPLATE.STATUS
  is '0：启用 1：失效';
alter table NFB.TB_WX_TEMPLATE
  add primary key (YWTYPE, ACCOUNTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_WX_USER
prompt =========================
prompt
create table NFB.TB_WX_USER
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column NFB.TB_WX_USER.USEFLAG
  is '黑名单标识 0：正常 1：黑户';
comment on column NFB.TB_WX_USER.DAIRYFLAG
  is '日记提醒标识 1：推送 0：不推送';
alter table NFB.TB_WX_USER
  add primary key (OPENID, ACCOUNTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_USER_ISSUBSCRIBE on NFB.TB_WX_USER (ISSUBSCRIBE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_USER_NICKNAME on NFB.TB_WX_USER (NICKNAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index NFB.IDX_WX_USER_SUBSCRIBETIME on NFB.TB_WX_USER (SUBSCRIBETIME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_SYS_USER
prompt ==============================
prompt
create sequence NFB.SEQ_SYS_USER
minvalue 1
maxvalue 9999999999999999999999
start with 1000019
increment by 1
nocache
cycle;

prompt
prompt Creating sequence SEQ_WX_AUTO_REPLAY_NEWS
prompt =========================================
prompt
create sequence NFB.SEQ_WX_AUTO_REPLAY_NEWS
minvalue 1
maxvalue 9999999999999999999999
start with 100000013
increment by 1
nocache
cycle;

prompt
prompt Creating view VIEW_SYS_ROLE_FUNC
prompt ================================
prompt
CREATE OR REPLACE VIEW NFB.VIEW_SYS_ROLE_FUNC AS
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

prompt
prompt Creating view VIEW_SYS_ROLE_MENU
prompt ================================
prompt
CREATE OR REPLACE VIEW NFB.VIEW_SYS_ROLE_MENU AS
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


spool off
