package com.marks.module.system.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marks.module.system.sys.pojo.SysFunc;
import com.marks.module.system.sys.pojo.SysMenu;
import com.marks.module.system.sys.pojo.SysOperate;

public interface SysMenuDao {

	List<SysMenu> getChildSysMenuList();

	List<SysMenu> getParentSysMenuList();

	void save(@Param("sm") SysMenu sm);

	SysMenu getSysMenuByMenuid(@Param("menuid") String menuid);

	void update(@Param("sm") SysMenu sm);

	List<SysMenu> getChildListByParentid(@Param("menuid") String menuid);

	void delete(@Param("menuid") String menuid);

	void deleteRoleFunc(@Param("menuid") String menuid);

	void deleteFunc(@Param("menuid") String menuid);

	void deletSysRolecUrlByFuncid(@Param("funcid")String funcid);

	void deletSysFuncByFuncid(@Param("funcid")String funcid);

	void saveSysFunc(@Param("sf")SysFunc sf);

	SysOperate getSysOperateByOperid(@Param("operid")String operid);

	List<SysOperate> getSysOperateListByMenuid(@Param("menuid")String menuid);

	SysFunc getSysFuncByOperIdAndMenuid(@Param("menuid")String menuid,@Param("operid") String operid);

	List<SysOperate> getSysOperateList();

}
