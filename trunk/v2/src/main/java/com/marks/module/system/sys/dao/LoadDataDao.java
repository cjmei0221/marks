package com.marks.module.system.sys.dao;

import java.util.List;

import com.marks.module.system.datadir.pojo.DataDir;
import com.marks.module.system.sysconf.pojo.SysConf;
import com.marks.module.wx.wxaccount.pojo.WxAccount;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}
