package com.cjmei.module.note.transaction.service;


import com.cjmei.module.note.transaction.pojo.Transaction;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface TransactionService{

	public Transaction findById(String id);
	public void save(Transaction transaction);
	public void update(Transaction transaction);
	public void delete(String id);
	public List<Transaction> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Transaction> list(int page_number, int page_size,Map<String,Object> param);
}