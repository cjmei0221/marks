package com.marks.module.user.sysuser.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.user.sysuser.pojo.SysUser;

public interface SysUserService{

	public SysUser findByUserid(String userid);

	public SysUser findByMobile(String companyId, String bind_mobile);

	public Result save(SysUser sysUser);

	public Result update(SysUser sysUser);

	public Result saveOrUpdate(SysUser sysUser);
	public void delete(String userid);
	public List<SysUser> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysUser> list(int page_number, int page_size,Map<String,Object> param);

	public void updatePwd(String userid,String pwd);
	public void updateMobile(String userid, String newPhone);

	public void updateActiveFlag(SysUser sysUser);
	public void updateSkin(String userid, int parseInt);

	/**
	 * 解绑
	 * 
	 * @param accountId
	 * @param fromUserName
	 */
	public void updateUnbinding(String accountId, String fromUserName);

	/**
	 * 绑定
	 * 
	 * @param user
	 */
	public void updateBinding(SysUser user);

	/**
	 * 解绑占有此手机号
	 * 
	 * @param companyId
	 * @param linkTel
	 */
	public void updateUnMobile(String companyId, String linkTel);

}