--------------------------------------------
-- Export file for user NFB               --
-- Created by cjmei on 2017/2/23, 7:39:37 --
--------------------------------------------

spool NFB2.log

prompt
prompt Creating sequence SEQ_SYS_USER
prompt ==============================
prompt
create sequence NFB.SEQ_SYS_USER
minvalue 1
maxvalue 9999999999999999999999
start with 1000024
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
start with 100000015
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
