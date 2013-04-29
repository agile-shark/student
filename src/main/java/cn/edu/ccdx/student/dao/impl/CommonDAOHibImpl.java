package cn.edu.ccdx.student.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.ccdx.student.dao.CommonDAO;
import cn.edu.ccdx.student.util.Pager;


/**
 * 
 * @author hongBing lin
 */
@Transactional
public class CommonDAOHibImpl extends PageDaoImpl implements CommonDAO {

	JdbcTemplate jdbcTemplate ;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Serializable save(Object o) {
		Serializable ret = super.getHibernateTemplate().save(o);
		return ret;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Object get(Class clazz, Serializable id) {
		Object ret = super.getHibernateTemplate().get(clazz, id);
		return ret;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public Object get(String sql, Class clazz) {
		try{
			Object ret = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(clazz));
			return ret;
		}catch (EmptyResultDataAccessException  e) {
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	public void delete(Class clazz, Serializable id) {
		super.getHibernateTemplate().delete(this.get(clazz, (Serializable) id));
	}
	

	public int delete(String sql) {
		int ret = this.jdbcTemplate.update(sql);
		return ret;
	}

	public void update(Object o) {
		super.getHibernateTemplate().update(o);
	}

	public void update(String sql) {
		this.jdbcTemplate.update(sql.toString());
	}
	
	public void update(String sql, Object[] args) {
		this.jdbcTemplate.update(sql.toString(), args);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List list(String hql) {
		List ret = super.getHibernateTemplate().find(hql);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public List list(String sql, Class clazz) {
		List ret = null;
		try {
			ret = (List) this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(clazz));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List list(String sql, String[] param, String[] param1,
			Class clazz) {
		List ret = super.getHibernateTemplate().findByNamedParam(sql, param,
				param1);

		return ret;
	}
	
	

	@SuppressWarnings("deprecation")
	public Object execProc(String procName) {
		Object ret = null;
		// Transaction tx = this.getSession().beginTransaction();
		/*String procedure = "{call " + procName + "() }";
		CallableStatement cstmt;
		try {
			Connection con = this.getSession().connection();
			cstmt = con.prepareCall(procedure);
			ret = cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return ret;
	}

	public int count(String hql) {
		int i = 0;
		i = this.list(hql).size();
		return i;
	}

	/******************************************************Pager start****************************************************/
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getCountItems(String sql) {
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*)  from (").append(sql).append(") d");
		//System.out.println("countSql---->"+countSql);
		int num = this.jdbcTemplate.queryForInt(countSql.toString());
		return num;
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int getSeqNextVals(String seqName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select" + seqName + ".nextval as nVal from dual");
		return this.jdbcTemplate.queryForInt(sql.toString());
	}

	/*
	 * oracle
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageOracle(String sql, Pager page, Class<?> listToType) {
		return pageOracleParams(sql, null, page, listToType);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageOracleParams(String sql, Object[] args, Pager page,
			Class<?> clazz) {
		int count = this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql = new StringBuilder();
		pageSql.append("select * from (select t.*, rownum counts from(")
				.append(sql).append(")t)");
		pageSql.append(" where counts between ");
		pageSql.append(page.getOffset()+1);
		pageSql.append(" and ");
		pageSql.append((page.getOffset() + page.getMaxPageItems()));
		List<?> list = this.jdbcTemplate.query(pageSql.toString(), args,
						new BeanPropertyRowMapper(clazz));
		return list;
	}


	/*
	 * mysql
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageMySql(String hql, Pager pager, Class<?> clazz) {
		return pageMySqlParams(hql, null, pager, clazz);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageMySqlParams(String sql, Object[] args, Pager page,
			Class<?> clazz) {

		StringBuilder countSql = new StringBuilder();
		countSql.append("select count(*) from (").append(sql).append(") as c");

		int count = 0;
		count = this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql = new StringBuilder();
		pageSql.append("select t.* from(").append(sql).append(") as t");
		pageSql.append(" limit ");
		pageSql.append(page.getOffset());
		pageSql.append(" , ");
		pageSql.append(page.getMaxPageItems());
		List<?> list = this.jdbcTemplate.query(pageSql.toString(), args,
						new BeanPropertyRowMapper(clazz));
		return list;
	}

	/**
	 * sql server
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageMsSql(String hql, Pager pager, Class<?> clazz, String orderItem) {
		return pageMsSqlParams(hql, null, pager, clazz, orderItem);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<?> pageMsSqlParams(String sql, Object[] args, Pager page,
			Class<?> clazz ,String orderItem) {

		StringBuilder countSql = new StringBuilder();
		countSql.append("select count(*) from (").append(sql).append(") as c");

		int count = 0;
		count = this.getCountItems(sql);
		page.setItems(count);
		StringBuilder pageSql = new StringBuilder();
		// count M
		int m = 0;
		if (page.getMaxPageNumber() == page.getNoncePage()) {
			m = page.getItems();
		} else {
			m = page.getNoncePage() * page.getMaxPageItems();
		}
		// count N
		int n = (page.getNoncePage() - 1) * page.getMaxPageItems() + 1;

		int start = m - n + 1;
		int end = n - 1;
		pageSql.append("select top ").append(start).append(" * from ( ");
		pageSql.append(sql).append(" ) t where ").append(orderItem).append(
				" not in (select top ").append(end).append(" ").append(
				orderItem);
		pageSql.append("  from (").append(sql).append(" ) tt order by ")
				.append(orderItem).append(" desc ) order by ");
		pageSql.append(orderItem).append(" desc");

		List<?> list = this.jdbcTemplate.query(pageSql.toString(), args,
						new BeanPropertyRowMapper(clazz));
		return list;
	}
	
}
