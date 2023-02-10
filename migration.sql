DROP DATABASE adlister_db;

CREATE DATABASE IF NOT EXISTS adlister_db;

USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       bigint UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240)    NOT NULL UNIQUE,
    email    VARCHAR(240)    NOT NULL UNIQUE,
    password VARCHAR(255)    NOT NULL,
    imgURL   VARCHAR(255)    NOT NULL,
    isAdmin  boolean         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id           bigint UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id      bigint UNSIGNED NOT NULL,
    title        VARCHAR(240)    NOT NULL,
    description  TEXT            NOT NULL,
    imgURL       VARCHAR(255)    NOT NULL,
    date_created DATETIME,
    price        double,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE category
(
    category_id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
    name        VARCHAR(240)    NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE ad_categories
(
    ad_id       bigint UNSIGNED NOT NULL,
    category_id bigint UNSIGNED NOT NULL,
    PRIMARY KEY (ad_id, category_id),
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);
