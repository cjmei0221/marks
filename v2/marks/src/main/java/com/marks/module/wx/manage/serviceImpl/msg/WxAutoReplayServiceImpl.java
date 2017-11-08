package com.marks.module.wx.manage.serviceImpl.msg;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.dao.msg.WxAutoReplayDao;
import com.marks.module.wx.manage.entity.msg.WxAutoReplay;
import com.marks.module.wx.manage.service.msg.WxAutoReplayService;
@Service
public class WxAutoReplayServiceImpl implements WxAutoReplayService{
   
	@Autowired
    private WxAutoReplayDao wxAutoReplayDao;

   /* public WxAutoReplayDao getWxAutoReplayDao(){
        return wxAutoReplayDao;
    }
    public void setWxAutoReplayDao(WxAutoReplayDao wxAutoReplayDao){
        this.wxAutoReplayDao =wxAutoReplayDao;
    }*/

    
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
		String keyCode = wxAutoReplayDao.getKeyCode(wxAutoReplay.getAccountid());
		int num = 0;
		if (null != keyCode && !"".equals(keyCode)) {
			num = Integer.parseInt(keyCode);
		}
		wxAutoReplay.setCkeyCode(num + 1);
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
	public List<WxAutoReplay> findByCkey(String ckey, String ckeyName, String accountid) {
		return wxAutoReplayDao.findByCkey(ckey, ckeyName, accountid);
	}
	

}