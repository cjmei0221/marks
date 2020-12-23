package com.marks.smart.system.work.info.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.system.work.info.pojo.WorkStep;
import com.marks.smart.system.work.info.dao.WorkStepDao;
import com.marks.smart.system.work.info.service.WorkStepService;

@Service
@Transactional
public class WorkStepServiceImpl implements WorkStepService{

	@Autowired
	private WorkStepDao workStepDao;
   
/**
    private WorkStepDao workStepDao;

    public WorkStepDao getWorkStepDao(){
        return workStepDao;
    }
    public void setWorkStepDao(WorkStepDao workStepDao){
        this.workStepDao =workStepDao;
    }

 */   
    /**
    *根据ID查找工作步骤
    */
    @Override
    public WorkStep findById(String id){
        return workStepDao.findById(id);
    }
    
    /**
    *保存工作步骤
    */
    @Override
    public void save(WorkStep info){
        workStepDao.save(info);
    }
    
    /**
    *更新工作步骤
    */
    @Override
    public void update(WorkStep info){
        workStepDao.update(info);
    }
    
    /**
    *删除工作步骤
    */
    @Override
    public void delete(String id){
        workStepDao.delete(id);       
    }
    
    /**
    *查找所有工作步骤
    */
    @Override
    public List<WorkStep> findAll(){
        return workStepDao.findAll();   
    }
    
    /**
    *删除多个工作步骤
    */
    @Override
   public void deleteBatch(List<String> ids) {
		workStepDao.deleteBatch(ids);
	}
	
	public PojoDomain<WorkStep> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WorkStep> pojoDomain = new PojoDomain<WorkStep>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkStep> list = workStepDao.list(pageBounds,param);
		PageList<WorkStep> pageList = (PageList<WorkStep>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}