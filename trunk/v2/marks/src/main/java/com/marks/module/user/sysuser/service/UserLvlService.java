package com.marks.module.user.sysuser.service;


import com.marks.module.user.sysuser.pojo.UserLvl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface UserLvlService{

	public UserLvl findById(String lvlId);
	public void save(UserLvl info);
	public void update(UserLvl info);
	public void delete(String id);
	public List<UserLvl> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<UserLvl> list(int page_number, int page_size,Map<String,Object> param);
}