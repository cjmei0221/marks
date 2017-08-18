package com.marks.module.inner.wx.wxuser.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.center.wxfwhao.common.entity.WxUser;
import com.marks.module.inner.wx.wxuser.dao.WxUserDao;
import com.marks.module.inner.wx.wxuser.service.WxUserService;
@Service
public class WxUserServiceImpl implements WxUserService{
   
	@Autowired
    private WxUserDao wxUserDao;

 /*   public WxUserDao getWxUserDao(){
        return wxUserDao;
    }
    public void setWxUserDao(WxUserDao wxUserDao){
        this.wxUserDao =wxUserDao;
    }*/

    
    /**
    *根据ID查找粉丝管理
    */
    @Override
    public WxUser findById(String accountid,String openid){
        return wxUserDao.findById(accountid,openid);
    }
    
    /**
    *保存粉丝管理
    */
    @Override
    public void save(WxUser wxUser){
        wxUserDao.save(wxUser);
    }
    
    /**
    *更新粉丝管理
    */
    @Override
    public void update(WxUser wxUser){
        wxUserDao.update(wxUser);
    }
    
    /**
    *删除粉丝管理
    */
    @Override
    public void delete(String openid){
        wxUserDao.delete(openid);       
    }
    
    /**
    *查找所有粉丝管理
    */
    @Override
    public List<WxUser> findAll(){
        return wxUserDao.findAll();   
    }
    
    /**
    *删除多个粉丝管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxUserDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxUser> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxUser> pojoDomain = new PojoDomain<WxUser>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxUser> list = wxUserDao.list(pageBounds,param);
		PageList<WxUser> pageList = (PageList<WxUser>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public void updateDairyFlag(String openid, int dairyFlag) {
		wxUserDao.udateDairyFlag(openid, dairyFlag);
	}
	@Override
	public void saveOrUpdateWxUser(WxUser user) {
		WxUser old=wxUserDao.findById(user.getAccountid(),user.getOpenid());
		if(old !=null){
			wxUserDao.update(user);
		}else{
			wxUserDao.save(user);
		}
		
	}
	
}