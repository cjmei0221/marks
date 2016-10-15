package com.cjmei.module.system.mybatis.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础dao接口
 * @ClassName: BaseDao
 * @Description:
 * @author ykai5
 * @date 
 */
public interface BaseDao<T> {

	public T findById(String id);
	public void save(T po);
	public void update(T po);
	public void delete(String id);
	public List<T> findAll();
	//删除多个对象
	public void deleteBatch(List<String> ids);
	//查询
	public List<T> findObjectsByParam(Map<String, Object> objectMap);
}
