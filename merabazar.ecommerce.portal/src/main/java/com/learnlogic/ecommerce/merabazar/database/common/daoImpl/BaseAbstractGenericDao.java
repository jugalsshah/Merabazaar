package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.lang.reflect.*;

import com.learnlogic.ecommerce.merabazar.database.common.dao.GenericDao;

//public class BaseAbstractDao {
	
	public abstract class BaseAbstractGenericDao<EntityType, IDType extends Serializable> extends HibernateDaoSupport implements GenericDao<EntityType, IDType> {

		
		
		 private Class<EntityType> persistentClass = (Class<EntityType>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		    
		    @Autowired
		    @Qualifier("sessionFactorySocialStudent")
		    private void setSessionFactorySocialStudent(SessionFactory sessionFactory) {
		        this.setSessionFactory(sessionFactory);
		    }

		    /**
		     * get the persistent class
		     * @return
		     */
		    public Class<EntityType> getPersistentClass() {
		        return persistentClass;
		    }

		    /**
		     * Retrive entity by id
		     * @param id of type IDType
		     * @return Object of type EntityType
		     */
		    public EntityType retrieveById(IDType id) {
		        return (EntityType) getHibernateTemplate().get(getPersistentClass(), id);
		    }

		    /**
		     * save the created entity
		     * @param entity of type EntityType
		     * @return Object of type IDType
		     */
		    public IDType create(EntityType entity) {
		        System.out.println("\n\t---> "+getHibernateTemplate());
		        return (IDType) getHibernateTemplate().save(entity);
		    }

		    /**
		     * Save Or Update Entity
		     * @param entity of type EntityType
		     *
		     */
		    public void createOrUpdate(EntityType entity) {
		        getHibernateTemplate().merge(entity);
		    }

		    /**
		     * Update entity
		     * @param entity of type EntityType
		     */
		    public void update(EntityType entity) {
		        getHibernateTemplate().merge(entity);
		    }

		    /**
		     * Delete created Entity
		     * @param entity of type EntityType
		     */
		    public void delete(EntityType entity) {
		        getHibernateTemplate().delete(entity);
		    }

		    /**
		     * Delete created Entity by a particular Id
		     * @param id of type IDType
		     */
		    public void deleteById(IDType id) {
		        EntityType entity = retrieveById(id);
		        if (entity != null) {
		            delete(entity);
		        }
		    }

		    /**
		     * Retrive all data
		     * @return List of type EntityType
		     */
		    public List<EntityType> retrieveAll() {

		      
		        List<EntityType> list = getHibernateTemplate().loadAll(getPersistentClass());
		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);
		        return list;
		    }

		    /**
		     * Retrive data in a particular order@p
		     * @param orderBy of type String
		     * @return List of type EntityType
		     */
		    public List<EntityType> findAll(String orderBy) {

		        List<EntityType> list = (List<EntityType>) getHibernateTemplate().findByCriteria(
		                DetachedCriteria.forClass(getPersistentClass()).addOrder(Order.asc(orderBy)));
		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);
		        return list;
		    }

		    public List<EntityType> findFiltered(String property, Object filter) {
		        List<EntityType> list = null;
//		        List<EntityType> list = getHibernateTemplate().findByCriteria(
//		                DetachedCriteria.forClass(getPersistentClass()).add(
//		                Restrictions.eq(property, filter)));
		        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(getPersistentClass());
		        if(filter != null) {
		            detachedCriteria.add(Restrictions.eq(property, filter));
		        }
		        list = (List<EntityType>) getHibernateTemplate().findByCriteria(detachedCriteria);
		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);
		        return list;
		    }

		    public List<EntityType> findFiltered(String property, Object filter, String orderBy) {

		        List<EntityType> list = (List<EntityType>) getHibernateTemplate().findByCriteria(
		                DetachedCriteria.forClass(getPersistentClass()).add(
		                Restrictions.eq(property, filter)).addOrder(
		                Order.asc(orderBy)));
		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);
		        return list;
		    }
		    
		    public List<EntityType> findLikeFiltered(String property, Object filter) {

		        return (List<EntityType>) getHibernateTemplate().findByCriteria(
		                DetachedCriteria.forClass(getPersistentClass()).add(
		                Restrictions.ilike(property, filter)));
		    }

		    public List<EntityType> findLikeFiltered(String property, Object filter, String orderBy) {

		        return (List<EntityType>) getHibernateTemplate().findByCriteria(
		                DetachedCriteria.forClass(getPersistentClass()).add(
		                Restrictions.ilike(property, filter)).addOrder(
		                Order.asc(orderBy)));
		    }

		    /**
		     * Retrive the data on particular property
		     * @param property of type String and filter of type Object
		     * @return Object of type EntityType
		     */
		    public EntityType findUniqueFiltered(String property, Object filter) {

		        EntityType entityType = null;

		        try {
		            entityType = (EntityType) DataAccessUtils.requiredUniqueResult(getHibernateTemplate().findByCriteria(
		                    DetachedCriteria.forClass(getPersistentClass()).add(
		                    Restrictions.eq(property, filter))));
		        } catch (EmptyResultDataAccessException ex) {
		            Logger.getLogger(BaseAbstractGenericDao.class.getName()).log(Level.INFO, "Error in findUniqueFiltered...");
		        }

		        return entityType;
		    }

		    /**
		     * Retrive the data on particular property and in a particular order
		     * @param property of type String , filter of type Object and orderBy of type String
		     * @return Object of type EntityType
		     */
		    public EntityType findUniqueFiltered(String property, Object filter, String orderBy) {
		        return (EntityType) DataAccessUtils.requiredUniqueResult(getHibernateTemplate().findByCriteria(
		                DetachedCriteria.forClass(getPersistentClass()).add(
		                Restrictions.eq(property, filter)).addOrder(
		                Order.asc(orderBy))));
		    }

		    /**
		     * Use this inside subclasses as a convenience method.
		     */
		    public List<EntityType> findByCriteria(Criterion... criterion) {
		        DetachedCriteria crit = DetachedCriteria.forClass(getPersistentClass());

		        for (Criterion c : criterion) {
		            crit.add(c);
		        }
		        List<EntityType> list = (List<EntityType>) getHibernateTemplate().findByCriteria(crit);

		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);

		        return list;
		    }

		    /**
		     * Use this inside subclasses as a convenience method.
		     */
		    public List<EntityType> findByCriteriaList(List<Criterion> criterions) {
		        DetachedCriteria crit = DetachedCriteria.forClass(getPersistentClass());

		        for (Criterion c : criterions) {
		            crit.add(c);
		        }

		        List<EntityType> list = (List<EntityType>) getHibernateTemplate().findByCriteria(crit);

		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);

		        return list;
		    }

		    /**
		     * Use this inside subclasses as a convenience method.
		     */
		    public List<EntityType> findByCriteriaList(List<Criterion> criterions, Boolean isSearch) {
		        DetachedCriteria crit = DetachedCriteria.forClass(getPersistentClass());

		        for (Criterion c : criterions) {
		            crit.add(c);
		        }

		        List<EntityType> list = null;

		        if(isSearch != null && isSearch) {
		           list = (List<EntityType>) getHibernateTemplate().findByCriteria(crit, 0 , 100);
		        } else {
		            list = (List<EntityType>) getHibernateTemplate().findByCriteria(crit);
		        }

		        DistinctRootEntityResultTransformer transformer = DistinctRootEntityResultTransformer.INSTANCE;
		        list = transformer.transformList(list);

		        return list;
		    }

		    /**
		     * Use this inside subclasses as a convenience method.
		    */
		    public List<EntityType> findByCriteriaWithRange(Criteria criteria) {
		        return criteria.list();
		    }

		
}
