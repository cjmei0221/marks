package com.marks.smart.system.user.sysuser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

@MapperScan
public interface UserLogDao {

	
	void save(@Param("info")SysUser info);

	
	List<SysUser> list(PageBounds pageBounds, Map<String, Object> param);



}