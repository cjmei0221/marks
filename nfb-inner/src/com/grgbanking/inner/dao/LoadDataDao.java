package com.grgbanking.inner.dao;

import java.util.List;

import com.grgbanking.infra.pojo.DataDir;
import com.grgbanking.infra.pojo.SysConf;
import com.grgbanking.infra.pojo.WxAccount;

public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();

}
