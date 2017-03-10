package com.marks.module.wx.modulemsg.service.impl;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.wx.modulemsg.dao.ModuleMsgDao;
import com.marks.module.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.wx.wxutil.WxFwUtil;

public class ModuleMsgServiceImpl implements ModuleMsgService {

	private ModuleMsgDao moduleMsgDao;

	public ModuleMsgDao getModuleMsgDao() {
		return moduleMsgDao;
	}

	public void setModuleMsgDao(ModuleMsgDao moduleMsgDao) {
		this.moduleMsgDao = moduleMsgDao;
	}

	public void pustModuleMsg(ModuleMsg mmsg, boolean b) {
		mmsg.setNeedFlag(1);
		mmsg.setSendFlag(0);
		mmsg.setSendTimes(0);
		if (b) {
			Result result = WxFwUtil.getInstance().pushTemplateMsg(mmsg.getAccountid(), mmsg.getTouser(),
					mmsg.getTemplate_id(), mmsg.getUrl(), mmsg.getData(), mmsg.getNote());
			if (!"0".equals(result.getCode())) {
				this.moduleMsgDao.save(mmsg);
			}
		} else {
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