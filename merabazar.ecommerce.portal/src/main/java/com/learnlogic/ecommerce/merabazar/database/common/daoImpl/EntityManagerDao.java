package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;

import java.io.Serializable;
import java.util.List;

//import javax.persistence.EntityManager;



import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.learnlogic.ecommerce.merabazar.database.common.dao.GenericDao;

public class EntityManagerDao<EntityType, IDType extends Serializable>extends HibernateDaoSupport implements GenericDao<EntityType, IDType> {

//	private HibernateTemplate hibernateTemplate;
	
	 private Class<EntityType> persistentClass ;
	
	
//	public Class<EntityType> getEntity() {
//		return this.entity=entity;
//	}
//	public HibernateTemplate getHibernateTemplate() {
//		return this.hibernateTemplate;
//	}

	    /**
	     * get the persistent class
	     * @return
	     */
	    public Class<EntityType> getPersistentClass() {
	        return persistentClass;
	    }

	
	public EntityType retrieveById(IDType id) {
		// TODO Auto-generated method stub
		return (EntityType) getHibernateTemplate().get(getPersistentClass(), id);
	}	

	@SuppressWarnings("unchecked")
	public IDType create(EntityType entity) {
		// TODO Auto-generated method stub
		return (IDType) getHibernateTemplate().save(entity);
	}

	public void createOrUpdate(EntityType entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(EntityType entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(EntityType entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(IDType id) {
		// TODO Auto-generated method stub
		
	}

	public List<EntityType> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findAll(String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findFiltered(String property, Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findFiltered(String property, Object filter,
			String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findLikeFiltered(String property, Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findLikeFiltered(String property, Object filter,
			String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityType findUniqueFiltered(String property, Object filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityType findUniqueFiltered(String property, Object filter,
			String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findByCriteria(Criterion... criterion) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findByCriteriaList(List<Criterion> criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntityType> findByCriteriaList(List<Criterion> criterions,
			Boolean isSearch) {
		// TODO Auto-generated method stub
		return null;
	} 

}
