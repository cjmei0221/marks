package com.cjmei.module.system.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 基础dao实现类
 * @ClassName: BaseDaoImpl
 * @Description:
 * @author ykai5
 * @date 
 */
public class BaseDaoImpl<T> implements BaseDao<T> {    

	@Autowired 
	private SqlSession session;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		try {
			entityClass =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch(Exception e) {}
	}
	
	public SqlSession getSession() {
		return session;
	}
	
	/** 
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. 
     *  
     *@param clazz 
     *            clazz The class to introspect 
     * @param index 
     *            the Index of the generic ddeclaration,start from 0. 
     * @return the index generic declaration, or Object.class if cannot be 
     *         determined 
     */  
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {  
          
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = clazz.getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
           return Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if (index >= params.length || index < 0) {  
                     return Object.class;  
        }  
        if (!(params[index] instanceof Class)) {  
              return Object.class;  
        }  
  
        return (Class) params[index];  
    }  

	
	/**
	 * 生成sqlkey
	 * sqlkey规则=实体类的全限定名+"."+key
	 * @param key
	 * @return
	 */
	public String sqlkey(String key) {
		if(entityClass == null){
			entityClass = (Class<T>) getSuperClassGenricType(getClass(), 0);
		}
		return new StringBuilder().append(entityClass.getName()).append(".").append(key).toString();
	}
	/**
	 * 生成一个uuid
	 * @return
	 */
	public String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
//	/**
//	 * 为实体类设置uuid值
//	 * @param po
//	 */
//	public void setId(T po) {
//		if(po instanceof Pojo) {
//			((Pojo)po).setId(uuid());
//		}
//	}
	
	public void save(T po) {
//		setId(po);
		getSession().insert(sqlkey("save"), po);
	}
	
	public void update(T po) {
		getSession().update(sqlkey("update"), po);
	}
	
	@SuppressWarnings("unchecked")
	public T findById(String id) {
		return (T) getSession().selectOne(sqlkey("findById"), id);
	}
	
	public void delete(String id) {
		getSession().delete(sqlkey("delete"), id);
	}
	
	/**
	 * 查找所有记录
	 */
	public List<T> findAll() {
		return getSession().selectList(sqlkey("findAll"));
	}

	//删除多个对象
	public void deleteBatch(List<String> ids){
		getSession().delete(sqlkey("deleteBatch"), ids);
	}
	
	//查询
	public List<T> findObjectsByParam(Map<String, Object> objectMap){
		return getSession().selectList(sqlkey("findObjectsByParam"), objectMap);
	}
}
