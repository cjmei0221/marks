package com.marks.common.enums;

public class StockEnums {

	public enum StockStatus {
		stockIn(1, "入库"), // 系统用户
		stockOut(2, "出库"), transferIn(3, "转入"), transferOut(4, "转出"),;// 会员

		private int status;
		private String name;

		private StockStatus(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			switch (status) {
			case 1: {
				return StockStatus.stockIn.getName();
			}
			case 2: {
				return StockStatus.stockOut.getName();
			}
			case 3: {
				return StockStatus.transferIn.getName();
			}
			case 4: {
				return StockStatus.transferOut.getName();
			}
			default: {
				return "";
			}
			}
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
}
