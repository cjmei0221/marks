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
		Category parentVo = null;
		if (info.getLvl() == 1) {
			parentVo = new Category();
			parentVo.setLvl(0);
			info.setParentId(info.getCompanyId());
			info.setLvl(1);
		} else {
			parentVo = this.findById(info.getParentId());
			info.setLvl(parentVo.getLvl() + 1);
			info.setParentName(parentVo.getTypeName());
		}
		info.setTypeCode(this.getTypeId(info.getParentId()));
		if (info.getLvl() == 1) {
			info.setTypeId(info.getTypeCode());
		} else {
			info.setTypeId(info.getParentId() + info.getTypeCode());
		}

		info.setLvl1Id(parentVo.getLvl1Id());
		info.setLvl1Name(parentVo.getLvl1Name());

		info.setLvl2Id(parentVo.getLvl2Id());
		info.setLvl2Name(parentVo.getLvl2Name());

		info.setLvl3Id(parentVo.getLvl3Id());
		info.setLvl3Name(parentVo.getLvl3Name());

		info.setLvl4Id(parentVo.getLvl4Id());
		info.setLvl4Name(parentVo.getLvl4Name());

		info.setLvl5Id(parentVo.getLvl5Id());
		info.setLvl5Name(parentVo.getLvl5Name());

		if (info.getLvl() == 1) {
			info.setLvl1Id(info.getTypeId());
			info.setLvl1Name(info.getTypeName());
		} else if (info.getLvl() == 2) {
			info.setLvl2Id(info.getTypeId());
			info.setLvl2Name(info.getTypeName());
		} else if (info.getLvl() == 3) {
			info.setLvl3Id(info.getTypeId());
			info.setLvl3Name(info.getTypeName());
		} else if (info.getLvl() == 4) {
			info.setLvl4Id(info.getTypeId());
			info.setLvl4Name(info.getTypeName());
		} else if (info.getLvl() == 5) {
			info.setLvl5Id(info.getTypeId());
			info.setLvl5Name(info.getTypeName());
		}
        categoryDao.save(info);
    }
    
	private String getTypeId(String parentId) {
		String id = categoryDao.getTypeId(parentId);
		int num = 0;
		if (null != id && !"".equals(id)) {
			num = Integer.parseInt(id);
		} else {
			num = 0;
		}
		id = String.valueOf(num + 1);
		if (id.length() == 1) {
			id = "0" + id;
		}
		return id;
	}

	/**
	 * 更新品类管理
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
	public List<Category> treeGrid(String companyId, String parentId) {
		return categoryDao.getTreeGridByParentId(companyId, parentId);
	}
}