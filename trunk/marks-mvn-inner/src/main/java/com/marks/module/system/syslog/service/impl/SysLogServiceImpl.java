package com.marks.module.system.syslog.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.sys.dao.SysLogDao;
import com.marks.module.system.sys.pojo.SysLog;
import com.marks.module.system.syslog.service.SysLogService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class SysLogServiceImpl implements SysLogService{
   

    private SysLogDao sysLogDao;

    public SysLogDao getSysLogDao(){
        return sysLogDao;
    }
    public void setSysLogDao(SysLogDao sysLogDao){
        this.sysLogDao =sysLogDao;
    }
	
	public PojoDomain<SysLog> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<SysLog> pojoDomain = new PojoDomain<SysLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysLog> list = sysLogDao.list(pageBounds,param);
		PageList<SysLog> pageList = (PageList<SysLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}