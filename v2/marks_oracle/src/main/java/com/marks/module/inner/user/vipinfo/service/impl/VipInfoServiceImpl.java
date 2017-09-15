package com.marks.module.inner.user.vipinfo.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.inner.user.vipinfo.dao.VipInfoDao;
import com.marks.module.inner.user.vipinfo.pojo.VipInfo;
import com.marks.module.inner.user.vipinfo.service.VipInfoService;
@Service
public class VipInfoServiceImpl implements VipInfoService{
   
	@Autowired
    private VipInfoDao vipInfoDao;

   /* public VipInfoDao getVipInfoDao(){
        return vipInfoDao;
    }
    public void setVipInfoDao(VipInfoDao vipInfoDao){
        this.vipInfoDao =vipInfoDao;
    }*/

    
    /**
    *根据ID查找会员信息
    */
    @Override
    public VipInfo findById(String userid){
        return vipInfoDao.findById(userid);
    }
    
    /**
    *保存会员信息
    */
    @Override
    public void save(VipInfo vipInfo){
        vipInfoDao.save(vipInfo);
    }
    
    /**
    *更新会员信息
    */
    @Override
    public void update(VipInfo vipInfo){
        vipInfoDao.update(vipInfo);
    }
    
    /**
    *删除会员信息
    */
    @Override
    public void delete(String userid){
        vipInfoDao.delete(userid);       
    }
    
    /**
    *查找所有会员信息
    */
    @Override
    public List<VipInfo> findAll(){
        return vipInfoDao.findAll();   
    }
    
    /**
    *删除多个会员信息
    */
    @Override
   public void deleteBatch(List<String> ids) {
		vipInfoDao.deleteBatch(ids);
	}
	
	public PojoDomain<VipInfo> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<VipInfo> pojoDomain = new PojoDomain<VipInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<VipInfo> list = vipInfoDao.list(pageBounds,param);
		PageList<VipInfo> pageList = (PageList<VipInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public VipInfo findVipDetailInfoById(String userid) {
		return vipInfoDao.findVipDetailInfoById(userid);
	}
	
}