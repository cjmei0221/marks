package com.marks.common.enums;

/**
 * 枚举
 * 
 * @author lhyan3 2015年2月5日上午10:46:04
 */
public class GoodEnums {

	public enum GoodImgType {
		Main(1, "主图"), // 系统用户
		Detail(2, "详图");// 会员

		private int status;
		private String name;

		private GoodImgType(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (GoodImgType c : GoodImgType.values()) {
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

	public enum GoodOnsale {
		onsale(1, "上架"), // 系统用户
		init(2, "下架"), shelves(3, "下架");// 会员

		private int status;
		private String name;

		private GoodOnsale(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (GoodOnsale c : GoodOnsale.values()) {
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

	public enum GoodTagType {
		brand(0, "品牌"), // 系统用户
		priceGroup(1, "价格段");// 会员

		private int status;
		private String name;

		private GoodTagType(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (GoodTagType c : GoodTagType.values()) {
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

	public enum MaterialType {
		good_actual(0, "普通商品"), // 系统用户
		good_virtual(1, "服务项目"), //
		good_clothing(2, "服装商品"),;// 会员

		private int status;
		private String name;

		private MaterialType(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (MaterialType c : MaterialType.values()) {
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
