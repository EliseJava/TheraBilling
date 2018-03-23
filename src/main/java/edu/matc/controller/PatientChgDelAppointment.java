package edu.matc.controller;

import edu.matc.entity.Patient;
import edu.matc.entity.PatientProcedure;
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
import java.time.LocalDateTime;

/**
 * This servlet will add new appointments for a patient.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/appointmentChangeDel"}
)

public class PatientChgDelAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger   = LogManager.getLogger(this.getClass());

        String functionChg = request.getParameter("change");
        String functionDel = request.getParameter("delete");

        int code       = Integer.parseInt(request.getParameter("ProcCode"));
        String newDate = request.getParameter("AppointDate");

        int AppointId = Integer.parseInt(request.getParameter("AppointId"));

        logger.info("Delete this appointment id: " + AppointId);
        logger.info("code to chg/del           : " + code);
        logger.info("date to chg/del           : " + newDate);

        GenericDao genericDao = new GenericDao(PatientProcedure.class);

        PatientProcedure appointment   = (PatientProcedure)genericDao.getById(AppointId);

        if (functionDel != null) {
            genericDao.delete(appointment);
        } else if (functionChg != null) {
            appointment.setProcedureCode(code);
            appointment.setAppointmentDate(LocalDateTime.parse(newDate));
            genericDao.saveOrUpdate(appointment);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("patientShowPatient");
        dispatcher.forward(request, response);
    }
}