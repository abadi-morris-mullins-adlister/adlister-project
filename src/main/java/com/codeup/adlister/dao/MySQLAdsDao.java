package com.codeup.adlister.dao;

import java.util.ArrayList;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    //    A constructor that takes a Config object and connects to the database using the URL, user, and password provided in the Config object.
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

    //    Returns a list of all ads in the database.
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

    //    Returns a list of ads that contain the specified search term in their title or description.
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


    //    Returns a list of ads posted by the specified user.
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

    //    Returns the ad with the specified ID.
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

    //    Inserts a new ad into the database and returns its ID.
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
    //extracts the information from the ad such as title, description, etc.
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
    //Creates the ads based on results returned by the search query
    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    //    Updates the specified ad with the new values for title, description, imgURL, and price.
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

    //    Deletes the ad with the specified ID.
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
    //    Deletes all category assignments for the ad with the specified ID.
    public Long deleteListingAdCategories (Long ad_id) {
        String query = "DELETE FROM ad_categories WHERE ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad_id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the listing", e);
        }
        return null;
    }
    //    Assigns the category with the specified ID to the ad with the specified ID.
    public Long insertAdCategory (Long ad_id, Long category_id) {
        String query = "INSERT INTO ad_categories(ad_id, category_id) VALUES (?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad_id);
            stmt.setLong(2, category_id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting the ad category", e);        }
    }

    //Used for the associative table to retrieve the category from the Ad id.
    public ArrayList<String> getCategoriesFromAdID (long ad_id){
        String query = "SELECT * FROM ad_categories WHERE ad_id = ?";
        PreparedStatement stmt = null;
        try {
            System.out.println(ad_id);
            System.out.println(query);
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Long> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(rs.getLong("category_id"));
            }
            ArrayList<String> category_strings = new ArrayList<>();
            for (Long category_id : categories){
                category_strings.add(DaoFactory.getCategoriesDao().nameFromId(category_id));
            }
            return category_strings;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting ad id", e);
        }
    }

    //Used for the associative table to retrieve the ad id from the category.
    public ArrayList<Ad> getAdsFromCategory(Long category_id) {
        String query = "SELECT * FROM ad_categories WHERE category_id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, category_id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Long> ad_ids = new ArrayList<>();
            while (rs.next()) {
                ad_ids.add(rs.getLong("ad_id"));
            }
            ArrayList<Ad> ads = new ArrayList<>();
            for (Long ad_id : ad_ids) {
                ads.add(DaoFactory.getAdsDao().searchByAdId(ad_id));
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting ad id", e);
        }
    }

}