package com.marks.module.system.sysuser.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.sys.pojo.SysUserOrg;
import com.marks.module.system.sysrole.dao.SysRoleDao;
import com.marks.module.system.sysuser.dao.SysUserDao;
import com.marks.module.system.sysuser.pojo.SysUser;
import com.marks.module.system.sysuser.service.SysUserService;
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
    public void save(SysUser sysUser,String orgIdsPut){
        sysUserDao.save(sysUser);
        saveSysUserOrg(sysUser.getUserid(),orgIdsPut,sysUser.getCreator());
    }
    
    /**
    *更新用户管理
    */
    @Override
    public void update(SysUser sysUser,String orgIdsPut){
        sysUserDao.update(sysUser);
        saveSysUserOrg(sysUser.getUserid(),orgIdsPut,sysUser.getCreator());
    }
    private void saveSysUserOrg(String userid,String orgIdsPut,String creator){
    	sysUserDao.deleteSysUserOrg(userid);
    	SysUserOrg su=null;
    	String[] arr=orgIdsPut.split(",");
    	for(String id:arr){
    		if(id !=null && !"".equals(id)){
    			su=new SysUserOrg();
        		su.setOrgid(id);
        		su.setUserid(userid);
        		su.setCreator(creator);
        		sysUserDao.saveSysUserOrg(su);
    		}
    	}
    	
    }
    
    @Override
	public void updatetPwd(SysUser su) {
    	 sysUserDao.updatetPwd(su);
	}
    
	@Override
	public void updateActiveFlag(String userid, int flag) {
		 sysUserDao.updateActiveFlag(userid,flag);
	}
    
    /**
    *删除用户管理
    */
    @Override
    public void delete(String userid){  
        sysUserDao.deleteSysUserOrg(userid);
        sysUserDao.delete(userid);  
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