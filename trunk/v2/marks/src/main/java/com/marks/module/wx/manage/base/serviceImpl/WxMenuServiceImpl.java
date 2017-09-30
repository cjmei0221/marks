package com.marks.module.wx.manage.base.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.module.wx.api.mp.wxmenu.pojo.SpecialCondition;
import com.marks.module.wx.api.mp.wxmenu.pojo.WxMenu;
import com.marks.module.wx.manage.base.dao.WxMenuDao;
import com.marks.module.wx.manage.base.pojo.MyWxMenu;
import com.marks.module.wx.manage.base.service.WxMenuService;
import com.marks.module.wx.manage.wxutil.WxMpUtil;

@Service
@Transactional
public class WxMenuServiceImpl implements WxMenuService {
	@Autowired
	private WxMenuDao wxMenuDao;

	/**
	 * 根据ID查找微信菜单管理
	 */
	@Override
	public MyWxMenu findById(String id) {
		return wxMenuDao.findById(id);
	}

	/**
	 * 保存微信菜单管理
	 */
	@Override
	public void save(MyWxMenu wxMenu) {
		wxMenuDao.save(wxMenu);
	}

	/**
	 * 更新微信菜单管理
	 */
	@Override
	public void update(MyWxMenu wxMenu) {
		wxMenuDao.update(wxMenu);
	}

	/**
	 * 删除微信菜单管理
	 * 
	 * @throws Exception
	 */
	@Override
	public void delete(String id) throws Exception {
		
		MyWxMenu wx = wxMenuDao.findById(id);
		if(wx !=null && wx.getMenutype()==1 && null !=wx.getMenuid()){
			// 调用接口，删除个性化菜单
			WxMpUtil.getInstance().delSpecialWxMenu(wx.getAccountid(), wx.getMenuid());
		}
		wxMenuDao.delete(id);
	}

	/**
	 * 查找所有微信菜单管理
	 */
	@Override
	public List<MyWxMenu> findAll() {
		return wxMenuDao.findAll();
	}

	/**
	 * 删除多个微信菜单管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		wxMenuDao.deleteBatch(ids);
	}

	public PojoDomain<MyWxMenu> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<MyWxMenu> pojoDomain = new PojoDomain<MyWxMenu>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<MyWxMenu> list = wxMenuDao.list(pageBounds, param);
		PageList<MyWxMenu> pageList = (PageList<MyWxMenu>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<MyWxMenu> listTree(Map<String, Object> param) {
		List<MyWxMenu> list = wxMenuDao.getParentMenu(param);
		return list;
	}

	@Override
	public Result syncWx(String id) throws Exception {
		// 同步菜单到微信服务器
		Result result = new Result();
		// 获取菜单对象
		MyWxMenu info = wxMenuDao.findById(id);
		// 获取该服务号下所有菜单
		List<MyWxMenu> menuList = wxMenuDao.getWxMenuListByAccountId(info.getAccountid());
		if (null != menuList && menuList.size() > 0) {
			List<WxMenu> mlist = new ArrayList<WxMenu>();
			// 一级菜单
			for (WxMenu wm : menuList) {
				if (wm.getParent_id().equals(id)) {
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
			// 若有菜单则同步微信服务器
			if(mlist.size()>0){
				if (info.getMenutype() == 0) {// 通用菜单
					// 调用创建微信菜单接口
					result=WxMpUtil.getInstance().createWXMenu(info.getAccountid(), mlist);
				} else {// 个性菜单，暂时只支持用户标签
						// 个性化菜单条件
					SpecialCondition condition=new SpecialCondition();
					condition.setTag_id(info.getTagid());
					result=WxMpUtil.getInstance().createSpecialWxMenu(info.getAccountid(), condition, mlist);
					if(Code.CODE_SUCCESS.equals(result.getCode())){
						info.setMenuid(result.getData().get("menuid").toString());
						wxMenuDao.update(info);
					}
				}
			}else{
				
			}
		}
		return result;
	}

	@Override
	public List<MyWxMenu> getChildWxMenuList(String id) {
		return wxMenuDao.getChildWxMenuList(id);
	}
}