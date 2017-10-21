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
			switch (status) {
			case 0: {
				return DairyUse.NOUSE.getName();
			}
			case 1: {
				return DairyUse.USE.getName();
			}
			default: {
				return "";
			}
			}
		}
	}
}
