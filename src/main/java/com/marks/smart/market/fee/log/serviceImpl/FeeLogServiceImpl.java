package com.marks.smart.market.fee.log.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.FeeEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.smart.market.fee.base.dao.FeeTypeDao;
import com.marks.smart.market.fee.base.pojo.FeeType;
import com.marks.smart.market.fee.log.dao.FeeLogDao;
import com.marks.smart.market.fee.log.pojo.FeeLog;
import com.marks.smart.market.fee.log.service.FeeLogService;
import com.marks.smart.system.user.sysuser.dao.SysUserDao;

@Service
@Transactional
public class FeeLogServiceImpl implements FeeLogService {

	private static Logger logger = Logger.getLogger(FeeLogServiceImpl.class);

	@Autowired
	private FeeLogDao feeLogDao;

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private FeeTypeDao feeTypeDao;

	/**
	 * private FeeLogDao feeLogDao;
	 * 
	 * public FeeLogDao getFeeLogDao(){ return feeLogDao; } public void
	 * setFeeLogDao(FeeLogDao feeLogDao){ this.feeLogDao =feeLogDao; }
	 * 
	 */
	/**
	 * 根据ID查找费用明细
	 */
	@Override
	public FeeLog findById(String id) {
		logger.info("findById > param>" + id);
		return feeLogDao.findById(id);
	}

	@Override
	public void update(FeeLog info) {
		info.setTranDate(info.getTranTime().substring(0, 10));
		info.setItemName(FeeEnums.ItemCode.getByKey(info.getItemCode()));
		info.setI_month(Integer.parseInt(info.getTranDate().substring(5, 7)));
		info.setI_year(Integer.parseInt(info.getTranDate().substring(0, 4)));
		info.setI_season(DateUtil.getSeason(info.getI_month()));
		feeLogDao.update(info);
	}

	/**
	 * 保存费用明细
	 */
	@Override
	public void save(FeeLog info) {
		logger.info("save > start>");

		FeeType type = feeTypeDao.findById(info.getCompanyId() + info.getFeeCode());
		if (type != null) {
			info.setFeeName(type.getTypeName());
		}
		info.setId(IDUtil.getNumID());
		info.setTranDate(info.getTranTime().substring(0, 10));
		info.setItemName(FeeEnums.ItemCode.getByKey(info.getItemCode()));
		info.setI_month(Integer.parseInt(info.getTranDate().substring(5, 7)));
		info.setI_year(Integer.parseInt(info.getTranDate().substring(0, 4)));
		info.setI_season(DateUtil.getSeason(info.getI_month()));
		feeLogDao.save(info);
		logger.info("save > end>");
	}

	public PojoDomain<FeeLog> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<FeeLog> pojoDomain = new PojoDomain<FeeLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<FeeLog> list = feeLogDao.list(pageBounds, param);
		PageList<FeeLog> pageList = (PageList<FeeLog>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

}