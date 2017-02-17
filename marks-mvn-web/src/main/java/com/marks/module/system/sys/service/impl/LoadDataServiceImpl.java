package com.marks.module.system.sys.service.impl;

import java.util.List;

import com.marks.module.system.core.data.StaticData;
import com.marks.module.system.sys.dao.LoadDataDao;
import com.marks.module.system.sys.pojo.DataDir;
import com.marks.module.system.sys.pojo.SysConf;
import com.marks.module.system.sys.service.LoadDataService;
import com.marks.module.weixin.wfhao.pojo.WxAccount;

public class LoadDataServiceImpl implements LoadDataService{

	private LoadDataDao loadDataDao;
	
	public void setLoadDataDao(LoadDataDao loadDataDao) {
		this.loadDataDao = loadDataDao;
	}

	@Override
	public void loadSysConf() {
		List<SysConf> list=loadDataDao.loadSysConf();
		//将数据放入memcache缓存
		StaticData.putSysConfList(list);
	}

	@Override
	public void loadDataDir() {
		List<DataDir> list=loadDataDao.loadDataDir();
		//将数据放入memcache缓存
		StaticData.putDatadirList(list);
	}
	
	@Override
	public void loadWxAccount() {
		List<WxAccount> list=loadDataDao.loadWxAccount();
		//将数据放入memcache缓存
		StaticData.putWxAccount(list);
	}

}
