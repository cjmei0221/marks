package com.marks.smart.system.user.sysuser.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.system.user.sysuser.pojo.UserLvl;
import com.marks.smart.system.user.sysuser.dao.UserLvlDao;
import com.marks.smart.system.user.sysuser.service.UserLvlService;

@Service
@Transactional
public class UserLvlServiceImpl implements UserLvlService{

	private static Logger logger = Logger.getLogger( UserLvlServiceImpl.class);
	
	@Autowired
	private UserLvlDao userLvlDao;
   
/**
    private UserLvlDao userLvlDao;

    public UserLvlDao getUserLvlDao(){
        return userLvlDao;
    }
    public void setUserLvlDao(UserLvlDao userLvlDao){
        this.userLvlDao =userLvlDao;
    }

 */   
    /**
    *根据ID查找用户等级
    */
    @Override
    public UserLvl findById(String id){
      	logger.info("findById > param>"+id);
        return userLvlDao.findById(id);
    }
    
    /**
    *保存用户等级
    */
    @Override
    public void save(UserLvl info){
        logger.info("save > start>");
        userLvlDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新用户等级
    */
    @Override
    public void update(UserLvl info){
        logger.info("update > start>");
        userLvlDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除用户等级
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        userLvlDao.delete(id);       
    }
    
    /**
    *查找所有用户等级
    */
    @Override
    public List<UserLvl> findAll(){
        logger.info("findAll > start> params >");
        return userLvlDao.findAll();   
    }
    
    /**
    *删除多个用户等级
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		userLvlDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<UserLvl> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<UserLvl> pojoDomain = new PojoDomain<UserLvl>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<UserLvl> list = userLvlDao.list(pageBounds,param);
		PageList<UserLvl> pageList = (PageList<UserLvl>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}