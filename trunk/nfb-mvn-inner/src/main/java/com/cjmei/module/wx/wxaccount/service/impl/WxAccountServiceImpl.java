package com.cjmei.module.wx.wxaccount.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.wx.wxaccount.dao.WxAccountDao;
import com.cjmei.module.wx.wxaccount.pojo.WxAccount;
import com.cjmei.module.wx.wxaccount.service.WxAccountService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class WxAccountServiceImpl implements WxAccountService{
   

    private WxAccountDao wxAccountDao;

    public WxAccountDao getWxAccountDao(){
        return wxAccountDao;
    }
    public void setWxAccountDao(WxAccountDao wxAccountDao){
        this.wxAccountDao =wxAccountDao;
    }

    
    /**
    *根据ID查找公众号管理
    */
    @Override
    public WxAccount findById(String accountId){
        return wxAccountDao.findById(accountId);
    }
    
    /**
    *保存公众号管理
    */
    @Override
    public void save(WxAccount wxAccount){
        wxAccountDao.save(wxAccount);
    }
    
    /**
    *更新公众号管理
    */
    @Override
    public void update(WxAccount wxAccount){
        wxAccountDao.update(wxAccount);
    }
    
    /**
    *删除公众号管理
    */
    @Override
    public void delete(String accountId){
        wxAccountDao.delete(accountId);       
    }
    
    /**
    *查找所有公众号管理
    */
    @Override
    public List<WxAccount> findAll(){
        return wxAccountDao.findAll();   
    }
    
    /**
    *删除多个公众号管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxAccountDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxAccount> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxAccount> pojoDomain = new PojoDomain<WxAccount>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxAccount> list = wxAccountDao.list(pageBounds,param);
		PageList<WxAccount> pageList = (PageList<WxAccount>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}