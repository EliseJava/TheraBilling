package edu.matc.persistence;

import edu.matc.entity.PatientProcedures;
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
 * The type PatientProcedures dao.
 */
public class PatientProceduresDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get patientProcedures by id
     */
    public PatientProcedures getPatientProceduresById(int id) {
        Session session = sessionFactory.openSession();
        PatientProcedures patientProcedures = session.get(PatientProcedures.class, id);
        session.close();
        return patientProcedures;
    }


    /**
     * Get PatientProcedures by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<PatientProcedures> getPatientProceduresByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for PatientProcedures with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PatientProcedures> query = builder.createQuery( PatientProcedures.class );
        Root<PatientProcedures> root = query.from( PatientProcedures.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<PatientProcedures> PatientProceduress = session.createQuery( query ).getResultList();
        session.close();
        return PatientProceduress;
    }

    /**
     * update/save patientProcedures
     * @param patientProcedures  PatientProcedures to be inserted or updated
     */
    public void saveOrUpdate(PatientProcedures patientProcedures) {

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
    public int insert(PatientProcedures patientProcedures) {
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
     * @param patientProcedures PatientProcedures to be deleted
     */
    public void delete(PatientProcedures patientProcedures) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(patientProcedures);
        transaction.commit();
        session.close();
    }


}
