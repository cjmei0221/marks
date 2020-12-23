package com.marks.smart.system.user.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.smart.system.system.sysmenu.pojo.SysMenu;
import com.marks.smart.system.system.sysmenu.pojo.SysOperate;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.SysUserOrgRole;
@MapperScan
public interface LoginDao {

	/**
	 * 通过userid获取系统用户信息
	 * getSysUserByUserid:描述 <br/>
	 *
	 * @param userid
	 * @return
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	SysUser findById(@Param("companyId") String companyId, @Param("id") String id);

	List<SysMenu> getChildMenu(@Param("roleId") String roleId);

	/**
	 * 通过角色和菜单ID获取功能列表
	 * getSysOperate:描述 <br/>
	 *
	 * @param menuid
	 * @param rolelist
	 * @return
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	List<SysOperate> getSysOperate(@Param("menuid") String menuid,@Param("roleId") String roleId);

	public List<SysMenu> getParentSysMenu();

	List<String> getUrlByRoleId(@Param("roleId") String roleId);

	List<SysUser> getSysUserByOpenidAndAccountid(@Param("accountid") String accountid, @Param("openid") String openid);

	SysUser getSysUserByUserid(@Param("userid") String userid);

	List<SysUser> listById(@Param("id") String id);

	List<String> getMenuIdByLog(@Param("userid") String userid, @Param("before3Month") String before3Month);

	List<SysUserOrgRole> getUserOrgRolelistByUserid(@Param("userid") String userid);

}
