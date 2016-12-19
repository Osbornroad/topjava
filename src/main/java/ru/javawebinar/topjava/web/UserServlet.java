package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.AuthorizedUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class UserServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("forward to users");
        String authorizedUser = request.getParameter("authorizedUser");
        if (authorizedUser == null)
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        else {
            int userId = Integer.parseInt(authorizedUser);
            AuthorizedUser.setId(userId);
            response.sendRedirect("index.html");
            System.out.println("UserServlet: " + AuthorizedUser.getId());
        }
    }
}
