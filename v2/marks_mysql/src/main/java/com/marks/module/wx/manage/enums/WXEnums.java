package com.marks.module.wx.manage.enums;

public class WXEnums {
	/**
	 * 回话类型
	 * @author marks
	 *
	 */
	public enum SessionType{
		PEOPLE(1),//系统用户
		AUTO(0);//会员

		private int status;
		
		private SessionType(int status){
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
	 * 回话类型
	 * @author ReqType
	 *
	 */
	public enum ReqType{
		ask(0),//询问
		replay(1);//回复

		private int status;
		
		private ReqType(int status){
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
