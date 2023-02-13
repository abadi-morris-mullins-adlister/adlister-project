package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> searchByTerm(String searchTerm) {
        try {
            String searchQuery = "SELECT * FROM ads where title LIKE ? OR description LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);

            String formattedSearchTerm = "%" + searchTerm + "%";
            stmt.setString(1, formattedSearchTerm);
            stmt.setString(2, formattedSearchTerm);

            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> searchByUserId(long userID) {
        try {
            String searchQuery = "SELECT * FROM ads where user_id = ?";
            PreparedStatement stmt = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);

            long formattedSearchTerm = userID;
            stmt.setLong(1, formattedSearchTerm);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public Ad searchByAdId(long adID) {
        try {
            String searchQuery = "SELECT * FROM ads where id = ?";
            PreparedStatement stmt = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);

            long formattedSearchTerm = adID;
            stmt.setLong(1, formattedSearchTerm);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            return new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("imgURL"),
                    rs.getDate("date_created"),
                    rs.getDouble("price")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, imgURL, date_created, price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getImgURL());
            stmt.setDate(5, new java.sql.Date(ad.getDate_created().getTime()));
            stmt.setDouble(6, ad.getPrice());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("imgURL"),
            rs.getDate("date_created"),
            rs.getDouble("price")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public Long updateListing(String title, String description, String imgURL, double price, Long id) {
        String query = "UPDATE ads SET title = ?, description = ?, imgURL = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,title);
            stmt.setString(2, description);
            stmt.setString(3,imgURL);
            stmt.setDouble(4,price);
            stmt.setLong(5, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the listing", e);
        }
        return null;
    }

    public Long deleteListing (Long id) {
        String query = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the listing", e);
        }
        return null;
    }
}
