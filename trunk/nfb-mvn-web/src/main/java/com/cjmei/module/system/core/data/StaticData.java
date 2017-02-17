package com.cjmei.module.system.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.sys.pojo.DataDir;
import com.cjmei.module.system.sys.pojo.SysConf;
import com.cjmei.module.weixin.wfhao.pojo.WxAccount;

/**
 * 
 * File Name: com.grgbanking.inner.data.StaticData.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月26日上午9:02:19
 * @see (optional) 
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
 */
public class StaticData {
	private static Map<String, String> paramsMap = new HashMap<String, String>();

	private static Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();

	private static List<String> urlList = new ArrayList<String>();
	private static Map<String, WxAccount> wxMap = new HashMap<String, WxAccount>();

	public static String getSysConf(String key) {
		return paramsMap.get(key);
	}

	public static void putSysConfList(List<SysConf> list) {
		if (list != null && list.size() > 0) {
			for (SysConf sc : list) {
				paramsMap.put(sc.getCkey(), sc.getCvalue());
			}
		}
	}

	public static List<String> getUrlList() {
		return urlList;
	}

	public static void putUrlList(List<String> list) {
		if (list != null && list.size() > 0) {
			for(String url:list){
				int idx=url.indexOf(".");
				if(idx>0){
					url=url.substring(0, idx);
				}
				urlList.add(url);
			}
		}
	}

	public static Map<String, String> getDatadirMap(String parentkey) {
		Map<String, String> map = null;
		try {
			map = dataMap.get(parentkey);
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
		if (null != list && list.size() > 0) {
			List<String> maplist = new ArrayList<String>();
			Map<String, String> map = null;
			for (DataDir info : list) {
				if (Constants.top_datadir_id.equals(info.getParentkey())) {
					map = new HashMap<String, String>();
					dataMap.put(info.getCkey(), map);
					maplist.add(info.getCkey());
				}
			}
			if (maplist.size() > 0) {
				for (String ckey : maplist) {
					for (DataDir info : list) {
						if (ckey.equals(info.getParentkey())) {
							dataMap.get(ckey).put(info.getCkey(), info.getCvalue());
						}
					}
				}
			}
		}
	}
	
	public static WxAccount getWxAccount(String accountid) {
		return wxMap.get(accountid);
	}

	public static void putWxAccount(List<WxAccount> list) {
		if (list != null && list.size() > 0) {
			for (WxAccount sc : list) {
				wxMap.put(sc.getAccountid(),sc);
			}
		}
	}
}