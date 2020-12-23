package com.marks.smart.count.acct.base.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.count.acct.base.dao.UserExtDao;
import com.marks.smart.count.acct.base.pojo.UserExt;
import com.marks.smart.count.acct.base.service.UserExtService;
import com.marks.smart.system.user.sysuser.dao.SysUserDao;
import com.marks.smart.system.user.sysuser.dao.UserLvlDao;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.UserLvl;

@Service
@Transactional
public class UserExtServiceImpl implements UserExtService {

	private static Logger logger = Logger.getLogger(UserExtServiceImpl.class);
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private UserExtDao userExtDao;
	@Autowired
	private UserLvlDao userLvlDao;

	/**
	 * private UserExtDao userExtDao;
	 * 
	 * public UserExtDao getUserExtDao(){ return userExtDao; } public void
	 * setUserExtDao(UserExtDao userExtDao){ this.userExtDao =userExtDao; }
	 * 
	 */
	/**
	 * 根据ID查找用户扩展表
	 */
	@Override
	public UserExt findById(String id) {
		logger.info("findById > param>" + id);
		return userExtDao.findById(id);
	}

	/**
	 * 保存用户扩展表
	 */
	@Override
	public void saveOrUpdate(SysUser sysUser) {
		logger.info("save > start>");
		UserExt info = userExtDao.findById(sysUser.getUserid());
		String date = DateUtil.getCurrDateStr();
		if (info == null) {
			info = new UserExt();
			info.setUserid(sysUser.getUserid());
			info.setUserCode(sysUser.getUserCode());
			info.setUserName(sysUser.getUsername());
			info.setCompanyId(sysUser.getCompanyId());
			info.setLvlId(info.getCompanyId() + "_0");
			info.setLvlName("普通会员");
			info.setFirst_operate_time(date);
			info.setLast_operate_time(date);
			info.setGrand_total_consume_amt("0.00");
			userExtDao.save(info);
		} else {
			if (null == info.getFirst_operate_time() || "".equals(info.getFirst_operate_time())) {
				info.setFirst_operate_time(date);
			}
			info.setLast_operate_time(date);
			userExtDao.update(info);
		}
		logger.info("save > end>");
	}

	/**
	 * 删除用户扩展表
	 */
	@Override
	public void delete(String id) {
		logger.info("delete > start> params >" + id);
		userExtDao.delete(id);
	}

	/**
	 * 查找所有用户扩展表
	 */
	@Override
	public List<UserExt> findAll() {
		logger.info("findAll > start> params >");
		return userExtDao.findAll();
	}

	/**
	 * 删除多个用户扩展表
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		logger.info("deleteBatch > start> params >" + ids);
		userExtDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >" + ids);
	}

	public PojoDomain<UserExt> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<UserExt> pojoDomain = new PojoDomain<UserExt>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<UserExt> list = userExtDao.list(pageBounds, param);
		PageList<UserExt> pageList = (PageList<UserExt>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public UserExt findByMobile(String companyId, String mobile) {
		return userExtDao.findByMobile(companyId, mobile);
	}

	@Override
	public void updateVipInfoByOrder(String vipId, int point, String payAmt) {
		UserExt info = userExtDao.findById(vipId);
		boolean updateFlag = true;
		String date = DateUtil.getCurrDateStr();
		if (info == null) {
			SysUser user = sysUserDao.findByUserid(vipId);
			updateFlag = false;
			info = new UserExt();
			info.setUserid(user.getUserid());
			info.setUserCode(user.getUserCode());
			info.setUserName(user.getUsername());
			info.setCompanyId(user.getCompanyId());
			info.setLvlId(info.getCompanyId() + "_0");
			info.setLvlName("普通会员");
			info.setFirst_operate_time(date);
			info.setGrand_total_consume_amt("0.00");
		}
		info.setGrand_total_consume_nums(info.getGrand_total_consume_nums() + 1);
		info.setGrand_total_point(info.getGrand_total_point() + point);
		info.setGrand_total_consume_amt(MoneyUtil.add(info.getGrand_total_consume_amt(), payAmt));
		// 会员等级
		List<UserLvl> lvlList = userLvlDao.findAll();
		if (null == lvlList) {
			lvlList = new ArrayList<UserLvl>();
		}
		boolean normalflag = true;
		for (UserLvl lvl : lvlList) {
			if (lvl.getLvlId().equals(info.getCompanyId() + "_0")) {
				normalflag = false;
			}
		}
		if (normalflag) {
			UserLvl lvl = new UserLvl();
			lvl.setCompanyId(info.getCompanyId());
			lvl.setLvl(0);
			lvl.setLvlId(info.getCompanyId() + "_" + lvl.getLvl());
			lvl.setLvlName("普通会员");
			userLvlDao.save(lvl);
		}
		// 会员等级信息

		for (UserLvl lvl : lvlList) {
			// 如现有会员等级只升不降
			if (info.getLvl() < lvl.getLvl() && lvl.getUpPointFlag() == 1
					&& info.getGrand_total_point() >= lvl.getUpPoint()) {
				info.setLvlId(lvl.getLvlId());
				info.setLvlName(lvl.getLvlName());
				info.setLvl(lvl.getLvl());
			}
			if (info.getLvl() < lvl.getLvl() && lvl.getUpAmtFlag() == 1
					&& MoneyUtil.compare(info.getGrand_total_consume_amt(), lvl.getUpAmt())) {
				info.setLvlId(lvl.getLvlId());
				info.setLvlName(lvl.getLvlName());
				info.setLvl(lvl.getLvl());
			}
		}
		info.setLast_operate_time(date);
		info.setLast_consume_time(date);
		if (null == info.getFirst_consume_time() || "".equals(info.getFirst_consume_time())) {
			info.setFirst_consume_time(date);
		}
		if (updateFlag) {
			userExtDao.update(info);
		} else {
			userExtDao.save(info);
		}
	}

}