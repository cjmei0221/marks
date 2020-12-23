package com.marks.smart.wx.manage.mp.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.smart.system.cache.CacheData;
import com.marks.smart.wx.manage.mp.dao.WxChatMsgDao;
import com.marks.smart.wx.manage.mp.dao.WxChatSessionDao;
import com.marks.smart.wx.manage.mp.entity.WxAccount;
import com.marks.smart.wx.manage.mp.entity.WxChatCount;
import com.marks.smart.wx.manage.mp.entity.WxChatMsg;
import com.marks.smart.wx.manage.mp.entity.WxChatSession;
import com.marks.smart.wx.manage.mp.enums.WXEnums;
import com.marks.smart.wx.manage.mp.service.WxChatSessionService;
@Service
public class WxChatSessionServiceImpl implements WxChatSessionService{
   
	private static Logger logger = Logger.getLogger(WxChatMsgServiceImpl.class);
	@Autowired
    private WxChatSessionDao wxChatSessionDao;
	@Autowired
    private WxChatMsgDao wxChatMsgDao;

    public WxChatMsgDao getWxChatMsgDao(){
        return wxChatMsgDao;
    }
    public void setWxChatMsgDao(WxChatMsgDao wxChatMsgDao){
        this.wxChatMsgDao =wxChatMsgDao;
    }
    public WxChatSessionDao getWxChatSessionDao(){
        return wxChatSessionDao;
    }
    public void setWxChatSessionDao(WxChatSessionDao wxChatSessionDao){
        this.wxChatSessionDao =wxChatSessionDao;
    }

    
    /**
    *根据ID查找回话管理
    */
    @Override
    public WxChatSession findById(String session_id){
        return wxChatSessionDao.findById(session_id);
    }
    
    /**
    *保存回话管理
    */
    @Override
    public void save(WxChatSession sessionVo){
    	long timeLong = System.currentTimeMillis() / 1000;
		String sessionId = "SID" + IDUtil.getNumID();
		logger.info("getSessionFlag:"+sessionVo.getSessionFlag());
		WxAccount wx = CacheData.getWxAccount(sessionVo.getAccountid());
		if (WXEnums.SessionType.AUTO.getValue() == sessionVo.getSessionFlag()) {
			sessionVo.setCreateLong(timeLong);
			sessionVo.setSession_id(sessionId);
			sessionVo.setCompanyId(wx.getCompanyId());
			wxChatSessionDao.save(sessionVo);
		} else {
			// wxChatSessionDao.update(wxSession);
			WxChatMsg info = new WxChatMsg();
			info.setAccountid(sessionVo.getAccountid());
			info.setC_content(sessionVo.getC_content());
			info.setOpenid(sessionVo.getOpenid());
			info.setSession_id(sessionId);
			info.setSession_id(sessionVo.getSession_id());
			info.setC_type(WXEnums.ReqType.ask.getValue());
			info.setCompanyId(wx.getCompanyId());
			wxChatMsgDao.save(info);
		}
    }
    
    /**
    *更新回话管理
    */
    @Override
    public void update(WxChatSession wxChatSession){
        wxChatSessionDao.update(wxChatSession);
    }
    
    /**
    *删除回话管理
    */
    @Override
    public void delete(String session_id){
        wxChatSessionDao.delete(session_id);       
    }
    
    /**
    *查找所有回话管理
    */
    @Override
    public List<WxChatSession> findAll(){
        return wxChatSessionDao.findAll();   
    }
    
    /**
    *删除多个回话管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		wxChatSessionDao.deleteBatch(ids);
	}
	
	public PojoDomain<WxChatSession> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<WxChatSession> pojoDomain = new PojoDomain<WxChatSession>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxChatSession> list = wxChatSessionDao.list(pageBounds,param);
		if(null != list && list.size()>0){
			List<WxChatMsg> msgList=wxChatMsgDao.getReplayListBySessions(list);
			if(msgList !=null && msgList.size()>0){
				for(WxChatSession sessionVo:list){
					for(WxChatMsg msg:msgList){
						if(sessionVo.getSession_id().equals(msg.getSession_id())){
							sessionVo.addWxChatMsgList(msg);
						}
					}
				}
			}
		}
		PageList<WxChatSession> pageList = (PageList<WxChatSession>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public PojoDomain<WxChatCount> getCountList(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WxChatCount> pojoDomain = new PojoDomain<WxChatCount>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxChatCount> list = wxChatSessionDao.getCountList(pageBounds,param);
		PageList<WxChatCount> pageList = (PageList<WxChatCount>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}