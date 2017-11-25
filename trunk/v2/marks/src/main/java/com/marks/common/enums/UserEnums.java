package com.marks.common.enums;

public class UserEnums {

	public enum BindFlag {
		bind(1, "绑定"), // 绑定
		unbind(0, "未绑定");// 未绑定

		private int status;
		private String name;

		private BindFlag(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}

		public static String getByKey(int status) {
			for (BindFlag c : BindFlag.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}

	public enum ActiveFlag {
		use(1, "启用"), // 绑定
		unuse(0, "禁用");// 未绑定

		private int status;
		private String name;

		private ActiveFlag(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}

		public static String getByKey(int status) {
			for (ActiveFlag c : ActiveFlag.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}

	public enum UserType {
		SYS("SYS", "系统用户"), // 系统用户
		VIP("VIP", "会员");// 会员

		private String status;
		private String name;

		private UserType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return status;
		}

		public static String getByKey(String status) {
			for (UserType c : UserType.values()) {
				if (c.getValue().equals(status)) {
					return c.getName();
				}
			}
			return "";
		}
	}
}
