package com.marks.common.enums;

public class OrgEnums {

	public enum OrgCategory {
		supplier(2, "供应商"), //
		organization(0, "组织"), //
		company(1, "公司"), //
		;// 普通

		private int status;
		private String name;

		private OrgCategory(int status, String name) {
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
			for (OrgCategory c : OrgCategory.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}
	/**
	 * 系统用户启禁用
	 * 
	 * @author cjmei
	 *
	 */
	public enum OrgType {
		storehouse(4, "仓库"), // 公司
		shop(5, "门店"), // 公司
		supplier(2, "供应商"), // 公司
		company(1, "公司"), // 公司
		dept(3, "部门"), //
		;// 普通

		private int status;
		private String name;

		private OrgType(int status, String name) {
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
			for (OrgType c : OrgType.values()) {
				if (c.getValue() == status) {
					return c.getName();
				}
			}
			return "";
		}
	}
}
