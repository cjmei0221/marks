package com.marks.smart.system.org.orginfo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.Enums;
import com.marks.common.enums.OrgEnums;
import com.marks.common.enums.UserEnums;
import com.marks.common.util.Constants;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.smart.system.org.orginfo.dao.OrgInfoDao;
import com.marks.smart.system.org.orginfo.pojo.OrgInfo;
import com.marks.smart.system.org.orginfo.service.OrgInfoService;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.service.SysUserService;

@Service
public class OrgInfoServiceImpl implements OrgInfoService {

	@Autowired
	private OrgInfoDao orgInfoDao;
	@Autowired
	private SysUserService sysUserService;

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
	public String save(OrgInfo orgInfo) {
		String orgId = this.getOrgId(orgInfo.getCompanyId(), orgInfo.getOrgCategory() + "");
		orgInfo.setOrgid(orgId);
		if (OrgEnums.OrgType.company.getValue() == orgInfo.getOrgType()) {
			orgInfo.setParentId(Constants.top_parent_id);
			orgInfo.setCompanyId(orgInfo.getOrgid());
			orgInfo.setLvl(1);
			orgInfo.setCheckStatus(Enums.CheckStatus.noCheck.getValue());
		} else {
			OrgInfo parentVo = this.findById(orgInfo.getParentId());
			orgInfo.setLvl(parentVo.getLvl() + 1);
			orgInfo.setCompanyId(parentVo.getCompanyId());
			orgInfo.setParentName(parentVo.getOrgname());

			orgInfo.setLvl2Id(parentVo.getLvl2Id());
			orgInfo.setLvl2Name(parentVo.getLvl2Name());

			orgInfo.setLvl3Id(parentVo.getLvl3Id());
			orgInfo.setLvl3Name(parentVo.getLvl3Name());

			orgInfo.setLvl4Id(parentVo.getLvl4Id());
			orgInfo.setLvl4Name(parentVo.getLvl4Name());

			orgInfo.setLvl5Id(parentVo.getLvl5Id());
			orgInfo.setLvl5Name(parentVo.getLvl5Name());

			orgInfo.setLvl6Id(parentVo.getLvl6Id());
			orgInfo.setLvl6Name(parentVo.getLvl6Name());

			if (orgInfo.getLvl() == 2) {
				orgInfo.setLvl2Id(orgInfo.getOrgid());
				orgInfo.setLvl2Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 3) {
				orgInfo.setLvl3Id(orgInfo.getOrgid());
				orgInfo.setLvl3Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 4) {
				orgInfo.setLvl4Id(orgInfo.getOrgid());
				orgInfo.setLvl4Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 5) {
				orgInfo.setLvl5Id(orgInfo.getOrgid());
				orgInfo.setLvl5Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 6) {
				orgInfo.setLvl6Id(orgInfo.getOrgid());
				orgInfo.setLvl6Name(orgInfo.getOrgname());
			}
		}
		if (orgInfo.getOrgid().length() > orgInfo.getCompanyId().length()) {
			orgInfo.setOrgCode(orgInfo.getOrgid().substring(orgInfo.getCompanyId().length()));
		} else {
			orgInfo.setOrgCode("");
		}
		orgInfoDao.save(orgInfo);
		if (orgInfo.getLvl() > 1) {
			updateOrgChildNum(orgInfo.getParentId());
		}
		return orgId;
	}

