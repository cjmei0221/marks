package com.marks.smart.market.mall.base.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.base.dao.BrandDao;
import com.marks.smart.market.mall.base.pojo.Brand;
import com.marks.smart.market.mall.base.service.BrandService;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
   
/**
    private BrandDao brandDao;

    public BrandDao getBrandDao(){
        return brandDao;
    }
    public void setBrandDao(BrandDao brandDao){
        this.brandDao =brandDao;
    }

 */   
    /**
    *根据ID查找品牌管理
    */
    @Override
    public Brand findById(String id){
        return brandDao.findById(id);
    }
    
    /**
    *保存品牌管理
    */
    @Override
    public void save(Brand info){
        brandDao.save(info);
    }
    
    /**
    *更新品牌管理
    */
    @Override
    public void update(Brand info){
        brandDao.update(info);
    }
    
    /**
    *删除品牌管理
    */
    @Override
    public void delete(String id){
        brandDao.delete(id);       
    }
    
    /**
    *查找所有品牌管理
    */
    @Override
    public List<Brand> findAll(){
        return brandDao.findAll();   
    }
    
    /**
    *删除多个品牌管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		brandDao.deleteBatch(ids);
	}
	
	public PojoDomain<Brand> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Brand> pojoDomain = new PojoDomain<Brand>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Brand> list = brandDao.list(pageBounds,param);
		PageList<Brand> pageList = (PageList<Brand>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<Brand> findListByTypeId(String companyId, String typeId) {
		return brandDao.findListByTypeId(companyId, typeId);
	}

	@Override
	public String getBrandId() {
		String id = brandDao.getBrandId();
		int num = 0;
		if (null != id && !"".equals(id)) {
			num = Integer.parseInt(id);
		} else {
			num = 10000;
		}
		id = String.valueOf(num + 1);
		return id;
	}
	
}