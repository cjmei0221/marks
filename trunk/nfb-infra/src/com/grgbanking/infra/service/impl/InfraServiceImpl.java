package com.grgbanking.infra.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grgbanking.infra.pojo.DataDir;
import com.grgbanking.infra.pojo.SysConf;
import com.grgbanking.infra.pojo.WxAccount;
import com.grgbanking.infra.service.InfraService;
import com.grgbanking.infra.util.Constants;
import com.grgbanking.infra.util.MemcachedUtil;

public class InfraServiceImpl implements InfraService{
	
	private static InfraServiceImpl instance=null;
	
	private InfraServiceImpl(){}
	
	public static InfraServiceImpl getInstance(){
		if(instance ==null){
			instance=new InfraServiceImpl();
		}
		return instance;
	}

	@Override
	public void putDatadirList(List<DataDir> list) {
		Map<String,List<DataDir>> dataMap=new HashMap<String,List<DataDir>>();
		List<DataDir> parent=new ArrayList<DataDir>();
		if (null != list && list.size() > 0) {
			for (DataDir info : list) {
				if(Constants.top_datadir_info_parentid.equals(info.getParentkey())){
					parent.add(info);
				}
			}
			if(parent.size() >0){
				for(DataDir ckey:parent){
					for(DataDir info:list){
						if(info.getParentkey().equals(info.getCkey())){
							ckey.addChildren(info);
						}
					}
				}
			}
			for(DataDir dd:parent){
				dataMap.put(dd.getCkey(),dd.getChildren());
			}
			MemcachedUtil.putDataDirMap(dataMap);
		}
	}

	@Override
	public List<DataDir> getDataDirList(String parentkey) {
		return MemcachedUtil.getDataDirList(parentkey);
	}

	@Override
	public String getDataDirByParentkeyAndCKey(String parentkey, String ckey) {
		String str="";
		List<DataDir> list=MemcachedUtil.getDataDirList(parentkey);
		if(list !=null && list.size()>0){
			for(DataDir dd:list){
				if(dd.getCkey().equals(ckey)){
					str=dd.getCvalue();
					break;
				}
			}
		}
		return str;
	}

	@Override
	public void putSysConfList(List<SysConf> list) {
		Map<String,String> map=new HashMap<String,String>();
		if(list !=null && list.size()>0){
			for(SysConf sc:list){
				map.put(sc.getCkey(), sc.getCvalue());
			}
			MemcachedUtil.putSysConfMap(map);
		}
	}

	@Override
	public String getSysConfByKey(String key) {
		return MemcachedUtil.getSysConf(key);
	}

	@Override
	public void putWxAccount(List<WxAccount> list) {
		Map<String,WxAccount> map=new HashMap<String,WxAccount>();
		if(list !=null && list.size()>0){
			for(WxAccount sc:list){
				map.put(sc.getId(), sc);
			}
			MemcachedUtil.putWxAccountMap(map);
		}
	}

	@Override
	public WxAccount getWxAccount(String accountid) {
		return MemcachedUtil.getWxAccount(accountid);
	}

	
	
}
