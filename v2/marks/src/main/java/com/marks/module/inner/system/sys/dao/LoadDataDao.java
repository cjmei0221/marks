package com.marks.module.inner.system.sys.dao;

import java.util.List;

import com.marks.module.inner.system.datadir.pojo.DataDir;
import com.marks.module.inner.system.sysconf.pojo.SysConf;
import com.marks.module.inner.wx.wxaccount.pojo.WxAccount;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}
