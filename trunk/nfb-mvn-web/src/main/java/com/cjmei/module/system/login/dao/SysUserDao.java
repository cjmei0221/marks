package com.cjmei.module.system.login.dao;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.login.pojo.SysUser;

public interface SysUserDao {

	SysUser getSysUserByUseridOrMobile(@Param("userid")String userid);

	void updatePwd(@Param("userid")String userid, @Param("password")String password);

	void updateSkin(@Param("userid")String userid,@Param("skin") int skin);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

}
