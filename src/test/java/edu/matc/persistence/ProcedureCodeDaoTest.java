package edu.matc.persistence;

import edu.matc.entity.ProcedureCode;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This program is selecting the Procedure Codes
 *
 * Procedure codes are directly entered into the system and stays static.
 * Project Phase II will implement a Medical billing API to maintain
 * procedure codes on a yearly basis.
 *
 * @author   Elise Strauss
 */
class ProcedureCodeDaoTest {

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
        genericDao = new GenericDao(ProcedureCode.class);

        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    /**
     * Verify a procedure code by id.
     */
    @Test
    void getProcedureCodeByIdIsSuccessful() {
        ProcedureCode code = (ProcedureCode)genericDao.getById(6);
        logger.info(code.getDescription());
        assertNotNull(code);
        assertEquals(97001, code.getCode());
    }

    /**
     * Gets ALL procedure codes in the database.
     */
    @Test
    void getAllAreSuccessful() {
        List<ProcedureCode> codes = (List<ProcedureCode>)genericDao.getAllByTable();
        assertEquals(12, codes.size());
    }

    /**
     * Gets the id of the procedure code
     */
    @Test
    void getIdOfProcedureCodeIsSuccessful() {

        List<ProcedureCode> code = (List<ProcedureCode>)genericDao.getByColumnInt("code", 97018);
        ProcedureCode newcode = code.get(0);
        assertEquals(10, newcode.getId());

        ProcedureCode code1 = (ProcedureCode)genericDao.getOneEntityByColumnInt("code", 97018);
        assertEquals(10, code1.getId());
    }
}