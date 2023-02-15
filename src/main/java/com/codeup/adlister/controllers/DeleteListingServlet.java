package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Delete Ad: Allows the user to delete a listing. Finds the listing by its ID and deletes it from
// both the ads & the ad_categories tables.
@WebServlet(name = "controllers.DeleteListingServlet", urlPatterns = "/ads/delete")
public class DeleteListingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects view-only users to sign-in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Deletes ad by ID from the ad_categories table
        DaoFactory.getAdsDao().deleteListingAdCategories(Long.valueOf(request.getParameter("id")));
        // Deletes ad by ID from the ads table
        DaoFactory.getAdsDao().deleteListing(Long.valueOf(request.getParameter("id")));
        // Redirects the user to their profile
        response.sendRedirect("/profile");
    }

}