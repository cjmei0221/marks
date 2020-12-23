package com.marks.smart.system.system.data.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.smart.system.cache.CacheData;
import com.marks.smart.system.system.data.dao.LoadDataDao;
import com.marks.smart.system.system.data.service.LoadDataService;
import com.marks.smart.system.system.datadir.pojo.DataDir;
import com.marks.smart.system.system.sysconf.pojo.SysConf;
import com.marks.smart.wx.manage.mp.entity.WxAccount;

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
		CacheData.putSysConfList(list);
	}

	@Override
	public void loadDataDir() {
		List<DataDir> list=loadDataDao.loadDataDir();
		//将数据放入memcache缓存
		CacheData.putDatadirList(list);
	}
	
	@Override
	public void loadUrlList() {
		List<String> list=loadDataDao.loadUrlList();
		CacheData.putUrlList(list);
	}

	@Override
	public void loadWxAccount() {
		List<WxAccount> list=loadDataDao.loadWxAccount();
		//将数据放入memcache缓存
		CacheData.putWxAccountList(list);
	}

}
