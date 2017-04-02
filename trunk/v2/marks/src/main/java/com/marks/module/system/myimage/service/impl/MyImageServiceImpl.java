package com.marks.module.system.myimage.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.system.myimage.pojo.MyImage;
import com.marks.module.system.myimage.dao.MyImageDao;
import com.marks.module.system.myimage.service.MyImageService;

public class MyImageServiceImpl implements MyImageService{
   

    private MyImageDao myImageDao;

    public MyImageDao getMyImageDao(){
        return myImageDao;
    }
    public void setMyImageDao(MyImageDao myImageDao){
        this.myImageDao =myImageDao;
    }

    
    /**
    *根据ID查找图片
    */
    @Override
    public MyImage findById(String picId){
        return myImageDao.findById(picId);
    }
    
    /**
    *保存图片
    */
    @Override
    public void save(MyImage myImage){
        myImageDao.save(myImage);
    }
    
    /**
    *更新图片
    */
    @Override
    public void update(MyImage myImage){
        myImageDao.update(myImage);
    }
    
    /**
    *删除图片
    */
    @Override
    public void delete(String picId){
        myImageDao.delete(picId);       
    }
    
    /**
    *查找所有图片
    */
    @Override
    public List<MyImage> findAll(){
        return myImageDao.findAll();   
    }
    
    /**
    *删除多个图片
    */
    @Override
   public void deleteBatch(List<String> ids) {
		myImageDao.deleteBatch(ids);
	}
	
	public PojoDomain<MyImage> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<MyImage> pojoDomain = new PojoDomain<MyImage>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<MyImage> list = myImageDao.list(pageBounds,param);
		PageList<MyImage> pageList = (PageList<MyImage>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}