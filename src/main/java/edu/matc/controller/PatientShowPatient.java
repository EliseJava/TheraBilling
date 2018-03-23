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


/**
 * A simple servlet to welcome the user.
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientShowPatient"}
)

public class PatientShowPatient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        GenericDao genericDao = new GenericDao(Patient.class);

        logger.info("shared id" + request.getSession().getAttribute("sharedId"));

        int id = (int) request.getSession().getAttribute("sharedId");
        Patient patient = (Patient)genericDao.getById(id);

        request.setAttribute("patient", patient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientchange.jsp");
        dispatcher.forward(request, response);
    }
}