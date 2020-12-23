package com.marks.common.enums;

public class SalesEnums {

	public enum YwCode {
		coupon(0, "优惠券方案"), //
		redpackets(10, "奖励红包方案"), //
		games(30, "游戏方案"), //
		goodSales(20 ,"商品促销方案"), //
		;// 会员

		private int status;
		private String name;

		private YwCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (YwCode c : YwCode.values()) {
				if (c.getValue()==status) {
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

		@Override
		public String toString() {
			return String.valueOf(status);
		}
	}

	public enum TypeCode {
		coupon_amt(0, "现金券"), //
		coupon_discount(1, "折扣券"), //
		goodSales_order(20, "订单满减"), //
		goodSales_good_single(21, "单品折扣"), //
		goodSales_good_nums(22, "商品满赠"), //
		goodSales_brand_nums(23, "品牌满赠"), //
		goodSales_type_nums(24, "品类满赠"), //
		;// 会员

		private int status;
		private String name;

		private TypeCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (TypeCode c : TypeCode.values()) {
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

		@Override
		public String toString() {
			return String.valueOf(status);
		}
		
	}

	public enum SceneCode {
		default0(0, "主动领取"), //
		birthday(1, "生日赠送"), //
		buy(2, "购买赠送"), //
		;// 会员

		private int status;
		private String name;

		private SceneCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (SceneCode c : SceneCode.values()) {
				if (c.getValue() == status) {
					return c.name;
				}
			}
			return "";
		}

		@Override
		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
	
	public enum DetailStatus {
		init(0, ""), //
		no_use(1, "未使用"), //
		had_use(2, "已使用"), //
		lose(2, "已失效"), //
		;// 会员

		private int status;
		private String name;

		private DetailStatus(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (DetailStatus c : DetailStatus.values()) {
				if (c.getValue() == status) {
					return c.name;
				}
			}
			return "";
		}

		@Override
		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
	public enum ItemTypeCode {
		init(0, ""), //
		coupon(1, "优惠券"), //
		redpackets(2, "红包"), //
		play(3, "游戏"), //
		goodSales(4, "商品优惠"), //
		discount(5, "折扣"), //
		send(6, "赠送"), //
		less(7, "免减"), //
		;// 会员

		private int status;
		private String name;

		private ItemTypeCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (ItemTypeCode c : ItemTypeCode.values()) {
				if (c.getValue() == status) {
					return c.name;
				}
			}
			return "";
		}

		@Override
		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
	
	public enum AwardTypeCode {
		init(0, ""), //
		coupon(1, "优惠券"), //
		redpackets(2, "红包"), //
		discount(5, "折扣"), //
		send(6, "赠送"), //
		less(7, "免减"), //
		;// 会员

		private int status;
		private String name;

		private AwardTypeCode(int status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(int status) {
			for (AwardTypeCode c : AwardTypeCode.values()) {
				if (c.getValue() == status) {
					return c.name;
				}
			}
			return "";
		}

		@Override
		public String toString() {
			return String.valueOf(status);
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return status;
		}
	}
}
