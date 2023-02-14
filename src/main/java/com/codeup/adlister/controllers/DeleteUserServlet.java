package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers.DeleteUserServlet", urlPatterns = "/delete_user")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        List<Ad> ads = DaoFactory.getAdsDao().searchByUserId(Long.parseLong(request.getParameter("id")));
        for (Ad ad : ads){
            DaoFactory.getAdsDao().deleteListing(ad.getId());
        }
        DaoFactory.getUsersDao().deleteUser(Long.valueOf(request.getParameter("id")));
        response.sendRedirect("/profile");
    }

}