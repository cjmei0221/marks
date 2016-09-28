package com.cjmei.module.system.sys.service.impl;

import com.cjmei.module.system.sys.dao.SysLogDao;
import com.cjmei.module.system.sys.service.SysLogService;
/**
 * 系统日志接口实现类
 * File Name: com.grgbanking.inner.service.impl.SysLogServiceImpl.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月26日上午11:50:19
 * @see (optional) 
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
 */
public class SysLogServiceImpl implements SysLogService{

	private SysLogDao sysLogDao;

	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
	
	
}
