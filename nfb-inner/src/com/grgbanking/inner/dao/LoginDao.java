package com.grgbanking.inner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.inner.po.sys.SysMenu;
import com.grgbanking.inner.po.sys.SysOperate;
import com.grgbanking.inner.po.sys.SysUser;

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

	List<SysMenu> getChildMenu(@Param("roleids") List<Integer> roleids);

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
	List<SysOperate> getSysOperate(@Param("menuid") String menuid,@Param("roleids") List<Integer> rolelist);

	public List<SysMenu> getParentSysMenu();
}
