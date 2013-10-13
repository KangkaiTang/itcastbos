package com.kk.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kk.bos.dao.IGenericDao;

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


}
