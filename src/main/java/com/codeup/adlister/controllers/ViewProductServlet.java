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

@WebServlet(name = "controllers.ViewProductServlet", urlPatterns = "/product")
public class ViewProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Ad ad = DaoFactory.getAdsDao().searchByAdId(Long.parseLong(id));
        User user = DaoFactory.getUsersDao().findByUserID(ad.getUserId());
        request.setAttribute("ad", ad);
        request.setAttribute("user", user);
//        request.setAttribute("categories", DaoFactory.getAdsDao().getCategoriesFromAdID(Long.parseLong(id)));
//        ArrayList<String> test = DaoFactory.getAdsDao().getCategoriesFromAdID(Long.parseLong(id));
//        for (String test3 : test){
//            System.out.println(test3);
//        }
        request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
    }
}