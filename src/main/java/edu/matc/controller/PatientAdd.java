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
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A servlet to add a new patient.  When a new patient is created a Physical Therapy Evaluation
 * appointment will be automatically added.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientAdd"}
)

public class PatientAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        GenericDao genericDao   = new GenericDao(Patient.class);
        GenericDao genericDao2   = new GenericDao(ProcedureCode.class);

        Patient newPatient = new Patient();
        int postalCode = Integer.parseInt(request.getParameter("addCode"));

        newPatient.setFirstName(request.getParameter("addFirstName"));
        newPatient.setLastName(request.getParameter("addLastName"));
        newPatient.setDiagnosis(request.getParameter("addDiagnosis"));
        newPatient.setReferredBy(request.getParameter("addRefferedBy"));
        newPatient.setStreetName(request.getParameter("addStreet"));
        newPatient.setState(request.getParameter("addState"));
        newPatient.setCity(request.getParameter("addCity"));
        newPatient.setPostalCode(postalCode);

        //add a new patient
        //int id                  = genericDao.insert(newPatient);
        //Patient addedPatient    = (Patient)genericDao.getById(id);

        String date = request.getParameter("addAppointment");

        //get the Physical Therapy Evaluation Procedure Code
        logger.info("date parsed: " + LocalDateTime.parse(date));
        ProcedureCode evalCode = (ProcedureCode)genericDao2.getById(6);

        PatientProcedure newProc = new PatientProcedure(evalCode, LocalDateTime.parse(date), newPatient);
        newPatient.addProcedures(newProc);
        genericDao.insert(newPatient);

        RequestDispatcher dispatcher = request.getRequestDispatcher("patientsShowAll");
        dispatcher.forward(request, response);
    }
}