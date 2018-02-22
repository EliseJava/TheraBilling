package edu.matc.controller;

import edu.matc.entity.Patient;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.PatientDao;
import edu.matc.persistence.UserDao;

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
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Patient.class);

        Patient patient = (Patient)genericDao.getById(1);

        List<Patient> patients = (List<Patient>)genericDao.getAllByTable();

        request.setAttribute("patients", (List<Patient>)genericDao.getAllByTable());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientresults.jsp");
        dispatcher.forward(request, response);
    }
}