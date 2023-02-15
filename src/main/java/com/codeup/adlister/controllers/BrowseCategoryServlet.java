package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Browse Category: Gets the ID # for the requested category, filters the ads by their categories,
// then pushes the ads arraylist to the browse.jsp.
@WebServlet(name = "controllers.BrowseCategoryServlet", urlPatterns = "/ads/browse")
public class BrowseCategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Uses the requested category ID # to filter ads by category
        Long category_id = Long.valueOf(request.getParameter("category"));
        // Ads in the category
        ArrayList<Ad> ads = DaoFactory.getAdsDao().getAdsFromCategory(category_id);
        request.setAttribute("ads", ads);
        // Category name
        String category_name = DaoFactory.getCategoriesDao().nameFromId(category_id);
        request.setAttribute("searchTerm", category_name);
        // Number of results
        int searchResults = ads.size();
        request.setAttribute("searchResult", searchResults); // # of results
        // Forwards to browse.jsp
        request.getRequestDispatcher("/WEB-INF/browse.jsp").forward(request, response);
    }
}