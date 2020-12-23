package com.marks.smart.wx.manage.mp.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.wx.manage.mp.entity.WxAccount;

public interface WxAccountService{

	public WxAccount findById(String accountId);
	public void save(WxAccount wxAccount);
	public void update(WxAccount wxAccount);
	public void delete(String accountId);
	public List<WxAccount> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxAccount> list(int page_number, int page_size,Map<String,Object> param);
	public List<WxAccount> combox(Map<String, Object> param);
	public List<String> getAccountIdsByLoginUser(Map<String, Object> param);
}