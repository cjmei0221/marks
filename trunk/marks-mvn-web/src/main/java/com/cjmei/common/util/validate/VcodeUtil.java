package com.cjmei.common.util.validate;

import javax.servlet.http.HttpServletRequest;

public class VcodeUtil {

	public static VcodeUtil util=null;
	private VcodeUtil(){}
	public static VcodeUtil getInstance(){
		if(util==null){
			util=new VcodeUtil();
		}
		return util;
	}
	
	public boolean checkValidateCode(HttpServletRequest request,String code) {
		boolean flag=false;
		String has=request.getSession().getAttribute("vCode").toString();
		if(code.equalsIgnoreCase(has)){
			flag=true;
		}
		return flag;
	}
	public void setValidateCode(HttpServletRequest request,String code) {
		request.getSession().setAttribute("vCode", code);  
	}
}