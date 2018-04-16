package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to direct us to the Task List for the day
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/taskList"}
)

public class TaskList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/dashform-tag.jsp");
        dispatcher.forward(request, response);
    }
}