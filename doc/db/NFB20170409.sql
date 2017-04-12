--------------------------------------------
-- Export file for user NFB               --
-- Created by cjmei on 2017/4/9, 19:23:04 --
--------------------------------------------

spool NFB20170409.log

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
  SORT      NUMBER(2) default 0,
  NOTE      NVARCHAR2(200),
  ISQUERY   VARCHAR2(50)
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
comment on column NFB.TB_AUTOCODE_ATTR.ISQUERY
  is '�Ƿ��ǲ�ѯ�ֶ� NO������ YES����';
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
  PARENTPACKAGE  VARCHAR2(50),
  DESCRIPTION    NVARCHAR2(350),
  ISAUTO         NUMBER(1) default 1
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
  is '0��������  1������';
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
prompt Creating table TB_IMAGE
prompt =======================
prompt
create table NFB.TB_IMAGE
(
  PICID      VARCHAR2(50) not null,
  PICNAME    VARCHAR2(255),
  PICURL     VARCHAR2(255),
  CREATETIME TIMESTAMP(6),
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
alter table NFB.TB_IMAGE
  add primary key (PICID)
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
  is 'ͼƬ����  1����ͼ  2����ͼ';
comment on column NFB.TB_MALL_GOOD_IMG.SORT
  is '����';

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
  is 'SKU����';
comment on column NFB.TB_MALL_GOOD_INFO.ONSALE_STATUS
  is '�ϼ�״̬  1���ϼ�  2��δ�ϼ�  3���¼� ';
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
prompt Creating table TB_NOTE_REMINDER
prompt ===============================
prompt
create table NFB.TB_NOTE_REMINDER
(
  ID             VARCHAR2(50) not null,
  REMIND_TYPE    NUMBER(2),
  CALENDAR_TYPE  NUMBER(1) default 0,
  REMIND_DATE    VARCHAR2(50),
  REMIND_TIME    VARCHAR2(30),
  IS_REPEAT      NUMBER(1) default 0,
  REMIND_CONTENT NVARCHAR2(200),
  BEFORE_DAYS    NUMBER(3),
  IS_BEFORE      NUMBER(1) default 0,
  CREATETIME     TIMESTAMP(6),
  UPDATETIME     TIMESTAMP(6),
  CREATOR        NVARCHAR2(100),
  NEEDFLAG       NUMBER(1) default 1,
  HOLIDAY_TYPE   NUMBER(4) default 0
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
comment on column NFB.TB_NOTE_REMINDER.REMIND_TYPE
  is '	0����ͨ 1����������';
comment on column NFB.TB_NOTE_REMINDER.CALENDAR_TYPE
  is '0:���� 1��ũ��';
comment on column NFB.TB_NOTE_REMINDER.IS_REPEAT
  is '0�����ظ� 1���ظ���Ĭ�ϲ��ظ�';
comment on column NFB.TB_NOTE_REMINDER.IS_BEFORE
  is '0������ǰ 1����ǰ';
comment on column NFB.TB_NOTE_REMINDER.NEEDFLAG
  is '1:���� 0��������';
comment on column NFB.TB_NOTE_REMINDER.HOLIDAY_TYPE
  is '������������ 1������';
alter table NFB.TB_NOTE_REMINDER
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
  COMPANYID  VARCHAR2(50),
  ORGTYPE    NUMBER(1) default 0,
  ISMAIN     NUMBER(1) default 0,
  CHILDNUM   NUMBER(4) default 0
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
  is '0:���� 1������';
comment on column NFB.TB_ORG_INFO.LVL
  is '��߹���Ա';
comment on column NFB.TB_ORG_INFO.ORGTYPE
  is '0:��ͨ��֯  1����˾';
comment on column NFB.TB_ORG_INFO.ISMAIN
  is '0:���� 1������˾';
comment on column NFB.TB_ORG_INFO.CHILDNUM
  is '�ӽڵ���';
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
  is '����';
comment on column NFB.TB_SYS_CONF.CVALUE
  is '����ֵ';
comment on column NFB.TB_SYS_CONF.CKEYNAME
  is '��������';
comment on column NFB.TB_SYS_CONF.COMPANYID
  is '��������';
comment on column NFB.TB_SYS_CONF.CREATETIME
  is '����ʱ��';
comment on column NFB.TB_SYS_CONF.UPDATETIME
  is '����ʱ��';
comment on column NFB.TB_SYS_CONF.CREATOR
  is '������';
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
  is '����';
comment on column NFB.TB_SYS_DATADIR_INFO.PARENTKEY
  is '������';
comment on column NFB.TB_SYS_DATADIR_INFO.CVALUE
  is '����ֵ';
comment on column NFB.TB_SYS_DATADIR_INFO.COMPANYID
  is '��������';
comment on column NFB.TB_SYS_DATADIR_INFO.SORT
  is '����';
comment on column NFB.TB_SYS_DATADIR_INFO.CREATETIME
  is '����ʱ��';
comment on column NFB.TB_SYS_DATADIR_INFO.UPDATETIME
  is '����ʱ��';
comment on column NFB.TB_SYS_DATADIR_INFO.CREATOR
  is '������';
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
prompt Creating table TB_SYS_FUNC_BAK
prompt ==============================
prompt
create table NFB.TB_SYS_FUNC_BAK
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
  is '��˾ID';
comment on column NFB.TB_SYS_LOG.SOURCE
  is '��Դ0:�ڹܣ�1��Ϣ���� 2��ǰ��';
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
  FANID       VARCHAR2(64),
  ROLEID      VARCHAR2(50),
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
comment on column NFB.TB_SYS_USER.FANID
  is '��˿ID';
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
  is '�˺�';
comment on column NFB.TB_WX_ACCOUNT.ACCOUNTNAME
  is '����';
comment on column NFB.TB_WX_ACCOUNT.AUTHDOMAIN
  is '����';
comment on column NFB.TB_WX_ACCOUNT.URL
  is '�ص�·��';
comment on column NFB.TB_WX_ACCOUNT.CREATOR
  is '������';
comment on column NFB.TB_WX_ACCOUNT.CREATETIME
  is '����ʱ��';
comment on column NFB.TB_WX_ACCOUNT.SERVER_CONTEXT
  is '����������';
comment on column NFB.TB_WX_ACCOUNT.WX_ACCTNO
  is '΢�ź�';
comment on column NFB.TB_WX_ACCOUNT.IS_SERVICE
  is '1:�ṩ����0�����ṩ����';
comment on column NFB.TB_WX_ACCOUNT.ACCTTYPE
  is '0:����� 1����ҵ�� 2:���ĺ�';
comment on column NFB.TB_WX_ACCOUNT.ORGID
  is '��֯ID';
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
  DELFLAG    NUMBER(1) default 1,
  CKEYNAME   VARCHAR2(500)
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
  FANID        VARCHAR2(50),
  C_TYPE       NUMBER(1),
  USERID       VARCHAR2(50),
  C_CONTENT    VARCHAR2(2048),
  CREATETIME   TIMESTAMP(6),
  C_REPLAYTYPE VARCHAR2(50),
  SESSION_ID   VARCHAR2(50),
  OPENID       VARCHAR2(50),
  ACCOUNTID    VARCHAR2(50),
  IS_REPLAY    NUMBER(1) default 0
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
comment on column NFB.TB_WX_CHAT_MSG.IS_REPLAY
  is '�Ƿ�ظ� 0��δ�ظ� 1���ظ�';
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

prompt
prompt Creating table TB_WX_CHAT_SESSION
prompt =================================
prompt
create table NFB.TB_WX_CHAT_SESSION
(
  SESSION_ID VARCHAR2(50) not null,
  ACCOUNTID  VARCHAR2(50),
  OPENID     VARCHAR2(50),
  CREATETIME TIMESTAMP(6),
  CREATELONG NUMBER(10),
  UPDATETIME TIMESTAMP(6),
  C_CONTENT  VARCHAR2(2048),
  ENDTIME    TIMESTAMP(6),
  FANID      VARCHAR2(50),
  FLAG       NUMBER(1) default 0
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
comment on column NFB.TB_WX_CHAT_SESSION.FLAG
  is '0:�ػ� 1���ǻػ�';
alter table NFB.TB_WX_CHAT_SESSION
  add primary key (SESSION_ID)
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
  ID           VARCHAR2(64) not null,
  ACCOUNTID    VARCHAR2(64),
  TEMPLATE_ID  VARCHAR2(64),
  TOUSER       VARCHAR2(64),
  URL          VARCHAR2(1024),
  DATA         VARCHAR2(2048),
  NEEDFLAG     NUMBER(1) default 1,
  SENDFLAG     NUMBER(1) default 0,
  SENDTIMES    NUMBER(1) default 0,
  CREATETIME   DATE,
  SENDTIME     DATE,
  MSGID        VARCHAR2(64),
  PUSH_CODE    VARCHAR2(64),
  PUSH_MSG     VARCHAR2(1024),
  RESULTCODE   VARCHAR2(64),
  RESULTMSG    VARCHAR2(1024),
  NOTE         VARCHAR2(528),
  RESULTTIME   DATE,
  CREATE_STAMP NUMBER(10)
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
comment on column NFB.TB_WX_MODULE_MSG.CREATE_STAMP
  is '����ʱ���';
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
  is '0������ 1��ʧЧ';
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
  DAIRYFLAG     NUMBER(1) default 0,
  FANID         VARCHAR2(50)
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
  is '��������ʶ 0������ 1���ڻ�';
comment on column NFB.TB_WX_USER.DAIRYFLAG
  is '�ռ����ѱ�ʶ 1������ 0��������';
comment on column NFB.TB_WX_USER.FANID
  is '��˿ID';
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
start with 1000027
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
start with 100000025
increment by 1
nocache
cycle;

prompt
prompt Creating sequence SEQ_WX_USER
prompt =============================
prompt
create sequence NFB.SEQ_WX_USER
minvalue 1
maxvalue 9999999999999999999999
start with 100000006
increment by 1
nocache;

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



CREATE TABLE tb_pay_alipay_log (
ID VARCHAR2(64 BYTE) NOT NULL ,
TRADE_NO VARCHAR2(100 BYTE) NOT NULL ,
ORDERID VARCHAR2(100 BYTE) NOT NULL ,
NOTIFY_ID VARCHAR2(100 BYTE) NULL ,
NOTIFY_NAME VARCHAR2(100 BYTE) NULL ,
NOTIFY_TYPE VARCHAR2(100 BYTE) NULL ,
TRADE_STATUS VARCHAR2(100 BYTE) NULL ,
TOTAL_FEE VARCHAR2(100 BYTE) NULL ,
GMT_PAYMENT VARCHAR2(100 BYTE) NULL ,
BUYER_EMAIL VARCHAR2(100 BYTE) NULL ,
BUYER_ID VARCHAR2(100 BYTE) NULL ,
CREATETIME VARCHAR2(50 BYTE) NULL ,
NOTIFY_TIME VARCHAR2(50 BYTE) NULL ,
PRIMARY KEY (ID)
);
CREATE TABLE tb_pay_UNIONPAY_LOG (
	ORDERID VARCHAR2 (50 BYTE) NOT NULL,
	TXNTIME VARCHAR2 (14 BYTE) NOT NULL,
	TXNTYPE VARCHAR2 (2 BYTE) NULL,
	TXNSUBTYPE VARCHAR2 (2 BYTE) NULL,
	BIZTYPE VARCHAR2 (6 BYTE) NULL,
	MERID VARCHAR2 (15 BYTE) NULL,
	TXNAMT VARCHAR2 (20 BYTE) NULL,
	QUERYID VARCHAR2 (50 BYTE) NULL,
	RESPCODE VARCHAR2 (2 BYTE) NULL,
	RESPMSG VARCHAR2 (2048 BYTE) NULL,
	SETTLEAMT VARCHAR2 (20 BYTE) NULL,
	SETTLEDATE VARCHAR2 (14 BYTE) NULL,
	TRACENO VARCHAR2 (6 BYTE) NULL,
	TRACETIME VARCHAR2 (14 BYTE) NULL,
	ACCNO VARCHAR2 (100 BYTE) NULL,
	STATUS CHAR (1 BYTE) NULL,
	CREATEDATE DATE NULL,
	CUSTOMERNM VARCHAR2 (50 BYTE) NULL,
	CHANNELTYPE VARCHAR2 (10 BYTE) NULL,
	REQRESERVED VARCHAR2 (50 BYTE) NULL,
	PRIMARY KEY (ORDERID, TXNTIME)
)

spool off