package com.marks.common.enums;

public class ChannelEnums {

	public enum Channel {
		manage("manage", "管理端"), //
		web("web", "前端"), //
		mobile("mobile", "手机端"), //
		;// 会员

		private String status;
		private String name;

		private Channel(String status, String name) {
			this.status = status;
			this.name = name;
		}

		public static String getByKey(String status) {
			for (Channel c : Channel.values()) {
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
