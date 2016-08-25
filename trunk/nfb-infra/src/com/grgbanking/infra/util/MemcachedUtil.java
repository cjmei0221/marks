package com.grgbanking.infra.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;
import com.grgbanking.infra.pojo.DataDir;
import com.grgbanking.infra.pojo.WxAccount;

public class MemcachedUtil {
	
	private static final String SysConfMAP="SysConfMAP";//存放客户列表的key

	private static final String DataDirMap="DataDirMap";
	
	private static final String WxAccountMap="WxAccountMap";
	
	private static ICacheManager<IMemcachedCache> manager;
	
	private static IMemcachedCache cache0;
	
	private static Logger logger = Logger.getLogger(MemcachedUtil.class);
	
	public static void init() {
		manager = CacheUtil.getCacheManager(IMemcachedCache.class,
				MemcachedCacheManager.class.getName());
		manager.setConfigFile("memcached.xml");
		//manager.setResponseStatInterval(5*1000);
		manager.start();
		cache0 = manager.getCache("mclient0");
	}

	/*public static void main(String[] args){
		MemcachedUtil.init();
	}*/
	public static void putWxAccountMap(Map<String,WxAccount> map) {
		if(null != map && map.size() > 0){
			Object obj=null;
			try {
				obj = cache0.get(WxAccountMap);
			} catch (Exception e) {
				obj=null;
			}
			if(obj !=null){
				cache0.replace(WxAccountMap, map);
				//cache0.remove(PriceMarketControlMap);
			}else{
				cache0.put(WxAccountMap, map);
			}
		}
	}

	public static WxAccount getWxAccount(String accountid) {
		try {
			Object obj=cache0.get(WxAccountMap);
			if(obj!=null){
				return ((Map<String, WxAccount>)obj).get(accountid);
			}
			return null;
		} catch (Exception e) {
			logger.error("SysConfMAP", e);
		}
		return null;
	}
	public static void removeWxAccount(){
		try {
			Object obj =cache0.get(WxAccountMap);
			if(obj !=null){
				cache0.remove(WxAccountMap);
			}
		} catch (Exception e) {
			logger.info("error", e);
		}
	}
	/*首页列表*/
	public static void putSysConfMap(Map<String,String> map) {
		if(null != map && map.size() > 0){
			Object obj=null;
			try {
				obj = cache0.get(SysConfMAP);
			} catch (Exception e) {
				obj=null;
			}
			if(obj !=null){
				cache0.replace(SysConfMAP, map);
				//cache0.remove(PriceMarketControlMap);
			}else{
				cache0.put(SysConfMAP, map);
			}
		}
	}

	public static String getSysConf(String key) {
		try {
			Object obj=cache0.get(SysConfMAP);
			if(obj!=null){
				return ((Map<String, String>)obj).get(key);
			}
			return null;
		} catch (Exception e) {
			logger.error("SysConfMAP", e);
		}
		return null;
	}
	public static void removeSysConf(){
		try {
			Object obj =cache0.get(SysConfMAP);
			if(obj !=null){
				cache0.remove(SysConfMAP);
			}
		} catch (Exception e) {
			logger.info("error", e);
		}
	}
	
	public static void putDataDirMap(Map<String,List<DataDir>> map) {
		if(null != map && map.size() > 0){
			Object obj=null;
			try {
				obj = cache0.get(DataDirMap);
			} catch (Exception e) {
				obj=null;
			}
			if(obj !=null){
				cache0.replace(DataDirMap, map);
			}else{
				cache0.put(DataDirMap, map);
			}
		}
	}

	public static List<DataDir> getDataDirList(String parentkey) {
		try {
			Object obj = cache0.get(DataDirMap);
			if(obj!=null)
				return ((Map<String, List<DataDir>>) obj).get(parentkey);
			return null;
		} catch (Exception e) {
			logger.error("getDataDirList", e);
		}
		return null;
	}
	public static void removeDataDirList(){
		try {
			Object obj =cache0.get(DataDirMap);
			if(obj !=null){
				cache0.remove(DataDirMap);
			}
		} catch (Exception e) {
			logger.info("error", e);
		}
	}
}
