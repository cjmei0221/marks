package com.marks.common.enums;

public class AcctEnums {

	public enum YwCode {
		point("0", "积分"), //
		acct("1", "储值"), //
		;// 会员

		private String status;
		private String name;

		private YwCode(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (YwCode c : YwCode.values()) {
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

	public enum TranCode {
		less("0", "消费"), //
		add("1", "增加"), //
		loss("2", "失效"), //
		;// 会员

		private String status;
		private String name;

		private TranCode(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (TranCode c : TranCode.values()) {
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

	public enum TranStatus {
		init(0, "未完成"), //
		complete(1, "完成"), //
		;// 会员

		private int status;
		private String name;

		private TranStatus(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (TranStatus c : TranStatus.values()) {
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
}
