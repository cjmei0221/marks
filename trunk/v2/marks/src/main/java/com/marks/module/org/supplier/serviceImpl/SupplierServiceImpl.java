package com.marks.module.org.supplier.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.org.supplier.pojo.Supplier;
import com.marks.module.org.supplier.dao.SupplierDao;
import com.marks.module.org.supplier.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierDao;
   
/**
    private SupplierDao supplierDao;

    public SupplierDao getSupplierDao(){
        return supplierDao;
    }
    public void setSupplierDao(SupplierDao supplierDao){
        this.supplierDao =supplierDao;
    }

 */   
    /**
    *根据ID查找供应商管理
    */
    @Override
    public Supplier findById(String id){
        return supplierDao.findById(id);
    }
    
    /**
    *保存供应商管理
    */
    @Override
    public void save(Supplier info){
        supplierDao.save(info);
    }
    
    /**
    *更新供应商管理
    */
    @Override
    public void update(Supplier info){
        supplierDao.update(info);
    }
    
    /**
    *删除供应商管理
    */
    @Override
    public void delete(String id){
        supplierDao.delete(id);       
    }
    
    /**
    *查找所有供应商管理
    */
    @Override
    public List<Supplier> findAll(){
        return supplierDao.findAll();   
    }
    
    /**
    *删除多个供应商管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		supplierDao.deleteBatch(ids);
	}
	
	public PojoDomain<Supplier> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Supplier> pojoDomain = new PojoDomain<Supplier>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Supplier> list = supplierDao.list(pageBounds,param);
		PageList<Supplier> pageList = (PageList<Supplier>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}