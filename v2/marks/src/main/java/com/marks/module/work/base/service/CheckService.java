package com.marks.module.work.base.service;


import java.util.Map;

public interface CheckService{

	public void approveOk(Map<String, String> params);

	public void approveFail(Map<String, String> params);
}