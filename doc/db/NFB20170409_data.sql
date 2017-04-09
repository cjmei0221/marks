prompt PL/SQL Developer import file
prompt Created on 2017年4月9日 by cjmei
set feedback off
set define off
prompt Loading TB_ORG_INFO...
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('N', 'admin', '农富宝', to_date('20-10-2016 20:59:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 20:59:46', 'dd-mm-yyyy hh24:mi:ss'), 1, '0', 1, 'N', 1, 0, 2);
insert into TB_ORG_INFO (ORGID, CREATOR, ORGNAME, CREATETIME, UPDATETIME, USEFLAG, PARENTID, LVL, COMPANYID, ORGTYPE, ISMAIN, CHILDNUM)
values ('Marks', 'admin', '痕迹', to_date('07-01-2017 22:59:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 22:59:45', 'dd-mm-yyyy hh24:mi:ss'), 1, '0', 1, 'Marks', 1, 1, 2);
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
values ('clear_syslog_data', '60', '清理多少天之前的日志数据', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('clear_modulemsg_data', '30', '清理多少天之前的微信模板消息数据', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_modulemsg_time_limit', '60', '多久之前的消息不再推送 单位分钟，默认60分钟', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_modulemsg_push_limitnum', '3', '每条模板消息推送次数，默认3次', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_modulemsg_scan_limitnum', '1000', '微信模板消息一次扫描的记录条数，默认1000条', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('is_open_session', 'Y', '是否启动系统自带人工服务 N：不启动 Y：启动', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('session_time', '15', '人工服务回话时间  单位 分', null, null, null, null);
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('wx_host_url', 'http://127.0.0.1:6080', '访问center功能路径', null, to_date('06-11-2016', 'dd-mm-yyyy'), to_date('08-02-2017 18:31:20', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_CONF (CKEY, CVALUE, CKEYNAME, COMPANYID, CREATETIME, UPDATETIME, CREATOR)
values ('out_log_flag', 'Y', 'output输出标识（Y:输出 N：不输出）', null, to_date('23-02-2017 18:36:35', 'dd-mm-yyyy hh24:mi:ss'), to_date('13-03-2017 21:24:01', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 9 records loaded
prompt Loading TB_SYS_DATADIR_INFO...
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('1', 'holiday_type', '生日', null, 1, to_date('18-03-2017 19:20:37', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-03-2017 19:20:37', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('question_level', '0', '问题级别', null, 2, to_date('30-11-2016 21:40:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:40:15', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('L1', 'question_level', '严重', null, 5, to_date('30-11-2016 21:45:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:45:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('holiday_type', '0', '提醒节日类型', null, 1, to_date('18-03-2017 19:20:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-03-2017 19:20:01', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_DATADIR_INFO (CKEY, PARENTKEY, CVALUE, COMPANYID, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('2', 'holiday_type', '其他节日', null, 2, to_date('18-03-2017 19:21:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-03-2017 19:21:39', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
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
prompt 13 records loaded
prompt Loading TB_SYS_FUNC...
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FB548F9A221041E1A70A0A30D12F3457', '20161016024730740', 'query', to_date('16-10-2016 02:48:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('49A155C4DBBF4A56907BFA4B60B4FAF1', '20161016024730740', 'edit', to_date('16-10-2016 02:48:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:23', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9A05C58D23E64D82A8A0FC1448EB732D', '20161016024730740', 'add', to_date('16-10-2016 02:48:12', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:12', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('699C293D715340D392CD4E113B864D20', '20161016024730740', 'delete', to_date('16-10-2016 02:48:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:48:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C3A5BC0B6477434E9E3942C16353834A', 'diary', 'edit', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/diary/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9CFAB7B9645F4EB48F69A3E900B51CDB', 'diary', 'delete', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/diary/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6BFC445EB2FC46D3B49582B319BB503E', '20161016024730740', 'autoCodeBtn', to_date('20-10-2016 02:10:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 02:10:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/autocode');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0784E15BB48B4061A038499DC17B45C3', 'sysRole', 'edit', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysRole/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('34D4A51F71A3452DA20B5C89272F7121', 'diary', 'query', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/diary/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('729986573F3F498AB804BD1B7CC58466', 'diary', 'add', to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-10-2016 21:08:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/diary/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0EE456741D42426DB6448E5C6DDFDA8E', 'sysRole', 'delete', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysRole/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('40B743A6291A435AAE743CA93499AD8F', 'orgInfo', 'query', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('475B85B975C441E9B720FAC82ECAB89A', 'orgInfo', 'add', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('D5FFAAAD152F4023BDEC443B8CECA7C6', 'sysRole', 'query', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysRole/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('588848E727F14FCAA21623A6894C2DDB', 'sysRole', 'add', to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 03:23:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysRole/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('35EA71BD598246AFB5769EA6730A1254', 'orgInfo', 'edit', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('165FEFC91D0F4A26B232D2A1D59F4D37', 'orgInfo', 'delete', to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 04:04:05', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('D650F41753614EF68D65AD237334627C', 'wxAccount', 'query', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAccount/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('AE5067796D694BAFB287D18529BAFFE2', 'wxAccount', 'add', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAccount/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A9EDBB5CBFAA49CEB53C12A3C516BE85', 'wxAccount', 'edit', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAccount/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7C045D9CA9D5456FAF856490836AA6C8', 'wxAccount', 'delete', to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('20-10-2016 21:24:27', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAccount/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E0214CC842524D61A1CADB4B25F28C6D', '20161023003925948', 'query', to_date('23-10-2016 00:39:48', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:39:48', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/framelist');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('751789E53BAA42428D477E49B00572C5', '20161023003925948', 'add', to_date('23-10-2016 00:39:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:39:59', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('140845F24CC241B7AB3783B93F98724B', '20161023003925948', 'edit', to_date('23-10-2016 00:40:09', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:40:09', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2DA34B5B4BF643E89DD5B6C791CD630A', '20161023003925948', 'delete', to_date('23-10-2016 00:40:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:40:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/orgInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4C7AA4B348454752BEF6F9EC55402280', 'sysRole', 'addFunc', to_date('23-10-2016 00:47:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 00:47:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysRole/funclist');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C58C67CD6EA94BB2963C9714C6F9F90B', 'goodInfo', 'query', to_date('26-10-2016 21:13:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/goodInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3DA8897C41E8473A99C5492100190412', 'goodInfo', 'add', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/goodInfo/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2309E4BC9A924651B31F785C830728B6', 'goodInfo', 'edit', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/goodInfo/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0F54D4F78A8D491FA43C3FBF60A9B1CF', 'goodInfo', 'delete', to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/goodInfo/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E24E30A2E2674303B6C9B62B36D79ADC', 'advise', 'query', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/advise/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8890D1E058DB4B7894B2D7B2BCC696A7', 'advise', 'add', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/advise/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A10AF55DA5C548E294DBD10A10F92E46', 'advise', 'edit', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/advise/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('062D833DD050478A8B6D5503CD347F60', 'advise', 'delete', to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('26-10-2016 21:13:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/advise/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2DFE8F4215A34E4AB1A603C36242F923', 'wxMenu', 'syncWx', to_date('17-11-2016 19:03:58', 'dd-mm-yyyy hh24:mi:ss'), to_date('17-11-2016 19:03:58', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenu/syncWxMenu');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0CC56B98214E4C8FB8439F341AFEEE28', 'vipInfo', 'resetPwdBtn', to_date('08-01-2017 21:40:52', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 21:40:52', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/resetPwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('575ED5D781A844478D16F7D7118AE210', 'wxChatSession', 'query', to_date('12-03-2017 11:23:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-03-2017 11:23:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxChatSession/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('633836EDCC0E40329B2BEBB34FA2B5FB', '2', 'add', to_date('23-10-2016 18:03:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:03:59', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('DA0BA7D60DD6461E85EA1EFB4E56AC1D', '2', 'edit', to_date('23-10-2016 18:04:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:04:19', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6232F8C5272A489CB66E54091718E5AD', '2', 'query', to_date('23-10-2016 18:03:47', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 18:03:47', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysMenu/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('831A77AF2FB5418FB6290E19ACB03F72', 'sysUser', 'edit', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7F15BED5384E401AA13B8FE99FDD79E5', 'sysUser', 'delete', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FA00FAE5BE8249519544EAB937CED130', 'sysUser', 'query', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('81F44FFCFB484D1B9B2B28B8B44038FD', 'sysUser', 'add', to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-10-2016 17:41:22', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9B746C1302684616B012733A4E791179', 'goodInfo', 'onsaleBtn', to_date('07-12-2016 20:31:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-12-2016 20:31:07', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/goodSale/onsale');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A4847B5D9E2C404BAFFCA1925B4C651B', '20161203195018623', 'edit', to_date('03-12-2016 19:54:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:54:50', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/updatePwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6061F2E92C214F4E98AA9F8A6862CD58', '20161203195318395', 'edit', to_date('03-12-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:56:02', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/updateMobile');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A0BEFFBB0FDA42F38280FBE35A670977', 'wxAccount', 'syncWxFans', to_date('22-12-2016 22:30:28', 'dd-mm-yyyy hh24:mi:ss'), to_date('22-12-2016 22:30:28', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxUser/sync');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('81B28ED45F1A427ABBA9025E4D917AD0', 'sysLogParam', 'add', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysLogParam/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('351B1DF16E6444258F142C4FD767FCEE', 'sysLogParam', 'query', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysLogParam/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A6907ADFCD4B4E048DDA0632C2D5062F', 'sysLogParam', 'edit', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysLogParam/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('5AA2258E1404444BAE135783DD56DC03', 'sysLogParam', 'delete', to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-01-2017 20:48:32', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysLogParam/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('92078E74B6784886BA2956AE553BFA69', '20160928203125806', 'query', to_date('30-09-2016 14:38:50', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:38:50', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysOperate/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A716C1E44907420AAD6CA5AC638541C8', '20160928203125806', 'add', to_date('30-09-2016 14:39:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:39:01', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysOperate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('7EF6056FFFDE4EE6BBF84F86EF66BF28', '20160928203125806', 'edit', to_date('30-09-2016 14:39:06', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 14:39:06', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysOperate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0073BE06AA6A49D783E9E033131A5C57', '2', 'addFunc', to_date('30-09-2016 15:43:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 15:43:44', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysMenu/initFunc');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C1060CF0D3CE49A19BB7AEB3AF622B0C', '2', 'delete', to_date('30-09-2016 15:45:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 15:45:46', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysMenu/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('37A16BCD5D0E462EB892CDC9BB3D28EA', '20160928203125806', 'delete', to_date('30-09-2016 16:11:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-09-2016 16:11:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysOperate/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A3E3FFABB3264BEC9D20C47EA542B2F0', 'moduleMsg', 'query', to_date('28-11-2016 19:23:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-11-2016 19:23:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/moduleMsg/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E9AFCA0B219A48F2B26C3407B89F6D4F', 'vipInfo', 'query', to_date('08-01-2017 19:55:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 19:55:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/vipInfo/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F76059071E814CBF8DB6623DD26C04C6', 'wxChatMsg', 'add', to_date('11-03-2017 21:12:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-03-2017 21:12:16', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxChatMsg/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3E71A3CE7AB34607BDC570E72EBB6444', 'qrcode', 'add', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/qrcode/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('AFF47427547E413D8A4E6E9D8658BB17', 'qrcode', 'query', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/qrcode/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F43CE8D5ABDB46148E26B8C6A7C513D7', 'wxMenu', 'query', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenu/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CB28B8D3B8E846C7A355249B8A6D14BC', 'wxMenu', 'add', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenu/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('374088A1D165445AB7496D87B9A5175E', 'wxMenu', 'edit', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenu/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('58F8C1A54B244D07986F391AD5CB9E5D', 'wxUser', 'query', to_date('06-11-2016 19:11:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 19:11:31', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxUser/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('2B12F2FF49C242F4963A550AC1AA4D52', 'qrcode', 'edit', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/qrcode/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E5934CC56BEF43ECBF47AC07890713AC', 'wxMenu', 'delete', to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenu/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('0C86A52B779342DA92F4F6027B3251FE', 'wxMenuUrl', 'query', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenuUrl/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('805B2E58E7CB46CFAC9629FE35F9E051', 'wxMenuUrl', 'add', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenuUrl/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('21B1268FD84F4B1C8945C8E9731F0F49', 'wxMenuUrl', 'edit', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenuUrl/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F9B4C69C5F864657A55BF9560AAD7AC9', 'wxMenuUrl', 'delete', to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxMenuUrl/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('34CC225109974D0296DD538ED1A229C0', 'wxAutoReplay', 'query', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAutoReplay/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('941ABAFE35D6480B95D0178B760BB1DB', 'wxAutoReplay', 'add', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAutoReplay/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('56AF2BA7BBD643D8B66F1FEDB2F8D650', 'wxAutoReplay', 'edit', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAutoReplay/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A88AB1777C264C8387A4CF7B9C961048', 'wxAutoReplay', 'delete', to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:40', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxAutoReplay/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A3FEA09B72BA41868AA07D6818117AC0', 'newsItem', 'query', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/newsItem/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('FB4C99E9FB1A42F19B86FFC3DA761824', 'newsItem', 'add', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/newsItem/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8D4EC97F07AA48C0BA5F5F55A302532E', 'newsItem', 'edit', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/newsItem/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('6FB911AF50884CB9B52D3A6D9D3D4B03', 'newsItem', 'delete', to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), to_date('06-11-2016 21:45:45', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/newsItem/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('55371B38A22F4D078947A10E51837D47', 'qrcode', 'delete', to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('25-11-2016 11:34:29', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/qrcode/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('18B306C4A74149609A3FDC36F86F902A', 'sysConf', 'query', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysConf/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B0E3BAAA2955492FADE23C35F774BCC3', 'sysConf', 'add', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysConf/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B31E5C8F9DDB434CA70DDCC8204A74F3', 'sysConf', 'edit', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysConf/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('431D29CBA6B64D92821180C1DB4335DE', 'sysConf', 'delete', to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:30', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysConf/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F52536BB355D4216AA5F541601ABA4E0', 'dataDir', 'query', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/dataDir/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('C50921BE08CE4C47BEC824DA733F4CFD', 'dataDir', 'add', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/dataDir/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('88EA18C8BA4847119DEFC9146B7C7F1F', 'dataDir', 'edit', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/dataDir/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('3EC98DB80F6440269D3628766217A68E', 'dataDir', 'delete', to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 17:53:51', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/dataDir/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('A947C38F31814E67830E922BA2FD5926', 'wxTemplate', 'query', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxTemplate/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('352724802F66473AA600570AB00C61D4', 'wxTemplate', 'add', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxTemplate/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CB6D94D479C34121A38F5B40B91106D2', 'wxTemplate', 'edit', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxTemplate/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('8B31D84CC47A466C8132F6C0D212D442', 'wxTemplate', 'delete', to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:52:15', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxTemplate/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('440141C13AB345BC991774CDD7614909', 'question', 'query', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/question/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('E95BB25BFFAF4C13864DBC3A02B9306D', 'question', 'add', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/question/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CD2780A03F02413E9D18F66323064595', 'question', 'edit', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/question/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F26FD1B3DCBF43D38E37529BC60E12F3', 'question', 'delete', to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:07:18', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/question/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('BFBB32ADDE9C42B4ADECACACC04DF0A5', 'gains', 'edit', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/gains/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('56FC1334D6A54B28B41C552156EA7E2C', 'gains', 'delete', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/gains/delete');
commit;
prompt 100 records committed...
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('B527659F90594CD4844E2A2F22223E2A', 'vipInfo', 'activeBtn', to_date('08-01-2017 21:42:39', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 21:42:39', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/updateActiveFlag');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('F2B99E17C4EC4CB399A1F4D435C28909', 'gains', 'query', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/gains/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9E081346B9F5409EB8E8D79A988515E3', 'gains', 'add', to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-12-2016 21:13:00', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/gains/save');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CF44B5BC126F4E6B9B9C976AA0F6D459', 'wxChatMsg', 'query', to_date('12-03-2017 21:59:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-03-2017 21:59:23', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxChatSession/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('86BC5FE8B3624C5B96922DA0D299D843', 'sysLog', 'query', to_date('27-11-2016 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), to_date('27-11-2016 21:09:57', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysLog/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CC56C8DA7CCE474BB86FCFF73ECD3D26', 'reminder', 'edit', to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/reminder/update');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('10ACD5DC793A4D5A9F4228195CF57B77', 'wxUser', 'dairyBtn', to_date('03-12-2016 18:50:26', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 18:50:26', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/wxUser/dairy');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('028280270812450986EE5E8552E692EC', 'sysUser', 'resetPwdBtn', to_date('03-12-2016 19:27:01', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:27:01', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/sysUser/resetPwd');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('12334FC4E13E4F94B649DDEAC18AB3D2', 'reminder', 'delete', to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/reminder/delete');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('9AC1C6253D034F49B9CA958923A923FC', 'reminder', 'query', to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/reminder/list');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('4A911E4E08FE45BF95EE3CC1BA5F3B78', '20161016024730740', 'introBtn', to_date('09-01-2017 23:03:44', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-01-2017 23:03:44', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/autoCode/autocodeIntroFile');
insert into TB_SYS_FUNC (FUNCID, MENUID, OPERID, CREATETIME, UPDATETIME, CREATOR, URL)
values ('CADEF9328DCE4870BC463AA8D3F8D28D', 'reminder', 'add', to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), null, '/inner/reminder/save');
commit;
prompt 112 records loaded
prompt Loading TB_SYS_LOG_PARAM...
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/createWXMenu', 1, '微信菜单', '创建', to_timestamp('07-01-2017 21:13:26.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:49:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '0FA563075BA242B5BCEA8BA88278E299');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/login', 2, '痕迹', '登录', to_timestamp('07-01-2017 21:38:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:38:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '1DC12C11DF88478598754FC7975A1D49');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/diary/list', 2, '日记', '查询', to_timestamp('07-01-2017 21:36:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:36:48.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '543B4F72BB79444B9AE7892044F0B42B');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/diary/save', 2, '日记', '添加', to_timestamp('07-01-2017 21:37:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:37:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'F48446BFE6BF4F73B4E86CB3CAE46658');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/diary/update', 2, '日记', '修改', to_timestamp('07-01-2017 21:37:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:37:47.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '68F42736FA4E4F8C94D67868E1FC910F');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/diary/findDiaryById', 2, '日记', '详情', to_timestamp('07-01-2017 21:38:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 21:38:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'D2CA1EC951F14BDC98D467F1D6A3A48D');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/createQrcode', 1, '二维码管理', '创建', to_timestamp('05-03-2017 20:49:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:50:33.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '94ACB8A7D9A44D4282559141F9959392');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/jssdk/getJssdkTicket', 1, 'JSSDK', 'TICKET', to_timestamp('05-03-2017 20:51:50.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:51:50.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'EAC6BD30AEA0477E855C0CEAAE9E9A12');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/groups/members/update', 1, '分组管理', '移动', to_timestamp('05-03-2017 20:52:57.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:52:57.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '9CEECE6902954129BBE033D357EAF51C');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/receive/sendTemplateMsg', 1, '消息管理', '模板消息', to_timestamp('05-03-2017 20:53:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:53:44.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '60BA961301B840CE9690F577854A9527');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/sendCustomTextMsg', 1, '消息管理', '客服消息', to_timestamp('05-03-2017 20:54:24.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:54:24.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '4A4D3023DAF84683BB78FA850B9E8999');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/getUserInfo', 1, '用户管理', '用户信息', to_timestamp('05-03-2017 20:55:20.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:56:18.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '120C1B917CC64BDDBF612E1C7F17EBD0');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/wechat/getWXUserOpenId', 1, '用户管理', '获取Openid', to_timestamp('05-03-2017 20:56:04.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 20:56:04.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'F0DFD697660D4F67A92BF35F82F5DA54');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/gains/findGainsById', 2, '备忘', '详情', to_timestamp('05-03-2017 21:04:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 21:04:13.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '496BF48CEDEA471EBDBC954EEE9101E7');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/gains/save', 2, '备忘', '添加', to_timestamp('05-03-2017 21:04:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 21:04:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'FA47D5DB2EEA4085B0838DD811C39034');
insert into TB_SYS_LOG_PARAM (URL, SOURCE, MENUNAME, OPERNAME, CREATETIME, UPDATETIME, CREATOR, ID)
values ('/web/gains/update', 2, '备忘', '修改', to_timestamp('05-03-2017 21:05:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('05-03-2017 21:05:51.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', '157862D7ACF64A7898DB32E1FEAAFC50');
commit;
prompt 16 records loaded
prompt Loading TB_SYS_MENU...
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20160928203125806', '1', '操作类型', 'page/system/operate/sysOperate.jsp', 2, to_date('28-09-2016 20:31:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('28-09-2016 20:36:19', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysRole', 'system', '用户类型', 'page/system/sysrole/sysRole.jsp', 1, null, to_date('02-04-2017 00:46:49', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxChatSession', 'wx', '询问统计', 'page/wx/wxchatsession/wxChatSession.jsp', 100, to_date('12-03-2017 11:23:15', 'dd-mm-yyyy hh24:mi:ss'), to_date('12-03-2017 21:58:35', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161016024730740', '1', '生成代码', 'page/autocode/autocode/autoCode.jsp', 3, to_date('16-10-2016 02:47:30', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-10-2016 02:47:30', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('diary', 'note', '我的日记', 'page/note/diary/diary.jsp', 1, null, to_date('08-01-2017 20:41:07', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('orgInfo', 'system', '组织管理', 'page/system/orginfo/orgInfo.jsp', 2, null, to_date('02-04-2017 00:46:37', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxAccount', 'wx', '公众号管理', 'page/wx/wxaccount/wxAccount.jsp', 4, null, to_date('10-01-2017 23:10:44', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161023003925948', 'system', '公司管理', 'page/system/orginfo/companyInfo.jsp', 2, to_date('23-10-2016 00:39:25', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:45:59', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('mall', '0', '商城', '#', 10, null, to_date('02-04-2017 00:47:59', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('goodInfo', 'mall', '商品管理', 'page/mall/goodinfo/goodInfo.jsp', 2, null, to_date('31-03-2017 19:48:18', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('advise', 'mall', '客户定制', 'page/mall/advise/advise.jsp', 1, null, to_date('02-04-2017 00:36:42', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('1', '0', '菜单', '#', 200, to_date('30-07-2016 13:35:59', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:16:37', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('2', '1', '系统菜单', 'page/system/menu/sysMenu.jsp', 1, to_date('27-07-2016 13:36:03', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-07-2016 13:36:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysUser', 'system', '用户管理', 'page/system/sysuser/sysUser.jsp', 1, null, to_date('08-11-2016 18:50:24', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0', '系统', '#', 199, to_date('30-07-2016 13:36:10', 'dd-mm-yyyy hh24:mi:ss'), to_date('30-11-2016 21:16:25', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203194846615', '0', '个人', '#', 341, to_date('03-12-2016 19:48:46', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:48:11', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203195318395', '20161203194846615', '重置手机', 'page/system/sysuser/changeMobile.jsp', 2, to_date('03-12-2016 19:53:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 20:02:17', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysLogParam', 'system', '日志参数', 'page/system/syslogparam/sysLogParam.jsp', 9, null, to_date('10-03-2017 22:57:13', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('vipInfo', 'note', '会员信息', 'page/note/vipinfo/vipInfo.jsp', 4, null, to_date('08-01-2017 20:41:53', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('note', '0', '痕迹', '#', 1, null, to_date('08-01-2017 19:57:21', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('moduleMsg', 'wx', '模板消息', 'page/wx/modulemsg/moduleMsg.jsp', 11, null, to_date('10-01-2017 23:10:32', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxChatMsg', 'wx', '询问管理', 'page/wx/wxchatmsg/wxChatMsg.jsp', 100, to_date('11-03-2017 21:12:16', 'dd-mm-yyyy hh24:mi:ss'), to_date('11-03-2017 21:12:16', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxUser', 'wx', '粉丝管理', 'page/wx/wxuser/wxUser.jsp', 3, null, to_date('10-01-2017 23:10:06', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxMenu', 'wx', '微信菜单', 'page/wx/wxmenu/wxMenu.jsp', 5, null, to_date('10-03-2017 22:44:11', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wx', '0', '微信', '#', 30, null, to_date('30-11-2016 21:15:43', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxMenuUrl', 'wx', '微信菜单URL', 'page/wx/wxmenuurl/wxMenuUrl.jsp', 6, null, to_date('10-01-2017 23:11:03', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('qrcode', 'wx', '二维码管理', 'page/wx/qrcode/qrcode.jsp', 3, null, to_date('02-04-2017 00:14:57', 'dd-mm-yyyy hh24:mi:ss'), '系统管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxAutoReplay', 'wx', '回复管理', 'page/wx/wxautoreplay/wxAutoReplay.jsp', 1, null, to_date('10-03-2017 22:43:25', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('question', 'note', '问题记录', 'page/note/question/question.jsp', 3, null, to_date('08-01-2017 20:42:02', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('newsItem', 'wx', '图文管理', 'page/wx/newsitem/newsItem.jsp', 2, null, to_date('10-03-2017 22:43:36', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysConf', 'system', '系统参数', 'page/system/sysconf/sysConf.jsp', 3, null, to_date('10-01-2017 23:11:29', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('wxTemplate', 'wx', '微信模板', 'page/wx/wxtemplate/wxTemplate.jsp', 10, null, to_date('10-01-2017 23:10:27', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('dataDir', 'system', '数据字典', 'page/system/datadir/dataDir.jsp', 4, null, to_date('10-01-2017 23:11:38', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('gains', 'note', '备忘记录', 'page/note/gains/gains.jsp', 2, null, to_date('08-01-2017 20:41:23', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('sysLog', 'system', '系统日志', 'page/system/syslog/sysLog.jsp', 10, null, to_date('10-03-2017 22:56:58', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('20161203195018623', '20161203194846615', '修改密码', 'page/system/sysuser/changePwd.jsp', 1, to_date('03-12-2016 19:50:18', 'dd-mm-yyyy hh24:mi:ss'), to_date('03-12-2016 19:50:18', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员');
insert into TB_SYS_MENU (MENUID, PARENTID, MENUITEM, URL, SORT, CREATETIME, UPDATETIME, CREATOR)
values ('reminder', 'note', '事务提醒', 'page/note/reminder/reminder.jsp', 100, to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-02-2017 18:43:34', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 37 records loaded
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
values ('同步', 'syncWx', 'icon-edit', to_date('17-11-2016 19:03:08', 'dd-mm-yyyy hh24:mi:ss'), to_date('10-03-2017 23:14:05', 'dd-mm-yyyy hh24:mi:ss'), '超级管理员', 7);
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
values ('Marks_ADMIN', '超级管理员', to_timestamp('17-02-2017 21:51:36.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-03-2017 22:48:46.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'ADMIN', 'Marks', 2, 1);
insert into TB_SYS_ROLE (ROLEID, ROLENAME, CREATETIME, UPDATETIME, CREATOR, USERTYPE, COMPANYID, LVL, SHOWFLAG)
values ('system', '系统管理员', to_timestamp('31-03-2017 22:19:22.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-03-2017 22:30:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'system', 'Marks', 0, 1);
commit;
prompt 3 records loaded
prompt Loading TB_SYS_ROLE_FUNC...
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '34D4A51F71A3452DA20B5C89272F7121', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '729986573F3F498AB804BD1B7CC58466', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'C3A5BC0B6477434E9E3942C16353834A', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '9CFAB7B9645F4EB48F69A3E900B51CDB', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'F2B99E17C4EC4CB399A1F4D435C28909', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '9E081346B9F5409EB8E8D79A988515E3', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '56FC1334D6A54B28B41C552156EA7E2C', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '440141C13AB345BC991774CDD7614909', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'E95BB25BFFAF4C13864DBC3A02B9306D', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'CD2780A03F02413E9D18F66323064595', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'F26FD1B3DCBF43D38E37529BC60E12F3', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '9AC1C6253D034F49B9CA958923A923FC', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'CADEF9328DCE4870BC463AA8D3F8D28D', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'CC56C8DA7CCE474BB86FCFF73ECD3D26', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', '12334FC4E13E4F94B649DDEAC18AB3D2', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_VIP', 'A4847B5D9E2C404BAFFCA1925B4C651B', to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:50:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '729986573F3F498AB804BD1B7CC58466', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C3A5BC0B6477434E9E3942C16353834A', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9CFAB7B9645F4EB48F69A3E900B51CDB', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F2B99E17C4EC4CB399A1F4D435C28909', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9E081346B9F5409EB8E8D79A988515E3', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '56FC1334D6A54B28B41C552156EA7E2C', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '440141C13AB345BC991774CDD7614909', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E95BB25BFFAF4C13864DBC3A02B9306D', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CD2780A03F02413E9D18F66323064595', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F26FD1B3DCBF43D38E37529BC60E12F3', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '34D4A51F71A3452DA20B5C89272F7121', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E9AFCA0B219A48F2B26C3407B89F6D4F', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0CC56B98214E4C8FB8439F341AFEEE28', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B527659F90594CD4844E2A2F22223E2A', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9AC1C6253D034F49B9CA958923A923FC', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CADEF9328DCE4870BC463AA8D3F8D28D', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CC56C8DA7CCE474BB86FCFF73ECD3D26', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '12334FC4E13E4F94B649DDEAC18AB3D2', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E24E30A2E2674303B6C9B62B36D79ADC', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8890D1E058DB4B7894B2D7B2BCC696A7', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A10AF55DA5C548E294DBD10A10F92E46', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '062D833DD050478A8B6D5503CD347F60', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C58C67CD6EA94BB2963C9714C6F9F90B', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3DA8897C41E8473A99C5492100190412', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2309E4BC9A924651B31F785C830728B6', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0F54D4F78A8D491FA43C3FBF60A9B1CF', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '9B746C1302684616B012733A4E791179', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'AFF47427547E413D8A4E6E9D8658BB17', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3E71A3CE7AB34607BDC570E72EBB6444', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2B12F2FF49C242F4963A550AC1AA4D52', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '55371B38A22F4D078947A10E51837D47', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '34CC225109974D0296DD538ED1A229C0', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '941ABAFE35D6480B95D0178B760BB1DB', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '56AF2BA7BBD643D8B66F1FEDB2F8D650', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A88AB1777C264C8387A4CF7B9C961048', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A3FEA09B72BA41868AA07D6818117AC0', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'FB4C99E9FB1A42F19B86FFC3DA761824', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8D4EC97F07AA48C0BA5F5F55A302532E', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6FB911AF50884CB9B52D3A6D9D3D4B03', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '58F8C1A54B244D07986F391AD5CB9E5D', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '10ACD5DC793A4D5A9F4228195CF57B77', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'D650F41753614EF68D65AD237334627C', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'AE5067796D694BAFB287D18529BAFFE2', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A9EDBB5CBFAA49CEB53C12A3C516BE85', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '7C045D9CA9D5456FAF856490836AA6C8', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A0BEFFBB0FDA42F38280FBE35A670977', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F43CE8D5ABDB46148E26B8C6A7C513D7', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CB28B8D3B8E846C7A355249B8A6D14BC', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '374088A1D165445AB7496D87B9A5175E', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E5934CC56BEF43ECBF47AC07890713AC', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2DFE8F4215A34E4AB1A603C36242F923', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0C86A52B779342DA92F4F6027B3251FE', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '805B2E58E7CB46CFAC9629FE35F9E051', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '21B1268FD84F4B1C8945C8E9731F0F49', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F9B4C69C5F864657A55BF9560AAD7AC9', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A947C38F31814E67830E922BA2FD5926', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '352724802F66473AA600570AB00C61D4', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CB6D94D479C34121A38F5B40B91106D2', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '8B31D84CC47A466C8132F6C0D212D442', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A3E3FFABB3264BEC9D20C47EA542B2F0', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'CF44B5BC126F4E6B9B9C976AA0F6D459', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F76059071E814CBF8DB6623DD26C04C6', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '575ED5D781A844478D16F7D7118AE210', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '40B743A6291A435AAE743CA93499AD8F', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '475B85B975C441E9B720FAC82ECAB89A', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '35EA71BD598246AFB5769EA6730A1254', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '165FEFC91D0F4A26B232D2A1D59F4D37', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'E0214CC842524D61A1CADB4B25F28C6D', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '751789E53BAA42428D477E49B00572C5', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '140845F24CC241B7AB3783B93F98724B', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '2DA34B5B4BF643E89DD5B6C791CD630A', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'FA00FAE5BE8249519544EAB937CED130', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '81F44FFCFB484D1B9B2B28B8B44038FD', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '831A77AF2FB5418FB6290E19ACB03F72', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '7F15BED5384E401AA13B8FE99FDD79E5', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '028280270812450986EE5E8552E692EC', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'D5FFAAAD152F4023BDEC443B8CECA7C6', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '588848E727F14FCAA21623A6894C2DDB', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0784E15BB48B4061A038499DC17B45C3', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '4C7AA4B348454752BEF6F9EC55402280', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '0EE456741D42426DB6448E5C6DDFDA8E', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '18B306C4A74149609A3FDC36F86F902A', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 100 records committed...
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B0E3BAAA2955492FADE23C35F774BCC3', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'B31E5C8F9DDB434CA70DDCC8204A74F3', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '431D29CBA6B64D92821180C1DB4335DE', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'F52536BB355D4216AA5F541601ABA4E0', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'C50921BE08CE4C47BEC824DA733F4CFD', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '88EA18C8BA4847119DEFC9146B7C7F1F', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '3EC98DB80F6440269D3628766217A68E', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '351B1DF16E6444258F142C4FD767FCEE', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '81B28ED45F1A427ABBA9025E4D917AD0', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A6907ADFCD4B4E048DDA0632C2D5062F', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '5AA2258E1404444BAE135783DD56DC03', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '86BC5FE8B3624C5B96922DA0D299D843', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', 'A4847B5D9E2C404BAFFCA1925B4C651B', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('Marks_ADMIN', '6061F2E92C214F4E98AA9F8A6862CD58', to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), to_date('31-03-2017 22:53:53', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '34D4A51F71A3452DA20B5C89272F7121', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '729986573F3F498AB804BD1B7CC58466', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'C3A5BC0B6477434E9E3942C16353834A', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '9CFAB7B9645F4EB48F69A3E900B51CDB', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F2B99E17C4EC4CB399A1F4D435C28909', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '9E081346B9F5409EB8E8D79A988515E3', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'BFBB32ADDE9C42B4ADECACACC04DF0A5', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '56FC1334D6A54B28B41C552156EA7E2C', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '440141C13AB345BC991774CDD7614909', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'E95BB25BFFAF4C13864DBC3A02B9306D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CD2780A03F02413E9D18F66323064595', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F26FD1B3DCBF43D38E37529BC60E12F3', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'E9AFCA0B219A48F2B26C3407B89F6D4F', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0CC56B98214E4C8FB8439F341AFEEE28', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'B527659F90594CD4844E2A2F22223E2A', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '9AC1C6253D034F49B9CA958923A923FC', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CADEF9328DCE4870BC463AA8D3F8D28D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CC56C8DA7CCE474BB86FCFF73ECD3D26', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '12334FC4E13E4F94B649DDEAC18AB3D2', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'E24E30A2E2674303B6C9B62B36D79ADC', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '8890D1E058DB4B7894B2D7B2BCC696A7', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A10AF55DA5C548E294DBD10A10F92E46', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '062D833DD050478A8B6D5503CD347F60', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'C58C67CD6EA94BB2963C9714C6F9F90B', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '3DA8897C41E8473A99C5492100190412', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '2309E4BC9A924651B31F785C830728B6', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0F54D4F78A8D491FA43C3FBF60A9B1CF', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '9B746C1302684616B012733A4E791179', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'AFF47427547E413D8A4E6E9D8658BB17', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '3E71A3CE7AB34607BDC570E72EBB6444', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '2B12F2FF49C242F4963A550AC1AA4D52', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '55371B38A22F4D078947A10E51837D47', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '34CC225109974D0296DD538ED1A229C0', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '941ABAFE35D6480B95D0178B760BB1DB', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '56AF2BA7BBD643D8B66F1FEDB2F8D650', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A88AB1777C264C8387A4CF7B9C961048', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A3FEA09B72BA41868AA07D6818117AC0', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'FB4C99E9FB1A42F19B86FFC3DA761824', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '8D4EC97F07AA48C0BA5F5F55A302532E', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '6FB911AF50884CB9B52D3A6D9D3D4B03', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '58F8C1A54B244D07986F391AD5CB9E5D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '10ACD5DC793A4D5A9F4228195CF57B77', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'D650F41753614EF68D65AD237334627C', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'AE5067796D694BAFB287D18529BAFFE2', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A9EDBB5CBFAA49CEB53C12A3C516BE85', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '7C045D9CA9D5456FAF856490836AA6C8', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A0BEFFBB0FDA42F38280FBE35A670977', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F43CE8D5ABDB46148E26B8C6A7C513D7', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CB28B8D3B8E846C7A355249B8A6D14BC', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '374088A1D165445AB7496D87B9A5175E', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'E5934CC56BEF43ECBF47AC07890713AC', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '2DFE8F4215A34E4AB1A603C36242F923', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0C86A52B779342DA92F4F6027B3251FE', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '805B2E58E7CB46CFAC9629FE35F9E051', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '21B1268FD84F4B1C8945C8E9731F0F49', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F9B4C69C5F864657A55BF9560AAD7AC9', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A947C38F31814E67830E922BA2FD5926', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '352724802F66473AA600570AB00C61D4', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CB6D94D479C34121A38F5B40B91106D2', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '8B31D84CC47A466C8132F6C0D212D442', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A3E3FFABB3264BEC9D20C47EA542B2F0', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'CF44B5BC126F4E6B9B9C976AA0F6D459', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F76059071E814CBF8DB6623DD26C04C6', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '575ED5D781A844478D16F7D7118AE210', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '40B743A6291A435AAE743CA93499AD8F', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '475B85B975C441E9B720FAC82ECAB89A', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '35EA71BD598246AFB5769EA6730A1254', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '165FEFC91D0F4A26B232D2A1D59F4D37', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'E0214CC842524D61A1CADB4B25F28C6D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '751789E53BAA42428D477E49B00572C5', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '140845F24CC241B7AB3783B93F98724B', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '2DA34B5B4BF643E89DD5B6C791CD630A', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'FA00FAE5BE8249519544EAB937CED130', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '81F44FFCFB484D1B9B2B28B8B44038FD', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '831A77AF2FB5418FB6290E19ACB03F72', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '7F15BED5384E401AA13B8FE99FDD79E5', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '028280270812450986EE5E8552E692EC', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'D5FFAAAD152F4023BDEC443B8CECA7C6', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '588848E727F14FCAA21623A6894C2DDB', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0784E15BB48B4061A038499DC17B45C3', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '4C7AA4B348454752BEF6F9EC55402280', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0EE456741D42426DB6448E5C6DDFDA8E', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '18B306C4A74149609A3FDC36F86F902A', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'B0E3BAAA2955492FADE23C35F774BCC3', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'B31E5C8F9DDB434CA70DDCC8204A74F3', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '431D29CBA6B64D92821180C1DB4335DE', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 200 records committed...
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'F52536BB355D4216AA5F541601ABA4E0', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'C50921BE08CE4C47BEC824DA733F4CFD', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '88EA18C8BA4847119DEFC9146B7C7F1F', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '3EC98DB80F6440269D3628766217A68E', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '351B1DF16E6444258F142C4FD767FCEE', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '81B28ED45F1A427ABBA9025E4D917AD0', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A6907ADFCD4B4E048DDA0632C2D5062F', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '5AA2258E1404444BAE135783DD56DC03', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '86BC5FE8B3624C5B96922DA0D299D843', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '6232F8C5272A489CB66E54091718E5AD', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '633836EDCC0E40329B2BEBB34FA2B5FB', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'DA0BA7D60DD6461E85EA1EFB4E56AC1D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '0073BE06AA6A49D783E9E033131A5C57', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'C1060CF0D3CE49A19BB7AEB3AF622B0C', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '92078E74B6784886BA2956AE553BFA69', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A716C1E44907420AAD6CA5AC638541C8', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '7EF6056FFFDE4EE6BBF84F86EF66BF28', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '37A16BCD5D0E462EB892CDC9BB3D28EA', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'FB548F9A221041E1A70A0A30D12F3457', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '9A05C58D23E64D82A8A0FC1448EB732D', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '49A155C4DBBF4A56907BFA4B60B4FAF1', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '699C293D715340D392CD4E113B864D20', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '6BFC445EB2FC46D3B49582B319BB503E', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '4A911E4E08FE45BF95EE3CC1BA5F3B78', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'A4847B5D9E2C404BAFFCA1925B4C651B', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TB_SYS_ROLE_FUNC (ROLEID, FUNCID, CREATETIME, UPDATETIME, CREATOR)
values ('system', '6061F2E92C214F4E98AA9F8A6862CD58', to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), to_date('02-04-2017 00:04:07', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 226 records loaded
prompt Loading TB_SYS_USER...
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, FANID, ROLEID, SKIN, BINDFLAG)
values ('U1000008', 'cjmei', 'B15A268148D9C5A9363E915581CE1819', '18680221791', 1, to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-04-2017 22:39:12.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, 'F100000000', 'Marks_VIP', 3, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, FANID, ROLEID, SKIN, BINDFLAG)
values ('U1000018', '18210012743', 'B15A268148D9C5A9363E915581CE1819', '18210012749', 0, to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('06-04-2017 18:37:43.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '18210012743', 'Marks', null, null, 'Marks_VIP', 6, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, FANID, ROLEID, SKIN, BINDFLAG)
values ('U1000024', '18210022744', 'B15A268148D9C5A9363E915581CE1819', '18210022744', 1, to_timestamp('15-03-2017 20:30:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('15-03-2017 20:30:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 0, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, FANID, ROLEID, SKIN, BINDFLAG)
values ('admin', '超级管理员', 'B15A268148D9C5A9363E915581CE1819', '18210012743', 1, to_timestamp('24-07-2016 15:30:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('02-04-2017 01:39:34.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', 'Marks', null, null, 'Marks_ADMIN', 2, 1);
insert into TB_SYS_USER (USERID, USERNAME, PASSWORD, BIND_MOBILE, ACTIVEFLAG, CREATETIME, UPDATETIME, CREATOR, COMPANYID, TOKEN, FANID, ROLEID, SKIN, BINDFLAG)
values ('system', '系统管理员', '8CD7A411CAC95C896C5F18D72E4CE49C', '18610013597', 1, to_timestamp('31-03-2017 22:22:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-03-2017 22:47:56.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin', null, null, null, 'system', 0, 1);
commit;
prompt 5 records loaded
prompt Loading TB_SYS_USER_ORG...
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000008', 'Marks', to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('07-01-2017 23:48:54.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000018', 'Marks', to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 00:07:10.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), '18210012743');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('U1000024', 'Marks01', to_timestamp('15-03-2017 20:30:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('15-03-2017 20:30:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('system', 'Marks', to_timestamp('31-03-2017 22:22:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-03-2017 22:22:45.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
insert into TB_SYS_USER_ORG (USERID, ORGID, CREATETIME, UPDATETIME, CREATOR)
values ('admin', 'Marks', to_timestamp('08-01-2017 21:07:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-01-2017 21:07:23.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null);
commit;
prompt 5 records loaded
prompt Loading TB_WX_ACCOUNT...
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('wxtest012', '测试012', 'wx1102d8ed48b46f5e', 'c655d6de4b8fa4587fca8691ed478996', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=wxtest012', null, null, 'admin', to_date('17-11-2016 14:44:07', 'dd-mm-yyyy hh24:mi:ss'), '/', 'test_012 ', 0, 0, to_date('11-01-2017 21:07:24', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('ctest', 'cjmei0221测试服务号', 'wxfa54b3d1eafa3510', '15411cc0a1cd4eea2003581717ec0d59', 'http://169j366m32.iask.in', 'http://169j366m32.iask.in/WECHAT/HANDLER?accountid=ctest', 'marks', null, 'admin', to_date('25-11-2016 11:03:09', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 1, 0, to_date('07-04-2017 19:56:48', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
insert into TB_WX_ACCOUNT (ACCOUNTID, ACCOUNTNAME, APPID, APPSECRET, AUTHDOMAIN, URL, TOKEN, AESKEY, CREATOR, CREATETIME, SERVER_CONTEXT, WX_ACCTNO, IS_SERVICE, ACCTTYPE, UPDATETIME, ORGID, COMPANYID)
values ('qy_cjmei', 'C团队', 'wx89e520f1912d47a2', 'o9cj_Mo84hGY0x1nu4uDzGV8mfrkoBRpQehiCHkKOp3g5i6oUxM-BzH2vcgax8fx', 'http://s.cjmei.cn', 'http://s.cjmei.cn/WECHAT/HANDLER?accountid=qy_cjmei', null, null, 'admin', to_date('17-11-2016 14:13:13', 'dd-mm-yyyy hh24:mi:ss'), '/', null, 0, 1, to_date('11-01-2017 20:37:23', 'dd-mm-yyyy hh24:mi:ss'), 'Marks', 'Marks');
commit;
prompt 3 records loaded
prompt Loading TB_WX_AUTO_REPLAY...
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('43', '您可能输入以下问题：' || chr(13) || '' || chr(10) || '[0]理财' || chr(13) || '' || chr(10) || '[1]基金', 'F17AC3B24D144520A2CBA0E40FD20CC5', '32', 'ctest', 'TEXT', to_date('14-03-2017 20:41:27', 'dd-mm-yyyy hh24:mi:ss'), to_date('01-04-2017 22:25:46', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '何为理财');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('d', 'http://169j366m32.iask.in/web/mobile/view/note/diary/list.html', '009DE82027E2446E8A4EFA15E5C49E5E', '日记', 'ctest', 'TEXT', to_date('07-04-2017 20:30:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2017 20:30:29', 'dd-mm-yyyy hh24:mi:ss'), 'system', 1, '日记');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('0', '您好！有什么可以帮助您吗？', '4F7B947C71F843FB9FC5A83363F2FCA0', '测试', 'ctest', 'TEXT', to_date('05-03-2017 15:20:51', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2017 20:48:55', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '人工客服');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('理财', 'N100000021', 'FF6BFFCC2992415ABA01FF291CBD11A6', '阿斯顿发', 'ctest', 'NEWS', to_date('13-03-2017 20:16:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-03-2017 20:11:33', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '理财产品');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('痕迹', 'N100000021,N100000024,N100000023', '7D7984B5E92F4414BFFC7FA680597C3C', '痕迹', 'ctest', 'NEWS', to_date('08-04-2017 08:09:19', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-04-2017 08:09:19', 'dd-mm-yyyy hh24:mi:ss'), 'system', 1, '我的痕迹');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('subscribereplay', '欢迎关注我们的公众号', '7C9688DE8BFB462CBA04C0442193F61D', '关注', 'ctest', 'TEXT', to_date('14-03-2017 21:16:31', 'dd-mm-yyyy hh24:mi:ss'), to_date('16-03-2017 22:06:12', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '关注或扫码回复');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('defaultreplay', '不能识别您的问题，你可咨询人工客服[0]', 'A75A85BDA17F4AA8B29B806318CB9844', '默认回复', 'ctest', 'TEXT', to_date('14-03-2017 21:18:55', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-04-2017 20:59:37', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '不识别的文字回复');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('我的痕迹', 'N100000021,N100000024,N100000023', '29D990AD07A646689F64E7876B05E0E0', '痕迹', 'ctest', 'NEWS', to_date('08-04-2017 08:09:42', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-04-2017 08:09:42', 'dd-mm-yyyy hh24:mi:ss'), 'system', 1, '我的痕迹');
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('teset', 'N100000021', '1E621C7BFE3E4C1196E5BC178DC2002F', '测试234', 'wxtest012', 'NEWS', to_date('25-11-2016 10:15:33', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-03-2017 20:11:45', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 0, null);
insert into TB_WX_AUTO_REPLAY (CKEY, CREPLAY, CTYPE, CTYPENAME, ACCOUNTID, REPLAYTYPE, CREATETIME, UPDATETIME, CREATOR, DELFLAG, CKEYNAME)
values ('理财产品', 'fwe', '9E312A1513ED468EBC432F237AFAC1DB', '理财', 'ctest', 'TEXT', to_date('19-03-2017 19:35:36', 'dd-mm-yyyy hh24:mi:ss'), to_date('19-03-2017 19:35:36', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 1, '理财');
commit;
prompt 10 records loaded
prompt Loading TB_WX_AUTO_REPLAY_NEWSITEM...
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000023', '备忘', '备忘录', 'U20170408085125579.jpg', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_gains_list', 4, 'ctest', to_timestamp('08-04-2017 08:07:05.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-04-2017 08:51:32.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'system');
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000024', '问题', '所遇到的问题', 'U20170408085119683.jpg', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_question_list', 3, 'ctest', to_timestamp('08-04-2017 08:08:16.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-04-2017 08:51:42.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'system');
insert into TB_WX_AUTO_REPLAY_NEWSITEM (ID, TITLE, DESCRIPTION, PICURL, URL, SORT, ACCOUNTID, CREATETIME, UPDATETIME, CREATOR)
values ('N100000021', '日记', '我的日记', 'U20170408085110257.jpg', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_dairy_list', 5, 'ctest', to_timestamp('19-03-2017 20:11:15.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('08-04-2017 08:55:35.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'admin');
commit;
prompt 3 records loaded
prompt Loading TB_WX_MENU...
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('8F877DEE46A14CF492E72FAD4FD2B739', 'wxtest012', '测试1', 'view', 'http://www.baidu.com', 1, 'wxtest012', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('EC46566839D64430BCB33C5CA7632DAD', 'ctest', '痕迹', '1', '#', 1, 'ctest', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('BF9153133E8C4E5B8DFAEF655E328DB7', 'EC46566839D64430BCB33C5CA7632DAD', '备忘', 'view', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_gains_list', 2, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('26CB0FA34F4E47DCA4CB68CF887D3F17', 'EC46566839D64430BCB33C5CA7632DAD', '日记', 'view', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_dairy_list', 1, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('42B3A5D791F54772AD235379E3BFD622', 'EC46566839D64430BCB33C5CA7632DAD', '问题', 'view', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_question_list', 3, 'ctest', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('9C53C598166F442694BB19507A5DFB34', 'ctest', '我', 'view', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_myInfo', 2, 'ctest', 1);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('02771C744D8C4479B695BAEBDAB6CC72', '8F877DEE46A14CF492E72FAD4FD2B739', '35', null, 'er''t', 12, 'wxtest012', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('F9EF2E2295054A7796C9DE393CDBA9CB', '8F877DEE46A14CF492E72FAD4FD2B739', '测试2', 'view', 'https://www.baidu.com', 2, 'wxtest012', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('ED7A8C4367A543C8ADA6A57A14F19700', '8F877DEE46A14CF492E72FAD4FD2B739', '测试3', 'view', 'https://www.baidu.com', 1, 'wxtest012', 2);
insert into TB_WX_MENU (ID, PARENT_ID, NAME, TYPE, CONTENT, SORT, ACCOUNTID, LVL)
values ('0B711EA4D8404F3589295C860058BA0D', 'wxtest012', 'ces1', 'view', 'https://www.baidu.com', 2, 'wxtest012', 1);
commit;
prompt 10 records loaded
prompt Loading TB_WX_MENU_URL...
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('82F2B16158DB433EBDFABBF91D766B66', '备忘 ', 'http://169j366m32.iask.in/web/mobile/view/note/gains/list.html', 'ctest');
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('BF07E2A4E18241978B30D84AC8B239D8', '日记', 'http://169j366m32.iask.in/web/wx/wxMenu/ctest/note_dairy_list', 'ctest');
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('EEFCDEE41C3845BAA87D6188053F897B', '我', 'http://169j366m32.iask.in/web/mobile/view/note/owner/myInfo.html', 'ctest');
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('EAC991E5044D4A5BA6E970B78E6F0ECE', '问题', 'http://169j366m32.iask.in/web/mobile/view/note/question/list.html', 'ctest');
insert into TB_WX_MENU_URL (ID, MENUNAME, MENUURL, ACCOUNTID)
values ('3A012A735B4E4127B9D28D02B6D561C0', '日记', 'http://169j366m32.iask.in/web/mobile/view/note/diary/list.html', 'ctest');
commit;
prompt 5 records loaded
prompt Loading TB_WX_TEMPLATE...
insert into TB_WX_TEMPLATE (YWTYPE, ACCOUNTID, TEMPLATE_ID, TEMPLATE_NAME, FIRST_CONTENT, REMARK_CONTENT, DETAILURL, STATUS, CREATETIME, UPDATETIME, CREATOR)
values ('wxtemplate_dairy', 'ctest', 'RvcSxaihNCLVOmS4OGj5vzw1im0IVvAhl3I2SgVyUMM', '日记提醒', '您今天写了日记吗？', '还没写，快去写吧', 'http://192.168.1.105:8080/mobile/view/note/diary/list.html', 1, to_date('27-11-2016 22:40:20', 'dd-mm-yyyy hh24:mi:ss'), to_date('08-01-2017 11:17:36', 'dd-mm-yyyy hh24:mi:ss'), 'admin');
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
