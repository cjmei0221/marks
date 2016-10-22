package com.cjmei.module.system.sys.dao;

import java.util.List;

import com.cjmei.module.system.sys.pojo.DataDir;
import com.cjmei.module.system.sys.pojo.SysConf;
import com.cjmei.module.weixin.account.pojo.WxAccount;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();


}
