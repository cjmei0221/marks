package com.marks.module.wx.manage.serviceImpl.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.dao.user.WxTagsDao;
import com.marks.module.wx.manage.entity.user.WxTags;
import com.marks.module.wx.manage.service.user.WxTagsService;

@Service
@Transactional
public class WxTagsServiceImpl implements WxTagsService {

	@Autowired
	private WxTagsDao wxTagsDao;

	/**
	 * private WxTagsDao wxTagsDao;
	 * 
	 * public WxTagsDao getWxTagsDao(){ return wxTagsDao; } public void
	 * setWxTagsDao(WxTagsDao wxTagsDao){ this.wxTagsDao =wxTagsDao; }
	 * 
	 */
	/**
	 * 根据ID查找用户标签
	 */
	@Override
	public WxTags findById(String id) {
		return wxTagsDao.findById(id);
	}

	/**
	 * 保存用户标签
	 */
	@Override
	public void save(WxTags wxTags) {
		wxTagsDao.save(wxTags);
	}

	/**
	 * 更新用户标签
	 */
	@Override
	public void update(WxTags wxTags) {
		wxTagsDao.update(wxTags);
	}

	/**
	 * 删除用户标签
	 */
	@Override
	public void delete(String id) {
		wxTagsDao.delete(id);
	}

	/**
	 * 查找所有用户标签
	 */
	@Override
	public List<WxTags> findAll() {
		return wxTagsDao.findAll();
	}

	/**
	 * 删除多个用户标签
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		wxTagsDao.deleteBatch(ids);
	}

	public PojoDomain<WxTags> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WxTags> pojoDomain = new PojoDomain<WxTags>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxTags> list = wxTagsDao.list(pageBounds, param);
		PageList<WxTags> pageList = (PageList<WxTags>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public WxTags findByAccountIdAndName(String accountid, String name) {
		return wxTagsDao.findByAccountIdAndName(accountid, name);
	}

	@Override
	public List<WxTags> findWxTagsByAccountid(String accountid) {
		return wxTagsDao.findWxTagsByAccountid(accountid);
	}

}