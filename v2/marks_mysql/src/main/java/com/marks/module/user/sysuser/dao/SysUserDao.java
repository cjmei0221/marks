package com.marks.module.user.sysuser.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserOrg;
@MapperScan
public interface SysUserDao {

	SysUser findByUserid(String userid);
	SysUser findByMobile(String mobile);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

	void delete(String userid);

	List<SysUser> findAll();

	void deleteBatch(List<String> list);

	List<SysUser> list(PageBounds pageBounds, Map<String,Object> param);
	SysUser findById(@Param("userid")String userid);
	void updatePwd(@Param("userid")String userid, @Param("password")String password);
	void updateMobile(@Param("userid")String userid, @Param("newPhone")String newPhone);
	void deleteSysUserOrg(@Param("userid") String userid);
	void saveSysUserOrg(SysUserOrg su);
	void updateActiveFlag(@Param("userid") String userid,@Param("flag") int flag);
	void updateSkin(@Param("userid")String userid,@Param("skin") int skin);
	String getUserIdForUser();
	
}