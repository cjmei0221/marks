package com.marks.smart.count.acct.ext.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.common.domain.Result;
import com.marks.common.enums.AcctEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.count.acct.ext.pojo.PointLog;
import com.marks.smart.count.acct.ext.pojo.TranLog;
import com.marks.smart.count.acct.ext.service.AcctService;
import com.marks.smart.count.acct.info.dao.AcctInfoDao;
import com.marks.smart.count.acct.info.dao.AcctPointDao;
import com.marks.smart.count.acct.info.pojo.AcctInfo;
import com.marks.smart.count.acct.info.pojo.AcctPoint;
import com.marks.smart.count.acct.log.dao.AcctLogDao;
import com.marks.smart.count.acct.log.pojo.AcctLog;
import com.marks.smart.system.user.sysuser.dao.SysUserDao;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

@Service
@Transactional
public class AcctServiceImpl implements AcctService {
	@Autowired
	private AcctPointDao acctPointDao;
	@Autowired
	private AcctInfoDao acctInfoDao;
	@Autowired
	private AcctLogDao acctLogDao;
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public Result savePoint(PointLog log) {
		Result result = new Result();
		AcctPoint info = acctPointDao.findById(log.getUserid());
		String date = DateUtil.getCurrDateStr();
		boolean updateFlag = true;
		if (null == info) {
			SysUser user = sysUserDao.findByUserid(log.getUserid());
			updateFlag = false;
			info = new AcctPoint();
			info.setCompanyId(user.getCompanyId());
			info.setFirst_point_time(date);
			info.setUserCode(user.getUserCode());
			info.setUserName(user.getUsername());
			info.setUserid(user.getUserid());
		}
		if(log.getTranPoint()<0) {
			log.setTranPoint(-log.getTranPoint());
		}

		if (AcctEnums.TranCode.add.getValue().equals(log.getTranCode())) {
			info.setBalPoint(info.getBalPoint() + log.getTranPoint());
			info.setGrand_total_point(info.getGrand_total_point() + log.getTranPoint());
			info.setLast_point_time(date);
			if (null == info.getFirst_point_time() || "".equals(info.getFirst_point_time())) {
				info.setFirst_point_time(date);
			}
		} else if (AcctEnums.TranCode.less.getValue().equals(log.getTranCode())) {
			if (info.getBalPoint() - log.getTranPoint() < 0) {
				result.setCode("4002");
				result.setMessage("积分不足");
				return result;
			}
			info.setBalPoint(info.getBalPoint() - log.getTranPoint());
		} else if (AcctEnums.TranCode.loss.getValue().equals(log.getTranCode())) {
			info.setLossPoint(info.getLossPoint() + log.getTranPoint());
			info.setBalPoint(info.getBalPoint() - log.getTranPoint());
			int soonPoint = info.getSoonPoint() - log.getTranPoint();
			if (info.getSoonPoint() > 0) {
				info.setSoonPoint(soonPoint);
			} else {
				info.setSoonPoint(0);
			}
		}
		info.setUpdatetime(date);
		if (updateFlag) {
			acctPointDao.update(info);
		} else {
			acctPointDao.save(info);
		}
		AcctLog vo = new AcctLog();
		vo.setId(IDUtil.getSecondID() + IDUtil.getID(8));
		vo.setRemarks(log.getRemarks());
		vo.setBalPoint(info.getBalPoint());
		vo.setTranCode(log.getTranCode());
		vo.setTranDesc(log.getTranDesc());
		vo.setTranPoint(log.getTranPoint());
		vo.setTranStatus(AcctEnums.TranStatus.complete.getValue());
		vo.setTranTime(log.getTranTime());
		vo.setUserCode(info.getUserCode());
		vo.setUserid(info.getUserid());
		vo.setUserName(info.getUserName());
		vo.setYwCode(AcctEnums.YwCode.point.getValue());
		vo.setCompanyId(info.getCompanyId());
		vo.setChannelId(log.getChannelId());
		vo.setOrgId(log.getOrgId());
		vo.setOrgName(log.getOrgName());
		vo.setOperatorCode(log.getOperatorCode());
		vo.setOperatorName(log.getOperatorName());
		vo.setOrderId(log.getOrderId());
		acctLogDao.save(vo);
		return result;
	}