	/**
	 * 更新机构管理
	 */
	@Override
	public void update(OrgInfo orgInfo) {
		if (OrgEnums.OrgType.company.getValue() == orgInfo.getOrgType()) {
			orgInfo.setParentId(Constants.top_parent_id);
			orgInfo.setLvl(1);
		} else {
			OrgInfo parentVo = this.findById(orgInfo.getParentId());
			orgInfo.setParentName(parentVo.getOrgname());
			orgInfo.setLvl(parentVo.getLvl() + 1);

			orgInfo.setLvl2Id(parentVo.getLvl2Id());
			orgInfo.setLvl2Name(parentVo.getLvl2Name());

			orgInfo.setLvl3Id(parentVo.getLvl3Id());
			orgInfo.setLvl3Name(parentVo.getLvl3Name());

			orgInfo.setLvl4Id(parentVo.getLvl4Id());
			orgInfo.setLvl4Name(parentVo.getLvl4Name());

			orgInfo.setLvl5Id(parentVo.getLvl5Id());
			orgInfo.setLvl5Name(parentVo.getLvl5Name());

			orgInfo.setLvl6Id(parentVo.getLvl6Id());
			orgInfo.setLvl6Name(parentVo.getLvl6Name());

			if (orgInfo.getLvl() == 2) {
				orgInfo.setLvl2Id(orgInfo.getOrgid());
				orgInfo.setLvl2Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 3) {
				orgInfo.setLvl3Id(orgInfo.getOrgid());
				orgInfo.setLvl3Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 4) {
				orgInfo.setLvl4Id(orgInfo.getOrgid());
				orgInfo.setLvl4Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 5) {
				orgInfo.setLvl5Id(orgInfo.getOrgid());
				orgInfo.setLvl5Name(orgInfo.getOrgname());
			} else if (orgInfo.getLvl() == 6) {
				orgInfo.setLvl6Id(orgInfo.getOrgid());
				orgInfo.setLvl6Name(orgInfo.getOrgname());
			}
		}
		orgInfoDao.update(orgInfo);
		if (orgInfo.getLvl() > 1) {
			orgInfoDao.updateMoreLvlName(orgInfo.getOrgid(), orgInfo.getOrgname(), orgInfo.getLvl());
			updateOrgChildNum(orgInfo.getParentId());
		}
		// 更新机构名称
		if (OrgEnums.OrgType.company.getValue() == orgInfo.getOrgType()) {
			sysUserService.updateOrgName(orgInfo.getOrgid(), orgInfo.getOrgname());
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
		sysUserService.delete(orgid);
	}

	/**
	 * 删除多个机构管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		orgInfoDao.deleteBatch(ids);
	}

	@Override
	public List<OrgInfo> listGrid(Map<String, Object> param) {
		return orgInfoDao.getTreeGridByParentId(param);
	}

	public List<OrgInfo> list(String companyId, String parentId, String orgType) {
		List<OrgInfo> allList = orgInfoDao.findAll(companyId, orgType);
		List<OrgInfo> list = new ArrayList<OrgInfo>();
		for (OrgInfo vo : allList) {
			if (parentId.equals(vo.getOrgid())) {
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

	public String getOrgId(String companyId, String orgCategory) {
		if(OrgEnums.OrgCategory.company.toString().equals(orgCategory)) {
			return this.getCompanyId();
		}
		String orgId = orgInfoDao.getOrgId(companyId, orgCategory);
		int num = 0;
		if (OrgEnums.OrgCategory.supplier.toString().equals(orgCategory)) {
			num = 1000;
		} else {
			num = 0;
		}
		if (null != orgId && orgId.length() > 1) {
			num = Integer.parseInt(orgId);
		}
		orgId = String.valueOf(num + 1);
		if (orgId.length() < 2) {
			orgId = "0" + orgId;
		}
		return companyId + orgId;
	}

	public String getCompanyId() {
		String orgId = orgInfoDao.getCompanyId();
		int num = 0;
		if (null != orgId && !"".equals(orgId)) {
			num = Integer.parseInt(orgId);
		} else {
			num = 1000;
		}
		if (num > 100000) {
			num = 1000000;
		}
		orgId = "" + (num + 1);
		return orgId;
	}

	public void updateCheckStatus(Map<String, String> map) {
		orgInfoDao.updateCheckStatus(map);
		String checkStatus = map.get("checkStatus");
		String companyId = map.get("companyId");
		OrgInfo info = orgInfoDao.findById(map.get("idNo"));
		// 审核通过处理库存
		if (Enums.CheckStatus.checkOk.toString().equals(checkStatus)) {
			// 若为公司则创建相关用户
			if (OrgEnums.OrgCategory.company.getValue() == info.getOrgCategory()) {
				SysUser user = new SysUser();
				if (null != info.getLinkTel() && info.getLinkTel().length() > 4) {
					user.setBind_mobile(info.getLinkTel());
				} else {
					user.setBind_mobile(info.getOrgid());
				}
				user.setActiveFlag(Enums.Status.Enable.getValue());
				user.setBindFlag(Enums.Status.Unable.getValue());
				user.setCompanyId(info.getCompanyId());
				user.setCreator(info.getCreator());
				user.setPassword(EncryptUtil.defaultPwd);
				user.setUsername(info.getOrgname());

				user.setRoleType("system");
				user.setRoleId(companyId + "_" + user.getRoleType());
				user.setUserid(info.getOrgid());
				user.setRoleYwType(UserEnums.RoleYwType.defaultUser.getValue());
				user.setOrgId(info.getOrgid());
				user.setChannelId(ChannelEnums.Channel.manage.getValue());
				sysUserService.saveOrUpdate(user);
			}
		}
	}
}