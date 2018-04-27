package edu.matc.controller;

import edu.matc.entity.ProcedureCode;
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
 * A servlet to display all current Procedure Codes.
 *
 * Procedure codes are directly entered into the system and stays static.
 * Project Phase II will implement a Medical billing API to maintain
 * procedure codes on a yearly basis.
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/procedureCodeDisplay"}
)

public class ProcedureCodeDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(ProcedureCode.class);

        List<ProcedureCode> procCodes = (List<ProcedureCode>)genericDao.getAllByTable();

        request.setAttribute("codes", procCodes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/procedurecodedisplay.jsp");
        dispatcher.forward(request, response);
    }
}