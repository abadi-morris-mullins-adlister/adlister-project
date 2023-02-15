package com.codeup.adlister.dao;

//Returns the Ads Data Access Object (DAO).
public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Categories categoryDao;
    private static Config config = new Config();

    //    Returns the Users Data Access Object (DAO).
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    //    Returns the Users Data Access Object (DAO).
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    //    Returns the Categories Data Access Object (DAO).
    public static Categories getCategoriesDao() {
        if (categoryDao == null) {
            categoryDao = new MySQLCategoriesDao(config);
        }
        return categoryDao;
    }

}