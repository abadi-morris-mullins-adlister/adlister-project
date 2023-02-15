package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Delete User: Allows for a user to be deleted. Restricted to admins only, and will only populate for
// a user designated as an admin.
@WebServlet(name = "controllers.DeleteUserServlet", urlPatterns = "/delete_user")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects view-only users to sign-in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Deletes the user's ads from the ads table
        List<Ad> ads = DaoFactory.getAdsDao().searchByUserId(Long.parseLong(request.getParameter("id")));
        for (Ad ad : ads){
            DaoFactory.getAdsDao().deleteListingAdCategories(ad.getId());
            DaoFactory.getAdsDao().deleteListing(ad.getId());
        }
        // Deletes the user from the users table
        DaoFactory.getUsersDao().deleteUser(Long.valueOf(request.getParameter("id")));
        response.sendRedirect("/profile");
    }
}