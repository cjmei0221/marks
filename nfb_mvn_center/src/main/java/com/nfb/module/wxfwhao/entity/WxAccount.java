package com.nfb.module.wxfwhao.entity;

public class WxAccount {
	
	private String accountId;
	
	private String accountName;
	
	private String appId;
	
	private String appSecret;
	
	private String server_context;
	
	private String authDomain;//应用域名
	
	public WxAccount(){}

	public WxAccount(String appId, String appSecret) {
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
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAuthDomain() {
		return authDomain;
	}

	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}

	public String getServer_context() {
		return server_context;
	}

	public void setServer_context(String serverContext) {
		server_context = serverContext;
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
		WxAccount other = (WxAccount) obj;
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
