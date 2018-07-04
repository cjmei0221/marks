package com.marks.common.enums;

public class StockEnums {

	/**
	 * 库存状态
	 * 
	 * @author cjmei
	 *
	 */
	public enum StockStatus {
		stockIn(1, "入库"), // 系统用户
		stockOut(2, "出库"), //
		;// 会员

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

	public enum GoodType {
		good(0, "正品"), // 系统用户
		gift(1, "赠品"), //
		second(2, "次品"), //
		scrap(3, "废品"), //
		;// 会员

		private int status;
		private String name;

		private GoodType(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (GoodType c : GoodType.values()) {
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

	public enum YwCode {
		cg_stockIn(10, "采购入库"), //
		sale_stockOut(11, "售卖出库"), //
		refund_stockIn(12, "退货入库"), //
		dh_stockIn(20, "调货入库"), //
		dh_stockOut(21, "调货出库"), //
		dz_stockIn(30, "调整入库"), //
		dz_stockOut(31, "调整出库"), //
		;// 会员

		private int status;
		private String name;

		private YwCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (YwCode c : YwCode.values()) {
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

	public enum StockManageType {
		simple(0, "一瓶一码"), // 系统用户
		nums(1, "数量管理"), //
		;// 会员

		private int status;
		private String name;

		private StockManageType(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (StockManageType c : StockManageType.values()) {
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

	public enum OperateCode {
		barCode(1, "条码日志"), //
		batch(0, "批次日志"), //
		;// 会员

		private int status;
		private String name;

		private OperateCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (OperateCode c : OperateCode.values()) {
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
