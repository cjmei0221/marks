package com.marks.module.wx.wxchatmsg.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.system.core.data.StaticData;
import com.marks.module.wx.enums.WXEnums;
import com.marks.module.wx.wfhao.service.impl.normal.VoiceRequestServiceImpl;
import com.marks.module.wx.wxchatmsg.dao.WxChatMsgDao;
import com.marks.module.wx.wxchatmsg.dao.WxChatSessionDao;
import com.marks.module.wx.wxchatmsg.pojo.WxChatMsg;
import com.marks.module.wx.wxchatmsg.pojo.WxChatSession;
import com.marks.module.wx.wxchatmsg.service.WxChatMsgService;

public class WxChatMsgServiceImpl implements WxChatMsgService {
	private static Logger logger = Logger.getLogger(WxChatMsgServiceImpl.class);
	private WxChatMsgDao wxChatMsgDao;
	private WxChatSessionDao wxChatSessionDao;

	public WxChatMsgDao getWxChatMsgDao() {
		return wxChatMsgDao;
	}

	public void setWxChatMsgDao(WxChatMsgDao wxChatMsgDao) {
		this.wxChatMsgDao = wxChatMsgDao;
	}

	public WxChatSessionDao getWxChatSessionDao() {
		return wxChatSessionDao;
	}

	public void setWxChatSessionDao(WxChatSessionDao wxChatSessionDao) {
		this.wxChatSessionDao = wxChatSessionDao;
	}

	/**
	 * 根据ID查找询问管理
	 */
	@Override
	public WxChatMsg findById(String id) {
		return wxChatMsgDao.findById(id);
	}

	/**
	 * 保存询问管理
	 */
	@Override
	public void save(WxChatSession sessionVo) {
		long timeLong = System.currentTimeMillis() / 1000;
		String sessionId = "SID" + IDUtil.getTimeID();
		logger.info("getSessionFlag:"+sessionVo.getSessionFlag());
		if (WXEnums.SessionType.AUTO.getValue() == sessionVo.getSessionFlag()) {
			sessionVo.setCreateLong(timeLong);
			sessionVo.setSession_id(sessionId);
			wxChatSessionDao.save(sessionVo);
		} else {
			// wxChatSessionDao.update(wxSession);
			WxChatMsg info = new WxChatMsg();
			info.setAccountid(sessionVo.getAccountid());
			info.setC_content(sessionVo.getC_content());
			info.setFanId(sessionVo.getFanId());
			info.setOpenid(sessionVo.getOpenid());
			info.setSession_id(sessionId);
			info.setSession_id(sessionVo.getSession_id());
			info.setC_type(WXEnums.ReqType.ask.getValue());
			wxChatMsgDao.save(info);
		}
	}

	/**
	 * 更新询问管理
	 */
	@Override
	public void update(WxChatMsg wxChatMsg) {
		wxChatMsgDao.update(wxChatMsg);
	}

	/**
	 * 删除询问管理
	 */
	@Override
	public void delete(String id) {
		wxChatMsgDao.delete(id);
	}

	/**
	 * 查找所有询问管理
	 */
	@Override
	public List<WxChatMsg> findAll() {
		return wxChatMsgDao.findAll();
	}

	/**
	 * 删除多个询问管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		wxChatMsgDao.deleteBatch(ids);
	}

	public PojoDomain<WxChatMsg> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WxChatMsg> pojoDomain = new PojoDomain<WxChatMsg>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxChatMsg> list = wxChatMsgDao.list(pageBounds, param);
		PageList<WxChatMsg> pageList = (PageList<WxChatMsg>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

}