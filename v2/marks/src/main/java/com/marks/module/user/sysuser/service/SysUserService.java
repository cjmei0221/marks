package com.marks.module.user.sysuser.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.user.sysuser.pojo.SysUser;

public interface SysUserService{

	public SysUser findByUserid(String userid);

	public String save(SysUser sysUser, String orgIdsPut, String orgNamesPut);

	public void update(SysUser sysUser, String orgIdsPut, String orgNamesPut);
	public void delete(String userid);
	public List<SysUser> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysUser> list(int page_number, int page_size,Map<String,Object> param);
	public SysUser findByMobile(String companyId, String bind_mobile);
	public SysUser findById(String userid);
	public void updatePwd(String userid,String pwd);
	public void updateMobile(String userid, String newPhone);
	public void updateActiveFlag(String userid, int flag);
	public void updateSkin(String userid, int parseInt);

	public String save(SysUser user);

	public void update(SysUser user);
	

}