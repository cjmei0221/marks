package com.marks.module.cache;

import java.util.List;

import com.marks.module.cache.stccache.StcCacheData;
import com.marks.module.system.datadir.pojo.DataDir;
import com.marks.module.system.sysconf.pojo.SysConf;
import com.marks.module.wx.manage.base.pojo.WxAccount;

public class CacheData {

	public static String getSysConf(String key) {
		return StcCacheData.getSysConf(key);
	}

	public static void putSysConfList(List<SysConf> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putSysConfList(list);
		}
	}

	public static void putSysConf(SysConf info) {
		if (info != null) {
			StcCacheData.putSysConf(info);
		}
	}

	public static List<String> getUrlList() {
		return StcCacheData.getUrlList();
	}

	public static void putUrlList(List<String> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putUrlList(list);
		}
	}



	public static String getDatadirValue(String parentkey, String ckey) {
		String cvalue = "";
		try {
			cvalue = StcCacheData.getDatadirValue(parentkey, ckey);
		} catch (Exception e) {
		}
		return cvalue;
	}

	public static void putDatadir(DataDir info) {
		if (info != null) {
			StcCacheData.putDatadir(info);
		}
	}

	public static void putDatadirList(List<DataDir> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putDatadirList(list);
		}
	}

	public static WxAccount getWxAccount(String accountid) {
		return StcCacheData.getWxAccount(accountid);
	}

	public static void putWxAccountList(List<WxAccount> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putWxAccountList(list);
		}
	}

	public static void putWxAccount(WxAccount info) {
		if (info != null) {
			StcCacheData.putWxAccount(info);
		}
	}
}
