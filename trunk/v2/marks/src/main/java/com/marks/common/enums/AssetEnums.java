package com.marks.common.enums;

public class AssetEnums {

	public enum ItemType {
		type0("type0", "日常"), // 系统用户
		type1("type1", "服装"), //
		type2("type2", "电子产品"), //
		type3("type3", "化妆品"), //
		type4("type4", "读书");// 会员

		private String status;
		private String name;

		private ItemType(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			switch (status) {
			case "type0": {
				return ItemType.type0.getName();
			}
			case "type1": {
				return ItemType.type1.getName();
			}
			case "type2": {
				return ItemType.type2.getName();
			}
			case "type3": {
				return ItemType.type3.getName();
			}
			case "type4": {
				return ItemType.type4.getName();
			}
			default: {
				return "";
			}
			}
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return status;
		}
	}
}
