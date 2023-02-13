package com.codeup.adlister.dao;

public interface Categories {

    Long idFromName(String searchName);

    String nameFromId(long searchId);

}