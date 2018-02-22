package edu.matc.persistence;

import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedure;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This program is testing the PatientDao
 */
class PatientDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The genericDao.
     */
     GenericDao genericDao;

    /**
     * Sets up. Run sql to recreate the database before each test
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Patient.class);

        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    /**
     * Verify a patient is returned correctly by their id.
     */
    @Test
    void getPatientByIdIsSuccessful() {
        Patient patient = (Patient)genericDao.getById(1);
        assertNotNull(patient);
        assertEquals("Calvin", patient.getFirstName());
    }

    /**
     * Gets ALL patient in the database.
     */
    @Test
    void getAllAreSuccessful() {
        List<Patient> patient = (List<Patient>)genericDao.getAllByTable();
        assertEquals(5, patient.size());
    }

    /**
     * Gets ALL patient in the database.
     */
    @Test
    void getAllByLastNameAreSuccessful() {
        List<Patient> patient = (List<Patient>)genericDao.getAllPatients("");
        assertEquals(5, patient.size());
    }

    /**
     * Gets patient by like lastname
     */
    @Test
    void getPatientsByLastNameIsSuccessful() {
        List<Patient> patient = (List<Patient>)genericDao.getAllPatients("R");
        assertEquals(2, patient.size());
    }

    /**
     * Gets patient by like lastname
     */
    @Test
    void getPatientsByColumnIsSuccessful() {
        List<Patient> patient = (List<Patient>)genericDao.getByColumn("lastName", "R");
        assertEquals(2, patient.size());
    }


    /**
     * Verify successful get by property - likes
     */
    @Test
    void getPropertyLikeSuccess() {
        List<Patient> patient = (List<Patient>)genericDao.getByColumn("firstName", "Cal");
        assertEquals(1, patient.size());
        //assertEquals(3, patient.get(0).getPatientId());
    }


    /**
     * Verify successful get by property - equals
     */
    @Test
    void getPropertyEqualSuccess() {
        List<Patient> patient = (List<Patient>)genericDao.getByColumn("lastName", "Roberts");
        assertEquals(1, patient.size());
    }

    /**
     * Patient is updates successfully.
     */
    @Test
    void patientUpdatedSuccessfully() {

        String newFirstName = "Calvinator";
        Patient patientToUpdate = (Patient)genericDao.getById(1);
        patientToUpdate.setFirstName(newFirstName);
        genericDao.saveOrUpdate(patientToUpdate);

        Patient changedPatient = (Patient)genericDao.getById(1);
        logger.info("name should be updated {}", changedPatient.getFirstName());
        assertEquals(patientToUpdate, changedPatient);
    }

    /**
     * Verify successful insert of a patient
     */
    @Test
    void insertPatientIsSuccessful() {

        Patient newPatient = new Patient("Sandy", "Kmiec", "Nerve damage in knee", "Dr. Thorpe", "11 Sandhill Crane", "Sun Prairie", "WI", 51904);
        int id = genericDao.insert(newPatient);
        assertNotEquals(0,id);

        Patient insertedPatient = (Patient)genericDao.getById(id);
        assertEquals(newPatient, insertedPatient);

        //http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful insert of a patient with more than one procedure
     */
    @Test
    void insertPatientWithProceduresSuccess() {

        Patient newPatient = new Patient("Elizabeth", "Visser", "Dislocated shoulder", "Dr. Melbourne", "4 PebbleBrook Lane", "Aurora", "IL", 42763);
        PatientProcedure treatment1 = new PatientProcedure(123456,LocalDateTime.now(), newPatient);
        newPatient.addProcedures(treatment1);

        int id = genericDao.insert(newPatient);

        assertNotEquals(0, id);
        Patient insertedPatient = (Patient)genericDao.getById(id);
        assertNotNull(insertedPatient);

        assertEquals(newPatient, insertedPatient);
        assertEquals(1, insertedPatient.getTreatmentPlan().size());

        //http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of patient
     */
    @Test
    void deletePatientIsSuccessful() {

        genericDao.delete((Patient)genericDao.getById(3));
        assertNull((Patient)genericDao.getById(3));
    }
}