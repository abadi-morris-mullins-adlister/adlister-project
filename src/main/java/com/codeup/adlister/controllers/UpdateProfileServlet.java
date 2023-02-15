package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Update Profile: Allows a user to update their profile. Admin users will be able to
// update any user profile.
@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/edit_profile")
public class UpdateProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects view-only users to sign-in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Admin users will be able to edit the profile of the requested user by their ID
        if (((User) request.getSession().getAttribute("user")).isAdmin()){
            User user = DaoFactory.getUsersDao().findByUserID(Long.parseLong(request.getParameter("id")));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/edit_profile.jsp")
                    .forward(request, response);
        // Regular users will be taken to the edit_profile.jsp for their own profile
        } else {
            request.setAttribute("user", ((User) request.getSession().getAttribute("user")));
            request.getRequestDispatcher("/WEB-INF/edit_profile.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gets the updated data from the submitted form
        String username = request.getParameter("username");
        String imgURL = request.getParameter("imgURL");
        String email = request.getParameter("email");
        Long user_id = Long.valueOf(request.getParameter("id"));

        // Updates the user info in the users table
        DaoFactory.getUsersDao().updateUser(username, imgURL, email, user_id);
        // Redirects the user back to their profile
        response.sendRedirect("/profile");
    }
}