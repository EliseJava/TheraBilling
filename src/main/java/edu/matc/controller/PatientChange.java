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
 * This servlet will update patient information.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientChange"}
)

public class PatientChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        GenericDao genericDao = new GenericDao(Patient.class);

        int id                = (int) request.getSession().getAttribute("sharedId");
        int code              = Integer.parseInt(request.getParameter("chgCode"));

        Patient chgPatient    = (Patient)genericDao.getById(id);

        chgPatient.setFirstName(request.getParameter("chgFirstName"));
        chgPatient.setLastName(request.getParameter("chgLastName"));
        chgPatient.setDiagnosis(request.getParameter("chgDiagnosis"));
        chgPatient.setReferredBy(request.getParameter("chgReferredBy"));
        chgPatient.setStreetName(request.getParameter("chgStreet"));
        chgPatient.setCity(request.getParameter("chgCity"));

        chgPatient.setPostalCode(code);
        genericDao.saveOrUpdate(chgPatient);

        RequestDispatcher dispatcher = request.getRequestDispatcher("patientShowPatient");
        dispatcher.forward(request, response);
    }
}