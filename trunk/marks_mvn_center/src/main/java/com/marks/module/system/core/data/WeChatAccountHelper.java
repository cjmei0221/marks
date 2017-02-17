package com.marks.module.system.core.data;

import java.util.HashMap;
import java.util.Map;

import com.marks.module.wxfwhao.common.entity.WxAccount;

public class WeChatAccountHelper {
	
	private static Map<String, WxAccount> account_map=new HashMap<String, WxAccount>();

	
	public static WxAccount getWeChatAccount(String accountId) throws Exception{
		WxAccount weChatAccount=account_map.get(accountId);
		if(weChatAccount==null)
			throw new Exception("accountid="+accountId+"的微信公众账号参数未配置");
		return weChatAccount;
	}
	
	
	public static void put(WxAccount weChatAccount){
		if(null !=weChatAccount){
			account_map.remove(weChatAccount.getAccountId());
			account_map.put(weChatAccount.getAccountId(), weChatAccount);
		}
	}
}
