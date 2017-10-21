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
			switch (status) {
			case 1: {
				return GoodImgType.Main.getName();
			}
			case 2: {
				return GoodImgType.Detail.getName();
			}
			default: {
				return "";
			}
			}
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
			switch (status) {
			case 1: {
				return GoodOnsale.onsale.getName();
			}
			case 2: {
				return GoodOnsale.init.getName();
			}
			case 3: {
				return GoodOnsale.shelves.getName();
			}
			default: {
				return "";
			}
			}
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
}
