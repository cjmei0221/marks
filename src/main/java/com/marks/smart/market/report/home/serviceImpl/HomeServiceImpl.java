package com.marks.smart.market.report.home.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.market.report.home.dao.HomeDao;
import com.marks.smart.market.report.home.pojo.CoreData;
import com.marks.smart.market.report.home.pojo.SalesData;
import com.marks.smart.market.report.home.service.HomeService;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;

	@Override
	public CoreData getCoreData(Map<String, Object> param) {
		CoreData info = new CoreData();
		CoreData income = homeDao.getIncome(param);
		if (income != null) {
			info.setIncomeAmt(MoneyUtil.format(income.getIncomeAmt()));
			info.setCostAmt(MoneyUtil.format(income.getCostAmt()));
			info.setProfitAmt(MoneyUtil.subtract(info.getIncomeAmt(), info.getCostAmt()));
		}
		CoreData consume = homeDao.getConsume(param);
		if (consume != null) {
			info.setConsumeCashAmt(MoneyUtil.format(consume.getConsumeCashAmt()));
			info.setConsumeCostAmt(MoneyUtil.format(consume.getConsumeCostAmt()));
			info.setConsumeProfixAmt(MoneyUtil.subtract(info.getConsumeCashAmt(), info.getConsumeCostAmt()));
		}
		return info;
	}

	@Override
	public List<SalesData> getSalesForDate(Map<String, Object> param) {
		return homeDao.getSalesForDate(param);
	}

	@Override
	public List<SalesData> getSalesForSeason(Map<String, Object> param) {
		return homeDao.getSalesForSeason(param);
	}

	@Override
	public List<SalesData> getSalesForMonth(Map<String, Object> param) {
		return homeDao.getSalesForMonth(param);
	}


}
