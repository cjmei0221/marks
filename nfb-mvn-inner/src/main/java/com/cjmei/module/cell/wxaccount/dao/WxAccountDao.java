package com.cjmei.module.cell.wxaccount.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.cell.wxaccount.pojo.WxAccount;

public interface WxAccountDao {

	WxAccount findById(String accountId);

	void save(WxAccount wxAccount);

	void update(WxAccount wxAccount);

	void delete(String accountId);

	List<WxAccount> findAll();

	void deleteBatch(List<String> list);

	List<WxAccount> list(PageBounds pageBounds, Map<String,Object> param);
}