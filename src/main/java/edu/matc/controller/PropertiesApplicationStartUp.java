package edu.matc.controller;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import edu.matc.javabackground.*;

/**
 * This servlet will load a properties files and assign it as an attribute to
 * the ServletContext object.
 *
 *@author   Elise Strauss
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/properties-startup" },
        loadOnStartup = 1
)

public class PropertiesApplicationStartUp extends HttpServlet implements PropertiesLoaderInterface {

    /**
     * This metod will load the properties file
     *
     * @throws ServletException The exception thrown by init()
     */
    public void init() throws ServletException {

        Properties theraProperties;

        theraProperties         = loadProperties("/therabilling.properties");
        ServletContext context  = getServletContext();

        context.setAttribute("theraProperties", theraProperties);
    }
}





