package edu.matc.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.criteria.*;

import javax.persistence.*;


import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com.  This DAO will serve
 * all the database needs for TheraBilling application
 *
 * @author   Elise Strauss
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Instantiates a new Generic dao.
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

        Session          session = getSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query   = builder.createQuery(type);
        Root<T>          root    = query.from(type);

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

        Session            session      = sessionFactory.openSession();
        CriteriaBuilder    builder      = session.getCriteriaBuilder();
        CriteriaQuery<T>   query        = builder.createQuery(type);
        Root<T>            root         = query.from(type);
        Expression<String> propertyPath = root.get(column);

        query.where(builder.like(propertyPath,term + "%"));

        List<T> list = session.createQuery(query).getResultList();
        session.close();

        return list;
    }

    /**
     * This function gets by a column, and searches by a term.
     * @return a list of items
     */
    public List<T> getByColumnInt(String column, int term) {

        logger.debug("Searching for Patient with {} = {}",  column, term);

        Session          session = sessionFactory.openSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query   = builder.createQuery(type);
        Root<T>          root    = query.from(type);

        query.select(root).where(builder.equal(root.get(column), term));
        List<T> list = session.createQuery( query ).getResultList();
        session.close();

        return list;
    }

    /**
     * This function gets by a column, and searches by a term.
     *
     *
     * @return an entity.
     */
    public <T> T getOneEntityByColumnInt(String column, int term) {

        logger.debug("Searching for Patient with {} = {}",  column, term);

        Session          session = sessionFactory.openSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery query   = builder.createQuery(type);
        Root          root    = query.from(type);

        query.select(root).where(builder.equal(root.get(column), term));
        T entity = (T) session.createQuery( query ).getSingleResult();
        session.close();

        return entity;
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
     * Gets all appointments for today where the the appointment was not billed yet.
     *
     * Billed appointments will have a billing_status_active = TRUE
     *
     * @return the all entities
     */
    public List<T> getProcByDate(String column, LocalDateTime term1, LocalDateTime term2)  {

        Session          session = getSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query   = builder.createQuery(type);
        Root<T>          root    = query.from(type);

        query.select(root).where(builder.between(root.get(column), term1, term2),
                                 builder.isFalse(root.get("billingStatusActive")));

        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets all Billable appointments for the month
     *
     * @return the all Billable entities for the month
     */
    public List<T> getProcByBillingMonth(String column, LocalDateTime term1, LocalDateTime term2)  {

        Session          session = getSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query   = builder.createQuery(type);
        Root<T>          root    = query.from(type);

        query.select(root).where(builder.between(root.get(column), term1, term2),
                builder.isTrue(root.get("billingStatusActive")));

        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
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