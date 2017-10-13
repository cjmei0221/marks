package com.marks.module.core.data;

import java.util.List;
import java.util.Map;

import com.marks.module.core.data.stccache.StcCacheData;
import com.marks.module.org.orginfo.pojo.OrgInfo;
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

	public static List<String> getUrlList() {
		return StcCacheData.getUrlList();
	}

	public static void putUrlList(List<String> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putUrlList(list);
		}
	}

	public static Map<String, String> getDatadirMap(String parentkey) {
		Map<String, String> map = null;
		try {
			map = StcCacheData.getDatadirMap(parentkey);
		} catch (Exception e) {
		}
		return map;
	}

	public static String getDatadirValue(String parentkey, String ckey) {
		String cvalue = "";
		try {
			Map<String, String> map = getDatadirMap(parentkey);
			if (null != map) {
				cvalue = map.get(ckey);
			}
		} catch (Exception e) {
		}
		return cvalue;
	}

	public static void putDatadirList(List<DataDir> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putDatadirList(list);
		}
	}

	public static WxAccount getWxAccount(String accountid) {
		return StcCacheData.getWxAccount(accountid);
	}

	public static void putWxAccount(List<WxAccount> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putWxAccount(list);
		}
	}

	public static OrgInfo getOrgInfo(String orgid) {
		return StcCacheData.getOrgInfo(orgid);
	}

	public static void putOrgInfo(OrgInfo info) {
		if (info != null) {
			StcCacheData.putOrgInfo(info);
		}
	}

	public static void putOrgInfoList(List<OrgInfo> list) {
		if (list != null && list.size() > 0) {
			StcCacheData.putOrgInfoList(list);
		}
	}
}
