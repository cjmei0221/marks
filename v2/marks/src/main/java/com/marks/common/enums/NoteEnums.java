package com.marks.common.enums;

public class NoteEnums {

	/**
	 * 用户类型
	 * 
	 * @author cjmei
	 *
	 */
	public enum DairyUse {
		USE(1, "启用"), // 系统用户
		NOUSE(0, "禁用");// 会员

		private int status;
		private String name;

		private DairyUse(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public String toString() {
			return String.valueOf(status);
		}

		public int getValue() {
			return status;
		}

		public String getName() {
			return name;
		}

		public static String getByKey(int status) {
			for (DairyUse c : DairyUse.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}
}
