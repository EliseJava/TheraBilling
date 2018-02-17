package edu.matc.persistence;

import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedures;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This program is testing the PatientDao
 */
class PatientDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The patient dao.
     */
    PatientDao patientDao;


    /**
     * Sets up. Run sql to recreate the database before each test
     */
    @BeforeEach
    void setUp() {
        patientDao = new PatientDao();
        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }


    /**
     * Gets patient by their id.
     */
    @Test
    void getPatientByIdIsSuccessful() {
        Patient patient = patientDao.getPatientById(1);
        assertEquals("Calvin", patient.getFirstName());
    }

    /**
     * Gets ALL patient in the database. Pass empty string.
     */
    @Test
    void getAllPatientsAreSuccessful() {
        List<Patient> patient = patientDao.getAllPatients("");
        assertEquals(3, patient.size());
    }

    /**
     * Gets patient by lastname.
     */
    @Test
    void getPatientsByLastNameIsSuccessful() {
        List<Patient> patient = patientDao.getAllPatients("Gerber");
        assertEquals(1, patient.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getPatientByPropertyEqualSuccess() {
        List<Patient> patient = patientDao.getPatientByPropertyLike("firstName", "Calvin");
        assertEquals(1, patient.size());
        //assertEquals(3, patient.get(0).getPatientId());
    }

    /**
     * Patient is updates successfully.
     */
    @Test
    void patientUpdatedSuccessfully() {

        String newFirstName = "Calvinator";

        Patient patientToUpdate = patientDao.getPatientById(1);
        patientToUpdate.setFirstName(newFirstName);
        patientDao.saveOrUpdate(patientToUpdate);

        Patient changedPatient = patientDao.getPatientById(1);

        logger.info("name should be updated {}", changedPatient.getFirstName());
        assertEquals(newFirstName, changedPatient.getFirstName());
    }



    /**
     * Verify successful insert of a patient
     */
    @Test
    void insertPatientIsSuccessful() {

        Patient newPatient = new Patient("Sandy", "Kmiec", "Nerve damage in knee", "Dr. Thorpe", "11 Sandhill Crane", "Sun Prairie", "WI", 51904);

        int id = patientDao.insert(newPatient);
        assertNotEquals(0,id);
        Patient insertedPatient = patientDao.getPatientById(id);

        assertEquals("Sandy", newPatient.getFirstName());

        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful insert of a patient and procedures
     */
    @Test
    void insertPatientWithProceduresSuccess() {


        Patient newPatient = new Patient("Elizabeth", "Visser", "Dislocated shoulder", "Dr. Melbourne", "4 PebbleBrook Lane", "Aurora", "IL", 42763);
        PatientProcedures treatment1 = new PatientProcedures(123456,LocalDateTime.now(), newPatient);

        newPatient.addProcedures(treatment1);

        int id = patientDao.insert(newPatient);

        assertNotEquals(0, id);
        Patient insertedPatient = patientDao.getPatientById(id);
        assertNotNull(insertedPatient);

        assertEquals("Elizabeth", insertedPatient.getFirstName());
        assertEquals(1, insertedPatient.getTreatmentPlan().size());

        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    @Test
    void deleteProcedureForPatientSuccess() {

        Patient person = new Patient().getId(3);
        PatientProcedures treatment = new PatientProcedures().getId(1);

        person.removeProcedures(treatment);

        int id = patientDao.insert(newPatient);


        assertNotEquals(0, id);
        Patient insertedPatient = patientDao.getPatientById(id);
        assertNotNull(insertedPatient);

        assertEquals("Elizabeth", insertedPatient.getFirstName());
        assertEquals(1, insertedPatient.getTreatmentPlan().size());

        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of patient
     */
    @Test
    void deletePatientIsSuccessfull() {

        patientDao.delete(patientDao.getPatientById(3));
        assertNull(patientDao.getPatientById(3));
    }

}