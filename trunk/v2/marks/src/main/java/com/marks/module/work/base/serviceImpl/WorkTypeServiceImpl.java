package com.marks.module.work.base.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.work.base.dao.WorkTypeDao;
import com.marks.module.work.base.dao.WorkTypeStepDao;
import com.marks.module.work.base.pojo.WorkType;
import com.marks.module.work.base.service.WorkTypeService;

@Service
@Transactional
public class WorkTypeServiceImpl implements WorkTypeService{

	@Autowired
	private WorkTypeDao workTypeDao;
	@Autowired
	private WorkTypeStepDao workTypeStepDao;
   
/**
    private WorkTypeDao workTypeDao;

    public WorkTypeDao getWorkTypeDao(){
        return workTypeDao;
    }
    public void setWorkTypeDao(WorkTypeDao workTypeDao){
        this.workTypeDao =workTypeDao;
    }

 */   
    /**
    *根据ID查找工作类型
    */
    @Override
    public WorkType findById(String id){
        return workTypeDao.findById(id);
    }
    
    /**
    *保存工作类型
    */
    @Override
    public void save(WorkType info){
        workTypeDao.save(info);
    }
    
    /**
    *更新工作类型
    */
    @Override
    public void update(WorkType info){
        workTypeDao.update(info);
    }
    
    /**
    *删除工作类型
    */
    @Override
    public void delete(String id){
		workTypeDao.delete(id);
		workTypeStepDao.deleteByTypeId(id);
    }
    
    /**
    *查找所有工作类型
    */
    @Override
    public List<WorkType> findAll(){
        return workTypeDao.findAll();   
    }
    
    /**
    *删除多个工作类型
    */
    @Override
   public void deleteBatch(List<String> ids) {
		workTypeDao.deleteBatch(ids);
	}
	
	public PojoDomain<WorkType> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WorkType> pojoDomain = new PojoDomain<WorkType>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkType> list = workTypeDao.list(pageBounds,param);
		PageList<WorkType> pageList = (PageList<WorkType>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}