package com.marks.smart.system.user.sysuser.thread;

import java.util.List;

import com.marks.smart.system.user.sysuser.pojo.SysUserExcel;

public class UserThread implements Runnable {

	private List<SysUserExcel> infoList;

	public UserThread(List<SysUserExcel> infoList) {
		this.infoList = infoList;
	}

	@Override
	public void run() {

	}

}
