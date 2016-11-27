package com.cjmei.module.system.sysconf.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.system.sysconf.pojo.SysConf;
import com.cjmei.module.system.sysconf.dao.SysConfDao;
import com.cjmei.module.system.sysconf.service.SysConfService;

public class SysConfServiceImpl implements SysConfService{
   

    private SysConfDao sysConfDao;

    public SysConfDao getSysConfDao(){
        return sysConfDao;
    }
    public void setSysConfDao(SysConfDao sysConfDao){
        this.sysConfDao =sysConfDao;
    }

    
    /**
    *根据ID查找系统参数
    */
    @Override
    public SysConf findById(String ckey){
        return sysConfDao.findById(ckey);
    }
    
    /**
    *保存系统参数
    */
    @Override
    public void save(SysConf sysConf){
        sysConfDao.save(sysConf);
    }
    
    /**
    *更新系统参数
    */
    @Override
    public void update(SysConf sysConf){
        sysConfDao.update(sysConf);
    }
    
    /**
    *删除系统参数
    */
    @Override
    public void delete(String ckey){
        sysConfDao.delete(ckey);       
    }
    
    /**
    *查找所有系统参数
    */
    @Override
    public List<SysConf> findAll(){
        return sysConfDao.findAll();   
    }
    
    /**
    *删除多个系统参数
    */
    @Override
   public void deleteBatch(List<String> ids) {
		sysConfDao.deleteBatch(ids);
	}
	
	public PojoDomain<SysConf> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<SysConf> pojoDomain = new PojoDomain<SysConf>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysConf> list = sysConfDao.list(pageBounds,param);
		PageList<SysConf> pageList = (PageList<SysConf>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}