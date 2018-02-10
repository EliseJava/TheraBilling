package edu.matc.persistence;

import edu.matc.entity.Patient;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class PatientDaoTest {

    /**
     * The User dao.
     */
    PatientDao patientDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        patientDao = new PatientDao();

        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    @Test
    void getPatientByIdSucess() {
        Patient patient = patientDao.getPatientById(1);
        assertEquals("Calvin", patient.getFirstName());
    }

    /**
     * Gets users that start with C (lastName + "%").
     */
    @Test
    void getAllPatients() {
        List<Patient> patient = patientDao.getAllPatients("C");
        assertEquals(2, patient.size());
    }

    }