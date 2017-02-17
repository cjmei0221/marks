/**
 * 文件名：GoodInfo.java
 * 创建日期： 2015-02-10
 * Copyright (c) 2015 运通信息
 * All rights reserved.
 * 修改记录：
 * 
 */
package com.marks.common.util;

import java.io.Serializable;



/**
 *  处理结果信息返回
 * @author lqing01e
 * 
 */
public class JsonResult implements Serializable{

    private Boolean success=true ;

    private String errorCode=SysCode.SUCCESS;

    private Object result;

    private String errorMsg;

    public JsonResult(){
        this.success = Boolean.TRUE;
    }


    public JsonResult(Boolean success, String errorMsg){
        this.success = success;
        this.errorMsg = errorMsg;
    }


    public JsonResult(Boolean success, String errorCode, String errorMsg){
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public String tolog(){
    	return success+"-"+errorCode+"-"+errorMsg+"-"+result.toString();
    }
}
