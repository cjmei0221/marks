package com.grgbanking.module.wxfwhao.entity;

public class WeChatAccount {
	
	private String accountid;
	
	private String account_name;
	
	private String appId;
	
	private String appSecret;
	
	private String server_context;
	
	private String authdomain;//应用域名
	
	public WeChatAccount(){}

	public WeChatAccount(String appId, String appSecret) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getServer_context() {
		return server_context;
	}

	public void setServer_context(String serverContext) {
		server_context = serverContext;
	}

	public String getAuthdomain() {
		return authdomain;
	}

	public void setAuthdomain(String authdomain) {
		this.authdomain = authdomain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result
				+ ((appSecret == null) ? 0 : appSecret.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeChatAccount other = (WeChatAccount) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (appSecret == null) {
			if (other.appSecret != null)
				return false;
		} else if (!appSecret.equals(other.appSecret))
			return false;
		return true;
	}
	
	
}
