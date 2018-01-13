package com.marks.module.wx.manage.serviceImpl.template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.cache.CacheData;
import com.marks.module.quartz.wx.thread.pool.WxModuleMsgThreadPool;
import com.marks.module.wx.manage.dao.template.ModuleMsgDao;
import com.marks.module.wx.manage.entity.template.ModuleMsg;
import com.marks.module.wx.manage.service.template.ModuleMsgService;

@Service
public class ModuleMsgServiceImpl implements ModuleMsgService {
	@Autowired
	private ModuleMsgDao moduleMsgDao;

	/**
	 * 根据ID查找模板消息
	 */
	@Override
	public ModuleMsg findById(String id) {
		return moduleMsgDao.findById(id);
	}

	/**
	 * 保存模板消息
	 */
	@Override
	public void save(ModuleMsg moduleMsg) {
		moduleMsgDao.save(moduleMsg);
	}

	/**
	 * 更新模板消息
	 */
	@Override
	public void update(ModuleMsg moduleMsg) {
		moduleMsgDao.update(moduleMsg);
	}

	/**
	 * 删除模板消息
	 */
	@Override
	public void delete(String id) {
		moduleMsgDao.delete(id);
	}

	/**
	 * 查找所有模板消息
	 */
	@Override
	public List<ModuleMsg> findAll() {
		return moduleMsgDao.findAll();
	}

	/**
	 * 删除多个模板消息
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		moduleMsgDao.deleteBatch(ids);
	}

	public PojoDomain<ModuleMsg> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<ModuleMsg> pojoDomain = new PojoDomain<ModuleMsg>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<ModuleMsg> list = moduleMsgDao.list(pageBounds, param);
		PageList<ModuleMsg> pageList = (PageList<ModuleMsg>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void clearData() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String clear_modulemsg_data_str = CacheData.getSysConf("clear_modulemsg_data");
		int clearNum=30;
		if(null !=clear_modulemsg_data_str && !"".equals(clear_modulemsg_data_str)){
			clearNum=Integer.parseInt(clear_modulemsg_data_str);
		}
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_MONTH, -clearNum);
		moduleMsgDao.deleteData(sdf.format(today.getTime()));
	}

	@Override
	public void pustWxbModuleMsg() {
		int limitnum = 1000;// 一次扫描的记录条数
		String limitStr = CacheData.getSysConf("wx_modulemsg_scan_limitnum");
		if (null != limitStr && !"".equals(limitStr)) {
			limitnum = Integer.parseInt(limitStr);
		}
		int pushlimitnum = 3;// 一条记录推送次数
		String pushlimitnumStr = CacheData.getSysConf("wx_modulemsg_push_limitnum");
		if (null != pushlimitnumStr && !"".equals(pushlimitnumStr)) {
			pushlimitnum = Integer.parseInt(pushlimitnumStr);
		}
		int timelimit = 60;// 时间限制 默认60分钟
		String timelimitStr = CacheData.getSysConf("wx_modulemsg_time_limit");
		if (null != timelimitStr && !"".equals(timelimitStr)) {
			timelimit = Integer.parseInt(timelimitStr);
		}
		long nowtime = System.currentTimeMillis() / 1000;
		// logger.info("pustWxbModuleMsg params> limitnum:"+limitnum +" -
		// pushlimitnum:"+pushlimitnum+" - timelimit:"+timelimit+"-
		// nowtime:"+nowtime);
		List<ModuleMsg> list = moduleMsgDao.getNeedPustMsg(limitnum, pushlimitnum, timelimit * 60, nowtime);
		if (null != list && list.size() > 0) {
			for (ModuleMsg msg : list) {
				WxModuleMsgThreadPool.pushModuleMsg(msg);
			}
		}
	}

	@Override
	public void updateResultForModuleMsg(String accountId, String msgID, String time, String status) {
		String resultCode="0";
		if(status.indexOf("success")>=0){
			resultCode="1";
		}
		moduleMsgDao.updateResultForModuleMsg(accountId,msgID,time,resultCode,status);
	}
	
	
}