package com.marks.smart.market.mall.order.thread;

import java.util.HashMap;
import java.util.Map;

import com.marks.common.enums.SalesEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.market.mall.order.pojo.OrderInfo;
import com.marks.smart.market.project.sales.pojo.SalesForm;
import com.marks.smart.market.project.sales.pojo.SalesInfo;
import com.marks.smart.market.project.sales.service.SalesInfoService;

public class SalesThread implements Runnable {

	private OrderInfo info;
	private SalesInfoService salesInfoService;

	public SalesThread(OrderInfo info) {
		this.info = info;
	}

	@Override
	public void run() {
		try {
			if (salesInfoService == null) {
				salesInfoService = SpringContextHolder.getBean(SalesInfoService.class);
			}
			Thread.sleep(3000);
			Map<String, String> params = new HashMap<String, String>();
			params.put("companyId", info.getCompanyId());
			params.put("ywCode", SalesEnums.YwCode.coupon.toString());
			params.put("sceneCode", SalesEnums.SceneCode.buy.toString());
			SalesInfo sales = salesInfoService.findActiveSalesInfo(params);
			if (sales == null) {
				return;
			}
			if(!MoneyUtil.compare(info.getPayAmt(), sales.getPushLimit())) {
				return;
			}
			SalesForm form=new SalesForm();
			form.setIdName(info.getRemarks());
			form.setIdNo(info.getOrderId());
			form.setRemarks("购买赠送");
			form.setUserId(info.getVipId());
			form.setBatchId(IDUtil.getNumID());
			salesInfoService.saveDetail(form,sales);
		} catch (InterruptedException e) {

		}

	}

}
