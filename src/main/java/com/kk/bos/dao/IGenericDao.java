package com.kk.bos.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Standard;

public interface IGenericDao<T> {
	
	public void save(T obj);
	
	public void update(T obj);
	
	public void delete(T obj);
	
	public List<T> listAll();
	
	public T findById(Serializable id);
	
	public List<T> findByNamedQuery(String queryName, Object... values);
	
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);

	//public List findByCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults);
	
	public void saveOrUpdate(T obj);

	public List<T> pageQuery(DetachedCriteria detachedCriteria,
			int firstResult, int maxResults);
	
	public Page queryByLucene(String conditionName, String conditionValue, Page page);

	
}
