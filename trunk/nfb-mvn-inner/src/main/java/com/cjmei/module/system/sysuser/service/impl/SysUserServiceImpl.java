package com.cjmei.module.system.sysuser.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.system.sys.pojo.SysUserOrg;
import com.cjmei.module.system.sys.pojo.SysUserRole;
import com.cjmei.module.system.sysrole.dao.SysRoleDao;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysuser.dao.SysUserDao;
import com.cjmei.module.system.sysuser.pojo.SysUser;
import com.cjmei.module.system.sysuser.service.SysUserService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class SysUserServiceImpl implements SysUserService{
   

    private SysUserDao sysUserDao;

    public SysUserDao getSysUserDao(){
        return sysUserDao;
    }
    public void setSysUserDao(SysUserDao sysUserDao){
        this.sysUserDao =sysUserDao;
    }
    private SysRoleDao sysRoleDao;

	public SysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}
    
    /**
    *根据ID查找用户管理
    */
    @Override
    public SysUser findByUserid(String userid){
        return sysUserDao.findByUserid(userid);
    }
    
    /**
     * 根據手機號查詢用戶信息
     */
    @Override
	public SysUser findByMobile(String bind_mobile) {
    	 return sysUserDao.findByMobile(bind_mobile);
	}
    
    
	@Override
	public SysUser findById(String userid) {
		return sysUserDao.findById(userid);
	}
	/**
    *保存用户管理
    */
    @Override
    public void save(SysUser sysUser,String roleidPut,String orgIdsPut){
    	SysRole sRole=sysRoleDao.findById(roleidPut);
    	sysUser.setUserType(sRole.getUserType());
        sysUserDao.save(sysUser);
        saveSysUserRole(sysUser.getUserid(),roleidPut,sysUser.getCreator());
    }
    
    /**
    *更新用户管理
    */
    @Override
    public void update(SysUser sysUser,String roleidPut,String orgIdsPut){
    	SysRole sRole=sysRoleDao.findById(roleidPut);
    	sysUser.setUserType(sRole.getUserType());
        sysUserDao.update(sysUser);
        saveSysUserRole(sysUser.getUserid(),roleidPut,sysUser.getCreator());
    }
    private void saveSysUserOrg(String userid,String orgIdsPut,SysUser sysUser){
    	sysUserDao.deleteSysUserOrg(userid);
    	SysUserOrg su=null;
    	String[] arr=orgIdsPut.split(",");
    	for(String id:arr){
    		if(id !=null && !"".equals(id)){
    			su=new SysUserOrg();
        		su.setOrgid(id);
        		su.setUserid(userid);
        		su.setCreator(sysUser.getUserid());
        		sysUserDao.saveSysUserOrg(su);
    		}
    	}
    	
    }
    
    @Override
	public void updatetPwd(SysUser su) {
    	 sysUserDao.updatetPwd(su);
	}
	private void saveSysUserRole(String userid,String roleidPut,String creator){
    	sysUserDao.deleteSysUserRole(userid);
    	SysUserRole su=null;
    	String[] roleArr=roleidPut.split(",");
    	for(String roleid:roleArr){
    		if(roleid !=null && !"".equals(roleid)){
    			su=new SysUserRole();
        		su.setRoleid(roleid);
        		su.setUserid(userid);
        		su.setCreator(creator);
        		sysUserDao.saveSysUserRole(su);
    		}
    	}
    	
    }
    
    /**
    *删除用户管理
    */
    @Override
    public void delete(String userid){
        sysUserDao.delete(userid);  
        sysUserDao.deleteSysUserRole(userid);
    }
    
    /**
    *查找所有用户管理
    */
    @Override
    public List<SysUser> findAll(){
        return sysUserDao.findAll();   
    }
    
    /**
    *删除多个用户管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		sysUserDao.deleteBatch(ids);
	}
	
	public PojoDomain<SysUser> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<SysUser> pojoDomain = new PojoDomain<SysUser>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysUser> list = sysUserDao.list(pageBounds,param);
		PageList<SysUser> pageList = (PageList<SysUser>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public void updateMobile(String userid, String newPhone) {
		 sysUserDao.updateMobile(userid,newPhone);
	}
	
	
}