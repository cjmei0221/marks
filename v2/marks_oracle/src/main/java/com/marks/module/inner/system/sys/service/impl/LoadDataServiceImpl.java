package com.marks.module.inner.system.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.module.inner.system.datadir.pojo.DataDir;
import com.marks.module.inner.system.sys.dao.LoadDataDao;
import com.marks.module.inner.system.sys.service.LoadDataService;
import com.marks.module.inner.system.sysconf.pojo.SysConf;
import com.marks.module.inner.wx.wxaccount.pojo.WxAccount;
import com.marks.module.sys.system.core.data.StaticData;

@Service
public class LoadDataServiceImpl implements LoadDataService{
	@Autowired
	private LoadDataDao loadDataDao;
	
	/*public void setLoadDataDao(LoadDataDao loadDataDao) {
		this.loadDataDao = loadDataDao;
	}*/

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
	public void loadUrlList() {
		List<String> list=loadDataDao.loadUrlList();
		StaticData.putUrlList(list);
	}

	@Override
	public void loadWxAccount() {
		List<WxAccount> list=loadDataDao.loadWxAccount();
		//将数据放入memcache缓存
		StaticData.putWxAccount(list);
	}

}
