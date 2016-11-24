package com.cjmei.module.wx.wxaccount.dao;


import java.util.List;
import java.util.Map;

import com.cjmei.module.wx.wxaccount.pojo.WxAccount;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WxAccountDao {

	WxAccount findById(String accountId);

	void save(WxAccount wxAccount);

	void update(WxAccount wxAccount);

	void delete(String accountId);

	List<WxAccount> findAll();

	void deleteBatch(List<String> list);

	List<WxAccount> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxAccount> getWxfwhaoList(Map<String, Object> param);

	List<String> getAccountIdsByLoginUser(Map<String, Object> param);
}