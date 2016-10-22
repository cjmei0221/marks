package com.cjmei.module.system.orginfo.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.TreeVo;
import com.cjmei.module.system.orginfo.dao.OrgInfoDao;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;
import com.cjmei.module.system.orginfo.service.OrgInfoService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

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
	
	public List<OrgInfo> list(String parentid) {
		
		List<OrgInfo> list = orgInfoDao.getTreeGridByParentId(parentid);
		
		return list;
	}
	@Override
	public List<TreeVo> getChildListByParentId(String parentId) {
		List<TreeVo> returnlist =orgInfoDao.getChildListByParentId(parentId);
		return returnlist;
	}
	@Override
	public PojoDomain<OrgInfo> framelist(int page_number, int page_size, Map<String, Object> param) {
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