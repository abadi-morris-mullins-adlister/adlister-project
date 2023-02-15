package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Browse Ads: Retrieves all listed ads and forwards them to the index.jsp.
@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieves all ads
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        // Forwards to index.jsp
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
