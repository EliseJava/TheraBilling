package edu.matc.persistence;

import edu.matc.entity.Patient;
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
 * The type Patient dao.
 */
public class PatientDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get patient by id
     */
    public Patient getPatientById(int id) {

        Session session = sessionFactory.openSession();
        Patient patient = session.get(Patient.class, id);
        session.close();
        return patient;
    }

    /**
     * Get patient(s) by last name or start of last name.
     * OR
     * Get all patients if no last name provided
     *
     * @param lastName the last name
     * @return the patients
     */
    public List<Patient> getAllPatients(String lastName) {

        logger.debug("lastname {}", lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);
        if (!lastName.equals("")) {
            Expression<String> propertyPath = root.get("lastName");
            query.where(builder.like(propertyPath, lastName + "%"));
        }
        List<Patient> patients = session.createQuery(query).getResultList();
        session.close();

        return patients;
    }

    /**
     * update/save patient
     * @param patient  Patient to be inserted or updated
     */
    public void saveOrUpdate(Patient patient) {

        logger.info("patient {}", patient);

        Session session = sessionFactory.openSession();
        session.saveOrUpdate(patient);
        session.close();
    }

    /**
     * update patient
     * @param patient  the patient to be inserted or updated
     */
    public int insert(Patient patient) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(patient);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a patient
     * @param patient Patient to be deleted
     */
    public void delete(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(patient);
        transaction.commit();
        session.close();
    }
}