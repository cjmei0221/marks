package com.marks.module.work.base.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.Enums;
import com.marks.module.work.base.dao.WorkTypeDao;
import com.marks.module.work.base.dao.WorkTypeStepDao;
import com.marks.module.work.base.pojo.WorkType;
import com.marks.module.work.base.pojo.WorkTypeStep;
import com.marks.module.work.base.service.WorkTypeStepService;

@Service
@Transactional
public class WorkTypeStepServiceImpl implements WorkTypeStepService {
	@Autowired
	private WorkTypeDao workTypeDao;
	@Autowired
	private WorkTypeStepDao workTypeStepDao;

	/**
	 * private WorkTypeStepDao workTypeStepDao;
	 * 
	 * public WorkTypeStepDao getWorkTypeStepDao(){ return workTypeStepDao; }
	 * public void setWorkTypeStepDao(WorkTypeStepDao workTypeStepDao){
	 * this.workTypeStepDao =workTypeStepDao; }
	 * 
	 */
	/**
	 * 根据ID查找工作流步骤配置
	 */
	@Override
	public WorkTypeStep findById(String id) {
		return workTypeStepDao.findById(id);
	}

	/**
	 * 保存工作流步骤配置
	 */
	@Override
	public void save(WorkTypeStep info) {
		workTypeStepDao.save(info);
	}

	/**
	 * 更新工作流步骤配置
	 */
	@Override
	public void update(WorkTypeStep info) {
		workTypeStepDao.update(info);
	}

	/**
	 * 删除工作流步骤配置
	 */
	@Override
	public void delete(String id) {
		workTypeStepDao.delete(id);
	}

	/**
	 * 查找所有工作流步骤配置
	 */
	@Override
	public List<WorkTypeStep> findAll() {
		return workTypeStepDao.findAll();
	}

	/**
	 * 删除多个工作流步骤配置
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		workTypeStepDao.deleteBatch(ids);
	}

	public PojoDomain<WorkTypeStep> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WorkTypeStep> pojoDomain = new PojoDomain<WorkTypeStep>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkTypeStep> list = workTypeStepDao.list(pageBounds, param);
		List<WorkTypeStep> returnlist = new ArrayList<WorkTypeStep>();
		WorkTypeStep info = null;
		if (list == null) {
			list = new ArrayList<WorkTypeStep>();
		}
		if (list.size() > 0) {
			returnlist.addAll(list);
		}
		for (int i = 0; i < 10 - list.size(); i++) {
			info = new WorkTypeStep();
			returnlist.add(info);
		}
		pojoDomain.setPojolist(returnlist);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(returnlist.size());
		return pojoDomain;
	}

	@Override
	public void saveStep(String typeId, String status, String listArr) {
		WorkType type = workTypeDao.findById(typeId);
		if (type != null) {
			type.setStatus(Integer.parseInt(status));
			workTypeDao.update(type);
			workTypeStepDao.deleteByTypeId(typeId);
			String[] arr = listArr.split(",");
			if (null != arr && arr.length > 0) {
				List<WorkTypeStep> list = new ArrayList<WorkTypeStep>();
				WorkTypeStep info = null;
				int count = 0;
				for (int i = 0; i < arr.length; i++) {
					// 单个商品信息
					String[] infos = arr[i].split("#");
					if (null != infos && infos.length > 0) {
						count++;
						if (infos[0].length() > 0) {
							info = new WorkTypeStep();
							info.setCompanyId(type.getCompanyId());
							info.setRoleId(infos[0]);
							info.setStep(count);
							info.setStepId(type.getTypeId() + "_" + info.getStep());
							info.setStepName(infos[1]);
							info.setTypeId(type.getTypeId());
							info.setRoleName(infos[2]);
							list.add(info);
						}
					}
				}
				if (list.size() > 0) {
					list.get(list.size() - 1).setIsCheckOk(Enums.Status.Enable.getValue());
					workTypeStepDao.saveBatch(list);
				}
			}
		}
	}
}