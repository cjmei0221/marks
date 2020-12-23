package com.marks.common.enums;

public class StockAdjustEnums {
	
	public enum TypeCode {
		typeCode_1("1", "调整单"), // 系统用户
		typeCode_2("2", "盘点单"), //
		typeCode_3("3", "报废单"), //
		;// 会员

		private String status;
		private String name;

		private TypeCode(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (TypeCode c : TypeCode.values()) {
				if (c.getValue().equals(status)) {
					return c.getName();
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

	/**
	 * 库存状态
	 * 
	 * @author cjmei
	 *
	 */
	public enum Status {
		init(0, "未处理"), //
		dealing(1, "处理中"), //
		part(2, "部分处理"), //
		end(3, "处理结束"), //
		;// 会员

		private int status;
		private String name;

		private Status(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (Status c : Status.values()) {
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
