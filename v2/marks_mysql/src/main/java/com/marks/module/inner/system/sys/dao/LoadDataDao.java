package com.marks.module.inner.system.sys.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.inner.system.datadir.pojo.DataDir;
import com.marks.module.inner.system.sysconf.pojo.SysConf;
import com.marks.module.inner.wx.wxaccount.pojo.WxAccount;
@MapperScan
public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}