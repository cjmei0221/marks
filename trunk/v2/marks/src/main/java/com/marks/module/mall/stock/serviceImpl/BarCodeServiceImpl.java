package com.marks.module.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.dao.BarCodeDao;
import com.marks.module.mall.stock.service.BarCodeService;

@Service
@Transactional
public class BarCodeServiceImpl implements BarCodeService{

	@Autowired
	private BarCodeDao barCodeDao;
   
/**
    private BarCodeDao barCodeDao;

    public BarCodeDao getBarCodeDao(){
        return barCodeDao;
    }
    public void setBarCodeDao(BarCodeDao barCodeDao){
        this.barCodeDao =barCodeDao;
    }

 */   
    /**
    *根据ID查找条码管理
    */
    @Override
    public BarCode findById(String id){
        return barCodeDao.findById(id);
    }
    
    /**
    *保存条码管理
    */
    @Override
    public void save(BarCode info){
        barCodeDao.save(info);
    }
    
    /**
    *更新条码管理
    */
    @Override
    public void update(BarCode info){
        barCodeDao.update(info);
    }
    
    /**
    *删除条码管理
    */
    @Override
    public void delete(String id){
        barCodeDao.delete(id);       
    }
    
    /**
    *查找所有条码管理
    */
    @Override
    public List<BarCode> findAll(){
        return barCodeDao.findAll();   
    }
    
    /**
    *删除多个条码管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		barCodeDao.deleteBatch(ids);
	}
	
	public PojoDomain<BarCode> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<BarCode> pojoDomain = new PojoDomain<BarCode>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<BarCode> list = barCodeDao.list(pageBounds,param);
		PageList<BarCode> pageList = (PageList<BarCode>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}