package com.marks.module.asset.base.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.asset.base.pojo.AssetLog;
import com.marks.module.asset.base.dao.AssetLogDao;
import com.marks.module.asset.base.service.AssetLogService;

@Service
@Transactional
public class AssetLogServiceImpl implements AssetLogService{

	@Autowired
	private AssetLogDao assetLogDao;
   
/**
    private AssetLogDao assetLogDao;

    public AssetLogDao getAssetLogDao(){
        return assetLogDao;
    }
    public void setAssetLogDao(AssetLogDao assetLogDao){
        this.assetLogDao =assetLogDao;
    }

 */   
    /**
    *根据ID查找记账
    */
    @Override
    public AssetLog findById(String id){
        return assetLogDao.findById(id);
    }
    
    /**
    *保存记账
    */
    @Override
    public void save(AssetLog info){
        assetLogDao.save(info);
    }
    
    /**
    *更新记账
    */
    @Override
    public void update(AssetLog info){
        assetLogDao.update(info);
    }
    
    /**
    *删除记账
    */
    @Override
    public void delete(String id){
        assetLogDao.delete(id);       
    }
    
    /**
    *查找所有记账
    */
    @Override
    public List<AssetLog> findAll(){
        return assetLogDao.findAll();   
    }
    
    /**
    *删除多个记账
    */
    @Override
   public void deleteBatch(List<String> ids) {
		assetLogDao.deleteBatch(ids);
	}
	
	public PojoDomain<AssetLog> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<AssetLog> pojoDomain = new PojoDomain<AssetLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AssetLog> list = assetLogDao.list(pageBounds,param);
		PageList<AssetLog> pageList = (PageList<AssetLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}