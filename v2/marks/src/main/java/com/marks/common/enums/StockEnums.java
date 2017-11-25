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
			for (StockStatus c : StockStatus.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
}
