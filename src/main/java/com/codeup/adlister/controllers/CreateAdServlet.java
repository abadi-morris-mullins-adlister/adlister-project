package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Create Ad: Only accessible for signed-in users. View-only users will be redirected to the Log In page.
// Allows users to create a new ad listing, which will be added to the ads table and attached to the user's ID.
@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirects to Log In if the viewer is not signed in
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Gets the User object for the signed-in user
        User user = (User) request.getSession().getAttribute("user");
        // Creates a new Ad object using the submitted data
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description"),
            request.getParameter("imgURL"),
            Double.parseDouble(request.getParameter("price"))
        );
        // Inserts new ad into the ads table
        long newAdId = DaoFactory.getAdsDao().insert(ad);
        // Adds key-value pairs into the associative ad_categories table
        String[] category_id = request.getParameterValues("category");
        for (String category : category_id){
            Long insert_category = Long.valueOf(category);
            DaoFactory.getAdsDao().insertAdCategory(newAdId, insert_category);
        }
        // Redirects user to the Browse Ads page
        response.sendRedirect("/ads");
    }
}
