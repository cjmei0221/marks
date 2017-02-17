package com.marks.module.wx.wxmenu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.wx.wxmenu.dao.WxMenuDao;
import com.marks.module.wx.wxmenu.pojo.WxMenu;
import com.marks.module.wx.wxmenu.service.WxMenuService;
import com.marks.module.wx.wxutil.WxFwUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class WxMenuServiceImpl implements WxMenuService {

	private WxMenuDao wxMenuDao;

	public WxMenuDao getWxMenuDao() {
		return wxMenuDao;
	}

	public void setWxMenuDao(WxMenuDao wxMenuDao) {
		this.wxMenuDao = wxMenuDao;
	}

	/**
	 * 根据ID查找微信菜单管理
	 */
	@Override
	public WxMenu findById(String id) {
		return wxMenuDao.findById(id);
	}

	/**
	 * 保存微信菜单管理
	 */
	@Override
	public void save(WxMenu wxMenu) {
		wxMenuDao.save(wxMenu);
	}

	/**
	 * 更新微信菜单管理
	 */
	@Override
	public void update(WxMenu wxMenu) {
		wxMenuDao.update(wxMenu);
	}

	/**
	 * 删除微信菜单管理
	 */
	@Override
	public void delete(String id) {
		wxMenuDao.delete(id);
	}

	/**
	 * 查找所有微信菜单管理
	 */
	@Override
	public List<WxMenu> findAll() {
		return wxMenuDao.findAll();
	}

	/**
	 * 删除多个微信菜单管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		wxMenuDao.deleteBatch(ids);
	}

	public PojoDomain<WxMenu> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WxMenu> pojoDomain = new PojoDomain<WxMenu>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WxMenu> list = wxMenuDao.list(pageBounds, param);
		PageList<WxMenu> pageList = (PageList<WxMenu>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<WxMenu> listTree(Map<String, Object> param) {
		List<WxMenu> list = wxMenuDao.getParentMenu(param);
		if (null != list && list.size() > 0) {
			List<WxMenu> menuList = wxMenuDao.getWxMenuList();
			if (null != menuList && menuList.size() > 0) {
				// 加载一级菜单
				for (WxMenu p : list) {
					for (WxMenu wx : menuList) {
						if (p.getId().equals(wx.getParent_id())) {
							p.addChildren(wx);
						}
					}
					p.setChildnum(p.getChildren().size());
					if (p.getChildren().size() > 0) {
						// 加载二级菜单
						for (WxMenu pc : p.getChildren()) {
							for (WxMenu wx : menuList) {
								if (pc.getId().equals(wx.getParent_id())) {
									pc.addChildren(wx);
								}
							}
							pc.setChildnum(pc.getChildren().size());
						}
					}
				}

			}
		}
		return list;
	}

	@Override
	public Result syncWx(String accountid) throws Exception {
		Result result = new Result();
		List<WxMenu> menuList = wxMenuDao.getWxMenuListByAccountId(accountid);
		if (null != menuList && menuList.size() > 0) {
			List<WxMenu> mlist = new ArrayList<WxMenu>();
			// 一级菜单
			for (WxMenu wm : menuList) {
				if (wm.getParent_id().equals(accountid)) {
					mlist.add(wm);
				}
			}
			// 加载二级菜单
			for (WxMenu wmchild : mlist) {
				for (WxMenu wm : menuList) {
					if (wmchild.getId().equals(wm.getParent_id())) {
						wmchild.addChildren(wm);
					}
				}
				if (wmchild.getChildren().size() > 0) {
					wmchild.setType("click");
//					wmchild.setContent("");
				}
			}
			result=WxFwUtil.getInstance().createWXMenu(accountid, mlist);
		}
		return result;
	}

	@Override
	public List<WxMenu> getChildWxMenuList(String id) {
		return wxMenuDao.getChildWxMenuList(id);
	}
}