package com.marks.module.mall.base.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.base.dao.CategoryDao;
import com.marks.module.mall.base.pojo.Category;
import com.marks.module.mall.base.service.CategoryService;
import com.marks.module.org.area.pojo.Area;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
   
/**
    private CategoryDao categoryDao;

    public CategoryDao getCategoryDao(){
        return categoryDao;
    }
    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao =categoryDao;
    }

 */   
    /**
    *根据ID查找品类管理
    */
    @Override
    public Category findById(String id){
        return categoryDao.findById(id);
    }
    
    /**
    *保存品类管理
    */
    @Override
    public void save(Category info){
        categoryDao.save(info);
    }
    
    /**
    *更新品类管理
    */
    @Override
    public void update(Category info){
        categoryDao.update(info);
		categoryDao.updateMoreLvlName(info.getTypeId(), info.getTypeName(), info.getLvl());
		categoryDao.updateParentName(info.getTypeId(), info.getTypeName());
    }
    
    /**
    *删除品类管理
    */
    @Override
    public void delete(String id){
        categoryDao.delete(id);       
    }
    
    /**
    *查找所有品类管理
    */
    @Override
    public List<Category> findAll(){
        return categoryDao.findAll();   
    }
    
    /**
    *删除多个品类管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		categoryDao.deleteBatch(ids);
	}
	
	public PojoDomain<Category> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Category> pojoDomain = new PojoDomain<Category>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Category> list = categoryDao.list(pageBounds,param);
		PageList<Category> pageList = (PageList<Category>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<Area> treeGrid(String companyId, String parentId) {
		return categoryDao.getTreeGridByParentId(companyId, parentId);
	}
	
}