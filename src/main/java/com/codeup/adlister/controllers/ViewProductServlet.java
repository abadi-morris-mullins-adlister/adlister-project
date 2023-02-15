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
import java.util.ArrayList;
import java.util.List;

// View Product: All users can view an ad listing. The servlet will find the requested
// Ad object by ID and forward the data to the product.jsp to be displayed.
@WebServlet(name = "controllers.ViewProductServlet", urlPatterns = "/product")
public class ViewProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gets the requested ad ID
        String id = request.getParameter("id");
        // Ad object data:
        Ad ad = DaoFactory.getAdsDao().searchByAdId(Long.parseLong(id));
        request.setAttribute("ad", ad);
        // Ad seller data:
        User user = DaoFactory.getUsersDao().findByUserID(ad.getUserId());
        request.setAttribute("user", user);
        // Ad category data:
        List<String> categories = DaoFactory.getAdsDao().getCategoriesFromAdID(Long.parseLong(id));
        request.setAttribute("categories", categories);
        // Forwards data to product.jsp
        request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
    }
}