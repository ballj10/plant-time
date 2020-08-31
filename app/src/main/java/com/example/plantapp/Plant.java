package com.example.plantapp;

import java.util.Date;

public class Plant {
    private String name;
    private String species;
    private String type;
    private Date date;
    private String imageUrl;

    public Plant (String name, String species, Date birthday, String type, String url) {
        this.name = name;
        this.date = birthday;
        this.species = species;
        this.type = type;
        this.imageUrl = url;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
