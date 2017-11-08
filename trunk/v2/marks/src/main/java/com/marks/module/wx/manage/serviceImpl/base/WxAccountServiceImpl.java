package com.marks.module.wx.manage.serviceImpl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.dao.base.WxAccountDao;
import com.marks.module.wx.manage.entity.base.WxAccount;
import com.marks.module.wx.manage.service.base.WxAccountService;
@Service
public class WxAccountServiceImpl implements WxAccountService{
   
	@Autowired
    private WxAccountDao wxAccountDao;

 /*   public WxAccountDao getWxAccountDao(){
        return wxAccountDao;
    }
    public void setWxAccountDao(WxAccountDao wxAccountDao){
        this.wxAccountDao =wxAccountDao;
    }*/

    
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
	@Override
	public List<WxAccount> combox(Map<String, Object> param) {
		return wxAccountDao.getWxfwhaoList(param);
	}
	@Override
	public List<String> getAccountIdsByLoginUser(Map<String, Object> param) {
		return wxAccountDao.getAccountIdsByLoginUser(param);
	}
	
	
	
}