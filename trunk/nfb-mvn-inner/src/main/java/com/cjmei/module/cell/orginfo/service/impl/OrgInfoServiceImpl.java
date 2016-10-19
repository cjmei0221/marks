package com.cjmei.module.cell.orginfo.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.cell.orginfo.pojo.OrgInfo;
import com.cjmei.module.cell.orginfo.dao.OrgInfoDao;
import com.cjmei.module.cell.orginfo.service.OrgInfoService;

public class OrgInfoServiceImpl implements OrgInfoService{
   

    private OrgInfoDao orgInfoDao;

    public OrgInfoDao getOrgInfoDao(){
        return orgInfoDao;
    }
    public void setOrgInfoDao(OrgInfoDao orgInfoDao){
        this.orgInfoDao =orgInfoDao;
    }

    
    /**
    *根据ID查找机构管理
    */
    @Override
    public OrgInfo findById(String orgid){
        return orgInfoDao.findById(orgid);
    }
    
    /**
    *保存机构管理
    */
    @Override
    public void save(OrgInfo orgInfo){
        orgInfoDao.save(orgInfo);
    }
    
    /**
    *更新机构管理
    */
    @Override
    public void update(OrgInfo orgInfo){
        orgInfoDao.update(orgInfo);
    }
    
    /**
    *删除机构管理
    */
    @Override
    public void delete(String orgid){
        orgInfoDao.delete(orgid);       
    }
    
    /**
    *查找所有机构管理
    */
    @Override
    public List<OrgInfo> findAll(){
        return orgInfoDao.findAll();   
    }
    
    /**
    *删除多个机构管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		orgInfoDao.deleteBatch(ids);
	}
	
	public PojoDomain<OrgInfo> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<OrgInfo> pojoDomain = new PojoDomain<OrgInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrgInfo> list = orgInfoDao.list(pageBounds,param);
		PageList<OrgInfo> pageList = (PageList<OrgInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}