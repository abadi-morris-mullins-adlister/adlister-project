package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// View Profile: Allows the user to view their profile. Admin users will be taken to a
// restricted page with admin actions. View-only users will be re-directed to login.jsp.
@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects view-only users to sign-in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Gets the User session object & their ads
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().searchByUserId(user.getId()));
        // Admin users will be re-directed to admin.jsp
        if (user.isAdmin()) {
            // All User object data & Ad object data is pulled for admin users
            List<User> users = DaoFactory.getUsersDao().findAllUsers();
            request.setAttribute("users", users);
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        // Regular users will be re-directed to profile.jsp
        } else {
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }
    }
}