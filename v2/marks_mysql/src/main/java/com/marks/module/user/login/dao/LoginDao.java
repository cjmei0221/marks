package com.marks.module.user.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.system.sys.pojo.SysMenu;
import com.marks.module.system.sys.pojo.SysOperate;
import com.marks.module.user.sysuser.pojo.SysUser;
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
	SysUser getSysUserByUserid(@Param("userid") String userid);

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

	List<String> getUrlByUserid(@Param("userid") String userid);

	List<String> getOrgidBySysUser(@Param("orglist")List<OrgInfo> orglist);

	List<OrgInfo> getOrgInfoListByUserid(@Param("userid")String userid);

	SysUser getSysUserByOpenidAndAccountid(@Param("accountid")String accountid, @Param("openid")String openid);


}
