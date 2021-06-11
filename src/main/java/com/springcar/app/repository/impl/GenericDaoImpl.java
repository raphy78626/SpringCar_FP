package com.springcar.app.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcar.app.models.entity.AbstractEntity;
import com.springcar.app.repository.GenericDao;

@Repository("genericDao")
@Transactional
public class GenericDaoImpl implements GenericDao {
	
	
	private final static Logger LOG = LogManager.getLogger(GenericDaoImpl.class.getName());
	
	static class CaseInsensitiveAliasToEntityMapResultTransformer extends AliasedTupleSubsetResultTransformer{
		
		public static final CaseInsensitiveAliasToEntityMapResultTransformer INSTANCE = new CaseInsensitiveAliasToEntityMapResultTransformer();
		private CaseInsensitiveAliasToEntityMapResultTransformer() {
			
		}
		
		private static final long serialVersionUID = 1L;
		@Override
		public Object transformTuple(Object[] tuple, String[] aliases) {
			Map<String, Object> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
			for ( int i=0; i<tuple.length; i++ ) {
				String alias = aliases[i];
				if ( alias!=null ) {
					result.put( alias.toLowerCase(), tuple[i] );
				}
			}
			return result;
		}
		@Override
		public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
			return false;
		}

	}

	

	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public <E extends AbstractEntity> E create(E model) {
		entityManager.persist(model);
		return model;
	}

	@Override
	public <E extends AbstractEntity> E update(E model) {
		model = entityManager.merge(model);
		entityManager.flush();
		return model;
	}

	@Override
	public <E extends AbstractEntity> void delete(E model) {
		 entityManager.remove(model);

	}

	@Override
	public <E extends AbstractEntity> E getById(Class<E> modelClass, Serializable id) {
			return entityManager.find(modelClass, id);
	}

	@Override
	public <E extends AbstractEntity> void deleteById(Class<E> modelClass, Serializable id) {
		final E entity = getById(modelClass,id);
		entityManager.remove(entity);

	}

	@Override
	public <E extends AbstractEntity> List<E> getAll(Class<E> model) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(model);
		criteriaQuery.from(model);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public <E extends AbstractEntity> Map<String, Object> callNamedStoredProcedure(String callerName, 
			Map<String, Object> parameters, Map<String, Object> outputParameters){
		StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery(callerName);
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				storedProcedure.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		storedProcedure.execute();
		if(outputParameters != null) {
			for(final Entry<String,Object> parameter : outputParameters.entrySet()) {
				outputParameters.put(parameter.getKey(), storedProcedure.getOutputParameterValue(parameter.getKey()));
			}
		}
		return  outputParameters;
	}
	
	@Override
	public int updateByNamedQuery(String queryName, Map<String, Object> parameters) {
		final Query query = entityManager.createNamedQuery(queryName); 
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		return query.executeUpdate();
	}

	
	
	@Override
	public <E extends AbstractEntity> List<E> getResultByNamedQuery(final Class<E> objectType, String queryName, Map<String, Object> parameters) {
		final TypedQuery<E> query = entityManager.createNamedQuery(queryName,objectType); 
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		/**
		 * Found shared references to a collection org.hibernate.HibernateException

		 */
		entityManager.clear();
		return query.getResultList();
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public <E extends AbstractEntity> List < Map < String, Object >> getNativeQueryResultInMap(String queryName, final Class<E> objectType) {
		final Query query = entityManager.createNativeQuery(queryName, objectType);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List < Map < String, Object >> result = query.getResultList();
		for (Map map: result) {
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	@Override
	public  List<Object> getResultByNativeQuery(String queryName, 
			Map<String, Object> parameters) {
		final Query query  = entityManager.createNativeQuery(queryName);

		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		return query.getResultList();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public <E extends AbstractEntity> List<E> getResultByNativeQuery(String queryName, 
			Map<String, Object> parameters, String name) {
		/**
		 * At least when using Hibernate 4.x and 5.x because the JPA StoredProcedureQuery does not work for SQL FUNCTIONS.
		 */
		final Query query  = entityManager.createNativeQuery(queryName, name);
		
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		return query.getResultList();
	}
	
	@Override
	public <E extends AbstractEntity> void executeNativeQuery(String queryName, Map<String, Object> parameters) {
		/**
		 * At least when using Hibernate 4.x and 5.x because the JPA StoredProcedureQuery does not work for SQL FUNCTIONS.
		 */
		final Query query  = entityManager.createNativeQuery(queryName);
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		query.getSingleResult();
//		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends AbstractEntity> List<E> getResultByNativeQuery(String queryName, Map<String, Object> parameters,
			Class<E> objectType) {
		/**
		 * At least when using Hibernate 4.x and 5.x because the JPA StoredProcedureQuery does not work for SQL FUNCTIONS.
		 */
		final Query query  = entityManager.createNativeQuery(queryName, objectType);
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public  void executeUpdate(String queryName, Map<String, Object> parameters) {
		final Query query  = entityManager.createNativeQuery(queryName);
		if(parameters != null) {
			for(final Entry<String,Object> parameter : parameters.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
		}
		int update = query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getQueryResultAsMap(String nativeQueryStr) {
		final Query query = entityManager.createNativeQuery(nativeQueryStr);
		NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
		nativeQuery.setResultTransformer(CaseInsensitiveAliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> result = (List<Map<String, Object>>) nativeQuery.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findAllColumns(String table) {
		Query query = entityManager.createNativeQuery("DESCRIBE " + table);
		List<Object[]> list = null;
				
		try {
			list = (List<Object[]>) query.getResultList();
		}
		catch(Exception e) {
			LOG.error("Problem describing the table {} {}", table, e);
		}
		List<String> collect = list.stream().map( arr -> {
			return String.valueOf(arr[0]);
		}).collect(Collectors.toList());
		return collect;
	}
}
