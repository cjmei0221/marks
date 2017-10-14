package com.marks.module.org.area.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.org.area.dao.AreaDao;
import com.marks.module.org.area.pojo.Area;
import com.marks.module.org.area.service.AreaService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDao areaDao;
   
/**
    private AreaDao areaDao;

    public AreaDao getAreaDao(){
        return areaDao;
    }
    public void setAreaDao(AreaDao areaDao){
        this.areaDao =areaDao;
    }

 */   
    /**
    *根据ID查找区域管理
    */
    @Override
    public Area findById(String areaId){
        return areaDao.findById(areaId);
    }
    
    /**
    *保存区域管理
    */
    @Override
    public void save(Area area){
        areaDao.save(area);
    }
    
    /**
    *更新区域管理
    */
    @Override
    public void update(Area area){
        areaDao.update(area);
		areaDao.updateMoreLvlName(area.getAreaId(), area.getAreaName(), area.getLvl());
		areaDao.updateParentName(area.getAreaId(), area.getAreaName());
    }
    
    /**
    *删除区域管理
    */
    @Override
    public void delete(String areaId){
        areaDao.delete(areaId);       
    }
    
    /**
    *查找所有区域管理
    */
    @Override
    public List<Area> findAll(){
        return areaDao.findAll();   
    }
    
    /**
    *删除多个区域管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		areaDao.deleteBatch(ids);
	}
	
	public PojoDomain<Area> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Area> pojoDomain = new PojoDomain<Area>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Area> list = areaDao.list(pageBounds,param);
		PageList<Area> pageList = (PageList<Area>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<Area> findByParentId(String parenId) {
		return areaDao.findByParentId(parenId);
	}

	@Override
	public List<Area> treeGrid(String companyId, String parentId) {
		return areaDao.getTreeGridByParentId(companyId, parentId);
	}
	
}