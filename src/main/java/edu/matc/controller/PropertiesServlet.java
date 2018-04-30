package edu.matc.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import edu.matc.javabackground.PropertiesLoaderInterface;


/**
 * This is a java servlet will set the properties file to the ServletContext
 * in HTML format
 *
 *@author   Elise Strauss
 */
@WebServlet(
        name = "propertiesServlet",
        urlPatterns = { "/propserv" }
)

public class PropertiesServlet extends HttpServlet implements PropertiesLoaderInterface {

    private Properties properties;

    /**
     * This method will load the Properties file
     * @throws ServletException Servlet exception when loading Properties
     */
    public void init() throws ServletException {
        properties = loadProperties("/project2.properties");
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter output = response.getWriter();

        output.print("<HTML>");
        output.print("<HEAD><TITLE>Properties Servlet</TITLE></HEAD>");
        output.print("<BODY>");
        output.print("<H2>The Properties File content</H1>");
        output.print("<p><a href='/java112'>Back to home page</a></p>");

        output.print("<TABLE style='border:5px double black; cellpadding = '5' cellspacing = '5''>");
        output.print("<tr>");
        output.print("<th>Key</th>");
        output.print("<th>Value</th>");
        output.print("</tr>");

        for (Map.Entry<Object,Object> entry : properties.entrySet()) {

            output.print("<tr>");
            output.print("<td style='border:1px solid black;'>" + entry.getKey() + "</td>");
            output.print("<td style='border:1px solid black;'>" + entry.getValue() + "</td>");
            output.print("</tr>");
        }

        output.print("</TABLE>");
        output.print("</BODY>");
        output.print("</HTML>");
        output.close();
    }
}