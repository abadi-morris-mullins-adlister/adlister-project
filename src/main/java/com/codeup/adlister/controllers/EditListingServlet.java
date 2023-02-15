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

// Edit Listing: Allows for a listing to be edited. Regular users may only update their own listings, while
// admin users can modify every listing in the ads table. Updates the ads table with the new ad data and
// redirects the user to the edited listing for review.
@WebServlet(name = "controllers.EditListingServlet", urlPatterns = "/ads/edit")
public class EditListingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects view-only users to sign-in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Gets the Ad object and forwards it to edit.jsp
        request.setAttribute("ad", DaoFactory.getAdsDao().searchByAdId(Long.parseLong(request.getParameter("id"))));
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gets the submitted form data
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imgURL = request.getParameter("imgURL");
        double price = Double.parseDouble(request.getParameter("price"));
        Long id = Long.valueOf(request.getParameter("id"));
        // Updates the ads table with the updated info
        DaoFactory.getAdsDao().updateListing(title, description, imgURL, price, id);
        // Redirects the user to the updated listing
        response.sendRedirect("/product?id="+id);
    }
}