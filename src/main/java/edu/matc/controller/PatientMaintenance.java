package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to direct the application in adding a new patient.
 * @author Elise Strauss
 */

@WebServlet(
        urlPatterns = {"/patientMaintenance"}
)

public class PatientMaintenance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        String functionAdd = request.getParameter("add");

        request.setAttribute("firstname", request.getParameter("firstname"));
        request.setAttribute("lastname", request.getParameter("lastname"));

        if (functionAdd != null) {
            logger.info("Direct to add " + functionAdd);
            request.getRequestDispatcher("/jsp/patientadd.jsp").forward(request, response);
        }
    }
}


