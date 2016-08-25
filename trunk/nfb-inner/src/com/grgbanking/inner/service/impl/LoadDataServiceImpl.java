package com.grgbanking.inner.service.impl;

import java.util.List;

import com.grgbanking.infra.InfraUtil;
import com.grgbanking.infra.pojo.DataDir;
import com.grgbanking.infra.pojo.SysConf;
import com.grgbanking.infra.pojo.WxAccount;
import com.grgbanking.inner.dao.LoadDataDao;
import com.grgbanking.inner.service.LoadDataService;

public class LoadDataServiceImpl implements LoadDataService{

	private LoadDataDao loadDataDao;
	
	public void setLoadDataDao(LoadDataDao loadDataDao) {
		this.loadDataDao = loadDataDao;
	}

	@Override
	public void loadSysConf() {
		List<SysConf> list=loadDataDao.loadSysConf();
		//将数据放入memcache缓存
		InfraUtil.getInstance().putSysConfList(list);
	}

	@Override
	public void loadDataDir() {
		List<DataDir> list=loadDataDao.loadDataDir();
		//将数据放入memcache缓存
		InfraUtil.getInstance().putDatadirList(list);
	}

	@Override
	public void loadWxAccount() {
		List<WxAccount> list=loadDataDao.loadWxAccount();
		//将数据放入memcache缓存
		InfraUtil.getInstance().putWxAccount(list);
	}

}
