package com.marks.module.cache.stccache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.marks.common.util.Constants;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.system.datadir.pojo.DataDir;
import com.marks.module.system.sysconf.pojo.SysConf;
import com.marks.module.wx.manage.base.pojo.WxAccount;

/**
 * 
 * File Name: com.grgbanking.inner.data.StaticData.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月26日上午9:02:19
 * @see (optional)
 * @Copyright (c) 2016, marks All Rights Reserved.
 */
public class StcCacheData {
	private static Map<String, String> paramsMap = new HashMap<String, String>();

	private static Map<String, String> dataMap = new HashMap<String, String>();

	private static List<String> urlList = new ArrayList<String>();
	private static Map<String, WxAccount> wxMap = new HashMap<String, WxAccount>();
	private static Map<String, OrgInfo> orgMap = new HashMap<String, OrgInfo>();

	public static String getSysConf(String key) {
		return paramsMap.get(key);
	}

	public static void putSysConf(SysConf info) {
		paramsMap.put(info.getCkey(), info.getCvalue());
	}
	public static void putSysConfList(List<SysConf> list) {
		if (list != null && list.size() > 0) {
			for (SysConf info : list) {
				putSysConf(info);
			}
		}
	}

	public static List<String> getUrlList() {
		return urlList;
	}

	public static void putUrlList(List<String> list) {
		if (list != null && list.size() > 0) {
			for (String url : list) {
				int idx = url.indexOf(".");
				if (idx > 0) {
					url = url.substring(0, idx);
				}
				urlList.add(url);
			}
		}
	}

	public static String getDatadirValue(String parentkey, String ckey) {
		String cvalue = "";
		try {
			cvalue = dataMap.get(parentkey + "_" + ckey);
		} catch (Exception e) {
		}
		return cvalue;
	}

	public static void putDatadir(DataDir info) {
		if (Constants.top_datadir_id.equals(info.getParentkey())) {
			return;
		}
		dataMap.put(info.getParentkey() + "_" + info.getCkey(), info.getCvalue());
	}

	public static void putDatadirList(List<DataDir> list) {
		if (null != list && list.size() > 0) {
			for (DataDir info : list) {
				putDatadir(info);
			}
		}
	}

	public static WxAccount getWxAccount(String accountid) {
		return wxMap.get(accountid);
	}

	public static void putWxAccount(WxAccount info) {
		if (info != null) {
			wxMap.put(info.getAccountId(), info);
		}
	}

	public static void putWxAccountList(List<WxAccount> list) {
		if (list != null && list.size() > 0) {
			for (WxAccount info : list) {
				putWxAccount(info);
			}
		}
	}

	// public static OrgInfo getOrgInfo(String orgid) {
	// return orgMap.get(orgid);
	// }
	//
	// public static void putOrgInfo(OrgInfo info) {
	// if (info != null) {
	//
	// orgMap.put(info.getOrgid(), info);
	//
	// }
	// }
	//
	// public static void putOrgInfoList(List<OrgInfo> list) {
	// if (list != null && list.size() > 0) {
	// for (OrgInfo info : list) {
	// putOrgInfo(info);
	// }
	// }
	// }

}
