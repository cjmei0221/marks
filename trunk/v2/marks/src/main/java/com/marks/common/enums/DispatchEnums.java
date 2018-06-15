package com.marks.common.enums;

public class DispatchEnums {

	/**
	 * 
	 * 
	 * @author cjmei
	 *
	 */
	public enum YwCode {
		ywCode_cg("1", "采购单"), // 系统用户
		ywCode_dh("2", "调货单"), //
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

	public enum TypeCode {
		cg_apply("1", "申请采购"), // 系统用户
		cg_receive("2", "采购收货"), //
		cg_refund("3", "采购退货"), //
		dh_apply("11", "申请调货"), // 系统用户
		dh_receive("12", "调货收货"), //
		dh_refund("13", "调货退货"), //
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
