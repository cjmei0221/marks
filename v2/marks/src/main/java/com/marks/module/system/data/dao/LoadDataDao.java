package com.marks.module.system.data.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.system.datadir.pojo.DataDir;
import com.marks.module.system.sysconf.pojo.SysConf;
import com.marks.module.wx.manage.entity.base.WxAccount;
@MapperScan
public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}
