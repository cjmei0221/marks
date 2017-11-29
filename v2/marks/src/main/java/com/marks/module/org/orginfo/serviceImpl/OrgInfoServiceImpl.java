package com.marks.module.org.orginfo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.org.orginfo.dao.OrgInfoDao;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.org.orginfo.service.OrgInfoService;
import com.marks.module.user.sysuser.pojo.SysUser;

@Service
public class OrgInfoServiceImpl implements OrgInfoService {

	@Autowired
	private OrgInfoDao orgInfoDao;

	/*
	 * public OrgInfoDao getOrgInfoDao() { return orgInfoDao; }
	 * 
	 * public void setOrgInfoDao(OrgInfoDao orgInfoDao) { this.orgInfoDao =
	 * orgInfoDao; }
	 */

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
		if (orgInfo.getLvl() > 1) {
			updateOrgChildNum(orgInfo.getParentId());
		}

	}

	/**
	 * 更新机构管理
	 */
	@Override
	public void update(OrgInfo orgInfo) {
		orgInfoDao.update(orgInfo);
		if (orgInfo.getLvl() > 1) {
			orgInfoDao.updateMoreLvlName(orgInfo.getOrgid(), orgInfo.getOrgname(), orgInfo.getLvl());
			updateOrgChildNum(orgInfo.getParentId());
		}
	}

	private void updateOrgChildNum(String orgid) {
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
	public List<OrgInfo> listGrid(String parentId, String companyId, String orgType) {
		return orgInfoDao.getTreeGridByParentId(parentId, companyId, orgType);
	}

	public List<OrgInfo> list(SysUser admin) {
		List<OrgInfo> allList = orgInfoDao.findAll(admin.getCompanyId());
		List<OrgInfo> list = new ArrayList<OrgInfo>();
		for (OrgInfo vo : allList) {
			if (admin.getCompanyId().equals(vo.getOrgid())) {
				list.add(vo);
			}
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

	@Override
	public String getOrgId() {
		// String orgId = orgInfoDao.getOrgId();
		// int num = 0;
		// if (null != orgId && !"".equals(orgId)) {
		// num = Integer.parseInt(orgId.substring(1));
		// } else {
		// orgId = "O1000001";
		// }
		// orgId = "O" + (num + 1);
		String orgId = IDUtil.getDateID() + "_" + IDUtil.getRandom(100, 999) + IDUtil.getRandom(100, 999);
		return orgId;
	}

	@Override
	public String getCompanyId() {
		String orgId = orgInfoDao.getCompanyId();
		int num = 0;
		if (null != orgId && !"".equals(orgId)) {
			num = Integer.parseInt(orgId);
		} else {
			orgId = "1001";
		}
		orgId = "" + (num + 1);
		return orgId;
	}
}