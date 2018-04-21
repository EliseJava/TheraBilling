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
 * This servlet will delete a patient and all his appointments
 * or
 * Change patient information and delete/insert/change a patients appointments
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientUpdateDelete"}
)

public class PatientDeleteUpdate extends HttpServlet {
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

        //a Patient and all is appointments will be deleted
        if (functionDel != null) {
            logger.info("Direct to delete " + functionDel);
            genericDao.delete(patient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("patientsShowAll");
            dispatcher.forward(request, response);
        } else if (functionChg != null) {
            //Here you can change patient information; add/change/delete appointments
            logger.info("Direct to change" + functionChg);

            request.getSession().setAttribute("sharedId", id);
            request.getRequestDispatcher("patientShowPatient").forward(request, response);
        }
    }
}


