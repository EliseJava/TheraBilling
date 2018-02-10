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
 * The type User dao.
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
     * Gets patients.
     *
     * @param lastName the last name
     * @return the users
     */
    public List<Patient> getPatients(String lastName) {

        logger.debug("lastname {}", lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);
        if (!lastName.equals("")) {
            Expression<String> propertyPath = root.get("lastName");
            query.where(builder.like(propertyPath, lastName + "%"));
        }

        List<Patient> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }
}
