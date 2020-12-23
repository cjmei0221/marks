package com.marks.smart.count.asset.base.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.smart.count.asset.base.dao.AssetLogDao;
import com.marks.smart.count.asset.base.pojo.AssetLog;
import com.marks.smart.count.asset.base.pojo.AssetLogCount;
import com.marks.smart.count.asset.base.service.AssetLogService;

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
		info.setTranYear(info.getTranTime().substring(0, 4));
		info.setTranMonth(info.getTranTime().substring(5, 7));
        assetLogDao.save(info);
    }
    
    /**
    *更新记账
    */
    @Override
    public void update(AssetLog info){
		info.setTranYear(info.getTranTime().substring(0, 4));
		info.setTranMonth(info.getTranTime().substring(5, 7));
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

	@Override
	public PojoDomain<AssetLogCount> listCount(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<AssetLogCount> pojoDomain = new PojoDomain<AssetLogCount>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AssetLogCount> list = assetLogDao.listCount(pageBounds, param);
		PageList<AssetLogCount> pageList = (PageList<AssetLogCount>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public PojoDomain<AssetLogCount> listDayCount(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<AssetLogCount> pojoDomain = new PojoDomain<AssetLogCount>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AssetLogCount> list = assetLogDao.listDayCount(pageBounds, param);
		PageList<AssetLogCount> pageList = (PageList<AssetLogCount>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<AssetLogCount> countAmount(Map<String, Object> param) {
		return assetLogDao.countAmount(param);
	}
	
}