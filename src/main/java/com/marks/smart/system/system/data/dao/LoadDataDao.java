package com.marks.smart.system.system.data.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.marks.smart.system.system.datadir.pojo.DataDir;
import com.marks.smart.system.system.sysconf.pojo.SysConf;
import com.marks.smart.wx.manage.mp.entity.WxAccount;
@MapperScan
public interface LoadDataDao {

	List<SysConf> loadSysConf();

	List<DataDir> loadDataDir();

	List<WxAccount> loadWxAccount();
	
	List<String> loadUrlList();

}