	@Override
	public Result saveAmt(TranLog log) {
		Result result = new Result();
		AcctInfo info = acctInfoDao.findById(log.getUserid());
		String date = DateUtil.getCurrDateStr();
		boolean updateFlag = true;
		if (null == info) {
			SysUser user = sysUserDao.findByUserid(log.getUserid());
			info = new AcctInfo();
			updateFlag = false;
			info.setCompanyId(user.getCompanyId());
			info.setFirst_recharge_time(date);
			info.setUserCode(user.getUserCode());
			info.setUserName(user.getUsername());
			info.setUserid(user.getUserid());
		}
//		
//		if(MoneyUtil.compare("-0.01",log.getTranAmt())) {
//			log.setTranAmt(String.valueOf(-Double.parseDouble(log.getTranAmt())));
//		}

		if (AcctEnums.TranCode.add.getValue().equals(log.getTranCode())) {
			info.setBalAmt(MoneyUtil.add(info.getBalAmt(), log.getTranAmt()));
			info.setTotalAmt(MoneyUtil.add(info.getTotalAmt(), log.getTranAmt()));
			info.setLast_recharge_time(date);
			info.setCashAmt(MoneyUtil.add(info.getCashAmt(), log.getCashAmt()));
			info.setSendAmt(MoneyUtil.add(info.getSendAmt(), log.getSendAmt()));
			info.setGrand_recharge_cashAmt(MoneyUtil.add(info.getGrand_recharge_cashAmt(), log.getCashAmt()));
			info.setGrand_recharge_sendAmt(MoneyUtil.add(info.getGrand_recharge_sendAmt(), log.getSendAmt()));
			if (null == info.getFirst_recharge_time() || "".equals(info.getFirst_recharge_time())) {
				info.setFirst_recharge_time(date);
			}
		} else if (AcctEnums.TranCode.less.getValue().equals(log.getTranCode())) {
			if (!MoneyUtil.compare(info.getBalAmt(), log.getTranAmt())) {
				result.setCode("4002");
				result.setMessage("余额不足");
				return result;
			}
			info.setBalAmt(MoneyUtil.subtract(info.getBalAmt(), log.getTranAmt()));
			info.setTotalAmt(MoneyUtil.subtract(info.getTotalAmt(), log.getTranAmt()));
			String bl = MoneyUtil.subtract(info.getSendAmt(), log.getTranAmt());
			if (MoneyUtil.compare(bl, "0")) {
				info.setSendAmt(bl);
			} else {
				info.setSendAmt("0");
				bl = MoneyUtil.add(info.getCashAmt(), bl);
				if (MoneyUtil.compare(bl, "0")) {
					info.setCashAmt(bl);
				} else {
					info.setCashAmt("0");
				}
			}
		}
		info.setUpdatetime(date);
		if (updateFlag) {
			acctInfoDao.update(info);
		} else {
			acctInfoDao.save(info);
		}
		AcctLog vo = new AcctLog();
		vo.setId(IDUtil.getSecondID() + IDUtil.getID(8));
		vo.setRemarks(log.getRemarks());
		vo.setBalAmt(info.getBalAmt());
		vo.setTranCode(log.getTranCode());
		vo.setTranDesc(log.getTranDesc());
		vo.setTranAmt(log.getTranAmt());
		vo.setTranStatus(AcctEnums.TranStatus.complete.getValue());
		vo.setTranTime(date);
		vo.setUserCode(info.getUserCode());
		vo.setUserid(info.getUserid());
		vo.setUserName(info.getUserName());
		vo.setYwCode(AcctEnums.YwCode.acct.getValue());
		vo.setCompanyId(info.getCompanyId());
		vo.setChannelId(log.getChannelId());
		vo.setOrgId(log.getOrgId());
		vo.setOrgName(log.getOrgName());
		vo.setOperatorCode(log.getOperatorCode());
		vo.setOperatorName(log.getOperatorName());
		vo.setSendAmt(log.getSendAmt());
		vo.setCashAmt(log.getCashAmt());
		vo.setOrderId(log.getOrderId());
		acctLogDao.save(vo);
		return result;
	}

}
