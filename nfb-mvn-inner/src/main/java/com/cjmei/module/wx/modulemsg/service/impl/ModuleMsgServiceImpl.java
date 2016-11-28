package com.cjmei.module.wx.modulemsg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.wx.modulemsg.dao.ModuleMsgDao;
import com.cjmei.module.wx.modulemsg.pojo.ModuleMsg;
import com.cjmei.module.wx.modulemsg.pojo.WxMsg;
import com.cjmei.module.wx.modulemsg.service.ModuleMsgService;
import com.cjmei.module.wx.wxtemplate.dao.WxTemplateDao;
import com.cjmei.module.wx.wxtemplate.pojo.WxTemplate;
import com.cjmei.module.wx.wxuser.pojo.WxUser;
import com.cjmei.module.wx.wxutil.WxFwUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class ModuleMsgServiceImpl implements ModuleMsgService {

	private WxTemplateDao wxTemplateDao;

	private ModuleMsgDao moduleMsgDao;

	public WxTemplateDao getWxTemplateDao() {
		return wxTemplateDao;
	}

	public void setWxTemplateDao(WxTemplateDao wxTemplateDao) {
		this.wxTemplateDao = wxTemplateDao;
	}

	public ModuleMsgDao getModuleMsgDao() {
		return moduleMsgDao;
	}

	public void setModuleMsgDao(ModuleMsgDao moduleMsgDao) {
		this.moduleMsgDao = moduleMsgDao;
	}

	@Override
	public void pushDairyWxMsg(WxUser wxUser) {
		WxTemplate temp = wxTemplateDao.findById("wxtemplate_dairy", wxUser.getAccountid());
		if(null != temp){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String firstMsg=temp.getFirst_content();
			String remarkMsg=temp.getRemark_content();
			WxMsg wxMsg=new WxMsg();
			wxMsg.setFirst(firstMsg);
			wxMsg.setRemark(remarkMsg);
			wxMsg.addKeyword(wxUser.getNickname());
			wxMsg.addKeyword(sdf.format(new Date()));
			
			ModuleMsg mmsg=new ModuleMsg();
			mmsg.setAccountid(wxUser.getAccountid());
			mmsg.setCreatetime(new Date());
			mmsg.setData(wxMsg.toJsonString());
			mmsg.setNeedFlag(1);
			mmsg.setNote(sdf.format(new Date())+" "+wxUser.getNickname()+" "+temp.getTemplate_name());
			mmsg.setSendFlag(0);
			mmsg.setSendTimes(0);
			mmsg.setTemplate_id(temp.getTemplate_id());
			mmsg.setTouser(wxUser.getOpenid());
			mmsg.setUrl(temp.getDetailUrl());
			pustModuleMsg(mmsg,false);
		}
	}

	private void pustModuleMsg(ModuleMsg mmsg, boolean b) {
		if(b){
			WxFwUtil.getInstance().pushTemplateMsg(mmsg.getAccountid(), mmsg.getTouser(), mmsg.getTemplate_id(), mmsg.getUrl(), mmsg.getData(),mmsg.getNote());
		}else{
			this.moduleMsgDao.save(mmsg);
		}
	}

	/**
	 * 根据ID查找模板消息
	 */
	@Override
	public ModuleMsg findById(String id) {
		return moduleMsgDao.findById(id);
	}

	/**
	 * 保存模板消息
	 */
	@Override
	public void save(ModuleMsg moduleMsg) {
		moduleMsgDao.save(moduleMsg);
	}

	/**
	 * 更新模板消息
	 */
	@Override
	public void update(ModuleMsg moduleMsg) {
		moduleMsgDao.update(moduleMsg);
	}

	/**
	 * 删除模板消息
	 */
	@Override
	public void delete(String id) {
		moduleMsgDao.delete(id);
	}

	/**
	 * 查找所有模板消息
	 */
	@Override
	public List<ModuleMsg> findAll() {
		return moduleMsgDao.findAll();
	}

	/**
	 * 删除多个模板消息
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		moduleMsgDao.deleteBatch(ids);
	}

	public PojoDomain<ModuleMsg> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<ModuleMsg> pojoDomain = new PojoDomain<ModuleMsg>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<ModuleMsg> list = moduleMsgDao.list(pageBounds, param);
		PageList<ModuleMsg> pageList = (PageList<ModuleMsg>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

}