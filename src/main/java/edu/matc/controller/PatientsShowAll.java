package edu.matc.controller;

import edu.matc.entity.Patient;
import edu.matc.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to get all patient info.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/patientsShowAll"}
)

public class PatientsShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Patient.class);

        List<Patient> patients = (List<Patient>)genericDao.getAllByTable();

        request.setAttribute("patients", patients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientresults.jsp");
        dispatcher.forward(request, response);
    }
}