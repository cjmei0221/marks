package com.cjmei.module.system.sys.dao;

import java.util.List;

import com.cjmei.module.cell.wxaccount.pojo.WxAccount;
import com.cjmei.module.system.sys.pojo.DataDir;
import com.cjmei.module.system.sys.pojo.SysConf;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}
