package com.cjmei.module.system.sysuser.service;


import com.cjmei.module.system.sysuser.pojo.SysUser;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface SysUserService{

	public SysUser findByUserid(String userid);
	public void save(SysUser sysUser,String roleidPut,String orgIdsPut);
	public void update(SysUser sysUser,String roleidPut,String orgIdsPut);
	public void delete(String userid);
	public List<SysUser> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysUser> list(int page_number, int page_size,Map<String,Object> param);
	public SysUser findByMobile(String bind_mobile);
	public SysUser findById(String userid);
	public void updatetPwd(SysUser su);
	public void updateMobile(String userid, String newPhone);

}