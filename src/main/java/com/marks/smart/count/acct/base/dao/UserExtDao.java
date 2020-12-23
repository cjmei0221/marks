package com.marks.smart.count.acct.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.count.acct.base.pojo.UserExt;

@MapperScan
public interface UserExtDao {

	UserExt findById(@Param("userid") String userid);

	void save(@Param("info") UserExt userExt);
	

	void update(@Param("info") UserExt userExt);

	void delete(@Param("userid") String userid);

	List<UserExt> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<UserExt> list(PageBounds pageBounds, Map<String,Object> param);

	UserExt findByMobile(@Param("companyId") String companyId, @Param("mobile") String mobile);
}