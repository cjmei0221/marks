package com.marks.module.inner.note.plan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.inner.note.plan.dao.PlanDao;
import com.marks.module.inner.note.plan.pojo.Plan;
import com.marks.module.inner.note.plan.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanDao planDao;
   
/**
    private PlanDao planDao;

    public PlanDao getPlanDao(){
        return planDao;
    }
    public void setPlanDao(PlanDao planDao){
        this.planDao =planDao;
    }

 */   
    /**
    *根据ID查找计划
    */
    @Override
    public Plan findById(String id){
        return planDao.findById(id);
    }
    
    /**
    *保存计划
    */
    @Override
    public void save(Plan plan){
        planDao.save(plan);
    }
    
    /**
    *更新计划
    */
    @Override
    public void update(Plan plan){
        planDao.update(plan);
    }
    
    /**
    *删除计划
    */
    @Override
    public void delete(String id){
        planDao.delete(id);       
    }
    
    /**
    *查找所有计划
    */
    @Override
    public List<Plan> findAll(){
        return planDao.findAll();   
    }
    
    /**
    *删除多个计划
    */
    @Override
   public void deleteBatch(List<String> ids) {
		planDao.deleteBatch(ids);
	}
	
	public PojoDomain<Plan> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Plan> pojoDomain = new PojoDomain<Plan>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Plan> list = planDao.list(pageBounds,param);
		PageList<Plan> pageList = (PageList<Plan>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}