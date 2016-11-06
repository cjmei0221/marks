package com.cjmei.module.wx.wxmenu.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.wx.wxmenu.pojo.WxMenu;
import com.cjmei.module.wx.wxmenu.dao.WxMenuDao;
import com.cjmei.module.wx.wxmenu.service.WxMenuService;

public class WxMenuServiceImpl implements WxMenuService{
   

    private WxMenuDao wxMenuDao;

    public WxMenuDao getWxMenuDao(){
        return wxMenuDao;
    }
    public void setWxMenuDao(WxMenuDao wxMenuDao){
        this.wxMenuDao =wxMenuDao;
    }

    
    /**
    *根据ID查找微信菜单管理
    */
    @Override
    public WxMenu findById(String id){
        return wxMenuDao.findById(id);
    }
    
    /**
    *保存微信菜单管理
    */
    @Override
    public void save(WxMenu wxMenu){
        wxMenuDao.save(wxMenu);
    }
    
    /**
    *更新微信菜单管理
    */
    @Override
    public void update(WxMenu wxMenu){
        wxMenuDao.update(wxMenu);
    }
    
    /**
    *删除微信菜单管理
    */
    @Override
    public void delete(String id){
        wxMenuDao.delete(id);       
    }
    
    /**
    *查找所有微信菜单管理
    */
    @Override
    public List<WxMenu> findAll(){
        return wxMenuDao.findAll();   
    }
    
    /**
    *删除多个微信菜单管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxMenuDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxMenu> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxMenu> pojoDomain = new PojoDomain<WxMenu>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxMenu> list = wxMenuDao.list(pageBounds,param);
		PageList<WxMenu> pageList = (PageList<WxMenu>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}