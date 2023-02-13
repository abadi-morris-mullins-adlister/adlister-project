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

@WebServlet(name = "controllers.EditListingServlet", urlPatterns = "/ads/edit")
public class EditListingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("ad", DaoFactory.getAdsDao().searchByAdId(Long.parseLong(request.getParameter("id"))));
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imgURL = request.getParameter("imgURL");
        double price = Double.parseDouble(request.getParameter("price"));
        Long id = Long.valueOf(request.getParameter("id"));

        System.out.println(title);
        System.out.println(description);
        System.out.println(imgURL);
        System.out.println(price);
        System.out.println(id);

        DaoFactory.getAdsDao().updateListing(title, description, imgURL, price, id);

        response.sendRedirect("/product?id="+id);
    }
}