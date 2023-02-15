package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Search: All users can search through the ad listings using keywords. The keyword
// entered into the search bar will be matched against the ad titles & descriptions.
@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gets the search term & filters ads by match
        String searchTerm = request.getParameter("searchTerm");
        request.setAttribute("ads", DaoFactory.getAdsDao().searchByTerm(searchTerm));
        // Number of search results
        int searchResults = DaoFactory.getAdsDao().searchByTerm(searchTerm).size();
        request.setAttribute("searchResult", searchResults);
        // Forwards data to search.jsp
        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }
}
