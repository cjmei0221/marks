package com.marks.module.wx.manage.service.base;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.entity.base.WxAccount;

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