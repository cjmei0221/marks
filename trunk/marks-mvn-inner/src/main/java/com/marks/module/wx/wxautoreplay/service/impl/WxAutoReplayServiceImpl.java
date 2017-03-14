package com.marks.module.wx.wxautoreplay.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.wx.wxautoreplay.pojo.WxAutoReplay;
import com.marks.module.wx.wxautoreplay.dao.WxAutoReplayDao;
import com.marks.module.wx.wxautoreplay.service.WxAutoReplayService;

public class WxAutoReplayServiceImpl implements WxAutoReplayService{
   

    private WxAutoReplayDao wxAutoReplayDao;

    public WxAutoReplayDao getWxAutoReplayDao(){
        return wxAutoReplayDao;
    }
    public void setWxAutoReplayDao(WxAutoReplayDao wxAutoReplayDao){
        this.wxAutoReplayDao =wxAutoReplayDao;
    }

    
    /**
    *根据ID查找微信回复管理
    */
    @Override
    public WxAutoReplay findById(String cparentType){
        return wxAutoReplayDao.findById(cparentType);
    }
    
    /**
    *保存微信回复管理
    */
    @Override
    public void save(WxAutoReplay wxAutoReplay){
        wxAutoReplayDao.save(wxAutoReplay);
    }
    
    /**
    *更新微信回复管理
    */
    @Override
    public void update(WxAutoReplay wxAutoReplay){
        wxAutoReplayDao.update(wxAutoReplay);
    }
    
    /**
    *删除微信回复管理
    */
    @Override
    public void delete(String cparentType){
        wxAutoReplayDao.delete(cparentType);       
    }
    
    /**
    *查找所有微信回复管理
    */
    @Override
    public List<WxAutoReplay> findAll(){
        return wxAutoReplayDao.findAll();   
    }
    
    /**
    *删除多个微信回复管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxAutoReplayDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxAutoReplay> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxAutoReplay> pojoDomain = new PojoDomain<WxAutoReplay>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxAutoReplay> list = wxAutoReplayDao.list(pageBounds,param);
		PageList<WxAutoReplay> pageList = (PageList<WxAutoReplay>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public List<WxAutoReplay> findByCkey(String ckey) {
		  return wxAutoReplayDao.findByCkey(ckey);
	}
	
}