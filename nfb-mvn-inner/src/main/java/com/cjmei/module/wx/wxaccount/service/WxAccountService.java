package com.cjmei.module.wx.wxaccount.service;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.wx.wxaccount.pojo.WxAccount;

public interface WxAccountService{

	public WxAccount findById(String accountId);
	public void save(WxAccount wxAccount);
	public void update(WxAccount wxAccount);
	public void delete(String accountId);
	public List<WxAccount> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxAccount> list(int page_number, int page_size,Map<String,Object> param);
}