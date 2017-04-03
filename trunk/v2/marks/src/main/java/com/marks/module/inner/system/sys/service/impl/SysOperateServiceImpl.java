package com.marks.module.inner.system.sys.service.impl;

import java.util.List;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.inner.system.sys.dao.SysOperateDao;
import com.marks.module.inner.system.sys.pojo.SysOperate;
import com.marks.module.inner.system.sys.service.SysOperateService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class SysOperateServiceImpl implements SysOperateService{

	private SysOperateDao sysOperateDao;
	
	public void setSysOperateDao(SysOperateDao sysOperateDao) {
		this.sysOperateDao = sysOperateDao;
	}

	@Override
	public PojoDomain<SysOperate> list(int page_number, int page_size, String keyword) {
		PojoDomain<SysOperate> pojoDomain = new PojoDomain<SysOperate>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysOperate> list = sysOperateDao.list(pageBounds,keyword);
		PageList<SysOperate> pageList = (PageList<SysOperate>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void save(SysOperate info) {
		sysOperateDao.save(info);
	}

	@Override
	public SysOperate getObjectById(String operid) {
		return sysOperateDao.getObjectById(operid);
	}

	@Override
	public void update(SysOperate info) {
		sysOperateDao.update(info);
	}

	@Override
	public void delete(Result result, String id) {
		int num=sysOperateDao.countfunc(id);
		if(num>0){
			result.setCode("4002");
			result.setMessage("有菜单使用该功能按钮，不能删除");
		}else{
			sysOperateDao.delete(id);
		}
	}

}
