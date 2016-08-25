package com.grgbanking.infra.service;

import java.util.List;

import com.grgbanking.infra.pojo.DataDir;
import com.grgbanking.infra.pojo.SysConf;
import com.grgbanking.infra.pojo.WxAccount;

public interface InfraService {
	
	public void putDatadirList(List<DataDir> list);
	
	public List<DataDir> getDataDirList(String parentkey);
	
	public String getDataDirByParentkeyAndCKey(String parentkey,String ckey);
	
	public void putSysConfList(List<SysConf> list);
	
	public String getSysConfByKey(String key);
	
	public void putWxAccount(List<WxAccount> list);
	
	public WxAccount getWxAccount(String accountid);
	
}
