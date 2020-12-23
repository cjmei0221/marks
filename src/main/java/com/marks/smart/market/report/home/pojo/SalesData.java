package com.marks.smart.market.report.home.pojo;

import com.marks.common.util.number.MoneyUtil;

public class SalesData {

	private String xAxis;// 销售日期

	private int salesNums;// 销售日期

	private String salesAmt;// 销售日期

	private String costAmt;// 销售日期

	private String profitAmt;// 销售日期

	public String getProfitAmt() {
		return MoneyUtil.subtract(this.getSalesAmt(), getCostAmt());
	}


	public String getCostAmt() {
		return MoneyUtil.format(costAmt);
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public int getSalesNums() {
		return salesNums;
	}

	public void setSalesNums(int salesNums) {
		this.salesNums = salesNums;
	}

	public String getSalesAmt() {
		return MoneyUtil.format(salesAmt);
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}

}
