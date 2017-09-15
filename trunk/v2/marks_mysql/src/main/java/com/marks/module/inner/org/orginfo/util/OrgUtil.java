package com.marks.module.inner.org.orginfo.util;

import com.marks.common.enums.Enums;
import com.marks.module.inner.org.orginfo.pojo.OrgInfo;
import com.marks.module.sys.data.StaticData;

public class OrgUtil {

	public static OrgUtil util = null;

	private OrgUtil() {
	}

	public static OrgUtil getInstance() {
		if (util == null) {
			util = new OrgUtil();
		}
		return util;
	}

	public String getOrgFullName(String orgid) {
		String format = "-";
		String name = "";
		// 一级
		OrgInfo info = StaticData.getOrgInfo(orgid);
		name = format + info.getOrgname() + name;
		if (Enums.OrgType.company.getValue()==info.getOrgType()) {
			return name.substring(format.length());
		}
		// 二级
		info = StaticData.getOrgInfo(info.getParentId());
		name = format + info.getOrgname() + name;
		if ("0".equals(info.getParentId())) {
			return name.substring(format.length());
		}
		// 三级
		info = StaticData.getOrgInfo(info.getParentId());
		name = format + info.getOrgname() + name;
		if ("0".equals(info.getParentId())) {
			return name.substring(format.length());
		}
		// 四级
		info = StaticData.getOrgInfo(info.getParentId());
		name = format + info.getOrgname() + name;
		if ("0".equals(info.getParentId())) {
			return name.substring(format.length());
		}
		// 五级
		info = StaticData.getOrgInfo(info.getParentId());
		name = format + info.getOrgname() + name;
		if ("0".equals(info.getParentId())) {
			return name.substring(format.length());
		}
		return name.toString();
	}
}
