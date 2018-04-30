package edu.matc.controller;

import edu.matc.entity.Patient;
import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


/**
 * A simple servlet to welcome the user.
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/userAdd"}
)

public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

        String function         = request.getParameter("useradd");
        GenericDao genericDao   = new GenericDao(User.class);

        ServletContext context  = getServletContext();
        Properties properties   = (Properties) context.getAttribute("theraProperties");
        logger.info("properties password " + properties.getProperty("defaultuserpassword"));

        if (function != null) {
            GenericDao genericDao2 = new GenericDao(Role.class);

            User newUser = new User();
            Role role = new Role();

            newUser.setFirstName(request.getParameter("FirstName"));
            newUser.setLastName(request.getParameter("LastName"));
            newUser.setUserName(request.getParameter("userName"));
            newUser.setPassword(properties.getProperty("defaultuserpassword"));

            int id = genericDao.insert(newUser);
            User userAdded = (User) genericDao.getById(id);

            role.setRoleType(request.getParameter("role"));
            role.setUserName(request.getParameter("userName"));
            role.setUser(userAdded);

            genericDao2.insert(role);
        }

        List<User> allUsers = (List<User>)genericDao.getAllByTable();
        request.setAttribute("users", allUsers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/addnewuser.jsp");
        dispatcher.forward(request, response);
    }
}