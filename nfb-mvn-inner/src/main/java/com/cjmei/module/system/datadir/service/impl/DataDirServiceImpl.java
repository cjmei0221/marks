package com.cjmei.module.system.datadir.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.system.datadir.pojo.DataDir;
import com.cjmei.module.system.datadir.dao.DataDirDao;
import com.cjmei.module.system.datadir.service.DataDirService;

public class DataDirServiceImpl implements DataDirService{
   

    private DataDirDao dataDirDao;

    public DataDirDao getDataDirDao(){
        return dataDirDao;
    }
    public void setDataDirDao(DataDirDao dataDirDao){
        this.dataDirDao =dataDirDao;
    }

    
    /**
    *根据ID查找数据字典
    */
    @Override
    public DataDir findById(String ckey){
        return dataDirDao.findById(ckey);
    }
    
    /**
    *保存数据字典
    */
    @Override
    public void save(DataDir dataDir){
        dataDirDao.save(dataDir);
    }
    
    /**
    *更新数据字典
    */
    @Override
    public void update(DataDir dataDir){
        dataDirDao.update(dataDir);
    }
    
    /**
    *删除数据字典
    */
    @Override
    public void delete(String ckey){
        dataDirDao.delete(ckey);       
    }
    
    /**
    *查找所有数据字典
    */
    @Override
    public List<DataDir> findAll(){
        return dataDirDao.findAll();   
    }
    
    /**
    *删除多个数据字典
    */
    @Override
   public void deleteBatch(List<String> ids) {
		dataDirDao.deleteBatch(ids);
	}
	
	public PojoDomain<DataDir> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<DataDir> pojoDomain = new PojoDomain<DataDir>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<DataDir> list = dataDirDao.list(pageBounds,param);
		PageList<DataDir> pageList = (PageList<DataDir>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}