package com.springcar.app.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaQuery;

import com.springcar.app.models.entity.AbstractEntity;

public interface GenericDao {

	<E extends AbstractEntity> E create(final E model);
	
	<E extends AbstractEntity> E update(final E model);
	
	<E extends AbstractEntity> void delete(final E model);
	
	<E extends AbstractEntity> E getById(final Class<E> modelClass, final Serializable id);
	
	<E extends AbstractEntity> void deleteById(final Class<E> modelClass, final Serializable id);
	
	<E extends AbstractEntity> List<E>  getAll(final Class<E> model);
	<E extends AbstractEntity> List<E> getResultByNativeQuery(final String queryName, Map<String, Object> parameters, String name);
	List<Object> getResultByNativeQuery(final String queryName, Map<String, Object> parameters);
	<E extends AbstractEntity> List<E> getResultByNativeQuery(final String queryName, Map<String, Object> parameters, Class<E> objectType);
	public <E extends AbstractEntity> List < Map < String, Object >> getNativeQueryResultInMap(String queryName, Class<E> objectType);
	<E extends AbstractEntity> void executeNativeQuery(final String queryName, Map<String, Object> parameters);
	/**
	 * Update using named query
	 * @param queryName
	 * @param parameters
	 * @return
	 */
	int updateByNamedQuery(String queryName, Map<String,Object> parameters);

	<E  extends AbstractEntity> List<E> getResultByNamedQuery(Class<E> objectType, String queryName, Map<String, Object> parameters);
	public <E extends AbstractEntity> Map<String, Object> callNamedStoredProcedure(String callerName, 
			Map<String, Object> parameters, Map<String, Object> outputParameters);
	
	void executeUpdate(final String queryName, Map<String, Object> parameters);
	
	List<Map<String, Object>> getQueryResultAsMap(String nativeQuery);
	
}
