package cn.edu.ccdx.student.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.ccdx.student.util.Pager;

@Transactional

public class PageDaoImpl extends HibernateDaoSupport{
	DataSource dataSource;
	@Override
	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {
		dataSource = SessionFactoryUtils.getDataSource(sessionFactory);
		return super.createHibernateTemplate(sessionFactory);
	}
	//????????????????为什么要用JdbcTemplate模板，不是直接用spring注入就可以了吗？
	public SimpleJdbcTemplate simpleJdbcTemplate;
	public void setDataSource(DataSource dataSource){
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	//使用了Spring的事务的传播行为，Not_SUPPORTED:以非事务方式执行，如果存在就将事务挂起
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getCountItems(String sql){
		StringBuffer countSql=new StringBuffer();
		countSql.append("select count(*)  from (").append(sql).append(") d");
		int num = new SimpleJdbcTemplate(dataSource).getJdbcOperations().queryForInt(countSql.toString());
		return num;
	}
	
	/*
	 * oracle
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListOracle(String sql,Pager page,Class<?> listToType)
	{
		return getPageListOracle(sql,null,page,listToType);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListOracle(String sql, Object[] args, Pager page,
			Class<?> listToType) {
		int count= this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql=new StringBuilder();
		//select * from (select t.*,rownum counts from(sql) t) where counts between index and last
		pageSql.append("select * from (select t.*, rownum counts from(").append(sql).append(")t)");
		pageSql.append(" where counts between ");
		pageSql.append(page.getOffset());
		pageSql.append(" and ");
		pageSql.append((page.getOffset()+page.getMaxPageItems()-1));
		List<?> list = new SimpleJdbcTemplate(dataSource).getJdbcOperations().query(pageSql.toString(),args,new BeanPropertyRowMapper(listToType));
		return list;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Map<String,Object>> getPageMapOracle(String sql, Pager page){
		return this.getPageMapOracle(sql, null, page);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Map<String,Object>> getPageMapOracle(String sql, Object[] args, Pager page){
		int count= this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql=new StringBuilder();
		pageSql.append("select * from (select t.*, rownum counts from(").append(sql).append(")t)");
		pageSql.append(" where counts between ");
		pageSql.append(page.getOffset());
		pageSql.append(" and ");
		pageSql.append((page.getOffset()+page.getMaxPageItems()-1));
		List<Map<String,Object>> list = new SimpleJdbcTemplate(dataSource).queryForList(sql.toString(), args);
		return list;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getSeqNextVals(String seqName) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT "+seqName+".Nextval as nVal FROM DUAL");
		return new SimpleJdbcTemplate(dataSource).getJdbcOperations().queryForInt(sql.toString());
	}
	
	
	public void updateWhere(String sql){
		new SimpleJdbcTemplate(dataSource).update(sql.toString());
	}
	public void updateWhere(String sql,Object[] args){
		new SimpleJdbcTemplate(dataSource).update(sql.toString(),args);
	}
	/*
	 * mysql
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListMysql(String sql,Pager page,Class<?> listToType)
	{
		return getPageListMysql(sql,null,page,listToType);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListMysql(String sql, Object[] args, Pager page,
			Class<?> listToType) {

		StringBuilder countSql=new StringBuilder();
		countSql.append("select count(*) from (").append(sql).append(") as c");
		
		int count=0;
		count=this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql=new StringBuilder();
		pageSql.append("select t.* from(").append(sql).append(") as t");
		pageSql.append(" limit ");
		pageSql.append(page.getOffset());
		pageSql.append(" , ");
		pageSql.append(page.getMaxPageItems());
		//System.out.println("page--:"+pageSql.toString());
		List<?> list = new SimpleJdbcTemplate(dataSource).getJdbcOperations().query(pageSql.toString(),args,new BeanPropertyRowMapper(listToType));
		return list;
	}
	
	/**
	 * sql server
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListMsSql(String sql,Pager page,Class<?> listToType,String orderItem)
	{
		return getPageListMsSql(sql,null,page,listToType,orderItem);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> getPageListMsSql(String sql, Object[] args, Pager page,
			Class<?> listToType,String orderItem) {

		StringBuilder countSql=new StringBuilder();
		countSql.append("select count(*) from (").append(sql).append(") as c");
		
		int count=0;
		count=this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql=new StringBuilder();
		//count M
		int m = 0;
		if(page.getMaxPageNumber()==page.getNoncePage()){
			m=page.getItems();
		}else{
			m=page.getNoncePage()*page.getMaxPageItems();
		}
		//count N
		int n=(page.getNoncePage()-1)*page.getMaxPageItems()+1;
		
		int start = m-n+1;
		int end = n-1;
		pageSql.append("Select Top ").append(start).append(" * from ( ");
		pageSql.append(sql).append(" ) t where ").append(orderItem).append(" not in (Select Top ").append(end).append(" ").append(orderItem);
		pageSql.append("  from (").append(sql).append(" ) tt order by ").append(orderItem).append(" desc ) order by ");
		pageSql.append(orderItem).append(" desc");
		
		
		//System.out.println("page ms sql--:"+pageSql.toString());
		List<?> list = new SimpleJdbcTemplate(dataSource).getJdbcOperations().query(pageSql.toString(),args,new BeanPropertyRowMapper(listToType));
		return list;
	}
}
