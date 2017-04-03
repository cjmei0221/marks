package com.marks.module.inner.wx.wxtemplate.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.inner.wx.wxtemplate.pojo.WxTemplate;
import com.marks.module.inner.wx.wxtemplate.dao.WxTemplateDao;
import com.marks.module.inner.wx.wxtemplate.service.WxTemplateService;

public class WxTemplateServiceImpl implements WxTemplateService{
   

    private WxTemplateDao wxTemplateDao;

    public WxTemplateDao getWxTemplateDao(){
        return wxTemplateDao;
    }
    public void setWxTemplateDao(WxTemplateDao wxTemplateDao){
        this.wxTemplateDao =wxTemplateDao;
    }

    
    /**
    *根据ID查找微信模板
    */
    @Override
    public WxTemplate findById(String ywType,String accountid){
        return wxTemplateDao.findById(ywType,accountid);
    }
    
    /**
    *保存微信模板
    */
    @Override
    public void save(WxTemplate wxTemplate){
        wxTemplateDao.save(wxTemplate);
    }
    
    /**
    *更新微信模板
    */
    @Override
    public void update(WxTemplate wxTemplate){
        wxTemplateDao.update(wxTemplate);
    }
    
    /**
    *删除微信模板
    */
    @Override
    public void delete(String ywType,String accountid){
        wxTemplateDao.delete(ywType,accountid);       
    }
    
    /**
    *查找所有微信模板
    */
    @Override
    public List<WxTemplate> findAll(){
        return wxTemplateDao.findAll();   
    }
    
    /**
    *删除多个微信模板
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxTemplateDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxTemplate> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxTemplate> pojoDomain = new PojoDomain<WxTemplate>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxTemplate> list = wxTemplateDao.list(pageBounds,param);
		PageList<WxTemplate> pageList = (PageList<WxTemplate>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}