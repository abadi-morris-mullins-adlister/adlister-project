package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> searchByUserId(long userID);

    Ad searchByAdId(long adID);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> searchByTerm(String searchTerm);

    Long updateListing(String title, String description, String imgURL, double price, Long id);

    Long deleteListing(Long id);

    Long insertAdCategory(Long ad_id, Long category_id);

    Long deleteListingAdCategories(Long ad_id);
    ArrayList<String> getCategoriesFromAdID (long ad_id);

    ArrayList<Ad> getAdsFromCategory (Long category_id);

}
