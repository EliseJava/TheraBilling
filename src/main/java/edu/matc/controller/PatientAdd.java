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
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientAdd"}
)

public class PatientAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        Patient newPatient = new Patient();
        int code = Integer.parseInt(request.getParameter("addCode"));

        newPatient.setFirstName(request.getParameter("addFirstName"));
        newPatient.setLastName(request.getParameter("addLastName"));
        newPatient.setDiagnosis(request.getParameter("addDiagnosis"));
        newPatient.setReferredBy(request.getParameter("addRefferedBy"));
        newPatient.setStreetName(request.getParameter("addStreet"));
        newPatient.setCity(request.getParameter("addCity"));
        newPatient.setPostalCode(code);

        GenericDao genericDao = new GenericDao(Patient.class);
        int id = genericDao.insert(newPatient);
        Patient addedPatient = (Patient)genericDao.getById(id);

        String date = request.getParameter("addAppointment");

        logger.info("date parsed: " + LocalDateTime.parse(date));

        PatientProcedure newProc = new PatientProcedure(97001, LocalDateTime.parse(date), addedPatient);
        addedPatient.addProcedures(newProc);
        genericDao.insert(newProc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("patientsShowAll");
        dispatcher.forward(request, response);
    }
}