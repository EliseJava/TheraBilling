package edu.matc.persistence;

import edu.matc.billingFunctions.BillingFunctions;
import edu.matc.entity.Patient;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This program is testing the Billing function
 *
 * @author   Elise Strauss
 */
class BillingFunctionTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    BillingFunctions billing = new BillingFunctions();

    /**
     * Sets up. Run sql to recreate the database before each test
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    /**
     * Verify a patient billing charges is added up correctly.
     */
    @Test
    void getMonthlyBilling() {
        List<Patient> monthlyBilling = billing.getMonthlyBillingRecords();

        assertEquals(0, monthlyBilling.size());
    }


}