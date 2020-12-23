package com.marks.smart.system.work.info.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.Enums;
import com.marks.common.enums.WorkEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.system.user.sysrole.dao.SysRoleDao;
import com.marks.smart.system.user.sysrole.pojo.SysRole;
import com.marks.smart.system.user.sysuser.dao.SysUserDao;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.work.base.dao.WorkTypeDao;
import com.marks.smart.system.work.base.dao.WorkTypeStepDao;
import com.marks.smart.system.work.base.pojo.WorkType;
import com.marks.smart.system.work.base.pojo.WorkTypeStep;
import com.marks.smart.system.work.info.dao.WorkInfoDao;
import com.marks.smart.system.work.info.dao.WorkStepDao;
import com.marks.smart.system.work.info.pojo.WorkFlow;
import com.marks.smart.system.work.info.pojo.WorkInfo;
import com.marks.smart.system.work.info.pojo.WorkStep;
import com.marks.smart.system.work.info.service.CheckService;
import com.marks.smart.system.work.info.service.WorkInfoService;

@Service
@Transactional
public class WorkInfoServiceImpl implements WorkInfoService {

	@Autowired
	private WorkInfoDao workInfoDao;
	@Autowired
	private WorkTypeDao workTypeDao;
	@Autowired
	private WorkTypeStepDao workTypeStepDao;
	@Autowired
	private WorkStepDao workStepDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * private WorkInfoDao workInfoDao;
	 * 
	 * public WorkInfoDao getWorkInfoDao(){ return workInfoDao; } public void
	 * setWorkInfoDao(WorkInfoDao workInfoDao){ this.workInfoDao =workInfoDao; }
	 * 
	 */
	/**
	 * 根据ID查找工作流查询
	 */
	@Override
	public WorkInfo findById(String id) {
		return workInfoDao.findById(id);
	}
	
	

	@Override
	public boolean check(String companyId, String typeCode) {
		WorkType type = workTypeDao.findById(companyId + "_" + typeCode);
		if (null == type) {
			return false;
		}
		if (type.getStatus() == Enums.Status.Unable.getValue()) {
			return false;
		}
		List<WorkTypeStep> list = workTypeStepDao.listByTypeId(type.getTypeId());
		if (null == list || (list != null && list.size() == 0)) {
			return false;
		}
		return true;
	}



	/**
	 * 保存工作流查询
	 */
	@Override
	public boolean save(WorkFlow flow) {
		WorkType type = workTypeDao.findById(flow.getCompanyId() + "_" + flow.getTypeCode());
		if (null == type) {
			return false;
		}
		if (type.getStatus() == Enums.Status.Unable.getValue()) {
			return false;
		}
		List<WorkTypeStep> list = workTypeStepDao.listByTypeId(type.getTypeId());
		if (null == list || (list != null && list.size() == 0)) {
			return false;
		}
		WorkInfo info = new WorkInfo();
		info.setDealModel(type.getIsAuto());
		info.setApplyMan(flow.getApplyMan());
		info.setApplyManId(flow.getApplyManId());
		info.setCompanyId(flow.getCompanyId());
		info.setTypeCode(flow.getTypeCode());
		info.setIdNo(flow.getIdNo());
		info.setIdName(flow.getRemarks());
		WorkTypeStep typeStep = list.get(0);
		info.setCompanyId(type.getCompanyId());
		info.setCurrRoleid(flow.getApplyRoleId());
		info.setCurrRolename(flow.getApplyRoleName());
		info.setCurrUserid(flow.getApplyManId());
		info.setCurrUsername(flow.getApplyMan());
		info.setOperatorStatus(Enums.CheckStatus.checking.getValue());
		info.setNextStep(typeStep.getStep());
		info.setNextStepId(typeStep.getStepId());
		info.setNextStepName(typeStep.getStepName());
		info.setTypeCode(type.getTypeCode());
		info.setTypeName(type.getTypeName());
		info.setWorkId(IDUtil.getProjectCode());
		info.setApplyOrgId(flow.getApplyOrgId());
		info.setApplyOrgName(flow.getApplyOrgName());
		info.setApplyMan(flow.getApplyMan());

		info.setNextRoleid(typeStep.getRoleId());
		// 同级职位
		if ("1".equals(typeStep.getDealType())) {
			SysUser user = sysUserDao.findByUserid(info.getCurrUserid());
			info.setNextRoleid(user.getOrgId() +"_"+ typeStep.getRoleId().split("_")[1]);
		} else if ("2".equals(typeStep.getDealType())) {
			SysUser user = sysUserDao.findByUserid(info.getCurrUserid());
			info.setNextRoleid(user.getParentOrgId()  +"_"+ typeStep.getRoleId().split("_")[1]);
		}
		SysRole role = sysRoleDao.findById(info.getNextRoleid());
		info.setNextRolename(role.getShowName());
		info.setNextUserid("");
		info.setNextUsername("");
		info.setNextDealType(Integer.parseInt(typeStep.getDealType()));
		info.setPageUrl(
				type.getLinkUrl() + "?idNo=" + info.getIdNo() + "&workId=" + info.getWorkId() + "&formStatus=check");
		workInfoDao.save(info);
		WorkStep step = new WorkStep();
		step.setCompanyId(type.getCompanyId());
		step.setEndTime(DateUtil.getCurrDateStr());
		step.setOperateStatus(Enums.CheckStatus.noCheck.getValue());
		step.setOperatorId(info.getApplyManId());
		step.setOperatorName(flow.getApplyMan());
		step.setOperatorOrgId(flow.getApplyOrgId());
		step.setOperatorOrgName(flow.getApplyOrgName());
		step.setRemarks("申请审核");
		step.setRoleId(flow.getApplyRoleId());
		step.setRoleName(flow.getApplyRoleName());
		step.setStep(0);
		step.setStepId(info.getWorkId() + "_" + step.getStep());
		step.setStepName("申请");
		step.setWrokId(info.getWorkId());
		workStepDao.save(step);
		noticeNextCheckMan(info);
		return true;
	}

