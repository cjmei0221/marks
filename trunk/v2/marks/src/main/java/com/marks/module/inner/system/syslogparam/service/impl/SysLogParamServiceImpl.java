package com.marks.module.inner.system.syslogparam.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.inner.system.syslogparam.pojo.SysLogParam;
import com.marks.module.inner.system.syslogparam.dao.SysLogParamDao;
import com.marks.module.inner.system.syslogparam.service.SysLogParamService;

public class SysLogParamServiceImpl implements SysLogParamService{
   

    private SysLogParamDao sysLogParamDao;

    public SysLogParamDao getSysLogParamDao(){
        return sysLogParamDao;
    }
    public void setSysLogParamDao(SysLogParamDao sysLogParamDao){
        this.sysLogParamDao =sysLogParamDao;
    }

    
    /**
    *根据ID查找日志参数
    */
    @Override
    public SysLogParam findById(String id){
        return sysLogParamDao.findById(id);
    }
    
    /**
    *保存日志参数
    */
    @Override
    public void save(SysLogParam sysLogParam){
        sysLogParamDao.save(sysLogParam);
    }
    
    /**
    *更新日志参数
    */
    @Override
    public void update(SysLogParam sysLogParam){
        sysLogParamDao.update(sysLogParam);
    }
    
    /**
    *删除日志参数
    */
    @Override
    public void delete(String id){
        sysLogParamDao.delete(id);       
    }
    
    /**
    *查找所有日志参数
    */
    @Override
    public List<SysLogParam> findAll(){
        return sysLogParamDao.findAll();   
    }
    
    /**
    *删除多个日志参数
    */
    @Override
   public void deleteBatch(List<String> ids) {
		sysLogParamDao.deleteBatch(ids);
	}
	
	public PojoDomain<SysLogParam> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<SysLogParam> pojoDomain = new PojoDomain<SysLogParam>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysLogParam> list = sysLogParamDao.list(pageBounds,param);
		PageList<SysLogParam> pageList = (PageList<SysLogParam>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public SysLogParam findByUrlAndSource(String url, int source) {
		return sysLogParamDao.findByUrlAndSource(url,source);
	}
	
}