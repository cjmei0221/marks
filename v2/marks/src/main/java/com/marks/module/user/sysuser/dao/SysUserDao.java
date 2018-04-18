package com.marks.module.user.sysuser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserOrgRole;

@MapperScan
public interface SysUserDao {

	SysUser findByUserid(String userid);

	SysUser findByMobile(@Param("companyId") String companyId, @Param("mobile") String mobile);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

	void delete(String userid);

	List<SysUser> findAll();

	void deleteBatch(List<String> list);

	List<SysUser> list(PageBounds pageBounds, Map<String, Object> param);

	void updatePwd(@Param("userid") String userid, @Param("password") String password);

	void updateMobile(@Param("userid") String userid, @Param("newPhone") String newPhone);

	void deleteSysUserOrgRole(@Param("userid") String userid, @Param("orgid") String orgid);

	void deleteSysUserOrgRoleByUserid(@Param("userid") String userid);

	void saveSysUserOrgRole(SysUserOrgRole su);

	void updateActiveFlag(@Param("userid") String userid, @Param("flag") int flag);

	void updateSkin(@Param("userid") String userid, @Param("skin") int skin);

	String getMaxCode(@Param("companyId") String companyId);

	List<SysUserOrgRole> findUserRoleByUserids(@Param("list") List<String> userids);

	void updateUnbinding(@Param("accountId") String accountId, @Param("openid") String openid);

	void updateBinding(SysUser user);

	void updateforbidOrder(@Param("companyId") String companyId, @Param("userid") String userid,
			@Param("mobile") String mobile, @Param("openid") String openid);

}