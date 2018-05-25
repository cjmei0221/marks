package com.marks.common.enums;

public class WorkEnums {

	public enum DealType {
		auto(0, "系统全权处理"), // 绑定
		self(1, "系统代为转发"), //
		dealSelf(2, "自行业务处理");// 未绑定

		private int status;
		private String name;

		private DealType(int status, String name) {
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
			for (DealType c : DealType.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}
}
