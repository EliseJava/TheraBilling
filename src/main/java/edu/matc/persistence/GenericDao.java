package edu.matc.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Instantiates a new Generic dao.     *
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities     *
     * @return the all entities
     */
    public List<T> getAllByTable() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;

    }

    /**
     * Gets an entity by id
     * @param id entity id to search by
     * @return entity
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * This function gets by a column, and searches by a term.
     * @return a list of users
     */
    public List<T> getByColumn(String column, String term) {

        logger.debug("Searching for Patient with {} = {}",  column, term);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(column);
        query.where(builder.like(propertyPath,term + "%"));
        List<T> list = session.createQuery(query).getResultList();
        session.close();

        return list;
    }

    /**
     * This function gets by a column, and searches by a term.
     * @return a list of users
     */
    public List<T> getByColumnInt(String column, int term) {

        logger.debug("Searching for Patient with {} = {}",  column, term);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(column), term));
        List<T> list = session.createQuery( query ).getResultList();
        session.close();

        return list;
    }

    /**
     * Get patient(s) by last name or start of last name.
     * OR
     * Get all patients if no last name provided
     *
     * @param lastName the last name
     * @return the patients
     */
    public List<T> getAllPatients(String lastName) {

        logger.debug("lastname {}", lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        //CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<T> root = query.from(type);
        if (!lastName.equals("")) {
            Expression<String> propertyPath = root.get("lastName");
            query.where(builder.like(propertyPath, lastName + "%"));
        }
        List<T> patients = session.createQuery(query).getResultList();
        session.close();

        return patients;
    }


    /**
     * Deletes the entity.     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * update entity
     * @param entity Entity to be inserted
     * @return id of the inserted entity
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * update/save entity
     * @param entity  Entity to be inserted or updated
     */
    public void saveOrUpdate(T entity) {

        logger.info("patient {}", entity);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}