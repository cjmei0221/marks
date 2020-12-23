package com.marks.smart.system.work.info.service;

import java.util.Map;

public interface CheckService {
	/**
	 * 审核通知
	 * @param params
	 */
	public void approveNotice(Map<String, String> params);
	
}