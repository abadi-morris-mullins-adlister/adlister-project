CREATE DATABASE IF NOT EXISTS adlister_db;

USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       long UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    imgURL   VARCHAR(255) NOT NULL,
    isAdmin  boolean      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          long UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     long UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    imgURL      VARCHAR(255) NOT NULL,
    date_created(DATETIME),
    price(double),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE category
(
    category_id          long UNSIGNED NOT NULL AUTO_INCREMENT,
    name       VARCHAR(240) NOT NULL,
);
