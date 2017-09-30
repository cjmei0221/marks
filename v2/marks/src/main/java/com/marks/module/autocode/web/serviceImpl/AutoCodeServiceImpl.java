package com.marks.module.autocode.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.autocode.web.dao.AutoCodeDao;
import com.marks.module.autocode.web.pojo.AutoCode;
import com.marks.module.autocode.web.pojo.AutoCodeAttr;
import com.marks.module.autocode.web.service.AutoCodeService;

@Service
public class AutoCodeServiceImpl implements AutoCodeService {
	@Autowired
	private AutoCodeDao autoCodeDao;

	/**
	 * 根据ID查找自动生成代码记录
	 */
	@Override
	public AutoCode findById(String tableName) {
		return autoCodeDao.findById(tableName);
	}

	/**
	 * 保存自动生成代码记录
	 */
	@Override
	public void save(AutoCode autoCode, String attrList) {
		autoCodeDao.save(autoCode);
		saveAttr(autoCode.getTableName(), attrList);
	}

	/**
	 * 更新自动生成代码记录
	 */
	@Override
	public void update(AutoCode autoCode, String attrList) {
		autoCodeDao.update(autoCode);
		saveAttr(autoCode.getTableName(), attrList);
	}

	private void saveAttr(String tableName, String attrList) {
		// 关联商品数组
		autoCodeDao.deleteAttr(tableName);
		String[] goods = attrList.split(",");
		AutoCodeAttr info = null;
		if (null != goods && goods.length > 0) {
			List<AutoCodeAttr> list = new ArrayList<AutoCodeAttr>();
			for (int i = 0; i < goods.length; i++) {

				// 单个商品信息
				String[] infos = goods[i].split("#");

				if (null != infos && infos.length > 0) {
					if (infos[0].length() > 0) {
						info = new AutoCodeAttr();
						info.setAttrDesc(infos[3]);
						info.setAttrName(infos[0].trim());
						info.setAttrSize(Integer.parseInt(infos[2]));
						info.setAttrType(infos[1]);
						info.setTableName(tableName);
						info.setSort(i);
						if (infos.length > 4) {
							info.setNote(infos[4]);
						}
						info.setIsQuery(infos[5]);
						list.add(info);

					}
				}

			}
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					AutoCodeAttr vo = list.get(i);
					if (i == 0) {
						vo.setIsPK(1);
					} else {
						vo.setIsPK(0);
					}
					// 保存促销商品
					autoCodeDao.saveAttr(vo);
				}
			}
		}
	}

	/**
	 * 删除自动生成代码记录
	 */
	@Override
	public void delete(String tableName) {
		autoCodeDao.delete(tableName);
		autoCodeDao.deleteAttr(tableName);
	}

	/**
	 * 查找所有自动生成代码记录
	 */
	@Override
	public List<AutoCode> findAll() {
		return autoCodeDao.findAll();
	}

	/**
	 * 删除多个自动生成代码记录
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		autoCodeDao.deleteBatch(ids);
	}

	public PojoDomain<AutoCode> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<AutoCode> pojoDomain = new PojoDomain<AutoCode>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AutoCode> list = autoCodeDao.list(pageBounds, param);
		PageList<AutoCode> pageList = (PageList<AutoCode>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public PojoDomain<AutoCodeAttr> attrList(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<AutoCodeAttr> pojoDomain = new PojoDomain<AutoCodeAttr>();
		List<AutoCodeAttr> list = autoCodeDao.attrList(param);
		List<AutoCodeAttr> returnlist = new ArrayList<AutoCodeAttr>();
		AutoCodeAttr info = null;
		if (list == null || (list != null && list.size() == 0)) {
			list = new ArrayList<AutoCodeAttr>();
			info = new AutoCodeAttr();
			info.setIsPK(1);
			list.add(info);
		}
		if (list.size() > 0) {
			returnlist.addAll(list);
		}

		for (int i = 0; i < 200 - list.size(); i++) {
			info = new AutoCodeAttr();
			returnlist.add(info);
		}
		pojoDomain.setPojolist(returnlist);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(returnlist.size());
		return pojoDomain;
	}

	@Override
	public AutoCode findDetailById(String tableName) {
		AutoCode info = autoCodeDao.findById(tableName);
		if (info != null) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tableName", tableName);
			List<AutoCodeAttr> list = autoCodeDao.attrList(param);
			info.setAttrList(list);
			return info;
		}
		return null;
	}

}