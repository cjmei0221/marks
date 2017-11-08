package com.marks.module.wx.manage.serviceImpl.chat;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.dao.chat.WxChatMsgDao;
import com.marks.module.wx.manage.entity.chat.WxChatMsg;
import com.marks.module.wx.manage.service.chat.WxChatMsgService;
@Service
public class WxChatMsgServiceImpl implements WxChatMsgService{
   
	@Autowired
    private WxChatMsgDao wxChatMsgDao;

   /* public WxChatMsgDao getWxChatMsgDao(){
        return wxChatMsgDao;
    }
    public void setWxChatMsgDao(WxChatMsgDao wxChatMsgDao){
        this.wxChatMsgDao =wxChatMsgDao;
    }*/

    
    /**
    *根据ID查找询问管理
    */
    @Override
    public WxChatMsg findById(String id){
        return wxChatMsgDao.findById(id);
    }
    
    /**
    *保存询问管理
    */
    @Override
    public void save(WxChatMsg wxChatMsg){
        wxChatMsgDao.save(wxChatMsg);
    }
    
    /**
    *更新询问管理
    */
    @Override
    public void update(WxChatMsg wxChatMsg){
        wxChatMsgDao.update(wxChatMsg);
    }
    
    /**
    *删除询问管理
    */
    @Override
    public void delete(String id){
        wxChatMsgDao.delete(id);       
    }
    
    /**
    *查找所有询问管理
    */
    @Override
    public List<WxChatMsg> findAll(){
        return wxChatMsgDao.findAll();   
    }
    
    /**
    *删除多个询问管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxChatMsgDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxChatMsg> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxChatMsg> pojoDomain = new PojoDomain<WxChatMsg>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxChatMsg> list = wxChatMsgDao.list(pageBounds,param);
		for(WxChatMsg vo:list){
			vo.setReplayList(wxChatMsgDao.getReplayList(vo.getSession_id()));
		}
		PageList<WxChatMsg> pageList = (PageList<WxChatMsg>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public List<WxChatMsg> getReplayList(String session_id) {
		return wxChatMsgDao.getReplayList(session_id);
	}
	
	
	
}