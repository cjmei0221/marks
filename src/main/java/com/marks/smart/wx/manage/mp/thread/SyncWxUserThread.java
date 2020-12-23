package com.marks.smart.wx.manage.mp.thread;

import java.util.List;

import com.marks.smart.wx.api.mp.wxInteface.user.entity.UserGet;
import com.marks.smart.wx.manage.mp.util.WxMpUtil;

public class SyncWxUserThread implements Runnable {

	private String accountId;

	public SyncWxUserThread(String accountId) {
		this.accountId = accountId;
	}
	@Override
	public void run() {
		try {
			String next_openid = "";
			UserGet ug = WxMpUtil.getInstance().getWXUserOpenId(accountId, next_openid);
			if (ug != null) {
				saveWxUser(ug.getOpenid_list());
				next_openid = ug.getNext_openid();
				int total = ug.getTotal();
				int pageNum = total % ug.getCount() > 0 ? total / ug.getCount() + 1 : total / ug.getCount();
				pageNum = pageNum - 1;
				if (pageNum > 0) {
					for (int i = 0; i < pageNum; i++) {
						ug = WxMpUtil.getInstance().getWXUserOpenId(accountId, next_openid);
						next_openid = ug.getNext_openid();
						saveWxUser(ug.getOpenid_list());
					}
				}
			}
		} catch (Exception e) {

		}
	}

	public void saveWxUser(List<String> list) {
		int size = 300;
		int endLen = list.size() / size;
		if (list.size() % size > 0) {
			endLen = endLen + 1;
		}

		for (int i = 0; i < endLen; i++) {
			List<String> saveList = null;
			if (i == endLen - 1) {
				saveList = list.subList(i * size, list.size());
			} else {
				saveList = list.subList(i * size, (i + 1) * 300);
			}
			new Thread(new WxUserThread(accountId, saveList)).start();

		}
	}

}
