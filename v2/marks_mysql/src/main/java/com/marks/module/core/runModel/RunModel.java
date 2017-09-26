package com.marks.module.core.runModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.marks.module.core.util.WebPropsUtil;

public class RunModel {
	private String run_mode = WebPropsUtil.getProperty("runModul");// 与行方对接 N：测试
																	// Y:对接
	private String weixin_mode = WebPropsUtil.getProperty("weixinMode");// 与微信对接
																		// N：测试
																		// Y:对接
	private String run_companyId = WebPropsUtil.getProperty("run_companyId");// 与微信对接
																				// N：测试
																				// Y:对接
	private String run_wxaccountId = WebPropsUtil.getProperty("run_wxaccountId");// 与微信对接
																					// N：测试
																					// Y:对接
	private static RunModel util = null;

	public static RunModel getInstance() {
		if (util == null) {
			util = new RunModel();
		}
		return util;
	}

	public String getMode() {
		return this.run_mode;
	}

	public String getWeixinMode() {
		return this.weixin_mode;
	}

	public String getCompanyId() {
		return run_companyId;
	}

	public String getWxAccountId() {
		return run_wxaccountId;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
		System.out.println(list);
		// 打乱顺序
		Collections.shuffle(list);
		Object[] arr = list.toArray();
		System.out.println(list);
		for (Object str : arr) {
			System.out.print(str + " ");
		}
	}
}