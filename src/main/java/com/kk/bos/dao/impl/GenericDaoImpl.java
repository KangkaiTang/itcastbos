package com.kk.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.impl.FullTextSessionImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kk.bos.dao.IGenericDao;
import com.kk.bos.domain.Page;

public class GenericDaoImpl<T> extends HibernateDaoSupport implements IGenericDao<T>{

	private String className;
	
	public GenericDaoImpl(String className) {
		this.className = className;
	}
	
	@Override
	public void save(T obj) {
		this.getHibernateTemplate().save(obj);
	}

	@Override
	public void update(T obj) {
		this.getHibernateTemplate().update(obj);
	}

	@Override
	public void delete(T obj) {
		this.getHibernateTemplate().delete(obj);
	}

	@Override
	public List<T> listAll() {
		return this.getHibernateTemplate().find("from "+ className);
	}

	@Override
	public T findById(Serializable id) {
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... values) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	@Override
	public void saveOrUpdate(T obj) {
		this.getHibernateTemplate().saveOrUpdate(obj);
	}

	@Override
	public List<T> pageQuery(DetachedCriteria detachedCriteria,
			int firstResult, int maxResults) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
	}
	
	
	public Page queryByLucene(String conditionName, String conditionValue, Page page) {
		//1.session
		Session session = this.getSession();
		//2. 全文检索session
		FullTextSession fullTextSession = new FullTextSessionImpl(session);
		//3. lucene query对象
		Query query = new WildcardQuery(new Term(conditionName, "*" + conditionValue + "*"));
		//4. 全文检索Query
		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query);
		
		//total
		page.setTotal(fullTextQuery.getResultSize());
		
		//rows
		int firstResult = (page.getPageNum() -1) * page.getRowPerPage();
		int maxResults = page.getRowPerPage();
		
		List rows = fullTextQuery.setFirstResult(firstResult).setMaxResults(maxResults).list();
		page.setRows(rows);
		
		return page;
	}


}
