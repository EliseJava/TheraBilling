package edu.matc.persistence;

import edu.matc.entity.PatientProcedure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type PatientProcedure dao.
 */
public class PatientProcedureDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get patientProcedures by id
     */
    public PatientProcedure getPatientProceduresById(int id) {
        Session session = sessionFactory.openSession();
        PatientProcedure patientProcedures = session.get(PatientProcedure.class, id);
        session.close();
        return patientProcedures;
    }

    /**
     * Gets all patientProcedures.
     *
     * @return the all patientProcedures
     */
    public List<PatientProcedure> getAllPatientProcedures() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PatientProcedure> query = builder.createQuery(PatientProcedure.class);
        Root<PatientProcedure> root = query.from(PatientProcedure.class);
        List<PatientProcedure> patientProcedures = session.createQuery(query).getResultList();
        session.close();
        return patientProcedures;
    }

    /**
     * Get patient by property (exact match)
     * sample usage: getByPropertyEqual("lastName", "Curry")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of patients meeting the criteria search
     */
    public List<PatientProcedure> getByPropertyEqual(String propertyName, int value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for patient with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PatientProcedure> query = builder.createQuery( PatientProcedure.class );
        Root<PatientProcedure> root = query.from( PatientProcedure.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<PatientProcedure> procedures = session.createQuery( query ).getResultList();
        session.close();

        return procedures;
    }

    /**
     * update/save patientProcedures
     * @param patientProcedures  PatientProcedure to be inserted or updated
     */
    public void saveOrUpdate(PatientProcedure patientProcedures) {

        logger.info("patientProcedures {}", patientProcedures);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(patientProcedures);
        transaction.commit();
        session.close();
    }

    /**
     * update patientProcedures
     * @param patientProcedures  the patientProcedures to be inserted or updated
     */
    public int insert(PatientProcedure patientProcedures) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(patientProcedures);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a patientProcedures
     * @param patientProcedures PatientProcedure to be deleted
     */
    public void delete(PatientProcedure patientProcedures) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(patientProcedures);
        transaction.commit();
        session.close();
    }


}
