package com.marks.common.enums;

public class AssetEnums {

	public enum ItemType {
		type0("type0", "日常"), // 系统用户
		type1("type1", "服装"), //
		type2("type2", "电子产品"), //
		type3("type3", "化妆品"), //
		type4("type4", "读书"), //
		type5("type5", "话费"), //
		type6("type6", "出行"), //
		type7("type7", "工资"), //
		type8("type8", "差旅"), //
		type9("type9", "理财"), //
		type10("type10", "人情"), //
		type11("type100", "其他");// 会员

		private String status;
		private String name;

		private ItemType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (ItemType c : ItemType.values()) {
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
