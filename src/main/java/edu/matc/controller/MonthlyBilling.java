package edu.matc.controller;

import edu.matc.billingFunctions.BillingFunctions;
import edu.matc.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * This servlet will pull all the Billable appointments for the month selected.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/monthlyBilling"}
)
public class MonthlyBilling extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        BillingFunctions billing = new BillingFunctions();

        List<Patient> monthlyBilling = billing.getMonthlyBillingRecords();

        request.setAttribute("mbilling", monthlyBilling);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/monthly_billing.jsp");
        dispatcher.forward(request, response);
    }
}
