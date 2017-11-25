package com.marks.module.asset.base.pojo;

import com.marks.common.util.number.MoneyUtil;

public class AssetLogCount {

	private String itemName;

	private String outAmount;// 支出

	private String inAmount;// 收入

	private String diff;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(String outAmount) {
		this.outAmount = outAmount;
	}

	public String getInAmount() {
		return inAmount;
	}

	public void setInAmount(String inAmount) {
		this.inAmount = inAmount;
	}

	public String getDiff() {
		return MoneyUtil.subtract(this.getInAmount(), this.getOutAmount());
	}

}
