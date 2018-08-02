package com.journaldev.elasticsearch.bean;

import java.util.Arrays;
import java.util.List;

public class Hotel {


    private String photoUrl;

    private String regionName;

    private String title;

    private String country;
    private String distanceToAirport;
    private List facilities;

    /**
     * hotel rating.
     */
    private byte stars;

    private String food;
    private Beach beach;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List getFacilities() {
        return facilities;
    }

    public void setFacilities(List facilities) {
        this.facilities = facilities;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Beach getBeach() {
        return beach;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }

    public byte getStars() {
        return stars;
    }

    public void setStars(byte stars) {
        this.stars = stars;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String typeOfFood) {
        this.food = typeOfFood;
    }

    public String getDistanceToAirport() {
        return distanceToAirport;
    }

    public void setDistanceToAirport(String distanceToAirport) {
        this.distanceToAirport = distanceToAirport;
    }
}
