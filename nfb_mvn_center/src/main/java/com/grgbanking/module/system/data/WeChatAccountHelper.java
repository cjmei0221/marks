package com.grgbanking.module.system.data;

import java.util.HashMap;
import java.util.Map;

import com.grgbanking.module.wxfwhao.entity.WeChatAccount;

public class WeChatAccountHelper {
	
	private static Map<String, WeChatAccount> account_map=new HashMap<String, WeChatAccount>();

	
	public static WeChatAccount getWeChatAccount(String accountId) throws Exception{
		WeChatAccount weChatAccount=account_map.get(accountId);
		if(weChatAccount==null)
			throw new Exception("accountid="+accountId+"的微信公众账号参数未配置");
		return weChatAccount;
	}
	
	
	public static void put(WeChatAccount weChatAccount){
		if(null !=weChatAccount){
			account_map.remove(weChatAccount.getAccountid());
			account_map.put(weChatAccount.getAccountid(), weChatAccount);
		}
	}
}
