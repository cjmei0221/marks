package com.marks.module.inner.system.sys.service;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.inner.system.sys.pojo.SysOperate;

public interface SysOperateService {

	void save(SysOperate info);

	SysOperate getObjectById(String operid);

	void update(SysOperate info);

	void delete(Result result, String id);

	PojoDomain<SysOperate> list(int page_number, int page_size, String keyword);

}