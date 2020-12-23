package com.marks.common.enums;

public class OrderEnums {

	public enum YwType {
		good("0", "商品订单"), // 系统用户
		service("1", "服务订单"), // 系统用户
		batch("2", "批发订单"), // 系统用户
		;// 会员

		private String status;
		private String name;

		private YwType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (YwType c : YwType.values()) {
				if (c.getValue().equals(status)) {
					return c.name;
				}
			}
			return "";
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return status;
		}
	}

	public enum CashType {
		consume("0", "消费"), // 系统用户
		refund("1", "退货"), // 系统用户
		recharge("2", "充值"), // 系统用户
		;// 会员

		private String status;
		private String name;

		private CashType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (CashType c : CashType.values()) {
				if (c.getValue().equals(status)) {
					return c.name;
				}
			}
			return "";
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return status;
		}
	}

	public enum OrderStatus {
		commit(1, "待付款"), // 系统用户
		payOk(2, "待收货"), // 系统用户
		complete(3, "已完成"), // 系统用户
		cancel(4, "已取消"), // 系统用户
		;// 会员

		private int status;
		private String name;

		private OrderStatus(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (OrderStatus c : OrderStatus.values()) {
				if (c.getValue() == status) {
					return c.name;
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

	public enum PayType {
		cash("cash", "现金"), // 系统用户
		;// 会员

		private String status;
		private String name;

		private PayType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (PayType c : PayType.values()) {
				if (c.getValue().equals(status)) {
					return c.name;
				}
			}
			return "";
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return status;
		}
	}
}
