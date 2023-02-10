package com.codeup.adlister.models;

import java.util.Date;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;

    private String imgURL;

    private Date date_created;

    private double price;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description, String imgURL, double price) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
        this.date_created = new Date();
        this.price = price;
    }

    public Ad(long id, long userId, String title, String description, String imgURL, Date date_created, double price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imgURL = imgURL;
        this.date_created = date_created;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
