package com.codeup.adlister.dao;

public interface Categories {

    Long idFromName(String searchName);

    String nameFromId(long searchId);

//    Long insertCategoryAd(Long category_id);

}