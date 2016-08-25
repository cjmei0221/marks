package com.grgbanking.inner.data;

import java.util.List;

import com.grgbanking.infra.InfraUtil;
import com.grgbanking.infra.pojo.DataDir;

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
	/**
	 * 获取缓存中的系统参数
	 * getSysConf:描述 <br/>
	 *
	 * @param key
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String getSysConf(String key){
		return InfraUtil.getInstance().getSysConfByKey(key);
	}
	/**
	 * 获取缓存中的数据字典
	 * getDataDir:描述 <br/>
	 *
	 * @param parentkey
	 * @param key
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static String getDataDir(String parentkey,String key){
		return InfraUtil.getInstance().getDataDirByParentkeyAndCKey(parentkey, key);
	}
	/**
	 * 通过父ID获取数组字典中子集合
	 * getDataDirList:描述 <br/>
	 *
	 * @param parentkey
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public static List<DataDir> getDataDirList(String parentkey){	
		return InfraUtil.getInstance().getDataDirList(parentkey);
	}
}
