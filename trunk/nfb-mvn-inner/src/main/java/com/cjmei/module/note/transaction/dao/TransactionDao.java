package com.cjmei.module.note.transaction.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.note.transaction.pojo.Transaction;

public interface TransactionDao {

	Transaction findById(String id);

	void save(Transaction transaction);

	void update(Transaction transaction);

	void delete(String id);

	List<Transaction> findAll();

	void deleteBatch(List<String> list);

	List<Transaction> list(PageBounds pageBounds, Map<String,Object> param);
}