package edu.matc.controller;

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
import java.util.List;


/**
 * This servlet will pull all the daily appointments.
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/dailySchedule"}
)

public class DailySchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        GenericDao genericDao   = new GenericDao(PatientProcedure.class);

        //Check if the CHECKOUT button was submitted, if so update the billing status
        String functionCheckout = request.getParameter("checkout");
        if (functionCheckout != null) {

              int id = Integer.parseInt(request.getParameter("AppointId"));

              PatientProcedure procedureToUpdate = (PatientProcedure) genericDao.getById(id);
              procedureToUpdate.setBillingStatusActive(true);
              genericDao.saveOrUpdate(procedureToUpdate);
        }


        //Get daily appointments that were not billed yet
        String    startime      = "T00:00:00.000";
        String    endtime       = "T23:59:00.000";
        LocalDate today         = LocalDate.now();
        LocalDateTime startdate = LocalDateTime.parse(today + startime);
        LocalDateTime enddate   = LocalDateTime.parse(today + endtime);

        List<PatientProcedure> schedule
                = (List<PatientProcedure>)genericDao.getProcByDate("appointmentDate", startdate, enddate);

        for (PatientProcedure index: schedule) {
            logger.info("schedule :" + index);
        }

        request.setAttribute("schedule", schedule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/dailyscheduleresults.jsp");
        dispatcher.forward(request, response);
    }
}