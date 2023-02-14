package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Long idFromName(String searchName) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM category where name = ?");
            stmt.setString(1, searchName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getLong("category_id");
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public String nameFromId(long searchId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM category where category_id = ?");
            stmt.setLong(1, searchId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    //Gil
//    public Long insertCategoryAd (Long category_id) {
//        String query = "INSERT INTO ad_categories(category_id) VALUES (?)";
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, category_id);
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return null;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {

        System.out.println(DaoFactory.getCategoriesDao().idFromName("electronics"));
        System.out.println(DaoFactory.getCategoriesDao().nameFromId(1));

    }
}