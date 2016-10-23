package com.cjmei.module.system.sysuser.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.system.sysuser.pojo.SysUser;
import com.cjmei.module.system.sysuser.dao.SysUserDao;
import com.cjmei.module.system.sysuser.service.SysUserService;

public class SysUserServiceImpl implements SysUserService{
   

    private SysUserDao sysUserDao;

    public SysUserDao getSysUserDao(){
        return sysUserDao;
    }
    public void setSysUserDao(SysUserDao sysUserDao){
        this.sysUserDao =sysUserDao;
    }

    
    /**
    *根据ID查找用户管理
    */
    @Override
    public SysUser findById(String userid){
        return sysUserDao.findById(userid);
    }
    
    /**
    *保存用户管理
    */
    @Override
    public void save(SysUser sysUser){
        sysUserDao.save(sysUser);
    }
    
    /**
    *更新用户管理
    */
    @Override
    public void update(SysUser sysUser){
        sysUserDao.update(sysUser);
    }
    
    /**
    *删除用户管理
    */
    @Override
    public void delete(String userid){
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
	
}