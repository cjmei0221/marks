package com.marks.smart.system.user.sysuser.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

public interface SysUserService{

	public SysUser findByUserid(String userid);

	public SysUser findByMobile(String companyId, String bind_mobile);



	public Result saveOrUpdate(SysUser sysUser);
	public void delete(String userid);
	public List<SysUser> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysUser> list(int page_number, int page_size,Map<String,Object> param);


	public SysUser findById(String companyId, String vipId);

	/**
	 * 更新用户机构名称
	 * 
	 * @param orgid
	 * @param orgname
	 */
	public void updateOrgName(String orgid, String orgname);

	public PojoDomain<SysUser> listActive(int page_number, int page_size, Map<String, Object> param);

	public void updateUnbinding(String accountId, String openid);

	public void updatePwd(String userid, String defaultPwd);

	public void updateSkin(String userid, int parseInt);

}