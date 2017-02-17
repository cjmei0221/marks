package com.marks.module.system.datadir.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.datadir.dao.DataDirDao;
import com.marks.module.system.datadir.pojo.DataDir;
import com.marks.module.system.datadir.service.DataDirService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

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
    public DataDir findById(String ckey,String parentKey){
        return dataDirDao.findById(ckey,parentKey);
    }
    
    @Override
	public List<DataDir> findChildList(String ckey) {
    	 return dataDirDao.findChildList(ckey);
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
    public void delete(String ckey,String parentKey){
        dataDirDao.delete(ckey,parentKey);       
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
	@Override
	public List<DataDir> listTree(Map<String, Object> param) {
		List<DataDir> returnList=new ArrayList<DataDir>();
		List<DataDir> list = dataDirDao.listByParam(param);
		if(null != list && list.size()>0){
			//一级
			for(DataDir dd:list){
				if("0".equals(dd.getParentkey())){
					returnList.add(dd);
				}
			}
			//二级
			if(returnList.size()>0){
				for(DataDir dd:returnList){
					for(DataDir cc:list){
						if(dd.getCkey().equals(cc.getParentkey())){
							dd.addChildren(cc);
						}
					}
				}
			}
		}
		DataDir dir=new DataDir();
		dir.setCkey("0");
		dir.setCvalue("一级父节点");
		dir.setParentkey("Top");
		returnList.add(dir);
		return returnList;
	}
	
}