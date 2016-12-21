package com.cjmei.module.system.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysuser.pojo.SysUser;

public interface LoginDao {

	/**
	 * 通过userid获取系统用户信息
	 * getSysUserByUserid:描述 <br/>
	 *
	 * @param userid
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	SysUser getSysUserByUserid(@Param("userid")String userid);

	List<SysMenu> getChildMenu(@Param("list") List<SysRole> list);

	/**
	 * 通过角色和菜单ID获取功能列表
	 * getSysOperate:描述 <br/>
	 *
	 * @param menuid
	 * @param rolelist
	 * @return
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	List<SysOperate> getSysOperate(@Param("menuid") String menuid,@Param("list") List<SysRole> list);

	public List<SysMenu> getParentSysMenu();

	List<String> getUrlByUserid(@Param("userid") String userid);

	List<String> getRoleIdsByUserid(@Param("userid") String userid);

	List<SysRole> getUserRoleList(@Param("userid")String userid);

	List<String> getOrgidBySysUser(@Param("orgid")String orgid);


}
