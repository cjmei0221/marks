package com.marks.smart.count.asset.manage.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.count.asset.manage.pojo.AssetPlan;
import com.marks.smart.count.asset.manage.dao.AssetPlanDao;
import com.marks.smart.count.asset.manage.service.AssetPlanService;

@Service
@Transactional
public class AssetPlanServiceImpl implements AssetPlanService{

	@Autowired
	private AssetPlanDao assetPlanDao;
   
/**
    private AssetPlanDao assetPlanDao;

    public AssetPlanDao getAssetPlanDao(){
        return assetPlanDao;
    }
    public void setAssetPlanDao(AssetPlanDao assetPlanDao){
        this.assetPlanDao =assetPlanDao;
    }

 */   
    /**
    *根据ID查找理财
    */
    @Override
    public AssetPlan findById(String id){
        return assetPlanDao.findById(id);
    }
    
    /**
    *保存理财
    */
    @Override
    public void save(AssetPlan info){
        assetPlanDao.save(info);
    }
    
    /**
    *更新理财
    */
    @Override
    public void update(AssetPlan info){
        assetPlanDao.update(info);
    }
    
    /**
    *删除理财
    */
    @Override
    public void delete(String id){
        assetPlanDao.delete(id);       
    }
    
    /**
    *查找所有理财
    */
    @Override
    public List<AssetPlan> findAll(){
        return assetPlanDao.findAll();   
    }
    
    /**
    *删除多个理财
    */
    @Override
   public void deleteBatch(List<String> ids) {
		assetPlanDao.deleteBatch(ids);
	}
	
	public PojoDomain<AssetPlan> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<AssetPlan> pojoDomain = new PojoDomain<AssetPlan>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AssetPlan> list = assetPlanDao.list(pageBounds,param);
		PageList<AssetPlan> pageList = (PageList<AssetPlan>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}