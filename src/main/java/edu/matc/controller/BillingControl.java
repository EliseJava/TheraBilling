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
 * This servlet will mark a scheduled appointment as billable after the
 * patient was checked out after treatment was received.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/billingControl"}
)

public class BillingControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        int id = Integer.parseInt(request.getParameter("AppointId"));
        logger.info("id ..." + id);

        GenericDao genericDao = new GenericDao(ProcedureCode.class);

        PatientProcedure procedureToUpdate = (PatientProcedure)genericDao.getById(id);
        procedureToUpdate.setBillingStatusActive(true);
        genericDao.saveOrUpdate(procedureToUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/dailySchedule");
        dispatcher.forward(request, response);
    }
}