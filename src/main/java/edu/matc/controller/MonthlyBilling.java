package edu.matc.controller;

import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedure;
import edu.matc.entity.ProcedureCode;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;


/**
 * This servlet will pull all the Billable appointments for the month selected.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/monthlyBilling"}
)

public class MonthlyBilling extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        GenericDao genericDao   = new GenericDao(Patient.class);

        String    startime      = "T00:00:00.000";
        String    endtime       = "T23:59:00.000";

        LocalDate firstDayofCurrentMonth    = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayofCurrentMonth     = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        LocalDateTime startDate   = LocalDateTime.parse(firstDayofCurrentMonth + startime);
        LocalDateTime endDate = LocalDateTime.parse(lastDayofCurrentMonth + endtime);

//        List<Patient> billing
//                = (List<Patient>)genericDao.getProcByBillingMonth("appointmentDate", startDate, endDate);

        List<Patient> billing = (List<Patient>)genericDao.getAllByTable();
        List<Patient> billingcopy = new ArrayList<>();
        Patient test = new Patient();

        for (Patient index: billing) {
            logger.info("Patient  + " + index.getFirstName());
            Set<PatientProcedure> proc = index.getTreatmentPlan();
            Set<PatientProcedure> proccopy = new HashSet<>();
            for (PatientProcedure index2 : proc ) {
                if (index2.isBillingStatusActive()                       &
                   (!index2.getAppointmentDate().isBefore(startDate)     &
                   (!index2.getAppointmentDate().isAfter(endDate)))) {
                    proccopy.add(index2);
                }
            }

            if (proccopy.size() > 0) {

                test = index;
                for (PatientProcedure i : proccopy) {
                    test.addProcedures(i);
                    logger.info("Procedure code: " + i.getProcedureCode().getCode());
                }
                billingcopy.add(test);
            }

            proccopy.clear();
            test = null;
        }


        request.setAttribute("billing", billingcopy);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/monthly_billing.jsp");
        dispatcher.forward(request, response);
    }
}
