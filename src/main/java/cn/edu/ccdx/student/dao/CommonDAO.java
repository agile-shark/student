package cn.edu.ccdx.student.dao;


import java.io.Serializable;
import java.util.List;

import cn.edu.ccdx.student.util.Pager;

/**
 * @see 可以看到，到处都使用了Serializable接口，目的是实现序列化，即可以支持多用户同时访问。
 * @author 梁永星
 * 以后记着自己写程序的时候要用到此方法
 */
public interface CommonDAO {

	public Serializable save(Object o);
	
	//删除、修改和更新分别用了对象和sql语句的方式进行更新，为以后实现方便提供了便利
	@SuppressWarnings("unchecked")
	public Object get(Class clazz, Serializable id);

	@SuppressWarnings("unchecked")
	public Object get(String sql, Class clazz);
	

	@SuppressWarnings("unchecked")
	public void delete(Class clazz, Serializable id);
	
	public int delete(String sql);
	

	public void update(Object o);
	
	public void update(String sql);

	public void update(String sql, Object[] args);
	

	public List<?> list(String hql);
	
	@SuppressWarnings("unchecked")
	public List<?> list(String sql, Class clazz);//为什么需要加这个Class类呢？

	@SuppressWarnings("unchecked")
	public List<?> list(String hql, String[] param, String[] param1,Class clazz);


	public Object execProc(String procName);
	

	public int count(String hql);
	

	public List<?> pageOracle(String hql, Pager pager, Class<?> clazz);

	public List<?> pageOracleParams(String hql,Object[] args, Pager pager, Class<?> clazz);

	public List<?> pageMySql(String hql, Pager pager, Class<?> clazz);
	
	public List<?> pageMySqlParams(String hql,Object[] args, Pager pager, Class<?> clazz);

	public List<?> pageMsSql(String hql, Pager pager, Class<?> clazz,String orderItem);
	
	public List<?> pageMsSqlParams(String hql,Object[] args, Pager pager, Class<?> clazz, String orderItem);

}
