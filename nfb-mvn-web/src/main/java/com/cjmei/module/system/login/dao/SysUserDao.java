package com.cjmei.module.system.login.dao;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.login.pojo.SysUser;

public interface SysUserDao {

	SysUser getSysUserByUseridOrMobile(@Param("userid")String userid);

	void updatePwd(@Param("userid")String userid, @Param("password")String password);

	void updateSkin(@Param("userid")String userid,@Param("skin") int skin);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

	String getRoleIdByUserTypeAndCompanyId(@Param("userType")String userType, @Param("companyId")String companyId);

	void saveSysUserRole(@Param("userid")String userid, @Param("roleid")String roleId,@Param("creator") String creator);

	void saveSysUserOrg(@Param("userid")String userid, @Param("orgid")String orgid, @Param("creator")String creator);

	void updateMobile(@Param("userid")String userid, @Param("mobile")String mobile);

}
