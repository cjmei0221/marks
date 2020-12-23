package com.marks.smart.count.asset.base.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.count.asset.base.pojo.Asset;
import com.marks.smart.count.asset.base.dao.AssetDao;
import com.marks.smart.count.asset.base.service.AssetService;

@Service
@Transactional
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetDao assetDao;
   
/**
    private AssetDao assetDao;

    public AssetDao getAssetDao(){
        return assetDao;
    }
    public void setAssetDao(AssetDao assetDao){
        this.assetDao =assetDao;
    }

 */   
    /**
    *根据ID查找资产
    */
    @Override
    public Asset findById(String id){
        return assetDao.findById(id);
    }
    
    /**
    *保存资产
    */
    @Override
    public void save(Asset info){
        assetDao.save(info);
    }
    
    /**
    *更新资产
    */
    @Override
    public void update(Asset info){
        assetDao.update(info);
    }
    
    /**
    *删除资产
    */
    @Override
    public void delete(String id){
        assetDao.delete(id);       
    }
    
    /**
    *查找所有资产
    */
    @Override
    public List<Asset> findAll(){
        return assetDao.findAll();   
    }
    
    /**
    *删除多个资产
    */
    @Override
   public void deleteBatch(List<String> ids) {
		assetDao.deleteBatch(ids);
	}
	
	public PojoDomain<Asset> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Asset> pojoDomain = new PojoDomain<Asset>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Asset> list = assetDao.list(pageBounds,param);
		PageList<Asset> pageList = (PageList<Asset>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}