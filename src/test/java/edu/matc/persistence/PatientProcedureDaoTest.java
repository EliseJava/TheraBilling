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

/**
 * This program is testing the PatientProcedureDao
 */
class PatientProcedureDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The patient dao.
     */
    PatientProcedureDao ppDao;

    /**
     * Sets up. Run sql to recreate the database before each test
     */
    @BeforeEach
    void setUp() {
        ppDao = new PatientProcedureDao();
        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    /**
     * Gets the patient's procedure by id.
     */
    @Test
    void getPatientProcedureByIdIsSuccessful() {
        PatientProcedure procedure = ppDao.getPatientProceduresById(1);
        assertEquals(97001, procedure.getProcedureCode());
    }

    /**
     * Gets the all procedures for a patient (by FK)
     */
    @Test
    void getAllProceduresForPatient() {
        List<PatientProcedure> procedure = ppDao.getByPropertyEqual("patient", 1);
        assertEquals(3, procedure.size());
    }


    /**
     * Gets the all procedure on the database
     */
    @Test
    void getAllProcedures() {
        List<PatientProcedure> procedure = ppDao.getAllPatientProcedures();
        assertEquals(7, procedure.size());
    }

    /**
     * patient procedure code is updates successfully.
     */
    @Test
    void UpdatedProcedureSuccessfully() {

        int newCode = 888888;

        PatientProcedure procedureToUpdate = ppDao.getPatientProceduresById(6);
        procedureToUpdate.setProcedureCode(newCode);
        ppDao.saveOrUpdate(procedureToUpdate);

        PatientProcedure changedProcedure = ppDao.getPatientProceduresById(6);
        logger.info("Code should be updated {}", changedProcedure.getProcedureCode());
        assertEquals(888888, changedProcedure.getProcedureCode());
    }

    /**
     * Verify successful insert of a procedure code for a patient
     */
    @Test
    void insertProcedureForPatientIsSuccessful() {

        PatientDao patientUpdate = new PatientDao();
        Patient patient = patientUpdate.getPatientById(3);
        PatientProcedure newProc = new PatientProcedure(777777, LocalDateTime.now(), patient);
        patient.addProcedures(newProc);

        int id = ppDao.insert(newProc);
        assertNotEquals(0, id);

        PatientProcedure testProc = ppDao.getPatientProceduresById(id);
        assertEquals(777777, testProc.getProcedureCode());
        assertNotNull(testProc.getPatient());
        assertEquals("Doug", testProc.getPatient().getFirstName());

        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/orderguide/html_single/Hibernate_Order_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Delete procedure is successful.
     */
    @Test
    void deleteProcedureIsSuccessful() {
        ppDao.delete(ppDao.getPatientProceduresById(3));
        assertNull(ppDao.getPatientProceduresById(3));
    }
}