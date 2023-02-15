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

@WebServlet(name = "controllers.BrowseCategoryServlet", urlPatterns = "/ads/browse")
public class BrowseCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long category_id = Long.valueOf(request.getParameter("category"));
        ArrayList<Ad> ads = DaoFactory.getAdsDao().getAdsFromCategory(category_id);
        String category_name = DaoFactory.getCategoriesDao().nameFromId(category_id);
        int searchResults = ads.size();
        request.setAttribute("searchResult", searchResults);
        request.setAttribute("searchTerm", category_name);
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/browse.jsp").forward(request, response);
    }
}