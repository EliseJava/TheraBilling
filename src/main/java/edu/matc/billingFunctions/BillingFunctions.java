package edu.matc.billingFunctions;

import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedure;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class will pull all the Billable appointments for the month selected.
 *
 * @author Elise Strauss
 */
public class BillingFunctions {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao   = new GenericDao(Patient.class);

    private static final String STARTTIME = "T00:00:00.000";
    private static final String   ENDTIME = "T23:59:00.000";

    private LocalDate firstDayofCurrentMonth    = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    private LocalDate lastDayofCurrentMonth     = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

    private LocalDateTime startDate = LocalDateTime.parse(firstDayofCurrentMonth + STARTTIME);
    private LocalDateTime endDate   = LocalDateTime.parse(lastDayofCurrentMonth + ENDTIME);

    private List<Patient> billing       = (List<Patient>)genericDao.getAllByTable();
    private List<Patient> billingIncome = new ArrayList<>();

    public List<Patient> getMonthlyBillingRecords() {

        Patient billableProcedure   = new Patient();

        for (Patient index: billing) {
            logger.info("Patient  + " + index.getFirstName());
            Set<PatientProcedure> proc = index.getTreatmentPlan();
            Set<PatientProcedure> proccopy = new HashSet<>();

            for (PatientProcedure index2 : proc ) {
                if (index2.isBillingStatusActive()                       &&
                        (!index2.getAppointmentDate().isBefore(startDate)     &&
                                (!index2.getAppointmentDate().isAfter(endDate)))) {

                   proccopy.add(index2);
                }
            }

            if (!proccopy.isEmpty()) {

                //assign the current patient index to this Patient object
                billableProcedure = index;
                Set<PatientProcedure> emptylist = new HashSet<>();
                billableProcedure.setTreatmentPlan(emptylist);

                for (PatientProcedure i : proccopy) {
                    billableProcedure.addProcedures(i);
                    logger.info("Procedure code: " + i.getProcedureCode().getCode());
                }
                billingIncome.add(billableProcedure);
            }
            proccopy.clear();
        }
        return billingIncome;
    }
}
