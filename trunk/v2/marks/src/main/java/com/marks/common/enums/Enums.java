package com.marks.common.enums;

/**
 * 枚举
 * @author lhyan3
 * 2015年2月5日上午10:46:04
 */
public class Enums {
	/**
	 * 系统用户启禁用
	 * @author marks
	 *
	 */
	public enum SysUserBindFlag{
		USE(1),//绑定
		NOUSE(0);//未绑定

		private int status;
		
		private SysUserBindFlag(int status){
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
	 * 系统用户启禁用
	 * @author cjmei
	 *
	 */
	public enum OrgType{
		company(1),//公司
		common(0);//普通

		private int status;
		
		private OrgType(int status){
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
	 * 系统用户启禁用
	 * @author cjmei
	 *
	 */
	
	public enum SysUserUse{
		USE(1),//系统用户
		NOUSE(0);//会员

		private int status;
		
		private SysUserUse(int status){
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
