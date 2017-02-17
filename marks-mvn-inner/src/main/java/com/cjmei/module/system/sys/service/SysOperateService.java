package com.cjmei.module.system.sys.service;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.module.system.sys.pojo.SysOperate;

public interface SysOperateService {

	void save(SysOperate info);

	SysOperate getObjectById(String operid);

	void update(SysOperate info);

	void delete(Result result, String id);

	PojoDomain<SysOperate> list(int page_number, int page_size, String keyword);

}
