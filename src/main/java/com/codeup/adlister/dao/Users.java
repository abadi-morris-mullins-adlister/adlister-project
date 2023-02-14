package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByUserID(long userID);
    Long insert(User user);
    Long updateUser(String username, String imgURL, String email, Long user);

    List<User> findAllUsers();
    Long deleteUser (Long id);
}
