package edu.matc.controller;

import edu.matc.entity.Patient;
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
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientUpdateDelete"}
)

public class PatientUpdateDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        String functionDel = request.getParameter("delete");
        int id = Integer.parseInt(request.getParameter("id"));
        logger.info("ID to delete: " + id);

        String functionChg = request.getParameter("update");

        Patient patient = new Patient();
        GenericDao genericDao = new GenericDao(Patient.class);
        patient = (Patient)genericDao.getById(id);
        logger.info("diagnosis: " + patient.getDiagnosis());

        if (functionDel != null) {
            logger.info("Direct to delete " + functionDel);
            genericDao.delete(patient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("patientsShowAll");
            dispatcher.forward(request, response);
        } else if (functionChg != null) {
            logger.info("Direct to change" + functionChg);

            request.setAttribute("patient", patient);
            request.setAttribute("diagnosis", patient.getDiagnosis());
            request.getRequestDispatcher("/jsp/patientchange.jsp").forward(request, response);


        }
    }
}


