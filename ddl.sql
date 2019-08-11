---------------------------------------------
-- Export file for user TEST@ORCL          --
-- Created by s1700 on 2019/8/11, 21:55:33 --
---------------------------------------------

set define off
spool ddl.log

prompt
prompt Creating table MEMBER
prompt =====================
prompt
create table TEST.MEMBER
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  name     VARCHAR2(20),
  nickname VARCHAR2(20),
  phonenum VARCHAR2(20),
  email    VARCHAR2(20)
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
alter table TEST.MEMBER
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
prompt Creating table PRODUCT
prompt ======================
prompt
create table TEST.PRODUCT
(
  id            VARCHAR2(32) default SYS_GUID() not null,
  productnum    VARCHAR2(50) not null,
  productname   VARCHAR2(50),
  cityname      VARCHAR2(50),
  departuretime TIMESTAMP(6),
  productprice  NUMBER,
  productdesc   VARCHAR2(500),
  productstatus INTEGER
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
alter table TEST.PRODUCT
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
alter table TEST.PRODUCT
  add constraint PRODUCT unique (ID, PRODUCTNUM)
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
prompt Creating table ORDERS
prompt =====================
prompt
create table TEST.ORDERS
(
  id          VARCHAR2(32) default SYS_GUID() not null,
  ordernum    VARCHAR2(20) not null,
  ordertime   TIMESTAMP(6),
  peoplecount INTEGER,
  orderdesc   VARCHAR2(500),
  paytype     INTEGER,
  orderstatus INTEGER,
  productid   VARCHAR2(32),
  memberid    VARCHAR2(32)
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
alter table TEST.ORDERS
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
alter table TEST.ORDERS
  add unique (ORDERNUM)
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
alter table TEST.ORDERS
  add foreign key (PRODUCTID)
  references TEST.PRODUCT (ID);
alter table TEST.ORDERS
  add foreign key (MEMBERID)
  references TEST.MEMBER (ID);

prompt
prompt Creating table TRAVELLER
prompt ========================
prompt
create table TEST.TRAVELLER
(
  id              VARCHAR2(32) default SYS_GUID() not null,
  name            VARCHAR2(20),
  sex             VARCHAR2(20),
  phonenum        VARCHAR2(20),
  credentialstype INTEGER,
  credentialsnum  VARCHAR2(50),
  travellertype   INTEGER
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
alter table TEST.TRAVELLER
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
prompt Creating table ORDER_TRAVELLER
prompt ==============================
prompt
create table TEST.ORDER_TRAVELLER
(
  orderid     VARCHAR2(32) not null,
  travellerid VARCHAR2(32) not null
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
alter table TEST.ORDER_TRAVELLER
  add primary key (ORDERID, TRAVELLERID)
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
alter table TEST.ORDER_TRAVELLER
  add foreign key (ORDERID)
  references TEST.ORDERS (ID);
alter table TEST.ORDER_TRAVELLER
  add foreign key (TRAVELLERID)
  references TEST.TRAVELLER (ID);

prompt
prompt Creating table PERMISSION
prompt =========================
prompt
create table TEST.PERMISSION
(
  id             VARCHAR2(32) default SYS_GUID() not null,
  permissionname VARCHAR2(50),
  url            VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table TEST.PERMISSION
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table ROLE
prompt ===================
prompt
create table TEST.ROLE
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  rolename VARCHAR2(50),
  roledesc VARCHAR2(50)
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
alter table TEST.ROLE
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
prompt Creating table ROLE_PERMISSION
prompt ==============================
prompt
create table TEST.ROLE_PERMISSION
(
  permissionid VARCHAR2(32) not null,
  roleid       VARCHAR2(32) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table TEST.ROLE_PERMISSION
  add primary key (PERMISSIONID, ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table TEST.ROLE_PERMISSION
  add foreign key (PERMISSIONID)
  references TEST.PERMISSION (ID);
alter table TEST.ROLE_PERMISSION
  add foreign key (ROLEID)
  references TEST.ROLE (ID);

prompt
prompt Creating table SYSLOG
prompt =====================
prompt
create table TEST.SYSLOG
(
  id            VARCHAR2(32) default SYS_GUID() not null,
  visittime     TIMESTAMP(6),
  username      VARCHAR2(50),
  ip            VARCHAR2(30),
  url           VARCHAR2(50),
  executiontime INTEGER,
  method        VARCHAR2(200)
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
alter table TEST.SYSLOG
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
prompt Creating table USERS
prompt ====================
prompt
create table TEST.USERS
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  email    VARCHAR2(50) not null,
  username VARCHAR2(50),
  password VARCHAR2(500),
  phonenum VARCHAR2(20),
  status   INTEGER
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
alter table TEST.USERS
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
alter table TEST.USERS
  add unique (EMAIL)
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
prompt Creating table USERS_ROLE
prompt =========================
prompt
create table TEST.USERS_ROLE
(
  userid VARCHAR2(32) not null,
  roleid VARCHAR2(32) not null
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
alter table TEST.USERS_ROLE
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
alter table TEST.USERS_ROLE
  add foreign key (USERID)
  references TEST.USERS (ID);
alter table TEST.USERS_ROLE
  add foreign key (ROLEID)
  references TEST.ROLE (ID);


spool off
