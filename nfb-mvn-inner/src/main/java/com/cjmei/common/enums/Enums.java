package com.cjmei.common.enums;

/**
 * 枚举
 * @author lhyan3
 * 2015年2月5日上午10:46:04
 */
public class Enums {
	
	/**
	 * 用户类型
	 * @author cjmei
	 *
	 */
	public enum DairyUse{
		USE(1),//系统用户
		NOUSE(0);//会员

		private int status;
		
		private DairyUse(int status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public int getValue(){
			return status;
		}
	}
	
	/**
	 * 用户类型
	 * @author cjmei
	 *
	 */
	public enum UserType{
		SYS("SYS"),//系统用户
		VIP("VIP");//会员

		private String status;
		
		private UserType(String status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public String getValue(){
			return status;
		}
	}
	
	
	public enum GoodImgType{
		Main(1),//系统用户
		Detail(2);//会员

		private int status;
		
		private GoodImgType(int status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public int getValue(){
			return status;
		}
	}
	
	public enum GoodOnsale{
		onsale(1),//系统用户
		init(2),
		shelves(3);//会员

		private int status;
		
		private GoodOnsale(int status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public int getValue(){
			return status;
		}
	}
}
