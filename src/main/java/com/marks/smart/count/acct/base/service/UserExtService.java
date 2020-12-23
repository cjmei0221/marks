package com.marks.smart.count.acct.base.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.count.acct.base.pojo.UserExt;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

public interface UserExtService{

	public UserExt findById(String userid);

	public void saveOrUpdate(SysUser sysUser);

	public void delete(String id);
	public List<UserExt> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<UserExt> list(int page_number, int page_size,Map<String,Object> param);

	public UserExt findByMobile(String companyId, String mobile);

	/**
	 * 更新销售
	 * 
	 * @param vipId
	 * @param point
	 * @param payAmt
	 */
	public void updateVipInfoByOrder(String vipId, int point, String payAmt);
}