	/**
	 * 审核
	 */
	@Override
	public void saveWorkStep(WorkStep info) {
		WorkInfo work = workInfoDao.findById(info.getWrokId());
		work.setCurrRoleid(info.getRoleId());
		work.setCurrRolename(info.getRoleName());
		work.setCurrUserid(info.getOperatorId());
		work.setCurrUsername(info.getOperatorName());
		info.setStep(work.getNextStep());
		info.setStepId(work.getNextStepId());
		info.setStepName(work.getNextStepName());
		info.setStepId(work.getWorkId() + "_" + info.getStep());
		WorkTypeStep currStep = workTypeStepDao.findById(work.getNextStepId());
		int next = work.getNextStep() + 1;
		WorkTypeStep nextStep = workTypeStepDao.findById(work.getCompanyId() + "_" + work.getTypeCode() + "_" + next);

		if (null != nextStep) {
			currStep.setIsCheckOk(Enums.Status.Unable.getValue());
			work.setNextRoleid(nextStep.getRoleId());
			work.setNextRolename(nextStep.getRoleName());
			work.setNextStep(next);
			work.setNextStepId(nextStep.getStepId());
			work.setNextStepName(nextStep.getStepName());
			// 同级职位
			if ("1".equals(nextStep.getDealType())) {
				work.setNextRoleid(info.getOperatorOrgId() + "_" + nextStep.getRoleId().split("_")[1]);
			} else if ("2".equals(nextStep.getDealType())) {
				work.setNextRoleid(info.getParentOrgId() + "_" + nextStep.getRoleId().split("_")[1]);
			}
			SysRole role = sysRoleDao.findById(work.getNextRoleid());
			work.setNextRolename(role.getShowName());
		} else {
			currStep.setIsCheckOk(Enums.Status.Enable.getValue());
			work.setNextRoleid("");
			work.setNextRolename("");
			work.setNextStep(0);
			work.setNextStepId("");
			work.setNextStepName("");
		}
		work.setUpdatetime(DateUtil.getCurrDateStr());
		work.setOperatorStatus(Enums.CheckStatus.checking.getValue());
		if (Enums.Status.Enable.getValue() == currStep.getIsCheckOk()) {
			if (Enums.CheckStatus.checkOk.getValue() == info.getOperateStatus()) {
				work.setOperatorStatus(Enums.CheckStatus.checkOk.getValue());
			} else {
				work.setOperatorStatus(Enums.CheckStatus.checkFail.getValue());
			}
		} 
		workInfoDao.update(work);
		workStepDao.save(info);
		// 审核流程结束
		if (Enums.Status.Enable.getValue() == currStep.getIsCheckOk()) {
			WorkType type = workTypeDao.findById(work.getCompanyId() + "_" + work.getTypeCode());
			Map<String, String> params = new HashMap<String, String>();
			params.put("idNo", work.getIdNo());
			params.put("checkerId", info.getOperatorId());
			params.put("checker", info.getOperatorName());
			params.put("remarks", info.getRemarks());
			params.put("companyId", info.getCompanyId());
			params.put("checkStatus", String.valueOf(work.getOperatorStatus()));
			type.setChecker(info.getOperatorName());
			type.setCheckerId(info.getOperatorId());
			type.setIdNo(work.getIdNo());
			type.setCheckStatus(work.getOperatorStatus());
			
			if (WorkEnums.DealType.auto.getValue() == type.getIsAuto()) {
				workInfoDao.updateCheck(type);
			} else if (WorkEnums.DealType.self.getValue() == type.getIsAuto()) {
				CheckService service = SpringContextHolder.getBean(type.getClassType());
				service.approveNotice(params);
			}
			noticeRepMan(work, info);
			return;
		}
		// 继续审核
		noticeNextCheckMan(work);
	}
	
	@Override
	public void updateTargetCheckStatus(WorkFlow work, Map<String, String> params) {
		WorkType type = workTypeDao.findById(work.getCompanyId() + "_" + work.getTypeCode());
		if(null != type) {
			int checkStatus=Integer.parseInt(params.get("checkStatus"));
			type.setChecker(params.get("checker"));
			type.setCheckerId(params.get("checkerId"));
			type.setIdNo(params.get("idNo"));
			type.setCheckStatus(checkStatus);
			if (WorkEnums.DealType.auto.getValue() == type.getIsAuto()) {
				workInfoDao.updateCheck(type);
			} else if (WorkEnums.DealType.self.getValue() == type.getIsAuto()) {
				CheckService service = SpringContextHolder.getBean(type.getClassType());
				service.approveNotice(params);
			}
		}
	}

	/**
	 * 通知审核人去审核
	 * 
	 * @param work
	 */
	private void noticeNextCheckMan(WorkInfo work) {
		// TODO Auto-generated method stub

	}

	/**
	 * 通知请求人
	 * 
	 * @param work
	 * @param info
	 */
	private void noticeRepMan(WorkInfo work, WorkStep info) {
		// TODO Auto-generated method stub

	}




	public PojoDomain<WorkInfo> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WorkInfo> pojoDomain = new PojoDomain<WorkInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkInfo> list = workInfoDao.list(pageBounds, param);
		PageList<WorkInfo> pageList = (PageList<WorkInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public PojoDomain<WorkInfo> listByUserId(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<WorkInfo> pojoDomain = new PojoDomain<WorkInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<WorkInfo> list = workInfoDao.listByUserId(pageBounds, param);
		PageList<WorkInfo> pageList = (PageList<WorkInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
}