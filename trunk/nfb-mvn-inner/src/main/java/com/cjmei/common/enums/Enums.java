package com.cjmei.common.enums;

/**
 * 枚举
 * @author lhyan3
 * 2015年2月5日上午10:46:04
 */
public class Enums {
	
	/**
	 * 机构类型
	 * @author cjmei
	 *
	 */
	public enum Shop{
		shop(0),//商铺
		company(1);//公司

		private int status;
		
		private Shop(int status){
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
