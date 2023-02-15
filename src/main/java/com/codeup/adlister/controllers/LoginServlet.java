package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// User Login: Only view-only users that are not signed in may visit the Login page.
// Signed-in users will be redirected to their profile page. The server will get the data
// from the Login form and check that the password is correct.
@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects a signed-in user to their profile page
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Gets the submitted username & password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        // Redirects user back to Login if the username is not valid
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        // Checks the password
        boolean validAttempt = Password.check(password, user.getPassword());
        // If the password is correct, the user is directed to their profile page
        if (validAttempt) {
            request.getSession().setAttribute("user", user);

            response.sendRedirect("/profile");
        // If the password is incorrect, the user is directed to the log in page
        } else {
            response.sendRedirect("/login");
        }
    }
}
