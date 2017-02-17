package com.marks.module.system.sys.dao;

import java.util.List;

import com.marks.module.system.sys.pojo.DataDir;
import com.marks.module.system.sys.pojo.SysConf;
import com.marks.module.weixin.wfhao.pojo.WxAccount;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();


}
