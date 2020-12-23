package com.marks.smart.market.project.sales.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.Enums;
import com.marks.common.enums.SalesEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.smart.market.project.sales.dao.SalesDetailDao;
import com.marks.smart.market.project.sales.dao.SalesInfoDao;
import com.marks.smart.market.project.sales.dao.SalesItemDao;
import com.marks.smart.market.project.sales.pojo.SalesDetail;
import com.marks.smart.market.project.sales.pojo.SalesForm;
import com.marks.smart.market.project.sales.pojo.SalesInfo;
import com.marks.smart.market.project.sales.pojo.SalesItem;
import com.marks.smart.market.project.sales.service.SalesInfoService;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.service.SysUserService;

@Service
@Transactional
public class SalesInfoServiceImpl implements SalesInfoService {

	private static Logger logger = Logger.getLogger(SalesInfoServiceImpl.class);

	@Autowired
	private SalesInfoDao salesInfoDao;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SalesDetailDao salesDetailDao;
	@Autowired
	private SalesItemDao salesItemDao;

	/**
	 * private SalesInfoDao salesInfoDao;
	 * 
	 * public SalesInfoDao getSalesInfoDao(){ return salesInfoDao; } public void
	 * setSalesInfoDao(SalesInfoDao salesInfoDao){ this.salesInfoDao =salesInfoDao;
	 * }
	 * 
	 */
	/**
	 * 根据ID查找促销方案
	 */
	@Override
	public SalesInfo findById(String id) {
		logger.info("findById > param>" + id);
		return salesInfoDao.findById(id);
	}
	
	

	@Override
	public List<SalesItem> findSalesItemListByProjectCode(String projectCode) {
		return salesItemDao.findByProjectCode(projectCode);
	}



	/**
	 * 保存促销方案
	 */
	@Override
	public void save(SalesInfo info, List<SalesItem> list) {
		logger.info("save > start>");
		salesInfoDao.save(info);
		saveSalesItemList(info, list);
		logger.info("save > end>");
	}

	private void saveSalesItemList(SalesInfo info, List<SalesItem> list) {
		if (null != list && list.size() > 0) {
			salesItemDao.deleteByProjectCode(info.getProjectCode());
			salesItemDao.saveBatch(list);
		}

	}

	/**
	 * 更新促销方案
	 */
	@Override
	public void update(SalesInfo info, List<SalesItem> list) {
		logger.info("update > start>");
		salesInfoDao.update(info);
		saveSalesItemList(info, list);
		logger.info("update > end>");
	}

	/**
	 * 删除促销方案
	 */
	@Override
	public void delete(String id) {
		logger.info("delete > start> params >" + id);
		salesItemDao.deleteByProjectCode(id);
		salesInfoDao.delete(id);
	}

	/**
	 * 查找所有促销方案
	 */
	@Override
	public List<SalesInfo> findAll() {
		logger.info("findAll > start> params >");
		return salesInfoDao.findAll();
	}

	/**
	 * 删除多个促销方案
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		logger.info("deleteBatch > start> params >" + ids);
		salesInfoDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >" + ids);
	}

	public PojoDomain<SalesInfo> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<SalesInfo> pojoDomain = new PojoDomain<SalesInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SalesInfo> list = salesInfoDao.list(pageBounds, param);
		PageList<SalesInfo> pageList = (PageList<SalesInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public void updateCheckStatus(Map<String, String> map) {
		int checkStatus = Integer.parseInt(map.get("checkStatus"));
		SalesInfo info = salesInfoDao.findById(map.get("idNo"));
		info.setChecker(map.get("checker"));
		info.setCheckStatus(checkStatus);
		info.setCheckTime(DateUtil.getCurrDateStr());
		info.setStatus(Enums.Status.Unable.getValue());
		if (Enums.CheckStatus.checkOk.getValue() == checkStatus) {
			info.setStatus(Enums.Status.Enable.getValue());
		}
		salesInfoDao.update(info);
	}

	@Override
	public SalesInfo findActiveSalesInfo(Map<String, String> params) {
		List<SalesInfo> list = salesInfoDao.findActiveSalesInfo(params);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveDetail(SalesForm info, SalesInfo sales) {
		SysUser user = sysUserService.findById(sales.getCompanyId(), info.getUserId());
		if (user == null) {
			return;
		}
		SalesDetail log = new SalesDetail();
		log.setBatchId(info.getBatchId());
		log.setCompanyId(sales.getCompanyId());
		log.setId(IDUtil.getNumID());
		log.setIdName(info.getIdName());
		log.setIdNo(info.getIdNo());
		if (SalesEnums.YwCode.coupon.getValue() == sales.getYwCode()) {
			log.setItemCode(sales.getProjectCode());
			log.setItemValue(sales.getProjectVal());
			log.setItemTypeCode(sales.getTypeCode());
			log.setItemTypeName(sales.getTypeName());
			log.setItemName(log.getItemValue() +" "+ sales.getTypeName());
			if (SalesEnums.TypeCode.coupon_amt.getValue() == sales.getTypeCode()) {
				log.setItemName(log.getItemValue() + " 元" + sales.getTypeName());
			}
			log.setIsAward(1);
			log.setAwardTypeCode(SalesEnums.AwardTypeCode.coupon.getValue());
			log.setAwardTypeName(sales.getTypeName());
			log.setAwardCode(log.getId());
			log.setAwardName(log.getItemName());
			log.setAwardVal(log.getItemValue());
		}
		log.setProjectCode(sales.getProjectCode());
		log.setProjectName(sales.getProjectName());
		log.setStartDate(sales.getStartDate());
		log.setEndDate(sales.getEndDate());
		log.setRemarks(info.getRemarks());
		log.setStatus(SalesEnums.DetailStatus.no_use.getValue());
		log.setYwCode(sales.getYwCode());
		log.setYwName(sales.getYwName());
		log.setTypeCode(sales.getTypeCode());
		log.setTypeName(sales.getTypeName());
		log.setUserId(info.getUserId());
		log.setUserCode(user.getUserCode());
		log.setUserId(user.getUserid());
		log.setUserName(user.getUsername());
		log.setUserTel(user.getBind_mobile());
		log.setOpenid(user.getOpenid());
		log.setOrgId(user.getOrgId());
		log.setOrgName(user.getOrgName());
		log.setRoleName(user.getRoleName());
		log.setRoleType(user.getRoleType());
		salesDetailDao.save(log);
	}

}