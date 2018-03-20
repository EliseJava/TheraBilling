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
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/patientMaintenance"}
)

public class PatientMaintenance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        //RequestDispatcher dispatcher;

        String functionAdd = request.getParameter("add");
        String functionDel = request.getParameter("delete");
        String functionChg = request.getParameter("change");

        request.setAttribute("firstname", request.getParameter("firstname"));
        request.setAttribute("lastname", request.getParameter("lastname"));

        if (functionAdd != null) {
            logger.info("Direct to add " + functionAdd);
            request.getRequestDispatcher("/jsp/patientadd.jsp").forward(request, response);
        } else if (functionDel != null) {
            logger.info("Direct to delete " + functionDel);
            request.getRequestDispatcher("/jsp/patientadd.jsp").forward(request, response);
        } else if (functionChg != null) {
            logger.info("Direct to change" + functionChg);
            request.getRequestDispatcher("/jsp/patientadd.jsp").forward(request, response);
        }
    }
}

        // response.sendRedirect(url);

//        GenericDao genericDao = new GenericDao(Patient.class);
//
//        List<Patient> patients = (List<Patient>)genericDao.getAllByTable();
//
//        request.setAttribute("patients", (List<Patient>)genericDao.getAllByTable());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientresults.jsp");
//        dispatcher.forward(request, response);

