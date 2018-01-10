package com.marks.module.work.base.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.work.base.pojo.WorkTypeStep;
import com.marks.module.work.base.dao.WorkTypeStepDao;
import com.marks.module.work.base.service.WorkTypeStepService;

@Service
@Transactional
public class WorkTypeStepServiceImpl implements WorkTypeStepService{

	@Autowired
	private WorkTypeStepDao workTypeStepDao;
   
/**
    private WorkTypeStepDao workTypeStepDao;

    public WorkTypeStepDao getWorkTypeStepDao(){
        return workTypeStepDao;
    }
    public void setWorkTypeStepDao(WorkTypeStepDao workTypeStepDao){
        this.workTypeStepDao =workTypeStepDao;
    }

 */   
    /**
    *根据ID查找工作流步骤配置
    */
    @Override
    public WorkTypeStep findById(String id){
        return workTypeStepDao.findById(id);
    }
    
    /**
    *保存工作流步骤配置
    */
    @Override
    public void save(WorkTypeStep info){
        workTypeStepDao.save(info);
    }
    
    /**
    *更新工作流步骤配置
    */
    @Override
    public void update(WorkTypeStep info){
        workTypeStepDao.update(info);
    }
    
    /**
    *删除工作流步骤配置
    */
    @Override
    public void delete(String id){
        workTypeStepDao.delete(id);       
    }
    
    /**
    *查找所有工作流步骤配置
    */
    @Override
    public List<WorkTypeStep> findAll(){
        return workTypeStepDao.findAll();   
    }
    
    /**
    *删除多个工作流步骤配置
    */
    @Override
   public void deleteBatch(List<String> ids) {
		workTypeStepDao.deleteBatch(ids);
	}
	
	public PojoDomain<WorkTypeStep> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WorkTypeStep> pojoDomain = new PojoDomain<WorkTypeStep>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkTypeStep> list = workTypeStepDao.list(pageBounds,param);
		PageList<WorkTypeStep> pageList = (PageList<WorkTypeStep>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}