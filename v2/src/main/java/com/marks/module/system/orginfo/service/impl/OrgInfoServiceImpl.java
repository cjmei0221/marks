package com.marks.module.system.orginfo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.orginfo.dao.OrgInfoDao;
import com.marks.module.system.orginfo.pojo.OrgInfo;
import com.marks.module.system.orginfo.service.OrgInfoService;
import com.marks.module.system.sysuser.pojo.SysUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class OrgInfoServiceImpl implements OrgInfoService {

	private OrgInfoDao orgInfoDao;

	public OrgInfoDao getOrgInfoDao() {
		return orgInfoDao;
	}

	public void setOrgInfoDao(OrgInfoDao orgInfoDao) {
		this.orgInfoDao = orgInfoDao;
	}

	/**
	 * 根据ID查找机构管理
	 */
	@Override
	public OrgInfo findById(String orgid) {
		return orgInfoDao.findById(orgid);
	}

	/**
	 * 保存机构管理
	 */
	@Override
	public void save(OrgInfo orgInfo) {
		orgInfoDao.save(orgInfo);
		updateOrgChildNum(orgInfo.getParentId());
	}

	/**
	 * 更新机构管理
	 */
	@Override
	public void update(OrgInfo orgInfo) {
		orgInfoDao.update(orgInfo);
		updateOrgChildNum(orgInfo.getParentId());
	}

	private void updateOrgChildNum(String orgid){
		orgInfoDao.updateOrgChildNum(orgid);
	}
	
	/**
	 * 删除机构管理
	 */
	@Override
	public void delete(String orgid) {
		orgInfoDao.delete(orgid);
	}

	/**
	 * 查找所有机构管理
	 */
	@Override
	public List<OrgInfo> findAll() {
		return orgInfoDao.findAll(null);
	}

	/**
	 * 删除多个机构管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		orgInfoDao.deleteBatch(ids);
	}

	@Override
	public List<OrgInfo> listGrid(List<String> plist, String companyId) {
		return orgInfoDao.getTreeGridByParentId(plist, companyId);
	}

	public List<OrgInfo> list(SysUser admin) {
		List<OrgInfo> allList = orgInfoDao.findAll(admin.getCompanyId());
		List<OrgInfo> list = null;
		if (null == admin.getCompanyId()) {
			list = new ArrayList<OrgInfo>();
			for (OrgInfo vo : allList) {
				if (admin.getOrgInfoList().get(0).getParentId().equals(vo.getParentId())) {
					list.add(vo);
				}
			}
		} else {
			list = admin.getOrgInfoList();
		}
		if (list.size() > 0) {
			getChildren(list, allList);
		}
		return list;
	}

	private void getChildren(List<OrgInfo> list, List<OrgInfo> allList) {
		if (list.size() > 0) {
			for (OrgInfo p : list) {
				for (OrgInfo vo : allList) {
					if (p.getOrgid().equals(vo.getParentId())) {
						p.addChildren(vo);
					}
				}
				if (p.getChildren().size() > 0) {
					p.setState("closed");
					getChildren(p.getChildren(), allList);
				}
			}
		}
	}

	@Override
	public List<OrgInfo> getChildList(String orgid) {
		return orgInfoDao.getChildList(orgid);
	}

	@Override
	public PojoDomain<OrgInfo> framelist(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<OrgInfo> pojoDomain = new PojoDomain<OrgInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrgInfo> list = orgInfoDao.list(pageBounds, param);
		PageList<OrgInfo> pageList = (PageList<OrgInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<OrgInfo> frameCombo(Map<String, Object> param) {
		return orgInfoDao.frameCombo(param);
	}
}