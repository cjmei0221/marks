package com.marks.smart.system.user.sysuser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.SysUserOrgRole;

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


	void deleteSysUserOrgRole(@Param("userid") String userid, @Param("orgid") String orgid);

	void deleteSysUserOrgRoleByUserid(@Param("userid") String userid);

	void saveSysUserOrgRole(SysUserOrgRole su);


	void updateSkin(@Param("userid") String userid, @Param("skin") int skin);

	String getMaxCode(@Param("companyId") String companyId, @Param("roleYwType") int roleYwType);

	List<SysUserOrgRole> findUserRoleByUserids(@Param("list") List<String> userids);

	void updateUnbinding(@Param("accountId") String accountId, @Param("openid") String openid);

	
	List<SysUser> findByParams(Map<String, String> param);


	SysUser findById(@Param("companyId") String companyId, @Param("id") String id);

	void updateOrgName(@Param("orgId") String orgId, @Param("orgName") String orgName);

	void updateCompanyName(@Param("orgId") String orgId, @Param("orgName") String orgName);

	void updateUserRoleOrg(@Param("orgId") String orgId, @Param("orgName") String orgName);

	void undateUnbindByTelOrOpenid(Map<String, String> param);

	List<SysUser> listActive(PageBounds pageBounds, Map<String, Object> param);

	String getUserId(@Param("companyId")String companyId);

}