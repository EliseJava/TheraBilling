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
import java.time.LocalDateTime;

/**
 * This servlet will add new appointments for a patient.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientAddAppointment"}
)

public class PatientAddAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger     = LogManager.getLogger(this.getClass());

        int id                  = (int) request.getSession().getAttribute("sharedId");
        int newProc             = Integer.parseInt(request.getParameter("addProcCode"));

        GenericDao genericDao   = new GenericDao(Patient.class);
        Patient patient         = (Patient)genericDao.getById(id);

        GenericDao genericDao2  = new GenericDao(ProcedureCode.class);
        ProcedureCode code      = (ProcedureCode)genericDao2.getOneEntityByColumnInt("code", newProc);

        String newDate              = request.getParameter("addAppointmentDate");
        PatientProcedure newAppoint = new PatientProcedure(code, LocalDateTime.parse(newDate), patient);

        patient.addProcedures(newAppoint);
        genericDao.insert(newAppoint);

        RequestDispatcher dispatcher = request.getRequestDispatcher("patientShowPatient");
        dispatcher.forward(request, response);
    }
}